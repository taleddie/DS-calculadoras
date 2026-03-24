import javax.swing.*;
import java.awt.*;

public class Calc1 {

    private JFrame janela;
    private JTextField visorEquacao;
    private JTextField visorAtual;

    private double resultado=0;

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

        JPanel painelBotoes = new JPanel(new GridLayout(4,4, 5, 5));

        String[] textos = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String texto : textos){
            JButton btn = new JButton(texto);
            btn.addActionListener(e -> tratarClique(texto));
            painelBotoes.add(btn);
        }

        janela.add(painelBotoes);

        janela.setVisible(true); //deixar por ultimo

    }

    private void tratarClique(String comando){
        calcular(Double.parseDouble(visorAtual.getText()), comando);

        if ("0123456789".contains(comando)) {
            visorAtual.setText(comando);
        } else if ("+-*/=".contains(comando)){
            if (comando.equals("=")) {
                visorEquacao.setText(visorEquacao.getText() + visorAtual.getText() + " =");
                visorAtual.setText(String.valueOf(resultado));
            } else {
                visorEquacao.setText(visorEquacao.getText() + visorAtual.getText() + " " + comando + "  ");
            }
        }
    }

    private void calcular(double valor, String operador){
        if (operador.equals("+")){
            resultado += valor;
        } else if (operador.equals("-")){
            resultado -= valor;
        } else if (operador.equals("*")){
            resultado *= valor;
        } else if (operador.equals("/")){
            resultado /= valor;
        }
    }

}
