package com.wang.cn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.wang.cn.base.BaseFragment;
import com.wang.cn.fragmetn.FragmentFactory;
import com.wang.cn.utils.UIUtils;
import com.wang.cn.utils.ViewUtils;

public class FragmetActivity extends FragmentActivity {
	// tab��������
	private String[] tab_names;
	private FrameLayout fl_menu;
	private ViewPager mViewPager;

	private PagerTabStrip pager_tab_strip;
	private View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = UIUtils.inflate(R.layout.fragment_main);
		setContentView(view);
		init();
	}

	private void init() {
//		tab��ͷ����
		tab_names = UIUtils.getStringArray(R.array.tab_names);
		// ����
		mViewPager = (ViewPager) findViewById(R.id.vp);

		mViewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
//		������ʱ�� ����״̬
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						super.onPageSelected(position);
						BaseFragment createFragment = FragmentFactory
								.createFragment(position);
						createFragment.show();// ���л������ʱ���ؼ��ؽ����ȡ״̬
					}
				});
//		������ɫ
		pager_tab_strip = ViewUtils.findViewById(view, R.id.pager_tab_strip);
		// ��ǩ�»��ߵ���ɫ
		pager_tab_strip.setTabIndicatorColor(UIUtils
				.getColor(R.color.indicatorcolor));

	}

	private class MainAdapter extends FragmentStatePagerAdapter {
		// ÿ����Ŀ���ص�fragmetn
		public MainAdapter(android.support.v4.app.FragmentManager fm) {
			super(fm);
		}
		// ÿ����Ŀ���ص�fragment
		@Override
		public Fragment getItem(int arg0) {
			return FragmentFactory.createFragment(arg0);
		}

		// һ���Ўׂ��lĿ
		@Override
		public int getCount() {
			return tab_names.length;
		}

		// ����ÿ���lĿ�ı���
		@Override
		public CharSequence getPageTitle(int position) {
			return tab_names[position];
		}
	}

}
