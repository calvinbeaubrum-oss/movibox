package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.File;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends q implements OnDownloadStateListener<com.mbridge.msdk.newreward.function.d.a.b>, OnProgressStateListener<com.mbridge.msdk.newreward.function.d.a.b>, com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.b f46385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.a f46386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f46387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f46388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f46389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f46390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DownloadMessage f46391g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DownloadRequest f46394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f46395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private x f46396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f46397m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f46399o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f46392h = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f46398n = false;

    public y(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar, n nVar, int i11) {
        this.f46399o = false;
        this.f46385a = bVar;
        this.f46386b = aVar;
        this.f46387c = nVar;
        this.f46393i = i11;
        String strJ = nVar.j();
        this.f46388d = strJ;
        String str = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator;
        this.f46389e = str;
        String strA = com.mbridge.msdk.newreward.function.h.a.a(strJ);
        this.f46390f = strA;
        this.f46397m = str + strA;
        nVar.a(new File(this.f46397m));
        nVar.a(true);
        File file = new File(this.f46397m);
        if (file.exists() && file.isFile()) {
            this.f46399o = true;
            nVar.a(1);
            nVar.b(true);
            nVar.a(false);
        }
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.p
    public final void a(int i11, x xVar) {
        int i12;
        this.f46396l = xVar;
        if (TextUtils.isEmpty(this.f46388d)) {
            if (this.f46387c.c()) {
                x xVar2 = this.f46396l;
                if (xVar2 != null) {
                    xVar2.a(this.f46385a, this.f46386b, this);
                    this.f46396l.b(this.f46385a, this.f46386b, this);
                    return;
                }
                return;
            }
            x xVar3 = this.f46396l;
            if (xVar3 != null) {
                xVar3.a(this.f46385a, this.f46386b, this);
                this.f46396l.a(this.f46385a, this.f46386b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
                return;
            }
            return;
        }
        if (this.f46399o) {
            x xVar4 = this.f46396l;
            if (xVar4 != null) {
                xVar4.a(this.f46385a, this.f46386b, this);
                this.f46396l.b(this.f46385a, this.f46386b, this);
                return;
            }
            return;
        }
        this.f46398n = false;
        int iV = this.f46385a.v();
        this.f46395k = UUID.randomUUID().toString();
        int videoCtnType = this.f46386b.g().getVideoCtnType();
        if (i11 == 1 || (i12 = this.f46393i) == 100 || videoCtnType == 1) {
            this.f46392h = false;
            this.f46391g = new DownloadMessage(this.f46385a, this.f46388d, this.f46390f, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
        } else {
            this.f46392h = true;
            this.f46391g = new DownloadMessage(this.f46385a, this.f46388d, this.f46390f, i12, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
        }
        long j11 = iV;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46395k, j11, this);
        DownloadRequest downloadRequestBuild = MBDownloadManager.getInstance().download(this.f46391g).withReadTimeout(j11).withConnectTimeout(j11).withWriteTimeout(j11).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f46389e).withDownloadStateListener(this).withProgressStateListener(this).with("do_us_fi_re", Boolean.toString(true)).build();
        this.f46394j = downloadRequestBuild;
        downloadRequestBuild.start();
    }

    @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a
    public final void a(String str, long j11) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onTimeout taskID: " + str);
        }
        if (this.f46394j != null) {
            this.f46398n = true;
            this.f46394j.cancel(this.f46391g);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onCancelDownload taskID: " + this.f46395k);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46395k);
        if (this.f46398n) {
            x xVar = this.f46396l;
            if (xVar != null) {
                xVar.b(this.f46385a, this.f46386b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
                return;
            }
            return;
        }
        x xVar2 = this.f46396l;
        if (xVar2 != null) {
            xVar2.a(this.f46385a, this.f46386b, this, new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onDownloadComplete taskID: " + this.f46395k);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46395k);
        this.f46387c.a(TextUtils.equals(this.f46394j.get("cache", "2"), "2") ? 2 : 1);
        this.f46387c.b(true);
        this.f46387c.a(false);
        this.f46387c.a(TextUtils.equals(this.f46394j.get("cache", "2"), "2") ? 2 : 1);
        x xVar = this.f46396l;
        if (xVar != null) {
            xVar.b(this.f46385a, this.f46386b, this);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadError(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage, DownloadError downloadError) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onDownloadError taskID: " + this.f46395k);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46395k);
        this.f46387c.a(TextUtils.equals(this.f46394j.get("cache", "2"), "2") ? 2 : 1);
        this.f46387c.b(false);
        this.f46387c.a(false);
        MBridgeError mBridgeError = new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_ERROR);
        mBridgeError.setException(downloadError.getException());
        x xVar = this.f46396l;
        if (xVar != null) {
            xVar.a(this.f46385a, this.f46386b, this, mBridgeError);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onDownloadStart taskID: " + this.f46395k);
        }
        x xVar = this.f46396l;
        if (xVar != null) {
            xVar.a(this.f46385a, this.f46386b, this);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
    public final void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage, DownloadProgress downloadProgress) {
        if (downloadProgress.getCurrentDownloadRate() >= this.f46393i) {
            this.f46387c.a(TextUtils.equals(this.f46394j.get("cache", "2"), "2") ? 2 : 1);
            this.f46387c.b(true);
            this.f46387c.a(false);
            if (this.f46392h) {
                this.f46394j.cancel(downloadMessage);
            }
        }
    }
}
