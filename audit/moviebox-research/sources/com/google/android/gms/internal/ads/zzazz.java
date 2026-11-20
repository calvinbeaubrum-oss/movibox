package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazz {
    public static long zza(long j11, int i11) {
        if (i11 == 1) {
            return j11;
        }
        int i12 = i11 >> 1;
        long j12 = (j11 * j11) % 1073807359;
        return ((i11 & 1) == 0 ? zza(j12, i12) : j11 * (zza(j12, i12) % 1073807359)) % 1073807359;
    }

    public static String zzb(String[] strArr, int i11, int i12) {
        int i13 = i12 + i11;
        if (strArr.length < i13) {
            zzcec.zzg("Unable to construct shingle");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i14 = i13 - 1;
            if (i11 >= i14) {
                sb2.append(strArr[i14]);
                return sb2.toString();
            }
            sb2.append(strArr[i11]);
            sb2.append(' ');
            i11++;
        }
    }

    public static void zzc(String[] strArr, int i11, int i12, PriorityQueue priorityQueue) {
        int length = strArr.length;
        if (length < 6) {
            zzd(i11, zze(strArr, 0, length), zzb(strArr, 0, length), length, priorityQueue);
            return;
        }
        long jZze = zze(strArr, 0, 6);
        zzd(i11, jZze, zzb(strArr, 0, 6), 6, priorityQueue);
        int i13 = 1;
        while (true) {
            int length2 = strArr.length;
            if (i13 >= length2 - 5) {
                return;
            }
            long jZza = zzazv.zza(strArr[i13 - 1]);
            long jZza2 = zzazv.zza(strArr[i13 + 5]);
            String strZzb = zzb(strArr, i13, 6);
            jZze = ((((((jZze + 1073807359) - ((zza(16785407L, 5) * ((jZza + 2147483647L) % 1073807359)) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((jZza2 + 2147483647L) % 1073807359)) % 1073807359;
            zzd(i11, jZze, strZzb, length2, priorityQueue);
            i13++;
        }
    }

    public static void zzd(int i11, long j11, String str, int i12, PriorityQueue priorityQueue) {
        zzazy zzazyVar = new zzazy(j11, str, i12);
        if ((priorityQueue.size() != i11 || (((zzazy) priorityQueue.peek()).zzc <= zzazyVar.zzc && ((zzazy) priorityQueue.peek()).zza <= zzazyVar.zza)) && !priorityQueue.contains(zzazyVar)) {
            priorityQueue.add(zzazyVar);
            if (priorityQueue.size() > i11) {
                priorityQueue.poll();
            }
        }
    }

    private static long zze(String[] strArr, int i11, int i12) {
        long jZza = (((long) zzazv.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i13 = 1; i13 < i12; i13++) {
            jZza = (((jZza * 16785407) % 1073807359) + ((((long) zzazv.zza(strArr[i13])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return jZza;
    }
}
