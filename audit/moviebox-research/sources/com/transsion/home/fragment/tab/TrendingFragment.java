package com.transsion.home.fragment.tab;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.DefaultView;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.commercializationapi.ICommonDialogApi;
import com.transsion.fissionapi.IFissionProvider;
import com.transsion.home.R$id;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.home.adapter.trending.TrendingAdapter;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.bean.TrendingRespItemType;
import com.transsion.home.fragment.HomeFragment;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.mb.config.download.RequestConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.CustomData;
import com.transsion.moviedetailapi.bean.LiveListItem;
import com.transsion.moviedetailapi.bean.MainOperateData;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PlayListItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.helper.PreloadHelperKt;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.f1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class TrendingFragment extends BaseHomeSubFragment<lt.s> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f52560y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f52561z = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public nt.b f52562h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TrendingViewModel f52565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TrendingAdapter f52566l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public nt.c f52567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b1.b<Intent> f52568n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f52570p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile MainOperateData f52571q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f52572r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function0<Unit> f52574t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f52575u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b1.b<String[]> f52576v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f52578x;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f52563i = "1";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f52564j = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f52569o = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f52573s = LazyKt__LazyJVMKt.b(new Function0<IFissionProvider>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$fissionProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFissionProvider invoke() {
            return (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Function1<Function1<? super Boolean, Unit>, Unit> f52577w = new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$mOnAppointmentClick$1
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
            this.this$0.f52575u = callback;
            b1.b bVar = this.this$0.f52576v;
            if (bVar != null) {
                bVar.a(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"});
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrendingFragment a(int i11, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str);
            uo.b.f78622a.c("TrendingFragment", "create trending fragment", true);
            TrendingFragment trendingFragment = new TrendingFragment();
            trendingFragment.setArguments(bundle);
            return trendingFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            if (TrendingFragment.this.y1()) {
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                TrendingFragment trendingFragment = TrendingFragment.this;
                trendingFragment.S1(kotlin.ranges.a.f((iComputeVerticalScrollOffset * 1.0f) / trendingFragment.f52570p, 1.0f));
                if (!TrendingFragment.this.q0() && TrendingFragment.this.o1() < 0.7f) {
                    TrendingFragment.this.g0(true);
                } else {
                    if (!TrendingFragment.this.q0() || TrendingFragment.this.o1() < 0.7f) {
                        return;
                    }
                    TrendingFragment.this.g0(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class c implements nt.a {
        public c() {
        }

        @Override // nt.a
        public void a(int i11, long j11, View view) {
            androidx.lifecycle.c0<RoomEntranceResponse> c0VarQ;
            List<BannerData> banners;
            List<BannerData> items;
            try {
                TrendingAdapter trendingAdapter = TrendingFragment.this.f52566l;
                TrendingAdapter trendingAdapter2 = null;
                if (trendingAdapter == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter = null;
                }
                OperateItem operateItem = trendingAdapter.D().get(i11);
                TrendingFragment.this.Q1(i11);
                String type = operateItem.getType();
                if (Intrinsics.b(type, PostItemType.PLAY_LIST.getValue())) {
                    pr.a.f74040a.u(operateItem, j11, i11, HomeTabType.TAB_CODE_TRENDING);
                    return;
                }
                if (Intrinsics.b(type, PostItemType.RANKING_LIST_NUMBER.getValue()) || Intrinsics.b(type, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
                    List<AppointSubject> subjects = operateItem.getSubjects();
                    if (subjects != null) {
                        pr.a.f74040a.x(operateItem, operateItem.getType() + "_Full", subjects, j11, i11);
                        return;
                    }
                    return;
                }
                if (Intrinsics.b(type, PostItemType.CUSTOM_DATA.getValue())) {
                    CustomData customData = operateItem.getCustomData();
                    if (customData == null || (items = customData.getItems()) == null) {
                        return;
                    }
                    pr.a.f74040a.c(operateItem, operateItem.getType() + "_Full", items, j11, i11);
                    return;
                }
                if (!Intrinsics.b(type, PostItemType.HORIZONTAL_BANNER.getValue()) && !Intrinsics.b(type, PostItemType.BANNER.getValue())) {
                    if (Intrinsics.b(type, PostItemType.SPORT_LIVE.getValue())) {
                        List<LiveListItem> liveList = operateItem.getLiveList();
                        if (liveList != null) {
                            pr.a.f74040a.y(operateItem, operateItem.getType() + "_Full", liveList, j11, i11);
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.b(type, PostItemType.ROOM.getValue())) {
                        TrendingViewModel trendingViewModel = TrendingFragment.this.f52565k;
                        if (trendingViewModel == null || (c0VarQ = trendingViewModel.Q()) == null) {
                            return;
                        }
                        c0VarQ.f();
                        return;
                    }
                    if (Intrinsics.b(type, PostItemType.SINGLE_IMAGE.getValue())) {
                        pr.a.f74040a.p(i11, j11, operateItem);
                        return;
                    }
                    nt.c cVarT1 = TrendingFragment.this.t1();
                    if (cVarT1 != null) {
                        TrendingAdapter trendingAdapter3 = TrendingFragment.this.f52566l;
                        if (trendingAdapter3 == null) {
                            Intrinsics.y("mAdapter");
                        } else {
                            trendingAdapter2 = trendingAdapter3;
                        }
                        cVarT1.a(trendingAdapter2, i11, j11);
                        return;
                    }
                    return;
                }
                BannerBean banner = operateItem.getBanner();
                if (banner == null || (banners = banner.getBanners()) == null) {
                    return;
                }
                pr.a.f74040a.c(operateItem, operateItem.getType() + "_Full", banners, j11, i11);
            } catch (Exception e11) {
                String message = e11.getMessage();
                if (message != null) {
                    uo.b.a.f(uo.b.f78622a, "reportExposure", message, false, 4, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class d extends DiffUtil.e<OperateItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(OperateItem oldItem, OperateItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            Subject feedsSubject = oldItem.getFeedsSubject();
            String strValueOf = String.valueOf(feedsSubject != null ? feedsSubject.getSubjectId() : null);
            Subject feedsSubject2 = newItem.getFeedsSubject();
            return Intrinsics.b(strValueOf, String.valueOf(feedsSubject2 != null ? feedsSubject2.getSubjectId() : null));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(OperateItem oldItem, OperateItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getType(), newItem.getType());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class e extends GridLayoutManager.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f52582f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f52583g;

        public e(int i11, int i12) {
            this.f52582f = i11;
            this.f52583g = i12;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            TrendingAdapter trendingAdapter = TrendingFragment.this.f52566l;
            TrendingAdapter trendingAdapter2 = null;
            if (trendingAdapter == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter = null;
            }
            if (!trendingAdapter.Z0()) {
                return this.f52582f;
            }
            TrendingAdapter trendingAdapter3 = TrendingFragment.this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter3;
            }
            return Intrinsics.b(trendingAdapter2.getItem(i11).getType(), PostItemType.SUBJECT.getValue()) ? this.f52582f / this.f52583g : this.f52582f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class f implements com.tn.lib.util.networkinfo.g {
        public f() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            TrendingFragment.this.O1();
            if (TrendingFragment.this.isResumed()) {
                TrendingAdapter trendingAdapter = TrendingFragment.this.f52566l;
                if (trendingAdapter == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter = null;
                }
                if (trendingAdapter.D().isEmpty() || PreloadTrendingData.f52790o.a().G().f() == null) {
                    uo.b.a.f(uo.b.f78622a, "TrendingFragment", "onConnected", false, 4, null);
                    TrendingFragment.this.I1(false);
                }
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
            TrendingFragment.this.H1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RecyclerView recyclerView;
            ViewTreeObserver viewTreeObserver;
            Unit unit;
            TrendingFragment trendingFragment = TrendingFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                FragmentActivity activity = trendingFragment.getActivity();
                if (activity != null) {
                    activity.reportFullyDrawn();
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            lt.s sVar = (lt.s) TrendingFragment.this.getMViewBinding();
            if (sVar == null || (recyclerView = sVar.f70507d) == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null) {
                return true;
            }
            viewTreeObserver.removeOnPreDrawListener(this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class h implements b1.a<Map<String, Boolean>> {
        public h() {
        }

        public static final void d(TrendingFragment this$0, Ref.BooleanRef allGranted) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(allGranted, "$allGranted");
            Function1 function1 = this$0.f52575u;
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
            lt.s sVar = (lt.s) TrendingFragment.this.getMViewBinding();
            if (sVar == null || (recyclerView = sVar.f70507d) == null) {
                return;
            }
            final TrendingFragment trendingFragment = TrendingFragment.this;
            recyclerView.post(new Runnable() { // from class: com.transsion.home.fragment.tab.k0
                @Override // java.lang.Runnable
                public final void run() {
                    TrendingFragment.h.d(trendingFragment, booleanRef);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class i implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52587a;

        public i(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52587a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52587a;
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
            this.f52587a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @DebugMetadata(c = "com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2", f = "TrendingFragment.kt", l = {431}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.home.fragment.tab.TrendingFragment$initViewModel$2$1", f = "TrendingFragment.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ TrendingFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TrendingFragment trendingFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = trendingFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            public final Object invoke(boolean z11, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z11), continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                androidx.lifecycle.c0<Boolean> c0VarN;
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                boolean z11 = this.Z$0;
                TrendingViewModel trendingViewModel = this.this$0.f52565k;
                if (trendingViewModel != null && (c0VarN = trendingViewModel.N()) != null) {
                    c0VarN.n(Boxing.a(z11));
                }
                return Unit.f68710a;
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TrendingFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                f1<Boolean> f1VarD = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).d();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(TrendingFragment.this, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(f1VarD, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    private final void A1() {
        this.f52567m = new nt.c(getPageName());
        nt.b bVar = new nt.b(0.6f, new c(), false, 4, null);
        this.f52562h = bVar;
        bVar.l(2);
    }

    public static final void C1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.K1();
    }

    public static final void D1(TrendingFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        OperateItem operateItem;
        Subject feedsSubject;
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (!(item instanceof OperateItem) || (feedsSubject = (operateItem = (OperateItem) item).getFeedsSubject()) == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() <= 0) {
            return;
        }
        Subject feedsSubject2 = operateItem.getFeedsSubject();
        Intrinsics.d(feedsSubject2);
        HomeUtilsKt.b(feedsSubject2, "opt_feeds");
        nt.c cVar = this$0.f52567m;
        if (cVar != null) {
            Subject feedsSubject3 = operateItem.getFeedsSubject();
            Intrinsics.d(feedsSubject3);
            cVar.b(i11, feedsSubject3);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void E1(TrendingFragment this$0, TrendingAdapter this_apply, BaseQuickAdapter adapter, View view, int i11) {
        Subject feedsSubject;
        TrendingViewModel trendingViewModel;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Object item = adapter.getItem(i11);
        String strC = null;
        OperateItem operateItem = item instanceof OperateItem ? (OperateItem) item : null;
        if (view.getId() == R$id.ll_download) {
            strC = HomeUtilsKt.c(operateItem != null ? operateItem.getFeedsSubject() : null, this$0.getPageName(), this_apply.getContext(), "opt_feeds");
        }
        if (operateItem == null || (feedsSubject = operateItem.getFeedsSubject()) == null || (trendingViewModel = this$0.f52565k) == null) {
            return;
        }
        if (strC == null) {
            strC = "";
        }
        trendingViewModel.U(feedsSubject, i11, strC);
    }

    public static final void F1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.h0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void G1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        ICommonDialogApi iCommonDialogApi = (ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class);
        lt.s sVar = (lt.s) this$0.getMViewBinding();
        iCommonDialogApi.i0(sVar != null ? sVar.f70505b : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(boolean z11) {
        if (z11) {
            TrendingAdapter trendingAdapter = this.f52566l;
            if (trendingAdapter == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter = null;
            }
            if (trendingAdapter.D().size() <= 2) {
                W1();
            }
        }
        PreloadTrendingData preloadTrendingDataA = PreloadTrendingData.f52790o.a();
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        preloadTrendingDataA.M(contextRequireContext);
    }

    public static /* synthetic */ void J1(TrendingFragment trendingFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        trendingFragment.I1(z11);
    }

    public static final void L1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.isResumed() && this$0.isAdded() && this$0.getActivity() != null) {
            TrendingViewModel trendingViewModel = this$0.f52565k;
            if (trendingViewModel != null) {
                trendingViewModel.I();
            }
            TrendingViewModel trendingViewModel2 = this$0.f52565k;
            if (trendingViewModel2 != null) {
                trendingViewModel2.J();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        lt.s sVar = (lt.s) this$0.getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout = sVar != null ? sVar.f70508f : null;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void S1(float f11) {
        lt.s sVar = (lt.s) getMViewBinding();
        View view = sVar != null ? sVar.f70509g : null;
        if (view == null) {
            return;
        }
        view.setAlpha(f11);
    }

    private final void T1() {
        z1();
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        View viewK1 = k1(contextRequireContext);
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        trendingAdapter.r0(viewK1);
    }

    private final void U1() {
        this.f52569o.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.z
            @Override // java.lang.Runnable
            public final void run() {
                TrendingFragment.V1(this.f52634a);
            }
        }, 200L);
    }

    public static final void V1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.isDetached() || !this$0.isAdded() || this$0.getContext() == null) {
            return;
        }
        this$0.z1();
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        View viewM1 = this$0.m1(contextRequireContext);
        TrendingAdapter trendingAdapter = this$0.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        trendingAdapter.r0(viewM1);
    }

    public static final void Y1(TrendingFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        TrendingAdapter trendingAdapter = this$0.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        trendingAdapter.Q().u();
    }

    public static final void Z1(TrendingFragment this$0, List newList) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(newList, "$newList");
        if (this$0.getContext() == null) {
            return;
        }
        TrendingAdapter trendingAdapter = null;
        if (newList.isEmpty()) {
            TrendingAdapter trendingAdapter2 = this$0.f52566l;
            if (trendingAdapter2 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter2 = null;
            }
            h9.f.t(trendingAdapter2.Q(), false, 1, null);
            return;
        }
        TrendingAdapter trendingAdapter3 = this$0.f52566l;
        if (trendingAdapter3 == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter3 = null;
        }
        trendingAdapter3.m(newList);
        TrendingAdapter trendingAdapter4 = this$0.f52566l;
        if (trendingAdapter4 == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter4 = null;
        }
        if (trendingAdapter4.Q().q()) {
            TrendingAdapter trendingAdapter5 = this$0.f52566l;
            if (trendingAdapter5 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter = trendingAdapter5;
            }
            trendingAdapter.Q().r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        return r1();
    }

    private final void initViewModel() {
        TrendingViewModel trendingViewModel = this.f52565k;
        if (trendingViewModel != null) {
            trendingViewModel.R().j(this, new i(new Function1<BaseDto<TrendingRespData>, Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$initViewModel$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BaseDto<TrendingRespData> baseDto) {
                    invoke2(baseDto);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BaseDto<TrendingRespData> baseDto) {
                    List<OperateItem> items;
                    MainOperateData mainOperateData = this.this$0.f52571q;
                    boolean z11 = false;
                    boolean z12 = (mainOperateData == null || (items = mainOperateData.getItems()) == null || items.size() <= 0) ? false : true;
                    if (!z12) {
                        TrendingAdapter trendingAdapter = this.this$0.f52566l;
                        if (trendingAdapter == null) {
                            Intrinsics.y("mAdapter");
                            trendingAdapter = null;
                        }
                        if (trendingAdapter.D().size() > 0 && Intrinsics.b(this.this$0.f52563i, "1")) {
                            z11 = true;
                        }
                    }
                    uo.b.a.f(uo.b.f78622a, "PreloadTrending", "load code" + baseDto.getCode() + " isFresh " + z11 + " hasOperating " + z12, false, 4, null);
                    this.this$0.X1(baseDto, z11);
                }
            }));
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_home_show_honor_v2", true);
            if (Intrinsics.b(configBeanB != null ? configBeanB.getValue() : null, "true") && trendingViewModel.M().f() == null) {
                trendingViewModel.I();
                trendingViewModel.J();
            }
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new AnonymousClass2(null), 3, null);
        h1();
        g1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j1() {
        SwipeRefreshLayout swipeRefreshLayout;
        View view;
        SwipeRefreshLayout swipeRefreshLayout2;
        SwipeRefreshLayout swipeRefreshLayout3;
        lt.s sVar = (lt.s) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (sVar == null || (swipeRefreshLayout3 = sVar.f70508f) == null) ? null : swipeRefreshLayout3.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (y1()) {
            layoutParams2.topMargin = 0;
            lt.s sVar2 = (lt.s) getMViewBinding();
            if (sVar2 != null && (swipeRefreshLayout2 = sVar2.f70508f) != null) {
                int i11 = this.f52570p;
                swipeRefreshLayout2.setProgressViewOffset(false, i11, com.blankj.utilcode.util.f0.a(50.0f) + i11);
            }
            S1(0.0f);
            g0(true);
            return;
        }
        lt.s sVar3 = (lt.s) getMViewBinding();
        layoutParams2.topMargin = (sVar3 == null || (view = sVar3.f70509g) == null) ? 0 : view.getHeight();
        lt.s sVar4 = (lt.s) getMViewBinding();
        if (sVar4 != null && (swipeRefreshLayout = sVar4.f70508f) != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, com.blankj.utilcode.util.f0.a(50.0f));
        }
        S1(1.0f);
        g0(false);
    }

    private final View k1(Context context) {
        final DefaultView defaultView = new DefaultView(context);
        defaultView.setDefaultImageViewVisibility(0);
        defaultView.setDefaultImage(R$mipmap.ic_no_content);
        String string = context.getString(R$string.no_content);
        Intrinsics.f(string, "context.getString(com.tn…dget.R.string.no_content)");
        defaultView.setDescText(string);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DESC_BTN);
        defaultView.setBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string2, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setBtnText(string2);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TrendingFragment.l1(this.f52610a, defaultView, view);
            }
        });
        defaultView.setVisibility(0);
        return defaultView;
    }

    public static final void l1(TrendingFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        J1(this$0, false, 1, null);
        this_apply.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float o1() {
        View view;
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar == null || (view = sVar.f70509g) == null) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    private final String r1() {
        String str;
        if (this.f52572r == null) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof HomeFragment) {
                this.f52572r = ((HomeFragment) parentFragment).x0();
            }
        }
        return (TextUtils.isEmpty(this.f52572r) || (str = this.f52572r) == null) ? HomeTabType.TAB_CODE_TRENDING : str;
    }

    private final List<String> s1() {
        ArrayList arrayList = new ArrayList();
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        for (OperateItem operateItem : trendingAdapter.D()) {
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
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y1() {
        TrendingAdapter trendingAdapter = this.f52566l;
        TrendingAdapter trendingAdapter2 = null;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        if (trendingAdapter.D().size() <= 0) {
            return false;
        }
        TrendingAdapter trendingAdapter3 = this.f52566l;
        if (trendingAdapter3 == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter3 = null;
        }
        if (!Intrinsics.b(trendingAdapter3.D().get(0).getType(), PostItemType.BANNER.getValue())) {
            TrendingAdapter trendingAdapter4 = this.f52566l;
            if (trendingAdapter4 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter4;
            }
            if (!Intrinsics.b(trendingAdapter2.D().get(0).getType(), PostItemType.HONOR.getValue())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1() {
        int i11;
        int i12;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        lt.s sVar;
        RecyclerView recyclerView2;
        Context context = getContext();
        if (context == null || !com.transsion.baseui.util.b.a(context)) {
            i11 = 3;
            i12 = 3;
        } else if (com.blankj.utilcode.util.d0.e() > com.blankj.utilcode.util.d0.c()) {
            i11 = 5;
            i12 = 5;
        } else {
            i11 = 4;
            i12 = 4;
        }
        nt.b bVar = this.f52562h;
        KeyEventDispatcher.Component activity = getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b bVarR = ((com.transsion.home.preload.a) activity).r();
        TrendingViewModel trendingViewModel = this.f52565k;
        Function1<Function1<? super Boolean, Unit>, Unit> function1 = this.f52577w;
        Context context2 = getContext();
        final TrendingAdapter trendingAdapter = new TrendingAdapter(bVar, bVarR, this, trendingViewModel, function1, context2 != null && com.transsion.baseui.util.b.a(context2), i11);
        trendingAdapter.Q().y(true);
        trendingAdapter.Q().x(true);
        trendingAdapter.Q().D(4);
        trendingAdapter.Q().C(new f9.f() { // from class: com.transsion.home.fragment.tab.c0
            @Override // f9.f
            public final void a() {
                TrendingFragment.C1(this.f52594a);
            }
        });
        trendingAdapter.o0(new d());
        trendingAdapter.B0(new f9.d() { // from class: com.transsion.home.fragment.tab.d0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                TrendingFragment.D1(this.f52596a, baseQuickAdapter, view, i13);
            }
        });
        trendingAdapter.i(R$id.ll_download);
        trendingAdapter.z0(new f9.b() { // from class: com.transsion.home.fragment.tab.e0
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                TrendingFragment.E1(this.f52599a, trendingAdapter, baseQuickAdapter, view, i13);
            }
        });
        trendingAdapter.a1(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$initTrendingList$1$5
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
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    this.this$0.O1();
                }
            }
        });
        this.f52566l = trendingAdapter;
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(requireContext(), i12);
        npaGridLayoutManager.setSpanSizeLookup(new e(i12, i11));
        A1();
        nt.b bVar2 = this.f52562h;
        if (bVar2 != null && (sVar = (lt.s) getMViewBinding()) != null && (recyclerView2 = sVar.f70507d) != null) {
            recyclerView2.addOnScrollListener(bVar2);
        }
        lt.s sVar2 = (lt.s) getMViewBinding();
        if (sVar2 != null && (recyclerView = sVar2.f70507d) != null) {
            recyclerView.setLayoutManager(npaGridLayoutManager);
            ro.f fVar = new ro.f(com.blankj.utilcode.util.f0.a(12.0f), i11);
            fVar.d(com.blankj.utilcode.util.f0.a(6.0f));
            recyclerView.addItemDecoration(fVar);
            TrendingAdapter trendingAdapter2 = null;
            recyclerView.setItemAnimator(null);
            TrendingAdapter trendingAdapter3 = this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter3 = null;
            }
            recyclerView.setAdapter(trendingAdapter3);
            TrendingAdapter trendingAdapter4 = this.f52566l;
            if (trendingAdapter4 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter4;
            }
            recyclerView.addOnScrollListener(new hs.a(trendingAdapter2.Q()));
        }
        lt.s sVar3 = (lt.s) getMViewBinding();
        if (sVar3 == null || (swipeRefreshLayout = sVar3.f70508f) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.f0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                TrendingFragment.F1(this.f52603a);
            }
        });
    }

    public final void H1() {
        if (x1()) {
            return;
        }
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        int iP1 = p1(trendingAdapter.D());
        if (iP1 >= 0) {
            TrendingAdapter trendingAdapter2 = this.f52566l;
            if (trendingAdapter2 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter2 = null;
            }
            if (iP1 < trendingAdapter2.D().size()) {
                TrendingAdapter trendingAdapter3 = this.f52566l;
                if (trendingAdapter3 == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter3 = null;
                }
                trendingAdapter3.D().add(iP1, new OperateItem(null, PostItemType.NO_NETWORK.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null));
                TrendingAdapter trendingAdapter4 = this.f52566l;
                if (trendingAdapter4 == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter4 = null;
                }
                trendingAdapter4.notifyItemInserted(iP1);
            }
        }
    }

    public final void K1() {
        List<String> listS1 = s1();
        TrendingViewModel trendingViewModel = this.f52565k;
        if (trendingViewModel != null) {
            String str = this.f52563i;
            int i11 = this.f52564j;
            if (i11 <= 0) {
                i11 = 12;
            }
            TrendingAdapter trendingAdapter = this.f52566l;
            if (trendingAdapter == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter = null;
            }
            trendingViewModel.S(str, i11, listS1, trendingAdapter.Z0());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M1() {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        if (isAdded()) {
            lt.s sVar = (lt.s) getMViewBinding();
            if (sVar != null && (recyclerView = sVar.f70507d) != null) {
                recyclerView.scrollToPosition(0);
            }
            lt.s sVar2 = (lt.s) getMViewBinding();
            if (sVar2 == null || (swipeRefreshLayout = sVar2.f70508f) == null) {
                return;
            }
            swipeRefreshLayout.post(new Runnable() { // from class: com.transsion.home.fragment.tab.a0
                @Override // java.lang.Runnable
                public final void run() {
                    TrendingFragment.N1(this.f52589a);
                }
            });
        }
    }

    public final void O1() {
        int iQ1 = q1();
        if (iQ1 >= 0) {
            TrendingAdapter trendingAdapter = this.f52566l;
            TrendingAdapter trendingAdapter2 = null;
            if (trendingAdapter == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter = null;
            }
            if (iQ1 < trendingAdapter.D().size()) {
                TrendingAdapter trendingAdapter3 = this.f52566l;
                if (trendingAdapter3 == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter3 = null;
                }
                trendingAdapter3.D().remove(iQ1);
                TrendingAdapter trendingAdapter4 = this.f52566l;
                if (trendingAdapter4 == null) {
                    Intrinsics.y("mAdapter");
                } else {
                    trendingAdapter2 = trendingAdapter4;
                }
                trendingAdapter2.notifyItemRemoved(iQ1);
            }
        }
    }

    public final List<OperateItem> P1(List<TrendingRespItem> list) {
        ArrayList arrayList = new ArrayList();
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        List<OperateItem> listD = trendingAdapter.D();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listD) {
            if (((OperateItem) obj).getFeedsSubject() != null) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(kotlin.collections.h.v(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Subject feedsSubject = ((OperateItem) it.next()).getFeedsSubject();
            arrayList3.add(feedsSubject != null ? feedsSubject.getSubjectId() : null);
        }
        for (TrendingRespItem trendingRespItem : list) {
            if (trendingRespItem.getSubject() != null) {
                Subject subject = trendingRespItem.getSubject();
                if (arrayList3.contains(subject != null ? subject.getSubjectId() : null)) {
                    uo.b.a aVar = uo.b.f78622a;
                    Subject subject2 = trendingRespItem.getSubject();
                    String title = subject2 != null ? subject2.getTitle() : null;
                    Subject subject3 = trendingRespItem.getSubject();
                    uo.b.a.f(aVar, HomeTabType.TAB_CODE_TRENDING, "find same item title..." + title + " id  " + (subject3 != null ? subject3.getSubjectId() : null), false, 4, null);
                }
            }
            e1(arrayList, trendingRespItem);
        }
        return arrayList;
    }

    public final void Q1(int i11) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        String str;
        Integer numL;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        int iIntValue = (logViewConfig == null || (mapG2 = logViewConfig.g()) == null || (str = mapG2.get("scrollPosition")) == null || (numL = kotlin.text.k.l(str)) == null) ? 0 : numL.intValue();
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
            return;
        }
        mapG.put("scrollPosition", String.valueOf(kotlin.ranges.a.d(iIntValue, i11)));
    }

    public final void R1(Function0<Unit> function0) {
        this.f52574t = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W1() {
        lt.b0 b0Var;
        ConstraintLayout constraintLayout;
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar != null && (b0Var = sVar.f70506c) != null && (constraintLayout = b0Var.f70397i) != null) {
            so.c.k(constraintLayout);
        }
        lt.s sVar2 = (lt.s) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout = sVar2 != null ? sVar2.f70508f : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setEnabled(false);
    }

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
    public final void X1(BaseDto<TrendingRespData> baseDto, boolean z11) {
        String nextPage;
        List<TrendingRespItem> list;
        List<TrendingRespItem> list2;
        Integer perPage;
        uo.b.a aVar = uo.b.f78622a;
        TrendingAdapter trendingAdapter = null;
        TrendingAdapter trendingAdapter2 = null;
        uo.b.a.f(aVar, "PreloadTrending", "updateTrendingList code " + (baseDto != null ? baseDto.getCode() : null) + " baseBean.data=" + (baseDto != null ? baseDto.getData() : null), false, 4, null);
        if (!Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0")) {
            MainOperateData mainOperateData = this.f52571q;
            List<OperateItem> items = mainOperateData != null ? mainOperateData.getItems() : null;
            if (items == null || items.isEmpty()) {
                U1();
            }
            TrendingAdapter trendingAdapter3 = this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter3 = null;
            }
            if (trendingAdapter3.Q().q()) {
                TrendingAdapter trendingAdapter4 = this.f52566l;
                if (trendingAdapter4 == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter4 = null;
                }
                trendingAdapter4.Q().u();
                zp.b.f82110a.e(baseDto != null ? baseDto.getMsg() : null);
                return;
            }
            return;
        }
        TrendingRespData data = baseDto.getData();
        if (data != null) {
            z1();
            List<TrendingRespItem> items2 = data.getItems();
            uo.b.a.f(aVar, "TrendingFragment", "updateTrendingList subjectBean " + (items2 != null ? Integer.valueOf(items2.size()) : null), false, 4, null);
            Pager pager = data.getPager();
            this.f52564j = (pager == null || (perPage = pager.getPerPage()) == null) ? this.f52564j : perPage.intValue();
            Pager pager2 = data.getPager();
            if (pager2 == null || (nextPage = pager2.getNextPage()) == null) {
                nextPage = "1";
            }
            this.f52563i = nextPage;
            List<TrendingRespItem> items3 = data.getItems();
            if (z11 && (list2 = items3) != null && !list2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<TrendingRespItem> it = items3.iterator();
                while (it.hasNext()) {
                    e1(arrayList, it.next());
                }
                TrendingAdapter trendingAdapter5 = this.f52566l;
                if (trendingAdapter5 == null) {
                    Intrinsics.y("mAdapter");
                } else {
                    trendingAdapter2 = trendingAdapter5;
                }
                trendingAdapter2.w0(arrayList);
                return;
            }
            TrendingAdapter trendingAdapter6 = this.f52566l;
            if (trendingAdapter6 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter = trendingAdapter6;
            }
            if (trendingAdapter.D().size() == 0 && ((list = items3) == null || list.isEmpty())) {
                T1();
            } else {
                if (items3 == null) {
                    this.f52569o.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.g0
                        @Override // java.lang.Runnable
                        public final void run() {
                            TrendingFragment.Y1(this.f52605a);
                        }
                    }, 200L);
                    return;
                }
                final List<OperateItem> listP1 = P1(items3);
                PreloadHelperKt.a(getContext(), listP1);
                this.f52569o.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrendingFragment.Z1(this.f52607a, listP1);
                    }
                }, 200L);
            }
        }
    }

    public final void e1(List<OperateItem> list, TrendingRespItem trendingRespItem) {
        OperateItem playlist;
        Integer type = trendingRespItem.getType();
        int value = TrendingRespItemType.SUBJECT.getValue();
        if (type == null || type.intValue() != value || trendingRespItem.getSubject() == null) {
            Integer type2 = trendingRespItem.getType();
            int value2 = TrendingRespItemType.PLAY_LIST.getValue();
            if (type2 != null && type2.intValue() == value2 && trendingRespItem.getPlaylist() != null) {
                TrendingAdapter trendingAdapter = this.f52566l;
                if (trendingAdapter == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter = null;
                }
                if (trendingAdapter.Z0() || (playlist = trendingRespItem.getPlaylist()) == null) {
                    return;
                }
                playlist.setType(PostItemType.PLAY_LIST.getValue());
                list.add(playlist);
            }
        } else {
            list.add(new OperateItem(null, PostItemType.SUBJECT.getValue(), null, null, null, null, null, null, null, trendingRespItem.getSubject(), null, null, null, null, null, null, null, null, null, null, null, 2096637, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f1() {
        RecyclerView recyclerView;
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar == null || (recyclerView = sVar.f70507d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b());
    }

    public final void g1() {
        PreloadTrendingData.f52790o.a().A().j(this, new i(new TrendingFragment$checkGamesList$1(this)));
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void h0() {
        String version;
        super.h0();
        this.f52563i = "1";
        Context context = getContext();
        if (context != null) {
            PreloadTrendingData preloadTrendingDataA = PreloadTrendingData.f52790o.a();
            MainOperateData mainOperateData = this.f52571q;
            if (mainOperateData == null || (version = mainOperateData.getVersion()) == null) {
                version = "";
            }
            if (!preloadTrendingDataA.P(context, version)) {
                z1();
            }
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_home_show_honor_v2", true);
            if (Intrinsics.b(configBeanB != null ? configBeanB.getValue() : null, "true")) {
                TrendingViewModel trendingViewModel = this.f52565k;
                if (trendingViewModel != null) {
                    trendingViewModel.J();
                }
                TrendingViewModel trendingViewModel2 = this.f52565k;
                if (trendingViewModel2 != null) {
                    trendingViewModel2.I();
                }
            }
        }
    }

    public final void h1() {
        HashMap<String, String> mapG;
        uo.b.a aVar = uo.b.f78622a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("operating livedata setObserve: ");
        final boolean z11 = true;
        sb2.append(true);
        aVar.c("PreloadTrending", sb2.toString(), true);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put("useCacheRender", String.valueOf(true));
        }
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$checkPreloadOperatingList$startRender$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z12) {
                RecyclerView recyclerView;
                lt.s sVar;
                RecyclerView recyclerView2;
                Integer groupPos;
                TrendingViewModel trendingViewModel;
                com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.j(true);
                }
                MainOperateData mainOperateData = this.this$0.f52571q;
                if (mainOperateData != null && (groupPos = mainOperateData.getGroupPos()) != null && groupPos.intValue() > 0 && (trendingViewModel = this.this$0.f52565k) != null) {
                    trendingViewModel.H(z12);
                }
                ArrayList arrayList = new ArrayList();
                this.this$0.v1(arrayList);
                MainOperateData mainOperateData2 = this.this$0.f52571q;
                TrendingAdapter trendingAdapter = null;
                HomeUtilsKt.a(arrayList, mainOperateData2 != null ? mainOperateData2.getOps() : null);
                TrendingAdapter trendingAdapter2 = this.this$0.f52566l;
                if (trendingAdapter2 == null) {
                    Intrinsics.y("mAdapter");
                } else {
                    trendingAdapter = trendingAdapter2;
                }
                trendingAdapter.w0(arrayList);
                uo.b.a.f(uo.b.f78622a, "lgx", "hide1 fragment:" + this.this$0, false, 4, null);
                this.this$0.z1();
                this.this$0.j1();
                lt.s sVar2 = (lt.s) this.this$0.getMViewBinding();
                if (sVar2 != null && (recyclerView = sVar2.f70507d) != null && recyclerView.computeVerticalScrollOffset() > 10 && (sVar = (lt.s) this.this$0.getMViewBinding()) != null && (recyclerView2 = sVar.f70507d) != null) {
                    recyclerView2.scrollBy(0, 1);
                }
                if (z12) {
                    return;
                }
                PreloadHelperKt.d(this.this$0.getContext(), arrayList);
            }
        };
        PreloadTrendingData.a aVar2 = PreloadTrendingData.f52790o;
        uo.b.a.f(aVar, "lgx", "preObserve fragment:" + this + " " + aVar2.a().F() + "  " + aVar2.a().G(), false, 4, null);
        aVar2.a().F().j(this, new i(new Function1<MainOperateData, Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$checkPreloadOperatingList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MainOperateData mainOperateData) {
                invoke2(mainOperateData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MainOperateData mainOperateData) {
                HashMap<String, String> mapG2;
                List<OperateItem> items;
                uo.b.a.f(uo.b.f78622a, "lgx", "observe1 fragment:" + this.this$0, false, 4, null);
                com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                if (logViewConfig2 != null && (mapG2 = logViewConfig2.g()) != null) {
                    mapG2.put("enterCache", String.valueOf((mainOperateData == null || (items = mainOperateData.getItems()) == null) ? null : Integer.valueOf(items.size())));
                }
                if (z11) {
                    TrendingAdapter trendingAdapter = this.this$0.f52566l;
                    if (trendingAdapter == null) {
                        Intrinsics.y("mAdapter");
                        trendingAdapter = null;
                    }
                    if (trendingAdapter.D().size() == 0) {
                        List<OperateItem> items2 = mainOperateData != null ? mainOperateData.getItems() : null;
                        if (items2 == null || items2.isEmpty()) {
                            return;
                        }
                        this.this$0.f52571q = mainOperateData;
                        function1.invoke(Boolean.TRUE);
                    }
                }
            }
        }));
        aVar2.a().G().j(this, new i(new Function1<MainOperateData, Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$checkPreloadOperatingList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MainOperateData mainOperateData) {
                invoke2(mainOperateData);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MainOperateData mainOperateData) {
                List<OperateItem> items;
                lt.s sVar;
                SwipeRefreshLayout swipeRefreshLayout;
                HashMap<String, String> mapG2;
                List<OperateItem> items2;
                List<OperateItem> items3;
                List<OperateItem> items4;
                List<OperateItem> items5;
                uo.b.a aVar3 = uo.b.f78622a;
                uo.b.a.f(aVar3, "lgx", "observe2 fragment:" + this.this$0, false, 4, null);
                MainOperateData mainOperateDataF = PreloadTrendingData.f52790o.a().F().f();
                aVar3.c("PreloadTrending", "operating preload cache " + ((mainOperateDataF == null || (items5 = mainOperateDataF.getItems()) == null) ? null : Integer.valueOf(items5.size())) + "  net:" + ((mainOperateData == null || (items4 = mainOperateData.getItems()) == null) ? null : Integer.valueOf(items4.size())), true);
                com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                if (logViewConfig2 != null && (mapG2 = logViewConfig2.g()) != null) {
                    mapG2.put("enterNet", "cache:" + ((mainOperateDataF == null || (items3 = mainOperateDataF.getItems()) == null) ? null : Integer.valueOf(items3.size())) + " net:" + ((mainOperateData == null || (items2 = mainOperateData.getItems()) == null) ? null : Integer.valueOf(items2.size())));
                }
                List<OperateItem> items6 = mainOperateData != null ? mainOperateData.getItems() : null;
                if (items6 != null && !items6.isEmpty()) {
                    this.this$0.f52571q = mainOperateData;
                } else if (this.this$0.f52571q == null) {
                    this.this$0.f52571q = mainOperateDataF;
                }
                if (z11) {
                    TrendingAdapter trendingAdapter = this.this$0.f52566l;
                    if (trendingAdapter == null) {
                        Intrinsics.y("mAdapter");
                        trendingAdapter = null;
                    }
                    if (trendingAdapter.D().size() > 0 && ((sVar = (lt.s) this.this$0.getMViewBinding()) == null || (swipeRefreshLayout = sVar.f70508f) == null || !swipeRefreshLayout.isRefreshing())) {
                        List<OperateItem> items7 = mainOperateData != null ? mainOperateData.getItems() : null;
                        if (items7 == null || items7.isEmpty()) {
                            return;
                        }
                    }
                }
                MainOperateData mainOperateData2 = this.this$0.f52571q;
                if (mainOperateData2 != null && (items = mainOperateData2.getItems()) != null && (!items.isEmpty())) {
                    function1.invoke(Boolean.FALSE);
                } else {
                    this.this$0.K1();
                    this.this$0.j1();
                }
            }
        }));
    }

    public final void i1() {
        nt.b bVar = this.f52562h;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        View view2;
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        FrameLayout root;
        Intrinsics.g(view, "view");
        super.initView(view, bundle);
        TrendingViewModel trendingViewModel = this.f52565k;
        if (trendingViewModel != null) {
            trendingViewModel.B(getPageName());
        }
        B1();
        initViewModel();
        setNetListener(new f());
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar != null && (root = sVar.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.transsion.home.fragment.tab.b0
                @Override // java.lang.Runnable
                public final void run() {
                    TrendingFragment.G1(this.f52591a);
                }
            });
        }
        lt.s sVar2 = (lt.s) getMViewBinding();
        if (sVar2 != null && (recyclerView = sVar2.f70507d) != null && (viewTreeObserver = recyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnPreDrawListener(new g());
        }
        this.f52576v = registerForActivityResult(new c1.h(), new h());
        f1();
        this.f52570p = n0();
        lt.s sVar3 = (lt.s) getMViewBinding();
        TrendingAdapter trendingAdapter = null;
        ViewGroup.LayoutParams layoutParams = (sVar3 == null || (view2 = sVar3.f70509g) == null) ? null : view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f52570p;
        }
        if (bundle == null || !bundle.getBoolean("operate_items", false)) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "lgx", "get save instance", false, 4, null);
        List<OperateItem> listH = PreloadTrendingData.f52790o.a().H();
        TrendingAdapter trendingAdapter2 = this.f52566l;
        if (trendingAdapter2 == null) {
            Intrinsics.y("mAdapter");
        } else {
            trendingAdapter = trendingAdapter2;
        }
        trendingAdapter.w0(listH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView l0() {
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar != null) {
            return sVar.f70507d;
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        List<OperateItem> items;
        MainOperateData mainOperateData = this.f52571q;
        if (mainOperateData == null || (items = mainOperateData.getItems()) == null || !(!items.isEmpty())) {
            uo.b.a aVar = uo.b.f78622a;
            boolean z11 = this.f52571q == null;
            TrendingAdapter trendingAdapter = this.f52566l;
            if (trendingAdapter == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter = null;
            }
            aVar.c("PreloadTrending", "lazyLoadData " + z11 + " " + trendingAdapter.D().size(), true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load1 fragment:");
            sb2.append(this);
            uo.b.a.f(aVar, "lgx", sb2.toString(), false, 4, null);
            J1(this, false, 1, null);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        IFissionProvider iFissionProviderN1 = n1();
        if (iFissionProviderN1 != null) {
            IFissionProvider.a.a(iFissionProviderN1, false, 1, null);
        }
        IFissionProvider iFissionProviderN2 = n1();
        if (iFissionProviderN2 != null) {
            iFissionProviderN2.l0(false);
        }
        RequestConfig.f53099a.f();
    }

    public final View m1(Context context) {
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(context);
        this.f52578x = noNetworkBigView;
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
        noNetworkBigView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$getErrorView$1$1
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
                TrendingFragment.J1(this.this$0, false, 1, null);
                com.tn.lib.view.l.b(this.this$0.getPageName());
            }
        });
        noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.TrendingFragment$getErrorView$1$2
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
        return noNetworkBigView;
    }

    public final IFissionProvider n1() {
        return (IFissionProvider) this.f52573s.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        TrendingAdapter trendingAdapter = this.f52566l;
        TrendingAdapter trendingAdapter2 = null;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        if (trendingAdapter.Z0()) {
            TrendingAdapter trendingAdapter3 = this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter3;
            }
            trendingAdapter2.notifyDataSetChanged();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            mapG.put("onCreate", "true");
        }
        AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.TRENDING_CREATE, 0L, 2, null));
        super.onCreate(bundle);
        this.f52565k = (TrendingViewModel) new v0(this).a(TrendingViewModel.class);
        BannerADDataHelper.f(BannerADDataHelper.f52219a, null, 1, null);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f52569o.removeCallbacksAndMessages(null);
        pr.a.f74040a.a();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b1.b<Intent> bVar = this.f52568n;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
                i1();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        i1();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        HashMap<String, String> mapG;
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        if (trendingAdapter.D().size() > 0 && !isFirst()) {
            TrendingAdapter trendingAdapter2 = this.f52566l;
            if (trendingAdapter2 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter2 = null;
            }
            if (Intrinsics.b(trendingAdapter2.getItem(0).getType(), PostItemType.HONOR.getValue())) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrendingFragment.L1(this.f52633a);
                    }
                }, 1000L);
            }
        }
        super.onResume();
        uo.b.a aVar = uo.b.f78622a;
        View view = this.f52578x;
        uo.b.a.f(aVar, "TrendingFragment", "visible = " + (view != null ? Integer.valueOf(view.getVisibility()) : null) + "  " + this, false, 4, null);
        View view2 = this.f52578x;
        if (view2 != null && view2.getVisibility() == 0 && com.tn.lib.util.networkinfo.f.f49475a.e()) {
            TrendingAdapter trendingAdapter3 = this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter3 = null;
            }
            if (trendingAdapter3.D().size() < 2) {
                J1(this, false, 1, null);
            }
        }
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("scrollPosition", "0");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        TrendingAdapter trendingAdapter = this.f52566l;
        TrendingAdapter trendingAdapter2 = null;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        if (trendingAdapter.D().size() > 0) {
            PreloadTrendingData preloadTrendingDataA = PreloadTrendingData.f52790o.a();
            TrendingAdapter trendingAdapter3 = this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter3;
            }
            preloadTrendingDataA.S(trendingAdapter2.D());
            outState.putBoolean("operate_items", true);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.TRENDING_RENDER, 0L, 2, null));
    }

    public final int p1(List<OperateItem> list) {
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            OperateItem operateItem = (OperateItem) obj;
            if (Intrinsics.b(operateItem.getType(), PostItemType.BANNER.getValue()) || Intrinsics.b(operateItem.getType(), PostItemType.HONOR.getValue())) {
                return i12;
            }
            i11 = i12;
        }
        return 0;
    }

    public final int q1() {
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        int i11 = 0;
        for (Object obj : trendingAdapter.D()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            if (Intrinsics.b(((OperateItem) obj).getType(), PostItemType.NO_NETWORK.getValue())) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0089  */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void s0(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
        String value;
        Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager != null) {
            OperateItem operateItem = new OperateItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
            operateItem.setNonAdDelegate(wrapperNativeManager);
            TrendingAdapter trendingAdapter = this.f52566l;
            TrendingAdapter trendingAdapter2 = null;
            if (trendingAdapter == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter = null;
            }
            int size = trendingAdapter.D().size();
            TrendingAdapter trendingAdapter3 = this.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter3 = null;
            }
            if (!trendingAdapter3.Z0()) {
                value = PostItemType.TRENDING_NATIVE_AD.getValue();
            } else if (1 > i11 || i11 >= size) {
                value = PostItemType.SUBJECT.getValue();
            } else {
                TrendingAdapter trendingAdapter4 = this.f52566l;
                if (trendingAdapter4 == null) {
                    Intrinsics.y("mAdapter");
                    trendingAdapter4 = null;
                }
                if (Intrinsics.b(trendingAdapter4.D().get(i11).getType(), PostItemType.SUBJECT.getValue())) {
                    value = PostItemType.SUBJECT.getValue();
                } else {
                    value = PostItemType.TRENDING_NATIVE_AD.getValue();
                }
            }
            operateItem.setType(value);
            if (Intrinsics.b(operateItem.getType(), PostItemType.SUBJECT.getValue())) {
                return;
            }
            if (i11 < 0 || i11 > size) {
                TrendingAdapter trendingAdapter5 = this.f52566l;
                if (trendingAdapter5 == null) {
                    Intrinsics.y("mAdapter");
                } else {
                    trendingAdapter2 = trendingAdapter5;
                }
                trendingAdapter2.l(operateItem);
                return;
            }
            TrendingAdapter trendingAdapter6 = this.f52566l;
            if (trendingAdapter6 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter6;
            }
            trendingAdapter2.j(i11, operateItem);
        }
    }

    public final nt.c t1() {
        return this.f52567m;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
    public lt.s getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        KeyEventDispatcher.Component activity = getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.home.preload.MainXMLPreload");
        com.transsion.home.preload.b bVarR = ((com.transsion.home.preload.a) activity).r();
        Boolean boolValueOf = bVarR != null ? Boolean.valueOf(bVarR.f()) : null;
        View viewG = bVarR != null ? bVarR.g() : null;
        if (viewG == null || !Intrinsics.b(boolValueOf, Boolean.FALSE)) {
            lt.s sVarC = lt.s.c(inflater);
            Intrinsics.f(sVarC, "inflate(inflater)");
            return sVarC;
        }
        uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "postlist root ", false, 4, null);
        lt.s sVarA = lt.s.a(viewG);
        Intrinsics.f(sVarA, "bind(rootView)");
        return sVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void v0() {
        RecyclerView recyclerView;
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar == null || (recyclerView = sVar.f70507d) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    public final void v1(List<OperateItem> list) {
        Integer groupPos;
        Integer groupPos2;
        int iP1;
        HashMap<String, String> mapG;
        List<OperateItem> items;
        List<OperateItem> listE0;
        ArrayList arrayList;
        List<AppointSubject> subjects;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_home_show_honor_v2", true);
        boolean zB = Intrinsics.b(configBeanB != null ? configBeanB.getValue() : null, "true");
        if (zB && list.size() == 0) {
            list.add(new OperateItem(null, PostItemType.HONOR.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null));
        }
        MainOperateData mainOperateData = this.f52571q;
        if (mainOperateData != null && (items = mainOperateData.getItems()) != null && (listE0 = CollectionsKt___CollectionsKt.E0(items, new Comparator() { // from class: com.transsion.home.fragment.tab.TrendingFragment$handleOpList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.b.d(((OperateItem) t11).getPosition(), ((OperateItem) t12).getPosition());
            }
        })) != null) {
            for (OperateItem operateItem : listE0) {
                String type = operateItem.getType();
                operateItem.setPageName(getPageName());
                if (Intrinsics.b(type, PostItemType.BANNER.getValue())) {
                    BannerBean banner = operateItem.getBanner();
                    List<BannerData> banners = banner != null ? banner.getBanners() : null;
                    if (banners != null && !banners.isEmpty() && !zB) {
                        BannerBean banner2 = operateItem.getBanner();
                        if (banner2 != null) {
                            banner2.setBanners(w1(operateItem));
                        }
                    }
                }
                if (!Intrinsics.b(type, PostItemType.PLAY_LIST.getValue()) || ((subjects = operateItem.getSubjects()) != null && subjects.size() >= 3)) {
                    if (Intrinsics.b(type, PostItemType.SPORT_LIVE.getValue())) {
                        List<LiveListItem> liveList = operateItem.getLiveList();
                        if (liveList != null) {
                            arrayList = new ArrayList();
                            for (Object obj : liveList) {
                                if (!Intrinsics.b(((LiveListItem) obj).getStatus(), "MatchEnded")) {
                                    arrayList.add(obj);
                                }
                            }
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null || arrayList.isEmpty()) {
                        }
                    }
                    TrendingAdapter trendingAdapter = this.f52566l;
                    if (trendingAdapter == null) {
                        Intrinsics.y("mAdapter");
                        trendingAdapter = null;
                    }
                    Set<String> setKeySet = trendingAdapter.Y0().keySet();
                    Intrinsics.f(setKeySet, "mAdapter.supportProviders.keys");
                    if (CollectionsKt___CollectionsKt.X(setKeySet, type)) {
                        List<AppointSubject> subjects2 = operateItem.getSubjects();
                        if (subjects2 != null) {
                            int size = subjects2.size();
                            if (!Intrinsics.b(type, PostItemType.OP_SUBJECTS_MOVIE.getValue()) || size >= 3) {
                            }
                        }
                        list.add(operateItem);
                    }
                }
            }
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            MainOperateData mainOperateData2 = this.f52571q;
            mapG.put("fill_opt_type", mainOperateData2 != null ? mainOperateData2.getSourceFrom() : null);
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e() && (iP1 = p1(list)) >= 0 && iP1 < list.size()) {
            list.add(iP1, new OperateItem(null, PostItemType.NO_NETWORK.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null));
        }
        list.add(new OperateItem(getString(com.transsion.postdetail.R$string.short_tv_most_trending), PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097148, null));
        MainOperateData mainOperateData3 = this.f52571q;
        if (mainOperateData3 == null || (groupPos = mainOperateData3.getGroupPos()) == null || groupPos.intValue() <= 0) {
            return;
        }
        MainOperateData mainOperateData4 = this.f52571q;
        int iIntValue = (mainOperateData4 == null || (groupPos2 = mainOperateData4.getGroupPos()) == null) ? 0 : groupPos2.intValue();
        if (iIntValue >= list.size()) {
            list.add(new OperateItem(null, PostItemType.ROOM.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null));
        } else {
            list.add(iIntValue, new OperateItem(null, PostItemType.ROOM.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null));
        }
    }

    public final List<BannerData> w1(OperateItem operateItem) {
        List<BannerData> banners;
        BannerBean banner = operateItem.getBanner();
        if (banner != null) {
            banner.setRefreshAd(true);
        }
        BannerBean banner2 = operateItem.getBanner();
        if (banner2 == null || (banners = banner2.getBanners()) == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.M0(banners);
    }

    public final boolean x1() {
        TrendingAdapter trendingAdapter = this.f52566l;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        Iterator<T> it = trendingAdapter.D().iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(((OperateItem) it.next()).getType(), PostItemType.NO_NETWORK.getValue())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        SwipeRefreshLayout swipeRefreshLayout;
        lt.b0 b0Var;
        ConstraintLayout constraintLayout;
        lt.s sVar = (lt.s) getMViewBinding();
        if (sVar != null && (b0Var = sVar.f70506c) != null && (constraintLayout = b0Var.f70397i) != null) {
            so.c.g(constraintLayout);
        }
        lt.s sVar2 = (lt.s) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout2 = sVar2 != null ? sVar2.f70508f : null;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setEnabled(true);
        }
        lt.s sVar3 = (lt.s) getMViewBinding();
        if (sVar3 == null || (swipeRefreshLayout = sVar3.f70508f) == null || !swipeRefreshLayout.isRefreshing()) {
            return;
        }
        lt.s sVar4 = (lt.s) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout3 = sVar4 != null ? sVar4.f70508f : null;
        if (swipeRefreshLayout3 == null) {
            return;
        }
        swipeRefreshLayout3.setRefreshing(false);
    }
}
