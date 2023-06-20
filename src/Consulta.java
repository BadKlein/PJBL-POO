import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Consulta{

    DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final Paciente p;
    private final Medico m;
    private final String data;


    public Consulta(Paciente p, Medico m) {
        this.p = p;
        this.m = m;
        LocalDateTime date = LocalDateTime.now();
        this.data = date.format(dataformat);
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