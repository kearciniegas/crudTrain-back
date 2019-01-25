package com.onesystem.crudTrain.ngc;

import com.onesystem.crudTrain.bd.TbTestPerson;
import com.onesystem.crudTrain.dao.PersonaDao;


import java.util.Date;
import java.util.List;

public class PersonaNgcImpl implements PersonaNgc {

    private PersonaDao personaDao;

    public PersonaDao getPersonaDao() {
        return personaDao;
    }

    public void setPersonaDao(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    public List<TbTestPerson> getPersonas() throws Exception {
        return personaDao.getPersonas();
    }

    @Override
    public void guardarPersona(TbTestPerson tbTestPerson) throws Exception {
        tbTestPerson.setDtAdtFchupd(new Date());
        personaDao.guardarPersona(tbTestPerson);
    }

    @Override
    public void actualizarPersona(TbTestPerson tbTestPerson) throws Exception {
        tbTestPerson.setDtAdtFchupd(new Date());
        personaDao.actualizarPersona(tbTestPerson);
    }

    @Override
    public TbTestPerson getPersonaById(long idPersona) throws Exception {
        return personaDao.getPersonaById(idPersona);
    }

    @Override
    public void eliminarPersona(long idPersona) throws Exception {
        TbTestPerson persona = this.getPersonaById(idPersona);
        personaDao.eliminarPersona(persona);
    }
}
