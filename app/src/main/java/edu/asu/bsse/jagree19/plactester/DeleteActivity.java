package edu.asu.bsse.jagree19.plactester;

/*
 * DeleteActivity.java
 * Assign 7
 *
 * Copyright 2018 Justin Greene,
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: To remove a location from a database  as per assignment 7 SER423 2018 Spring B
 *
 * @author Justin Greene   mailto:jagree19@asu.edu
 * @version March 2018
 */

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeleteActivity extends AppCompatActivity {
   private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Intent i = getIntent();
        name = i.getStringExtra("name");
    }

    public void deleteLoc(View view) {
        String delete = "delete from locations where locations.name=?;";
        try {
            LocationDB db = new LocationDB(this);
            SQLiteDatabase locDB = db.openDB();
            locDB.execSQL(delete, new String[]{this.name});
            locDB.close();
            db.close();
            DeleteActivity.this.finish();
        } catch (Exception e) {
            android.util.Log.w(this.getClass().getSimpleName(), "error deleting location"+e.getMessage());
        }

    }
}
