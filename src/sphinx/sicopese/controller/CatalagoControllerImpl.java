package sphinx.sicopese.controller;

import java.util.List;
import sphinx.sicopese.acceso.AccesoDatosImpl;
import sphinx.sicopese.acceso.interfaces.IAccesoDatos;
import sphinx.sicopese.controller.interfaces.ICatalogoController;
import sphinx.sicopese.excepciones.AccesoDatosEx;
import sphinx.sicopese.excepciones.EscrituraDatosEx;
import sphinx.sicopese.excepciones.LecturaDatosEx;
import sphinx.sicopese.model.Pelicula;
import sphinx.sicopese.model.PeliculaSerie;
import sphinx.sicopese.model.Serie;

public class CatalagoControllerImpl implements ICatalogoController {

    private final IAccesoDatos catalogo;
    
    
    public CatalagoControllerImpl() {
        this.catalogo=new AccesoDatosImpl();
    }

    @Override
    public void index() {
        try {
            List<PeliculaSerie> peliculaseries = this.catalogo.listar(NOMBRE_RECURSO);
            int i=1;
            for (PeliculaSerie item : peliculaseries) {
                System.out.println(i + " item = " + item);
                i++;
            }
        } catch (LecturaDatosEx ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void show(String titulo) {
        try {
            System.out.println(this.catalogo.buscar(NOMBRE_RECURSO,titulo));
        } catch (LecturaDatosEx ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }

    @Override
    public void store(String peliculaserie) {
        try {
            if(this.catalogo.existe(NOMBRE_RECURSO)){
                String[] datos= peliculaserie.split("\\|");
               
               String tipo=datos[0];
               String nombre=datos[1];
               int annoestreno=Integer.parseInt(datos[2]);
               String director=datos[3];
               String urlimagen=datos[4];
               int duracion=Integer.parseInt(datos[5]);
               
               if(tipo.equalsIgnoreCase("pelicula")){
                   this.catalogo.escribir(new Pelicula(nombre,annoestreno, director, urlimagen, tipo, duracion), NOMBRE_RECURSO);
               }else{
                   this.catalogo.escribir(new Serie(nombre, annoestreno, director, urlimagen, tipo, duracion), NOMBRE_RECURSO);
               }
            } 
        } catch (AccesoDatosEx ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();            
        }
    }
    
    @Override
    public void store(PeliculaSerie peliculaserie) {
        try {
            this.catalogo.escribir(peliculaserie, NOMBRE_RECURSO);
        } catch (EscrituraDatosEx ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(String titulo) {
    }

    @Override
    public void InitResource() {
        try {
            this.catalogo.crear(NOMBRE_RECURSO);
        } catch (AccesoDatosEx ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void ReInitResource() {
        try {
            if(!this.catalogo.existe(NOMBRE_RECURSO)){
                this.catalogo.crear(NOMBRE_RECURSO);
            }else{
                this.catalogo.borrar(NOMBRE_RECURSO);
                this.catalogo.crear(NOMBRE_RECURSO);
            } 
        } catch (AccesoDatosEx ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    
}
