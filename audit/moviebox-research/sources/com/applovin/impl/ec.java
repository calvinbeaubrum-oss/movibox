package com.applovin.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ec extends BaseAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f18683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f18684b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f18685c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f18686d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(lb lbVar, dc dcVar);
    }

    public ec(Context context) {
        this.f18683a = context.getApplicationContext();
    }

    private Drawable a(View view) {
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(t3.a(R.color.applovin_sdk_highlightListItemColor, this.f18683a));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[0], background);
        return stateListDrawable;
    }

    private lb a(int i11) {
        for (int i12 = 0; i12 < b(); i12++) {
            Integer num = (Integer) this.f18685c.get(Integer.valueOf(i12));
            if (num != null) {
                if (i11 <= num.intValue() + d(i12)) {
                    return new lb(i12, i11 - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    public dc a() {
        return null;
    }

    public void a(a aVar) {
        this.f18686d = aVar;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public abstract int b();

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public dc getItem(int i11) {
        return (dc) this.f18684b.get(i11);
    }

    public abstract List c(int i11);

    public void c() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hv
            @Override // java.lang.Runnable
            public final void run() {
                this.f19544a.notifyDataSetChanged();
            }
        });
    }

    public abstract int d(int i11);

    public abstract dc e(int i11);

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18684b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return i11;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i11) {
        return getItem(i11).m();
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        cc ccVar;
        dc item = getItem(i11);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(item.j(), viewGroup, false);
            ccVar = new cc();
            ccVar.f18173a = (TextView) view.findViewById(android.R.id.text1);
            ccVar.f18174b = (TextView) view.findViewById(android.R.id.text2);
            ccVar.f18175c = (ImageView) view.findViewById(R.id.imageView);
            ccVar.f18176d = (ImageView) view.findViewById(R.id.detailImageView);
            view.setTag(ccVar);
            view.setOnClickListener(this);
            view.setBackground(a(view));
        } else {
            ccVar = (cc) view.getTag();
        }
        ccVar.a(i11);
        ccVar.a(item);
        view.setEnabled(item.o());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return dc.n();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i11) {
        return getItem(i11).o();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int i11;
        this.f18684b = new ArrayList();
        int iB = b();
        this.f18685c = new HashMap(iB);
        dc dcVarA = a();
        if (dcVarA != null) {
            this.f18684b.add(dcVarA);
            i11 = 1;
        } else {
            i11 = 0;
        }
        for (int i12 = 0; i12 < iB; i12++) {
            int iD = d(i12);
            if (iD != 0) {
                this.f18684b.add(e(i12));
                this.f18684b.addAll(c(i12));
                this.f18685c.put(Integer.valueOf(i12), Integer.valueOf(i11));
                i11 += iD + 1;
            }
        }
        this.f18684b.add(new fj(""));
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cc ccVar = (cc) view.getTag();
        dc dcVarB = ccVar.b();
        lb lbVarA = a(ccVar.a());
        a aVar = this.f18686d;
        if (aVar == null || lbVarA == null) {
            return;
        }
        aVar.a(lbVarA, dcVarB);
    }
}
