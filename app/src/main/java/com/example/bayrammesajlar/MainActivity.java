package com.example.bayrammesajlar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {

    private Button bt_pre,bt_share,bt_forw;
    private TextView tv_message;
    private ArrayList<String> messages;
    int current_messages = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineLayouts();
        filltheArrays();
        String c_messages = messages.get(current_messages);
        tv_message.setText(c_messages);



    }
    @Override
    public void onClick(View v){
    int  id = v.getId();
    switch (id)
    {
        case R.id.bt_forward:
            forward();
            break ;
        case  R.id.bt_previous:
                previous();
            break ;
        case R.id.bt_share:
                share();
            break ;




    }
    }
    private void filltheArrays(){
        messages.add("Şeker tadında bir Kurban Bayramı geçirmenizi diler, her şeyin gönlünüzce olmasını temenni ederiz iyi bayramlar…");
        messages.add("Kurban bir olmaktır, birlik olmaktır, birlikte olmaktır. Sevdiklerinizin hep yanınızda olduğu nica bayramlar geçirmeniz dileğiyle...");
        messages.add("Sevdiklerinizle beraber sağlıklı ve huzur içinde mutlu bir bayram geçirmenizi dileriz");
        messages.add("Kurban Bayramının güzelliğini ve bereketini yaşadığınız, sevdiklerinizle birlikte nice bayramlar dilerim.");
        messages.add("Mübarek Kurban Bayramının size ve sevdiklerinize mutluluk, huzur ve refah getirmesi dileğiyle. Kurban bayramınız mübarek olsun.. .");
        messages.add("Bir avuç dua, bir kucak sevgi, sıcak bir mesaj kapatır mesafeleri, birleştirir gönülleri, bir sıcak gülümseme, bir ufak hediye daha da yaklaştırır bizi birbirimize. Nice Kurban Bayramlarına…");
        messages.add("Bugün sevinç günü, kederleri bir yana bırakıp mutlu olalım. Kurban Bayramını doya doya yaşayalım. Hayırlı bayramlar.");
        messages.add("Her şeye kadir olan Yüce Allah, bizleri, doğru yoldan ve sevdiklerimizden ayırmasın! Hayırlı ve bereketli Kurban Bayramları dileğiyle.");


    }
    private void share() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, messages.get(current_messages)+" from serhat");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

        Log.i("Button State","share basıldı");
    }
    private void previous() {
        if (current_messages > 0) {
            Log.i("Button State", "previous basıldı");

            current_messages--;
            tv_message.setText(messages.get(current_messages));
        }
    }

    private void forward() {
        if (current_messages < messages.size() -1 ){
         current_messages++;
        tv_message.setText(messages.get(current_messages));

        Log.i("Button State","forward basıldı");}


    }
    private void defineLayouts(){

        bt_pre = findViewById(R.id.bt_previous);
        bt_pre.setOnClickListener(this);
        bt_share = findViewById(R.id.bt_share);
        bt_share.setOnClickListener(this);

        bt_forw = findViewById(R.id.bt_forward);
        bt_forw.setOnClickListener(this);

        tv_message = findViewById(R.id.tv_message);
        messages = new ArrayList<String>();

    }


}


