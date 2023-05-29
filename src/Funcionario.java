public class Funcionario extends Pessoa{
    private int id;
    private String turno;
    private String tipoFuncionario;

    public Funcionario(String nome, String cpf, int id, String turno, String tipoFuncionario) {
        super(nome, cpf);
        this.id = id;
        this.turno = turno;
        this.tipoFuncionario = tipoFuncionario;
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

    private int mudarFuncionario(int id){

    }

    private void mudarTipoFuncionario(){

    }
}
