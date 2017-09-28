package com.inventoryutilization.inv.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groups")
public class GroupsController {
    public String groupsHome(){

        return "groups/groupsHome";
    }
}
