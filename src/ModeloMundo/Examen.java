/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloMundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author USUARIO
 */
public class Examen {
    private final static double NOTA_MAXIMA = 5.0;    
    private int cantidadPreguntas;
    private ArrayList<Pregunta> preguntas;
    
    public Examen(String archivoPrueba) throws Exception
    {
        preguntas = new ArrayList();
        FileInputStream fis = new FileInputStream( new File( archivoPrueba ) );
        Properties propiedades = new Properties( );
        propiedades.load( fis );
        
        String pregunta;
        String rutaImagenInformacion;
        String[] opciones;
        String respuestaCorrecta;
        String rutaImagenPregunta;
        
        String temp; //me va obtener la cantidad de carros en el archivo, es de tipo string.
        String dato = "total.preguntas"; //asi esta representada la cantidad de carros en el vehiculo        
        temp = propiedades.getProperty(dato); //busca en el archivo total.perros y obtiene el valor que tiene asociado (4)
        cantidadPreguntas = Integer.parseInt(temp);
        
        for( int cont = 1; cont <= cantidadPreguntas; cont++ )
            {
                opciones = new String[4]; //Cada vez creo un nuevo arreglo para que se tengan diferentes referencias.
                // Carga un carro
                dato = "pregunta" + cont + ".pregunta";
                pregunta = propiedades.getProperty( dato );

                dato = "pregunta" + cont + ".rutaImagenInformacion";
                rutaImagenInformacion = propiedades.getProperty( dato );

                dato = "pregunta" + cont + ".opcionA";
                opciones[0] = propiedades.getProperty( dato );
                
                dato = "pregunta" + cont + ".opcionB";
                opciones[1] = propiedades.getProperty( dato );
                
                dato = "pregunta" + cont + ".opcionC";
                opciones[2] = propiedades.getProperty( dato );
                
                dato = "pregunta" + cont + ".opcionD";
                opciones[3] = propiedades.getProperty( dato );

                dato = "pregunta" + cont + ".rutaImagenPregunta";
                rutaImagenPregunta = propiedades.getProperty( dato );
                
                dato = "pregunta" + cont + ".respuestaCorrecta";
                respuestaCorrecta = propiedades.getProperty( dato );
                // S�lo se carga la pregunta si los datos son correctos
                if( pregunta != null && rutaImagenInformacion != null && opciones[0]!= null && rutaImagenPregunta != null)
                    preguntas.add(new Pregunta( pregunta, rutaImagenInformacion, opciones, rutaImagenPregunta, respuestaCorrecta));
                fis.close( );
            }
    }

    public int getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }
    
    public String[] getRespuestasCorrectas(){
        String[] respuestaCorrectas = new String[preguntas.size()];
        for (int i = 0; i < preguntas.size(); i++)
            respuestaCorrectas[i] = preguntas.get(i).getRespuestaCorrecta();
        return respuestaCorrectas;
    }
    
    public double calcularPuntaje()
    {
        double puntaje;
        int respuestasCorrectas = 0;
        for (int i = 0; i < cantidadPreguntas; i++)
        {
            if (preguntas.get(i).isRespondioBien())
                respuestasCorrectas += 1;
        }
        puntaje = (NOTA_MAXIMA/cantidadPreguntas)*respuestasCorrectas;
        return puntaje;
    }
    
}
