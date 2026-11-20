package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class H5DownLoadManager {
    public static final String SP_ENDING_PAGE_SAVE_TIME = "ending_page_save_time";
    public static final String SP_ENDING_PAGE_SOURCE = "ending_page_source";
    private static final String TAG = "H5DownLoadManager";
    private static volatile H5DownLoadManager sH5Manager;
    private final String DOWN_TYPE = "down_type";
    private final String LOCAL_RID = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    private HTMLResourceManager htmlResourceManager;
    private boolean isUseDownloadModule;
    private CopyOnWriteArrayList<String> mResDownloadingList;
    private ConcurrentMap<String, DownLoadH5SourceListener> mResDownloadingMap;
    private ResourceManager resourceManager;

    /* JADX INFO: compiled from: source.java */
    public interface H5ResDownloadListerInter {
        void onFailed(String str, String str2);

        void onSuccess(String str, String str2, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface IH5SourceDownloadListener extends H5ResDownloadListerInter {
    }

    /* JADX INFO: compiled from: source.java */
    public interface IOnDownLoadH5Source {
        void onFailed(String str);

        void onStart();

        void onSuccess(String str, byte[] bArr, String str2);
    }

    /* JADX INFO: compiled from: source.java */
    public interface ZipDownloadListener extends H5ResDownloadListerInter {
    }

    private H5DownLoadManager() {
        this.isUseDownloadModule = false;
        try {
            this.resourceManager = ResourceManager.getinstance();
            this.htmlResourceManager = HTMLResourceManager.getInstance();
            this.mResDownloadingList = new CopyOnWriteArrayList<>();
            this.mResDownloadingMap = new ConcurrentHashMap();
            g gVarB = h.a().b(c.m().k());
            if (gVarB != null) {
                this.isUseDownloadModule = gVarB.y(1);
            }
        } catch (Throwable th2) {
            ad.a(TAG, th2.getMessage(), th2);
        }
    }

    private void downloadHTML(final b bVar, final String str, final H5ResDownloadListerInter h5ResDownloadListerInter) {
        try {
            ad.b(TAG, "download url:" + str);
            final d dVar = new d();
            dVar.a("scenes", "1");
            dVar.a("url", str);
            if (bVar != null) {
                dVar.a("resource_type", Integer.valueOf(bVar.b()));
            }
            if (this.mResDownloadingList.contains(str)) {
                return;
            }
            this.mResDownloadingList.add(str);
            DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.2
                @Override // com.mbridge.msdk.foundation.same.e.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void pauseTask(boolean z11) {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void runTask() {
                    if (TextUtils.isEmpty(H5DownLoadManager.this.htmlResourceManager.getHtmlContentFromUrl(str))) {
                        DownLoadUtils.getSourceCodeFromNetUrl(str, new IOnDownLoadH5Source() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.2.1
                            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                            public void onFailed(String str2) {
                                try {
                                    H5DownLoadManager.this.mResDownloadingList.remove(str);
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter2 != null) {
                                        h5ResDownloadListerInter2.onFailed(str, str2);
                                    }
                                } catch (Exception e11) {
                                    if (MBridgeConstans.DEBUG) {
                                        e11.printStackTrace();
                                    }
                                    AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter3 != null) {
                                        h5ResDownloadListerInter3.onFailed(str, str2);
                                    }
                                }
                                AnonymousClass2 anonymousClass4 = AnonymousClass2.this;
                                if (h5ResDownloadListerInter == null) {
                                    dVar.a("result", 3);
                                    AnonymousClass2 anonymousClass5 = AnonymousClass2.this;
                                    bVar.a("m_download_end", dVar);
                                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_end", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                }
                            }

                            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                            public void onStart() {
                            }

                            @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                            public void onSuccess(String str2, byte[] bArr, String str3) {
                                try {
                                    H5DownLoadManager.this.mResDownloadingList.remove(str3);
                                    if (bArr == null || bArr.length <= 0) {
                                        return;
                                    }
                                    if (H5DownLoadManager.this.htmlResourceManager.saveResHtmlFile(str3, bArr)) {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                                        if (h5ResDownloadListerInter2 != null) {
                                            h5ResDownloadListerInter2.onSuccess(str3, "", false);
                                            return;
                                        }
                                        dVar.a("result", 3);
                                        AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                        bVar.a("m_download_end", dVar);
                                        com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_end", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                        return;
                                    }
                                    AnonymousClass2 anonymousClass4 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter3 != null) {
                                        h5ResDownloadListerInter3.onFailed(str3, "save file failed");
                                        return;
                                    }
                                    dVar.a("result", 3);
                                    AnonymousClass2 anonymousClass5 = AnonymousClass2.this;
                                    bVar.a("m_download_end", dVar);
                                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_end", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                } catch (Exception e11) {
                                    if (MBridgeConstans.DEBUG) {
                                        e11.printStackTrace();
                                    }
                                    AnonymousClass2 anonymousClass6 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter4 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter4 != null) {
                                        h5ResDownloadListerInter4.onFailed(str3, e11.getMessage());
                                        return;
                                    }
                                    dVar.a("result", 3);
                                    AnonymousClass2 anonymousClass7 = AnonymousClass2.this;
                                    bVar.a("m_download_end", dVar);
                                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_end", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                }
                            }
                        }, true);
                        dVar.a("cache", 1);
                        bVar.a("m_download_start", dVar);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        return;
                    }
                    dVar.a("cache", 2);
                    H5DownLoadManager.this.mResDownloadingList.remove(str);
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onSuccess(str, "", true);
                    }
                    bVar.a("m_download_start", dVar);
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                }
            });
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    private void downloadHTMLByDownloadModule(final String str, final H5ResDownloadListerInter h5ResDownloadListerInter) {
        if (TextUtils.isEmpty(str)) {
            if (h5ResDownloadListerInter != null) {
                h5ResDownloadListerInter.onFailed("zip url is null", str);
                return;
            }
            return;
        }
        try {
            new URL(str);
            String str2 = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML) + "/";
            String md5 = SameMD5.getMD5(ao.b(str));
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, md5 + ".html", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withReadTimeout(30000L).withConnectTimeout(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.1
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onCancelDownload(DownloadMessage downloadMessage) {
                    ad.a(H5DownLoadManager.TAG, "下载取消： ");
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onFailed(str, "task cancel");
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadComplete(DownloadMessage downloadMessage) {
                    ad.a(H5DownLoadManager.TAG, "下载结束： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + " " + downloadMessage.getSaveFilePath());
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onSuccess(str, "", false);
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                    ad.a(H5DownLoadManager.TAG, "下载结束失败： " + downloadError.getException().getMessage());
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onFailed(str, downloadError.getException().getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadStart(DownloadMessage downloadMessage) {
                    ad.a(H5DownLoadManager.TAG, "开始下载 html： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                }
            }).build().start();
        } catch (Exception unused) {
            if (h5ResDownloadListerInter != null) {
                h5ResDownloadListerInter.onFailed("zip url is unlawful", str);
            }
        }
    }

    private void downloadZipByDownloadModule(final b bVar, String str, final ZipDownloadListener zipDownloadListener) {
        if (TextUtils.isEmpty(str)) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "zip url is null");
                return;
            }
            return;
        }
        try {
            new URL(str);
            final d dVar = new d();
            dVar.a("scenes", "1");
            dVar.a("url", str);
            if (bVar != null) {
                dVar.a("resource_type", Integer.valueOf(bVar.b()));
            }
            String strA = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
            String md5 = SameMD5.getMD5(ao.b(str));
            String str2 = strA + "/";
            final String str3 = strA + "/" + md5;
            DownloadMessage<?> downloadMessage = new DownloadMessage<>(bVar, str, md5 + ".zip", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP);
            if (bVar != null) {
                downloadMessage.setUseCronetDownload(bVar.n());
            }
            MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(30000L).withConnectTimeout(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.3
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onCancelDownload(DownloadMessage downloadMessage2) {
                    ad.a(H5DownLoadManager.TAG, "下载取消： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType());
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a("cache", Integer.valueOf(downloadMessage2.isCache() ? 1 : 2));
                    }
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a("m_download_start", dVar);
                    }
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    if (TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage2.getDownloadUrl()))) {
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onFailed(downloadMessage2.getDownloadUrl(), "task cancel");
                            return;
                        }
                        return;
                    }
                    ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                    if (zipDownloadListener3 != null) {
                        zipDownloadListener3.onSuccess(downloadMessage2.getDownloadUrl(), "", downloadMessage2.isCache());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadComplete(DownloadMessage downloadMessage2) throws Throwable {
                    ad.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType() + " " + downloadMessage2.getSaveFilePath());
                    try {
                        d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.a("cache", Integer.valueOf(downloadMessage2.isCache() ? 1 : 2));
                        }
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a("m_download_start", dVar);
                        }
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        if (TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage2.getDownloadUrl()))) {
                            MBResourceManager.getInstance().unZip(downloadMessage2.getSaveFilePath(), str3);
                        }
                        String str4 = "";
                        try {
                            str4 = (String) downloadMessage2.getExtra("responseHeaders");
                        } catch (Throwable th2) {
                            ad.b(H5DownLoadManager.TAG, th2.getMessage());
                        }
                        ad.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件，文件解压成功： " + str3);
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onSuccess(downloadMessage2.getDownloadUrl(), str4, downloadMessage2.isCache());
                        }
                    } catch (IOException e11) {
                        ad.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件，文件解压失败： " + e11.getMessage());
                        ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                        if (zipDownloadListener3 != null) {
                            zipDownloadListener3.onFailed(downloadMessage2.getDownloadUrl(), e11.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadError(DownloadMessage downloadMessage2, DownloadError downloadError) {
                    ad.a(H5DownLoadManager.TAG, "下载错误： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType() + "  " + downloadError.getException().getMessage());
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a("cache", Integer.valueOf(downloadMessage2.isCache() ? 1 : 2));
                    }
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a("m_download_start", dVar);
                    }
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    if (TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage2.getDownloadUrl()))) {
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onFailed(downloadMessage2.getDownloadUrl(), downloadError.getException().getMessage());
                            return;
                        }
                        return;
                    }
                    ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                    if (zipDownloadListener3 != null) {
                        zipDownloadListener3.onSuccess(downloadMessage2.getDownloadUrl(), "", downloadMessage2.isCache());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadStart(DownloadMessage downloadMessage2) {
                    ad.a(H5DownLoadManager.TAG, "开始下载 zip： " + downloadMessage2.getDownloadUrl() + " " + downloadMessage2.getDownloadResourceType());
                }
            }).build().start();
        } catch (Exception unused) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "zip url is unlawful");
            }
        }
    }

    private void downloadZipByOldDownloadModule(b bVar, String str, ZipDownloadListener zipDownloadListener) {
        d dVar = new d();
        dVar.a("scenes", "1");
        dVar.a("url", str);
        if (bVar != null) {
            dVar.a("resource_type", Integer.valueOf(bVar.b()));
        }
        try {
            if (TextUtils.isEmpty(this.resourceManager.getResDirFromCampaign(str))) {
                dVar.a("cache", 2);
                if (this.mResDownloadingMap.containsKey(str)) {
                    DownLoadH5SourceListener downLoadH5SourceListener = this.mResDownloadingMap.get(str);
                    if (downLoadH5SourceListener != null) {
                        downLoadH5SourceListener.setZipDownloadListener(zipDownloadListener);
                    }
                    if (bVar == null || bVar.a()) {
                        return;
                    }
                    bVar.a("m_download_start", dVar);
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    return;
                }
                DownLoadH5SourceListener downLoadH5SourceListener2 = new DownLoadH5SourceListener(this.mResDownloadingMap, this.resourceManager, zipDownloadListener, str);
                this.mResDownloadingMap.put(str, downLoadH5SourceListener2);
                DownLoadUtils.getSourceCodeFromNetUrl(str, downLoadH5SourceListener2, true);
            } else {
                dVar.a("cache", 1);
                if (zipDownloadListener != null) {
                    zipDownloadListener.onSuccess(str, "", true);
                }
            }
            if (bVar == null || bVar.a()) {
                return;
            }
            bVar.a("m_download_start", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e11) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "downloadzip failed");
            }
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private String getHtmlAddress(String str) {
        HTMLResourceManager hTMLResourceManager = this.htmlResourceManager;
        return hTMLResourceManager != null ? hTMLResourceManager.getHtmlPathFromUrl(str) : str;
    }

    public static H5DownLoadManager getInstance() {
        if (sH5Manager == null) {
            synchronized (H5DownLoadManager.class) {
                try {
                    if (sH5Manager == null) {
                        sH5Manager = new H5DownLoadManager();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sH5Manager;
    }

    private long getPreSaveTimeFromSp(String str) {
        try {
            Object objA = al.a(c.m().c(), SP_ENDING_PAGE_SAVE_TIME + str, 0L);
            if (objA != null && (objA instanceof Long)) {
                return ((Long) objA).longValue();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return 0L;
    }

    private void saveSourceContent(String str, String str2) {
        try {
            ad.c(TAG, "sourceContent:" + str);
            al.b(c.m().c(), SP_ENDING_PAGE_SOURCE + str2, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void updateEndingPageSaveTime(String str) {
        try {
            al.b(c.m().c(), SP_ENDING_PAGE_SAVE_TIME + str, Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void download(b bVar, String str) {
        download(bVar, str, null);
    }

    public void download(b bVar, String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        if (this.isUseDownloadModule) {
            downloadHTMLByDownloadModule(str, h5ResDownloadListerInter);
        } else {
            downloadHTML(bVar, str, h5ResDownloadListerInter);
        }
    }

    public void downloadH5Res(b bVar, String str) {
        downloadH5Res(bVar, str, null);
    }

    public void downloadH5Res(b bVar, String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        b bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(bVar);
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        downloadZip(bVarB, str, (ZipDownloadListener) h5ResDownloadListerInter);
                        return;
                    } else {
                        download(bVarB, str, h5ResDownloadListerInter);
                        return;
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (h5ResDownloadListerInter != null) {
            h5ResDownloadListerInter.onFailed(str, "The URL does not contain a path ");
        }
    }

    public void downloadH5Res(String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        downloadH5Res(new b(), str, h5ResDownloadListerInter);
    }

    public void downloadZip(b bVar, String str, ZipDownloadListener zipDownloadListener) {
        if (this.isUseDownloadModule) {
            downloadZipByDownloadModule(bVar, str, zipDownloadListener);
        } else {
            downloadZipByOldDownloadModule(bVar, str, zipDownloadListener);
        }
    }

    public String getH5ResAddress(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri uri = Uri.parse(str);
                String path = uri.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                    return str;
                }
                return path.toLowerCase().endsWith(".zip") ? getResAddress(str) : getHtmlAddress(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return str;
    }

    public String getResAddress(String str) {
        ResourceManager resourceManager = this.resourceManager;
        if (resourceManager != null) {
            return resourceManager.getResDirFromCampaign(str);
        }
        return null;
    }

    public String getSourceContentFromSp(String str) {
        try {
            Object objA = al.a(c.m().c(), SP_ENDING_PAGE_SOURCE + str, "");
            if (objA == null || !(objA instanceof String)) {
                return null;
            }
            String str2 = (String) objA;
            if (an.b(str2)) {
                return str2;
            }
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
