package org.example.excaption;

public class DataNotFoundExcaption extends RuntimeException {
    public DataNotFoundExcaption(String dataNotFound) {
        super(dataNotFound);
    }
}
