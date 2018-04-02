package senac.cadaluno.castellan.cadastroaluno.Model;


import java.io.Serializable;

/**
 * Created by Henrique Castellan on 16/03/2018.
 */

public class Aluno implements Serializable {
    private String Id;
    private String nome;
    private String endereco;
    private String fone;
    private String email;
    private String sexo;

    public Aluno(String nome, String endereço, String fone, String email, String sexo) {
        this.nome = nome;
        this.endereco = endereço;
        this.fone = fone;
        this.email = email;
        this.sexo = sexo;
    }

    public Aluno() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereco;
    }

    public void setEndereço(String endereço) {
        this.endereco = endereço;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
