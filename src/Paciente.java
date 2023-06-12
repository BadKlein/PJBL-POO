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
}




