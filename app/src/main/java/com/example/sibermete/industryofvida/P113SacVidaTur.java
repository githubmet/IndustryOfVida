package com.example.sibermete.industryofvida;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class P113SacVidaTur extends ListActivity {
    public static final String SAC_VIDA_BOYU_P107="com.example.sibermete.industryofvida.SAC_VIDA_TUR";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] array=getResources().getStringArray(R.array.sac_vida_tur);
        ListView listView= getListView();
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(listAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String veri= String.valueOf(l.getItemAtPosition(position));

        Intent intent= getIntent();
        String veri2=intent.getExtras().getString(P106VidaCesidi.VIDA_CESIDI);

        Intent intent2=new Intent(this,P115SacVidaBoyu.class);
        intent2.putExtra(SAC_VIDA_BOYU_P107,veri2+ "%" +veri);  //this one
        startActivity(intent2);


    }
}
