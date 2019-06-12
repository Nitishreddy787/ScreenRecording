package com.nitish.screenrecording;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.nitish.adapter.ExampagerAdapter;
import com.nitish.beans.QuestionsAndOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamActivity extends AppCompatActivity {

    com.nitish.util.LockableViewPager pager;
    List<QuestionsAndOptions> questions=new ArrayList<>();
    ImageButton proceed;
    Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        pager=findViewById(R.id.pager);
        proceed=findViewById(R.id.proceed);
        back=findViewById(R.id.back);

        /*questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");
        questions.add( "Which method can be defined only once in a program?");*/
        for(int i=0;i<10;i++){
            QuestionsAndOptions questionsAndOptions=new QuestionsAndOptions("",new ArrayList<String>(),null);
            questionsAndOptions.setQuestion("Which method can be defined only once in a program?");
            List<String> options=new ArrayList<>();
            options.add("Hello 1");
            options.add("Hello 2");
            options.add("Hello 3");
            options.add("Hello 4");
            questionsAndOptions.setOptions(options);
            questions.add(questionsAndOptions);
        }

        pager.setSwipeable(false);
        pager.setAdapter(new ExampagerAdapter(ExamActivity.this, questions));

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() + 1,true);

                System.out.println("page number:::"+pager.getCurrentItem());
                if(pager.getCurrentItem() == (questions.size()-1)){
                    for(int i=0;i<questions.size();i++){
                        System.out.println(questions.get(i).getAnswer());
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() - 1,true);
            }
        });

        new CountDownTimer(1200000 ,1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                back.setText(""+String.format("%d : %d ",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                back.setText("done!");
            }
        }.start();

    }
}
