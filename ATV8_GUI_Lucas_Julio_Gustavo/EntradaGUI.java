/*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */
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

public class EntradaGUI extends JFrame implements IEntrada, ActionListener { 
    // Atributos
    public JLabel nome;
    public JLabel idade;
    public JLabel curso;
    public JLabel nota;
    public JLabel ra;
    public JLabel res;
    

    public JTextField nomeTF;
    public JTextField idadeTF;
    public JTextField cursoTF;
    public JTextField notaTF;
    public JTextField raTF;
    

    public JButton conv;
    //private JTextField tc;
    String nm;
    Aluno a;
    // Construtor
    /**
     * EntradaGUI Construtor
     * Cria a interface do GUI
     */
    public EntradaGUI(){
        // Criando a janela

        setSize(600, 600);
        setLocation(200, 100);

        //Pega e Define atributos do container
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6,2));

        //Nome
        // Adiciona Label 1

        cp.add(nome = new JLabel("Forneca nome", JLabel.CENTER));
        // Adiciona caixa de texto
        nomeTF = new JTextField();
        //nomeTF.addActionListener(this);
        nomeTF.setToolTipText("Forneca nome");
        nomeTF.setBackground(Color.WHITE);
        nomeTF.setForeground(Color.BLACK);        
        cp.add(nomeTF);
        nm = nomeTF.getText();

        //Idade
        // Adiciona Label 2
        cp.add(idade = new JLabel("Forneca idade", JLabel.CENTER));
        // Adiciona caixa de texto
        idadeTF = new JTextField();
        //idadeTF.addActionListener(this);
        idadeTF.setToolTipText("Forneca idade");
        idadeTF.setBackground(Color.WHITE);
        idadeTF.setForeground(Color.BLACK);
        cp.add(idadeTF);

        //RA
        // Adiciona Label 3
        cp.add(ra = new JLabel("Forneca ra", JLabel.CENTER));
        // Adiciona caixa de texto
        raTF = new JTextField();
        //raTF.addActionListener(this);
        raTF.setToolTipText("Forneca ra");
        raTF.setBackground(Color.WHITE);
        raTF.setForeground(Color.BLACK);
        cp.add(raTF);

        //Curso
        // Adiciona Label 4
        cp.add(curso = new JLabel("Forneca curso", JLabel.CENTER));
        // Adiciona caixa de texto
        cursoTF = new JTextField();
        //cursoTF.addActionListener(this);
        cursoTF.setToolTipText("Forneca curso");
        cursoTF.setBackground(Color.WHITE);
        cursoTF.setForeground(Color.BLACK);
        cp.add(cursoTF);

        //Nota
        // Adiciona Label 1
        cp.add(nota = new JLabel("Forneca Nota", JLabel.CENTER));
        // Adiciona caixa de texto
        notaTF = new JTextField(); 
        //notaTF.addActionListener(this);
        notaTF.setToolTipText("Forneca Nota");
        notaTF.setBackground(Color.WHITE);
        notaTF.setForeground(Color.BLACK);
        cp.add(notaTF);

        // Adiciona botao
        cp.add(conv = new JButton("Armazenar"));
        conv.setBackground(Color.RED);
        conv.setForeground(Color.CYAN);
        conv.addActionListener(this);
        conv.setToolTipText("Armazena o Aluno");

    }

    public void actionPerformed(ActionEvent ae) {

        try{
            System.out.println(ae.getActionCommand());
            a = criarAluno();    
            setVisible(false);
        }catch(Exception e){
            res.setText("Valor invalido!");
        }

    }
    
    /**
     * Método lerNome
     * lê o nome fornecido na interface
     * @return retorna o nome
     */
    public String lerNome(){ 
        //System.out.println(nome.getActionCommand());

        String nome = (nomeTF.getText());
        return nome;
    }

    /**
     * Método lerIdade
     * lê a idade fornecida na interface
     * @return retorna a idade
     */
    public int lerIdade(){ 

        int idade = Integer.parseInt(idadeTF.getText());
        return idade;
    }

    /**
     * Método lerNota
     * lê a nota fornecida na interface
     * @return retorna a nota
     */
    public float lerNota(){ 
        //System.out.println(nota.getActionCommand());
        float nota = Float.parseFloat(notaTF.getText());
        return nota;
    }
    
    /**
     * Método lerCurso
     * lê o curso fornecido na interface
     * @return retorna o curso
     */
    public String lerCurso(){ 
        String curso = (cursoTF.getText());
        return curso;
    }

    /**
     * Método lerRa
     * lê o RA fornecido na interface
     * @return retorna o RA
     */
    public String lerRa(){ 
        String ra = (raTF.getText());
        return ra;
    }

    /**
     * Método criarAluno
     * pega as variaveis fornecidas na interface e cria um aluno
     * @return retorna aluno
     */
    public Aluno criarAluno(){
        // le os dados do aluno

        String nome = lerNome();
        int idade = lerIdade();
        String ra = lerRa();
        String curso = lerCurso();
        float nota = lerNota();

        a = new Aluno(nome, idade, ra, curso, nota);
        
        return a;
    }

    public Aluno getAluno(){
        return a;
    }

    
}