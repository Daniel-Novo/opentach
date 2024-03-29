package com.ontimize.jee.server.dao.common.attributedispatcher;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.ontimize.db.EntityResult;
import com.ontimize.db.TableEntity;
import com.ontimize.jee.common.services.ServiceTools;
import com.ontimize.jee.common.tools.ReflectionTools;
import com.ontimize.jee.server.spring.SpringTools;
import com.opentach.server.AbstractOpentachServerLocator;

// NOTE: Temporary copied from OJEEntimize, because queryOtherEntities does not consider older entities.
/**
 * The Class AbstractAttributeDispatcher.
 *
 * @param <T>
 *            the generic type
 */
public abstract class AbstractAttributeDispatcher<T> implements IAttributeDispatcher<T> {

	/** The CONSTANT logger */
	private static final Logger logger = LoggerFactory.getLogger(AbstractAttributeDispatcher.class);

	/**
	 * Invoca la consulta al servicio correspondiente que indica el nombre de la entidad.
	 *
	 * @param applicationContext
	 *            the application context
	 * @param entityName
	 *            the entity name
	 * @param filter
	 *            the filter
	 * @param attributes
	 *            the attributes
	 * @return the entity result
	 */
	protected EntityResult invokeQuery(ApplicationContext applicationContext, String entityName, Map<?, ?> filter, List<?> attributes) {
		return this.invoke(applicationContext, entityName, IAttributeDispatcher.QUERY_SUFFIX, filter, attributes);
	}

	/**
	 * Invoke insert.
	 *
	 * @param applicationContext
	 *            the application context
	 * @param entityName
	 *            the entity name
	 * @param filter
	 *            the filter
	 * @return the entity result
	 */
	protected EntityResult invokeInsert(ApplicationContext applicationContext, String entityName, Map<?, ?> filter) {
		return this.invoke(applicationContext, entityName, IAttributeDispatcher.INSERT_SUFFIX, filter);
	}

	/**
	 * Invoke update.
	 *
	 * @param applicationContext
	 *            the application context
	 * @param entityName
	 *            the entity name
	 * @param attr
	 *            the attr
	 * @param keys
	 *            the keys
	 * @return the entity result
	 */
	protected EntityResult invokeUpdate(ApplicationContext applicationContext, String entityName, Map<?, ?> attr, Map<?, ?> keys) {
		return this.invoke(applicationContext, entityName, IAttributeDispatcher.UPDATE_SUFFIX, attr, keys);
	}

	/**
	 * Invoke update.
	 *
	 * @param applicationContext
	 *            the application context
	 * @param entityName
	 *            the entity name
	 * @param keys
	 *            the keys
	 * @return the entity result
	 */
	protected EntityResult invokeDelete(ApplicationContext applicationContext, String entityName, Map<?, ?> keys) {
		return this.invoke(applicationContext, entityName, IAttributeDispatcher.DELETE_SUFFIX, keys);
	}

	/**
	 * Invoke.
	 *
	 * @param applicationContext
	 *            the application context
	 * @param entityName
	 *            the entity name
	 * @param methodSufix
	 *            the method sufix
	 * @param parameters
	 *            the parameters
	 * @return the entity result
	 */
	protected EntityResult invoke(ApplicationContext applicationContext, String entityName, String methodSufix, Object... parameters) {
		try {
			// Note: only fix QUERY to support QueryOtherEntities
			if (IAttributeDispatcher.QUERY_SUFFIX.equals(methodSufix) && !entityName.contains(".")) {
				AbstractOpentachServerLocator locator = AbstractOpentachServerLocator.getLocator();
				TableEntity entity = (TableEntity) AbstractOpentachServerLocator.getLocator().getEntityReferenceFromServer(entityName);
				int sessionId = TableEntity.getEntityPrivilegedId(entity);// TODO how to get sessionId from userLogin?
				Connection conn = null;// TODO transactional current connection, and
				Hashtable keysValues = new Hashtable((Map) parameters[0]);
				Vector attributes = new Vector((List) parameters[1]);
				if (conn != null) {
					return entity.query(keysValues, attributes, sessionId, conn);
				} else {
					return entity.query(keysValues, attributes, sessionId);
				}
			}
		} catch (Exception err) {
			AbstractAttributeDispatcher.logger.trace("E_ITS_NOT_AN_ENTITY__" + entityName, err);
		}
		String methodName = ServiceTools.extractServiceMethodPrefixFromEntityName(entityName) + StringUtils.capitalize(methodSufix);
		String serviceName = ServiceTools.extractServiceFromEntityName(entityName);
		String queryId = ServiceTools.extractQueryIdFromEntityName(entityName);
		Object service = applicationContext.getBean(serviceName);
		service = SpringTools.getTargetObject(service, Object.class);
		if (IAttributeDispatcher.QUERY_SUFFIX.equals(methodSufix) && (queryId != null) && !queryId.isEmpty()) {
			Object[] params = Arrays.copyOf(parameters, parameters.length + 1);
			params[parameters.length] = queryId;
			return (EntityResult) ReflectionTools.invoke(service, methodName, params);
		} else {
			return (EntityResult) ReflectionTools.invoke(service, methodName, parameters);
		}
	}
}
