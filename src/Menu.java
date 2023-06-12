import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Objects;
import javax.swing.*;

public class Menu extends JFrame {
    private JButton medico;
    private JButton enfermagem;
    private JButton secretaria;
    private JButton administrador;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JPanel teste1 = new JPanel();
    private JPanel teste2 = new JPanel();
    JPanel secretarioMenu = new secretarioMenu();

    public Menu(String title) {
        this.setPreferredSize(new Dimension(750,475));
        this.setTitle(title);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible (true);
        //construct components
        medico = new JButton ("Medico(a)");
        enfermagem = new JButton ("Enfermeiro(a)");
        secretaria = new JButton ("Secretario(a)");
        administrador = new JButton ("Administrador");
        jcomp5 = new JLabel ("Como deseja acessar o sistema?");
        jcomp6 = new JLabel ("Lembre-se, o cadastro de novos funcionarios deve ser feito pelo administrador");
        jcomp6.setForeground(Color.red);
        //adjust size and set layout

        setPreferredSize (new Dimension (740, 364));
        setLayout (null);
        medico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirInput();
            }



        });
        enfermagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirInput();
            }



        });
        secretaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secretarioMenu.setVisible(true);
                Menu.this.setContentPane(secretarioMenu);
            }



        });
        administrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirInput();
            }



        });
        //add components
        add (medico);
        add (enfermagem);
        add (secretaria);
        add (administrador);
        add (jcomp5);
        add (jcomp6);

        //set component bounds (only needed by Absolute Positioning)
        medico.setBounds (405, 155, 125, 50);
        enfermagem.setBounds (220, 155, 125, 50);
        secretaria.setBounds (45, 155, 125, 50);
        administrador.setBounds (580, 155, 125, 50);
        jcomp5.setBounds (270, 30, 400, 50);
        jcomp6.setBounds (150, 325, 500, 25);
    }
    private void trocaPainel(JPanel inicial,JPanel alvo){
        inicial.setVisible(false);
        alvo.setVisible(true);
    }
    private void exibirInput(){
        JFrame input = new JFrame();
        input.setVisible(true);
        input.setSize(new Dimension(300,150));
        input.setLocationRelativeTo(null);
        String csvFile = "C:\\Users\\alwaystiredbtw\\pjbl-poo\\PJBL-POO\\src\\usuarios.csv";

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());
        JLabel lblCodigo = new JLabel("Digite o código de autenticação:");
        JTextField txtCodigo = new JTextField(15);
        JButton btnEnviar = new JButton("Enviar");

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                boolean isUsuarioValido = verificarFuncionario(csvFile, codigo);
                if (isUsuarioValido){
                    JOptionPane.showMessageDialog(Menu.this, "Autenticado");
                    input.setVisible(false);
                    Menu.this.add(secretarioMenu);

                }
                else {
                    JOptionPane.showMessageDialog(Menu.this, "Codigo nao existente, contate o responsavel.");
                }
            }
        });


        painel.add(lblCodigo);
        painel.add(txtCodigo);
        painel.add(btnEnviar);
        input.add(painel);

    }
    public boolean verificarFuncionario(String arquivoCSV, String input) {
        verificarInput(input);
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String line;
            boolean found = false;
            // Lê cada linha do arquivo CSV
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Verifica se o código de autenticação corresponde ao input
                if (data.length == 3 && data[2].trim().equals(input)) {
                    found = true;
                    break;
                }
            }

            return found;
        }  catch (IOException e) {
            throw new exceptionNull("");
        }
    }
    public void verificarInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new exceptionNull("O input não pode ser vazio ou nulo!");
        }
}

}
