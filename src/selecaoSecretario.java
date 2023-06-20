
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class selecaoSecretario extends JPanel{
    private JButton novaConsultaButton;
    private JButton cadastrarButton;
    private JButton listarConsultaButton;
    private JLabel contagemCadastros;
    private JLabel numeroCadastros;

    public selecaoSecretario(JPanel panel,JPanel panel1,JPanel panel2) {
        //construct components
        novaConsultaButton = new JButton("Nova consulta");
        cadastrarButton = new JButton("Cadastrar paciente");
        listarConsultaButton = new JButton("Listar consultas");
        contagemCadastros = new JLabel("Cadastros totais:");
        numeroCadastros = new JLabel("");


        panel.setBounds(0,0,750,475);
        panel1.setBounds(0,0,750,475);
        panel2.setBounds(0,0,750,475);
        panel.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        //adjust size and set layout
        setPreferredSize(new Dimension(750, 475));
        setLayout(null);

        novaConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoSecretario.this.setVisible(false);
                panel.setVisible(true);
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoSecretario.this.setVisible(false);
                panel1.setVisible(true);
            }
        });

        listarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecaoSecretario.this.setVisible(false);
                panel2.setVisible(true);
            }
        });
        //add components
        add(novaConsultaButton);
        add(cadastrarButton);
        add(listarConsultaButton);

        //set component bounds (only needed by Absolute Positioning)
        novaConsultaButton.setBounds(300, 190, 130, 50);
        cadastrarButton.setBounds(75, 190, 145, 50);
        listarConsultaButton.setBounds(510, 190, 130, 50);
        contagemCadastros.setBounds(300,100,100,25);
    }


}
