public class Paciente extends Pessoa{
    private String convenio;
    private int id;

    public Paciente(String convenio, int id) {
        this.convenio = convenio;
        this.id = id;
    }
}