package senac.cadaluno.castellan.cadastroaluno.Cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import senac.cadaluno.castellan.cadastroaluno.DAO.CursoDAO;
import senac.cadaluno.castellan.cadastroaluno.Helper.CursoHelper;
import senac.cadaluno.castellan.cadastroaluno.Listas.CursoListaAct;
import senac.cadaluno.castellan.cadastroaluno.Model.Curso;
import senac.cadaluno.castellan.cadastroaluno.R;

public class CursoCadastroActivity extends AppCompatActivity {
    private EditText nome,ch,site;
    private Curso curso;
    private CursoHelper help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_cadastro);
        nome = findViewById(R.id.etNomeCurso);
        ch = findViewById(R.id.etCH);
        site = findViewById(R.id.etSite);
    }

    public void cadastrar(View v){
        help = new CursoHelper(this);
        curso = help.pegarCurso();

        CursoDAO dao = new CursoDAO(this);
        dao.inserir(curso);
        Toast.makeText(this, curso.getNome() + " inserido", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(this,CursoListaAct.class));
    }

    public void voltar(View v){
        finish();
        startActivity(new Intent(this,CursoListaAct.class));
    }

    @Override
    protected void onResume() {
        try {
            curso = (Curso) getIntent().getExtras().getSerializable("ALUNO");
            if (curso != null) {
                help = new CursoHelper(this);
                help.carregar(curso);
            }

        } catch (Exception e) {
            curso = null;
            Toast.makeText(this, "Deu ruim no onResume", Toast.LENGTH_SHORT).show();
        }finally {
            super.onResume();
        }
    }
}
