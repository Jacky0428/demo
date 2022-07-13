package com.example.demo.store.service.impl;

import com.example.demo.store.command.StoreCreateCommand;
import com.example.demo.store.command.StoreUpdateCommand;
import com.example.demo.store.exception.DataNotExistException;
import com.example.demo.store.jpa.Store;
import com.example.demo.store.repository.StoreRepository;
import com.example.demo.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Transactional
    @Override
    public void create(StoreCreateCommand storeCreateCommand) {
        Store store = new Store();
        store.setAddress(storeCreateCommand.getAddress());
        store.setDescription(storeCreateCommand.getDescription());
        store.setName(storeCreateCommand.getName());
        store.setPhone1(storeCreateCommand.getPhone1());
        store.setPhone2(storeCreateCommand.getPhone2());
        store.setWebsiteUrl(storeCreateCommand.getWebsiteUrl());
        storeRepository.save(store);
    }

    @Transactional
    @Override
    public void update(StoreUpdateCommand storeUpdateCommand) {
        Store store = storeRepository.findById(storeUpdateCommand.getId())
                .orElseThrow(() -> new DataNotExistException("Updating Store", Store.class, storeUpdateCommand.getId().toString()));
        store.setAddress(storeUpdateCommand.getAddress());
        store.setDescription(storeUpdateCommand.getDescription());
        store.setName(storeUpdateCommand.getName());
        store.setPhone1(storeUpdateCommand.getPhone1());
        store.setPhone2(storeUpdateCommand.getPhone2());
        store.setWebsiteUrl(storeUpdateCommand.getWebsiteUrl());

        storeRepository.save(store);
    }
}
