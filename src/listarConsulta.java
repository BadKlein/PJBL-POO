import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.*;

public class listarConsulta extends JPanel {
    private JLabel jcomp1;
    private JButton jcomp2;
    private JList listaPac;

    public listarConsulta(JPanel panel) {



        //construct components
        jcomp1 = new JLabel("Lista de consultas");
        jcomp2 = new JButton("Voltar");
        ArrayList<String> k = new ArrayList<>();
        lerConsultaCSV(k);
        k.remove(0);
        listaPac = new JList(k.toArray());



        jcomp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarConsulta.this.setVisible(false);
                panel.setVisible(true);
            }
        });
        //set components properties
        listaPac.setToolTipText("lista");

        //adjust size and set layout
        setPreferredSize(new Dimension(750, 475));
        setLayout(null);

        //add components
        add(jcomp1);
        add(jcomp2);
        add(listaPac);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(325, 20, 111, 25);
        jcomp2.setBounds(340, 350, 100, 25);
        listaPac.setBounds(135, 80, 500, 300);
    }

    public void lerConsultaCSV(ArrayList array){
        String arquivoCSV = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\consulta.csv";
        ArrayList<String> listaDados = lerCSV(arquivoCSV);

        for (String linha : listaDados) {
            String[] dados = linha.split(",");
            String nomePaciente = dados[0];
            String nomeMedico = dados[1];
            String data = dados[2];

            String f = ("Paciente: " + nomePaciente + "| Médico: " + nomeMedico + "| Data: " + data );
            array.add(f);
        }
    }


    // Leitura de CSV (generica)
    public static ArrayList<String> lerCSV(String arquivoCSV) {
        ArrayList<String> listaDados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                listaDados.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDados;
    }


}