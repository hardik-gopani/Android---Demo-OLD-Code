package gopanisolutions.loginregistration;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginForm extends AppCompatActivity {

    TextView tv1;
    EditText e1, e2;
    String s1, s2;
    Button b1, b2;
    SQLiteDatabase hardik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        hardik = openOrCreateDatabase("mrhardik.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        hardik.execSQL("create table if not exists reg(id integer primary key autoincrement,email text,name text,phone text,password text)");

        tv1 = (TextView) findViewById(R.id.latv1);

        e1 = (EditText) findViewById(R.id.laet1);
        e2 = (EditText) findViewById(R.id.laet2);

        b1 = (Button) findViewById(R.id.labtn1);
        b2 = (Button) findViewById(R.id.labtn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString().trim();
                s2 = e2.getText().toString().trim();

                if (s1.equals("")) {
                    e1.setError("Plze Enter Uesrname");
                } else if (s2.equals("")) {
                    e2.setError("Plze Enter Password");
                } else {

                    Cursor c = hardik.rawQuery("select * from reg where email='" + s1 + "' and password='" + s2 + "'", null);
                    if (c.moveToNext())
                    {
                        Toast.makeText(LoginForm.this, "Login Success Full", Toast.LENGTH_LONG).show();
                        Intent a = new Intent(LoginForm.this, Home.class);
                        startActivity(a);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginForm.this, Registration.class);
                startActivity(i);

            }
        });
    }
}
