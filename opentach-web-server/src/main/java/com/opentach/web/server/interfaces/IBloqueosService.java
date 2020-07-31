package com.opentach.web.server.interfaces;



import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IBloqueosService {

    // ---- BRANCHES ----
    public EntityResult bloqueoQuery(Map<String, Object> keysValues, List<String> attributes) throws OntimizeJEERuntimeException;
    public EntityResult bloqueoInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException;
    public EntityResult bloqueoUpdate(Map<String, Object> attributes, Map<String, Object> keyValues) throws OntimizeJEERuntimeException;
    public EntityResult bloqueoDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException;
}