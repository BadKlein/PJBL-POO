public class Pessoa {
    private String nome;
    private String cpf;

    private String convenio;

    public Pessoa(String nome, String cpf, String convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    //Métodos
    private void mudarDados(String nome, String cpf, String convenio){

    }
}
