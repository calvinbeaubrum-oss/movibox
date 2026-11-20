package com.tn.lib.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
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
public final class PagerLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f49405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jp.a f49406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49408d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f49412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RecyclerView.o f49413j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements RecyclerView.o {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void onChildViewAttachedToWindow(View view) {
            jp.a aVar;
            Intrinsics.g(view, "view");
            int position = PagerLayoutManager.this.getPosition(view);
            if (PagerLayoutManager.this.getChildCount() == 1 && position == 0 && (aVar = PagerLayoutManager.this.f49406b) != null) {
                aVar.b(view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void onChildViewDetachedFromWindow(View view) {
            Intrinsics.g(view, "view");
            if (PagerLayoutManager.this.f49407c >= 0) {
                jp.a aVar = PagerLayoutManager.this.f49406b;
                if (aVar != null) {
                    aVar.c(true, PagerLayoutManager.this.getPosition(view), view);
                    return;
                }
                return;
            }
            jp.a aVar2 = PagerLayoutManager.this.f49406b;
            if (aVar2 != null) {
                aVar2.c(false, PagerLayoutManager.this.getPosition(view), view);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            View viewFindSnapView = PagerLayoutManager.this.n().findSnapView(PagerLayoutManager.this);
            if (viewFindSnapView == null) {
                return;
            }
            int position = PagerLayoutManager.this.getPosition(viewFindSnapView);
            if (PagerLayoutManager.this.f49409f != i11 && PagerLayoutManager.this.f49410g != position) {
                PagerLayoutManager.this.f49409f = i11;
                PagerLayoutManager.this.f49410g = position;
                jp.a aVar = PagerLayoutManager.this.f49406b;
                if (aVar != null) {
                    aVar.a(position, position == PagerLayoutManager.this.getItemCount() - 1, viewFindSnapView);
                }
            }
            if (i11 == 0) {
                PagerLayoutManager.this.f49411h = position;
                jp.a aVar2 = PagerLayoutManager.this.f49406b;
                if (aVar2 != null) {
                    aVar2.d(position, position == PagerLayoutManager.this.getItemCount() - 1, viewFindSnapView);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerLayoutManager(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f49405a = LazyKt__LazyJVMKt.b(PagerLayoutManager$pagerSnapHelper$2.INSTANCE);
        this.f49408d = true;
        this.f49409f = -1;
        this.f49410g = -1;
        this.f49411h = -1;
        this.f49412i = new b();
        this.f49413j = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.f49405a = LazyKt__LazyJVMKt.b(PagerLayoutManager$pagerSnapHelper$2.INSTANCE);
        this.f49408d = true;
        this.f49409f = -1;
        this.f49410g = -1;
        this.f49411h = -1;
        this.f49412i = new b();
        this.f49413j = new a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return this.f49408d & super.canScrollVertically();
    }

    public final View m() {
        return n().findSnapView(this);
    }

    public final m n() {
        return (m) this.f49405a.getValue();
    }

    public final void o(boolean z11) {
        this.f49408d = z11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        if ((recyclerView != null ? recyclerView.getOnFlingListener() : null) == null) {
            n().attachToRecyclerView(recyclerView);
        }
        if (recyclerView != null) {
            recyclerView.addOnChildAttachStateChangeListener(this.f49413j);
        }
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.f49412i);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        if (recyclerView != null) {
            recyclerView.removeOnChildAttachStateChangeListener(this.f49413j);
        }
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.f49412i);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        try {
            super.onLayoutChildren(tVar, xVar);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public final void p(jp.a aVar) {
        this.f49406b = aVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        this.f49407c = i11;
        return super.scrollHorizontallyBy(i11, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.x xVar) {
        this.f49407c = i11;
        return super.scrollVerticallyBy(i11, tVar, xVar);
    }
}
