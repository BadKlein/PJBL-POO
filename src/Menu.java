import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

public class Menu extends JFrame {
    private JButton medico;
    private JButton enfermagem;
    private JButton secretaria;
    private JButton administrador;
    private JLabel jcomp5;
    private JLabel jcomp6;


    public static ArrayList<Pessoa> pacientes = new ArrayList<Pessoa>();
    public static ArrayList<Medico> medicos = new ArrayList<Medico>();


    JPanel menu = new JPanel();

    JPanel administradorMenu= new administradorMenu(menu);

    JPanel secretarioMenu = new secretarioMenu(menu);
    JPanel listarConsulta = new listarConsulta(menu);
    JPanel novaConsulta = new novaConsulta(menu);
    JPanel selecaoSecretario = new selecaoSecretario(novaConsulta,secretarioMenu,listarConsulta);


    public Menu(String title) {
        this.setPreferredSize(new Dimension(750,475));
        this.setTitle(title);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible (true);
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setBounds(0, 0, 750, 475);
        selecaoSecretario.setBounds(0,0,750,475);
        selecaoSecretario.setVisible(false);
        administradorMenu.setBounds(0,0,750,475);
        administradorMenu.setVisible(false);
        medicoMenu.setVisible(false);
        medicoMenu.setBounds(0,0,750,475);;




        //construct components

                secretaria = new JButton ("Secretario(a)");
        administrador = new JButton ("Administrador");
        jcomp5 = new JLabel ("Como deseja acessar o sistema?");
        jcomp6 = new JLabel ("Lembre-se, o cadastro de novos funcionarios deve ser feito pelo administrador");
        jcomp6.setForeground(Color.red);
        //adjust size and set layout

        secretaria.setBounds (220, 155, 125, 50);
        administrador.setBounds (405, 155, 125, 50);
        jcomp5.setBounds (270, 30, 400, 50);
        jcomp6.setBounds (150, 325, 500, 25);

        setPreferredSize (new Dimension (750, 475));
        setLayout (null);


        secretaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                exibirInput(selecaoSecretario, 2);


            }



        });
        administrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirInput(administradorMenu, 1);
            }



        });

        //add components

        menu.add (secretaria);
        menu.add (administrador);
        menu.add (jcomp5);
        menu.add (jcomp6);
        add(menu);
        add(selecaoSecretario);
        add(administradorMenu);

        add(secretarioMenu);
        add(selecaoSecretario);
        add(listarConsulta);
        add(novaConsulta);

        //set component bounds (only needed by Absolute Positioning)

    }

    // Exibir painel onde o usuario digita codigo de autenticacao

    private void exibirInput(JPanel panelNovo, int tipoUsuario){

        JFrame input = new JFrame();
        input.setVisible(true);
        input.setSize(new Dimension(300,150));
        input.setLocationRelativeTo(null);
        String csvFile;
        switch (tipoUsuario){
            case 1:
                csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\administrador.csv";
                break;
            case 2:
                csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\secretario.csv";
                break;
            case 3:
                csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\enfermeiro.csv";
                break;
            default:
                csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\medico.csv";
                break;

        }



        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());
        JLabel lblCodigo = new JLabel("Digite o código de autenticação:");
        JTextField txtCodigo = new JTextField(15);
        JButton btnEnviar = new JButton("Enviar");

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                if (codigo.isEmpty()){
                    JOptionPane.showMessageDialog(Menu.this, "O campo codigo nao pode ficar vazio");
                }
                else {
                    boolean isUsuarioValido;
                    switch (tipoUsuario) {
                        case 1:
                            isUsuarioValido = verificarAdministrador(csvFile, codigo);
                            break;
                        case 2:
                            isUsuarioValido = verificarSecretaria(csvFile, codigo);
                            break;
                        default:
                            isUsuarioValido = verificarMedico(csvFile, codigo);
                            break;

                    }
                    if (isUsuarioValido) {
                        JOptionPane.showMessageDialog(Menu.this, "Autenticado");
                        input.setVisible(false);
                        menu.setVisible(false);
                        panelNovo.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(Menu.this, "Codigo nao existente, contate o responsavel.");
                    }
                }
            }
        });


        painel.add(lblCodigo);
        painel.add(txtCodigo);
        painel.add(btnEnviar);
        input.add(painel);

    }

    // Verificar se codigo de autenticacao inserido existe
    public boolean verificarMedico(String arquivoCSV, String input) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String line;
            boolean found = false;
            // Lê cada linha do arquivo CSV
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Verifica se o código de autenticação corresponde ao input
                if (data.length == 5 && data[3].trim().equals(input)) {
                    found = true;
                    break;
                }
            }

            return found;
        }  catch (IOException e) {
            throw new exceptionNull("Ocorreu algum erro, não foi possível autenticar usuário");
        }
    }
    public boolean verificarSecretaria(String arquivoCSV, String input) {

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
            throw new exceptionNull("Ocorreu algum erro, não foi possível autenticar usuário");
        }
    }
    public boolean verificarAdministrador(String arquivoCSV, String input) {

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String line;
            boolean found = false;
            // Lê cada linha do arquivo CSV
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Verifica se o código de autenticação corresponde ao input

                if (data.length == 2 && data[1].trim().equals(input)) {

                    found = true;
                    break;
                }
            }

            return found;
        } catch (IOException e) {
            throw new exceptionNull("Ocorreu algum erro, não foi possível autenticar usuário");
        }

    }




}
