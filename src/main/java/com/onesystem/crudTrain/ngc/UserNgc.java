package com.onesystem.crudTrain.ngc;

import com.onesystem.crudTrain.bd.TbTestPerson;
import com.onesystem.crudTrain.bd.TbTestUser;
import com.onesystem.crudTrain.dto.UsuarioDto;


public interface UserNgc {
    /**
     * Metodo de negocio que nos permite obtener la consulta de una persona
     *
     * @return
     * @author Kevin A
     * @since 04/01/2019
     */
    TbTestUser getUserById(long idUser) throws Exception;

    /**
     * Metodo de negocio que nos permite obtener la consulta de una persona
     *
     * @return
     * @author Kevin A
     * @since 04/01/2019
     */
    TbTestUser getUserByName(String usuario) throws Exception;

    /**
     * Metodo de negocio que nos permite obtener el listado de personas
     *
     * @return
     * @author Kevin A
     * @since 10/01/2019
     */
    void guardarUsuario(UsuarioDto usuarioDto) throws Exception;
}
