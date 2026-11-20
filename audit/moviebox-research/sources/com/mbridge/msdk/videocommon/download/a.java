package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbnative.controller.NativeController;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Serializable {
    private int A;
    private File B;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private k H;
    private com.mbridge.msdk.videocommon.d.c I;
    private k J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f48508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f48509c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f48511e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f48513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f48514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CampaignEx f48515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f48516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f48517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f48518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f48519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f48520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f48521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f48522p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f48524r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private p f48527u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f48529w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private DownloadRequest f48530x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f48531y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f48532z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f48507a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f48510d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<c> f48512f = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48523q = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f48525s = 100;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f48526t = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f48528v = false;
    private int C = 1;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private OnDownloadStateListener R = new OnDownloadStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.1
        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage downloadMessage) {
            String str;
            try {
                ad.b("CampaignDownLoadTask", "onDownloadComplete callback : " + a.this.f48521o + "    " + a.this.f48518l);
                if (a.this.f48527u == null) {
                    a.this.f48527u = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                }
                a.this.f48527u.a(a.this.f48519m, a.this.f48521o, 5);
                if (downloadMessage != null) {
                    try {
                        str = (String) downloadMessage.getExtra("responseHeaders");
                    } catch (Throwable th2) {
                        ad.b("CampaignDownLoadTask", th2.getMessage());
                        str = "";
                    }
                } else {
                    str = "";
                }
                a aVar = a.this;
                aVar.a(aVar.f48521o, true, str);
                a.this.f48527u.a(a.this.f48519m, a.this.f48521o, 5);
                a aVar2 = a.this;
                aVar2.a(aVar2.f48521o, true, "");
                a.a(a.this, 1, true);
            } catch (Exception e11) {
                ad.b("CampaignDownLoadTask", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (a.this.f48530x == null || a.this.f48530x.getStatus() == DownloadStatus.CANCELLED) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("cache", a.this.f48530x.get("cache", "2"));
            a aVar = a.this;
            aVar.a(aVar.f48515i, dVar);
            String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
            a.this.v();
            a.this.a(3, message, "");
            a.this.a(message);
            a aVar2 = a.this;
            a.a(aVar2, 3, aVar2.f48532z);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage downloadMessage) {
            a.this.f48511e = 1;
            if (a.this.f48527u == null) {
                a.this.f48527u = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            }
            a.this.f48527u.a(a.this.f48515i, a.this.f48518l, a.this.f48522p, a.this.f48511e);
        }
    };
    private OnProgressStateListener S = new OnProgressStateListener() { // from class: com.mbridge.msdk.videocommon.download.a.2
        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public final void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("cache", a.this.f48530x.get("cache", "2"));
                a aVar = a.this;
                aVar.a(aVar.f48515i, dVar);
                a.this.f48521o = downloadProgress.getCurrent();
                a.this.f48518l = downloadProgress.getTotal();
                a.this.f48531y = downloadProgress.getCurrentDownloadRate();
                if (a.this.f48525s != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.f48525s) {
                    ad.b("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate = " + a.this.f48525s + " " + a.this.f48509c);
                    if (a.this.f48510d) {
                        return;
                    }
                    a.this.f48510d = true;
                    if (!a.this.f48532z) {
                        a.a(a.this, 1, true);
                        a.this.a(downloadProgress.getCurrent(), false, "");
                    }
                    if (a.this.f48530x == null || a.this.C != 2 || a.this.f48532z) {
                        return;
                    }
                    a.this.f48530x.cancel(downloadMessage);
                }
            } catch (Exception e11) {
                ad.b("CampaignDownLoadTask", e11.getMessage());
            }
        }
    };

    public a(Context context, CampaignEx campaignEx, String str, int i11) {
        File file;
        File file2;
        this.f48508b = 1;
        this.f48511e = 0;
        this.f48521o = 0L;
        int iB = 100;
        this.G = false;
        if (context == null && campaignEx == null) {
            return;
        }
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarA != null) {
            this.G = gVarA.aF();
        }
        this.D = com.mbridge.msdk.foundation.same.a.f44385u;
        this.E = com.mbridge.msdk.foundation.same.a.f44386v;
        this.F = com.mbridge.msdk.foundation.same.a.f44384t;
        this.f48524r = System.currentTimeMillis();
        this.f48517k = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f48515i = campaignEx;
        this.f48516j = str;
        this.f48508b = i11;
        if (campaignEx != null) {
            this.f48519m = campaignEx.getVideoUrlEncode();
        }
        this.f48529w = ab.c(this.f48519m);
        this.f48520n = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
        this.f48522p = this.f48520n + this.f48529w;
        ad.c("CampaignDownLoadTask", this.f48515i.getAppName() + " videoLocalPath:" + this.f48522p + " videoUrl: " + this.f48515i.getVideoUrlEncode() + " " + this.f48525s);
        try {
            if (TextUtils.isEmpty(this.f48519m)) {
                return;
            }
            if (TextUtils.isEmpty(this.f48520n)) {
                file = null;
            } else {
                file = new File(this.f48520n);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            if (file != null && file.exists() && ((file2 = this.B) == null || !file2.exists())) {
                File file3 = new File(file + "/.nomedia");
                this.B = file3;
                if (!file3.exists()) {
                    this.B.createNewFile();
                }
            }
            p pVarA = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            m mVarA = pVarA.a(this.f48519m, "");
            if (mVarA != null) {
                this.f48521o = mVarA.c();
                if (this.f48511e != 2) {
                    this.f48511e = mVarA.b();
                }
                if (this.f48511e == 1) {
                    this.f48511e = 2;
                }
                this.f48518l = mVarA.d();
                if (mVarA.a() > 0) {
                    this.f48524r = mVarA.a();
                }
                if (this.f48511e == 5) {
                    if (Objects.exists(new File(this.f48520n + this.f48529w), this.f48520n, this.f48529w)) {
                        this.f48522p = this.f48520n + this.f48529w;
                    } else {
                        u();
                    }
                } else if (this.f48511e != 0) {
                    this.f48522p = this.f48520n + this.f48529w;
                }
            } else {
                pVarA.a(this.f48519m, this.f48524r);
            }
            try {
                long j11 = this.f48518l;
                if (j11 > 0 && this.f48521o * 100 >= j11 * ((long) b(this.f48515i)) && (b(this.f48515i) == 100 || this.f48511e == 5)) {
                    com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar.a("cache", 1);
                    a(this.f48515i, dVar);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
            String str2 = this.f48519m;
            if (TextUtils.isEmpty(str2)) {
                this.f48514h.a("VideoUrl is NULL, Please check it.", "");
                return;
            }
            if (this.f48511e == 1) {
                ad.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
                return;
            }
            if (this.f48511e == 5 && Utils.getDownloadRate(this.f48518l, this.f48521o) >= this.f48525s) {
                ad.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar = this.f48513g;
                if (aVar != null) {
                    aVar.a(this.f48519m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f48514h;
                if (aVar2 != null) {
                    aVar2.a(this.f48519m);
                }
                try {
                    File file4 = new File(this.f48522p);
                    if (Objects.exists(file4, this.f48520n, this.f48529w) && file4.isFile()) {
                        file4.setLastModified(System.currentTimeMillis());
                    }
                } catch (Exception e12) {
                    ad.b("CampaignDownLoadTask", e12.getMessage());
                }
                com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar2.a("cache", 1);
                a(this.f48515i, dVar2);
                return;
            }
            if (this.f48508b == 3) {
                ad.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
                a(0L, false, "");
                com.mbridge.msdk.foundation.same.report.d.d dVar3 = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar3.a("cache", 1);
                a(this.f48515i, dVar3);
                return;
            }
            try {
                iB = b(this.f48515i);
            } catch (Exception unused) {
            }
            c(iB);
            if (iB == 0) {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.f48513g;
                if (aVar3 != null) {
                    aVar3.a(this.f48519m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.f48514h;
                if (aVar4 != null) {
                    aVar4.a(this.f48519m);
                }
            }
            DownloadMessage downloadMessage = new DownloadMessage(this.f48515i, str2, this.f48529w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            downloadMessage.setUseCronetDownload(e(this.f48515i));
            downloadMessage.addExtra("resource_type", 4);
            this.f48530x = a(downloadMessage, this.R, this.S, "1");
        } catch (Exception e13) {
            ad.c("CampaignDownLoadTask", e13.getMessage());
        }
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener, String str) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(this.D).withConnectTimeout(this.F).withWriteTimeout(this.E).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f48520n).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).with("do_us_fi_re", Boolean.toString(this.G)).with(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f48525s)).with("scenes", str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, String str, String str2) {
        n nVar = new n(this.f48517k, this.f48515i, i11, Long.toString(this.f48524r != 0 ? System.currentTimeMillis() - this.f48524r : 0L), this.f48518l, this.A);
        nVar.e(this.f48515i.getId());
        nVar.m(this.f48515i.getVideoUrlEncode());
        nVar.h(str);
        nVar.f(this.f48515i.getRequestId());
        nVar.s(this.f48515i.getCurrentLocalRid());
        nVar.g(this.f48515i.getRequestIdNotice());
        nVar.c(this.f48516j);
        nVar.t(str2);
        nVar.a(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f48525s));
        nVar.a("url", this.f48515i.getVideoUrlEncode());
        nVar.e(4);
        DownloadRequest downloadRequest = this.f48530x;
        if (downloadRequest != null) {
            nVar.a("scenes", downloadRequest.get("scenes", ""));
            nVar.a("resumed_breakpoint", this.f48530x.get("resumed_breakpoint", ""));
        }
        int i12 = this.A;
        if (i12 == 94 || i12 == 287) {
            return;
        }
        q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(nVar);
    }

    private void a(long j11, int i11) {
        this.f48521o = j11;
        int i12 = this.f48525s;
        if (100 * j11 >= ((long) i12) * this.f48518l && !this.f48526t && i11 != 4) {
            if (i12 == 100 && i11 != 5) {
                this.f48511e = 5;
                return;
            }
            this.f48526t = true;
            ad.b("CampaignDownLoadTask", "UpdateListener : state: " + i11 + " progress : " + j11);
            String strQ = q();
            if (TextUtils.isEmpty(strQ)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.f48513g;
                if (aVar != null) {
                    aVar.a(this.f48519m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f48514h;
                if (aVar2 != null) {
                    aVar2.a(this.f48519m);
                }
            } else {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.f48513g;
                if (aVar3 != null) {
                    aVar3.a("file is not effective " + strQ, this.f48519m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.f48514h;
                if (aVar4 != null) {
                    aVar4.a("file is not effective " + strQ, this.f48519m);
                }
            }
        }
        if (!this.f48507a && j11 > 0) {
            this.f48507a = true;
            if (this.f48527u == null) {
                this.f48527u = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            }
            this.f48527u.a(this.f48519m, j11, this.f48511e);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f48512f;
        if (copyOnWriteArrayList != null) {
            for (c cVar : copyOnWriteArrayList) {
                if (cVar != null) {
                    cVar.a(j11, i11);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        if (this.O || campaignEx == null || dVar == null) {
            return;
        }
        this.O = true;
        try {
            dVar.a("resource_type", 4);
            DownloadRequest downloadRequest = this.f48530x;
            if (downloadRequest != null) {
                dVar.a("scenes", downloadRequest.get("scenes", "1"));
                dVar.a("resumed_breakpoint", this.f48530x.get("resumed_breakpoint", "2"));
            } else {
                dVar.a("scenes", "1");
                dVar.a("resumed_breakpoint", "1");
            }
            dVar.a("url", campaignEx.getVideoUrlEncode());
            dVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(this.f48525s));
            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", campaignEx, dVar);
        } catch (Exception e11) {
            ad.b("CampaignDownLoadTask", e11.getMessage());
        }
    }

    public static /* synthetic */ void a(a aVar, int i11, boolean z11) {
        if (aVar.P) {
            return;
        }
        try {
            aVar.P = true;
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            DownloadRequest downloadRequest = aVar.f48530x;
            if (downloadRequest != null) {
                dVar.a("scenes", downloadRequest.get("scenes", ""));
                dVar.a("url", aVar.f48519m);
                dVar.a("resumed_breakpoint", aVar.f48530x.get("resumed_breakpoint", ""));
                dVar.a("h3c", "");
            }
            dVar.a("resource_type", 4);
            dVar.a("file_size", Long.valueOf(aVar.f48518l));
            dVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(aVar.f48525s));
            dVar.a("result", Integer.valueOf(i11));
            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_end", aVar.f48515i, dVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private int b(CampaignEx campaignEx) {
        int iC;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            iC = campaignEx.getReady_rate();
            ad.a("CampaignDownLoadTask", "ready_rate(campaign): " + iC);
        } else {
            iC = c(campaignEx);
            ad.a("CampaignDownLoadTask", "ready_rate(reward_unit_setting): " + iC);
        }
        try {
            return Math.max(iC, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.H == null) {
                    this.H = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48516j);
                }
                return this.H.p();
            }
            if (campaignEx.getAdType() == 42) {
                if (this.J == null) {
                    this.J = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48516j);
                }
                return d((CampaignEx) null);
            }
            if (this.I == null) {
                this.I = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48516j, false);
            }
            return this.I.r();
        } catch (Throwable th2) {
            ad.a("CampaignDownLoadTask", th2.getMessage(), th2);
            return 100;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.J;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            ad.b("CampaignDownLoadTask", e11.getMessage());
            return 100;
        }
    }

    private int e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th2) {
            ad.b("CampaignDownLoadTask", th2.getMessage());
            return 0;
        }
    }

    private void u() {
        if (this.f48527u == null) {
            this.f48527u = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        try {
            try {
                this.f48527u.b(this.f48519m);
                if (!af.a().a("r_d_v_b_l", true)) {
                    File file = new File(this.f48522p);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
            } catch (Throwable unused) {
                ad.b("CampaignDownLoadTask", "del DB or file failed");
            }
        } finally {
            this.f48511e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            String str = com.mbridge.msdk.reward.b.a.f46783b;
            com.mbridge.msdk.reward.b.a.class.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(com.mbridge.msdk.reward.b.a.class.newInstance(), this.f48516j, this.f48515i);
            Map<String, Long> map = NativeController.f45460b;
            NativeController.class.getMethod("insertExcludeId", String.class, CampaignEx.class).invoke(NativeController.class.newInstance(), this.f48516j, this.f48515i);
        } catch (Exception e11) {
            ad.b("CampaignDownLoadTask", e11.getMessage());
        }
    }

    public final void a(int i11) {
        this.f48508b = i11;
    }

    public final void a(int i11, int i12) {
        this.f48511e = i11;
        if (this.f48527u == null) {
            this.f48527u = p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        this.f48527u.a(this.f48519m, i12, i11);
    }

    public final void a(long j11, boolean z11, String str) {
        p pVar;
        ad.b("CampaignDownLoadTask", "setStateToDone 下载完成  ： mProgressSize" + this.f48521o + "  progressSize " + j11 + "  " + this.f48531y + "%   FileSize : " + this.f48518l + "  " + this.f48515i.getAppName());
        if (this.f48525s != 100 || this.f48508b == 3 || j11 == this.f48518l || z11) {
            this.f48511e = 5;
            if (j11 == this.f48518l) {
                a(1, "", str);
            }
            long j12 = this.f48518l;
            if (j12 != 0 && (pVar = this.f48527u) != null) {
                pVar.b(this.f48519m, j12);
            }
            this.f48507a = false;
            a(j11, this.f48511e);
            return;
        }
        File file = new File(this.f48522p);
        ad.b("CampaignDownLoadTask", "progressSize = " + j11 + " fileSize = " + this.f48518l + " " + z11 + " absFileSize = " + (Objects.exists(file, this.f48520n, this.f48529w) ? file.length() : 0L));
        a("File size is not match witch download size.");
    }

    public final void a(CampaignEx campaignEx) {
        this.f48515i = campaignEx;
    }

    public final void a(c cVar) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f48512f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f48513g = aVar;
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.f48513g;
        if (aVar != null) {
            aVar.a(str, this.f48519m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.f48514h;
        if (aVar2 != null) {
            aVar2.a(str, this.f48519m);
        }
        ad.b("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.f48511e == 4 || this.f48511e == 2 || this.f48511e == 5) {
            return;
        }
        this.f48511e = 4;
        CampaignEx campaignEx = this.f48515i;
        if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || this.f48515i.getRsIgnoreCheckRule().size() <= 0 || !this.f48515i.getRsIgnoreCheckRule().contains(0)) {
            a(this.f48521o, this.f48511e);
        } else {
            ad.c("CampaignDownLoadTask", "Is not check video download status");
        }
    }

    public final void a(boolean z11) {
        this.K = z11;
    }

    public final boolean a() {
        return this.K;
    }

    public final void b(int i11) {
        this.f48509c = i11;
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f48514h = aVar;
    }

    public final void b(String str) {
        v();
        a(2, str, "");
        this.f48511e = 4;
    }

    public final void b(boolean z11) {
        this.L = z11;
    }

    public final boolean b() {
        return this.L;
    }

    public final void c(int i11) {
        ad.a("CampaignDownLoadTask", "set ready rate: " + i11);
        this.f48525s = i11;
    }

    public final void c(String str) {
        this.f48522p = str;
    }

    public final void c(boolean z11) {
        this.M = z11;
    }

    public final boolean c() {
        return this.M;
    }

    public final void d(int i11) {
        this.A = i11;
    }

    public final void d(String str) {
        this.f48519m = str;
    }

    public final void d(boolean z11) {
        this.N = z11;
    }

    public final boolean d() {
        return this.N;
    }

    public final String e() {
        return this.f48519m;
    }

    public final void e(int i11) {
        this.C = i11;
    }

    public final void e(boolean z11) {
        this.f48528v = z11;
    }

    public final void f(boolean z11) {
        this.f48523q = z11;
    }

    public final boolean f() {
        return this.f48528v;
    }

    public final long g() {
        return this.f48524r;
    }

    public final String h() {
        return this.f48522p;
    }

    public final boolean i() {
        return this.Q;
    }

    public final long j() {
        return this.f48518l;
    }

    public final int k() {
        return this.f48511e;
    }

    public final CampaignEx l() {
        return this.f48515i;
    }

    public final long m() {
        return this.f48521o;
    }

    public final void n() {
        ad.b("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.f48519m)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.f48513g;
                if (aVar != null) {
                    aVar.a(this.f48519m);
                    return;
                }
                return;
            }
            if (this.f48519m != null) {
                ad.b("CampaignDownLoadTask", new URL(this.f48519m).getPath());
            }
            if (this.f48508b == 3) {
                ad.b("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f48513g;
                if (aVar2 != null) {
                    aVar2.a(this.f48519m);
                    return;
                }
                return;
            }
            if (this.f48525s == 0 && this.C == 2) {
                ad.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.f48513g;
                if (aVar3 != null) {
                    aVar3.a(this.f48519m);
                    return;
                }
                return;
            }
            try {
                if (this.f48511e == 5 && Utils.getDownloadRate(this.f48518l, this.f48521o) >= this.f48525s) {
                    if (Objects.exists(new File(this.f48520n + this.f48529w), this.f48520n, this.f48529w)) {
                        this.f48522p = this.f48520n + this.f48529w;
                        com.mbridge.msdk.videocommon.listener.a aVar4 = this.f48513g;
                        if (aVar4 != null) {
                            aVar4.a(this.f48519m);
                            return;
                        }
                        return;
                    }
                }
            } catch (Exception e11) {
                ad.b("CampaignDownLoadTask", "startForLoadRefactor: " + e11.getMessage());
            }
            DownloadRequest downloadRequest = this.f48530x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.f48513g;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void o() {
        ad.b("CampaignDownLoadTask", "start()");
        try {
            if (TextUtils.isEmpty(this.f48519m)) {
                return;
            }
            if (this.f48519m != null) {
                ad.b("CampaignDownLoadTask", new URL(this.f48519m).getPath());
            }
            if (this.f48525s == 0 && this.C == 2) {
                ad.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                return;
            }
            DownloadRequest downloadRequest = this.f48530x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f48513g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.f48514h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void p() {
        if (this.Q) {
            return;
        }
        try {
            this.f48532z = true;
            if (this.C == 1) {
                ad.b("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.C);
                return;
            }
            if (this.f48508b == 3) {
                ad.b("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.f48508b);
                return;
            }
            ad.b("CampaignDownLoadTask", "resume()");
            this.O = false;
            this.P = false;
            DownloadMessage downloadMessage = new DownloadMessage(new Object(), this.f48519m, this.f48529w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            downloadMessage.setUseCronetDownload(e(this.f48515i));
            DownloadRequest<?> downloadRequestA = a(downloadMessage, this.R, this.S, "2");
            this.f48530x = downloadRequestA;
            downloadRequestA.start();
        } catch (Exception e11) {
            ad.b("CampaignDownLoadTask", e11.getMessage());
        }
    }

    public final String q() {
        String message = "";
        if (this.f48508b == 3) {
            return "";
        }
        String str = this.f48520n + this.f48529w;
        File file = new File(str);
        try {
            if (!Objects.exists(file, this.f48520n, this.f48529w)) {
                message = "file is not exist ";
            } else if (!file.isFile()) {
                message = "file is not file ";
            } else if (!file.canRead()) {
                message = "file can not read ";
            } else if (file.length() > 0) {
                this.f48522p = str;
            } else {
                message = "file length is 0 ";
            }
        } catch (Throwable th2) {
            ad.b("CampaignDownLoadTask", th2.getMessage());
            message = th2.getMessage();
        }
        if (this.f48511e == 5 && !TextUtils.isEmpty(message)) {
            u();
        }
        return message;
    }

    public final void r() {
        if (this.f48512f != null) {
            this.f48512f = null;
        }
    }

    public final void s() {
        try {
            try {
                u();
                CampaignEx campaignEx = this.f48515i;
                if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                    com.mbridge.msdk.videocommon.a.a aVarA = com.mbridge.msdk.videocommon.a.a.a();
                    if (aVarA != null) {
                        aVarA.a(this.f48515i);
                    }
                }
            } catch (Exception unused) {
                ad.b("CampaignDownLoadTask", "del file is failed");
            }
        } finally {
            this.f48511e = 0;
        }
    }

    public final String t() {
        if (this.Q) {
            try {
                File file = new File(this.f48522p);
                return (file.exists() && file.isFile()) ? this.f48522p : this.f48519m;
            } catch (Exception e11) {
                ad.b("CampaignDownLoadTask", e11.getMessage());
                return this.f48519m;
            }
        }
        try {
            File file2 = new File(this.f48522p);
            if (Objects.exists(file2, this.f48520n, this.f48529w) && file2.isFile()) {
                return this.f48522p;
            }
        } catch (Exception e12) {
            ad.b("CampaignDownLoadTask", e12.getMessage());
        }
        return this.f48519m;
    }
}
