package fidpay.com;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;

public class ProfileHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PowerhouseDB.db";
    public static final String TABLE_NAME = "profile";
    public static final String NAME = "name";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String RISK_FACTOR = "riskfactor";
    public static final String PHONE_NUMBER = "phonenumber";
    public static final String EMAILID = "emailid";

    //initialize the database
    public ProfileHandler(Context context, Stringname, SQLiteDatabase.CursorFactoryfactory, intversion) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public ProfileHandler(Context context, Stringname,
                       SQLiteDatabase.CursorFactoryfactory, intversion) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + NAME +
                "TEXT," + USER_NAME + "TEXT PRIMARYKEY," + PASSWORD + "TEXT," + RISK_FACTOR+ "TEXT," + PHONE_NUMBER +"INTEGER(10)," + EMAILID + "TEXT)";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    public String loadHandler() {
        String result = "";
        String query = "Select*FROM" + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler(profile Prof) {
        ContentValues values = new ContentValues();
        values.put(NAME, Prof.getName());
        values.put(USER_NAME, Prof.getUsername());
        values.put(PASSWORD, Prof.getPassword());
        values.put(RISK_FACTOR, Prof.getRisk());
        values.put(PHONE_NUMBER, Prof.getPhonenumber());
        values.put(EMAILID, Prof.getEmail());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public profile findHandler(String studentname) {}
    public boolean deleteHandler(String username) {
        boolean result = false;
        String query = "Select*FROM" + TABLE_NAME + "WHERE" + USER_NAME + "= '" + username + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        profile prof = new profile();
        if (cursor.moveToFirst()) {
            prof.setUsername(username));
            db.delete(TABLE_NAME, USER_NAME + "=?",
                    newString[] {
                prof.getUsername();
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
    public boolean updateHandler(int ID, String name) {}
}

public class profile {
     private String Name;
     private String Username;
     private String Password;
     private String Riskfactor;
     private Integer Phonenumber;
     private String EmailId;

     public profile{}

     public profile(String Name, String Username, String Password, String Riskfactor, Integer Phonenumber, String EmailId){
         this.Name = Name;
         this.Username = Username;
         this.Password = Password;
         this.Riskfactor = Riskfactor;
         this.Phonenumber = Phonenumber;
         this.EmailId = EmailId;
     }
     public void setName(String Name){
         this.Name = Name;
     }
     public String getName(){
         return this.Name;
     }
}

