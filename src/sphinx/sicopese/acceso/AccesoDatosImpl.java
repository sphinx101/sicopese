package sphinx.sicopese.acceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import sphinx.sicopese.acceso.interfaces.IAccesoDatos;
import sphinx.sicopese.excepciones.AccesoDatosEx;
import sphinx.sicopese.excepciones.EscrituraDatosEx;
import sphinx.sicopese.excepciones.LecturaDatosEx;
import sphinx.sicopese.model.Pelicula;
import sphinx.sicopese.model.PeliculaSerie;
import sphinx.sicopese.model.Serie;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        return new File(nombreRecurso).exists();
    }

    @Override
    public List<PeliculaSerie> listar(String nombreRecurso) throws LecturaDatosEx {
        File file=new File(nombreRecurso);
        List<PeliculaSerie> PeliculaSeries=new ArrayList<>();
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String row=br.readLine();
            while (row!=null) {
               String[] datos= row.split("\\|");
               
               String tipo=datos[0];
               String nombre=datos[1];
               int annoestreno=Integer.parseInt(datos[2]);
               String director=datos[3];
               String urlimagen=datos[4];
               int duracion=Integer.parseInt(datos[5]);
               
               if(tipo.equalsIgnoreCase("pelicula")){
                   PeliculaSeries.add(new Pelicula(nombre,annoestreno,director,urlimagen,tipo,duracion));
               }else{
                   PeliculaSeries.add(new Serie(nombre,annoestreno,director,urlimagen,tipo,duracion));
               }
               row=br.readLine();
               datos=null;
               tipo=null;
               nombre=null;
               annoestreno=0;
               director=null;
               duracion=0;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx(ex.getMessage());
        }
        
        return PeliculaSeries;
    }

    @Override
    public void escribir(PeliculaSerie peliculaserie,String nombreRecurso) throws EscrituraDatosEx {
        File file = new File(nombreRecurso);
        try {
            PrintWriter pw=new PrintWriter(new FileWriter(file,true));
            pw.println(peliculaserie.toString());
            pw.close();
            System.out.println("informacion agregada al archivo: "+peliculaserie);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx(ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String titulo) throws LecturaDatosEx {
        File file=new File(nombreRecurso);
        String res=null;
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String row=br.readLine();           
            int i=1;
            while (row != null) {
                String[] datos=row.split("\\|");
                if(titulo != null && titulo.equalsIgnoreCase(datos[1])){
                    res="Titulo encontrado en la linea No. "+i;
                    row=null;
                }else{
                    row=br.readLine();
                    i++;
                }
                datos=null;
            }
            br.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace();
             throw new LecturaDatosEx(ex.getMessage());
        } catch (IOException ex) {
             ex.printStackTrace();
             throw new LecturaDatosEx(ex.getMessage());
        }
        return res;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File file=new File(nombreRecurso);
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.close();
             System.out.println("Recurso Creado con Exito!");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx(ex.getMessage());
        }
        
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        File file=new File(nombreRecurso);
        if(file.exists())
            file.delete();
        else
            throw new AccesoDatosEx("Recurso no existe!!");
    }
    
}
