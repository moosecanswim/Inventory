package com.inventoryutilization.inv.Controller;

import com.inventoryutilization.inv.Model.Part;
import com.inventoryutilization.inv.Service.PartsInventoryService;
import com.inventoryutilization.inv.Service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    PartsService partsService;
    @Autowired
    PartsInventoryService partsInventoryService;

    @RequestMapping("/")
    public String partsHome(Model model){
        model.addAttribute("partsList", partsService.findAllPartsByStatusAndArchived(true,false));
        return "parts/partsHome";
    }
    @GetMapping("/part/{id}")
    public String partPage(@PathVariable("id")long id, Model model){
        //model.addAttribute("aPartInventory",partInventoryService.findByPartId(id));
        model.addAttribute("aPart",partsService.findPartById(id));
        return "parts/partPage";
    }
    //method to change qnty and price




    @GetMapping("/add")
    public String createPart(Model model){
        model.addAttribute("aPart", new Part());
        return "parts/addPart";
    }
    @GetMapping("/update/{id}")
    public String updatePart(@PathVariable("id")long id,Model model){
        model.addAttribute("aPart",partsService.findPartById(id));
        return "parts/updatePart";
    }
    @PostMapping("/processpart")
    public String processPart(@Valid Part aPart, BindingResult result){
        if(result.hasErrors()){
            return "parts/addPart";
        }
        partsInventoryService.addPartToInventory(aPart);
        partsService.processPart(aPart);
        return "parts/confirmPart";
    }
}
