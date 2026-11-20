package com.transsion.postdetail.ui.fragment;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.permissionx.guolindev.PermissionX;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.bean.LocationPlace;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class RoomPostNearbyFragment extends RoomPostBaseFragment {
    public static final a P = new a(null);
    public View F;
    public Double G;
    public Double H;
    public Address I;
    public View J;
    public View K;
    public boolean L;
    public boolean M;
    public rw.a N;
    public final Lazy O = LazyKt__LazyJVMKt.b(new Function0<IRoomApi>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment$mRoomApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IRoomApi invoke() {
            return (IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class);
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

        public final RoomPostNearbyFragment a() {
            return new RoomPostNearbyFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55803a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55803a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55803a;
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
            this.f55803a.invoke(obj);
        }
    }

    public static final void o2(RoomPostNearbyFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p2(View view, RoomPostNearbyFragment this$0) {
        Unit unit;
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        try {
            Result.Companion companion = Result.Companion;
            tv.p pVar = (tv.p) this$0.getMViewBinding();
            if (pVar == null || (recyclerView = pVar.f77888b) == null) {
                unit = null;
            } else {
                recyclerView.scrollToPosition(0);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void r2(RoomPostNearbyFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.s2(true);
    }

    public static final void t2(RoomPostNearbyFragment this$0, View emptyView) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(emptyView, "$emptyView");
        com.transsion.postdetail.ui.adapter.d dVarB1 = this$0.b1();
        if (dVarB1 != null) {
            BaseQuickAdapter.q(dVarB1, emptyView, 1, 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2() {
        View view = this.K;
        if (view != null) {
            com.transsion.postdetail.ui.adapter.d dVarB1 = b1();
            if (dVarB1 != null) {
                dVarB1.m0(view);
            }
            this.K = null;
        }
        View view2 = this.J;
        if (view2 != null) {
            com.transsion.postdetail.ui.adapter.d dVarB2 = b1();
            if (dVarB2 != null) {
                dVarB2.m0(view2);
            }
            this.J = null;
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void D1(PostSubjectItem postSubjectItem) {
        L1(postSubjectItem);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String E1() {
        return "user_center";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String M1() {
        return "room_home";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public PostAdapterFrom N1() {
        return PostAdapterFrom.NEARBY;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String R1() {
        return "room_home_nearby";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public int S1() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void a1() {
        final View viewL0;
        FrameLayout frameLayoutB;
        if (this.F == null) {
            super.a1();
            return;
        }
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            viewL0 = l0(false);
            this.J = viewL0;
        } else {
            viewL0 = r0(false);
            this.K = viewL0;
        }
        tv.p pVar = (tv.p) getMViewBinding();
        if (pVar == null || (frameLayoutB = pVar.getRoot()) == null) {
            return;
        }
        frameLayoutB.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.r0
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostNearbyFragment.t2(this.f55927a, viewL0);
            }
        });
    }

    public final IRoomApi getMRoomApi() {
        return (IRoomApi) this.O.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<RoomBean> c0VarX;
        androidx.lifecycle.c0<PostSubjectBean> c0VarP;
        RoomPostViewModel roomPostViewModelJ1 = j1();
        if (roomPostViewModelJ1 != null && (c0VarP = roomPostViewModelJ1.p()) != null) {
            c0VarP.j(this, new b(new Function1<PostSubjectBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment.initViewModel.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PostSubjectBean postSubjectBean) {
                    invoke2(postSubjectBean);
                    return Unit.f68710a;
                }

                /* JADX WARN: Code duplicated, block: B:40:0x00cd  */
                /* JADX WARN: Instruction removed from duplicated block: B:40:0x00cd, please report this as an issue */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PostSubjectBean postSubjectBean) {
                    List<RoomItem> list;
                    androidx.lifecycle.c0<RoomBean> c0VarX2;
                    RoomBean roomBeanF;
                    RoomPostViewModel roomPostViewModelJ2 = RoomPostNearbyFragment.this.j1();
                    List<RoomItem> items = (roomPostViewModelJ2 == null || (c0VarX2 = roomPostViewModelJ2.x()) == null || (roomBeanF = c0VarX2.f()) == null) ? null : roomBeanF.getItems();
                    if (!RoomPostNearbyFragment.this.L || RoomPostNearbyFragment.this.M) {
                        uo.b.a.f(uo.b.f78622a, RoomPostNearbyFragment.this.l1(), "帖子列表成功，room推荐:" + RoomPostNearbyFragment.this.L + "，不插入数据", false, 4, null);
                    } else {
                        List<PostSubjectItem> items2 = postSubjectBean != null ? postSubjectBean.getItems() : null;
                        if (items2 == null || items2.isEmpty() || (list = items) == null || list.isEmpty() || items == null || items.size() < 3) {
                            uo.b.a.f(uo.b.f78622a, RoomPostNearbyFragment.this.l1(), "帖子列表成功，room推荐:" + RoomPostNearbyFragment.this.L + "，不插入数据", false, 4, null);
                        } else {
                            uo.b.a.f(uo.b.f78622a, RoomPostNearbyFragment.this.l1(), "帖子列表成功，room推荐已成功，插入数据", false, 4, null);
                            PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, true, items, false, null, false, 973078527, null);
                            List<PostSubjectItem> items3 = postSubjectBean.getItems();
                            if (items3 == null || items3.size() <= 2) {
                                List<PostSubjectItem> items4 = postSubjectBean.getItems();
                                if (items4 != null) {
                                    items4.add(postSubjectItem);
                                }
                            } else {
                                List<PostSubjectItem> items5 = postSubjectBean.getItems();
                                if (items5 != null) {
                                    items5.add(2, postSubjectItem);
                                }
                            }
                            RoomPostNearbyFragment.this.M = true;
                        }
                    }
                    RoomPostNearbyFragment.this.w2();
                    RoomPostNearbyFragment.this.T1(postSubjectBean);
                }
            }));
        }
        RoomPostViewModel roomPostViewModelJ2 = j1();
        if (roomPostViewModelJ2 == null || (c0VarX = roomPostViewModelJ2.x()) == null) {
            return;
        }
        c0VarX.j(this, new b(new Function1<RoomBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment.initViewModel.2
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
                Unit unit;
                List<PostSubjectItem> listD;
                RoomPostNearbyFragment.this.L = true;
                List<RoomItem> items = roomBean != null ? roomBean.getItems() : null;
                List<RoomItem> list = items;
                if (list == null || list.isEmpty()) {
                    uo.b.a.f(uo.b.f78622a, RoomPostNearbyFragment.this.l1(), "room 推荐列表成功，属于为空，不处理", false, 4, null);
                    return;
                }
                if (items.size() < 3) {
                    uo.b.a.f(uo.b.f78622a, RoomPostNearbyFragment.this.l1(), "room 推荐列表成功，少于3个，直接隐藏", false, 4, null);
                    return;
                }
                PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, false, null, null, null, null, null, true, items, false, null, false, 973078527, null);
                com.transsion.postdetail.ui.adapter.d dVarB1 = RoomPostNearbyFragment.this.b1();
                int itemCount = dVarB1 != null ? dVarB1.getItemCount() : 0;
                if (itemCount > 0) {
                    uo.b.a.f(uo.b.f78622a, RoomPostNearbyFragment.this.l1(), "room 推荐列表成功，帖子列表已返回，直接插入， " + items.size(), false, 4, null);
                    if (itemCount > 2) {
                        itemCount = 2;
                    }
                    RoomPostNearbyFragment roomPostNearbyFragment = RoomPostNearbyFragment.this;
                    try {
                        Result.Companion companion = Result.Companion;
                        com.transsion.postdetail.ui.adapter.d dVarB2 = roomPostNearbyFragment.b1();
                        if (dVarB2 != null && (listD = dVarB2.D()) != null) {
                            listD.add(itemCount, postSubjectItem);
                        }
                        com.transsion.postdetail.ui.adapter.d dVarB3 = roomPostNearbyFragment.b1();
                        if (dVarB3 != null) {
                            dVarB3.notifyItemInserted(itemCount);
                            unit = Unit.f68710a;
                        } else {
                            unit = null;
                        }
                        Result.m163constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m163constructorimpl(ResultKt.a(th2));
                    }
                }
            }
        }));
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        q2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n2() {
        RecyclerView recyclerView;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing() || this.F != null) {
            return;
        }
        final View viewInflate = LayoutInflater.from(activity).inflate(R$layout.layout_location_permission_header, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R$id.tv_allow)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomPostNearbyFragment.o2(this.f55932a, view);
            }
        });
        com.transsion.postdetail.ui.adapter.d dVarB1 = b1();
        if (dVarB1 != null) {
            Intrinsics.f(viewInflate, "this");
            BaseQuickAdapter.q(dVarB1, viewInflate, 0, 0, 6, null);
        }
        tv.p pVar = (tv.p) getMViewBinding();
        if (pVar != null && (recyclerView = pVar.f77888b) != null) {
            recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.u0
                @Override // java.lang.Runnable
                public final void run() {
                    RoomPostNearbyFragment.p2(viewInflate, this);
                }
            });
        }
        this.F = viewInflate;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.N = getMRoomApi().i1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q2() {
        FrameLayout frameLayoutB;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        rw.a aVar = this.N;
        if (aVar != null && aVar.b()) {
            uo.b.a.f(uo.b.f78622a, "NearbyLocation", "GPS is open, checkPermission", false, 4, null);
            tv.p pVar = (tv.p) getMViewBinding();
            if (pVar == null || (frameLayoutB = pVar.getRoot()) == null) {
                return;
            }
            frameLayoutB.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.s0
                @Override // java.lang.Runnable
                public final void run() {
                    RoomPostNearbyFragment.r2(this.f55930a);
                }
            });
            return;
        }
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (roomAppMMKV.a().getBoolean("key_lo_per_requested", false)) {
            n2();
            K0();
            RoomPostBaseFragment.w1(this, false, 1, null);
        } else {
            roomAppMMKV.a().putBoolean("key_lo_per_requested", true);
            rw.a aVar2 = this.N;
            if (aVar2 != null) {
                aVar2.a(new RoomPostNearbyFragment$checkGPS$2(this));
            }
        }
    }

    public final void s2(boolean z11) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (PermissionX.f48641a.e(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            u2();
            return;
        }
        if (z11) {
            uo.b.a.f(uo.b.f78622a, "NearbyLocation", "checkPermission forceRequest permission", false, 4, null);
            y2();
        } else {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            if (roomAppMMKV.a().getBoolean("key_lo_per_requested", false)) {
                uo.b.a.f(uo.b.f78622a, "NearbyLocation", "checkPermission other,show header", false, 4, null);
                n2();
            } else {
                uo.b.a.f(uo.b.f78622a, "NearbyLocation", "checkPermission first", false, 4, null);
                roomAppMMKV.a().putBoolean("key_lo_per_requested", true);
                y2();
            }
        }
        K0();
        RoomPostBaseFragment.w1(this, false, 1, null);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean t1() {
        return true;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean u1() {
        return false;
    }

    public final void u2() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        getMRoomApi().M0(activity, new Function1<LocationPlace, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment$getCurrentLocation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocationPlace locationPlace) {
                invoke2(locationPlace);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocationPlace locationPlace) {
                if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
                    return;
                }
                this.this$0.G = locationPlace != null ? locationPlace.getLat() : null;
                this.this$0.H = locationPlace != null ? locationPlace.getLon() : null;
                this.this$0.I = locationPlace != null ? locationPlace.getLocationAddress() : null;
                uo.b.a.f(uo.b.f78622a, this.this$0.l1(), "get location success load data again", false, 4, null);
                this.this$0.v2();
                this.this$0.K0();
                RoomPostBaseFragment.w1(this.this$0, false, 1, null);
            }
        });
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void v1(boolean z11) {
        if (z11) {
            this.M = false;
            v2();
        }
        RoomPostViewModel roomPostViewModelJ1 = j1();
        if (roomPostViewModelJ1 != null) {
            String strG1 = g1();
            int iI1 = i1();
            Double d11 = this.G;
            double dDoubleValue = d11 != null ? d11.doubleValue() : 0.0d;
            Double d12 = this.H;
            roomPostViewModelJ1.t(z11, strG1, iI1, dDoubleValue, d12 != null ? d12.doubleValue() : 0.0d);
        }
    }

    public final void v2() {
        RoomPostViewModel roomPostViewModelJ1;
        if (this.G == null || this.H == null || (roomPostViewModelJ1 = j1()) == null) {
            return;
        }
        Double d11 = this.G;
        Intrinsics.d(d11);
        double dDoubleValue = d11.doubleValue();
        Double d12 = this.H;
        Intrinsics.d(d12);
        roomPostViewModelJ1.w(dDoubleValue, d12.doubleValue(), this.I);
    }

    public final void x2() {
        View view = this.F;
        if (view != null) {
            com.transsion.postdetail.ui.adapter.d dVarB1 = b1();
            if (dVarB1 != null) {
                dVarB1.m0(view);
            }
            this.F = null;
        }
    }

    public final void y2() {
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        getMRoomApi().E0(activity, false, new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment$requestLocationPermission$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                if (!z11) {
                    uo.b.a.f(uo.b.f78622a, "NearbyLocation", "checkPermission permission denied, show header", false, 4, null);
                    this.this$0.n2();
                } else {
                    uo.b.a.f(uo.b.f78622a, "NearbyLocation", "checkPermission permission Granted， get location", false, 4, null);
                    this.this$0.x2();
                    this.this$0.u2();
                }
            }
        });
    }
}
