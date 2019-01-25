package com.onesystem.crudTrain.seg;

import com.onesystem.crudTrain.bd.TbTestUser;
import com.onesystem.crudTrain.ngc.UserNgc;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class Seguridad implements UserDetailsService {
    private Logger logger = Logger.getLogger (Seguridad.class);

    private UserNgc userNgc;

    public UserNgc getUserNgc() {
        return userNgc;
    }

    public void setUserNgc(UserNgc userNgc) {
        this.userNgc = userNgc;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userRetorno = null;
        TbTestUser usuario = null;
        try {
            usuario = userNgc.getUserByName (username);
        } catch (Exception e) {
            logger.error (e);
        }
        if (usuario != null) {
            userRetorno = new User (username, usuario.getVrUserCla (), usuario.getBlUserHab (), true, true, true, new ArrayList<> ());
        }
        return userRetorno;
    }
}
