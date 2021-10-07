package jaspreet.markscalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;


public class MainActivity extends AppCompatActivity
{


    public double in=0,out=0,prev=0,position=0;
    String stringdouble;
    void pos(int p)
    {
        position=p;
    }
    double calc(double n)
    {
        switch((int) position){
        case 0:
            return n/2;
        case 1:
            return n/3;
        case 2:
            return n/4;
        case 3:
            return n/5;
        case 4:
            return n/6;
        case 5:
            return n/7;
        case 6:
            return n/8;
        case 7:
            return n/9;
        case 8:
            return n*10;
        case 9:
            return n*5;
        case 10:
            return n/0.3;
        case 11:
            return n/0.4;
        case 12:
            return n*2;
        case 13:
            return n/0.6;
        case 14:
            return n/0.7;
        case 15:
            return n/0.8;
        case 16:
            return n/0.9;

        }
    return 0;
    }
    void outp(EditText output)
    {
        out=calc(in);
        out=out*10;
        out=round(out);
        out=out/10;

        if(position<=7 && out>10) {
            output.setText("Error");
        }
        else if(position>7 && out>100)
        {
            output.setText("Error");
        }
        else
         {
            String stringdouble = String.format("%.1f", out);

            output.setText(stringdouble);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button back=findViewById(R.id.back);
        final Button bhalf=findViewById(R.id.bhalf);
        final Button b0=findViewById(R.id.b0);
        final Button b1=findViewById(R.id.b1);
        final Button b2=findViewById(R.id.b2);
        final Button b3=findViewById(R.id.b3);
        final Button b4=findViewById(R.id.b4);
        final Button b5=findViewById(R.id.b5);
        final Button b6=findViewById(R.id.b6);
        final Button b7=findViewById(R.id.b7);
        final Button b8=findViewById(R.id.b8);
        final Button b9=findViewById(R.id.b9);
        final Button ce=findViewById(R.id.ce);
        final EditText input = (EditText) findViewById(R.id.input);
        final EditText output = (EditText) findViewById(R.id.output);

            Spinner spin = (Spinner) findViewById(R.id.spin);
            final String option[] = {
                    "20 -->> 10",   //  0 n/2
                    "30 -->> 10",   //  1 n/3
                    "40 -->> 10",   //  2 n/4
                    "50 -->> 10",   //  3 n/5
                    "60 -->> 10",   //  4 n/6
                    "70 -->> 10",   //  5 n/7
                    "80 -->> 10",   //  6 n/8
                    "90 -->> 10",   //  7 n/9
                    "10 -->> 100",  //  8 n*10
                    "20 -->> 100",  //  9 n*5
                    "30 -->> 100",  //  10 n/.3
                    "40 -->> 100",  //  11 n/.4
                    "50 -->> 100",  //  12 n*2
                    "60 -->> 100",  //  13 n/.6
                    "70 -->> 100",  //  14 n/.7
                    "80 -->> 100",  //  15 n/.8
                    "90 -->> 100"}; //  16 n/.9
            ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, option);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                pos(position);
                Toast.makeText(getApplicationContext(),option[position] , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        output.setText("0.0");
        input.setText("0");
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(prev==0.5) {
                    in = in - 0.5;
                    prev=0;
                }

                else {
                    int temp=(int)in/10;
                    in=temp;
                }

                    stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);


            }
        });
        bhalf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(prev!=0.5)
                    in=in+0.5;
                prev=0.5;
                String stringdouble= Double.toString(in);
                outp(output);
                input.setText(stringdouble);

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10;
                prev=0;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                prev=1;
                in=in*10+1;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+2;
                prev=2;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+3;
                prev=3;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+4;
                prev=4;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+5;
                prev=5;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+6;
                prev=6;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+7;
                prev=7;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+8;
                prev=8;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=in*10+9;
                prev=9;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                in=0;
                prev=0;
                String stringdouble= Double.toString(in);
                outp(output);
                if((in*10)%10==0)
                {
                    stringdouble = String.format("%.0f", in);
                }
                input.setText(stringdouble);
            }
        });




    }
}
