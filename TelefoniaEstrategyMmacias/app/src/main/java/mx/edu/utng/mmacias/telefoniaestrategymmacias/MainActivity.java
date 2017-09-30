package mx.edu.utng.mmacias.telefoniaestrategymmacias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class MainActivity implements AdapterView.OnItemSelectedListener{
    Spinner cmbOpciones;
    EditText txtMinutosLocal;
    EditText txtMinutosLD;
    EditText txtTotal;
    Button btnCalcular;
    Button btnLimpiar;
    Button btnMostrar;
    int op; //copañia seleccionada
    Contexto contexto;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacionando los controles con la views
        cmbOpciones= (Spinner)findViewById(R.id.cmb_opciones);
        txtMinutosLocal=(EditText)findViewById(R.id.txt_minutos_local);
        txtMinutosLD=(EditText)findViewById(R.id.txt_minutos_ld);
        txtTotal=(EditText)findViewById(R.id.txt_total);
        btnCalcular=(Button)findViewById(R.id.btn_calcular);
        btnLimpiar=(Button)findViewById(R.id.btn_limpiar);
        btnMostrar= (Button)findViewById(R.id.btn_mostrar);

        cmbOpciones.setOnItemSelectedListener(this);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreditosActivity.class);
                startActivity(intent);
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int minutosLocal;
                int minutosLD;
                double total=0;

                minutosLocal=Integer.parseInt(txtMinutosLocal.getText().toString());
                minutosLD=Integer.parseInt(txtMinutosLD.getText().toString());

                total = contexto.calcularTarifaLocal(minutosLocal)+
                        contexto.calcularTarifaLD(minutosLD);

                txtTotal.setText(""+total);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        op= (int)cmbOpciones.getSelectedItemId();
        switch (op){
            case 1:
                contexto = new Contexto(new Telcel());
                break;
            case 2:
                contexto = new Contexto(new unefon());
                break;
            case 3:
                contexto = new Contexto(new MyCompany());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        op= 1;
    }


}


