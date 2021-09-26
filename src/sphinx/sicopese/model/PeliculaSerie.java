package sphinx.sicopese.model;

public class PeliculaSerie {
    private String nombre;
    private int  annoestreno;
    private String director;
    private String urlimagen;

    

    public PeliculaSerie(){}
    public PeliculaSerie(String nombre, int annoestreno, String director, String urlimagen) {
        this.nombre = nombre;
        this.annoestreno = annoestreno;
        this.director = director;
        this.urlimagen=urlimagen;
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
    
    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    @Override
    public String toString() {
        return nombre + "|" + annoestreno + "|" + director + "|" + urlimagen;
    }
    
    
    
}
