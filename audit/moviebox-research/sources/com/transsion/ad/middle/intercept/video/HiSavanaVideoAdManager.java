package com.transsion.ad.middle.intercept.video;

import android.app.Activity;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TRewardedAd;
import com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager;
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
public final class HiSavanaVideoAdManager extends BaseInterceptHiSavanaAdManager {
    public static final a Companion = new a(null);
    private static final Lazy<HashMap<String, HiSavanaVideoAdManager>> mAdMap$delegate = LazyKt__LazyJVMKt.b(new Function0<HashMap<String, HiSavanaVideoAdManager>>() { // from class: com.transsion.ad.middle.intercept.video.HiSavanaVideoAdManager$Companion$mAdMap$2
        @Override // kotlin.jvm.functions.Function0
        public final HashMap<String, HiSavanaVideoAdManager> invoke() {
            return new HashMap<>();
        }
    });
    private final String mSceneId;
    private TRewardedAd tTVideoAd;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, HiSavanaVideoAdManager> a() {
            return (HashMap) HiSavanaVideoAdManager.mAdMap$delegate.getValue();
        }

        public final HiSavanaVideoAdManager b(String str) {
            String strB;
            if (TextUtils.isEmpty(str) || (strB = wq.a.f79581a.b(str)) == null) {
                return null;
            }
            HiSavanaVideoAdManager hiSavanaVideoAdManager = a().get(strB);
            if (hiSavanaVideoAdManager == null) {
                if (str == null) {
                    str = "";
                }
                hiSavanaVideoAdManager = new HiSavanaVideoAdManager(str);
                a().put(strB, hiSavanaVideoAdManager);
            }
            return hiSavanaVideoAdManager;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiSavanaVideoAdManager(String mSceneId) {
        super(mSceneId);
        Intrinsics.g(mSceneId, "mSceneId");
        this.mSceneId = mSceneId;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public in.b<?> getAdInstance() {
        if (this.tTVideoAd == null) {
            TRewardedAd tRewardedAd = new TRewardedAd(Utils.a(), wq.a.f79581a.b(this.mSceneId));
            this.tTVideoAd = tRewardedAd;
            tRewardedAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdListener(this).build());
        }
        return this.tTVideoAd;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public int getAdType() {
        return 3;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public void reset() {
        this.tTVideoAd = null;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager
    public void show(Activity topActivity, Map<String, ? extends Object> map) {
        TRewardedAd tRewardedAd;
        Intrinsics.g(topActivity, "topActivity");
        if (com.transsion.ad.strategy.b.f50584a.d(map) && (tRewardedAd = this.tTVideoAd) != null) {
            tRewardedAd.setContainVulgarContent(true);
        }
        TRewardedAd tRewardedAd2 = this.tTVideoAd;
        if (tRewardedAd2 != null) {
            tRewardedAd2.show(topActivity);
        }
    }
}
