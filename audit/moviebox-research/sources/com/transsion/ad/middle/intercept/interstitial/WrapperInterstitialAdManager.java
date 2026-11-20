package com.transsion.ad.middle.intercept.interstitial;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager;
import com.transsion.ad.middle.intercept.BaseNonAdManager;
import com.transsion.ad.middle.intercept.BaseWrapperAdManager;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tq.d;

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
public final class WrapperInterstitialAdManager extends BaseWrapperAdManager {
    public static final WrapperInterstitialAdManager INSTANCE = new WrapperInterstitialAdManager();
    private static boolean isInterceptFinalAd;

    private WrapperInterstitialAdManager() {
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public int getAdType() {
        return 4;
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public BaseNonAdManager getNonAdManager() {
        return new d();
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void loadHiSavanaAd(String sceneId, WrapperAdListener wrapperAdListener) {
        BaseInterceptHiSavanaAdManager listener;
        Intrinsics.g(sceneId, "sceneId");
        HiSavanaInterstitialAdManager hiSavanaInterstitialAdManagerB = HiSavanaInterstitialAdManager.Companion.b(sceneId);
        Unit unit = null;
        if (hiSavanaInterstitialAdManagerB != null && (listener = hiSavanaInterstitialAdManagerB.setListener(wrapperAdListener)) != null) {
            BaseInterceptHiSavanaAdManager.load$default(listener, null, 1, null);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            loadAdShowFinal();
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void onAdDestroy(String str) {
        HiSavanaInterstitialAdManager hiSavanaInterstitialAdManagerB = HiSavanaInterstitialAdManager.Companion.b(str);
        if (hiSavanaInterstitialAdManagerB != null) {
            hiSavanaInterstitialAdManagerB.destroy();
        }
        getNonAdManager().c();
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager, com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        if (isInterceptFinalAd) {
            WrapperAdListener mListener = getMListener();
            if (mListener != null) {
                mListener.onError(tAdErrorCode);
            }
        } else {
            super.onError(tAdErrorCode);
        }
        isInterceptFinalAd = false;
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager, com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
        isInterceptFinalAd = false;
    }

    public final void setInterceptFinal(boolean z11) {
        isInterceptFinalAd = z11;
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void showHiSavanaAd(String sceneId, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map) {
        Unit unit;
        BaseInterceptHiSavanaAdManager listener;
        Intrinsics.g(sceneId, "sceneId");
        HiSavanaInterstitialAdManager hiSavanaInterstitialAdManagerB = HiSavanaInterstitialAdManager.Companion.b(sceneId);
        if (hiSavanaInterstitialAdManagerB == null || (listener = hiSavanaInterstitialAdManagerB.setListener(wrapperAdListener)) == null) {
            unit = null;
        } else {
            listener.showAd(map);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            showInnerAdShowFinal();
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void showMbAd(String sceneId, AdPlans adPlans, WrapperAdListener wrapperAdListener) {
        Intrinsics.g(sceneId, "sceneId");
        getNonAdManager().g(wrapperAdListener).h(adPlans, sceneId);
    }
}
