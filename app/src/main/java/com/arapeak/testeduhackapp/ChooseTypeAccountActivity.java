package com.arapeak.testeduhackapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.arapeak.model.ChooseTypeAccount;

import java.util.ArrayList;

public class ChooseTypeAccountActivity extends AppCompatActivity  implements AdapterCallback{

    RecyclerView recycleView_choose_type_account;
    RecyclerView recycleView_choose_time_type_account;
    RecyclerView recycleView_choose_day_type_account;
    RecyclerView recycleView_skill;
    ChooseTypeAdapter chooseTypeAdapter;
    ChooseTimeAdapter chooseTimeAdapter;
    ChooseTimeAdapter chooseTimeAdapter2;
    ChooseTimeAdapter chooseTimeAdapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type_account);
        recycleView_choose_type_account= findViewById(R.id.recycleView_choose_type_account);
        recycleView_choose_time_type_account= findViewById(R.id.recycleView_choose_time_type_account);
        recycleView_choose_day_type_account= findViewById(R.id.recycleView_choose_day_type_account);
        recycleView_skill= findViewById(R.id.recycleView_skill);



        //list1
        ArrayList<ChooseTypeAccount> listAccounts= new ArrayList<>();
        listAccounts.add( new ChooseTypeAccount( R.drawable.team,"لأطفالك" ));
        listAccounts.add( new ChooseTypeAccount( R.drawable.boss,"لك أنت" ));
        chooseTypeAdapter= new ChooseTypeAdapter(this,listAccounts,this);
        chooseTypeAdapter.setPositionSelected(1);
        recycleView_choose_type_account.setAdapter(chooseTypeAdapter);

        //list2
        ArrayList<ChooseTypeAccount> listchooseTimes= new ArrayList<>();
        listchooseTimes.add( new ChooseTypeAccount( R.drawable.weather,"أول الصباح" ));
        listchooseTimes.add( new ChooseTypeAccount( R.drawable.cloud,"الظهر" ));
        listchooseTimes.add( new ChooseTypeAccount( R.drawable.sun,"العصر" ));
        listchooseTimes.add( new ChooseTypeAccount( R.drawable.sea,"المغرب" ));
        chooseTimeAdapter= new ChooseTimeAdapter(this,listchooseTimes,this);
        chooseTimeAdapter.setPositionSelected(1);
        recycleView_choose_time_type_account.setAdapter(chooseTimeAdapter);


        //list3
        ArrayList<ChooseTypeAccount> listdays= new ArrayList<>();
        listdays.add( new ChooseTypeAccount( 11111,"السبت" ));
        listdays.add( new ChooseTypeAccount( 11111,"الأحد" ));
        listdays.add( new ChooseTypeAccount( 11111,"الاثنين" ));
        listdays.add( new ChooseTypeAccount( 11111,"الثلاثاء" ));
        listdays.add( new ChooseTypeAccount( 11111,"الأربعاء" ));
        listdays.add( new ChooseTypeAccount( 11111,"الخميس" ));
        listdays.add( new ChooseTypeAccount( 11111,"الجمعة" ));
        chooseTimeAdapter2= new ChooseTimeAdapter(this,listdays,this);
        chooseTimeAdapter2.setPositionSelected(1);
        recycleView_choose_day_type_account.setAdapter(chooseTimeAdapter2);


        //list3
        ArrayList<ChooseTypeAccount> listSkills= new ArrayList<>();
        listSkills.add( new ChooseTypeAccount( 11111,"محادثة" ));
        listSkills.add( new ChooseTypeAccount( 11111,"تحضير\n توفير" ));
        listSkills.add( new ChooseTypeAccount( 11111,"تحضير\n ايلتس" ));
        listSkills.add( new ChooseTypeAccount( 11111,"لغة انجليزية\n عامة" ));
        listSkills.add( new ChooseTypeAccount( 11111,"قواعد" ));
        chooseTimeAdapter3= new ChooseTimeAdapter(this,listSkills,this);
        chooseTimeAdapter3.setPositionSelected(1);
        recycleView_skill.setAdapter(chooseTimeAdapter3);




    }

    @Override
    public void onItemClick(int position, String tag) {
    }
}
