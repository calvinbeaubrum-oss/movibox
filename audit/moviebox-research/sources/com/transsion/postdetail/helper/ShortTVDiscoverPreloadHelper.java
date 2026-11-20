package com.transsion.postdetail.helper;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.a0;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.gson.Gson;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.o;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.OperatingResp;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.shorttv.config.BannerType;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class ShortTVDiscoverPreloadHelper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f55032n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy<ShortTVDiscoverPreloadHelper> f55033o = LazyKt__LazyJVMKt.b(new Function0<ShortTVDiscoverPreloadHelper>() { // from class: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShortTVDiscoverPreloadHelper invoke() {
            return new ShortTVDiscoverPreloadHelper();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0<OperatingResp> f55035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0<ShortTVRespData> f55036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0<OperatingResp> f55037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c0<ShortTVRespData> f55038e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f55041h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f55045l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f55034a = LazyKt__LazyJVMKt.b(new Function0<xv.b>() { // from class: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$service$2
        @Override // kotlin.jvm.functions.Function0
        public final xv.b invoke() {
            return (xv.b) NetServiceGenerator.f49399d.a().i(xv.b.class);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k0 f55039f = l0.a(w0.c());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a0<Pair<OperatingResp, ShortTVRespData>> f55042i = new a0<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicBoolean f55043j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtomicBoolean f55044k = new AtomicBoolean(false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f55046m = LazyKt__LazyJVMKt.b(new Function0<yv.a>() { // from class: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$preloadDiscovers$2
        @Override // kotlin.jvm.functions.Function0
        public final yv.a invoke() {
            return new yv.a();
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

        public final ShortTVDiscoverPreloadHelper a() {
            return (ShortTVDiscoverPreloadHelper) ShortTVDiscoverPreloadHelper.f55033o.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55047a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55047a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55047a;
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
            this.f55047a.invoke(obj);
        }
    }

    public static /* synthetic */ void C(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "1";
        }
        if ((i12 & 2) != 0) {
            i11 = 8;
        }
        if ((i12 & 4) != 0) {
            z11 = true;
        }
        shortTVDiscoverPreloadHelper.B(str, i11, z11);
    }

    public static final void t(final ShortTVDiscoverPreloadHelper this$0) {
        Intrinsics.g(this$0, "this$0");
        a0<Pair<OperatingResp, ShortTVRespData>> a0Var = this$0.f55042i;
        c0<ShortTVRespData> c0Var = this$0.f55036c;
        Intrinsics.d(c0Var);
        a0Var.r(c0Var, new b(new Function1<ShortTVRespData, Unit>() { // from class: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$addTrendingLiveDataToCombined$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortTVRespData shortTVRespData) {
                invoke2(shortTVRespData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortTVRespData shortTVRespData) {
                if (this.this$0.f55040g && this.this$0.f55041h) {
                    a0<Pair<OperatingResp, ShortTVRespData>> a0VarV = this.this$0.v();
                    c0<OperatingResp> c0VarY = this.this$0.y();
                    a0VarV.q(new Pair<>(c0VarY != null ? c0VarY.f() : null, shortTVRespData));
                }
            }
        }));
    }

    public static /* synthetic */ void x(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        shortTVDiscoverPreloadHelper.w(str);
    }

    public final xv.b A() {
        return (xv.b) this.f55034a.getValue();
    }

    public final void B(String nextPage, int i11, boolean z11) {
        String string;
        Intrinsics.g(nextPage, "nextPage");
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(nextPage);
        immVideoRequestEntity.setPerPage(i11);
        immVideoRequestEntity.setSessionId(fp.b.f65208a.h());
        Uri uriA = o.f51281a.a();
        if (uriA == null || (string = uriA.toString()) == null) {
            string = "";
        }
        immVideoRequestEntity.setDeepLink(string);
        immVideoRequestEntity.setLatest_events(new ds.a(ds.b.f63534a.e()));
        j.d(this.f55039f, null, null, new ShortTVDiscoverPreloadHelper$getShortTVTrending$1(immVideoRequestEntity, this, z11, null), 3, null);
    }

    public final c0<ShortTVRespData> D() {
        return this.f55036c;
    }

    public final boolean E() {
        return this.f55045l;
    }

    public final void F(Context context) {
        Intrinsics.g(context, "context");
        uo.b.a.o(uo.b.f78622a, "DiscoverPreload", new String[]{"开始预加载"}, false, 4, null);
        j.d(l0.a(w0.b()), null, null, new ShortTVDiscoverPreloadHelper$loadCache$1(this, context, null), 3, null);
    }

    public final void G() {
        j.d(this.f55039f, w0.b(), null, new ShortTVDiscoverPreloadHelper$preloadOperatingList$1(this, null), 2, null);
        uo.b.a.o(uo.b.f78622a, "DiscoverPreload", new String[]{"preloadOperatingList"}, false, 4, null);
        x(this, null, 1, null);
    }

    public final void H() {
        j.d(this.f55039f, w0.b(), null, new ShortTVDiscoverPreloadHelper$preloadTrending$1(this, null), 2, null);
        uo.b.a.o(uo.b.f78622a, "DiscoverPreload", new String[]{"preloadTrending"}, false, 4, null);
        C(this, null, 0, false, 7, null);
    }

    public final void I(OperatingResp operatingResp) {
        List<OperateItem> ops = operatingResp.getOps();
        if (ops == null || !(!ops.isEmpty())) {
            return;
        }
        u(operatingResp);
        RoomAppMMKV.f51271a.a().putString("short_tv_operating_data", new Gson().toJson(operatingResp));
    }

    public final void J(List<? extends Subject> list) {
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        j.d(this.f55039f, w0.b(), null, new ShortTVDiscoverPreloadHelper$savesNewReleaseCache$1(list, null), 2, null);
    }

    public final void K(List<? extends Subject> list) {
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        j.d(this.f55039f, w0.b(), null, new ShortTVDiscoverPreloadHelper$savesTrendingCache$1(list, null), 2, null);
    }

    public final void L(c0<OperatingResp> c0Var) {
        this.f55035b = c0Var;
    }

    public final void M(boolean z11) {
        this.f55045l = z11;
    }

    public final void N(c0<ShortTVRespData> c0Var) {
        this.f55036c = c0Var;
    }

    public final void r() {
        a0<Pair<OperatingResp, ShortTVRespData>> a0Var = this.f55042i;
        c0<OperatingResp> c0Var = this.f55035b;
        Intrinsics.d(c0Var);
        a0Var.r(c0Var, new b(new Function1<OperatingResp, Unit>() { // from class: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$addOperatingLiveDataToCombined$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OperatingResp operatingResp) {
                invoke2(operatingResp);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OperatingResp operatingResp) {
                if (this.this$0.f55040g && this.this$0.f55041h) {
                    a0<Pair<OperatingResp, ShortTVRespData>> a0VarV = this.this$0.v();
                    c0<ShortTVRespData> c0VarD = this.this$0.D();
                    a0VarV.q(new Pair<>(operatingResp, c0VarD != null ? c0VarD.f() : null));
                }
            }
        }));
    }

    public final void s() {
        if (!ThreadUtils.i()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.postdetail.helper.c
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTVDiscoverPreloadHelper.t(this.f55066a);
                }
            });
            return;
        }
        a0<Pair<OperatingResp, ShortTVRespData>> a0Var = this.f55042i;
        c0<ShortTVRespData> c0Var = this.f55036c;
        Intrinsics.d(c0Var);
        a0Var.r(c0Var, new b(new Function1<ShortTVRespData, Unit>() { // from class: com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$addTrendingLiveDataToCombined$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortTVRespData shortTVRespData) {
                invoke2(shortTVRespData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortTVRespData shortTVRespData) {
                if (this.this$0.f55040g && this.this$0.f55041h) {
                    a0<Pair<OperatingResp, ShortTVRespData>> a0VarV = this.this$0.v();
                    c0<OperatingResp> c0VarY = this.this$0.y();
                    a0VarV.q(new Pair<>(c0VarY != null ? c0VarY.f() : null, shortTVRespData));
                }
            }
        }));
    }

    public final void u(OperatingResp operatingResp) {
        ArrayList arrayList;
        List<BannerData> banners;
        List listM0;
        List<OperateItem> ops = operatingResp.getOps();
        if (ops != null) {
            for (OperateItem operateItem : ops) {
                if (Intrinsics.b(operateItem.getType(), PostItemType.BANNER.getValue())) {
                    BannerBean banner = operateItem.getBanner();
                    if (banner == null || (banners = banner.getBanners()) == null || (listM0 = CollectionsKt___CollectionsKt.M0(banners)) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (Object obj : listM0) {
                            BannerData bannerData = (BannerData) obj;
                            if (bannerData == null || bannerData.getType() != BannerType.GUIDE.ordinal()) {
                                if (bannerData == null || bannerData.getType() != BannerType.AD.ordinal()) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                    }
                    BannerBean banner2 = operateItem.getBanner();
                    if (banner2 != null) {
                        banner2.setBanners(arrayList);
                    }
                }
            }
        }
    }

    public final a0<Pair<OperatingResp, ShortTVRespData>> v() {
        return this.f55042i;
    }

    public final void w(String version) {
        Intrinsics.g(version, "version");
        this.f55045l = true;
        if (this.f55035b == null) {
            this.f55035b = new c0<>();
            r();
        }
        j.d(this.f55039f, null, null, new ShortTVDiscoverPreloadHelper$getOperatingList$1(this, version, null), 3, null);
    }

    public final c0<OperatingResp> y() {
        return this.f55035b;
    }

    public final yv.a z() {
        return (yv.a) this.f55046m.getValue();
    }
}
