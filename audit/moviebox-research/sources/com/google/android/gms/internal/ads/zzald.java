package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzald implements zzakr {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakw zzg;
    private final zzakv zzh;
    private final zzalc zzi;
    private Bitmap zzj;

    public zzald(List list) {
        zzfp zzfpVar = new zzfp((byte[]) list.get(0));
        int iZzq = zzfpVar.zzq();
        int iZzq2 = zzfpVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakw(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakv(0, zzg(), zzh(), zzi());
        this.zzi = new zzalc(iZzq, iZzq2);
    }

    private static int zzb(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    private static zzakv zzc(zzfo zzfoVar, int i11) {
        int[] iArr;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i12 = 8;
        int iZzd5 = zzfoVar.zzd(8);
        zzfoVar.zzm(8);
        int[] iArrZzg = zzg();
        int[] iArrZzh = zzh();
        int[] iArrZzi = zzi();
        int i13 = i11 - 2;
        while (i13 > 0) {
            int iZzd6 = zzfoVar.zzd(i12);
            int iZzd7 = zzfoVar.zzd(i12);
            if ((iZzd7 & 128) != 0) {
                iArr = iArrZzg;
            } else {
                iArr = (iZzd7 & 64) != 0 ? iArrZzh : iArrZzi;
            }
            if ((iZzd7 & 1) != 0) {
                iZzd3 = zzfoVar.zzd(i12);
                iZzd4 = zzfoVar.zzd(i12);
                iZzd = zzfoVar.zzd(i12);
                iZzd2 = zzfoVar.zzd(i12);
                i13 -= 6;
            } else {
                int iZzd8 = zzfoVar.zzd(6) << 2;
                int iZzd9 = zzfoVar.zzd(4) << 4;
                i13 -= 4;
                iZzd = zzfoVar.zzd(4) << 4;
                iZzd2 = zzfoVar.zzd(2) << 6;
                iZzd3 = iZzd8;
                iZzd4 = iZzd9;
            }
            if (iZzd3 == 0) {
                iZzd2 = 255;
            }
            if (iZzd3 == 0) {
                iZzd = 0;
            }
            if (iZzd3 == 0) {
                iZzd4 = 0;
            }
            double d11 = iZzd3;
            double d12 = iZzd4 - 128;
            double d13 = iZzd - 128;
            iArr[iZzd6] = zzb((byte) (255 - (iZzd2 & 255)), Math.max(0, Math.min((int) (d11 + (1.402d * d12)), 255)), Math.max(0, Math.min((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d11 + (d13 * 1.772d)), 255)));
            iZzd5 = iZzd5;
            i12 = 8;
        }
        return new zzakv(iZzd5, iArrZzg, iArrZzh, iArrZzi);
    }

    private static zzakx zzd(zzfo zzfoVar) {
        byte[] bArr;
        int iZzd = zzfoVar.zzd(16);
        zzfoVar.zzm(4);
        int iZzd2 = zzfoVar.zzd(2);
        boolean zZzo = zzfoVar.zzo();
        zzfoVar.zzm(1);
        byte[] bArr2 = zzfy.zzf;
        if (iZzd2 != 1) {
            if (iZzd2 == 0) {
                int iZzd3 = zzfoVar.zzd(16);
                int iZzd4 = zzfoVar.zzd(16);
                if (iZzd3 > 0) {
                    bArr2 = new byte[iZzd3];
                    zzfoVar.zzh(bArr2, 0, iZzd3);
                }
                if (iZzd4 > 0) {
                    bArr = new byte[iZzd4];
                    zzfoVar.zzh(bArr, 0, iZzd4);
                }
            }
            return new zzakx(iZzd, zZzo, bArr2, bArr);
        }
        zzfoVar.zzm(zzfoVar.zzd(8) * 16);
        bArr = bArr2;
        return new zzakx(iZzd, zZzo, bArr2, bArr);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0215  */
    /* JADX WARN: Code duplicated, block: B:118:0x0224 A[LOOP:3: B:88:0x016c->B:118:0x0224, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:141:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x013b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0148 A[LOOP:2: B:40:0x00ac->B:75:0x0148, LOOP_END] */
    private static void zze(byte[] bArr, int[] iArr, int i11, int i12, int i13, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int iZzd;
        int i14;
        int iZzd2;
        int iZzd3;
        boolean z11;
        int iZzd4;
        zzfo zzfoVar = new zzfo(bArr, bArr.length);
        int i15 = i12;
        int i16 = i13;
        byte[] bArrZzf = null;
        byte[] bArrZzf2 = null;
        byte[] bArrZzf3 = null;
        while (zzfoVar.zza() != 0) {
            int i17 = 8;
            int iZzd5 = zzfoVar.zzd(8);
            if (iZzd5 != 240) {
                int i18 = 4;
                int i19 = 2;
                switch (iZzd5) {
                    case 16:
                        int i21 = 1;
                        if (i11 == 3) {
                            if (bArrZzf == null) {
                                bArr3 = zzb;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrZzf;
                            }
                        } else if (i11 != 2) {
                            bArr2 = null;
                        } else if (bArrZzf3 == null) {
                            bArr3 = zza;
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArrZzf3;
                        }
                        int i22 = i15;
                        boolean z12 = false;
                        while (true) {
                            int iZzd6 = zzfoVar.zzd(2);
                            if (iZzd6 == 0) {
                                if (zzfoVar.zzo()) {
                                    iZzd = zzfoVar.zzd(3) + 3;
                                    iZzd6 = zzfoVar.zzd(2);
                                    z12 = z12;
                                } else if (zzfoVar.zzo()) {
                                    iZzd6 = 0;
                                } else {
                                    int iZzd7 = zzfoVar.zzd(2);
                                    if (iZzd7 == 0) {
                                        iZzd6 = 0;
                                        iZzd = 0;
                                        z12 = true;
                                    } else if (iZzd7 == i21) {
                                        z12 = z12;
                                        iZzd6 = 0;
                                        iZzd = 2;
                                    } else if (iZzd7 == 2) {
                                        iZzd = zzfoVar.zzd(4) + 12;
                                        iZzd6 = zzfoVar.zzd(2);
                                        z12 = z12;
                                    } else if (iZzd7 != 3) {
                                        z12 = z12;
                                        iZzd6 = 0;
                                        iZzd = 0;
                                    } else {
                                        iZzd = zzfoVar.zzd(8) + 29;
                                        iZzd6 = zzfoVar.zzd(2);
                                        z12 = z12;
                                    }
                                }
                                if (iZzd == 0 && paint != null) {
                                    int i23 = i16 + 1;
                                    float f11 = i16;
                                    if (bArr2 != 0) {
                                        iZzd6 = bArr2[iZzd6];
                                    }
                                    paint.setColor(iArr[iZzd6]);
                                    canvas.drawRect(i22, f11, i22 + iZzd, i23, paint);
                                }
                                i22 += iZzd;
                                if (z12) {
                                    zzfoVar.zze();
                                    i15 = i22;
                                } else {
                                    z12 = z12;
                                    i21 = 1;
                                }
                                break;
                            }
                            iZzd = 1;
                            if (iZzd == 0) {
                            }
                            i22 += iZzd;
                            if (z12) {
                                zzfoVar.zze();
                                i15 = i22;
                            } else {
                                z12 = z12;
                                i21 = 1;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i11 == 3 ? bArrZzf2 == null ? zzc : bArrZzf2 : null;
                        int i24 = i15;
                        boolean z13 = false;
                        while (true) {
                            int iZzd8 = zzfoVar.zzd(i18);
                            if (iZzd8 == 0) {
                                if (zzfoVar.zzo()) {
                                    if (zzfoVar.zzo()) {
                                        int iZzd9 = zzfoVar.zzd(i19);
                                        if (iZzd9 == 0) {
                                            iZzd8 = 0;
                                        } else if (iZzd9 == 1) {
                                            z13 = z13;
                                            iZzd8 = 0;
                                            i14 = 2;
                                        } else if (iZzd9 == i19) {
                                            iZzd2 = zzfoVar.zzd(i18) + 9;
                                            iZzd3 = zzfoVar.zzd(i18);
                                        } else if (iZzd9 != 3) {
                                            z13 = z13;
                                            iZzd8 = 0;
                                            i14 = 0;
                                        } else {
                                            iZzd2 = zzfoVar.zzd(i17) + 25;
                                            iZzd3 = zzfoVar.zzd(i18);
                                        }
                                    } else {
                                        iZzd2 = zzfoVar.zzd(i19) + i18;
                                        iZzd3 = zzfoVar.zzd(i18);
                                    }
                                    z13 = z13;
                                    i14 = iZzd2;
                                    iZzd8 = iZzd3;
                                } else {
                                    int iZzd10 = zzfoVar.zzd(3);
                                    if (iZzd10 != 0) {
                                        z13 = z13;
                                        i14 = iZzd10 + 2;
                                        iZzd8 = 0;
                                    } else {
                                        iZzd8 = 0;
                                        z13 = true;
                                        i14 = 0;
                                    }
                                }
                                if (i14 == 0 && paint != null) {
                                    int i25 = i16 + 1;
                                    float f12 = i16;
                                    if (bArr4 != 0) {
                                        iZzd8 = bArr4[iZzd8];
                                    }
                                    paint.setColor(iArr[iZzd8]);
                                    canvas.drawRect(i24, f12, i24 + i14, i25, paint);
                                }
                                i24 += i14;
                                if (z13) {
                                    zzfoVar.zze();
                                    i15 = i24;
                                } else {
                                    z13 = z13;
                                    i19 = 2;
                                    i18 = 4;
                                    i17 = 8;
                                }
                                break;
                            }
                            i14 = 1;
                            if (i14 == 0) {
                            }
                            i24 += i14;
                            if (z13) {
                                zzfoVar.zze();
                                i15 = i24;
                            } else {
                                z13 = z13;
                                i19 = 2;
                                i18 = 4;
                                i17 = 8;
                            }
                            break;
                        }
                        break;
                    case 18:
                        int i26 = i15;
                        boolean z14 = false;
                        while (true) {
                            int iZzd11 = zzfoVar.zzd(8);
                            if (iZzd11 != 0) {
                                z11 = z14;
                                iZzd4 = 1;
                            } else if (zzfoVar.zzo()) {
                                z11 = z14;
                                iZzd4 = zzfoVar.zzd(7);
                                iZzd11 = zzfoVar.zzd(8);
                            } else {
                                int iZzd12 = zzfoVar.zzd(7);
                                if (iZzd12 != 0) {
                                    z11 = z14;
                                    iZzd4 = iZzd12;
                                    iZzd11 = 0;
                                } else {
                                    iZzd11 = 0;
                                    z11 = true;
                                    iZzd4 = 0;
                                }
                            }
                            if (iZzd4 != 0 && paint != null) {
                                paint.setColor(iArr[iZzd11]);
                                canvas.drawRect(i26, i16, i26 + iZzd4, i16 + 1, paint);
                            }
                            i26 += iZzd4;
                            if (z11) {
                                i15 = i26;
                            } else {
                                z14 = z11;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iZzd5) {
                            case 32:
                                bArrZzf3 = zzf(4, 4, zzfoVar);
                                break;
                            case 33:
                                bArrZzf = zzf(4, 8, zzfoVar);
                                break;
                            case 34:
                                bArrZzf2 = zzf(16, 8, zzfoVar);
                                break;
                        }
                        break;
                }
            } else {
                i16 += 2;
                i15 = i12;
            }
        }
    }

    private static byte[] zzf(int i11, int i12, zzfo zzfoVar) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) zzfoVar.zzd(i12);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            int i12 = i11 & 4;
            int i13 = i11 & 2;
            int i14 = i11 & 1;
            if (i11 < 8) {
                iArr[i11] = zzb(255, 1 != i14 ? 0 : 255, i13 != 0 ? 255 : 0, i12 != 0 ? 255 : 0);
            } else {
                iArr[i11] = zzb(255, 1 != i14 ? 0 : 127, i13 != 0 ? 127 : 0, i12 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = zzb(63, 1 != (i11 & 1) ? 0 : 255, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & 136;
                if (i12 == 0) {
                    iArr[i11] = zzb(255, (1 != (i11 & 1) ? 0 : 85) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 8) {
                    iArr[i11] = zzb(127, (1 != (i11 & 1) ? 0 : 85) + ((i11 & 16) != 0 ? 170 : 0), ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0), ((i11 & 4) == 0 ? 0 : 85) + ((i11 & 64) == 0 ? 0 : 170));
                } else if (i12 == 128) {
                    iArr[i11] = zzb(255, (1 != (i11 & 1) ? 0 : 43) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = zzb(255, (1 != (i11 & 1) ? 0 : 43) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        zzakj zzakjVar;
        zzala zzalaVar;
        int i13;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i14;
        int iZzd5;
        zzfo zzfoVar = new zzfo(bArr, i11 + i12);
        zzfoVar.zzk(i11);
        while (zzfoVar.zza() >= 48 && zzfoVar.zzd(8) == 15) {
            zzalc zzalcVar = this.zzi;
            int iZzd6 = zzfoVar.zzd(8);
            int iZzd7 = zzfoVar.zzd(16);
            int iZzd8 = zzfoVar.zzd(16);
            int iZzb = zzfoVar.zzb() + iZzd8;
            if (iZzd8 * 8 > zzfoVar.zza()) {
                zzff.zzf("DvbParser", "Data field length exceeds limit");
                zzfoVar.zzm(zzfoVar.zza());
            } else {
                switch (iZzd6) {
                    case 16:
                        if (iZzd7 == zzalcVar.zza) {
                            zzaky zzakyVar = zzalcVar.zzi;
                            int iZzd9 = zzfoVar.zzd(8);
                            int iZzd10 = zzfoVar.zzd(4);
                            int iZzd11 = zzfoVar.zzd(2);
                            zzfoVar.zzm(2);
                            SparseArray sparseArray = new SparseArray();
                            for (int i15 = iZzd8 - 2; i15 > 0; i15 -= 6) {
                                int iZzd12 = zzfoVar.zzd(8);
                                zzfoVar.zzm(8);
                                sparseArray.put(iZzd12, new zzakz(zzfoVar.zzd(16), zzfoVar.zzd(16)));
                            }
                            zzaky zzakyVar2 = new zzaky(iZzd9, iZzd10, iZzd11, sparseArray);
                            if (zzakyVar2.zzb != 0) {
                                zzalcVar.zzi = zzakyVar2;
                                zzalcVar.zzc.clear();
                                zzalcVar.zzd.clear();
                                zzalcVar.zze.clear();
                            } else if (zzakyVar != null) {
                                if (zzakyVar.zza != zzakyVar2.zza) {
                                    zzalcVar.zzi = zzakyVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzaky zzakyVar3 = zzalcVar.zzi;
                        if (iZzd7 == zzalcVar.zza && zzakyVar3 != null) {
                            int iZzd13 = zzfoVar.zzd(8);
                            zzfoVar.zzm(4);
                            boolean zZzo = zzfoVar.zzo();
                            zzfoVar.zzm(3);
                            int iZzd14 = zzfoVar.zzd(16);
                            int iZzd15 = zzfoVar.zzd(16);
                            int iZzd16 = zzfoVar.zzd(3);
                            int iZzd17 = zzfoVar.zzd(3);
                            zzfoVar.zzm(2);
                            int iZzd18 = zzfoVar.zzd(8);
                            int iZzd19 = zzfoVar.zzd(8);
                            int iZzd20 = zzfoVar.zzd(4);
                            int iZzd21 = zzfoVar.zzd(2);
                            zzfoVar.zzm(2);
                            int i16 = iZzd8 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while (i16 > 0) {
                                int iZzd22 = zzfoVar.zzd(16);
                                int iZzd23 = zzfoVar.zzd(2);
                                int iZzd24 = zzfoVar.zzd(2);
                                int iZzd25 = zzfoVar.zzd(12);
                                zzfoVar.zzm(4);
                                int iZzd26 = zzfoVar.zzd(12);
                                int i17 = i16 - 6;
                                if (iZzd23 == 1) {
                                    i16 -= 8;
                                    i13 = iZzd23;
                                    iZzd = zzfoVar.zzd(8);
                                    iZzd2 = zzfoVar.zzd(8);
                                } else if (iZzd23 == 2) {
                                    iZzd23 = 2;
                                    i16 -= 8;
                                    i13 = iZzd23;
                                    iZzd = zzfoVar.zzd(8);
                                    iZzd2 = zzfoVar.zzd(8);
                                } else {
                                    i13 = iZzd23;
                                    i16 = i17;
                                    iZzd = 0;
                                    iZzd2 = 0;
                                }
                                sparseArray2.put(iZzd22, new zzalb(i13, iZzd24, iZzd25, iZzd26, iZzd, iZzd2));
                            }
                            zzala zzalaVar2 = new zzala(iZzd13, zZzo, iZzd14, iZzd15, iZzd16, iZzd17, iZzd18, iZzd19, iZzd20, iZzd21, sparseArray2);
                            if (zzakyVar3.zzb == 0 && (zzalaVar = (zzala) zzalcVar.zzc.get(zzalaVar2.zza)) != null) {
                                int i18 = 0;
                                while (true) {
                                    SparseArray sparseArray3 = zzalaVar.zzj;
                                    if (i18 < sparseArray3.size()) {
                                        zzalaVar2.zzj.put(sparseArray3.keyAt(i18), (zzalb) sparseArray3.valueAt(i18));
                                        i18++;
                                    }
                                }
                            }
                            zzalcVar.zzc.put(zzalaVar2.zza, zzalaVar2);
                        }
                        break;
                    case 18:
                        if (iZzd7 == zzalcVar.zza) {
                            zzakv zzakvVarZzc = zzc(zzfoVar, iZzd8);
                            zzalcVar.zzd.put(zzakvVarZzc.zza, zzakvVarZzc);
                        } else if (iZzd7 == zzalcVar.zzb) {
                            zzakv zzakvVarZzc2 = zzc(zzfoVar, iZzd8);
                            zzalcVar.zzf.put(zzakvVarZzc2.zza, zzakvVarZzc2);
                        }
                        break;
                    case 19:
                        if (iZzd7 == zzalcVar.zza) {
                            zzakx zzakxVarZzd = zzd(zzfoVar);
                            zzalcVar.zze.put(zzakxVarZzd.zza, zzakxVarZzd);
                        } else if (iZzd7 == zzalcVar.zzb) {
                            zzakx zzakxVarZzd2 = zzd(zzfoVar);
                            zzalcVar.zzg.put(zzakxVarZzd2.zza, zzakxVarZzd2);
                        }
                        break;
                    case 20:
                        if (iZzd7 == zzalcVar.zza) {
                            zzfoVar.zzm(4);
                            boolean zZzo2 = zzfoVar.zzo();
                            zzfoVar.zzm(3);
                            int iZzd27 = zzfoVar.zzd(16);
                            int iZzd28 = zzfoVar.zzd(16);
                            if (zZzo2) {
                                int iZzd29 = zzfoVar.zzd(16);
                                iZzd3 = zzfoVar.zzd(16);
                                iZzd5 = zzfoVar.zzd(16);
                                iZzd4 = zzfoVar.zzd(16);
                                i14 = iZzd29;
                            } else {
                                iZzd3 = iZzd27;
                                iZzd4 = iZzd28;
                                i14 = 0;
                                iZzd5 = 0;
                            }
                            zzalcVar.zzh = new zzakw(iZzd27, iZzd28, i14, iZzd3, iZzd5, iZzd4);
                        }
                        break;
                }
                zzfoVar.zzn(iZzb - zzfoVar.zzb());
            }
        }
        zzalc zzalcVar2 = this.zzi;
        zzaky zzakyVar4 = zzalcVar2.zzi;
        if (zzakyVar4 == null) {
            zzakjVar = new zzakj(zzgaa.zzl(), C.TIME_UNSET, C.TIME_UNSET);
        } else {
            zzakw zzakwVar = zzalcVar2.zzh;
            if (zzakwVar == null) {
                zzakwVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakwVar.zza + 1 != bitmap.getWidth() || zzakwVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzakwVar.zza + 1, zzakwVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzakyVar4.zzc;
            int i19 = 0;
            while (i19 < sparseArray4.size()) {
                this.zzf.save();
                zzakz zzakzVar = (zzakz) sparseArray4.valueAt(i19);
                zzala zzalaVar3 = (zzala) this.zzi.zzc.get(sparseArray4.keyAt(i19));
                int i21 = zzakzVar.zza + zzakwVar.zzc;
                int i22 = zzakzVar.zzb + zzakwVar.zze;
                this.zzf.clipRect(i21, i22, Math.min(zzalaVar3.zzc + i21, zzakwVar.zzd), Math.min(zzalaVar3.zzd + i22, zzakwVar.zzf));
                zzakv zzakvVar = (zzakv) this.zzi.zzd.get(zzalaVar3.zzf);
                if (zzakvVar == null) {
                    zzakvVar = (zzakv) this.zzi.zzf.get(zzalaVar3.zzf);
                    if (zzakvVar == null) {
                        zzakvVar = this.zzh;
                    }
                }
                SparseArray sparseArray5 = zzalaVar3.zzj;
                int i23 = 0;
                while (i23 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i23);
                    zzalb zzalbVar = (zzalb) sparseArray5.valueAt(i23);
                    zzakx zzakxVar = (zzakx) this.zzi.zze.get(iKeyAt);
                    if (zzakxVar == null) {
                        zzakxVar = (zzakx) this.zzi.zzg.get(iKeyAt);
                    }
                    if (zzakxVar != null) {
                        Paint paint = zzakxVar.zzb ? null : this.zzd;
                        int i24 = zzalaVar3.zze;
                        int i25 = zzalbVar.zza + i21;
                        int i26 = zzalbVar.zzb + i22;
                        Canvas canvas = this.zzf;
                        int[] iArr = i24 == 3 ? zzakvVar.zzd : i24 == 2 ? zzakvVar.zzc : zzakvVar.zzb;
                        Paint paint2 = paint;
                        zze(zzakxVar.zzc, iArr, i24, i25, i26, paint2, canvas);
                        zze(zzakxVar.zzd, iArr, i24, i25, i26 + 1, paint2, canvas);
                    }
                    i23++;
                    sparseArray4 = sparseArray4;
                    sparseArray5 = sparseArray5;
                    i19 = i19;
                }
                SparseArray sparseArray6 = sparseArray4;
                int i27 = i19;
                float f11 = i22;
                float f12 = i21;
                if (zzalaVar3.zzb) {
                    int i28 = zzalaVar3.zze;
                    this.zze.setColor(i28 == 3 ? zzakvVar.zzd[zzalaVar3.zzg] : i28 == 2 ? zzakvVar.zzc[zzalaVar3.zzh] : zzakvVar.zzb[zzalaVar3.zzi]);
                    this.zzf.drawRect(f12, f11, zzalaVar3.zzc + i21, zzalaVar3.zzd + i22, this.zze);
                }
                zzea zzeaVar = new zzea();
                zzeaVar.zzc(Bitmap.createBitmap(this.zzj, i21, i22, zzalaVar3.zzc, zzalaVar3.zzd));
                zzeaVar.zzh(f12 / zzakwVar.zza);
                zzeaVar.zzi(0);
                zzeaVar.zze(f11 / zzakwVar.zzb, 0);
                zzeaVar.zzf(0);
                zzeaVar.zzk(zzalaVar3.zzc / zzakwVar.zza);
                zzeaVar.zzd(zzalaVar3.zzd / zzakwVar.zzb);
                arrayList.add(zzeaVar.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i19 = i27 + 1;
                sparseArray4 = sparseArray6;
            }
            zzakjVar = new zzakj(arrayList, C.TIME_UNSET, C.TIME_UNSET);
        }
        zzepVar.zza(zzakjVar);
    }
}
