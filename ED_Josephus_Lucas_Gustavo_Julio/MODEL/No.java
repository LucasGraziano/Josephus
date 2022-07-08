package MODEL;
 
/**
 * No da lista duplamente ligada circular
 */
public class No{
    /**
     * Atributos
     */
    Object conteudo; // conteudo
    No proximo;  // proximo
    No anterior; // anterior
    long id;                  // id do no         

    /**
     * Construtor
     * @param conteudo - conteudo que ir� ser armazenado no No
     */
    public No(Object conteudo){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(0);
    }
    /**
     * No Construtor
     *
     * @param conteudo dados do No
     * @param id id do no
     */
    public No(Object conteudo, long id){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(id);
    }
    
    /**
     * Method setConteudo - set o conteudo do No
     *
     * @param conteudo - conteudo do objeto
     */
    public void setConteudo(Object conteudo){
        this.conteudo = conteudo;
    }
    
    
    /**
     * Method setProximo - set o proximo do No
     *
     * @param proximo - quem sera o proximo do No selecionado
     */
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    
    /**
     * Method setAnterior - set o anterior do No
     *
     * @param anterior - quem sera o anterior do No selecionado
     */
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }

    /**
     * Method getConteudo - pega o conteudo do objeto
     * @return o conteudo do no
     */
    public Object getConteudo(){
        return(this.conteudo);
    }
    
    /**
     * Metodo getProximo - pega o proximo item do No
     * @return retorna o proximo item do no
     */
    public No getProximo(){
        return(this.proximo);
    }
    
    /**
     * Metodo getAnterior - pega o item anterior do No
     * @return retorna o item anterior do no
     */
    public No getAnterior(){
        return(this.anterior);
    }
    
    /**
     * Método setId - set o Id no No
     *
     * @param id Um parâmetro
     */
    public void setId(long id){
        this.id = id;
    }
    
    /**
     * Método getId - pega o id do No
     *
     * @return O valor de retorno
     */
    public long getId(){
        return (this.id);
    }
    
    public String toString(){
        //return "ID: " + getId() + " " + getConteudo().toString(); 
        return(conteudo.toString());
    }
}
