package GUI;
import MODEL.Josephus;
import MODEL.No;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Entrada em GUI.
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 01/06/2022
 */ 

public class JosephusGUI extends JFrame implements ActionListener
{
    //caixas de texto
    public JTextField nM; //casas que serão necessárias para pular (intervalo)
    public JTextField nP; //numero de pessoas
    //botoes
    public JButton botao; //comecar
    public JButton finalizar; //pausar
    //painel onde ira fica o jogo
    public JPanel jogo = new JPanel();
    //numero de pessoas e ciclo
    int numP; //numero de pessoas
    int ciclo; //intervalo
    //animacao
    Simulacao _simular; //animacao
    //chamada de outra classe
    Josephus jps = new Josephus();//variavel para a classe Josephus
    
    /**
     * JosephusGUI Constructor
     *
     * @param titulo - TITULO DO PROGRAMA
     * @param comp - Comprimento da janela
     * @param alt - Altura da janela
     */
    public JosephusGUI(String titulo, int comp, int alt){
        inicializar(titulo, comp ,alt);
    }
   
    /**
     * Faz a inicializaçao da janela principal e chama as outras funcoes para colocar os outros layouts
     * @param titulo - titulo da janela
     * @param comp - comprimento da janela
     * @param alt - altura da janela
     */
    private void inicializar(String titulo, int comp, int alt){
        // Atributos da janela
        setTitle(titulo); //coloca um titulo na box
        jogo.setLayout(null);
        setSize(comp, alt); //adiciona a largura e altura da Box
        setResizable(false);//impede que a janela mude de tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // operacao de saida da janela

        // Painel principal
        JPanel cJos = new JPanel(); //janela principal
        add(cJos);
        cJos.setLayout(new BorderLayout());//setando um layout para a janela principal

        // inserir visor do jogo
        inserirVisor(cJos);

        // inserir botoes do jogo
        inserirBotoes(cJos);

        cJos.add(jogo, BorderLayout.CENTER);//coloca o jogo no centro da janela

    }
    /**
     *  inserirVisor
     *  Serve para inserir as caixas de texto de quantidade de pessoas e o intervalo
     * @param cJos - painel principal
     */
    void inserirVisor(JPanel cJos){
        //insere um painel e coloca um layout nele
        JPanel jpVisor = new JPanel();
        jpVisor.setLayout(new FlowLayout());
        

        // Cria Visor 1
        nP = new JTextField(); // define numero de caracteres iniciais
        nP.setToolTipText("Forneca o numero de pessoas (2 >= 40)"); //"dica" para mostrar o que tem que ser digitado
        nP.setHorizontalAlignment(SwingConstants.CENTER); //alinhamento horizontal
        nP.setPreferredSize(new Dimension(200,45)); //dimensão da caixa
        nP.setBackground(Color.WHITE); //Background da caixa de texto
        nP.setForeground(Color.black); //cor do texto 
        nP.setEditable(true); //deixa o usuario digitar
        jpVisor.add(nP);// inserir o visor no painel jpVisor

        // Cria Visor 2
        nM = new JTextField(); // define numero de caracteres iniciais
        nM.setToolTipText("Forneca o Intervalo"); //"dica" para mostrar o que tem que ser digitado
        nM.setHorizontalAlignment(SwingConstants.CENTER); //alinhamento horizontal
        nM.setPreferredSize(new Dimension(200,45)); //dimensão da caixa
        nM.setBackground(Color.WHITE); //Background da caixa de texto
        nM.setForeground(Color.black); //cor do texto
        nM.setEditable(true); //deixa o usuario digitar
        jpVisor.add(nM);// inserir o visor no painel jpVisor

        // Adiciona o visor na parte superior da janela
        cJos.add(jpVisor, BorderLayout.PAGE_START);

    }

    /**
     * Method inserirBotoes adiciona os botoes no painel de botoes e insere o painel de botoes no painel principal
     *
     * @param cCalc Container painel principal onde sera inserido o painel de botoes
     */
    void inserirBotoes(Container cJos){

        //botao
        //faz um layout com uma borda redonda
        PainelRedondo botoes = new PainelRedondo(200); 
        botoes.setPreferredSize(new Dimension(100, 60));
        botoes.setLayout(new FlowLayout());
        botoes.setBackground(Color.black);
        botoes.setForeground(Color.black);
        
        //botao 1
        botoes.add(botao = new JButton("Comecar")); //nome do botao
        //alinhamento do botao

        botao.setHorizontalAlignment(SwingConstants.CENTER);//deixa o alinhamento centralizado

        //tamanho do botao
        botao.setPreferredSize(new Dimension(200,45));
        botao.addActionListener(this);//quando o botao for clicado, ira fazer uma acao

        botao.setToolTipText("Iniciar o jogo");//caixa de ajuda do texto
        

        //botao 2
        botoes.add(finalizar = new JButton("Pausar")); //nome do botao
        //alinhamento do botao

        finalizar.setHorizontalAlignment(SwingConstants.CENTER);//deixa o alinhamento centralizado

        //tamanho do botao
        finalizar.setPreferredSize(new Dimension(200,45));
        finalizar.addActionListener(this);

        finalizar.setToolTipText("Pausa o jogo");//caixa de ajuda do texto

        cJos.add(botoes, BorderLayout.PAGE_END);//coloca os botoes no final da janela principal
    }

    /**
     * Metodo actionPerformed - local onde sera instruido qual sera a acao do botao
     *
     * @param ae comando do botão
     */
    public void actionPerformed(ActionEvent ae) {
        try{
            if(ae.getActionCommand() == "Comecar"){
                repaint(); //evita bugs visuais
                int numP = Integer.parseInt(nP.getText()); //quantidade de pessoas
                int ciclo = Integer.parseInt(nM.getText()); //intevalo de "morte"
                int count = 0;
                jps.setVeri(false);
                jps.setJogo(jogo); //transfere o jogo para a classe josephus
                jps.setNumP(numP); //transfere o numP para a classe josephus
                jps.setCiclo(ciclo); //transfere o ciclo para a classe josephus
                jps.setCount(count); //transfere o contador para a classe josephus
                nM.setEditable(false); //deixa o usuario digitar
                nP.setEditable(false); //deixa o usuario digitar
                if((numP<41 && numP >= ciclo + 1 && numP > 2 && ciclo > 1)){ //Test case para verificar se enquadra nas regras do jogo
                    No aux;
                    jps.inserirPessoas();//insere as pessoas na lista
                    aux = jps.list.getFim();
                    jps.addPessoas(); //adiciona as pessoas no jogo
                    jps.setCel(aux); 
                    
                    try{
                        iniciarAnimacao(); //inicia a animacao
                        
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Algo deu errado", "ERRO", JOptionPane.WARNING_MESSAGE);
                        nM.setEditable(true); //deixa o usuario digitar
                        nP.setEditable(true); //deixa o usuario digitar
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Valores Invalidos", "ERRO", JOptionPane.WARNING_MESSAGE);
                    nM.setEditable(true); //deixa o usuario digitar
                    nP.setEditable(true); //deixa o usuario digitar
                }
                
            }
            if(ae.getActionCommand() == "Pausar"){
                repaint(); //evita bugs visuais
                finalizarAnimacao();
                nM.setEditable(true); //deixa o usuario digitar
                nP.setEditable(true); //deixa o usuario digitar
            } 

        } catch (Exception ee){
            JOptionPane.showMessageDialog(null, "Algo deu errado", "ERRO", JOptionPane.WARNING_MESSAGE);
            nM.setEditable(true); //deixa o usuario digitar
            nP.setEditable(true); //deixa o usuario digitar
        }
    }

    /**
     * classe para fazer a animacao do jogo
     */
    public class Simulacao extends Thread {
        public boolean continuar = false;

        public void run() {
            try {
                // o continuar vai rodar ate acabar o programa. no final da funcao jogar, muda o verificador na classe josephus para true, fazendo o loop parar
                while (continuar == false) {
                    
                    
                    jps.Jogar(numP); //run do jogo
                    sleep(200); // "Animacao"
                    continuar = jps.getVeri(); //quando o veri na classe josephus for verdadeira, o loop ira parar
                }    
                _simular = null;
                jogo.removeAll(); //remove os jogos anteriores
                nM.setEditable(true); //deixa o usuario digitar
                nP.setEditable(true); //deixa o usuario digitar
                botao.setEnabled(true); 
            } catch (InterruptedException e) {
                System.out.println("ERRO INESPERADO");
                System.exit(0);
            }    
        }
    }

    
    
    /**
     * Metodo iniciarAnimacao -
     * comeca a animacao
     */
    public void iniciarAnimacao() {
        jogo.repaint();//evita bugs visuais
        _simular = new Simulacao(); 
        _simular.start(); //comeca a animacao
        //deixa todos os botoes habilitados
        botao.setEnabled(false); 
        finalizar.setEnabled(true);
    }

    /**
     * Metodo finalizarAnimacao - 
     * finaliza a animacao
     */
    public void finalizarAnimacao() {
        jogo.repaint();//evita bugs visuais
        _simular.continuar = true;
        jps.setVeri(true); //coloca o verificador como verdadeiro para parar a animacao
        //deixa todos os botoes habilitados
        botao.setEnabled(true);
        finalizar.setEnabled(true);
        
        _simular = null; //coloca o simular como null
    }
    
}

