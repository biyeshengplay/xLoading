package com.wang.cn;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.every_text.view.LoadingPager.LoadResult;
import com.wang.cn.base.BaseActivity;
import com.wang.cn.utils.UIUtils;
import com.wang.cn.utils.ViewUtils;

public class MainActivity extends BaseActivity {
	// 刷新页面工程
	@Override
	protected View createSuccessView() {
		View inflate = UIUtils.inflate(R.layout.activity_main);
		
		TextView tv=ViewUtils.findViewById(inflate, R.id.textView1);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(UIUtils.getContext(),FragmetActivity.class);
				startActivity(intent);
			}
		});
		return inflate;
	}

	// 刷新页面工程
	@Override
	protected LoadResult load() {
		SystemClock.sleep(2000);
		return LoadResult.SUCCESS;
	}
}
