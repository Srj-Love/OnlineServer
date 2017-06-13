package srjlove.com.onlineserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Insert extends AppCompatActivity {


    EditText e_name, e_email, e_contact, e_password;
    String name, email, contact, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_insert);


        e_name = (EditText) findViewById(R.id.name);
        e_email = (EditText) findViewById(R.id.email);

        e_contact = (EditText) findViewById(R.id.contact);

        e_password = (EditText) findViewById(R.id.password);


    }


    public void reguser(View view) {


        name = e_name.getText().toString();
        email = e_email.getText().toString();

        contact = e_contact.getText().toString();

        password = e_password.getText().toString();

        String method = "register";

        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute(method, name, email, contact, password);

        finish();
    }


}
