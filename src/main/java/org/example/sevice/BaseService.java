package org.example.sevice;

import org.example.excaption.DataNotFoundExcaption;
import org.example.model.BaseModel;
import org.example.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<T extends BaseModel,R extends BaseRepository<T>> {

    protected R repository;
    public BaseService(R repository) {
        this.repository = repository;
    }
    public T add(T t){
        return repository.add(t);
    }
    public void update(UUID id,T t){
        List<T> all = getAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId().equals(id)){
                all.set(i,t);
                repository.addAll(all);
                return;
            }
        }
        throw new DataNotFoundExcaption("Data not found");
    }
    protected List<T> getAll(){
        return repository.readAll();
    }
}
