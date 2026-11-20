package com.mbridge.msdk.mbnative.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements NativeListener.NativeAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45622a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NativeListener.NativeAdListener f45623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45624c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f45625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f45626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f45627f;

    public a() {
    }

    public a(NativeListener.NativeAdListener nativeAdListener) {
        this.f45623b = nativeAdListener;
    }

    public final void a(CampaignEx campaignEx, String str) {
        this.f45624c = false;
        NativeListener.NativeAdListener nativeAdListener = this.f45623b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.f45626e == null) {
                this.f45626e = c.m().c();
            }
            if (TextUtils.isEmpty(this.f45625d)) {
                return;
            }
            com.mbridge.msdk.mbnative.e.a.a(this.f45626e, str, this.f45625d, this.f45627f, campaignEx);
        }
    }

    public final void a(String str) {
        this.f45625d = str;
    }

    public final void a(boolean z11) {
        this.f45627f = z11;
    }

    public final boolean a() {
        return this.f45624c;
    }

    public final void b() {
        this.f45624c = true;
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdClick(Campaign campaign) {
        NativeListener.NativeAdListener nativeAdListener = this.f45623b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdClick(campaign);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdFramesLoaded(List<Frame> list) {
        NativeListener.NativeAdListener nativeAdListener = this.f45623b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdFramesLoaded(list);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoadError(String str) {
        this.f45624c = false;
        NativeListener.NativeAdListener nativeAdListener = this.f45623b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.f45626e == null) {
                this.f45626e = c.m().c();
            }
            if (TextUtils.isEmpty(this.f45625d)) {
                return;
            }
            com.mbridge.msdk.mbnative.e.a.a(this.f45626e, str, this.f45625d, this.f45627f, (CampaignEx) null);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoaded(List<Campaign> list, int i11) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        try {
            this.f45624c = false;
            synchronized (list) {
                copyOnWriteArrayList = new CopyOnWriteArrayList(list);
            }
            if (this.f45623b != null) {
                if (copyOnWriteArrayList.size() > 0) {
                    this.f45623b.onAdLoaded(copyOnWriteArrayList, i11);
                } else {
                    this.f45623b.onAdLoaded(list, i11);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onLoggingImpression(int i11) {
        NativeListener.NativeAdListener nativeAdListener = this.f45623b;
        if (nativeAdListener != null) {
            nativeAdListener.onLoggingImpression(i11);
        }
    }
}
