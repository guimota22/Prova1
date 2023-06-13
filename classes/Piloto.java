package classes;
public class Piloto extends Pessoa {
    private String breve;

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "Nome: " + nome;
        texto += "\nCPF: " + cpf;
        texto += "\nBreve: " + breve + "\n";
        
        return texto;
    }
}
