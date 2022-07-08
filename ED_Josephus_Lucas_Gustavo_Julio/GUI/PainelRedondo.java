package GUI;
import java.awt.*;
import javax.swing.*;


public class PainelRedondo extends JPanel{

    Color backgroundColor;
    int PontaDoRaio = 15;
   
     /**
     * Construtor PainelRedondo
     * @param layout <- layout do objeto criado
     * @param raio <- raio do circulo
     * Aqui eh onde acontece os layouts redondos e prints redondos
     */public PainelRedondo(LayoutManager layout, int raio) {
        super(layout);
        
        PontaDoRaio = raio;
    }
   
    /**
     * Construtor PainelRedondo
     * @param layout <- layout do objeto criado
     * @param raio <- raio do circulo
     * @param bgColor <- cor do Background
     * Aqui eh onde acontece os layouts redondos e prints redondos
     */public PainelRedondo(LayoutManager layout, int raio, Color bgColor) {
        super(layout);
        
        PontaDoRaio = raio;
        backgroundColor = bgColor;
    }
    
    /**
     * Construtor PainelRedondo
     * @param raio <- raio do circulo
     * Aqui eh onde acontece os layouts redondos e prints redondos
     */public PainelRedondo(int raio) {
        super();
        
        PontaDoRaio = raio;
    }

    /**
     * Construtor PainelRedondo
     * @param raio <- raio do circulo
     * @param bgColor <- cor do Background
     * Aqui eh onde acontece os layouts e prints redondos
     */public PainelRedondo(int raio, Color bgColor) {
        super();
        
        PontaDoRaio = raio;
        backgroundColor = bgColor;
    }

    
    @Override

    /**
     * paintComponent
     * 
     * - aqui sera a edicao do personagem
     * 
     * @param g - parte grafica da "Pessoa"
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(PontaDoRaio, PontaDoRaio);
        int largura = getWidth();
        int altura = getHeight();
        Graphics2D graficos = (Graphics2D) g;
        graficos.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //desenha os paineis com bordas
        if (backgroundColor != null) {
            graficos.setColor(backgroundColor);
        } else {
            graficos.setColor(getBackground());
        }
        graficos.fillRoundRect(0, 0, largura-1, altura-1, arcs.width, arcs.height); //paint background
        graficos.setColor(getForeground());
        graficos.drawRoundRect(0, 0, largura-1, altura-1, arcs.width, arcs.height); //paint border
    }
} 
