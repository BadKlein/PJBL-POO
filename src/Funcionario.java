public class Funcionario extends Pessoa{
    private int id;
    private String turno;

    public Funcionario(String nome, String cpf, int id, String turno) {
        super(nome, cpf);
        this.id = id;
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
