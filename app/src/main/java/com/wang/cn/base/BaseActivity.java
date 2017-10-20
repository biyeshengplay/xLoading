package com.wang.cn.base;

import com.example.every_text.view.LoadingPager;
import com.example.every_text.view.LoadingPager.LoadResult;
import com.wang.cn.R;
import com.wang.cn.utils.UIUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class BaseActivity extends Activity {
	public LoadingPager loadingPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		loadingPage = new LoadingPager(UIUtils.getContext(),
				R.layout.loadpage_loading, R.layout.loadpage_error,
				R.layout.loadpage_empty) {
			@Override
			protected LoadResult load() {
				return BaseActivity.this.load();
			}
			@Override
			protected View createSuccessView() {
				return BaseActivity.this.createSuccessView();
			}
		};
//		���Ե��
		loadingPage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				loadingPage.show();
			}
		});
//		��ʾ loading��ҳ��
		loadingPage.show();
		setContentView(loadingPage);
	}

	/**
	 * ˢ��ҳ�湤��
	 * 
	 * @return
	 */
	protected abstract View createSuccessView();

	/**
	 * ��������� ��ȡ��ǰ״̬
	 * 
	 */
	protected abstract LoadResult load();

}
