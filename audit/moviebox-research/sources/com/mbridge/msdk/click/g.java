package com.mbridge.msdk.click;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends AppletSchemeCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativeListener.NativeTrackingListener f43138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CampaignEx f43139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppletsModel f43140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f43141d;

    public g(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        this.f43138a = nativeTrackingListener;
        this.f43139b = campaignEx;
        this.f43140c = appletsModel;
        this.f43141d = aVar;
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    public final void onRequestFailed(int i11, String str, String str2) {
        CampaignEx campaignEx = this.f43139b;
        if (campaignEx == null || this.f43140c == null) {
            return;
        }
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f43138a;
            if (nativeTrackingListener != null) {
                try {
                    nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("DefaultAppletSchemeCallBack", e11.getMessage());
                    }
                }
            }
            this.f43140c.setUserClick(false);
            this.f43140c.setRequestingFinish();
            this.f43139b.setClickURL(str2);
            a aVar = this.f43141d;
            if (aVar != null) {
                try {
                    aVar.a(this.f43139b);
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("DefaultAppletSchemeCallBack", e12.getMessage());
                    }
                }
            }
        } catch (Exception e13) {
            if (MBridgeConstans.DEBUG) {
                ad.b("DefaultAppletSchemeCallBack", e13.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    public final void onRequestStart() {
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    public final void onRequestSuccess(String str) {
        CampaignEx campaignEx = this.f43139b;
        if (campaignEx == null || this.f43140c == null) {
            return;
        }
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f43138a;
            if (nativeTrackingListener != null) {
                try {
                    nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("DefaultAppletSchemeCallBack", e11.getMessage());
                    }
                }
            }
            this.f43140c.setUserClick(false);
            this.f43140c.setRequestingFinish();
            this.f43139b.setDeepLinkUrl(str);
            a aVar = this.f43141d;
            if (aVar != null) {
                try {
                    aVar.a(this.f43139b);
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("DefaultAppletSchemeCallBack", e12.getMessage());
                    }
                }
            }
        } catch (Exception e13) {
            if (MBridgeConstans.DEBUG) {
                ad.b("DefaultAppletSchemeCallBack", e13.getMessage());
            }
        }
    }
}
