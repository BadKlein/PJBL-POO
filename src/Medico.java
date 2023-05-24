public class Medico extends Funcionario{
    private String CRM;
    private String especialidade;


    public Medico(String nome, String cpf, int id, String turno, String CRM, String especialidade) {
        super(nome, cpf, id, turno);
        this.CRM = CRM;
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}


