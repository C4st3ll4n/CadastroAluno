package senac.cadaluno.castellan.cadastroaluno.Adaptador;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import senac.cadaluno.castellan.cadastroaluno.Model.Aluno;
import senac.cadaluno.castellan.cadastroaluno.R;

/**
 * Created by Henrique on 20/03/2018.
 */

public class AlunoAdapter extends BaseAdapter {

    private final List<Aluno> alunos;
    private final Activity act;

    public AlunoAdapter(List<Aluno> alunos, Activity act) {
        this.alunos = alunos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup vg) {
        View v = act.getLayoutInflater()
                .inflate(R.layout.aluno_lista, vg, false);
        Aluno a = alunos.get(i);

        TextView twNome = v.findViewById(R.id.twNome);
        ImageView img = v.findViewById(R.id.imgAluno);

        twNome.setText(a.getNome());
        img.setImageResource(R.drawable.ic_launcher_background);
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
