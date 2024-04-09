/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class Lectura {
    public static List<Precipitaciones> extraerDatosJSON() throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<Precipitaciones> lluvias = mapeador.readValue(new File("precipitacionesBadajoz.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Precipitaciones.class));
        
        return lluvias;
    }
}
