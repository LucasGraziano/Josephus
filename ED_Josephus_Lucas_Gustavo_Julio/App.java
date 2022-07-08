import GUI.JosephusGUI;

/**
 * App inicia o "Jogo" 
 * 
 * @author Lucas Graziano | Julio Cesar | Gustavo Scacchetti
 * @version 10/06/2022 - 4:35
 */
public class App
{
    /**
     * main - aqui que eh iniciado o programa
     */
    public static void main(String args[])
    {
        JosephusGUI jos = new JosephusGUI("Josephus", 700, 700);
        jos.setVisible(true); //liga a janela
    }

    
}
