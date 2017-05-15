package com.example.sibermete.industryofvida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class P108PercinBoyu extends Activity implements View.OnClickListener {

    String veri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p108percinboyu);

        Button buttonAcceptP108= (Button)findViewById(R.id.buttonAcceptP108);
        Button buttonDenyP108= (Button)findViewById(R.id.buttonDenyP108);
        buttonAcceptP108.setOnClickListener(this);
        buttonDenyP108.setOnClickListener(this);


        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        veri =bundle.getString(P106VidaKafasi.VIDA_KAFASI_P107);
        TextView textViewSonucP108=(TextView)findViewById(R.id.textViewSonucP108);
        String[] array= veri.split("%");
        textViewSonucP108.setText("Vida cesidi= "+array[1]+"\n"+"Vida mazemesi= "+array[0]+"\n"+
                "Vida boyu= "+array[2]+"\n"+
                "Vid kafasi= "+array[3]+"\n");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonDenyP108:
                //Toast.makeText(this,"Denied",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, P106Vidalar.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            case R.id.buttonAcceptP108:

                EditText editTextP108=(EditText)findViewById(R.id.editTextP108);
                String percinBoyu= String.valueOf(editTextP108.getText());
                if(percinBoyu.isEmpty()){
                    Toast.makeText(this, R.string.percin_boyu_giriniz_p108,Toast.LENGTH_SHORT).show();
                }
                else{
                    P110SQLiteOpenHelper p110SQLiteOpenHelper=new P110SQLiteOpenHelper(this);
                    p110SQLiteOpenHelper.OpenMtd();

                    //when you cklick the button virtual keyword is gone
                    InputMethodManager inInputMethodManager= (InputMethodManager) getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
                    inInputMethodManager.hideSoftInputFromWindow(editTextP108.getWindowToken(),0);


                    String[] array= veri.split("%");
                    long gelenVeri= p110SQLiteOpenHelper.InsertMtd(array[0],array[1],array[2],array[3],"-->Percin="+editTextP108.getText().toString());
                    p110SQLiteOpenHelper.CloseMtd();
                    Toast.makeText(this, "Succesful "+gelenVeri,Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void onClickMtdP108(View view) {

        Intent intent =new Intent(this,P111GetAllData.class);
        startActivity(intent);
    }
}

