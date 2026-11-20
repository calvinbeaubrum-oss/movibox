package com.transsion.home.fragment.tab;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.home.activity.OperateActivity;
import com.transsion.home.adapter.suboperate.SubTabAdapter;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.fragment.HomeFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.home.viewmodel.SubTabViewModel;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PlayListItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class SubTabFragment extends BaseHomeSubFragment<lt.r> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f52541r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f52542s = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Map<Integer, String> f52543t;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SubTabViewModel f52544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SubTabAdapter f52545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f52546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f52547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f52548l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b1.b<String[]> f52549m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f52551o;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f52550n = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<Function1<? super Boolean, Unit>, Unit> f52552p = new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment$mOnAppointmentClick$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function1) {
            invoke2((Function1<? super Boolean, Unit>) function1);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function1<? super Boolean, Unit> callback) {
            Intrinsics.g(callback, "callback");
            this.this$0.f52548l = callback;
            b1.b bVar = this.this$0.f52549m;
            if (bVar != null) {
                bVar.a(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"});
            }
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f52553q = new d();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i11) {
            String str = (String) SubTabFragment.f52543t.get(Integer.valueOf(i11));
            return str == null ? "home_sub_operate" : str;
        }

        public final SubTabFragment b(int i11, String str) {
            if (!SubTabFragment.f52543t.containsKey(Integer.valueOf(i11)) && str != null) {
                SubTabFragment.f52543t.put(Integer.valueOf(i11), str);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str);
            SubTabFragment subTabFragment = new SubTabFragment();
            subTabFragment.setArguments(bundle);
            return subTabFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends GridLayoutManager.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f52555f;

        public b(RecyclerView recyclerView) {
            this.f52555f = recyclerView;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            SubTabAdapter subTabAdapter = SubTabFragment.this.f52545i;
            Integer numValueOf = subTabAdapter != null ? Integer.valueOf(subTabAdapter.getItemViewType(i11)) : null;
            boolean z11 = com.blankj.utilcode.util.d0.e() > com.blankj.utilcode.util.d0.c();
            int iOrdinal = PostItemType.SUBJECT.ordinal();
            if (numValueOf == null || numValueOf.intValue() != iOrdinal) {
                int iOrdinal2 = PostItemType.SINGLE_SUBJECT.ordinal();
                if (numValueOf == null || numValueOf.intValue() != iOrdinal2) {
                    return 6;
                }
            }
            Context context = this.f52555f.getContext();
            Intrinsics.f(context, "context");
            if (com.transsion.baseui.util.b.a(context)) {
                return z11 ? 2 : 3;
            }
            return 6;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends DiffUtil.e<OperateItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(OperateItem oldItem, OperateItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            Subject feedsSubject = oldItem.getFeedsSubject();
            String subjectId = feedsSubject != null ? feedsSubject.getSubjectId() : null;
            Subject feedsSubject2 = newItem.getFeedsSubject();
            return Intrinsics.b(subjectId, feedsSubject2 != null ? feedsSubject2.getSubjectId() : null);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(OperateItem oldItem, OperateItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            Subject feedsSubject = oldItem.getFeedsSubject();
            Integer subjectType = feedsSubject != null ? feedsSubject.getSubjectType() : null;
            Subject feedsSubject2 = newItem.getFeedsSubject();
            return Intrinsics.b(subjectType, feedsSubject2 != null ? feedsSubject2.getSubjectType() : null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends RecyclerView.r {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            if (SubTabFragment.this.f52546j) {
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                SubTabFragment subTabFragment = SubTabFragment.this;
                subTabFragment.d1(kotlin.ranges.a.f((iComputeVerticalScrollOffset * 1.0f) / subTabFragment.f52547k, 1.0f));
                if (!SubTabFragment.this.q0() && SubTabFragment.this.S0() < 0.7f) {
                    SubTabFragment.this.g0(true);
                } else {
                    if (!SubTabFragment.this.q0() || SubTabFragment.this.S0() < 0.7f) {
                        return;
                    }
                    SubTabFragment.this.g0(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.tn.lib.util.networkinfo.g {
        public e() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            SubTabAdapter subTabAdapter;
            List<OperateItem> listD;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            if (SubTabFragment.this.isResumed() && (subTabAdapter = SubTabFragment.this.f52545i) != null && (listD = subTabAdapter.D()) != null && listD.isEmpty()) {
                SubTabFragment.this.b1();
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f implements b1.a<Map<String, Boolean>> {
        public f() {
        }

        public static final void d(SubTabFragment this$0, Ref.BooleanRef allGranted) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(allGranted, "$allGranted");
            Function1 function1 = this$0.f52548l;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(allGranted.element));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b1.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final void a(Map<String, Boolean> permissions) {
            RecyclerView recyclerView;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            Intrinsics.f(permissions, "permissions");
            Iterator<Map.Entry<String, Boolean>> it = permissions.entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().booleanValue()) {
                    booleanRef.element = false;
                }
            }
            lt.r rVar = (lt.r) SubTabFragment.this.getMViewBinding();
            if (rVar == null || (recyclerView = rVar.f70502f) == null) {
                return;
            }
            final SubTabFragment subTabFragment = SubTabFragment.this;
            recyclerView.post(new Runnable() { // from class: com.transsion.home.fragment.tab.x
                @Override // java.lang.Runnable
                public final void run() {
                    SubTabFragment.f.d(subTabFragment, booleanRef);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52559a;

        public g(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52559a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52559a;
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
            this.f52559a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.home.fragment.tab.SubTabFragment$initData$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass3 extends Lambda implements Function1<BaseDto<TrendingRespData>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        public static final void b(SubTabFragment this$0) {
            h9.f fVarQ;
            Intrinsics.g(this$0, "this$0");
            SubTabAdapter subTabAdapter = this$0.f52545i;
            if (subTabAdapter == null || (fVarQ = subTabAdapter.Q()) == null) {
                return;
            }
            fVarQ.r();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseDto<TrendingRespData> baseDto) {
            invoke2(baseDto);
            return Unit.f68710a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BaseDto<TrendingRespData> baseDto) {
            h9.f fVarQ;
            TrendingRespData data;
            Pager pager;
            h9.f fVarQ2;
            TrendingRespData data2;
            List<TrendingRespItem> items;
            ConstraintLayout constraintLayoutB;
            List transferData;
            if (baseDto != null && (data2 = baseDto.getData()) != null && (items = data2.getItems()) != null && items.size() > 0) {
                SubTabAdapter subTabAdapter = SubTabFragment.this.f52545i;
                if (subTabAdapter != null) {
                    TrendingRespData data3 = baseDto.getData();
                    subTabAdapter.m((data3 == null || (transferData = data3.getTransferData()) == null) ? new ArrayList() : transferData);
                }
                lt.r rVar = (lt.r) SubTabFragment.this.getMViewBinding();
                if (rVar == null || (constraintLayoutB = rVar.getRoot()) == null) {
                    return;
                }
                final SubTabFragment subTabFragment = SubTabFragment.this;
                constraintLayoutB.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubTabFragment.AnonymousClass3.b(subTabFragment);
                    }
                }, 300L);
                return;
            }
            if (baseDto == null || (data = baseDto.getData()) == null || (pager = data.getPager()) == null || !Intrinsics.b(pager.getHasMore(), Boolean.FALSE)) {
                SubTabAdapter subTabAdapter2 = SubTabFragment.this.f52545i;
                if (subTabAdapter2 == null || (fVarQ = subTabAdapter2.Q()) == null) {
                    return;
                }
                fVarQ.u();
                return;
            }
            SubTabAdapter subTabAdapter3 = SubTabFragment.this.f52545i;
            if (subTabAdapter3 == null || (fVarQ2 = subTabAdapter3.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ2, false, 1, null);
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(HomeTabId.Trending.getValue()), HomeTabType.TAB_CODE_TRENDING);
        f52543t = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Q0() {
        Guideline guideline;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        View view;
        RecyclerView recyclerView2;
        SwipeRefreshLayout swipeRefreshLayout2;
        Guideline guideline2;
        lt.r rVar = (lt.r) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (rVar == null || (guideline2 = rVar.f70501d) == null) ? null : guideline2.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (this.f52546j) {
            bVar.f7277a = 0;
            lt.r rVar2 = (lt.r) getMViewBinding();
            guideline = rVar2 != null ? rVar2.f70501d : null;
            if (guideline != null) {
                guideline.setLayoutParams(bVar);
            }
            lt.r rVar3 = (lt.r) getMViewBinding();
            if (rVar3 != null && (swipeRefreshLayout2 = rVar3.f70503g) != null) {
                swipeRefreshLayout2.invalidate();
            }
            d1(0.0f);
            g0(true);
            lt.r rVar4 = (lt.r) getMViewBinding();
            if (rVar4 == null || (recyclerView2 = rVar4.f70502f) == null) {
                return;
            }
            recyclerView2.addOnScrollListener(this.f52553q);
            return;
        }
        lt.r rVar5 = (lt.r) getMViewBinding();
        bVar.f7277a = (rVar5 == null || (view = rVar5.f70499b) == null) ? 0 : view.getHeight();
        lt.r rVar6 = (lt.r) getMViewBinding();
        guideline = rVar6 != null ? rVar6.f70501d : null;
        if (guideline != null) {
            guideline.setLayoutParams(bVar);
        }
        lt.r rVar7 = (lt.r) getMViewBinding();
        if (rVar7 != null && (swipeRefreshLayout = rVar7.f70503g) != null) {
            swipeRefreshLayout.invalidate();
        }
        d1(1.0f);
        g0(false);
        lt.r rVar8 = (lt.r) getMViewBinding();
        if (rVar8 == null || (recyclerView = rVar8.f70502f) == null) {
            return;
        }
        recyclerView.removeOnScrollListener(this.f52553q);
    }

    private final View R0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(3, 1, false, "", "");
        stateView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment$getErrorView$1$1
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
                this.this$0.b1();
            }
        });
        return stateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float S0() {
        View view;
        lt.r rVar = (lt.r) getMViewBinding();
        if (rVar == null || (view = rVar.f70499b) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    private final View U0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(contextRequireContext);
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
        noNetworkBigView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment$getNoNetworkView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                so.c.g(noNetworkBigView);
                this.b1();
                com.tn.lib.view.l.b(this.getPageName());
            }
        });
        noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment$getNoNetworkView$1$2
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
                com.tn.lib.view.l.c(this.this$0.getPageName());
            }
        });
        com.tn.lib.view.l.a(getPageName());
        this.f52551o = noNetworkBigView;
        Intrinsics.d(noNetworkBigView);
        return noNetworkBigView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Y0(final SubTabFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            lt.r rVar = (lt.r) this$0.getMViewBinding();
            if (rVar == null || (recyclerView = rVar.f70502f) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.v
                @Override // java.lang.Runnable
                public final void run() {
                    SubTabFragment.Z0(this.f52629a);
                }
            }, 500L);
            return;
        }
        List<String> listV0 = this$0.V0();
        uo.b.a.f(uo.b.f78622a, "SubTabFragment", "The playlistIds is " + listV0, false, 4, null);
        SubTabViewModel subTabViewModel = this$0.f52544h;
        if (subTabViewModel != null) {
            subTabViewModel.m(this$0.k0(), false, listV0);
        }
    }

    public static final void Z0(SubTabFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        SubTabAdapter subTabAdapter = this$0.f52545i;
        if (subTabAdapter == null || (fVarQ = subTabAdapter.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static final void a1(SubTabFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.h0();
    }

    private final void c1() {
        setNetListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void d1(float f11) {
        lt.r rVar = (lt.r) getMViewBinding();
        View view = rVar != null ? rVar.f70499b : null;
        if (view == null) {
            return;
        }
        view.setAlpha(f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.s
            @Override // java.lang.Runnable
            public final void run() {
                SubTabFragment.f1(this.f52626a);
            }
        }, 200L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f1(SubTabFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.isDetached() || !this$0.isAdded() || this$0.getContext() == null) {
            return;
        }
        View viewR0 = com.tn.lib.util.networkinfo.f.f49475a.e() ? this$0.R0() : this$0.U0();
        SubTabAdapter subTabAdapter = this$0.f52545i;
        if (subTabAdapter != null) {
            subTabAdapter.r0(viewR0);
        }
        this$0.Q0();
        lt.r rVar = (lt.r) this$0.getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout = rVar != null ? rVar.f70503g : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int T0() {
        View view;
        View view2;
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof HomeFragment) {
            return n0();
        }
        if (parentFragment instanceof BottomOpFragment) {
            Fragment parentFragment2 = getParentFragment();
            Intrinsics.e(parentFragment2, "null cannot be cast to non-null type com.transsion.home.fragment.tab.BottomOpFragment");
            return ((BottomOpFragment) parentFragment2).i0();
        }
        if (!(getActivity() instanceof OperateActivity)) {
            lt.r rVar = (lt.r) getMViewBinding();
            if (rVar != null && (view = rVar.f70499b) != null) {
                so.c.h(view);
            }
            return 1;
        }
        int color = z2.a.getColor(requireContext(), R$color.bg_02);
        lt.r rVar2 = (lt.r) getMViewBinding();
        if (rVar2 != null && (view2 = rVar2.f70499b) != null) {
            view2.setBackgroundColor(color);
        }
        FragmentActivity activity = getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.home.activity.OperateActivity");
        return ((OperateActivity) activity).M();
    }

    public final List<String> V0() {
        List<OperateItem> listD;
        ArrayList arrayList = new ArrayList();
        SubTabAdapter subTabAdapter = this.f52545i;
        if (subTabAdapter != null && (listD = subTabAdapter.D()) != null) {
            for (OperateItem operateItem : listD) {
                if (Intrinsics.b(operateItem.getType(), PostItemType.PLAY_LIST.getValue())) {
                    PlayListItem playListData = operateItem.getPlayListData();
                    if ((playListData != null ? playListData.getGenreTopId() : null) != null) {
                        PlayListItem playListData2 = operateItem.getPlayListData();
                        String genreTopId = playListData2 != null ? playListData2.getGenreTopId() : null;
                        Intrinsics.d(genreTopId);
                        arrayList.add(genreTopId);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public lt.r getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.r rVarC = lt.r.c(inflater);
        Intrinsics.f(rVarC, "inflate(inflater)");
        return rVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void X0() {
        RecyclerView recyclerView;
        RecyclerView.m linearLayoutManager;
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment$initRecycleView$onScrollListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                HashMap<String, String> mapG;
                HashMap<String, String> mapG2;
                String str;
                Integer numL;
                com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                int iIntValue = (logViewConfig == null || (mapG2 = logViewConfig.g()) == null || (str = mapG2.get("scrollPosition")) == null || (numL = kotlin.text.k.l(str)) == null) ? 0 : numL.intValue();
                com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
                    return;
                }
                mapG.put("scrollPosition", String.valueOf(kotlin.ranges.a.d(iIntValue, i11)));
            }
        };
        ArrayList arrayList = new ArrayList();
        Function1<Function1<? super Boolean, Unit>, Unit> function2 = this.f52552p;
        int iK0 = k0();
        KeyEventDispatcher.Component activity = getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b bVarR = ((com.transsion.home.preload.a) activity).r();
        FragmentActivity activity2 = getActivity();
        this.f52545i = new SubTabAdapter(arrayList, function2, this, iK0, bVarR, function1, activity2 != null && com.transsion.baseui.util.b.a(activity2));
        lt.r rVar = (lt.r) getMViewBinding();
        if (rVar != null && (recyclerView = rVar.f70502f) != null) {
            recyclerView.setAdapter(this.f52545i);
            ro.f fVar = new ro.f(com.blankj.utilcode.util.f0.a(12.0f), 1);
            fVar.d(com.blankj.utilcode.util.f0.a(6.0f));
            recyclerView.addItemDecoration(fVar);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            Context context = recyclerView.getContext();
            Intrinsics.f(context, "context");
            if (com.transsion.baseui.util.b.a(context)) {
                NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(recyclerView.getContext(), 6);
                npaGridLayoutManager.setSpanSizeLookup(new b(recyclerView));
                linearLayoutManager = npaGridLayoutManager;
            } else {
                linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            }
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setItemAnimator(null);
        }
        SubTabAdapter subTabAdapter = this.f52545i;
        if (subTabAdapter != null) {
            subTabAdapter.Q().y(true);
            subTabAdapter.Q().y(true);
            subTabAdapter.Q().x(true);
            subTabAdapter.Q().C(new f9.f() { // from class: com.transsion.home.fragment.tab.u
                @Override // f9.f
                public final void a() {
                    SubTabFragment.Y0(this.f52628a);
                }
            });
            subTabAdapter.o0(new c());
        }
    }

    public final void b1() {
        startLoading();
        SubTabViewModel subTabViewModel = this.f52544h;
        if (subTabViewModel != null) {
            subTabViewModel.g(k0(), false);
        }
    }

    public final String getPageName() {
        return f52541r.a(k0());
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void h0() {
        SubTabViewModel subTabViewModel = this.f52544h;
        if (subTabViewModel != null) {
            subTabViewModel.g(k0(), true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        lt.b0 b0Var;
        ConstraintLayout constraintLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        lt.r rVar = (lt.r) getMViewBinding();
        if (rVar != null && (swipeRefreshLayout = rVar.f70503g) != null && swipeRefreshLayout.isRefreshing()) {
            lt.r rVar2 = (lt.r) getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout2 = rVar2 != null ? rVar2.f70503g : null;
            if (swipeRefreshLayout2 == null) {
                return;
            }
            swipeRefreshLayout2.setRefreshing(false);
            return;
        }
        lt.r rVar3 = (lt.r) getMViewBinding();
        if (rVar3 == null || (b0Var = rVar3.f70500c) == null || (constraintLayout = b0Var.f70397i) == null) {
            return;
        }
        so.c.g(constraintLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        androidx.lifecycle.c0<BaseDto<TrendingRespData>> c0VarL;
        androidx.lifecycle.c0<SubOperateData> c0VarJ;
        androidx.lifecycle.c0<SubOperateData> c0VarI;
        Intrinsics.g(view, "view");
        final Function1<SubOperateData, Unit> function1 = new Function1<SubOperateData, Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment$initData$initViewWithData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubOperateData subOperateData) {
                invoke2(subOperateData);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubOperateData subOperateData) {
                List<OperateItem> items;
                OperateItem operateItem;
                lt.r rVar = (lt.r) this.this$0.getMViewBinding();
                String type = null;
                SwipeRefreshLayout swipeRefreshLayout = rVar != null ? rVar.f70503g : null;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setEnabled(true);
                }
                SubTabAdapter subTabAdapter = this.this$0.f52545i;
                h9.f fVarQ = subTabAdapter != null ? subTabAdapter.Q() : null;
                if (fVarQ != null) {
                    fVarQ.y(true);
                }
                HomeUtilsKt.a(subOperateData != null ? subOperateData.getItems() : null, subOperateData != null ? subOperateData.getOps() : null);
                SubTabAdapter subTabAdapter2 = this.this$0.f52545i;
                if (subTabAdapter2 != null) {
                    subTabAdapter2.w0(subOperateData != null ? subOperateData.getItems() : null);
                }
                SubTabFragment subTabFragment = this.this$0;
                String value = PostItemType.BANNER.getValue();
                if (subOperateData != null && (items = subOperateData.getItems()) != null && (operateItem = items.get(0)) != null) {
                    type = operateItem.getType();
                }
                subTabFragment.f52546j = Intrinsics.b(value, type);
                if (this.this$0.f52550n) {
                    this.this$0.Q0();
                    this.this$0.f52550n = false;
                }
            }
        };
        SubTabViewModel subTabViewModel = this.f52544h;
        if (subTabViewModel != null && (c0VarI = subTabViewModel.i()) != null) {
            c0VarI.j(this, new g(new Function1<SubOperateData, Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment.initData.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SubOperateData subOperateData) {
                    invoke2(subOperateData);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubOperateData subOperateData) {
                    List<OperateItem> items;
                    SubTabFragment.this.hideLoading();
                    if (subOperateData == null || (items = subOperateData.getItems()) == null || items.size() <= 0) {
                        SubTabFragment.this.e1();
                        return;
                    }
                    com.transsion.baselib.report.h logViewConfig = SubTabFragment.this.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    function1.invoke(subOperateData);
                }
            }));
        }
        SubTabViewModel subTabViewModel2 = this.f52544h;
        if (subTabViewModel2 != null && (c0VarJ = subTabViewModel2.j()) != null) {
            c0VarJ.j(this, new g(new Function1<SubOperateData, Unit>() { // from class: com.transsion.home.fragment.tab.SubTabFragment.initData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SubOperateData subOperateData) {
                    invoke2(subOperateData);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubOperateData subOperateData) {
                    List<OperateItem> items;
                    SubTabFragment.this.hideLoading();
                    if (subOperateData == null || (items = subOperateData.getItems()) == null || items.size() <= 0) {
                        return;
                    }
                    SubTabFragment.this.t0();
                    function1.invoke(subOperateData);
                }
            }));
        }
        SubTabViewModel subTabViewModel3 = this.f52544h;
        if (subTabViewModel3 == null || (c0VarL = subTabViewModel3.l()) == null) {
            return;
        }
        c0VarL.j(this, new g(new AnonymousClass3()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        View view2;
        Intrinsics.g(view, "view");
        super.initView(view, bundle);
        this.f52544h = (SubTabViewModel) new v0(this).a(SubTabViewModel.class);
        X0();
        this.f52547k = T0();
        lt.r rVar = (lt.r) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (rVar == null || (view2 = rVar.f70499b) == null) ? null : view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f52547k;
        }
        lt.r rVar2 = (lt.r) getMViewBinding();
        if (rVar2 != null && (swipeRefreshLayout2 = rVar2.f70503g) != null) {
            int i11 = this.f52547k;
            swipeRefreshLayout2.setProgressViewOffset(false, i11, com.blankj.utilcode.util.f0.a(50.0f) + i11);
        }
        lt.r rVar3 = (lt.r) getMViewBinding();
        if (rVar3 != null && (swipeRefreshLayout = rVar3.f70503g) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.t
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    SubTabFragment.a1(this.f52627a);
                }
            });
        }
        c1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView l0() {
        lt.r rVar = (lt.r) getMViewBinding();
        if (rVar != null) {
            return rVar.f70502f;
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        List<OperateItem> listD;
        SubTabAdapter subTabAdapter = this.f52545i;
        if (subTabAdapter == null || (listD = subTabAdapter.D()) == null || listD.size() <= 0) {
            b1();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f52549m = registerForActivityResult(new c1.h(), new f());
        super.onCreate(bundle);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        View view;
        HashMap<String, String> mapG;
        List<OperateItem> listD;
        super.onResume();
        SubTabAdapter subTabAdapter = this.f52545i;
        if ((subTabAdapter == null || (listD = subTabAdapter.D()) == null || listD.size() <= 0) && (view = this.f52551o) != null && view.getVisibility() == 0 && com.tn.lib.util.networkinfo.f.f49475a.e()) {
            uo.b.a aVar = uo.b.f78622a;
            View view2 = this.f52551o;
            uo.b.a.f(aVar, "SubTabFragment", "loaddata on resume = " + (view2 != null ? Integer.valueOf(view2.getVisibility()) : null) + "  " + this, false, 4, null);
            b1();
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("scrollPosition", "0");
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void s0(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
        List<OperateItem> listD;
        Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager == null || i11 < 0) {
            return;
        }
        OperateItem operateItem = new OperateItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        operateItem.setNonAdDelegate(wrapperNativeManager);
        operateItem.setType(PostItemType.TRENDING_NATIVE_AD.getValue());
        SubTabAdapter subTabAdapter = this.f52545i;
        int size = (subTabAdapter == null || (listD = subTabAdapter.D()) == null) ? 0 : listD.size();
        if (i11 < 0 || i11 > size) {
            SubTabAdapter subTabAdapter2 = this.f52545i;
            if (subTabAdapter2 != null) {
                subTabAdapter2.l(operateItem);
                return;
            }
            return;
        }
        SubTabAdapter subTabAdapter3 = this.f52545i;
        if (subTabAdapter3 != null) {
            subTabAdapter3.j(i11, operateItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        lt.b0 b0Var;
        ConstraintLayout constraintLayout;
        lt.r rVar = (lt.r) getMViewBinding();
        if (rVar == null || (b0Var = rVar.f70500c) == null || (constraintLayout = b0Var.f70397i) == null) {
            return;
        }
        so.c.k(constraintLayout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void v0() {
        RecyclerView recyclerView;
        lt.r rVar = (lt.r) getMViewBinding();
        if (rVar == null || (recyclerView = rVar.f70502f) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }
}
