


public class Consulta{
    private Paciente p;
    private Medico m;
    private String data;


    public Consulta(Paciente p, Medico m, String data) {
        this.p = p;
        this.m = m;
        this.data = data;
    }

    public void setP(Paciente p) {
        this.p = p;
    }

    public void setM(Medico m) {
        this.m = m;
    }

    public void setData(String data) {
        this.data = data;

    }

    public Paciente getP() {
        return p;
    }

    public Medico getM() {
        return m;
    }

    public String getData() {
        return data;
    }
}