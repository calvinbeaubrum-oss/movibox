package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhca {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhcp zzc;
    private static final zzhcp zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhcp zzhcpVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhcpVar = (zzhcp) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhcpVar;
        zzd = new zzhcr();
    }

    public static void zzA(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzu(i11, list, z11);
    }

    public static void zzB(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzx(i11, list, z11);
    }

    public static void zzC(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzz(i11, list, z11);
    }

    public static void zzD(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzB(i11, list, z11);
    }

    public static void zzE(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzD(i11, list, z11);
    }

    public static void zzF(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzI(i11, list, z11);
    }

    public static void zzG(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzK(i11, list, z11);
    }

    public static int zza(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(zzgzvVar.zze(i11));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return iZzA;
    }

    public static int zzb(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgza.zzz(i11 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgza.zzz(i11 << 3) + 8);
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(zzgzvVar.zze(i11));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return iZzA;
    }

    public static int zzg(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(zzhatVar.zze(i11));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return iZzA;
    }

    public static int zzh(int i11, Object obj, zzhby zzhbyVar) {
        int i12 = i11 << 3;
        if (!(obj instanceof zzhak)) {
            return zzgza.zzz(i12) + zzgza.zzx((zzhbe) obj, zzhbyVar);
        }
        int iZzz = zzgza.zzz(i12);
        int iZza = ((zzhak) obj).zza();
        return iZzz + zzgza.zzz(iZza) + iZza;
    }

    public static int zzi(List list) {
        int iZzz;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            iZzz = 0;
            while (i11 < size) {
                int iZze = zzgzvVar.zze(i11);
                iZzz += zzgza.zzz((iZze >> 31) ^ (iZze + iZze));
                i11++;
            }
        } else {
            iZzz = 0;
            while (i11 < size) {
                int iIntValue = ((Integer) list.get(i11)).intValue();
                iZzz += zzgza.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i11++;
            }
        }
        return iZzz;
    }

    public static int zzj(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            iZzA = 0;
            while (i11 < size) {
                long jZze = zzhatVar.zze(i11);
                iZzA += zzgza.zzA((jZze >> 63) ^ (jZze + jZze));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                long jLongValue = ((Long) list.get(i11)).longValue();
                iZzA += zzgza.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i11++;
            }
        }
        return iZzA;
    }

    public static int zzk(List list) {
        int iZzz;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            iZzz = 0;
            while (i11 < size) {
                iZzz += zzgza.zzz(zzgzvVar.zze(i11));
                i11++;
            }
        } else {
            iZzz = 0;
            while (i11 < size) {
                iZzz += zzgza.zzz(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return iZzz;
    }

    public static int zzl(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(zzhatVar.zze(i11));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzgza.zzA(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return iZzA;
    }

    public static zzhcp zzm() {
        return zzc;
    }

    public static zzhcp zzn() {
        return zzd;
    }

    public static Object zzo(Object obj, int i11, List list, zzgzy zzgzyVar, Object obj2, zzhcp zzhcpVar) {
        if (zzgzyVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int iIntValue = ((Integer) list.get(i13)).intValue();
                if (zzgzyVar.zza(iIntValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(iIntValue));
                    }
                    i12++;
                } else {
                    obj2 = zzp(obj, i11, iIntValue, obj2, zzhcpVar);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzgzyVar.zza(iIntValue2)) {
                    obj2 = zzp(obj, i11, iIntValue2, obj2, zzhcpVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static Object zzp(Object obj, int i11, int i12, Object obj2, zzhcp zzhcpVar) {
        if (obj2 == null) {
            obj2 = zzhcpVar.zzc(obj);
        }
        zzhcpVar.zzl(obj2, i11, i12);
        return obj2;
    }

    public static void zzq(zzhcp zzhcpVar, Object obj, Object obj2) {
        zzhcpVar.zzo(obj, zzhcpVar.zze(zzhcpVar.zzd(obj), zzhcpVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzgzu.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzs(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzt(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzc(i11, list, z11);
    }

    public static void zzu(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzg(i11, list, z11);
    }

    public static void zzv(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzj(i11, list, z11);
    }

    public static void zzw(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzl(i11, list, z11);
    }

    public static void zzx(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzn(i11, list, z11);
    }

    public static void zzy(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzp(i11, list, z11);
    }

    public static void zzz(int i11, List list, zzgzb zzgzbVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgzbVar.zzs(i11, list, z11);
    }
}
