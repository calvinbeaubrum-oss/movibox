package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabs {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzabr zza(byte[] bArr) throws zzcc {
        return zzb(new zzfo(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
    
        if (r11 != 3) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzabr zzb(zzfo zzfoVar, boolean z11) throws zzcc {
        int iZzc = zzc(zzfoVar);
        int iZzd = zzd(zzfoVar);
        int iZzd2 = zzfoVar.zzd(4);
        String str = "mp4a.40." + iZzc;
        int i11 = 22;
        if (iZzc == 5 || iZzc == 29) {
            iZzd = zzd(zzfoVar);
            iZzc = zzc(zzfoVar);
            if (iZzc == 22) {
                iZzd2 = zzfoVar.zzd(4);
            }
        }
        if (z11) {
            int i12 = 3;
            if (iZzc != 1 && iZzc != 2 && iZzc != 3 && iZzc != 4 && iZzc != 6 && iZzc != 7 && iZzc != 17) {
                switch (iZzc) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw zzcc.zzc("Unsupported audio object type: " + iZzc);
                }
            }
            if (zzfoVar.zzo()) {
                zzff.zzf("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(14);
            }
            boolean zZzo = zzfoVar.zzo();
            if (iZzd2 == 0) {
                throw new UnsupportedOperationException();
            }
            if (iZzc == 6) {
                zzfoVar.zzm(3);
            } else if (iZzc == 20) {
                iZzc = 20;
                zzfoVar.zzm(3);
            }
            if (zZzo) {
                if (iZzc == 22) {
                    zzfoVar.zzm(16);
                } else {
                    i11 = iZzc;
                }
                if (i11 == 17 || i11 == 19 || i11 == 20 || i11 == 23) {
                    zzfoVar.zzm(3);
                }
                zzfoVar.zzm(1);
            }
            switch (iZzc) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iZzd3 = zzfoVar.zzd(2);
                    if (iZzd3 == 2) {
                        i12 = iZzd3;
                    }
                    throw zzcc.zzc("Unsupported epConfig: " + i12);
            }
        }
        int i13 = zzc[iZzd2];
        if (i13 != -1) {
            return new zzabr(iZzd, i13, str, null);
        }
        throw zzcc.zza(null, null);
    }

    private static int zzc(zzfo zzfoVar) {
        int iZzd = zzfoVar.zzd(5);
        return iZzd == 31 ? zzfoVar.zzd(6) + 32 : iZzd;
    }

    private static int zzd(zzfo zzfoVar) throws zzcc {
        int iZzd = zzfoVar.zzd(4);
        if (iZzd == 15) {
            if (zzfoVar.zza() >= 24) {
                return zzfoVar.zzd(24);
            }
            throw zzcc.zza("AAC header insufficient data", null);
        }
        if (iZzd < 13) {
            return zzb[iZzd];
        }
        throw zzcc.zza("AAC header wrong Sampling Frequency Index", null);
    }
}
