package com.transsion.ad.middle.icon;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.mediation.ad.TNativeAd;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.gslb.Worker;
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
public final class HiSavanaIconAdManager extends TAdListener {
    private boolean isLoading;
    private WrapperAdListener mListener;
    private String mSceneId;
    private TNativeAd tNativeAd;

    private final void dispense() {
        WrapperAdListener wrapperAdListener;
        TNativeAd tNativeAd = this.tNativeAd;
        List<TAdNativeInfo> nativeAdInfo = tNativeAd != null ? tNativeAd.getNativeAdInfo() : null;
        if (nativeAdInfo == null || (wrapperAdListener = this.mListener) == null) {
            return;
        }
        wrapperAdListener.onHiIconAdReady(nativeAdInfo);
    }

    private final String getClassTag() {
        String simpleName = HiSavanaIconAdManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final String getPlacementId() {
        String strB = wq.a.f79581a.b(getSceneId());
        return strB == null ? "" : strB;
    }

    public final void destroy() {
        this.mListener = null;
        TNativeAd tNativeAd = this.tNativeAd;
        if (tNativeAd != null) {
            tNativeAd.destroy();
        }
        this.tNativeAd = null;
    }

    public final TNativeAd getNativeAd() {
        return this.tNativeAd;
    }

    public final String getSceneId() {
        return this.mSceneId;
    }

    public final void loadAd() {
        if (!HiSavanaAdManager.f50400a.f()) {
            WrapperAdListener wrapperAdListener = this.mListener;
            if (wrapperAdListener != null) {
                wrapperAdListener.onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "广告SDK没有初始化"));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(getPlacementId())) {
            WrapperAdListener wrapperAdListener2 = this.mListener;
            if (wrapperAdListener2 != null) {
                wrapperAdListener2.onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "当前场景配置不存在"));
                return;
            }
            return;
        }
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        if (this.tNativeAd == null) {
            TNativeAd tNativeAd = new TNativeAd(Utils.a(), getPlacementId());
            this.tNativeAd = tNativeAd;
            tNativeAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdListener(this).build());
            com.transsion.ad.a.B(com.transsion.ad.a.f50276a, getClassTag() + " --> loadAd() --> mPlacementId = " + getPlacementId() + " --> create TNativeAd() =================== ", false, 2, null);
        }
        TNativeAd tNativeAd2 = this.tNativeAd;
        if (tNativeAd2 != null) {
            tNativeAd2.loadAd();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClosed(int i11) {
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClosed(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        WrapperAdListener wrapperAdListener;
        this.isLoading = false;
        if (tAdErrorCode == null || (wrapperAdListener = this.mListener) == null) {
            return;
        }
        wrapperAdListener.onError(new TAdErrorCode(tAdErrorCode.getErrorCode(), tAdErrorCode.getErrorMessage() + "-- placementId = " + getPlacementId()));
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
        this.isLoading = false;
        dispense();
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onNativeFeedClicked(int i11, TAdNativeInfo tAdNativeInfo) {
        super.onNativeFeedClicked(i11, tAdNativeInfo);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onNativeFeedShow(int i11, TAdNativeInfo tAdNativeInfo) {
        super.onNativeFeedShow(i11, tAdNativeInfo);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onNativeFeedShow(i11, tAdNativeInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShow(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShowError(TAdErrorCode tAdErrorCode) {
        super.onShowError(tAdErrorCode);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShowError(tAdErrorCode);
        }
    }

    public final void setListener(WrapperAdListener listener) {
        Intrinsics.g(listener, "listener");
        this.mListener = listener;
    }

    public final void setSceneId(String sceneId) {
        Intrinsics.g(sceneId, "sceneId");
        this.mSceneId = sceneId;
    }
}
