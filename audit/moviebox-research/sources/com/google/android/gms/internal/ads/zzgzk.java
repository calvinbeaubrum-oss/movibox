package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzk {
    private static final zzgzk zzb = new zzgzk(true);
    final zzhcl zza = new zzhcb(16);
    private boolean zzc;
    private boolean zzd;

    private zzgzk() {
    }

    private zzgzk(boolean z11) {
        zzb();
        zzb();
    }

    public static zzgzk zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzd(zzgzj zzgzjVar, Object obj) {
        boolean z11;
        zzhdf zzhdfVarZzb = zzgzjVar.zzb();
        byte[] bArr = zzhae.zzd;
        obj.getClass();
        zzhdf zzhdfVar = zzhdf.zza;
        zzhdg zzhdgVar = zzhdg.INT;
        switch (zzhdfVarZzb.zza().ordinal()) {
            case 0:
                z11 = obj instanceof Integer;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z11 = obj instanceof Long;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z11 = obj instanceof Float;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z11 = obj instanceof Double;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z11 = obj instanceof Boolean;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z11 = obj instanceof String;
                if (z11) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzgyl) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgzw)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zzhbe) || (obj instanceof zzhaj)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgzk zzgzkVar = new zzgzk();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry entryZzg = this.zza.zzg(i11);
            zzgzkVar.zzc((zzgzj) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgzkVar.zzc((zzgzj) entry.getKey(), entry.getValue());
        }
        zzgzkVar.zzd = this.zzd;
        return zzgzkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgzk) {
            return this.zza.equals(((zzgzk) obj).zza);
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
            if (entryZzg.getValue() instanceof zzgzu) {
                ((zzgzu) entryZzg.getValue()).zzaS();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzgzj zzgzjVar, Object obj) {
        if (!zzgzjVar.zzc()) {
            zzd(zzgzjVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(zzgzjVar, arrayList.get(i11));
            }
            obj = arrayList;
        }
        if (obj instanceof zzhaj) {
            this.zzd = true;
        }
        this.zza.put(zzgzjVar, obj);
    }
}
