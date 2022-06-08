import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Model.Aluno;

/**
 * Write a description of class RemoverGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoverGUI extends JFrame implements ActionListener
{
    public JLabel removerRa;
    public JLabel aviso;
    public JTextField removerRaTF;
    public JButton conv;
    public String ra;
    /**
     * Método removerRA
     * remove o aluno com o ra removido 
     * @return retorna o RA pedido para ser removido
     */

    public RemoverGUI()
    {
        setSize(500, 100);
        setLocation(200, 100);

        //Pega e Define atributos do container
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,2));
        
        // Adiciona Label 3
        cp.add(removerRa = new JLabel("Forneca ra", JLabel.CENTER));
            // Adiciona caixa de texto
        removerRaTF = new JTextField();
        removerRaTF.setToolTipText("Forneca ra");
        removerRaTF.setBackground(Color.WHITE);
        removerRaTF.setForeground(Color.BLACK);
        cp.add(removerRaTF);
        
        cp.add(conv = new JButton("Armazenar"));
        conv.setBackground(Color.YELLOW);
        conv.setForeground(Color.RED);
        conv.addActionListener(this);
        conv.setToolTipText("Armazena o Aluno");
        
        cp.add(aviso = new JLabel("", JLabel.CENTER));
    }

    public void actionPerformed(ActionEvent ae) {

        try{
            //System.out.println(ae.getActionCommand());
            setVisible(false);
        }catch(Exception e){
            aviso.setText("Valor invalido!");
        }

    }
    
    
    public String lerRA(){
        ra = removerRaTF.getText();
        return ra;
    }
}
