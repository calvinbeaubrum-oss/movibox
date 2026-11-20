package com.transsion.home.viewmodel.preload;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.google.gson.Gson;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.banner.banner.config.BannerType;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.AhaGameResponse;
import com.transsion.commercializationapi.IAhaGameApi;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.p003enum.BottomTabType;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.MainOperateData;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f;
import kotlin.collections.k;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import rt.d;
import rw.e;

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
public final class PreloadTrendingData {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f52790o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f52791p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy<PreloadTrendingData> f52792q = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<PreloadTrendingData>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PreloadTrendingData invoke() {
            return new PreloadTrendingData();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f52794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f52795c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppTab f52804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<OperateItem> f52805m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f52793a = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f52796d = (d) NetServiceGenerator.f49399d.a().i(d.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f52797e = LazyKt__LazyJVMKt.b(new Function0<PreloadTrendingBuiltInHelper>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$builtInHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PreloadTrendingBuiltInHelper invoke() {
            return new PreloadTrendingBuiltInHelper();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f52798f = LazyKt__LazyJVMKt.b(new Function0<c0<MainOperateData>>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$operatingRespNet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<MainOperateData> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f52799g = LazyKt__LazyJVMKt.b(new Function0<c0<MainOperateData>>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$operatingCache$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<MainOperateData> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52800h = LazyKt__LazyJVMKt.b(new Function0<c0<AppTab>>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$appTabFromNet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<AppTab> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f52801i = LazyKt__LazyJVMKt.b(new Function0<c0<AppTab>>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$appTabFromCache$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<AppTab> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f52802j = LazyKt__LazyJVMKt.b(new Function0<c0<HotSubjectEntity>>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$hotSearchLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<HotSubjectEntity> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f52803k = LazyKt__LazyJVMKt.b(new Function0<c0<List<AhaGameAllGames>>>() { // from class: com.transsion.home.viewmodel.preload.PreloadTrendingData$gameListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<AhaGameAllGames>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g0 f52806n = new b(g0.f69429i8);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PreloadTrendingData a() {
            return (PreloadTrendingData) PreloadTrendingData.f52792q.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class b extends AbstractCoroutineContextElement implements g0 {
        public b(g0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.g0
        public void l(CoroutineContext coroutineContext, Throwable th2) {
            uo.b.f78622a.h("PreloadTrending", "coroutineExceptionHandler " + th2.getMessage(), true);
            th2.printStackTrace();
        }
    }

    public final c0<List<AhaGameAllGames>> A() {
        return (c0) this.f52803k.getValue();
    }

    public final AppTab B() {
        return this.f52804l;
    }

    public final void C() {
        j.d(l0.a(w0.b()), null, null, new PreloadTrendingData$getHotSearch$1(this, null), 3, null);
    }

    public final c0<HotSubjectEntity> D() {
        return (c0) this.f52802j.getValue();
    }

    public final HotSubjectEntity E() {
        String string = RoomAppMMKV.f51271a.a().getString("hot_search_words", null);
        if (string != null) {
            return (HotSubjectEntity) n.d(string, HotSubjectEntity.class);
        }
        return null;
    }

    public final c0<MainOperateData> F() {
        return (c0) this.f52799g.getValue();
    }

    public final c0<MainOperateData> G() {
        return (c0) this.f52798f.getValue();
    }

    public final List<OperateItem> H() {
        List<OperateItem> list = this.f52805m;
        this.f52805m = null;
        return list;
    }

    public final boolean I() {
        return this.f52795c;
    }

    public final void J(AppTab appTab) {
        BottomTabItem bottomTabItem;
        BottomTabItem bottomTabItem2;
        List<BottomTabItem> bottomTabs;
        Object next;
        List<BottomTabItem> bottomTabs2;
        Object next2;
        Object obj = null;
        if (appTab == null || (bottomTabs2 = appTab.getBottomTabs()) == null) {
            bottomTabItem = null;
        } else {
            Iterator<T> it = bottomTabs2.iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
            } while (!Intrinsics.b(((BottomTabItem) next2).getBtTabCode(), BottomTabType.TAB_CODE_COMMUNITY));
            bottomTabItem = (BottomTabItem) next2;
        }
        if (bottomTabItem != null) {
            uo.b.a.f(uo.b.f78622a, "PreloadTrending", "has bottom room tab", false, 4, null);
            e.f75743a.c(true);
            return;
        }
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            bottomTabItem2 = null;
        } else {
            Iterator<T> it2 = bottomTabs.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.b(((BottomTabItem) next).getBtTabCode(), BottomTabType.TAB_CODE_HOME));
            bottomTabItem2 = (BottomTabItem) next;
        }
        if (bottomTabItem2 == null) {
            uo.b.a.f(uo.b.f78622a, "PreloadTrending", "has no room tab", false, 4, null);
            e.f75743a.c(false);
            return;
        }
        List<HomeTabItem> subTabs = bottomTabItem2.getSubTabs();
        if (subTabs != null) {
            for (Object obj2 : subTabs) {
                HomeTabItem homeTabItem = (HomeTabItem) obj2;
                if (Intrinsics.b(homeTabItem != null ? homeTabItem.getTabCode() : null, "Community")) {
                    obj = obj2;
                    break;
                }
            }
            obj = (HomeTabItem) obj;
        }
        uo.b.a.f(uo.b.f78622a, "PreloadTrending", "has top room tab:" + (obj != null), false, 4, null);
        e.f75743a.c(obj != null);
    }

    public final boolean K(String str) {
        if (this.f52794b) {
            return false;
        }
        this.f52794b = true;
        j.d(l0.a(w0.b()), this.f52806n, null, new PreloadTrendingData$loadOperatingDataFromNet$1(this, str, null), 2, null);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d9 A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #0 {Exception -> 0x0036, blocks: (B:13:0x0032, B:24:0x005b, B:26:0x0067, B:28:0x006d, B:30:0x0077, B:32:0x0097, B:34:0x009d, B:36:0x00a5, B:38:0x00b7, B:40:0x00c1, B:42:0x00c9, B:45:0x00d0, B:46:0x00d3, B:47:0x00d9), top: B:54:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object L(String str, Continuation<? super Unit> continuation) throws Throwable {
        PreloadTrendingData$preloadMainOperation$1 preloadTrendingData$preloadMainOperation$1;
        PreloadTrendingData preloadTrendingData;
        BaseDto baseDto;
        MainOperateData mainOperateData;
        Integer numD;
        List<OperateItem> items;
        List<OperateItem> items2;
        if (continuation instanceof PreloadTrendingData$preloadMainOperation$1) {
            preloadTrendingData$preloadMainOperation$1 = (PreloadTrendingData$preloadMainOperation$1) continuation;
            int i11 = preloadTrendingData$preloadMainOperation$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                preloadTrendingData$preloadMainOperation$1.label = i11 - Integer.MIN_VALUE;
            } else {
                preloadTrendingData$preloadMainOperation$1 = new PreloadTrendingData$preloadMainOperation$1(this, continuation);
            }
        } else {
            preloadTrendingData$preloadMainOperation$1 = new PreloadTrendingData$preloadMainOperation$1(this, continuation);
        }
        PreloadTrendingData$preloadMainOperation$1 preloadTrendingData$preloadMainOperation$2 = preloadTrendingData$preloadMainOperation$1;
        Object objB = preloadTrendingData$preloadMainOperation$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = preloadTrendingData$preloadMainOperation$2.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            try {
                d dVar = this.f52796d;
                int i13 = this.f52793a;
                preloadTrendingData$preloadMainOperation$2.L$0 = this;
                preloadTrendingData$preloadMainOperation$2.L$1 = str;
                preloadTrendingData$preloadMainOperation$2.label = 1;
                objB = d.a.b(dVar, null, i13, 0, str, preloadTrendingData$preloadMainOperation$2, 5, null);
                if (objB == objE) {
                    return objE;
                }
                preloadTrendingData = this;
                baseDto = (BaseDto) objB;
                uo.b.a aVar = uo.b.f78622a;
                mainOperateData = (MainOperateData) baseDto.getData();
                if (mainOperateData != null) {
                    numD = null;
                } else {
                    numD = null;
                }
                aVar.c("PreloadTrending", "get operating data from net size = " + numD, true);
                if (Intrinsics.b(baseDto.getCode(), "0")) {
                    preloadTrendingData.G().n(null);
                } else {
                    preloadTrendingData.G().n(null);
                }
            } catch (Exception e11) {
                e = e11;
                preloadTrendingData = this;
                uo.b.f78622a.h("PreloadTrending", "get Operating List msg=" + e.getMessage() + " cause=" + e.getCause(), true);
                preloadTrendingData.G().n(null);
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) preloadTrendingData$preloadMainOperation$2.L$1;
            preloadTrendingData = (PreloadTrendingData) preloadTrendingData$preloadMainOperation$2.L$0;
            try {
                ResultKt.b(objB);
                baseDto = (BaseDto) objB;
                uo.b.a aVar2 = uo.b.f78622a;
                mainOperateData = (MainOperateData) baseDto.getData();
                if (mainOperateData != null || (items2 = mainOperateData.getItems()) == null) {
                    numD = null;
                } else {
                    numD = Boxing.d(items2.size());
                }
                aVar2.c("PreloadTrending", "get operating data from net size = " + numD, true);
                if (Intrinsics.b(baseDto.getCode(), "0") || baseDto.getData() == null) {
                    preloadTrendingData.G().n(null);
                } else {
                    MainOperateData mainOperateData2 = (MainOperateData) baseDto.getData();
                    if (mainOperateData2 != null) {
                        mainOperateData2.setSourceFrom("from_net");
                        preloadTrendingData.G().n(mainOperateData2);
                        if (mainOperateData2.getVersion() != null && !Intrinsics.b(mainOperateData2.getVersion(), str) && (items = mainOperateData2.getItems()) != null && !items.isEmpty()) {
                            preloadTrendingData.Q(mainOperateData2);
                        }
                    }
                    preloadTrendingData.f52793a++;
                }
            } catch (Exception e12) {
                e = e12;
                uo.b.f78622a.h("PreloadTrending", "get Operating List msg=" + e.getMessage() + " cause=" + e.getCause(), true);
                preloadTrendingData.G().n(null);
            }
        }
        return Unit.f68710a;
    }

    public final void M(Context context) {
        Intrinsics.g(context, "context");
        uo.b.f78622a.c("PreloadTrending", "preloadOperatingCache() called", true);
        j.d(l0.a(w0.b()), null, null, new PreloadTrendingData$preloadOperating$1(this, context, null), 3, null);
        O(context);
        N(context);
    }

    public final void N(Context context) {
        j.d(l0.a(w0.b()), null, null, new PreloadTrendingData$preloadSkuDataCache$1(context, null), 3, null);
    }

    public final void O(Context context) {
        j.d(l0.a(w0.b()), null, null, new PreloadTrendingData$preloadVideoCache$1(this, context, null), 3, null);
    }

    public final boolean P(Context context, String operationVersion) {
        Intrinsics.g(context, "context");
        Intrinsics.g(operationVersion, "operationVersion");
        if (F().f() != null) {
            return K(operationVersion);
        }
        M(context);
        return true;
    }

    public final void Q(MainOperateData mainOperateData) {
        List<OperateItem> items = mainOperateData.getItems();
        if (items == null || !(!items.isEmpty())) {
            return;
        }
        q(mainOperateData);
        RoomAppMMKV.f51271a.a().putString("main_operating_data", new Gson().toJson(mainOperateData));
    }

    public final void R(AppTab appTab) {
        List<BottomTabItem> bottomTabs = appTab != null ? appTab.getBottomTabs() : null;
        if (bottomTabs == null || bottomTabs.isEmpty()) {
            return;
        }
        RoomAppMMKV.f51271a.a().putString("app_tab", n.j(appTab));
    }

    public final void S(List<OperateItem> list) {
        Intrinsics.g(list, "list");
        this.f52805m = list;
    }

    public final void q(MainOperateData mainOperateData) {
        ArrayList arrayList;
        List<BannerData> banners;
        List listM0;
        List<OperateItem> items = mainOperateData.getItems();
        if (items != null) {
            for (OperateItem operateItem : items) {
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

    public final List<BottomTabItem> r(AppTab appTab) {
        List<BottomTabItem> bottomTabs;
        ArrayList arrayList = new ArrayList();
        for (BottomTabType bottomTabType : BottomTabType.values()) {
            k.A(arrayList, f.e(bottomTabType.getValue()));
        }
        boolean zE1 = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1();
        if (!zE1) {
            uo.b.a.f(uo.b.f78622a, "co_mem", "MainActivity --> getTabEntities() --> 当前没有开启会员功能 --> 不展示会员Tab", false, 4, null);
        }
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : bottomTabs) {
            BottomTabItem bottomTabItem = (BottomTabItem) obj;
            if (Intrinsics.b(bottomTabItem.getBtTabType(), BottomTabType.PREMIUM.getValue())) {
                if (CollectionsKt___CollectionsKt.X(arrayList, bottomTabItem.getBtTabType()) && zE1) {
                    arrayList2.add(obj);
                }
            } else if (CollectionsKt___CollectionsKt.X(arrayList, bottomTabItem.getBtTabType())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt___CollectionsKt.M0(arrayList2);
    }

    public final List<HomeTabItem> s(List<HomeTabItem> list) {
        ArrayList arrayList = new ArrayList();
        for (HomeTabType homeTabType : HomeTabType.values()) {
            k.A(arrayList, f.e(homeTabType.getValue()));
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            HomeTabItem homeTabItem = (HomeTabItem) obj;
            if (homeTabItem != null && CollectionsKt___CollectionsKt.X(arrayList, homeTabItem.getType())) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt___CollectionsKt.M0(arrayList2);
    }

    public final void t() {
        this.f52795c = true;
        uo.b.f78622a.c("PreloadTrending", "getAppTab() called", true);
        j.d(l0.a(w0.b()), null, null, new PreloadTrendingData$getAppTab$1(this, null), 3, null);
    }

    public final AppTab u(Context context) {
        Intrinsics.g(context, "context");
        try {
            String strD = y().d(context);
            if (strD != null && strD.length() != 0) {
                return (AppTab) n.d(strD, AppTab.class);
            }
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final AppTab v() {
        String str = "";
        try {
            String string = RoomAppMMKV.f51271a.a().getString("app_tab", "");
            if (string == null || string.length() == 0) {
                PreloadTrendingBuiltInHelper preloadTrendingBuiltInHelperY = y();
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                String strD = preloadTrendingBuiltInHelperY.d(applicationA);
                if (strD != null) {
                    str = strD;
                }
                string = str;
            }
            if (string.length() > 0) {
                return (AppTab) n.d(string, AppTab.class);
            }
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final c0<AppTab> w() {
        return (c0) this.f52801i.getValue();
    }

    public final c0<AppTab> x() {
        return (c0) this.f52800h.getValue();
    }

    public final PreloadTrendingBuiltInHelper y() {
        return (PreloadTrendingBuiltInHelper) this.f52797e.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object z(Continuation<? super AhaGameResponse> continuation) throws Throwable {
        PreloadTrendingData$getGameList$1 preloadTrendingData$getGameList$1;
        Object objM163constructorimpl;
        if (continuation instanceof PreloadTrendingData$getGameList$1) {
            preloadTrendingData$getGameList$1 = (PreloadTrendingData$getGameList$1) continuation;
            int i11 = preloadTrendingData$getGameList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                preloadTrendingData$getGameList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                preloadTrendingData$getGameList$1 = new PreloadTrendingData$getGameList$1(this, continuation);
            }
        } else {
            preloadTrendingData$getGameList$1 = new PreloadTrendingData$getGameList$1(this, continuation);
        }
        Object objR = preloadTrendingData$getGameList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = preloadTrendingData$getGameList$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objR);
                ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_home_show_gamelist", true);
                if (!Intrinsics.b(configBeanB != null ? configBeanB.getValue() : null, "true")) {
                    return new AhaGameResponse(Boxing.d(0), null, null);
                }
                Result.Companion companion = Result.Companion;
                IAhaGameApi iAhaGameApi = (IAhaGameApi) com.alibaba.android.arouter.launcher.a.d().h(IAhaGameApi.class);
                preloadTrendingData$getGameList$1.label = 1;
                objR = iAhaGameApi.r(preloadTrendingData$getGameList$1);
                if (objR == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objR);
            }
            objM163constructorimpl = Result.m163constructorimpl((AhaGameResponse) objR);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
            return objM163constructorimpl;
        }
        return null;
    }
}
