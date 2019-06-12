package com.nitish.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nitish.beans.QuestionsAndOptions;
import com.nitish.screenrecording.R;

import java.util.ArrayList;
import java.util.List;

public class ExampagerAdapter extends PagerAdapter {

    private Context context;
    private List<QuestionsAndOptions> questions=new ArrayList<>();
    private LayoutInflater inflater;

    public ExampagerAdapter(Context context, List<QuestionsAndOptions> questions) {
        this.context=context;
        this.questions=questions;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup view, final int position) {

        View v = inflater.inflate(R.layout.fragment_questions, view, false);

        final TextView question=v.findViewById(R.id.title);
        TextView txt_demo_desc=v.findViewById(R.id.txt_demo_desc);

        final TextView option1=v.findViewById(R.id.option1);
        final TextView option2=v.findViewById(R.id.option2);
        final TextView option3=v.findViewById(R.id.option3);
        final TextView option4=v.findViewById(R.id.option4);


        if( questions.get(position).getAnswer() == null){
            option1.setTextColor(Color.parseColor("#ffffff"));
            option2.setTextColor(Color.parseColor("#ffffff"));
            option3.setTextColor(Color.parseColor("#ffffff"));
            option4.setTextColor(Color.parseColor("#ffffff"));
        }else{
            for(int i=0;i<questions.get(position).getOptions().size();i++){
                if(questions.get(position).getAnswer().equals(questions.get(position).getOptions().get(i))){
                    switch (i){
                        case 0:
                            option1.setTextColor(Color.parseColor("#f2863e"));
                            break;

                        case 1:
                            option2.setTextColor(Color.parseColor("#f2863e"));
                            break;

                        case 2:
                            option3.setTextColor(Color.parseColor("#f2863e"));
                            break;

                        case 3:
                            option4.setTextColor(Color.parseColor("#f2863e"));
                            break;
                    }
                }
            }
        }

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setTextColor(Color.parseColor("#f2863e"));
                option2.setTextColor(Color.parseColor("#ffffff"));
                option3.setTextColor(Color.parseColor("#ffffff"));
                option4.setTextColor(Color.parseColor("#ffffff"));

                questions.get(position).setAnswer(questions.get(position).getOptions().get(0));
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setTextColor(Color.parseColor("#ffffff"));
                option2.setTextColor(Color.parseColor("#f2863e"));
                option3.setTextColor(Color.parseColor("#ffffff"));
                option4.setTextColor(Color.parseColor("#ffffff"));

                questions.get(position).setAnswer(questions.get(position).getOptions().get(1));
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setTextColor(Color.parseColor("#ffffff"));
                option2.setTextColor(Color.parseColor("#ffffff"));
                option3.setTextColor(Color.parseColor("#f2863e"));
                option4.setTextColor(Color.parseColor("#ffffff"));

                questions.get(position).setAnswer(questions.get(position).getOptions().get(2));
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setTextColor(Color.parseColor("#ffffff"));
                option2.setTextColor(Color.parseColor("#ffffff"));
                option3.setTextColor(Color.parseColor("#ffffff"));
                option4.setTextColor(Color.parseColor("#f2863e"));

                questions.get(position).setAnswer(questions.get(position).getOptions().get(3));
            }
        });

        question.setText(questions.get(position).getQuestion());
        txt_demo_desc.setText((position+1)+"/"+questions.size());

        view.addView(v, 0);

        return v;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
