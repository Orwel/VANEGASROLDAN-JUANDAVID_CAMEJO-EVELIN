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
        odontologos.setMatricula(111111);
        odontologos.setNombre("Jose");
        odontologos.setApellido("Raush");

        // Utilizar el servicio para guardar el objeto odontologos en la base de datos
        odontologosService.guardarOdontologos(odontologos);
    }
}
