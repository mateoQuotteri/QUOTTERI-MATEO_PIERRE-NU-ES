package com.backend.test;

import com.backend.dao.impl.OdontologoDaoH2;
import com.backend.dao.impl.OdontologoDaoMemoria;
import com.backend.entity.Odontologo;
import com.backend.service.impl.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OdontologoServiceTest {
    private OdontologoService odontologoService;

    @Test
    void deberiaGuardarUnOdontologoEnH2Y_Retornarlo(){
        odontologoService = new OdontologoService(new OdontologoDaoH2());
        Odontologo odontologo1 = new Odontologo("Mateo", "Quotteri", 1145);
        Odontologo odontologo2 = new Odontologo("Pierre", "Nuñez", 1146);

        Odontologo odontologoRegistrado1 = odontologoService.guardarOdontologo(odontologo1);
        Odontologo odontologoRegistrado2 = odontologoService.guardarOdontologo(odontologo2);


        Assertions.assertTrue(odontologoRegistrado1.getId() != 0);
        Assertions.assertTrue(odontologoRegistrado2.getId() != 0);


    }

    @Test
    void deberiaRetronarLaListaEnH2DeOdontologos(){
        odontologoService = new OdontologoService(new OdontologoDaoH2());
        List<Odontologo> odontologos =  odontologoService.listarOdontologos();



        Assertions.assertTrue(odontologos.size() > 0);

    }

    @Test
    void deberiaGuardarUnOdontologoEnMemoriaY_Retornarlo(){
        List<Odontologo> listaVacia = new ArrayList<>();

        odontologoService = new OdontologoService(new OdontologoDaoMemoria(listaVacia));
        Odontologo odontologo1 = new Odontologo("Jorginho", "Lopez", 2245);
        Odontologo odontologo2 = new Odontologo("Lionel", "Messi", 2246);

        Odontologo odontologoRegistrado1 = odontologoService.guardarOdontologo(odontologo1);
        Odontologo odontologoRegistrado2 = odontologoService.guardarOdontologo(odontologo2);




        Assertions.assertTrue(odontologoRegistrado1.getId() != 0);
        Assertions.assertTrue(odontologoRegistrado2.getId() != 0);



    }

    @Test
    void deberiaRetronarLaListaEnMemoriaDeOdontologos(){
        List<Odontologo> odontologoListados = List.of(new Odontologo("Jorginho", "Lopez", 2245), new Odontologo("Lionel", "Messi", 2246));
        odontologoService = new OdontologoService(new OdontologoDaoMemoria(odontologoListados));
        List<Odontologo> odontologos =  odontologoService.listarOdontologos();

        assertNotNull(odontologos);
        assertEquals(2, odontologos.size());

        
        assertEquals(odontologoListados.get(0).getNombre(), "Jorginho");
        assertEquals(odontologoListados.get(1).getNombre(), "Lionel");

    }

    }
