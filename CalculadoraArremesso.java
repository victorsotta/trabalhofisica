import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraArremesso extends JFrame {

    // Declaração dos campos de texto e labels conforme o rascunho
    JTextField campo_angulo, campo_d1, campo_d2, campo_h1, campo_h2;
    JLabel txt_resul;

    // Função construtora para montar a interface e os elementos na tela
    public CalculadoraArremesso() {
        setTitle("Interface de Calculo"); 
        setSize(500, 500); 
        setDefaultCloseOperation(3); // EXIT_ON_CLOSE
        setLocationRelativeTo(null);
        setLayout(null); // Layout nulo para posicionar manualmente como no desenho [cite: 27, 28]

        // --- TITULO ---
        JLabel titulo = new JLabel("Calc. de Arremesso");
        titulo.setBounds(150, 20, 200, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo);

        // --- CAMPO DO ANGULO ---
        JLabel l1 = new JLabel("Angulo:");
        l1.setBounds(160, 70, 60, 25);
        add(l1);
        
        campo_angulo = new JTextField();
        campo_angulo.setBounds(220, 70, 80, 25);
        add(campo_angulo);

        // --- POSIÇÕES D1 E H1 ---
        JLabel ld1 = new JLabel("d1:");
        ld1.setBounds(50, 120, 30, 25);
        add(ld1);
        campo_d1 = new JTextField();
        campo_d1.setBounds(80, 120, 100, 30); 
        add(campo_d1);

        JLabel lh1 = new JLabel("h1:");
        lh1.setBounds(250, 120, 30, 25);
        add(lh1);
        campo_h1 = new JTextField();
        campo_h1.setBounds(280, 120, 100, 30);
        add(campo_h1);

        // --- POSIÇÕES D2 E H2 ---
        JLabel ld2 = new JLabel("d2:");
        ld2.setBounds(50, 170, 30, 25);
        add(ld2);
        campo_d2 = new JTextField();
        campo_d2.setBounds(80, 170, 100, 30);
        add(campo_d2);

        JLabel lh2 = new JLabel("h2:");
        lh2.setBounds(250, 170, 30, 25);
        add(lh2);
        campo_h2 = new JTextField();
        campo_h2.setBounds(280, 170, 100, 30);
        add(campo_h2);

        // --- BOTAO CALCULAR ---
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 240, 280, 60); 
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 20));
        add(btnCalcular);

        // --- BOTAO RESET ---
        JButton btnReset = new JButton("reset");
        btnReset.setBounds(160, 310, 160, 40);
        add(btnReset);

        // EXIBIÇÃO DO RESULTADO
        txt_resul = new JLabel("Velocidade Inicial: ...");
        txt_resul.setBounds(100, 370, 300, 30);
        add(txt_resul);

        // Ação do botão calcular
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executarCalculoFisico();
            }
        });

        // Ação do botão reset
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparDadosDigitados();
            }
        });
    }

    // Calcular as componentes horizontal e vertical da força e a velocidade inicial
    private void executarCalculoFisico() {
        try {
            // Pegando valores dos inputs [cite: 15, 16, 20]
            double a = Double.parseDouble(campo_angulo.getText());
            double d1 = Double.parseDouble(campo_d1.getText());
            double d2 = Double.parseDouble(campo_d2.getText());
            double h1 = Double.parseDouble(campo_h1.getText());
            double h2 = Double.parseDouble(campo_h2.getText());

            double g = 32.17; // Gravidade em ft/s^2 [cite: 13]
            double x = d2 - d1; // Distancia horizontal total [cite: 13]
            double y = h2 - h1; // Diferenca de altura [cite: 13]
            
            // Converter angulo para radiano de forma manual
            double rad = (a * 3.14159) / 180; 

            // Aplicar a formula do lancamento obliquo para achar v0
            double cosPart = Math.pow(Math.cos(rad), 2);
            double tanPart = (x * Math.tan(rad)) - y;
            
            double resultado_v = Math.sqrt((g * x * x) / (2 * cosPart * tanPart));

            // Verificar se o valor e valido ou impossivel
            if (Double.isNaN(resultado_v)) {
                txt_resul.setText("Erro: Lancamento impossivel");
            } else {
                txt_resul.setText("Velocidade Inicial: " + String.format("%.2f", resultado_v) + " ft/s");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Coloque numeros!");
        }
    }

    // Limpar todos os campos de texto e resetar a frase de resultado
    private void limparDadosDigitados() {
        campo_angulo.setText("");
        campo_d1.setText("");
        campo_d2.setText("");
        campo_h1.setText("");
        campo_h2.setText("");
        txt_resul.setText("Velocidade Inicial: ...");
    }

    // Iniciar o programa e tornar a janela visivel
    public static void main(String[] args) {
        new CalculadoraArremesso().setVisible(true);
    }
}