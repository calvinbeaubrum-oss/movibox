package tq;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.transsion.ad.middle.intercept.BaseNonAdManager;
import com.transsion.ad.middle.intercept.interstitial.NonInterstitialAdActivity;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
public final class d extends BaseNonAdManager {
    @Override // com.transsion.ad.middle.intercept.BaseNonAdManager
    public Intent e(Context context, AdPlans adPlans, String str) {
        Intrinsics.g(context, "context");
        return new Intent(context, (Class<?>) NonInterstitialAdActivity.class);
    }

    @Override // com.transsion.ad.middle.intercept.BaseNonAdManager
    public void f(IntentFilter filter) {
        Intrinsics.g(filter, "filter");
        filter.addAction("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onDestroy.Interstitial");
        filter.addAction("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onRewarded.Interstitial");
        filter.addAction("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onShow.Interstitial");
    }
}
