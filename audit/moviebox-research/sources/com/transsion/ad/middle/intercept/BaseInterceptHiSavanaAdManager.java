package com.transsion.ad.middle.intercept;

import android.app.Activity;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.interfacz.TAdListener;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.gslb.Worker;
import java.util.Map;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
public abstract class BaseInterceptHiSavanaAdManager extends TAdListener {
    public static final a Companion = new a(null);
    public static final String HI_SAVANA_AD_SHOW_ERROR_IS_SHOWING_TAG = "当前正在展示Hi广告";
    private boolean isShowing;
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

    public BaseInterceptHiSavanaAdManager(String mSceneId) {
        Intrinsics.g(mSceneId, "mSceneId");
        this.mSceneId = mSceneId;
    }

    private final String getHiId() {
        return wq.a.f79581a.b(this.mSceneId);
    }

    private final void innerLoad() {
        if (!HiSavanaAdManager.f50400a.f()) {
            com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
            String classTag = getClassTag();
            String str = this.mSceneId;
            com.transsion.ad.a.F(aVar, classTag + " --> innerLoad() --> 广告SDK没有初始化 --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
            WrapperAdListener wrapperAdListener = this.mListener;
            if (wrapperAdListener != null) {
                wrapperAdListener.onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "广告SDK没有初始化 --> mSceneId = " + this.mSceneId));
                return;
            }
            return;
        }
        if (this.isShowing) {
            com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
            String classTag2 = getClassTag();
            String str2 = this.mSceneId;
            com.transsion.ad.a.F(aVar2, classTag2 + " --> innerLoad() --> 当前正在展示Hi广告 --> mSceneId = " + str2 + " -- hiId = " + wq.a.f79581a.b(str2), false, 2, null);
            WrapperAdListener wrapperAdListener2 = this.mListener;
            if (wrapperAdListener2 != null) {
                wrapperAdListener2.onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, HI_SAVANA_AD_SHOW_ERROR_IS_SHOWING_TAG));
                return;
            }
            return;
        }
        in.b<?> adInstance = getAdInstance();
        if (adInstance != null && !adInstance.hasAd()) {
            in.b<?> adInstance2 = getAdInstance();
            if (adInstance2 != null) {
                adInstance2.loadAd();
                return;
            }
            return;
        }
        com.transsion.ad.a aVar3 = com.transsion.ad.a.f50276a;
        String classTag3 = getClassTag();
        boolean z11 = this.isShowing;
        in.b<?> adInstance3 = getAdInstance();
        Boolean boolValueOf = adInstance3 != null ? Boolean.valueOf(adInstance3.hasAd()) : null;
        String str3 = this.mSceneId;
        com.transsion.ad.a.F(aVar3, classTag3 + " --> innerLoad() --> 广告已经加载完成 不需要重复加载了 -- isShowing = " + z11 + " -- hasAd = " + boolValueOf + " --> mSceneId = " + str3 + " -- hiId = " + wq.a.f79581a.b(str3), false, 2, null);
        WrapperAdListener wrapperAdListener3 = this.mListener;
        if (wrapperAdListener3 != null) {
            wrapperAdListener3.onLoad();
        }
    }

    private final void innerReset() {
        in.b<?> adInstance = getAdInstance();
        if (adInstance != null) {
            adInstance.destroy();
        }
        reset();
        this.mListener = null;
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClassTag() + " --> destroy() --> 资源回收 -- tInterstitialAd = null -->  load() --> mSceneId = " + this.mSceneId + " -- hiId = " + getHiId(), false, 2, null);
        load("innerReset() -- 预加载一个插屏广告");
    }

    private final void innerShowAd(Map<String, ? extends Object> map) {
        Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB == null) {
            com.transsion.ad.a.H(com.transsion.ad.a.f50276a, getClassTag() + " --> null == topActivity --> mSceneId = " + this.mSceneId + " -- hiId = " + getHiId(), false, 2, null);
            WrapperAdListener wrapperAdListener = this.mListener;
            if (wrapperAdListener != null) {
                wrapperAdListener.onShowError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "null == topActivity --> mSceneId = " + this.mSceneId));
                return;
            }
            return;
        }
        if (this.isShowing) {
            com.transsion.ad.a.H(com.transsion.ad.a.f50276a, getClassTag() + " --> showAd() --> isShowing = " + this.isShowing + " -- 当前正在展示插屏广告，return -- hiId = " + getHiId(), false, 2, null);
            WrapperAdListener wrapperAdListener2 = this.mListener;
            if (wrapperAdListener2 != null) {
                wrapperAdListener2.onShowError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "showAd() --> 当前正在展示Hi广告 --> mSceneId = " + this.mSceneId));
                return;
            }
            return;
        }
        in.b<?> adInstance = getAdInstance();
        if (adInstance != null && adInstance.hasAd()) {
            com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClassTag() + " --> showAd() --> 开始展示广告 --> mSceneId = " + this.mSceneId + " -- hiId = " + getHiId(), false, 2, null);
            in.b<?> adInstance2 = getAdInstance();
            if (adInstance2 != null) {
                adInstance2.enterScene(this.mSceneId, 1);
            }
            show(activityB, map);
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClassTag() + " --> showAd() --> 开始展示广告 -- 当前还没有广告 --> mSceneId = " + this.mSceneId + " -- hiId = " + getHiId(), false, 2, null);
        WrapperAdListener wrapperAdListener3 = this.mListener;
        if (wrapperAdListener3 != null) {
            wrapperAdListener3.onShowError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "当前还没有广告 --> mSceneId = " + this.mSceneId));
        }
        destroy();
        load("showAd() -- 当前还没有广告 -- load()");
    }

    public static /* synthetic */ void load$default(BaseInterceptHiSavanaAdManager baseInterceptHiSavanaAdManager, String str, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }
        if ((i11 & 1) != 0) {
            str = null;
        }
        baseInterceptHiSavanaAdManager.load(str);
    }

    public final void destroy() {
        setListener(null);
    }

    public abstract in.b<?> getAdInstance();

    public abstract int getAdType();

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void load(String str) {
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str2 = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> load() --> " + str + " --> mSceneId = " + str2 + " -- hiId = " + wq.a.f79581a.b(str2), false, 2, null);
        innerLoad();
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> onClicked() --> source = " + i11 + " --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        vq.b.f79053a.a((128 & 1) != 0 ? "" : null, this.mSceneId, "", Integer.valueOf(i11), getHiId(), getAdType(), (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClicked(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClosed(int i11) {
        this.isShowing = false;
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> onClosed() --> source = " + i11 + " --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onClosed(i11);
        }
        innerReset();
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.H(aVar, classTag + " --> onError() --> errorCode = " + tAdErrorCode + " --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(tAdErrorCode);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> onLoad() --> 广告加载成功 --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onLoad();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onRewarded() {
        super.onRewarded();
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> onRewarded() --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onRewarded();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
        this.isShowing = true;
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> onShow() --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        vq.b.f79053a.f((128 & 1) != 0 ? "" : null, this.mSceneId, "", Integer.valueOf(i11), getHiId(), getAdType(), (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShow(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShowError(TAdErrorCode tAdErrorCode) {
        super.onShowError(tAdErrorCode);
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.H(aVar, classTag + " --> onShowError() --> errorCode = " + tAdErrorCode + " --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onShowError(tAdErrorCode);
        }
    }

    public abstract void reset();

    public final BaseInterceptHiSavanaAdManager setListener(WrapperAdListener wrapperAdListener) {
        this.mListener = wrapperAdListener;
        return this;
    }

    public abstract void show(Activity activity, Map<String, ? extends Object> map);

    public final void showAd(Map<String, ? extends Object> map) {
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String classTag = getClassTag();
        String str = this.mSceneId;
        com.transsion.ad.a.F(aVar, classTag + " --> showAd() --> mSceneId = " + str + " -- hiId = " + wq.a.f79581a.b(str), false, 2, null);
        innerShowAd(map);
    }
}
