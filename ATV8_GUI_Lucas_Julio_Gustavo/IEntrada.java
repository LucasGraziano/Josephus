import Model.Aluno;
/**
 * Escreva a descrição da interface IEntrada aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface IEntrada {
    public String lerNome(); 
    public int lerIdade(); 
    public String lerRa();
    public String lerCurso();
    public float lerNota(); 
    public Aluno criarAluno();
}
