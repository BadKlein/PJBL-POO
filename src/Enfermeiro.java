public class Enfermeiro extends Funcionario{
    private String setor;
    private float cargaHoraria;

    public Enfermeiro(String nome, String cpf, int id, String turno, String setor, float cargaHoraria) {
        super(nome, cpf, id, turno);
        this.setor = setor;
        this.cargaHoraria = cargaHoraria;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    private void mudarSetor(){

    }

    private float mudarCargaHoraria(){


    }
}
