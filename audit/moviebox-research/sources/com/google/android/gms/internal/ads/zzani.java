package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzani {
    private final zzaea zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzani(zzaea zzaeaVar) {
        this.zza = zzaeaVar;
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
    private final void zzf(int i11) {
        long j11 = this.zzl;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        boolean z11 = this.zzm;
        long j12 = this.zzb - this.zzk;
        this.zza.zzt(j11, z11 ? 1 : 0, (int) j12, i11, null);
    }

    public final void zza(long j11) {
        this.zzb = j11;
        zzf(0);
        this.zzi = false;
    }

    public final void zzb(long j11, int i11, boolean z11) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z11 && this.zzi) {
                zzf(i11 + ((int) (j11 - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }

    public final void zzc(byte[] bArr, int i11, int i12) {
        if (this.zzf) {
            int i13 = this.zzd;
            int i14 = (i11 + 2) - i13;
            if (i14 >= i12) {
                this.zzd = i13 + (i12 - i11);
            } else {
                this.zzg = (bArr[i14] & 128) != 0;
                this.zzf = false;
            }
        }
    }

    public final void zzd() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zze(long j11, int i11, int i12, long j12, boolean z11) {
        this.zzg = false;
        this.zzh = false;
        this.zze = j12;
        this.zzd = 0;
        this.zzb = j11;
        if (i12 >= 32 && i12 != 40) {
            if (this.zzi && !this.zzj) {
                if (z11) {
                    zzf(i11);
                }
                this.zzi = false;
            }
            if (i12 <= 35 || i12 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z12 = i12 >= 16 && i12 <= 21;
        this.zzc = z12;
        this.zzf = z12 || i12 <= 9;
    }
}
