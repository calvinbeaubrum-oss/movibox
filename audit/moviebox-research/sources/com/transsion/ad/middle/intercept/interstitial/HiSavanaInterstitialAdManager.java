package com.transsion.ad.middle.intercept.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TInterstitialAd;
import com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager;
import in.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
@Deprecated
@Metadata
public final class HiSavanaInterstitialAdManager extends BaseInterceptHiSavanaAdManager {
    public static final a Companion = new a(null);
    private static final Lazy<HashMap<String, HiSavanaInterstitialAdManager>> mAdMap$delegate = LazyKt__LazyJVMKt.b(new Function0<HashMap<String, HiSavanaInterstitialAdManager>>() { // from class: com.transsion.ad.middle.intercept.interstitial.HiSavanaInterstitialAdManager$Companion$mAdMap$2
        @Override // kotlin.jvm.functions.Function0
        public final HashMap<String, HiSavanaInterstitialAdManager> invoke() {
            return new HashMap<>();
        }
    });
    private final String mSceneId;
    private TInterstitialAd tInterstitialAd;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, HiSavanaInterstitialAdManager> a() {
            return (HashMap) HiSavanaInterstitialAdManager.mAdMap$delegate.getValue();
        }

        public final HiSavanaInterstitialAdManager b(String str) {
            String strB;
            if (TextUtils.isEmpty(str) || (strB = wq.a.f79581a.b(str)) == null) {
                return null;
            }
            HiSavanaInterstitialAdManager hiSavanaInterstitialAdManager = a().get(strB);
            if (hiSavanaInterstitialAdManager == null) {
                if (str == null) {
                    str = "";
                }
                hiSavanaInterstitialAdManager = new HiSavanaInterstitialAdManager(str);
                a().put(strB, hiSavanaInterstitialAdManager);
            }
            return hiSavanaInterstitialAdManager;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiSavanaInterstitialAdManager(String mSceneId) {
        super(mSceneId);
        Intrinsics.g(mSceneId, "mSceneId");
        this.mSceneId = mSceneId;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public b<?> getAdInstance() {
        if (this.tInterstitialAd == null) {
            TInterstitialAd tInterstitialAd = new TInterstitialAd(Utils.a(), wq.a.f79581a.b(this.mSceneId));
            this.tInterstitialAd = tInterstitialAd;
            tInterstitialAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdListener(this).build());
        }
        return this.tInterstitialAd;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public int getAdType() {
        return 4;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public void reset() {
        this.tInterstitialAd = null;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public void show(Activity topActivity, Map<String, ? extends Object> map) {
        TInterstitialAd tInterstitialAd;
        Intrinsics.g(topActivity, "topActivity");
        if (com.transsion.ad.strategy.b.f50584a.d(map) && (tInterstitialAd = this.tInterstitialAd) != null) {
            tInterstitialAd.setContainVulgarContent(true);
        }
        TInterstitialAd tInterstitialAd2 = this.tInterstitialAd;
        if (tInterstitialAd2 != null) {
            tInterstitialAd2.show(topActivity);
        }
    }
}
