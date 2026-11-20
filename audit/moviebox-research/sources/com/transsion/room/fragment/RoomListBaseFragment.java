package com.transsion.room.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.publish.api.GroupBean;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.RoomListAdapter;
import com.transsion.room.adapter.RoomListFrom;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
public abstract class RoomListBaseFragment extends LazyFragment<sw.m> {
    public final b1.b<Intent> A;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RoomListAdapter f57204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public zr.b f57205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RoomViewModel f57206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RoomDetailViewModel f57207r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f57208s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f57209t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f57210u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f57212w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RoomJoinAnimationView f57213x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f57214y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f57211v = 12;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f57215z = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.room.fragment.RoomListBaseFragment$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements zr.a {
        public a() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            RoomItem item;
            RoomListBaseFragment roomListBaseFragment = RoomListBaseFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                RoomListAdapter roomListAdapterD1 = roomListBaseFragment.d1();
                if (roomListAdapterD1 != null && (item = roomListAdapterD1.getItem(i11)) != null) {
                    com.transsion.room.helper.k.f57301a.g(roomListBaseFragment.f57209t, roomListBaseFragment.v1(), i11, j11, item);
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends DiffUtil.e<RoomItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(RoomItem oldItem, RoomItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getGroupId(), newItem.getGroupId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(RoomItem oldItem, RoomItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getGroupId(), newItem.getGroupId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57217a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57217a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57217a;
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
            this.f57217a.invoke(obj);
        }
    }

    public RoomListBaseFragment() {
        b1.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.room.fragment.h0
            @Override // b1.a
            public final void a(Object obj) {
                RoomListBaseFragment.s1(this.f57253a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…on = null\n        }\n    }");
        this.A = bVarRegisterForActivityResult;
    }

    private final boolean checkLogin() {
        if (e1().N()) {
            return true;
        }
        b1.b<Intent> bVar = this.A;
        Context context = getContext();
        bVar.a(context != null ? e1().o1(context) : null);
        return false;
    }

    private final ILoginApi e1() {
        return (ILoginApi) this.f57215z.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k1() {
        RecyclerView recyclerView;
        zr.b bVar = new zr.b(0.6f, new a(), false, 4, null);
        bVar.n(2);
        sw.m mVar = (sw.m) getMViewBinding();
        if (mVar != null && (recyclerView = mVar.f76559b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.f57205p = bVar;
    }

    public static final void l1(RoomListBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.c1();
    }

    public static final void m1(RoomListBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.q1(false);
    }

    public static final void n1(RoomListBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        if (Intrinsics.b(roomItem.getHasJoin(), Boolean.TRUE)) {
            this$0.u1(roomItem, i11);
            return;
        }
        this$0.f57212w = Integer.valueOf(i11);
        this$0.f57213x = (RoomJoinAnimationView) view;
        this$0.p1();
    }

    public static final void o1(RoomListBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Object item = adapter.getItem(i11);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        if (this$0.f57208s) {
            this$0.t1(roomItem);
        } else {
            this$0.u1(roomItem, i11);
        }
    }

    private final void p1() {
        Integer num;
        RoomItem item;
        String groupId;
        RoomJoinAnimationView roomJoinAnimationView = this.f57213x;
        if ((roomJoinAnimationView == null || !roomJoinAnimationView.isLoading()) && checkLogin() && (num = this.f57212w) != null) {
            Intrinsics.d(num);
            if (num.intValue() < 0) {
                return;
            }
            RoomListAdapter roomListAdapter = this.f57204o;
            if (roomListAdapter != null) {
                Integer num2 = this.f57212w;
                Intrinsics.d(num2);
                item = roomListAdapter.getItem(num2.intValue());
            } else {
                item = null;
            }
            if (com.transsion.baseui.util.c.f51452a.a(1001, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                return;
            }
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(R$string.no_network_toast);
                return;
            }
            if (item == null || (groupId = item.getGroupId()) == null) {
                return;
            }
            RoomJoinAnimationView roomJoinAnimationView2 = this.f57213x;
            if (roomJoinAnimationView2 != null) {
                roomJoinAnimationView2.setStatus(RoomJoinStatus.LOADING);
            }
            RoomDetailViewModel roomDetailViewModel = this.f57207r;
            if (roomDetailViewModel != null) {
                roomDetailViewModel.r(groupId);
            }
            com.transsion.baselib.helper.a.f51183a.g(v1(), "join", (28 & 4) != 0 ? "" : groupId, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
        }
    }

    public static /* synthetic */ void r1(RoomListBaseFragment roomListBaseFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        roomListBaseFragment.q1(z11);
    }

    public static final void s1(RoomListBaseFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.p1();
            return;
        }
        RoomJoinAnimationView roomJoinAnimationView = this$0.f57213x;
        if (roomJoinAnimationView != null) {
            roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
        }
        this$0.f57213x = null;
        this$0.f57212w = null;
    }

    private final void u1(RoomItem roomItem, int i11) {
        if (roomItem != null) {
            com.transsion.room.helper.k.f57301a.h(this.f57209t, v1(), i11, roomItem);
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withParcelable(WebConstants.FIELD_ITEM, roomItem).withString("id", roomItem != null ? roomItem.getGroupId() : null).navigation();
        b1(roomItem, i11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        K0();
        r1(this, false, 1, null);
    }

    public void a1() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            RoomListAdapter roomListAdapter = this.f57204o;
            if (roomListAdapter != null) {
                roomListAdapter.r0(l0(false));
                return;
            }
            return;
        }
        RoomListAdapter roomListAdapter2 = this.f57204o;
        if (roomListAdapter2 != null) {
            roomListAdapter2.r0(r0(false));
        }
    }

    public final void b1(RoomItem roomItem, int i11) {
        if (roomItem != null) {
            roomItem.setNewPostCount(0L);
        }
        RoomListAdapter roomListAdapter = this.f57204o;
        if (roomListAdapter != null) {
            roomListAdapter.notifyItemChanged(i11, 0L);
        }
    }

    public void c1() {
        this.f57210u = null;
        r1(this, false, 1, null);
    }

    public final RoomListAdapter d1() {
        return this.f57204o;
    }

    public final String f1() {
        return this.f57210u;
    }

    public final int g1() {
        return this.f57211v;
    }

    public final RoomViewModel h1() {
        return this.f57206q;
    }

    public abstract RoomListFrom i1();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        RoomListAdapter roomListAdapter;
        LiveData<RoomNet> liveDataN;
        RoomDetailViewModel roomDetailViewModel = this.f57207r;
        if (roomDetailViewModel != null && (liveDataN = roomDetailViewModel.n()) != null) {
            liveDataN.j(this, new c(new Function1<RoomNet, Unit>() { // from class: com.transsion.room.fragment.RoomListBaseFragment.initViewModel.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                    invoke2(roomNet);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RoomNet roomNet) {
                    if (roomNet == null) {
                        RoomJoinAnimationView roomJoinAnimationView = RoomListBaseFragment.this.f57213x;
                        if (roomJoinAnimationView != null) {
                            roomJoinAnimationView.setStatus(RoomJoinStatus.JOIN);
                        }
                    } else {
                        RoomJoinAnimationView roomJoinAnimationView2 = RoomListBaseFragment.this.f57213x;
                        if (roomJoinAnimationView2 != null) {
                            roomJoinAnimationView2.setStatus(RoomJoinStatus.JOINED);
                        }
                    }
                    RoomListBaseFragment.this.f57213x = null;
                    RoomListBaseFragment.this.f57212w = null;
                }
            }));
        }
        if (com.tn.lib.util.networkinfo.f.f49475a.e() || (roomListAdapter = this.f57204o) == null) {
            return;
        }
        roomListAdapter.r0(r0(false));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public sw.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.m mVarC = sw.m.c(inflater);
        Intrinsics.f(mVarC, "inflate(inflater)");
        return mVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(com.transsion.usercenter.R$string.profile_not_content);
        Intrinsics.f(string, "getString(com.transsion.…ring.profile_not_content)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        K0();
        r1(this, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f57208s = arguments != null ? arguments.getBoolean("is_select_room") : false;
        this.f57206q = (RoomViewModel) new v0(this).a(RoomViewModel.class);
        this.f57207r = (RoomDetailViewModel) new v0(this).a(RoomDetailViewModel.class);
        this.f57209t = com.transsion.baselib.report.m.f51277a.f();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        if (this.f57214y == null) {
            this.f57214y = LayoutInflater.from(requireContext()).inflate(R$layout.layout_room_list_loading, (ViewGroup) o0(), false);
        }
        return this.f57214y;
    }

    public abstract void q1(boolean z11);

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void t1(RoomItem roomItem) {
        uo.b.a.f(uo.b.f78622a, "RoomList", "onSelectRoom, name:" + roomItem.getName() + ",id:" + roomItem.getGroupId(), false, 4, null);
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupId(roomItem.getGroupId());
        groupBean.setName(roomItem.getName());
        groupBean.setDes(roomItem.getDescription());
        groupBean.setDescription(roomItem.getDescription());
        groupBean.setPostCount(String.valueOf(roomItem.getPostCount()));
        groupBean.setAvatar(roomItem.getAvatar());
        groupBean.setNewPostCount(String.valueOf(roomItem.getNewPostCount()));
        groupBean.setOps(roomItem.getOps());
        cw.a aVar = new cw.a();
        aVar.o(6);
        aVar.n(1);
        aVar.m(groupBean);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        k1();
        sw.m mVar = (sw.m) getMViewBinding();
        if (mVar != null && (swipeRefreshLayout = mVar.f76560c) != null) {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.bg_01));
            swipeRefreshLayout.setColorSchemeColors(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_center), z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_start));
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.d0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    RoomListBaseFragment.l1(this.f57245a);
                }
            });
        }
        RoomListAdapter roomListAdapter = new RoomListAdapter(i1(), this.f57208s);
        roomListAdapter.Q().y(true);
        roomListAdapter.Q().x(true);
        roomListAdapter.Q().D(3);
        roomListAdapter.Q().C(new f9.f() { // from class: com.transsion.room.fragment.e0
            @Override // f9.f
            public final void a() {
                RoomListBaseFragment.m1(this.f57247a);
            }
        });
        roomListAdapter.o0(new b());
        roomListAdapter.i(R$id.v_join);
        roomListAdapter.z0(new f9.b() { // from class: com.transsion.room.fragment.f0
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomListBaseFragment.n1(this.f57249a, baseQuickAdapter, view, i11);
            }
        });
        roomListAdapter.B0(new f9.d() { // from class: com.transsion.room.fragment.g0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomListBaseFragment.o1(this.f57251a, baseQuickAdapter, view, i11);
            }
        });
        this.f57204o = roomListAdapter;
        sw.m mVar2 = (sw.m) getMViewBinding();
        if (mVar2 == null || (recyclerView = mVar2.f76559b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f57204o);
    }

    public abstract String v1();

    /* JADX WARN: Multi-variable type inference failed */
    public void w1(RoomBean roomBean) {
        List arrayList;
        h9.f fVarQ;
        h9.f fVarQ2;
        Pager pager;
        h9.f fVarQ3;
        List<RoomItem> items;
        h9.f fVarQ4;
        RoomListAdapter roomListAdapter;
        h9.f fVarQ5;
        h9.f fVarQ6;
        RoomListAdapter roomListAdapter2;
        h9.f fVarQ7;
        SwipeRefreshLayout swipeRefreshLayout;
        sw.m mVar = (sw.m) getMViewBinding();
        if (mVar != null && (swipeRefreshLayout = mVar.f76560c) != null && swipeRefreshLayout.isRefreshing()) {
            sw.m mVar2 = (sw.m) getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout2 = mVar2 != null ? mVar2.f76560c : null;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
        }
        F0();
        RoomListAdapter roomListAdapter3 = this.f57204o;
        if (roomListAdapter3 == null || (arrayList = roomListAdapter3.D()) == null) {
            arrayList = new ArrayList();
        }
        if (roomBean == null || (items = roomBean.getItems()) == null || items.isEmpty()) {
            if (arrayList.isEmpty()) {
                a1();
                return;
            }
            RoomListAdapter roomListAdapter4 = this.f57204o;
            if (roomListAdapter4 == null || (fVarQ = roomListAdapter4.Q()) == null || !fVarQ.q()) {
                return;
            }
            if (roomBean == null || (pager = roomBean.getPager()) == null || !Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) {
                RoomListAdapter roomListAdapter5 = this.f57204o;
                if (roomListAdapter5 == null || (fVarQ2 = roomListAdapter5.Q()) == null) {
                    return;
                }
                h9.f.t(fVarQ2, false, 1, null);
                return;
            }
            RoomListAdapter roomListAdapter6 = this.f57204o;
            if (roomListAdapter6 == null || (fVarQ3 = roomListAdapter6.Q()) == null) {
                return;
            }
            fVarQ3.u();
            return;
        }
        Pager pager2 = roomBean.getPager();
        this.f57210u = pager2 != null ? pager2.getNextPage() : null;
        if (roomBean.isRefresh()) {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.j(true);
            }
            RoomListAdapter roomListAdapter7 = this.f57204o;
            if (roomListAdapter7 != null) {
                roomListAdapter7.w0(roomBean.getItems());
            }
        } else {
            List<RoomItem> items2 = roomBean.getItems();
            if (items2 != null) {
                ArrayList arrayList2 = new ArrayList();
                if (!arrayList.isEmpty()) {
                    for (RoomItem roomItem : items2) {
                        if (!arrayList.contains(roomItem)) {
                            arrayList2.add(roomItem);
                        }
                    }
                } else {
                    arrayList2.addAll(items2);
                }
                if (arrayList2.isEmpty()) {
                    RoomListAdapter roomListAdapter8 = this.f57204o;
                    if (roomListAdapter8 != null && (fVarQ4 = roomListAdapter8.Q()) != null) {
                        h9.f.t(fVarQ4, false, 1, null);
                    }
                    if (arrayList.isEmpty()) {
                        a1();
                    }
                } else {
                    RoomListAdapter roomListAdapter9 = this.f57204o;
                    if (roomListAdapter9 != null) {
                        roomListAdapter9.m(arrayList2);
                    }
                }
            }
        }
        RoomListAdapter roomListAdapter10 = this.f57204o;
        if (roomListAdapter10 != null && (fVarQ6 = roomListAdapter10.Q()) != null && fVarQ6.q() && (roomListAdapter2 = this.f57204o) != null && (fVarQ7 = roomListAdapter2.Q()) != null) {
            fVarQ7.r();
        }
        Pager pager3 = roomBean.getPager();
        if ((pager3 != null && Intrinsics.b(pager3.getHasMore(), Boolean.TRUE)) || (roomListAdapter = this.f57204o) == null || (fVarQ5 = roomListAdapter.Q()) == null) {
            return;
        }
        h9.f.t(fVarQ5, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
