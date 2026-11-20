package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzin<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzll {
    @Override // 
    /* JADX INFO: renamed from: zzau, reason: merged with bridge method [inline-methods] */
    public abstract zzin clone();

    public zzin zzav(byte[] bArr, int i11, int i12) throws zzkp {
        throw null;
    }

    public zzin zzaw(byte[] bArr, int i11, int i12, zzjr zzjrVar) throws zzkp {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final /* synthetic */ zzll zzax(byte[] bArr) throws zzkp {
        return zzav(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final /* synthetic */ zzll zzay(byte[] bArr, zzjr zzjrVar) throws zzkp {
        return zzaw(bArr, 0, bArr.length, zzjrVar);
    }
}
