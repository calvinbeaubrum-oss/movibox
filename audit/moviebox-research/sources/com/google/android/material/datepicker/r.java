package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class r extends LinearLayoutManager {

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.recyclerview.widget.h {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.h
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public r(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i11) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i11);
        startSmoothScroll(aVar);
    }
}
