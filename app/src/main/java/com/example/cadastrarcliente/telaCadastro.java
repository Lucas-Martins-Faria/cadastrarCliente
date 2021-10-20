package com.example.cadastrarcliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadastrarcliente.modelo.Cliente;

public class telaCadastro extends AppCompatActivity implements View.OnClickListener {

    EditText edtId;
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtObs;

    Button btnGravar;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edtId = findViewById(R.id.edtId);
        if (getIntent().getExtras() != null) {
            int id = getIntent().getExtras().getInt("novoId");
            edtId.setText(String.valueOf(id));
        }
        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEmail = findViewById(R.id.edtEmail);
        edtObs = findViewById(R.id.edtObs);

        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);
        btnGravar = findViewById(R.id.btnGravar);
        btnGravar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnCancelar) {
            finish();
        }
        else if (view == btnGravar) {

            Cliente c = new Cliente(Integer.parseInt(edtId.getText().toString()),
            edtNome.getText().toString(),
            edtTelefone.getText().toString(),
            edtEmail.getText().toString(),
            edtObs.getText().toString());

        Intent intRetorno = new Intent();
        intRetorno.putExtra("cliente", c);
        setResult(1, intRetorno);
        finish();

        }
    }
}