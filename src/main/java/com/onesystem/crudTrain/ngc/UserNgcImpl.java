package com.onesystem.crudTrain.ngc;

import com.onesystem.crudTrain.bd.TbTestPerson;
import com.onesystem.crudTrain.bd.TbTestUser;
import com.onesystem.crudTrain.dao.UserDao;
import com.onesystem.crudTrain.dto.UsuarioDto;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

public class UserNgcImpl implements UserNgc {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public TbTestUser getUserById(long idUser) throws Exception {
        return userDao.getUserById ( idUser );
    }

    @Override
    public TbTestUser getUserByName(String usuario) throws Exception {
        return userDao.getUserByName ( usuario );
    }

    @Override
    public void guardarUsuario(UsuarioDto usuarioDto) throws Exception {
        TbTestUser usuario = new TbTestUser ();
        TbTestPerson person;
        person = new TbTestPerson ( usuarioDto.getIdPersona () );
        usuario.setTbTestPerson ( person );
        usuario.setVrUserNom ( usuarioDto.getNombre () );
        usuario.setDtAdtFchupd ( new Date () );
        String hash = DigestUtils.sha1Hex ( usuarioDto.getClave () );
        usuario.setBlUserHab ( true );
        usuario.setVrUserCla ( hash );
        usuario.setVrUserCor ( usuarioDto.getCorreo () );
        userDao.guardarUsuario ( usuario );
    }
}
