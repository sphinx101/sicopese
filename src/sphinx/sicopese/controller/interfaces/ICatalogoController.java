package sphinx.sicopese.controller.interfaces;

import sphinx.sicopese.model.PeliculaSerie;

public interface ICatalogoController {
    public static final String NOMBRE_RECURSO="Catalogo.txt";
    
    public void index();
    public void show(String titulo);
    public void store(String peliculaserie);
    public void store(PeliculaSerie peliculaserie);
    public void remove(String titulo);
    
    public void InitResource();
    public void ReInitResource();
    
}
