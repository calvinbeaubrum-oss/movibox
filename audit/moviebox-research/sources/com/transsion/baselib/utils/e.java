package com.transsion.baselib.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f51310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f51311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Integer, Unit> f51312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Integer> f51313d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            e.this.d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(RecyclerView recyclerView, RecyclerView recyclerView2, float f11, Function1<? super Integer, Unit> onExposure) {
        Intrinsics.g(onExposure, "onExposure");
        this.f51310a = recyclerView2;
        this.f51311b = f11;
        this.f51312c = onExposure;
        this.f51313d = new LinkedHashSet();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a());
        }
        d();
    }

    public final void b() {
        this.f51313d.clear();
    }

    public final boolean c(View view, int i11) {
        Rect rect = new Rect();
        RecyclerView recyclerView = this.f51310a;
        if (recyclerView != null) {
            recyclerView.getGlobalVisibleRect(rect);
        }
        Rect rect2 = new Rect();
        if (view != null) {
            view.getGlobalVisibleRect(rect2);
        }
        int i12 = rect2.intersect(rect) ? rect2.bottom - rect2.top : 0;
        int height = view != null ? view.getHeight() : 0;
        float f11 = this.f51311b;
        if (f11 < 0.0f) {
            f11 = 0.1f;
        } else if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        return ((float) i12) >= ((float) height) * f11;
    }

    public final void d() {
        RecyclerView recyclerView = this.f51310a;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            f(this.f51310a, layoutManager, this.f51312c);
        } else if (layoutManager instanceof GridLayoutManager) {
            f(this.f51310a, layoutManager, this.f51312c);
        }
    }

    public final void e() {
        b();
        d();
    }

    public final void f(RecyclerView recyclerView, RecyclerView.m mVar, Function1<? super Integer, Unit> function1) {
        RecyclerView recyclerView2 = this.f51310a;
        int childCount = recyclerView2 != null ? recyclerView2.getChildCount() : 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            RecyclerView recyclerView3 = this.f51310a;
            View childAt = recyclerView3 != null ? recyclerView3.getChildAt(i11) : null;
            if (!this.f51313d.contains(Integer.valueOf(i11)) && c(childAt, i11)) {
                this.f51313d.add(Integer.valueOf(i11));
                if (childAt != null) {
                    RecyclerView recyclerView4 = this.f51310a;
                    function1.invoke(Integer.valueOf(recyclerView4 != null ? recyclerView4.getChildAdapterPosition(childAt) : -1));
                }
            }
        }
    }
}
