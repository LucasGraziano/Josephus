/*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */



import javax.swing.JFrame;
import Model.Aluno;
import java.lang.Thread;
import java.lang.*;
import javax.swing.JOptionPane;
/**
 * Escreva a descrição da classe App aqui.
 *  classe app é o console do sistema, nele é administrado qual classe vai ser selecionada para uso, menu selecionado, e as instruções de inserir, remover, listar e sair.
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti 
 * @version 05/05/2022
 */
public class App {
   
    
    public static void main(String args[]) {
        
        // criar cadastro (instaciacao de um objeto da classe)
        Cadastro cad = new Cadastro();
        
        //Cria menu seleciona opcao no cadastro
        Menu mn = new Menu();
        OpcoesMenu opcao = OpcoesMenu.NENHUM;
        Boolean gui  = new Boolean(true);
        int op;
        //Interface
        EntradaGUI ent = new EntradaGUI();
        RemoverGUI rem = new RemoverGUI();
        ArquivoTexto arq = new ArquivoTexto();
       
        //Console ou JO
        //IEntrada ent = new EntradaJO();
        
        do {
            mn.setVisible(true);
            mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            do{
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    
                    }while(mn.isVisible() == true);
            op = mn.getOP();
            opcao = mn.lerOpcao(op);

            switch(opcao){
                case INSERIR:
                    //Interface
                    
                    ent.setVisible(true);
                    ent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    do{
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    
                    }while(ent.isVisible() == true);
                    Aluno a = ent.getAluno();
                    
                    
                    //JO ou console
                    //Aluno a = ent.criarAluno();
                    cad.inserir(a);
                    break;                
                case REMOVER:
                    //Interface
                    rem.setVisible(true);
                    rem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    do{
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    
                    }while(rem.isVisible() == true);
                    // le ra do aluno
                    String raRemover = rem.lerRA();
                    
                    //Console ou JO
                    //String raRemover = ent.lerRa();
        
                    // remove
                    cad.remover(raRemover);
                    break;
                case LISTAR:
            
                    cad.listar();
                    break;
                case GRAVAR:
                    arq.gravarArquivo(cad);
                    break;
                case LER:
                    arq.lerArquivo(cad);
                    break;
            }
            
        } while (opcao != OpcoesMenu.SAIR);
    }
    
    public int getQtd(){
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Forneca quantidade de alunos que voce deseja armazenar: "));
        return qtd;
    }
}
