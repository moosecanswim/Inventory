package com.inventoryutilization.inv.Service;

import com.inventoryutilization.inv.Model.Part;
import com.inventoryutilization.inv.Model.PartInventory;
import com.inventoryutilization.inv.Repository.PartsInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartsInventoryService {
    @Autowired
    PartsInventoryRepository partInvRepo;
    @Autowired
    PartsService partsService;

    //**********Create/update********
    public void addPartToInventory(Part aPart){
        PartInventory ePI = findByPart(aPart);
        if(ePI == null){
            ePI.setaPart(aPart);
            ePI.setPrice(0.0);
            ePI.setQuantity(0);
            partInvRepo.save(ePI);
        }
        else{
            System.out.println(String.format("part %s (%d) already exists in inventory",aPart.getPartName(),aPart.getId()));
            throw new RuntimeException(String.format("part %s (%d) already exists in inventory",aPart.getPartName(),aPart.getId()));
        }
    }


//    **********FIND*********
    public PartInventory findByPart(Part aPart){
        PartInventory output =null;
        try{
            Part exPart = partsService.findPartById(aPart.getId());
        }
        catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        PartInventory exPartInv = partInvRepo.findByAPart(aPart);
        if(exPartInv != null){
            System.out.println(String.format("There is no partInventory data for %s(%d)",aPart.getPartName(),aPart.getId()));
            throw new RuntimeException(String.format("There is no partInventory data for %s(%d)",aPart.getPartName(),aPart.getId()));
        }else{
            output =  partInvRepo.findByAPart(aPart);
        }
        return output;
    }
    public PartInventory findByPartId(long id){
        PartInventory output =null;
        Part exPart= null;
        try{
            exPart = partsService.findPartById(id);
        }
        catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        PartInventory exPartInv = partInvRepo.findByAPart(exPart);
        if(exPartInv != null){
            System.out.println(String.format("There is no partInventory data for %s(%d)",exPart.getPartName(),exPart.getId()));
            throw new RuntimeException(String.format("There is no partInventory data for %s(%d)",exPart.getPartName(),exPart.getId()));
        }else{
            output =  partInvRepo.findByAPart(exPart);
        }
        return output;
    }
}
