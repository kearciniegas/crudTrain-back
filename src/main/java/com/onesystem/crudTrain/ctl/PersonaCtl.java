package com.onesystem.crudTrain.ctl;

import com.onesystem.crudTrain.bd.TbTestPerson;
import com.onesystem.crudTrain.ngc.PersonaNgc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personaCtl")
public class PersonaCtl {

    private PersonaNgc personaNgc;

    public PersonaNgc getPersonaNgc() {
        return personaNgc;
    }

    public void setPersonaNgc(PersonaNgc personaNgc) {
        this.personaNgc = personaNgc;
    }

    @RequestMapping(value = "getPersonas", method = RequestMethod.GET)
    public List<TbTestPerson> getPersonas() throws Exception {
        return personaNgc.getPersonas();
    }

    @RequestMapping(value = "guardarPersona", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void guardarPersona(@RequestBody TbTestPerson tbTestPerson) throws Exception {
        personaNgc.guardarPersona(tbTestPerson);
    }

    @RequestMapping(value = "actualizarPersona", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void actualizarPersona(@RequestBody TbTestPerson tbTestPerson) throws Exception {
        personaNgc.actualizarPersona(tbTestPerson);
    }

    @RequestMapping(value = "getPersonaById", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TbTestPerson getPersonaById(long idPersona) throws Exception {
        return personaNgc.getPersonaById(idPersona);
    }
    @RequestMapping(value = "eliminarPersona", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void eliminarPersona(long idPersona) throws Exception {
        personaNgc.eliminarPersona(idPersona);
    }
}
