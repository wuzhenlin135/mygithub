package com.tencent.djcity.my;

import com.tencent.djcity.R;
import java.util.ArrayList;

import com.tencent.djcity.util.Config;
import com.tencent.djcity.util.ImageLoadListener;
import com.tencent.djcity.util.ImageLoader;
import com.tencent.djcity.util.ToolUtil;
import com.tencent.djcity.util.activity.BaseActivity;
import com.tencent.djcity.util.activity.BaseActivity.DestroyListener;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class OrderListAdapter extends BaseAdapter implements DestroyListener, ImageLoadListener, OnClickListener {
	private LayoutInflater mInflater;
	private ArrayList<OrderItemModel> mModels;
	private ImageLoader mImageLoader;
	private BaseActivity activity;
	
//	private int          payType;

	public OrderListAdapter(BaseActivity activity, ArrayList<OrderItemModel> dataSource) {

		mInflater = LayoutInflater.from(activity);
		mModels = dataSource;
		this.activity = activity;

//		this.payType = aPayType;
		mImageLoader = new ImageLoader(activity, Config.CHANNEL_PIC_DIR, true);

		activity.addDestroyListener(this);
	}

	@Override
	public int getCount() 
	{
		return null != mModels ? mModels.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, final ViewGroup parent) {
		
		ItemHolder holder = null;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_order_list, null);
			holder = new ItemHolder();
			holder.pImage = (ImageView) convertView.findViewById(R.id.order_image);
			holder.pName = (TextView) convertView.findViewById(R.id.order_name);
			holder.pPrice = (TextView) convertView.findViewById(R.id.order_price);
			holder.pStatus = (TextView) convertView.findViewById(R.id.order_status);

			convertView.setTag(holder);
		} else {
			holder = (ItemHolder) convertView.getTag();
		}

		if(null != mModels && 0 != mModels.size()) {
			OrderItemModel model = mModels.get(position);
			loadImage(holder.pImage, model.getGoodPic());
			holder.pName.setText(model.getGoodName());
			holder.pPrice.setText("金额："+ToolUtil.toPrice(model.getPayAmount()));
//			holder.pStatus.setText("已出库");
			setStatus(holder.pStatus, model.getStatus());
		}
		

		return convertView;
	}

	private void loadImage(ImageView view, String url) {
		Bitmap data = mImageLoader.get(url);
		if (data != null) {
			view.setImageBitmap(data);
			return;
		}
		view.setImageBitmap(mImageLoader.getLoadingBitmap(activity));
		mImageLoader.get(url, this);
	}
	
	private void setStatus(TextView view, int nStatus) {
		if(null == view) {
			return;
		}
		
		String strStatus = "";
		if(0 == nStatus) {
			strStatus = "未付款";
		}else if(1 == nStatus) {
			strStatus = "发货中";
		}else if(3 == nStatus) {
			strStatus = "已发货";
		}else if(-1 == nStatus) {
			strStatus = "用户取消";
		}else if(-2 == nStatus) {
			strStatus = "系统取消";
		}
		
		view.setText(strStatus);
	}

	@Override
	public void onDestroy() {
		mModels = null;
		mImageLoader.cleanup();
		mImageLoader = null;
	}

	@Override
	public void onLoaded(Bitmap image, String url) {
		notifyDataSetChanged();
	}
	
	@Override
	public void onError(String strUrl) {
	}

	private static class ItemHolder {
		ImageView pImage;
		TextView pName;
		TextView pPrice;
		TextView pStatus;

	}

	@Override
	public void onClick(View v) {
		Object pTag = v.getTag();

		if (pTag != null) {
//			EventProductModel pModel = (EventProductModel) pTag;
//			Bundle param = new Bundle();
//			param.putLong(ItemActivity.REQUEST_PRODUCT_ID, pModel.getProductId());
//			if(pModel.getChannelId() > 0) //场景多价商品
//				param.putInt(ItemActivity.REQUEST_CHANNEL_ID, pModel.getChannelId());
//			param.putInt(ItemActivity.REQUEST_PAY_TYPE, this.payType);
//			ToolUtil.startActivity(activity, ItemActivity.class, param);
//			
//			String pageId = "199050";
//			if(activity instanceof Event1Activity){
//				pageId = "1990"+ (50+((Event1Activity)activity).getEventId());
//			}
//			//01011
//			String locationId = "";
//			int id = (Integer) v.getTag(R.layout.event_1_item);
//			int line = id/mColumnSize +1;
//			if(line <10)
//				locationId ="0"+line+"01"+(id%mColumnSize+1);
//			else
//				locationId = ""+line+"01"+(id%mColumnSize+1);
//			
//			ToolUtil.sendTrack(activity.getClass().getName(), pageId, ItemActivity.class.getName(), activity.getString(R.string.tag_ItemActivity), locationId, String.valueOf(pModel.getProductId()));
		}
	}
}
