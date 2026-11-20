package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzp;
import com.google.android.gms.internal.ads.zzgzu;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzgzp<MessageType extends zzgzu<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> extends zzgxs<MessageType, BuilderType> {
    protected zzgzu zza;
    private final zzgzu zzb;

    public zzgzp(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaY()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzaD();
    }

    private static void zza(Object obj, Object obj2) {
        zzhbn.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxs
    /* JADX INFO: renamed from: zzai, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzgzp zzah() {
        zzgzp zzgzpVar = (zzgzp) this.zzb.zzb(5, null, null);
        zzgzpVar.zza = zzan();
        return zzgzpVar;
    }

    public final zzgzp zzaj(zzgzu zzgzuVar) {
        if (!this.zzb.equals(zzgzuVar)) {
            if (!this.zza.zzaY()) {
                zzaq();
            }
            zza(this.zza, zzgzuVar);
        }
        return this;
    }

    public final zzgzp zzak(byte[] bArr, int i11, int i12, zzgzf zzgzfVar) throws zzhag {
        if (!this.zza.zzaY()) {
            zzaq();
        }
        try {
            zzhbn.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i12, new zzgxx(zzgzfVar));
            return this;
        } catch (zzhag e11) {
            throw e11;
        } catch (IOException e12) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhag.zzj();
        }
    }

    public final MessageType zzal() {
        MessageType messagetype = (MessageType) zzan();
        if (messagetype.zzaX()) {
            return messagetype;
        }
        throw new zzhco(messagetype);
    }

    @Override // com.google.android.gms.internal.ads.zzhbd
    /* JADX INFO: renamed from: zzam, reason: merged with bridge method [inline-methods] */
    public MessageType zzan() {
        if (!this.zza.zzaY()) {
            return (MessageType) this.zza;
        }
        this.zza.zzaS();
        return (MessageType) this.zza;
    }

    public final void zzap() {
        if (this.zza.zzaY()) {
            return;
        }
        zzaq();
    }

    public void zzaq() {
        zzgzu zzgzuVarZzaD = this.zzb.zzaD();
        zza(zzgzuVarZzaD, this.zza);
        this.zza = zzgzuVarZzaD;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final /* synthetic */ zzhbe zzbk() {
        throw null;
    }
}
