package narahari.com.areacalculator;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class AreaCalculator extends AppCompatActivity {

    EditText result;
    EditText length1;
    EditText length2;
    TextView shape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.splashScreenTheme);


        final TextView length1View = (TextView) findViewById(R.id.length1);
        final TextView length2View = (TextView) findViewById(R.id.length2);

        length1 = (EditText) findViewById(R.id.length1Value);
        length2 = (EditText) findViewById(R.id.length2value);
        result = (EditText) findViewById(R.id.resultValue);

        ImageView square = (ImageView) findViewById(R.id.square);
        ImageView triangle = (ImageView) findViewById(R.id.triangle);
        ImageView circle = (ImageView)findViewById(R.id.circle);

        shape = (TextView) findViewById(R.id.shapeselect);

        Button calculate = (Button) findViewById(R.id.calculatebutton);
        Button clear = (Button) findViewById(R.id.clearbutton);

        result.setEnabled(false);
        square.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               length2.setVisibility(View.INVISIBLE);
               length2View.setVisibility(View.INVISIBLE);
               length1View.setText("Side Length:");
               shape.setText("Square");
               shape.setTextColor(getResources().getColor(R.color.colorPrimary));
               result.setEnabled(false);
               length1.setText("");
               length2.setText("");
               result.setText("");
           }
        });

        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                length2.setVisibility(View.VISIBLE);
                length2View.setVisibility(View.VISIBLE);
                length1View.setText("Breadth:");
                length2View.setText("Height:");
                shape.setText("Triangle");
                shape.setTextColor(getResources().getColor(R.color.colorPrimary));
                result.setEnabled(false);
                length1.setText("");
                length2.setText("");
                result.setText("");
            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                length2.setVisibility(View.INVISIBLE);
                length2View.setVisibility(View.INVISIBLE);
                length1View.setText("Radius:");
                shape.setText("Circle");
                shape.setTextColor(getResources().getColor(R.color.colorPrimary));
                result.setEnabled(false);
                length1.setText("");
                length2.setText("");
                result.setText("");
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double side1;
                double side2;
                double area;
                DecimalFormat dFormat = new DecimalFormat("#.##");
                result.setEnabled(true);
                switch(shape.getText().toString())
                {
                        case "Square":

                            if(length1.getText().toString() != null && !length1.getText().toString().isEmpty()) {
                                side1 = Double.parseDouble(length1.getText().toString());
                                result = (EditText) findViewById(R.id.resultValue);
                                area = Double.valueOf(dFormat.format(side1 * side1));
                                result.setText(Double.toString(area));
                            }

                            else {

                                Toast.makeText( AreaCalculator.this,"Enter Length of Square to Proceed",Toast.LENGTH_LONG).show();
                            }
                        break;

                        case "Triangle":

                            if(length1.getText().toString() != null && length2.getText().toString() != null && !length1.getText().toString().isEmpty() && !length2.getText().toString().isEmpty()) {
                                side1 = Double.parseDouble(length1.getText().toString());
                                side2 = Double.parseDouble(length2.getText().toString());
                                area = Double.valueOf(dFormat.format(side1 * side2 * 0.5));
                                result.setText(Double.toString(area));
                            }

                            else {

                            Toast.makeText( AreaCalculator.this,"Enter Breadth and Height of Triangle to Proceed",Toast.LENGTH_LONG).show();
                        }
                        break;

                        case "Circle":
                            if(length1.getText().toString() != null && !length1.getText().toString().isEmpty()) {
                                side1 = Double.parseDouble(length1.getText().toString());
                                result = (EditText) findViewById(R.id.resultValue);
                                area = Double.valueOf(dFormat.format((side1 * side1 * 22) / 7));
                                result.setText(Double.toString(area));
                            }
                            else {

                                Toast.makeText( AreaCalculator.this,"Enter Radius of Circle to Proceed",Toast.LENGTH_LONG).show();
                            }
                        break;

                        default:
                            Toast.makeText(AreaCalculator.this,"Select a Shape to Proceed",Toast.LENGTH_LONG).show();

                }

                result.setEnabled(false);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                length1.setText("");
                length2.setText("");
                length2View.setVisibility(View.VISIBLE);
                length2.setVisibility(View.VISIBLE);
                length1View.setText("Length 1:");
                length2View.setText("Length 2:");
                result.setText("");
                result.setEnabled(false);
                shape.setText(getResources().getString(R.string.select));
            }
        });
    }

}
