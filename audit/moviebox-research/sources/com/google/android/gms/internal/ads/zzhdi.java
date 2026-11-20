package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhdi implements zzgzy {
    static final zzgzy zza = new zzhdi();

    private zzhdi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzy
    public final boolean zza(int i11) {
        if (i11 != 0 && i11 != 1 && i11 != 2 && i11 != 1999) {
            switch (i11) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
