package Model;

/**
 * Escreva a descrição da classe Pessoa aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Pessoa {
    // Atributos
    private NomePessoa nome;
    private int idade;
    
    // construtor
    Pessoa (String nome, int idade){
        this.nome = new NomePessoa(nome);
        this.idade = idade;
    }
    
    // setters e getters
    public int getIdade(){
        return this.idade;
    }
    
    public String toString(){
        String s = this.nome + "| Idade: " + getIdade();
        return s;
    }
    
    public String getDados(){
        String s = this.nome + "|" + getIdade();
        return s;
    }
}
