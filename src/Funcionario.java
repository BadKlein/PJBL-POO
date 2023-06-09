import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public abstract class Funcionario extends Pessoa{

    private String id;

    private String turno;

    public Funcionario(String nome, String cpf, String id, String turno) {
        super(nome, cpf);
        this.id = id;
        this.turno = turno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void adicionaFuncionario(String arquivoCSV,String tipo,String nome, String codigo){


        // Adiciona o novo usuário ao arquivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCSV, true))) {
            bw.write(tipo + "," + nome + "," + codigo);
            bw.newLine();
            System.out.println("Usuário adicionado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu algum erro");
        }
    }

    public abstract int contagemCadastros();
}



