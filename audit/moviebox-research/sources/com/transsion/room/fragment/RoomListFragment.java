package com.transsion.room.fragment;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.permissionx.guolindev.PermissionX;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.RoomListAdapter;
import com.transsion.room.adapter.RoomListFrom;
import com.transsion.room.api.bean.LocationPlace;
import com.transsion.room.helper.GpsServiceHelper;
import com.transsion.room.helper.LocationPlaceHelper;
import com.transsion.room.viewmodel.RoomViewModel;
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
public final class RoomListFragment extends RoomListBaseFragment {
    public static final a J = new a(null);
    public Integer B;
    public Double C;
    public Double D;
    public Address E;
    public View F;
    public View G;
    public View H;
    public final Lazy I = LazyKt__LazyJVMKt.b(new Function0<GpsServiceHelper>() { // from class: com.transsion.room.fragment.RoomListFragment$mGpsServiceHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GpsServiceHelper invoke() {
            return new GpsServiceHelper(this.this$0);
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

        public final RoomListFragment a(Integer num, boolean z11) {
            RoomListFragment roomListFragment = new RoomListFragment();
            roomListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("id", num), TuplesKt.a("is_select_room", Boolean.valueOf(z11))));
            return roomListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57218a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57218a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57218a;
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
            this.f57218a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1() {
        if (this.F == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_location_permission_header, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R$id.tv_allow)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomListFragment.I1(this.f57255a, view);
                }
            });
            RoomListAdapter roomListAdapterD1 = d1();
            if (roomListAdapterD1 != null) {
                Intrinsics.f(viewInflate, "this");
                BaseQuickAdapter.q(roomListAdapterD1, viewInflate, 0, 0, 4, null);
            }
            this.F = viewInflate;
        }
    }

    public static final void I1(RoomListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.R1();
    }

    private final void J1() {
        if (N1().b()) {
            uo.b.a.f(uo.b.f78622a, "RoomLocation", "GPS is open, checkPermission", false, 4, null);
            K1();
        } else if (getActivity() != null) {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            if (roomAppMMKV.a().getBoolean("key_list_lo_per_requested", false)) {
                H1();
            } else {
                roomAppMMKV.a().putBoolean("key_list_lo_per_requested", true);
                N1().a(new RoomListFragment$checkGPS$1$1(this));
            }
            K0();
            RoomListBaseFragment.r1(this, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (PermissionX.f48641a.e(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            M1();
            return;
        }
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (roomAppMMKV.a().getBoolean("key_list_lo_per_requested", false)) {
            H1();
        } else {
            roomAppMMKV.a().putBoolean("key_list_lo_per_requested", true);
            R1();
        }
        K0();
        RoomListBaseFragment.r1(this, false, 1, null);
    }

    public static final void L1(RoomListFragment this$0, View emptyView) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(emptyView, "$emptyView");
        RoomListAdapter roomListAdapterD1 = this$0.d1();
        if (roomListAdapterD1 != null) {
            BaseQuickAdapter.q(roomListAdapterD1, emptyView, 1, 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        LocationPlaceHelper.f57284a.n(activity, new Function1<LocationPlace, Unit>() { // from class: com.transsion.room.fragment.RoomListFragment$getCurrentLocation$1
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
                this.this$0.C = locationPlace != null ? locationPlace.getLat() : null;
                this.this$0.D = locationPlace != null ? locationPlace.getLon() : null;
                this.this$0.E = locationPlace != null ? locationPlace.getLocationAddress() : null;
                this.this$0.K0();
                RoomListBaseFragment.r1(this.this$0, false, 1, null);
            }
        });
    }

    private final void O1() {
        Function1<JoinRoomEvent, Unit> function1 = new Function1<JoinRoomEvent, Unit>() { // from class: com.transsion.room.fragment.RoomListFragment$observerJoinRoomEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinRoomEvent joinRoomEvent) {
                invoke2(joinRoomEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinRoomEvent value) {
                List<RoomItem> listD;
                Intrinsics.g(value, "value");
                RoomListAdapter roomListAdapterD1 = this.this$0.d1();
                int i11 = -1;
                if (roomListAdapterD1 != null && (listD = roomListAdapterD1.D()) != null) {
                    Iterator<RoomItem> it = listD.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        if (Intrinsics.b(value.getGroupId(), it.next().getGroupId())) {
                            i11 = i12;
                            break;
                        }
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    RoomListAdapter roomListAdapterD2 = this.this$0.d1();
                    RoomItem item = roomListAdapterD2 != null ? roomListAdapterD2.getItem(i11) : null;
                    if (item != null) {
                        item.setHasJoin(Boolean.valueOf(value.getJoin()));
                    }
                    RoomListAdapter roomListAdapterD3 = this.this$0.d1();
                    if (roomListAdapterD3 != null) {
                        roomListAdapterD3.notifyItemChanged(i11, Boolean.valueOf(value.getJoin()));
                    }
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1() {
        View view = this.H;
        if (view != null) {
            RoomListAdapter roomListAdapterD1 = d1();
            if (roomListAdapterD1 != null) {
                roomListAdapterD1.m0(view);
            }
            this.H = null;
        }
        View view2 = this.G;
        if (view2 != null) {
            RoomListAdapter roomListAdapterD2 = d1();
            if (roomListAdapterD2 != null) {
                roomListAdapterD2.m0(view2);
            }
            this.G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1() {
        View view = this.F;
        if (view != null) {
            RoomListAdapter roomListAdapterD1 = d1();
            if (roomListAdapterD1 != null) {
                roomListAdapterD1.m0(view);
            }
            this.F = null;
        }
    }

    private final void R1() {
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        LocationPlaceHelper.f57284a.t(activity, false, new Function1<Boolean, Unit>() { // from class: com.transsion.room.fragment.RoomListFragment$requestLocationPermission$1
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
                    this.this$0.H1();
                } else {
                    this.this$0.Q1();
                    this.this$0.M1();
                }
            }
        });
    }

    public final GpsServiceHelper N1() {
        return (GpsServiceHelper) this.I.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void a1() {
        final View viewL0;
        SwipeRefreshLayout root;
        Integer num = this.B;
        if (num == null || num.intValue() != -2) {
            super.a1();
            return;
        }
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            viewL0 = l0(false);
            this.G = viewL0;
        } else {
            viewL0 = r0(false);
            this.H = viewL0;
        }
        sw.m mVar = (sw.m) getMViewBinding();
        if (mVar == null || (root = mVar.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.transsion.room.fragment.j0
            @Override // java.lang.Runnable
            public final void run() {
                RoomListFragment.L1(this.f57258a, viewL0);
            }
        });
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public RoomListFrom i1() {
        return RoomListFrom.ROOM_LIST;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        O1();
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<RoomBean> c0VarZ;
        super.initViewModel();
        RoomViewModel roomViewModelH1 = h1();
        if (roomViewModelH1 == null || (c0VarZ = roomViewModelH1.z()) == null) {
            return;
        }
        c0VarZ.j(this, new b(new Function1<RoomBean, Unit>() { // from class: com.transsion.room.fragment.RoomListFragment.initViewModel.1
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
                RoomListFragment.this.P1();
                RoomListFragment.this.w1(roomBean);
            }
        }));
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        Integer num = this.B;
        if (num != null && num.intValue() == -2) {
            return;
        }
        super.lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public void q1(boolean z11) {
        Integer num = this.B;
        if (num != null) {
            int iIntValue = num.intValue();
            RoomViewModel roomViewModelH1 = h1();
            if (roomViewModelH1 != null) {
                String strF1 = f1();
                if (strF1 == null) {
                    strF1 = "1";
                }
                roomViewModelH1.x(z11, iIntValue, strF1, g1(), this.C, this.D, this.E);
            }
        }
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("id", -1)) : null;
        this.B = numValueOf;
        if (numValueOf != null && numValueOf.intValue() == -2) {
            J1();
        }
    }

    @Override // com.transsion.room.fragment.RoomListBaseFragment
    public String v1() {
        return "room_list";
    }
}
