import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;



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



    public secretarioMenu(JPanel panel) {
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
      
        // Lendo as informacoes que ja estao salvas no csv para instanciar os objetos nos ArrayLists
        secretarioMenu.lerCSVPaciente();
        secretarioMenu.lerCSVMedico();



        //adjust size and set layout
        setPreferredSize(new Dimension(750, 475));
        setLayout(null);

        //add components


        //set component bounds (only needed by Absolute Positioning)
        submit.setBounds(235, 395, 100, 25);
        voltar.setBounds(365, 395, 100, 25);
        jcomp3.setBounds(295, 15, 200, 25);
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
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero;
                if (genero1.isSelected()) {
                    genero = "masculino";
                } else if (genero2.isSelected()) {
                    genero = "feminino";
                } else {
                    genero = "outro";
                }

                Menu.pacientes.add(new Paciente(nome.getText(), cpf.getText(), genero, idade.getText(), atendimentoTipo.getText()));


                escreverCSV(nome.getText(), cpf.getText(), genero, idade.getText(), atendimentoTipo.getText());
                secretarioMenu.this.setVisible(false);
                panel.setVisible(true);

            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secretarioMenu.this.setVisible(false);
                panel.setVisible(true);
            }
        });


    }



    // Escreve no CSV do paciente novos pacientes que forem registrados
    public void escreverCSV(String nome, String cpf, String genero, String idade, String atendimentoTipo) {
        String filePath = "C:/Users/leokl/IdeaProjects/PJBL-POO/src/paciente.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder fileContent = new StringBuilder();

            // Ler o arquivo original e armazenar o conteúdo em memória
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }

            // Adicionar nova linha com tipo, nome e código

            fileContent.append(nome).append(",").append(cpf).append(",").append(genero).append(",").append(idade).append(",").append(atendimentoTipo).append(System.lineSeparator());
            Menu.pacientes.add(new Paciente(nome, cpf, genero, idade, atendimentoTipo));

            // Sobrescrever o arquivo original com as alterações
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(fileContent.toString());
                JOptionPane.showMessageDialog(secretarioMenu.this, "Paciente registrado");
            } catch (IOException f) {
                JOptionPane.showMessageDialog(secretarioMenu.this, "Ocorreu algum erro");
            }

        } catch (IOException f) {
            System.out.println("Erro ao ler o arquivo CSV: " + f.getMessage());

        }

    }
    // Leitura do CSV do medico que instancia todos os pacientes salvos em um ArrayList
    public static void lerCSVPaciente() {
        String csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\paciente.csv";
        String csvDelimiter = ",";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Lê o cabeçalho do arquivo CSV
            String headerLine = br.readLine();
            String[] headers = headerLine.split(csvDelimiter);

            // Índices das colunas do arquivo CSV
            int nomeIndex = findHeaderIndex(headers, "Nome");
            int cpfIndex = findHeaderIndex(headers, "CPF");
            int generoIndex = findHeaderIndex(headers, "Gênero");
            int idadeIndex = findHeaderIndex(headers, "Idade");
            int atendimentoTipoIndex = findHeaderIndex(headers, "AtendimentoTipo");

            // Lê as linhas do arquivo CSV
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Extrai os dados de cada campo
                String nome = fields[nomeIndex];
                String cpf = fields[cpfIndex];
                String genero = fields[generoIndex];
                String idade = (fields[idadeIndex]);
                String atendimentoTipo = fields[atendimentoTipoIndex];

                // Instancia o objeto Paciente com os atributos lidos (CHAMADA POLIFORMICA)
                Menu.pacientes.add(new Paciente(nome, cpf, genero, idade, atendimentoTipo));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // Leitura do CSV do medico que instancia todos os medicos salvos em um ArrayList
    public static void lerCSVMedico() {
        String csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\medico.csv";

        String csvDelimiter = ",";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Lê o cabeçalho do arquivo CSV
            String headerLine = br.readLine();
            String[] headers = headerLine.split(csvDelimiter);

            // Índices das colunas do arquivo CSV
            int nomeIndex = findHeaderIndex(headers, "Nome");
            int cpfIndex = findHeaderIndex(headers, "CPF");
            int idIndex = findHeaderIndex(headers, "ID");
            int turnoIndex = findHeaderIndex(headers, "Turno");
            int crmIndex = findHeaderIndex(headers, "CRM");


            // Lê as linhas do arquivo CSV
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Extrai os dados de cada campo
                String nome = fields[nomeIndex];
                String cpf = fields[cpfIndex];

                String id = fields[idIndex];
                String turno = (fields[turnoIndex]);
                String crm = fields[crmIndex];

                // Instancia o objeto Paciente com os atributos lidos
                Menu.medicos.add(new Medico(nome, cpf, id, turno, crm));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Encontra o índice do cabeçalho no array de headers
    private static int findHeaderIndex(String[] headers, String header) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(header)) {
                return i;
            }
        }
        return 0;
    }
}

