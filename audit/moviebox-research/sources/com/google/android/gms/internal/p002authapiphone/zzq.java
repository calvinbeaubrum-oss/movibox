package com.google.android.gms.internal.p002authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzq extends zzf {
    final /* synthetic */ TaskCompletionSource zza;

    public zzq(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p002authapiphone.zzg
    public final void zzb(Status status, boolean z11) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z11), this.zza);
    }
}
