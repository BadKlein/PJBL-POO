import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Medico extends Funcionario{
    private String CRM;


    public Medico(String nome, String cpf, String id, String turno, String CRM) {

        super(nome, cpf, id, turno);
        this.CRM = CRM;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    @Override
    public int contagemCadastros(){
      String csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\medico.csv";
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String linha;
            // Ignorando a primeira linha (cabeçalho)
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                boolean linhaPreenchida = false;
                for (String campo : campos) {
                    if (!campo.trim().isEmpty()) {
                        linhaPreenchida = true;
                        break;
                    }
                }
                if (linhaPreenchida) {
                    contador++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }


}


