/*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */


import java.util.Scanner;
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
/**
 * Escreva uma descrição da classe Menu aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Menu extends JFrame implements ActionListener {
    OpcoesMenu opcao = OpcoesMenu.NENHUM;
    Scanner scan = new Scanner( System.in );

    public JButton Inserir;
    public JButton Remover;
    public JButton Listar;
    public JButton Gravar;
    public JButton Ler;
    public JButton Sair;
    int op;

    public Menu(){
        // criarMenu();
        // Criando a janela

        setSize(600, 600);
        setLocation(200, 100);

        //Pega e Define atributos do container
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6,1));

        // Adiciona botao INSERIR
        cp.add(Inserir = new JButton("Inserir"));
        Inserir.setBackground(Color.WHITE);
        Inserir.setForeground(Color.BLACK);
        Inserir.addActionListener(this);
        Inserir.setToolTipText("Inserir");

        // Adiciona botao Remover
        cp.add(Remover = new JButton("Remover"));
        Remover.setBackground(Color.WHITE);
        Remover.setForeground(Color.BLACK);
        Remover.addActionListener(this);
        Remover.setToolTipText("Remover");

        // Adiciona botao Listar
        cp.add(Listar = new JButton("Listar"));
        Listar.setBackground(Color.WHITE);
        Listar.setForeground(Color.BLACK);
        Listar.addActionListener(this);
        Listar.setToolTipText("Listar");

        // Adiciona botao Gravar
        cp.add(Gravar = new JButton("Gravar"));
        Gravar.setBackground(Color.WHITE);
        Gravar.setForeground(Color.BLACK);
        Gravar.addActionListener(this);
        Gravar.setToolTipText("Gravar");

        // Adiciona botao Ler
        cp.add(Ler = new JButton("Ler"));
        Ler.setBackground(Color.WHITE);
        Ler.setForeground(Color.BLACK);
        Ler.addActionListener(this);
        Ler.setToolTipText("Ler");

        // Adiciona botao Sair
        cp.add(Sair = new JButton("Sair"));
        Sair.setBackground(Color.WHITE);
        Sair.setForeground(Color.BLACK);
        Sair.addActionListener(this);
        Sair.setToolTipText("Sair");
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() ==  Inserir){ 
            op = 1;
            opcao = OpcoesMenu.INSERIR;
        }else if(ae.getSource() ==  Remover){ 
            op = 2;
            opcao = OpcoesMenu.REMOVER;
        }else if(ae.getSource() ==  Listar){
            op = 3;
            opcao = OpcoesMenu.LISTAR;
        }else if(ae.getSource() ==  Gravar){
            op = 4;
            opcao = OpcoesMenu.GRAVAR;
        }else if(ae.getSource() ==  Ler){
            op = 5;
            opcao = OpcoesMenu.LER;
        }else if(ae.getSource() ==  Sair){
            op = 6;
            opcao = OpcoesMenu.SAIR;
        } else {
            opcao = OpcoesMenu.NENHUM;
        }
        setVisible(false);

    }
    public int getOP(){
        this.op = op;
        return op;
    }
    public OpcoesMenu lerOpcao(int op){ 
        // IEntrada ent = new EntradaConsole();

        switch (op){
            case 1: 
                opcao = OpcoesMenu.INSERIR;
                break;
            case 2: 
                opcao = OpcoesMenu.REMOVER;
                break;
            case 3: 
                opcao = OpcoesMenu.LISTAR;
                break;
            case 4:
                opcao = OpcoesMenu.GRAVAR;
                break;
            case 5: 
                opcao = OpcoesMenu.LER;
                break;
            case 6: 
                opcao = OpcoesMenu.SAIR;
                break;
            default:
                opcao = OpcoesMenu.NENHUM;
                break;                
        }
        return opcao;
    }
}
