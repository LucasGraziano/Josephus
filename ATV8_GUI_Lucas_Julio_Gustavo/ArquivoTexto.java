 /*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */


import java.io.BufferedReader;
import java.io.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import Model.Aluno;
import javax.swing.JOptionPane;
public class ArquivoTexto implements IPersistencia {
    public File file = null;
    public String arquivo = null;
    public boolean repetir = false;
    public String sn = "S";
    String nome;
    int idade;
    String ra;
    String curso;
    float nota;
    Aluno a;
    public ArquivoTexto() {

    }
    
    public void lerArquivo(Cadastro cad){
        
        // Faz leitura do nome do arquivo
        do {
            repetir = false;
            arquivo = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(arquivo);
            if (!file.exists()) { // Verifica se o qruivo existe
                String sn = JOptionPane.showInputDialog("Arquivo:" + arquivo + " inexistente, deseja tentar de novo?(s/n): ");
                if (sn.toUpperCase().charAt(0) == 'S') {
                    repetir = true;
                } else {
                    System.exit(0);
                }
            }
        } while(repetir);

        // Classes para leitura de dados
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        }

        // Leitura de dados
        try {
            String line = br.readLine();
            while(line != null) { // Enquanto existir linha no arquivo
                String separadores = "\n"+ "|"; //"\t\n\r\f"+ "|";
                StringTokenizer st = new StringTokenizer(line, separadores);
                
                // String    
                if (st.hasMoreTokens()) {
                    nome = st.nextToken();
                    System.out.println("Leu o String: " + nome + " do disco");
                } else {
                    throw new DadosIncorretosException();
                }
                
                // inteiro
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    idade = Integer.parseInt(tok);
                    System.out.println("Leu o inteiro: " + idade + " do disco");
                } else {
                    throw new DadosIncorretosException();
                }
                
                // String    
                if (st.hasMoreTokens()) {
                    ra = st.nextToken();
                    System.out.println("Leu o String: " + ra + " do disco");
                } else {
                    throw new DadosIncorretosException();
                }
                
                // String    
                if (st.hasMoreTokens()) {
                    curso = st.nextToken();
                    System.out.println("Leu o String: " + curso + " do disco");
                } else {
                    throw new DadosIncorretosException();
                }
                
                // double
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    nota = Float.parseFloat(tok);
                    System.out.println("Leu o Float: " + nota + " do disco");
                } else {
                    throw new DadosIncorretosException();
                }
                a = new Aluno(nome, idade, ra, curso, nota);
                cad.inserir(a);
                line = br.readLine(); // Le a proxima linha
            }

        } catch(DadosIncorretosException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return;
        } catch(EOFException ex) {
            System.out.println("Atingiu prematuramente o final do arquivo: " + arquivo);
            return;
        } catch(IOException ex) {
            System.out.println("Nao conseguiu ler do arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar ler o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        } finally {
            try {
                br.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
            try {
                fr.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
        }
    }
    
    public void gravarArquivo(Cadastro cad){
        do {
            arquivo = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(arquivo);
            if (file.exists()) {
                sn = JOptionPane.showInputDialog("Arquivo: " + arquivo + " ja existe, pode sobrescreve-lo?(s/n): ");
            }

        } while(sn.toUpperCase().charAt(0) == 'N');

        char separador = '|'; // caractere que sera utilizado para separar os dados

        // Classes de gravacao de dados
        PrintWriter pw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
        } catch(IOException ex) {
            System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            return;
        }

        // Gravacao dos dado no arquivo
        try {
            //for (int i = 0; i < cad.getQtd(); i++) { //para gravar algumas linhas
                    cad.gravar(pw);
                    //pw.println();
            //}
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar escrever no arquivo: " + arquivo);
            return;
        } finally {
            try {
                pw.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
            try {
                fos.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }
}
