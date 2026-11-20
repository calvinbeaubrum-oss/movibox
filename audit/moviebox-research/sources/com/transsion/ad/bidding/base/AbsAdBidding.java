package com.transsion.ad.bidding.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.google.android.gms.common.api.Api;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import com.transsion.ad.report.BiddingStateEnum;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public abstract class AbsAdBidding extends jq.a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f50283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jq.a f50284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f50285d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<BiddingIntermediateMaterialBean> f50288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BiddingIntermediateMaterialBean f50289i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50286f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f50287g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f50290j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f50291k = new Handler(Looper.getMainLooper());

    public static final void U(AbsAdBidding this$0, AdPlans adPlans, long j11) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.d(adPlans, j11);
        }
    }

    public static final void V(AbsAdBidding this$0, TAdErrorCode tAdErrorCode) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.g(tAdErrorCode);
        }
    }

    public static final void W(AbsAdBidding this$0, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.h(biddingIntermediateMaterialBean);
        }
    }

    public static final void Y(AbsAdBidding this$0) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            List<BiddingIntermediateMaterialBean> listI = this$0.I();
            aVarN.g(new TAdErrorCode(105, "竞价失败 --> maxEcpmObject == null --> biddingPlanList?.size = " + (listI != null ? Integer.valueOf(listI.size()) : null)));
        }
    }

    public static final void Z(AbsAdBidding this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.m(i11);
        }
    }

    public static final void c0(AbsAdBidding this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.i(i11);
        }
    }

    public static final void e0(AbsAdBidding this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.j(i11);
        }
    }

    public static final void g0(AbsAdBidding this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.l(i11);
        }
    }

    public static final void i0(AbsAdBidding this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        jq.a aVarN = this$0.N();
        if (aVarN != null) {
            aVarN.k(i11);
        }
    }

    public abstract void D(List<BiddingIntermediateMaterialBean> list, AdPlans adPlans);

    public boolean E() {
        return false;
    }

    public void F() {
        AbsBiddingInterceptHiSavanaAdManager hiSavanaInterceptProvider;
        m0(null);
        l0(null);
        k0(null);
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
        if (biddingIntermediateMaterialBeanP != null && (hiSavanaInterceptProvider = biddingIntermediateMaterialBeanP.getHiSavanaInterceptProvider()) != null) {
            hiSavanaInterceptProvider.a(this);
        }
        this.f50287g.removeCallbacksAndMessages(null);
        this.f50289i = null;
        AbsBiddingBuyOutGemini absBiddingBuyOutGeminiM = M();
        if (absBiddingBuyOutGeminiM != null) {
            absBiddingBuyOutGeminiM.b();
        }
        if (G() != 2) {
            a0(3, getClassTag() + " --> destroy() --> 资源回收");
        }
    }

    public abstract int G();

    public final Pair<List<BiddingIntermediateMaterialBean>, Boolean> H(List<AdPlans> list) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (AdPlans adPlans : list) {
            if (AdPlanSourceManager.f50540a.d(adPlans)) {
                if (!wq.c.f79583a.a(Q())) {
                    D(arrayList, adPlans);
                    z11 = true;
                }
            } else if (!wq.c.f79583a.b(Q())) {
                arrayList.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, null, null, null, null, false, 56, null));
            }
        }
        return new Pair<>(arrayList, Boolean.valueOf(z11));
    }

    public final List<BiddingIntermediateMaterialBean> I() {
        return this.f50288h;
    }

    public final long J() {
        if (G() == 1) {
            return ((long) wq.a.f79581a.a(Q())) * 1000;
        }
        return 0L;
    }

    public final Context K() {
        return this.f50285d;
    }

    public final Map<String, Object> L() {
        Map<String, ? extends Object> map = this.f50283b;
        return map == null ? s.h() : map;
    }

    public abstract AbsBiddingBuyOutGemini M();

    public final jq.a N() {
        return this.f50284c;
    }

    public final BiddingIntermediateMaterialBean O(List<BiddingIntermediateMaterialBean> list) {
        List<BiddingIntermediateMaterialBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            a0(5, "getMaxEcpmBiddingPlan() --> biddingList.isNullOrEmpty() == true");
            return null;
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$getMaxEcpmBiddingPlan$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.b.d(((BiddingIntermediateMaterialBean) t11).getEcpm(), ((BiddingIntermediateMaterialBean) t12).getEcpm());
            }
        };
        return (BiddingIntermediateMaterialBean) CollectionsKt___CollectionsKt.t0(list, new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$getMaxEcpmBiddingPlan$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                Integer numValueOf;
                Integer numValueOf2;
                int iCompare = comparator.compare(t11, t12);
                if (iCompare != 0) {
                    return iCompare;
                }
                AdPlans plans = ((BiddingIntermediateMaterialBean) t11).getPlans();
                if (plans == null || (numValueOf = plans.getSort()) == null) {
                    numValueOf = Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
                AdPlans plans2 = ((BiddingIntermediateMaterialBean) t12).getPlans();
                if (plans2 == null || (numValueOf2 = plans2.getSort()) == null) {
                    numValueOf2 = Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
                return kotlin.comparisons.b.d(numValueOf, numValueOf2);
            }
        });
    }

    public final BiddingIntermediateMaterialBean P() {
        return this.f50289i;
    }

    public final String Q() {
        String str = this.f50282a;
        return str == null ? "" : str;
    }

    public final String R() {
        return this.f50286f;
    }

    public final boolean S(AdPlans adPlans) {
        if ((adPlans != null ? adPlans.getBidEcpmCent() : null) != null) {
            Double bidEcpmCent = adPlans.getBidEcpmCent();
            if ((bidEcpmCent != null ? bidEcpmCent.doubleValue() : 0.0d) != 0.0d) {
                return false;
            }
        }
        return true;
    }

    public final Object T(Continuation<? super Unit> continuation) {
        if (oq.f.f72518a.a()) {
            g(new TAdErrorCode(105, "测试广告加载失败Case"));
            return Unit.f68710a;
        }
        if (o.f50331a.b()) {
            g(new TAdErrorCode(105, "intercept ad is showing"));
            return Unit.f68710a;
        }
        if (this.f50290j.get()) {
            g(new TAdErrorCode(105, "isLoading -- Try again when it's a little thicker"));
            return Unit.f68710a;
        }
        this.f50290j.set(true);
        this.f50286f = xq.j.f80681a.b();
        vq.b bVar = vq.b.f79053a;
        bVar.l(R(), Q(), G(), 105, "");
        String strD = wq.c.f79583a.d(Q());
        if (!TextUtils.isEmpty(strD)) {
            bVar.k(this.f50286f, Q(), G(), 105, strD);
            g(new TAdErrorCode(105, strD));
            return Unit.f68710a;
        }
        if (E() && K() == null) {
            g(new TAdErrorCode(105, "context is null"));
            return Unit.f68710a;
        }
        Object objG = kotlinx.coroutines.h.g(w0.b(), new AbsAdBidding$loadAd$2(this, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final void X() {
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanO = O(I());
        this.f50289i = biddingIntermediateMaterialBeanO;
        if (biddingIntermediateMaterialBeanO == null) {
            this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.h
                @Override // java.lang.Runnable
                public final void run() {
                    AbsAdBidding.Y(this.f50323a);
                }
            });
        } else {
            h(biddingIntermediateMaterialBeanO);
        }
    }

    @Override // jq.a
    public void a(AdPlans adPlans) {
        super.a(adPlans);
        vq.b bVar = vq.b.f79053a;
        String strR = R();
        String strQ = Q();
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdPlanUtil adPlanUtil = AdPlanUtil.f50541a;
        AdMaterialList adMaterialListA = adPlanUtil.a(adPlans);
        bVar.a((128 & 1) != 0 ? "" : strR, strQ, id2, 102, adMaterialListA != null ? adMaterialListA.getId() : null, G(), (128 & 64) != 0 ? false : uq.b.f78633a.a(adPlans), (128 & 128) != 0 ? s.h() : null, adPlanUtil.c(adPlans), (128 & 512) != 0 ? null : adPlans != null ? adPlans.getBidEcpmCent() : null, (128 & 1024) != 0 ? null : adPlans != null ? adPlans.getEcpmCent() : null);
        b0(102);
    }

    public void a0(int i11, String str) {
        n.a.b(this, i11, str);
    }

    @Override // jq.a
    public void b(AdPlans adPlans) {
        super.b(adPlans);
        d0(102);
    }

    public final void b0(final int i11) {
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.g
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.c0(this.f50321a, i11);
            }
        });
    }

    @Override // jq.a
    public void c(AdPlans adPlans) {
        super.c(adPlans);
        vq.b bVar = vq.b.f79053a;
        String strR = R();
        String strQ = Q();
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdPlanUtil adPlanUtil = AdPlanUtil.f50541a;
        AdMaterialList adMaterialListA = adPlanUtil.a(adPlans);
        bVar.f((128 & 1) != 0 ? "" : strR, strQ, id2, 102, adMaterialListA != null ? adMaterialListA.getId() : null, G(), (128 & 64) != 0 ? false : uq.b.f78633a.a(adPlans), (128 & 128) != 0 ? s.h() : null, adPlanUtil.c(adPlans), (128 & 512) != 0 ? null : adPlans != null ? adPlans.getBidEcpmCent() : null, (128 & 1024) != 0 ? null : adPlans != null ? adPlans.getEcpmCent() : null);
        h0(102);
    }

    @Override // jq.a
    public void d(final AdPlans adPlans, final long j11) {
        super.d(adPlans, j11);
        vq.b bVar = vq.b.f79053a;
        String strR = R();
        String strQ = Q();
        String id2 = adPlans != null ? adPlans.getId() : null;
        AdMaterialList adMaterialListA = AdPlanUtil.f50541a.a(adPlans);
        bVar.c(strR, strQ, id2, j11, adMaterialListA != null ? adMaterialListA.getId() : null, G(), uq.b.f78633a.a(adPlans));
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.f
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.U(this.f50318a, adPlans, j11);
            }
        });
    }

    public final void d0(final int i11) {
        o oVar = o.f50331a;
        if (oVar.a(G())) {
            oVar.c();
        }
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.e
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.e0(this.f50316a, i11);
            }
        });
    }

    @Override // jq.a
    public void e(AdPlans adPlans) {
        super.e(adPlans);
        f0(102);
    }

    @Override // jq.a
    public void f(TAdErrorCode tAdErrorCode, AdPlans adPlans) {
        super.f(tAdErrorCode, adPlans);
        m(102);
    }

    public final void f0(final int i11) {
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.c
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.g0(this.f50312a, i11);
            }
        });
    }

    @Override // jq.a
    public void g(final TAdErrorCode tAdErrorCode) {
        super.g(tAdErrorCode);
        a0(6, "onBiddingWrapperError() --> 加载失败 --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null) + " --> 重置状态");
        this.f50290j.set(false);
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.d
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.V(this.f50314a, tAdErrorCode);
            }
        });
    }

    @Override // com.transsion.ad.bidding.base.n
    public String getClassTag() {
        return n.a.a(this);
    }

    @Override // jq.a
    public void h(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        AdPlans plans2;
        AdPlans plans3;
        AdPlans plans4;
        super.h(biddingIntermediateMaterialBean);
        ArrayList arrayList = new ArrayList();
        List<BiddingIntermediateMaterialBean> listI = I();
        String name = null;
        if (listI != null) {
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                Double ecpm = ((BiddingIntermediateMaterialBean) it.next()).getEcpm();
                arrayList.add(ecpm != null ? ecpm.toString() : null);
            }
        }
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
        Double ecpm2 = biddingIntermediateMaterialBeanP != null ? biddingIntermediateMaterialBeanP.getEcpm() : null;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP2 = P();
        String id2 = (biddingIntermediateMaterialBeanP2 == null || (plans4 = biddingIntermediateMaterialBeanP2.getPlans()) == null) ? null : plans4.getId();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP3 = P();
        a0(3, "onBiddingWrapperLoad() --> 竞价完成 --> ecpmList = " + arrayList + " --> ecpm = " + ecpm2 + " --> plans?.id = " + id2 + " --> plans?.name = " + ((biddingIntermediateMaterialBeanP3 == null || (plans3 = biddingIntermediateMaterialBeanP3.getPlans()) == null) ? null : plans3.getName()));
        vq.b bVar = vq.b.f79053a;
        String strR = R();
        String strQ = Q();
        int iG = G();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP4 = P();
        Double ecpm3 = biddingIntermediateMaterialBeanP4 != null ? biddingIntermediateMaterialBeanP4.getEcpm() : null;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP5 = P();
        String id3 = (biddingIntermediateMaterialBeanP5 == null || (plans2 = biddingIntermediateMaterialBeanP5.getPlans()) == null) ? null : plans2.getId();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP6 = P();
        if (biddingIntermediateMaterialBeanP6 != null && (plans = biddingIntermediateMaterialBeanP6.getPlans()) != null) {
            name = plans.getName();
        }
        bVar.e(strR, strQ, iG, BiddingStateEnum.BIDDING_REPORT_BIDDING_SUCCESS, "竞价成功 --> ecpmList = " + arrayList + " , ecpm = " + ecpm3 + " , plans?.id = " + id3 + " , plans?.name = " + name);
        this.f50290j.set(false);
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.i
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.W(this.f50324a, biddingIntermediateMaterialBean);
            }
        });
    }

    public final void h0(final int i11) {
        o oVar = o.f50331a;
        if (oVar.a(G())) {
            oVar.d();
        }
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.b
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.i0(this.f50310a, i11);
            }
        });
        NonAdShowedTimesManager nonAdShowedTimesManager = NonAdShowedTimesManager.f50524a;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
        nonAdShowedTimesManager.c(biddingIntermediateMaterialBeanP != null ? biddingIntermediateMaterialBeanP.getPlans() : null);
    }

    public final void j0(Context context) {
        Intrinsics.g(context, "context");
        this.f50285d = context;
    }

    public final AbsAdBidding k0(Map<String, ? extends Object> map) {
        this.f50283b = map;
        return this;
    }

    public final AbsAdBidding l0(jq.a aVar) {
        this.f50284c = aVar;
        return this;
    }

    @Override // jq.a
    public void m(final int i11) {
        super.m(i11);
        this.f50291k.post(new Runnable() { // from class: com.transsion.ad.bidding.base.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.Z(this.f50308a, i11);
            }
        });
    }

    public final AbsAdBidding m0(String str) {
        this.f50282a = str;
        return this;
    }

    public final void n0(Activity activity) {
        LifecycleCoroutineScope lifecycleCoroutineScopeA;
        if (o.f50331a.b()) {
            a0(6, "startAdActivity() --> intercept ad is showing");
            return;
        }
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity == null || (lifecycleCoroutineScopeA = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.j.d(lifecycleCoroutineScopeA, null, null, new AbsAdBidding$startAdActivity$1(this, activity, null), 3, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        TAdNativeInfo nativeInfo;
        Intrinsics.g(p11, "p1");
        super.onClick(tAdNativeInfo, p11);
        if (G() == 2) {
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
            if (!TextUtils.equals((biddingIntermediateMaterialBeanP == null || (nativeInfo = biddingIntermediateMaterialBeanP.getNativeInfo()) == null) ? null : nativeInfo.getAdId(), tAdNativeInfo != null ? tAdNativeInfo.getAdId() : null)) {
                return;
            }
        }
        vq.b bVar = vq.b.f79053a;
        String strR = R();
        String strQ = Q();
        Integer source = p11.getSource();
        String codeSeatId = p11.getCodeSeatId();
        int iG = G();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP2 = P();
        bVar.a((128 & 1) != 0 ? "" : strR, strQ, "", source, codeSeatId, iG, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : biddingIntermediateMaterialBeanP2 != null ? biddingIntermediateMaterialBeanP2.getEcpm() : null, (128 & 1024) != 0 ? null : null);
        b0(Worker.WHAT_SYNC_DATA);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClosed(int i11) {
        super.onClosed(i11);
        d0(Worker.WHAT_SYNC_DATA);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onRewarded() {
        super.onRewarded();
        f0(Worker.WHAT_SYNC_DATA);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        TAdNativeInfo nativeInfo;
        Intrinsics.g(p11, "p1");
        super.onShow(tAdNativeInfo, p11);
        if (G() == 2) {
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
            if (!TextUtils.equals((biddingIntermediateMaterialBeanP == null || (nativeInfo = biddingIntermediateMaterialBeanP.getNativeInfo()) == null) ? null : nativeInfo.getAdId(), tAdNativeInfo != null ? tAdNativeInfo.getAdId() : null)) {
                return;
            }
        }
        h0(Worker.WHAT_SYNC_DATA);
        vq.b bVar = vq.b.f79053a;
        String strR = R();
        String strQ = Q();
        Integer source = p11.getSource();
        String codeSeatId = p11.getCodeSeatId();
        int iG = G();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP2 = P();
        bVar.f((128 & 1) != 0 ? "" : strR, strQ, "", source, codeSeatId, iG, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : biddingIntermediateMaterialBeanP2 != null ? biddingIntermediateMaterialBeanP2.getEcpm() : null, (128 & 1024) != 0 ? null : null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onShowError(tAdErrorCode, p11);
        m(Worker.WHAT_SYNC_DATA);
    }
}
