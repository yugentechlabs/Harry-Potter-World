package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class SortingQuiz extends AppCompatActivity {

    ProgressDialog progress;
    ImageView black,white,oneImage,twoImage,threeImage,fourImage;
    TextView oneText,twoText,threeText,fourText,question;
    ConstraintLayout one,two,three,four;
    LinearLayout options;
    int griffindor, slytherin, hufflepuff, ravenclaw;
    static String house="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorting_one_chess);

        griffindor=0;
        slytherin=0;
        ravenclaw=0;
        hufflepuff=0;

        showLoading();

        One();
    }

    private void One() {
        black=findViewById(R.id.black);
        white=findViewById(R.id.white);

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(black.getTag().toString().equals("RS")){
                    ravenclaw++;
                    slytherin++;
                }
                else{
                    griffindor++;
                    hufflepuff++;
                }
                setContentView(R.layout.sorting_whose_class);
                Two();
            }
        });

        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(white.getTag().toString().equals("HG")){
                    griffindor++;
                    hufflepuff++;
                }
                else{
                    ravenclaw++;
                    slytherin++;
                }
                setContentView(R.layout.sorting_whose_class);
                Two();
            }
        });
    }

    private void Two() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);
        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_remember);
                Three();
            }
        });
        
        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_remember);
                Three();
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_remember);
                Three();
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_remember);
                Three();
            }
        });
    }

    private void Three() {
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);

        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_subject);
                Four();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_subject);
                Four();
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_subject);
                Four();
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_subject);
                Four();
            }
        });
    }

    private void Four() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);

        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_dragons);
                Five();
            }
        });

        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_dragons);
                Five();
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_dragons);
                Five();
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_dragons);
                Five();
            }
        });
        
    }

    private void Five() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);

        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_text_options);
                Six();
            }
        });

        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_text_options);
                Six();
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_text_options);
                Six();
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_text_options);
                Six();
            }
        });
    }

    private void Six() {
        oneText=findViewById(R.id.one);
        twoText=findViewById(R.id.two);
        threeText=findViewById(R.id.three);
        fourText=findViewById(R.id.four);

        question=findViewById(R.id.question);

        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(oneText);
        YoYo.with(Techniques.BounceInRight).duration(700).repeat(0).playOn(twoText);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(threeText);
        YoYo.with(Techniques.BounceInRight).duration(700).repeat(0).playOn(fourText);

        oneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_animagus);
                Seven();
            }
        });

        twoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_animagus);
               Seven();
            }
        });

        threeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_animagus);
                Seven();
            }
        });

        fourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_animagus);
                Seven();
            }
        });
    }

    private void Seven() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);
        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_road);
                Eight();
            }
        });

        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_road);
                Eight();
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_road);
               Eight();
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_road);
                Eight();
            }
        });
    }

    private void Eight() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);
        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_bring_back_from_dead);
                Nine();
            }
        });

        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_bring_back_from_dead);
                Nine();
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_bring_back_from_dead);
                Nine();
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_bring_back_from_dead);
                Nine();
            }
        });
    }

    private void Nine() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);
        question=findViewById(R.id.question);
        options=findViewById(R.id.options);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(options);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                setContentView(R.layout.sorting_text_options);
                Ten();
            }
        });

        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                setContentView(R.layout.sorting_text_options);
                Ten();
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                setContentView(R.layout.sorting_text_options);
                Ten();
            }
        });

        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                setContentView(R.layout.sorting_text_options);
                Ten();
            }
        });
    }

    private void Ten() {
        oneText=findViewById(R.id.one);
        twoText=findViewById(R.id.two);
        threeText=findViewById(R.id.three);
        fourText=findViewById(R.id.four);
        question=findViewById(R.id.question);

        question=findViewById(R.id.question);

        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(oneText);
        YoYo.with(Techniques.BounceInRight).duration(700).repeat(0).playOn(twoText);
        YoYo.with(Techniques.BounceInLeft).duration(700).repeat(0).playOn(threeText);
        YoYo.with(Techniques.BounceInRight).duration(700).repeat(0).playOn(fourText);

        question.setText("You come face to face with a death eater, what would you do?");
        oneText.setText("Use one of the unforgivable curses");
        twoText.setText("Create a distraction using riddikulus and take cover");
        threeText.setText("Disarm him with expelliarmus");
        fourText.setText("Defend against his spells with Protego");

        oneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                showHouse();
            }
        });

        twoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                showHouse();
            }
        });

        threeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                griffindor++;
                showHouse();
            }
        });

        fourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                showHouse();
            }
        });
    }

    private void showHouse() {
      if(griffindor>=slytherin && griffindor>=hufflepuff && griffindor>=ravenclaw){
          ArrayList<String> arr=new ArrayList<>();
          arr.add("Gryffindor");
          if(griffindor==slytherin){
              arr.add("Slytherin");
          }
          if(griffindor==ravenclaw)
          {
              arr.add("Ravenclaw");
          }
          if(griffindor==hufflepuff){
              arr.add("Hufflepuff");
          }
          randomHouse(arr);
      }
      else if(slytherin>=griffindor && slytherin>=hufflepuff && slytherin>=ravenclaw){
          ArrayList<String> arr=new ArrayList<>();
          arr.add("Slytherin");
          if(slytherin==griffindor){
              arr.add("Gryffindor");
          }
          if(slytherin==ravenclaw)
          {
              arr.add("Ravenclaw");
          }
          if(slytherin==hufflepuff){
              arr.add("Hufflepuff");
          }
          randomHouse(arr);
        }
      else if(hufflepuff>=griffindor && hufflepuff>=slytherin && hufflepuff>=ravenclaw){
          ArrayList<String> arr=new ArrayList<>();
          arr.add("Hufflepuff");
          if(hufflepuff==griffindor){
              arr.add("Gryffindor");
          }
          if(hufflepuff==ravenclaw)
          {
              arr.add("Ravenclaw");
          }
          if(hufflepuff==slytherin){
              arr.add("Slytherin");
          }
          randomHouse(arr);
      }
      else{
          ArrayList<String> arr=new ArrayList<>();
          arr.add("Ravenclaw");
          if(ravenclaw==griffindor){
              arr.add("Gryffindor");
          }
          if(ravenclaw==slytherin)
          {
              arr.add("Slytherin");
          }
          if(ravenclaw==hufflepuff){
              arr.add("Hufflepuff");
          }
          randomHouse(arr);
      }
    }

    private void randomHouse(ArrayList<String> arr) {
        Random r=new Random();
        int i=r.nextInt(arr.size());
        house=arr.get(i);
        HouseCard houseCard=new HouseCard();
        houseCard.show(getSupportFragmentManager(),"House");
    }

    void showLoading(){
        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progress.dismiss();
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        ExitQuiz e=new ExitQuiz();
        e.show(getSupportFragmentManager(),"Exit");
    }
}