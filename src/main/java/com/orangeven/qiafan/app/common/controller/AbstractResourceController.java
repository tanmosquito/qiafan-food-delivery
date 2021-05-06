package com.orangeven.qiafan.app.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangeven.qiafan.app.common.controller.exception.IllegalRequestParameterException;
import com.orangeven.qiafan.app.common.dao.AbstractEntityDao;
import com.orangeven.qiafan.app.common.model.AbstractEntityModel;
import com.orangeven.qiafan.app.common.service.AbstractResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

public abstract class AbstractResourceController<E extends AbstractEntityModel,T extends AbstractEntityDao<E>, S extends AbstractResourceService<E, T>> {
	public AbstractResourceController(S service) {
		this.service = service;
	}

    @GetMapping("/")
    public List<E> range(@RequestParam("from") long from,
    					@RequestParam("size") int size)
            throws ResourceSetSizeTooLargeException, ResourceNotFoundException,
    				IllegalRequestParameterException{
    	if(from < 0 || size <= 0) {
    		throw new IllegalRequestParameterException(ILLEGAL_RANGE_REQUEST_PARAMTER_MSG);
    	} else {
    		return service.findRange(from, size);
    	}
    }

    @GetMapping("/{id}")
    public E show(@PathVariable("id")long id)
            throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/")
    public E create(@ModelAttribute E entity, HttpServletRequest request)
            throws ResourceExistsException {
        service.create(entity);
        return entity;
    }

    @PostMapping("/{id}")
    public E update(@ModelAttribute E entity)
            throws ResourceNotFoundException {
        service.update(entity);

        return entity;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<E> destroy(@PathVariable("id")long id)
            throws ResourceNotFoundException {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<E> destroyWithDeleteMethod(@PathVariable("id")long id)
    		throws ResourceNotFoundException {
    	return destroy(id);
    }

    @ModelAttribute
    protected abstract E getInstance();
    protected S service;
    private final static String ILLEGAL_RANGE_REQUEST_PARAMTER_MSG = "资源范围参数不合法";
}
