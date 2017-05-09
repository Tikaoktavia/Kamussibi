package com.example.blesscom.kamusisyarat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

    /**
     * Created by Blesscom on 3/7/2017.
     */
    public class Kamus extends AppCompatActivity {

        List<GetDataAdapter> GetDataAdapter1;

        RecyclerView recyclerView;

        RecyclerView.LayoutManager recyclerViewlayoutManager;

        RecyclerView.Adapter recyclerViewadapter;

        private List<String> list = new ArrayList<String>();

        Adapter mAdapter;

        private RecyclerViewAdapter mAdapter2;


        String GET_JSON_DATA_HTTP_URL = Timthumb.php? src="http://kamusskrpsi.esy.es/cup/ImageJsonData.php"&w=50&h=50;

        String JSON_IMAGE_TITLE_NAME = "image_title";
        String JSON_IMAGE_URL = "image_url";
        private static final String TAG = MainActivity.class.getSimpleName();

        //If server response is equal to this that means login is successful
        public static final String KEY_SUCCESS = "success";


        JsonArrayRequest jsonArrayRequest;

        RequestQueue requestQueue;

        // Search Text
        SearchView searchView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_kamus);

            //pencarian
            searchView = (SearchView) findViewById(R.id.search_view);

            recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            JSON_DATA_WEB_CALL();

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    mAdapter2.getFilter().filter(query);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    mAdapter2.getFilter().filter(newText);
                    return true;
                }
            });

        }

        public void JSON_DATA_WEB_CALL() {

            jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL,



                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            JSON_PARSE_DATA_AFTER_WEBCALL(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

            requestQueue = Volley.newRequestQueue(this);

            requestQueue.add(jsonArrayRequest);
        }

        public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

            GetDataAdapter1 = new ArrayList<>();


            for (int i = 0; i < array.length(); i++) {

                GetDataAdapter GetDataAdapter2 = new GetDataAdapter();

                JSONObject json = null;
                try {

                    json = array.getJSONObject(i);

                    GetDataAdapter2.setImageTitleNamee(json.getString(JSON_IMAGE_TITLE_NAME));

                    GetDataAdapter2.setImageServerUrl(json.getString(JSON_IMAGE_URL));

                } catch (JSONException e) {

                    e.printStackTrace();
                }

                GetDataAdapter1.add(GetDataAdapter2);

            }

            mAdapter2 = new RecyclerViewAdapter((ArrayList<GetDataAdapter>) GetDataAdapter1,this);
            recyclerView.setAdapter(mAdapter2);

        }






    }