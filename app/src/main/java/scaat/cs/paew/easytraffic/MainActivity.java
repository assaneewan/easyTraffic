package scaat.cs.paew.easytraffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private ListView trafficListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //InitialWidget
        initialWidget();

        // Create ListView()
        createListView();

    } // Main Method
    // bind xml
    public void clickTest(View view) {
        startActivity(new Intent(this,TestActivity.class));
    } // clickTest

    private void createListView() {
        final String[] strTitle = new String[7];
        strTitle[0] = "ห้ามกลับ";
        strTitle[1] = "ห้ามกลับ";
        strTitle[2] = "จำกัดน้ำหนัก";
        strTitle[3] = "ห้ามแซง";
        strTitle[4] = "ห้ามแซง";
        strTitle[5] = "ออก";
        strTitle[6] = "เข้า";
//        strTitle[7] = "ออก";
//        strTitle[8] = "หยุด";
//        strTitle[9] = "จำกัดความสูง";
//        strTitle[10] = "ทางแยก";
//        strTitle[11] = "ห้ามกลับรถ";
//        strTitle[12] = "ห้ามจอด";
//        strTitle[13] = "รถสวน";
//        strTitle[14] = "ห้ามแซง";
//        strTitle[15] = "เข้า";
//        strTitle[16] = "หยุดตรวจ";
//        strTitle[17] = "จำกัดความเร็ว";
//        strTitle[18] = "จำกัดความกว้าง";
//        strTitle[19] = "จำกัดความสูง";

        final int[] intImage = {R.drawable.t1, R.drawable.t2, R.drawable.t3,
                R.drawable.t4, R.drawable.t5, R.drawable.t6,R.drawable.t7};

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intImage, strTitle);
        trafficListView.setAdapter(objMyAdapter);

        // Active onClick on ListView
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent to detail
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);
                objIntent.putExtra("Title", strTitle[position]);
                objIntent.putExtra("Image", intImage[position]);
                objIntent.putExtra("Detail", position);

                startActivity(objIntent);

            } // event
        });
    } // createListView

    private void initialWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
