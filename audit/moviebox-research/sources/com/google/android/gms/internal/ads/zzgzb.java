package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzb {
    private final zzgza zza;

    private zzgzb(zzgza zzgzaVar) {
        byte[] bArr = zzhae.zzd;
        this.zza = zzgzaVar;
        zzgzaVar.zze = this;
    }

    public static zzgzb zza(zzgza zzgzaVar) {
        zzgzb zzgzbVar = zzgzaVar.zze;
        return zzgzbVar != null ? zzgzbVar : new zzgzb(zzgzaVar);
    }

    public final void zzA(int i11, int i12) throws IOException {
        this.zza.zzr(i11, (i12 >> 31) ^ (i12 + i12));
    }

    public final void zzB(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                zzgza zzgzaVar = this.zza;
                int iIntValue = ((Integer) list.get(i12)).intValue();
                zzgzaVar.zzr(i11, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzz = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            int iIntValue2 = ((Integer) list.get(i13)).intValue();
            iZzz += zzgza.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzs(iZzz);
        while (i12 < list.size()) {
            zzgza zzgzaVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i12)).intValue();
            zzgzaVar2.zzs((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i12++;
        }
    }

    public final void zzC(int i11, long j11) throws IOException {
        this.zza.zzt(i11, (j11 >> 63) ^ (j11 + j11));
    }

    public final void zzD(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                zzgza zzgzaVar = this.zza;
                long jLongValue = ((Long) list.get(i12)).longValue();
                zzgzaVar.zzt(i11, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzA = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            long jLongValue2 = ((Long) list.get(i13)).longValue();
            iZzA += zzgza.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzs(iZzA);
        while (i12 < list.size()) {
            zzgza zzgzaVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i12)).longValue();
            zzgzaVar2.zzu((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i12++;
        }
    }

    @Deprecated
    public final void zzE(int i11) throws IOException {
        this.zza.zzq(i11, 3);
    }

    public final void zzF(int i11, String str) throws IOException {
        this.zza.zzo(i11, str);
    }

    public final void zzG(int i11, List list) throws IOException {
        int i12 = 0;
        if (!(list instanceof zzham)) {
            while (i12 < list.size()) {
                this.zza.zzo(i11, (String) list.get(i12));
                i12++;
            }
            return;
        }
        zzham zzhamVar = (zzham) list;
        while (i12 < list.size()) {
            Object objZzf = zzhamVar.zzf(i12);
            if (objZzf instanceof String) {
                this.zza.zzo(i11, (String) objZzf);
            } else {
                this.zza.zzK(i11, (zzgyl) objZzf);
            }
            i12++;
        }
    }

    public final void zzH(int i11, int i12) throws IOException {
        this.zza.zzr(i11, i12);
    }

    public final void zzI(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzr(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzz = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZzz += zzgza.zzz(((Integer) list.get(i13)).intValue());
        }
        this.zza.zzs(iZzz);
        while (i12 < list.size()) {
            this.zza.zzs(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzJ(int i11, long j11) throws IOException {
        this.zza.zzt(i11, j11);
    }

    public final void zzK(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzt(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzA = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZzA += zzgza.zzA(((Long) list.get(i13)).longValue());
        }
        this.zza.zzs(iZzA);
        while (i12 < list.size()) {
            this.zza.zzu(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        this.zza.zzJ(i11, z11);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzc(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzJ(i11, ((Boolean) list.get(i12)).booleanValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Boolean) list.get(i14)).booleanValue();
            i13++;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzI(((Boolean) list.get(i12)).booleanValue() ? (byte) 1 : (byte) 0);
            i12++;
        }
    }

    public final void zzd(int i11, zzgyl zzgylVar) throws IOException {
        this.zza.zzK(i11, zzgylVar);
    }

    public final void zze(int i11, List list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zza.zzK(i11, (zzgyl) list.get(i12));
        }
    }

    public final void zzf(int i11, double d11) throws IOException {
        this.zza.zzj(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zzg(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzj(i11, Double.doubleToRawLongBits(((Double) list.get(i12)).doubleValue()));
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Double) list.get(i14)).doubleValue();
            i13 += 8;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i12)).doubleValue()));
            i12++;
        }
    }

    @Deprecated
    public final void zzh(int i11) throws IOException {
        this.zza.zzq(i11, 4);
    }

    public final void zzi(int i11, int i12) throws IOException {
        this.zza.zzl(i11, i12);
    }

    public final void zzj(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzl(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzA = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZzA += zzgza.zzA(((Integer) list.get(i13)).intValue());
        }
        this.zza.zzs(iZzA);
        while (i12 < list.size()) {
            this.zza.zzm(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzk(int i11, int i12) throws IOException {
        this.zza.zzh(i11, i12);
    }

    public final void zzl(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzh(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Integer) list.get(i14)).intValue();
            i13 += 4;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzi(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzm(int i11, long j11) throws IOException {
        this.zza.zzj(i11, j11);
    }

    public final void zzn(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzj(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Long) list.get(i14)).longValue();
            i13 += 8;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzk(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzo(int i11, float f11) throws IOException {
        this.zza.zzh(i11, Float.floatToRawIntBits(f11));
    }

    public final void zzp(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzh(i11, Float.floatToRawIntBits(((Float) list.get(i12)).floatValue()));
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Float) list.get(i14)).floatValue();
            i13 += 4;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i12)).floatValue()));
            i12++;
        }
    }

    public final void zzq(int i11, Object obj, zzhby zzhbyVar) throws IOException {
        zzgza zzgzaVar = this.zza;
        zzgzaVar.zzq(i11, 3);
        zzhbyVar.zzm((zzhbe) obj, zzgzaVar.zze);
        zzgzaVar.zzq(i11, 4);
    }

    public final void zzr(int i11, int i12) throws IOException {
        this.zza.zzl(i11, i12);
    }

    public final void zzs(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzl(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzA = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZzA += zzgza.zzA(((Integer) list.get(i13)).intValue());
        }
        this.zza.zzs(iZzA);
        while (i12 < list.size()) {
            this.zza.zzm(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzt(int i11, long j11) throws IOException {
        this.zza.zzt(i11, j11);
    }

    public final void zzu(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzt(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int iZzA = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            iZzA += zzgza.zzA(((Long) list.get(i13)).longValue());
        }
        this.zza.zzs(iZzA);
        while (i12 < list.size()) {
            this.zza.zzu(((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzv(int i11, Object obj, zzhby zzhbyVar) throws IOException {
        this.zza.zzn(i11, (zzhbe) obj, zzhbyVar);
    }

    public final void zzw(int i11, int i12) throws IOException {
        this.zza.zzh(i11, i12);
    }

    public final void zzx(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzh(i11, ((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Integer) list.get(i14)).intValue();
            i13 += 4;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzi(((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzy(int i11, long j11) throws IOException {
        this.zza.zzj(i11, j11);
    }

    public final void zzz(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (!z11) {
            while (i12 < list.size()) {
                this.zza.zzj(i11, ((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        this.zza.zzq(i11, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((Long) list.get(i14)).longValue();
            i13 += 8;
        }
        this.zza.zzs(i13);
        while (i12 < list.size()) {
            this.zza.zzk(((Long) list.get(i12)).longValue());
            i12++;
        }
    }
}
