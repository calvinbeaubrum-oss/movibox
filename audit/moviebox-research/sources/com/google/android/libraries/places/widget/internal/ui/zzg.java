package com.google.android.libraries.places.widget.internal.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.internal.zzkd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzg extends RecyclerView.r {
    final /* synthetic */ AutocompleteImplFragment zza;

    public zzg(AutocompleteImplFragment autocompleteImplFragment) {
        this.zza = autocompleteImplFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public final void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        if (i11 == 1) {
            try {
                this.zza.zze.zzg();
                this.zza.zzg.clearFocus();
            } catch (Error | RuntimeException e11) {
                zzkd.zzb(e11);
                throw e11;
            }
        }
    }
}
