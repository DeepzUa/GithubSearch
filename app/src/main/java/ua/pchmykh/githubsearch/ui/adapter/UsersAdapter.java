package ua.pchmykh.githubsearch.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.pchmykh.githubsearch.R;
import ua.pchmykh.githubsearch.net.pojo.user.Item;

public class UsersAdapter  extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    private List<Item> list = new ArrayList<>();

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.init(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(Collection<Item> tweets) {
        list.clear();
        list.addAll(tweets);
        notifyDataSetChanged();
    }

    public void clearItems() {
        list.clear();
        notifyDataSetChanged();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.search_logo)
        ImageView searchLogo;
        @BindView(R.id.search_name)
        TextView searchName;
        @BindView(R.id.search_address)
        TextView searchAddress;
        @BindView(R.id.search_link)
        TextView searchLink;

         UsersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            searchName = itemView.findViewById(R.id.search_name);
            searchLogo = itemView.findViewById(R.id.search_logo);
        }

         void init(Item user){
            Picasso.get().load(user.getAvatarUrl()).into(searchLogo);
            searchName.setText(user.getLogin());
        }
    }

}
