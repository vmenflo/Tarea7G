/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author victor
 */
public class Metodos {
    
//      Obtén una estructura Map donde para cada nombre de estación meteorológica se pueda 
//      consultar la precipitación acumulada de la misma. Muestra por consola el resultado
//      de la estructura map obtenida. Opcional, hacerlo con API Strea
    
    public static Map<String,Double> generarMapPrecipitacionAcumulada(List<Precipitaciones> lista){
        return lista.stream().collect(Collectors.toMap((p)->p.estacionMeteorologica(), p->p.precipitacion()));
    }
    
//      Usando API Stream, muestra por consola el registro que tiene la mayor precipitación.
    public static double registroMayorPrecipitacion(List<Precipitaciones> lista){
        return lista.stream()
                .mapToDouble(p->p.precipitacion())
                .max()
                .getAsDouble();
    }
    
//        Usando API Stream, muestra por consola el número de estaciones 
//        meteorológicas que han sido leídas entre el 10 de octubre de 2017 y el 
//        20 de octubre de 2017, ambos días incluidos.
    
    public static int registroNumeroEstaciones(List<Precipitaciones> lista){
        LocalDate inicio = LocalDate.of(2017, 10, 10);
        LocalDate fin = LocalDate.of(2017, 10, 20);
        return (int)lista.stream().filter(p->p.fecha().isAfter(inicio)&&p.fecha().isBefore(fin)).count();
    }
    
//        Usando API Stream, calcula la media de precipitaciones de aquellas
//        estaciones meteorológicas leídas entre el 10 de octubre de 2017 y el
//        20 de octubre de 2017, ambos días incluidos.
    public static double registroMediaEstaciones(List<Precipitaciones> lista){
        LocalDate inicio = LocalDate.of(2017, 10, 10);
        LocalDate fin = LocalDate.of(2017, 10, 20);
        return lista.stream().filter(p->p.fecha().isAfter(inicio)&&p.fecha().isBefore(fin))
                .mapToDouble(p->p.precipitacion())
                .average()
                .getAsDouble();
    }
}
