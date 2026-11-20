package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import g20.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onDeselected(int i11, int i12) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
        setTextColor(a.a(f11, this.f71885b, this.f71884a));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
        setTextColor(a.a(f11, this.f71884a, this.f71885b));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onSelected(int i11, int i12) {
    }
}
