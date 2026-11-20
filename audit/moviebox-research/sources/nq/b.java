package nq;

import android.content.Context;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class b extends AbsAdBidding {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final lq.b f72141l = new lq.b();

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_s";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void D(List<BiddingIntermediateMaterialBean> biddingPlan, AdPlans adPlans) {
        Intrinsics.g(biddingPlan, "biddingPlan");
        Intrinsics.g(adPlans, "adPlans");
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int G() {
        return 5;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini M() {
        return this.f72141l;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding, jq.a
    public void b(AdPlans adPlans) {
        super.b(adPlans);
        jq.a aVarN = N();
        if (aVarN != null) {
            aVarN.b(adPlans);
        }
        F();
    }

    public final void o0(Integer num, Context context) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP = P();
            Unit unit = null;
            if ((biddingIntermediateMaterialBeanP != null ? biddingIntermediateMaterialBeanP.getPlans() : null) == null) {
                g(new TAdErrorCode(102, "getAdPlan() == null"));
                unit = Unit.f68710a;
            } else if (context != null) {
                this.f72141l.q(num);
                AbsBiddingBuyOutGemini absBiddingBuyOutGeminiN = this.f72141l.o(this).n();
                String strQ = Q();
                BiddingIntermediateMaterialBean biddingIntermediateMaterialBeanP2 = P();
                absBiddingBuyOutGeminiN.p(context, strQ, biddingIntermediateMaterialBeanP2 != null ? biddingIntermediateMaterialBeanP2.getPlans() : null);
                unit = Unit.f68710a;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g(new TAdErrorCode(102, String.valueOf(thM166exceptionOrNullimpl.getMessage())));
    }
}
