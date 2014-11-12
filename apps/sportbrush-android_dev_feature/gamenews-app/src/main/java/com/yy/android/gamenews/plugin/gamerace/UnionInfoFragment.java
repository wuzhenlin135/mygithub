package com.yy.android.gamenews.plugin.gamerace;

import java.util.List;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.duowan.android.base.model.BaseModel.ResponseListener;
import com.duowan.gamenews.ArticleInfo;
import com.duowan.gamenews.GetUnionInfoRsp;
import com.duowan.gamenews.RefreshType;
import com.duowan.gamenews.UnionInfo;
import com.yy.android.gamenews.Constants;
import com.yy.android.gamenews.event.SupportUnionEvent;
import com.yy.android.gamenews.jcewrapper.GetUnionInfoRspLocal;
import com.yy.android.gamenews.model.UnionModel;
import com.yy.android.gamenews.ui.ArticleListFragment;
import com.yy.android.gamenews.ui.common.RefreshableViewWrapper;
import com.yy.android.gamenews.ui.common.SwitchImageLoader;
import com.yy.android.gamenews.util.Preference;
import com.yy.android.gamenews.util.ToastUtil;
import com.yy.android.gamenews.util.Util;
import com.yy.android.sportbrush.R;

import de.greenrobot.event.EventBus;

public class UnionInfoFragment extends
		ArticleListFragment<GetUnionInfoRsp, GetUnionInfoRspLocal> {

	private UnionInfo unionInfo;
	private View headerView;

	public static UnionInfoFragment newInstance(UnionInfo unionInfo) {
		UnionInfoFragment fragment = new UnionInfoFragment();
		Bundle args = new Bundle();
		args.putSerializable(UnionInfoActivity.UNION, unionInfo);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		unionInfo = (UnionInfo) getArguments().getSerializable(
				UnionInfoActivity.UNION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup parentView = (ViewGroup) super.onCreateView(inflater,
				container, savedInstanceState);
		return parentView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		View footerView = new View(getActivity());
		footerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, Util.dip2px(getActivity(), 45)));
		mDataViewConverter.addFooter(footerView);
		GetUnionInfoRsp rsp = getRspInstance();
		if (rsp != null) {
			initUnionInfo();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		checkExpire();
	}

	@Override
	protected RefreshableViewWrapper<?> getViewWrapper() {
		headerView = mInflater.inflate(R.layout.union_header_view, null);
		return mDataViewConverter.getViewWrapper(headerView);
	}
	
	private void initUnionInfo() {
		GetUnionInfoRsp mRsp = getRspInstance();
		if (mRsp == null) {
			return;
		}
		SwitchImageLoader mImageLoader = SwitchImageLoader.getInstance();
		mImageLoader.displayImage(mRsp.getImg(),
				(ImageView) headerView.findViewById(R.id.iv_union_logo),
				SwitchImageLoader.DEFAULT_ARTICLE_ITEM_BIG_DISPLAYER);
		if(mRsp.getHeat() > 0){
			headerView.findViewById(R.id.union_order).setVisibility(View.VISIBLE);
			((TextView) headerView.findViewById(R.id.tv_order)).setText(String
					.valueOf(mRsp.getRanking()));
		}else{
			headerView.findViewById(R.id.union_order).setVisibility(View.GONE);
		}
		((TextView) headerView.findViewById(R.id.tv_support_count))
		.setText(String.valueOf(mRsp.getHeat()));
		String summary = mRsp.getSummary();
		if (summary != null && !summary.equals("")) {
			SpannableStringBuilder desc = new SpannableStringBuilder();
			desc.append("　　　    ");
			desc.append(summary);

			((TextView) headerView.findViewById(R.id.tv_union_desc))
					.setText(desc);
			headerView.findViewById(R.id.rl_union_desc).setVisibility(
					View.VISIBLE);
		} else {
			headerView.findViewById(R.id.rl_union_desc)
					.setVisibility(View.GONE);
		}

	}

	/**
	 * 底部view点击事件
	 */
	@Override
	public void onClick(final View v) {
		if (unionInfo == null) {
			return;
		}
		UnionModel.supportUnion(new ResponseListener<SparseArray<String>>(getActivity()) {

			@Override
			public void onResponse(SparseArray<String> response) {
				if(response.get(0) != null){
					ToastUtil.showToast(R.string.supported_success);
					enbaleSupport(false);
					GetUnionInfoRsp mRsp = getRspInstance();
					if (mRsp != null) {
						mRsp.setHeat(mRsp.getHeat() + 1);
						((TextView) headerView.findViewById(R.id.tv_support_count))
								.setText(String.valueOf(mRsp.getHeat()));
						saveResponseToDisk();
					}
					SupportUnionEvent event = new SupportUnionEvent();
					event.setUnionId(unionInfo.getId());
					EventBus.getDefault().post(event);
				}else if(!TextUtils.isEmpty(response.get(1))){
					ToastUtil.showToast(response.get(1));
				}
			}
			
			@Override
			public void onError(Exception e) {
				if (e != null) {
					ToastUtil.showToast(R.string.http_error);
				}
				super.onError(e);
			}
		}, unionInfo.getId());
	};

	@Override
	protected void requestDataImpl(final int refresh, Object attachInfo) {
		if (unionInfo == null) {
			return;
		}
		UnionModel.getUnionInfo(new ResponseListener<GetUnionInfoRsp>(
				getActivity()) {

			@Override
			public void onResponse(GetUnionInfoRsp data) {
				requestFinish(refresh, data, false);
			}

			@Override
			public void onError(Exception e) {
				requestFinish(refresh, null, true);
				if (e != null) {
					ToastUtil.showToast(R.string.http_error);
				}
				super.onError(e);
			}
		}, unionInfo.getId(), String.valueOf(attachInfo));
	}

	@Override
	protected void requestFinishImpl(int refresh, GetUnionInfoRsp data,
			boolean error) {
		showSupportView(true);
		if (data != null) {
			if(refresh != RefreshType._REFRESH_TYPE_LOAD_MORE){
				initUnionInfo();
			}
			enbaleSupport(data.getIsVoteAvailable());
		}

		super.requestFinishImpl(refresh, data, error);
	}
	
	@Override
	protected boolean hasData() {
		GetUnionInfoRsp rsp = getRspInstance();
		if (rsp != null) {
			return true;
		}
		return super.hasData();
	}

	@Override
	protected GetUnionInfoRsp newRspObject() {
		return new GetUnionInfoRsp();
	}

	protected String getKey() {
		if (unionInfo == null) {
			return null;
		}
		String key = Constants.CACHE_KEY_UNION_LIST + unionInfo.getId();

		return key;
	}

	@Override
	protected boolean isExpire() {
		List<ArticleInfo> dataList = getDataSource();
		if (dataList != null && dataList.size() > 0) { // 如果列表为空，不需要刷新
			if (mPageCache.isExpire(getKey())) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean needShowBottomBarView() {
		return true;
	}

	@Override
	protected boolean needShowUpdatedBubble() {
		return false;
	}

	@Override
	protected boolean needShowUpdatedCount() {
		return false;
	}

	@Override
	protected GetUnionInfoRspLocal initRspWrapper() {
		return new GetUnionInfoRspLocal();
	}
}
