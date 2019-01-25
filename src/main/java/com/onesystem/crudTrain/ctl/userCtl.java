package com.onesystem.crudTrain.ctl;

import com.onesystem.crudTrain.bd.TbTestUser;
import com.onesystem.crudTrain.dto.UsuarioDto;
import com.onesystem.crudTrain.ngc.UserNgc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarioCtl")
public class UserCtl {

    private UserNgc userNgc;

    public UserNgc getUserNgc() {
        return userNgc;
    }

    public void setUserNgc(UserNgc userNgc) {
        this.userNgc = userNgc;
    }

    @RequestMapping(value = "getUserById", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TbTestUser getUserById(long idUser) throws Exception {
        return userNgc.getUserById (idUser);
    }

    @RequestMapping(value = "guardarUsuario", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void guardarUsuario(@RequestBody UsuarioDto usuarioDto) throws Exception {
        userNgc.guardarUsuario (usuarioDto);
    }

}
