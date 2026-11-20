package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzanc {
    private final zzaea zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzanc(zzaea zzaeaVar) {
        this.zza = zzaeaVar;
    }

    public final void zza(byte[] bArr, int i11, int i12) {
        if (this.zzc) {
            int i13 = this.zzf;
            int i14 = (i11 + 1) - i13;
            if (i14 >= i12) {
                this.zzf = i13 + (i12 - i11);
            } else {
                this.zzd = ((bArr[i14] & 192) >> 6) == 0;
                this.zzc = false;
            }
        }
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
    public final void zzb(long j11, int i11, boolean z11) {
        zzek.zzf(this.zzh != C.TIME_UNSET);
        if (this.zze == 182 && z11 && this.zzb) {
            this.zza.zzt(this.zzh, this.zzd ? 1 : 0, (int) (j11 - this.zzg), i11, null);
        }
        if (this.zze != 179) {
            this.zzg = j11;
        }
    }

    public final void zzc(int i11, long j11) {
        boolean z11;
        this.zze = i11;
        this.zzd = false;
        if (i11 == 182) {
            z11 = true;
        } else if (i11 == 179) {
            i11 = 179;
            z11 = true;
        } else {
            z11 = false;
        }
        this.zzb = z11;
        this.zzc = i11 == 182;
        this.zzf = 0;
        this.zzh = j11;
    }

    public final void zzd() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }
}
