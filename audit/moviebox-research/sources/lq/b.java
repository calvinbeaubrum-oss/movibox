package lq;

import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.bidding.splash.BiddingBuyOutSplashActivity;
import kotlin.Metadata;

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
public final class b extends AbsBiddingBuyOutGemini {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f70370f;

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_s";
    }

    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public Class<?> c() {
        return BiddingBuyOutSplashActivity.class;
    }

    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public String d() {
        return "splash";
    }

    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public Integer e() {
        return this.f70370f;
    }

    public final void q(Integer num) {
        this.f70370f = num;
    }
}
