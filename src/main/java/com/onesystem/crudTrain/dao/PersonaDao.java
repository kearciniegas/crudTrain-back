package com.onesystem.crudTrain.dao;

import com.onesystem.crudTrain.bd.TbTestPerson;
import org.apache.log4j.Logger;
import java.util.List;

public class PersonaDao extends GenericDao {

    private static final Logger logger = Logger.getLogger(PersonaDao.class);

    /**
     * Metodo Dao que nos permite obtener el listado de personas
     *
     * @return
     * @author Elmer Urrea
     * @author Kevin A
     * @since 13/12/2018
     */
    public List<TbTestPerson> getPersonas() throws Exception {
        return (List<TbTestPerson>) super.findAll(TbTestPerson.class);
    }

    /**
     * Permite almacenar una persona
     *
     * @param tbTestPerson objeto persona
     * @throws Exception
     * @author Kevin A
     * @since 16-12-2018
     */
    public void guardarPersona(TbTestPerson tbTestPerson) throws Exception {
        super.save(tbTestPerson);
    }
    /**
     * Permite actualizar una persona
     *
     * @param tbTestPerson objeto persona
     * @throws Exception
     * @author Kevin A
     * @since 27-12-2018
     */
    public void actualizarPersona(TbTestPerson tbTestPerson) throws Exception {
        super.update(tbTestPerson);
    }
    /**
     * Permite consultar una persona
     * @throws Exception
     * @author Elmer Urrea
     * @author Kevin A
     * @since 28-12-2018
     */
    public TbTestPerson getPersonaById(long idPersona) throws Exception {
        return (TbTestPerson) super.find(TbTestPerson.class, idPersona);
    }
    /**
     * Permite eliminar una persona
     * @throws Exception
     * @author Elmer Urrea
     * @author Kevin A
     * @since 28-12-2018
     */
    public void eliminarPersona(TbTestPerson persona) throws Exception {
         super.delete(persona);
    }
}
