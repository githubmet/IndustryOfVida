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
import android.widget.Toast;

public class P107VidaBoyu extends Activity implements AdapterView.OnItemClickListener {

    public static final String VIDA_BOYU_P107="com.example.sibermete.industryofvida.VIDA_BOYU_P107";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p107vidaboyu);

        ListView listViewVidaBoyuP107=(ListView)findViewById(R.id.listViewVidaBoyuP107);

        String[] array=getResources().getStringArray(R.array.metrik_vida_boyu);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1
                ,array);
        listViewVidaBoyuP107.setAdapter(listAdapter);
        listViewVidaBoyuP107.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();

        Intent intent =new Intent(this,P106VidaKafasi.class);
        String veri = String.valueOf(adapterView.getItemAtPosition(i));

        String veri2=getIntent().getExtras().getString(P112MetrikVidaTur.METRIK_VIDA_TUR);

        intent.putExtra(VIDA_BOYU_P107,veri2+" X "+veri);
        startActivity(intent);
    }
}
