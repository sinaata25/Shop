package myapp.co.shop.adapters;

import android.content.Context;
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
import myapp.co.shop.model.Model_Categories;

public class HomeCategoriesAdapter extends RecyclerView.Adapter<HomeCategoriesAdapter.viewholder> {

        Context context;
        List<Model_Categories> list;
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.categories_home_fragment_item,parent,false);
        return new viewholder(view);
    }

    public HomeCategoriesAdapter(Context context,List<Model_Categories>list){
        this.context=context;
        this.list=list;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Model_Categories model_categories=list.get(position);
        holder.textView.setText(model_categories.getName());
        Picasso.get()
                .load(model_categories.getImage())
                //.resize(50, 50)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        CardView cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview_categories_item);
            imageView=itemView.findViewById(R.id.imageview_categories_item);
            cardView=itemView.findViewById(R.id.card_home_categories_item);

        }
    }



}
