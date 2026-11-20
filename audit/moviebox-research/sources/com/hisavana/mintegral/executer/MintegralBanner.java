package com.hisavana.mintegral.executer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.check.ExistsCheck;
import com.hisavana.mintegral.check.MBridgeSDKManager;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MintegralBanner extends BaseBanner {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MBBannerView f41977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BannerAdListener f41978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BannerSize f41979l;

    public MintegralBanner(Context context, Network network, int i11) {
        BannerSize bannerSize;
        BannerSize bannerSize2;
        super(context, network);
        this.f41978k = new BannerAdListener() { // from class: com.hisavana.mintegral.executer.MintegralBanner.1
            @Override // com.mbridge.msdk.out.BannerAdListener
            public void closeFullScreen(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads closeFullScreen");
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onClick(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onClick");
                MintegralBanner.this.adClicked(null);
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onCloseBanner(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onCloseBanner");
                MintegralBanner.this.adClosed();
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLeaveApp(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onLeaveApp");
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
                MintegralBanner.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, str));
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral onLoadFailed message：" + str);
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLoadSuccessed(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onLoadSuccessed");
                MintegralBanner.this.adLoaded();
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void onLogImpression(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onAdShowed");
                MintegralBanner.this.adImpression(null);
            }

            @Override // com.mbridge.msdk.out.BannerAdListener
            public void showFullScreen(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads showFullScreen");
            }
        };
        if (i11 != 0) {
            if (i11 == 1) {
                bannerSize2 = new BannerSize(5, 320, 100);
            } else if (i11 == 2 || i11 == 3) {
                bannerSize2 = new BannerSize(2, 0, 0);
            } else {
                bannerSize = new BannerSize(4, 0, 0);
            }
            this.f41979l = bannerSize2;
            return;
        }
        bannerSize = new BannerSize(4, 0, 0);
        this.f41979l = bannerSize;
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    public int dpToPx(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.hisavana.common.base.BaseBanner
    public View getBanner() {
        WeakReference<Context> weakReference;
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "getBanner " + this.f41977j);
        if (this.f41977j == null && (weakReference = this.mContext) != null && weakReference.get() != null) {
            MBBannerView mBBannerView = new MBBannerView(f.a());
            this.f41977j = mBBannerView;
            mBBannerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        return this.f41977j;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onBannerDestroy");
        MBBannerView mBBannerView = this.f41977j;
        if (mBBannerView != null) {
            mBBannerView.release();
            this.f41977j = null;
        }
        this.f41978k = null;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        Network network;
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onBannerLoad");
        if (MBridgeSDKManager.getInstance().getCurrentState() != MBridgeSDKManager.MBridgeSDKInitializeState.SDK_STATE_INITIALIZE_SUCCESS) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_SOURCE_INIT_FAILED, "Mintegral Ads failed to load ad error with param empty"));
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "init onError ");
            return;
        }
        if (this.f41977j != null && (network = this.mNetwork) != null && !TextUtils.isEmpty(network.getCodeSeatId()) && this.f41978k != null) {
            if (!TextUtils.isEmpty(this.mNetwork.getBidInfo() != null ? this.mNetwork.getBidInfo().getPayload() : null)) {
                this.f41977j.init(this.f41979l, "", this.mNetwork.getCodeSeatId());
                this.f41977j.setBannerAdListener(this.f41978k);
                this.f41977j.loadFromBid(this.mNetwork.getBidInfo().getPayload());
                return;
            }
        }
        adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad error with param is empty"));
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void pauseAd() {
        MBBannerView mBBannerView = this.f41977j;
        if (mBBannerView != null) {
            mBBannerView.onPause();
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void resumeAd() {
        MBBannerView mBBannerView = this.f41977j;
        if (mBBannerView != null) {
            mBBannerView.onResume();
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "showBanner");
        MBBannerView mBBannerView = this.f41977j;
        if (mBBannerView == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e(ExistsCheck.MINTEGRAL_TAG, "showBanner show error,mbBannerView is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = mBBannerView.getLayoutParams();
        layoutParams.width = dpToPx(this.f41977j.getContext(), this.f41979l.getWidth());
        layoutParams.height = dpToPx(this.f41977j.getContext(), this.f41979l.getHeight());
        this.f41977j.setLayoutParams(layoutParams);
        this.f41977j.setVisibility(0);
    }
}
