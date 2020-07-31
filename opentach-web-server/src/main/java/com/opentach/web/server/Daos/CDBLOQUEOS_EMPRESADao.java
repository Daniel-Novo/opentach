package com.opentach.web.server.Daos;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;


@Repository(value = "CDBLOQUEOS_EMPRESADao")
@Lazy
@ConfigurationFile(configurationFile = "com/opentach/web/server/xmlDao/CDBLOQUEOS_EMPRESADao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class CDBLOQUEOS_EMPRESADao  {

    public static final String ATTR_IDTIPO_AMBITO = "IDTIPO_AMBITO";
    public static final String ATTR_NOMBRE_AMBITO = "NOMBRE_AMBITO";
 
    public CDBLOQUEOS_EMPRESADao() {
        super();
    }
}