package com.transsion.ad.middle;

import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.interfacz.TAdListener;
import com.transsion.ad.middle.icon.WrapperIconBean;
import com.transsion.ad.ps.model.RecommendInfo;
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
public abstract class WrapperAdListener extends TAdListener {
    public void onBannerViewReady(View view) {
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClosed(int i11) {
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClosed(TAdNativeInfo tAdNativeInfo) {
        super.onClosed(tAdNativeInfo);
    }

    public void onDestroy() {
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
    }

    public void onHiIconAdReady(List<TAdNativeInfo> tAdNativeInfos) {
        Intrinsics.g(tAdNativeInfos, "tAdNativeInfos");
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
    }

    public void onMbIconClick(RecommendInfo recommendInfo) {
    }

    public void onMbIconShow(RecommendInfo recommendInfo) {
    }

    public void onNativeInfoReady(TAdNativeInfo tAdNativeInfo) {
    }

    public void onPSDistributionReady(List<RecommendInfo> list) {
    }

    public void onPlanAdShowError(TAdErrorCode tAdErrorCode) {
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onRewarded() {
        super.onRewarded();
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
    }

    public void onStart(String sceneId) {
        Intrinsics.g(sceneId, "sceneId");
    }

    public void onWrapperIconReady(List<WrapperIconBean> list) {
    }
}
