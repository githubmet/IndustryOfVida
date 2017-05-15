package com.example.sibermete.industryofvida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

//import static com.example.kkldfkld.myapplication.P107VidaBoyu.VIDA_BOYU_P107;

public class P115SacVidaBoyu extends Activity implements AdapterView.OnItemClickListener {

    public static final String SAC_VIDA_BOYU_P107="com.example.sibermete.industryofvida.SAC_VIDA_BOYU_P107";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p107sacvidaboyu);

        ListView listViewSacVidaBoyuP115=(ListView)findViewById(R.id.listViewSacVidaBoyuP115);

        String[] array=getResources().getStringArray(R.array.sac_vida_boyu);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1
                ,array);
        listViewSacVidaBoyuP115.setAdapter(listAdapter);
        listViewSacVidaBoyuP115.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();


        String veri = String.valueOf(adapterView.getItemAtPosition(i));
        String veri2=getIntent().getExtras().getString(P113SacVidaTur.SAC_VIDA_BOYU_P107);
        Intent intent =new Intent(this,P106VidaKafasi.class);
        intent.putExtra(SAC_VIDA_BOYU_P107,veri2+" X "+veri);
        startActivity(intent);
    }
}


