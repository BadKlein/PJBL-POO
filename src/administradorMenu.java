import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;


public class administradorMenu extends JPanel {
    private JButton enviar;
    private JButton voltar;
    private JLabel jcomp3;
    private JLabel tipo;
    private JTextField txtTipo;
    private JTextField txtNome;
    private JLabel jcomp7;
    private JTextField txtCodigo;
    private JLabel jcomp9;



    public administradorMenu(JPanel panel) {
        //construct components
        enviar = new JButton("Enviar");
        voltar = new JButton("Voltar");
        jcomp3 = new JLabel("Cadastrar funcionario");
        tipo = new JLabel("Tipo:");
        txtTipo = new JTextField(5);
        txtNome = new JTextField(5);
        jcomp7 = new JLabel("Nome:");
        txtCodigo = new JTextField(5);
        jcomp9 = new JLabel("Codigo unico:");

        //adjust size and set layout
        setPreferredSize(new Dimension(750, 475));
        setLayout(null);

        enviar.setBounds(235, 395, 100, 25);
        voltar.setBounds(365, 395, 100, 25);
        jcomp3.setBounds(295, 30, 130, 25);
        tipo.setBounds(30, 90, 100, 25);
        txtTipo.setBounds(110, 90, 200, 25);
        txtNome.setBounds(110, 140, 200, 25);
        jcomp7.setBounds(30, 140, 100, 25);
        txtCodigo.setBounds(110, 190, 200, 25);
        jcomp9.setBounds(30, 190, 100, 25);

        //add components
        add(enviar);
        add(voltar);
        add(jcomp3);
        add(tipo);
        add(txtTipo);
        add(txtNome);
        add(jcomp7);
        add(txtCodigo);
        add(jcomp9);

        //set component bounds (only needed by Absolute Positioning)

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = txtTipo.getText();
                String nome = txtNome.getText();
                String codigo = txtCodigo.getText();
                String filePath = "C:/Users/leokl/IdeaProjects/PJBL-POO/src/administrador.csv";

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder fileContent = new StringBuilder();

                    // Ler o arquivo original e armazenar o conteúdo em memória
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line).append(System.lineSeparator());
                    }

                    // Adicionar nova linha com tipo, nome e código
                    fileContent.append(tipo).append(",").append(nome).append(",").append(codigo).append(System.lineSeparator());

                    // Sobrescrever o arquivo original com as alterações
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(fileContent.toString());
                        JOptionPane.showMessageDialog(administradorMenu.this, "Funcionario registrado");
                        administradorMenu.this.setVisible(false);
                        panel.setVisible(true);
                    } catch (IOException f) {
                        JOptionPane.showMessageDialog(administradorMenu.this, "Ocorreu algum erro");
                    }

                } catch (IOException f) {
                    System.out.println("Erro ao ler o arquivo CSV: " + f.getMessage());

                }
            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administradorMenu.this.setVisible(false);
                panel.setVisible(true);
            }

        });
    }
}

