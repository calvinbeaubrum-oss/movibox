package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcih extends zzgq implements zzht {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzc = new AtomicReference();
    private final SSLSocketFactory zzd;
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzhs zzh;
    private zzhb zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private int zzr;
    private final Set zzs;

    public zzcih(String str, zzhy zzhyVar, int i11, int i12, int i13) {
        super(true);
        this.zzd = new zzcig(this);
        this.zzs = new HashSet();
        zzek.zzc(str);
        this.zzg = str;
        this.zzh = new zzhs();
        this.zze = i11;
        this.zzf = i12;
        this.zzr = i13;
        if (zzhyVar != null) {
            zzf(zzhyVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                zzcec.zzh("Unexpected error while disconnecting", e11);
            }
            this.zzj = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007b A[Catch: IOException -> 0x001b, TryCatch #0 {IOException -> 0x001b, blocks: (B:2:0x0000, B:23:0x005a, B:25:0x0062, B:28:0x006d, B:29:0x0073, B:31:0x007b, B:34:0x0082, B:35:0x0087, B:36:0x0088, B:5:0x000b, B:7:0x0016, B:10:0x001e, B:12:0x0026, B:15:0x003c, B:16:0x0046, B:17:0x004b, B:18:0x004c, B:19:0x0051, B:20:0x0052), top: B:40:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x0082 A[Catch: IOException -> 0x001b, TryCatch #0 {IOException -> 0x001b, blocks: (B:2:0x0000, B:23:0x005a, B:25:0x0062, B:28:0x006d, B:29:0x0073, B:31:0x007b, B:34:0x0082, B:35:0x0087, B:36:0x0088, B:5:0x000b, B:7:0x0016, B:10:0x001e, B:12:0x0026, B:15:0x003c, B:16:0x0046, B:17:0x004b, B:18:0x004c, B:19:0x0051, B:20:0x0052), top: B:40:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0088 A[Catch: IOException -> 0x001b, TRY_LEAVE, TryCatch #0 {IOException -> 0x001b, blocks: (B:2:0x0000, B:23:0x005a, B:25:0x0062, B:28:0x006d, B:29:0x0073, B:31:0x007b, B:34:0x0082, B:35:0x0087, B:36:0x0088, B:5:0x000b, B:7:0x0016, B:10:0x001e, B:12:0x0026, B:15:0x003c, B:16:0x0046, B:17:0x004b, B:18:0x004c, B:19:0x0051, B:20:0x0052), top: B:40:0x0000 }] */
    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws zzhp {
        int i13;
        try {
            if (this.zzp != this.zzn) {
                byte[] bArr2 = (byte[]) zzc.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j11 = this.zzp;
                    long j12 = this.zzn;
                    if (j11 == j12) {
                        zzc.set(bArr2);
                        break;
                    }
                    int i14 = this.zzk.read(bArr2, 0, (int) Math.min(j12 - j11, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i14 == -1) {
                        throw new EOFException();
                    }
                    this.zzp += (long) i14;
                    zzg(i14);
                }
            }
            if (i12 == 0) {
                return 0;
            }
            long j13 = this.zzo;
            if (j13 != -1) {
                long j14 = j13 - this.zzq;
                if (j14 != 0) {
                    i12 = (int) Math.min(i12, j14);
                    i13 = this.zzk.read(bArr, i11, i12);
                    if (i13 == -1) {
                        this.zzq += (long) i13;
                        zzg(i13);
                        return i13;
                    }
                    if (this.zzo == -1) {
                        throw new EOFException();
                    }
                }
            } else {
                i13 = this.zzk.read(bArr, i11, i12);
                if (i13 == -1) {
                    this.zzq += (long) i13;
                    zzg(i13);
                    return i13;
                }
                if (this.zzo == -1) {
                    throw new EOFException();
                }
            }
            return -1;
        } catch (IOException e11) {
            throw new zzhp(e11, this.zzi, 2000, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x00bc A[Catch: IOException -> 0x003c, TryCatch #4 {IOException -> 0x003c, blocks: (B:3:0x000e, B:4:0x0023, B:6:0x0029, B:8:0x0033, B:11:0x0040, B:12:0x0058, B:14:0x005e, B:21:0x0082, B:23:0x009c, B:24:0x00ae, B:25:0x00b3, B:27:0x00bc, B:28:0x00c3, B:41:0x00ee, B:94:0x0239, B:96:0x0244, B:98:0x0255, B:101:0x025e, B:102:0x026d, B:104:0x0275, B:105:0x027c, B:106:0x027d, B:107:0x0293), top: B:118:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:51:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0244 A[Catch: IOException -> 0x003c, TryCatch #4 {IOException -> 0x003c, blocks: (B:3:0x000e, B:4:0x0023, B:6:0x0029, B:8:0x0033, B:11:0x0040, B:12:0x0058, B:14:0x005e, B:21:0x0082, B:23:0x009c, B:24:0x00ae, B:25:0x00b3, B:27:0x00bc, B:28:0x00c3, B:41:0x00ee, B:94:0x0239, B:96:0x0244, B:98:0x0255, B:101:0x025e, B:102:0x026d, B:104:0x0275, B:105:0x027c, B:106:0x027d, B:107:0x0293), top: B:118:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhp {
        int responseCode;
        String headerField;
        String protocol;
        long j11;
        long jMax;
        this.zzi = zzhbVar;
        long j12 = 0;
        this.zzq = 0L;
        this.zzp = 0L;
        try {
            URL url = new URL(zzhbVar.zza.toString());
            long j13 = zzhbVar.zzf;
            long j14 = zzhbVar.zzg;
            boolean zZza = zzhbVar.zza(1);
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i12);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.zzd);
                }
                httpURLConnection.setConnectTimeout(this.zze);
                httpURLConnection.setReadTimeout(this.zzf);
                for (Map.Entry entry : this.zzh.zza().entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (j13 == j12) {
                    if (j14 != -1) {
                    }
                    httpURLConnection.setRequestProperty("User-Agent", this.zzg);
                    if (!zZza) {
                        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        this.zzj = httpURLConnection;
                        try {
                            int responseCode2 = httpURLConnection.getResponseCode();
                            this.zzm = responseCode2;
                            if (responseCode2 < 200 || responseCode2 > 299) {
                                Map<String, List<String>> headerFields = this.zzj.getHeaderFields();
                                zzn();
                                zzhr zzhrVar = new zzhr(this.zzm, null, null, headerFields, zzhbVar, zzfy.zzf);
                                if (this.zzm != 416) {
                                    throw zzhrVar;
                                }
                                zzhrVar.initCause(new zzgx(2008));
                                throw zzhrVar;
                            }
                            if (responseCode2 == 200) {
                                j11 = zzhbVar.zzf;
                                if (j11 == 0) {
                                    j11 = 0;
                                }
                            } else {
                                j11 = 0;
                            }
                            this.zzn = j11;
                            if (zzhbVar.zza(1)) {
                                this.zzo = zzhbVar.zzg;
                            } else {
                                long j15 = zzhbVar.zzg;
                                if (j15 != -1) {
                                    this.zzo = j15;
                                } else {
                                    HttpURLConnection httpURLConnection2 = this.zzj;
                                    String headerField2 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                                    if (TextUtils.isEmpty(headerField2)) {
                                        jMax = -1;
                                    } else {
                                        try {
                                            jMax = Long.parseLong(headerField2);
                                        } catch (NumberFormatException unused) {
                                            zzcec.zzg("Unexpected Content-Length [" + headerField2 + "]");
                                            jMax = -1;
                                        }
                                    }
                                    String headerField3 = httpURLConnection2.getHeaderField("Content-Range");
                                    if (!TextUtils.isEmpty(headerField3)) {
                                        Matcher matcher = zzb.matcher(headerField3);
                                        if (matcher.find()) {
                                            try {
                                                long j16 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                                if (jMax < 0) {
                                                    jMax = j16;
                                                } else if (jMax != j16) {
                                                    zzcec.zzj("Inconsistent headers [" + headerField2 + "] [" + headerField3 + "]");
                                                    jMax = Math.max(jMax, j16);
                                                }
                                            } catch (NumberFormatException unused2) {
                                                zzcec.zzg("Unexpected Content-Range [" + headerField3 + "]");
                                            }
                                        }
                                    }
                                    this.zzo = jMax != -1 ? jMax - this.zzn : -1L;
                                }
                            }
                            try {
                                this.zzk = this.zzj.getInputStream();
                                this.zzl = true;
                                zzj(zzhbVar);
                                return this.zzo;
                            } catch (IOException e11) {
                                zzn();
                                throw new zzhp(e11, zzhbVar, 2000, 1);
                            }
                        } catch (IOException e12) {
                            zzn();
                            throw new zzhp("Unable to connect to ".concat(String.valueOf(zzhbVar.zza.toString())), e12, zzhbVar, 2000, 1);
                        }
                    }
                    headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    httpURLConnection.disconnect();
                    if (headerField != null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    URL url2 = new URL(url, headerField);
                    protocol = url2.getProtocol();
                    if (!"https".equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                        throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                    }
                    url = url2;
                    i11 = i12;
                    j12 = 0;
                } else {
                    j12 = j13;
                }
                String string = "bytes=" + j12 + "-";
                if (j14 != -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append((j12 + j14) - 1);
                    string = sb2.toString();
                }
                httpURLConnection.setRequestProperty("Range", string);
                httpURLConnection.setRequestProperty("User-Agent", this.zzg);
                if (!zZza) {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 300) {
                }
                headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                httpURLConnection.disconnect();
                if (headerField != null) {
                    throw new ProtocolException("Null location redirect");
                }
                URL url3 = new URL(url, headerField);
                protocol = url3.getProtocol();
                if (!"https".equals(protocol)) {
                    throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                }
                url = url3;
                i11 = i12;
                j12 = 0;
            }
        } catch (IOException e13) {
            throw new zzhp("Unable to connect to ".concat(String.valueOf(zzhbVar.zza.toString())), e13, zzhbVar, 2000, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws zzhp {
        try {
            InputStream inputStream = this.zzk;
            if (inputStream != null) {
                int i11 = zzfy.zza;
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new zzhp(e11, this.zzi, 2000, 3);
                }
            }
            this.zzk = null;
            zzn();
            if (this.zzl) {
                this.zzl = false;
                zzh();
            }
            this.zzs.clear();
        } catch (Throwable th2) {
            this.zzk = null;
            zzn();
            if (this.zzl) {
                this.zzl = false;
                zzh();
            }
            this.zzs.clear();
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final void zzm(int i11) {
        this.zzr = i11;
        for (Socket socket : this.zzs) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzr);
                } catch (SocketException e11) {
                    zzcec.zzk("Failed to update receive buffer size.", e11);
                }
            }
        }
    }
}
