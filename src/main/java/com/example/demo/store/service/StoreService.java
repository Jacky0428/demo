package com.example.demo.store.service;

import com.example.demo.store.command.StoreCreateCommand;
import com.example.demo.store.command.StoreUpdateCommand;

public interface StoreService {

    void create(StoreCreateCommand storeCreateCommand);

    void update(StoreUpdateCommand storeUpdateCommand);
}
