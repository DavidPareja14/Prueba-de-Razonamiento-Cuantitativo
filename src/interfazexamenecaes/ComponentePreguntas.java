/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazexamenecaes;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import ModeloMundo.Pregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

/**
 *
 * @author USUARIO
 */
class Informacion extends JFrame{
    private JLabel labImagenInformativa;
    private JLabel labImagenPregunta;
    
    public Informacion(String rutaImagenInformativa, String rutaImagenPregunta)
    {
        if (!rutaImagenInformativa.equals("") || !rutaImagenPregunta.equals("")){
            setTitle("Información");
            setSize(650, 700);
            setResizable(false);

            setLayout(new BorderLayout());
            labImagenInformativa = new JLabel();
            labImagenPregunta = new JLabel();

            JPanel imgsInformacion = new JPanel();
            imgsInformacion.setLayout(new BorderLayout());

            labImagenInformativa.setIcon( new ImageIcon( new ImageIcon( rutaImagenInformativa).getImage( )) );


            TitledBorder bordeInfoPreguntas = new TitledBorder("Información para las preguntas indicadas");
            bordeInfoPreguntas.setTitleColor(Color.BLUE);
            labImagenInformativa.setBorder(bordeInfoPreguntas);


            imgsInformacion.add(labImagenInformativa, BorderLayout.NORTH);

            labImagenPregunta.setIcon( new ImageIcon( new ImageIcon(rutaImagenPregunta).getImage( )) );

            TitledBorder bordeInfoPregunta = new TitledBorder("Información para la pregunta");
            bordeInfoPregunta.setTitleColor(Color.BLUE);
            labImagenPregunta.setBorder(bordeInfoPregunta);

            imgsInformacion.add(labImagenPregunta, BorderLayout.CENTER);

            JScrollPane scrollImgs = new JScrollPane(imgsInformacion);
            scrollImgs.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            add(scrollImgs, BorderLayout.CENTER);
            
            this.setVisible(true);
        }
        else
        {
             JOptionPane.showMessageDialog(this, "No hay información para mostrar", "Sin información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

public class ComponentePreguntas extends JPanel implements ActionListener{
    private final static String ANTERIOR_PREGUNTA = "<";
    private final static String SIGUIENTE_PREGUNTA = ">";
    private final static String VER_INFORMACION = "<html><p align = 'center'>Ver</p>Información</html>";
    private final static String OPCION_A = "A";
    private final static String OPCION_B = "B";
    private final static String OPCION_C = "C";
    private final static String OPCION_D = "D";
    
    InterfazExamenECAES principal;
    
    private int numeroPreguntaActual;
    private ArrayList<Pregunta> preguntas;
    private Pregunta preguntaActual;
    //Es necesario para saber que se respondio en cada pregunta y tener bien
    //actualizados los checBox
    private String[] respuestaAPreguntas;
    private int numeroDePreguntas;
    //Necesito saber si ya se ha terminado la prueba y se quieren ver los resul-
    //tados o si aún se está presentando el examen.
    private boolean presentandoPrueba;
    
    private JLabel imagenPregunta;
    private JTextArea taPregunta;
    private JButton btnInformacion;
    private JButton btnAnterior;
    private JCheckBox cbOpcionA;
    private JCheckBox cbOpcionB;
    private JCheckBox cbOpcionC;
    private JCheckBox cbOpcionD;
    private JButton btnSiguiente;
    
    public ComponentePreguntas(InterfazExamenECAES pPrincipal, ArrayList<Pregunta> pPreguntas)
    {
        principal = pPrincipal;
        numeroPreguntaActual = 0;
        preguntas = pPreguntas;
        numeroDePreguntas = preguntas.size();
        respuestaAPreguntas = new String[numeroDePreguntas];
        presentandoPrueba = true;
        //Inicialmente no se ha contestado alguna pregunta
        for (int i = 0; i < numeroDePreguntas; i++)
            respuestaAPreguntas[i]  = "";
        
        setLayout(new BorderLayout());
        
        TitledBorder borde = new TitledBorder("Preguntas");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);
        
        taPregunta = new JTextArea();
        taPregunta.setLineWrap(true);
        taPregunta.setWrapStyleWord(true);
        taPregunta.setText(preguntas.get(numeroPreguntaActual).getPregunta()); //Pongo la primera pregunta
        taPregunta.setEditable(false);
        JScrollPane scrollPregunta = new JScrollPane(taPregunta);
        scrollPregunta.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPregunta, BorderLayout.CENTER);
        
        btnInformacion = new JButton(VER_INFORMACION);
        btnInformacion.setActionCommand(VER_INFORMACION);
        btnInformacion.addActionListener(this);
        add(btnInformacion, BorderLayout.EAST);
        
        JPanel todasLasPreguntas = new JPanel();
        
        todasLasPreguntas.setLayout(new BorderLayout());
        btnAnterior = new JButton(ANTERIOR_PREGUNTA);
        btnAnterior.setActionCommand(ANTERIOR_PREGUNTA);
        btnAnterior.addActionListener(this);
        todasLasPreguntas.add(btnAnterior, BorderLayout.WEST);
        JPanel opciones = new JPanel();
        opciones.setLayout(new GridLayout(4,1));
        cbOpcionA = new JCheckBox(preguntas.get(numeroPreguntaActual).getOpciones()[0]);
        cbOpcionA.setActionCommand(OPCION_A);
        cbOpcionA.addActionListener(this);
        opciones.add(cbOpcionA);
        cbOpcionB = new JCheckBox(preguntas.get(numeroPreguntaActual).getOpciones()[1]);
        cbOpcionB.setActionCommand(OPCION_B);
        cbOpcionB.addActionListener(this);
        opciones.add(cbOpcionB);
        cbOpcionC = new JCheckBox(preguntas.get(numeroPreguntaActual).getOpciones()[2]);
        cbOpcionC.setActionCommand(OPCION_C);
        cbOpcionC.addActionListener(this);
        opciones.add(cbOpcionC);
        cbOpcionD = new JCheckBox(preguntas.get(numeroPreguntaActual).getOpciones()[3]);
        cbOpcionD.setActionCommand(OPCION_D);
        cbOpcionD.addActionListener(this);
        opciones.add(cbOpcionD);
        
        cbOpcionA.setBackground(Color.WHITE);
        cbOpcionB.setBackground(Color.WHITE);
        cbOpcionC.setBackground(Color.WHITE);
        cbOpcionD.setBackground(Color.WHITE);
        
        JScrollPane scrollOpciones = new JScrollPane(opciones);
        scrollOpciones.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        todasLasPreguntas.add(scrollOpciones, BorderLayout.CENTER);
        btnSiguiente = new JButton(SIGUIENTE_PREGUNTA);
        btnSiguiente.setActionCommand(SIGUIENTE_PREGUNTA);
        btnSiguiente.addActionListener(this);
        todasLasPreguntas.add(btnSiguiente, BorderLayout.EAST);
        
        add(todasLasPreguntas, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        String nombreEvento = evento.getActionCommand();
        
        if (nombreEvento.equals(ANTERIOR_PREGUNTA))
        {
            if (numeroPreguntaActual == 0)
            {
                if (!presentandoPrueba)
                    principal.visualizarRespuestaCorrecta(numeroPreguntaActual);
                JOptionPane.showMessageDialog(this, "Se encuentra en la primera pregunta", "Primera Pregunta", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                if (presentandoPrueba)
                {
                    preguntaActual = preguntas.get(numeroPreguntaActual);
                    actualizarEstadoPregunta();
                    numeroPreguntaActual -= 1;
                }
                else{
                    numeroPreguntaActual -= 1;
                    principal.visualizarRespuestaCorrecta(numeroPreguntaActual);
                }
                preguntaActual = preguntas.get(numeroPreguntaActual);
                cargarPregunta();
            }            
        }
        else if (nombreEvento.equals(SIGUIENTE_PREGUNTA))
        {
            if (numeroPreguntaActual == numeroDePreguntas-1)
            {
                if (presentandoPrueba)
                    actualizarEstadoPregunta();
                else
                    principal.visualizarRespuestaCorrecta(numeroPreguntaActual);
                JOptionPane.showMessageDialog(this, "Se encuentra en la última pregunta", "Última Pregunta", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                if (presentandoPrueba)
                {
                    preguntaActual = preguntas.get(numeroPreguntaActual);
                    actualizarEstadoPregunta();
                    numeroPreguntaActual += 1;  
                }
                else{
                    numeroPreguntaActual += 1;
                    principal.visualizarRespuestaCorrecta(numeroPreguntaActual);
                    preguntaActual = preguntas.get(numeroPreguntaActual);
                } 
                preguntaActual = preguntas.get(numeroPreguntaActual);
                cargarPregunta();
            }
        }
        else if (nombreEvento.equals(VER_INFORMACION))
        {
            new Informacion(preguntas.get(numeroPreguntaActual).getRutaImagenInformacion(), preguntas.get(numeroPreguntaActual).getRutaImagenPregunta());
        }
        else
        {
            if (presentandoPrueba)
            {
                if (respuestaAPreguntas[numeroPreguntaActual].equals(nombreEvento))
                    respuestaAPreguntas[numeroPreguntaActual] = "";
                else
                    respuestaAPreguntas[numeroPreguntaActual] = nombreEvento;
                seleccionarUnicaOpcion(respuestaAPreguntas[numeroPreguntaActual]);
            }
            else
                seleccionarUnicaOpcion(respuestaAPreguntas[numeroPreguntaActual]);
        }
    }
    
    public void setPresentandoPrueba(boolean enExamen)
    {
        presentandoPrueba = enExamen;
    }
    
    public int getNumeroPreguntaActual()
    {
        return numeroPreguntaActual;
    }
    /**
     * Muestra la pregunta actual con sus respectivas opciones
     */
    public void cargarPregunta()
    {
        taPregunta.setText(preguntaActual.getPregunta());
        cbOpcionA.setText(preguntaActual.getOpciones()[0]);
        cbOpcionB.setText(preguntaActual.getOpciones()[1]);
        cbOpcionC.setText(preguntaActual.getOpciones()[2]);
        cbOpcionD.setText(preguntaActual.getOpciones()[3]);
        seleccionarUnicaOpcion(respuestaAPreguntas[numeroPreguntaActual]);
    }
    
    /**
     * Cuando la prueba es terminada, se colorea la respuesta correcta e
     * incorrecta con verder y rojo respectivamente para cada pregunta.
     * @param opcion es el checkbox que el usuario seleccionó
     * @param opcionSeleccionada es la letra seleccionada
     */
    public void colorearCorrectaEIncorrecta(JCheckBox opcion, String opcionSeleccionada)
    {
        if (!presentandoPrueba)
        {
            if (preguntaActual.getRespuestaCorrecta().equals(OPCION_A))
            {
                cbOpcionA.setBackground(Color.GREEN);
                cbOpcionB.setBackground(Color.GRAY);
                cbOpcionC.setBackground(Color.GRAY);
                cbOpcionD.setBackground(Color.GRAY);
            }
            else if (preguntaActual.getRespuestaCorrecta().equals(OPCION_B))
            {
                cbOpcionA.setBackground(Color.GRAY);
                cbOpcionB.setBackground(Color.GREEN);
                cbOpcionC.setBackground(Color.GRAY);
                cbOpcionD.setBackground(Color.GRAY);
            }
            else if (preguntaActual.getRespuestaCorrecta().equals(OPCION_C))
            {
                cbOpcionA.setBackground(Color.GRAY);
                cbOpcionB.setBackground(Color.GRAY);
                cbOpcionC.setBackground(Color.GREEN);
                cbOpcionD.setBackground(Color.GRAY);
            }
            else if (preguntaActual.getRespuestaCorrecta().equals(OPCION_D))
            {
                cbOpcionA.setBackground(Color.GRAY);
                cbOpcionB.setBackground(Color.GRAY);
                cbOpcionC.setBackground(Color.GRAY);
                cbOpcionD.setBackground(Color.GREEN);
            }
            if (preguntaActual.getRespuestaCorrecta().equals(opcionSeleccionada))
                opcion.setBackground(Color.GREEN);
            else if (opcion != null)
                    opcion.setBackground(Color.RED);
        }
    }
    
    public void seleccionarUnicaOpcion(String opcionSeleccionada)
    {
        if (opcionSeleccionada.equals(OPCION_A)){
            colorearCorrectaEIncorrecta(cbOpcionA, OPCION_A);
            cbOpcionA.setSelected(true);
            cbOpcionB.setSelected(false);
            cbOpcionC.setSelected(false);
            cbOpcionD.setSelected(false);}
        else if (opcionSeleccionada.equals(OPCION_B)){
            colorearCorrectaEIncorrecta(cbOpcionB, OPCION_B);
            cbOpcionA.setSelected(false);
            cbOpcionB.setSelected(true);
            cbOpcionC.setSelected(false);
            cbOpcionD.setSelected(false);}
        else if (opcionSeleccionada.equals(OPCION_C)){
            colorearCorrectaEIncorrecta(cbOpcionC, OPCION_C);
            cbOpcionA.setSelected(false);
            cbOpcionB.setSelected(false);
            cbOpcionC.setSelected(true);
            cbOpcionD.setSelected(false);}
        else if (opcionSeleccionada.equals(OPCION_D)){
            colorearCorrectaEIncorrecta(cbOpcionD, OPCION_D);
            cbOpcionA.setSelected(false);
            cbOpcionB.setSelected(false);
            cbOpcionC.setSelected(false);
            cbOpcionD.setSelected(true);}
        else{
            colorearCorrectaEIncorrecta(null, "");
            cbOpcionA.setSelected(false);
            cbOpcionB.setSelected(false);
            cbOpcionC.setSelected(false);
            cbOpcionD.setSelected(false);            
        }
    }
    
    /**
     * Funcion que permitirá asignar si la pregunta quedó bien contestada o no
     */
    public void cargarSiRespondioBien()
    {
        if (respuestaAPreguntas[numeroPreguntaActual].equals(preguntaActual.getRespuestaCorrecta()))
            preguntaActual.setRespondioBien(true);
        else
            preguntaActual.setRespondioBien(false);
    }
    
    /**
     * Le permite al componente estados actualizar el estado de la pregunta
     */
    public void actualizarEstadoPregunta()
    {
        if (!respuestaAPreguntas[numeroPreguntaActual].equals("")){
            principal.navegandoPreguntas(numeroPreguntaActual, "X");
            cargarSiRespondioBien();
        }
        else
        {
            principal.navegandoPreguntas(numeroPreguntaActual, "");
            cargarSiRespondioBien();
        }
    }
}
