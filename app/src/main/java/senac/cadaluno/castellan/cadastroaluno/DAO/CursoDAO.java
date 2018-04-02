package senac.cadaluno.castellan.cadastroaluno.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import senac.cadaluno.castellan.cadastroaluno.Model.Curso;

/**
 * Created by TARDE on 22/03/2018.
 */

public class CursoDAO extends SQLiteOpenHelper {

    public CursoDAO(Context context) {
        super(context, "SENAC_C", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL("CREATE TABLE CURSO(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOME VARCHAR(100)," +
                "CHR VARCHAR(4)," +
                "SITE VARCHAR(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserir(Curso curso) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", curso.getNome());
        contentValues.put("CHR", curso.getCargaHr());
        contentValues.put("SITE", curso.getSite());

        db.insert("CURSO", null, contentValues);
    }

    public List getCurso() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM CURSO", null);

        List<Curso> cursoList = new ArrayList<>();
        int indiceColumnNome = c.getColumnIndex("NOME");
        int indiceColumnId = c.getColumnIndex("ID");
        int indiceColumnSite = c.getColumnIndex("SITE");
        int indiceColumnCHR = c.getColumnIndex("CHR");
        c.moveToFirst();

        while (c.moveToNext()) {
            Curso novo = new Curso();
            novo.setId(c.getString(indiceColumnId));
            novo.setNome(c.getString(indiceColumnNome));
            novo.setSite(c.getString(indiceColumnSite));
            novo.setCargaHr(c.getString(indiceColumnCHR));
            cursoList.add(novo);
        }
        return cursoList;
    }

    public void deletar(Curso curso) {
        SQLiteDatabase db = getWritableDatabase();
        String i = curso.getId();
        try {
            db.execSQL("DELETE FROM CURSO WHERE ID = " + i);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nOnDelete");
        }
    }
}
