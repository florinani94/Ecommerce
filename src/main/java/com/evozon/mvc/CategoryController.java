package com.evozon.mvc;

import com.evozon.domain.Category;
import com.evozon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mihai on 7/12/2016.
 */
@Controller
@RequestMapping(value = "Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/addCategory", method = RequestMethod.GET)
    public String showAddCategory(Model model){
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @RequestMapping(value="/addCategory", method = RequestMethod.POST)
    public String addCategory(Model model, @ModelAttribute("category") Category category, BindingResult result){

        try {
            categoryService.addCategory(category);
            model.addAttribute("message", true);
            if (result.hasErrors()) {
                model.addAttribute("message", false);
                return "createCategory";
            }
        }catch (Exception e){
            model.addAttribute("message", false);
        }
        return "viewCategories";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewCategories(Model model){
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "viewCategories";
    }

//    @RequestMapping(value="/viewCategory",method = RequestMethod.GET)
//    public String goToViewCategory(){
//        categoryService.deleteCategory(categoryId);
//
//        return "viewCategories";
//    }


}
