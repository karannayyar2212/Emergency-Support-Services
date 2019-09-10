package com.example.ess;

import android.os.AsyncTask;
import android.provider.ContactsContract;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPlacesData extends AsyncTask<Object,String, String> {

String googleplacesdata;
GoogleMap nMap;
String url;
    @Override
    protected String doInBackground(Object... objects) {
        nMap =(GoogleMap)objects[0];
        url= (String)objects[1];
        DownloadUrl downloadUrl=new DownloadUrl();
        try {
            googleplacesdata = downloadUrl.readurl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googleplacesdata;
    }

    @Override
    protected void onPostExecute(String s) {
        List<HashMap<String,String>>nearbyPlaceList = null;
        DataParser parser = new DataParser();
        nearbyPlaceList=parser.parse(s);
        showNearbyPlaces(nearbyPlaceList);
    }
    private void showNearbyPlaces(List<HashMap<String,String>>nearbyPlaceList)
    {
        for(int i=0;i<nearbyPlaceList.size();i++)
        {
            MarkerOptions markerOptions=new MarkerOptions();
            HashMap<String,String> googlePlace= nearbyPlaceList.get(i);
            String placeName =googlePlace.get("place_name");
            String vicinity =googlePlace.get("vicinity");
            Double lat =Double.parseDouble(googlePlace.get("lat"));
            Double lng =Double.parseDouble(googlePlace.get("lng"));

            LatLng latLng=new LatLng(lat,lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName +":"+ vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            nMap.addMarker(markerOptions);
            nMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            nMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        }
    }
}
