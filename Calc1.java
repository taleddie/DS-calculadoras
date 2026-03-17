import javax.swing.*;
import java.awt.*;

public class Calc1 {

    private JFrame janela;
    private JTextField visorEquacao;
    private JTextField visorAtual;

    public Calc1(){
        janela = new JFrame();

        janela.setSize(350, 450);
        janela.setTitle("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        visorEquacao = new JTextField();
        visorEquacao.setEditable(false);
        visorEquacao.setHorizontalAlignment(JTextField.RIGHT);

        visorAtual = new JTextField("0");
        visorAtual.setEditable(false);
        visorAtual.setHorizontalAlignment(JTextField.RIGHT);
        Font font = new Font("Arial", Font.BOLD, 28);
        visorAtual.setFont(font);

        JPanel painelVisores = new JPanel(new GridLayout(2, 1));
        painelVisores.add(visorEquacao);
        painelVisores.add(visorAtual);

        janela.add(painelVisores, BorderLayout.NORTH);

        janela.setVisible(true); //deixar por ultimo

    }
}
