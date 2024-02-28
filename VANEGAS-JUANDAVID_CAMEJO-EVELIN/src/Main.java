import daos.OdontologoEnMemoria;
import daos.OdontologosDAOH2;
import entidades.Odontologos;
import servicios.OdontologosService;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de OdontologosService con OdontologosDAOH2
        OdontologosService odontologosService = new OdontologosService(new OdontologosDAOH2());

        Odontologos odontologos = new Odontologos();
        odontologos.setMatricula(100);
        odontologos.setNombre("Jose");
        odontologos.setApellido("Raush");

        Odontologos odontologos2 = new Odontologos();
        odontologos.setMatricula(101);
        odontologos.setNombre("Evelin");
        odontologos.setApellido("Camejo");

        Odontologos odontologos3 = new Odontologos();
        odontologos.setMatricula(102);
        odontologos.setNombre("Juan David");
        odontologos.setApellido("Roldan");

        // Utilizar el servicio para guardar el objeto odontologos en la base de datos
        odontologosService.guardarOdontologos(odontologos);

        List<Odontologos> odontologosList = new ArrayList<>();

        // Crear algunos objetos Odontologos y agregarlos a la lista
        Odontologos odontologo1 = new Odontologos(1, "Juan", "Perez");
        Odontologos odontologo2 = new Odontologos(2, "Maria", "Gonzalez");

        odontologosList.add(odontologo1);
        odontologosList.add(odontologo2);

        // Crear un objeto de OdontologoEnMemoria pasando la lista al constructor
        OdontologoEnMemoria odontologoEnMemoria = new OdontologoEnMemoria(odontologosList);

        // Ahora puedes llamar a los métodos de OdontologoEnMemoria según sea necesario
        // Por ejemplo, guardar un nuevo odontólogo
        Odontologos nuevoOdontologo = new Odontologos(3, "Carlos", "Lopez");
        odontologoEnMemoria.guardar(nuevoOdontologo);

        // O buscar todos los odontólogos registrados
        List<Odontologos> todosLosOdontologos = odontologoEnMemoria.buscarTodos();
        System.out.println("Todos los odontólogos registrados: " + todosLosOdontologos);
    }
}
