package com.company.NearestNeighbor;


public class NearestNeighborPersistenceError extends Exception {

    public NearestNeighborPersistenceError(String msg){
        super(msg);
    }

    public NearestNeighborPersistenceError(String msg, Throwable cause){
        super(msg, cause);
    }
}