package com.transsion.baseui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.StateView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.R$layout;
import h9.f;
import java.util.List;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseListFragment<T> extends LazyFragment<fs.a> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BaseQuickAdapter<T, BaseViewHolder> f51352o;

    public static final void c1(BaseListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.g1()) {
            this$0.o1();
        } else {
            this$0.q1(false);
            zp.b.f82110a.e("loading, please try again later ...");
        }
    }

    public static final void d1(BaseListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.h1()) {
            this$0.i1();
        } else {
            zp.b.f82110a.e("being refreshed, please try again later ...");
            this$0.m1();
        }
    }

    public static /* synthetic */ void l1(BaseListFragment baseListFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        }
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        baseListFragment.k1(z11);
    }

    public static /* synthetic */ void s1(BaseListFragment baseListFragment, View view, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRvEmptyLayout");
        }
        if ((i11 & 1) != 0) {
            view = baseListFragment.X0();
        }
        baseListFragment.r1(view);
    }

    public static /* synthetic */ void u1(BaseListFragment baseListFragment, View view, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRvLoadingLayout");
        }
        if ((i11 & 1) != 0) {
            view = baseListFragment.Y0();
        }
        baseListFragment.t1(view);
    }

    public abstract BaseQuickAdapter<T, BaseViewHolder> T0();

    public final void U0() {
        fs.a aVar = (fs.a) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout = aVar != null ? aVar.f65250c : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(false);
    }

    public RecyclerView.m V0() {
        return new LinearLayoutManager(requireContext());
    }

    public final BaseQuickAdapter<T, BaseViewHolder> W0() {
        return this.f51352o;
    }

    public View X0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(2, 1, false, "", k0());
        return stateView;
    }

    public View Y0() {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.default_rv_loading_layout, (ViewGroup) null);
        Intrinsics.f(viewInflate, "from(requireContext()).i…_rv_loading_layout, null)");
        return viewInflate;
    }

    public abstract String Z0();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public fs.a getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        fs.a aVarC = fs.a.c(inflater);
        Intrinsics.f(aVarC, "inflate(inflater)");
        return aVarC;
    }

    public final void b1() {
        fs.a aVar = (fs.a) getMViewBinding();
        TitleLayout titleLayout = aVar != null ? aVar.f65252f : null;
        if (titleLayout == null) {
            return;
        }
        titleLayout.setVisibility(8);
    }

    public void e1() {
        RecyclerView recyclerView;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (recyclerView = aVar.f65251d) == null) {
            return;
        }
        recyclerView.setLayoutManager(V0());
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapterT0 = T0();
        this.f51352o = baseQuickAdapterT0;
        recyclerView.setAdapter(baseQuickAdapterT0);
        if (f1()) {
            BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
            recyclerView.addOnScrollListener(new hs.a(baseQuickAdapter != null ? baseQuickAdapter.Q() : null));
        }
    }

    public boolean f1() {
        return true;
    }

    public final boolean g1() {
        f fVarQ;
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
            return false;
        }
        return fVarQ.q();
    }

    public final boolean h1() {
        SwipeRefreshLayout swipeRefreshLayout;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (swipeRefreshLayout = aVar.f65250c) == null) {
            return false;
        }
        return swipeRefreshLayout.isRefreshing();
    }

    public abstract void i1();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        SwipeRefreshLayout swipeRefreshLayout;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar != null && (swipeRefreshLayout = aVar.f65250c) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.baseui.fragment.a
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    BaseListFragment.c1(this.f51366a);
                }
            });
        }
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.Q().C(new f9.f() { // from class: com.transsion.baseui.fragment.b
                @Override // f9.f
                public final void a() {
                    BaseListFragment.d1(this.f51367a);
                }
            });
        }
    }

    public final boolean isEmpty() {
        List<T> listD;
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        return (baseQuickAdapter == null || (listD = baseQuickAdapter.D()) == null || !listD.isEmpty()) ? false : true;
    }

    public final void j1() {
        f fVarQ;
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
            return;
        }
        fVarQ.r();
    }

    public final void k1(boolean z11) {
        f fVarQ;
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
            return;
        }
        fVarQ.s(z11);
    }

    public final void m1() {
        f fVarQ;
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public final void n1() {
        f fVarQ;
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
            return;
        }
        fVarQ.v();
    }

    public abstract void o1();

    public final void p1(BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter) {
        this.f51352o = baseQuickAdapter;
    }

    public final void q1(boolean z11) {
        fs.a aVar = (fs.a) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout = aVar != null ? aVar.f65250c : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(z11);
    }

    public final void r1(View emptyView) {
        Intrinsics.g(emptyView, "emptyView");
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.r0(emptyView);
        }
    }

    public final void t1(View loadingView) {
        Intrinsics.g(loadingView, "loadingView");
        BaseQuickAdapter<T, BaseViewHolder> baseQuickAdapter = this.f51352o;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.r0(loadingView);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        TitleLayout titleLayout;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar != null && (titleLayout = aVar.f65252f) != null) {
            titleLayout.setTitleText(Z0());
        }
        e1();
    }

    public void v1() {
        q1(false);
        m1();
        if (isEmpty()) {
            s1(this, null, 1, null);
        }
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        zp.b.f82110a.e(getString(R$string.no_network_toast));
    }
}
