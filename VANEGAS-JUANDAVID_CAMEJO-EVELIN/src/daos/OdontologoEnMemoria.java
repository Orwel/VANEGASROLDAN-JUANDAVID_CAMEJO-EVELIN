package daos;

import entidades.Odontologos;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoEnMemoria {

    private final Logger LOGGER = Logger.getLogger(OdontologoEnMemoria.class);
    private List<Odontologos> odontologoRepository;

    public OdontologoEnMemoria(List<Odontologos> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologos guardar(Odontologos odontologo) {
        int id = this.odontologoRepository.size() + 1;
        Odontologos odontologoRegistrado = new Odontologos(odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
        this.odontologoRepository.add(odontologoRegistrado);
        this.LOGGER.info("Se registró el siguiente odontólogo " + String.valueOf(odontologoRegistrado));
        return odontologoRegistrado;
    }

    public List<Odontologos> buscarTodos() {
        this.LOGGER.info("Encontramos los siguientes odontólogos: ");
        return this.odontologoRepository;
    }
}
