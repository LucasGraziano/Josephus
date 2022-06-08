 import Model.Aluno;
/**
 * No da lista (ou célula para algumas pessoas)
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */

public class No{
    // Atributos
    Aluno conteudo; // conteudo
    No proximo; // proximo

    /**
     * Constroi um no da lista ligada
     * @param Object conteudo do no
     */
    public No(Aluno aluno){
        setConteudo(aluno);
        setProximo(null);
    }
    // setters e getters
    /**
     * Método setConteudo
     *
     * @param conteudo conteudo do no
     */
    public void setConteudo(Aluno aluno){
        this.conteudo = aluno;
    }
    
    /**
     * Método setProximo
     *
     * @param proximo referencia para o proximo no
     */
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    /**
     * Método getConteudo
     *
     * @return Object conteudo do no
     */
    public Aluno getConteudo(){
        return(this.conteudo);
    }
    
    /**
     * Método getProximo
     *
     * @return NO referencia do proximo no
     */
    public No getProximo(){
        return(this.proximo);
    }
    /**
     * Método toString
     *
     * @return String conteudo do no como string
     */
    public String toString(){
        return(getConteudo().getDados());
    }
    

}
