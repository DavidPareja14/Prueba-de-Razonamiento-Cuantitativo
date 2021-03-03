/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazexamenecaes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author USUARIO
 */
public class ComponenteResultados extends JPanel{
    
    private JLabel jbCorrecta;
    private JTextField txtCorrecta;
    private JLabel jbPuntaje;
    private JTextField txtPuntaje;
    
    private String[] respuestasCorrectas;
    
    public ComponenteResultados()
    {
        setLayout(new GridLayout(1,4));
        
        TitledBorder borde = new TitledBorder("Resultados");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);
        
        jbCorrecta = new JLabel("Respuesta correcta");
        add(jbCorrecta);
        txtCorrecta = new JTextField();
        txtCorrecta.setEditable(false);
        add(txtCorrecta);
        jbPuntaje = new JLabel("                       Puntaje");
        add(jbPuntaje);
        txtPuntaje = new JTextField();
        txtPuntaje.setEditable(false);
        add(txtPuntaje);
    }
    
    public void setTxtPuntaje(double puntaje)
    {
        txtPuntaje.setText(puntaje+"");
    }
    
    public void setPreguntasCorrectas(String[] pRespuestasCorrectas)
    {
        respuestasCorrectas = pRespuestasCorrectas;
    }
    
    public void verRespuestaCorrecta(int posRespuestaCorrecta)
    {
        txtCorrecta.setText(respuestasCorrectas[posRespuestaCorrecta]);
    }
}
