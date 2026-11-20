package com.cloud.tmc.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31933a = Color.parseColor("#cccccc");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f31935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f31936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f31938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f31939g;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f31941b = Color.parseColor("#cccccc");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f31942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f31943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f31944e;
    }

    public final boolean d(int i11, int i12) {
        return (i11 + 1) % i12 == 0;
    }

    public final boolean e(int i11, int i12, int i13) {
        return i11 / i13 == (i12 - 1) / i13;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005e  */
    /* JADX WARN: Code duplicated, block: B:8:0x0030  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(outRect, "outRect");
        Intrinsics.g(view, "view");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        int i11 = this.f31937e;
        if (i11 == 0) {
            if (this.f31936d) {
                outRect.set(0, 0, 0, this.f31934b);
            } else {
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                RecyclerView.Adapter adapter = parent.getAdapter();
                Intrinsics.d(adapter);
                if (childLayoutPosition != adapter.getItemCount() - 1) {
                    outRect.set(0, 0, 0, this.f31934b);
                }
            }
            if (this.f31935c && parent.getChildLayoutPosition(view) == 0) {
                int i12 = this.f31934b;
                outRect.set(0, i12, 0, i12);
                return;
            }
            return;
        }
        if (i11 == 1) {
            if (this.f31936d) {
                outRect.set(0, 0, this.f31934b, 0);
            } else {
                int childLayoutPosition2 = parent.getChildLayoutPosition(view);
                RecyclerView.Adapter adapter2 = parent.getAdapter();
                Intrinsics.d(adapter2);
                if (childLayoutPosition2 != adapter2.getItemCount() - 1) {
                    outRect.set(0, 0, this.f31934b, 0);
                }
            }
            if (this.f31935c && parent.getChildLayoutPosition(view) == 0) {
                int i13 = this.f31934b;
                outRect.set(i13, 0, i13, 0);
                return;
            }
            return;
        }
        if (i11 == 2) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
            Intrinsics.d(gridLayoutManager);
            int spanCount = gridLayoutManager.getSpanCount();
            RecyclerView.Adapter adapter3 = parent.getAdapter();
            Intrinsics.d(adapter3);
            int itemCount = adapter3.getItemCount();
            if (e(parent.getChildLayoutPosition(view), itemCount, spanCount) && d(parent.getChildLayoutPosition(view), spanCount)) {
                outRect.set(0, 0, 0, 0);
                return;
            }
            if (e(parent.getChildLayoutPosition(view), itemCount, spanCount)) {
                outRect.set(0, 0, this.f31934b, 0);
            } else if ((parent.getChildLayoutPosition(view) + 1) % spanCount == 0) {
                outRect.set(0, 0, 0, this.f31934b);
            } else {
                int i14 = this.f31934b;
                outRect.set(0, 0, i14, i14);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDraw(Canvas c11, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(c11, "c");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        Paint paint = this.f31938f;
        if (paint != null) {
            paint.setColor(this.f31933a);
        }
        int i11 = this.f31937e;
        int i12 = 2;
        int i13 = 0;
        if (i11 == 0) {
            int childCount = parent.getChildCount();
            if (this.f31935c) {
                float top = parent.getChildAt(0).getTop() - (this.f31934b / 2);
                float width = parent.getWidth();
                Paint paint2 = this.f31938f;
                Intrinsics.d(paint2);
                c11.drawLine(0, top, width, top, paint2);
            }
            for (int i14 = 0; i14 < childCount; i14++) {
                if (!this.f31936d && i14 == childCount - 1) {
                    return;
                }
                float bottom = (this.f31934b / 2) + parent.getChildAt(i14).getBottom();
                float width2 = parent.getWidth();
                Paint paint3 = this.f31938f;
                Intrinsics.d(paint3);
                c11.drawLine(0, bottom, width2, bottom, paint3);
            }
            return;
        }
        if (i11 == 1) {
            int childCount2 = parent.getChildCount();
            if (this.f31935c) {
                float left = parent.getChildAt(0).getLeft() - (this.f31934b / 2);
                float height = parent.getHeight();
                Paint paint4 = this.f31938f;
                Intrinsics.d(paint4);
                c11.drawLine(left, 0, left, height, paint4);
            }
            for (int i15 = 0; i15 < childCount2; i15++) {
                if (!this.f31936d && i15 == childCount2 - 1) {
                    return;
                }
                float right = (this.f31934b / 2) + parent.getChildAt(i15).getRight();
                float height2 = parent.getHeight();
                Paint paint5 = this.f31938f;
                Intrinsics.d(paint5);
                c11.drawLine(right, 0, right, height2, paint5);
            }
            return;
        }
        if (i11 != 2) {
            return;
        }
        int childCount3 = parent.getChildCount();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        Intrinsics.d(gridLayoutManager);
        int spanCount = gridLayoutManager.getSpanCount();
        RecyclerView.Adapter adapter = parent.getAdapter();
        Intrinsics.d(adapter);
        int itemCount = adapter.getItemCount();
        while (i13 < childCount3) {
            View childAt = parent.getChildAt(i13);
            int right2 = (this.f31934b / i12) + childAt.getRight();
            int bottom2 = (this.f31934b / i12) + childAt.getBottom();
            if (!e(i13, itemCount, spanCount)) {
                float left2 = childAt.getLeft();
                float f11 = bottom2;
                float right3 = childAt.getRight() + this.f31934b;
                Paint paint6 = this.f31938f;
                Intrinsics.d(paint6);
                c11.drawLine(left2, f11, right3, f11, paint6);
            }
            if (e(i13, itemCount, spanCount) && !d(i13, spanCount)) {
                float f12 = right2;
                float top2 = childAt.getTop();
                float bottom3 = childAt.getBottom();
                Paint paint7 = this.f31938f;
                Intrinsics.d(paint7);
                c11.drawLine(f12, top2, f12, bottom3, paint7);
            } else if (!d(i13, spanCount)) {
                float f13 = right2;
                float top3 = childAt.getTop();
                float f14 = bottom2;
                Paint paint8 = this.f31938f;
                Intrinsics.d(paint8);
                c11.drawLine(f13, top3, f13, f14, paint8);
            }
            i13++;
            i12 = 2;
        }
    }
}
