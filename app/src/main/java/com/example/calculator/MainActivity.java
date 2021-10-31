package com.example.calculator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    private TextView tinh;
    private TextView ketqua;
    private int[] idButton = {
            R.id.button0,
            R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9,R.id.bottonphantram, R.id.bottonCE, R.id.buttonC,
            R.id.buttonPhan, R.id.buttonMu2, R.id.buttonChia,R.id.buttonNhan, R.id.buttonTru, R.id.buttonCong,
            R.id.buttonTanggiam, R.id.buttonPhay, R.id.buttonBang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
    }
    private void connectView() {
         tinh= (TextView) findViewById(R.id.tinh);
        ketqua = (TextView) findViewById(R.id.ketqua);

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
        init();
    }

    private void init() {
        tinh.setText("|");
        ketqua.setText("0");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // check button number and button operator
        for (int i = 0; i < idButton.length - 2; i++) {
            if (id == idButton[i]) {
                String text = ((Button) findViewById(id)).getText().toString();

                // clear char | on top
                if (tinh.getText().toString().trim().equals("|")) {
                    tinh.setText("");
                }

                tinh.append(text);
                return;
            }
        }

        // clear screen
        if (id == R.id.buttonC) {
            init();
            return;
        }

        // calculation
        if (id == R.id.buttonBang) {
            getCallingActivity();
        }
    }
}