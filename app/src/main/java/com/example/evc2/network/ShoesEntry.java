package com.example.evc2.network;
import android.content.res.Resources;
import  android.net.Uri;
import android.util.Log;

import com.example.evc2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class ShoesEntry {
    private static final String TAG = ShoesEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String price;
    public final String description;

    public ShoesEntry(String title, String dynamicUrl, String url, String price, String description) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.price = price;
        this.description = description;
    }

    public static List<ShoesEntry> initShoesEntryList (Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.shoes);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0 , pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo error al cerrar el input stream", exception);
            }
        }
        String jsonshoesString = writer.toString();
        Gson gson = new Gson();
        Type shoeListType = new TypeToken<ArrayList<ShoesEntry>>(){
        }.getType();

        return gson.fromJson(jsonshoesString, shoeListType);
    }
}