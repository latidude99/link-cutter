package com.latidude99.links.controller;

import com.latidude99.links.dto.LinkDTO;
import com.latidude99.links.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;

@Controller
public class MapController {
    private static final String URL_PREFIX = "http://";
    private static final String ERROR_PAGE = "http://localhost:8080/error";
    private static final String ERROR_MESSAGE = "LINK NOT FOUND";

    @Autowired
    LinkDTO linkDTO;

    @Autowired
    LinkService linkService;

    @PostMapping("/shorten")
    public String shortened(@ModelAttribute LinkDTO linkDTO, Model model) {
        if(!linkDTO.getOriginal().equals("")){
            String shortLink = linkService.makeShortLink(linkDTO.getOriginal());
            linkDTO.setShortened(shortLink);
            linkDTO.setOriginal(null);
            model.addAttribute("linkDTO", linkDTO);
            return "shortened";
        }
        return "home";
    }
/*
    @GetMapping("/{shortened}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortened) {
        System.out.println("Controller: " + shortened);
        String original = linkService.getOriginalLink(shortened);
        if (original.equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .location(URI.create(ERROR_PAGE))
                    .build();
        } else {

            if(!original.contains(URL_PREFIX))
                original = URL_PREFIX + original;
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(original))
                    .build();
        }
    }
    */

    /*@GetMapping("/error")
    public String error(Model model){
        model.addAttribute("error", ERROR_MESSAGE);
        return ERROR_PAGE;
    }*/

}








