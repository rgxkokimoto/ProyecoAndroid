package dam.pmdm.proyectoandroid1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;

public class SeleccionAsignatura extends ComponentActivity {

    private Button btnPmdm;
    private Button btnAsgAd;
    private Button btnAsgPsp;
    private Button btnAsgDi;
    private Button btnAsgSge;
    private Button btnAsgIacc;
    private Button btnAsgIos;
    private EditText edSelAss;
    private Button btnAceptar;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        btnPmdm = findViewById(R.id.btnPmdm);
        btnAsgAd = findViewById(R.id.btnAsgAd);
        btnAsgPsp = findViewById(R.id.btnAsgPsp);
        btnAsgDi = findViewById(R.id.btnAsgDi);
        btnAsgSge = findViewById(R.id.btnAsgSge);
        btnAsgIacc = findViewById(R.id.btnAsgIacc);
        edSelAss = findViewById(R.id.edSelAss);
        btnAsgIos = findViewById(R.id.btnAsgIos);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancel = findViewById(R.id.btnCancel);

        btnPmdm.setOnClickListener(view -> {
            edSelAss.setText("PMDM");
        });

        btnAsgAd.setOnClickListener(view -> {
            edSelAss.setText("AD");
        });

        btnAsgPsp.setOnClickListener(view -> {
            edSelAss.setText("PSP");
        });

        btnAsgDi.setOnClickListener(view -> {
            edSelAss.setText("DI");
        });

        btnAsgSge.setOnClickListener(view -> {
            edSelAss.setText("SGE");
        });

        btnAsgIacc.setOnClickListener(view -> {
            edSelAss.setText("IACC");
        });

        btnAsgIos.setOnClickListener(view -> {
            edSelAss.setText("IOS");
        });

        btnAceptar.setOnClickListener(view -> {
            String asignatura = edSelAss.getText().toString();
            if (asignatura.isEmpty()) {
                Toast.makeText(this, "Por favor, selecciona una asignatura", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("asigantura", asignatura);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnCancel.setOnClickListener(view -> {
            finish();
        });


    }







}
