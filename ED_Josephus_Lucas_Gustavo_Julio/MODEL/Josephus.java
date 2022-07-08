package MODEL;
import javax.swing.*;
import GUI.PainelRedondo;;


/**
 * Escreva uma descrição da classe Josephus aqui.
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 10/06/2022 - 4:35
 */
public class Josephus extends Thread {
    // constante
    public static final int RAIO = 250;
    // variáveis de instância
    private int nM;
    private int numP;
    String lista;
    private int count;
    boolean veri;
    No cel;
    
    //acesso de outras classes
    public ListaDuplamenteLigadaCircular list = new ListaDuplamenteLigadaCircular(); //aqui acontece a logica do jogo
    public ListaDuplamenteLigadaCircular aux = new ListaDuplamenteLigadaCircular(); //aqui ira mostrar a ordem dos mortos
    No cAux = list.getFim();
    Pessoa ps;
   
    //panel onde irá acontecer o jogo
    private JPanel jogo;

    /**
     * Construtor para objetos da classe Josephus
     */
    public Josephus() { 
    }

    /**
     * Method getCel - pega o conteudo do No Cel
     *
     * @return No Cel
     */
    public void setCel(No cel) {
        this.cel = cel;
    }
    
    /**
     * Method setCount - set conteudo no contador
     *
     * @param count contador do jogo (essa funcao foi criada porque as vezes o contador nao era zerado)
     */
    public void setCount(int count){
        this.count = count;
    }
    
    /**
     * Method getcount - pega o conteudo do contador
     *
     * @return contador do jogo
     */
    public int getcount(){
        return count;
    }
    
    /**
     * Method getCel - pega o conteudo do No Cel
     *
     * @return No Cel
     */
    public No getCel() {
        return cel;
    }

    /**
     * Method setJogo - set do jogo
     *
     * @param jogo Painel onde ira passar o jogo
     */
    public void setJogo(JPanel jogo) {
        this.jogo = jogo;
    }

    /**
     * Method getJogo - pega o conteudo do jogo
     *
     * @return Painel onde ira passar o jogo
     */
    public JPanel getJogo() {
        return jogo;
    }

    /**
     * Method inserirPessoas
     * Insere a quantidade de pessoas inseridas na lista
     * 
     * @param nP quantidade de pessoas
     */
    public void inserirPessoas() {
        int i;
        //esvazia as duas listas
        esvaziarLista();
        esvaziarListaAux();
        jogo.removeAll();//some com o jogo anterior
        //for serve para adicionar pessoas at� o digitado
        for (i = 1; i <= numP; i++) {
            ps = new Pessoa(i, true, new PainelRedondo(200)); //cria o personagem
            list.inserirFim(ps); //insere no fim da lista
        }
    }

    /**
     * Method getQtdVivos - calcula a quantidade de vivos
     *
     * @return a quantidade de pessoas que ainda estao vivas
     */
    public int getQtdVivos() {
        int cout = 0;
        No cel = list.getInicio(); // celula que comeca do inicio
        Pessoa ps;
        
        //do while serve para contar quantas pessoas estao vivas, ou seja, ele ira rodar a lista inteira fazendo a contagem
        do {
            cel = cel.getProximo(); // pula para o próximo no
            ps = (Pessoa) cel.getConteudo(); // faz o cast e pega o coneúdo da celula
            
            if (ps.getStatus())
                cout++; // incremento para cada pessoa viva
        } while (cel != list.getInicio());

        return cout;
    }

    /**
     * Method Jogar
     * Aqui ira ser a logica do jogo.
     *
     * @param numP quantidade de pessoas
     * @param jogo O panel onde vai acontecer o jogo
     */
    public void Jogar(int numP) throws InterruptedException {
        //if � baseado para fazer a contagem das pessoas vivas. quando for igual a 1, ele caira direto para o else
        if (getQtdVivos() > 1) {
            veri = false;
            
            // while ira parar quando achar alguma pessoa viva
            do {

                cel = cel.getProximo();
                ps = (Pessoa) cel.getConteudo();

            } while (ps.getStatus() == false);
            count++;
            
            //quando o contador igualar ao intervalo, ele entrar na funcao e vai mudar o status da pessoa como morto
            if (count == nM) {

                aux.inserirFim(ps);//adiciona o "morto" na lista aux para fazer a ordenacao futuramente
                ps.changeStatus(); // se o count == nM -> o status irá mudar (novo morto)
                count = 0; // contador reseta

            }
        } else {

            acharUltimo();//entra na funcao para achar o ultimo
            ordemMortos(aux); //entra na funcao para mostrar a ordem que as pessoas foram mortas
            veri = true;
            setVeri(veri); //coloca o verificador como true para parar a animacao

        }

    }

    /**
     * Method Jogar
     * Adiciona as pessoas nas localizacoes do circulo
     *
     */
    public void addPessoas() {
        jogo.removeAll(); //remove as celulas anteriores
        double angulo; 
        cel = list.getInicio(); //pega o inicio da lista
        int setorCirculo = 360 / numP; //pedaco do circulo/angulo inicial
        //aqui � um for baseado no pedaco no qual a pessoa esta. quando atingir o 360, ele ira parar o for.
        for (int i = 0; i <= 360; i = setorCirculo + i) {
            ps = (Pessoa) cel.getConteudo();
            angulo = (Math.PI / 180) * i; // calcula o angulo em radianos
            double cos = Math.cos(angulo); //calcula o cosceno do angulo(x)
            double sen = Math.sin(angulo); //calcula o seno do angulo (y)
            ps.getLabel().setBounds((int) (cos * RAIO) + 300, (int) (sen * RAIO) + 260, 20, 20);//coloca na localizacao desejada
            jogo.add(ps.getLabel());//adiciona a pessoa no Label
            cel = cel.getProximo(); //vai para a proxima celula
        }
        jogo.repaint(); //repaint para evitar bug visual

        setJogo(jogo);
    }

    /**
     * Method AcharUltimo
     * Acha a ultima pessoa viva no Josephus
     *
     */
    public void acharUltimo() {
        //variaveis temporarias
        No ult;
        Pessoa ultP;
        int aux;
        //No pegando o inicio da lista
        ult = list.getInicio();
        
        //procura ate achar a unica pessoa viva
        do { 
            ultP = (Pessoa) ult.getConteudo();
            ult = ult.getProximo();
        } while (ultP.getStatus() == false);

        aux = ultP.getNum(); //pega o numero da pessoa
        JOptionPane.showMessageDialog(null, "Ultimo sobrevivente foi: " + aux); //print da pessoa viva
    }

    /**
     * Method ordemMortos
     * Mostra a ordem que as pessoas foram "mortas"
     * 
     * @param aux Lista onde esta a ordem dos mortos
     * 
     */
    public void ordemMortos(ListaDuplamenteLigadaCircular aux) {
        No cel;
        Pessoa p;
        //No comecando do inicio da lista
        cel = aux.getInicio();
        //pessoa pegando o conteudo da celula
        p = (Pessoa) cel.getConteudo();
        String s = "";
        //string vai aumentando ate acabar a lista
        do { 
            s = s + p.getNum() + " ";
            cel = cel.getProximo();
            p = (Pessoa) cel.getConteudo();
        } while (cel != aux.getInicio());

        JOptionPane.showMessageDialog(null, "Ordem de mortos: " + s); //print
    }

    /**
     * Method setCiclo - set intervalo do jogo
     * 
     * @param nM Intervalo do jogo
     *
     */
    public void setCiclo(int nM) {
        this.nM = nM;
    }

    /**
     * Method getCiclo - pega o valor do intervalo do jogo
     * 
     * @return nM Intervalo do jogo
     *
     */
    public int getCiclo() {
        return (this.nM);
    }

    // setters e getters
    /**
     * Method setNumP - set quantidade de pessoas no jogo
     * 
     * @param numP Numero de pessoas
     *
     */
    public void setNumP(int numP) {
        this.numP = numP;
    }

    /**
     * Method getNumP - pega a quantidade de pessoas no jogo
     * 
     * @return numP - quantidade de pessoas
     *
     */
    public int getNumP() {
        return (this.numP);
    }

    // setters e getters
    /**
     * Method setVeri - set o conteudo do verificador (true ou false)
     * 
     * @param veri verificador
     *
     */
    public void setVeri(boolean veri) {
        this.veri = veri;
    }

    /**
     * Method getVeri - pega o conteudo do verificador (true ou false)
     * 
     * @return veri verificador
     *
     */
    public boolean getVeri() {
        return veri;
    }

    /**
     * Method esvaziarLista - 
     * Esvazia a lista principal
     */
    public void esvaziarLista() {

        while (list.getInicio() != null) {//ira remover o fim ate a lista inteira ser null
            list.removerFim();
        }

    }

    /**
     * Method esvaziarLista - 
     * Esvazia a lista auxiliar
     */public void esvaziarListaAux() {

        while (aux.getInicio() != null) {//ira remover o fim ate a lista inteira ser null
            aux.removerFim();
        }

    }
}
