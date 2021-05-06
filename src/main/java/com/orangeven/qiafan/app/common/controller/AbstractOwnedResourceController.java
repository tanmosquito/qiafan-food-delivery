package com.orangeven.qiafan.app.common.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangeven.qiafan.app.common.controller.exception.IllegalRequestParameterException;
import com.orangeven.qiafan.app.common.dao.AbstractOwnedEntityDao;
import com.orangeven.qiafan.app.common.model.AbstractOwnedEntityModel;
import com.orangeven.qiafan.app.common.service.AbstractOwnedResourceService;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;
import com.orangeven.qiafan.app.common.service.exception.ResourceSetSizeTooLargeException;

public abstract class AbstractOwnedResourceController<E extends AbstractOwnedEntityModel,T extends AbstractOwnedEntityDao<E>,
                                            S extends AbstractOwnedResourceService<E, T>>{
	public AbstractOwnedResourceController(S service) {
		this.service = service;
	}

    @GetMapping("/")
    public List<E> range(@RequestParam("from") long from,
    					@RequestParam("size") int size, HttpSession session)
            throws ResourceSetSizeTooLargeException, ResourceNotFoundException,
    				IllegalRequestParameterException{
    	if(from < 0 || size <= 0) {
    		throw new IllegalRequestParameterException(ILLEGAL_RANGE_REQUEST_PARAMTER_MSG);
    	} else {
    		return service.findRange((long)session.getAttribute(USER_ID_NAME_IN_SESSION), from, size);
    	}
    }

    @GetMapping("/{id}")
    public E show(@PathVariable("id")long id, HttpSession session)
            throws ResourceNotFoundException {
        return service.findById((long)session.getAttribute(USER_ID_NAME_IN_SESSION), id);
    }

    @PostMapping("/")
    public E create(@ModelAttribute E entity, HttpSession session)
            throws ResourceExistsException {
        service.create((long)session.getAttribute(USER_ID_NAME_IN_SESSION), entity);
        return entity;
    }

    @PostMapping("/{id}")
    public E update(@ModelAttribute E entity, HttpSession session)
            throws ResourceNotFoundException {
        service.update((long)session.getAttribute(USER_ID_NAME_IN_SESSION), entity);

        return entity;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<E> destroy(@PathVariable("id")long id, HttpSession session)
            throws ResourceNotFoundException {
        service.delete((long)session.getAttribute(USER_ID_NAME_IN_SESSION), id);

        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<E> destroyWithDeleteMethod(@PathVariable("id")long id, HttpSession session)
    		throws ResourceNotFoundException {
    	return destroy(id, session);
    }

    @ModelAttribute
    abstract protected E getInstance();
    protected S service;
    public final static String USER_ID_NAME_IN_SESSION = "userId";
    private final static String ILLEGAL_RANGE_REQUEST_PARAMTER_MSG = "资源范围参数不合法";
    
}