package aplicativos.aviacao;

public class Pilotos extends Pessoas{
    
    private String breve;
    private String matricula;
    
    private Aeronave av1;

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Aeronave getAv1() {
        return av1;
    }

    public void setAv1(Aeronave av1) {
        this.av1 = av1;
    }



}
