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
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends q implements OnDownloadStateListener<com.mbridge.msdk.newreward.function.d.a.b>, OnProgressStateListener<com.mbridge.msdk.newreward.function.d.a.b>, com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f46370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f46371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f46372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.d.a.b f46373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.d.a.a f46374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f46375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f46376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DownloadMessage f46377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DownloadRequest f46378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f46379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private x f46380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f46381l;

    public v(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar, c cVar) {
        this.f46381l = false;
        this.f46373d = bVar;
        this.f46374e = aVar;
        this.f46375f = cVar;
        this.f46376g = cVar.j();
        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
        String md5 = SameMD5.getMD5(ao.b(this.f46376g));
        this.f46370a = md5;
        this.f46371b = strA + "/";
        this.f46372c = strA + "/" + md5;
        this.f46375f.a(true);
        String resDirFromCampaign = ResourceManager.getinstance().getResDirFromCampaign(this.f46376g);
        if (TextUtils.isEmpty(resDirFromCampaign)) {
            return;
        }
        this.f46381l = true;
        this.f46375f.a(1);
        this.f46375f.a(resDirFromCampaign);
        this.f46375f.b(true);
        this.f46375f.a(false);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.p
    public final void a(int i11, x xVar) {
        this.f46380k = xVar;
        int iV = this.f46373d.v();
        this.f46379j = UUID.randomUUID().toString();
        if (xVar != null) {
            xVar.a(this.f46373d, this.f46374e, this);
        }
        if (this.f46381l) {
            x xVar2 = this.f46380k;
            if (xVar2 != null) {
                xVar2.b(this.f46373d, this.f46374e, this);
                return;
            }
            return;
        }
        long j11 = iV;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46379j, j11, this);
        this.f46377h = new DownloadMessage(this.f46373d, this.f46376g, this.f46370a + ".zip", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP);
        DownloadRequest downloadRequestBuild = MBDownloadManager.getInstance().download(this.f46377h).withReadTimeout(j11).withConnectTimeout(j11).withWriteTimeout(j11).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f46371b).withDownloadStateListener(this).withProgressStateListener(this).with("do_us_fi_re", Boolean.toString(true)).build();
        this.f46378i = downloadRequestBuild;
        downloadRequestBuild.start();
    }

    @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a
    public final void a(String str, long j11) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onTimeout: " + str);
        }
        DownloadRequest downloadRequest = this.f46378i;
        if (downloadRequest != null) {
            downloadRequest.cancel(this.f46377h);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onCancelDownload: " + downloadMessage);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46379j);
        this.f46375f.a(TextUtils.equals(this.f46378i.get("cache", "2"), "2") ? 2 : 1);
        this.f46375f.b(false);
        this.f46375f.a(false);
        if (this.f46375f.c()) {
            x xVar = this.f46380k;
            if (xVar != null) {
                xVar.b(this.f46373d, this.f46374e, this);
                return;
            }
            return;
        }
        x xVar2 = this.f46380k;
        if (xVar2 != null) {
            xVar2.a(this.f46373d, this.f46374e, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        x xVar;
        com.mbridge.msdk.newreward.function.d.a.b bVar;
        com.mbridge.msdk.newreward.function.d.a.a aVar;
        MBridgeError mBridgeError;
        x xVar2;
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onDownloadComplete: " + downloadMessage);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46379j);
        try {
            try {
                MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), this.f46372c);
                String resDirFromCampaign = ResourceManager.getinstance().getResDirFromCampaign(this.f46376g);
                if (!TextUtils.isEmpty(resDirFromCampaign)) {
                    this.f46375f.a(TextUtils.equals(this.f46378i.get("cache", "2"), "2") ? 2 : 1);
                    this.f46375f.b(true);
                    this.f46375f.a(false);
                    this.f46375f.a(2);
                    this.f46375f.a(resDirFromCampaign);
                }
                if (this.f46375f.c()) {
                    xVar2 = this.f46380k;
                    if (xVar2 == null) {
                        return;
                    }
                    xVar2.b(this.f46373d, this.f46374e, this);
                    return;
                }
                xVar = this.f46380k;
                if (xVar != null) {
                    bVar = this.f46373d;
                    aVar = this.f46374e;
                    mBridgeError = new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
                    xVar.a(bVar, aVar, this, mBridgeError);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("MBridgeDownloader", "onDownloadComplete.unZip: " + e11.getMessage());
                }
                if (!this.f46375f.c()) {
                    xVar = this.f46380k;
                    if (xVar != null) {
                        bVar = this.f46373d;
                        aVar = this.f46374e;
                        mBridgeError = new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
                        xVar.a(bVar, aVar, this, mBridgeError);
                    }
                    return;
                }
                xVar2 = this.f46380k;
                if (xVar2 == null) {
                }
            }
        } catch (Throwable th2) {
            if (this.f46375f.c()) {
                x xVar3 = this.f46380k;
                if (xVar3 != null) {
                    xVar3.b(this.f46373d, this.f46374e, this);
                }
            } else {
                x xVar4 = this.f46380k;
                if (xVar4 != null) {
                    xVar4.a(this.f46373d, this.f46374e, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
                }
            }
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadError(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage, DownloadError downloadError) {
        String str;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46379j);
        this.f46375f.a(TextUtils.equals(this.f46378i.get("cache", "2"), "2") ? 2 : 1);
        this.f46375f.b(false);
        this.f46375f.a(false);
        if (this.f46375f.c()) {
            x xVar = this.f46380k;
            if (xVar != null) {
                xVar.b(this.f46373d, this.f46374e, this);
                return;
            }
            return;
        }
        if (this.f46380k != null) {
            c cVar = this.f46375f;
            if (cVar == null) {
                str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR;
            } else {
                int iH = cVar.h();
                if (iH == 2) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_TEMPLATE_ERROR;
                } else if (iH == 3) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_BIG_TEMPLATE_ERROR;
                } else if (iH != 4) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR;
                } else {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_EC_TEMPLATE_ERROR;
                }
            }
            MBridgeError mBridgeError = new MBridgeError(2, str);
            mBridgeError.setException(downloadError.getException());
            this.f46380k.a(this.f46373d, this.f46374e, this, mBridgeError);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public final void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
    }

    @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
    public final void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage, DownloadProgress downloadProgress) {
    }
}
