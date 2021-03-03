/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazexamenecaes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 *
 * @author USUARIO
 */
public class ComponenteOpciones extends JPanel implements ActionListener{
    private final static String TERMINAR = "Terminar";
    private final static String NUEVO_EXAMEN = "Nuevo Examen";
    
    InterfazExamenECAES principal;
    
    JButton btnTerminar;
    JButton btnNuevoExamen;
    JButton btnOpcion1;
    
    public ComponenteOpciones(InterfazExamenECAES pPrincipal)
    {
        principal = pPrincipal;
        
        setLayout(new GridLayout(1,3));
        TitledBorder borde = new TitledBorder("Opciones");
        borde.setTitleColor(Color.BLUE);
        setBorder(borde);
        
        btnTerminar = new JButton(TERMINAR);
        btnTerminar.setActionCommand(TERMINAR);
        btnTerminar.addActionListener(this);
        add(btnTerminar);
        btnNuevoExamen = new JButton("Nuevo Examen");
        btnNuevoExamen.setActionCommand(NUEVO_EXAMEN);
        btnNuevoExamen.addActionListener(this);
        add(btnNuevoExamen);
        btnOpcion1 = new JButton("Opción 1");
        add(btnOpcion1);
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        String nombreEvento = evento.getActionCommand();
        
        if (nombreEvento == TERMINAR)
        {
            int decision;
            decision = JOptionPane.showConfirmDialog(this, "Está segura mocosa que quiere terminar", "", JOptionPane.YES_NO_CANCEL_OPTION);
            if (JOptionPane.YES_OPTION == decision  )
                principal.terminarPrueba();
        }
        else if (nombreEvento == NUEVO_EXAMEN)
            principal.nuevoExamen();
    }
}
