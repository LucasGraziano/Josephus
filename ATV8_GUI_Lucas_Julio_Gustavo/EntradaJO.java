/*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */

import javax.swing.JOptionPane;
import Model.Aluno;

public class EntradaJO implements IEntrada
{
    String nome;
    String curso;
    float nota;
    int idade;
    String idS;
    String nS;

    //Menu mn = new Menu();
    /**
     * Método lerNome
     *  lê o nome fornecido no JO, com proteção de dados
     * @return retorna o nome
     */
    public String lerNome(){ 

        boolean auxN;      
        do{
            auxN = true;
            try{
                nome = JOptionPane.showInputDialog("Forneca nome:");
                for(int i = 0; i < nome.length(); i++){
                    char pos = nome.charAt(i);
                    if(pos == '0' || pos == '1' || pos == '2' || pos == '3' || pos == '4' || pos == '5' || pos == '6' || pos == '7' || pos == '8' || pos == '9'){
                        auxN = false;
                    }
                }
                if(auxN == false){
                    JOptionPane.showMessageDialog(null, "Formato Invalido, utilize somente letras");
                }

            }catch(Exception e){
                if(nome == null){ //clica no cancelar
                    JOptionPane.showMessageDialog(null,"Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(nome.equals("")){
                    JOptionPane.showMessageDialog(null,"Erro: Nome vazio");
                    auxN = false;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro 404");
                    auxN = false;
                }
            }
        }while(auxN == false);
        return nome;
    }

    /**
     * Método lerIdade
     * lê a idade fornecida no JO, com proteção de dados
     * @return retorna a idade
     */
    public int lerIdade(){ 
        boolean auxI;
        do{
            auxI = true;
            try{
                do{
                    idS = JOptionPane.showInputDialog(" Forneça a idade: ");
                    idade = Integer.parseInt(idS);
                    if(idade<0 ||  idade>120){
                        JOptionPane.showMessageDialog(null,"A idade deve estar entre 0 e 120");
                    }
                }while(idade<0 || idade>120);
            }catch(Exception e){
                if( idS == null){
                    JOptionPane.showMessageDialog(null,"Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(idS.equals("")){
                    JOptionPane.showMessageDialog(null,"Erro: Idade vazio");
                    auxI = false;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Digite apenas numeros");
                    auxI = false;
                }
            }
        }while(auxI == false);
        return idade;
    }

    /**
     * Método lerNota
     *  lê a nota fornecida no JO, com proteção de dados
     * @return retorna a nota 
     */
    public float lerNota(){ 
        boolean auxN;
        do{
            auxN = true;
            try{
                do{
                    nS = JOptionPane.showInputDialog(" Forneça a nota: ");
                    nota = Float.parseFloat(nS);
                    if(nota < 0.0 || nota > 10.0){
                        JOptionPane.showMessageDialog(null,"A nota deve estar entre 0 e 10");
                    } 
                }while(nota < 0.0 || nota > 10.0);    
            }catch(Exception e){
                if( nS == null){
                    JOptionPane.showMessageDialog(null,"Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(nS.equals("")){
                    JOptionPane.showMessageDialog(null,"Erro: nota vazia");
                    auxN = false;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Digite apenas numeros");
                    auxN = false;
                }
            }        
        }while(auxN == false);
        return nota;
    }

    /**
     * Método lerCurso
     * lê o curso fornecido no JO, com proteção de dados
     * @return retorna o curso 
     */
    public String lerCurso(){ 

        boolean auxC;
        do{
            auxC = true;
            try{
                curso = JOptionPane.showInputDialog("Forneca curso:");
                for(int i = 0; i < curso.length(); i++){
                    char pos = curso.charAt(i);
                    if(pos == '0'  || pos == '1' || pos == '2' || pos == '3' || pos == '4' || pos == '5' || pos == '6' || pos == '7' || pos == '8' || pos == '9'){
                        auxC = false;
                    }
                }
                if(auxC == false){
                    JOptionPane.showMessageDialog(null, "Formato Invalido, utilize somente letras");
                }
            }catch(Exception e){
                if (curso == null){ // ao clicar no cancelar
                    JOptionPane.showMessageDialog(null,"Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(nome.equals("")){
                    JOptionPane.showMessageDialog(null,"Erro: Curso vazio");
                    auxC = false;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro 404");
                    auxC = false;
                }
            }
        }while(auxC == false);
        return curso;
    }

    /**
     * Método lerRa
     * lê o RA fornecido no JO
     * @return retorna RA
     */
    public String lerRa(){ 
        String ra = JOptionPane.showInputDialog("Forneca RA: ");
        return ra;
    }

    /**
     * Método criarAluno
     * Pega as Strings fornecidas nas funções e gera o criarAluno
     * @return retorna Aluno
     */
    public Aluno criarAluno(){

        // le os dados do aluno
        String nome = lerNome();
        int idade = lerIdade();
        String ra = lerRa();
        String curso = lerCurso();
        float nota = lerNota();

        Aluno a = new Aluno(nome, idade, ra, curso, nota);
        return a;
    }
}

