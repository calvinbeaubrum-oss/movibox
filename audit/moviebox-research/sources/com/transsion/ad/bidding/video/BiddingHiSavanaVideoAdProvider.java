package com.transsion.ad.bidding.video;

import android.app.Activity;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TRewardedAd;
import com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager;
import java.util.HashMap;
import java.util.Map;
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
@Metadata
public final class BiddingHiSavanaVideoAdProvider extends AbsBiddingInterceptHiSavanaAdManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f50377h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<HashMap<String, BiddingHiSavanaVideoAdProvider>> f50378i = LazyKt__LazyJVMKt.b(new Function0<HashMap<String, BiddingHiSavanaVideoAdProvider>>() { // from class: com.transsion.ad.bidding.video.BiddingHiSavanaVideoAdProvider$Companion$mAdMap$2
        @Override // kotlin.jvm.functions.Function0
        public final HashMap<String, BiddingHiSavanaVideoAdProvider> invoke() {
            return new HashMap<>();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TRewardedAd f50379g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HashMap<String, BiddingHiSavanaVideoAdProvider> a() {
            return (HashMap) BiddingHiSavanaVideoAdProvider.f50378i.getValue();
        }

        public final BiddingHiSavanaVideoAdProvider b(String str) {
            String strB;
            if (TextUtils.isEmpty(str) || (strB = wq.a.f79581a.b(str)) == null) {
                return null;
            }
            BiddingHiSavanaVideoAdProvider biddingHiSavanaVideoAdProvider = a().get(strB);
            if (biddingHiSavanaVideoAdProvider != null) {
                return biddingHiSavanaVideoAdProvider;
            }
            BiddingHiSavanaVideoAdProvider biddingHiSavanaVideoAdProvider2 = new BiddingHiSavanaVideoAdProvider();
            biddingHiSavanaVideoAdProvider2.i(strB);
            a().put(strB, biddingHiSavanaVideoAdProvider2);
            return biddingHiSavanaVideoAdProvider2;
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public in.b<?> c() {
        String strE = e();
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        if (this.f50379g == null) {
            TRewardedAd tRewardedAd = new TRewardedAd(Utils.a(), strE);
            this.f50379g = tRewardedAd;
            tRewardedAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
        }
        return this.f50379g;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void g() {
        TRewardedAd tRewardedAd = this.f50379g;
        if (tRewardedAd != null) {
            tRewardedAd.destroy();
        }
        this.f50379g = null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void j(Activity topActivity, Map<String, ? extends Object> map) {
        TRewardedAd tRewardedAd;
        Intrinsics.g(topActivity, "topActivity");
        if (com.transsion.ad.strategy.b.f50584a.d(map) && (tRewardedAd = this.f50379g) != null) {
            tRewardedAd.setContainVulgarContent(true);
        }
        TRewardedAd tRewardedAd2 = this.f50379g;
        if (tRewardedAd2 != null) {
            tRewardedAd2.show(topActivity);
        }
    }
}
