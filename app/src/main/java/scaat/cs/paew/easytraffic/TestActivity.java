package scaat.cs.paew.easytraffic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    // explicit
    private TextView questionTextView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton,
            choice3RadioButton, choice4RadioButton;
    private String[] questionStrings;
    private int[] imageInts;
    private int radioAnInt, indexAnInt, scoreAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //bind Widget
        bindWidget();

        // radio controller
        radioController();
    }  //onCreate


    public void  clickAnswer(View view) {

        if (radioAnInt==0) {
            Toast.makeText(TestActivity.this,"กรุงณาตอบคำถามด้วยจ้า",Toast.LENGTH_LONG).show();
        } else {
            checkScore();
            myModel();

        }

    } // clickAnswer

    private void myModel() {
        if (indexAnInt == 6) {
            showAnswerDialog();

        } else {
            // check Score
            checkScore();
            indexAnInt += 1;

            // change View
            changeView(indexAnInt);

            // clear check
            choiceRadioGroup.clearCheck();
        }
    } // myModel

    private void checkScore() {

        int[] intTrueAnswer = {1, 2, 3, 1, 2, 3, 1};
        if (radioAnInt == intTrueAnswer[indexAnInt]) {
            scoreAnInt++;
        }

    } // checkScore

    private void changeView(int indexAnInt) {
        //change Question
        questionTextView.setText(questionStrings[indexAnInt]);

        // change ImageView
        trafficImageView.setImageResource(imageInts[indexAnInt]);

        // change Choice
        int[] intTimes = {R.array.times1, R.array.times2, R.array.times3, R.array.times4, R.array.times5, R.array.times6, R.array.times7};
        String[] strChoice = getResources().getStringArray(intTimes[indexAnInt]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

    } // changeView

    private void showAnswerDialog() {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.p4);
        objBuilder.setTitle("คะแนนสอบของคุณ");
        objBuilder.setMessage("คะแนนที่คุณสอบได้" + Integer.toString(scoreAnInt) + "คะแนน");
        objBuilder.setCancelable(false);
        objBuilder.setNegativeButton("เล่นอีกครั้ง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onStart();
                dialog.dismiss();
            }
        });
        objBuilder.setPositiveButton("อ่านบทเรียน", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent objIntent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(objIntent);
                dialog.dismiss();
            }
        });
        objBuilder.show();
    } // showAnswerDialog

    private void radioController() {

        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }
            }
        });

    }

    @Override
    protected void onStart() {
        // Setup
        questionStrings = getResources().getStringArray(R.array.question);
        imageInts = new int[7];
        imageInts[0] = R.drawable.t1;
        imageInts[1] = R.drawable.t2;
        imageInts[2] = R.drawable.t3;
        imageInts[3] = R.drawable.t4;
        imageInts[4] = R.drawable.t5;
        imageInts[5] = R.drawable.t6;
        imageInts[6] = R.drawable.t7;

        indexAnInt = 0;
        scoreAnInt = 0;

        String[] strChoice = getResources().getStringArray(R.array.times1);

        //Just Start
        questionTextView.setText(questionStrings[0]);
        trafficImageView.setImageResource(imageInts[0]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);


        super.onStart();
    } //onStart



    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuesttion);
        trafficImageView = (ImageView) findViewById(R.id.imvTrafficTest);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChioce);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
}  //main class
