package com.example.viewpager;

import android.os.Bundle;
import android.provider.BlockedNumberContract;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XBanner banner;

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<Integer> mDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mDatas.add(R.mipmap.a);
        mDatas.add(R.mipmap.b);
        mDatas.add(R.mipmap.c);
        mDatas.add(R.mipmap.d);
        mDatas.add(R.mipmap.e);


//        mViewPager.setPageTransformer(true, new ScaleInTransformer());
        mViewPager.setPageTransformer(true, new NonPageTransformer());
        ScaleInTransformer transformer = new ScaleInTransformer();
        banner.setPageTransformer(Transformer.ScaleIn);

        //设置Page间间距
//        mViewPager.setPageMargin(20);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter( new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                ImageView view = new ImageView(MainActivity.this);
                view.setImageResource(mDatas.get(position % mDatas.size()));
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView((View) object);
            }

            @Override
            public int getCount()
            {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object o)
            {
                return view == o;
            }
        });


        banner.setData(mDatas, null);//第二个参数为提示文字资源集合
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
//                ((ImageView) view).setScaleType(ImageView.ScaleType.CENTER);
               ((ImageView) view).setImageResource(mDatas.get(position));
//                new GlideImageLoader().onDisplayImageWithDefault(getActivity(), (ImageView) view, mDatas.get(position).getImageUrl(), R.mipmap.c1_image2);
            }
        });
    }

    private void initView() {
        banner = (XBanner) findViewById(R.id.vp);
        mViewPager = findViewById(R.id.viepager);
    }
}
