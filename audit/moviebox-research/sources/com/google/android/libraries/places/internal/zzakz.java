package com.google.android.libraries.places.internal;

import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzakz implements zzaty {
    static final zzaty zza = new zzakz();

    private zzakz() {
    }

    @Override // com.google.android.libraries.places.internal.zzaty
    public final boolean zza(int i11) {
        if (i11 != 1 && i11 != 2 && i11 != 3 && i11 != 99) {
            switch (i11) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                case 30:
                case VungleException.WEB_CRASH /* 31 */:
                case 32:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
