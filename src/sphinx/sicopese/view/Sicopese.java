package sphinx.sicopese.view;

import java.util.Scanner;
import sphinx.sicopese.controller.CatalagoControllerImpl;
import sphinx.sicopese.controller.interfaces.ICatalogoController;
import sphinx.sicopese.model.Pelicula;
import sphinx.sicopese.model.Serie;

public class Sicopese {
    public static void main(String[] args) {
        int opcion=-1;
        Scanner teclado=new Scanner(System.in);
        ICatalogoController catalogo=new CatalagoControllerImpl();
        while (opcion!=0) {
            System.out.println("1.- Inicializar Recurso \n"
                               +"2.- Agregar Pelicula \n"
                               +"3.- Listar Catalago\n"
                               +"4.- Buscar Pelicula o Serie\n"
                               +"0.- Salir");
            System.out.println("Elige una opcion: "); opcion=Integer.parseInt(teclado.nextLine());
            switch (opcion){
                case 1: catalogo.InitResource();
                        break;
                case 2: System.out.println("Introduce los datos de la pelicula o serie: \n");
                        System.out.println("tipo\n");
                        String tipo=teclado.nextLine();
                        System.out.println("nombre\n");
                        String nombre=teclado.nextLine();
                        System.out.println("Año estreno \n");
                        String estreno=teclado.nextLine();
                        System.out.println("director\n");
                        String director=teclado.nextLine();
                        System.out.println("ruta imagen\n");
                        String imagen=teclado.nextLine();
                        System.out.println("duracion\n");
                        String duracion=teclado.nextLine();
                        if(tipo.equalsIgnoreCase("pelicula")){
                           catalogo.store(new Pelicula(nombre, Integer.parseInt(estreno), director, imagen, tipo, Integer.parseInt(duracion)));
                        }else{
                           catalogo.store(new Serie(nombre, Integer.parseInt(estreno), director, imagen, tipo, Integer.parseInt(duracion)));
                        }
                        System.out.println("Pelicula o Serie registrada con exito");
                        break;
                case 3: catalogo.index();
                        break;
                case 4: System.out.println("Introduce el nombre de pelicula o serie a buscar: \n");
                        String titulo_buscar=teclado.nextLine();
                        catalogo.show(titulo_buscar);
                        break;
                case 0: System.exit(0);
                        break;
                default: System.out.println("Opcion no valida!");
                        break;
                        
            }
            
        }
                
    }
}
