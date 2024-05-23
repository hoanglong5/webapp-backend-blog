package com.hoanglong.springbootblogwebapp.init.service;

import com.hoanglong.springbootblogwebapp.init.enums.GenErrorMessage;
import com.hoanglong.springbootblogwebapp.init.exception.exceptions.ItemNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseEntityService <E,D extends JpaRepository<E,String>> {
    private D dao;
    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;
    public D getDao() {
        return dao;
    }
    public List<E> findAll(){
        return dao.findAll();
    }
    public Optional<E> findById(String id){
        return dao.findById(id);
    }
    public E save(E entity){
        entity = dao.save(entity);
        return entity;
    }
    public void delete(E entity){
        dao.delete(entity);
    }
    public E getByIdWithControl(String id) {
        Optional<E> entityOptional = findById(id);
        E entity;
        if (entityOptional.isPresent()){
            entity = entityOptional.get();
        } else {
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
        }
        return entity;
    }
    public boolean existsById(String id){
        return dao.existsById(id);
    }
    protected Integer getSize(Optional<Integer> sizeOptional) {
        Integer size = DEFAULT_SIZE;
        if (sizeOptional.isPresent()){
            int providedSize = sizeOptional.get();
            if(providedSize >= 0){
                size = sizeOptional.get();
            }else {
                return size;
            }
        }
        return size;
    }

    protected Integer getPage(Optional<Integer> pageOptional) {
        Integer page = DEFAULT_PAGE;
        if (pageOptional.isPresent()){
            int providedPage = pageOptional.get();
            if(providedPage > 0){
                page = pageOptional.get();
            }else {
                return page;
            }
        }
        return page;
    }
    protected PageRequest getPageRequest(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {
        Integer page = getPage(pageOptional);
        Integer size = getSize(sizeOptional);
        PageRequest pageRequest = PageRequest.of(page, size);
        return pageRequest;
    }
}
