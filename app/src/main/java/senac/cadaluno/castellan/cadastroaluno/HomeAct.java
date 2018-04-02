package senac.cadaluno.castellan.cadastroaluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import senac.cadaluno.castellan.cadastroaluno.Cadastro.AlunoCadastroActivity;
import senac.cadaluno.castellan.cadastroaluno.Cadastro.CursoCadastroActivity;
import senac.cadaluno.castellan.cadastroaluno.Listas.AlunoListaAct;
import senac.cadaluno.castellan.cadastroaluno.Listas.CursoListaAct;
import senac.cadaluno.castellan.cadastroaluno.R;

public class HomeAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_main, menu);
        return true;
    }

    public void goToAlunos(View v){
        finish();
        startActivity(new Intent(this, AlunoListaAct.class));
    }

    public void goToCursos(View v){
        finish();
        startActivity(new Intent(this, CursoListaAct.class));
    }
}
