package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;

import java.util.List;
import org.apache.log4j.Logger;


public class OdontologoDaoMemoria implements IDao<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);
    private List<Odontologo> odontologoList;

    public List<Odontologo> getOdontologoList() {
        return odontologoList;
    }

    public void setOdontologoList(List<Odontologo> odontologoList) {
        this.odontologoList = odontologoList;
    }

    public OdontologoDaoMemoria(List<Odontologo> odontologoList) {
        this.odontologoList = odontologoList;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        int id = odontologoList.size() + 1;
        Odontologo odontologoGuardado = new Odontologo(id, odontologo.getNombre(), odontologo.getApellido(), odontologo.getNumeroDeMatricula());

        odontologoList.add(odontologoGuardado);
        LOGGER.info("Odontologo guardado: " + odontologoGuardado);
        return odontologoGuardado;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return getOdontologoList();
    }
}
