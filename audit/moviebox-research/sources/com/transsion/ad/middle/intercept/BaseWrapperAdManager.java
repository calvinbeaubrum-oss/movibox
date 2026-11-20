package com.transsion.ad.middle.intercept;

import android.text.TextUtils;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
public abstract class BaseWrapperAdManager extends WrapperAdListener {
    private boolean isShow;
    private AdPlans mAdPlans;
    private AdPlans mAdShowFinalPlan;
    private WrapperAdListener mListener;
    private String mSceneId;

    /* JADX INFO: renamed from: com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerLoadAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.intercept.BaseWrapperAdManager", f = "BaseWrapperAdManager.kt", l = {260, 265}, m = "innerLoadAd")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseWrapperAdManager.this.innerLoadAd(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerLoadAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerLoadAd$2", f = "BaseWrapperAdManager.kt", l = {261}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super AdPlans>, Object> {
        final /* synthetic */ String $sceneId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$sceneId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$sceneId, continuation);
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
                Map mapH = s.h();
                this.label = 1;
                obj = AdPlansStorageManager.d(adPlansStorageManager, str, null, mapH, this, 2, null);
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

    /* JADX INFO: renamed from: com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerLoadAd$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerLoadAd$3", f = "BaseWrapperAdManager.kt", l = {266}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<k0, Continuation<? super AdPlans>, Object> {
        final /* synthetic */ String $sceneId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$sceneId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$sceneId, continuation);
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
                Map<String, ? extends Object> mapH = s.h();
                this.label = 1;
                obj = adPlansStorageManager.c(str, "AdShowFinal", mapH, this);
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

    /* JADX INFO: renamed from: com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerShowAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.intercept.BaseWrapperAdManager", f = "BaseWrapperAdManager.kt", l = {361, 366}, m = "innerShowAd")
    public static final class C19861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C19861(Continuation<? super C19861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseWrapperAdManager.this.innerShowAd(null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerShowAd$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.intercept.BaseWrapperAdManager$innerShowAd$2", f = "BaseWrapperAdManager.kt", l = {367}, m = "invokeSuspend")
    public static final class C19872 extends SuspendLambda implements Function2<k0, Continuation<? super AdPlans>, Object> {
        final /* synthetic */ String $sceneId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C19872(String str, Continuation<? super C19872> continuation) {
            super(2, continuation);
            this.$sceneId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C19872(this.$sceneId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super AdPlans> continuation) {
            return ((C19872) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
                String str = this.$sceneId;
                Map<String, ? extends Object> mapH = s.h();
                this.label = 1;
                obj = adPlansStorageManager.c(str, "AdShowFinal", mapH, this);
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

    /* JADX INFO: renamed from: com.transsion.ad.middle.intercept.BaseWrapperAdManager$isAdPlansExist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.middle.intercept.BaseWrapperAdManager", f = "BaseWrapperAdManager.kt", l = {430}, m = "isAdPlansExist")
    public static final class C19881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C19881(Continuation<? super C19881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseWrapperAdManager.this.isAdPlansExist(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:31:0x00db  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object innerLoadAd(String str, WrapperAdListener wrapperAdListener, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        BaseWrapperAdManager baseWrapperAdManager;
        Object obj;
        BaseWrapperAdManager baseWrapperAdManager2;
        String str2;
        BaseWrapperAdManager baseWrapperAdManager3;
        BaseWrapperAdManager baseWrapperAdManager4;
        AdPlans adPlans;
        int i11;
        String str3 = str;
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
                BaseWrapperAdManager baseWrapperAdManager5 = (BaseWrapperAdManager) anonymousClass1.L$2;
                String str4 = (String) anonymousClass1.L$1;
                baseWrapperAdManager = (BaseWrapperAdManager) anonymousClass1.L$0;
                ResultKt.b(objG);
                baseWrapperAdManager2 = baseWrapperAdManager5;
                str3 = str4;
                obj = objG;
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseWrapperAdManager3 = (BaseWrapperAdManager) anonymousClass1.L$2;
                str2 = (String) anonymousClass1.L$1;
                baseWrapperAdManager4 = (BaseWrapperAdManager) anonymousClass1.L$0;
                ResultKt.b(objG);
            }
            baseWrapperAdManager3.mAdShowFinalPlan = (AdPlans) objG;
            if (baseWrapperAdManager4.mListener != null) {
                vq.b bVar = vq.b.f79053a;
                int adType = baseWrapperAdManager4.getAdType();
                adPlans = baseWrapperAdManager4.mAdPlans;
                if (adPlans == null) {
                    i11 = 2;
                } else {
                    i11 = 1;
                }
                vq.b.m(bVar, null, str2, adType, i11, adPlans != null ? adPlans.getId() : null, 1, null);
            }
            if (baseWrapperAdManager4.mAdPlans == null && !c.f79583a.b(str2)) {
                baseWrapperAdManager4.loadPlanAd(str2);
            } else {
                baseWrapperAdManager4.innerLoadHiSavanaAd(str2);
            }
            return Unit.f68710a;
        }
        ResultKt.b(objG);
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerLoadAd() --> sceneId = " + str3, false, 2, null);
        this.mSceneId = str3;
        this.mListener = wrapperAdListener;
        CoroutineDispatcher coroutineDispatcherB = w0.b();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(str3, null);
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = str3;
        anonymousClass1.L$2 = this;
        anonymousClass1.label = 1;
        Object objG2 = h.g(coroutineDispatcherB, anonymousClass2, anonymousClass1);
        if (objG2 == objE) {
            return objE;
        }
        baseWrapperAdManager = this;
        obj = objG2;
        baseWrapperAdManager2 = baseWrapperAdManager;
        baseWrapperAdManager2.mAdPlans = (AdPlans) obj;
        CoroutineDispatcher coroutineDispatcherB2 = w0.b();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(str3, null);
        anonymousClass1.L$0 = baseWrapperAdManager;
        anonymousClass1.L$1 = str3;
        anonymousClass1.L$2 = baseWrapperAdManager;
        anonymousClass1.label = 2;
        objG = h.g(coroutineDispatcherB2, anonymousClass3, anonymousClass1);
        if (objG == objE) {
            return objE;
        }
        str2 = str3;
        baseWrapperAdManager3 = baseWrapperAdManager;
        baseWrapperAdManager4 = baseWrapperAdManager3;
        baseWrapperAdManager3.mAdShowFinalPlan = (AdPlans) objG;
        if (baseWrapperAdManager4.mListener != null) {
            vq.b bVar2 = vq.b.f79053a;
            int adType2 = baseWrapperAdManager4.getAdType();
            adPlans = baseWrapperAdManager4.mAdPlans;
            if (adPlans == null) {
                i11 = 2;
            } else {
                i11 = 1;
            }
            vq.b.m(bVar2, null, str2, adType2, i11, adPlans != null ? adPlans.getId() : null, 1, null);
        }
        if (baseWrapperAdManager4.mAdPlans == null) {
            baseWrapperAdManager4.innerLoadHiSavanaAd(str2);
        } else {
            baseWrapperAdManager4.loadPlanAd(str2);
        }
        return Unit.f68710a;
    }

    private final void innerLoadHiSavanaAd(String str) {
        if (c.f79583a.a(str)) {
            loadAdShowFinal();
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerLoadHiSavanaAd() --> 加载HiSavana广告 --> sceneId = " + str, false, 2, null);
        if (this.mListener == null) {
            loadHiSavanaAd(str, null);
        } else {
            loadHiSavanaAd(str, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:31:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:33:0x0102  */
    /* JADX WARN: Code duplicated, block: B:35:0x0105  */
    /* JADX WARN: Code duplicated, block: B:36:0x0109  */
    /* JADX WARN: Code duplicated, block: B:38:0x0111  */
    /* JADX WARN: Code duplicated, block: B:39:0x0115  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0115, please report this as an issue */
    public final Object innerShowAd(String str, WrapperAdListener wrapperAdListener, boolean z11, Map<String, ? extends Object> map, Continuation<? super Unit> continuation) throws Throwable {
        C19861 c19861;
        boolean z12;
        Object obj;
        BaseWrapperAdManager baseWrapperAdManager;
        String str2;
        AdPlans adPlans;
        boolean z13;
        Map<String, ? extends Object> map2;
        BaseWrapperAdManager baseWrapperAdManager2;
        BaseWrapperAdManager baseWrapperAdManager3;
        String str3 = str;
        Map<String, ? extends Object> map3 = map;
        if (continuation instanceof C19861) {
            c19861 = (C19861) continuation;
            int i11 = c19861.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c19861.label = i11 - Integer.MIN_VALUE;
            } else {
                c19861 = new C19861(continuation);
            }
        } else {
            c19861 = new C19861(continuation);
        }
        Object obj2 = c19861.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = c19861.label;
        if (i12 != 0) {
            if (i12 == 1) {
                boolean z14 = c19861.Z$0;
                map3 = (Map) c19861.L$2;
                String str4 = (String) c19861.L$1;
                BaseWrapperAdManager baseWrapperAdManager4 = (BaseWrapperAdManager) c19861.L$0;
                ResultKt.b(obj2);
                z12 = z14;
                str3 = str4;
                obj = obj2;
                baseWrapperAdManager = baseWrapperAdManager4;
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z13 = c19861.Z$0;
                baseWrapperAdManager2 = (BaseWrapperAdManager) c19861.L$4;
                adPlans = (AdPlans) c19861.L$3;
                map2 = (Map) c19861.L$2;
                String str5 = (String) c19861.L$1;
                BaseWrapperAdManager baseWrapperAdManager5 = (BaseWrapperAdManager) c19861.L$0;
                ResultKt.b(obj2);
                str2 = str5;
                baseWrapperAdManager3 = baseWrapperAdManager5;
            }
            baseWrapperAdManager2.mAdShowFinalPlan = (AdPlans) obj2;
            if (z13) {
                vq.b.m(vq.b.f79053a, null, str2, baseWrapperAdManager3.getAdType(), adPlans != null ? 1 : 2, adPlans != null ? adPlans.getId() : null, 1, null);
            }
            if (adPlans == null) {
                baseWrapperAdManager3.innerShowHiSavanaAd(str2, baseWrapperAdManager3, map2);
            } else if (c.f79583a.b(str2)) {
                com.transsion.ad.a.f50276a.E(baseWrapperAdManager3.getClass().getSimpleName() + " --> innerShowAd() --> 非标广告场景关闭 --> 继续加载HiSavana广告 --> sceneId = " + str2, false);
                baseWrapperAdManager3.innerShowHiSavanaAd(str2, baseWrapperAdManager3, map2);
            } else {
                baseWrapperAdManager3.showMbAd(str2, adPlans, baseWrapperAdManager3);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj2);
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerShowAd() --> sceneId = " + str3, false, 2, null);
        this.mSceneId = str3;
        this.mListener = wrapperAdListener;
        CoroutineDispatcher coroutineDispatcherB = w0.b();
        BaseWrapperAdManager$innerShowAd$mAdPlans$1 baseWrapperAdManager$innerShowAd$mAdPlans$1 = new BaseWrapperAdManager$innerShowAd$mAdPlans$1(str3, map3, null);
        c19861.L$0 = this;
        c19861.L$1 = str3;
        c19861.L$2 = map3;
        z12 = z11;
        c19861.Z$0 = z12;
        c19861.label = 1;
        Object objG = h.g(coroutineDispatcherB, baseWrapperAdManager$innerShowAd$mAdPlans$1, c19861);
        if (objG == objE) {
            return objE;
        }
        obj = objG;
        baseWrapperAdManager = this;
        AdPlans adPlans2 = (AdPlans) obj;
        CoroutineDispatcher coroutineDispatcherB2 = w0.b();
        C19872 c19872 = new C19872(str3, null);
        c19861.L$0 = baseWrapperAdManager;
        c19861.L$1 = str3;
        c19861.L$2 = map3;
        c19861.L$3 = adPlans2;
        c19861.L$4 = baseWrapperAdManager;
        c19861.Z$0 = z12;
        c19861.label = 2;
        Object objG2 = h.g(coroutineDispatcherB2, c19872, c19861);
        if (objG2 == objE) {
            return objE;
        }
        str2 = str3;
        adPlans = adPlans2;
        z13 = z12;
        map2 = map3;
        baseWrapperAdManager2 = baseWrapperAdManager;
        obj2 = objG2;
        baseWrapperAdManager3 = baseWrapperAdManager2;
        baseWrapperAdManager2.mAdShowFinalPlan = (AdPlans) obj2;
        if (z13) {
            vq.b.m(vq.b.f79053a, null, str2, baseWrapperAdManager3.getAdType(), adPlans != null ? 1 : 2, adPlans != null ? adPlans.getId() : null, 1, null);
        }
        if (adPlans == null) {
            baseWrapperAdManager3.innerShowHiSavanaAd(str2, baseWrapperAdManager3, map2);
        } else if (c.f79583a.b(str2)) {
            baseWrapperAdManager3.showMbAd(str2, adPlans, baseWrapperAdManager3);
        } else {
            com.transsion.ad.a.f50276a.E(baseWrapperAdManager3.getClass().getSimpleName() + " --> innerShowAd() --> 非标广告场景关闭 --> 继续加载HiSavana广告 --> sceneId = " + str2, false);
            baseWrapperAdManager3.innerShowHiSavanaAd(str2, baseWrapperAdManager3, map2);
        }
        return Unit.f68710a;
    }

    private final void innerShowHiSavanaAd(String str, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map) {
        if (c.f79583a.a(str)) {
            showInnerAdShowFinal();
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerShowHiSavanaAd() --> 展示HiSavana广告 --> sceneId = " + str, false, 2, null);
        showHiSavanaAd(str, wrapperAdListener, map);
    }

    private final void onFailCallback(WrapperAdListener wrapperAdListener, String str) {
        com.transsion.ad.a.P(com.transsion.ad.a.f50276a, getClassTag() + " --> onFailCallback --> " + str, false, 2, null);
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(new TAdErrorCode(101, str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object showAd$default(BaseWrapperAdManager baseWrapperAdManager, String str, WrapperAdListener wrapperAdListener, boolean z11, Map map, Continuation continuation, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAd");
        }
        boolean z12 = (i11 & 4) != 0 ? false : z11;
        if ((i11 & 8) != 0) {
            map = s.h();
        }
        return baseWrapperAdManager.showAd(str, wrapperAdListener, z12, map, continuation);
    }

    public final void destroy() {
        onAdDestroy(this.mSceneId);
        this.mSceneId = null;
        this.mAdShowFinalPlan = null;
        this.mListener = null;
    }

    public abstract int getAdType();

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final WrapperAdListener getMListener() {
        return this.mListener;
    }

    public final String getMSceneId() {
        return this.mSceneId;
    }

    public abstract BaseNonAdManager getNonAdManager();

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object isAdPlansExist(String str, Map<String, ? extends Object> map, Continuation<? super Boolean> continuation) throws Throwable {
        C19881 c19881;
        if (continuation instanceof C19881) {
            c19881 = (C19881) continuation;
            int i11 = c19881.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c19881.label = i11 - Integer.MIN_VALUE;
            } else {
                c19881 = new C19881(continuation);
            }
        } else {
            c19881 = new C19881(continuation);
        }
        Object objG = c19881.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = c19881.label;
        if (i12 == 0) {
            ResultKt.b(objG);
            CoroutineDispatcher coroutineDispatcherB = w0.b();
            BaseWrapperAdManager$isAdPlansExist$adPlans$1 baseWrapperAdManager$isAdPlansExist$adPlans$1 = new BaseWrapperAdManager$isAdPlansExist$adPlans$1(str, map, null);
            c19881.label = 1;
            objG = h.g(coroutineDispatcherB, baseWrapperAdManager$isAdPlansExist$adPlans$1, c19881);
            if (objG == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objG);
        }
        return Boxing.a(((AdPlans) objG) != null);
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final Object loadAd(String str, WrapperAdListener wrapperAdListener, Continuation<? super Unit> continuation) throws Throwable {
        String strD = c.f79583a.d(str);
        if (!TextUtils.isEmpty(strD)) {
            onFailCallback(wrapperAdListener, strD);
            return Unit.f68710a;
        }
        if (!oq.c.f72513a.a()) {
            Object objInnerLoadAd = innerLoadAd(str, wrapperAdListener, continuation);
            return objInnerLoadAd == kotlin.coroutines.intrinsics.a.e() ? objInnerLoadAd : Unit.f68710a;
        }
        onFailCallback(wrapperAdListener, getClassTag() + " --> loadAd() --> 全局弹窗展示的时候不加载广告");
        return Unit.f68710a;
    }

    public void loadAdShowFinal() {
        if (this.mAdShowFinalPlan != null) {
            com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerLoadHiSavanaAd() --> 当前有兜底广告可用 --> sceneId = " + this.mSceneId, false, 2, null);
            WrapperAdListener wrapperAdListener = this.mListener;
            if (wrapperAdListener != null) {
                wrapperAdListener.onLoad();
                return;
            }
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerLoadHiSavanaAd() --> 当前没有兜底广告 --> sceneId = " + this.mSceneId, false, 2, null);
        WrapperAdListener wrapperAdListener2 = this.mListener;
        if (wrapperAdListener2 != null) {
            wrapperAdListener2.onError(new TAdErrorCode(101, "没有兜底广告 --> sceneId = " + this.mSceneId));
        }
    }

    public abstract void loadHiSavanaAd(String str, WrapperAdListener wrapperAdListener);

    public void loadPlanAd(String sceneId) {
        Intrinsics.g(sceneId, "sceneId");
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> innerLoadHiSavanaAd() --> 当前包断广告可用 --> sceneId = " + this.mSceneId, false, 2, null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onLoad();
        }
    }

    public abstract void onAdDestroy(String str);

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        super.onClicked(i11);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(i11);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onClosed(int i11) {
        super.onClosed(i11);
        this.isShow = false;
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClosed(i11);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onClosed(TAdNativeInfo tAdNativeInfo) {
        super.onClosed(tAdNativeInfo);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClosed(tAdNativeInfo);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        String errorMessage;
        super.onError(tAdErrorCode);
        if (tAdErrorCode == null || (errorMessage = tAdErrorCode.getErrorMessage()) == null || !StringsKt__StringsKt.Q(errorMessage, BaseInterceptHiSavanaAdManager.HI_SAVANA_AD_SHOW_ERROR_IS_SHOWING_TAG, false, 2, null)) {
            loadAdShowFinal();
            return;
        }
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(tAdErrorCode);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onLoad();
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onPlanAdShowError(TAdErrorCode tAdErrorCode) {
        super.onPlanAdShowError(tAdErrorCode);
        this.isShow = false;
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShowError(tAdErrorCode);
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onRewarded() {
        super.onRewarded();
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onRewarded();
        }
    }

    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
        super.onShow(i11);
        this.isShow = true;
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShow(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShowError(TAdErrorCode tAdErrorCode) {
        String errorMessage;
        super.onShowError(tAdErrorCode);
        if (tAdErrorCode == null || (errorMessage = tAdErrorCode.getErrorMessage()) == null || !StringsKt__StringsKt.Q(errorMessage, BaseInterceptHiSavanaAdManager.HI_SAVANA_AD_SHOW_ERROR_IS_SHOWING_TAG, false, 2, null)) {
            showInnerAdShowFinal();
            return;
        }
        this.isShow = false;
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShowError(tAdErrorCode);
        }
    }

    public final void setMListener(WrapperAdListener wrapperAdListener) {
        this.mListener = wrapperAdListener;
    }

    public final void setMSceneId(String str) {
        this.mSceneId = str;
    }

    public final Object showAd(String str, WrapperAdListener wrapperAdListener, boolean z11, Map<String, ? extends Object> map, Continuation<? super Unit> continuation) throws Throwable {
        String strD = c.f79583a.d(str);
        if (!TextUtils.isEmpty(strD)) {
            onFailCallback(wrapperAdListener, strD);
            return Unit.f68710a;
        }
        if (!oq.c.f72513a.a()) {
            Object objInnerShowAd = innerShowAd(str, wrapperAdListener, z11, map, continuation);
            return objInnerShowAd == kotlin.coroutines.intrinsics.a.e() ? objInnerShowAd : Unit.f68710a;
        }
        onFailCallback(wrapperAdListener, getClassTag() + " --> showAd() --> 全局弹窗展示的时候不加载广告");
        return Unit.f68710a;
    }

    public abstract void showHiSavanaAd(String str, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map);

    public final void showInnerAdShowFinal() {
        if (this.mAdShowFinalPlan == null) {
            com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> showInnerAdShowFinal() --> 没有兜底广告可用于展示 --> sceneId = " + this.mSceneId, false, 2, null);
            WrapperAdListener wrapperAdListener = this.mListener;
            if (wrapperAdListener != null) {
                wrapperAdListener.onShowError(new TAdErrorCode(101, "没有兜底广告可用于展示"));
                return;
            }
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClass().getSimpleName() + " --> showInnerAdShowFinal() --> 加载包断兜底广告 --> sceneId = " + this.mSceneId, false, 2, null);
        String str = this.mSceneId;
        if (str == null) {
            str = "";
        }
        showMbAd(str, this.mAdShowFinalPlan, this);
    }

    public abstract void showMbAd(String str, AdPlans adPlans, WrapperAdListener wrapperAdListener);
}
