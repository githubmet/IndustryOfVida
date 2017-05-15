package com.example.sibermete.industryofvida;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class P111GetAllData extends ListActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        P110SQLiteOpenHelper p110SQLiteOpenHelper=new P110SQLiteOpenHelper(this);
        p110SQLiteOpenHelper.OpenMtd();
        String veri=p110SQLiteOpenHelper.GetAllInfoMtd();
        p110SQLiteOpenHelper.CloseMtd();

        String[] array= veri.split("&");

        ListView listView= getListView();
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String rowData= String.valueOf(l.getItemAtPosition(position));
        final String idData= rowData.substring(0,rowData.indexOf(" "));

        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.temizlik_P111);
        alertDialogBuilder.setMessage(R.string.temizlik_ok_or_not_p111);

        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(P111GetAllData.this,idData,Toast.LENGTH_SHORT).show();
                P110SQLiteOpenHelper p110SQLiteOpenHelper=new
                        P110SQLiteOpenHelper(P111GetAllData.this);
                p110SQLiteOpenHelper.OpenMtd();
                p110SQLiteOpenHelper.DeleteInfoById(idData);
                p110SQLiteOpenHelper.CloseMtd();

                finish();
                startActivity(getIntent());

            }
        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(P111GetAllData.this,R.string.iptal_p111,Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.show();
    }
}



