package com.alorma.intendencia.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.alorma.intendencia.domain.Menu;

public class MenusAdapter extends RecyclerArrayAdapter<Menu, MenusAdapter.Holder> {
  public MenusAdapter(LayoutInflater inflater) {
    super(inflater);
  }

  @Override
  protected void onBindViewHolder(MenusAdapter.Holder holder, Menu menu) {
    holder.textView.setText(menu.getName());
  }

  @Override
  public MenusAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new Holder(getInflater().inflate(android.R.layout.simple_list_item_1, parent, false));
  }

  public class Holder extends RecyclerView.ViewHolder {
    @Bind(android.R.id.text1) TextView textView;

    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (getCallback() != null) {
            getCallback().onItemSelected(getItem(getAdapterPosition()));
          }
        }
      });
    }
  }
}
