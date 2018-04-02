package senac.cadaluno.castellan.cadastroaluno.Model;

import java.io.Serializable;

/**
 * Created by TARDE on 22/03/2018.
 */

public class Curso implements Serializable {
    private String Id;
    private String nome;
    private String cargaHr;
    private String site;

    public Curso() {
    }

    public Curso(String nome, String cargaHr, String site) {
        this.nome = nome;
        this.cargaHr = cargaHr;
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHr() {
        return cargaHr;
    }

    public void setCargaHr(String cargaHr) {
        this.cargaHr = cargaHr;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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
