package senac.cadaluno.castellan.cadastroaluno.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import senac.cadaluno.castellan.cadastroaluno.Model.Aluno;

/**
 * Created by Henrique on 20/03/2018.
 */

public class AlunoDAO extends SQLiteOpenHelper {

    public AlunoDAO(Context context) {
        super(context, "SENAC_A", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        sqlDB.execSQL("CREATE TABLE IF NOT EXISTS ALUNO(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOME VARCHAR(100) NOT NULL," +
                "TELEFONE VARCHAR(9)," +
                "ENDEREÇO TEXT," +
                "EMAIL TEXT," +
                "SEXO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserir(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        db.insert("ALUNO", null, dadosAluno(aluno));
    }

    public List getAluno() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ALUNO", null);

        List<Aluno> alunoList = new ArrayList<>();
        int indiceColumnNome = c.getColumnIndex("NOME");
        int indiceColumnTel = c.getColumnIndex("TELEFONE");
        int indiceColumnEnd = c.getColumnIndex("ENDEREÇO");
        int indiceColumnS = c.getColumnIndex("SEXO");
        int indiceColumnEmail = c.getColumnIndex("EMAIL");
        int indiceColumnId = c.getColumnIndex("ID");
        c.moveToFirst();

        while (c.moveToNext()) {
            Aluno novo = new Aluno();
            novo.setNome(c.getString(indiceColumnNome));
            novo.setId(c.getString(indiceColumnId));
            novo.setFone(c.getString(indiceColumnTel));
            novo.setEmail(c.getString(indiceColumnEmail));
            novo.setSexo(c.getString(indiceColumnS));
            novo.setEndereço(c.getString(indiceColumnEnd));
            alunoList.add(novo);

        }
        return alunoList;
    }

    public void deletar(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String i = aluno.getId();
        try {
            db.execSQL("DELETE FROM ALUNO WHERE ID = " + i);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nOnDelete");
        }
    }

    public void alterar(Aluno aluno){
        SQLiteDatabase db = getWritableDatabase();
        String[] dados = {aluno.getId()};
        db.update("ALUNO",dadosAluno(aluno),"ID=?",dados);
    }

    public ContentValues dadosAluno(Aluno aluno){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", aluno.getNome());
        contentValues.put("TELEFONE", aluno.getFone());
        contentValues.put("EMAIL", aluno.getEmail());
        contentValues.put("ENDEREÇO", aluno.getEndereço());
        contentValues.put("SEXO", aluno.getSexo());
        return contentValues;
    }
}

