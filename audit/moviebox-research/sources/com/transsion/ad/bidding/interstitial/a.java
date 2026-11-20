package com.transsion.ad.bidding.interstitial;

import com.hisavana.common.bean.AdditionalInfo;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class a extends AbsAdBidding {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0546a f50342m = new C0546a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final lq.a f50343l = new lq.a();

    /* JADX INFO: renamed from: com.transsion.ad.bidding.interstitial.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0546a {
        public C0546a() {
        }

        public /* synthetic */ C0546a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String sceneId) {
            Intrinsics.g(sceneId, "sceneId");
            BiddingHiSavanaInterstitialProvider biddingHiSavanaInterstitialProviderB = BiddingHiSavanaInterstitialProvider.f50339h.b(sceneId);
            if (biddingHiSavanaInterstitialProviderB != null) {
                biddingHiSavanaInterstitialProviderB.f();
            }
        }
    }

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_i";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void D(List<BiddingIntermediateMaterialBean> biddingPlan, AdPlans adPlans) {
        Intrinsics.g(biddingPlan, "biddingPlan");
        Intrinsics.g(adPlans, "adPlans");
        BiddingHiSavanaInterstitialProvider biddingHiSavanaInterstitialProviderB = BiddingHiSavanaInterstitialProvider.f50339h.b(Q());
        AdditionalInfo additionalInfoD = biddingHiSavanaInterstitialProviderB != null ? biddingHiSavanaInterstitialProviderB.d() : null;
        if (additionalInfoD == null) {
            a0(6, "插屏广告同步获取失败");
            return;
        }
        if (S(adPlans)) {
            adPlans.setBidEcpmCent(additionalInfoD.getECPM());
        }
        biddingPlan.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, null, null, null, biddingHiSavanaInterstitialProviderB, false, 24, null));
        biddingHiSavanaInterstitialProviderB.b(Q());
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int G() {
        return 4;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini M() {
        return this.f50343l;
    }
}
