import Model.Aluno;
import java.io.*;
/**
 * Escreva uma descrição da classe Array aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Array implements ILista
{
    int qtd;
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public Aluno cadAlunos[];

    public Array(int qtd)
    {
        // Cria array com tamanho = qtd
        cadAlunos = new Aluno[qtd];
        this.qtd = qtd;
        setQtd(qtd);
        // Inicia cadastrocom null
        iniciarCadastro();
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return this.qtd;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public void inserir(Aluno aluno){
        for (int i = 0; i < cadAlunos.length; i++) { // percorre array
            if (cadAlunos[i] == null){ // se existir espaco livre (null), insere aluno
                cadAlunos[i] = aluno;
            }
        }
    }


    /**
     * faz a remocao atraves da String inserida pelo usuário
     * 
     * @param  String ra - ra para ser removido
     * @return aluno removido
     */
    public Aluno remover(String ra){
        for (int i = 0; i < cadAlunos.length; i++) {
            if (cadAlunos[i] != null && cadAlunos[i].getRa().equals(ra)){
                Aluno alunoRemovido = cadAlunos[i];
                cadAlunos[i] = null;
                return alunoRemovido;
            }
        }
        return null;
    }

    public Aluno removerInicio(){
        int i = 0;

        if (cadAlunos[i] != null){
            Aluno alunoRemovido = cadAlunos[i];
            cadAlunos[i] = null;
            return alunoRemovido;
        }

        return null;
    }

    public Aluno removerFim(){
        int i = cadAlunos.length - 1;

        while (cadAlunos[i] == null){
            i--;
        }

        if (cadAlunos[i] != null){
            Aluno alunoRemovido = cadAlunos[i];
            cadAlunos[i] = null;
            return alunoRemovido;
        }

        return null;
    }

    /**
     * Método listar
     *
     */
    public void listar(){
        for (int i = 0; i < cadAlunos.length; i++) {
            if (cadAlunos[i] != null){
                System.out.println(cadAlunos[i]);
            }
        }    
    }

    /**
     * Método iniciarCadastro
     * 
     * Inicia todas as posições do array com null
     *
     */
    private void iniciarCadastro(){
        for (int i = 0; i < cadAlunos.length; i++) {
            cadAlunos[i] = null;
        }
    }

    public void gravar(PrintWriter pw){
        for (int i = 0; i < cadAlunos.length; i++) {
            if (cadAlunos[i] != null){
                pw.print(cadAlunos[i].getDados());
                pw.println();
                //System.out.println(cadAlunos[i]);
            }
        }
    }
    
    public boolean estaVazia(){
        int i = 0;

        while (cadAlunos[i] == null){
            i++;
        }
        if (i == cadAlunos.length - 1){
            return true;
        }
        
        return false;
    }
}
