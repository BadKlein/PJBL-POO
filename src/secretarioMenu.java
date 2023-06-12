import java.awt.*;
import javax.swing.*;

public class secretarioMenu extends JPanel {
    private JButton submit;
    private JButton voltar;
    private JLabel jcomp3;
    private JLabel nomeLabel;
    private JTextField nome;
    private JLabel idadeLabel;
    private JTextField idade;
    private JRadioButton genero1;
    private JLabel generoLabel;
    private JRadioButton genero2;
    private JRadioButton genero3;
    private JTextField cpf;
    private JLabel cpfLabel;
    private JLabel atendimentoTipoLabel;
    private JTextField atendimentoTipo;

    public secretarioMenu() {
        //construct components
        submit = new JButton("Enviar");
        voltar = new JButton("Cancelar");
        jcomp3 = new JLabel("Cadastrar novo paciente ");
        nomeLabel = new JLabel("Nome:");
        nome = new JTextField(5);
        idadeLabel = new JLabel("Idade:");
        idade = new JTextField(5);
        genero1 = new JRadioButton("Masculino");
        generoLabel = new JLabel("Genero:");
        genero2 = new JRadioButton("Feminino");
        genero3 = new JRadioButton("Outro");
        cpf = new JTextField(5);
        cpfLabel = new JLabel("CPF:");
        atendimentoTipoLabel = new JLabel("Direcionamento do atendimento(especialidade):");
        atendimentoTipo = new JTextField(5);

        //adjust size and set layout
        setPreferredSize(new Dimension(950, 570));
        setLayout(null);

        //add components
        add(submit);
        add(voltar);
        add(jcomp3);
        add(nomeLabel);
        add(nome);
        add(idadeLabel);
        add(idade);
        add(genero1);
        add(generoLabel);
        add(genero2);
        add(genero3);
        add(cpf);
        add(cpfLabel);
        add(atendimentoTipoLabel);
        add(atendimentoTipo);

        //set component bounds (only needed by Absolute Positioning)
        submit.setBounds(345, 515, 100, 20);
        voltar.setBounds(475, 515, 140, 20);
        jcomp3.setBounds(380, 15, 200, 25);
        nomeLabel.setBounds(35, 105, 100, 25);
        nome.setBounds(110, 105, 250, 25);
        idadeLabel.setBounds(35, 145, 100, 25);
        idade.setBounds(110, 145, 100, 25);
        genero1.setBounds(100, 180, 85, 25);
        generoLabel.setBounds(35, 180, 100, 25);
        genero2.setBounds(195, 180, 80, 25);
        genero3.setBounds(285, 180, 100, 25);
        cpf.setBounds(110, 215, 250, 25);
        cpfLabel.setBounds(35, 215, 100, 25);
        atendimentoTipoLabel.setBounds(30, 325, 300, 25);
        atendimentoTipo.setBounds(305, 325, 300, 25);
    }
}

