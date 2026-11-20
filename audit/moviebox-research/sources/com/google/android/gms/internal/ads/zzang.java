package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzang {
    private final zzaea zza;
    private final zzgn zzd;
    private final byte[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final zzanf zzi = new zzanf(null);
    private final zzanf zzj = new zzanf(null);
    private boolean zzk = false;

    public zzang(zzaea zzaeaVar, boolean z11, boolean z12) {
        this.zza = zzaeaVar;
        byte[] bArr = new byte[128];
        this.zze = bArr;
        this.zzd = new zzgn(bArr, 0, 0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void zzg(int i11) {
        long j11 = this.zzm;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        boolean z11 = this.zzn;
        long j12 = this.zzg - this.zzl;
        this.zza.zzt(j11, z11 ? 1 : 0, (int) j12, i11, null);
    }

    public final void zza(long j11) {
        this.zzg = j11;
        zzg(0);
        this.zzk = false;
    }

    public final void zzb(zzgk zzgkVar) {
        this.zzc.append(zzgkVar.zza, zzgkVar);
    }

    public final void zzc(zzgl zzglVar) {
        this.zzb.append(zzglVar.zzd, zzglVar);
    }

    public final void zzd() {
        this.zzk = false;
    }

    public final void zze(long j11, int i11, long j12, boolean z11) {
        this.zzf = i11;
        this.zzh = j12;
        this.zzg = j11;
        this.zzo = z11;
    }

    public final boolean zzf(long j11, int i11, boolean z11) {
        boolean z12 = false;
        if (this.zzf == 9) {
            if (z11 && this.zzk) {
                zzg(i11 + ((int) (j11 - this.zzg)));
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z13 = this.zzo;
        boolean z14 = this.zzn;
        int i12 = this.zzf;
        if (i12 == 5 || (z13 && i12 == 1)) {
            z12 = true;
        }
        boolean z15 = z14 | z12;
        this.zzn = z15;
        return z15;
    }
}
