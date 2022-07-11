package com.example.demo.store.dto;

public abstract class DTOObject {

    /**
     * The data status.
     *
     * The data needs to be create, update or delete.
     */
    protected DataStatusType dataStatusType;

    public DataStatusType getDataStatusType() {
        return dataStatusType;
    }

    public void setDataStatusType(DataStatusType dataStatusType) {
        this.dataStatusType = dataStatusType;
    }
}
