package com.mbridge.msdk.advanced.a;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f f42745a = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f42746b = "ResManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f42747c = 1;

    public static CampaignEx a(MBNativeAdvancedView mBNativeAdvancedView, String str, String str2, String str3, int i11, boolean z11, boolean z12) {
        g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            gVarB = i.a();
        }
        long jAb = gVarB.ab() * 1000;
        long jAc = gVarB.ac() * 1000;
        if (f42745a == null) {
            f42745a = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        f42745a.b(jAc, str2);
        if (f42745a == null) {
            f42745a = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        List<CampaignEx> listB = f42745a.b(str2, 0, 0, f42747c);
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = listB.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = jCurrentTimeMillis - jAb;
        if (!z11) {
            if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < jCurrentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j11)) {
                ad.a(f42746b, "========已经超了缓存时间");
                if (campaignEx.isSpareOffer(jAb, jAc) || mBNativeAdvancedView == null) {
                    return null;
                }
                mBNativeAdvancedView.setVisibility(8);
                return null;
            }
            if (!a(mBNativeAdvancedView, campaignEx, str, str2, i11, z12)) {
                return null;
            }
            ad.b(f42746b, "cache campain is picked:" + campaignEx.getAppName());
            return a(campaignEx);
        }
        if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < jCurrentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j11)) {
            if (a(mBNativeAdvancedView, campaignEx, str, str2, i11, z12) && campaignEx.isSpareOffer(jAb, jAc)) {
                return a(campaignEx);
            }
            if (campaignEx.isSpareOffer(jAb, jAc) || mBNativeAdvancedView == null) {
                return null;
            }
            mBNativeAdvancedView.setVisibility(8);
            return null;
        }
        if (!a(mBNativeAdvancedView, campaignEx, str, str2, i11, z12)) {
            return null;
        }
        ad.b(f42746b, "cache campain is picked:" + campaignEx.getAppName());
        return a(campaignEx);
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    private static void a(final MBNativeAdvancedView mBNativeAdvancedView, final String str, final CampaignEx campaignEx, final String str2, final String str3, int i11) {
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.advanced.common.d.a().c(campaignEx.getId()).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).b(str3).a(campaignEx.isBidCampaign()), str3);
        com.mbridge.msdk.advanced.signal.b bVar = new com.mbridge.msdk.advanced.signal.b(mBNativeAdvancedView.getContext(), str2, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(i11);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(bVar);
        final MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.advanced.a.d.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i12) {
                super.a(webView, i12);
                if (i12 != 1) {
                    mBNativeAdvancedView.setH5Ready(false);
                    ad.a("WindVaneWebView", "======渲染失败");
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str3, "readyState 2", jCurrentTimeMillis, 3);
                    return;
                }
                com.mbridge.msdk.advanced.common.c.a(str2 + str3 + campaignEx.getRequestId(), true);
                mBNativeAdvancedView.setH5Ready(true);
                ad.a("WindVaneWebView", "======渲染成功：ready");
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str3, "", jCurrentTimeMillis, 1);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i12, String str4, String str5) {
                super.a(webView, i12, str4, str5);
                mBNativeAdvancedView.setH5Ready(false);
                ad.a("WindVaneWebView", "======渲染失败");
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str3, "error code:" + i12 + str4, jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                mBNativeAdvancedView.setH5Ready(false);
                ad.a("WindVaneWebView", "======渲染失败");
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str3, "error url:" + sslError.getUrl(), jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str4) {
                super.a(webView, str4);
                if (!campaignEx.isHasMBTplMark()) {
                    com.mbridge.msdk.advanced.common.c.a(str2 + str3 + campaignEx.getRequestId(), true);
                    mBNativeAdvancedView.setH5Ready(true);
                    ad.a("WindVaneWebView", "======渲染成功：finish");
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str3, "", jCurrentTimeMillis, 1);
                }
                com.mbridge.msdk.advanced.signal.a.a(webView);
            }
        });
        if (advancedNativeWebview.isDestoryed()) {
            mBNativeAdvancedView.setH5Ready(false);
            com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str3, "webview had destory", jCurrentTimeMillis, 3);
            return;
        }
        ad.a(f42746b, "======开始渲染：" + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.d.2
            @Override // java.lang.Runnable
            public final void run() {
                advancedNativeWebview.loadUrl(str);
            }
        });
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (f42745a == null) {
            f42745a = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        f42745a.b(arrayList, str);
    }

    public static void a(String str) {
        if (f42745a == null) {
            f42745a = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        f42745a.a(str, 0, f42747c);
    }

    public static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2) {
        boolean zA;
        boolean z11 = false;
        if (mBNativeAdvancedView == null) {
            ad.b(f42746b, "mbAdvancedNativeView  is null");
            return false;
        }
        if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            zA = true;
        } else {
            zA = mBNativeAdvancedView.isVideoReady();
            ad.b(f42746b, "======isReady isVideoReady:" + zA);
        }
        if (zA && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            zA = com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId());
            ad.b(f42746b, "======isReady getAdZip:" + zA);
        }
        if (zA && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            zA = com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId());
            ad.b(f42746b, "======isReady getAdHtml:" + zA);
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            ad.b(f42746b, "======isReady getAdHtml  getAdZip all are empty");
        } else {
            z11 = zA;
        }
        if (!z11 || TextUtils.isEmpty(campaignEx.getendcard_url())) {
            return z11;
        }
        boolean zIsEndCardReady = mBNativeAdvancedView.isEndCardReady();
        ad.b(f42746b, "======isReady isEndCardReady:" + zIsEndCardReady);
        return zIsEndCardReady;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    /* JADX WARN: Code duplicated, block: B:27:0x008f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x009e  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x0073, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x00c7, please report this as an issue */
    private static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2, int i11, boolean z11) {
        boolean zA;
        boolean z12;
        String strB;
        String h5ResAddress;
        if (campaignEx == null) {
            return false;
        }
        mBNativeAdvancedView.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            zA = com.mbridge.msdk.videocommon.download.b.getInstance().a(298, str2, campaignEx.isBidCampaign());
            if (zA) {
            }
            z12 = zA;
            if (!TextUtils.isEmpty(campaignEx.getendcard_url()) && !mBNativeAdvancedView.isEndCardReady() && !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getendcard_url()))) {
                mBNativeAdvancedView.setEndCardReady(true);
            }
            if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBNativeAdvancedView.isH5Ready()) {
                h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip());
                if (TextUtils.isEmpty(h5ResAddress)) {
                    z12 = false;
                } else {
                    if (com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId())) {
                        mBNativeAdvancedView.setH5Ready(true);
                    } else {
                        a(mBNativeAdvancedView, h5ResAddress, campaignEx, str, str2, i11);
                        if (!z11) {
                            z12 = false;
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBNativeAdvancedView.isH5Ready()) {
                strB = b(campaignEx.getAdHtml());
                if (!TextUtils.isEmpty(strB)) {
                    return false;
                }
                if (com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId())) {
                    mBNativeAdvancedView.setH5Ready(true);
                    if (campaignEx.isMraid()) {
                        mBNativeAdvancedView.setVideoReady(true);
                    }
                    return true;
                }
                a(mBNativeAdvancedView, strB, campaignEx, str, str2, i11);
                if (!z11) {
                    return false;
                }
            }
            return z12;
        }
        zA = true;
        mBNativeAdvancedView.setVideoReady(true);
        z12 = zA;
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            mBNativeAdvancedView.setEndCardReady(true);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip());
            if (TextUtils.isEmpty(h5ResAddress)) {
                if (com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId())) {
                    mBNativeAdvancedView.setH5Ready(true);
                } else {
                    a(mBNativeAdvancedView, h5ResAddress, campaignEx, str, str2, i11);
                    if (!z11) {
                        z12 = false;
                    }
                }
            } else {
                z12 = false;
            }
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip())) {
            strB = b(campaignEx.getAdHtml());
            if (!TextUtils.isEmpty(strB)) {
                return false;
            }
            if (com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId())) {
                mBNativeAdvancedView.setH5Ready(true);
                if (campaignEx.isMraid()) {
                    mBNativeAdvancedView.setVideoReady(true);
                }
                return true;
            }
            a(mBNativeAdvancedView, strB, campaignEx, str, str2, i11);
            if (!z11) {
                return false;
            }
        }
        return z12;
    }

    private static String b(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            return "file:///" + file.getAbsolutePath();
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Exception e11) {
                e11.getMessage();
                return "";
            }
        }
    }
}
