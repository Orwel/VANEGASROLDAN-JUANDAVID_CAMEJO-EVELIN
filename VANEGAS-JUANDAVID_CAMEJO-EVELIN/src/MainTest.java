import daos.OdontologoEnMemoria;
import daos.OdontologosDAOH2;
import entidades.Odontologos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servicios.OdontologosService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testGuardar() {
        // Crear una lista de odontólogos para guardar
        List<Odontologos> odontologosList = new ArrayList<>();
        odontologosList.add(new Odontologos(1, "Juan", "Perez"));
        odontologosList.add(new Odontologos(2, "Maria", "Gonzalez"));

        // Guardar odontólogos en memoria
        OdontologoEnMemoria odontologoEnMemoria = new OdontologoEnMemoria(odontologosList);
        List<Odontologos> odontologosGuardadosMemoria = odontologoEnMemoria.buscarTodos();



        // Guardar odontólogos en H2
        OdontologosDAOH2 odontologosDAOH2 = new OdontologosDAOH2();
        for (Odontologos odontologo : odontologosList) {
            odontologosDAOH2.guardar(odontologo);
        }
        List<Odontologos> odontologosGuardadosH2 = odontologosDAOH2.buscarTodos();

    }

    @Test
    public void testBuscarTodos() {

        Odontologos odontologoTest1 = new Odontologos(1, "Sofia", "Hernandez");
        Odontologos odontologoTest2 = new Odontologos(2, "Macarena", "Perez");


        List<Odontologos> listaOdontologos = new ArrayList<>();
        listaOdontologos.add(odontologoTest1);
        listaOdontologos.add(odontologoTest2);

        OdontologoEnMemoria DAO = new OdontologoEnMemoria(listaOdontologos);

        List<Odontologos> resultado = DAO.buscarTodos();


        Assertions.assertNotNull(resultado);
        Assertions.assertTrue(resultado.contains(odontologoTest1));
        Assertions.assertTrue(resultado.contains(odontologoTest2));



        System.out.println("Lista de odontologos encontrada:");
        for (Odontologos odontologo : listaOdontologos) {
            System.out.println(odontologo);}
        System.out.println(odontologoTest1.getNombre());
        System.out.println(odontologoTest1.getApellido());
        System.out.println(odontologoTest2.getNombre());
        System.out.println(odontologoTest2.getApellido());

    }

}