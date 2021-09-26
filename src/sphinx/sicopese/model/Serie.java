package sphinx.sicopese.model;

public class Serie extends PeliculaSerie{
    private String tipo;
    int temporadas;

    
    
    public Serie(){}

    public Serie(String nombre, int annoestreno, String director,String urlimagen,String tipo,int temporadas) {
        super(nombre, annoestreno, director,urlimagen);
        this.tipo = tipo;
        this.temporadas=temporadas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return tipo + "|" + super.toString() + "|" + temporadas;
    }
    
    
    
}
