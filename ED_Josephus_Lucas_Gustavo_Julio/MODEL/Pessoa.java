package MODEL;
import java.awt.*;

import GUI.PainelRedondo;

/**
 * Essa classe cria as pessoas que ir√£o jogar
 *
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 10/06/2022 - 4:35
 */
public class Pessoa
{
    private int nP; //numero de pessoas
    private boolean Vivo; //status para ver se esta vivo ou nao
    private PainelRedondo label; //visor
    
    /**
     * Pessoa Constructor - aqui È a construcao do personagem vivo, ser· aqui que vai colocar o status como vivo
     * e pegar todas as informacoes da pessoa
     *
     * @param nP Numero(posicao) da pessoa 
     * @param pVivo Statuso da pessoa
     * @param label Layout de como vai printar a pessoa
     */
    public Pessoa(int nP, boolean pVivo, PainelRedondo label){

        pVivo = true; //inicia o jogo com as pessoas vivas
        Vivo = pVivo; //inicia o jogo com as pessoas vivas
        this.nP = nP; // pega o numero de pessoas
        this.label = label; //inicializa o local onde vao ficar as pessoas

        label.setBackground(Color.GREEN);
        label.setForeground(Color.BLUE);

        //label.setFont(new Font("Comic Sans", Font.BOLD, 15)); //se quiser fazer em txt

        //label.setText(" O "); //se quiser fazer em txt

    }
    
    /**
     * Method getNum - coleta o numero(posicao) da pessoa
     *
     * @return Retorna o numero de pessoas
     */
    public int getNum(){
        return nP;
    }

    /**
     * Method getStatus - coleta o status da pessoa (vivo ou morto)
     *
     * @return retorna o status do construtor pessoa
     */
    public boolean getStatus(){ 
        return Vivo;
    }

    /**
     * Method getLabel - pega a label da pessoa
     *
     * @return retorna a label(interface)
     */
    public PainelRedondo getLabel(){ 
        return label;
    }

    /**
     * Method changeStatus - quando a pessoa morrer, ela ir· entrar aqui e mudar o status
     * 
     * Quando morto, o Status muda
     */
    public void changeStatus(){ 
        Vivo = false; //coloca a pessoa como morta
        //label.setFont(new Font("Comic Sans", Font.BOLD, 15)); //se quiser fazer em txt
        //muda a cor da pessoa
        label.setForeground(Color.BLACK);
        label.setBackground(Color.red);
        //label.setText(" X "); //se quiser fazer em txt
    }
}
