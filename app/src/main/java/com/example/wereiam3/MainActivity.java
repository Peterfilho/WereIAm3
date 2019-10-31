package com.example.wereiam3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editName, editAp1, editAp2, editAp3, editAp4, editAp5;

    Button btnClear, btnSave, btnDelete;

    ListView listViewAps;

    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editCodigo = (EditText)findViewById(R.id.editCod);
        editName = (EditText)findViewById(R.id.editName);
        editAp1 = (EditText)findViewById(R.id.editAp1);
        editAp2 = (EditText)findViewById(R.id.editAp2);
        editAp3 = (EditText)findViewById(R.id.editAp3);
        editAp4 = (EditText)findViewById(R.id.editAp4);
        editAp5 = (EditText)findViewById(R.id.editAp5);

        btnClear = (Button)findViewById(R.id.btnClear);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        listViewAps = (ListView)findViewById(R.id.listViewAps);

        /*TEST-CRUD*/

        /* INSERT */

//        db.addApData(new Access_point("LAB - B7 - porta", "-30", "-12", "-78", "-55", "-22"));
//        db.addApData(new Access_point("LAB - B8 - porta", "-35", "-25", "-93", "-87", "-42"));
//        db.addApData(new Access_point("LAB - B6 - porta", "-67", "-42", "-78", "-55", "-22"));
//        db.addApData(new Access_point("Porta entrada - alunos", "-64", "-43", "-78", "-85", "-94"));
//        db.addApData(new Access_point("Porta entrada - professores", "-30", "-62", "-78", "-58", "-29"));
//
//        Toast.makeText(MainActivity.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();

        /* DELETE */
//
//        Access_point access_point = new Access_point();
//        access_point.setId(1);
//        db.deleteApData(access_point);
//
//        Toast.makeText(MainActivity.this, "Excluído com sucesso", Toast.LENGTH_LONG).show();

        /* READ */

//        Access_point access_point = db.selectData(4);
//
//        Log.d("Local selecionado!", "ID: " + access_point.getId()
//                + " Nome: " + access_point.getName()
//                + " Ap1: " + access_point.getAp1()
//                + " Ap2: " + access_point.getAp2()
//                + " Ap3: " + access_point.getAp3()
//                + " Ap4: " + access_point.getAp4()
//                + " Ap5: " + access_point.getAp5()
//        );

        /* UPDATE */
//
//        Access_point access_point = new Access_point();
//        access_point.setId(4);
//        access_point.setName("Testeeeeee");
//        access_point.setAp1("-999");
//        access_point.setAp2("-888");
//        access_point.setAp3("-777");
//        access_point.setAp4("-666");
//        access_point.setAp5("-555");
//
//        db.updateData(access_point);
//
//        Toast.makeText(MainActivity.this, "Atualizado com sucesso", Toast.LENGTH_LONG).show();
//
//        Log.d("Local selecionado!", "ID: " + access_point.getId()
//                + " Nome: " + access_point.getName()
//                + " Ap1: " + access_point.getAp1()
//                + " Ap2: " + access_point.getAp2()
//                + " Ap3: " + access_point.getAp3()
//                + " Ap4: " + access_point.getAp4()
//                + " Ap5: " + access_point.getAp5()
//        );

        

    }
}
