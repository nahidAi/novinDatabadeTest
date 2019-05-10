package dtabase.novin.com.databaseproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {
    private TextView textShow,textSave;
    private EditText edName,edFamily,edPhone;
    Context context =this;
    Database database = new Database(context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        edName =(EditText)findViewById(R.id.edName);
        edFamily =(EditText)findViewById(R.id.edFamily);
        edPhone =(EditText)findViewById(R.id.edPhONE);
        textSave =(TextView)findViewById(R.id.textSave);
        textShow =(TextView)findViewById(R.id.textShow);
        textSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarTool calendarTool = new CalendarTool();
                String date =calendarTool.getIranianYear()+"/"+calendarTool.getIranianMonth()+"/"+calendarTool.getIranianDay();
                database.InsertData(new Data(edName.getText().toString(),edFamily.getText().toString()
                        ,edPhone.getText().toString(),date));
                edFamily.setText("");
                edName.setText("");
                edPhone.setText("");
                Toast.makeText(getApplicationContext(), "اطلاعات ذخیره شد", Toast.LENGTH_SHORT).show();
            }
        });
        textShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SaveActivity.this,ShowActivity.class));
            }
        });
    }
}
