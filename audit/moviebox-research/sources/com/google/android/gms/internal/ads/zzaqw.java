package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqw implements zzapk {
    private final zzaqv zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqw(zzaqv zzaqvVar, int i11) {
        this.zzc = zzaqvVar;
    }

    public zzaqw(File file, int i11) {
        this.zzc = new zzaqs(this, file);
    }

    public static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    public static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    public static String zzh(zzaqu zzaquVar) throws IOException {
        return new String(zzm(zzaquVar, zzf(zzaquVar)), "UTF-8");
    }

    public static void zzj(OutputStream outputStream, int i11) throws IOException {
        outputStream.write(i11 & 255);
        outputStream.write((i11 >> 8) & 255);
        outputStream.write((i11 >> 16) & 255);
        outputStream.write((i11 >> 24) & 255);
    }

    public static void zzk(OutputStream outputStream, long j11) throws IOException {
        outputStream.write((byte) j11);
        outputStream.write((byte) (j11 >>> 8));
        outputStream.write((byte) (j11 >>> 16));
        outputStream.write((byte) (j11 >>> 24));
        outputStream.write((byte) (j11 >>> 32));
        outputStream.write((byte) (j11 >>> 40));
        outputStream.write((byte) (j11 >>> 48));
        outputStream.write((byte) (j11 >>> 56));
    }

    public static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    public static byte[] zzm(zzaqu zzaquVar, long j11) throws IOException {
        long jZza = zzaquVar.zza();
        if (j11 >= 0 && j11 <= jZza) {
            int i11 = (int) j11;
            if (i11 == j11) {
                byte[] bArr = new byte[i11];
                new DataInputStream(zzaquVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j11 + ", maxLength=" + jZza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int i11 = inputStream.read();
        if (i11 != -1) {
            return i11;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzaqt zzaqtVar) {
        if (this.zza.containsKey(str)) {
            this.zzb += zzaqtVar.zza - ((zzaqt) this.zza.get(str)).zza;
        } else {
            this.zzb += zzaqtVar.zza;
        }
        this.zza.put(str, zzaqtVar);
    }

    private final void zzp(String str) {
        zzaqt zzaqtVar = (zzaqt) this.zza.remove(str);
        if (zzaqtVar != null) {
            this.zzb -= zzaqtVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized zzapj zza(String str) {
        zzaqt zzaqtVar = (zzaqt) this.zza.get(str);
        if (zzaqtVar == null) {
            return null;
        }
        File fileZzg = zzg(str);
        try {
            zzaqu zzaquVar = new zzaqu(new BufferedInputStream(new FileInputStream(fileZzg)), fileZzg.length());
            try {
                zzaqt zzaqtVarZza = zzaqt.zza(zzaquVar);
                if (!TextUtils.equals(str, zzaqtVarZza.zzb)) {
                    zzaqm.zza("%s: key=%s, found=%s", fileZzg.getAbsolutePath(), str, zzaqtVarZza.zzb);
                    zzp(str);
                    zzaquVar.close();
                    return null;
                }
                byte[] bArrZzm = zzm(zzaquVar, zzaquVar.zza());
                zzapj zzapjVar = new zzapj();
                zzapjVar.zza = bArrZzm;
                zzapjVar.zzb = zzaqtVar.zzc;
                zzapjVar.zzc = zzaqtVar.zzd;
                zzapjVar.zzd = zzaqtVar.zze;
                zzapjVar.zze = zzaqtVar.zzf;
                zzapjVar.zzf = zzaqtVar.zzg;
                List<zzaps> list = zzaqtVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzaps zzapsVar : list) {
                    treeMap.put(zzapsVar.zza(), zzapsVar.zzb());
                }
                zzapjVar.zzg = treeMap;
                zzapjVar.zzh = Collections.unmodifiableList(zzaqtVar.zzh);
                zzaquVar.close();
                return zzapjVar;
            } catch (Throwable th2) {
                zzaquVar.close();
                throw th2;
            }
        } catch (IOException e11) {
            zzaqm.zza("%s: %s", fileZzg.getAbsolutePath(), e11.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized void zzb() {
        try {
            File fileZza = this.zzc.zza();
            if (fileZza.exists()) {
                File[] fileArrListFiles = fileZza.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        try {
                            long length = file.length();
                            zzaqu zzaquVar = new zzaqu(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                zzaqt zzaqtVarZza = zzaqt.zza(zzaquVar);
                                zzaqtVarZza.zza = length;
                                zzo(zzaqtVarZza.zzb, zzaqtVarZza);
                                zzaquVar.close();
                            } catch (Throwable th2) {
                                zzaquVar.close();
                                throw th2;
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!fileZza.mkdirs()) {
                zzaqm.zzb("Unable to create cache dir %s", fileZza.getAbsolutePath());
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized void zzc(String str, boolean z11) {
        zzapj zzapjVarZza = zza(str);
        if (zzapjVarZza != null) {
            zzapjVarZza.zzf = 0L;
            zzapjVarZza.zze = 0L;
            zzd(str, zzapjVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final synchronized void zzd(String str, zzapj zzapjVar) {
        try {
            long j11 = this.zzb;
            int length = zzapjVar.zza.length;
            long j12 = j11 + ((long) length);
            int i11 = this.zzd;
            if (j12 <= i11 || length <= i11 * 0.9f) {
                File fileZzg = zzg(str);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzg));
                    zzaqt zzaqtVar = new zzaqt(str, zzapjVar);
                    try {
                        zzj(bufferedOutputStream, 538247942);
                        zzl(bufferedOutputStream, zzaqtVar.zzb);
                        String str2 = zzaqtVar.zzc;
                        if (str2 == null) {
                            str2 = "";
                        }
                        zzl(bufferedOutputStream, str2);
                        zzk(bufferedOutputStream, zzaqtVar.zzd);
                        zzk(bufferedOutputStream, zzaqtVar.zze);
                        zzk(bufferedOutputStream, zzaqtVar.zzf);
                        zzk(bufferedOutputStream, zzaqtVar.zzg);
                        List<zzaps> list = zzaqtVar.zzh;
                        if (list != null) {
                            zzj(bufferedOutputStream, list.size());
                            for (zzaps zzapsVar : list) {
                                zzl(bufferedOutputStream, zzapsVar.zza());
                                zzl(bufferedOutputStream, zzapsVar.zzb());
                            }
                        } else {
                            zzj(bufferedOutputStream, 0);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.write(zzapjVar.zza);
                        bufferedOutputStream.close();
                        zzaqtVar.zza = fileZzg.length();
                        zzo(str, zzaqtVar);
                        if (this.zzb >= this.zzd) {
                            if (zzaqm.zzb) {
                                zzaqm.zzd("Pruning old cache entries.", new Object[0]);
                            }
                            long j13 = this.zzb;
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            Iterator it = this.zza.entrySet().iterator();
                            int i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    jElapsedRealtime = jElapsedRealtime;
                                    break;
                                }
                                zzaqt zzaqtVar2 = (zzaqt) ((Map.Entry) it.next()).getValue();
                                if (zzg(zzaqtVar2.zzb).delete()) {
                                    this.zzb -= zzaqtVar2.zza;
                                } else {
                                    String str3 = zzaqtVar2.zzb;
                                    zzaqm.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                                }
                                it.remove();
                                i12++;
                                if (this.zzb < this.zzd * 0.9f) {
                                    break;
                                } else {
                                    jElapsedRealtime = jElapsedRealtime;
                                }
                            }
                            if (zzaqm.zzb) {
                                zzaqm.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i12), Long.valueOf(this.zzb - j13), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                            }
                        }
                    } catch (IOException e11) {
                        zzaqm.zza("%s", e11.toString());
                        bufferedOutputStream.close();
                        zzaqm.zza("Failed to write header for %s", fileZzg.getAbsolutePath());
                        throw new IOException();
                    }
                } catch (IOException unused) {
                    if (!fileZzg.delete()) {
                        zzaqm.zza("Could not clean up file %s", fileZzg.getAbsolutePath());
                    }
                    if (!this.zzc.zza().exists()) {
                        zzaqm.zza("Re-initializing cache after external clearing.", new Object[0]);
                        this.zza.clear();
                        this.zzb = 0L;
                        zzb();
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean zDelete = zzg(str).delete();
        zzp(str);
        if (zDelete) {
            return;
        }
        zzaqm.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }
}
