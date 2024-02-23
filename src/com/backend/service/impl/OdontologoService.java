package com.backend.service.impl;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;
import com.backend.service.IOdontologoService;

import java.util.List;

public class OdontologoService  implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;
    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }
    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }



    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }
}
