package com.evozon.service;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;


    @Autowired
    private ServletContext servletContext;

    public void addProduct(Product product) {
        this.productDAO.addProduct(product);
    }


    public void deleteProduct(int productId) { this.productDAO.deleteProduct(productId);}


    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void importFromFile(String filename) {
        productDAO.importFromFile(filename);
    }


    public Product getProductById(Integer id){
       return  productDAO.getProductById(id);
    }


    public void exportToCSV(String fileName) {

        List<Product> products = productDAO.getAllProducts();

        FileWriter writer = null;


            try {
                writer = new FileWriter(fileName + ".csv");
                for (Product product : products) {
                    writer.append(String.valueOf(product.getProductId()));
                    writer.append(",");
                    writer.append(product.getCode());
                    writer.append(",");
                    writer.append(product.getName());
                    writer.append(",");
                    writer.append(product.getDescription());
                    writer.append(",");
                    writer.append(String.valueOf(product.getPrice()));
                    writer.append(",");
                    writer.append(String.valueOf(product.getStockLevel()));
                    writer.append("\n");
                }

                writer.flush();
                writer.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
            finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


    }

    public List<Product> validateExport(String fileName) {

        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        List<Product> list = new ArrayList<Product>();

        try {

            br = new BufferedReader(new FileReader((fileName + ".csv")));
            while ((line = br.readLine()) != null) {

                String[] product = line.split(csvSplitBy);
                Product newProduct = new Product();
                newProduct.setProductId(Integer.valueOf(product[0]));
                newProduct.setCode(product[1]);
                newProduct.setName(product[2]);
                newProduct.setDescription(product[3]);
                newProduct.setPrice(Double.valueOf(product[4]));
                newProduct.setStockLevel(Integer.valueOf(product[5]));

                list.add(newProduct);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }


    public List<Product> getProductsForPage(int startPageIndex, int recordsPerPage){

        if(startPageIndex<=0){
            return null;
        }
        return productDAO.getProductsForPage(startPageIndex,recordsPerPage);
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public int getSize(){
        return productDAO.getAllProducts().size();
    }

    public List<Product> getSortedProducts(String option, Integer startPageIndex, Integer MAX_PRODUCTS_PER_PAGE){

            switch (option) {
                case "SORTPRICEUPDOWN":
                    return productDAO.getSortedProducts("FROM Product P ORDER BY P.price", startPageIndex, MAX_PRODUCTS_PER_PAGE);
                case "SORTPRICEDOWNUP":
                    return productDAO.getSortedProducts("FROM Product P ORDER BY P.price DESC", startPageIndex, MAX_PRODUCTS_PER_PAGE);
                case "SORTNAMEAZ":
                    return productDAO.getSortedProducts("FROM Product P ORDER BY P.name", startPageIndex, MAX_PRODUCTS_PER_PAGE);
                case "SORTNAMEZA":
                    return productDAO.getSortedProducts("FROM Product P ORDER BY P.name DESC", startPageIndex, MAX_PRODUCTS_PER_PAGE);
                default:
                    return productDAO.getAllProducts();
            }

    }

    /* save image to local */
    public void saveImage(String filename, MultipartFile image) {
        File file = new File(servletContext.getRealPath("/resources/productImages" + "/" + filename));

        try {
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /* validation for .jpg */
    public boolean validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            return false;
        }

        return true;
    }

    /* delete a image based on the id */
    public void deleteImage(int id) {
        File image = new File(servletContext.getRealPath(productDAO.getProductById(id).getImageURL()));

        image.delete();
    }

    /* execute the image save operation */
    public Product doImageSaveOperation(Product product,  MultipartFile image) {
        if((!image.isEmpty()) && (this.validateImage(image) == true)) {
            this.saveImage(product.getCode() + ".jpg", image);
            String imageURL = "/resources/productImages/" + product.getCode() + ".jpg";
            product.setImageURL(imageURL);
        } else {
            File file = new File(servletContext.getRealPath("/resources/productImages/default@product.jpg"));
            MultipartFile defaultImage = null;

            try {
                FileInputStream input = new FileInputStream(file);
                defaultImage = new MockMultipartFile(product.getCode() + ".jpg", file.getName(), "image/jpeg", IOUtils.toByteArray(input));
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.doImageSaveOperation(product, defaultImage);
        }

        return product;
    }
}

