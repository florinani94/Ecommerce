package com.evozon.service;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public void addProduct(Product product) {
        this.productDAO.addProduct(product);
    }

    public void deleteProduct(int productId) { this.productDAO.deleteProduct(productId);}


    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }


    public void addDefaultProducts() {
        productDAO.addDefaultProducts();
    }

    public boolean validateProduct(Product product) {
        if ((!product.getCode().equals("") && (!product.getName().equals("")))) {
            return true;
        }
        return false;
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
}

