import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {


    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLHelper dbhelper = new SQLHelper(this);

        database = openOrCreateDatabase("sqlitetable",MODE_PRIVATE,null);
        dbhelper.onCreate(database);
        database.execSQL("CREATE TABLE IF NOT EXISTS sqlitetable(Username VARCHAR,Password VARCHAR);");

        final EditText nameTextfield = (EditText)findViewById(R.id.editname);
        final EditText addressTextfield = (EditText)findViewById(R.id.editadd);
        final EditText phoneTextfield = (EditText)findViewById(R.id.editphone);
        final TextView dataview = (TextView)findViewById(R.id.textView);
        final Button saveButton = (Button) findViewById(R.id.button1);
        final Button dropButton = (Button) findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dbhelper.insertEntry(nameTextfield.getText().toString(),addressTextfield.getText().toString(),phoneTextfield.getText().toString());
                dataview.setText(null);
                ArrayList dat = dbhelper.getAllEntries();
                int count=1;
                for (int i = 0; i < dat.size();i++){
                    if(count>2){
                        count=0;
                        dataview.setText(dataview.getText()+" "+dat.get(i)+"\n");
                    }
                    else dataview.setText(dataview.getText()+" "+dat.get(i));
                    count++;
                }
                dataview.setText(dataview.getText()+"\n");
            }
        });

        dropButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dbhelper.deleteTable();
                String toastText = "Table dropped. Whoops.";
                database = openOrCreateDatabase("sqlitetable",MODE_PRIVATE,null);
                dbhelper.onCreate(database);
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context,toastText,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
