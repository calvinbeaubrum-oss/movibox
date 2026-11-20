package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzjw {
    private static final zzjw zzb = new zzjw(true);
    final zzmk zza = new zzma(16);
    private boolean zzc;
    private boolean zzd;

    private zzjw() {
    }

    private zzjw(boolean z11) {
        zzb();
        zzb();
    }

    public static zzjw zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzd(zzjv zzjvVar, Object obj) {
        boolean z11;
        zzjvVar.zzb();
        zzkn.zze(obj);
        zzne zzneVar = zzne.zza;
        zznf zznfVar = zznf.INT;
        switch (r0.zza()) {
            case INT:
                z11 = obj instanceof Integer;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z11 = obj instanceof Long;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z11 = obj instanceof Float;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z11 = obj instanceof Double;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z11 = obj instanceof Boolean;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z11 = obj instanceof String;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzje) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzkh)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzlm) || (obj instanceof zzkr)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzjvVar.zza()), zzjvVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjw zzjwVar = new zzjw();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry entryZzg = this.zza.zzg(i11);
            zzjwVar.zzc((zzjv) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjwVar.zzc((zzjv) entry.getKey(), entry.getValue());
        }
        zzjwVar.zzd = this.zzd;
        return zzjwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjw) {
            return this.zza.equals(((zzjw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry entryZzg = this.zza.zzg(i11);
            if (entryZzg.getValue() instanceof zzkf) {
                ((zzkf) entryZzg.getValue()).zzbJ();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzjv zzjvVar, Object obj) {
        if (!zzjvVar.zzc()) {
            zzd(zzjvVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(zzjvVar, arrayList.get(i11));
            }
            obj = arrayList;
        }
        if (obj instanceof zzkr) {
            this.zzd = true;
        }
        this.zza.put(zzjvVar, obj);
    }
}
