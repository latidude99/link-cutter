package com.latidude99.links.controller;

import com.latidude99.links.dto.LinkDTO;
import com.latidude99.links.dto.LinkDTOH2;
import com.latidude99.links.model.Link;
import com.latidude99.links.service.LinkService;
import com.latidude99.links.service.LinkServiceH2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
public class H2Controller {
    private static Logger log = LoggerFactory.getLogger(H2Controller.class);
    public static final String URL_BASE = "http://localhost:8080/";
    private static final String HTTP_PREFIX = "http";
    private static final String FTP_PREFIX = "ftp";
    private static final String ERROR_PAGE = "http://localhost:8080/error";
    private static final String ERROR_MESSAGE = "LINK NOT FOUND";
    private static final String INFO_PAGE = "http://localhost:8080/info/";

    @Autowired
    LinkDTOH2 linkDTOH2;

    @Autowired
    LinkDTOH2 linkDTOH2ToDelete;

    @Autowired
    LinkServiceH2 linkServiceH2;

    @PostMapping("/short")
    public String shortened(@ModelAttribute @Valid LinkDTOH2 linkDTOH2, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("linkDTOH2", linkDTOH2);
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "h2home";
        }
        if(!linkDTOH2.getOriginal().equals("")){
            linkDTOH2 = linkServiceH2.createAndSaveShortLink(linkDTOH2);
            model.addAttribute("linkDTOH2", linkDTOH2);
            return "h2shortened";
        }else{
            model.addAttribute("linkDTOH2", new LinkDTOH2());
            model.addAttribute("emptyURL", "Please enter vaild URL address!");
        }
        return "h2home";
    }
/*
    // another option to redirect
    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String id) {
        LinkDTOH2 link = linkServiceH2.getOriginalLink(id);
        String original = link.getOriginal();
        if (original.equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .location(URI.create(ERROR_PAGE))
                    .build();
        } else if(link.isDeleted() || link.isExpired()) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(INFO_PAGE + id.substring(id.lastIndexOf("/") + 1)))
                    .build();
        } else{
            if(!original.contains(URL_PREFIX))
                original = URL_PREFIX + original;
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(original))
                    .build();
        }
    }
*/

    @GetMapping("/{id}")
    public RedirectView redirectToOriginal(@PathVariable String id) {
        LinkDTOH2 link = linkServiceH2.getOriginalLink(id);
        String original = link.getOriginal();
        if (original.equals("")) {
            return new RedirectView(ERROR_PAGE);
        } else if(link.isDeleted() || link.isExpired()) {
            return new RedirectView(INFO_PAGE + id.substring(id.lastIndexOf("/") + 1));
        } else{
            if(!original.contains(HTTP_PREFIX) && !original.contains(FTP_PREFIX))
                original = HTTP_PREFIX + ":://" + original;
            return new RedirectView(original);
        }
    }

    @GetMapping("/info/{id}")
    public String showLinkInfo(@PathVariable String id, Model model) {
        LinkDTOH2 link = linkServiceH2.getOriginalLinkInfo(id);
        model.addAttribute("linkDTOH2ToDelete", linkDTOH2ToDelete);
        if (link.getOriginal() == null || id.equals("")) {
           model.addAttribute("empty", "LINK NOT FOUND");
        } else {
           model.addAttribute("linkDTOH2", link);
        }
        return "h2info";
    }

    @PostMapping("/info")
    public String showLinkInfo(@ModelAttribute LinkDTOH2 linkDTOH2, Model model) {
        if(linkDTOH2.getShortened().contains(URL_BASE)){
            String id = linkDTOH2.getShortened().substring(linkDTOH2.getShortened().lastIndexOf("/") + 1);
            LinkDTOH2 link = linkServiceH2.getOriginalLinkInfo(id);
            model.addAttribute("linkDTOH2ToDelete", linkDTOH2ToDelete);
            if (link.getOriginal() == null) {
                model.addAttribute("empty", "LINK NOT FOUND");
            } else {
                model.addAttribute("linkDTOH2", link);
            }
        } else{
            model.addAttribute("linkDTOH2ToDelete", linkDTOH2ToDelete);
            model.addAttribute("empty","LINK NOT RECOGNISED");
            model.addAttribute("unrecognised",
                    "All links created with this service should start with " + URL_BASE);
        }
        return "h2info";
    }

    @PostMapping("/delete")
    public String deleteLink(@ModelAttribute LinkDTOH2 linkDTOH2ToDelete, Model model) {
        model.addAttribute("linkDTOH2ToDelete", new LinkDTOH2());
        if(linkDTOH2ToDelete.getShortened().contains(URL_BASE)){
            String id = linkDTOH2ToDelete
                    .getShortened()
                    .substring(linkDTOH2ToDelete.getShortened().lastIndexOf("/") + 1);
            if (id == null || id.equals("")) {
                model.addAttribute("empty", "LINK NOT FOUND");
            } else {
                LinkDTOH2 linkDeleted = linkServiceH2.deleteLink(linkDTOH2ToDelete);
                model.addAttribute("linkDTOH2", linkDeleted);
            }
        } else{
            model.addAttribute("empty","LINK NOT RECOGNISED");
            model.addAttribute("unrecognised",
                    "All links created with this service should start with " + URL_BASE);
        }
        return "h2info";
    }

    @GetMapping("/clear")
    public String clearForm(Model model){
        model.addAttribute("linkDTOH2", new LinkDTOH2());
        return "home";
    }

    @GetMapping("/error")
    public String error(Model model){
        model.addAttribute("error", ERROR_MESSAGE);
        return ERROR_PAGE;
    }

}








