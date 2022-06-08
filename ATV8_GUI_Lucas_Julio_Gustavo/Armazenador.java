import Model.Aluno;
import java.io.*;
/**
 * Escreva uma descrição da classe CadastroLL aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Armazenador
{
       
        //public Aluno a;
        
        //Array list = new Array(10);
        ListaLigada list = new ListaLigada();
    /**
     * Construtor para objetos da classe CadastroLL
     */
    public Armazenador()
    {
     
    }
    
    public void inserir(Aluno aluno){
        list.inserir(aluno);
    }
    
    public void remover(String ra){
        list.remover(ra);
        //list.removerInicio();
        //list.removerFim();
    }
    
    public void listar(){
        list.listar();
    }
    
    public void gravar(PrintWriter pw){
        list.gravar(pw);
    }
}
