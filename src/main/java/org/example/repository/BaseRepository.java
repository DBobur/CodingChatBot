package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BaseRepository<T> {

    protected String path;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    ObjectMapper objectMapper = new ObjectMapper();
    public T add(T t){
        List<T> ts = readAll();
        ts.add(t);
        addAll(ts);
        return t;
    }
    public void addAll(List<T> ts){
        try {
            objectMapper.writeValue(new File(path),ts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<T> readAll(){
        try {
            return objectMapper.readValue(new File(path), new TypeReference<List<T>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
