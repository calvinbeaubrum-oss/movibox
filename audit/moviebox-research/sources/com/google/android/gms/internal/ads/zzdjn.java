package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdjn extends zzcwh {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdhy zze;
    private final zzdkw zzf;
    private final zzcxc zzg;
    private final zzfrc zzh;
    private final zzdbk zzi;
    private final zzcdp zzj;
    private boolean zzk;

    public zzdjn(zzcwg zzcwgVar, Context context, zzcjk zzcjkVar, zzdhy zzdhyVar, zzdkw zzdkwVar, zzcxc zzcxcVar, zzfrc zzfrcVar, zzdbk zzdbkVar, zzcdp zzcdpVar) {
        super(zzcwgVar);
        this.zzk = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcjkVar);
        this.zze = zzdhyVar;
        this.zzf = zzdkwVar;
        this.zzg = zzcxcVar;
        this.zzh = zzfrcVar;
        this.zzi = zzdbkVar;
        this.zzj = zzcdpVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcjk zzcjkVar = (zzcjk) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgL)).booleanValue()) {
                if (!this.zzk && zzcjkVar != null) {
                    zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjm
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcjkVar.destroy();
                        }
                    });
                }
            } else if (zzcjkVar != null) {
                zzcjkVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza() {
        return this.zzg.zzg();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0092  */
    /* JADX WARN: Code duplicated, block: B:21:0x0096  */
    /* JADX WARN: Code duplicated, block: B:24:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:9:0x004e  */
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
    public final boolean zzc(boolean z11, Activity activity) {
        Context context;
        zzfgm zzfgmVarZzD;
        this.zze.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaB)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzF(this.zzc)) {
                zzcec.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaC)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
            } else {
                zzcjk zzcjkVar = (zzcjk) this.zzd.get();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzll)).booleanValue() || zzcjkVar == null || (zzfgmVarZzD = zzcjkVar.zzD()) == null || !zzfgmVarZzD.zzar || zzfgmVarZzD.zzas == this.zzj.zzb()) {
                    if (this.zzk) {
                        zzcec.zzj("The interstitial ad has been shown.");
                        this.zzi.zza(zzfij.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzk) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        try {
                            this.zzf.zza(z11, context, this.zzi);
                            this.zze.zza();
                            this.zzk = true;
                            return true;
                        } catch (zzdkv e11) {
                            this.zzi.zzc(e11);
                        }
                    }
                } else {
                    zzcec.zzj("The interstitial consent form has been shown.");
                    this.zzi.zza(zzfij.zzd(12, "The consent form has already been shown.", null));
                }
            }
        } else {
            zzcjk zzcjkVar2 = (zzcjk) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzll)).booleanValue()) {
                if (this.zzk) {
                    zzcec.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfij.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    this.zzf.zza(z11, context, this.zzi);
                    this.zze.zza();
                    this.zzk = true;
                    return true;
                }
            } else {
                if (this.zzk) {
                    zzcec.zzj("The interstitial ad has been shown.");
                    this.zzi.zza(zzfij.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzk) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    this.zzf.zza(z11, context, this.zzi);
                    this.zze.zza();
                    this.zzk = true;
                    return true;
                }
            }
        }
        return false;
    }
}
