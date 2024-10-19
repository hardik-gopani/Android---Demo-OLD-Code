package gopanisolutions.loginregistration;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by Hardik on 22-04-2017.
 */

public class Home extends Activity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv1= (TextView) findViewById(R.id.hatv1);

    }
}
