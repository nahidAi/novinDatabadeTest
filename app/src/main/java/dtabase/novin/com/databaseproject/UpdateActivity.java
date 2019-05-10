package dtabase.novin.com.databaseproject;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.ShortBufferException;

public class UpdateActivity extends AppCompatActivity {
    private TextView textSave;
    private EditText edName, edFamily, edPhone;
    Context context = this;
    Database database = new Database(context);
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(getApplicationContext());
        edName = (EditText) findViewById(R.id.edName);
        edFamily = (EditText) findViewById(R.id.edFamily);
        edPhone = (EditText) findViewById(R.id.edPhONE);
        textSave = (TextView) findViewById(R.id.textSave);
         id = getIntent().getStringExtra("id");
        Toast.makeText(context, id + "", Toast.LENGTH_SHORT).show();
        edName.setText(getIntent().getStringExtra("name"));
        edFamily.setText(getIntent().getStringExtra("family"));
        edPhone.setText(getIntent().getStringExtra("phone"));
        final String date = getIntent().getStringExtra("date");


        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.Update(new Data(edName.getText().toString(), edFamily.getText().toString(), edPhone.getText().toString(), date), Integer.parseInt(id));
                edFamily.setText("");
                edName.setText("");
                edPhone.setText("");
                Toast.makeText(getApplicationContext(), "اطلاعات تغییر کرد", Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(UpdateActivity.this, ShowActivity.class);
                        startActivity(intent);

                    }
                },500);

            }
        });



    }
}
