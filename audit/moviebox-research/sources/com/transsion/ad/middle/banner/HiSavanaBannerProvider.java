package com.transsion.ad.middle.banner;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.mediation.ad.TBannerView;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.gslb.Worker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.s;
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
public final class HiSavanaBannerProvider extends TAdListener {
    public static final int AD_BANNER_STATE_ERROR = 2;
    public static final int AD_BANNER_STATE_LOADED = 3;
    public static final int AD_BANNER_STATE_LOADING = 1;
    public static final int AD_BANNER_STATE_NONE = 0;
    public static final int AD_BANNER_STATE_SHOWED = 4;
    public static final a Companion = new a(null);
    private final int adSize;
    private TBannerView adview;
    private int currentState;
    private String mHiSavanaId;
    private WrapperAdListener mListener;
    private final String mSceneId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HiSavanaBannerProvider(String str, int i11) {
        this.mSceneId = str;
        this.adSize = i11;
    }

    private final String getClassTag() {
        String simpleName = HiSavanaBannerProvider.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void destroy() {
        com.transsion.ad.a.v(com.transsion.ad.a.f50276a, getClassTag() + " --> destroy() -- sceneId = " + this.mSceneId, false, 2, null);
        this.mListener = null;
        TBannerView tBannerView = this.adview;
        ViewParent parent = tBannerView != null ? tBannerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.adview);
        }
        TBannerView tBannerView2 = this.adview;
        if (tBannerView2 != null) {
            tBannerView2.destroy();
        }
        this.adview = null;
    }

    public final String getMSceneId() {
        return this.mSceneId;
    }

    public final void loadAd(WrapperAdListener listener, Map<String, ? extends Object> ctxMap) {
        TBannerView tBannerView;
        Intrinsics.g(listener, "listener");
        Intrinsics.g(ctxMap, "ctxMap");
        this.mListener = listener;
        this.mHiSavanaId = wq.a.f79581a.b(this.mSceneId);
        this.currentState = 1;
        if (!HiSavanaAdManager.f50400a.f()) {
            WrapperAdListener wrapperAdListener = this.mListener;
            if (wrapperAdListener != null) {
                wrapperAdListener.onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "HiSavana 广告SDK未初始化 -- sceneId = " + this.mSceneId));
                return;
            }
            return;
        }
        if (this.adview == null) {
            this.adview = new TBannerView(Utils.a());
            if (com.transsion.ad.strategy.b.f50584a.d(ctxMap) && (tBannerView = this.adview) != null) {
                tBannerView.setContainVulgarContent(true);
            }
            TBannerView tBannerView2 = this.adview;
            if (tBannerView2 != null) {
                tBannerView2.setAdSize(this.adSize);
            }
            TBannerView tBannerView3 = this.adview;
            if (tBannerView3 != null) {
                tBannerView3.setAdUnitId(this.mHiSavanaId);
            }
            TBannerView tBannerView4 = this.adview;
            if (tBannerView4 != null) {
                tBannerView4.setHideAdCloseView(true);
            }
            TAdRequestBody tAdRequestBodyBuild = new TAdRequestBody.AdRequestBodyBuild().setAdListener(this).build();
            TBannerView tBannerView5 = this.adview;
            if (tBannerView5 != null) {
                tBannerView5.setRequestBody(tAdRequestBodyBuild);
            }
        }
        TBannerView tBannerView6 = this.adview;
        if (tBannerView6 != null) {
            tBannerView6.loadAd();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        vq.b.f79053a.a((128 & 1) != 0 ? "" : null, this.mSceneId, "", Integer.valueOf(i11), this.mHiSavanaId, 1, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClosed(int i11) {
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        this.currentState = 2;
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(tAdErrorCode);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
        this.currentState = 3;
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onBannerViewReady(this.adview);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
        this.currentState = 4;
        vq.b.f79053a.f((128 & 1) != 0 ? "" : null, this.mSceneId, "", Integer.valueOf(i11), this.mHiSavanaId, 1, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
    }
}
