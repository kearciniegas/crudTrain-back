package com.onesystem.crudTrain.ngc;

import com.onesystem.crudTrain.bd.TbTestPerson;

import java.util.List;

public interface PersonaNgc {

    /**
     * Metodo de negocio que nos permite obtener el listado de personas
     *
     * @return
     * @author Elmer Urrea
     * @author Kevin A
     * @since 13/12/2018
     */
    List<TbTestPerson> getPersonas() throws Exception;
    /**
     * Metodo de negocio que nos permite obtener el listado de personas
     *
     * @return
     * @author Elmer Urrea
     * @author Kevin A
     * @since 22/12/2018
     */
    void guardarPersona(TbTestPerson tbTestPerson) throws Exception;
    /**
     * Metodo de negocio que nos permite actualizar a una personas
     *
     * @return
     * @author Elmer Urrea
     * @author Kevin A
     * @since 22/12/2018
     */
    void actualizarPersona(TbTestPerson tbTestPerson) throws Exception;
    /**
     * Metodo de negocio que nos permite obtener la consulta de una persona
     *
     * @return
     * @author Elmer Urrea
     * @author Kevin A
     * @since 28/12/2018
     */
    TbTestPerson getPersonaById(long idPersona) throws Exception;
    /**
     * Metodo de negocio que nos permite eliminar una persona
     *
     * @return
     * @author Elmer Urrea
     * @author Kevin A
     * @since 2/01/2019
     */
    void eliminarPersona(long idPersona) throws Exception;
}
