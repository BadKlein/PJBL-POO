import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Paciente extends Pessoa {
    private String genero;
    private String idade;
    private String atendimentoTipo;

    public Paciente(String nome, String cpf,String genero,String idade,String atendimentoTipo) {
        super(nome, cpf);
        this.genero = genero;
        this.idade = idade;
        this.atendimentoTipo = atendimentoTipo;

    }

    public String getGenero() {
        return genero;
    }

    public String getIdade() {
        return idade;
    }

    public String getAtendimentoTipo() {
        return atendimentoTipo;
    }

    @Override
    public int contagemCadastros(){
        String csvFile = "C:\\Users\\leokl\\IdeaProjects\\PJBL-POO\\src\\paciente.csv";
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




