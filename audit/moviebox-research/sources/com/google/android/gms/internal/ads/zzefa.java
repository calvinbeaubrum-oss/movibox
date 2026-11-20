package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzefa implements zzfkp {
    protected final Context zza;
    protected final String zzb;
    protected final zzbzq zzc;

    public zzefa(Context context, String str, zzbzq zzbzqVar, int i11) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbzqVar;
    }

    /* JADX WARN: Code duplicated, block: B:91:0x0221 A[Catch: all -> 0x009a, TryCatch #10 {all -> 0x009a, blocks: (B:12:0x0094, B:89:0x020f, B:91:0x0221, B:93:0x022f, B:21:0x00ab, B:23:0x00b3, B:24:0x00b8, B:26:0x00bc, B:29:0x00ce, B:33:0x00d6, B:34:0x00d9, B:35:0x00da, B:36:0x00f2, B:38:0x00f8, B:40:0x0110, B:41:0x011a, B:42:0x0124, B:44:0x0129, B:50:0x0149, B:52:0x0157, B:55:0x016a, B:56:0x0170, B:59:0x0174, B:68:0x018b, B:69:0x018e, B:73:0x0195, B:75:0x01a1, B:79:0x01c6, B:80:0x01d2, B:81:0x01d3, B:82:0x01df, B:83:0x01e0, B:84:0x0206), top: B:107:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x022f A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #10 {all -> 0x009a, blocks: (B:12:0x0094, B:89:0x020f, B:91:0x0221, B:93:0x022f, B:21:0x00ab, B:23:0x00b3, B:24:0x00b8, B:26:0x00bc, B:29:0x00ce, B:33:0x00d6, B:34:0x00d9, B:35:0x00da, B:36:0x00f2, B:38:0x00f8, B:40:0x0110, B:41:0x011a, B:42:0x0124, B:44:0x0129, B:50:0x0149, B:52:0x0157, B:55:0x016a, B:56:0x0170, B:59:0x0174, B:68:0x018b, B:69:0x018e, B:73:0x0195, B:75:0x01a1, B:79:0x01c6, B:80:0x01d2, B:81:0x01d3, B:82:0x01df, B:83:0x01e0, B:84:0x0206), top: B:107:0x0094 }] */
    @Override // com.google.android.gms.internal.ads.zzfkp
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzeez zza(zzeey zzeeyVar) throws zzead {
        int i11;
        HttpURLConnection httpURLConnection;
        zzeez zzeezVar;
        InputStreamReader inputStreamReader;
        zzefa zzefaVar = this;
        String str = zzeeyVar.zza;
        int i12 = zzeeyVar.zzb;
        Map map = zzeeyVar.zzc;
        byte[] bArr = zzeeyVar.zzd;
        String str2 = zzeeyVar.zze;
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        try {
            zzeez zzeezVar2 = new zzeez();
            zzcec.zzi("SDK version: " + zzefaVar.zzb);
            zzcec.zze("AdRequestServiceImpl: Sending request: " + str);
            URL url = new URL(str);
            HashMap map2 = new HashMap();
            int i13 = 0;
            while (true) {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    com.google.android.gms.ads.internal.util.zzt zztVarZzp = com.google.android.gms.ads.internal.zzt.zzp();
                    Context context = zzefaVar.zza;
                    String str3 = zzefaVar.zzb;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    zzeez zzeezVar3 = zzeezVar2;
                    i11 = 1;
                    try {
                        zztVarZzp.zzf(context, str3, false, httpURLConnection2, false, i12);
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnection = httpURLConnection3;
                            try {
                                try {
                                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    httpURLConnection3 = httpURLConnection;
                                } catch (zzead e11) {
                                    e = e11;
                                    zzeezVar = zzeezVar3;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzih)).booleanValue()) {
                                        throw e;
                                    }
                                    zzeezVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                    httpURLConnection.disconnect();
                                    return zzeezVar;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection.disconnect();
                                throw th;
                            }
                        }
                        httpURLConnection = httpURLConnection3;
                        if (!TextUtils.isEmpty(str2)) {
                            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str2);
                        }
                        int length = bArr.length;
                        BufferedOutputStream bufferedOutputStream = null;
                        if (length > 0) {
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                                try {
                                    bufferedOutputStream2.write(bArr);
                                    IOUtils.closeQuietly(bufferedOutputStream2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    IOUtils.closeQuietly(bufferedOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        zzceb zzcebVar = new zzceb(null);
                        zzcebVar.zzc(httpURLConnection, bArr);
                        int responseCode = httpURLConnection.getResponseCode();
                        for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (map2.containsKey(key)) {
                                ((List) map2.get(key)).addAll(value);
                            } else {
                                map2.put(key, new ArrayList(value));
                            }
                        }
                        zzcebVar.zze(httpURLConnection, responseCode);
                        zzeezVar = zzeezVar3;
                        try {
                            zzeezVar.zza = responseCode;
                            zzeezVar.zzb = map2;
                            zzeezVar.zzc = "";
                            if (responseCode >= 200 && responseCode < 300) {
                                try {
                                    inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                                    try {
                                        com.google.android.gms.ads.internal.zzt.zzp();
                                        String strZzM = com.google.android.gms.ads.internal.util.zzt.zzM(inputStreamReader);
                                        IOUtils.closeQuietly(inputStreamReader);
                                        zzcebVar.zzg(strZzM);
                                        zzeezVar.zzc = strZzM;
                                        if (TextUtils.isEmpty(strZzM)) {
                                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzft)).booleanValue()) {
                                                throw new zzead(3);
                                            }
                                        }
                                        zzeezVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                        break;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        IOUtils.closeQuietly(inputStreamReader);
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    inputStreamReader = null;
                                }
                            } else {
                                if (responseCode < 300 || responseCode >= 400) {
                                    zzcec.zzj("Received error HTTP response code: " + responseCode);
                                    throw new zzead(1, "Received error HTTP response code: " + responseCode);
                                }
                                String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                                if (TextUtils.isEmpty(headerField)) {
                                    zzcec.zzj("No location header to follow redirect.");
                                    throw new zzead(1, "No location header to follow redirect");
                                }
                                URL url2 = new URL(headerField);
                                int i14 = i13 + 1;
                                if (i14 > ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeT)).intValue()) {
                                    zzcec.zzj("Too many redirects.");
                                    throw new zzead(1, "Too many redirects");
                                }
                                try {
                                    httpURLConnection.disconnect();
                                    zzefaVar = this;
                                    i13 = i14;
                                    zzeezVar2 = zzeezVar;
                                    url = url2;
                                } catch (IOException e12) {
                                    e = e12;
                                    String strConcat = "Error while connecting to ad server: ".concat(String.valueOf(e.getMessage()));
                                    zzcec.zzj(strConcat);
                                    throw new zzead(i11, strConcat, e);
                                }
                            }
                        } catch (zzead e13) {
                            e = e13;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzih)).booleanValue()) {
                                throw e;
                            }
                            zzeezVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                        }
                    } catch (zzead e14) {
                        e = e14;
                        httpURLConnection = httpURLConnection3;
                    } catch (Throwable th7) {
                        th = th7;
                        httpURLConnection = httpURLConnection3;
                    }
                } catch (zzead e15) {
                    e = e15;
                    httpURLConnection = httpURLConnection2;
                    zzeezVar = zzeezVar2;
                } catch (Throwable th8) {
                    th = th8;
                    httpURLConnection = httpURLConnection2;
                }
            }
            httpURLConnection.disconnect();
            return zzeezVar;
        } catch (IOException e16) {
            e = e16;
            i11 = 1;
        }
    }
}
