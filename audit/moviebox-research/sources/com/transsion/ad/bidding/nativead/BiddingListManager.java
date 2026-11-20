package com.transsion.ad.bidding.nativead;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;

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
@SourceDebugExtension
public final class BiddingListManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0 f50352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f50353c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<RecyclerView> f50356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super Integer, ? super c, Unit> f50357g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50359i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f50351a = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50354d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f50355e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<c> f50358h = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f50360j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50361k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f50362l = 300;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f50363m = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f50364n = new Runnable() { // from class: com.transsion.ad.bidding.nativead.b
        @Override // java.lang.Runnable
        public final void run() {
            BiddingListManager.n(this.f50367a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (BiddingListManager.this.f50361k) {
                RecyclerView.m layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    BiddingListManager.this.E(linearLayoutManager.findLastVisibleItemPosition());
                }
                GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
                if (gridLayoutManager != null) {
                    BiddingListManager.this.E(gridLayoutManager.findLastVisibleItemPosition());
                }
                if (i11 != 0) {
                    BiddingListManager.this.f50359i = false;
                    return;
                }
                BiddingListManager.this.f50359i = true;
                if (BiddingListManager.this.t() >= BiddingListManager.this.u() && BiddingListManager.this.s() == -1) {
                    BiddingListManager.this.x();
                } else {
                    if (BiddingListManager.this.t() < BiddingListManager.this.u() || BiddingListManager.this.t() - BiddingListManager.this.s() < BiddingListManager.this.v()) {
                        return;
                    }
                    BiddingListManager.this.x();
                }
            }
        }
    }

    public static final void n(BiddingListManager this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.q();
    }

    public final void A(k0 k0Var) {
        this.f50352b = k0Var;
    }

    public final void B(Map<String, Object> ctxMap) {
        Intrinsics.g(ctxMap, "ctxMap");
        this.f50351a = ctxMap;
    }

    public final void C(boolean z11) {
        this.f50361k = z11;
    }

    public final void D(Function2<? super Integer, ? super c, Unit> function2) {
        this.f50357g = function2;
    }

    public final void E(int i11) {
        this.f50354d = i11;
    }

    public final void F(RecyclerView recyclerView) {
        this.f50356f = new WeakReference<>(recyclerView);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a());
        }
    }

    public final void G(String sceneId) {
        Intrinsics.g(sceneId, "sceneId");
        this.f50360j = sceneId;
    }

    public final void o() {
        y();
        this.f50363m.removeCallbacksAndMessages(null);
        WeakReference<RecyclerView> weakReference = this.f50356f;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f50357g = null;
    }

    public final String p() {
        String simpleName = BiddingListManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void q() {
        c cVar = this.f50353c;
        if ((cVar != null ? cVar.P() : null) != null) {
            w();
            return;
        }
        if (this.f50353c != null) {
            com.transsion.ad.a.f50276a.I(p() + " --> null != delegate", false);
            return;
        }
        c cVar2 = new c();
        this.f50353c = cVar2;
        this.f50358h.add(cVar2);
        k0 k0Var = this.f50352b;
        if (k0Var != null) {
            j.d(k0Var, null, null, new BiddingListManager$getDelegate$1$1(cVar2, this, null), 3, null);
        }
    }

    public final Function2<Integer, c, Unit> r() {
        return this.f50357g;
    }

    public final int s() {
        return this.f50355e;
    }

    public final int t() {
        return this.f50354d;
    }

    public final int u() {
        return wq.a.f(wq.a.f79581a, this.f50360j, 0, 2, null);
    }

    public final int v() {
        return wq.a.h(wq.a.f79581a, this.f50360j, 0, 2, null);
    }

    public final void w() {
        c cVar = this.f50353c;
        if (cVar != null) {
            int i11 = this.f50354d + 1;
            if (i11 - this.f50355e < v()) {
                return;
            }
            this.f50355e = i11;
            k0 k0Var = this.f50352b;
            if (k0Var != null) {
                j.d(k0Var, null, null, new BiddingListManager$insert$1$1(this, cVar, null), 3, null);
            }
            com.transsion.ad.a.J(com.transsion.ad.a.f50276a, p() + " --> insert() --> 触发插入广告 --- mLastItemPosition = " + this.f50354d + " -- mLastAdPosition = " + this.f50355e, false, 2, null);
            this.f50353c = null;
        }
    }

    public final void x() {
        this.f50363m.removeCallbacks(this.f50364n);
        this.f50363m.postDelayed(this.f50364n, this.f50362l);
    }

    public final void y() {
        com.transsion.ad.a.f50276a.I(p() + " --> refresh() --> 资源回收 --> delegateList.forEach{it.destroy()} -- sceneId = " + this.f50360j, false);
        Iterator<T> it = this.f50358h.iterator();
        while (it.hasNext()) {
            ((c) it.next()).F();
        }
        this.f50354d = -1;
        this.f50355e = -1;
    }

    public final void z(Function2<? super Integer, ? super c, Unit> function2) {
        this.f50357g = function2;
    }
}
