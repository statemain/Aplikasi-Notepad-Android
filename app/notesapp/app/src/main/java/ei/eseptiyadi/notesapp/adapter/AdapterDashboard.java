package ei.eseptiyadi.notesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.model.listdatanotes.ListnotesItem;
// Buat Extend
// Alt + Enter
public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.MyViewHolder> {

    // Constructor
    Context context;
    List<ListnotesItem> listnotesItems;

    public AdapterDashboard (Context context, List<ListnotesItem> listnotesItems) {
        this.context = context;
        this.listnotesItems = listnotesItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listnotes, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txLabel.setText(listnotesItems.get(position).getTitleofNotes());
        holder.txDate.setText(listnotesItems.get(position).getDateCreated()
                + "  ॰  " + listnotesItems.get(position).getUsername()
                + "  ॰  " + listnotesItems.get(position).getCategoryofNotes());

        // Muncul adalah Notes -> icn_notes
        String category = listnotesItems.get(position).getCategoryofNotes().toString();

        if (category.equals("Notes")) {
            holder.picNotes.setImageResource(R.drawable.icn_notes);
        } else if (category.equals("Task")) {
            holder.picNotes.setImageResource(R.drawable.icn_task);
        } else if (category.equals("To do")) {
            holder.picNotes.setImageResource(R.drawable.icn_todo);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item yang dipilih adalah " + listnotesItems.get(position).getTitleofNotes(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listnotesItems.size();
    }

    // Buat Class MyViewHolder dengan Extend > kalo ada error alt + enter buat constructor matching
    // Not null (hapus)
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView picNotes;
        TextView txLabel, txDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            picNotes = (ImageView)itemView.findViewById(R.id.img_notes);
            txLabel = (TextView)itemView.findViewById(R.id.txtTittle);
            txDate = (TextView)itemView.findViewById(R.id.txtInformation);
        }
    }
}
