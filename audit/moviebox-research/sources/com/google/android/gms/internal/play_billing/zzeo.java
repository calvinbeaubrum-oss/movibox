package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeo {
    private static final zzeo zzb = new zzeo(true);
    final zzgz zza = new zzgp(16);
    private boolean zzc;
    private boolean zzd;

    private zzeo() {
    }

    private zzeo(boolean z11) {
        zzb();
        zzb();
    }

    public static zzeo zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzd(zzen zzenVar, Object obj) {
        boolean z11;
        zzenVar.zzb();
        byte[] bArr = zzfd.zzd;
        obj.getClass();
        zzht zzhtVar = zzht.zza;
        zzhu zzhuVar = zzhu.INT;
        switch (r0.zza()) {
            case INT:
                z11 = obj instanceof Integer;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z11 = obj instanceof Long;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z11 = obj instanceof Float;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z11 = obj instanceof Double;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z11 = obj instanceof Boolean;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z11 = obj instanceof String;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzdw) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzez)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzgc) || (obj instanceof zzfh)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzenVar.zza()), zzenVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeo zzeoVar = new zzeo();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry entryZzg = this.zza.zzg(i11);
            zzeoVar.zzc((zzen) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzeoVar.zzc((zzen) entry.getKey(), entry.getValue());
        }
        zzeoVar.zzd = this.zzd;
        return zzeoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeo) {
            return this.zza.equals(((zzeo) obj).zza);
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
            if (entryZzg.getValue() instanceof zzex) {
                ((zzex) entryZzg.getValue()).zzn();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzen zzenVar, Object obj) {
        if (!zzenVar.zzc()) {
            zzd(zzenVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(zzenVar, arrayList.get(i11));
            }
            obj = arrayList;
        }
        if (obj instanceof zzfh) {
            this.zzd = true;
        }
        this.zza.put(zzenVar, obj);
    }
}
