package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlz {
    private static final Class zza;
    private static final zzmo zzb;
    private static final zzmo zzc;
    private static final zzmo zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzmq();
    }

    public static zzmo zzA() {
        return zzc;
    }

    public static zzmo zzB() {
        return zzd;
    }

    public static Object zzC(Object obj, int i11, List list, zzkj zzkjVar, Object obj2, zzmo zzmoVar) {
        Object objZzD = null;
        if (zzkjVar == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int iIntValue = ((Integer) list.get(i13)).intValue();
                if (zzkjVar.zza(iIntValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(iIntValue));
                    }
                    i12++;
                } else {
                    objZzD = zzD(obj, i11, iIntValue, objZzD, zzmoVar);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return objZzD;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzkjVar.zza(iIntValue2)) {
                    objZzD = zzD(obj, i11, iIntValue2, objZzD, zzmoVar);
                    it.remove();
                }
            }
        }
        return objZzD;
    }

    public static Object zzD(Object obj, int i11, int i12, Object obj2, zzmo zzmoVar) {
        if (obj2 == null) {
            obj2 = zzmoVar.zzc(obj);
        }
        zzmoVar.zzf(obj2, i11, i12);
        return obj2;
    }

    public static void zzE(zzjs zzjsVar, Object obj, Object obj2) {
        zzjsVar.zza(obj2);
        throw null;
    }

    public static void zzF(zzmo zzmoVar, Object obj, Object obj2) {
        zzmoVar.zzh(obj, zzmoVar.zze(zzmoVar.zzd(obj), zzmoVar.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzkf.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzc(i11, list, z11);
    }

    public static void zzI(int i11, List list, zzng zzngVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zze(i11, list);
    }

    public static void zzJ(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzg(i11, list, z11);
    }

    public static void zzK(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzj(i11, list, z11);
    }

    public static void zzL(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzl(i11, list, z11);
    }

    public static void zzM(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzn(i11, list, z11);
    }

    public static void zzN(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzp(i11, list, z11);
    }

    public static void zzO(int i11, List list, zzng zzngVar, zzlx zzlxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((zzjn) zzngVar).zzq(i11, list.get(i12), zzlxVar);
        }
    }

    public static void zzP(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzs(i11, list, z11);
    }

    public static void zzQ(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzu(i11, list, z11);
    }

    public static void zzR(int i11, List list, zzng zzngVar, zzlx zzlxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((zzjn) zzngVar).zzv(i11, list.get(i12), zzlxVar);
        }
    }

    public static void zzS(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzx(i11, list, z11);
    }

    public static void zzT(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzz(i11, list, z11);
    }

    public static void zzU(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzB(i11, list, z11);
    }

    public static void zzV(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzD(i11, list, z11);
    }

    public static void zzW(int i11, List list, zzng zzngVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzG(i11, list);
    }

    public static void zzX(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzI(i11, list, z11);
    }

    public static void zzY(int i11, List list, zzng zzngVar, boolean z11) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzngVar.zzK(i11, list, z11);
    }

    public static boolean zzZ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i11 << 3) + 1);
    }

    public static void zzaa(zzlh zzlhVar, Object obj, Object obj2, long j11) {
        zzmy.zzs(obj, j11, zzlh.zzb(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11)));
    }

    private static zzmo zzab(boolean z11) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzmo) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z11));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List list) {
        return list.size();
    }

    public static int zzc(int i11, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzz = size * zzjm.zzz(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzz += zzjm.zzt((zzje) list.get(i12));
        }
        return iZzz;
    }

    public static int zzd(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjm.zzz(i11));
    }

    public static int zze(List list) {
        int iZzv;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            iZzv = 0;
            while (i11 < size) {
                iZzv += zzjm.zzv(zzkgVar.zze(i11));
                i11++;
            }
        } else {
            iZzv = 0;
            while (i11 < size) {
                iZzv += zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return iZzv;
    }

    public static int zzf(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i11 << 3) + 4);
    }

    public static int zzg(List list) {
        return list.size() * 4;
    }

    public static int zzh(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i11 << 3) + 8);
    }

    public static int zzi(List list) {
        return list.size() * 8;
    }

    public static int zzj(int i11, List list, zzlx zzlxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzu = 0;
        for (int i12 = 0; i12 < size; i12++) {
            iZzu += zzjm.zzu(i11, (zzlm) list.get(i12), zzlxVar);
        }
        return iZzu;
    }

    public static int zzk(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjm.zzz(i11));
    }

    public static int zzl(List list) {
        int iZzv;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            iZzv = 0;
            while (i11 < size) {
                iZzv += zzjm.zzv(zzkgVar.zze(i11));
                i11++;
            }
        } else {
            iZzv = 0;
            while (i11 < size) {
                iZzv += zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return iZzv;
    }

    public static int zzm(int i11, List list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjm.zzz(i11));
    }

    public static int zzn(List list) {
        int iZzB;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            iZzB = 0;
            while (i11 < size) {
                iZzB += zzjm.zzB(zzlbVar.zza(i11));
                i11++;
            }
        } else {
            iZzB = 0;
            while (i11 < size) {
                iZzB += zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return iZzB;
    }

    public static int zzo(int i11, Object obj, zzlx zzlxVar) {
        if (!(obj instanceof zzks)) {
            return zzjm.zzA(i11 << 3) + zzjm.zzx((zzlm) obj, zzlxVar);
        }
        int iZzA = zzjm.zzA(i11 << 3);
        int iZza = ((zzks) obj).zza();
        return iZzA + zzjm.zzA(iZza) + iZza;
    }

    public static int zzp(int i11, List list, zzlx zzlxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzz = zzjm.zzz(i11) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            iZzz += obj instanceof zzks ? zzjm.zzw((zzks) obj) : zzjm.zzx((zzlm) obj, zzlxVar);
        }
        return iZzz;
    }

    public static int zzq(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjm.zzz(i11));
    }

    public static int zzr(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            iZzA = 0;
            while (i11 < size) {
                int iZze = zzkgVar.zze(i11);
                iZzA += zzjm.zzA((iZze >> 31) ^ (iZze + iZze));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                int iIntValue = ((Integer) list.get(i11)).intValue();
                iZzA += zzjm.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i11++;
            }
        }
        return iZzA;
    }

    public static int zzs(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjm.zzz(i11));
    }

    public static int zzt(List list) {
        int iZzB;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            iZzB = 0;
            while (i11 < size) {
                long jZza = zzlbVar.zza(i11);
                iZzB += zzjm.zzB((jZza >> 63) ^ (jZza + jZza));
                i11++;
            }
        } else {
            iZzB = 0;
            while (i11 < size) {
                long jLongValue = ((Long) list.get(i11)).longValue();
                iZzB += zzjm.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i11++;
            }
        }
        return iZzB;
    }

    public static int zzu(int i11, List list) {
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzz = zzjm.zzz(i11) * size;
        if (list instanceof zzku) {
            zzku zzkuVar = (zzku) list;
            while (i12 < size) {
                Object objZzf = zzkuVar.zzf(i12);
                iZzz += objZzf instanceof zzje ? zzjm.zzt((zzje) objZzf) : zzjm.zzy((String) objZzf);
                i12++;
            }
        } else {
            while (i12 < size) {
                Object obj = list.get(i12);
                iZzz += obj instanceof zzje ? zzjm.zzt((zzje) obj) : zzjm.zzy((String) obj);
                i12++;
            }
        }
        return iZzz;
    }

    public static int zzv(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjm.zzz(i11));
    }

    public static int zzw(List list) {
        int iZzA;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkgVar = (zzkg) list;
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzjm.zzA(zzkgVar.zze(i11));
                i11++;
            }
        } else {
            iZzA = 0;
            while (i11 < size) {
                iZzA += zzjm.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return iZzA;
    }

    public static int zzx(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjm.zzz(i11));
    }

    public static int zzy(List list) {
        int iZzB;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            iZzB = 0;
            while (i11 < size) {
                iZzB += zzjm.zzB(zzlbVar.zza(i11));
                i11++;
            }
        } else {
            iZzB = 0;
            while (i11 < size) {
                iZzB += zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return iZzB;
    }

    public static zzmo zzz() {
        return zzb;
    }
}
