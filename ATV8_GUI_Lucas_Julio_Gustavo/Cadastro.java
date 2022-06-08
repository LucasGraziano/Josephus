/*
 * -Lucas Costa Pessoa Graziano - ra00297851
 * -Gustavo Scacchetti de Sousa - ra00301499    
 * -Julio Cesar Barboza Filho   - ra00297586
 */

import Model.Aluno;
import java.io.*;
/**
 * Cadastro de alunos utilizando array.
 * 
 * @author Julio Arakaki
 * @version 1.0 22/04/2022
 */
public class Cadastro {
    // Atributos
    //private Aluno cadAlunos[]; // armazenador
    Armazenador Ar = new Armazenador();
    
    /**
     * Construtor para objetos da classe Cadastro
     * @param qtd quantidade de alunos (maximo)
     */
    public Cadastro() {
        
    }

    /**
     * Método inserir - insere aluno na primeira posicao livre (null) do array
     *
     * @param aluno aluno a ser inserido
     * @return true aluno inserido com sucesso, false aluno nao inserido (falta espaco no array)
     */
    public void inserir(Aluno aluno){
        Ar.inserir(aluno);
    }

    /**
     * Método remover - remove o aluno do cadastro a partir do RA
     *
     * @param ra String - RA do aluno a ser removido
     * @return aluno removido, null - se o aluno não for encontrado
     * 
     */
    public void remover(String ra){
        Ar.remover(ra);
    }

    // listar alunos
    /**
     * Método listar
     *
     */
    public void listar(){
        Ar.listar(); 
    }

    /**
     * Método iniciarCadastro
     * 
     * Inicia todas as posições do array com null
     *
     */
    /*
    private void iniciarCadastro(){
        for (int i = 0; i < cadAlunos.length; i++) {
            cadAlunos[i] = null;
        }
    }
    */
    public void gravar(PrintWriter pw){
        Ar.gravar(pw);
    }
    
}
