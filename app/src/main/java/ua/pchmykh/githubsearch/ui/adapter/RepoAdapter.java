package ua.pchmykh.githubsearch.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.pchmykh.githubsearch.R;
import ua.pchmykh.githubsearch.net.pojo.JsonRepo;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<JsonRepo> list = new ArrayList<>();

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        final RepoAdapter.RepoViewHolder mViewHolder = new RepoAdapter.RepoViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.init(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(List<JsonRepo> repo) {
        list.addAll(repo);
        notifyDataSetChanged();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {

        TextView repoName;
        TextView repoDesc;

        RepoViewHolder(View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repo_name);
            repoDesc = itemView.findViewById(R.id.repo_desc);

        }

        void init(JsonRepo repo) {
            repoName.setText(repo.getName());
            repoDesc.setText(repo.getDescription());
        }
    }
}