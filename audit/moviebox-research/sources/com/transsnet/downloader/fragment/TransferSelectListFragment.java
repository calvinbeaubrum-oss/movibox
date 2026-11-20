package com.transsnet.downloader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.viewmodel.LocalFileViewModel;
import com.transsnet.downloader.viewmodel.TransferReceivedViewModel;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class TransferSelectListFragment extends PageStatusFragment<h00.n0> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f60871t = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f60876o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f60878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.transsnet.downloader.adapter.g0 f60879r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b1.b<String[]> f60880s;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f60872k = TransferBottomToolsView.TAG;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f60873l = FragmentViewModelLazyKt.a(this, Reflection.b(DownloadViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f60874m = FragmentViewModelLazyKt.a(this, Reflection.b(LocalFileViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$4
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f60875n = FragmentViewModelLazyKt.a(this, Reflection.b(TransferReceivedViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$5
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$special$$inlined$activityViewModels$default$6
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f60877p = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferSelectListFragment a(int i11, String tabName) {
            Intrinsics.g(tabName, "tabName");
            TransferSelectListFragment transferSelectListFragment = new TransferSelectListFragment();
            transferSelectListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_download_out_file_tab_name", tabName), TuplesKt.a("extra_page_index", Integer.valueOf(i11))));
            return transferSelectListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60881a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60881a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60881a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60881a.invoke(obj);
        }
    }

    public TransferSelectListFragment() {
        b1.b<String[]> bVarRegisterForActivityResult = registerForActivityResult(new c1.h(), new b1.a() { // from class: com.transsnet.downloader.fragment.c2
            @Override // b1.a
            public final void a(Object obj) {
                TransferSelectListFragment.u1(this.f60904a, (Map) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f60880s = bVarRegisterForActivityResult;
    }

    private final void c1() {
        B0();
    }

    private final DownloadViewModel d1() {
        return (DownloadViewModel) this.f60873l.getValue();
    }

    private final LocalFileViewModel g1() {
        return (LocalFileViewModel) this.f60874m.getValue();
    }

    private final String getPageName() {
        String lowerCase;
        int i11 = this.f60878q;
        if (i11 == 0) {
            lowerCase = "mb";
        } else if (i11 == 1) {
            lowerCase = "all";
        } else if (i11 != 2) {
            lowerCase = this.f60877p.toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = "received";
        }
        return "transfer_tab_" + lowerCase;
    }

    private final TransferReceivedViewModel h1() {
        return (TransferReceivedViewModel) this.f60875n.getValue();
    }

    public static final void p1(TransferSelectListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        DownloadBean downloadBean = item instanceof DownloadBean ? (DownloadBean) item : null;
        if (downloadBean == null || !downloadBean.isSeriesCollection()) {
            this$0.s1(downloadBean, view, i11);
        } else {
            this$0.t1(downloadBean);
        }
    }

    public static final void q1(TransferSelectListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (view.getId() == R$id.v_more) {
            Object item = adapter.getItem(i11);
            this$0.s1(item instanceof DownloadBean ? (DownloadBean) item : null, view, i11);
        }
    }

    public static final void r1(TransferSelectListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.c1();
    }

    public static final void u1(TransferSelectListFragment this$0, Map result) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(result, "result");
        if (!com.transsion.baselib.helper.c.f51185a.c(this$0.requireContext())) {
            this$0.v1();
        } else {
            this$0.K0();
            this$0.g1().j(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        com.transsnet.downloader.adapter.g0 g0Var = this.f60879r;
        if (g0Var != null) {
            g0Var.r0(f1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(List<DownloadBean> list) {
        List<DownloadBean> listD;
        SwipeRefreshLayout swipeRefreshLayout;
        h00.n0 mViewBinding = getMViewBinding();
        Integer numValueOf = null;
        if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f65964c) != null && swipeRefreshLayout.isRefreshing()) {
            h00.n0 mViewBinding2 = getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f65964c : null;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
        }
        uo.b.a aVar = uo.b.f78622a;
        String str = this.f60872k;
        int i11 = this.f60878q;
        int size = list.size();
        com.transsnet.downloader.adapter.g0 g0Var = this.f60879r;
        if (g0Var != null && (listD = g0Var.D()) != null) {
            numValueOf = Integer.valueOf(listD.size());
        }
        uo.b.a.f(aVar, str, "updateList tabIndex:" + i11 + ", size:" + size + ", curSize:" + numValueOf, false, 4, null);
        com.transsnet.downloader.adapter.g0 g0Var2 = this.f60879r;
        if (g0Var2 != null) {
            g0Var2.w0(i1(list));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        super.B0();
        int i11 = this.f60878q;
        if (i11 == 0) {
            d1().m(true);
        } else if (i11 == 1) {
            g1().j(true);
        } else {
            if (i11 != 2) {
                return;
            }
            h1().h(true);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        super.D0();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("extra_download_out_file_tab_name") : null;
        if (string == null) {
            string = "";
        }
        this.f60877p = string;
        Bundle arguments2 = getArguments();
        this.f60878q = arguments2 != null ? arguments2.getInt("extra_page_index") : 0;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final View e1() {
        if (this.f60876o == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            StateView stateView = new StateView(contextRequireContext);
            String string = Utils.a().getString(R$string.download_no_historical_tips);
            Intrinsics.f(string, "getApp().getString(R.str…nload_no_historical_tips)");
            stateView.showData(4, 2, false, "", string);
            String string2 = Utils.a().getString(R$string.download_empty_find_free_source);
            Intrinsics.f(string2, "getApp().getString(R.str…d_empty_find_free_source)");
            stateView.setReTryTxt(string2);
            stateView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$getDownloadedEmptyView$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.alibaba.android.arouter.launcher.a.d().b("/home/movieFilter").withInt("tabId", 2).navigation();
                }
            });
            this.f60876o = stateView;
        }
        View view = this.f60876o;
        Intrinsics.d(view);
        return view;
    }

    public final View f1() {
        View viewL0;
        if (this.f60876o == null) {
            if (com.transsnet.downloader.viewmodel.c.f61276a.a()) {
                viewL0 = super.l0(false);
            } else {
                Context contextRequireContext = requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                StateView stateView = new StateView(contextRequireContext);
                stateView.updateNoContentResId(R$mipmap.ic_no_permission);
                String string = Utils.a().getString(R$string.download_file_permission_tips);
                Intrinsics.f(string, "getApp().getString(R.str…oad_file_permission_tips)");
                stateView.showData(4, 2, false, "", string);
                String string2 = Utils.a().getString(R$string.download_no_permission_btn);
                Intrinsics.f(string2, "getApp().getString(R.str…wnload_no_permission_btn)");
                stateView.setReTryTxt(string2);
                stateView.retry(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$getLocalVideoEmptyView$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FragmentActivity activity = this.this$0.getActivity();
                        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                            return;
                        }
                        com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
                        if (cVar.s(activity)) {
                            cVar.C();
                        } else {
                            this.this$0.f60880s.a(com.transsion.baselib.helper.c.f51185a.a());
                        }
                    }
                });
                viewL0 = stateView;
            }
            this.f60876o = viewL0;
        }
        View view = this.f60876o;
        Intrinsics.d(view);
        return view;
    }

    public final List<DownloadBean> i1(List<DownloadBean> list) {
        List<DownloadBean> listD;
        Object next;
        ArrayList arrayList = new ArrayList();
        for (DownloadBean downloadBean : list) {
            com.transsnet.downloader.adapter.g0 g0Var = this.f60879r;
            if (g0Var != null && (listD = g0Var.D()) != null) {
                Iterator<T> it = listD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    DownloadBean downloadBean2 = (DownloadBean) next;
                    if (downloadBean2.isInnerRes()) {
                        if (Intrinsics.b(downloadBean2.getSubjectId(), downloadBean.getSubjectId()) && downloadBean2.getResolution() == downloadBean.getResolution() && downloadBean2.getEp() == downloadBean.getEp() && downloadBean2.getSe() == downloadBean.getSe()) {
                            break;
                        }
                    } else {
                        if (Intrinsics.b(downloadBean2.getPath(), downloadBean.getPath()) && Intrinsics.b(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                            break;
                        }
                    }
                }
                DownloadBean downloadBean3 = (DownloadBean) next;
                if (downloadBean3 != null) {
                    arrayList.add(downloadBean3);
                }
            }
            arrayList.add(downloadBean);
        }
        return arrayList;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        int i11 = this.f60878q;
        if (i11 == 0) {
            l1();
        } else if (i11 == 1) {
            m1();
        } else if (i11 != 2) {
            n1();
        } else {
            o1();
        }
        d1().A().j(this, new b(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                List<DownloadBean> listD;
                com.transsnet.downloader.adapter.g0 g0Var = TransferSelectListFragment.this.f60879r;
                if (g0Var != null && (listD = g0Var.D()) != null) {
                    for (DownloadBean downloadBean : listD) {
                        if (downloadBean.isSeriesCollection()) {
                            Iterator<T> it = downloadBean.getSeriesList().iterator();
                            while (it.hasNext()) {
                                ((DownloadBean) it.next()).setCheck(false);
                            }
                        }
                        downloadBean.setCheck(false);
                    }
                }
                com.transsnet.downloader.adapter.g0 g0Var2 = TransferSelectListFragment.this.f60879r;
                if (g0Var2 != null) {
                    g0Var2.notifyDataSetChanged();
                }
            }
        }));
    }

    public final View j1() {
        if (this.f60876o == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            StateView stateView = new StateView(contextRequireContext);
            String string = Utils.a().getString(R$string.download_transfer_received_empty_tips);
            Intrinsics.f(string, "getApp().getString(R.str…sfer_received_empty_tips)");
            stateView.showData(2, 2, false, "", string);
            this.f60876o = stateView;
        }
        View view = this.f60876o;
        Intrinsics.d(view);
        return view;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        int i11 = this.f60878q;
        if (i11 == 0) {
            String string = getString(R$string.newcomer_guide_download_tips);
            Intrinsics.f(string, "getString(R.string.newcomer_guide_download_tips)");
            return string;
        }
        if (i11 == 1) {
            String string2 = getString(R$string.download_no_local_file_tips_2);
            Intrinsics.f(string2, "getString(R.string.download_no_local_file_tips_2)");
            return string2;
        }
        if (i11 != 2) {
            String string3 = getString(R$string.download_no_local_file_tips_2);
            Intrinsics.f(string3, "getString(R.string.download_no_local_file_tips_2)");
            return string3;
        }
        String string4 = getString(R$string.download_transfer_received_empty_tips);
        Intrinsics.f(string4, "getString(R.string.downl…sfer_received_empty_tips)");
        return string4;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: k1, reason: merged with bridge method [inline-methods] */
    public h00.n0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.n0 n0VarC = h00.n0.c(inflater);
        Intrinsics.f(n0VarC, "inflate(inflater)");
        return n0VarC;
    }

    public final void l1() {
        d1().o().j(this, new b(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$initDownloadedViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends DownloadBean> list) {
                SwipeRefreshLayout swipeRefreshLayout;
                h00.n0 mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f65964c) != null && swipeRefreshLayout.isRefreshing()) {
                    h00.n0 mViewBinding2 = this.this$0.getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f65964c : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                List<? extends DownloadBean> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    this.this$0.w1(CollectionsKt___CollectionsKt.M0(list2));
                    return;
                }
                com.transsnet.downloader.adapter.g0 g0Var = this.this$0.f60879r;
                if (g0Var != null) {
                    g0Var.r0(this.this$0.e1());
                }
            }
        }));
        d1().E().j(this, new b(new Function1<DownloadBean, Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$initDownloadedViewModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                invoke2(downloadBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean downloadBean) {
                List<DownloadBean> listD;
                com.transsnet.downloader.adapter.g0 g0Var = this.this$0.f60879r;
                if (g0Var == null || (listD = g0Var.D()) == null) {
                    return;
                }
                Iterator<DownloadBean> it = listD.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    }
                    DownloadBean next = it.next();
                    if (next.isInnerRes()) {
                        if (Intrinsics.b(next.getSubjectId(), downloadBean != null ? downloadBean.getSubjectId() : null) && downloadBean != null && next.getResolution() == downloadBean.getResolution() && downloadBean != null && next.getEp() == downloadBean.getEp() && downloadBean != null && next.getSe() == downloadBean.getSe()) {
                            break;
                        } else {
                            i11++;
                        }
                    } else {
                        if (Intrinsics.b(next.getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                TransferSelectListFragment transferSelectListFragment = this.this$0;
                if (i11 >= 0) {
                    uo.b.a.f(uo.b.f78622a, transferSelectListFragment.f60872k, "外部列表，刷新index:" + i11, false, 4, null);
                    com.transsnet.downloader.adapter.g0 g0Var2 = transferSelectListFragment.f60879r;
                    if (g0Var2 != null) {
                        g0Var2.notifyItemChanged(i11, downloadBean);
                    }
                }
            }
        }));
    }

    public final void m1() {
        g1().i().j(this, new b(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$initLocalFileAllViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DownloadBean> list) {
                SwipeRefreshLayout swipeRefreshLayout;
                h00.n0 mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f65964c) != null && swipeRefreshLayout.isRefreshing()) {
                    h00.n0 mViewBinding2 = this.this$0.getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f65964c : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                uo.b.a.f(uo.b.f78622a, this.this$0.f60872k, "获取到外部数据all:" + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
                this.this$0.F0();
                if (!com.transsnet.downloader.viewmodel.c.f61276a.a()) {
                    this.this$0.v1();
                    return;
                }
                List<DownloadBean> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    this.this$0.w1(list);
                    return;
                }
                com.transsnet.downloader.adapter.g0 g0Var = this.this$0.f60879r;
                if (g0Var != null) {
                    g0Var.r0(this.this$0.f1());
                }
            }
        }));
    }

    public final void n1() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    public final void o1() {
        h1().j().j(this, new b(new Function1<List<DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.TransferSelectListFragment$initReceivedTabViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DownloadBean> list) {
                SwipeRefreshLayout swipeRefreshLayout;
                h00.n0 mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f65964c) != null && swipeRefreshLayout.isRefreshing()) {
                    h00.n0 mViewBinding2 = this.this$0.getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f65964c : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                this.this$0.F0();
                List<DownloadBean> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    this.this$0.w1(list);
                    return;
                }
                com.transsnet.downloader.adapter.g0 g0Var = this.this$0.f60879r;
                if (g0Var != null) {
                    g0Var.r0(this.this$0.j1());
                }
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (!z11) {
            B0();
        }
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    public final void s1(DownloadBean downloadBean, View view, int i11) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        d1().w().q(TransferBottomToolsView.STATUS_SEND);
        androidx.lifecycle.c0<List<DownloadBean>> c0VarB = d1().B(this.f60878q);
        Object obj = null;
        List<DownloadBean> listF = c0VarB != null ? c0VarB.f() : null;
        if (listF == null) {
            listF = new ArrayList<>();
        }
        if (downloadBean == null || !downloadBean.isCheck()) {
            if (downloadBean != null) {
                downloadBean.setCheck(true);
            }
            if (downloadBean != null) {
                listF.add(downloadBean);
                DownloadUtil.f61136a.A(true, downloadBean);
                androidx.lifecycle.c0<List<DownloadBean>> c0VarB2 = d1().B(this.f60878q);
                if (c0VarB2 != null) {
                    c0VarB2.q(listF);
                }
            }
        } else if (DownloadUtil.f61136a.v(downloadBean)) {
            downloadBean.setCheck(false);
            Iterator<DownloadBean> it = listF.iterator();
            int i12 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i12 = -1;
                    break;
                }
                DownloadBean next = it.next();
                if (!next.isSeries()) {
                    if (Intrinsics.b(next.getResourceId(), downloadBean.getResourceId())) {
                        break;
                    } else {
                        i12++;
                    }
                } else if (Intrinsics.b(next.getSubjectId(), downloadBean.getSubjectId()) && next.getResolution() == downloadBean.getResolution() && next.getEp() == downloadBean.getEp() && next.getSe() == downloadBean.getSe()) {
                    break;
                } else {
                    i12++;
                }
            }
            try {
                Result.Companion companion = Result.Companion;
                if (i12 >= 0) {
                    listF.remove(i12);
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            DownloadUtil.f61136a.A(false, downloadBean);
            androidx.lifecycle.c0<List<DownloadBean>> c0VarB3 = d1().B(this.f60878q);
            if (c0VarB3 != null) {
                c0VarB3.q(listF);
            }
        } else {
            for (Object obj2 : listF) {
                if (Intrinsics.b((DownloadBean) obj2, downloadBean)) {
                    obj = obj2;
                    break;
                }
            }
            if (obj == null) {
                listF.add(downloadBean);
            }
            DownloadUtil.f61136a.A(true, downloadBean);
            androidx.lifecycle.c0<List<DownloadBean>> c0VarB4 = d1().B(this.f60878q);
            if (c0VarB4 != null) {
                c0VarB4.q(listF);
            }
        }
        d1().D().q(Integer.valueOf(DownloadUtil.f61136a.n(listF)));
        uo.b.a.f(uo.b.f78622a, this.f60872k, "onItemCheckClick selectedList size:" + listF.size(), false, 4, null);
        com.transsnet.downloader.adapter.g0 g0Var = this.f60879r;
        if (g0Var != null) {
            g0Var.notifyItemChanged(i11, downloadBean);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void t1(DownloadBean downloadBean) {
        d1().y().q(Boolean.TRUE);
        d1().x().q(downloadBean);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        int i11 = this.f60878q;
        if (i11 != 0 && i11 != 2 && !com.transsnet.downloader.viewmodel.c.f61276a.a()) {
            v1();
        }
        h00.n0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f65963b) != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
            com.transsnet.downloader.adapter.g0 g0Var = new com.transsnet.downloader.adapter.g0(new ArrayList());
            this.f60879r = g0Var;
            g0Var.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.z1
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    TransferSelectListFragment.p1(this.f60986a, baseQuickAdapter, view, i12);
                }
            });
            g0Var.i(R$id.v_more);
            g0Var.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.a2
                @Override // f9.b
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    TransferSelectListFragment.q1(this.f60886a, baseQuickAdapter, view, i12);
                }
            });
            recyclerView.setAdapter(g0Var);
        }
        h00.n0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (swipeRefreshLayout = mViewBinding2.f65964c) == null) {
            return;
        }
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.bg_01));
        swipeRefreshLayout.setColorSchemeColors(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_center), z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_start));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsnet.downloader.fragment.b2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                TransferSelectListFragment.r1(this.f60900a);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
