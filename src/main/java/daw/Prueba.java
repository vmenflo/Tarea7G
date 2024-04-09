/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import static java.time.Clock.system;
import static java.time.InstantSource.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author victor
 */
public class Prueba {
    public static void main(String[] args) throws IOException {
//      Crea la clase POJO para mapear los datos del JSON en ella. Ayúdate de la 
//      herramienta online vista en clase. Procede a leer el fichero adjunto, carga los 
//      datos en una lista de objetos POJO y a muestra los registros contenidos 
//      la lista usando la consola.

        List<Precipitaciones> lista = Lectura.extraerDatosJSON();
        lista.forEach(System.out::println);
        
//      Obtén una estructura Map donde para cada nombre de estación meteorológica se pueda 
//      consultar la precipitación acumulada de la misma. Muestra por consola el resultado
//      de la estructura map obtenida. Opcional, hacerlo con API Stream.

        Map<String,Double> listado = Metodos.generarMapPrecipitacionAcumulada(lista);
        for (String key : listado.keySet()) {
            System.out.printf("Clave %s -- Objeto %s %n", key, listado.get(key));
        }
        
//        Guarda en un fichero JSON, en la raíz del proyecto, el resultado del map.
//        Pasa el objeto map directamente a la hora de generar el archivo.

        Escritura.generarMapJSON(listado);
        
//        Usando API Stream, muestra por consola el registro que tiene la mayor precipitación.
        System.out.println(Metodos.registroMayorPrecipitacion(lista));
        
//        Usando API Stream, muestra por consola el número de estaciones 
//        meteorológicas que han sido leídas entre el 10 de octubre de 2017 y el 
//        20 de octubre de 2017, ambos días incluidos.
        System.out.println(Metodos.registroNumeroEstaciones(lista));
        
//        Usando API Stream, calcula la media de precipitaciones de aquellas
//        estaciones meteorológicas leídas entre el 10 de octubre de 2017 y el
//        20 de octubre de 2017, ambos días incluidos.
        System.out.println(Metodos.registroMediaEstaciones(lista));

    
    }
}
