package edu.asu.bsse.jagree19.plactester;

/*
 * PlaceDescription.java
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
 * Purpose: To display a place description as per assignment 7 SER423 2018 Spring B
 *
 * @author Justin Greene   mailto:jagree19@asu.edu
 * @version March 2018
 */

import org.json.JSONObject;

/**
 * Created by justingreene on 3/16/18.
 */

public class PlaceDescription {

    protected String name;
    protected String description;
    protected String category;
    protected String address_title;
    protected String address_street;
    protected Double elevation;
    protected Double latitude;
    protected Double longitude;

    public static final PlaceDescription place1 = new PlaceDescription("Home", "Where I Live", "Residence", "Mi casa", "67 Pebble Dr.", 16.52, 47.42, 72.77);

    //constructor for field by field input
    PlaceDescription (String _name, String _description, String _category, String _address_title, String _address_street,
                      Double _elevation, Double _latitude, Double _longitude) {

        name = _name;
        description = _description;
        category = _category;
        address_title = _address_title;
        address_street = _address_street;
        elevation = _elevation;
        latitude = _latitude;
        longitude = _longitude;

    }

    //constructor for json input
    PlaceDescription (String jsonStr) {

        try {
            JSONObject jo = new JSONObject(jsonStr);
            name = jo.getString("name");
            description = jo.getString("description");
            category = jo.getString("category");
            address_title = jo.getString("address_title");
            address_street = jo.getString("address_street");
            elevation = jo.getDouble("elevation");
            latitude = jo.getDouble("latitude");
            longitude = jo.getDouble("longitude");
        } catch (Exception ex) {
            android.util.Log.w(this.getClass().getSimpleName(),
                    "errror converting to/from json");
        }
    }

    // method to convert a placeDescription to a string value
    public String toJsonString () {
        String ret = "";
        try {
            JSONObject jo = new JSONObject();
            jo.put("name",name);
            jo.put("description", description);
            jo.put("category", category);
            jo.put("address_title", address_title);
            jo.put("address_street", address_street);
            jo.put("elevation", elevation);
            jo.put("latitude", latitude);
            jo.put("longitude", longitude);
        }catch (Exception ex){
            android.util.Log.w(this.getClass().getSimpleName(),
                    "errror converting to/from json");
        }
        return ret;
    }

}
