
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class medicoMenu extends JPanel {
    private JLabel labelAtendimento;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JTextField txtRelato;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JLabel jcomp13;
    private JTextArea txtObservacoes;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JTextField txtDiagnostico;
    private JTextField txtMedicacao;
    private JLabel jcomp19;
    private JLabel jcomp20;
    private JLabel jcomp21;
    private JLabel jcomp22;
    private JLabel jcomp23;
    private JLabel jcomp24;
    private JRadioButton encaminhamentoSim;
    private JRadioButton encaminhamentoNao;
    private JTextField txtEspecialidade;
    private JLabel jcomp28;
    private JButton btnConcluir;






    public medicoMenu(JPanel panel) {
        //construct components
        labelAtendimento = new JLabel ("Novo atendimento");
        jcomp2 = new JLabel ("Dados do paciente:");
        jcomp3 = new JLabel ("Nome:");
        jcomp4 = new JLabel ("Genero:");
        jcomp5 = new JLabel ("Idade:");
        jcomp6 = new JLabel ("nameInsert");
        jcomp7 = new JLabel ("generoInsert");
        jcomp8 = new JLabel ("idadeInsert");
        jcomp9 = new JLabel ("Anamnese:");
        txtRelato = new JTextField (5);
        jcomp11 = new JLabel ("Relato do paciente:");
        jcomp12 = new JLabel ("");
        jcomp13 = new JLabel ("Observacoes:");
        txtObservacoes = new JTextArea (5, 5);
        jcomp15 = new JLabel ("Medicacao indicada:");
        jcomp16 = new JLabel ("Diagnostico parcial:");
        txtDiagnostico = new JTextField (5);
        txtMedicacao = new JTextField (5);
        jcomp19 = new JLabel ("Data/Hora da consulta:");
        jcomp20 = new JLabel ("Data:");
        jcomp21 = new JLabel ("Horario:");
        jcomp22 = new JLabel ("horarioInsert");
        jcomp23 = new JLabel ("dataInsert");
        jcomp24 = new JLabel ("Encaminhamento a especialista?");
        encaminhamentoSim = new JRadioButton ("Sim");
        encaminhamentoNao = new JRadioButton ("Nao");
        txtEspecialidade = new JTextField (5);
        jcomp28 = new JLabel ("Area de especialidade indicada:");
        btnConcluir = new JButton ("Concluir");

        //set components properties
        txtEspecialidade.setEnabled (false);

        txtEspecialidade.setEnabled(encaminhamentoSim.isSelected());

        //adjust size and set layout
        setPreferredSize (new Dimension (750, 475));
        setLayout (null);

        //add components
        add (labelAtendimento);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (txtRelato);
        add (jcomp11);
        add (jcomp12);
        add (jcomp13);
        add (txtObservacoes);
        add (jcomp15);
        add (jcomp16);
        add (txtDiagnostico);
        add (txtMedicacao);
        add (jcomp19);
        add (jcomp20);
        add (jcomp21);
        add (jcomp22);
        add (jcomp23);
        add (jcomp24);
        add (encaminhamentoSim);
        add (encaminhamentoNao);
        add (txtEspecialidade);
        add (jcomp28);
        add (btnConcluir);
        //set component bounds (only needed by Absolute Positioning)
        labelAtendimento.setBounds (340, 10, 110, 26);
        jcomp2.setBounds (5, 40, 120, 25);
        jcomp3.setBounds (15, 75, 45, 25);
        jcomp4.setBounds (240, 75, 100, 25);
        jcomp5.setBounds (385, 75, 40, 25);
        jcomp6.setBounds (65, 75, 100, 25);
        jcomp7.setBounds (290, 75, 80, 25);
        jcomp8.setBounds (425, 75, 100, 25);
        jcomp9.setBounds (360, 135, 125, 25);
        txtRelato.setBounds (20, 240, 240, 90);
        jcomp11.setBounds (10, 215, 115, 25);
        jcomp12.setBounds (215, 150, 100, 25);
        jcomp13.setBounds (10, 340, 100, 25);
        txtObservacoes.setBounds (20, 365, 240, 90);
        jcomp15.setBounds (280, 340, 122, 25);
        jcomp16.setBounds (280, 215, 116, 26);
        txtDiagnostico.setBounds (285, 240, 240, 90);
        txtMedicacao.setBounds (285, 365, 240, 90);
        jcomp19.setBounds (505, 40, 134, 25);
        jcomp20.setBounds (690, 75, 34, 25);
        jcomp21.setBounds (560, 75, 49, 25);
        jcomp22.setBounds (610, 75, 76, 25);
        jcomp23.setBounds (725, 75, 100, 25);
        jcomp24.setBounds (575, 210, 197, 25);
        encaminhamentoSim.setBounds (595, 270, 49, 25);
        encaminhamentoNao.setBounds (645, 270, 53, 25);
        txtEspecialidade.setBounds (540, 365, 240, 45);
        jcomp28.setBounds (530, 340, 185, 25);
        btnConcluir.setBounds (610, 425, 100, 25);
    }
}
