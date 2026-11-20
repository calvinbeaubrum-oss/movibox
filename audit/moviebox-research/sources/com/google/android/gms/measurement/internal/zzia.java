package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzia implements Runnable {
    final /* synthetic */ zzib zza;
    private final URL zzb;
    private final String zzc;
    private final zzfp zzd;

    public zzia(zzib zzibVar, String str, URL url, byte[] bArr, Map map, zzfp zzfpVar, byte[] bArr2) {
        this.zza = zzibVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfpVar);
        this.zzb = url;
        this.zzd = zzfpVar;
        this.zzc = str;
    }

    private final void zzb(final int i11, final Exception exc, final byte[] bArr, final Map map) {
        this.zza.zzt.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(i11, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.gms.measurement.internal.zzia] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        ?? r11;
        ?? r12;
        Throwable th2;
        int responseCode;
        IOException e11;
        InputStream inputStream;
        this.zza.zzax();
        try {
            zzib zzibVar = this.zza;
            URLConnection uRLConnectionOpenConnection = this.zzb.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzibVar.zzt.zzf();
            r11 = 60000;
            r12 = 60000;
            httpURLConnection.setConnectTimeout(60000);
            zzibVar.zzt.zzf();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                responseCode = httpURLConnection.getResponseCode();
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i11 = inputStream.read(bArr);
                                    if (i11 <= 0) {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        inputStream.close();
                                        httpURLConnection.disconnect();
                                        zzb(responseCode, null, byteArray, headerFields);
                                        return;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i11);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                        }
                    } catch (IOException e12) {
                        e11 = e12;
                        r12 = 0;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(responseCode, e11, null, r12);
                    } catch (Throwable th5) {
                        th2 = th5;
                        r11 = 0;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(responseCode, null, null, r11);
                        throw th2;
                    }
                } catch (IOException e13) {
                    e11 = e13;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, e11, null, r12);
                } catch (Throwable th6) {
                    th2 = th6;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, null, null, r11);
                    throw th2;
                }
            } catch (IOException e14) {
                e = e14;
                r12 = 0;
                e11 = e;
                responseCode = 0;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(responseCode, e11, null, r12);
            } catch (Throwable th7) {
                th = th7;
                r11 = 0;
                th2 = th;
                responseCode = 0;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(responseCode, null, null, r11);
                throw th2;
            }
        } catch (IOException e15) {
            e = e15;
            httpURLConnection = null;
            r12 = 0;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
            r11 = 0;
        }
    }

    public final /* synthetic */ void zza(int i11, Exception exc, byte[] bArr, Map map) {
        zzfp zzfpVar = this.zzd;
        zzfpVar.zza.zzC(this.zzc, i11, exc, bArr, map);
    }
}
