import daos.OdontologosDAOH2;
import entidades.Odontologos;
import servicios.OdontologosService;

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
    }
}
