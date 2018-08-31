
package com.example.asus.androadamyakala;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.os.Handler;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView ;
    ImageView imageView2 ;
    ImageView imageView3 ;
    ImageView imageView4 ;
    ImageView imageView5 ;
    ImageView imageView6 ;
    ImageView imageView7 ;
    ImageView imageView8 ;
    ImageView imageView9 ;
    ImageView[] imageArray ;
    Handler handler;
    Runnable run;
    TextView skorText;
    int skor ;
    CountDownTimer countDownTimer;
    android.support.v7.app.AlertDialog AlertDialog;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8= (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageArray = new ImageView[] {imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        gizle();
        skor = 0;
        countDownTimer= new CountDownTimer(20000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                TextView zamanText= (TextView) findViewById(R.id.zamanText);
                zamanText.setText("Zaman : "+millisUntilFinished /1000);
            }

            @Override
            public void onFinish() {
                TextView zamanText= (TextView) findViewById(R.id.zamanText);
                zamanText.setText("Oyun Bitti :)");
                handler.removeCallbacks(run);


                bitis();


            }
        }.start();

    }

    public void skorum(View view){


         skorText= (TextView) findViewById(R.id.skorText);
        skor++;
        skorText.setText("Skor : "+ skor);
    }
    public void gizle(){
        handler = new Handler();
        run=new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);

                }

                Random r = new Random();
                int i = r.nextInt(9 - 0);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(run,750);

            }

        };
        handler.post(run);
    }



    public void yenidenBasla(){


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Beni " + skor + " defa  Yakaladın!");
        builder.setMessage("Tekrar Oynamak İstermisiniz ?");
        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("");
                builder.setMessage("Beni Yakala Uygulamasından çıkılsın mı ?");
                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {



                    }
                });


                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);

                    }
                });


                builder.show();

            }
        });


        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        builder.show();
    }


    public void bitis(){

        CountDownTimer bitis = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setVisibility(View.VISIBLE);
                skorText.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFinish() {

                yenidenBasla();
            }
        }.start();
        imageArray[0].setVisibility(View.INVISIBLE);
        imageArray[1].setVisibility(View.INVISIBLE);
        imageArray[2].setVisibility(View.INVISIBLE);
        imageArray[3].setVisibility(View.INVISIBLE);
        imageArray[4].setVisibility(View.INVISIBLE);
        imageArray[5].setVisibility(View.INVISIBLE);
        imageArray[6].setVisibility(View.INVISIBLE);
        imageArray[7].setVisibility(View.INVISIBLE);
        imageArray[8].setVisibility(View.INVISIBLE);

    }


}
