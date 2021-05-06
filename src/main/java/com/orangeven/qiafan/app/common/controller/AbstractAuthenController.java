package com.orangeven.qiafan.app.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.orangeven.qiafan.app.common.controller.exception.AlreadyLogedInException;
import com.orangeven.qiafan.app.common.controller.exception.NotLoggedInException;
import com.orangeven.qiafan.app.common.dao.AbstractLoginableEntityDao;
import com.orangeven.qiafan.app.common.model.AbstractLoginableEntityModel;
import com.orangeven.qiafan.app.common.service.AbstractLoginableResourceService;
import com.orangeven.qiafan.app.common.service.exception.AuthenFailedException;
import com.orangeven.qiafan.app.common.service.exception.ResourceExistsException;
import com.orangeven.qiafan.app.common.service.exception.ResourceNotFoundException;

abstract public class AbstractAuthenController<E extends AbstractLoginableEntityModel, D extends AbstractLoginableEntityDao<E>, S extends AbstractLoginableResourceService<E, D>> {
	
	public AbstractAuthenController(@Autowired S service) {
		this.service = service;
	}

    @PostMapping("/signin")
    public ResponseEntity<E> signIn(@ModelAttribute("entity") E entity,
    		HttpSession session, HttpServletRequest request)
    		throws ResourceNotFoundException, AlreadyLogedInException, AuthenFailedException {
    	if(session.getAttribute("id") != null) {
    		throw new AlreadyLogedInException();
    	} else {
    		entity.setLastSuccessfulLoginIp(request.getRemoteAddr());
    		long id = service.signIn(entity);
    		session.setAttribute(AbstractOwnedResourceController.USER_ID_NAME_IN_SESSION, id);
    		return ResponseEntity.ok().build();
    	}
    }

    @PostMapping("/signup")
    public ResponseEntity<E> signUp(@ModelAttribute("entity") E entity)
            throws ResourceExistsException {
        service.signUp(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<E> logOut(HttpSession session) throws NotLoggedInException {
    	if(session.getAttribute("id") == null) {
			throw new NotLoggedInException();
		} else {
			session.removeAttribute("id");
			return ResponseEntity.ok().build();
		}
    }
    
    @ModelAttribute("entity")
    abstract protected E getInstance();
	
	@Autowired
	protected S service;
}
