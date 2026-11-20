package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f47046a = "SplashLoadManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f47049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f47050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.splash.d.b f47051f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MBSplashView f47053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k f47054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f47056k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f47057l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47058m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f47059n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47060o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f47061p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f47062q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f47063r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f47064s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f47065t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f47066u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f47068w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<CampaignEx> f47069x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f47067v = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f47070y = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Handler f47071z = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.e.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) throws Throwable {
            int i11;
            super.handleMessage(message);
            int i12 = message.what;
            if (i12 == 1) {
                Object obj = message.obj;
                int i13 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    e.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i13);
                    return;
                }
                return;
            }
            if (i12 != 2) {
                if (i12 != 3) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof CampaignEx) {
                    e eVar = e.this;
                    eVar.b((CampaignEx) obj2, eVar.f47060o);
                    return;
                }
                return;
            }
            Object obj3 = message.obj;
            try {
                if (obj3 instanceof Bundle) {
                    int i14 = ((Bundle) obj3).getInt("type");
                    String string = ((Bundle) obj3).getString(NotificationCompat.CATEGORY_MESSAGE);
                    CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                    if (i14 == 1) {
                        i11 = 880004;
                    } else {
                        i11 = i14 == 2 ? 880006 : 880027;
                    }
                    com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(i11);
                    bVar.a(string);
                    e eVar2 = e.this;
                    eVar2.a(bVar, eVar2.f47059n, e.this.f47060o, campaignEx2);
                }
            } catch (Exception e11) {
                com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880024);
                bVar2.a((Throwable) e11);
                e eVar3 = e.this;
                eVar3.a(bVar2, eVar3.f47059n, e.this.f47060o, (CampaignEx) null);
            }
        }
    };
    private Runnable A = new Runnable() { // from class: com.mbridge.msdk.splash.c.e.4
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880010);
            e eVar = e.this;
            eVar.a(bVar, eVar.f47059n, e.this.f47060o, (CampaignEx) null);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f47052g = com.mbridge.msdk.foundation.controller.c.m().c();

    public e(String str, String str2, long j11) {
        this.f47048c = str;
        this.f47047b = str2;
        this.f47050e = j11;
    }

    private void a(long j11) {
        this.f47071z.postDelayed(this.A, j11);
    }

    private void a(Context context, final String str, final int i11) throws Throwable {
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.c.b(880025), str, i11, (CampaignEx) null);
                return;
            }
            if (an.a(this.f47047b)) {
                a(new com.mbridge.msdk.foundation.c.b(880032), str, i11, (CampaignEx) null);
                return;
            }
            MBridgeIds mBridgeIds = new MBridgeIds(this.f47048c, this.f47047b);
            com.mbridge.msdk.splash.f.f fVar = new com.mbridge.msdk.splash.f.f();
            fVar.a(i11);
            fVar.b(this.f47066u);
            fVar.a(this.f47065t);
            fVar.c(this.f47058m);
            fVar.d(this.f47057l);
            com.mbridge.msdk.foundation.same.net.h.e eVarA = com.mbridge.msdk.splash.f.e.a(context, mBridgeIds, fVar);
            if (eVarA == null) {
                a(new com.mbridge.msdk.foundation.c.b(880001), str, i11, (CampaignEx) null);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                eVarA.a("token", str);
            }
            String strD = ai.d(this.f47047b);
            if (!TextUtils.isEmpty(strD)) {
                eVarA.a("j", strD);
            }
            com.mbridge.msdk.splash.f.c cVar = new com.mbridge.msdk.splash.f.c(context);
            com.mbridge.msdk.splash.f.b bVar = new com.mbridge.msdk.splash.f.b(i11) { // from class: com.mbridge.msdk.splash.c.e.5
                @Override // com.mbridge.msdk.splash.f.b
                public final void a(int i12, String str2) throws Throwable {
                    ad.b(e.f47046a, str2);
                    com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880002);
                    bVar2.a(str2);
                    e.this.a(bVar2, str, i11, (CampaignEx) null);
                    e.this.f47066u = 0;
                }

                @Override // com.mbridge.msdk.splash.f.b
                public final void a(CampaignUnit campaignUnit, int i12) throws Throwable {
                    try {
                        e eVar = e.this;
                        e.a(eVar, campaignUnit, i12, eVar.f47047b, str);
                        e.this.f47067v = campaignUnit.getRequestId();
                        e.this.f47069x = campaignUnit.getAds();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880003);
                        bVar2.a((Throwable) e11);
                        e.this.a(bVar2, str, i12, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
                        e.this.f47066u = 0;
                    }
                }
            };
            bVar.a(str);
            bVar.setUnitId(this.f47047b);
            bVar.setPlacementId(this.f47048c);
            bVar.setAdType(297);
            cVar.choiceV3OrV5BySetting(1, eVarA, bVar, str);
        } catch (Exception e11) {
            ad.b(f47046a, e11.getMessage());
            com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880020);
            bVar2.a((Throwable) e11);
            a(bVar2, str, i11, (CampaignEx) null);
            this.f47066u = 0;
        }
    }

    private void a(com.mbridge.msdk.foundation.c.b bVar, int i11, CampaignEx campaignEx) {
        if (this.f47062q) {
            return;
        }
        e();
        this.f47062q = true;
        if (bVar != null) {
            bVar.a(campaignEx);
        }
        com.mbridge.msdk.splash.d.b bVar2 = this.f47051f;
        if (bVar2 != null) {
            bVar2.a(bVar, i11);
        }
    }

    private void a(com.mbridge.msdk.foundation.c.b bVar, int i11, String str, CampaignEx campaignEx) throws Throwable {
        CampaignEx campaignExA = d.a(this.f47053h, this.f47048c, this.f47047b, str, this.f47055j, this.f47056k, true, false);
        if (campaignExA != null) {
            a(campaignExA, i11);
        } else {
            a(bVar, i11, campaignEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar, String str, int i11, CampaignEx campaignEx) throws Throwable {
        if (!this.f47061p) {
            a(bVar, i11, campaignEx);
        } else {
            this.f47061p = false;
            a(bVar, i11, str, campaignEx);
        }
    }

    private void a(CampaignEx campaignEx, int i11) throws Throwable {
        MBSplashView mBSplashView = this.f47053h;
        if (mBSplashView != null) {
            mBSplashView.setDynamicView(false);
        }
        if (campaignEx.isDynamicView()) {
            d(campaignEx, i11);
        } else {
            MBSplashView mBSplashView2 = this.f47053h;
            if (mBSplashView2 != null) {
                mBSplashView2.setSplashWebView();
            }
        }
        if (d.a(this.f47053h, campaignEx)) {
            b(campaignEx, i11);
        } else {
            c(campaignEx, i11);
        }
    }

    public static /* synthetic */ void a(e eVar, CampaignEx campaignEx, String str, boolean z11, String str2) {
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
                ad.b(f47046a, e11.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.mbridge.msdk.foundation.same.report.d.a.a] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.mbridge.msdk.foundation.entity.CampaignEx] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static /* synthetic */ void a(e eVar, CampaignUnit campaignUnit, int i11, String str, String str2) throws Throwable {
        ArrayList arrayList;
        final CampaignEx campaignEx = 0;
        campaignEx = 0;
        campaignEx = 0;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            final CampaignEx campaignEx2 = campaignUnit.getAds().get(0);
            campaignEx2.setCampaignUnitId(eVar.f47047b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.e.7
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.foundation.db.k.a(h.a(e.this.f47052g)).a();
                    m.a(e.this.f47052g, campaignEx2);
                }
            }).start();
            eVar.f47065t = campaignUnit.getSessionId();
            if (campaignEx2.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx2.getAdZip()) || !TextUtils.isEmpty(campaignEx2.getAdHtml()))) {
                if (ai.c(campaignEx2)) {
                    campaignEx2.setRtinsType(ai.c(eVar.f47052g, campaignEx2.getPackageName()) ? 1 : 2);
                }
                if (com.mbridge.msdk.foundation.same.b.a(eVar.f47052g, campaignEx2)) {
                    arrayList.add(campaignEx2);
                } else {
                    ai.a(eVar.f47047b, campaignEx2, com.mbridge.msdk.foundation.same.a.f44388x);
                    eVar.f47070y = "APP ALREADY INSTALLED";
                }
                try {
                    com.mbridge.msdk.foundation.same.b.a(campaignEx2, eVar.f47052g, null, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.splash.c.e.6
                        @Override // com.mbridge.msdk.foundation.same.b.a
                        public final void a(String str3, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                            try {
                                com.mbridge.msdk.foundation.same.report.d.c.a().a(str3, bVar, campaignEx2, e.this.f47052g, campaignEx);
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
            com.mbridge.msdk.foundation.c.b bVar = eVar.f47070y.contains("INSTALLED") ? new com.mbridge.msdk.foundation.c.b(880021, "APP ALREADY INSTALLED") : new com.mbridge.msdk.foundation.c.b(880003);
            if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() != 0) {
                campaignEx = campaignUnit.getAds().get(0);
            }
            eVar.a(bVar, str2, i11, campaignEx);
            return;
        }
        try {
            int i12 = eVar.f47066u + 1;
            eVar.f47066u = i12;
            k kVar = eVar.f47054i;
            if (kVar == null || i12 > kVar.w()) {
                eVar.f47066u = 0;
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        CampaignEx campaignEx3 = (CampaignEx) arrayList.get(0);
        if (!TextUtils.isEmpty(campaignEx3.getAdZip()) || (!TextUtils.isEmpty(campaignEx3.getAdHtml()) && campaignEx3.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx3.setHasMBTplMark(true);
            campaignEx3.setIsMraid(false);
        } else {
            campaignEx3.setHasMBTplMark(false);
            campaignEx3.setIsMraid(true);
        }
        eVar.a(campaignEx3, i11);
    }

    public static /* synthetic */ void a(e eVar, String str, int i11, CampaignEx campaignEx) throws Throwable {
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880009);
        bVar.a(str);
        eVar.a(bVar, eVar.f47059n, i11, campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final CampaignEx campaignEx, final int i11) {
        g.c cVar = new g.c();
        cVar.c(this.f47047b);
        cVar.b(this.f47048c);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(this.f47055j);
        cVar.a(this.f47056k);
        g.a.f47106a.a(this.f47053h, cVar, new g.b() { // from class: com.mbridge.msdk.splash.c.e.2
            @Override // com.mbridge.msdk.splash.c.g.b
            public final void a() {
                if (campaignEx.isHasMBTplMark()) {
                    return;
                }
                e.c(e.this, campaignEx, i11);
            }

            @Override // com.mbridge.msdk.splash.c.g.b
            public final void a(int i12) throws Throwable {
                if (i12 == 1) {
                    e.c(e.this, campaignEx, i11);
                } else {
                    e.a(e.this, "readyState 2", i11, campaignEx);
                }
            }

            @Override // com.mbridge.msdk.splash.c.g.b
            public final void a(String str2) throws Throwable {
                e.a(e.this, str2, i11, campaignEx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i11) {
        if (!d.a(this.f47053h, campaignEx) || this.f47062q) {
            return;
        }
        e();
        if (this.f47061p) {
            d.a(campaignEx, this.f47047b);
        }
        this.f47062q = true;
        com.mbridge.msdk.splash.d.b bVar = this.f47051f;
        if (bVar != null) {
            bVar.a(campaignEx, i11);
        }
    }

    public static /* synthetic */ void b(e eVar, final CampaignEx campaignEx, final int i11) {
        if (campaignEx.isDynamicView()) {
            com.mbridge.msdk.splash.a.d.a aVar = new com.mbridge.msdk.splash.a.d.a();
            aVar.b(eVar.f47047b).a(eVar.f47048c).a(eVar.f47055j).a(campaignEx).a(eVar.f47056k).h(eVar.f47068w);
            try {
                if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
                    Uri uri = Uri.parse(campaignEx.getAdZip());
                    String queryParameter = uri.getQueryParameter("hdbtn");
                    String queryParameter2 = uri.getQueryParameter("alecfc");
                    String queryParameter3 = uri.getQueryParameter("hdinfo");
                    String queryParameter4 = uri.getQueryParameter("shake_show");
                    String queryParameter5 = uri.getQueryParameter("shake_strength");
                    String queryParameter6 = uri.getQueryParameter("shake_time");
                    String queryParameter7 = uri.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th2) {
                ad.b(f47046a, th2.getMessage());
            }
            c.a.f47039a.a(eVar.f47053h, new com.mbridge.msdk.splash.a.d(aVar), new com.mbridge.msdk.splash.b.a() { // from class: com.mbridge.msdk.splash.c.e.11
                @Override // com.mbridge.msdk.splash.b.a
                public final void a(View view) {
                    if (e.this.f47053h != null) {
                        e.this.f47053h.setDynamicView(true);
                        e.this.f47053h.setSplashNativeView(view);
                        e.this.b(campaignEx, i11);
                    }
                }

                @Override // com.mbridge.msdk.splash.b.a
                public final void a(String str) throws Throwable {
                    com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880034);
                    bVar.a(str);
                    e eVar2 = e.this;
                    eVar2.a(bVar, eVar2.f47059n, i11, campaignEx);
                }
            });
        }
    }

    private void c(CampaignEx campaignEx, int i11) throws Throwable {
        this.f47053h.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            f(campaignEx, i11);
        }
        if (campaignEx.isDynamicView()) {
            return;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            e(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            g(campaignEx, i11);
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return;
        }
        d(campaignEx, i11);
    }

    public static /* synthetic */ void c(e eVar, CampaignEx campaignEx, int i11) {
        if (eVar.f47053h.isH5Ready()) {
            return;
        }
        eVar.f47053h.setH5Ready(true);
        eVar.b(campaignEx, i11);
    }

    private void d(final CampaignEx campaignEx, final int i11) {
        d.a(this.f47053h, campaignEx, new com.mbridge.msdk.splash.view.nativeview.a() { // from class: com.mbridge.msdk.splash.c.e.8
            @Override // com.mbridge.msdk.splash.view.nativeview.a
            public final void a() {
                if (campaignEx.isDynamicView() && e.this.f47053h != null) {
                    e.this.f47053h.setImageReady(true);
                    e.b(e.this, campaignEx, i11);
                }
                e.this.b(campaignEx, i11);
            }

            @Override // com.mbridge.msdk.splash.view.nativeview.a
            public final void b() throws Throwable {
                if (!campaignEx.isDynamicView() || e.this.f47053h == null) {
                    return;
                }
                e.this.f47053h.setImageReady(false);
                com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880027);
                e eVar = e.this;
                eVar.a(bVar, eVar.f47059n, i11, campaignEx);
            }
        });
    }

    private void e() {
        this.f47071z.removeCallbacks(this.A);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00aa A[Catch: Exception -> 0x0105, PHI: r3 r7
  0x00aa: PHI (r3v3 java.io.FileOutputStream) = (r3v4 java.io.FileOutputStream), (r3v6 java.io.FileOutputStream) binds: [B:36:0x00bf, B:30:0x00a8] A[DONT_GENERATE, DONT_INLINE]
  0x00aa: PHI (r7v1 java.io.File) = (r7v3 java.io.File), (r7v7 java.io.File) binds: [B:36:0x00bf, B:30:0x00a8] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0105, blocks: (B:47:0x0101, B:48:0x0104, B:38:0x00c2, B:40:0x00c8, B:42:0x00ce, B:44:0x00d4, B:45:0x00f4, B:31:0x00aa), top: B:58:0x0008 }] */
    private void e(CampaignEx campaignEx, int i11) throws Throwable {
        File file;
        FileOutputStream fileOutputStream = null;
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
                                        com.mbridge.msdk.foundation.same.report.m.a(campaignEx, e.getMessage(), this.f47047b, PrepareException.ERROR_NO_URL);
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
                        com.mbridge.msdk.foundation.same.report.m.a(campaignEx, "", this.f47047b, PrepareException.ERROR_NO_URL);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e13) {
                        e = e13;
                        file = file2;
                    }
                } catch (Exception e14) {
                    e = e14;
                    file = null;
                }
                if (!file.exists() || !file.isFile() || !file.canRead()) {
                    a(new com.mbridge.msdk.foundation.c.b(880013), this.f47059n, i11, campaignEx);
                    return;
                }
                campaignEx.setAdHtml(file.getAbsolutePath());
                a("file:////" + file.getAbsolutePath(), campaignEx, i11);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused) {
            a(new com.mbridge.msdk.foundation.c.b(880013), this.f47059n, i11, campaignEx);
        }
    }

    private void f(final CampaignEx campaignEx, final int i11) {
        if (campaignEx.isDynamicView()) {
            com.mbridge.msdk.foundation.tools.n.a(5, "", campaignEx.getAdZip(), new com.mbridge.msdk.foundation.tools.n.a() { // from class: com.mbridge.msdk.splash.c.e.9
                @Override // com.mbridge.msdk.foundation.tools.n.a
                public final void a(String str, DownloadError downloadError) {
                    String message = "";
                    if (downloadError != null) {
                        try {
                            if (downloadError.getException() != null) {
                                message = downloadError.getException().getMessage();
                            }
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                e11.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                    e.a(e.this, campaignEx, str, false, message);
                }

                @Override // com.mbridge.msdk.foundation.tools.n.a
                public final void a(String str, String str2, String str3, String str4, boolean z11) {
                    if (z11) {
                        return;
                    }
                    e.a(e.this, campaignEx, str, true, "");
                }
            }, campaignEx);
            return;
        }
        this.f47064s = new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.splash.c.e.10
            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onFailed(String str, String str2) throws Throwable {
                com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880006);
                e eVar = e.this;
                eVar.a(bVar, eVar.f47059n, i11, campaignEx);
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
                bundle.putInt("type", 2);
                messageObtain.obj = bundle;
                e.this.f47071z.sendMessage(messageObtain);
                e.a(e.this, campaignEx, str2, false, str);
            }

            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
            public final void onSuccess(String str, String str2, boolean z11) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = campaignEx;
                messageObtain.arg1 = i11;
                e.this.f47071z.sendMessage(messageObtain);
                if (z11) {
                    return;
                }
                CampaignEx campaignEx2 = campaignEx;
                e.a(e.this, campaignEx, campaignEx2 != null ? campaignEx2.getAdZip() : "", true, "");
            }
        };
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        bVar.b(297);
        bVar.a(2);
        bVar.a(campaignEx);
        bVar.c(campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0);
        H5DownLoadManager.getInstance().downloadH5Res(bVar, campaignEx.getAdZip(), this.f47064s);
    }

    private void g(final CampaignEx campaignEx, int i11) {
        this.f47063r = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.splash.c.e.3
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str) {
                e.this.f47053h.setVideoReady(true);
                Message messageObtain = Message.obtain();
                messageObtain.obj = campaignEx;
                messageObtain.what = 3;
                e.this.f47071z.sendMessage(messageObtain);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str, String str2) throws Throwable {
                e.this.f47053h.setVideoReady(false);
                com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880004);
                bVar.a(str);
                e eVar = e.this;
                eVar.a(bVar, eVar.f47059n, e.this.f47060o, campaignEx);
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
                bundle.putInt("type", 1);
                messageObtain.obj = bundle;
                messageObtain.what = 2;
                e.this.f47071z.sendMessage(messageObtain);
            }
        };
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f47052g, this.f47047b, copyOnWriteArrayList, 297, this.f47063r);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().a(297, this.f47047b, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f47047b);
        } else {
            this.f47053h.setVideoReady(true);
            b(campaignEx, i11);
        }
    }

    public final String a() {
        return this.f47067v;
    }

    public final void a(int i11) {
        this.f47056k = i11;
    }

    public final void a(int i11, int i12) {
        this.f47058m = i11;
        this.f47057l = i12;
    }

    public final void a(k kVar) {
        this.f47054i = kVar;
    }

    public final void a(com.mbridge.msdk.splash.d.b bVar) {
        this.f47051f = bVar;
    }

    public final void a(MBSplashView mBSplashView) {
        this.f47053h = mBSplashView;
    }

    public final void a(String str, int i11) {
        this.f47062q = false;
        this.f47059n = str;
        this.f47060o = i11;
        CampaignEx campaignExA = d.a(this.f47053h, this.f47048c, this.f47047b, str, this.f47055j, this.f47056k, false, false);
        long timestamp = campaignExA != null ? campaignExA.getTimestamp() : 0L;
        if (this.f47054i.m() == 1 && i11 != 1 && campaignExA != null) {
            a(campaignExA, i11);
            return;
        }
        this.f47061p = true;
        if (i11 == 1) {
            List<Integer> listC = this.f47054i.c();
            if (listC == null || listC.size() <= 0) {
                this.f47049d = 30000L;
            } else {
                this.f47049d = listC.get(0).intValue() * 1000;
            }
        } else {
            long j11 = this.f47050e;
            if (j11 <= 0) {
                this.f47049d = this.f47054i.r();
            } else {
                this.f47049d = j11;
            }
        }
        if (this.f47054i == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.f47049d);
            a(this.f47052g, str, i11);
            return;
        }
        if (System.currentTimeMillis() - timestamp <= this.f47054i.o() * 1000) {
            a(campaignExA, i11);
        } else {
            a(this.f47049d);
            a(this.f47052g, str, i11);
        }
    }

    public final void a(boolean z11) {
        this.f47055j = z11;
    }

    public final String b() {
        return com.mbridge.msdk.foundation.same.b.a(this.f47069x);
    }

    public final void b(int i11) {
        this.f47068w = i11;
    }

    public final void c() {
        if (this.f47051f != null) {
            this.f47051f = null;
        }
        if (this.f47063r != null) {
            this.f47063r = null;
        }
        if (this.f47064s != null) {
            this.f47064s = null;
        }
    }
}
