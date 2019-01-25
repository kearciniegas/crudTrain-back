package com.onesystem.crudTrain.dao;

import com.onesystem.crudTrain.bd.TbTestPerson;
import com.onesystem.crudTrain.bd.TbTestUser;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class UserDao  extends  GenericDao{
    private static final Logger logger = Logger.getLogger(UserDao.class);

    /**
     * Permite consultar una persona
     *
     * @throws Exception
     * @author Kevin A
     * @since 04-01-2018
     */
    public TbTestUser getUserById(long idUser) throws Exception {
        return (TbTestUser) super.find(TbTestUser.class, idUser);
    }

    public TbTestUser getUserByName(String nombre) throws Exception {
        DetachedCriteria criteria = DetachedCriteria.forClass(TbTestUser.class);
        criteria.add(Restrictions.eq("vrUserNom", nombre));
        return (TbTestUser) super.findObjectByCriteria(criteria);
    }
    public void guardarUsuario(TbTestUser tbTestUser) throws Exception {
        super.save(tbTestUser);
    }

}
