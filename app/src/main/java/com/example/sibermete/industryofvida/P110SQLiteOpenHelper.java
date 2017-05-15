package com.example.sibermete.industryofvida;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class P110SQLiteOpenHelper {

    private static final String DATABASE_NAME="dbVidalar2";//"com.example.sibermete.industryofvida.VIDALAR";
    private static final int DATABASE_VERSION_NUMBER= 1;
    private static final String TABLE_NAME="PERCIN_BOYU_TBL";
    public static final String KAYIT_ID="KAYIT_ID";
    public static final String VIDA_MAZEMESI="VIDA_MAZEMESI";
    public static final String VIDA_CESIDI="VIDA_CESIDI";
    public static final String VIDA_KAFA_TIPI="VIDA_KAFA_TIPI";
    public static final String VIDA_BOYU="VIDA_BOYU";
    public static final String PERCIN_BOYU="PERCIN_BOYU";

    private final Context context;
    private SQLiteDatabase sqLiteDatabase2;
    private P110CreateDatabase p110CreateDatabase;

    public P110SQLiteOpenHelper(Context context) {
        this.context=context;
    }

    public P110SQLiteOpenHelper OpenMtd(){
        p110CreateDatabase=new P110CreateDatabase(this.context);
        sqLiteDatabase2=p110CreateDatabase.getWritableDatabase();

        return this;
    }
    public void CloseMtd(){
        sqLiteDatabase2.close();
    }

    public long InsertMtd(String VIDA_MAZEMESI, String VIDA_CESIDI,
                          String VIDA_KAFA_TIPI, String VIDA_BOYU,
                          String PERCIN_BOYU){
        ContentValues contentValues=new ContentValues();
        contentValues.put(this.VIDA_MAZEMESI,VIDA_MAZEMESI);
        contentValues.put(this.VIDA_CESIDI,VIDA_CESIDI);
        contentValues.put(this.VIDA_KAFA_TIPI,VIDA_KAFA_TIPI);
        contentValues.put(this.VIDA_BOYU,VIDA_BOYU);
        contentValues.put(this.PERCIN_BOYU,PERCIN_BOYU);

        return sqLiteDatabase2.insert(TABLE_NAME,null,contentValues);
    }
    public String GetAllInfoMtd(){
        String[] columns={KAYIT_ID,VIDA_MAZEMESI,VIDA_CESIDI,VIDA_KAFA_TIPI,VIDA_BOYU,
                PERCIN_BOYU};
        Cursor cursor= sqLiteDatabase2.query(TABLE_NAME,columns,null,null,null,null,null);

        String katar="";
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            katar =katar +cursor.getInt(0)+" "+cursor.getString(1)+ " "+ cursor.getString(2)+
                    " "+cursor.getString(3)+ " "+ cursor.getString(4)+
                    " "+cursor.getString(5)+ "&\n";
        }
        return katar;

    }
    public void DeleteInfoById(String Id){
        sqLiteDatabase2.delete(TABLE_NAME,KAYIT_ID+" = "+Id,null);
    }
    public class P110CreateDatabase extends SQLiteOpenHelper{

        public P110CreateDatabase(Context context) {//, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION_NUMBER);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table "+TABLE_NAME+" ("+
                    KAYIT_ID+ " integer primary key autoincrement, "+
                    VIDA_MAZEMESI+" text not null, "+
                    VIDA_CESIDI +" text not null, "+
                    VIDA_KAFA_TIPI +" text not null, "+
                    VIDA_BOYU +" text not null, "+
                    PERCIN_BOYU +" text not null );" );

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists "+ TABLE_NAME);
        }
    }
}

