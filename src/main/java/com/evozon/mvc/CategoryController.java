package com.evozon.mvc;

import com.evozon.domain.Category;
import com.evozon.domain.Product;
import com.evozon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/backoffice/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String showAddCategory(Model model){
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addCategory(Model model, @ModelAttribute("category") Category category, BindingResult result){

        try {
            categoryService.addCategory(category);
            model.addAttribute("result", true);
            if (result.hasErrors()) {
                model.addAttribute("result", false);
                model.addAttribute("category",category);
                return "createCategory";
            }
        }catch (Exception e){
            model.addAttribute("result", false);
        }

        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "viewCategories";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewCategories(Model model){
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "viewCategories";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCategory(@RequestParam("id") int id, Model model){
        categoryService.deleteCategory(id);
        model.addAttribute("allCategories", categoryService.getAllCategories());

        return "viewCategories";
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public String editCategory(Model model, @ModelAttribute("category") Category category){
//
//         categoryService.updateCategory(category);
//
//        model.addAttribute("allCategories", categoryService.getAllCategories());
//        return "viewCategories";
//    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public String goToCreateCategoryPage(@RequestParam("categoryId") int categoryId, Model model) {
//        Category category = categoryService.getCategoryById(categoryId);
//        //model.addAttribute("allCategories", categoryService.getAllCategories());
//        model.addAttribute("category", category);
//        return "editCategory";

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editTheCategory() {
        return "editCategory";
    }


}
