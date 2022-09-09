package myapp.co.shop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import myapp.co.shop.IntroInterface;
import myapp.co.shop.R;
import myapp.co.shop.adapters.SliderAdapter;
import myapp.co.shop.data.Keys;
import myapp.co.shop.data.Urls;
import myapp.co.shop.model.SliderData;


public class Home extends Fragment {
    View view;
    SliderView sliderView;
    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.home_fragment,container,false);
        setUpViews();
        sets();
        serverRequest();
        return view;
    }

    private void sets(){
        setUpImageSlider();
    }

   public void setUpImageSlider() {
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        SliderAdapter adapter = new SliderAdapter(getContext(), sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    private void setUpViews() {
         sliderView = view.findViewById(R.id.slider);
    }

   void serverRequest(){
       StringRequest stringRequest=new StringRequest(Request.Method.POST, Urls.urlGetImageSilder, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               try {
                   JSONArray jsonArray=new JSONArray(response);
                   System.out.println(jsonArray);
               } catch (JSONException e) {
                   e.printStackTrace();
               }

           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
           }
       }){
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String> param;
               param = new HashMap<>();
                 param.put("key", Keys.key_home_image_priview);
               return param;
           }
       };


       RequestQueue requestQueue= Volley.newRequestQueue(getContext());
       stringRequest.setRetryPolicy(new DefaultRetryPolicy());
       requestQueue.add(stringRequest);

   }







}
