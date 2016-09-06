package com.heroku.demo;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("/")
public class HomeController {

    private AdoptionRepository repository;

    @Autowired
    public HomeController(AdoptionRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Adoption> records = repository.findAll();
        model.addAttribute("records", records);
        model.addAttribute("insertRecord", new Adoption());
        return "home";
    }
    
    //---------------------Retrieve List of Adoptions---------------------------------------------------
    @RequestMapping(value = "/records/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Adoption>> getAllRecords()
    {
        List<Adoption> record = repository.findAll();
        if(record.isEmpty())
        {
            return new ResponseEntity<List<Adoption>>(HttpStatus.NO_CONTENT);//OR HttpStatus.Not_Found
        }

        return new ResponseEntity<List<Adoption>>(record,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public String insertData(ModelMap model, 
                             @ModelAttribute("insertRecord") @Valid Adoption record,
                             BindingResult result) {
        if (!result.hasErrors()) {
            repository.save(record);
        }
        return home(model);
     }
 }
