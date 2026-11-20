package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhj extends zzgq implements zzht {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;

    @Nullable
    private final String zze;

    @Nullable
    private final zzhs zzf;
    private final zzhs zzg;

    @Nullable
    private zzhb zzh;

    @Nullable
    private HttpURLConnection zzi;

    @Nullable
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzhj() {
        this(null, 8000, 8000, false, null, null, false);
    }

    private zzhj(@Nullable String str, int i11, int i12, boolean z11, @Nullable zzhs zzhsVar, @Nullable zzfxf zzfxfVar, boolean z12) {
        super(true);
        this.zze = str;
        this.zzc = i11;
        this.zzd = i12;
        this.zzb = z11;
        this.zzf = zzhsVar;
        this.zzg = new zzhs();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    private final HttpURLConnection zzk(URL url, int i11, @Nullable byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map map) throws IOException {
        StringBuilder sb2;
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzc);
        httpURLConnection.setReadTimeout(this.zzd);
        HashMap map2 = new HashMap();
        map2.putAll(this.zzf.zza());
        map2.putAll(this.zzg.zza());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j11 != 0) {
            sb2 = new StringBuilder();
            sb2.append("bytes=");
            sb2.append(j11);
            sb2.append("-");
            if (j12 != -1) {
                sb2.append((j11 + j12) - 1);
            }
            string = sb2.toString();
        } else if (j12 == -1) {
            string = null;
        } else {
            j11 = 0;
            sb2 = new StringBuilder();
            sb2.append("bytes=");
            sb2.append(j11);
            sb2.append("-");
            if (j12 != -1) {
                sb2.append((j11 + j12) - 1);
            }
            string = sb2.toString();
        }
        if (string != null) {
            httpURLConnection.setRequestProperty("Range", string);
        }
        String str = this.zze;
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", true != z11 ? "identity" : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z12);
        httpURLConnection.setDoOutput(false);
        int i12 = zzhb.zzj;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, @Nullable String str, zzhb zzhbVar) throws zzhp {
        if (str == null) {
            throw new zzhp("Null location redirect", zzhbVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                throw new zzhp("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzhbVar, 2001, 1);
            }
            if (this.zzb || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new zzhp("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", zzhbVar, 2001, 1);
        } catch (MalformedURLException e11) {
            throw new zzhp(e11, zzhbVar, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                zzff.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
            this.zzi = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    /* JADX WARN: Code duplicated, block: B:15:0x002c A[Catch: IOException -> 0x001f, TRY_LEAVE, TryCatch #0 {IOException -> 0x001f, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0018, B:12:0x0021, B:15:0x002c), top: B:19:0x0004 }] */
    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws zzhp {
        int i13;
        if (i12 == 0) {
            return 0;
        }
        try {
            long j11 = this.zzm;
            if (j11 != -1) {
                long j12 = j11 - this.zzn;
                if (j12 != 0) {
                    i12 = (int) Math.min(i12, j12);
                    InputStream inputStream = this.zzj;
                    int i14 = zzfy.zza;
                    i13 = inputStream.read(bArr, i11, i12);
                    if (i13 == -1) {
                        this.zzn += (long) i13;
                        zzg(i13);
                        return i13;
                    }
                }
            } else {
                InputStream inputStream2 = this.zzj;
                int i15 = zzfy.zza;
                i13 = inputStream2.read(bArr, i11, i12);
                if (i13 == -1) {
                    this.zzn += (long) i13;
                    zzg(i13);
                    return i13;
                }
            }
            return -1;
        } catch (IOException e11) {
            zzhb zzhbVar = this.zzh;
            int i16 = zzfy.zza;
            throw zzhp.zza(e11, zzhbVar, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhp {
        int i11;
        HttpURLConnection httpURLConnectionZzk;
        byte[] byteArray;
        long j11;
        this.zzh = zzhbVar;
        this.zzn = 0L;
        this.zzm = 0L;
        zzi(zzhbVar);
        try {
            URL url = new URL(zzhbVar.zza.toString());
            long j12 = zzhbVar.zzf;
            long j13 = zzhbVar.zzg;
            boolean zZza = zzhbVar.zza(1);
            if (this.zzb) {
                URL urlZzl = url;
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    if (i12 > 20) {
                        i11 = 1;
                        throw new zzhp(new NoRouteToHostException("Too many redirects: " + i13), zzhbVar, 2001, 1);
                    }
                    long j14 = j13;
                    long j15 = j12;
                    URL url2 = urlZzl;
                    HttpURLConnection httpURLConnectionZzk2 = zzk(urlZzl, 1, null, j12, j13, zZza, false, zzhbVar.zzd);
                    int responseCode = httpURLConnectionZzk2.getResponseCode();
                    String headerField = httpURLConnectionZzk2.getHeaderField(HttpHeaders.LOCATION);
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        httpURLConnectionZzk = httpURLConnectionZzk2;
                        break;
                    }
                    i11 = 1;
                    try {
                        httpURLConnectionZzk2.disconnect();
                        urlZzl = zzl(url2, headerField, zzhbVar);
                        i12 = i13;
                        j13 = j14;
                        j12 = j15;
                    } catch (IOException e11) {
                        e = e11;
                    }
                    e = e11;
                    zzm();
                    throw zzhp.zza(e, zzhbVar, i11);
                }
            }
            httpURLConnectionZzk = zzk(url, 1, null, j12, j13, zZza, true, zzhbVar.zzd);
            try {
                this.zzi = httpURLConnectionZzk;
                this.zzl = httpURLConnectionZzk.getResponseCode();
                String responseMessage = httpURLConnectionZzk.getResponseMessage();
                int i14 = this.zzl;
                if (i14 < 200 || i14 > 299) {
                    Map<String, List<String>> headerFields = httpURLConnectionZzk.getHeaderFields();
                    if (this.zzl == 416) {
                        if (zzhbVar.zzf == zzhu.zzb(httpURLConnectionZzk.getHeaderField("Content-Range"))) {
                            this.zzk = true;
                            zzj(zzhbVar);
                            long j16 = zzhbVar.zzg;
                            if (j16 != -1) {
                                return j16;
                            }
                            return 0L;
                        }
                    }
                    InputStream errorStream = httpURLConnectionZzk.getErrorStream();
                    try {
                        if (errorStream != null) {
                            int i15 = zzfy.zza;
                            byte[] bArr = new byte[4096];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int i16 = errorStream.read(bArr);
                                if (i16 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i16);
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                        } else {
                            byteArray = zzfy.zzf;
                        }
                    } catch (IOException unused) {
                        byteArray = zzfy.zzf;
                    }
                    zzm();
                    throw new zzhr(this.zzl, responseMessage, this.zzl == 416 ? new zzgx(2008) : null, headerFields, zzhbVar, byteArray);
                }
                httpURLConnectionZzk.getContentType();
                if (this.zzl == 200) {
                    j11 = zzhbVar.zzf;
                    if (j11 == 0) {
                        j11 = 0;
                    }
                } else {
                    j11 = 0;
                }
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                if (zEqualsIgnoreCase) {
                    this.zzm = zzhbVar.zzg;
                } else {
                    long j17 = zzhbVar.zzg;
                    if (j17 != -1) {
                        this.zzm = j17;
                    } else {
                        long jZza = zzhu.zza(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionZzk.getHeaderField("Content-Range"));
                        this.zzm = jZza != -1 ? jZza - j11 : -1L;
                    }
                }
                try {
                    this.zzj = httpURLConnectionZzk.getInputStream();
                    if (zEqualsIgnoreCase) {
                        this.zzj = new GZIPInputStream(this.zzj);
                    }
                    this.zzk = true;
                    zzj(zzhbVar);
                    if (j11 != 0) {
                        try {
                            byte[] bArr2 = new byte[4096];
                            while (j11 > 0) {
                                int iMin = (int) Math.min(j11, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                                InputStream inputStream = this.zzj;
                                int i17 = zzfy.zza;
                                int i18 = inputStream.read(bArr2, 0, iMin);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new zzhp(new InterruptedIOException(), zzhbVar, 2000, 1);
                                }
                                if (i18 == -1) {
                                    throw new zzhp(zzhbVar, 2008, 1);
                                }
                                j11 -= (long) i18;
                                zzg(i18);
                            }
                        } catch (IOException e12) {
                            zzm();
                            if (e12 instanceof zzhp) {
                                throw ((zzhp) e12);
                            }
                            throw new zzhp(e12, zzhbVar, 2000, 1);
                        }
                    }
                    return this.zzm;
                } catch (IOException e13) {
                    zzm();
                    throw new zzhp(e13, zzhbVar, 2000, 1);
                }
            } catch (IOException e14) {
                e = e14;
                i11 = 1;
                zzm();
                throw zzhp.zza(e, zzhbVar, i11);
            }
        } catch (IOException e15) {
            e = e15;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000d */
    @Override // com.google.android.gms.internal.ads.zzgw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd() throws zzhp {
        InputStream inputStream = this.zzj;
        if (inputStream != null) {
            if (this.zzi != null) {
                int i11 = zzfy.zza;
            }
            try {
                inputStream.close();
            } catch (IOException e11) {
                zzhb zzhbVar = this.zzh;
                int i12 = zzfy.zza;
                throw new zzhp(e11, zzhbVar, 2000, 3);
            }
        }
        this.zzj = null;
        zzm();
        if (this.zzk) {
            this.zzk = false;
            zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? zzgad.zzd() : new zzhh(httpURLConnection.getHeaderFields());
    }
}
