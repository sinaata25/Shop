package myapp.co.shop.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import myapp.co.shop.R;
import myapp.co.shop.model.ModelNew;
import myapp.co.shop.model.ModelSpecialOfferHome;

public class HomeNewAdapter extends RecyclerView.Adapter<HomeNewAdapter.viewholder> {

        Context context;
        List<ModelNew> list;
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_product_new,parent,false);
        return new viewholder(view);
    }

    public HomeNewAdapter(Context context, List<ModelNew>list){
        this.list=list;
        this.context=context;

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       ModelNew modelNew=list.get(position);
       holder.textViewname.setText(modelNew.getName());
       holder.textViewPrice.setText(modelNew.getPrice());
        Picasso.get()
                .load(modelNew.getImage())
                //.resize(50, 50)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView textViewname;
        TextView textViewPrice;
        ImageView imageView;
        CardView cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textViewname=itemView.findViewById(R.id.textview_new_name);
            textViewPrice=itemView.findViewById(R.id.textview_new_price);
            imageView=itemView.findViewById(R.id.imageview_new);
            cardView=itemView.findViewById(R.id.card_new_home);

        }
    }



}
