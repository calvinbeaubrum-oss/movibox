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
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.File;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
abstract class r extends q implements OnDownloadStateListener<com.mbridge.msdk.newreward.function.d.a.b>, OnProgressStateListener<com.mbridge.msdk.newreward.function.d.a.b>, com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.d.a.b f46358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.d.a.a f46359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f46360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f46361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f46362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadMessage f46363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DownloadRequest f46364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f46365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f46366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private x f46367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f46368k = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f46369l;

    public r(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar, b bVar2) {
        this.f46369l = false;
        this.f46358a = bVar;
        this.f46359b = aVar;
        this.f46360c = bVar2;
        this.f46361d = bVar2.j();
        String strA = com.mbridge.msdk.newreward.function.h.a.a(this.f46361d);
        this.f46362e = strA;
        this.f46366i = this.f46368k + strA.replace(".zip", "").replace(".xml", "");
        this.f46360c.a(true);
        File fileA = a(this.f46366i);
        if (fileA == null || !fileA.exists()) {
            return;
        }
        this.f46369l = true;
        this.f46360c.a(1);
        this.f46360c.a(fileA);
        this.f46360c.b(true);
        this.f46360c.a(false);
    }

    private File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str + ".xml");
        return (file.isFile() && file.exists()) ? file : b(str);
    }

    private File b(String str) throws Throwable {
        String strA = com.mbridge.msdk.newreward.function.h.a.a(new File(str + File.separator + "template_config.json"));
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(strA);
            if (jSONArray.length() == 0) {
                return null;
            }
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("xml_type", "");
                    if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, a())) {
                        File file = new File(str + File.separator + jSONObjectOptJSONObject.optString("name", ""));
                        if (file.exists()) {
                            return file;
                        }
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("MBridgeDownloader", "findTemplateFile: " + e11.getMessage());
            }
        }
        return null;
    }

    public abstract String a();

    @Override // com.mbridge.msdk.newreward.function.d.c.p
    public void a(int i11, x xVar) {
        this.f46367j = xVar;
        if (xVar != null) {
            xVar.a(this.f46358a, this.f46359b, this);
        }
        if (this.f46369l) {
            if (xVar != null) {
                xVar.b(this.f46358a, this.f46359b, this);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f46361d)) {
            if (this.f46360c.c()) {
                if (xVar != null) {
                    xVar.b(this.f46358a, this.f46359b, this);
                    return;
                }
                return;
            } else {
                if (xVar != null) {
                    xVar.a(this.f46358a, this.f46359b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
                    return;
                }
                return;
            }
        }
        int iV = this.f46358a.v();
        this.f46365h = UUID.randomUUID().toString();
        long j11 = iV;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46365h, j11, this);
        this.f46363f = new DownloadMessage(this.f46358a, this.f46361d, this.f46362e, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP);
        DownloadRequest downloadRequestBuild = MBDownloadManager.getInstance().download(this.f46363f).withReadTimeout(j11).withConnectTimeout(j11).withWriteTimeout(j11).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f46368k).withDownloadStateListener(this).withProgressStateListener(this).with("do_us_fi_re", Boolean.toString(true)).build();
        this.f46364g = downloadRequestBuild;
        downloadRequestBuild.start();
    }

    @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a
    public void a(String str, long j11) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onTimeout: " + str + " " + d().j());
        }
        DownloadRequest downloadRequest = this.f46364g;
        if (downloadRequest != null) {
            downloadRequest.cancel(this.f46363f);
        }
    }

    public com.mbridge.msdk.newreward.function.d.a.a b() {
        return this.f46359b;
    }

    public com.mbridge.msdk.newreward.function.d.a.b c() {
        return this.f46358a;
    }

    public a<?> d() {
        return this.f46360c;
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onCancelDownload(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onCancelDownload:  " + d().j());
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46365h);
        this.f46360c.a(TextUtils.equals(this.f46364g.get("cache", "2"), "2") ? 2 : 1);
        this.f46360c.b(false);
        this.f46360c.a(false);
        if (this.f46360c.c()) {
            x xVar = this.f46367j;
            if (xVar != null) {
                xVar.b(this.f46358a, this.f46359b, this);
                return;
            }
            return;
        }
        x xVar2 = this.f46367j;
        if (xVar2 != null) {
            xVar2.a(this.f46358a, this.f46359b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onDownloadComplete(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
        x xVar;
        com.mbridge.msdk.newreward.function.d.a.b bVar;
        com.mbridge.msdk.newreward.function.d.a.a aVar;
        MBridgeError mBridgeError;
        x xVar2;
        if (MBridgeConstans.DEBUG) {
            ad.a("MBridgeDownloader", "onDownloadComplete:  " + d().j() + " " + downloadMessage.getSaveFilePath());
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46365h);
        try {
            try {
                MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), this.f46368k);
                this.f46360c.a(TextUtils.equals(this.f46364g.get("cache", "2"), "2") ? 2 : 1);
                this.f46360c.b(true);
                this.f46360c.a(false);
                this.f46360c.a(a(this.f46366i));
                this.f46360c.a(2);
                if (this.f46360c.c()) {
                    xVar2 = this.f46367j;
                    if (xVar2 == null) {
                        return;
                    }
                    xVar2.b(this.f46358a, this.f46359b, this);
                    return;
                }
                xVar = this.f46367j;
                if (xVar != null) {
                    bVar = this.f46358a;
                    aVar = this.f46359b;
                    mBridgeError = new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
                    xVar.a(bVar, aVar, this, mBridgeError);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("MBridgeDownloader", "onDownloadComplete.unZip: " + e11.getMessage());
                }
                if (!this.f46360c.c()) {
                    xVar = this.f46367j;
                    if (xVar != null) {
                        bVar = this.f46358a;
                        aVar = this.f46359b;
                        mBridgeError = new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR);
                        xVar.a(bVar, aVar, this, mBridgeError);
                    }
                    return;
                }
                xVar2 = this.f46367j;
                if (xVar2 == null) {
                }
            }
        } catch (Throwable th2) {
            if (this.f46360c.c()) {
                x xVar3 = this.f46367j;
                if (xVar3 != null) {
                    xVar3.b(this.f46358a, this.f46359b, this);
                }
            } else {
                x xVar4 = this.f46367j;
                if (xVar4 != null) {
                    xVar4.a(this.f46358a, this.f46359b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
                }
            }
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onDownloadError(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage, DownloadError downloadError) {
        String str;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f46365h);
        this.f46360c.a(TextUtils.equals(this.f46364g.get("cache", "2"), "2") ? 2 : 1);
        this.f46360c.b(false);
        this.f46360c.a(false);
        if (this.f46367j != null) {
            b bVar = this.f46360c;
            if (bVar == null) {
                str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR;
            } else {
                int iH = bVar.h();
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
            this.f46367j.a(this.f46358a, this.f46359b, this, mBridgeError);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
    public void onDownloadStart(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage) {
    }

    @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
    public void onProgress(DownloadMessage<com.mbridge.msdk.newreward.function.d.a.b> downloadMessage, DownloadProgress downloadProgress) {
    }
}
