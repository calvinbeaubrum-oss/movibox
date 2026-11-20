package com.transsion.ad.bidding.nativead;

import android.text.TextUtils;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.view.native_ad.BiddingBuyOutNativeView;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class c extends AbsAdBidding {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TAdNativeView f50368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BiddingBuyOutNativeView f50369m;

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_n";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void D(List<BiddingIntermediateMaterialBean> biddingPlan, AdPlans adPlans) {
        Intrinsics.g(biddingPlan, "biddingPlan");
        Intrinsics.g(adPlans, "adPlans");
        BiddingHiSavanaNativeProvider.a aVar = BiddingHiSavanaNativeProvider.f50344g;
        BiddingHiSavanaNativeProvider biddingHiSavanaNativeProviderB = aVar.b(Q());
        TAdNativeInfo tAdNativeInfoD = biddingHiSavanaNativeProviderB != null ? biddingHiSavanaNativeProviderB.d() : null;
        if (tAdNativeInfoD != null) {
            if (S(adPlans)) {
                adPlans.setBidEcpmCent(Double.valueOf(tAdNativeInfoD.getEcpmPrice()));
            }
            biddingPlan.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, tAdNativeInfoD, null, null, null, false, 56, null));
            BiddingHiSavanaNativeProvider biddingHiSavanaNativeProviderB2 = aVar.b(Q());
            if (biddingHiSavanaNativeProviderB2 != null) {
                biddingHiSavanaNativeProviderB2.c(this);
            }
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void F() {
        TAdNativeInfo nativeInfo;
        BiddingBuyOutNativeView biddingBuyOutNativeView = this.f50369m;
        if (biddingBuyOutNativeView != null) {
            biddingBuyOutNativeView.destroy();
        }
        super.F();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
        if (biddingIntermediateMaterialBeanP != null && (nativeInfo = biddingIntermediateMaterialBeanP.getNativeInfo()) != null) {
            nativeInfo.release();
        }
        BiddingHiSavanaNativeProvider biddingHiSavanaNativeProviderB = BiddingHiSavanaNativeProvider.f50344g.b(Q());
        if (biddingHiSavanaNativeProviderB != null) {
            biddingHiSavanaNativeProviderB.k(this);
        }
        TAdNativeView tAdNativeView = this.f50368l;
        if (tAdNativeView != null) {
            tAdNativeView.release();
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int G() {
        return 2;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini M() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding, jq.a
    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        super.h(biddingIntermediateMaterialBean);
        List<BiddingIntermediateMaterialBean> listI = I();
        if (listI != null) {
            for (BiddingIntermediateMaterialBean biddingIntermediateMaterialBean2 : listI) {
                if (biddingIntermediateMaterialBean2.getNativeInfo() != null) {
                    String id2 = (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getId();
                    AdPlans plans2 = biddingIntermediateMaterialBean2.getPlans();
                    if (!TextUtils.equals(id2, plans2 != null ? plans2.getId() : null)) {
                        biddingIntermediateMaterialBean2.getNativeInfo().release();
                    }
                }
            }
        }
    }

    public final void o0(BiddingBuyOutNativeView biddingBuyOutNativeView) {
        this.f50369m = biddingBuyOutNativeView;
    }

    public final void p0(TAdNativeView tAdNativeView) {
        this.f50368l = tAdNativeView;
    }

    public final boolean q0() {
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f50540a;
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
        return adPlanSourceManager.d(biddingIntermediateMaterialBeanP != null ? biddingIntermediateMaterialBeanP.getPlans() : null);
    }

    public final boolean r0() {
        return P() != null;
    }
}
