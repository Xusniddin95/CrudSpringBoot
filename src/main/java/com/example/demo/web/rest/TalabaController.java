package com.example.demo.web.rest;


import com.example.demo.model.Talaba;
import com.example.demo.service.TalabaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TalabaController {

        @Autowired
        TalabaService talabaService;
//        2-usul
//    private final TalabaService talabaService;
//    public TalabaController(TalabaService talabaService) {
//        this.talabaService = talabaService;
//    }

    //    display list of students
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listTalaba", talabaService.getAllTalaba());
        return "index";
    }

//    CREATE NEW TALABA
    @GetMapping("/showNewTalabaForm")
    public String showNewTalabaForm(Model model){
        Talaba talaba = new Talaba();
        model.addAttribute("talaba", talaba);
        return "new_talaba";
    }

    @PostMapping("/saveTalaba")
    public String saveTalaba(@ModelAttribute("talaba") Talaba talaba){
//        save talaba to database
        talabaService.saveTalaba(talaba);
        return "redirect:/";
    }


//    UPDATE
    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable (value = "id") Long id, Model model){
//        get talaba from the service
        Talaba talaba = talabaService.getTalabaById(id);

//        set talaba as a model attribute to pre-popullate the form
        model.addAttribute("talaba", talaba);
        return "update_talaba";
    }

//    DELETE
    @GetMapping("/deleteTalaba/{id}")
    public String deleteTalaba(@PathVariable (value = "id") Long id ){
//        call delete talaba method
        this.talabaService.deleteTalabaById(id);
        return "redirect:/";
    }
}
