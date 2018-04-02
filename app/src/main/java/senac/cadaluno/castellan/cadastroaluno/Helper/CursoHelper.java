package senac.cadaluno.castellan.cadastroaluno.Helper;

import android.app.Activity;
import android.widget.EditText;

import senac.cadaluno.castellan.cadastroaluno.Model.Curso;
import senac.cadaluno.castellan.cadastroaluno.R;

/**
 * Created by TARDE on 22/03/2018.
 */

public class CursoHelper {

    private EditText nome,ch,site;
    private Curso curso;

    public CursoHelper(Activity act) {
        nome = act.findViewById(R.id.etNomeCurso);
        ch = act.findViewById(R.id.etCH);
        site = act.findViewById(R.id.etSite);
    }

    public Curso pegarCurso(){
        String n,carga,www;
        n = nome.getText().toString();
        carga = ch.getText().toString();
        www = site.getText().toString();
        curso = new Curso(n,carga,www);
        return curso;
    }

    public void carregar(Curso curso){

    }
}
