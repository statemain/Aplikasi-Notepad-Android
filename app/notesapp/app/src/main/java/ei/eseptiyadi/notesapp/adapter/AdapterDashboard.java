package ei.eseptiyadi.notesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
