package com.transsion.ad.middle.nativead;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TAdNativeView;
import com.hisavana.mediation.ad.TNativeAd;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import xq.l;

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
@Deprecated
@Metadata
public final class WrapperNativeManager extends WrapperAdListener implements Parcelable {
    public static final Parcelable.Creator<WrapperNativeManager> CREATOR = new a();
    private BuyOutNativeView buyOutNativeView;
    private Map<String, ? extends Object> ctxMap = new LinkedHashMap();
    private Boolean enableBgBlur;
    private FrameLayout mAdContainer;
    private AdPlans mAdPlans;
    private AdPlans mAdShowFinalPlan;
    private WrapperAdListener mCallback;
    private TAdNativeInfo mNativeInfo;
    private AdPlans mNonAdPlans;
    private String mSceneId;
    private TAdNativeView mTAdNativeView;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<WrapperNativeManager> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WrapperNativeManager createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            parcel.readInt();
            return new WrapperNativeManager();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WrapperNativeManager[] newArray(int i11) {
            return new WrapperNativeManager[i11];
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.nativead.WrapperNativeManager$innerLoadAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.nativead.WrapperNativeManager", f = "WrapperNativeManager.kt", l = {230, 235}, m = "innerLoadAd")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WrapperNativeManager.this.innerLoadAd(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.nativead.WrapperNativeManager$innerLoadAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.nativead.WrapperNativeManager$innerLoadAd$2", f = "WrapperNativeManager.kt", l = {231}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super AdPlans>, Object> {
        final /* synthetic */ Map<String, Object> $ctxMap;
        final /* synthetic */ String $sceneId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Map<String, ? extends Object> map, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$sceneId = str;
            this.$ctxMap = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$sceneId, this.$ctxMap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super AdPlans> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
                String str = this.$sceneId;
                Map<String, Object> map = this.$ctxMap;
                this.label = 1;
                obj = AdPlansStorageManager.d(adPlansStorageManager, str, null, map, this, 2, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.nativead.WrapperNativeManager$innerLoadAd$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.nativead.WrapperNativeManager$innerLoadAd$3", f = "WrapperNativeManager.kt", l = {236}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<k0, Continuation<? super AdPlans>, Object> {
        final /* synthetic */ Map<String, Object> $ctxMap;
        final /* synthetic */ String $sceneId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Map<String, ? extends Object> map, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$sceneId = str;
            this.$ctxMap = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$sceneId, this.$ctxMap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super AdPlans> continuation) {
            return ((AnonymousClass3) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
                String str = this.$sceneId;
                Map<String, ? extends Object> map = this.$ctxMap;
                this.label = 1;
                obj = adPlansStorageManager.c(str, "AdShowFinal", map, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    private static /* synthetic */ void getBuyOutNativeView$annotations() {
    }

    private final String getClassTag() {
        String simpleName = WrapperNativeManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private static /* synthetic */ void getCtxMap$annotations() {
    }

    private static /* synthetic */ void getEnableBgBlur$annotations() {
    }

    private static /* synthetic */ void getMAdContainer$annotations() {
    }

    private static /* synthetic */ void getMAdPlans$annotations() {
    }

    private static /* synthetic */ void getMAdShowFinalPlan$annotations() {
    }

    private static /* synthetic */ void getMCallback$annotations() {
    }

    private static /* synthetic */ void getMNativeInfo$annotations() {
    }

    private static /* synthetic */ void getMNonAdPlans$annotations() {
    }

    private static /* synthetic */ void getMSceneId$annotations() {
    }

    private static /* synthetic */ void getMTAdNativeView$annotations() {
    }

    private final void innerAddViewShowAd(View view, FrameLayout frameLayout) {
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private final void innerAddViewShowAd(FrameLayout frameLayout, boolean z11, boolean z12, ViewBinder viewBinder) {
        this.mAdContainer = frameLayout;
        if (this.mNativeInfo == null) {
            innerShowNonNativeAd(frameLayout, z11, z12, viewBinder);
        } else {
            innerShowHiSavanaAd(frameLayout, viewBinder);
        }
    }

    private final void innerDestroy() {
        com.transsion.ad.a.f50276a.I(getClassTag() + " --> destroy() --> sceneId = " + this.mSceneId + " 场景资源回收了", false);
        HiSavanaNativeAdManager.a aVar = HiSavanaNativeAdManager.Companion;
        wq.a aVar2 = wq.a.f79581a;
        HiSavanaNativeAdManager hiSavanaNativeAdManagerB = aVar.b(aVar2.b(this.mSceneId));
        if (hiSavanaNativeAdManagerB != null) {
            hiSavanaNativeAdManagerB.removerCallback(this);
        }
        TAdNativeInfo tAdNativeInfo = this.mNativeInfo;
        if (tAdNativeInfo != null) {
            if (TextUtils.isEmpty(tAdNativeInfo != null ? tAdNativeInfo.getExt() : null)) {
                tAdNativeInfo.release();
            } else {
                HiSavanaNativeAdManager hiSavanaNativeAdManagerB2 = aVar.b(aVar2.b(this.mSceneId));
                if (hiSavanaNativeAdManagerB2 != null) {
                    hiSavanaNativeAdManagerB2.addUnusedAdToPool(tAdNativeInfo);
                }
            }
        }
        BuyOutNativeView buyOutNativeView = this.buyOutNativeView;
        if (buyOutNativeView != null) {
            buyOutNativeView.destroy();
        }
        this.buyOutNativeView = null;
        TAdNativeView tAdNativeView = this.mTAdNativeView;
        if (tAdNativeView != null) {
            tAdNativeView.release();
        }
        this.mTAdNativeView = null;
        FrameLayout frameLayout = this.mAdContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.mAdContainer = null;
        this.mCallback = null;
        this.mNativeInfo = null;
        this.mAdShowFinalPlan = null;
        this.mAdPlans = null;
        this.mNonAdPlans = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:27:0x00df  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object innerLoadAd(String str, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        WrapperNativeManager wrapperNativeManager;
        Object obj;
        WrapperNativeManager wrapperNativeManager2;
        String str2;
        WrapperNativeManager wrapperNativeManager3;
        WrapperNativeManager wrapperNativeManager4;
        AdPlans adPlans;
        int i11;
        String str3 = str;
        Map<String, ? extends Object> map2 = map;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i12 = anonymousClass1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i12 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objG = anonymousClass1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = anonymousClass1.label;
        if (i13 != 0) {
            if (i13 == 1) {
                WrapperNativeManager wrapperNativeManager5 = (WrapperNativeManager) anonymousClass1.L$3;
                map2 = (Map) anonymousClass1.L$2;
                String str4 = (String) anonymousClass1.L$1;
                wrapperNativeManager = (WrapperNativeManager) anonymousClass1.L$0;
                ResultKt.b(objG);
                wrapperNativeManager2 = wrapperNativeManager5;
                str3 = str4;
                obj = objG;
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wrapperNativeManager3 = (WrapperNativeManager) anonymousClass1.L$2;
                str2 = (String) anonymousClass1.L$1;
                wrapperNativeManager4 = (WrapperNativeManager) anonymousClass1.L$0;
                ResultKt.b(objG);
            }
            wrapperNativeManager3.mAdShowFinalPlan = (AdPlans) objG;
            vq.b bVar = vq.b.f79053a;
            adPlans = wrapperNativeManager4.mAdPlans;
            if (adPlans == null) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            vq.b.m(bVar, null, str2, 2, i11, adPlans != null ? adPlans.getId() : null, 1, null);
            if (wrapperNativeManager4.mAdPlans == null && !wq.c.f79583a.b(str2)) {
                wrapperNativeManager4.innerLoadAdPlan();
            } else {
                wrapperNativeManager4.innerLoadHiSavanaAd(str2);
            }
            return Unit.f68710a;
        }
        ResultKt.b(objG);
        com.transsion.ad.a.f50276a.I(getClassTag() + " --> loadNativeAd() --> 开始加载广告 --> sceneId = " + str3 + " --> ctxMap = " + map2, false);
        this.mCallback = wrapperAdListener;
        this.mSceneId = str3;
        CoroutineDispatcher coroutineDispatcherB = w0.b();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(str3, map2, null);
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = str3;
        anonymousClass1.L$2 = map2;
        anonymousClass1.L$3 = this;
        anonymousClass1.label = 1;
        Object objG2 = h.g(coroutineDispatcherB, anonymousClass2, anonymousClass1);
        if (objG2 == objE) {
            return objE;
        }
        wrapperNativeManager = this;
        obj = objG2;
        wrapperNativeManager2 = wrapperNativeManager;
        wrapperNativeManager2.mAdPlans = (AdPlans) obj;
        CoroutineDispatcher coroutineDispatcherB2 = w0.b();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(str3, map2, null);
        anonymousClass1.L$0 = wrapperNativeManager;
        anonymousClass1.L$1 = str3;
        anonymousClass1.L$2 = wrapperNativeManager;
        anonymousClass1.L$3 = null;
        anonymousClass1.label = 2;
        objG = h.g(coroutineDispatcherB2, anonymousClass3, anonymousClass1);
        if (objG == objE) {
            return objE;
        }
        str2 = str3;
        wrapperNativeManager3 = wrapperNativeManager;
        wrapperNativeManager4 = wrapperNativeManager3;
        wrapperNativeManager3.mAdShowFinalPlan = (AdPlans) objG;
        vq.b bVar2 = vq.b.f79053a;
        adPlans = wrapperNativeManager4.mAdPlans;
        if (adPlans == null) {
            i11 = 2;
        } else {
            i11 = 1;
        }
        vq.b.m(bVar2, null, str2, 2, i11, adPlans != null ? adPlans.getId() : null, 1, null);
        if (wrapperNativeManager4.mAdPlans == null) {
            wrapperNativeManager4.innerLoadHiSavanaAd(str2);
        } else {
            wrapperNativeManager4.innerLoadAdPlan();
        }
        return Unit.f68710a;
    }

    private final void innerLoadAdPlan() {
        com.transsion.ad.a.f50276a.I(getClassTag() + " --> innerLoadAdPlan() --> 包断广告可以使用 --> sceneId = " + this.mSceneId, false);
        onNonNativeReady(this.mAdPlans);
    }

    private final void innerLoadAdShowFinal() {
        if (this.mAdShowFinalPlan != null) {
            com.transsion.ad.a.f50276a.I(getClassTag() + " --> innerLoadAdShowFinal() --> 当前有兜底广告可用 --> sceneId = " + this.mSceneId, false);
            onNonNativeReady(this.mAdShowFinalPlan);
            return;
        }
        com.transsion.ad.a.f50276a.I(getClassTag() + " --> innerLoadAdShowFinal() --> 当前没有兜底广告 --> sceneId = " + this.mSceneId, false);
        WrapperAdListener wrapperAdListener = this.mCallback;
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(new TAdErrorCode(101, "没有兜底广告 --> sceneId = " + this.mSceneId));
        }
    }

    private final void innerLoadHiSavanaAd(String str) {
        Unit unit;
        if (wq.c.f79583a.a(str)) {
            innerLoadAdShowFinal();
            return;
        }
        HiSavanaNativeAdManager hiSavanaNativeAdManagerB = HiSavanaNativeAdManager.Companion.b(wq.a.f79581a.b(this.mSceneId));
        if (hiSavanaNativeAdManagerB != null) {
            hiSavanaNativeAdManagerB.addCallback(this, this.mSceneId);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            innerLoadAdShowFinal();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    private final void innerShowHiSavanaAd(FrameLayout frameLayout, ViewBinder viewBinder) {
        TNativeAd nativeAd;
        Unit unit;
        HiSavanaNativeAdManager hiSavanaNativeAdManagerB = HiSavanaNativeAdManager.Companion.b(wq.a.f79581a.b(this.mSceneId));
        if (hiSavanaNativeAdManagerB == null || (nativeAd = hiSavanaNativeAdManagerB.getNativeAd()) == null) {
            return;
        }
        TAdNativeInfo tAdNativeInfo = this.mNativeInfo;
        if (tAdNativeInfo == null || viewBinder == null) {
            unit = null;
        } else {
            TAdNativeView tAdNativeView = this.mTAdNativeView;
            if (tAdNativeView == null) {
                this.mTAdNativeView = new TAdNativeView(Utils.a());
            } else {
                if (tAdNativeView != null) {
                    tAdNativeView.removeAllViews();
                }
                l.f80683a.b(this.mTAdNativeView);
            }
            TAdNativeView tAdNativeView2 = this.mTAdNativeView;
            if (tAdNativeView2 != null) {
                nativeAd.bindNativeView(tAdNativeView2, tAdNativeInfo, viewBinder, nativeAd.enterScene(this.mSceneId, 1));
                tAdNativeInfo.setSceneId(TextUtils.isEmpty(this.mSceneId) ? "tag_mSceneId" : this.mSceneId);
                innerAddViewShowAd(tAdNativeView2, frameLayout);
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
        }
        if (unit == null) {
            com.transsion.ad.a.J(com.transsion.ad.a.f50276a, getClassTag() + " --> bindNativeView() --> sceneId = " + this.mSceneId + " 场景接受到回调了 --> null == mNativeInfo", false, 2, null);
        }
    }

    private final void innerShowNonNativeAd(FrameLayout frameLayout, boolean z11, boolean z12, ViewBinder viewBinder) {
        BuyOutNativeView buyOutNativeView = this.buyOutNativeView;
        if (buyOutNativeView == null) {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            BuyOutNativeView buyOutNativeView2 = new BuyOutNativeView(applicationA);
            this.buyOutNativeView = buyOutNativeView2;
            buyOutNativeView2.enableBgBlur(this.enableBgBlur);
            BuyOutNativeView buyOutNativeView3 = this.buyOutNativeView;
            if (buyOutNativeView3 != null) {
                buyOutNativeView3.setCallback(this);
            }
        } else {
            if (buyOutNativeView != null) {
                buyOutNativeView.removeAllViews();
            }
            l.f80683a.b(this.buyOutNativeView);
        }
        BuyOutNativeView buyOutNativeView4 = this.buyOutNativeView;
        if (buyOutNativeView4 != null) {
            buyOutNativeView4.bindNativeView(this.mSceneId, this.mNonAdPlans, viewBinder, z11, z12);
        }
        innerAddViewShowAd(this.buyOutNativeView, frameLayout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object loadNativeAd$default(WrapperNativeManager wrapperNativeManager, String str, WrapperAdListener wrapperAdListener, Map map, Continuation continuation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = s.h();
        }
        return wrapperNativeManager.loadNativeAd(str, wrapperAdListener, map, continuation);
    }

    private final void onFailCallback(WrapperAdListener wrapperAdListener, String str) {
        com.transsion.ad.a.P(com.transsion.ad.a.f50276a, str, false, 2, null);
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(new TAdErrorCode(101, str));
        }
    }

    private final void onNonNativeReady(AdPlans adPlans) {
        this.mNonAdPlans = adPlans;
        WrapperAdListener wrapperAdListener = this.mCallback;
        if (wrapperAdListener != null) {
            wrapperAdListener.onLoad();
        }
    }

    public static /* synthetic */ void showNativeAd$default(WrapperNativeManager wrapperNativeManager, FrameLayout frameLayout, boolean z11, boolean z12, ViewBinder viewBinder, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        wrapperNativeManager.showNativeAd(frameLayout, z11, z12, viewBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void destroy() {
        innerDestroy();
    }

    public final void enableBgBlur(boolean z11) {
        this.enableBgBlur = Boolean.valueOf(z11);
    }

    public final TAdNativeInfo getNativeInfo() {
        return this.mNativeInfo;
    }

    public final String getSceneId() {
        return this.mSceneId;
    }

    public final boolean isMonopolyAd() {
        return this.mNativeInfo == null;
    }

    public final boolean isReady() {
        return (this.mAdPlans == null && this.mNativeInfo == null) ? false : true;
    }

    public final Object loadNativeAd(String str, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map, Continuation<? super Unit> continuation) throws Throwable {
        String strD = wq.c.f79583a.d(str);
        if (!TextUtils.isEmpty(strD)) {
            onFailCallback(wrapperAdListener, strD);
            return Unit.f68710a;
        }
        this.ctxMap = map;
        Object objInnerLoadAd = innerLoadAd(str, wrapperAdListener, map, continuation);
        return objInnerLoadAd == kotlin.coroutines.intrinsics.a.e() ? objInnerLoadAd : Unit.f68710a;
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        super.onClicked(i11);
        WrapperAdListener wrapperAdListener = this.mCallback;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(i11);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        super.onError(tAdErrorCode);
        innerLoadAdShowFinal();
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onNativeInfoReady(TAdNativeInfo tAdNativeInfo) {
        super.onNativeInfoReady(tAdNativeInfo);
        com.transsion.ad.strategy.b bVar = com.transsion.ad.strategy.b.f50584a;
        String strB = bVar.b();
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String simpleName = WrapperNativeManager.class.getSimpleName();
        boolean z11 = tAdNativeInfo != null && tAdNativeInfo.isMatchVulgarBrand();
        aVar.I(simpleName + " --> onNativeInfoReady() --> HiSavana 广告准备完成 --> isMatchVulgarBrand = " + z11 + " --> genre = " + strB + " -- ctxMap = " + this.ctxMap, false);
        if (tAdNativeInfo == null || !tAdNativeInfo.isMatchVulgarBrand() || !bVar.d(this.ctxMap)) {
            if (tAdNativeInfo != null) {
                tAdNativeInfo.setExt(this.mSceneId);
            }
            this.mNativeInfo = tAdNativeInfo;
            WrapperAdListener wrapperAdListener = this.mCallback;
            if (wrapperAdListener != null) {
                wrapperAdListener.onLoad();
                return;
            }
            return;
        }
        onError(null);
        HiSavanaNativeAdManager hiSavanaNativeAdManagerB = HiSavanaNativeAdManager.Companion.b(wq.a.f79581a.b(this.mSceneId));
        if (hiSavanaNativeAdManagerB != null) {
            hiSavanaNativeAdManagerB.addUnusedAdToPoolLast(tAdNativeInfo);
        }
        com.transsion.ad.a.L(aVar, getClassTag() + " --> 当前是品牌广告 -- 当前是限制场景 --> 需要屏蔽 --> 重新添加到缓存池中 --> genre = " + strB + " -- ctxMap = " + this.ctxMap, false, 2, null);
    }

    public final void showNativeAd(FrameLayout frameLayout, boolean z11, boolean z12, ViewBinder viewBinder) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            innerAddViewShowAd(frameLayout, z11, z12, viewBinder);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.ad.a.J(com.transsion.ad.a.f50276a, getClassTag() + " --> showNativeAd() --> 广告加载失败 --> it = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(1);
    }
}
