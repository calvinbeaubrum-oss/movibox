package com.transsion.room.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.NestedSwipeRefreshLayout;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.publish.api.IPublishApi;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.UploadView;
import com.transsion.room.activity.RoomHomeActivity;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.room.widget.CommunityRoomsView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import net.lucode.hackware.magicindicator.MagicIndicator;

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
public final class RoomHomeFragment extends RoomBaseFragment<sw.l> implements rw.c {
    public static final a C = new a(null);
    public String A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PublishResult f57199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Fragment f57200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Fragment f57201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f57202z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f57197u = FragmentViewModelLazyKt.a(this, Reflection.b(RoomViewModel.class), new Function0<x0>() { // from class: com.transsion.room.fragment.RoomHomeFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomHomeFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<String> f57198v = kotlin.collections.g.o(Utils.a().getString(R$string.explore), Utils.a().getString(R$string.nearby));
    public final Lazy B = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.room.fragment.RoomHomeFragment$mPublishedApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPublishApi invoke() {
            return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomHomeFragment a(String str, String str2) {
            RoomHomeFragment roomHomeFragment = new RoomHomeFragment();
            roomHomeFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("post_id", str), TuplesKt.a("ops", str2)));
            return roomHomeFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57203a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57203a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57203a;
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
            this.f57203a.invoke(obj);
        }
    }

    private final IPublishApi g1() {
        return (IPublishApi) this.B.getValue();
    }

    public static final void j1(RoomHomeFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.p1();
    }

    public static final void k1(final RoomHomeFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.m1();
        aw.a aVar = null;
        if (this$0.V0() == 0) {
            androidx.lifecycle.u uVar = this$0.f57200x;
            if (uVar instanceof aw.a) {
                aVar = (aw.a) uVar;
            }
        } else {
            androidx.lifecycle.u uVar2 = this$0.f57201y;
            if (uVar2 instanceof aw.a) {
                aVar = (aw.a) uVar2;
            }
        }
        if (aVar != null) {
            aVar.g(new Function0<Unit>() { // from class: com.transsion.room.fragment.RoomHomeFragment$initViewData$1$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
                    sw.l lVar = (sw.l) this.this$0.getMViewBinding();
                    if (lVar == null || (nestedSwipeRefreshLayout = lVar.f76554f) == null || !nestedSwipeRefreshLayout.isRefreshing()) {
                        return;
                    }
                    sw.l lVar2 = (sw.l) this.this$0.getMViewBinding();
                    NestedSwipeRefreshLayout nestedSwipeRefreshLayout2 = lVar2 != null ? lVar2.f76554f : null;
                    if (nestedSwipeRefreshLayout2 == null) {
                        return;
                    }
                    nestedSwipeRefreshLayout2.setRefreshing(false);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l1(RoomHomeFragment this$0, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        sw.l lVar = (sw.l) this$0.getMViewBinding();
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout = lVar != null ? lVar.f76554f : null;
        if (nestedSwipeRefreshLayout == null) {
            return;
        }
        nestedSwipeRefreshLayout.setEnabled(i11 >= 0);
    }

    private final void m1() {
        Context context = getContext();
        if (context != null) {
            RoomViewModel.m(h1(), context, null, 0, 6, null);
        }
    }

    private final void n1() {
        Object context = getContext();
        if (context instanceof ComponentActivity) {
            Function1<PublishResult, Unit> function1 = new Function1<PublishResult, Unit>() { // from class: com.transsion.room.fragment.RoomHomeFragment$observer$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PublishResult publishResult) {
                    invoke2(publishResult);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PublishResult it) {
                    Intrinsics.g(it, "it");
                    this.this$0.q1(it);
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishResult.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.observeEvent((androidx.lifecycle.u) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        }
    }

    public static final void r1(RoomHomeFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        this$0.s1(applicationA);
    }

    private final void s1(Context context) {
        UploadView uploadView = new UploadView(context);
        uploadView.setPageName("room_home");
        if (!uploadView.isShow()) {
            uploadView.setVisibility(0);
            uploadView.setAlpha(1.0f);
            Activity activityB = com.blankj.utilcode.util.a.b();
            if (activityB == null || activityB.isFinishing() || activityB.isDestroyed()) {
                activityB = com.blankj.utilcode.util.a.b();
            }
            if (activityB == null || activityB.isFinishing() || activityB.isDestroyed()) {
                return;
            } else {
                uploadView.show(activityB);
            }
        }
        uploadView.showFloatView(this.f57199w);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        m1();
    }

    @Override // rw.c
    public int K() {
        return V0();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public Fragment S0(int i11) {
        if (i11 == 0) {
            Fragment fragmentP0 = U0().P0(this.f57202z, this.A);
            this.f57200x = fragmentP0;
            return fragmentP0;
        }
        Fragment fragmentN1 = U0().n1();
        this.f57201y = fragmentN1;
        return fragmentN1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public MagicIndicator X0() {
        sw.l lVar = (sw.l) getMViewBinding();
        if (lVar != null) {
            return lVar.f76553d;
        }
        return null;
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public List<String> Z0() {
        return this.f57198v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public ViewPager2 a1() {
        sw.l lVar = (sw.l) getMViewBinding();
        if (lVar != null) {
            return lVar.f76557i;
        }
        return null;
    }

    public final RoomViewModel h1() {
        return (RoomViewModel) this.f57197u.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public sw.l getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.l lVarC = sw.l.c(inflater);
        Intrinsics.f(lVarC, "inflate(inflater)");
        return lVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        sw.l lVar = (sw.l) getMViewBinding();
        if (lVar == null || (appCompatImageView = lVar.f76552c) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomHomeFragment.j1(this.f57280a, view);
            }
        });
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        h1().n().j(this, new b(new Function1<RoomBean, Unit>() { // from class: com.transsion.room.fragment.RoomHomeFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomBean roomBean) {
                invoke2(roomBean);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomBean roomBean) {
                sw.l lVar;
                CommunityRoomsView communityRoomsView;
                CommunityRoomsView communityRoomsView2;
                CommunityRoomsView communityRoomsView3;
                CommunityRoomsView communityRoomsView4;
                com.transsion.baselib.report.h logViewConfig = RoomHomeFragment.this.getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(roomBean != null);
                }
                List<RoomItem> items = roomBean != null ? roomBean.getItems() : null;
                if (items == null || items.isEmpty()) {
                    return;
                }
                sw.l lVar2 = (sw.l) RoomHomeFragment.this.getMViewBinding();
                if ((lVar2 == null || (communityRoomsView4 = lVar2.f76556h) == null || communityRoomsView4.getVisibility() != 0) && (lVar = (sw.l) RoomHomeFragment.this.getMViewBinding()) != null && (communityRoomsView = lVar.f76556h) != null) {
                    so.c.k(communityRoomsView);
                }
                sw.l lVar3 = (sw.l) RoomHomeFragment.this.getMViewBinding();
                if (lVar3 != null && (communityRoomsView3 = lVar3.f76556h) != null) {
                    List<RoomItem> items2 = roomBean != null ? roomBean.getItems() : null;
                    Intrinsics.d(items2);
                    communityRoomsView3.setList(items2);
                }
                sw.l lVar4 = (sw.l) RoomHomeFragment.this.getMViewBinding();
                if (lVar4 == null || (communityRoomsView2 = lVar4.f76556h) == null) {
                    return;
                }
                communityRoomsView2.setReportName("room_home", "room_home_community");
            }
        }));
        n1();
        o1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        m1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("room_home", false, 2, null);
    }

    public final void o1() {
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>() { // from class: com.transsion.room.fragment.RoomHomeFragment$observerJoinRoomEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinRoomEvent joinRoomEvent) {
                invoke2(joinRoomEvent);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinRoomEvent value) {
                CommunityRoomsView communityRoomsView;
                List<RoomItem> dataList;
                Object next;
                RoomHomeFragment roomHomeFragment;
                Context it1;
                Intrinsics.g(value, "value");
                if (value.getJoin()) {
                    Context context = this.this$0.getContext();
                    if (context != null) {
                        RoomViewModel.m(this.this$0.h1(), context, null, 0, 6, null);
                        return;
                    }
                    return;
                }
                sw.l lVar = (sw.l) this.this$0.getMViewBinding();
                if (lVar == null || (communityRoomsView = lVar.f76556h) == null || (dataList = communityRoomsView.getDataList()) == null) {
                    return;
                }
                Iterator<T> it = dataList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((RoomItem) next).getGroupId(), value.getGroupId()));
                if (((RoomItem) next) == null || (it1 = (roomHomeFragment = this.this$0).getContext()) == null) {
                    return;
                }
                RoomViewModel roomViewModelH1 = roomHomeFragment.h1();
                Intrinsics.f(it1, "it1");
                RoomViewModel.m(roomViewModelH1, it1, null, 0, 6, null);
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f57202z = arguments != null ? arguments.getString("post_id") : null;
        Bundle arguments2 = getArguments();
        this.A = arguments2 != null ? arguments2.getString("ops") : null;
        lazyLoadData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public void p1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        g1().K(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q1(PublishResult publishResult) {
        sw.l lVar;
        AppCompatImageView appCompatImageView;
        this.f57199w = publishResult;
        Integer numValueOf = publishResult != null ? Integer.valueOf(publishResult.getState()) : null;
        if (numValueOf == null || numValueOf.intValue() != 0 || (lVar = (sw.l) getMViewBinding()) == null || (appCompatImageView = lVar.f76552c) == null) {
            return;
        }
        appCompatImageView.postDelayed(new Runnable() { // from class: com.transsion.room.fragment.c0
            @Override // java.lang.Runnable
            public final void run() {
                RoomHomeFragment.r1(this.f57243a);
            }
        }, 1500L);
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        AppCompatImageView appCompatImageView;
        AppBarLayout appBarLayout;
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        super.v0();
        sw.l lVar = (sw.l) getMViewBinding();
        if (lVar != null && (nestedSwipeRefreshLayout = lVar.f76554f) != null) {
            nestedSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(z2.a.getColor(nestedSwipeRefreshLayout.getContext(), R$color.bg_01));
            nestedSwipeRefreshLayout.setColorSchemeColors(z2.a.getColor(nestedSwipeRefreshLayout.getContext(), R$color.main_gradient_center), z2.a.getColor(nestedSwipeRefreshLayout.getContext(), R$color.main_gradient_start));
            nestedSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.a0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    RoomHomeFragment.k1(this.f57238a);
                }
            });
        }
        sw.l lVar2 = (sw.l) getMViewBinding();
        if (lVar2 != null && (appBarLayout = lVar2.f76551b) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.b0
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void a(AppBarLayout appBarLayout2, int i11) {
                    RoomHomeFragment.l1(this.f57240a, appBarLayout2, i11);
                }
            });
        }
        sw.l lVar3 = (sw.l) getMViewBinding();
        if (lVar3 == null || (appCompatImageView = lVar3.f76552c) == null || (getActivity() instanceof RoomHomeActivity)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = com.transsion.usercenter.setting.labelsfeedback.a.b(104);
        appCompatImageView.setLayoutParams(marginLayoutParams);
    }
}
