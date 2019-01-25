package com.onesystem.crudTrain.bd;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TB_TEST_USER")
public class TbTestUser {
    @Id
    @SequenceGenerator(name = "SC_TEST_USER_IDN", sequenceName = "SC_TEST_USER_IDN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_TEST_USER_IDN")
    @Column(name = "NB_USER_IDN", length = 38, scale = 0, nullable = false)
    private long nbUserIdn;

    @Column(name = "VR_USER_NOM", length = 128, nullable = false)
    private String vrUserNom;

    @Column(name = "DT_ADT_FCHUPD", nullable = false)
    private Date dtAdtFchupd;

    @Column(name = "VR_USER_CLA", length = 64, nullable = false)
    private String vrUserCla;

    @Column(name = "BL_USER_HAB", length = 1, nullable = true)
    private boolean blUserHab;

    @Column(name = "VR_USER_COR", length = 64, nullable = false)
    private String vrUserCor;

    @OneToOne
    @JoinColumn(name = "NB_PERSON_IDN", nullable = false)
    private TbTestPerson tbTestPerson;

    public TbTestUser() {
    }

    public TbTestUser(long nbUserIdn) {
        this.nbUserIdn = nbUserIdn;
    }

    public TbTestUser(String vrUserNom, Date dtAdtFchupd, String vrUserCla, boolean blUserHab, String vrUserCor) {
        this.vrUserNom = vrUserNom;
        this.dtAdtFchupd = dtAdtFchupd;
        this.vrUserCla = vrUserCla;
        this.blUserHab = blUserHab;
        this.vrUserCor = vrUserCor;
    }

    public long getNbUserIdn() {
        return nbUserIdn;
    }

    public void setNbUserIdn(long nbUserIdn) {
        this.nbUserIdn = nbUserIdn;
    }

    public String getVrUserNom() {
        return vrUserNom;
    }

    public void setVrUserNom(String vrUserNom) {
        this.vrUserNom = vrUserNom;
    }

    public Date getDtAdtFchupd() {
        return dtAdtFchupd;
    }

    public void setDtAdtFchupd(Date dtAdtFchupd) {
        this.dtAdtFchupd = dtAdtFchupd;
    }

    public boolean getBlUserHab() {
        return blUserHab;
    }

    public void setBlUserHab(boolean blUserHab) {
        this.blUserHab = blUserHab;
    }

    public String getVrUserCor() {
        return vrUserCor;
    }

    public void setVrUserCor(String vrUserCor) {
        this.vrUserCor = vrUserCor;
    }

    public String getVrUserCla() { return vrUserCla; }

    public void setVrUserCla(String vrUserCla) {
        this.vrUserCla = vrUserCla;
    }

    public TbTestPerson getTbTestPerson() {
        return tbTestPerson;
    }

    public void setTbTestPerson(TbTestPerson tbTestPerson) {
        this.tbTestPerson = tbTestPerson;
    }

}
