/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazexamenecaes;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 *
 * @author USUARIO
 */
public class ComponenteEstadoPreguntas extends JPanel{
    
    private int totalPreguntas;
    private ArrayList<JLabel> numeroPregunta;
    private ArrayList<JTextField> estadoPregunta;
    
    public ComponenteEstadoPreguntas()
    {
        totalPreguntas = 25;
        numeroPregunta = new ArrayList();
        estadoPregunta = new ArrayList();
        setLayout(new GridLayout(3,10));
        
        TitledBorder borde = new TitledBorder("Estado de las preguntas");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);
        
        for (int i = 1; i <= totalPreguntas; i++)
        {
            String j = "   "+i+"";
            numeroPregunta.add(new JLabel(j));
            estadoPregunta.add(new JTextField());
        }
        for (int i = 0; i < totalPreguntas; i++)
        {
            JTextField estado = estadoPregunta.get(i);
            add(numeroPregunta.get(i));
            add(estado);
            estado.setEditable(false);
        }
    }
    
    /**
     * Si alguna opcion fue seleccionada, al pasar a la siguiente o anterior 
     * pregunta, se debe poner una x en el textfield correspondiente
     * antes de pasar a la siguiente pregunta
     * @param numPreguntaActual La posicion de la pregunta que esta en el vector
     * @param actualizar si hay una pregunta marcada, se pone una X,
     * de lo contrario no se pone, es vacío.
     * de preguntas según se crea en Examen
     */
    public void preguntaContestada(int numPreguntaActual, String actualizar)
    {        
        estadoPregunta.get(numPreguntaActual).setText(actualizar);
    }
}
