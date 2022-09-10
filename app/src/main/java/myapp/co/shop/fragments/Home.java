package myapp.co.shop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.co.shop.R;
import myapp.co.shop.adapters.HomeCategoriesAdapter;
import myapp.co.shop.adapters.HomeNewAdapter;
import myapp.co.shop.adapters.HomeSpecialOffersAdapter;
import myapp.co.shop.adapters.SliderAdapter;
import myapp.co.shop.data.Keys;
import myapp.co.shop.data.Urls;
import myapp.co.shop.model.ModelNew;
import myapp.co.shop.model.ModelSpecialOfferHome;
import myapp.co.shop.model.Model_Categories;
import myapp.co.shop.model.SliderData;


public class Home extends Fragment {
    View view;
    SliderView sliderView;
    RecyclerView recyclerView;
    RecyclerView recyclerViewNewProduct;
    RecyclerView recyclerViewSpecial;
    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";
    List<Model_Categories>list_categories;
    List<ModelSpecialOfferHome>listSpecialOffers;
    List<ModelNew>listNewProducts;
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.home_fragment,container,false);
        setUpViews();
        sets();
        //serverRequest();
        return view;
    }

    private void sets(){
        setUpImageSlider();
        load_categories();
        loadSpecialOffers();
        loadNewProducts();
    }

    private void loadNewProducts() {
        listNewProducts=new ArrayList<>();
        //
        ModelNew modelNew=new ModelNew();
        modelNew.setId(0);
        modelNew.setName("تیشرت مدل جیورجیو آرمانی");
        modelNew.setPrice("1,000,000 تومان");
        modelNew.setImage(url1);
        listNewProducts.add(modelNew);
        //
        ModelNew modelNew1=new ModelNew();
        modelNew1.setId(0);
        modelNew1.setName("تیشرت مدل جیورجیو آرمانی");
        modelNew1.setPrice("1,000,000 تومان");
        modelNew1.setImage(url1);
        listNewProducts.add(modelNew1);
        //
        ModelNew modelNew2=new ModelNew();
        modelNew2.setId(0);
        modelNew2.setName("تیشرت مدل جیورجیو آرمانی");
        modelNew2.setPrice("1,000,000 تومان");
        modelNew2.setImage(url2);
        listNewProducts.add(modelNew2);
        //
        ModelNew modelNew3=new ModelNew();
        modelNew3.setId(0);
        modelNew3.setName("تیشرت مدل جیورجیو آرمانی");
        modelNew3.setPrice("1,000,000 تومان");
        modelNew3.setImage(url2);
        listNewProducts.add(modelNew3);
        //
        ModelNew modelNew4=new ModelNew();
        modelNew4.setId(0);
        modelNew4.setName("تیشرت مدل جیورجیو آرمانی");
        modelNew4.setPrice("1,000,000 تومان");
        modelNew4.setImage(url3);
        listNewProducts.add(modelNew4);
        //
        recyclerViewNewProduct.setAdapter(new HomeNewAdapter(getContext(),listNewProducts));
    }

    private void loadSpecialOffers() {
        listSpecialOffers=new ArrayList<>();
        //
        ModelSpecialOfferHome modelSpecialOfferHome=new ModelSpecialOfferHome();
        modelSpecialOfferHome.setId(0);
        modelSpecialOfferHome.setName("تیشرت مدل جیورجیو آرمانی");
        modelSpecialOfferHome.setCurrentPrice("1,000,000 تومان");
        modelSpecialOfferHome.setLastPrice("890,000 تومان");
        modelSpecialOfferHome.setImage(url1);
        listSpecialOffers.add(modelSpecialOfferHome);
        //
        ModelSpecialOfferHome modelSpecialOfferHome1=new ModelSpecialOfferHome();
        modelSpecialOfferHome1.setId(1);
        modelSpecialOfferHome1.setName("تیشرت سگ");
        modelSpecialOfferHome1.setCurrentPrice("1,000,000 تومان");
        modelSpecialOfferHome1.setLastPrice("890,000 تومان");
        modelSpecialOfferHome1.setImage(url2);
        listSpecialOffers.add(modelSpecialOfferHome1);
        //
        ModelSpecialOfferHome modelSpecialOfferHome2=new ModelSpecialOfferHome();
        modelSpecialOfferHome2.setId(2);
        modelSpecialOfferHome2.setName("شلوار خر");
        modelSpecialOfferHome2.setCurrentPrice("2,000,000 تومان");
        modelSpecialOfferHome2.setLastPrice("840,000 تومان");
        modelSpecialOfferHome2.setImage(url3);
        listSpecialOffers.add(modelSpecialOfferHome2);
        //
        ModelSpecialOfferHome modelSpecialOfferHome3=new ModelSpecialOfferHome();
        modelSpecialOfferHome3.setId(3);
        modelSpecialOfferHome3.setName("انسان مرد");
        modelSpecialOfferHome3.setCurrentPrice("8,000,000 تومان");
        modelSpecialOfferHome3.setLastPrice("790,000 تومان");
        modelSpecialOfferHome3.setImage(url1);
        listSpecialOffers.add(modelSpecialOfferHome3);
        //
        ModelSpecialOfferHome modelSpecialOfferHome4=new ModelSpecialOfferHome();
        modelSpecialOfferHome4.setId(4);
        modelSpecialOfferHome4.setName("مردانه");
        modelSpecialOfferHome4.setCurrentPrice("1,000,000 تومان");
        modelSpecialOfferHome4.setLastPrice("890,000 تومان");
        modelSpecialOfferHome4.setImage(url2);
        listSpecialOffers.add(modelSpecialOfferHome4);
        //
        recyclerViewSpecial.setAdapter(new HomeSpecialOffersAdapter(getContext(),listSpecialOffers));
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
         //categories
         recyclerView=view.findViewById(R.id.recycler_home_categories);
         recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
         //specials
        recyclerViewSpecial=view.findViewById(R.id.recycler_home_special_sell);
        recyclerViewSpecial.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        //new products
        recyclerViewNewProduct=view.findViewById(R.id.recycler_home_new_clothes);
        recyclerViewNewProduct.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        //

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

    void load_categories(){
        list_categories=new ArrayList<>();
        //
        Model_Categories model_categories=new Model_Categories();
        model_categories.setId(0);
        model_categories.setName("پوشاک مردانه");
        model_categories.setImage(url1);
        list_categories.add(model_categories);
        //
        Model_Categories model_categories1=new Model_Categories();
        model_categories1.setId(1);
        model_categories1.setName("پوشاک زنانه");
        model_categories1.setImage(url1);
        list_categories.add(model_categories1);
        //
        Model_Categories model_categories2=new Model_Categories();
        model_categories2.setId(2);
        model_categories2.setName("پوشاک بچه گانه");
        model_categories2.setImage(url1);
        list_categories.add(model_categories2);

        recyclerView.setAdapter(new HomeCategoriesAdapter(getContext(),list_categories));
    }





}
