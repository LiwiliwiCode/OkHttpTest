package com.okhttptest.adapter;

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
import com.okhttptest.bean.MoviecomingsBean;
import com.okhttptest.view.ReceivedAdapterCallback;

import java.util.List;

/**
 * Created by hhmsw on 2017/9/21.
 */

public class SoonReceivedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "SoonReceivedAdapter";
    private static final int TYPE_ITEM = 1;
    private Context mContext;
    private List<MoviecomingsBean> mInfo = null;
    private ReceivedAdapterCallback mReceivedAdapterCallback = null;

    public SoonReceivedAdapter(Context context, ReceivedAdapterCallback listener){
        mContext = context;
        mReceivedAdapterCallback = listener;
    }

    public void addData(List<MoviecomingsBean> info) {
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
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
      return TYPE_ITEM;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemHolder = (ItemViewHolder) holder;
            MoviecomingsBean bean = mInfo.get(position);
            Uri uri = Uri.parse(bean.getImage());

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

            itemHolder.mflimUpTimeTv.setText(bean.getReleaseDate());
            itemHolder.mflimNameTv.setText(bean.getTitle());
            itemHolder.mflimTypeTv.setText(bean.getType());
            itemHolder.itemView.setTag(bean);

        }

    }

    public interface ItemOnClickListener{
        void onClickListener(MoviecomingsBean bean);
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
                itemOnClickListener.onClickListener((MoviecomingsBean) v.getTag());
            }
        }
    }

}
