package com.kotlin.limiao.flowlayoutdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * Created by miao on 2018/12/3.
 */
public class SearchTagAdapter extends TagAdapter<String> {

    private Context mContext;
    private List<String> datas;

    public SearchTagAdapter(List<String> datas,Context context) {
        super(datas);
        mContext = context;
    }


    @Override
    public View getView(FlowLayout parent, int position, String s) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.)
        return null;
    }
}
