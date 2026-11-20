package w9;

import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f79364a = new d();

    public final ConfigCodeSeatDTO a(ConfigCodeSeatDTO defaultConfig) {
        Intrinsics.g(defaultConfig, "defaultConfig");
        defaultConfig.setApplicationId(AdManager.f29117b);
        defaultConfig.setAdSeatType("");
        defaultConfig.setOfflineAdCacheCount(5);
        defaultConfig.setOfflineAdRequestCount(2);
        defaultConfig.setOfflineAdRequestTimeInterval(30);
        defaultConfig.setOfflineAdRequestTimeIntervalNoAd(24);
        defaultConfig.setAdShowCountLimit(-1);
        defaultConfig.setCarouselTime(0);
        defaultConfig.setCarouselCount(1);
        defaultConfig.setShowInterval(0);
        defaultConfig.setLastOfflineAdEnable(Boolean.FALSE);
        defaultConfig.setDefaultConfig(Boolean.TRUE);
        return defaultConfig;
    }
}
