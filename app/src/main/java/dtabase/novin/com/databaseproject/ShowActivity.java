package dtabase.novin.com.databaseproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context = this;
    ArrayList<Data>data = new ArrayList<>();
    AdapterData adapterData;
    Database database = new Database(context);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        data = database.ShowData();
        adapterData = new AdapterData(data,context);
        recyclerView=findViewById(R.id.recyShow);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapterData);
    }
}
