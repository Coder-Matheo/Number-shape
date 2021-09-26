package rob.myappcompany.numbershaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class  Number{
        int number;
        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }else {
                return false;
            }
        }
        public boolean isTriangular(){
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number){
                x++;
                triangularNumber = triangularNumber + x;
            }
            if(triangularNumber == number){
                return true;
            }else {
                return false;
            }
        }
    }

    public void testNumber(View view){



        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message = editText.getText().toString();
        if (editText.getText().toString().isEmpty()){
            message = " Please enter a number";
        }else {
            Number myNmber = new Number();
            myNmber.number = Integer.parseInt(editText.getText().toString());


            if (myNmber.isSquare() && myNmber.isTriangular()){
                message = editText.getText().toString() + " is square and triangulare!";
            }else if (myNmber.isSquare()){
                message += " is square and triangular";
            }else  if (myNmber.isTriangular()){
                message += " is triagular but not square";
            }else {
                message += " is neither triangular not square";
            }


        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}