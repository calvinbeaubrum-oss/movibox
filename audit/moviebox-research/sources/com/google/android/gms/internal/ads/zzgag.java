package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgag {
    public static Object zza(Iterable iterable, Object obj) {
        zzgbt zzgbtVar = new zzgbt((zzgbu) iterable);
        return zzgbtVar.hasNext() ? zzgbtVar.next() : obj;
    }

    public static boolean zzb(Iterable iterable, zzfxf zzfxfVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzfxfVar.getClass();
            return zzd((List) iterable, zzfxfVar);
        }
        Iterator it = iterable.iterator();
        zzfxfVar.getClass();
        boolean z11 = false;
        while (it.hasNext()) {
            if (zzfxfVar.zza(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    private static void zzc(List list, zzfxf zzfxfVar, int i11, int i12) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i12) {
                break;
            } else if (zzfxfVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i12--;
            if (i12 < i11) {
                return;
            } else {
                list.remove(i12);
            }
        }
    }

    private static boolean zzd(List list, zzfxf zzfxfVar) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < list.size()) {
            Object obj = list.get(i11);
            if (!zzfxfVar.zza(obj)) {
                if (i11 > i12) {
                    try {
                        list.set(i12, obj);
                    } catch (IllegalArgumentException unused) {
                        zzc(list, zzfxfVar, i12, i11);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzc(list, zzfxfVar, i12, i11);
                        return true;
                    }
                }
                i12++;
            }
            i11++;
        }
        list.subList(i12, list.size()).clear();
        return i11 != i12;
    }
}
