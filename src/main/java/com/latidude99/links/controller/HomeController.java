package com.latidude99.links.controller;

import com.latidude99.links.dto.LinkDTOH2;
import com.latidude99.links.service.LinkService;
import com.latidude99.links.dto.LinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
public class HomeController {

    @Autowired
    LinkDTO linkDTO;

    @Autowired
    LinkDTOH2 linkDTOH2;

    @GetMapping("/simple")
    public String home(Model model) {
        model.addAttribute("linkDTO", linkDTO);
        return "home";
    }

    @GetMapping("/")
    public String homeH2(Model model) {
        model.addAttribute("linkDTOH2", linkDTOH2);
        return "h2home";
    }

}








