package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalw implements zzakr {
    private final zzfp zza = new zzfp();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzalw(List list) {
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = C.SANS_SERIF_NAME;
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzfy.zzA(bArr, 43, bArr.length + (-43))) ? C.SERIF_NAME : str;
        int i11 = bArr[25] * Ascii.DC4;
        this.zzg = i11;
        boolean z11 = (bArr[0] & 32) != 0;
        this.zzb = z11;
        if (z11) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i11, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            int i16 = i15 | 33;
            int i17 = i11 & 1;
            int i18 = i11 & 2;
            boolean z11 = true;
            if (i17 != 0) {
                if (i18 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i13, i14, i16);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i13, i14, i16);
                    z11 = false;
                }
            } else if (i18 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i13, i14, i16);
            } else {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i13, i14, i16);
            } else {
                if (i17 != 0 || z11) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i13, i14, i16);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        String strZzA;
        int length;
        this.zza.zzI(bArr, i11 + i12);
        this.zza.zzK(i11);
        zzfp zzfpVar = this.zza;
        int i13 = 1;
        int i14 = 2;
        zzek.zzd(zzfpVar.zzb() >= 2);
        int iZzq = zzfpVar.zzq();
        if (iZzq == 0) {
            strZzA = "";
        } else {
            int iZzd = zzfpVar.zzd();
            Charset charsetZzB = zzfpVar.zzB();
            int iZzd2 = zzfpVar.zzd() - iZzd;
            if (charsetZzB == null) {
                charsetZzB = zzfwq.zzc;
            }
            strZzA = zzfpVar.zzA(iZzq - iZzd2, charsetZzB);
        }
        if (strZzA.isEmpty()) {
            zzepVar.zza(new zzakj(zzgaa.zzl(), C.TIME_UNSET, C.TIME_UNSET));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strZzA);
        zzc(spannableStringBuilder, this.zzc, 0, 0, spannableStringBuilder.length(), 16711680);
        zzb(spannableStringBuilder, this.zzd, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = this.zze;
        int length2 = spannableStringBuilder.length();
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fMax = this.zzf;
        while (true) {
            zzfp zzfpVar2 = this.zza;
            if (zzfpVar2.zzb() < 8) {
                zzea zzeaVar = new zzea();
                zzeaVar.zzl(spannableStringBuilder);
                zzeaVar.zze(fMax, 0);
                zzeaVar.zzf(0);
                zzepVar.zza(new zzakj(zzgaa.zzm(zzeaVar.zzp()), C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
            int iZzd3 = zzfpVar2.zzd();
            int iZzg = zzfpVar2.zzg();
            int iZzg2 = this.zza.zzg();
            if (iZzg2 == 1937013100) {
                zzek.zzd(this.zza.zzb() >= i14);
                int iZzq2 = this.zza.zzq();
                int i15 = 0;
                while (i15 < iZzq2) {
                    zzfp zzfpVar3 = this.zza;
                    zzek.zzd(zzfpVar3.zzb() >= 12);
                    int iZzq3 = zzfpVar3.zzq();
                    int iZzq4 = zzfpVar3.zzq();
                    zzfpVar3.zzL(i14);
                    int iZzm = zzfpVar3.zzm();
                    zzfpVar3.zzL(i13);
                    int iZzg3 = zzfpVar3.zzg();
                    if (iZzq4 > spannableStringBuilder.length()) {
                        zzff.zzf("Tx3gParser", "Truncating styl end (" + iZzq4 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
                        length = spannableStringBuilder.length();
                    } else {
                        length = iZzq4;
                    }
                    if (iZzq3 >= length) {
                        zzff.zzf("Tx3gParser", "Ignoring styl with start (" + iZzq3 + ") >= end (" + length + ").");
                    } else {
                        int i16 = length;
                        zzc(spannableStringBuilder, iZzm, this.zzc, iZzq3, i16, 0);
                        zzb(spannableStringBuilder, iZzg3, this.zzd, iZzq3, i16, 0);
                    }
                    i15++;
                    iZzq2 = iZzq2;
                    i13 = 1;
                    i14 = 2;
                }
            } else {
                if (iZzg2 == 1952608120 && this.zzb) {
                    zzek.zzd(this.zza.zzb() >= 2);
                    fMax = Math.max(0.0f, Math.min(this.zza.zzq() / this.zzg, 0.95f));
                }
                this.zza.zzK(iZzd3 + iZzg);
                i13 = 1;
                i14 = 2;
            }
            this.zza.zzK(iZzd3 + iZzg);
            i13 = 1;
            i14 = 2;
        }
    }
}
