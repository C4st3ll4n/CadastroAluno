package senac.cadaluno.castellan.cadastroaluno.Listas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import senac.cadaluno.castellan.cadastroaluno.Cadastro.AlunoCadastroActivity;
import senac.cadaluno.castellan.cadastroaluno.DAO.AlunoDAO;
import senac.cadaluno.castellan.cadastroaluno.HomeAct;
import senac.cadaluno.castellan.cadastroaluno.Model.Aluno;
import senac.cadaluno.castellan.cadastroaluno.R;

public class AlunoListaAct extends AppCompatActivity {
    private ArrayAdapter adaptadorAluno;
    private ListView lista_aluno;
    private List<Aluno> alunos = new ArrayList<>();
    private AlunoDAO Adao = new AlunoDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_lista);
        lista_aluno = findViewById(R.id.lista_alunos);
        registerForContextMenu(lista_aluno);

        alunos = Adao.getAluno();
        adaptadorAluno = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, alunos);
        lista_aluno.setAdapter(adaptadorAluno);

        lista_aluno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno neo = new Aluno();
                neo = (Aluno) lista_aluno.getItemAtPosition(position);
                Intent t = new Intent(getApplicationContext(), AlunoCadastroActivity.class);
                t.putExtra("ALUNO", neo);
                startActivity(t);
            }
        });
    }

    public void goToCadastroAluno(View v) {
        finish();
        startActivity(new Intent(getApplicationContext(), AlunoCadastroActivity.class));
    }

    @Override
    public void onCreateContextMenu(final ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Excluir aluno").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int pos = menuInfo.position;

                Aluno aluno = new Aluno();
                aluno = (Aluno) lista_aluno.getItemAtPosition(pos);
                Adao.deletar(aluno);
                Adao.close();
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
