package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfsn {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfru zze;
    private boolean zzf;

    public zzfsn(@NonNull Context context, @NonNull int i11, @NonNull zzfru zzfruVar, boolean z11) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i11 - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfruVar;
        this.zzf = z11;
    }

    private final File zze(@NonNull String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(@NonNull zzayc zzaycVar) {
        zzaye zzayeVarZze = zzayf.zze();
        zzayeVarZze.zze(zzaycVar.zzd().zzk());
        zzayeVarZze.zza(zzaycVar.zzd().zzj());
        zzayeVarZze.zzb(zzaycVar.zzd().zza());
        zzayeVarZze.zzd(zzaycVar.zzd().zzd());
        zzayeVarZze.zzc(zzaycVar.zzd().zzc());
        return Hex.bytesToStringLowercase(((zzayf) zzayeVarZze.zzal()).zzax());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i11, long j11) {
        this.zze.zza(i11, j11);
    }

    private final void zzj(int i11, long j11, String str) {
        this.zze.zzb(i11, j11, str);
    }

    @Nullable
    private final zzayf zzk(int i11) {
        String string = i11 == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgyl zzgylVar = zzgyl.zzb;
            return zzayf.zzi(zzgyl.zzv(bArrStringToBytes, 0, bArrStringToBytes.length), this.zzf ? zzgzf.zza() : zzgzf.zzb());
        } catch (zzhag unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(@NonNull zzayc zzaycVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                if (!zzfsh.zze(new File(zze(zzaycVar.zzd().zzk()), "pcbc"), zzaycVar.zze().zzA())) {
                    zzi(4020, jCurrentTimeMillis);
                    return false;
                }
                String strZzf = zzf(zzaycVar);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                boolean zCommit = editorEdit.commit();
                if (zCommit) {
                    zzi(5015, jCurrentTimeMillis);
                } else {
                    zzi(4021, jCurrentTimeMillis);
                }
                return zCommit;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zzb(@NonNull zzayc zzaycVar, @Nullable zzfsm zzfsmVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzayf zzayfVarZzk = zzk(1);
                String strZzk = zzaycVar.zzd().zzk();
                if (zzayfVarZzk != null && zzayfVarZzk.zzk().equals(strZzk)) {
                    zzi(TaErrorCode.CODE_INIT_ERROR, jCurrentTimeMillis);
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File fileZze = zze(strZzk);
                if (fileZze.exists()) {
                    zzj(4023, jCurrentTimeMillis2, "d:" + (true != fileZze.isDirectory() ? "0" : "1") + ",f:" + (true != fileZze.isFile() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                } else if (!fileZze.mkdirs()) {
                    zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                    return false;
                }
                File fileZze2 = zze(strZzk);
                File file = new File(fileZze2, "pcam.jar");
                File file2 = new File(fileZze2, "pcbc");
                if (!zzfsh.zze(file, zzaycVar.zzf().zzA())) {
                    zzi(4016, jCurrentTimeMillis);
                    return false;
                }
                if (!zzfsh.zze(file2, zzaycVar.zze().zzA())) {
                    zzi(4017, jCurrentTimeMillis);
                    return false;
                }
                if (zzfsmVar != null && !zzfsmVar.zza(file)) {
                    zzi(4018, jCurrentTimeMillis);
                    zzfsh.zzd(fileZze2);
                    return false;
                }
                String strZzf = zzf(zzaycVar);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                String string = this.zzc.getString(zzh(), null);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                if (string != null) {
                    editorEdit.putString(zzg(), string);
                }
                if (!editorEdit.commit()) {
                    zzi(4019, jCurrentTimeMillis3);
                    return false;
                }
                HashSet hashSet = new HashSet();
                zzayf zzayfVarZzk2 = zzk(1);
                if (zzayfVarZzk2 != null) {
                    hashSet.add(zzayfVarZzk2.zzk());
                }
                zzayf zzayfVarZzk3 = zzk(2);
                if (zzayfVarZzk3 != null) {
                    hashSet.add(zzayfVarZzk3.zzk());
                }
                for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                    if (!hashSet.contains(file3.getName())) {
                        zzfsh.zzd(file3);
                    }
                }
                zzi(5014, jCurrentTimeMillis);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public final zzfsf zzc(int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzayf zzayfVarZzk = zzk(1);
                if (zzayfVarZzk == null) {
                    zzi(4022, jCurrentTimeMillis);
                    return null;
                }
                File fileZze = zze(zzayfVarZzk.zzk());
                File file = new File(fileZze, "pcam.jar");
                if (!file.exists()) {
                    file = new File(fileZze, "pcam");
                }
                File file2 = new File(fileZze, "pcbc");
                File file3 = new File(fileZze, "pcopt");
                zzi(5016, jCurrentTimeMillis);
                return new zzfsf(zzayfVarZzk, file, file2, file3);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zzd(int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzayf zzayfVarZzk = zzk(1);
                if (zzayfVarZzk == null) {
                    zzi(4025, jCurrentTimeMillis);
                    return false;
                }
                File fileZze = zze(zzayfVarZzk.zzk());
                if (!new File(fileZze, "pcam.jar").exists()) {
                    zzi(4026, jCurrentTimeMillis);
                    return false;
                }
                if (new File(fileZze, "pcbc").exists()) {
                    zzi(5019, jCurrentTimeMillis);
                    return true;
                }
                zzi(4027, jCurrentTimeMillis);
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
