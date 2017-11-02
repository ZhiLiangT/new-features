package omeng.bbwhm.com.weixin.file_manage.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import omeng.bbwhm.com.weixin.R;


/**
 * 文件夹列表适配器
 * Created by tianzl on 2017/8/31.
 */

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    private Context context;
    private List<FolderChooserInfo> infos;
    private LayoutInflater inflater;
    public FolderAdapter(Context context,List<FolderChooserInfo> infos){
        this.context=context;
        this.infos=infos;
        inflater=LayoutInflater.from(context);
    }
    public void setData(List<FolderChooserInfo> mData){
    	infos.clear();
    	infos.addAll(mData);
    	notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_folder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        FolderChooserInfo info=infos.get(position);
        holder.tvName.setText(info.getName() == null ? "" : info.getName());
        holder.ivIcon.setImageResource(info.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFolderItemClick(view,position,infos.get(position));
            }
        });
    }
    public interface OnFolderItemClickListener{
        void onFolderItemClick(View view, int position, FolderChooserInfo info);
    }
    private OnFolderItemClickListener listener;
    public void setOnFolderItemClickListener(OnFolderItemClickListener listener){
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName=(TextView) itemView.findViewById(R.id.item_name);
            ivIcon=(ImageView) itemView.findViewById(R.id.item_icon);
        }
    }
}
