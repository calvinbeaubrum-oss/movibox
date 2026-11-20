package kq;

import android.content.Context;
import com.hisavana.common.bean.AdditionalInfo;
import com.transsion.ad.bidding.banner.BiddingBuyOutBannerView;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class a extends AbsAdBidding {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f69626l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BiddingBuyOutBannerView f69627m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AdPlans f69628n;

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_b";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void D(List<BiddingIntermediateMaterialBean> biddingPlan, AdPlans adPlans) {
        Intrinsics.g(biddingPlan, "biddingPlan");
        Intrinsics.g(adPlans, "adPlans");
        if (this.f69626l == null) {
            d dVar = new d();
            this.f69626l = dVar;
            dVar.l(Q());
            d dVar2 = this.f69626l;
            if (dVar2 != null) {
                dVar2.j(L());
            }
            d dVar3 = this.f69626l;
            if (dVar3 != null) {
                dVar3.i(K());
            }
            d dVar4 = this.f69626l;
            if (dVar4 != null) {
                dVar4.k(this);
            }
        }
        this.f69628n = adPlans;
        d dVar5 = this.f69626l;
        if (dVar5 != null) {
            dVar5.g();
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public boolean E() {
        return true;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void F() {
        super.F();
        BiddingBuyOutBannerView biddingBuyOutBannerView = this.f69627m;
        if (biddingBuyOutBannerView != null) {
            biddingBuyOutBannerView.destroy();
        }
        d dVar = this.f69626l;
        if (dVar != null) {
            dVar.a();
        }
        List<BiddingIntermediateMaterialBean> listI = I();
        if (listI != null) {
            listI.clear();
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int G() {
        return 1;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini M() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean] */
    @Override // com.transsion.ad.bidding.base.AbsAdBidding, jq.a
    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        ?? r11 = 0;
        if ((biddingIntermediateMaterialBean != 0 ? biddingIntermediateMaterialBean.getHiSavanaBannerProvider() : null) == null) {
            Context contextK = K();
            if (contextK != null) {
                BiddingBuyOutBannerView biddingBuyOutBannerView = new BiddingBuyOutBannerView(contextK, r11, 2, r11);
                this.f69627m = biddingBuyOutBannerView;
                biddingBuyOutBannerView.setAdPlans(biddingIntermediateMaterialBean != 0 ? biddingIntermediateMaterialBean.getPlans() : null);
                BiddingBuyOutBannerView biddingBuyOutBannerView2 = this.f69627m;
                if (biddingBuyOutBannerView2 != null) {
                    biddingBuyOutBannerView2.setSceneId(Q());
                }
                BiddingBuyOutBannerView biddingBuyOutBannerView3 = this.f69627m;
                if (biddingBuyOutBannerView3 != null) {
                    biddingBuyOutBannerView3.setListener(this);
                }
            }
            if (biddingIntermediateMaterialBean != 0) {
                biddingIntermediateMaterialBean.setBannerView(this.f69627m);
            }
        } else {
            d dVar = this.f69626l;
            biddingIntermediateMaterialBean.setBannerView(dVar != null ? dVar.b() : 0);
        }
        super.h(biddingIntermediateMaterialBean);
    }

    public final void o0() {
        BiddingBuyOutBannerView biddingBuyOutBannerView = this.f69627m;
        if (biddingBuyOutBannerView != null) {
            biddingBuyOutBannerView.showAd();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo p11) {
        AdPlans adPlans;
        Intrinsics.g(p11, "p0");
        super.onLoadSuccess(p11);
        if (S(this.f69628n) && (adPlans = this.f69628n) != null) {
            adPlans.setBidEcpmCent(p11.getECPM());
        }
        List<BiddingIntermediateMaterialBean> listI = I();
        if (listI != null) {
            AdPlans adPlans2 = this.f69628n;
            listI.add(new BiddingIntermediateMaterialBean(adPlans2 != null ? adPlans2.getBidEcpmCent() : null, this.f69628n, null, this.f69626l, null, null, false, 52, null));
        }
    }
}
