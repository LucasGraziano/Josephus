package Model;


/**
 * Armazena dadosdo aluno.
 * 
 * @author Julio Arakaki 
 * @version 1.0, 22/04/2022
 */
public class Aluno extends Pessoa {
    // Atributos
    private String ra;
    private String curso;
    private float mediaGeral;
    
    //Disciplina disciplinas[];
    
    // Construtor
    public Aluno (String nome, int idade, String ra, String curso, float mediaGeral){
        
        super(nome, idade); // aciona o construtor da classe pai
        
        this.ra = ra;
        this.curso = curso;
        this.mediaGeral = mediaGeral;
    }
    // setters e getters
    public String getRa(){
        return this.ra;
    }    
    
    public String getCurso(){
        return this.curso;
    }
    
    public float getMediaGeral(){
        return this.mediaGeral;
    }
    
    public String getDados(){
        String s = super.getDados()  + "|" + getRa() + "|" +  getCurso() + "|" +  getMediaGeral();
        
        return s;
    }
    public String toString(){
        // formatando dados do aluno
        String s = super.toString() + " |ra: " + getRa() + "| curso: " + getCurso() + "| media geral: " + getMediaGeral() + "|";
        
        return s;
    }
}
