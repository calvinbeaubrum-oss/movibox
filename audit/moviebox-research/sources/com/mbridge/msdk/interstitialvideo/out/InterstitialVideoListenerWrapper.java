package com.mbridge.msdk.interstitialvideo.out;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class InterstitialVideoListenerWrapper implements RewardVideoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterstitialVideoListener f45188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f45189b = new Handler(Looper.getMainLooper());

    public InterstitialVideoListenerWrapper(InterstitialVideoListener interstitialVideoListener) {
        this.f45188a = interstitialVideoListener;
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onAdClose(final MBridgeIds mBridgeIds, final RewardInfo rewardInfo) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.5
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onAdClose(mBridgeIds, rewardInfo);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onAdCloseWithIVReward(final MBridgeIds mBridgeIds, final boolean z11, final int i11) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.10
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onAdCloseWithIVReward(mBridgeIds, new RewardInfo(z11, i11));
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onAdShow(final MBridgeIds mBridgeIds) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onAdShow(mBridgeIds);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onEndcardShow(final MBridgeIds mBridgeIds) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.9
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onEndcardShow(mBridgeIds);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onLoadSuccess(mBridgeIds);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onShowFail(final MBridgeIds mBridgeIds, final String str) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.6
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onShowFail(mBridgeIds, str);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onVideoAdClicked(final MBridgeIds mBridgeIds) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.7
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onVideoAdClicked(mBridgeIds);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onVideoComplete(final MBridgeIds mBridgeIds) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.8
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onVideoComplete(mBridgeIds);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onVideoLoadFail(final MBridgeIds mBridgeIds, final String str) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onVideoLoadFail(mBridgeIds, str);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public void onVideoLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f45189b.post(new Runnable() { // from class: com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListenerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f45188a != null) {
                    InterstitialVideoListenerWrapper.this.f45188a.onVideoLoadSuccess(mBridgeIds);
                }
            }
        });
    }
}
