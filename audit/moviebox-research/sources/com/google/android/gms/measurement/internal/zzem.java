package com.google.android.gms.measurement.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzem implements Runnable {
    final /* synthetic */ zzen zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzej zzd;
    private final String zze;
    private final Map zzf;

    public zzem(zzen zzenVar, String str, URL url, byte[] bArr, Map map, zzej zzejVar) {
        this.zza = zzenVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzejVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzejVar;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARN: Code duplicated, block: B:75:0x014f  */
    /* JADX WARN: Code duplicated, block: B:85:0x018d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0109: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:54:0x0108 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x010d: MOVE (r12 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:55:0x010b */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Throwable th2;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException e11;
        Map map2;
        int i11;
        zzel zzelVar;
        zzfo zzfoVarZzaz;
        IOException iOException;
        int i12;
        Map map3;
        Map map4;
        InputStream inputStream;
        this.zza.zzax();
        OutputStream outputStream = null;
        try {
            zzen zzenVar = this.zza;
            URLConnection uRLConnectionOpenConnection = this.zzb.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzenVar.zzt.zzf();
            httpURLConnection.setConnectTimeout(60000);
            zzenVar.zzt.zzf();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map map5 = this.zzf;
                if (map5 != null) {
                    for (Map.Entry entry : map5.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.zzc != null) {
                    byte[] bArrZzy = this.zza.zzf.zzu().zzy(this.zzc);
                    zzef zzefVarZzj = this.zza.zzt.zzay().zzj();
                    int length = bArrZzy.length;
                    zzefVarZzj.zzb("Uploading data. size", Integer.valueOf(length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArrZzy);
                        outputStream2.close();
                    } catch (IOException e12) {
                        e11 = e12;
                        map2 = null;
                        outputStream = outputStream2;
                        iOException = e11;
                        i12 = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e13) {
                                this.zza.zzt.zzay().zzd().zzc("Error closing HTTP compressed POST connection output stream. appId", zzeh.zzn(this.zze), e13);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzfoVarZzaz = this.zza.zzt.zzaz();
                        zzelVar = new zzel(this.zze, this.zzd, i12, iOException, null, map2, null);
                        zzfoVarZzaz.zzp(zzelVar);
                    } catch (Throwable th3) {
                        th2 = th3;
                        map = null;
                        outputStream = outputStream2;
                        i11 = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e14) {
                                this.zza.zzt.zzay().zzd().zzc("Error closing HTTP compressed POST connection output stream. appId", zzeh.zzn(this.zze), e14);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zza.zzt.zzaz().zzp(new zzel(this.zze, this.zzd, i11, null, null, map, null));
                        throw th2;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i13 = inputStream.read(bArr);
                                    if (i13 <= 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i13);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                inputStream.close();
                                httpURLConnection.disconnect();
                                zzfoVarZzaz = this.zza.zzt.zzaz();
                                zzelVar = new zzel(this.zze, this.zzd, responseCode, null, byteArray, headerFields, null);
                            } catch (Throwable th4) {
                                th = th4;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                        }
                    } catch (IOException e15) {
                        map2 = null;
                        iOException = e15;
                        i12 = responseCode;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzfoVarZzaz = this.zza.zzt.zzaz();
                        zzelVar = new zzel(this.zze, this.zzd, i12, iOException, null, map2, null);
                    } catch (Throwable th6) {
                        th2 = th6;
                        map = null;
                        i11 = responseCode;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zza.zzt.zzaz().zzp(new zzel(this.zze, this.zzd, i11, null, null, map, null));
                        throw th2;
                    }
                } catch (IOException e16) {
                    iOException = e16;
                    i12 = responseCode;
                    map2 = map4;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzfoVarZzaz = this.zza.zzt.zzaz();
                    zzelVar = new zzel(this.zze, this.zzd, i12, iOException, null, map2, null);
                } catch (Throwable th7) {
                    th2 = th7;
                    i11 = responseCode;
                    map = map3;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.zza.zzt.zzaz().zzp(new zzel(this.zze, this.zzd, i11, null, null, map, null));
                    throw th2;
                }
            } catch (IOException e17) {
                map2 = null;
                iOException = e17;
                i12 = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzfoVarZzaz = this.zza.zzt.zzaz();
                zzelVar = new zzel(this.zze, this.zzd, i12, iOException, null, map2, null);
                zzfoVarZzaz.zzp(zzelVar);
            } catch (Throwable th8) {
                map = null;
                th2 = th8;
            }
            zzfoVarZzaz.zzp(zzelVar);
        } catch (IOException e18) {
            e11 = e18;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th9) {
            th2 = th9;
            httpURLConnection = null;
            map = null;
        }
    }
}
