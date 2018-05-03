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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import butterknife.ButterKnife;
import ua.pchmykh.githubsearch.R;
import ua.pchmykh.githubsearch.net.pojo.JsonFullUser;

public class UsersAdapter  extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    private List<JsonFullUser> list = new ArrayList<>();
    private LinkedHashSet<JsonFullUser> reverseView = new LinkedHashSet<>();
    private ItemClickListener listener;


    public UsersAdapter(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        final UsersViewHolder mViewHolder = new UsersViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.init(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public JsonFullUser getUser(int pos){
        return list.get(pos);
    }

    public void setItems(JsonFullUser users) {
        list.clear();
        reverseView.add(users);
        list.addAll(reverseView);
        Collections.reverse(list);
        notifyDataSetChanged();
    }

    public void clearItems() {
        list.clear();
        reverseView.clear();
        notifyDataSetChanged();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder  {

        ImageView searchLogo;
        TextView searchName;
        TextView searchAddress;
        TextView searchLink;

         UsersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            searchName = itemView.findViewById(R.id.search_name);
            searchLogo = itemView.findViewById(R.id.search_logo);
            searchLink = itemView.findViewById(R.id.search_link);
            searchAddress = itemView.findViewById(R.id.search_address);
        }

         void init(JsonFullUser user){
            Picasso.get().load(user.getAvatarUrl()).into(searchLogo);
            searchName.setText(user.getLogin());
            searchAddress.setText(user.getLocation());
            searchLink.setText(user.getBlog());
         }
    }

    public interface ItemClickListener {

        void onItemClick(View v, int position);
    }

}
