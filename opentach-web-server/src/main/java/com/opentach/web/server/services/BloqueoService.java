package com.opentach.web.server.services;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opentach.web.server.dao.CdBloqueosEmpresaDao;
import com.opentach.web.server.interfaces.IBloqueosService;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.jee.server.dao.IOntimizeDaoSupport;

@Service("BloqueoService")
public class BloqueoService implements IBloqueosService{

    private static final Logger logger = LoggerFactory.getLogger(BloqueoService.class);
    @Autowired private CdBloqueosEmpresaDao bloqueoDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;
 
   

	@Override
	public EntityResult bloqueoQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return this.daoHelper.query( this.bloqueoDao, keysValues, attributes);
	}

	@Override
	public EntityResult bloqueoInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		 return this.daoHelper.insert( this.bloqueoDao, attributes);
	}

	@Override
	public EntityResult bloqueoUpdate(Map<String, Object> attributes, Map<String, Object> keyValues)
			throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		 return this.daoHelper.update( this.bloqueoDao, attributes, keyValues);
	}

	@Override
	public EntityResult bloqueoDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return this.daoHelper.delete( this.bloqueoDao, keyValues);
	}
}
