package com.mbridge.msdk.advanced.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.d.f;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f42672a = "NativeAdvancedLoadManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f42673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f42674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f42675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.advanced.b.b f42676e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MBNativeAdvancedView f42678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f42679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<CampaignEx> f42680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CampaignEx f42681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f42682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f42683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f42685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f42686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f42687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f42688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile boolean f42689r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f42690s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f42691t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f42692u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f42693v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f42694w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f42695x = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Handler f42696y = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.advanced.a.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i11;
            Object obj;
            super.handleMessage(message);
            int i12 = message.what;
            if (i12 == 1) {
                Object obj2 = message.obj;
                int i13 = message.arg1;
                if (obj2 == null || !(obj2 instanceof CampaignEx)) {
                    return;
                }
                CampaignEx campaignEx = (CampaignEx) obj2;
                b.a(b.this, H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i13);
                return;
            }
            if (i12 == 2) {
                Object obj3 = message.obj;
                try {
                    if (obj3 instanceof Bundle) {
                        int i14 = ((Bundle) obj3).getInt("type");
                        if (i14 == 1) {
                            i11 = 880004;
                        } else if (i14 == 2) {
                            i11 = 880007;
                        } else {
                            i11 = i14 == 3 ? 880006 : 880024;
                        }
                        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(i11);
                        String string = ((Bundle) obj3).getString(NotificationCompat.CATEGORY_MESSAGE);
                        CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                        bVar.a(string);
                        bVar.a(campaignEx2);
                        b bVar2 = b.this;
                        bVar2.a(bVar, bVar2.f42686o, b.this.f42687p, campaignEx2);
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880000);
                    bVar3.a((Throwable) e11);
                    b bVar4 = b.this;
                    bVar4.a(bVar3, bVar4.f42686o, b.this.f42687p, (CampaignEx) null);
                    return;
                }
            }
            if (i12 == 3) {
                Object obj4 = message.obj;
                if (obj4 == null || !(obj4 instanceof CampaignEx)) {
                    return;
                }
                b bVar5 = b.this;
                bVar5.b((CampaignEx) obj4, bVar5.f42687p);
                return;
            }
            if (i12 != 4) {
                if (i12 == 5 && (obj = message.obj) != null && (obj instanceof CampaignEx)) {
                    if (b.this.f42678g != null) {
                        b.this.f42678g.setVideoReady(true);
                    }
                    b bVar6 = b.this;
                    bVar6.b((CampaignEx) obj, bVar6.f42687p);
                    return;
                }
                return;
            }
            Object obj5 = message.obj;
            if (obj5 == null || !(obj5 instanceof CampaignEx)) {
                return;
            }
            if (b.this.f42678g != null) {
                b.this.f42678g.setEndCardReady(true);
            }
            b bVar7 = b.this;
            bVar7.b((CampaignEx) obj5, bVar7.f42687p);
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Runnable f42697z = new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.6
        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880010);
            b bVar2 = b.this;
            bVar2.a(bVar, bVar2.f42686o, b.this.f42687p, (CampaignEx) null);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f42677f = com.mbridge.msdk.foundation.controller.c.m().c();

    public b(String str, String str2, long j11) {
        this.f42674c = str;
        this.f42673b = str2;
    }

    private void a(long j11) {
        this.f42696y.postDelayed(this.f42697z, j11);
    }

    private void a(Context context, String str, int i11) {
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.c.b(880025), str, i11, (CampaignEx) null);
                return;
            }
            if (an.a(this.f42673b)) {
                a(new com.mbridge.msdk.foundation.c.b(880032), str, i11, (CampaignEx) null);
                return;
            }
            try {
                d.a(this.f42673b);
            } catch (Throwable th2) {
                ad.b(f42672a, th2.getMessage());
            }
            ad.c(f42672a, "load 开始准备请求参数");
            MBridgeIds mBridgeIds = new MBridgeIds(this.f42674c, this.f42673b);
            f fVar = new f();
            fVar.a(i11);
            fVar.b(this.f42694w);
            fVar.a(this.f42693v);
            fVar.c(this.f42685n);
            fVar.d(this.f42684m);
            e eVarA = com.mbridge.msdk.advanced.d.e.a(context, mBridgeIds, fVar);
            if (eVarA == null) {
                ad.c(f42672a, "load 请求参数为空 load失败");
                a(new com.mbridge.msdk.foundation.c.b(880001), str, i11, (CampaignEx) null);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                eVarA.a("token", str);
            }
            String strD = ai.d(this.f42673b);
            if (!TextUtils.isEmpty(strD)) {
                eVarA.a("j", strD);
            }
            new com.mbridge.msdk.advanced.d.c(context).choiceV3OrV5BySetting(1, eVarA, b(str, i11), str);
        } catch (Exception e11) {
            ad.b(f42672a, e11.getMessage());
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880020);
            bVar.a((Throwable) e11);
            a(bVar, str, i11, (CampaignEx) null);
            this.f42694w = 0;
        }
    }

    public static /* synthetic */ void a(b bVar, CampaignEx campaignEx, String str, boolean z11, String str2) {
        try {
            n nVar = new n();
            nVar.e(2);
            nVar.a("m_download_end");
            if (campaignEx != null) {
                nVar.d(campaignEx.isMraid() ? n.f44338a : n.f44339b);
                nVar.g(campaignEx.getRequestIdNotice());
            }
            nVar.a("url", str);
            nVar.a("scenes", "1");
            if (z11) {
                nVar.b(1);
            } else {
                nVar.b(3);
                nVar.h(str2);
            }
            com.mbridge.msdk.foundation.same.report.d.c.a().a(nVar, campaignEx);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(f42672a, e11.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.mbridge.msdk.foundation.same.report.d.a.a] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static /* synthetic */ void a(b bVar, CampaignUnit campaignUnit, int i11, String str, String str2) {
        ArrayList arrayList;
        final CampaignEx campaignEx = 0;
        campaignEx = 0;
        campaignEx = 0;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            final CampaignEx campaignEx2 = campaignUnit.getAds().get(0);
            campaignEx2.setCampaignUnitId(bVar.f42673b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.9
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.foundation.db.k.a(h.a(b.this.f42677f)).a();
                    m.a(b.this.f42677f, campaignEx2);
                }
            }).start();
            bVar.f42693v = campaignUnit.getSessionId();
            if (campaignEx2.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx2.getAdZip()) || !TextUtils.isEmpty(campaignEx2.getAdHtml()))) {
                if (ai.c(campaignEx2)) {
                    campaignEx2.setRtinsType(ai.c(bVar.f42677f, campaignEx2.getPackageName()) ? 1 : 2);
                }
                if (com.mbridge.msdk.foundation.same.b.a(bVar.f42677f, campaignEx2)) {
                    arrayList.add(campaignEx2);
                } else {
                    ai.a(bVar.f42673b, campaignEx2, com.mbridge.msdk.foundation.same.a.f44388x);
                }
                try {
                    com.mbridge.msdk.foundation.same.b.a(campaignEx2, bVar.f42677f, null, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.advanced.a.b.8
                        @Override // com.mbridge.msdk.foundation.same.b.a
                        public final void a(String str3, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
                            try {
                                com.mbridge.msdk.foundation.same.report.d.c.a().a(str3, bVar2, campaignEx2, b.this.f42677f, campaignEx);
                            } catch (Exception e11) {
                                if (MBridgeConstans.DEBUG) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                    });
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            ad.c(f42672a, "onload load失败 返回的compaign没有可以用的");
            com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880033);
            if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() != 0) {
                campaignEx = campaignUnit.getAds().get(0);
            }
            bVar.a(bVar2, str2, i11, campaignEx);
            return;
        }
        try {
            int i12 = bVar.f42694w + 1;
            bVar.f42694w = i12;
            k kVar = bVar.f42679h;
            if (kVar == null || i12 > kVar.w()) {
                ad.c(f42672a, "onload 重置offset为0");
                bVar.f42694w = 0;
            }
            ad.c(f42672a, "onload 算出 下次的offset是:" + bVar.f42694w);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        ad.c(f42672a, "onload load成功 size:" + arrayList.size());
        CampaignEx campaignEx3 = (CampaignEx) arrayList.get(0);
        if (!TextUtils.isEmpty(campaignEx3.getAdZip()) || (!TextUtils.isEmpty(campaignEx3.getAdHtml()) && campaignEx3.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx3.setHasMBTplMark(true);
            campaignEx3.setIsMraid(false);
        } else {
            campaignEx3.setHasMBTplMark(false);
            campaignEx3.setIsMraid(true);
        }
        bVar.a(campaignEx3, i11);
    }

    public static /* synthetic */ void a(b bVar, final String str, final CampaignEx campaignEx, final int i11) {
        MBNativeAdvancedView mBNativeAdvancedView = bVar.f42678g;
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.advanced.common.d.a().c(campaignEx.getId()).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).b(bVar.f42673b).a(campaignEx.isBidCampaign()), bVar.f42673b);
        com.mbridge.msdk.advanced.signal.b bVar2 = new com.mbridge.msdk.advanced.signal.b(bVar.f42678g.getContext(), bVar.f42674c, bVar.f42673b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar2.a(arrayList);
        bVar2.a(bVar.f42682k);
        bVar2.b(bVar.f42683l);
        bVar.f42678g.setAdvancedNativeSignalCommunicationImpl(bVar2);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final MBNativeAdvancedWebview advancedNativeWebview = bVar.f42678g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            bVar.a(campaignEx, "webview is null", i11);
            return;
        }
        if (advancedNativeWebview.isDestoryed()) {
            bVar.a(campaignEx, "webview is destroyed", i11);
            return;
        }
        advancedNativeWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.advanced.a.b.3
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i12) {
                super.a(webView, i12);
                ad.b("NativeAdvancedLoadManager", "=========readyState: " + i12);
                if (i12 != 1) {
                    b.this.a(campaignEx, "readyState 2", i11);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, b.this.f42673b, "readyState 2", jCurrentTimeMillis, 3);
                    return;
                }
                b.this.f42678g.setH5Ready(true);
                com.mbridge.msdk.advanced.common.c.a(b.this.f42674c + b.this.f42673b + campaignEx.getRequestId(), true);
                b.b(b.this, campaignEx, i11);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, b.this.f42673b, "", jCurrentTimeMillis, 1);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i12, String str2, String str3) {
                super.a(webView, i12, str2, str3);
                ad.b("NativeAdvancedLoadManager", "onReceivedError： " + i12 + "  " + str2 + "  " + str3);
                b.this.a(campaignEx, str2, i11);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, b.this.f42673b, "error code:" + i12 + str2, jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                ad.b("NativeAdvancedLoadManager", "onReceivedSslError: " + sslError.getPrimaryError());
                b.this.a(campaignEx, "onReceivedSslError:" + sslError.getUrl(), i11);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, b.this.f42673b, "error url:" + sslError.getUrl(), jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str2) {
                super.a(webView, str2);
                ad.b("NativeAdvancedLoadManager", "onPageFinished");
                if (!campaignEx.isHasMBTplMark()) {
                    b.this.f42678g.setH5Ready(true);
                    ad.b("NativeAdvancedLoadManager", "=======onPageFinished OK");
                    com.mbridge.msdk.advanced.common.c.a(b.this.f42674c + b.this.f42673b + campaignEx.getRequestId(), true);
                    b.b(b.this, campaignEx, i11);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, b.this.f42673b, "", jCurrentTimeMillis, 1);
                }
                com.mbridge.msdk.advanced.signal.a.a(webView);
            }
        });
        if (advancedNativeWebview.isDestoryed()) {
            bVar.a(new com.mbridge.msdk.foundation.c.b(880031), bVar.f42686o, i11, campaignEx);
            com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, bVar.f42673b, "webview had destory", jCurrentTimeMillis, 3);
            return;
        }
        ad.b(f42672a, "=======开始渲染: " + str);
        Handler handler = bVar.f42696y;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    advancedNativeWebview.loadUrl(str);
                }
            });
        }
    }

    private void a(com.mbridge.msdk.foundation.c.b bVar, int i11, CampaignEx campaignEx) {
        if (this.f42689r) {
            return;
        }
        e();
        if (bVar != null) {
            ad.b(f42672a, "real failed: " + bVar.b());
        }
        this.f42689r = true;
        com.mbridge.msdk.advanced.b.b bVar2 = this.f42676e;
        if (bVar2 != null) {
            bVar2.a(bVar, i11);
        }
    }

    private void a(com.mbridge.msdk.foundation.c.b bVar, int i11, String str) {
        CampaignEx campaignExA = d.a(this.f42678g, this.f42674c, this.f42673b, str, this.f42682k, true, true);
        if (campaignExA == null) {
            a(bVar, i11, campaignExA);
        } else {
            ad.b(f42672a, "load failed cache ");
            a(campaignExA, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar, String str, int i11, CampaignEx campaignEx) {
        if (this.f42688q) {
            this.f42688q = false;
            a(bVar, i11, str);
        } else {
            if (bVar != null) {
                bVar.a(campaignEx);
            }
            a(bVar, i11, campaignEx);
        }
    }

    private void a(CampaignEx campaignEx, int i11) {
        this.f42681j = campaignEx;
        if (d.a(this.f42678g, campaignEx, this.f42674c, this.f42673b)) {
            b(campaignEx, i11);
        } else {
            c(campaignEx, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i11) {
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880009);
        bVar.a(str);
        a(bVar, this.f42686o, i11, campaignEx);
        b(campaignEx, str, 2);
    }

    private com.mbridge.msdk.advanced.d.b b(final String str, final int i11) {
        com.mbridge.msdk.advanced.d.b bVar = new com.mbridge.msdk.advanced.d.b(i11) { // from class: com.mbridge.msdk.advanced.a.b.7
            @Override // com.mbridge.msdk.advanced.d.b
            public final void a(int i12, final String str2) {
                ad.b(b.f42672a, str2);
                ad.c(b.f42672a, "onLoadCompaginFailed load failed errorCode:" + i12 + " msg:" + str2);
                if (b.this.f42696y != null) {
                    b.this.f42696y.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.7.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880002);
                            bVar2.a(str2);
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            b.this.a(bVar2, str, i11, (CampaignEx) null);
                        }
                    });
                }
                b.this.f42694w = 0;
            }

            @Override // com.mbridge.msdk.advanced.d.b
            public final void a(final CampaignUnit campaignUnit, final int i12) {
                try {
                    b bVar2 = b.this;
                    b.a(bVar2, campaignUnit, i12, bVar2.f42673b, str);
                    b.this.f42695x = campaignUnit.getRequestId();
                    b.this.f42680i = campaignUnit.getAds();
                } catch (Exception e11) {
                    ad.b(b.f42672a, e11.getMessage());
                    ad.c(b.f42672a, "onLoadCompaginSuccess 数据刚请求失败");
                    if (b.this.f42696y != null) {
                        b.this.f42696y.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.7.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880003);
                                bVar3.a((Throwable) e11);
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                b bVar4 = b.this;
                                String str2 = str;
                                int i13 = i12;
                                CampaignUnit campaignUnit2 = campaignUnit;
                                bVar4.a(bVar3, str2, i13, (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
                            }
                        });
                    }
                    b.this.f42694w = 0;
                }
            }
        };
        bVar.a(str);
        bVar.setUnitId(this.f42673b);
        bVar.setPlacementId(this.f42674c);
        bVar.setAdType(298);
        return bVar;
    }

    public static /* synthetic */ void b(b bVar, CampaignEx campaignEx, int i11) {
        if (bVar.f42678g.isH5Ready()) {
            bVar.b(campaignEx, i11);
            bVar.b(campaignEx, "", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i11) {
        if (!d.a(this.f42678g, campaignEx, this.f42674c, this.f42673b) || this.f42689r) {
            return;
        }
        e();
        d.a(campaignEx, this.f42673b);
        this.f42689r = true;
        com.mbridge.msdk.advanced.b.b bVar = this.f42676e;
        if (bVar != null) {
            bVar.a(campaignEx, i11);
        }
    }

    private void b(CampaignEx campaignEx, String str, int i11) {
        com.mbridge.msdk.advanced.c.a.b(com.mbridge.msdk.advanced.common.d.a().c(campaignEx.getId()).b(this.f42673b).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i11).a(campaignEx.isBidCampaign()), this.f42673b);
    }

    private void c(CampaignEx campaignEx, int i11) {
        MBNativeAdvancedView mBNativeAdvancedView = this.f42678g;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            ad.a(f42672a, "开始下载zip： " + campaignEx.getAdZip());
            h(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            ad.a(f42672a, "开始下载HTML： " + campaignEx.getAdHtml());
            g(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            ad.a(f42672a, "开始下载Video： " + campaignEx.getVideoUrlEncode());
            i(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            ad.a(f42672a, "开始下载image： " + campaignEx.getImageUrl());
            f(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            ad.a(f42672a, "开始下载EndCard： " + campaignEx.getendcard_url());
            e(campaignEx, i11);
        }
        if (TextUtils.isEmpty(campaignEx.getGifUrl())) {
            return;
        }
        ad.a(f42672a, "开始下载gitUrl： " + campaignEx.getGifUrl());
        d(campaignEx, i11);
    }

    private void d(final CampaignEx campaignEx, final int i11) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getGifUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.advanced.a.b.10
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                ad.a(b.f42672a, "gifurl 下载失败： " + str2);
                if (b.this.f42696y != null) {
                    b.this.f42696y.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.10.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            b.this.b(campaignEx, i11);
                        }
                    });
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                ad.a(b.f42672a, "giturl 下载成功： " + str);
                if (b.this.f42696y != null) {
                    b.this.f42696y.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.10.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            b.this.b(campaignEx, i11);
                        }
                    });
                }
            }
        });
    }

    private void e() {
        this.f42696y.removeCallbacks(this.f42697z);
    }

    private void e(final CampaignEx campaignEx, final int i11) {
        String str;
        this.f42692u = new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.advanced.a.b.11
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str2, String str3) {
                ad.a(b.f42672a, "endcard 下载失败： " + str3);
                if (b.this.f42678g != null) {
                    b.this.f42678g.setEndCardReady(false);
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str2);
                bundle.putInt("type", 2);
                messageObtain.obj = bundle;
                b.this.f42696y.sendMessage(messageObtain);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str2, String str3, boolean z11) {
                ad.a(b.f42672a, "endcard 下载成功： " + str2);
                if (b.this.f42696y != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 4;
                    messageObtain.obj = campaignEx;
                    messageObtain.arg1 = i11;
                    b.this.f42696y.sendMessage(messageObtain);
                }
            }
        };
        int i12 = 0;
        if (campaignEx != null) {
            i12 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            str = campaignEx.getendcard_url();
        } else {
            str = "";
        }
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        bVar.a(campaignEx);
        bVar.c(i12);
        H5DownLoadManager.getInstance().downloadH5Res(bVar, str, this.f42692u);
    }

    private void f(final CampaignEx campaignEx, final int i11) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.advanced.a.b.12
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                ad.a(b.f42672a, "image 下载失败： " + str2);
                if (b.this.f42696y != null) {
                    b.this.f42696y.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.12.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            b.this.b(campaignEx, i11);
                        }
                    });
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                ad.a(b.f42672a, "image 下载成功： " + str);
                if (b.this.f42696y != null) {
                    b.this.f42696y.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.12.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            b.this.b(campaignEx, i11);
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00aa A[Catch: all -> 0x00ae, Exception -> 0x011f, PHI: r3 r7
  0x00aa: PHI (r3v3 java.io.FileOutputStream) = (r3v5 java.io.FileOutputStream), (r3v7 java.io.FileOutputStream) binds: [B:38:0x00c2, B:30:0x00a8] A[DONT_GENERATE, DONT_INLINE]
  0x00aa: PHI (r7v1 java.io.File) = (r7v3 java.io.File), (r7v7 java.io.File) binds: [B:38:0x00c2, B:30:0x00a8] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x011f, blocks: (B:56:0x011b, B:57:0x011e, B:40:0x00c5, B:42:0x00cb, B:44:0x00d1, B:46:0x00d7, B:48:0x00e9, B:49:0x00f2, B:31:0x00aa), top: B:70:0x0008, outer: #7 }] */
    private void g(final CampaignEx campaignEx, final int i11) {
        final File file;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    try {
                        try {
                            File file2 = new File(campaignEx.getAdHtml());
                            try {
                                if (file2.exists()) {
                                    file = file2;
                                } else {
                                    String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                                    String md5 = SameMD5.getMD5(ao.b(campaignEx.getAdHtml()));
                                    if (TextUtils.isEmpty(md5)) {
                                        md5 = String.valueOf(System.currentTimeMillis());
                                    }
                                    file = new File(strA, md5.concat(".html"));
                                    try {
                                        if (!file.exists()) {
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                            try {
                                                String strA2 = jn.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, "<script>" + com.mbridge.msdk.c.b.a.a().b() + "</script>" + campaignEx.getAdHtml());
                                                if (campaignEx.isActiveOm()) {
                                                    strA2 = com.mbridge.msdk.a.b.c(strA2);
                                                }
                                                fileOutputStream2.write(strA2.getBytes());
                                                fileOutputStream2.flush();
                                                fileOutputStream = fileOutputStream2;
                                            } catch (Exception e11) {
                                                e = e11;
                                                fileOutputStream = fileOutputStream2;
                                                e.printStackTrace();
                                                campaignEx.setMraid("");
                                                com.mbridge.msdk.foundation.same.report.m.a(campaignEx, e.getMessage(), this.f42673b, PrepareException.ERROR_MANIFEST_INFO);
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileOutputStream = fileOutputStream2;
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e12) {
                                        e = e12;
                                    }
                                }
                                com.mbridge.msdk.foundation.same.report.m.a(campaignEx, "", this.f42673b, PrepareException.ERROR_MANIFEST_INFO);
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Exception e13) {
                                e = e13;
                                file = file2;
                            }
                        } catch (Exception unused) {
                            a(new com.mbridge.msdk.foundation.c.b(880013), this.f42686o, i11, campaignEx);
                            if (0 != 0) {
                                fileOutputStream.close();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e14) {
                            ad.b(f42672a, e14.getMessage());
                        }
                    }
                    throw th4;
                }
            } catch (Exception e15) {
                e = e15;
                file = null;
            }
            if (file.exists() && file.isFile() && file.canRead()) {
                campaignEx.setAdHtml(file.getAbsolutePath());
                ad.a(f42672a, "开始渲染 HTML： ");
                Handler handler = this.f42696y;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.b.13
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, "file:////" + file.getAbsolutePath(), campaignEx, i11);
                        }
                    });
                }
            } else {
                ad.a(f42672a, "渲染 HTML 失败： html file write failed");
                com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880013);
                a(bVar, this.f42686o, i11, campaignEx);
                a(bVar, this.f42686o, i11, campaignEx);
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e16) {
            ad.b(f42672a, e16.getMessage());
        }
    }

    private void h(final CampaignEx campaignEx, final int i11) {
        String adZip;
        this.f42691t = new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.advanced.a.b.2
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str, String str2) {
                ad.a(b.f42672a, "zip 下载失败： " + str2 + " " + str);
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
                bundle.putInt("type", 3);
                messageObtain.obj = bundle;
                b.this.f42696y.sendMessage(messageObtain);
                b.a(b.this, campaignEx, str2, false, str);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str, String str2, boolean z11) {
                ad.a(b.f42672a, "zip 下载成功： " + str);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = campaignEx;
                messageObtain.arg1 = i11;
                b.this.f42696y.sendMessage(messageObtain);
                if (z11) {
                    return;
                }
                b.a(b.this, campaignEx, str, true, "");
            }
        };
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        bVar.a(campaignEx);
        int i12 = 0;
        if (campaignEx != null) {
            i12 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            adZip = campaignEx.getAdZip();
        } else {
            adZip = "";
        }
        bVar.c(i12);
        bVar.a(2);
        H5DownLoadManager.getInstance().downloadH5Res(bVar, adZip, this.f42691t);
    }

    private void i(final CampaignEx campaignEx, int i11) {
        this.f42690s = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.advanced.a.b.5
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str) {
                ad.a(b.f42672a, "Video 下载成功： " + str);
                Message messageObtain = Message.obtain();
                messageObtain.obj = campaignEx;
                messageObtain.what = 5;
                b.this.f42696y.sendMessage(messageObtain);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str, String str2) {
                ad.a(b.f42672a, "Video 下载失败： " + str);
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
                bundle.putInt("type", 1);
                messageObtain.obj = bundle;
                messageObtain.what = 2;
                b.this.f42696y.sendMessage(messageObtain);
            }
        };
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f42677f, this.f42673b, copyOnWriteArrayList, 298, this.f42690s);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().a(298, this.f42673b, campaignEx.isBidCampaign())) {
            ad.a(f42672a, " load Video");
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f42673b);
        } else {
            ad.a(f42672a, " load Video isReady true");
            this.f42678g.setVideoReady(true);
            b(campaignEx, i11);
        }
    }

    public final String a() {
        return this.f42695x;
    }

    public final String a(String str) {
        int iK;
        if (this.f42681j == null) {
            return "";
        }
        try {
            com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f42673b, this.f42681j.getId() + this.f42681j.getVideoUrlEncode() + this.f42681j.getBidToken());
            if (aVarA == null || (iK = aVarA.k()) != 5) {
                return str;
            }
            String strH = aVarA.h();
            if (!new File(strH).exists()) {
                return str;
            }
            ad.b(f42672a, "本地已下载完 拿本地播放地址：" + strH + " state：" + iK);
            return strH;
        } catch (Exception e11) {
            ad.b(f42672a, e11.getMessage());
            return str;
        }
    }

    public final void a(int i11) {
        this.f42682k = i11;
    }

    public final void a(int i11, int i12) {
        this.f42685n = i11;
        this.f42684m = i12;
    }

    public final void a(com.mbridge.msdk.advanced.b.b bVar) {
        this.f42676e = bVar;
    }

    public final void a(MBNativeAdvancedView mBNativeAdvancedView) {
        this.f42678g = mBNativeAdvancedView;
    }

    public final void a(k kVar) {
        this.f42679h = kVar;
    }

    public final void a(String str, int i11) {
        List<Integer> listC;
        this.f42689r = false;
        this.f42686o = str;
        this.f42687p = i11;
        this.f42681j = null;
        if (this.f42678g == null) {
            a(new com.mbridge.msdk.foundation.c.b(880030), str, i11, (CampaignEx) null);
            return;
        }
        CampaignEx campaignExA = TextUtils.isEmpty(str) ? d.a(this.f42678g, this.f42674c, this.f42673b, str, this.f42682k, false, false) : d.a(this.f42678g, this.f42674c, this.f42673b, str, this.f42682k, false, true);
        long timestamp = campaignExA != null ? campaignExA.getTimestamp() : 0L;
        k kVar = this.f42679h;
        if (kVar != null && kVar.m() == 1 && this.f42678g != null && campaignExA != null) {
            a(campaignExA, i11);
            return;
        }
        this.f42688q = false;
        k kVar2 = this.f42679h;
        if (kVar2 == null || (listC = kVar2.c()) == null || listC.size() <= 0) {
            this.f42675d = 30000L;
        } else {
            this.f42675d = listC.get(0).intValue() * 1000;
        }
        ad.a(f42672a, "开始从V3请求新的 offer，超时 ：" + this.f42675d);
        if (this.f42679h == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.f42675d);
            a(this.f42677f, str, i11);
        } else if (System.currentTimeMillis() - timestamp <= this.f42679h.o() * 1000) {
            a(campaignExA, i11);
        } else {
            a(this.f42675d);
            a(this.f42677f, str, i11);
        }
    }

    public final String b() {
        return com.mbridge.msdk.foundation.same.b.a(this.f42680i);
    }

    public final void c() {
        if (this.f42676e != null) {
            this.f42676e = null;
        }
        if (this.f42690s != null) {
            this.f42690s = null;
        }
        if (this.f42691t != null) {
            this.f42691t = null;
        }
    }
}
