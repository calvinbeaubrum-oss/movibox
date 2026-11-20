package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f43142a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.c.g f43143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f43145d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f43146e = 3145728;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f43147f;

    public h() {
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        this.f43143b = gVarB;
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            this.f43143b = com.mbridge.msdk.c.i.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0040 A[Catch: all -> 0x000f, TryCatch #5 {all -> 0x000f, blocks: (B:4:0x0008, B:9:0x0013, B:22:0x003c, B:24:0x0040, B:25:0x004d), top: B:41:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0058 A[Catch: Exception -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0031, blocks: (B:18:0x002d, B:27:0x0058), top: B:39:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String a(InputStream inputStream, boolean z11) throws Throwable {
        Throwable th2;
        Exception e11;
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            if (z11) {
                try {
                    try {
                        inputStream = new GZIPInputStream(inputStream);
                    } catch (Exception e12) {
                        e11 = e12;
                        if (this.f43147f == null) {
                            com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
                            this.f43147f = aVar;
                            aVar.f43128h = e11.getMessage();
                        }
                        ad.b(f43142a, e11.getMessage());
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb2.toString();
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e13) {
                            ad.b(f43142a, e13.getMessage());
                        }
                    }
                    throw th2;
                }
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                } catch (Exception e14) {
                    e11 = e14;
                    bufferedReader = bufferedReader2;
                    if (this.f43147f == null) {
                        com.mbridge.msdk.click.entity.a aVar2 = new com.mbridge.msdk.click.entity.a();
                        this.f43147f = aVar2;
                        aVar2.f43128h = e11.getMessage();
                    }
                    ad.b(f43142a, e11.getMessage());
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return sb2.toString();
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th2;
                }
            }
            bufferedReader2.close();
        } catch (Exception e15) {
            ad.b(f43142a, e15.getMessage());
        }
        return sb2.toString();
    }

    public final com.mbridge.msdk.click.entity.a a(String str, boolean z11, boolean z12, CampaignEx campaignEx) {
        int i11;
        HttpURLConnection httpURLConnection = null;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String strReplace = str.replace(" ", "%20");
        this.f43147f = new com.mbridge.msdk.click.entity.a();
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(strReplace).openConnection()));
            try {
                httpURLConnection2.setRequestMethod("GET");
                if ((!z11 && !z12) || campaignEx == null) {
                    httpURLConnection2.setRequestProperty("User-Agent", z.g());
                }
                if (z11 && campaignEx != null && campaignEx.getcUA() == 1) {
                    httpURLConnection2.setRequestProperty("User-Agent", z.g());
                }
                if (z12 && campaignEx != null && campaignEx.getImpUA() == 1) {
                    httpURLConnection2.setRequestProperty("User-Agent", z.g());
                }
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                if (this.f43143b.aI() && !TextUtils.isEmpty(this.f43144c)) {
                    httpURLConnection2.setRequestProperty(RequestParameters.SUBRESOURCE_REFERER, this.f43144c);
                }
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.connect();
                this.f43147f.f43121a = httpURLConnection2.getHeaderField(HttpHeaders.LOCATION);
                this.f43147f.f43124d = httpURLConnection2.getHeaderField("Referer");
                this.f43147f.f43126f = httpURLConnection2.getResponseCode();
                this.f43147f.f43122b = httpURLConnection2.getContentType();
                this.f43147f.f43125e = httpURLConnection2.getContentLength();
                this.f43147f.f43123c = httpURLConnection2.getContentEncoding();
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(this.f43147f.f43123c);
                com.mbridge.msdk.click.entity.a aVar = this.f43147f;
                if (aVar.f43126f == 200 && this.f43145d && (i11 = aVar.f43125e) > 0 && i11 < 3145728 && !TextUtils.isEmpty(strReplace)) {
                    try {
                        String strA = a(httpURLConnection2.getInputStream(), zEqualsIgnoreCase);
                        if (!TextUtils.isEmpty(strA)) {
                            byte[] bytes = strA.getBytes();
                            if (bytes.length > 0 && bytes.length < 3145728) {
                                this.f43147f.f43127g = strA.trim();
                            }
                        }
                    } catch (Throwable th2) {
                        ad.b(f43142a, th2.getMessage());
                    }
                }
                this.f43144c = strReplace;
                httpURLConnection2.disconnect();
                return this.f43147f;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                try {
                    this.f43147f.f43128h = th.getMessage();
                    return this.f43147f;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
