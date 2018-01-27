package com.app.cats.controllers;

import com.app.cats.CatDAO;
import com.app.cats.domain.Cat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.app.cats.dto.CatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CatsController {

    @Autowired
    CatDAO dao;

    @RequestMapping("/list")
    public String catslist(Model model) {
        model.addAttribute("cats", dao.getCats());
        return "list";
    }

    @RequestMapping("/add")
    public String addCat(HttpServletRequest request, @ModelAttribute("catDto") @Valid CatDTO catDto, BindingResult result) {
        if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
            Cat cat = new Cat ();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
            try {
                cat.setDateOfBirth(sdf.parse(catDto.getDateOfBirth()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cat.setName(catDto.getName());
            cat.setCatOwnerName(catDto.getCatOwnerName());
            cat.setWeight(catDto.getWeight());
            dao.addCat(cat);
            return "redirect:/list";
        }
        return "add";
    }

    @RequestMapping("/cat-{id}")
    public String catDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cat", dao.getCatById(id));
        return "details";
    }

}
