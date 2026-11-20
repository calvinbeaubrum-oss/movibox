package com.transsion.ad.middle.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import wq.c;

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
public final class WrapperBanner extends WrapperAdListener {
    private HiSavanaBannerProvider hiSavanaBanner;
    private boolean isMute;
    private AdPlans mAdPlans;
    private AdPlans mAdShowFinalPlan;
    private Context mContext;
    private WrapperAdListener mListener;
    private String mSceneId = "";
    private NonBannerView nonBannerView;

    /* JADX INFO: renamed from: com.transsion.ad.middle.banner.WrapperBanner$innerLoadAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.banner.WrapperBanner", f = "WrapperBanner.kt", l = {122, 127}, m = "innerLoadAd")
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return WrapperBanner.this.innerLoadAd(null, null, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.banner.WrapperBanner$innerLoadAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.banner.WrapperBanner$innerLoadAd$2", f = "WrapperBanner.kt", l = {123}, m = "invokeSuspend")
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

    /* JADX INFO: renamed from: com.transsion.ad.middle.banner.WrapperBanner$innerLoadAd$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.banner.WrapperBanner$innerLoadAd$3", f = "WrapperBanner.kt", l = {128}, m = "invokeSuspend")
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

    private final String getClassTag() {
        String simpleName = WrapperBanner.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object innerLoadAd(String str, Context context, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map, int i11, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        WrapperBanner wrapperBanner;
        Object obj;
        WrapperBanner wrapperBanner2;
        String str2;
        int i12;
        Map<String, ? extends Object> map2;
        String str3;
        WrapperBanner wrapperBanner3;
        WrapperBanner wrapperBanner4;
        AdPlans adPlans;
        int i13;
        Map<String, ? extends Object> map3 = map;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i14 = anonymousClass1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i14 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objG = anonymousClass1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i15 = anonymousClass1.label;
        if (i15 != 0) {
            if (i15 == 1) {
                i12 = anonymousClass1.I$0;
                WrapperBanner wrapperBanner5 = (WrapperBanner) anonymousClass1.L$3;
                Map<String, ? extends Object> map4 = (Map) anonymousClass1.L$2;
                str2 = (String) anonymousClass1.L$1;
                wrapperBanner = (WrapperBanner) anonymousClass1.L$0;
                ResultKt.b(objG);
                wrapperBanner2 = wrapperBanner5;
                map3 = map4;
                obj = objG;
            } else {
                if (i15 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i12 = anonymousClass1.I$0;
                wrapperBanner3 = (WrapperBanner) anonymousClass1.L$3;
                map2 = (Map) anonymousClass1.L$2;
                str3 = (String) anonymousClass1.L$1;
                wrapperBanner4 = (WrapperBanner) anonymousClass1.L$0;
                ResultKt.b(objG);
            }
            wrapperBanner3.mAdShowFinalPlan = (AdPlans) objG;
            vq.b bVar = vq.b.f79053a;
            adPlans = wrapperBanner4.mAdPlans;
            if (adPlans == null) {
                i13 = 2;
            } else {
                i13 = 1;
            }
            vq.b.m(bVar, null, str3, 1, i13, adPlans != null ? adPlans.getId() : null, 1, null);
            if (wrapperBanner4.mAdPlans == null && !c.f79583a.b(str3)) {
                wrapperBanner4.loadNonBannerAd(wrapperBanner4.mAdPlans, str3);
            } else {
                wrapperBanner4.innerLoadHiSavanaAd(str3, map2, i12);
            }
            return Unit.f68710a;
        }
        ResultKt.b(objG);
        this.mSceneId = str;
        this.mListener = wrapperAdListener;
        this.mContext = context;
        CoroutineDispatcher coroutineDispatcherB = w0.b();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, map3, null);
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = str;
        anonymousClass1.L$2 = map3;
        anonymousClass1.L$3 = this;
        anonymousClass1.I$0 = i11;
        anonymousClass1.label = 1;
        Object objG2 = h.g(coroutineDispatcherB, anonymousClass2, anonymousClass1);
        if (objG2 == objE) {
            return objE;
        }
        wrapperBanner = this;
        obj = objG2;
        wrapperBanner2 = wrapperBanner;
        str2 = str;
        i12 = i11;
        wrapperBanner2.mAdPlans = (AdPlans) obj;
        CoroutineDispatcher coroutineDispatcherB2 = w0.b();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(str2, map3, null);
        anonymousClass1.L$0 = wrapperBanner;
        anonymousClass1.L$1 = str2;
        anonymousClass1.L$2 = map3;
        anonymousClass1.L$3 = wrapperBanner;
        anonymousClass1.I$0 = i12;
        anonymousClass1.label = 2;
        objG = h.g(coroutineDispatcherB2, anonymousClass3, anonymousClass1);
        if (objG == objE) {
            return objE;
        }
        map2 = map3;
        str3 = str2;
        wrapperBanner3 = wrapperBanner;
        wrapperBanner4 = wrapperBanner3;
        wrapperBanner3.mAdShowFinalPlan = (AdPlans) objG;
        vq.b bVar2 = vq.b.f79053a;
        adPlans = wrapperBanner4.mAdPlans;
        if (adPlans == null) {
            i13 = 2;
        } else {
            i13 = 1;
        }
        vq.b.m(bVar2, null, str3, 1, i13, adPlans != null ? adPlans.getId() : null, 1, null);
        if (wrapperBanner4.mAdPlans == null) {
            wrapperBanner4.innerLoadHiSavanaAd(str3, map2, i12);
        } else {
            wrapperBanner4.loadNonBannerAd(wrapperBanner4.mAdPlans, str3);
        }
        return Unit.f68710a;
    }

    private final void innerLoadAdShowFinal() {
        AdPlans adPlans = this.mAdShowFinalPlan;
        if (adPlans != null) {
            loadNonBannerAd(adPlans, this.mSceneId);
            return;
        }
        onFailCallback(this.mListener, getClassTag() + " --> innerLoadAdShowFinal() --> 当前没有兜底广告 --> sceneId = " + this.mSceneId);
    }

    private final void innerLoadHiSavanaAd(String str, Map<String, ? extends Object> map, int i11) {
        if (c.f79583a.a(str)) {
            innerLoadAdShowFinal();
            return;
        }
        if (this.hiSavanaBanner == null) {
            this.hiSavanaBanner = new HiSavanaBannerProvider(str, i11);
        }
        HiSavanaBannerProvider hiSavanaBannerProvider = this.hiSavanaBanner;
        if (hiSavanaBannerProvider != null) {
            hiSavanaBannerProvider.loadAd(this, map);
        }
    }

    private final void loadNonBannerAd(AdPlans adPlans, String str) {
        Unit unit;
        Context context = this.mContext;
        if (context != null) {
            NonBannerView nonBannerView = new NonBannerView(context);
            this.nonBannerView = nonBannerView;
            nonBannerView.loadAd(str, adPlans, this, this.isMute);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            onFailCallback(this.mListener, "mContext == null");
        }
    }

    private final void onFailCallback(WrapperAdListener wrapperAdListener, String str) {
        com.transsion.ad.a.P(com.transsion.ad.a.f50276a, str, false, 2, null);
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(new TAdErrorCode(101, str));
        }
    }

    public final void destroy() {
        this.mListener = null;
        HiSavanaBannerProvider hiSavanaBannerProvider = this.hiSavanaBanner;
        if (hiSavanaBannerProvider != null) {
            hiSavanaBannerProvider.destroy();
        }
        this.hiSavanaBanner = null;
        NonBannerView nonBannerView = this.nonBannerView;
        if (nonBannerView != null) {
            nonBannerView.destroy();
        }
        this.nonBannerView = null;
        this.mContext = null;
        com.transsion.ad.a.f50276a.u(getClassTag() + " --> destroy() --> sceneId = " + this.mSceneId, false);
    }

    public final Object loadBannerAd(String str, Context context, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map, boolean z11, int i11, Continuation<? super Unit> continuation) throws Throwable {
        this.isMute = z11;
        String strD = c.f79583a.d(str);
        if (TextUtils.isEmpty(strD)) {
            Object objInnerLoadAd = innerLoadAd(str, context, wrapperAdListener, map, i11, continuation);
            return objInnerLoadAd == kotlin.coroutines.intrinsics.a.e() ? objInnerLoadAd : Unit.f68710a;
        }
        onFailCallback(wrapperAdListener, strD);
        return Unit.f68710a;
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onBannerViewReady(View view) {
        super.onBannerViewReady(view);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onBannerViewReady(view);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        super.onError(tAdErrorCode);
        com.transsion.ad.a.x(com.transsion.ad.a.f50276a, getClassTag() + " --> onError() --> Hi Banner 加载失败 --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null) + " --> 继续加载兜底广告", false, 2, null);
        innerLoadAdShowFinal();
    }
}
