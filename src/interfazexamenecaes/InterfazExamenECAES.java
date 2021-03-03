/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazexamenecaes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import ModeloMundo.Examen;

class InterfazExamenECAES extends JFrame {

   Examen examen;
   
   //ExamenECAES examen;
   
   JLabel imagenExamen;
   ComponentePreguntas preguntas;
   ComponenteResultados resultados;
   ComponenteEstadoPreguntas estados;
   ComponenteOpciones opciones;
    
    public InterfazExamenECAES (String nombrePrueba) throws Exception{
        examen = new Examen(nombrePrueba);
        
        setTitle("Desarrollo de preguntas");
        setSize(500, 730);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        imagenExamen = new JLabel();
        imagenExamen.setIcon( new ImageIcon( new ImageIcon("./datos/RazonamientoCuantitativo.jpg").getImage( )) );
        add(imagenExamen, BorderLayout.NORTH);
        
        //ArrayList<Pregunta> vectorPreguntas = examen.getPreguntas();
        preguntas = new ComponentePreguntas(this, examen.getPreguntas());
        add(preguntas, BorderLayout.CENTER);
        
        JPanel otrosComponentes = new JPanel();
        otrosComponentes.setLayout(new BorderLayout());
        resultados = new ComponenteResultados();
        otrosComponentes.add(resultados, BorderLayout.NORTH);
        estados = new ComponenteEstadoPreguntas();
        otrosComponentes.add(estados, BorderLayout.CENTER);
        opciones = new ComponenteOpciones(this);
        otrosComponentes.add(opciones, BorderLayout.SOUTH);
        add(otrosComponentes, BorderLayout.SOUTH);
    }
    
    /**
     * Cada vez que se cambia de pregunta, se debe actualizar el estado de las
     * preguntas, para saber cuales han sido contestadas y cuales no.
     * @param numPreguntaActual para saber cual campo actualizar.
     * @param actualizarEstado Puede ser una x o nada (vacío)
     */
    public void navegandoPreguntas(int numPreguntaActual, String actualizarEstado)
    {
        estados.preguntaContestada(numPreguntaActual, actualizarEstado);
    }
    
    /**
     * Permite terminar una prueba, gracias a esto, ya no se pueden modificar las
     * opciones y se pueden ver los resulados y cargar las respuestas correctas
     */
    public void terminarPrueba()
    {
        preguntas.setPresentandoPrueba(false);
        double puntaje = examen.calcularPuntaje();
        resultados.setTxtPuntaje(puntaje);
        resultados.setPreguntasCorrectas(examen.getRespuestasCorrectas());
        resultados.verRespuestaCorrecta(preguntas.getNumeroPreguntaActual());
    }
    
    /**
     * Una vez la prueba ha sido terminada, al navegar entre las preguntas, se
     * pasa como parámetro la prosición de la pregunta actual para poder obtener
     * la respuesta a esa pregunta.
     * @param posPreguntaActual 
     */
    public void visualizarRespuestaCorrecta(int posPreguntaActual)
    {
        resultados.verRespuestaCorrecta(posPreguntaActual);
    }
    
    public void nuevoExamen(){
        this.setVisible(false);
        Selector.main(null);
    }
}