/*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */

import java.util.Scanner;
import Model.Aluno;
/**
 * Escreva uma descrição da classe EntradaConsole aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class EntradaConsole implements IEntrada
{
    Scanner scan = new Scanner( System.in );
    String nome;
    String curso;
    String idS;
    String nS;
    float nota;
    int idade;

    public String lerNome(){ 
        System.out.println("Forneca nome: ");

        boolean auxN;      
        do{
            auxN = true;
            try{
                nome = scan.next() + scan.nextLine();
                for(int i = 0; i < nome.length(); i++){
                    char pos = nome.charAt(i);
                    if(pos == '0' || pos == '1' || pos == '2' || pos == '3' || pos == '4' || pos == '5' || pos == '6' || pos == '7' || pos == '8' || pos == '9'){
                        auxN = false;
                    }
                }
                if(auxN == false){
                    System.out.println( "Formato Invalido, utilize somente letras");
                }

            }catch(Exception e){
                if(nome == null){ //clica no cancelar
                    System.out.println("Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(nome.equals("")){
                    System.out.println("Erro: Nome vazio");
                    auxN = false;
                }
                else{
                    System.out.println("Erro 404");
                    auxN = false;
                }
            }
        }while(auxN == false);
        return nome;
    }

    public int lerIdade(){ 
        boolean auxI;              
        do{
            auxI = true;
            try{
                do{
                    System.out.println("Forneca idade: ");
                    idS = scan.next()+ scan.nextLine();
                    idade = Integer.parseInt(idS);

                    if(idade<0 || idade>120){
                        System.out.println("A idade deve estar entre 0 e 120");
                    } 
                }while(idade<0 || idade > 120);    
            }catch(Exception e){
                if(idS == null){
                    System.out.println("Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(idS.equals("")){
                    System.out.println("Erro: idade vazia");
                    auxI = false;
                }
                else{
                    System.out.println("Digite apenas numeros");
                    auxI = false;
                }
            }        
        }while(auxI == false);

        return idade;
    }

    public String lerRa(){ 
        System.out.println("Forneca RA: ");
        String ra = scan.next() + scan.nextLine();
        return ra;
    }

    public String lerCurso(){ 
        System.out.println("Forneca o curso: ");

        boolean auxC;      
        do{
            auxC = true;
            try{
                nome = scan.next() + scan.nextLine();
                for(int i = 0; i < nome.length(); i++){
                    char pos = nome.charAt(i);
                    if(pos == '0' || pos == '1' || pos == '2' || pos == '3' || pos == '4' || pos == '5' || pos == '6' || pos == '7' || pos == '8' || pos == '9'){
                        auxC = false;
                    }
                }
                if(auxC == false){
                    System.out.println( "Formato Invalido, utilize somente letras");
                }

            }catch(Exception e){
                if(nome == null){ //clica no cancelar
                    System.out.println("Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(nome.equals("")){
                    System.out.println("Erro: Curso vazio");
                    auxC = false;
                }
                else{
                    System.out.println("Erro 404");
                    auxC = false;
                }
            }
        }while(auxC == false);
        return curso;
    }

    public float lerNota(){ 
        boolean auxN;
        do{
            auxN = true;
            try{
                do{
                    System.out.println("Forneca nota: ");
                    nS = scan.next()+ scan.nextLine();
                    nota = Float.parseFloat(nS);

                    if(nota<0.0 || nota>10.0){
                        System.out.println("A nota deve estar entre 0 e 10");
                    } 
                }while(nota<0.0 || nota > 10.0);    
            }catch(Exception e){
                if( nS == null){
                    System.out.println("Erro, voltando ao menu");
                    System.exit(1);
                }
                else if(nS.equals("")){
                    System.out.println("Erro: nota vazia");
                    auxN = false;
                }
                else{
                    System.out.println("Digite apenas numeros");
                    auxN = false;
                }
            }        
        }while(auxN == false);
        return nota;
    }

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
