package classes;

import java.util.InputMismatchException;

public class Pessoa {
    protected String nome;
    protected String cpf;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if( cpf == null ){
            throw new NullPointerException("O valor do CPF não pode ser nulo.");
        }

        if( cpf.length() != 11 ){
            throw new InputMismatchException("O CPF deve conter 11 caracteres.");
        }

        if( ! cpf.matches("\\d{11}") ){
            throw new InputMismatchException("O CPF deve ser composto por 11 números.");
        }
        
        if (cpf != null && cpf.length() == 11 && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        }   

    }
    
}
