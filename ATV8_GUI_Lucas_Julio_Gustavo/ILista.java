import Model.Aluno;
/**
 * Escreva a descrição da interface IListaLigadaSimples aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface ILista
{
    public boolean estaVazia();
    public void inserir(Aluno aluno);
    public Aluno removerInicio();
    public Aluno removerFim();
    public void listar();
}
