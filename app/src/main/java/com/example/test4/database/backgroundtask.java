package com.example.test4.database;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bridgelabz4 on 17/2/16.
 */
public class backgroundtask extends AsyncTask<Void,Void,Void> {
    ProgressDialog progressDialog;
    Context otx;
    public backgroundtask(Context ctx){
        this.otx=ctx;

    }
    String json_url="http://jsonplaceholder.typicode.com/albums";
    @Override
    protected void onPreExecute() {
        progressDialog= new ProgressDialog(otx);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("please wait");
        progressDialog.setMessage("downloading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected Void doInBackground(Void... params) {
//        try {
//            URL url= new URL(json_url);
//
//            HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
//            InputStream inputStream=httpURLConnection.getInputStream();
//            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder stringBuilder= new StringBuilder();
//            String line ;
//            while ((line=bufferedReader.readLine())!= null){
//                stringBuilder.append(line);
//                Thread.sleep(10);
//
//            }
//            httpURLConnection.disconnect();
 //           String jsonda=stringBuilder.toString().trim();
             Jsonurlcall jsonurlcall= new Jsonurlcall();
                JSONArray jsonArray=jsonurlcall.getjsonurl(json_url);




            //JSONObject jsonObject= new JSONObject(jsonda);
            //JSONArray jsonArray=jsonObject.getJSONArray("");
           // JSONArray jsonArray= jsonObject.getjsonurl(Url);

            //same code
            Databasehelper databasehelper= new Databasehelper(otx);
            SQLiteDatabase sqLiteDatabase=databasehelper.getWritableDatabase();
            int count=0;

//            while(count<jsonArray.length()){
//                JSONObject jo=jsonArray.getJSONObject(count);
//                count++;
//                databasehelper.putinfo(jo.getString("userID")
//                        ,jo.getString("id"),
//                        jo.getString("title"),
//                        sqLiteDatabase);
//
//            }
        for (int i=0;i<jsonArray.length();i++){
            try{
                JSONObject c= jsonArray.getJSONObject(i);
                Log.e("" + c.getString("userId"), "" + c.getString("id"));

                String title=c.getString("title");
                String id=c.getString("id");
                String user=c.getString("userId");

                databasehelper.putinfo(title,id,user,sqLiteDatabase);

            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }

            databasehelper.close();

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
       progressDialog.dismiss();
    }

    //post

//    public JSONArray getjsonurl(String url) {
//        StringBuilder stbuil = new StringBuilder();
//        HttpClient hclient = new DefaultHttpClient();
//        HttpGet htget = new HttpGet(url);
//        try {
//            HttpResponse hresp = hclient.execute(htget);
//            StatusLine statusLine = hresp.getStatusLine();
//            int Statuscode = statusLine.getStatusCode();
//            if (Statuscode == 200) {
//                HttpEntity entity = hresp.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader buffread = new BufferedReader(new InputStreamReader(content));
//                String Line;
//                while ((Line = buffread.readLine()) != null) {
//                    stbuil.append(Line);
//                }
//            } else {
//                Log.e("d==", "download not completed");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
    }
