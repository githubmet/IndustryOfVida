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

public class P106VidaKafasi extends Activity implements AdapterView.OnItemClickListener {

    public static final String VIDA_KAFASI_P107 ="com.example.sibermete.industryofvida.VIDA_KAFASI_P107";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p106vidakafasi);

        ListView listViewVidaKafasiP106=(ListView)findViewById(R.id.listViewVidaKafasiP106);

        String[] array=getResources().getStringArray(R.array.vida_kafasi);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);
        listViewVidaKafasiP106.setAdapter(listAdapter);

        listViewVidaKafasiP106.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();

        String veri= String.valueOf(adapterView.getItemAtPosition(i));
        Bundle bundle= getIntent().getExtras();
        String veri2="";
        if(bundle.containsKey(P107VidaBoyu.VIDA_BOYU_P107)) {
            veri2 = bundle.getString(P107VidaBoyu.VIDA_BOYU_P107);
        }
        else if(bundle.containsKey(P115SacVidaBoyu.SAC_VIDA_BOYU_P107)) {
            veri2 = bundle.getString(P115SacVidaBoyu.SAC_VIDA_BOYU_P107);
        }
        else if(bundle.containsKey(P116SuntaVidaBoyu.SUNTA_VIDA_BOYU_P107)) {
            veri2 = bundle.getString(P116SuntaVidaBoyu.SUNTA_VIDA_BOYU_P107);
        }
        else if(bundle.containsKey(P107VidaBoyu.VIDA_BOYU_P107)) {
            veri2 = bundle.getString(P107VidaBoyu.VIDA_BOYU_P107);
        }


        Intent intent=new Intent(this,P108PercinBoyu.class);
        intent.putExtra(VIDA_KAFASI_P107,veri2+"%"+veri);
        startActivity(intent);
    }
}

