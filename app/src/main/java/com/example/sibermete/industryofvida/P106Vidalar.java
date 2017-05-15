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

public class P106Vidalar extends Activity implements AdapterView.OnItemClickListener {

    public static final String VIDA_MAZEMESI="com.example.sibermete.industryofvida_VIDA_MAZEMESI";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p106vidalar);

        ListView listViewP106=(ListView)findViewById(R.id.listViewVidaMazemesiP106);

        String[] array=getResources().getStringArray(R.array.vida_mazemesi);
        ListAdapter listAdapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,array);
        listViewP106.setAdapter(listAdapter);

        listViewP106.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();

        try {
            Class className= Class.forName("com.example.sibermete.industryofvida.P106VidaCesidi");

            Intent intent = new Intent(this,className);
            String veri= String.valueOf(adapterView.getItemAtPosition(i));
            intent.putExtra(VIDA_MAZEMESI,veri);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
