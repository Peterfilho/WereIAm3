package com.example.wereiam3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editName, editAp1, editAp2, editAp3, editAp4, editAp5;

    Button btnClear, btnSave, btnDelete;

    ListView listViewAps;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

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

        listData();

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearForm();
            }
        });

        listViewAps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String content = (String) listViewAps.getItemAtPosition(i);

                Toast.makeText(MainActivity.this, "Select: " + content, Toast.LENGTH_LONG).show();

                String id = content.substring(0 , content.indexOf("-"));

                Access_point access_point = db.selectData(Integer.parseInt(id));

                editCodigo.setText(String.valueOf(access_point.getId()));
                editName.setText(access_point.getName());
                editAp1.setText(access_point.ap1);
                editAp2.setText(access_point.ap2);
                editAp3.setText(access_point.ap3);
                editAp4.setText(access_point.ap4);
                editAp5.setText(access_point.ap5);

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = editCodigo.getText().toString();
                String name = editName.getText().toString();
                String ap1 = editAp1.getText().toString();
                String ap2 = editAp2.getText().toString();
                String ap3 = editAp3.getText().toString();
                String ap4 = editAp4.getText().toString();
                String ap5 = editAp5.getText().toString();

                if(name.isEmpty()) {
                    editName.setError("Este campo é obrigatório");
                }else if (id.isEmpty()) {
                    db.addApData(new Access_point(name, ap1, ap2, ap3, ap4, ap5));
                    Toast.makeText(MainActivity.this, "Local cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                    listData();
                    clearForm();
                } else {
                    db.updateData(new Access_point(Integer.parseInt(id), name, ap1, ap2, ap3, ap4, ap5));
                    Toast.makeText(MainActivity.this, "Local atualizado com sucesso!", Toast.LENGTH_LONG).show();
                    listData();
                    clearForm();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editCodigo.getText().toString();

                if (id.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nenhum local selecionado!", Toast.LENGTH_LONG).show();
                } else {
                    Access_point access_point = new Access_point();
                    access_point.setId(Integer.parseInt(id));
                    db.deleteApData(access_point);

                    Toast.makeText(MainActivity.this, "Local excluído com sucesso!", Toast.LENGTH_LONG).show();
                    listData();
                    clearForm();

                }
            }
        });

    }

    public void clearForm() {
        editCodigo.setText("");
        editName.setText("");
        editAp1.setText("");
        editAp2.setText("");
        editAp3.setText("");
        editAp4.setText("");
        editAp5.setText("");

        editName.requestFocus();
    }

    public void listData() {

        List<Access_point> access_points = db.listAllData();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        listViewAps.setAdapter(adapter);


        for(Access_point a : access_points) {
            arrayList.add(a.getId() + "-" + a.getName());
            adapter.notifyDataSetChanged();
        }
    }

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
