package com.transsion.ad.middle.icon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.mediation.ad.TAdNativeView;
import com.hisavana.mediation.ad.TNativeAd;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;

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
public final class WrapperIconAdManager extends WrapperAdListener {
    private HiSavanaIconAdManager adManager;
    private View hiIconView;
    private WrapperAdListener mCallback;
    private String mSceneId;
    private PSDistributionProvider pSDistribution;
    private int targetNum;
    private Set<BuyOutIconView> buyOutIconViewSet = new LinkedHashSet();
    private Set<TAdNativeView> tAdNativeViewSet = new LinkedHashSet();
    private Set<TAdNativeInfo> tAdNativeInfoSet = new LinkedHashSet();
    private AtomicBoolean isLoading = new AtomicBoolean(false);
    private final Lazy mHandler$delegate = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.ad.middle.icon.WrapperIconAdManager$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private final Runnable delayRunnable = new Runnable() { // from class: com.transsion.ad.middle.icon.c
        @Override // java.lang.Runnable
        public final void run() {
            WrapperIconAdManager.delayRunnable$lambda$0(this.f50428a);
        }
    };
    private List<TAdNativeInfo> temporaryStorageHi = new ArrayList();
    private List<RecommendInfo> temporaryStoragePs = new ArrayList();

    /* JADX INFO: renamed from: com.transsion.ad.middle.icon.WrapperIconAdManager$bindHiIconView$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.icon.WrapperIconAdManager$bindHiIconView$2", f = "WrapperIconAdManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.transsion.ad.middle.nativead.a $absAdLayoutProvider;
        final /* synthetic */ Context $viewContext;
        int label;
        final /* synthetic */ WrapperIconAdManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(com.transsion.ad.middle.nativead.a aVar, WrapperIconAdManager wrapperIconAdManager, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$absAdLayoutProvider = aVar;
            this.this$0 = wrapperIconAdManager;
            this.$viewContext = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$absAdLayoutProvider, this.this$0, this.$viewContext, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Integer numQ;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            com.transsion.ad.middle.nativead.a aVar = this.$absAdLayoutProvider;
            if (aVar == null || (numQ = aVar.q()) == null) {
                return null;
            }
            this.this$0.hiIconView = this.$absAdLayoutProvider.e(this.$viewContext).findViewById(numQ.intValue());
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.icon.WrapperIconAdManager$clickAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.icon.WrapperIconAdManager$clickAd$1", f = "WrapperIconAdManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WrapperIconAdManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            BuyOutIconView buyOutIconView;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if ((!WrapperIconAdManager.this.buyOutIconViewSet.isEmpty()) && (buyOutIconView = (BuyOutIconView) CollectionsKt___CollectionsKt.d0(WrapperIconAdManager.this.buyOutIconViewSet)) != null) {
                buyOutIconView.clickAd();
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.icon.WrapperIconAdManager$clickAd$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.icon.WrapperIconAdManager$clickAd$2", f = "WrapperIconAdManager.kt", l = {}, m = "invokeSuspend")
    public static final class C19842 extends SuspendLambda implements Function2<k0, Continuation<? super Boolean>, Object> {
        int label;

        public C19842(Continuation<? super C19842> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WrapperIconAdManager.this.new C19842(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Boolean> continuation) {
            return ((C19842) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            View view = WrapperIconAdManager.this.hiIconView;
            if (view != null) {
                return Boxing.a(view.performClick());
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.icon.WrapperIconAdManager$innerLoadAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.icon.WrapperIconAdManager", f = "WrapperIconAdManager.kt", l = {342}, m = "innerLoadAd")
    public static final class C19851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C19851(Continuation<? super C19851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WrapperIconAdManager.this.innerLoadAd(null, false, this);
        }
    }

    private final void assemblyData(String str) {
        getMHandler().removeCallbacks(this.delayRunnable);
        try {
            Result.Companion companion = Result.Companion;
            List<WrapperIconBean> listCombineAndRetrieveData = combineAndRetrieveData(isHiPriority());
            Unit unit = null;
            com.transsion.ad.a.B(com.transsion.ad.a.f50276a, getClassTag() + " --> assemblyData() --> msg = " + str + " --> targetNum = " + this.targetNum + " --> 组装数据 --> size = " + listCombineAndRetrieveData.size(), false, 2, null);
            int i11 = this.targetNum;
            if (i11 > 0) {
                listCombineAndRetrieveData = CollectionsKt___CollectionsKt.M0(CollectionsKt___CollectionsKt.F0(listCombineAndRetrieveData, i11));
            }
            WrapperAdListener wrapperAdListener = this.mCallback;
            if (wrapperAdListener != null) {
                wrapperAdListener.onWrapperIconReady(listCombineAndRetrieveData);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public static /* synthetic */ void assemblyData$default(WrapperIconAdManager wrapperIconAdManager, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        wrapperIconAdManager.assemblyData(str);
    }

    private final List<WrapperIconBean> combineAndRetrieveData(boolean z11) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            if (!(!this.temporaryStorageHi.isEmpty()) && !(!this.temporaryStoragePs.isEmpty())) {
                return arrayList;
            }
            int i12 = i11 % 2;
            if (!z11 ? i12 == 1 : i12 == 0) {
                if (!this.temporaryStoragePs.isEmpty()) {
                    arrayList.add(getPs());
                } else if (!this.temporaryStorageHi.isEmpty()) {
                    arrayList.add(getHi());
                }
            } else if (!this.temporaryStorageHi.isEmpty()) {
                arrayList.add(getHi());
            } else if (!this.temporaryStoragePs.isEmpty()) {
                arrayList.add(getPs());
            }
            i11++;
        }
    }

    public static /* synthetic */ List combineAndRetrieveData$default(WrapperIconAdManager wrapperIconAdManager, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return wrapperIconAdManager.combineAndRetrieveData(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayRunnable$lambda$0(WrapperIconAdManager this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.assemblyData("竞价时间到");
        this$0.isLoading.set(false);
    }

    private final int getBindingTime() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b(getSceneId());
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("bindingTime")) == null) {
            return 2;
        }
        return jsonElement.getAsInt();
    }

    private final String getClassTag() {
        String simpleName = WrapperIconAdManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final WrapperIconBean getHi() {
        return new WrapperIconBean(2, null, this.temporaryStorageHi.remove(0));
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler$delegate.getValue();
    }

    private final WrapperIconBean getPs() {
        return new WrapperIconBean(1, this.temporaryStoragePs.remove(0), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object innerLoadAd(String str, boolean z11, Continuation<? super Unit> continuation) throws Throwable {
        C19851 c19851;
        WrapperIconAdManager wrapperIconAdManager;
        if (continuation instanceof C19851) {
            c19851 = (C19851) continuation;
            int i11 = c19851.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c19851.label = i11 - Integer.MIN_VALUE;
            } else {
                c19851 = new C19851(continuation);
            }
        } else {
            c19851 = new C19851(continuation);
        }
        C19851 c19852 = c19851;
        Object obj = c19852.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = c19852.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            wq.c cVar = wq.c.f79583a;
            if (!TextUtils.isEmpty(cVar.d(str))) {
                return Unit.f68710a;
            }
            com.transsion.ad.a.f50276a.A(getClassTag() + " --> innerLoadAd() --> 开始加载广告 --> sceneId = " + str, false);
            if (!cVar.a(str)) {
                if (this.adManager == null) {
                    HiSavanaIconAdManager hiSavanaIconAdManager = new HiSavanaIconAdManager();
                    this.adManager = hiSavanaIconAdManager;
                    hiSavanaIconAdManager.setSceneId(str);
                    HiSavanaIconAdManager hiSavanaIconAdManager2 = this.adManager;
                    if (hiSavanaIconAdManager2 != null) {
                        hiSavanaIconAdManager2.setListener(this);
                    }
                }
                HiSavanaIconAdManager hiSavanaIconAdManager3 = this.adManager;
                if (hiSavanaIconAdManager3 != null) {
                    hiSavanaIconAdManager3.loadAd();
                }
            }
            if (!cVar.b(str)) {
                if (this.pSDistribution == null) {
                    PSDistributionProvider pSDistributionProvider = new PSDistributionProvider();
                    this.pSDistribution = pSDistributionProvider;
                    pSDistributionProvider.setListener(this);
                    PSDistributionProvider pSDistributionProvider2 = this.pSDistribution;
                    if (pSDistributionProvider2 != null) {
                        pSDistributionProvider2.setFilteringInstalled(z11);
                    }
                }
                PSDistributionProvider pSDistributionProvider3 = this.pSDistribution;
                if (pSDistributionProvider3 != null) {
                    c19852.L$0 = this;
                    c19852.label = 1;
                    if (PSDistributionProvider.loadAd$default(pSDistributionProvider3, 0, false, str, null, c19852, 11, null) == objE) {
                        return objE;
                    }
                }
            }
            wrapperIconAdManager = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            wrapperIconAdManager = (WrapperIconAdManager) c19852.L$0;
            ResultKt.b(obj);
        }
        wrapperIconAdManager.getMHandler().postDelayed(wrapperIconAdManager.delayRunnable, ((long) wrapperIconAdManager.getBindingTime()) * 1000);
        return Unit.f68710a;
    }

    private final boolean isHiPriority() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b(getSceneId());
        String asString = (jsonObjectB == null || (jsonElement = jsonObjectB.get(TrackingKey.PRIORITY)) == null) ? null : jsonElement.getAsString();
        if (asString == null) {
            asString = "hi";
        }
        return TextUtils.equals(asString, "hi");
    }

    private final void onFailCallback(WrapperAdListener wrapperAdListener, String str) {
        com.transsion.ad.a.D(com.transsion.ad.a.f50276a, str, false, 2, null);
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(new TAdErrorCode(101, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHiIconAdReady$lambda$4(WrapperIconAdManager this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.assemblyData("数据都回来了 --> onHiIconAdReady");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPSDistributionReady$lambda$2(WrapperIconAdManager this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.assemblyData("数据都回来了 --> onPSDistributionReady");
    }

    public final void bindHiIconView(com.transsion.ad.middle.nativead.a aVar, TAdNativeView tAdNativeView, Context context, TAdNativeInfo tAdNativeInfo) throws InterruptedException {
        ViewBinder viewBinderP;
        HiSavanaIconAdManager hiSavanaIconAdManager;
        TNativeAd nativeAd;
        if (tAdNativeInfo != null && aVar != null && (viewBinderP = aVar.p(aVar.f(context), tAdNativeInfo)) != null && tAdNativeView != null && (hiSavanaIconAdManager = this.adManager) != null && (nativeAd = hiSavanaIconAdManager.getNativeAd()) != null) {
            nativeAd.bindNativeView(tAdNativeView, tAdNativeInfo, viewBinderP);
        }
        this.tAdNativeViewSet.add(tAdNativeView);
        this.tAdNativeInfoSet.add(tAdNativeInfo);
        i.b(null, new AnonymousClass2(aVar, this, context, null), 1, null);
    }

    public final void bindPsIconView(RecommendInfo recommendInfo, com.transsion.ad.middle.nativead.a aVar, BuyOutIconView buyOutIconView, Context context) {
        if (buyOutIconView != null) {
            buyOutIconView.setCallback(this);
        }
        if (buyOutIconView != null) {
            buyOutIconView.setSceneId(getSceneId());
        }
        if (buyOutIconView != null) {
            buyOutIconView.bindNativeView(recommendInfo, aVar != null ? aVar.f(context) : null);
        }
        this.buyOutIconViewSet.add(buyOutIconView);
    }

    public final void clickAd() throws InterruptedException {
        com.transsion.ad.a.D(com.transsion.ad.a.f50276a, getClassTag() + " --> clickAd() --> 模拟点击广告", false, 2, null);
        i.b(null, new AnonymousClass1(null), 1, null);
        i.b(null, new C19842(null), 1, null);
    }

    public final void destroy() {
        getMHandler().removeCallbacksAndMessages(null);
        this.mCallback = null;
        this.temporaryStorageHi.clear();
        this.temporaryStoragePs.clear();
        PSDistributionProvider pSDistributionProvider = this.pSDistribution;
        if (pSDistributionProvider != null) {
            pSDistributionProvider.destroy();
        }
        for (BuyOutIconView buyOutIconView : this.buyOutIconViewSet) {
            if (buyOutIconView != null) {
                buyOutIconView.destroy();
            }
        }
        for (TAdNativeView tAdNativeView : this.tAdNativeViewSet) {
            if (tAdNativeView != null) {
                tAdNativeView.release();
            }
        }
        for (TAdNativeInfo tAdNativeInfo : this.tAdNativeInfoSet) {
            if (tAdNativeInfo != null) {
                tAdNativeInfo.release();
            }
        }
    }

    public final String getSceneId() {
        return this.mSceneId;
    }

    public final Object loadIconAd(String str, boolean z11, int i11, WrapperAdListener wrapperAdListener, Continuation<? super Unit> continuation) throws Throwable {
        String strD = wq.c.f79583a.d(str);
        if (!TextUtils.isEmpty(strD)) {
            onFailCallback(wrapperAdListener, strD);
            return Unit.f68710a;
        }
        if (this.isLoading.get()) {
            return Unit.f68710a;
        }
        this.isLoading.set(true);
        this.mCallback = wrapperAdListener;
        this.mSceneId = str;
        this.targetNum = i11;
        Object objInnerLoadAd = innerLoadAd(str, z11, continuation);
        return objInnerLoadAd == kotlin.coroutines.intrinsics.a.e() ? objInnerLoadAd : Unit.f68710a;
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        super.onClicked(i11);
        vq.b.f79053a.a((128 & 1) != 0 ? "" : "", getSceneId(), "", Integer.valueOf(i11), "", 6, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        WrapperAdListener wrapperAdListener = this.mCallback;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(Worker.WHAT_SYNC_DATA);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        super.onError(tAdErrorCode);
        com.transsion.ad.a.B(com.transsion.ad.a.f50276a, getClassTag() + " --> onError() --> p0 = " + tAdErrorCode + " --> mSceneId = " + getSceneId(), false, 2, null);
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onHiIconAdReady(List<TAdNativeInfo> tAdNativeInfos) {
        Intrinsics.g(tAdNativeInfos, "tAdNativeInfos");
        super.onHiIconAdReady(tAdNativeInfos);
        com.transsion.ad.a.B(com.transsion.ad.a.f50276a, getClassTag() + " --> onIconAdReady() --> mSceneId = " + getSceneId() + " --> tAdNativeInfos.size =  = " + tAdNativeInfos.size(), false, 2, null);
        this.temporaryStorageHi.clear();
        this.temporaryStorageHi.addAll(tAdNativeInfos);
        if (!this.temporaryStoragePs.isEmpty()) {
            getMHandler().post(new Runnable() { // from class: com.transsion.ad.middle.icon.d
                @Override // java.lang.Runnable
                public final void run() {
                    WrapperIconAdManager.onHiIconAdReady$lambda$4(this.f50429a);
                }
            });
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onMbIconClick(RecommendInfo recommendInfo) {
        super.onMbIconClick(recommendInfo);
        vq.b.f79053a.a((128 & 1) != 0 ? "" : "", getSceneId(), "", 102, "", 6, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        WrapperAdListener wrapperAdListener = this.mCallback;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(102);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onMbIconShow(RecommendInfo recommendInfo) {
        super.onMbIconShow(recommendInfo);
        vq.b.f79053a.f((128 & 1) != 0 ? "" : "", getSceneId(), "", 102, "", 6, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onPSDistributionReady(List<RecommendInfo> list) {
        super.onPSDistributionReady(list);
        com.transsion.ad.a.B(com.transsion.ad.a.f50276a, getClassTag() + " --> onPSDistributionReady() --> mSceneId = " + getSceneId() + " --> data.size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 2, null);
        this.temporaryStoragePs.clear();
        if (list != null) {
            this.temporaryStoragePs.addAll(list);
        }
        if (!this.temporaryStorageHi.isEmpty()) {
            getMHandler().post(new Runnable() { // from class: com.transsion.ad.middle.icon.e
                @Override // java.lang.Runnable
                public final void run() {
                    WrapperIconAdManager.onPSDistributionReady$lambda$2(this.f50430a);
                }
            });
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
        super.onShow(i11);
        vq.b.f79053a.f((128 & 1) != 0 ? "" : "", getSceneId(), "", Integer.valueOf(i11), "", 6, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
    }
}
