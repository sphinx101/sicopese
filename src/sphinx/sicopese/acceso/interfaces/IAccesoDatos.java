package sphinx.sicopese.acceso.interfaces;

import java.util.List;
import sphinx.sicopese.excepciones.AccesoDatosEx;
import sphinx.sicopese.excepciones.EscrituraDatosEx;
import sphinx.sicopese.excepciones.LecturaDatosEx;
import sphinx.sicopese.model.PeliculaSerie;

public interface IAccesoDatos {

    public boolean existe(String nombreRecurso) throws AccesoDatosEx;

    public List<PeliculaSerie> listar(String nombreRecurso) throws LecturaDatosEx;

    public void escribir(PeliculaSerie peliculaserie,String nombreRecurso) throws EscrituraDatosEx;

    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    public void crear(String nombreRecurso) throws AccesoDatosEx;

    public void borrar(String nombreRecurso) throws AccesoDatosEx;
}
