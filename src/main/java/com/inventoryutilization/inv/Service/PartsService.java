package com.inventoryutilization.inv.Service;

import com.inventoryutilization.inv.Model.Part;
import com.inventoryutilization.inv.Repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class PartsService {
    @Autowired
    PartsRepository partsRepository;

    public Part findPartById(long id){
        Part exPart = partsRepository.findOne(id);
        if(exPart != null) {
            System.out.println(String.format("a part with id: %d was found",id));
        }
        else{
            System.out.println(String.format("a part with id: %d does not exist or cannot be found",id));
            throw new RuntimeException(String.format("a part with id: %d does not exist or cannot be found",id));
        }
        return exPart;
    }

    public Iterable<Part> findAllPartsByStatusAndArchived(Boolean status, Boolean archived){
        Iterable<Part> output = new HashSet<Part>();
        if(status == true){
            if(archived == true){
                //true true
                output = partsRepository.findAllByStatusTrueAndByArchivedTrue();
            }else if(archived == false){
                //true false
                output = partsRepository.findAllByStatusTrueAndByArchivedFalse();
            }
        }
        if(status == false){
            if(archived == true){
                //false true
                output = partsRepository.findAllByStatusFalseAndByArchivedTrue();
            }else if(archived == false){
                //false false
                output = partsRepository.findAllByStatusFalseAndByArchivedFalse();
            }
        }
        else{
            throw new RuntimeException("PartService/findAllPartsByStatusAndArchived: cannot find parts by status and archived");
        }
        return output;
    }

    public void processPart(Part aPart){
        Part exPart = partsRepository.findOne(aPart.getId());
        if(exPart == null){
            System.out.println(String.format("part %s does not exist yet (or no id was passed)",aPart.getPartName()));
            partsRepository.save(aPart);

        }
        else {
            exPart.setPartName(aPart.getPartName());
            exPart.setDescription(aPart.getDescription());
            //exPart.setStatus(aPart.getStatus());
            //exPart.setArchived(aPart.getArchived());
            //do not change part inventory or package info
        }
    }
}
