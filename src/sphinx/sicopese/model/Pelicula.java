package sphinx.sicopese.model;

public class Pelicula {
    private String nombre;
    private int annoestreno;
    private String director;
    

    public Pelicula(){}
    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnnoestreno() {
        return annoestreno;
    }

    public void setAnnoestreno(int annoestreno) {
        this.annoestreno = annoestreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
}
