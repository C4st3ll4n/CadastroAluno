package senac.cadaluno.castellan.cadastroaluno.Helper;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import senac.cadaluno.castellan.cadastroaluno.Cadastro.AlunoCadastroActivity;
import senac.cadaluno.castellan.cadastroaluno.Model.Aluno;
import senac.cadaluno.castellan.cadastroaluno.R;

/**
 * Created by Henrique on 20/03/2018.
 */

public class AlunoHelper {
    private EditText nome, end, fone, email;
    private RadioGroup rg;
    private RadioButton rb,rbM,rbF,rbX;
    private Aluno aluno;

    public AlunoHelper(AlunoCadastroActivity act) {
        this.nome = act.findViewById(R.id.etNome);
        this.end = act.findViewById(R.id.etEndereço);
        this.fone = act.findViewById(R.id.etTel);
        this.email = act.findViewById(R.id.etEmail);
        this.rg = act.findViewById(R.id.rgSexo);
        this.rb = act.findViewById(rg.getCheckedRadioButtonId());
        this.rbM = act.findViewById(R.id.rbM);
        this.rbF = act.findViewById(R.id.rbF);
        this.rbX = act.findViewById(R.id.rbX);
    }

    public AlunoHelper() {
    }

    public Aluno pegarAluno() {
        String n, ende, t, em, s;
        n = nome.getText().toString();
        ende = end.getText().toString();
        t = fone.getText().toString();
        em = email.getText().toString();
        s = rb.getText().toString();
        aluno = new Aluno(n, ende, t, em, s);
        return aluno;

    }

    public void carregar(Aluno aluno) {
        if (aluno == null) aluno = new Aluno();
        this.nome.setText(aluno.getNome());
        this.end.setText(aluno.getEndereço());
        this.fone.setText(aluno.getFone());
        this.email.setText(aluno.getEmail());

        if (aluno.getSexo().equals("M"))this.rbM.setChecked(true);
        else if (aluno.getSexo().equals("F"))this.rbF.setChecked(true);
        else if (aluno.getSexo().equals("X")) this.rbX.setChecked(true);
    }

    public AlunoHelper(AlunoCadastroActivity act,Aluno a) {
        this.nome = act.findViewById(R.id.etNome);
        this.end = act.findViewById(R.id.etEndereço);
        this.fone = act.findViewById(R.id.etTel);
        this.email = act.findViewById(R.id.etEmail);
        this.rg = act.findViewById(R.id.rgSexo);
        this.rb = act.findViewById(rg.getCheckedRadioButtonId());
        this.rbM = act.findViewById(R.id.rbM);
        this.rbF = act.findViewById(R.id.rbF);
        this.rbX = act.findViewById(R.id.rbX);
        this.aluno = a;
    }
}
