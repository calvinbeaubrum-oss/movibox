package com.transsion.search.fragment.group;

import android.annotation.SuppressLint;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.SearchManager;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.PagerEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchSubject;
import com.transsion.search.bean.SearchWorkEntity;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.viewmodel.SearchWorkViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class SearchUploadWorkFragment extends BaseFragment<bx.e> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f57479k = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f57481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public dx.c f57482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f57483d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SearchViewModel f57484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f57486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f57487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f57488j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchUploadWorkFragment a(int i11) {
            SearchUploadWorkFragment searchUploadWorkFragment = new SearchUploadWorkFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i11);
            searchUploadWorkFragment.setArguments(bundle);
            return searchUploadWorkFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.tn.lib.util.networkinfo.g {
        public b() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            h9.f fVarQ;
            List<SearchSubject> listD;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            z zVar = SearchUploadWorkFragment.this.f57481b;
            if (zVar != null && (listD = zVar.D()) != null && listD.isEmpty()) {
                SearchUploadWorkFragment.this.searchJob();
                return;
            }
            z zVar2 = SearchUploadWorkFragment.this.f57481b;
            if (zVar2 == null || (fVarQ = zVar2.Q()) == null) {
                return;
            }
            fVarQ.v();
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                SearchUploadWorkFragment.this.resetContent(true);
            }
            SearchUploadWorkFragment.this.f57488j = StringsKt__StringsKt.Z0(String.valueOf(editable)).toString();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SearchUploadWorkFragment.this.S0(true);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            SearchUploadWorkFragment.this.f57488j = StringsKt__StringsKt.Z0(String.valueOf(textView != null ? textView.getText() : null)).toString();
            SearchUploadWorkFragment.this.searchJob();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e extends RecyclerView.r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bx.e f57493b;

        public e(bx.e eVar) {
            this.f57493b = eVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            FragmentActivity activity;
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 1 || (activity = SearchUploadWorkFragment.this.getActivity()) == null) {
                return;
            }
            bx.e eVar = this.f57493b;
            if (KeyboardUtils.g(activity)) {
                KeyboardUtils.e(eVar.f14472c);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57494a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57494a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57494a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57494a.invoke(obj);
        }
    }

    public SearchUploadWorkFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f57483d = FragmentViewModelLazyKt.a(this, Reflection.b(SearchWorkViewModel.class), new Function0<x0>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f57486h = 1;
        this.f57487i = 10;
        this.f57488j = "";
    }

    public static final void E0(SearchUploadWorkFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.searchJob();
    }

    public static final void I0(SearchUploadWorkFragment this$0, dx.c this_apply) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        if (this$0.G0().f()) {
            SearchWorkViewModel.k(this$0.G0(), false, 1, null);
        } else {
            this_apply.Q().s(false);
        }
    }

    public static final void J0(SearchUploadWorkFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<VideoDetailPlayBean> listD;
        VideoDetailPlayBean videoDetailPlayBean;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "view");
        dx.c cVar = this$0.f57482c;
        if (cVar == null || (listD = cVar.D()) == null || (videoDetailPlayBean = listD.get(i11)) == null) {
            return;
        }
        this$0.reportClick("", videoDetailPlayBean.getSubjectId(), "", i11);
        cw.a aVar = new cw.a();
        aVar.o(3);
        aVar.n(1);
        aVar.s(this$0.V0(videoDetailPlayBean));
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void K0(View view, boolean z11) {
        view.dispatchWindowFocusChanged(z11);
    }

    public static final void L0(SearchUploadWorkFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.searchJob();
    }

    public static final void M0(SearchUploadWorkFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.resetContent(false);
    }

    public static final void N0(SearchUploadWorkFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.R0();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void O0(final SearchUploadWorkFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            SearchViewModel searchViewModel = this$0.f57484f;
            if (searchViewModel != null) {
                searchViewModel.u(this$0.f57486h, this$0.f57487i, this$0.f57488j);
                return;
            }
            return;
        }
        zp.b.f82110a.d(R$string.no_network_toast);
        bx.e mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f14477i) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.search.fragment.group.y
            @Override // java.lang.Runnable
            public final void run() {
                SearchUploadWorkFragment.P0(this.f57521a);
            }
        }, 300L);
    }

    public static final void P0(SearchUploadWorkFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        z zVar = this$0.f57481b;
        if (zVar == null || (fVarQ = zVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static final void Q0(SearchUploadWorkFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<SearchSubject> listD;
        SearchSubject searchSubject;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "view");
        z zVar = this$0.f57481b;
        if (zVar == null || (listD = zVar.D()) == null || (searchSubject = listD.get(i11)) == null) {
            return;
        }
        this$0.reportClick("", searchSubject.getSubjectId(), searchSubject.getOps(), i11);
        cw.a aVar = new cw.a();
        aVar.o(3);
        aVar.n(1);
        aVar.s(searchSubject);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initHistory() {
        final dx.c cVar = new dx.c(new ArrayList());
        cVar.Q().C(new f9.f() { // from class: com.transsion.search.fragment.group.w
            @Override // f9.f
            public final void a() {
                SearchUploadWorkFragment.I0(this.f57518a, cVar);
            }
        });
        cVar.B0(new f9.d() { // from class: com.transsion.search.fragment.group.x
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SearchUploadWorkFragment.J0(this.f57520a, baseQuickAdapter, view, i11);
            }
        });
        this.f57482c = cVar;
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        SearchViewModel searchViewModel = (SearchViewModel) new v0(fragmentActivityRequireActivity).a(SearchViewModel.class);
        searchViewModel.l().j(getViewLifecycleOwner(), new f(new Function1<SearchGroupEntity, Unit>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchGroupEntity searchGroupEntity) {
                invoke2(searchGroupEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchGroupEntity searchGroupEntity) {
                ProgressBar progressBar;
                PagerEntity pager;
                PagerEntity pager2;
                String nextPage;
                Integer numL;
                this.this$0.f57486h = (searchGroupEntity == null || (pager2 = searchGroupEntity.getPager()) == null || (nextPage = pager2.getNextPage()) == null || (numL = kotlin.text.k.l(nextPage)) == null) ? 1 : numL.intValue();
                this.this$0.f57487i = (searchGroupEntity == null || (pager = searchGroupEntity.getPager()) == null) ? 10 : pager.getPerPage();
                bx.e mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding == null || (progressBar = mViewBinding.f14475g) == null) {
                    return;
                }
                so.c.g(progressBar);
            }
        }));
        searchViewModel.n().j(getViewLifecycleOwner(), new f(new Function1<SearchWorkEntity, Unit>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchWorkEntity searchWorkEntity) {
                invoke2(searchWorkEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchWorkEntity searchWorkEntity) {
                Pager pager;
                HashMap<String, String> mapG;
                List<SearchSubject> listD;
                ProgressBar progressBar;
                Pager pager2;
                Pager pager3;
                Pager pager4;
                Boolean boolValueOf = null;
                List<SearchSubject> items = searchWorkEntity != null ? searchWorkEntity.getItems() : null;
                boolean hasMore = (searchWorkEntity == null || (pager4 = searchWorkEntity.getPager()) == null) ? false : pager4.getHasMore();
                this.this$0.f57486h = (searchWorkEntity == null || (pager3 = searchWorkEntity.getPager()) == null) ? 1 : pager3.getNextPage();
                this.this$0.f57487i = (searchWorkEntity == null || (pager2 = searchWorkEntity.getPager()) == null) ? 10 : pager2.getPerPage();
                bx.e mViewBinding = this.this$0.getMViewBinding();
                if (mViewBinding != null && (progressBar = mViewBinding.f14475g) != null) {
                    so.c.g(progressBar);
                }
                z zVar = this.this$0.f57481b;
                if (zVar != null) {
                    SearchUploadWorkFragment searchUploadWorkFragment = this.this$0;
                    zVar.Q().r();
                    z zVar2 = searchUploadWorkFragment.f57481b;
                    if (zVar2 != null && (listD = zVar2.D()) != null) {
                        boolValueOf = Boolean.valueOf(listD.isEmpty());
                    }
                    List<SearchSubject> list = items;
                    if ((list == null || list.isEmpty()) && Intrinsics.b(boolValueOf, Boolean.TRUE) && (searchUploadWorkFragment.f57486h == 1 || (searchWorkEntity != null && (pager = searchWorkEntity.getPager()) != null && pager.getPage() == 1))) {
                        zVar.x0(new ArrayList());
                        zVar.r0(searchUploadWorkFragment.emptyView());
                        searchUploadWorkFragment.U0(false);
                        zVar.E0(true);
                    }
                    if (list == null || list.isEmpty()) {
                        zVar.Q().s(false);
                    } else {
                        if (searchUploadWorkFragment.f57480a) {
                            searchUploadWorkFragment.f57480a = false;
                            z zVar3 = searchUploadWorkFragment.f57481b;
                            if (zVar3 != null) {
                                zVar3.w0(list);
                            }
                        } else {
                            z zVar4 = searchUploadWorkFragment.f57481b;
                            if (zVar4 != null) {
                                zVar4.m(list);
                            }
                        }
                        com.transsion.baselib.report.h logViewConfig = searchUploadWorkFragment.getLogViewConfig();
                        if (logViewConfig != null) {
                            logViewConfig.j(true);
                        }
                        com.transsion.baselib.report.h logViewConfig2 = searchUploadWorkFragment.getLogViewConfig();
                        if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
                            mapG.put("type", String.valueOf(searchUploadWorkFragment.f57485g));
                        }
                        searchUploadWorkFragment.U0(false);
                    }
                    if (!hasMore) {
                        zVar.Q().s(false);
                    }
                    if (searchWorkEntity == null) {
                        zVar.Q().u();
                    }
                }
            }
        }));
        this.f57484f = searchViewModel;
    }

    public final void F0() {
        G0().j(true);
        G0().g().j(this, new f(new Function1<List<VideoDetailPlayBean>, Unit>() { // from class: com.transsion.search.fragment.group.SearchUploadWorkFragment$getHistoryWork$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<VideoDetailPlayBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<VideoDetailPlayBean> list) {
                bx.e mViewBinding;
                TextView textView;
                List<VideoDetailPlayBean> list2 = list;
                if ((list2 == null || list2.isEmpty()) && (mViewBinding = this.this$0.getMViewBinding()) != null && (textView = mViewBinding.f14476h) != null) {
                    so.c.g(textView);
                }
                dx.c cVar = this.this$0.f57482c;
                if (cVar != null) {
                    cVar.w0(list2);
                }
            }
        }));
    }

    public final SearchWorkViewModel G0() {
        return (SearchWorkViewModel) this.f57483d.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public bx.e getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bx.e eVarC = bx.e.c(inflater);
        Intrinsics.f(eVarC, "inflate(inflater)");
        return eVarC;
    }

    public final void R0() {
        ax.a aVar = new ax.a();
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = ax.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    public final void S0(boolean z11) {
        bx.e mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            if (z11) {
                TextView textView = mViewBinding.f14478j;
                Intrinsics.f(textView, "it.searchTV");
                so.c.k(textView);
                AppCompatImageView appCompatImageView = mViewBinding.f14471b;
                Intrinsics.f(appCompatImageView, "it.clearIV");
                so.c.g(appCompatImageView);
                return;
            }
            TextView textView2 = mViewBinding.f14478j;
            Intrinsics.f(textView2, "it.searchTV");
            so.c.g(textView2);
            AppCompatImageView appCompatImageView2 = mViewBinding.f14471b;
            Intrinsics.f(appCompatImageView2, "it.clearIV");
            so.c.k(appCompatImageView2);
        }
    }

    public final void T0() {
        zp.b.f82110a.d(R$string.no_network_toast);
        U0(false);
        z zVar = this.f57481b;
        if (zVar != null) {
            zVar.r0(emptyView());
        }
        z zVar2 = this.f57481b;
        if (zVar2 != null) {
            zVar2.x0(new ArrayList());
        }
    }

    public final void U0(boolean z11) {
        bx.e mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            TextView textView = mViewBinding.f14476h;
            Intrinsics.f(textView, "binding.recentTV");
            textView.setVisibility(z11 ? 0 : 8);
            if (!z11) {
                mViewBinding.f14477i.setAdapter(this.f57481b);
                return;
            }
            mViewBinding.f14477i.setAdapter(this.f57482c);
            dx.c cVar = this.f57482c;
            if (cVar != null) {
                cVar.w0(G0().g().f());
            }
        }
    }

    public final Subject V0(VideoDetailPlayBean videoDetailPlayBean) {
        Cover cover = new Cover(null, null, null, videoDetailPlayBean.getCoverUrl(), null, videoDetailPlayBean.getThumbnail(), null, null, null, 471, null);
        return new Subject(videoDetailPlayBean.getSubjectId(), videoDetailPlayBean.getSubjectType(), videoDetailPlayBean.getTitle(), null, cover, null, null, null, null, com.transsion.moviedetailapi.helper.a.f53896a.g(videoDetailPlayBean.getSubjectType()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -536, 4194303, null);
    }

    public final View emptyView() {
        EditText editText;
        Editable text = null;
        View view = getLayoutInflater().inflate(R$layout.view_search_manager_empty, (ViewGroup) null);
        TextView textView = (TextView) view.findViewById(R$id.tv_empty_tips);
        ImageView imageView = (ImageView) view.findViewById(R$id.iv_tips);
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tv_retry);
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            bx.e mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f14472c) != null) {
                text = editText.getText();
            }
            String strValueOf = String.valueOf(text);
            textView.setText(getString(com.transsion.search.R$string.user_works_empty) + " \"" + strValueOf + "\"");
            appCompatTextView.setVisibility(8);
            imageView.setImageResource(R$mipmap.ic_no_content);
        } else {
            textView.setText(com.transsion.baseui.R$string.base_network_fail);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.E0(this.f57517a, view2);
                }
            });
        }
        Intrinsics.f(view, "view");
        return view;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        setNetListener(new b());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        F0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("searchpage", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProgressBar progressBar;
        bx.e mViewBinding = getMViewBinding();
        if (mViewBinding != null && (progressBar = mViewBinding.f14475g) != null) {
            so.c.g(progressBar);
        }
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f57485g = arguments != null ? arguments.getInt("type") : 1;
        z zVar = new z(new ArrayList());
        zVar.Q().C(new f9.f() { // from class: com.transsion.search.fragment.group.p
            @Override // f9.f
            public final void a() {
                SearchUploadWorkFragment.O0(this.f57512a);
            }
        });
        zVar.B0(new f9.d() { // from class: com.transsion.search.fragment.group.q
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                SearchUploadWorkFragment.Q0(this.f57513a, baseQuickAdapter, view2, i11);
            }
        });
        this.f57481b = zVar;
        initHistory();
        bx.e mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f14477i.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            mViewBinding.f14477i.setAdapter(this.f57482c);
            RecyclerView recyclerView = mViewBinding.f14477i;
            z zVar2 = this.f57481b;
            recyclerView.addOnScrollListener(new hs.a(zVar2 != null ? zVar2.Q() : null));
            RecyclerView recyclerView2 = mViewBinding.f14477i;
            dx.c cVar = this.f57482c;
            recyclerView2.addOnScrollListener(new hs.a(cVar != null ? cVar.Q() : null));
            initViewModel();
            mViewBinding.f14472c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.search.fragment.group.r
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z11) {
                    SearchUploadWorkFragment.K0(view2, z11);
                }
            });
            mViewBinding.f14478j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.L0(this.f57514a, view2);
                }
            });
            mViewBinding.f14472c.addTextChangedListener(new c());
            mViewBinding.f14472c.setOnEditorActionListener(new d());
            mViewBinding.f14471b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.M0(this.f57515a, view2);
                }
            });
            ProgressBar progressBar = mViewBinding.f14475g;
            Intrinsics.f(progressBar, "binding.loadView");
            so.c.g(progressBar);
            mViewBinding.f14473d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.group.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchUploadWorkFragment.N0(this.f57516a, view2);
                }
            });
            mViewBinding.f14472c.requestFocus();
            KeyboardUtils.i(mViewBinding.f14472c);
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.j(true);
            }
            mViewBinding.f14477i.addOnScrollListener(new e(mViewBinding));
        }
    }

    public final void reportClick(String str, String str2, String str3, int i11) {
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        map.put("group_id", str);
        if (str2 == null) {
            str2 = "";
        }
        map.put("subject_id", str2);
        map.put("sequence", String.valueOf(i11));
        if (str3 == null) {
            str3 = "";
        }
        map.put("ops", str3);
        com.transsion.baselib.helper.a.f51183a.e("searchresult", map);
    }

    public final void resetContent(boolean z11) {
        EditText editText;
        if (!z11) {
            bx.e mViewBinding = getMViewBinding();
            if (mViewBinding != null && (editText = mViewBinding.f14472c) != null) {
                editText.setText("");
            }
            this.f57488j = "";
        }
        z zVar = this.f57481b;
        if (zVar != null) {
            zVar.x0(new ArrayList());
        }
        z zVar2 = this.f57481b;
        if (zVar2 != null) {
            zVar2.l0();
        }
        bx.e mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            U0(true);
            TextView textView = mViewBinding2.f14476h;
            Intrinsics.f(textView, "binding.recentTV");
            dx.c cVar = this.f57482c;
            List<VideoDetailPlayBean> listD = cVar != null ? cVar.D() : null;
            textView.setVisibility(true ^ (listD == null || listD.isEmpty()) ? 0 : 8);
            KeyboardUtils.i(mViewBinding2.f14472c);
        }
    }

    public final void searchJob() {
        ProgressBar progressBar;
        if (TextUtils.isEmpty(this.f57488j)) {
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
            hVar.e(16);
            hVar.l(getString(com.transsion.search.R$string.tips_movie));
            return;
        }
        this.f57480a = true;
        SearchManager.f57422f.a().e(this.f57488j);
        bx.e mViewBinding = getMViewBinding();
        EditText editText = mViewBinding != null ? mViewBinding.f14472c : null;
        Intrinsics.d(editText);
        KeyboardUtils.e(editText);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            T0();
            return;
        }
        bx.e mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (progressBar = mViewBinding2.f14475g) != null) {
            so.c.k(progressBar);
        }
        S0(false);
        this.f57486h = 1;
        SearchViewModel searchViewModel = this.f57484f;
        if (searchViewModel != null) {
            searchViewModel.u(1, this.f57487i, this.f57488j);
        }
        HashMap map = new HashMap();
        map.put("module_name", AppLovinEventTypes.USER_EXECUTED_SEARCH);
        map.put(MBridgeConstans.KEY_WORD, this.f57488j);
        map.put("type", String.valueOf(this.f57485g));
        com.transsion.baselib.helper.a.f51183a.e("searchpage", map);
    }
}
