package adapter;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heroes.R;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import api.APIInterface;
import api.APIURL;
import model.HeroModel;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    Context context;
    List<HeroModel> heroModelslist;

    public HeroAdapter(List<HeroModel> heroModelslist, Context context) {
        this.context = context;
        this.heroModelslist = heroModelslist;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_heros_detail, viewGroup, false);
        return new HeroViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder hvh, int i) {
        final HeroModel hm = heroModelslist.get(i);
        String imgPath = APIInterface.BASE_URL + "uploads/" + hm.getImageName();
        APIURL.strictMode();
        try {

            String imgUrl = "https://i.ytimg.com/vi/AGBjI0x9VbM/maxresdefault.jpg";
            URL url = new URL(imgUrl);
            hvh.imgView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));

        } catch (Exception e) {
            System.out.println(e);
        }
        hvh.tvName.setText(hm.getName());
        hvh.tvDesc.setText(hm.getDesc());


    }

    @Override
    public int getItemCount() {
        return heroModelslist.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {


        public TextView tvName, tvDesc;
        public ImageView imgView;


        public HeroViewHolder(@NonNull View iv) {
            super(iv);

            tvName = iv.findViewById(R.id.tvName);
            tvDesc = iv.findViewById(R.id.tvDesc);
            imgView = iv.findViewById(R.id.imageView);


        }
    }
}
