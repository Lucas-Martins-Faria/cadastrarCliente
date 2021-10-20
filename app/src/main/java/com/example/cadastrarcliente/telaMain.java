package com.example.cadastrarcliente;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cadastrarcliente.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class telaMain extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button btnInserir;
    ListView ltvDados;
    List<Cliente> listaCliente = new ArrayList<Cliente>();
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main);

        btnInserir = findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener(this);
        ltvDados = findViewById(R.id.ltvDados);
        ltvDados.setOnItemClickListener(this);

    }

    @Override
    public void onREsume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        Intent intCadastro = new Intent(this, telaCadastro.class);
        intCadastro.putExtra("novoId", listaCliente.size()+1);
        startActivityForResult(intCadastro, 1);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cliente c = (Cliente) ltvDados.getAdapter().getItem(position);
        String dados = "Codigo.....: " + c.getId() + "\n"
                     + "Nome.......: " + c.getNome() + "\n"
                     + "Telefone...: " + c.getTelefone() + "\n"
                     + "Email......: " + c.getEmail() + "\n"
                     + "Observação.: " + c.getObs();
        Toast.makeText(this, dados, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            Cliente c = (Cliente) data.getSerializableExtra("cliente");
            listaCliente.add(c);

            listAdapter = new ArrayAdapter<Cliente>(this,
                    android.R.layout.simple_list_item_1, listaCliente);

            ltvDados.setAdapter(listAdapter);
        }
    }
}