package com.example.xyzreader.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.xyzreader.R;

//adapter class
public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private String[] articleBody;

    public ArticleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.article_body_item, parent, false);
        return new ArticleBodyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArticleBodyViewHolder articleBodyViewHolder = (ArticleBodyViewHolder) holder;
        articleBodyViewHolder.bindArticleBody(position);
    }

    @Override
    public int getItemCount() {
        if (articleBody != null) {
            Log.i("Adapter", "item count: " + articleBody.length);
            return articleBody.length;
        }
        return 0;
    }

    public void setArticleData(String[] articles) {
        this.articleBody = articles;
        notifyDataSetChanged();
    }

    class ArticleBodyViewHolder extends RecyclerView.ViewHolder {

        final TextView articleBodyTextView;

        ArticleBodyViewHolder(View view) {
            super(view);
            articleBodyTextView = (TextView) view.findViewById(R.id.article_body_text);
        }

        void bindArticleBody(int position) {
            String bodyPart = articleBody[position];
            articleBodyTextView.setText(Html.fromHtml(bodyPart));
        }
    }
}
