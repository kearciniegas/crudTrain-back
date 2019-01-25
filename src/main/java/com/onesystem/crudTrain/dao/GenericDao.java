package com.onesystem.crudTrain.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Clase generica de la cual extienden todos los DAOS para el acceso a la base de datos
 *
 * @author estebanmerchan
 */
public class GenericDao {

    protected SessionFactory sessionFactory;

    private Logger logger = Logger.getLogger(this.getClass());

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Metodo encargado de generar una sesión de hibernate para hacer transacciones
     *
     * @return Session
     * @author estebanmerchan
     */
    public Session getSession() throws Exception {
//        return obtenerSessionEsquema(obtenerEsquemaSession());
        return obtenerSessionEsquema();
    }

    /**
     * Metodo que retorna la sesion de acuerdo a un esquema especifico
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("resource")
    private Session obtenerSessionEsquema() throws Exception {
        Session session = null;
        try {
            String login = "sistema";
            String ip = "N/A";
            //ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            session = sessionFactory.withOptions().openSession();
//            session = sessionFactory.withOptions().interceptor(new B2zInterceptor(login, ip, this, this.genericDaoMongo)).openSession();
        } catch (Exception ex) {

        }
        return session;
    }

    /**
     * Inserta un objeto perteneciente a un registro en la base de datos, si
     * este elemento existe (se evalua clave primaria) ser&aacuten actualizados
     * sus atributos.
     *
     * @param ob Object mapeado por Hibernate que será almcenado o actualizado
     *           en base de datos
     * @throws Exception
     */
    public void saveOrUpdate(Object ob) throws Exception {
        Session session = getSession();
        Transaction tx = session.getTransaction();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            session.saveOrUpdate(ob);
            tx.commit();
        } catch (Exception ex) {
            try {
                tx.rollback();
            } catch (Exception ex2) {
                logger.error(new StringBuilder(ex2.getClass().getName()).append(": ").append(ex2.getMessage()).toString(), ex2);
                throw ex2;
            }
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void saveOrUpdateList(List<?> objetos) throws Exception {
        Session session = getSession();
        Transaction tx = session.getTransaction();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            for (Object objeto : objetos) {
                session.saveOrUpdate(objeto);
            }
            tx.commit();
        } catch (Exception ex) {
            try {
                tx.rollback();
            } catch (Exception ex2) {
                logger.error(new StringBuilder(ex2.getClass().getName()).append(": ").append(ex2.getMessage()).toString(), ex2);
                throw ex2;
            }
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Almacena un objeto en la base de datos.
     *
     * @param ob Object mapeado por hibernate correspondiente a una tabla
     * @throws Exception
     */
    public void save(Object ob) throws Exception {
        Session session = getSession();
        Transaction tx = session.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
        try {
            session.save(ob);
            tx.commit();
        } catch (Exception ex) {
            try {
                logger.error(new StringBuilder(ex.getClass().getName()).append(": ").append(ex.getMessage()).toString(), ex);
                tx.rollback();
            } catch (Exception ex2) {
                logger.error(new StringBuilder(ex2.getClass().getName()).append(": ").append(ex2.getMessage()).toString(), ex2);
                throw ex2;
            }
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Actualiza un objeto en base de datos.
     *
     * @param ob Object mapeado por hibernate correspondiente a una tabla
     * @throws Exception
     */
    public void update(Object ob) throws Exception {
        Session session = getSession();
        Transaction tx = session.getTransaction();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            session.merge(ob);
            tx.commit();
        } catch (Exception ex) {
            try {
                session.update(ob);
                tx.commit();
            } catch (Exception ex2) {
                logger.error(new StringBuilder(ex.getClass().getName()).append(": ").append(ex.getMessage()).toString(), ex);
                logger.error(new StringBuilder(ex2.getClass().getName()).append(": ").append(ex2.getMessage()).toString(), ex2);
                tx.rollback();
                throw ex2;
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Elimina un objeto o registro de base de datos.
     *
     * @param ob Object mapeado por hibernate correspondiente a una tabla
     * @throws Exception
     */
    public void delete(Object ob) throws Exception {
        Session session = getSession();
        Transaction tx = session.getTransaction();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            // Se limpia la sesion para evitar errores al eliminar registros en
            // las grillas
            session.clear();
            session.delete(ob);
            tx.commit();
        } catch (Exception ex) {
            try {
                tx.rollback();
            } catch (Exception ex2) {
                logger.error(new StringBuilder(ex2.getClass().getName()).append(": ").append(ex2.getMessage()).toString(), ex2);
                throw ex2;
            }
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Consulta los objetos o registro de la tabla relacionada al tipo de
     * clase suministrado como par&aacute;metro.
     *
     * @param clazz Class que corresponde al objeto mapeado
     * @return List estructura de datos con el resultado de la consulta
     * @throws Exception
     */
    public List<?> findAll(Class<?> clazz) throws Exception {
        /*
         * String hql = new
         * StringBuilder("from ").append(clazz.getName()).toString(); re*turn
         * find(hql);
         */
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        return findByCriteria(criteria);
    }

    /**
     * Ejecuta una consulta por criteria
     *
     * @param detachedCriteria
     * @return
     * @throws Exception
     */
    public List<?> findByCriteria(DetachedCriteria detachedCriteria) throws Exception {
        return findByCriteria(detachedCriteria, null);
    }

    /**
     * Obtiene el listado de elementos a partir de una sentencia criteria
     *
     * @param detachedCriteria
     * @param limite
     * @return
     * @throws Exception
     */
    public List<?> findByCriteria(DetachedCriteria detachedCriteria, Integer limite) throws Exception {
        List<?> res = null;
        Session session = getSession();
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        try {
            if (limite == null) {
                res = detachedCriteria.getExecutableCriteria(session).list();
            } else {
                res = detachedCriteria.getExecutableCriteria(session).setMaxResults(limite).list();
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return res;
    }

    /**
     * Ejecuta una consulta por criteria, retorna un objeto
     *
     * @param detachedCriteria
     * @return
     * @throws Exception
     */
    public Object findObjectByCriteria(DetachedCriteria detachedCriteria) throws Exception {
        Session session = getSession();
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        try {
            Object obj = detachedCriteria.getExecutableCriteria(session).uniqueResult();
            return obj;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Consulta un objeto o registro de base de datos dado un identificador.
     *
     * @param clazz Class que corresponde al objeto mapeado
     * @param id    Serializable identificador del objeto a buscar
     * @return Object objeto o registro encontrado
     * @throws Exception
     */

    public Object find(Class<?> clazz, Serializable id) throws Exception {
        logger.debug("GenericDao find(), Id: " + id);
        Session session = getSession();
        Transaction tx = session.getTransaction();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            Object obj = session.get(clazz, id);
            return obj;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
