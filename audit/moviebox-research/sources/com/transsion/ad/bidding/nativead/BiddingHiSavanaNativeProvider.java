package com.transsion.ad.bidding.nativead;

import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.hisavana.mediation.ad.TNativeAd;
import com.transsion.ad.hi.HiSavanaAdManager;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class BiddingHiSavanaNativeProvider extends TAdditionalListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f50344g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<Map<String, BiddingHiSavanaNativeProvider>> f50345h = LazyKt__LazyJVMKt.b(new Function0<Map<String, BiddingHiSavanaNativeProvider>>() { // from class: com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$Companion$map$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<String, BiddingHiSavanaNativeProvider> invoke() {
            return new LinkedHashMap();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TNativeAd f50349d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedDeque<jq.a> f50346a = new ConcurrentLinkedDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentSkipListSet<TAdNativeInfo> f50347b = new ConcurrentSkipListSet<>(new Comparator() { // from class: com.transsion.ad.bidding.nativead.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return BiddingHiSavanaNativeProvider.j((TAdNativeInfo) obj, (TAdNativeInfo) obj2);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicBoolean f50350f = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, BiddingHiSavanaNativeProvider> a() {
            return (Map) BiddingHiSavanaNativeProvider.f50345h.getValue();
        }

        public final BiddingHiSavanaNativeProvider b(String str) {
            String strB = wq.a.f79581a.b(str);
            if (strB == null || strB.length() == 0) {
                return null;
            }
            BiddingHiSavanaNativeProvider biddingHiSavanaNativeProvider = a().get(strB);
            if (biddingHiSavanaNativeProvider != null) {
                return biddingHiSavanaNativeProvider;
            }
            BiddingHiSavanaNativeProvider biddingHiSavanaNativeProvider2 = new BiddingHiSavanaNativeProvider();
            biddingHiSavanaNativeProvider2.l(strB);
            a().put(strB, biddingHiSavanaNativeProvider2);
            return biddingHiSavanaNativeProvider2;
        }
    }

    private final String g() {
        String str = this.f50348c;
        return str == null ? "" : str;
    }

    private final String getClassTag() {
        String simpleName = BiddingHiSavanaNativeProvider.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final void i(String str) {
        if (!HiSavanaAdManager.f50400a.f()) {
            com.transsion.ad.a.L(com.transsion.ad.a.f50276a, getClassTag() + " --> loadAd(" + str + ") --> 广告SDK没有初始化", false, 2, null);
            return;
        }
        if (this.f50350f.get()) {
            return;
        }
        this.f50350f.set(true);
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        com.transsion.ad.a.J(aVar, getClassTag() + " --> loadAd() --> mag = " + str, false, 2, null);
        if (this.f50349d == null) {
            TNativeAd tNativeAd = new TNativeAd(Utils.a(), g());
            this.f50349d = tNativeAd;
            tNativeAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
            com.transsion.ad.a.J(aVar, "============= " + getClassTag() + " --> loadAd() --> mPlacementId = " + g() + " --> create TNativeAd() =================== ", false, 2, null);
        }
        TNativeAd tNativeAd2 = this.f50349d;
        if (tNativeAd2 != null) {
            tNativeAd2.loadAd();
        }
    }

    public static final int j(TAdNativeInfo tAdNativeInfo, TAdNativeInfo tAdNativeInfo2) {
        int iCompare = Double.compare(tAdNativeInfo2.getEcpmPrice(), tAdNativeInfo.getEcpmPrice());
        if (iCompare != 0) {
            return iCompare;
        }
        String adId = tAdNativeInfo.getAdId();
        String adId2 = tAdNativeInfo2.getAdId();
        Intrinsics.f(adId2, "ad2.adId");
        return adId.compareTo(adId2);
    }

    public final void c(jq.a aVar) {
        this.f50346a.add(aVar);
    }

    public final TAdNativeInfo d() {
        TAdNativeInfo tAdNativeInfoF = f();
        if (!h()) {
            i("同步获取广告，继续装填缓存池");
        }
        return tAdNativeInfoF;
    }

    public final TNativeAd e() {
        return this.f50349d;
    }

    public final TAdNativeInfo f() {
        if (this.f50347b.isEmpty()) {
            return null;
        }
        TAdNativeInfo tAdNativeInfoPollFirst = this.f50347b.pollFirst();
        if (tAdNativeInfoPollFirst == null || !tAdNativeInfoPollFirst.isExpired()) {
            return tAdNativeInfoPollFirst;
        }
        tAdNativeInfoPollFirst.release();
        return f();
    }

    public final boolean h() {
        int iD = wq.b.f79582a.d();
        boolean z11 = this.f50347b.size() >= iD;
        if (z11) {
            com.transsion.ad.a.J(com.transsion.ad.a.f50276a, getClassTag() + " --> isUpperLimit() --- 达到阈值了 --> nativeInfoList.size = " + this.f50347b.size() + " -- cacheUpperLimit = " + iD, false, 2, null);
        }
        return z11;
    }

    public final void k(jq.a aVar) {
        this.f50346a.remove(aVar);
    }

    public final void l(String str) {
        this.f50348c = str;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onClick(tAdNativeInfo, p11);
        Iterator<T> it = this.f50346a.iterator();
        while (it.hasNext()) {
            ((jq.a) it.next()).onClick(tAdNativeInfo, p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onLoadFailure(tAdErrorCode, p11);
        this.f50350f.set(false);
        com.transsion.ad.a.L(com.transsion.ad.a.f50276a, getClassTag() + " --> onLoadFailure() --> placementId = " + g() + " --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 2, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo p11) {
        List<TAdNativeInfo> nativeAdInfo;
        Intrinsics.g(p11, "p0");
        super.onLoadSuccess(p11);
        TNativeAd tNativeAd = this.f50349d;
        if (tNativeAd != null && (nativeAdInfo = tNativeAd.getNativeAdInfo()) != null) {
            this.f50347b.addAll(nativeAdInfo);
        }
        if (!h()) {
            i("缓存池没有达到阈值，继续请求");
        }
        this.f50350f.set(false);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onShow(tAdNativeInfo, p11);
        Iterator<T> it = this.f50346a.iterator();
        while (it.hasNext()) {
            ((jq.a) it.next()).onShow(tAdNativeInfo, p11);
        }
    }
}
