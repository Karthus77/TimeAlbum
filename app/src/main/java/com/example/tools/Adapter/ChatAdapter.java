package com.example.tools.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tools.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ChatActivity context;
    private List<Map<String,Object>> list;
    private View inflater;
    public ChatAdapter(ChatActivity context, List<Map<String,Object>> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.item_chat,parent,false);
        ViewHolder viewHolder=new ViewHolder(inflater);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewholder = (ViewHolder) holder;
        viewholder.date.setText(list.get(position).get("date").toString());
            String k=list.get(position).get("type").toString();
            String c=list.get(position).get("choice").toString();
            if(k.equals("2"))
            {
                viewholder.head.setImageResource(R.drawable.message_like);
                if(c.equals("1"))
                viewholder.msg.setText("您点赞了《"+list.get(position).get("title")+"》这篇文章 ");
                else
                    viewholder.msg.setText("您取消点赞了《"+list.get(position).get("title")+"》这篇文章 ");
            }
            else if(k.equals("3"))
            {
                viewholder.head.setImageResource(R.drawable.message_collect);
                if(c.equals("1"))
                viewholder.msg.setText("您收藏了《"+list.get(position).get("title")+"》这篇文章 ");
                else
                    viewholder.msg.setText("您取消收藏了《"+list.get(position).get("title")+"》这篇文章 ");
            }
            else if(k.equals("4"))
            {
                viewholder.head.setImageResource(R.drawable.message_comment);
                viewholder.msg.setText("您评论了《"+list.get(position).get("title")+"》这篇文章 ");
            }
            else if(k.equals("5"))
            {
                viewholder.head.setImageResource(R.drawable.message_focus);
                if(c.equals("1"))
                viewholder.msg.setText("您关注了"+list.get(position).get("title")+" 这位作者 ");
                else
                    viewholder.msg.setText("您取消关注了"+list.get(position).get("title")+" 这位作者 ");
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView head;
        TextView date;
        TextView msg;
        public ViewHolder(View view) {
            super(view);
            head=view.findViewById(R.id.chat_head);
            date=view.findViewById(R.id.chat_date);
            msg=view.findViewById(R.id.chat_content);

        }
    }
}
