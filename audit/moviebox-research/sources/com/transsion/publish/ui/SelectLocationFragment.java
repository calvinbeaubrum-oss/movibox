package com.transsion.publish.ui;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.adapter.SelectLocationAdapter;
import com.transsion.publish.viewmodel.LocationPlaceViewModel;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
public final class SelectLocationFragment extends PageStatusFragment<ew.i> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f56533u = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SelectLocationAdapter f56534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LocationPlaceViewModel f56535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Double f56536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Double f56537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f56538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LocationPlace f56539p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f56540q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f56541r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public rw.a f56542s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f56543t = LazyKt__LazyJVMKt.b(new Function0<IRoomApi>() { // from class: com.transsion.publish.ui.SelectLocationFragment$mRoomApi$2
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

        public final SelectLocationFragment a(LocationPlace locationPlace) {
            SelectLocationFragment selectLocationFragment = new SelectLocationFragment();
            selectLocationFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("location_data", locationPlace)));
            return selectLocationFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f56544a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f56544a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f56544a;
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
            this.f56544a.invoke(obj);
        }
    }

    private final void f1() {
        LinearLayout linearLayout;
        rw.a aVar = this.f56542s;
        if (aVar == null || !aVar.b()) {
            ew.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (linearLayout = mViewBinding.f64444b) == null) {
                return;
            }
            so.c.k(linearLayout);
            return;
        }
        if (this.f56537n == null || this.f56536m == null) {
            uo.b.a.o(uo.b.f78622a, "LocationS", new String[]{"Select---GPS is open, location null, get location----"}, false, 4, null);
            requestCurrentLocation();
        } else {
            uo.b.a.o(uo.b.f78622a, "LocationS", new String[]{"Select---GPS is open, location not null"}, false, 4, null);
            m1();
        }
    }

    private final IRoomApi getMRoomApi() {
        return (IRoomApi) this.f56543t.getValue();
    }

    public static final void j1(final SelectLocationFragment this$0, View view) {
        rw.a aVar;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "LocationS", "Select--- openGPS click", false, 4, null);
        if (this$0.getActivity() == null || (aVar = this$0.f56542s) == null) {
            return;
        }
        aVar.a(new Function1<Boolean, Unit>() { // from class: com.transsion.publish.ui.SelectLocationFragment$initListener$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                LinearLayout linearLayout;
                LinearLayout linearLayout2;
                if (z11) {
                    ew.i mViewBinding = this.this$0.getMViewBinding();
                    if (mViewBinding != null && (linearLayout2 = mViewBinding.f64444b) != null) {
                        so.c.g(linearLayout2);
                    }
                    this.this$0.requestCurrentLocation();
                } else {
                    ew.i mViewBinding2 = this.this$0.getMViewBinding();
                    if (mViewBinding2 != null && (linearLayout = mViewBinding2.f64444b) != null) {
                        so.c.k(linearLayout);
                    }
                }
                uo.b.a.f(uo.b.f78622a, "LocationS", "Select--- openGPS result:" + z11, false, 4, null);
            }
        });
    }

    public static final void k1(SelectLocationFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        LocationPlace locationPlace = item instanceof LocationPlace ? (LocationPlace) item : null;
        if (locationPlace == null) {
            return;
        }
        this$0.n1(locationPlace);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(List<LocationPlace> list) {
        F0();
        if (list.isEmpty()) {
            G0(false);
            return;
        }
        SelectLocationAdapter selectLocationAdapter = this.f56534k;
        if (selectLocationAdapter != null) {
            selectLocationAdapter.w0(CollectionsKt___CollectionsKt.M0(list));
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        requestCurrentLocation();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0033  */
    public final void g1() {
        boolean z11;
        Object objM163constructorimpl;
        uo.b.a.f(uo.b.f78622a, "LocationS", "Select--- client, getCache", false, 4, null);
        String string = RoomAppMMKV.f51271a.a().getString("key_lo_last_lat_lon", null);
        if (string != null) {
            try {
                Result.Companion companion = Result.Companion;
                List listE0 = StringsKt__StringsKt.E0(string, new String[]{","}, false, 0, 6, null);
                if (!listE0.isEmpty()) {
                    Double dJ = kotlin.text.j.j((String) listE0.get(0));
                    Double dJ2 = kotlin.text.j.j((String) listE0.get(1));
                    Double d11 = this.f56536m;
                    if (d11 != null && this.f56537n != null && dJ != null && dJ2 != null) {
                        com.transsion.baselib.utils.l lVar = com.transsion.baselib.utils.l.f51319a;
                        Intrinsics.d(d11);
                        double dDoubleValue = d11.doubleValue();
                        Double d12 = this.f56537n;
                        Intrinsics.d(d12);
                        z11 = lVar.b(dDoubleValue, d12.doubleValue(), dJ.doubleValue(), dJ2.doubleValue()) <= 30000.0f;
                    }
                }
                try {
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                }
            } catch (Throwable th3) {
                th = th3;
                z11 = true;
            }
            Result.m162boximpl(objM163constructorimpl);
            if (!z11) {
                uo.b.f78622a.c("LocationS", "Select--- client 已超距离，清除缓存，使用 getNearbyPlaces", true);
                LocationPlaceViewModel locationPlaceViewModel = this.f56535l;
                if (locationPlaceViewModel != null) {
                    locationPlaceViewModel.f();
                }
                o1();
                return;
            }
        }
        LocationPlaceViewModel locationPlaceViewModel2 = this.f56535l;
        if (locationPlaceViewModel2 != null) {
            locationPlaceViewModel2.g();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public ew.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        ew.i iVarC = ew.i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    public final void i1() {
        Integer numL;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_use_server_place", true);
        String value = configBeanB != null ? configBeanB.getValue() : null;
        int iIntValue = 0;
        if (value != null && value.length() != 0 && (numL = kotlin.text.k.l(value)) != null) {
            iIntValue = numL.intValue();
        }
        this.f56541r = iIntValue;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatTextView appCompatTextView;
        ew.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatTextView = mViewBinding.f64446d) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLocationFragment.j1(this.f56588a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        LocationPlaceViewModel locationPlaceViewModel = (LocationPlaceViewModel) new androidx.lifecycle.v0(this).a(LocationPlaceViewModel.class);
        locationPlaceViewModel.j().j(this, new b(new Function1<List<? extends LocationPlace>, Unit>() { // from class: com.transsion.publish.ui.SelectLocationFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocationPlace> list) {
                invoke2((List<LocationPlace>) list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LocationPlace> list) {
                String name;
                String distance;
                List<LocationPlace> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    uo.b.f78622a.c("LocationS", "Select--- server, 无数据", true);
                    this.this$0.l1(1);
                    return;
                }
                List listM0 = CollectionsKt___CollectionsKt.M0(list2);
                uo.b.f78622a.c("LocationS", "Select--- server,有数据展示，count:" + list.size(), true);
                LocationPlace locationPlace = this.this$0.f56539p;
                if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                    listM0.add(0, locationPlace);
                }
                this.this$0.q1(listM0);
            }
        }));
        locationPlaceViewModel.h().j(this, new b(new Function1<List<? extends LocationPlace>, Unit>() { // from class: com.transsion.publish.ui.SelectLocationFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocationPlace> list) {
                invoke2((List<LocationPlace>) list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LocationPlace> list) {
                String name;
                String distance;
                List<LocationPlace> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    uo.b.f78622a.c("LocationS", "Select--- client 无缓存 getNearbyPlaces", true);
                    this.this$0.o1();
                    return;
                }
                List listM0 = CollectionsKt___CollectionsKt.M0(list2);
                uo.b.f78622a.c("LocationS", "Select--- client, 有缓存，使用缓存数据，count:" + list.size(), true);
                LocationPlace locationPlace = this.this$0.f56539p;
                if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                    listM0.add(0, locationPlace);
                }
                this.this$0.q1(listM0);
            }
        }));
        this.f56535l = locationPlaceViewModel;
        f1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = Utils.a().getString(R$string.location_fail_tips);
        Intrinsics.f(string, "getApp().getString(R.string.location_fail_tips)");
        return string;
    }

    public final void l1(int i11) {
        String name;
        String distance;
        ArrayList arrayList = new ArrayList();
        LocationPlace locationPlace = this.f56539p;
        if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
            arrayList.add(locationPlace);
        }
        q1(arrayList);
    }

    public final void m1() {
        SelectLocationAdapter selectLocationAdapter = this.f56534k;
        if (selectLocationAdapter != null) {
            selectLocationAdapter.I0(this.f56536m, this.f56537n);
        }
        uo.b.a.f(uo.b.f78622a, "LocationS", "Select--- get location success, placeType:" + this.f56541r + ", do next", false, 4, null);
        int i11 = this.f56541r;
        if (i11 == 0) {
            g1();
        } else if (i11 == 1) {
            p1();
        } else if (i11 == 2) {
            l1(2);
        }
        if (this.f56536m == null || this.f56537n == null) {
            return;
        }
        RoomAppMMKV.f51271a.a().putString("key_lo_last_lat_lon", this.f56536m + "," + this.f56537n);
    }

    public final void n1(LocationPlace locationPlace) {
        cw.a aVar = new cw.a();
        aVar.o(8);
        aVar.n(1);
        aVar.q(locationPlace);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void o1() {
        Double d11 = this.f56536m;
        if (d11 != null) {
            double dDoubleValue = d11.doubleValue();
            Double d12 = this.f56537n;
            if (d12 != null) {
                getMRoomApi().S0(dDoubleValue, d12.doubleValue(), new Function1<List<LocationPlace>, Unit>() { // from class: com.transsion.publish.ui.SelectLocationFragment$requestNearbyPlaces$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<LocationPlace> list) {
                        invoke2(list);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<LocationPlace> list) {
                        String name;
                        String distance;
                        List<LocationPlace> list2 = list;
                        if (list2 == null || list2.isEmpty()) {
                            this.this$0.l1(0);
                            return;
                        }
                        SelectLocationFragment selectLocationFragment = this.this$0;
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            ((LocationPlace) it.next()).setCountryCode(selectLocationFragment.f56538o);
                        }
                        LocationPlaceViewModel locationPlaceViewModel = this.this$0.f56535l;
                        if (locationPlaceViewModel != null) {
                            locationPlaceViewModel.m(list);
                        }
                        ArrayList arrayList = new ArrayList();
                        SelectLocationFragment selectLocationFragment2 = this.this$0;
                        arrayList.addAll(list2);
                        LocationPlace locationPlace = selectLocationFragment2.f56539p;
                        if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                            arrayList.add(locationPlace);
                        }
                        this.this$0.q1(arrayList);
                    }
                });
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        LocationPlace locationPlace;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("location_data") : null;
        LocationPlace locationPlace2 = serializable instanceof LocationPlace ? (LocationPlace) serializable : null;
        this.f56539p = locationPlace2;
        uo.b.a aVar = uo.b.f78622a;
        Double lat = locationPlace2 != null ? locationPlace2.getLat() : null;
        LocationPlace locationPlace3 = this.f56539p;
        Double lon = locationPlace3 != null ? locationPlace3.getLon() : null;
        LocationPlace locationPlace4 = this.f56539p;
        String name = locationPlace4 != null ? locationPlace4.getName() : null;
        LocationPlace locationPlace5 = this.f56539p;
        uo.b.a.s(aVar, "LocationS", "Select--- onCreate, lat:" + lat + ", lon：" + lon + " name:" + name + ",distance:" + (locationPlace5 != null ? locationPlace5.getDistance() : null), false, 4, null);
        LocationPlace locationPlace6 = this.f56539p;
        if (locationPlace6 != null) {
            String distance = locationPlace6 != null ? locationPlace6.getDistance() : null;
            if ((distance == null || distance.length() == 0) && (locationPlace = this.f56539p) != null) {
                locationPlace.setDistance("<1m");
            }
            LocationPlace locationPlace7 = this.f56539p;
            this.f56536m = locationPlace7 != null ? locationPlace7.getLat() : null;
            LocationPlace locationPlace8 = this.f56539p;
            this.f56537n = locationPlace8 != null ? locationPlace8.getLon() : null;
            LocationPlace locationPlace9 = this.f56539p;
            this.f56538o = locationPlace9 != null ? locationPlace9.getCountryCode() : null;
        }
        this.f56542s = getMRoomApi().i1(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        if (this.f56540q == null) {
            this.f56540q = LayoutInflater.from(requireContext()).inflate(R$layout.layout_select_location_loading, (ViewGroup) o0(), false);
        }
        return this.f56540q;
    }

    public final void p1() {
        LocationPlaceViewModel locationPlaceViewModel = this.f56535l;
        if (locationPlaceViewModel != null) {
            Double d11 = this.f56536m;
            Double dValueOf = Double.valueOf(d11 != null ? d11.doubleValue() : 0.0d);
            Double d12 = this.f56537n;
            locationPlaceViewModel.i(dValueOf, Double.valueOf(d12 != null ? d12.doubleValue() : 0.0d));
        }
    }

    public final void requestCurrentLocation() {
        K0();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        getMRoomApi().M0(activity, new Function1<LocationPlace, Unit>() { // from class: com.transsion.publish.ui.SelectLocationFragment.requestCurrentLocation.1
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
                if (locationPlace == null) {
                    uo.b.a.f(uo.b.f78622a, "LocationS", "Select--- get location fail", false, 4, null);
                    SelectLocationFragment.this.F0();
                    SelectLocationAdapter selectLocationAdapter = SelectLocationFragment.this.f56534k;
                    if (selectLocationAdapter != null) {
                        selectLocationAdapter.r0(SelectLocationFragment.this.n0(false));
                        return;
                    }
                    return;
                }
                SelectLocationFragment.this.f56536m = locationPlace.getLat();
                SelectLocationFragment.this.f56537n = locationPlace.getLon();
                SelectLocationFragment selectLocationFragment = SelectLocationFragment.this;
                Address locationAddress = locationPlace.getLocationAddress();
                selectLocationFragment.f56538o = locationAddress != null ? locationAddress.getCountryCode() : null;
                SelectLocationFragment.this.f56539p = locationPlace;
                SelectLocationFragment.this.m1();
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        i1();
        SelectLocationAdapter selectLocationAdapter = new SelectLocationAdapter();
        selectLocationAdapter.B0(new f9.d() { // from class: com.transsion.publish.ui.h0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SelectLocationFragment.k1(this.f56590a, baseQuickAdapter, view, i11);
            }
        });
        this.f56534k = selectLocationAdapter;
        ew.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f64445c) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f56534k);
    }
}
