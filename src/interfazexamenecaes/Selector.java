/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazexamenecaes;

/**
 *
 * @author USUARIO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author USUARIO
 */
public class Selector extends JFrame implements ActionListener{

    //Declarar las constantes con la direccion de los archivos con las pruebas.
    private final static String ARCHIVO_RAZONAMIENTO_CUANTITATIVO = "./datos/imagenesPreguntas/razonamientoCuantitativo.txt";
    private final static String RAZONAMIENTO_CUANTITATIVO = "Razonamiento Cuantitativo";
    private final static String LECTURA_CRITICA = "Lectura crítica";
    private final static String INGLES = "Inglés";
    private final static String COMPETENCIA_CIUDADANA = "Competencia ciudadana";
    
    JLabel lbSeleccionar;
    JComboBox seleccionador;
    String prueba; //contiene el nombre de la prueba
    InterfazExamenECAES principal;
    
    public Selector(){
        setTitle("Seleccionar prueba");
        setSize(350, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        add(new JLabel("<html>Seleccione una prueba:<br>(Solo se puede la prueba de<br>Razonamiento Cuantitativo)</html>"), BorderLayout.WEST);
        
        String[] pruebas = {"", RAZONAMIENTO_CUANTITATIVO, LECTURA_CRITICA, INGLES, COMPETENCIA_CIUDADANA};
        seleccionador = new JComboBox(pruebas);
        seleccionador.setSelectedIndex(0);
        seleccionador.addActionListener(this);
        add(new JLabel("<html><br><br><br><br><br></html>"), BorderLayout.NORTH);
        add(seleccionador, BorderLayout.EAST);
        add(new JLabel("<html><br><br><br><br><br></html>"), BorderLayout.SOUTH);
    }
    
    public void interfazPrincipal()
    {
        try
        {
            principal = new InterfazExamenECAES(prueba);
            principal.setVisible(true);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Prueba ECAES", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        JComboBox cb = (JComboBox)evento.getSource();
        String nombrePrueba = (String)cb.getSelectedItem();
        if (nombrePrueba.equals(RAZONAMIENTO_CUANTITATIVO) ){
            setVisible(false);
            prueba = ARCHIVO_RAZONAMIENTO_CUANTITATIVO;
            interfazPrincipal();
        }
    }
    
    public String getPrueba(){
        return prueba;
    }
    
    public static void main(String[] args) {
        Selector selector = new Selector();
        selector.setVisible(true);        
    }
}