package com.okhttptest.view;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.okhttptest.R;
import com.okhttptest.bean.WellRecevicebean;

import java.util.List;

/**
 * Created by hhmsw on 2017/9/21.
 */

public class WellReceivedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "WellReceivedAdapter";
    private static final int TYPE_FOOTER = 0;
    private static final int TYPE_ITEM = 1;
    private Context mContext;
    private List<WellRecevicebean.MsBean> mInfo = null;
    private ReceivedAdapterCallback mReceivedAdapterCallback = null;

    public interface ReceivedAdapterCallback{
        void Refrensh();
    }

    public WellReceivedAdapter(Context context,ReceivedAdapterCallback listener){
        mContext = context;
        mReceivedAdapterCallback = listener;
    }

    public void addData(List<WellRecevicebean.MsBean> info) {
        if (info != null) {
            this.mInfo = info;
        }
        if(mReceivedAdapterCallback !=null)
        mReceivedAdapterCallback.Refrensh();

    }


    @Override
    public int getItemCount() {
        if(mInfo != null){
            return mInfo.size();
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.well_item, parent,
                    false);
            return new ItemViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_foot, parent,
                    false);
            return new FootViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemHolder = (ItemViewHolder) holder;
            WellRecevicebean.MsBean bean = mInfo.get(position);
            Uri uri = Uri.parse(bean.getImg());

//          itemHolder.mflimImage.setImageURI(uri);

            int width = 50, height = 100;
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setResizeOptions(new ResizeOptions(width, height))
                    .setLocalThumbnailPreviewsEnabled(true)
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(itemHolder.mflimImage.getController())
                    .setImageRequest(request)
                    .build();
            itemHolder.mflimImage.setController(controller);

            itemHolder.mflimUpTimeTv.setText(bean.getRd());
            itemHolder.mflimNameTv.setText(bean.getT());
            itemHolder.mflimTypeTv.setText(bean.getMovieType());
            itemHolder.itemView.setTag(bean.getId());

            //holder.tv.setText(data.get(position));
//            if (onItemClickListener != null) {
//                holder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int position = holder.getLayoutPosition();
//                        onItemClickListener.onItemClick(holder.itemView, position);
//                    }
//                });
//
//                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        int position = holder.getLayoutPosition();
//                        onItemClickListener.onItemLongClick(holder.itemView, position);
//                        return false;
//                    }
//                });
//            }
        }

    }

    public interface ItemOnClickListener{
        void onClickListener(int moveId);
    }
    private ItemOnClickListener itemOnClickListener = null;
    public void setOnItemOnClickListener(ItemOnClickListener listener){
        itemOnClickListener = listener;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private SimpleDraweeView mflimImage;//影片图片
        private TextView mflimNameTv;//影片名称
        private TextView mflimUpTimeTv;//影片上映时间
        private TextView mflimTypeTv;//影片类型

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mflimImage = (SimpleDraweeView)itemView.findViewById(R.id.flim_Imageview);
            mflimNameTv = (TextView) itemView.findViewById(R.id.flim_Name);
            mflimUpTimeTv= (TextView) itemView.findViewById(R.id.flim_time);
            mflimTypeTv = (TextView) itemView.findViewById(R.id.flim_type);
        }

        @Override
        public void onClick(View v) {
            if(itemOnClickListener != null){
                itemOnClickListener.onClickListener(Integer.parseInt(v.getTag().toString()));
            }
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

}
