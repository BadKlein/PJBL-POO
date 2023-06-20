import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class novaConsulta extends JPanel {
    private JLabel jcomp1;
    private JButton voltarBtn;
    private JButton enviarBtn;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JComboBox pacienteDrop;
    private JComboBox medicodrop;
    private JTextField jcomp9;


    public novaConsulta(JPanel panel) {
        //construct preComponents

        //construct components
        jcomp1 = new JLabel("Nova consulta");
        voltarBtn = new JButton("Voltar");
        enviarBtn = new JButton("Enviar");
        jcomp4 = new JLabel("Paciente:");
        jcomp5 = new JLabel("Medico responsavel:");
        jcomp6 = new JLabel("Data da consulta:");
        pacienteDrop = new JComboBox();
        medicodrop = new JComboBox();
        jcomp9 = new JTextField(5);

        for(Pessoa p : Menu.pacientes){
            pacienteDrop.addItem(p.getNome());
        }
        for(Medico m : Menu.medicos){
            medicodrop.addItem(m.getNome());
        }

        //adjust size and set layout
        setPreferredSize(new Dimension(750, 475));
        setLayout(null);

        voltarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novaConsulta.this.setVisible(false);
                panel.setVisible(true);
            }
        });
        enviarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConsulta();
                novaConsulta.this.setVisible(false);
                panel.setVisible(true);



            }

        });
        //add components
        add(jcomp1);
        add(voltarBtn);
        add(enviarBtn);
        add(jcomp4);
        add(jcomp5);
        add(jcomp6);
        add(pacienteDrop);
        add(medicodrop);
        add(jcomp9);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(325, 20, 111, 25);
        voltarBtn.setBounds(270, 350, 100, 25);
        enviarBtn.setBounds(395, 350, 100, 25);
        jcomp4.setBounds(265, 105, 100, 25);
        jcomp5.setBounds(235, 155, 119, 25);
        jcomp6.setBounds(255, 205, 100, 25);
        pacienteDrop.setBounds(375, 105, 175, 25);
        medicodrop.setBounds(375, 155, 176, 25);
        jcomp9.setBounds(375, 205, 100, 25);
    }

    public void criarConsulta() {
        String filePath = "C:/Users/leokl/IdeaProjects/PJBL-POO/src/consulta.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder fileContent = new StringBuilder();

            // Ler o arquivo original e armazenar o conteúdo em memória
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }

            // Adicionar nova linha com tipo, nome e código
            fileContent.append(pacienteDrop.getSelectedItem()).append(",").append(medicodrop.getSelectedItem()).append(",").append(jcomp9.getText());
            // Sobrescrever o arquivo original com as alterações
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(fileContent.toString());
                JOptionPane.showMessageDialog(novaConsulta.this, "Consulta registrada");


            } catch (IOException f) {
                JOptionPane.showMessageDialog(novaConsulta.this, "Ocorreu algum erro");
            }

        } catch (IOException f) {
            System.out.println("Erro ao ler o arquivo CSV: " + f.getMessage());

        }

    }
}
