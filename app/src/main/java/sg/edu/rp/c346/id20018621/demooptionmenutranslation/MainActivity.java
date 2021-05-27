package sg.edu.rp.c346.id20018621.demooptionmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked = "";

    //context options
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        //to register TextView to the context menu should be associated by calling registerForContextMenu(),
        //pass in TextView variable
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    //options menu (top right)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //perform language transition (upon opt selected)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText.setText("Hello ");
            tvTranslatedText2.setText("Bye");
            return true;
        } else if (id == R.id.italianSelection) {
            tvTranslatedText.setText("Ciao");
            tvTranslatedText2.setText("Addio");
            return true;
        } else {
            tvTranslatedText.setText("Error translation");
        }

//        or if individually: (for bye/addio)
//        if (id == R.id.EnglishSelection) {
//            tvTranslatedText2.setText("Bye ");
//
//        } else if (id == R.id.italianSelection) {
//            tvTranslatedText2.setText("Addio ");
//
//        } else {
//            tvTranslatedText.setText("Error translation");
//        }
        return super.onOptionsItemSelected(item);
    }


    //for context
    //create Context Menu (long click event)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");
        if(v==tvTranslatedText){
            wordClicked = "1st";
        }else if(v == tvTranslatedText2){
            wordClicked = "bye";
        }
    }

    //menu selection
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("OnContextItemsSelected", "detected menuitem click");
        //for "1st (hello)
        if(wordClicked.equalsIgnoreCase("1st")){
            Log.d("OnContextItemsSelected", "detected action on 1st TextView");
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslatedText.setText("Hello");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslatedText.setText("Ciao");
                return true;  //menu item successfully handled
            }
        }
        //for "bye"
        if(wordClicked.equalsIgnoreCase("bye")){
            Log.d("OnContextItemsSelected", "detected action on 2nd TextView");
            //for 'bye'
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslatedText2.setText("Bye");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslatedText2.setText("Addio");
                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }



}