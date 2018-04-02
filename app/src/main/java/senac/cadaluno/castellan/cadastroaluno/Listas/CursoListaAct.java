package senac.cadaluno.castellan.cadastroaluno.Listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import senac.cadaluno.castellan.cadastroaluno.Cadastro.CursoCadastroActivity;
import senac.cadaluno.castellan.cadastroaluno.DAO.CursoDAO;
import senac.cadaluno.castellan.cadastroaluno.HomeAct;
import senac.cadaluno.castellan.cadastroaluno.Model.Curso;
import senac.cadaluno.castellan.cadastroaluno.R;

public class CursoListaAct extends AppCompatActivity {
    private ListView lista_cursos;
    private List<Curso> cursos = new ArrayList<>();
    private CursoDAO Cdao = new CursoDAO(this);
    private ArrayAdapter adaptadorCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_lista);
        lista_cursos = findViewById(R.id.lista_cursos);
        registerForContextMenu(lista_cursos);

        cursos = Cdao.getCurso();
        adaptadorCurso = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, cursos);
        lista_cursos.setAdapter(adaptadorCurso);

        lista_cursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Curso c = new Curso();
                c = (Curso) lista_cursos.getItemAtPosition(position);
                Intent t = new Intent(getApplicationContext(), CursoCadastroActivity.class);
                t.putExtra("CURSO", c);
                startActivity(t);

            }
        });
    }
    public void goToCadastroCurso(View v) {
        finish();
        startActivity(new Intent(getApplicationContext(), CursoCadastroActivity.class));
    }

    public void onCreateContextMenu(final ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Excluir curso").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int pos = menuInfo.position;

                Curso curso = new Curso();
                curso = (Curso) lista_cursos.getItemAtPosition(pos);
                Cdao.deletar(curso);
                Cdao.close();
                recreate();
                return false;
            }
        });
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), HomeAct.class));
    }
}
