package com.mbridge.msdk.nativex.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.mbridge.msdk.nativex.view.MBNativeRollView;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RollingAdapter extends PagerAdapter {
    private List<Frame> list;
    private List<View> listview = new ArrayList();
    private MBNativeRollView.a mvinterface;

    public RollingAdapter(List<Frame> list) {
        this.list = new ArrayList();
        this.list = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView(this.listview.get(i11));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.list.size();
    }

    public MBNativeRollView.a getMvinterface() {
        return this.mvinterface;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        List<Frame> list;
        View viewA;
        if (this.mvinterface == null || (list = this.list) == null || list.size() <= 0 || (viewA = this.mvinterface.a(this.list.get(i11), i11)) == null) {
            return null;
        }
        this.listview.add(viewA);
        viewGroup.addView(viewA);
        return viewA;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void setMvinterface(MBNativeRollView.a aVar) {
        this.mvinterface = aVar;
    }
}
