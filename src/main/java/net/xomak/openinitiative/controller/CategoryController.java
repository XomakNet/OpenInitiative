package net.xomak.openinitiative.controller;


import net.xomak.openinitiative.model.*;
import net.xomak.openinitiative.repository.*;
import net.xomak.openinitiative.service.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    InitiativeService service;


    @RequestMapping("/")
    public String categoryList(Model model, HttpServletResponse response) {
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setDateHeader("Expires", 0);
        model.addAttribute("categories", service.getAllCategories());
        return "category/list";
    }

    @RequestMapping("/{id}/delete")
    public String categoryDelete(@PathVariable("id") long id, Model model) {
        service.deleteCategoryById(id);
        return "redirect:/category/";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String categoryEdit(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", service.getCategoryById(id));
        return "category/form";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String categoryCreate(Model model) {
        model.addAttribute("category", new InitiativeCategory(""));
        return "category/form";
    }

    @RequestMapping(value = {"/{id}/edit", "/new"}, method = RequestMethod.POST)
    public String categorySave(@ModelAttribute("category") InitiativeCategory category, BindingResult br, Model model) {
        service.saveCategory(category);
        return "redirect:/category/";
    }
}