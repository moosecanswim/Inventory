package com.inventoryutilization.inv.Controller;

import com.inventoryutilization.inv.Model.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/parts")
public class PartsController {
    @RequestMapping("/")
    public String partsHome(){

        return "parts/partsHome";
    }
    @RequestMapping("/add")
    public String createPart(Model model){
        model.addAttribute("aPart", new Part());
        return "parts/addPart";
    }
    @PostMapping("/processpart")
    public String processPart(@Valid Part aPart, BindingResult result){
        if(result.hasErrors()){
            return "parts/addPart";
        }
        //send it through a processPart Method in the part service
        //this method will see if it is an update or an add and will do the relavent thing
        return "parts/confirmPart";
    }
}
