package com.onesystem.crudTrain.bd;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_TEST_PERSON")
public class TbTestPerson {

    @Id
    @SequenceGenerator(name = "SC_TEST_PERSON_IDN", sequenceName = "SC_TEST_PERSON_IDN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_TEST_PERSON_IDN")
    @Column(name = "NB_PERSON_IDN", length = 10, scale = 0, nullable = false)
    private long nbPersonIdn;

    @Column(name = "VR_PERSON_NOMS", length = 128, nullable = false)
    private String vrPersonNoms;

    @Column(name = "VR_PERSON_GEN", length = 2, nullable = true)
    private String vrPersonGen;

    @Column(name = "DT_PERSON_NAC", nullable = true)
    private Date dtPersonNac;

    @Column(name = "VR_PERSON_TEL", length = 32, nullable = true)
    private String vrPersonTel;

    @Column(name = "DT_ADT_FCHUPD", nullable = false)
    private Date dtAdtFchupd;

    @Column(name = "VR_ADT_USRUPD", length = 64, nullable = false)
    private String vrAdtUsrupd;

    @Column(name = "BL_ADT_DELETE", nullable = false)
    private boolean blAdtDelete;

    public TbTestPerson() {
    }

    public TbTestPerson(long nbPersonIdn) {
        this.nbPersonIdn = nbPersonIdn;
    }

    public TbTestPerson(String vrPersonNoms, String vrPersonGen, Date dtPersonNac, String vrPersonTel, Date dtAdtFchupd, String vrAdtUsrupd, boolean blAdtDelete) {
        this.vrPersonNoms = vrPersonNoms;
        this.vrPersonGen = vrPersonGen;
        this.dtPersonNac = dtPersonNac;
        this.vrPersonTel = vrPersonTel;
        this.dtAdtFchupd = dtAdtFchupd;
        this.vrAdtUsrupd = vrAdtUsrupd;
        this.blAdtDelete = blAdtDelete;
    }

    public long getNbPersonIdn() {
        return nbPersonIdn;
    }

    public void setNbPersonIdn(long nbPersonIdn) {
        this.nbPersonIdn = nbPersonIdn;
    }

    public String getVrPersonNoms() {
        return vrPersonNoms;
    }

    public void setVrPersonNoms(String vrPersonNoms) {
        this.vrPersonNoms = vrPersonNoms;
    }

    public String getVrPersonGen() {
        return vrPersonGen;
    }

    public void setVrPersonGen(String vrPersonGen) {
        this.vrPersonGen = vrPersonGen;
    }

    public Date getDtPersonNac() {
        return dtPersonNac;
    }

    public void setDtPersonNac(Date dtPersonNac) {
        this.dtPersonNac = dtPersonNac;
    }

    public String getVrPersonTel() {
        return vrPersonTel;
    }

    public void setVrPersonTel(String vrPersonTel) {
        this.vrPersonTel = vrPersonTel;
    }

    public Date getDtAdtFchupd() {
        return dtAdtFchupd;
    }

    public void setDtAdtFchupd(Date dtAdtFchupd) {
        this.dtAdtFchupd = dtAdtFchupd;
    }

    public String getVrAdtUsrupd() {
        return vrAdtUsrupd;
    }

    public void setVrAdtUsrupd(String vrAdtUsrupd) {
        this.vrAdtUsrupd = vrAdtUsrupd;
    }

    public boolean isBlAdtDelete() {
        return blAdtDelete;
    }

    public void setBlAdtDelete(boolean blAdtDelete) {
        this.blAdtDelete = blAdtDelete;
    }
}
