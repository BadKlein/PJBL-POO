public class Enfermeiro extends Funcionario{
    private String setor;

    public Enfermeiro(String nome, String cpf, int id, String turno, String setor) {
        super(nome, cpf, id, turno);
        this.setor = setor;
    }
}
