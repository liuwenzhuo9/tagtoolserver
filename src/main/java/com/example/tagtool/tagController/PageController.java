package com.example.tagtool.tagController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/allSentences")
    public String allSentences() {return "index";}

    @RequestMapping("/tagEntity")
    public String tagEntity() {
        return "index";
    }

    @RequestMapping("/tagResult")
    public String tagResult() {
        return "index";
    }
}
