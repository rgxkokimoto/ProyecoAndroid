package dam.pmdm.proyectoandroid1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;



    public class RegistroNotaAcv extends AppCompatActivity {

        private EditText edSelAl;
        private EditText edSelAss;
        private EditText edNotaExam;
        private EditText edNotaActividades;
        private Button btnSelAss;
        private Button btnSelAlm;
        private Button btnCalNot;
        private EditText edVacio;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);

            edSelAl = findViewById(R.id.edSelAl);
            edSelAss = findViewById(R.id.edSelAss);
            edNotaExam = findViewById(R.id.edNotaExam);
            edNotaActividades = findViewById(R.id.edNotaActividades);
            btnSelAss = findViewById(R.id.btnSelAss);
            btnSelAlm = findViewById(R.id.btnSlectAl);
            btnCalNot = findViewById(R.id.btnCalNot);
            edVacio = findViewById(R.id.edVacio);

        }

        private ActivityResultLauncher<Intent> arlAlumno = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String resultado = data.getStringExtra("alumno");
                        edSelAl.setText(resultado);
                        btnSelAlm.setEnabled(false);
                    }
                }
            }
        );

        public void seletAlum(View view) {

            // TODO para el que tenga laventana de seleccion de alumnos necesito que me retornes un dato
            //Intent intent = new Intent(this, SeleccionAlumno.class);
            //arlAlumno.launch(intent);

        }

        private ActivityResultLauncher<Intent> arlAsignatura = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String resultado = data.getStringExtra("asigantura");
                            edSelAss.setText(resultado);
                            btnSelAss.setEnabled(false);
                        }
                    }
                }
        );

        public void seletAss(View view) {
            Intent intent = new Intent(this, SeleccionAsignatura.class);
            arlAsignatura.launch(intent);
            // TODO aun falta implementar la seleccion de la asignatura
        }

        public void guardarDta(View view) {
            // Si se pulsa el botón Guardar Datos sin haber introducido todos los datos, se mostrará un mensaje que indique que los datos son obligatorios.

            if (edSelAl.getText().toString().isEmpty() || edSelAss.getText().toString().isEmpty() || edNotaExam.getText().toString().isEmpty() || edNotaActividades.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // TODO guardar los datos en fichero
                // despues de guardar los datos se debe msotrar un mensaje y limpiar los campos
                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
                limpiarDta(view);
            }

        }

        public void limpiarDta(View view) {
            edSelAl.setText("");
            edSelAss.setText("");
            edNotaExam.setText("");
            edNotaActividades.setText("");
            btnSelAss.setEnabled(true);
            btnSelAlm.setEnabled(true);
            btnCalNot.setEnabled(true);
        }

        public void calcularNota(View view) {
            if ( edNotaExam.getText().toString().isEmpty() && edNotaActividades.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos necesarios (nota examen y nota actividades)", Toast.LENGTH_SHORT).show();
            } else {
                // despues de calcular la nota se debe msotrar un mensaje y limpiar los campos
                btnCalNot.setEnabled(false);
               /* o
                Si la nota del examen es >= 4.5 y la nota de actividades es >= 7.5 →
                nota final = nota examen * 0.7 + nota actividades * 0.3
                o
                Si no, Si la nota del examen es < 4.5 →
                nota final = nota examen
                o
                Si no, (la nota de tareas < 7.5) →
                nota final = nota examen * 0.7 + nota actividades * 0.3 */
                // TODO me gustaria revisar esto
                Double notaExam = Integer.parseDouble(edNotaExam.getText().toString());
                Double notaActividades = Integer.parseDouble(edNotaActividades.getText().toString());
                Double notaFinal = -1.0;
                if (notaExam >= 4.5  && notaActividades >= 7.5) {
                    notaFinal = notaExam * 0.7 + notaActividades * 0.3;
                } else if (notaExam < 4.5) {
                    notaFinal = notaExam;
                } else {
                    notaFinal = notaExam * 0.7 + notaActividades * 0.3;
                }

                edVacio.setText(notaFinal.toString());

            }
        }

    }




