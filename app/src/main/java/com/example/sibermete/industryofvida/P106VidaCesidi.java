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

public class P106VidaCesidi extends Activity implements AdapterView.OnItemClickListener {

    public static final String VIDA_CESIDI="com.example.sibermete.industryofvida_VIDA_CESIDI";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p106vidacesidi);

        ListView listViewVidaCesidiP106= (ListView)findViewById(R.id.listViewVidaCesidiP106);

        String[] array=getResources().getStringArray(R.array.vida_cesidi);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);
        listViewVidaCesidiP106.setAdapter(listAdapter);

        listViewVidaCesidiP106.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        //Intent intent =new Intent(this,P106VidaKafasi.class);
        String veri= String.valueOf(adapterView.getItemAtPosition(i));
        Intent intent;
        switch (i){
            case 0:
                intent=new Intent(this,P112MetrikVidaTur.class);
                break;
            case 1:
                intent=new Intent(this,P113SacVidaTur.class);
                break;
            case 2:
                intent=new Intent(this,P114SuntaVidaTur.class);
                break;
            case 3:
                intent=new Intent(this,P113SacVidaTur.class);
                break;
            default:
                intent=new Intent(this,P112MetrikVidaTur.class);
                break;
        }

        Intent intent2= getIntent();
        Bundle bundle= intent2.getExtras();
        String veri2= bundle.getString(P106Vidalar.VIDA_MAZEMESI);
        intent.putExtra(VIDA_CESIDI,veri2+"%"+veri);
        startActivity(intent);
    }
}
