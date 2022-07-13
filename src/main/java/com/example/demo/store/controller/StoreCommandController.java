package com.example.demo.store.controller;

import com.example.demo.store.command.StoreCreateCommand;
import com.example.demo.store.command.StoreUpdateCommand;
import com.example.demo.store.dto.StoreDTO;
import com.example.demo.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class StoreCommandController {

    @Autowired
    StoreService storeService;

    @GetMapping("stores")
    public ResponseEntity find(){
        return ResponseEntity.ok("success");
    }

    @PostMapping("Stores")
    public ResponseEntity  create(@RequestBody StoreDTO storeDTO){

        StoreCreateCommand storeCreateCommand = new StoreCreateCommand();
        storeCreateCommand.setName(storeDTO.getName());
        storeCreateCommand.setDescription(storeDTO.getDescription());
        storeCreateCommand.setAddress(storeDTO.getAddress());
        storeCreateCommand.setPhone1(storeDTO.getPhone1());
        storeCreateCommand.setPhone2(storeDTO.getPhone2());
        storeCreateCommand.setWebsiteUrl(storeDTO.getWebsiteUrl());

        storeService.create(storeCreateCommand);
        return ResponseEntity.ok().build();
    }

    @PutMapping("Stores")
    public ResponseEntity update(@RequestBody StoreDTO storeDTO){
        StoreUpdateCommand storeUpdateCommand = new StoreUpdateCommand();
        storeUpdateCommand.setId(storeDTO.getId());
        storeUpdateCommand.setName(storeDTO.getName());
        storeUpdateCommand.setDescription(storeDTO.getDescription());
        storeUpdateCommand.setAddress(storeDTO.getAddress());
        storeUpdateCommand.setPhone1(storeDTO.getPhone1());
        storeUpdateCommand.setPhone2(storeDTO.getPhone2());
        storeUpdateCommand.setWebsiteUrl(storeDTO.getWebsiteUrl());

        storeService.update(storeUpdateCommand);
        return ResponseEntity.ok().build();
    }
}
