package com.transsnet.downloader.core.task;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.h0;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.exception.DownloadPauseException;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GetFileInfoTask implements Runnable {
    private final DownloadBean downloadInfo;
    private final com.transsnet.downloader.core.a downloadResponse;
    private final a onGetFileInfoListener;
    private final com.transsnet.downloader.proxy.a proxyHelper;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
    }

    public GetFileInfoTask(com.transsnet.downloader.core.a downloadResponse, DownloadBean downloadInfo, com.transsnet.downloader.proxy.a proxyHelper, a onGetFileInfoListener) {
        Intrinsics.g(downloadResponse, "downloadResponse");
        Intrinsics.g(downloadInfo, "downloadInfo");
        Intrinsics.g(proxyHelper, "proxyHelper");
        Intrinsics.g(onGetFileInfoListener, "onGetFileInfoListener");
        this.proxyHelper = proxyHelper;
        this.downloadResponse = downloadResponse;
        this.downloadInfo = downloadInfo;
    }

    private final void checkIfPause() {
        if (this.downloadInfo.isPause()) {
            throw new DownloadPauseException(7);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004e: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:9:0x004e */
    private final void executeConnection() throws Throwable {
        HttpURLConnection httpURLConnection;
        Exception e11;
        ProtocolException e12;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                try {
                    URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.downloadInfo.getUrl()).openConnection());
                    Intrinsics.e(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) uRLConnection;
                    try {
                        httpURLConnection3.setConnectTimeout(60000);
                        httpURLConnection3.setReadTimeout(60000);
                        httpURLConnection3.setRequestMethod("GET");
                        httpURLConnection3.setRequestProperty("Range", "bytes=0-");
                        int responseCode = httpURLConnection3.getResponseCode();
                        com.transsnet.downloader.proxy.a aVar = this.proxyHelper;
                        String contentType = httpURLConnection3.getContentType();
                        Intrinsics.f(contentType, "httpConnection.contentType");
                        String resourceId = this.downloadInfo.getResourceId();
                        if (resourceId == null) {
                            resourceId = "";
                        }
                        aVar.j(contentType, resourceId);
                        if (responseCode == 200) {
                            parseHttpResponse(httpURLConnection3, false);
                        } else {
                            if (responseCode != 206) {
                                throw new DownloadException(3, "error response code:" + responseCode);
                            }
                            parseHttpResponse(httpURLConnection3, true);
                        }
                        httpURLConnection3.disconnect();
                    } catch (DownloadPauseException unused) {
                        httpURLConnection2 = httpURLConnection3;
                        uo.b.a.f(uo.b.f78622a, DownloadBaseRunnable.TAG, "file downloadPauseException downloadInfo: " + this.downloadInfo.getUrl(), false, 4, null);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (MalformedURLException e13) {
                        e = e13;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Bad url.";
                        }
                        throw new DownloadException(2, message, e);
                    } catch (ProtocolException e14) {
                        e12 = e14;
                        String message2 = e12.getMessage();
                        if (message2 == null) {
                            message2 = "Protocol error";
                        }
                        throw new DownloadException(4, message2, e12);
                    } catch (Exception e15) {
                        e11 = e15;
                        String message3 = e11.getMessage();
                        if (message3 == null) {
                            message3 = "header error";
                        }
                        throw new DownloadException(4, message3, e11);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (DownloadPauseException unused2) {
            } catch (MalformedURLException e16) {
                e = e16;
            } catch (ProtocolException e17) {
                e12 = e17;
            } catch (Exception e18) {
                e11 = e18;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
        }
    }

    private final void parseHttpResponse(HttpURLConnection httpURLConnection, boolean z11) throws DownloadException {
        Long lValueOf;
        String headerField = httpURLConnection != null ? httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LENGTH) : null;
        if (headerField == null) {
            headerField = "0";
        }
        if (TextUtils.isEmpty(headerField) || Intrinsics.b(headerField, "0") || Intrinsics.b(headerField, "-1")) {
            lValueOf = httpURLConnection != null ? Long.valueOf(httpURLConnection.getContentLength()) : null;
        } else {
            lValueOf = Long.valueOf(Long.parseLong(headerField));
        }
        if (TextUtils.isEmpty(this.downloadInfo.getName())) {
            this.downloadInfo.setName(h0.h(System.currentTimeMillis()) + "-" + new Random().nextInt(100));
        }
        String headerField2 = httpURLConnection != null ? httpURLConnection.getHeaderField(HttpHeaders.CONTENT_DISPOSITION) : null;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, DownloadBaseRunnable.TAG, "file contentDis  " + headerField2, false, 4, null);
        List listE0 = headerField2 != null ? StringsKt__StringsKt.E0(headerField2, new String[]{"filename="}, false, 0, 6, null) : null;
        if (listE0 == null || !(!listE0.isEmpty()) || listE0.size() <= 1) {
            this.downloadInfo.setPath(DownloadEsHelper.f60994m.a().d().getAbsolutePath() + File.separatorChar + Uri.decode(this.downloadInfo.getName()).hashCode());
        } else {
            String strReplace = new Regex("[\\\\/:*?\"<>|]").replace(Uri.decode((String) listE0.get(1)).toString(), "");
            this.downloadInfo.setPath(DownloadEsHelper.f60994m.a().d().getAbsolutePath() + File.separatorChar + strReplace);
        }
        uo.b.a.f(aVar, DownloadBaseRunnable.TAG, "filename  " + this.downloadInfo.getPath(), false, 4, null);
        if (lValueOf == null || lValueOf.longValue() <= 0) {
            throw new DownloadException(6, "content-length <= 0");
        }
        checkIfPause();
        lValueOf.longValue();
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            executeConnection();
        } catch (DownloadException e11) {
            uo.b.f78622a.i("GetFileInfoTask --> run() --> executeConnection() --> e = " + e11, true);
            this.downloadResponse.b(this.downloadInfo, e11);
        } catch (Exception e12) {
            uo.b.f78622a.i("GetFileInfoTask --> run() --> executeConnection() --> e = " + e12, true);
            this.downloadResponse.b(this.downloadInfo, new DownloadException(9, e12));
        }
    }
}
