package com.google.android.libraries.places.widget.internal.ui;

import androidx.activity.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzf extends p {
    final /* synthetic */ AutocompleteImplFragment zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(AutocompleteImplFragment autocompleteImplFragment, boolean z11) {
        super(true);
        this.zza = autocompleteImplFragment;
    }

    @Override // androidx.activity.p
    public final void handleOnBackPressed() {
        this.zza.zze.zzj();
    }
}
