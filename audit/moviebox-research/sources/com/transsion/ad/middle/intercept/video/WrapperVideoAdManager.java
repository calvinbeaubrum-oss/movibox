package com.transsion.ad.middle.intercept.video;

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
public final class WrapperVideoAdManager extends BaseWrapperAdManager {
    public static final WrapperVideoAdManager INSTANCE = new WrapperVideoAdManager();

    private WrapperVideoAdManager() {
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public int getAdType() {
        return 3;
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public BaseNonAdManager getNonAdManager() {
        return new g();
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void loadHiSavanaAd(String sceneId, WrapperAdListener wrapperAdListener) {
        BaseInterceptHiSavanaAdManager listener;
        Intrinsics.g(sceneId, "sceneId");
        HiSavanaVideoAdManager hiSavanaVideoAdManagerB = HiSavanaVideoAdManager.Companion.b(sceneId);
        Unit unit = null;
        if (hiSavanaVideoAdManagerB != null && (listener = hiSavanaVideoAdManagerB.setListener(wrapperAdListener)) != null) {
            BaseInterceptHiSavanaAdManager.load$default(listener, null, 1, null);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            loadAdShowFinal();
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void onAdDestroy(String str) {
        HiSavanaVideoAdManager hiSavanaVideoAdManagerB = HiSavanaVideoAdManager.Companion.b(str);
        if (hiSavanaVideoAdManagerB != null) {
            hiSavanaVideoAdManagerB.destroy();
        }
        getNonAdManager().c();
    }

    @Override // com.transsion.ad.middle.intercept.BaseWrapperAdManager
    public void showHiSavanaAd(String sceneId, WrapperAdListener wrapperAdListener, Map<String, ? extends Object> map) {
        Unit unit;
        BaseInterceptHiSavanaAdManager listener;
        Intrinsics.g(sceneId, "sceneId");
        HiSavanaVideoAdManager hiSavanaVideoAdManagerB = HiSavanaVideoAdManager.Companion.b(sceneId);
        if (hiSavanaVideoAdManagerB == null || (listener = hiSavanaVideoAdManagerB.setListener(wrapperAdListener)) == null) {
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
