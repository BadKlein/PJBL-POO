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
    private JLabel jcomp1;
    private JLabel lblNome;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtID;
    private JTextField txtTurno;
    private JTextField txtCRM;
    private JButton enviar;
    private JButton voltar;





    public administradorMenu(JPanel panel) {
        jcomp1 = new JLabel ("Cadastrar medico");
        lblNome = new JLabel ("Nome:");
        jcomp3 = new JLabel ("CPF:");
        jcomp4 = new JLabel ("ID:");
        jcomp5 = new JLabel ("Turno:");
        jcomp6 = new JLabel ("CRM:");
        txtNome = new JTextField (5);
        txtCPF = new JTextField (5);
        txtID = new JTextField (5);
        txtTurno = new JTextField (5);
        txtCRM = new JTextField (5);
        enviar = new JButton ("Enviar");
        voltar = new JButton ("Cancelar");

        //adjust size and set layout
        setPreferredSize (new Dimension (755, 472));
        setLayout (null);

        //add components
        add (jcomp1);
        add (lblNome);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (txtNome);
        add (txtCPF);
        add (txtID);
        add (txtTurno);
        add (txtCRM);
        add (enviar);
        add (voltar);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (315, 25, 111, 25);
        lblNome.setBounds (50, 80, 46, 25);
        jcomp3.setBounds (55, 135, 50, 25);
        jcomp4.setBounds (60, 190, 25, 25);
        jcomp5.setBounds (50, 245, 48, 25);
        jcomp6.setBounds (60, 295, 100, 25);
        txtNome.setBounds (115, 85, 200, 25);
        txtCPF.setBounds (115, 140, 150, 25);
        txtID.setBounds (115, 195, 100, 25);
        txtTurno.setBounds (115, 245, 125, 25);
        txtCRM.setBounds (115, 300, 150, 25);
        enviar.setBounds (255, 390, 100, 25);
        voltar.setBounds (400, 390, 100, 25);
        //set component bounds (only needed by Absolute Positioning)

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String CPF = txtCPF.getText();
                String ID = txtID.getText();
                String turno = txtTurno.getText();
                String crm = txtCRM.getText();
                String filePath = "C:/Users/leokl/IdeaProjects/PJBL-POO/src/medico.csv";


                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder fileContent = new StringBuilder();

                    // Ler o arquivo original e armazenar o conteúdo em memória
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line).append(System.lineSeparator());
                    }

                    // Adicionar nova linha com tipo, nome e código
                    fileContent.append(nome).append(",").append(CPF).append(",").
                            append(ID).append(",").append(turno).append(",").append(crm).append(System.lineSeparator());

                    // Sobrescrever o arquivo original com as alterações
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(fileContent.toString());
                        JOptionPane.showMessageDialog(administradorMenu.this, "Médico registrado");
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

