package com.inventoryutilization.inv.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/packages")
public class PackagesController {
    @RequestMapping("/")
    public String packageHome(){
        return "packages/packagesHome";
    }
}
