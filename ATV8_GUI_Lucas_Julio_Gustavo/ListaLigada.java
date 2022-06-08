import Model.Aluno;
import java.io.*;
/**
 * Implementa o cadastro de aluno com Lista Ligada simples.
 * 
 * @author Lucas Graziano
 * @version 01/06/2022
 */
public class ListaLigada implements ILista {
    // Atributos
    No inicio,  // Ponteiro para o inicio
    fim;     // Ponteiro para o fim
    public Aluno cadAlunos;

    int qtdNos; // Quantidade de nos

    /**
     * ListaLigadaSimples Construtor
     *
     * Inicia uma lista ligada simples. Inicia ponteiros e contador de nos.
     * 
     */
    public ListaLigada(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    /**
     * Método setInicio
     *
     * @param inicio no inicial
     */
    private void setInicio(No inicio){
        this.inicio = inicio;
    }

    /**
     * Método getInicio
     *
     * @return No no inicial
     */
    public No getInicio(){
        return(this.inicio);
    }

    /**
     * Método getFim
     *
     * @return No no final
     */
    public No getFim(){
        return(this.fim);
    }

    /**
     * Método setFim
     *
     * @param fim no final
     */
    private void setFim(No fim){
        this.fim = fim;
    }

    /**
     * Método getQtdNos
     *
     * @return qtidade de nos
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * Método setQtdNos
     *
     * @param qtdNos atualiza qtde de nos
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * Método estaVazia
     *
     * @return true - lista vazia, false - lista nao vazia
     */
    public boolean estaVazia(){
        boolean ret = false; 
        if (getQtdNos() == 0 && getInicio() == null && getFim() == null){
            ret = true;
        }
        return ret;
    }

    /**
     * Método inserirInicio
     *
     * @param elem Objeto a ser inserido na lista
     */
    public void inserir(Aluno aluno) {
        No novo = new No(aluno); // Cria um no com o objeto a ser inserido

        if (estaVazia()){ // Se a lista estiver vazia
            setInicio(novo);
            setFim(novo);
            cadAlunos = aluno;
        } else{ // A lista não esta vazia
            novo.setProximo(inicio);
            setInicio(novo);
            cadAlunos = aluno;
        }

        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * Método removerInicio
     *
     * @return Object objeto a ser removido
     */
    public Aluno removerInicio(){
        No aux = null;
        Aluno obj = null; 

        if(!estaVazia()){ 
            if ((getInicio() == getFim())){ // Se existir apenas um no
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else { // Existe mais de um no
                aux = getInicio();
                setInicio(aux.getProximo());
                aux.setProximo(null);
            }

            // Decrementa qtidade de nos
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido
        }

        return(obj); // retorna o conteudo removido
    }

    public Aluno remover(String ra){
        No ant = getInicio();
        Aluno sup;
        No aux = null;
        No prox = null;
        Aluno obj = null;
        if(!estaVazia()){
            if((getInicio() == getFim())){
                aux = getInicio();
                setInicio(null);
                setFim(null);

            } else {
                sup = (Aluno)ant.getConteudo();
                if(sup.getRa().equals(ra)){
                    aux = getInicio();
                    setInicio(aux.getProximo());
                    aux.setProximo(null);
                } else {
                    prox = ant.getProximo();
                    sup = (Aluno)prox.getConteudo();
                    while(prox.getProximo() != null && !sup.getRa().equals(ra)){
                        ant = ant.getProximo();
                        prox = prox.getProximo();
                        sup = (Aluno)prox.getConteudo();
                    }
                    sup = (Aluno)prox.getConteudo();

                    if(sup.getRa().equals(ra)){
                        aux = prox.getProximo();
                        ant.setProximo(aux); 
                        if(prox.getProximo() == null){
                            setFim(ant); // atualiza ponteiro fim
                            aux = fim; // guarda no a ser removido
                        }
                    }
                }
            }
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido
        }

        return (obj);
    }

    /**
     * Método removerFim
     *
     * @return Object objeto a ser removido
     */
    public Aluno removerFim(){
        No ant = getInicio();
        No aux = null;
        Aluno obj = null; 

        if (!estaVazia()){
            if ((getInicio() == getFim())){ // Se existir apenas um no
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else { // Existe mais de um no           
                // percorre ate achar o no antes do fim

                while(ant.getProximo() != fim){
                    ant = ant.getProximo();
                }
                ant.setProximo(null); // desliga o no a ser removido
                aux = fim; // guarda no a ser removido
                setFim(ant); // atualiza ponteiro fim
            }

            // Decrementa qtidade de nos
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido          
        }
        return obj;
    }

    public void listar(){
        No listar = getInicio(); //coloca um No comecando do inicio
        String valores = "[ ";
        if(!estaVazia()){ //verificacao se a lista nao está vazia
            while(listar != null){ //ira rodar ate acabar
                Aluno aux = (Aluno)listar.getConteudo();
                System.out.println(listar.getConteudo());

                listar = listar.getProximo();
            }
        }
    }

    /**
     * Método toString
     *
     * @return String todos os nos da lista
     */

    public String toString(){
        No temp = getInicio();
        String valores = "[ ";
        if (!estaVazia() ){
            while (temp != null){ // percorre toda a lista
                valores += temp.getConteudo() + " ";
                temp = temp.getProximo();
            }
        }
        valores = valores + "]";
        return valores;
    }

    public void gravar(PrintWriter pw){
        No listar = getInicio();
        while(listar != null){ 
            Aluno aux = (Aluno)listar.getConteudo();
            pw.print(aux.getDados());
            pw.println();
            listar = listar.getProximo();
        }
    }
}