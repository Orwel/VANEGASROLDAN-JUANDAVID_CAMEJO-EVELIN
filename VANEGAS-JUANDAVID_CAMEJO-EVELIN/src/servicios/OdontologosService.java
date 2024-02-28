package servicios;

import daos.IDao;
import entidades.Odontologos;

import java.util.List;

public class OdontologosService {
    private IDao<Odontologos> odontologosIDao;

    public OdontologosService(IDao<Odontologos> odontologosIDao) {
        this.odontologosIDao = odontologosIDao;
    }

    public IDao<Odontologos> getOdontologosIDao() {
        return odontologosIDao;
    }

    public void setOdontologosIDao(IDao<Odontologos> odontologosIDao) {
        this.odontologosIDao = odontologosIDao;
    }

    public Odontologos guardarOdontologos(Odontologos o) {
        return odontologosIDao.guardar(o);
//Delegarle la responsabvilidad de guardar al DAO
    }



    public List<Odontologos> buscarTodos(){
        return odontologosIDao.buscarTodos();
    }

}
