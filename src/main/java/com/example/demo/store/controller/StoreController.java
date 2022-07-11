package com.example.demo.store.controller;

import com.example.demo.store.dto.StoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StoreV1")
public class StoreController {

    @PostMapping("Stores")
    public ResponseEntity<?>  create(StoreDTO storeDTO){

        //TODO
        return ResponseEntity.ok("");
    }
}
