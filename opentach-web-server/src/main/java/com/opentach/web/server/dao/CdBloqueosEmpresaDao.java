package com.opentach.web.server.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "CDBLOQUEOS_EMPRESADao")
@Lazy
@ConfigurationFile(configurationFile = "com/opentach/web/server/xmlDao/CDBLOQUEOS_EMPRESADao.xml", configurationFilePlaceholder = "placeholders.properties")
public class CdBloqueosEmpresaDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_IDTIPO_AMBITO = "IDTIPO_AMBITO";
    public static final String ATTR_NOMBRE_AMBITO = "NOMBRE_AMBITO";
 
    public CdBloqueosEmpresaDao() {
        super();
    }
}