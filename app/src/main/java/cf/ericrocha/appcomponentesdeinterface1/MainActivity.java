package cf.ericrocha.appcomponentesdeinterface1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText campoProduto;
    private TextView resultado;
    private CheckBox cbBranco, cbVerde, cbAzul;
    List<String> check = new ArrayList<String>();
    private TextView resultadoCb;
    private RadioGroup rgEstoque;
    private TextView resultadoRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoProduto = findViewById(R.id.etNomeProduto);
        resultado = findViewById(R.id.tvResultado);
        cbBranco = findViewById(R.id.cbBranco);
        cbVerde = findViewById(R.id.cbVerde);
        cbAzul = findViewById(R.id.cbAzul);
        resultadoCb = findViewById(R.id.tvResultadoCb);
        rgEstoque = findViewById(R.id.rgEstoque);
        resultadoRg = findViewById(R.id.tvResultadoRg);
        verificaRadioGroup();
    }

    public void verificaRadioGroup() {
        rgEstoque.setOnCheckedChangeListener(new
                                                     RadioGroup.OnCheckedChangeListener() {
                                                         @Override
                                                         public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                                             if (i == R.id.rbSim) {
                                                                 resultadoRg.setText("Sim");
                                                             } else {
                                                                 resultadoRg.setText("Não");
                                                             }
                                                         }
                                                     });
    }

    public void verificaCheck() {
        check.clear();
        if (cbBranco.isChecked()) {
            check.add(cbBranco.getText().toString());
        }
        if (cbVerde.isChecked()) {
            check.add(cbVerde.getText().toString());
        }
        if (cbAzul.isChecked()) {
            check.add(cbAzul.getText().toString());
        }
        resultadoCb.setText(check.toString());
    }

    public void btEnviar(View view) {
        String nomeProduto = campoProduto.getText().toString();
        resultado.setText(nomeProduto);
        verificaCheck();
    }
}
