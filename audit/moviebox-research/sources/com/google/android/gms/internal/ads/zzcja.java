package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcja extends zzgq implements zzht {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhs zzf;
    private zzhb zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    public zzcja(String str, zzhy zzhyVar, int i11, int i12, long j11, long j12) {
        super(true);
        zzek.zzc(str);
        this.zze = str;
        this.zzf = new zzhs();
        this.zzc = i11;
        this.zzd = i12;
        this.zzi = new ArrayDeque();
        this.zzr = j11;
        this.zzs = j12;
        if (zzhyVar != null) {
            zzf(zzhyVar);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e11) {
                zzcec.zzh("Unexpected error while disconnecting", e11);
            }
        }
        this.zzh = null;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws zzhp {
        if (i12 == 0) {
            return 0;
        }
        try {
            long j11 = this.zzm;
            long j12 = this.zzn;
            if (j11 - j12 == 0) {
                return -1;
            }
            long j13 = this.zzo + j12;
            long j14 = i12;
            long j15 = this.zzs;
            long j16 = j13 + j14 + j15;
            long j17 = this.zzq;
            long j18 = j17 + 1;
            if (j16 > j18) {
                long j19 = this.zzp;
                if (j17 < j19) {
                    long jMin = Math.min(j19, Math.max(((this.zzr + j18) - j15) - 1, (-1) + j18 + j14));
                    zzk(j18, jMin, 2);
                    this.zzq = jMin;
                    j17 = jMin;
                }
            }
            int i13 = this.zzj.read(bArr, i11, (int) Math.min(j14, ((j17 + 1) - this.zzo) - this.zzn));
            if (i13 == -1) {
                throw new EOFException();
            }
            this.zzn += (long) i13;
            zzg(i13);
            return i13;
        } catch (IOException e11) {
            throw new zzhp(e11, this.zzg, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhp {
        this.zzg = zzhbVar;
        this.zzn = 0L;
        long j11 = zzhbVar.zzf;
        long j12 = zzhbVar.zzg;
        long jMin = j12 == -1 ? this.zzr : Math.min(this.zzr, j12);
        this.zzo = j11;
        HttpURLConnection httpURLConnectionZzk = zzk(j11, (jMin + j11) - 1, 1);
        this.zzh = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j13 = Long.parseLong(matcher.group(2));
                    long j14 = Long.parseLong(matcher.group(3));
                    long j15 = zzhbVar.zzg;
                    if (j15 != -1) {
                        this.zzm = j15;
                        this.zzp = Math.max(j13, (this.zzo + j15) - 1);
                    } else {
                        this.zzm = j14 - this.zzo;
                        this.zzp = j14 - 1;
                    }
                    this.zzq = j13;
                    this.zzk = true;
                    zzj(zzhbVar);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zzcec.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzciy(headerField, zzhbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws zzhp {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new zzhp(e11, this.zzg, 2000, 3);
                }
            }
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (Throwable th2) {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final HttpURLConnection zzk(long j11, long j12, int i11) throws zzhp {
        String string = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + j11 + "-" + j12);
            httpURLConnection.setRequestProperty("User-Agent", this.zze);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String string2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzciz(this.zzl, headerFields, this.zzg, i11);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e11) {
                    zzl();
                    throw new zzhp(e11, this.zzg, 2000, i11);
                }
            } catch (IOException e12) {
                zzl();
                throw new zzhp("Unable to connect to ".concat(String.valueOf(string2)), e12, this.zzg, 2000, i11);
            }
        } catch (IOException e13) {
            throw new zzhp("Unable to connect to ".concat(String.valueOf(string)), e13, this.zzg, 2000, i11);
        }
    }
}
