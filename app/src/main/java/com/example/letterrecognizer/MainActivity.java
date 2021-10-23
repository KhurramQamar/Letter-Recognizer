package com.example.letterrecognizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView skylet;
    String resetsky="b,d,f,h,k,l,t";
    private Button showsky;

    private TextView grasslet;
    String resetgrass="a,c,i,m,n,o,r,s,u,v,w,x,z";
    private Button showgrass;

    private TextView rootlet;
    String resetroot="g,j,p,q,y";
    private Button showroot;

    private EditText checkalpha;
    //String resetroot="g,j,p,q,y";
    private Button checkBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
        showsky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skylet.setText(resetsky);
                grasslet.setText("");
                rootlet.setText("");
            }
        });

        showgrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grasslet.setText(resetgrass);
                skylet.setText("");
                rootlet.setText("");
            }
        });

        showroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootlet.setText(resetroot);
                grasslet.setText("");
                skylet.setText("");

            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grasslet.setText("");
                skylet.setText("");
                rootlet.setText("");
                String c=checkalpha.getText().toString();
                try {


                    if (checkalpha.getText().toString() == null) {
                        checkalpha.setText("enter an alphabet");
                    } else if (checkalpha.getText().toString().length() > 1) {
                        checkalpha.setText("");
                        checkalpha.setHint("enter single alphabet");
                    } else if (Character.isUpperCase(checkalpha.getText().toString().charAt(0))) {
                        checkalpha.setText("");
                        checkalpha.setHint("enter small letter");
                    } else {
                        if (resetsky.indexOf(checkalpha.getText().toString()) >= 0) {
                            checkalpha.setText("");
                            checkalpha.setHint(c + " is a sky letter");
                        } else if (resetgrass.indexOf(checkalpha.getText().toString()) >= 0) {
                            checkalpha.setText("");
                            checkalpha.setHint(c + " is a grass letter");
                        } else {
                            checkalpha.setText("");
                            checkalpha.setHint(c + " is a root letter");
                        }
                    }
                }
                catch (Exception e)
                {
                    checkalpha.setHint("enter an alphabet");
                }
            }
        });

    }
    private void setUI()
    {
        showsky=findViewById(R.id.sky);
        skylet=findViewById(R.id.skyletters);

        showgrass=findViewById(R.id.grass);
        grasslet=findViewById(R.id.grassletters);

        showroot=findViewById(R.id.root);
        rootlet=findViewById(R.id.rootletters);

        checkalpha=findViewById(R.id.checkview);
        checkBtn=findViewById(R.id.check);
    }
}