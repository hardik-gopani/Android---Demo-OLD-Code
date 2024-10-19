package gopanisolutions.loginregistration;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hardik on 22-04-2017.
 */

public class Registration extends Activity {

    TextView tv1;
    EditText e1, e2, e3, e4, e5;
    String s1, s2, s3, s4, s5;
    Button btn1;
    SQLiteDatabase hardik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        hardik = openOrCreateDatabase("mrhardik.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        tv1 = (TextView) findViewById(R.id.ratv1);

        e1 = (EditText) findViewById(R.id.raet1);
        e2 = (EditText) findViewById(R.id.raet2);
        e3 = (EditText) findViewById(R.id.raet3);
        e4 = (EditText) findViewById(R.id.raet4);
        e5 = (EditText) findViewById(R.id.raet5);

        btn1 = (Button) findViewById(R.id.rabtn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = e1.getText().toString().trim();
                s2 = e2.getText().toString().trim();
                s3 = e3.getText().toString().trim();
                s4 = e4.getText().toString().trim();
                s5 = e5.getText().toString().trim();

                if (s1.equals("")) {
                    e1.setError("Plze Enter...");

                } else if (s2.equals("")) {
                    e2.setError("Plze Enter...");

                } else if (s3.equals("")) {
                    e3.setError("Plze Enter...");

                } else if (s4.equals("")) {
                    e4.setError("Plze Enter...");

                } else if (s5.equals("") || !s5.equals(s4)) {
                    e5.setError("Plze Enter...");

                } else {

                    hardik.execSQL("insert into reg(email,name,phone,password) values('" + s1 + "','" + s2 + "','" + s3 + "','"+s4+"')");
                    Toast.makeText(Registration.this, "Complite Sign Up", Toast.LENGTH_LONG).show();
                    Intent a = new Intent(Registration.this, LoginForm.class);
                    startActivity(a);

                }
            }
        });


    }
}
