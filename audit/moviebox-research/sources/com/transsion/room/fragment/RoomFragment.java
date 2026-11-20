package com.transsion.room.fragment;

import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.activity.RoomDetailActivity;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

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
public final class RoomFragment extends BaseFragment<sw.h> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f57182j = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.room.adapter.b f57185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomViewModel f57186d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b1.b<Intent> f57190i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f57183a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f57184b = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57187f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f57188g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f57189h = 20;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
            return Intrinsics.b(oldItem.getCreatorId(), newItem.getCreatorId()) && Intrinsics.b(oldItem.getName(), newItem.getName());
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
    public static final class c implements AdvRecyclerView.a {
        public c() {
        }

        @Override // com.tn.lib.view.AdvRecyclerView.a
        public void a() {
            RoomFragment.this.v0();
        }

        @Override // com.tn.lib.view.AdvRecyclerView.a
        public void b() {
            RoomFragment.this.v0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f57192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f57193b;

        public d() {
        }

        private final void d(RecyclerView recyclerView) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                if (this.f57192a == null) {
                    this.f57192a = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                }
                ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(this.f57192a);
                this.f57193b = e(this.f57192a);
                return;
            }
            if (layoutManager instanceof GridLayoutManager) {
                this.f57193b = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else {
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    throw new RuntimeException("Unsupported layoutManager.");
                }
                this.f57193b = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            }
        }

        private final int e(int[] iArr) {
            if (iArr == null) {
                return 0;
            }
            int i11 = 0;
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
            }
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            com.transsion.room.adapter.b bVar;
            h9.f fVarQ;
            h9.f fVarQ2;
            Intrinsics.g(recyclerView, "recyclerView");
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i11 != 0 || childCount <= 0 || this.f57193b < itemCount - 1) {
                return;
            }
            com.transsion.room.adapter.b bVar2 = RoomFragment.this.f57185c;
            if (((bVar2 == null || (fVarQ2 = bVar2.Q()) == null) ? null : fVarQ2.i()) != LoadMoreStatus.Fail || (bVar = RoomFragment.this.f57185c) == null || (fVarQ = bVar.Q()) == null) {
                return;
            }
            fVarQ.v();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            d(recyclerView);
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
            h9.f fVarQ;
            List<RoomItem> listD;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            com.transsion.room.adapter.b bVar = RoomFragment.this.f57185c;
            if (bVar != null && (listD = bVar.D()) != null && listD.isEmpty()) {
                RoomFragment.this.v0();
                return;
            }
            com.transsion.room.adapter.b bVar2 = RoomFragment.this.f57185c;
            if (bVar2 == null || (fVarQ = bVar2.Q()) == null) {
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
    public static final class f implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57196a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57196a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57196a;
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
            this.f57196a.invoke(obj);
        }
    }

    private final void A0() {
        AdvRecyclerView advRecyclerView;
        sw.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f76500b) == null) {
            return;
        }
        advRecyclerView.showEmpty();
    }

    private final void initViewModel() {
        RoomViewModel roomViewModel = (RoomViewModel) new v0(this).a(RoomViewModel.class);
        roomViewModel.p().j(this, new f(new Function1<RoomBean, Unit>() { // from class: com.transsion.room.fragment.RoomFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomBean roomBean) {
                invoke2(roomBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomBean roomBean) {
                h9.f fVarQ;
                this.this$0.hideLoading();
                if (roomBean != null) {
                    this.this$0.B0(roomBean);
                    return;
                }
                com.transsion.room.adapter.b bVar = this.this$0.f57185c;
                if (bVar == null || (fVarQ = bVar.Q()) == null) {
                    return;
                }
                fVarQ.u();
            }
        }));
        this.f57186d = roomViewModel;
    }

    public static final void p0(RoomFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.w0();
    }

    public static final void q0(RoomFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.u0(adapter.getItem(i11), i11);
    }

    public static final void r0(RoomFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.v0();
    }

    public static final void t0(ActivityResult activityResult) {
        activityResult.getResultCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        List<RoomItem> listD;
        SwipeRefreshLayout swipeRefreshLayout;
        this.f57184b = true;
        this.f57188g = "";
        this.f57187f = "";
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            RoomViewModel roomViewModel = this.f57186d;
            if (roomViewModel != null) {
                roomViewModel.o(this.f57188g, this.f57189h);
                return;
            }
            return;
        }
        zp.b.f82110a.d(R$string.no_network_tips);
        sw.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f76501c) != null && swipeRefreshLayout.isRefreshing()) {
            sw.h mViewBinding2 = getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f76501c : null;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
        }
        com.transsion.room.adapter.b bVar = this.f57185c;
        if (bVar == null || (listD = bVar.D()) == null || !listD.isEmpty()) {
            return;
        }
        z0();
    }

    private final void w0() {
        h9.f fVarQ;
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            RoomViewModel roomViewModel = this.f57186d;
            if (roomViewModel != null) {
                roomViewModel.o(this.f57188g, this.f57189h);
                return;
            }
            return;
        }
        zp.b.f82110a.d(R$string.no_network_tips);
        com.transsion.room.adapter.b bVar = this.f57185c;
        if (bVar == null || (fVarQ = bVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    private final void z0() {
        AdvRecyclerView advRecyclerView;
        sw.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f76500b) == null) {
            return;
        }
        advRecyclerView.showError();
    }

    public final void B0(RoomBean roomBean) {
        String nextPage;
        com.transsion.room.adapter.b bVar;
        h9.f fVarQ;
        h9.f fVarQ2;
        com.transsion.room.adapter.b bVar2;
        h9.f fVarQ3;
        com.transsion.room.adapter.b bVar3;
        SwipeRefreshLayout swipeRefreshLayout;
        Pager pager = roomBean.getPager();
        if (pager == null || (nextPage = pager.getNextPage()) == null) {
            nextPage = "";
        }
        this.f57188g = nextPage;
        y0();
        if (this.f57184b) {
            this.f57184b = false;
            sw.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f76501c) != null && swipeRefreshLayout.isRefreshing()) {
                sw.h mViewBinding2 = getMViewBinding();
                SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding2 != null ? mViewBinding2.f76501c : null;
                if (swipeRefreshLayout2 != null) {
                    swipeRefreshLayout2.setRefreshing(false);
                }
            }
            List<RoomItem> items = roomBean.getItems();
            if (items != null && (bVar3 = this.f57185c) != null) {
                bVar3.w0(items);
            }
            List<RoomItem> items2 = roomBean.getItems();
            if (items2 == null || !items2.isEmpty()) {
                return;
            }
            A0();
            return;
        }
        List<RoomItem> items3 = roomBean.getItems();
        if (items3 != null) {
            com.transsion.room.adapter.b bVar4 = this.f57185c;
            List<RoomItem> listD = bVar4 != null ? bVar4.D() : null;
            ArrayList arrayList = new ArrayList();
            if (listD == null || !(!listD.isEmpty())) {
                arrayList.addAll(items3);
            } else {
                for (RoomItem roomItem : items3) {
                    if (listD.contains(roomItem)) {
                        uo.b.a.f(uo.b.f78622a, PlaceTypes.ROOM, "find same item name..." + roomItem.getName(), false, 4, null);
                    } else {
                        arrayList.add(roomItem);
                    }
                }
            }
            com.transsion.room.adapter.b bVar5 = this.f57185c;
            if (bVar5 != null) {
                bVar5.m(arrayList);
            }
        }
        com.transsion.room.adapter.b bVar6 = this.f57185c;
        if (bVar6 != null && (fVarQ2 = bVar6.Q()) != null && fVarQ2.q() && (bVar2 = this.f57185c) != null && (fVarQ3 = bVar2.Q()) != null) {
            fVarQ3.r();
        }
        Pager pager2 = roomBean.getPager();
        if (pager2 == null || !Intrinsics.b(pager2.getHasMore(), Boolean.FALSE) || (bVar = this.f57185c) == null || (fVarQ = bVar.Q()) == null) {
            return;
        }
        h9.f.t(fVarQ, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        so.c.e(view);
        s0();
        o0();
        initViewModel();
        setNetListener(new e());
        this.f57190i = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.room.fragment.v
            @Override // b1.a
            public final void a(Object obj) {
                RoomFragment.t0((ActivityResult) obj);
            }
        });
        x0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        startLoading();
        v0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public sw.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.h hVarC = sw.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("rooms", false, 2, null);
    }

    public final void o0() {
        AdvRecyclerView advRecyclerView;
        AdvRecyclerView advRecyclerView2;
        SwipeRefreshLayout swipeRefreshLayout;
        AdvRecyclerView advRecyclerView3;
        AdvRecyclerView advRecyclerView4;
        sw.h mViewBinding = getMViewBinding();
        RecyclerView recyclerView = (mViewBinding == null || (advRecyclerView4 = mViewBinding.f76500b) == null) ? null : advRecyclerView4.getRecyclerView();
        sw.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (advRecyclerView3 = mViewBinding2.f76500b) != null) {
            advRecyclerView3.setPageName("rooms");
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        }
        com.transsion.room.adapter.b bVar = new com.transsion.room.adapter.b(new ArrayList());
        bVar.Q().y(true);
        bVar.Q().x(true);
        bVar.Q().D(4);
        bVar.Q().C(new f9.f() { // from class: com.transsion.room.fragment.w
            @Override // f9.f
            public final void a() {
                RoomFragment.p0(this.f57277a);
            }
        });
        bVar.o0(new b());
        bVar.B0(new f9.d() { // from class: com.transsion.room.fragment.x
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomFragment.q0(this.f57278a, baseQuickAdapter, view, i11);
            }
        });
        this.f57185c = bVar;
        if (recyclerView != null) {
            recyclerView.setAdapter(bVar);
        }
        sw.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (swipeRefreshLayout = mViewBinding3.f76501c) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.y
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    RoomFragment.r0(this.f57279a);
                }
            });
        }
        sw.h mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (advRecyclerView2 = mViewBinding4.f76500b) != null) {
            advRecyclerView2.setOnStateClickListener(new c());
        }
        sw.h mViewBinding5 = getMViewBinding();
        if (mViewBinding5 == null || (advRecyclerView = mViewBinding5.f76500b) == null) {
            return;
        }
        advRecyclerView.addOnScrollListener(new d());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b1.b<Intent> bVar = this.f57190i;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public final void s0() {
        TitleLayout titleLayout;
        sw.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (titleLayout = mViewBinding.f76502d) == null) {
            return;
        }
        titleLayout.setTitleText(com.transsion.room.R$string.str_hot_room);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        AdvRecyclerView advRecyclerView;
        sw.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (advRecyclerView = mViewBinding.f76500b) == null) {
            return;
        }
        advRecyclerView.showProgress();
    }

    public final void u0(Object obj, int i11) {
        if (obj instanceof RoomItem) {
            Intent intent = new Intent(requireActivity(), (Class<?>) RoomDetailActivity.class);
            intent.putExtra(WebConstants.FIELD_ITEM, (Parcelable) obj);
            b1.b<Intent> bVar = this.f57190i;
            if (bVar != null) {
                bVar.a(intent);
            }
            HashMap map = new HashMap();
            String groupId = ((RoomItem) obj).getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            map.put("group_id", groupId);
            map.put("sequence", String.valueOf(i11));
            com.transsion.baselib.helper.a.f51183a.b("rooms", map);
        }
    }

    public final void x0() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.c()), null, null, new RoomFragment$observerPublishEvent$1(this, null), 3, null);
    }

    public final void y0() {
        AdvRecyclerView advRecyclerView;
        sw.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (advRecyclerView = mViewBinding.f76500b) != null) {
            advRecyclerView.showData();
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null) {
            return;
        }
        logViewConfig.j(true);
    }
}
