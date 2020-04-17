package com.arapeak.testeduhackapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;

import com.arapeak.model.ChooseTypeAccount;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements AdapterCallback {
    RecyclerView recycleView_number_lec_per_week;
    ChooseTimeAdapter chooseTimeAdapter1;

    RecyclerView recycleView_number_lec_per_once;
    ChooseTimeAdapter chooseTimeAdapter2;


    RecyclerView recycleView_number_week;
    ChooseTimeAdapter chooseTimeAdapter3;


    CardView card_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        recycleView_number_lec_per_week= findViewById(R.id.recycleView_number_lec_per_week);
        card_confirm= findViewById(R.id.card_confirm);
        //list1
        ArrayList<ChooseTypeAccount> listNumberLec= new ArrayList<>();
        listNumberLec.add( new ChooseTypeAccount( 11111,"1" ));
        listNumberLec.add( new ChooseTypeAccount( 11111,"2" ));
        listNumberLec.add( new ChooseTypeAccount( 11111,"3" ));
        listNumberLec.add( new ChooseTypeAccount( 11111,"4" ));
        listNumberLec.add( new ChooseTypeAccount( 11111,"5" ));
        listNumberLec.add( new ChooseTypeAccount( 11111,"6" ));

        chooseTimeAdapter1= new ChooseTimeAdapter(this,listNumberLec,this);
        chooseTimeAdapter1.setPositionSelected(1);
        recycleView_number_lec_per_week.setAdapter(chooseTimeAdapter1);





        recycleView_number_lec_per_once= findViewById(R.id.recycleView_number_lec_per_once);
        //list1
        ArrayList<ChooseTypeAccount> listNumberHours= new ArrayList<>();
        listNumberHours.add( new ChooseTypeAccount( 11111,"1" ));
        listNumberHours.add( new ChooseTypeAccount( 11111,"2" ));
        listNumberHours.add( new ChooseTypeAccount( 11111,"3" ));
        listNumberHours.add( new ChooseTypeAccount( 11111,"4" ));
        listNumberHours.add( new ChooseTypeAccount( 11111,"5" ));
        listNumberHours.add( new ChooseTypeAccount( 11111,"6" ));

        chooseTimeAdapter2= new ChooseTimeAdapter(this,listNumberHours,this);
        chooseTimeAdapter2.setPositionSelected(1);
        recycleView_number_lec_per_once.setAdapter(chooseTimeAdapter2);






        recycleView_number_week= findViewById(R.id.recycleView_number_week);
        //list1
        ArrayList<ChooseTypeAccount> listNumberWeek= new ArrayList<>();
        listNumberWeek.add( new ChooseTypeAccount( 11111,"1" ));
        listNumberWeek.add( new ChooseTypeAccount( 11111,"2" ));
        listNumberWeek.add( new ChooseTypeAccount( 11111,"3" ));
        listNumberWeek.add( new ChooseTypeAccount( 11111,"4" ));

        chooseTimeAdapter3= new ChooseTimeAdapter(this,listNumberWeek,this);
        chooseTimeAdapter3.setPositionSelected(1);
        recycleView_number_week.setAdapter(chooseTimeAdapter3);




        card_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CallActivity.class));

            }
        });
    }

    @Override
    public void onItemClick(int position, String tag) {

    }
}
