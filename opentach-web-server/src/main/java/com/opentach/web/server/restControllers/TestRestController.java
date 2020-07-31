package com.opentach.web.server.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;
import com.opentach.web.server.interfaces.IBloqueosService;

@RestController
@RequestMapping("/bloqueo")
public class TestRestController extends ORestController<IBloqueosService> {
	 @Autowired private IBloqueosService bloqueosService;
	 @Override
	 public IBloqueosService getService() {
		 return this.bloqueosService;
	 }

}



