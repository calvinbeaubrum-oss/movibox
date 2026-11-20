package com.cloud.tmc.miniapp.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31907a;

    public p(int i11) {
        this.f31907a = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x state) {
        Intrinsics.g(rect, "rect");
        Intrinsics.g(view, "view");
        Intrinsics.g(recyclerView, "recyclerView");
        Intrinsics.g(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        if ((childAdapterPosition + 1) % spanCount == 0) {
            rect.right = this.f31907a;
        }
        if (childAdapterPosition < spanCount) {
            rect.top = this.f31907a;
        }
        int i11 = this.f31907a;
        rect.bottom = i11;
        rect.left = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x state) {
        Intrinsics.g(canvas, "canvas");
        Intrinsics.g(recyclerView, "recyclerView");
        Intrinsics.g(state, "state");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x state) {
        Intrinsics.g(canvas, "canvas");
        Intrinsics.g(recyclerView, "recyclerView");
        Intrinsics.g(state, "state");
    }
}
