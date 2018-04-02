package senac.cadaluno.castellan.cadastroaluno.Cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import senac.cadaluno.castellan.cadastroaluno.DAO.AlunoDAO;
import senac.cadaluno.castellan.cadastroaluno.Helper.AlunoHelper;
import senac.cadaluno.castellan.cadastroaluno.Listas.AlunoListaAct;
import senac.cadaluno.castellan.cadastroaluno.Model.Aluno;
import senac.cadaluno.castellan.cadastroaluno.R;

public class AlunoCadastroActivity extends AppCompatActivity {
    private EditText nome, end, fone, email;
    private RadioGroup rg;
    private RadioButton rb;
    private AlunoHelper helper;
    private Aluno aluno;
    private AlunoDAO dao;
    private Button bt;
    private boolean editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        nome = findViewById(R.id.etNome);
        end = findViewById(R.id.etEndereço);
        fone = findViewById(R.id.etTel);
        email = findViewById(R.id.etEmail);
        rg = findViewById(R.id.rgSexo);
        bt = findViewById(R.id.btCadastrar);

        SimpleMaskFormatter sf = new SimpleMaskFormatter("(NN) NNNNN - NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(fone, sf);
        fone.addTextChangedListener(mtw);


    }

    public void Cadastrat(View v) {
        helper = new AlunoHelper(this);
        dao = new AlunoDAO(this);
        if (aluno == null) {
            aluno = helper.pegarAluno();
            dao.inserir(aluno);
            Toast.makeText(this, aluno.getNome() + " inserido", Toast.LENGTH_SHORT).show();
        } else {
            aluno = helper.pegarAluno();
            dao.alterar(aluno);
            Toast.makeText(this, aluno.getNome() + " alterado", Toast.LENGTH_SHORT).show();
        }
            finish();
            startActivity(new Intent(this, AlunoListaAct.class));
    }

    public void voltar(View v) {
        finish();
        startActivity(new Intent(this, AlunoListaAct.class));
    }

    @Override
    protected void onResume() {
        try {
            aluno = (Aluno) getIntent().getExtras().getSerializable("ALUNO");
            if (aluno != null) {
                helper = new AlunoHelper(this);
                helper.carregar(aluno);
                bt.setText("ATUALIZAR");
            }

        } catch (Exception e) {
           bt.setText("CADASTRAR");
            aluno = null;
        }finally {
            super.onResume();
        }
    }
}
