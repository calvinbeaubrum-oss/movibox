package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.n0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpandedMenuView extends ListView implements f.b, m, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1024c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1026b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        n0 n0VarV = n0.v(context, attributeSet, f1024c, i11, 0);
        if (n0VarV.s(0)) {
            setBackgroundDrawable(n0VarV.g(0));
        }
        if (n0VarV.s(1)) {
            setDivider(n0VarV.g(1));
        }
        n0VarV.x();
    }

    public int getWindowAnimations() {
        return this.f1026b;
    }

    @Override // androidx.appcompat.view.menu.m
    public void initialize(f fVar) {
        this.f1025a = fVar;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public boolean invokeItem(h hVar) {
        return this.f1025a.O(hVar, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        invokeItem((h) getAdapter().getItem(i11));
    }
}
