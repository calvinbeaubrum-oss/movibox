package com.hisavana.mintegral.executer;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.j;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.check.ExistsCheck;
import com.mbridge.msdk.out.MBSplashHandler;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MintegralSplash extends BaseSplash {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MBSplashHandler f41991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MBSplashLoadListener f41992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MBSplashShowListener f41993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f41994m;

    /* JADX INFO: renamed from: com.hisavana.mintegral.executer.MintegralSplash$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements MBSplashLoadListener {
        public AnonymousClass1() {
        }

        public final /* synthetic */ void b() {
            MintegralSplash.this.adLoaded();
        }

        @Override // com.mbridge.msdk.out.MBSplashLoadListener
        public void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z11) {
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "isSupportZoomOut");
        }

        @Override // com.mbridge.msdk.out.MBSplashLoadListener
        public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i11) {
            MintegralSplash.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad with error message: " + str));
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onError msg " + str);
        }

        @Override // com.mbridge.msdk.out.MBSplashLoadListener
        public void onLoadSuccessed(MBridgeIds mBridgeIds, int i11) {
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onLoadSuccessed");
            new Handler().postDelayed(new Runnable() { // from class: com.hisavana.mintegral.executer.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42001a.b();
                }
            }, 200L);
        }
    }

    public MintegralSplash(Context context, Network network) {
        super(context, network);
        this.f41992k = new AnonymousClass1();
        this.f41993l = new MBSplashShowListener() { // from class: com.hisavana.mintegral.executer.MintegralSplash.2
            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onAdClicked(MBridgeIds mBridgeIds) {
                MintegralSplash.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdClicked");
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onAdTick(MBridgeIds mBridgeIds, long j11) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdTick" + j11);
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onDismiss(MBridgeIds mBridgeIds, int i11) {
                if (i11 == 1) {
                    MintegralSplash.this.onSkipClick();
                }
                if (i11 == 2) {
                    MintegralSplash.this.onTimeReach();
                }
                MintegralSplash.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onDismiss" + i11);
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onShowFailed(MBridgeIds mBridgeIds, String str) {
                MintegralSplash.this.onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Mintegral Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onShowFailed,error msg，" + str);
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onShowSuccessed(MBridgeIds mBridgeIds) {
                MintegralSplash.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onShowSuccessed");
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onZoomOutPlayFinish(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onZoomOutPlayFinish");
            }

            @Override // com.mbridge.msdk.out.MBSplashShowListener
            public void onZoomOutPlayStart(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onZoomOutPlayStart");
            }
        };
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void addLogoLayout(View view) {
        if (view == null || this.f41991j == null) {
            return;
        }
        int iF = j.f();
        int i11 = iF > 0 ? (int) (((double) iF) * 0.2d) : 0;
        if (i11 == 0) {
            return;
        }
        this.f41991j.setLogoView(view, j.g(), i11);
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        MBSplashHandler mBSplashHandler = this.f41991j;
        if (mBSplashHandler != null) {
            mBSplashHandler.onDestroy();
        }
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseSplash
    public View getSplash() {
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onSplashLoad");
        if (f.a() != null) {
            return new View(f.a().getApplicationContext());
        }
        return null;
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashShow() {
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashStartLoad() {
        Network network = this.mNetwork;
        if (network != null && !TextUtils.isEmpty(network.getCodeSeatId()) && this.f41992k != null && this.f41993l != null) {
            if (!TextUtils.isEmpty(this.mNetwork.getBidInfo() != null ? this.mNetwork.getBidInfo().getPayload() : null)) {
                MBSplashHandler mBSplashHandler = new MBSplashHandler("", this.mNetwork.getCodeSeatId());
                this.f41991j = mBSplashHandler;
                mBSplashHandler.setSplashLoadListener(this.f41992k);
                this.f41991j.setSplashShowListener(this.f41993l);
                this.f41991j.setOrientation(getOrientation());
                this.f41991j.preLoadByToken(this.mNetwork.getBidInfo().getPayload());
                this.f41994m = this.mNetwork.getBidInfo().getPayload();
                return;
            }
        }
        adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad error with param empty"));
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void pauseAd() {
        MBSplashHandler mBSplashHandler = this.f41991j;
        if (mBSplashHandler != null) {
            mBSplashHandler.onPause();
        }
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void resumeAd() {
        MBSplashHandler mBSplashHandler = this.f41991j;
        if (mBSplashHandler != null) {
            mBSplashHandler.onResume();
        }
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.interfacz.IadView
    public void show(WrapTadView wrapTadView, String str, String str2) {
        AdLogUtil adLogUtilLog;
        String str3;
        logTrigerShow(str, str2);
        if (this.f41991j == null || wrapTadView == null || TextUtils.isEmpty(this.f41994m) || !this.f41991j.isReady(this.f41994m)) {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Mintegral Ads failed to load ad with error message: mbSplashHandler is null"));
            adLogUtilLog = AdLogUtil.Log();
            str3 = "onAdShowError";
        } else {
            addLogoLayout(getLogoLayout());
            this.f41991j.show(wrapTadView, this.f41994m);
            adLogUtilLog = AdLogUtil.Log();
            str3 = PushConstants.PUSH_SERVICE_TYPE_SHOW;
        }
        adLogUtilLog.d(ExistsCheck.MINTEGRAL_TAG, str3);
    }
}
