package sphinx.sicopese.model;

public class Pelicula extends PeliculaSerie {
    private String tipo;
    private int duracion;

    public Pelicula(){}
    
    public Pelicula(String nombre, int annoestreno, String director,String urlimagen,String tipo,int duracion) {
        super(nombre, annoestreno, director,urlimagen);
        this.tipo = tipo;
        this.duracion=duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return tipo +"|"+ super.toString() +"|"+ duracion;
    }
    
    
    
    
    
    
}
