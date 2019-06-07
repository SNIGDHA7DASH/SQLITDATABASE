package com.example.iteradmin.sqlitdatabase

import android.content.Context
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = openOrCreateDatabase("database", Context.MODE_PRIVATE, null)
        database.execSQL("create table student (id number,name VARCHAR,marks VARCHAR);")
        database.execSQL("insert into student values(1,snigdha,010)")
        database.execSQL("insert into student values (2,smiki,078)")
        val cursor:Cursor = database.rawQuery("select * from student",null)

        Toast.makeText(this,"col count"+cursor.columnCount.toString(),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"row"+cursor.count.toString(),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"colom name at position 1"+cursor.columnNames[1].toString(),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"colom index"+cursor.getColumnIndex("name").toString(),Toast.LENGTH_LONG).show()
        Toast.makeText(this,"colom name"+cursor.getColumnName(1).toString(),Toast.LENGTH_LONG).show()
            }
}
