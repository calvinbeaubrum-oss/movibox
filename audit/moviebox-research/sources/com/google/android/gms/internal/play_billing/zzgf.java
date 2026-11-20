package com.google.android.gms.internal.play_billing;

import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgf<T> implements zzgm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgc zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfq zzl;
    private final zzhd zzm;
    private final zzek zzn;
    private final zzgh zzo;
    private final zzfx zzp;

    private zzgf(int[] iArr, Object[] objArr, int i11, int i12, zzgc zzgcVar, int i13, boolean z11, int[] iArr2, int i14, int i15, zzgh zzghVar, zzfq zzfqVar, zzhd zzhdVar, zzek zzekVar, zzfx zzfxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        boolean z12 = false;
        if (zzekVar != null && zzekVar.zzc(zzgcVar)) {
            z12 = true;
        }
        this.zzh = z12;
        this.zzi = iArr2;
        this.zzj = i14;
        this.zzk = i15;
        this.zzo = zzghVar;
        this.zzl = zzfqVar;
        this.zzm = zzhdVar;
        this.zzn = zzekVar;
        this.zzg = zzgcVar;
        this.zzp = zzfxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i11) {
        if (zzI(obj2, i11)) {
            int iZzs = zzs(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = iZzs;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzgm zzgmVarZzv = zzv(i11);
            if (!zzI(obj, i11)) {
                if (zzL(object)) {
                    Object objZze = zzgmVarZzv.zze();
                    zzgmVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j11, objZze);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzD(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object objZze2 = zzgmVarZzv.zze();
                zzgmVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j11, objZze2);
                object2 = objZze2;
            }
            zzgmVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzM(obj2, i12, i11)) {
            int iZzs = zzs(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = iZzs;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzgm zzgmVarZzv = zzv(i11);
            if (!zzM(obj, i12, i11)) {
                if (zzL(object)) {
                    Object objZze = zzgmVarZzv.zze();
                    zzgmVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j11, objZze);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzE(obj, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object objZze2 = zzgmVarZzv.zze();
                zzgmVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j11, objZze2);
                object2 = objZze2;
            }
            zzgmVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i11) {
        int iZzp = zzp(i11);
        long j11 = 1048575 & iZzp;
        if (j11 == 1048575) {
            return;
        }
        zzhn.zzq(obj, j11, (1 << (iZzp >>> 20)) | zzhn.zzc(obj, j11));
    }

    private final void zzE(Object obj, int i11, int i12) {
        zzhn.zzq(obj, zzp(i12) & 1048575, i11);
    }

    private final void zzF(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, zzs(i11) & 1048575, obj2);
        zzD(obj, i11);
    }

    private final void zzG(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, zzs(i12) & 1048575, obj2);
        zzE(obj, i11, i12);
    }

    private final boolean zzH(Object obj, Object obj2, int i11) {
        return zzI(obj, i11) == zzI(obj2, i11);
    }

    private final boolean zzI(Object obj, int i11) {
        int iZzp = zzp(i11);
        long j11 = iZzp & 1048575;
        if (j11 != 1048575) {
            return (zzhn.zzc(obj, j11) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i11);
        long j12 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzhn.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhn.zzb(obj, j12)) != 0;
            case 2:
                return zzhn.zzd(obj, j12) != 0;
            case 3:
                return zzhn.zzd(obj, j12) != 0;
            case 4:
                return zzhn.zzc(obj, j12) != 0;
            case 5:
                return zzhn.zzd(obj, j12) != 0;
            case 6:
                return zzhn.zzc(obj, j12) != 0;
            case 7:
                return zzhn.zzw(obj, j12);
            case 8:
                Object objZzf = zzhn.zzf(obj, j12);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdw) {
                    return !zzdw.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhn.zzf(obj, j12) != null;
            case 10:
                return !zzdw.zzb.equals(zzhn.zzf(obj, j12));
            case 11:
                return zzhn.zzc(obj, j12) != 0;
            case 12:
                return zzhn.zzc(obj, j12) != 0;
            case 13:
                return zzhn.zzc(obj, j12) != 0;
            case 14:
                return zzhn.zzd(obj, j12) != 0;
            case 15:
                return zzhn.zzc(obj, j12) != 0;
            case 16:
                return zzhn.zzd(obj, j12) != 0;
            case 17:
                return zzhn.zzf(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return zzI(obj, i11);
        }
        return (i13 & i14) != 0;
    }

    private static boolean zzK(Object obj, int i11, zzgm zzgmVar) {
        return zzgmVar.zzk(zzhn.zzf(obj, i11 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzex) {
            return ((zzex) obj).zzt();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i11, int i12) {
        return zzhn.zzc(obj, (long) (zzp(i12) & 1048575)) == i11;
    }

    private static boolean zzN(Object obj, long j11) {
        return ((Boolean) zzhn.zzf(obj, j11)).booleanValue();
    }

    private static final void zzO(int i11, Object obj, zzhv zzhvVar) throws IOException {
        if (obj instanceof String) {
            zzhvVar.zzF(i11, (String) obj);
        } else {
            zzhvVar.zzd(i11, (zzdw) obj);
        }
    }

    public static zzhe zzd(Object obj) {
        zzex zzexVar = (zzex) obj;
        zzhe zzheVar = zzexVar.zzc;
        if (zzheVar != zzhe.zzc()) {
            return zzheVar;
        }
        zzhe zzheVarZzf = zzhe.zzf();
        zzexVar.zzc = zzheVarZzf;
        return zzheVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0280  */
    /* JADX WARN: Code duplicated, block: B:131:0x0283  */
    public static zzgf zzl(Class cls, zzfz zzfzVar, zzgh zzghVar, zzfq zzfqVar, zzhd zzhdVar, zzek zzekVar, zzfx zzfxVar) {
        int i11;
        int iCharAt;
        int iCharAt2;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        char cCharAt;
        int i18;
        char cCharAt2;
        int i19;
        char cCharAt3;
        int i21;
        char cCharAt4;
        int i22;
        char cCharAt5;
        int i23;
        char cCharAt6;
        int i24;
        char cCharAt7;
        int i25;
        char cCharAt8;
        int i26;
        int i27;
        int iObjectFieldOffset;
        int i28;
        int i29;
        int i31;
        int iObjectFieldOffset2;
        Field fieldZzz;
        char cCharAt9;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        Object obj;
        Field fieldZzz2;
        int i37;
        Object obj2;
        Field fieldZzz3;
        int i38;
        char cCharAt10;
        int i39;
        char cCharAt11;
        int i40;
        char cCharAt12;
        int i41;
        char cCharAt13;
        if (!(zzfzVar instanceof zzgl)) {
            throw null;
        }
        zzgl zzglVar = (zzgl) zzfzVar;
        String strZzd = zzglVar.zzd();
        int length = strZzd.length();
        char c11 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i42 = 1;
            while (true) {
                i11 = i42 + 1;
                if (strZzd.charAt(i42) < 55296) {
                    break;
                }
                i42 = i11;
            }
        } else {
            i11 = 1;
        }
        int i43 = i11 + 1;
        int iCharAt3 = strZzd.charAt(i11);
        if (iCharAt3 >= 55296) {
            int i44 = iCharAt3 & 8191;
            int i45 = 13;
            while (true) {
                i41 = i43 + 1;
                cCharAt13 = strZzd.charAt(i43);
                if (cCharAt13 < 55296) {
                    break;
                }
                i44 |= (cCharAt13 & 8191) << i45;
                i45 += 13;
                i43 = i41;
            }
            iCharAt3 = i44 | (cCharAt13 << i45);
            i43 = i41;
        }
        if (iCharAt3 == 0) {
            iArr = zza;
            i15 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i13 = 0;
            i16 = 0;
            i12 = 0;
            i14 = 0;
        } else {
            int i46 = i43 + 1;
            int iCharAt4 = strZzd.charAt(i43);
            if (iCharAt4 >= 55296) {
                int i47 = iCharAt4 & 8191;
                int i48 = 13;
                while (true) {
                    i25 = i46 + 1;
                    cCharAt8 = strZzd.charAt(i46);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt8 & 8191) << i48;
                    i48 += 13;
                    i46 = i25;
                }
                iCharAt4 = i47 | (cCharAt8 << i48);
                i46 = i25;
            }
            int i49 = i46 + 1;
            int iCharAt5 = strZzd.charAt(i46);
            if (iCharAt5 >= 55296) {
                int i50 = iCharAt5 & 8191;
                int i51 = 13;
                while (true) {
                    i24 = i49 + 1;
                    cCharAt7 = strZzd.charAt(i49);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt7 & 8191) << i51;
                    i51 += 13;
                    i49 = i24;
                }
                iCharAt5 = i50 | (cCharAt7 << i51);
                i49 = i24;
            }
            int i52 = i49 + 1;
            int iCharAt6 = strZzd.charAt(i49);
            if (iCharAt6 >= 55296) {
                int i53 = iCharAt6 & 8191;
                int i54 = 13;
                while (true) {
                    i23 = i52 + 1;
                    cCharAt6 = strZzd.charAt(i52);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt6 & 8191) << i54;
                    i54 += 13;
                    i52 = i23;
                }
                iCharAt6 = i53 | (cCharAt6 << i54);
                i52 = i23;
            }
            int i55 = i52 + 1;
            int iCharAt7 = strZzd.charAt(i52);
            if (iCharAt7 >= 55296) {
                int i56 = iCharAt7 & 8191;
                int i57 = 13;
                while (true) {
                    i22 = i55 + 1;
                    cCharAt5 = strZzd.charAt(i55);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt5 & 8191) << i57;
                    i57 += 13;
                    i55 = i22;
                }
                iCharAt7 = i56 | (cCharAt5 << i57);
                i55 = i22;
            }
            int i58 = i55 + 1;
            iCharAt = strZzd.charAt(i55);
            if (iCharAt >= 55296) {
                int i59 = iCharAt & 8191;
                int i60 = 13;
                while (true) {
                    i21 = i58 + 1;
                    cCharAt4 = strZzd.charAt(i58);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i59 |= (cCharAt4 & 8191) << i60;
                    i60 += 13;
                    i58 = i21;
                }
                iCharAt = i59 | (cCharAt4 << i60);
                i58 = i21;
            }
            int i61 = i58 + 1;
            iCharAt2 = strZzd.charAt(i58);
            if (iCharAt2 >= 55296) {
                int i62 = iCharAt2 & 8191;
                int i63 = 13;
                while (true) {
                    i19 = i61 + 1;
                    cCharAt3 = strZzd.charAt(i61);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i62 |= (cCharAt3 & 8191) << i63;
                    i63 += 13;
                    i61 = i19;
                }
                iCharAt2 = i62 | (cCharAt3 << i63);
                i61 = i19;
            }
            int i64 = i61 + 1;
            int iCharAt8 = strZzd.charAt(i61);
            if (iCharAt8 >= 55296) {
                int i65 = iCharAt8 & 8191;
                int i66 = 13;
                while (true) {
                    i18 = i64 + 1;
                    cCharAt2 = strZzd.charAt(i64);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i65 |= (cCharAt2 & 8191) << i66;
                    i66 += 13;
                    i64 = i18;
                }
                iCharAt8 = i65 | (cCharAt2 << i66);
                i64 = i18;
            }
            int i67 = i64 + 1;
            int iCharAt9 = strZzd.charAt(i64);
            if (iCharAt9 >= 55296) {
                int i68 = iCharAt9 & 8191;
                int i69 = 13;
                while (true) {
                    i17 = i67 + 1;
                    cCharAt = strZzd.charAt(i67);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i68 |= (cCharAt & 8191) << i69;
                    i69 += 13;
                    i67 = i17;
                }
                iCharAt9 = i68 | (cCharAt << i69);
                i67 = i17;
            }
            i12 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i13 = iCharAt6;
            i14 = iCharAt9;
            i15 = iCharAt4;
            i16 = iCharAt7;
            i43 = i67;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzglVar.zze();
        Class<?> cls2 = zzglVar.zza().getClass();
        int i70 = i14 + iCharAt2;
        int i71 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i71];
        int i72 = i14;
        int i73 = i70;
        int i74 = 0;
        int i75 = 0;
        while (i43 < length) {
            int i76 = i43 + 1;
            int iCharAt10 = strZzd.charAt(i43);
            if (iCharAt10 >= c11) {
                int i77 = iCharAt10 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i40 = i78 + 1;
                    cCharAt12 = strZzd.charAt(i78);
                    if (cCharAt12 < c11) {
                        break;
                    }
                    i77 |= (cCharAt12 & 8191) << i79;
                    i79 += 13;
                    i78 = i40;
                }
                iCharAt10 = i77 | (cCharAt12 << i79);
                i26 = i40;
            } else {
                i26 = i76;
            }
            int i80 = i26 + 1;
            int iCharAt11 = strZzd.charAt(i26);
            if (iCharAt11 >= c11) {
                int i81 = iCharAt11 & 8191;
                int i82 = i80;
                int i83 = 13;
                while (true) {
                    i39 = i82 + 1;
                    cCharAt11 = strZzd.charAt(i82);
                    if (cCharAt11 < c11) {
                        break;
                    }
                    i81 |= (cCharAt11 & 8191) << i83;
                    i83 += 13;
                    i82 = i39;
                }
                iCharAt11 = i81 | (cCharAt11 << i83);
                i27 = i39;
            } else {
                i27 = i80;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i74] = i75;
                i74++;
            }
            int i84 = iCharAt11 & 255;
            int i85 = iCharAt11 & 2048;
            int i86 = length;
            if (i84 >= 51) {
                int i87 = i27 + 1;
                int iCharAt12 = strZzd.charAt(i27);
                char c12 = 55296;
                if (iCharAt12 >= 55296) {
                    int i88 = 13;
                    int i89 = iCharAt12 & 8191;
                    int i90 = i87;
                    while (true) {
                        i38 = i90 + 1;
                        cCharAt10 = strZzd.charAt(i90);
                        if (cCharAt10 < c12) {
                            break;
                        }
                        i89 |= (cCharAt10 & 8191) << i88;
                        i88 += 13;
                        i90 = i38;
                        c12 = 55296;
                    }
                    iCharAt12 = i89 | (cCharAt10 << i88);
                    i34 = i38;
                } else {
                    i34 = i87;
                }
                int i91 = i34;
                int i92 = i84 - 51;
                if (i92 == 9 || i92 == 17) {
                    i35 = i12 + 1;
                    int i93 = i75 / 3;
                    objArr[i93 + i93 + 1] = objArrZze[i12];
                } else {
                    if (i92 == 12) {
                        if (zzglVar.zzc() == 1 || i85 != 0) {
                            i35 = i12 + 1;
                            int i94 = i75 / 3;
                            objArr[i94 + i94 + 1] = objArrZze[i12];
                        } else {
                            i85 = 0;
                        }
                    }
                    i36 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i36];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i36] = fieldZzz2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i37 = i36 + 1;
                    obj2 = objArrZze[i37];
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i37] = fieldZzz3;
                    }
                    zzglVar = zzglVar;
                    strZzd = strZzd;
                    i31 = i12;
                    i28 = i91;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i29 = 0;
                }
                i12 = i35;
                i36 = iCharAt12 + iCharAt12;
                obj = objArrZze[i36];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i36] = fieldZzz2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i37 = i36 + 1;
                obj2 = objArrZze[i37];
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i37] = fieldZzz3;
                }
                zzglVar = zzglVar;
                strZzd = strZzd;
                i31 = i12;
                i28 = i91;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz3);
                i29 = 0;
            } else {
                int i95 = i12 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i12]);
                if (i84 == 9 || i84 == 17) {
                    zzglVar = zzglVar;
                    int i96 = i75 / 3;
                    objArr[i96 + i96 + 1] = fieldZzz4.getType();
                } else {
                    if (i84 == 27) {
                        i32 = 1;
                        i33 = i12 + 2;
                    } else if (i84 == 49) {
                        i33 = i12 + 2;
                        i32 = 1;
                    } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                        zzglVar = zzglVar;
                        if (zzglVar.zzc() == 1 || i85 != 0) {
                            i33 = i12 + 2;
                            int i97 = i75 / 3;
                            objArr[i97 + i97 + 1] = objArrZze[i95];
                            i95 = i33;
                        } else {
                            i85 = 0;
                        }
                    } else {
                        if (i84 == 50) {
                            int i98 = i12 + 2;
                            int i99 = i72 + 1;
                            iArr[i72] = i75;
                            int i100 = i75 / 3;
                            int i101 = i100 + i100;
                            objArr[i101] = objArrZze[i95];
                            if (i85 != 0) {
                                i95 = i12 + 3;
                                objArr[i101 + 1] = objArrZze[i98];
                                i72 = i99;
                            } else {
                                i95 = i98;
                                i72 = i99;
                                i85 = 0;
                            }
                        }
                        zzglVar = zzglVar;
                    }
                    int i102 = i75 / 3;
                    objArr[i102 + i102 + i32] = objArrZze[i95];
                    i95 = i33;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i84 > 17) {
                    i28 = i27;
                    i29 = 0;
                } else {
                    int i103 = i27 + 1;
                    int iCharAt13 = strZzd.charAt(i27);
                    if (iCharAt13 >= 55296) {
                        int i104 = iCharAt13 & 8191;
                        int i105 = 13;
                        while (true) {
                            i28 = i103 + 1;
                            cCharAt9 = strZzd.charAt(i103);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i104 |= (cCharAt9 & 8191) << i105;
                            i105 += 13;
                            i103 = i28;
                        }
                        iCharAt13 = i104 | (cCharAt9 << i105);
                    } else {
                        i28 = i103;
                    }
                    int i106 = i15 + i15 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i106];
                    if (obj3 instanceof Field) {
                        fieldZzz = (Field) obj3;
                    } else {
                        fieldZzz = zzz(cls2, (String) obj3);
                        objArrZze[i106] = fieldZzz;
                    }
                    i29 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz);
                }
                if (i84 >= 18 && i84 <= 49) {
                    iArr[i73] = iObjectFieldOffset3;
                    i73++;
                }
                i31 = i95;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i107 = i75 + 1;
            iArr2[i75] = iCharAt10;
            int i108 = i75 + 2;
            iArr2[i107] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? ASTNode.DEOP : 0) | ((iCharAt11 & 512) != 0 ? ASTNode.DISCARD : 0) | (i85 != 0 ? Integer.MIN_VALUE : 0) | (i84 << 20);
            i75 += 3;
            iArr2[i108] = (i29 << 20) | iObjectFieldOffset;
            i12 = i31;
            i43 = i28;
            length = i86;
            zzglVar = zzglVar;
            strZzd = strZzd;
            i16 = i16;
            i13 = i13;
            c11 = 55296;
        }
        zzgl zzglVar2 = zzglVar;
        return new zzgf(iArr2, objArr, i13, i16, zzglVar2.zza(), zzglVar2.zzc(), false, iArr, i14, i70, zzghVar, zzfqVar, zzhdVar, zzekVar, zzfxVar);
    }

    private static double zzm(Object obj, long j11) {
        return ((Double) zzhn.zzf(obj, j11)).doubleValue();
    }

    private static float zzn(Object obj, long j11) {
        return ((Float) zzhn.zzf(obj, j11)).floatValue();
    }

    private static int zzo(Object obj, long j11) {
        return ((Integer) zzhn.zzf(obj, j11)).intValue();
    }

    private final int zzp(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzq(int i11, int i12) {
        int length = (this.zzc.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int i15 = this.zzc[i14];
            if (i11 == i15) {
                return i14;
            }
            if (i11 < i15) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzs(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzt(Object obj, long j11) {
        return ((Long) zzhn.zzf(obj, j11)).longValue();
    }

    private final zzfb zzu(int i11) {
        int i12 = i11 / 3;
        return (zzfb) this.zzd[i12 + i12 + 1];
    }

    private final zzgm zzv(int i11) {
        Object[] objArr = this.zzd;
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzgm zzgmVar = (zzgm) objArr[i13];
        if (zzgmVar != null) {
            return zzgmVar;
        }
        zzgm zzgmVarZzb = zzgk.zza().zzb((Class) objArr[i13 + 1]);
        this.zzd[i13] = zzgmVarZzb;
        return zzgmVarZzb;
    }

    private final Object zzw(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzx(Object obj, int i11) {
        zzgm zzgmVarZzv = zzv(i11);
        int iZzs = zzs(i11) & 1048575;
        if (!zzI(obj, i11)) {
            return zzgmVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgmVarZzv.zze();
        if (object != null) {
            zzgmVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i11, int i12) {
        zzgm zzgmVarZzv = zzv(i12);
        if (!zzM(obj, i11, i12)) {
            return zzgmVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i12) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgmVarZzv.zze();
        if (object != null) {
            zzgmVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0392  */
    /* JADX WARN: Code duplicated, block: B:180:0x048b  */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final int zza(Object obj) {
        int i11;
        int i12;
        int i13;
        int iZzx;
        int iZzx2;
        int iZzy;
        int iZzx3;
        int iZzx4;
        int iZzx5;
        int iZzx6;
        int iZzh;
        int iZzg;
        int size;
        int iZzx7;
        int iZzx8;
        int iZzx9;
        int iZze;
        int iZzx10;
        int iZzx11;
        int iZzt;
        Unsafe unsafe = zzb;
        boolean z11 = false;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.zzc.length) {
            int iZzs = zzs(i17);
            int iZzr = zzr(iZzs);
            int[] iArr = this.zzc;
            int i19 = iArr[i17];
            int i21 = iArr[i17 + 2];
            int i22 = i21 & i14;
            if (iZzr <= 17) {
                if (i22 != i15) {
                    i16 = i22 == i14 ? 0 : unsafe.getInt(obj, i22);
                    i15 = i22;
                }
                i13 = 1 << (i21 >>> 20);
                i11 = i15;
                i12 = i16;
            } else {
                i11 = i15;
                i12 = i16;
                i13 = 0;
            }
            int i23 = iZzs & i14;
            if (iZzr >= zzep.zzJ.zza()) {
                zzep.zzW.zza();
            }
            long j11 = i23;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx = zzee.zzx(i19 << 3);
                        iZzh = iZzx + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx2 = zzee.zzx(i19 << 3);
                        iZzh = iZzx2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzy = zzee.zzy(unsafe.getLong(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzy = zzee.zzy(unsafe.getLong(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzy = zzee.zzu(unsafe.getInt(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx = zzee.zzx(i19 << 3);
                        iZzh = iZzx + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx2 = zzee.zzx(i19 << 3);
                        iZzh = iZzx2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx4 = zzee.zzx(i19 << 3);
                        iZzh = iZzx4 + 1;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        int i24 = i19 << 3;
                        Object object = unsafe.getObject(obj, j11);
                        if (object instanceof zzdw) {
                            int i25 = zzee.zzb;
                            int iZzd = ((zzdw) object).zzd();
                            iZzx5 = zzee.zzx(iZzd) + iZzd;
                            iZzx6 = zzee.zzx(i24);
                            iZzh = iZzx6 + iZzx5;
                            i18 += iZzh;
                        } else {
                            iZzy = zzee.zzw((String) object);
                            iZzx3 = zzee.zzx(i24);
                            iZzh = iZzx3 + iZzy;
                            i18 += iZzh;
                        }
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzh = zzgo.zzh(i19, unsafe.getObject(obj, j11), zzv(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzdw zzdwVar = (zzdw) unsafe.getObject(obj, j11);
                        int i26 = zzee.zzb;
                        int iZzd2 = zzdwVar.zzd();
                        iZzx5 = zzee.zzx(iZzd2) + iZzd2;
                        iZzx6 = zzee.zzx(i19 << 3);
                        iZzh = iZzx6 + iZzx5;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzy = zzee.zzx(unsafe.getInt(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzy = zzee.zzu(unsafe.getInt(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx2 = zzee.zzx(i19 << 3);
                        iZzh = iZzx2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzx = zzee.zzx(i19 << 3);
                        iZzh = iZzx + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        int i27 = unsafe.getInt(obj, j11);
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzy = zzee.zzx((i27 >> 31) ^ (i27 + i27));
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        long j12 = unsafe.getLong(obj, j11);
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzy = zzee.zzy((j12 >> 63) ^ (j12 + j12));
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzh = zzee.zzt(i19, (zzgc) unsafe.getObject(obj, j11), zzv(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 18:
                    iZzh = zzgo.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 19:
                    iZzh = zzgo.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j11);
                    int i28 = zzgo.zza;
                    if (list.size() == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzgo.zzg(list) + (list.size() * zzee.zzx(i19 << 3));
                    }
                    i18 += iZzg;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j11);
                    int i29 = zzgo.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzx3 = zzgo.zzl(list2);
                        iZzx7 = zzee.zzx(i19 << 3);
                        iZzy = size * iZzx7;
                        iZzh = iZzx3 + iZzy;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i31 = zzgo.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzx3 = zzgo.zzf(list3);
                        iZzx7 = zzee.zzx(i19 << 3);
                        iZzy = size * iZzx7;
                        iZzh = iZzx3 + iZzy;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 23:
                    iZzh = zzgo.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 24:
                    iZzh = zzgo.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j11);
                    int i32 = zzgo.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = size2 * (zzee.zzx(i19 << 3) + 1);
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j11);
                    int i33 = zzgo.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzg = 0;
                    } else {
                        boolean z12 = list5 instanceof zzfk;
                        iZzg = zzee.zzx(i19 << 3) * size3;
                        if (z12) {
                            zzfk zzfkVar = (zzfk) list5;
                            for (int i34 = 0; i34 < size3; i34++) {
                                Object objZzf = zzfkVar.zzf(i34);
                                if (objZzf instanceof zzdw) {
                                    int iZzd3 = ((zzdw) objZzf).zzd();
                                    iZzg += zzee.zzx(iZzd3) + iZzd3;
                                } else {
                                    iZzg += zzee.zzw((String) objZzf);
                                }
                            }
                        } else {
                            for (int i35 = 0; i35 < size3; i35++) {
                                Object obj2 = list5.get(i35);
                                if (obj2 instanceof zzdw) {
                                    int iZzd4 = ((zzdw) obj2).zzd();
                                    iZzg += zzee.zzx(iZzd4) + iZzd4;
                                } else {
                                    iZzg += zzee.zzw((String) obj2);
                                }
                            }
                        }
                    }
                    i18 += iZzg;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j11);
                    zzgm zzgmVarZzv = zzv(i17);
                    int i36 = zzgo.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzx8 = 0;
                    } else {
                        iZzx8 = zzee.zzx(i19 << 3) * size4;
                        for (int i37 = 0; i37 < size4; i37++) {
                            Object obj3 = list6.get(i37);
                            if (obj3 instanceof zzfi) {
                                int iZza = ((zzfi) obj3).zza();
                                iZzx8 += zzee.zzx(iZza) + iZza;
                            } else {
                                iZzx8 += zzee.zzv((zzgc) obj3, zzgmVarZzv);
                            }
                        }
                    }
                    i18 += iZzx8;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j11);
                    int i38 = zzgo.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzx9 = 0;
                    } else {
                        iZzx9 = size5 * zzee.zzx(i19 << 3);
                        for (int i39 = 0; i39 < list7.size(); i39++) {
                            int iZzd5 = ((zzdw) list7.get(i39)).zzd();
                            iZzx9 += zzee.zzx(iZzd5) + iZzd5;
                        }
                    }
                    i18 += iZzx9;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    List list8 = (List) unsafe.getObject(obj, j11);
                    int i40 = zzgo.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzx3 = zzgo.zzk(list8);
                        iZzx7 = zzee.zzx(i19 << 3);
                        iZzy = size * iZzx7;
                        iZzh = iZzx3 + iZzy;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j11);
                    int i41 = zzgo.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzx3 = zzgo.zza(list9);
                        iZzx7 = zzee.zzx(i19 << 3);
                        iZzy = size * iZzx7;
                        iZzh = iZzx3 + iZzy;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iZzh = zzgo.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 32:
                    iZzh = zzgo.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j11);
                    int i42 = zzgo.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzx3 = zzgo.zzi(list10);
                        iZzx7 = zzee.zzx(i19 << 3);
                        iZzy = size * iZzx7;
                        iZzh = iZzx3 + iZzy;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j11);
                    int i43 = zzgo.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzx3 = zzgo.zzj(list11);
                        iZzx7 = zzee.zzx(i19 << 3);
                        iZzy = size * iZzx7;
                        iZzh = iZzx3 + iZzy;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 35:
                    iZze = zzgo.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 36:
                    iZze = zzgo.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 37:
                    iZze = zzgo.zzg((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 38:
                    iZze = zzgo.zzl((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 39:
                    iZze = zzgo.zzf((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 40:
                    iZze = zzgo.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 41:
                    iZze = zzgo.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list12 = (List) unsafe.getObject(obj, j11);
                    int i44 = zzgo.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZze = zzgo.zzk((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZze = zzgo.zza((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZze = zzgo.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZze = zzgo.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZze = zzgo.zzi((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 48:
                    iZze = zzgo.zzj((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzx10 = zzee.zzx(iZze);
                        iZzx11 = zzee.zzx(i19 << 3);
                        iZzx9 = iZzx11 + iZzx10 + iZze;
                        i18 += iZzx9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j11);
                    zzgm zzgmVarZzv2 = zzv(i17);
                    int i45 = zzgo.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzt = 0;
                    } else {
                        iZzt = 0;
                        for (int i46 = 0; i46 < size6; i46++) {
                            iZzt += zzee.zzt(i19, (zzgc) list13.get(i46), zzgmVarZzv2);
                        }
                    }
                    i18 += iZzt;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 50:
                    zzfw zzfwVar = (zzfw) unsafe.getObject(obj, j11);
                    if (zzfwVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzfwVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                case 51:
                    if (zzM(obj, i19, i17)) {
                        iZzx = zzee.zzx(i19 << 3);
                        iZzh = iZzx + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i19, i17)) {
                        iZzx2 = zzee.zzx(i19 << 3);
                        iZzh = iZzx2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 53:
                    if (zzM(obj, i19, i17)) {
                        iZzy = zzee.zzy(zzt(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 54:
                    if (zzM(obj, i19, i17)) {
                        iZzy = zzee.zzy(zzt(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 55:
                    if (zzM(obj, i19, i17)) {
                        iZzy = zzee.zzu(zzo(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i19, i17)) {
                        iZzx = zzee.zzx(i19 << 3);
                        iZzh = iZzx + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzM(obj, i19, i17)) {
                        iZzx2 = zzee.zzx(i19 << 3);
                        iZzh = iZzx2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 58:
                    if (zzM(obj, i19, i17)) {
                        iZzx4 = zzee.zzx(i19 << 3);
                        iZzh = iZzx4 + 1;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 59:
                    if (zzM(obj, i19, i17)) {
                        int i47 = i19 << 3;
                        Object object2 = unsafe.getObject(obj, j11);
                        if (object2 instanceof zzdw) {
                            int i48 = zzee.zzb;
                            int iZzd6 = ((zzdw) object2).zzd();
                            iZzx5 = zzee.zzx(iZzd6) + iZzd6;
                            iZzx6 = zzee.zzx(i47);
                            iZzh = iZzx6 + iZzx5;
                            i18 += iZzh;
                        } else {
                            iZzy = zzee.zzw((String) object2);
                            iZzx3 = zzee.zzx(i47);
                            iZzh = iZzx3 + iZzy;
                            i18 += iZzh;
                        }
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 60:
                    if (zzM(obj, i19, i17)) {
                        iZzh = zzgo.zzh(i19, unsafe.getObject(obj, j11), zzv(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 61:
                    if (zzM(obj, i19, i17)) {
                        zzdw zzdwVar2 = (zzdw) unsafe.getObject(obj, j11);
                        int i49 = zzee.zzb;
                        int iZzd7 = zzdwVar2.zzd();
                        iZzx5 = zzee.zzx(iZzd7) + iZzd7;
                        iZzx6 = zzee.zzx(i19 << 3);
                        iZzh = iZzx6 + iZzx5;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 62:
                    if (zzM(obj, i19, i17)) {
                        iZzy = zzee.zzx(zzo(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 63:
                    if (zzM(obj, i19, i17)) {
                        iZzy = zzee.zzu(zzo(obj, j11));
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i19, i17)) {
                        iZzx2 = zzee.zzx(i19 << 3);
                        iZzh = iZzx2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i19, i17)) {
                        iZzx = zzee.zzx(i19 << 3);
                        iZzh = iZzx + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 66:
                    if (zzM(obj, i19, i17)) {
                        int iZzo = zzo(obj, j11);
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzy = zzee.zzx((iZzo >> 31) ^ (iZzo + iZzo));
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj, i19, i17)) {
                        long jZzt = zzt(obj, j11);
                        iZzx3 = zzee.zzx(i19 << 3);
                        iZzy = zzee.zzy((jZzt >> 63) ^ (jZzt + jZzt));
                        iZzh = iZzx3 + iZzy;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 68:
                    if (zzM(obj, i19, i17)) {
                        iZzh = zzee.zzt(i19, (zzgc) unsafe.getObject(obj, j11), zzv(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                default:
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
            }
        }
        zzhd zzhdVar = this.zzm;
        int iZza2 = i18 + zzhdVar.zza(zzhdVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        this.zzn.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final int zzb(Object obj) {
        int i11;
        long jDoubleToLongBits;
        int i12;
        int iFloatToIntBits;
        int i13;
        int i14 = 0;
        for (int i15 = 0; i15 < this.zzc.length; i15 += 3) {
            int iZzs = zzs(i15);
            int[] iArr = this.zzc;
            int i16 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i17 = iArr[i15];
            long j11 = i16;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i11 = i14 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhn.zza(obj, j11));
                    byte[] bArr = zzfd.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i12 = i14 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhn.zzb(obj, j11));
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 2:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr2 = zzfd.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr3 = zzfd.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 5:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr4 = zzfd.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 7:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzfd.zza(zzhn.zzw(obj, j11));
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 8:
                    i12 = i14 * 53;
                    iFloatToIntBits = ((String) zzhn.zzf(obj, j11)).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 9:
                    i13 = i14 * 53;
                    Object objZzf = zzhn.zzf(obj, j11);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i14 = i13 + iHashCode;
                    break;
                case 10:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzf(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 11:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 12:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 13:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 14:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr5 = zzfd.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 16:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhn.zzd(obj, j11);
                    byte[] bArr6 = zzfd.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i13 = i14 * 53;
                    Object objZzf2 = zzhn.zzf(obj, j11);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i14 = i13 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
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
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzf(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 50:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhn.zzf(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j11));
                        byte[] bArr7 = zzfd.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j11));
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzt(obj, j11);
                        byte[] bArr8 = zzfd.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzt(obj, j11);
                        byte[] bArr9 = zzfd.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzo(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzt(obj, j11);
                        byte[] bArr10 = zzfd.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzo(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzfd.zza(zzN(obj, j11));
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = ((String) zzhn.zzf(obj, j11)).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhn.zzf(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhn.zzf(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzo(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzo(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzo(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzt(obj, j11);
                        byte[] bArr11 = zzfd.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzo(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzt(obj, j11);
                        byte[] bArr12 = zzfd.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhn.zzf(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i14 * 53) + this.zzm.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:105:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:110:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:119:0x0324  */
    /* JADX WARN: Code duplicated, block: B:121:0x032d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0331  */
    /* JADX WARN: Code duplicated, block: B:125:0x0335  */
    /* JADX WARN: Code duplicated, block: B:135:0x0372  */
    /* JADX WARN: Code duplicated, block: B:136:0x0374  */
    /* JADX WARN: Code duplicated, block: B:163:0x0488  */
    /* JADX WARN: Code duplicated, block: B:165:0x048e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0491  */
    /* JADX WARN: Code duplicated, block: B:174:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:176:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:177:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:181:0x050b  */
    /* JADX WARN: Code duplicated, block: B:183:0x050e  */
    /* JADX WARN: Code duplicated, block: B:185:0x052c  */
    /* JADX WARN: Code duplicated, block: B:187:0x0536 A[LOOP:2: B:184:0x052a->B:187:0x0536, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:192:0x055a  */
    /* JADX WARN: Code duplicated, block: B:194:0x0565  */
    /* JADX WARN: Code duplicated, block: B:196:0x056c  */
    /* JADX WARN: Code duplicated, block: B:198:0x0577 A[LOOP:3: B:197:0x0575->B:198:0x0577, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:203:0x058d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:204:0x058f  */
    /* JADX WARN: Code duplicated, block: B:206:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:208:0x05a8 A[LOOP:4: B:205:0x059e->B:208:0x05a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:211:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:213:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:215:0x05ce A[LOOP:5: B:214:0x05cc->B:215:0x05ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:220:0x05e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:223:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:225:0x0600 A[LOOP:6: B:222:0x05f6->B:225:0x0600, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:226:0x060e  */
    /* JADX WARN: Code duplicated, block: B:228:0x0615  */
    /* JADX WARN: Code duplicated, block: B:229:0x061a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:230:0x061c  */
    /* JADX WARN: Code duplicated, block: B:233:0x0633  */
    /* JADX WARN: Code duplicated, block: B:235:0x0637  */
    /* JADX WARN: Code duplicated, block: B:237:0x0641  */
    /* JADX WARN: Code duplicated, block: B:239:0x0653 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:240:0x0655  */
    /* JADX WARN: Code duplicated, block: B:242:0x0661  */
    /* JADX WARN: Code duplicated, block: B:246:0x0676  */
    /* JADX WARN: Code duplicated, block: B:247:0x067e  */
    /* JADX WARN: Code duplicated, block: B:250:0x068e  */
    /* JADX WARN: Code duplicated, block: B:253:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:256:0x06b2  */
    /* JADX WARN: Code duplicated, block: B:257:0x06b6  */
    /* JADX WARN: Code duplicated, block: B:259:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:261:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:263:0x06cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:264:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:265:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:268:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:270:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:272:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:274:0x06f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:286:0x0718  */
    /* JADX WARN: Code duplicated, block: B:287:0x071e  */
    /* JADX WARN: Code duplicated, block: B:289:0x0727  */
    /* JADX WARN: Code duplicated, block: B:291:0x074e  */
    /* JADX WARN: Code duplicated, block: B:292:0x0755  */
    /* JADX WARN: Code duplicated, block: B:294:0x0764  */
    /* JADX WARN: Code duplicated, block: B:296:0x076d  */
    /* JADX WARN: Code duplicated, block: B:298:0x0775 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:299:0x0777  */
    /* JADX WARN: Code duplicated, block: B:300:0x077b  */
    /* JADX WARN: Code duplicated, block: B:303:0x0788  */
    /* JADX WARN: Code duplicated, block: B:305:0x0790  */
    /* JADX WARN: Code duplicated, block: B:307:0x0798 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:315:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:317:0x07c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:318:0x07c4  */
    /* JADX WARN: Code duplicated, block: B:319:0x07c8  */
    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    /* JADX WARN: Code duplicated, block: B:321:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:324:0x07dd  */
    /* JADX WARN: Code duplicated, block: B:326:0x07e5  */
    /* JADX WARN: Code duplicated, block: B:328:0x07ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:332:0x07fb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:341:0x081a A[PHI: r1 r3 r4 r5 r7 r13 r14
  0x081a: PHI (r1v115 sun.misc.Unsafe) = 
  (r1v105 sun.misc.Unsafe)
  (r1v108 sun.misc.Unsafe)
  (r1v111 sun.misc.Unsafe)
  (r1v113 sun.misc.Unsafe)
  (r1v118 sun.misc.Unsafe)
 binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]
  0x081a: PHI (r3v52 int) = (r3v47 int), (r3v48 int), (r3v50 int), (r3v51 int), (r3v54 int) binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]
  0x081a: PHI (r4v31 int) = (r4v25 int), (r4v27 int), (r4v29 int), (r4v30 int), (r4v33 int) binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]
  0x081a: PHI (r5v59 int) = (r5v53 int), (r5v55 int), (r5v57 int), (r5v58 int), (r5v61 int) binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]
  0x081a: PHI (r7v15 int) = (r7v10 int), (r7v11 int), (r7v13 int), (r7v14 int), (r7v17 int) binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]
  0x081a: PHI (r13v52 com.google.android.gms.internal.play_billing.zzdj) = 
  (r13v47 com.google.android.gms.internal.play_billing.zzdj)
  (r13v48 com.google.android.gms.internal.play_billing.zzdj)
  (r13v50 com.google.android.gms.internal.play_billing.zzdj)
  (r13v51 com.google.android.gms.internal.play_billing.zzdj)
  (r13v54 com.google.android.gms.internal.play_billing.zzdj)
 binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]
  0x081a: PHI (r14v45 byte[]) = (r14v40 byte[]), (r14v41 byte[]), (r14v43 byte[]), (r14v44 byte[]), (r14v47 byte[]) binds: [B:405:0x0937, B:396:0x0902, B:379:0x08af, B:355:0x0853, B:293:0x0762] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:342:0x0820  */
    /* JADX WARN: Code duplicated, block: B:344:0x082e  */
    /* JADX WARN: Code duplicated, block: B:346:0x0839  */
    /* JADX WARN: Code duplicated, block: B:348:0x0843  */
    /* JADX WARN: Code duplicated, block: B:349:0x0845  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:355:0x0853 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:356:0x0855  */
    /* JADX WARN: Code duplicated, block: B:358:0x0861  */
    /* JADX WARN: Code duplicated, block: B:359:0x0863  */
    /* JADX WARN: Code duplicated, block: B:362:0x0869  */
    /* JADX WARN: Code duplicated, block: B:364:0x0871  */
    /* JADX WARN: Code duplicated, block: B:366:0x087b  */
    /* JADX WARN: Code duplicated, block: B:367:0x087d  */
    /* JADX WARN: Code duplicated, block: B:369:0x0882  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:371:0x0890  */
    /* JADX WARN: Code duplicated, block: B:373:0x089b A[LOOP:14: B:372:0x0899->B:373:0x089b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:378:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:380:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:382:0x08be  */
    /* JADX WARN: Code duplicated, block: B:384:0x08c6 A[LOOP:15: B:381:0x08bc->B:384:0x08c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:386:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:388:0x08e3  */
    /* JADX WARN: Code duplicated, block: B:390:0x08ee A[LOOP:16: B:389:0x08ec->B:390:0x08ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:395:0x0901  */
    /* JADX WARN: Code duplicated, block: B:397:0x0904  */
    /* JADX WARN: Code duplicated, block: B:399:0x0911  */
    /* JADX WARN: Code duplicated, block: B:401:0x0919 A[LOOP:17: B:398:0x090f->B:401:0x0919, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:402:0x0923  */
    /* JADX WARN: Code duplicated, block: B:404:0x0931  */
    /* JADX WARN: Code duplicated, block: B:405:0x0937 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:406:0x0939  */
    /* JADX WARN: Code duplicated, block: B:407:0x094b  */
    /* JADX WARN: Code duplicated, block: B:409:0x0957  */
    /* JADX WARN: Code duplicated, block: B:411:0x0962 A[LOOP:18: B:410:0x0960->B:411:0x0962, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:416:0x0975 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:417:0x0977  */
    /* JADX WARN: Code duplicated, block: B:419:0x0984  */
    /* JADX WARN: Code duplicated, block: B:421:0x098c A[LOOP:19: B:418:0x0982->B:421:0x098c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:422:0x0996  */
    /* JADX WARN: Code duplicated, block: B:424:0x09a2  */
    /* JADX WARN: Code duplicated, block: B:426:0x09ad A[LOOP:20: B:425:0x09ab->B:426:0x09ad, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:431:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:433:0x09c7  */
    /* JADX WARN: Code duplicated, block: B:435:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:437:0x09e0 A[LOOP:21: B:434:0x09d6->B:437:0x09e0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:438:0x09ee  */
    /* JADX WARN: Code duplicated, block: B:440:0x09fa  */
    /* JADX WARN: Code duplicated, block: B:442:0x0a05 A[LOOP:22: B:441:0x0a03->B:442:0x0a05, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:447:0x0a1b  */
    /* JADX WARN: Code duplicated, block: B:449:0x0a1e  */
    /* JADX WARN: Code duplicated, block: B:451:0x0a2f  */
    /* JADX WARN: Code duplicated, block: B:453:0x0a37 A[LOOP:23: B:450:0x0a2d->B:453:0x0a37, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:454:0x0a45 A[PHI: r0 r7 r8 r9 r10 r12 r13 r14
  0x0a45: PHI (r0v28 com.google.android.gms.internal.play_billing.zzgf<T>) = 
  (r0v1 com.google.android.gms.internal.play_billing.zzgf<T>)
  (r0v1 com.google.android.gms.internal.play_billing.zzgf<T>)
  (r0v1 com.google.android.gms.internal.play_billing.zzgf<T>)
  (r0v1 com.google.android.gms.internal.play_billing.zzgf<T>)
  (r0v29 com.google.android.gms.internal.play_billing.zzgf<T>)
 binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r7v27 int) = (r7v7 int), (r7v8 int), (r7v9 int), (r7v15 int), (r7v28 int) binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r8v102 int) = (r8v69 int), (r8v69 int), (r8v69 int), (r8v88 int), (r8v69 int) binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r9v75 int) = (r9v46 int), (r9v47 int), (r9v48 int), (r9v52 int), (r9v76 int) binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r10v60 int) = (r10v45 int), (r10v45 int), (r10v45 int), (r10v49 int), (r10v45 int) binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r12v60 sun.misc.Unsafe) = 
  (r12v48 sun.misc.Unsafe)
  (r12v49 sun.misc.Unsafe)
  (r12v50 sun.misc.Unsafe)
  (r12v53 sun.misc.Unsafe)
  (r12v61 sun.misc.Unsafe)
 binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r13v67 com.google.android.gms.internal.play_billing.zzdj) = 
  (r13v44 com.google.android.gms.internal.play_billing.zzdj)
  (r13v45 com.google.android.gms.internal.play_billing.zzdj)
  (r13v46 com.google.android.gms.internal.play_billing.zzdj)
  (r13v52 com.google.android.gms.internal.play_billing.zzdj)
  (r12v47 com.google.android.gms.internal.play_billing.zzdj)
 binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]
  0x0a45: PHI (r14v58 byte[]) = (r14v37 byte[]), (r14v38 byte[]), (r14v39 byte[]), (r14v45 byte[]), (r14v59 byte[]) binds: [B:448:0x0a1c, B:432:0x09c5, B:416:0x0975, B:341:0x081a, B:193:0x0561] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:465:0x0a8e  */
    /* JADX WARN: Code duplicated, block: B:468:0x0a9f  */
    /* JADX WARN: Code duplicated, block: B:470:0x0aad  */
    /* JADX WARN: Code duplicated, block: B:472:0x0ac1  */
    /* JADX WARN: Code duplicated, block: B:473:0x0ad2  */
    /* JADX WARN: Code duplicated, block: B:475:0x0ad5  */
    /* JADX WARN: Code duplicated, block: B:477:0x0b07  */
    /* JADX WARN: Code duplicated, block: B:478:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:480:0x0b29  */
    /* JADX WARN: Code duplicated, block: B:484:0x0b4d  */
    /* JADX WARN: Code duplicated, block: B:486:0x0b5e  */
    /* JADX WARN: Code duplicated, block: B:487:0x0b73  */
    /* JADX WARN: Code duplicated, block: B:489:0x0b84  */
    /* JADX WARN: Code duplicated, block: B:493:0x0b96  */
    /* JADX WARN: Code duplicated, block: B:497:0x0bba  */
    /* JADX WARN: Code duplicated, block: B:499:0x0bc3  */
    /* JADX WARN: Code duplicated, block: B:501:0x0bd4  */
    /* JADX WARN: Code duplicated, block: B:502:0x0be1  */
    /* JADX WARN: Code duplicated, block: B:504:0x0bee  */
    /* JADX WARN: Code duplicated, block: B:505:0x0c12  */
    /* JADX WARN: Code duplicated, block: B:506:0x0c17  */
    /* JADX WARN: Code duplicated, block: B:508:0x0c29  */
    /* JADX WARN: Code duplicated, block: B:510:0x0c31  */
    /* JADX WARN: Code duplicated, block: B:511:0x0c39  */
    /* JADX WARN: Code duplicated, block: B:520:0x0c61  */
    /* JADX WARN: Code duplicated, block: B:521:0x0c65  */
    /* JADX WARN: Code duplicated, block: B:523:0x0c77  */
    /* JADX WARN: Code duplicated, block: B:525:0x0c82  */
    /* JADX WARN: Code duplicated, block: B:526:0x0c84  */
    /* JADX WARN: Code duplicated, block: B:529:0x0c92  */
    /* JADX WARN: Code duplicated, block: B:531:0x0ca5  */
    /* JADX WARN: Code duplicated, block: B:532:0x0cb7  */
    /* JADX WARN: Code duplicated, block: B:534:0x0cca  */
    /* JADX WARN: Code duplicated, block: B:535:0x0cdc  */
    /* JADX WARN: Code duplicated, block: B:537:0x0cee  */
    /* JADX WARN: Code duplicated, block: B:538:0x0d00  */
    /* JADX WARN: Code duplicated, block: B:540:0x0d12  */
    /* JADX WARN: Code duplicated, block: B:541:0x0d25  */
    /* JADX WARN: Code duplicated, block: B:543:0x0d38  */
    /* JADX WARN: Code duplicated, block: B:544:0x0d4d  */
    /* JADX WARN: Code duplicated, block: B:546:0x0d60  */
    /* JADX WARN: Code duplicated, block: B:547:0x0d75 A[PHI: r5 r7 r8 r13 r14 r15 r20 r35
  0x0d75: PHI (r5v102 int) = 
  (r5v76 int)
  (r5v77 int)
  (r5v78 int)
  (r5v79 int)
  (r5v80 int)
  (r5v81 int)
  (r5v83 int)
  (r5v84 int)
  (r5v89 int)
  (r5v93 int)
  (r5v98 int)
  (r5v103 int)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r7v63 java.lang.Object) = 
  (r7v40 java.lang.Object)
  (r7v41 java.lang.Object)
  (r7v42 java.lang.Object)
  (r7v43 java.lang.Object)
  (r7v44 java.lang.Object)
  (r7v45 java.lang.Object)
  (r7v47 java.lang.Object)
  (r7v48 java.lang.Object)
  (r7v51 java.lang.Object)
  (r7v55 java.lang.Object)
  (r7v60 java.lang.Object)
  (r7v64 java.lang.Object)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r8v132 int) = 
  (r8v106 int)
  (r8v107 int)
  (r8v108 int)
  (r8v109 int)
  (r8v110 int)
  (r8v111 int)
  (r8v113 int)
  (r8v114 int)
  (r8v117 int)
  (r8v121 int)
  (r8v126 int)
  (r8v133 int)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r13v115 byte[]) = 
  (r13v82 byte[])
  (r13v83 byte[])
  (r13v84 byte[])
  (r13v85 byte[])
  (r13v86 byte[])
  (r13v87 byte[])
  (r13v89 byte[])
  (r13v90 byte[])
  (r13v96 byte[])
  (r13v103 byte[])
  (r13v110 byte[])
  (r13v116 byte[])
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r14v91 int) = 
  (r14v65 int)
  (r14v66 int)
  (r14v67 int)
  (r14v68 int)
  (r14v69 int)
  (r14v70 int)
  (r14v72 int)
  (r14v73 int)
  (r14v76 int)
  (r14v83 int)
  (r14v87 int)
  (r14v92 int)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r15v63 com.google.android.gms.internal.play_billing.zzdj) = 
  (r15v39 com.google.android.gms.internal.play_billing.zzdj)
  (r15v40 com.google.android.gms.internal.play_billing.zzdj)
  (r15v41 com.google.android.gms.internal.play_billing.zzdj)
  (r15v42 com.google.android.gms.internal.play_billing.zzdj)
  (r15v43 com.google.android.gms.internal.play_billing.zzdj)
  (r15v44 com.google.android.gms.internal.play_billing.zzdj)
  (r15v46 com.google.android.gms.internal.play_billing.zzdj)
  (r15v47 com.google.android.gms.internal.play_billing.zzdj)
  (r15v50 com.google.android.gms.internal.play_billing.zzdj)
  (r15v54 com.google.android.gms.internal.play_billing.zzdj)
  (r15v59 com.google.android.gms.internal.play_billing.zzdj)
  (r15v64 com.google.android.gms.internal.play_billing.zzdj)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r20v34 int) = 
  (r20v8 int)
  (r20v9 int)
  (r20v10 int)
  (r20v11 int)
  (r20v12 int)
  (r20v13 int)
  (r20v15 int)
  (r20v16 int)
  (r20v21 int)
  (r20v25 int)
  (r20v31 int)
  (r20v35 int)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]
  0x0d75: PHI (r35v53 sun.misc.Unsafe) = 
  (r35v33 sun.misc.Unsafe)
  (r35v34 sun.misc.Unsafe)
  (r35v35 sun.misc.Unsafe)
  (r35v36 sun.misc.Unsafe)
  (r35v37 sun.misc.Unsafe)
  (r35v38 sun.misc.Unsafe)
  (r35v40 sun.misc.Unsafe)
  (r35v41 sun.misc.Unsafe)
  (r35v44 sun.misc.Unsafe)
  (r35v46 sun.misc.Unsafe)
  (r35v50 sun.misc.Unsafe)
  (r35v54 sun.misc.Unsafe)
 binds: [B:545:0x0d5e, B:542:0x0d36, B:539:0x0d10, B:536:0x0cec, B:533:0x0cc8, B:530:0x0ca3, B:522:0x0c75, B:520:0x0c61, B:498:0x0bbc, B:483:0x0b49, B:477:0x0b07, B:472:0x0ac1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:596:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0200 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x022f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x0367 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x038d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x03ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x03f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0419 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x043d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x047c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0588 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x05e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0713 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x070e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0706 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0701 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x07b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x07a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x0815 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0810 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x080b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x0806 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x084e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x08a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x08fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x0970 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x09bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0a16 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0a48 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0a79 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0d78 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x01c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x021c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x0354 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0379 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0398 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x03bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x03de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0405 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:650:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x031f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x02fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x02c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x02e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x04d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x04c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x0479 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0a6d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x0a5a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x0d8c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x04e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x0a76 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x054d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:695:0x0551 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x0551 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:0x069e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x0688 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x06f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:709:0x070b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:710:0x06f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x07ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x079e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:0x079a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x07ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x07f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:726:0x07ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:735:0x07ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:740:0x08d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:742:0x08d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:746:0x0a46 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:749:0x0a46 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:752:0x0a46 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:754:0x0269 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:756:0x028f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:757:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:758:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:759:0x02ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0233  */
    /* JADX WARN: Code duplicated, block: B:760:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:765:0x0269 A[EDGE_INSN: B:765:0x0269->B:761:0x0269 BREAK  A[LOOP:26: B:90:0x027c->B:93:0x0286], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x023d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x023f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0246  */
    /* JADX WARN: Code duplicated, block: B:81:0x0251  */
    /* JADX WARN: Code duplicated, block: B:83:0x0258  */
    /* JADX WARN: Code duplicated, block: B:85:0x0260 A[LOOP:24: B:82:0x0256->B:85:0x0260, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x026b  */
    /* JADX WARN: Code duplicated, block: B:91:0x027e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0286 A[LOOP:26: B:90:0x027c->B:93:0x0286, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:97:0x0297  */
    public final int zzc(Object obj, byte[] bArr, int i11, int i12, int i13, zzdj zzdjVar) throws IOException {
        Unsafe unsafe;
        int i14;
        int iZzi;
        int i15;
        int i16;
        int iZzq;
        int i17;
        byte[] bArr2;
        zzdj zzdjVar2;
        int i18;
        int i19;
        int i21;
        int iZzg;
        zzej zzejVar;
        int i22;
        int[] iArr;
        int i23;
        int iZzr;
        long j11;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i31;
        int i32;
        int i33;
        int i34;
        byte[] bArr3;
        zzdj zzdjVar3;
        Unsafe unsafe2;
        int iZzh;
        int i35;
        boolean z11;
        int i36;
        int i37;
        int iZzh2;
        int i38;
        int length;
        int i39;
        char[] cArr;
        int i40;
        int i41;
        int i42;
        byte b11;
        byte b12;
        int i43;
        byte b13;
        int iZzm;
        int i44;
        int i45;
        zzdj zzdjVar4;
        int i46;
        int i47;
        Unsafe unsafe3;
        int i48;
        Unsafe unsafe4;
        int i49;
        int i50;
        byte[] bArr4;
        int i51;
        zzfc zzfcVarZzd;
        int size;
        int i52;
        long j12;
        Unsafe unsafe5;
        zzfc zzfcVarZzd2;
        zzfc zzfcVar;
        int i53;
        Unsafe unsafe6;
        int iZzh3;
        zzeg zzegVar;
        int iZzh4;
        zzeg zzegVar2;
        int i54;
        zzeq zzeqVar;
        int iZzh5;
        zzeq zzeqVar2;
        int i55;
        zzfr zzfrVar;
        int iZzh6;
        zzfr zzfrVar2;
        int i56;
        Unsafe unsafe7;
        int i57;
        int i58;
        int i59;
        int iZzf;
        int iZze;
        zzfr zzfrVar3;
        int iZzh7;
        zzfr zzfrVar4;
        int i60;
        zzey zzeyVar;
        int iZzh8;
        zzey zzeyVar2;
        int i61;
        zzdl zzdlVar;
        boolean z12;
        int iZzh9;
        boolean z13;
        zzdl zzdlVar2;
        int i62;
        boolean z14;
        int i63;
        int i64;
        int iZzh10;
        int i65;
        int i66;
        int i67;
        int iZzh11;
        int i68;
        byte[] bArr5;
        int i69;
        int iZzh12;
        int i70;
        int i71;
        int iZzj;
        zzfb zzfbVarZzu;
        zzhd zzhdVar;
        int i72;
        int i73;
        Iterator it;
        Object objZzo;
        int iIntValue;
        int size2;
        Object objZzo2;
        int i74;
        int i75;
        int iIntValue2;
        int i76;
        zzey zzeyVar3;
        int iZzh13;
        zzey zzeyVar4;
        int i77;
        zzfr zzfrVar5;
        int iZzh14;
        zzfr zzfrVar6;
        int i78;
        int i79;
        zzgm zzgmVarZzv;
        int iZzh15;
        int size3;
        int i80;
        Unsafe unsafe8;
        Object object;
        Unsafe unsafe9;
        long j13;
        int i81;
        int i82;
        int iZzh16;
        int iZzk;
        boolean z15;
        int iZzh17;
        int i83;
        int i84;
        int i85;
        Unsafe unsafe10;
        byte[] bArr6;
        int i86;
        int iZza;
        int i87;
        zzfb zzfbVarZzu2;
        Unsafe unsafe11;
        byte[] bArr7;
        int i88;
        int iZzh18;
        zzgf<T> zzgfVar = this;
        Object obj2 = obj;
        byte[] bArr8 = bArr;
        i12 = i12;
        i13 = i13;
        zzdj zzdjVar5 = zzdjVar;
        zzA(obj);
        Unsafe unsafe12 = zzb;
        int i89 = 0;
        int iZzl = i11;
        int i90 = -1;
        int i91 = 0;
        int i92 = 0;
        int i93 = 0;
        int i94 = 1048575;
        while (true) {
            if (iZzl < i12) {
                int i95 = iZzl + 1;
                byte b14 = bArr8[iZzl];
                if (b14 < 0) {
                    iZzi = zzdk.zzi(b14, bArr8, i95, zzdjVar5);
                    i14 = zzdjVar5.zza;
                } else {
                    i14 = b14;
                    iZzi = i95;
                }
                int i96 = i14 >>> 3;
                if (i96 > i90) {
                    iZzq = (i96 < zzgfVar.zze || i96 > zzgfVar.zzf) ? -1 : zzgfVar.zzq(i96, i91 / 3);
                } else {
                    if (i96 < zzgfVar.zze || i96 > zzgfVar.zzf) {
                        i15 = -1;
                        i16 = -1;
                    } else {
                        iZzq = zzgfVar.zzq(i96, i89);
                    }
                    if (i16 == i15) {
                        i22 = i14 & 7;
                        iArr = zzgfVar.zzc;
                        i23 = iArr[i16 + 1];
                        iZzr = zzr(i23);
                        j11 = i23 & 1048575;
                        i24 = iZzi;
                        if (iZzr <= 17) {
                            int i97 = iArr[i16 + 2];
                            i25 = 1 << (i97 >>> 20);
                            i26 = 1048575;
                            i27 = i97 & 1048575;
                            if (i27 != i94) {
                                if (i94 != 1048575) {
                                    unsafe12.putInt(obj2, i94, i93);
                                    i26 = 1048575;
                                }
                                if (i27 == i26) {
                                    i93 = 0;
                                } else {
                                    i93 = unsafe12.getInt(obj2, i27);
                                }
                                i28 = i27;
                            } else {
                                i28 = i94;
                            }
                            switch (iZzr) {
                                case 0:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 1) {
                                        iZzh = i33 + 8;
                                        i93 |= i25;
                                        zzhn.zzo(obj2, j11, Double.longBitsToDouble(zzdk.zzn(bArr3, i33)));
                                        iZzl = iZzh;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i98 = i34;
                                        bArr8 = bArr3;
                                        i92 = i98;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 1:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 5) {
                                        iZzh = i33 + 4;
                                        i93 |= i25;
                                        zzhn.zzp(obj2, j11, Float.intBitsToFloat(zzdk.zzb(bArr3, i33)));
                                        iZzl = iZzh;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i99 = i34;
                                        bArr8 = bArr3;
                                        i92 = i99;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 0) {
                                        i93 |= i25;
                                        int iZzk2 = zzdk.zzk(bArr3, i33, zzdjVar3);
                                        unsafe2.putLong(obj, j11, zzdjVar3.zzb);
                                        iZzl = iZzk2;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i910 = i34;
                                        bArr8 = bArr3;
                                        i92 = i910;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 0) {
                                        i93 |= i25;
                                        iZzh = zzdk.zzh(bArr3, i33, zzdjVar3);
                                        unsafe2.putInt(obj2, j11, zzdjVar3.zza);
                                        iZzl = iZzh;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i911 = i34;
                                        bArr8 = bArr3;
                                        i92 = i911;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 1) {
                                        i35 = i33 + 8;
                                        i93 |= i25;
                                        unsafe2.putLong(obj, j11, zzdk.zzn(bArr3, i33));
                                        i12 = i12;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        iZzl = i35;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i912 = i34;
                                        bArr8 = bArr3;
                                        i92 = i912;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 5) {
                                        iZzh = i33 + 4;
                                        i93 |= i25;
                                        unsafe2.putInt(obj2, j11, zzdk.zzb(bArr3, i33));
                                        iZzl = iZzh;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i913 = i34;
                                        bArr8 = bArr3;
                                        i92 = i913;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 7:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 0) {
                                        i93 |= i25;
                                        iZzh = zzdk.zzk(bArr3, i33, zzdjVar3);
                                        if (zzdjVar3.zzb != 0) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        zzhn.zzm(obj2, j11, z11);
                                        iZzl = iZzh;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i914 = i34;
                                        bArr8 = bArr3;
                                        i92 = i914;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 8:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 2) {
                                        if ((i23 & ASTNode.DISCARD) != 0) {
                                            i37 = i93 | i25;
                                            iZzh2 = zzdk.zzh(bArr3, i33, zzdjVar3);
                                            i38 = zzdjVar3.zza;
                                            if (i38 >= 0) {
                                                throw zzff.zzd();
                                            }
                                            if (i38 == 0) {
                                                zzdjVar3.zzc = "";
                                                i41 = i37;
                                            } else {
                                                int i100 = zzhs.zza;
                                                length = bArr3.length;
                                                if ((((length - iZzh2) - i38) | iZzh2 | i38) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh2), Integer.valueOf(i38)));
                                                }
                                                i39 = iZzh2 + i38;
                                                cArr = new char[i38];
                                                i40 = 0;
                                                while (iZzh2 < i39) {
                                                    b13 = bArr3[iZzh2];
                                                    if (zzho.zzd(b13)) {
                                                        iZzh2++;
                                                        cArr[i40] = (char) b13;
                                                        i40++;
                                                    } else {
                                                        while (iZzh2 < i39) {
                                                            i42 = iZzh2 + 1;
                                                            b11 = bArr3[iZzh2];
                                                            if (zzho.zzd(b11)) {
                                                                cArr[i40] = (char) b11;
                                                                i40++;
                                                                iZzh2 = i42;
                                                                while (iZzh2 < i39) {
                                                                    b12 = bArr3[iZzh2];
                                                                    if (zzho.zzd(b12)) {
                                                                    }
                                                                    iZzh2++;
                                                                    cArr[i40] = (char) b12;
                                                                    i40++;
                                                                }
                                                            } else {
                                                                i43 = i37;
                                                                if (b11 < -32) {
                                                                    if (i42 < i39) {
                                                                        throw zzff.zzc();
                                                                    }
                                                                    iZzh2 += 2;
                                                                    zzho.zzc(b11, bArr3[i42], cArr, i40);
                                                                    i40++;
                                                                } else if (b11 < -16) {
                                                                    if (i42 < i39 - 1) {
                                                                        throw zzff.zzc();
                                                                    }
                                                                    int i101 = iZzh2 + 2;
                                                                    iZzh2 += 3;
                                                                    zzho.zzb(b11, bArr3[i42], bArr3[i101], cArr, i40);
                                                                    i37 = i43;
                                                                    i40++;
                                                                } else {
                                                                    if (i42 < i39 - 2) {
                                                                        throw zzff.zzc();
                                                                    }
                                                                    byte b15 = bArr3[i42];
                                                                    int i102 = iZzh2 + 3;
                                                                    byte b16 = bArr3[iZzh2 + 2];
                                                                    iZzh2 += 4;
                                                                    zzho.zza(b11, b15, b16, bArr3[i102], cArr, i40);
                                                                    i40 += 2;
                                                                }
                                                                i37 = i43;
                                                            }
                                                            break;
                                                        }
                                                        i41 = i37;
                                                        zzdjVar3.zzc = new String(cArr, 0, i40);
                                                        iZzh2 = i39;
                                                    }
                                                }
                                                while (iZzh2 < i39) {
                                                    i42 = iZzh2 + 1;
                                                    b11 = bArr3[iZzh2];
                                                    if (zzho.zzd(b11)) {
                                                        cArr[i40] = (char) b11;
                                                        i40++;
                                                        iZzh2 = i42;
                                                        while (iZzh2 < i39) {
                                                            b12 = bArr3[iZzh2];
                                                            if (zzho.zzd(b12)) {
                                                            }
                                                            iZzh2++;
                                                            cArr[i40] = (char) b12;
                                                            i40++;
                                                        }
                                                    } else {
                                                        i43 = i37;
                                                        if (b11 < -32) {
                                                            if (i42 < i39) {
                                                                throw zzff.zzc();
                                                            }
                                                            iZzh2 += 2;
                                                            zzho.zzc(b11, bArr3[i42], cArr, i40);
                                                            i40++;
                                                        } else if (b11 < -16) {
                                                            if (i42 < i39 - 1) {
                                                                throw zzff.zzc();
                                                            }
                                                            int i103 = iZzh2 + 2;
                                                            iZzh2 += 3;
                                                            zzho.zzb(b11, bArr3[i42], bArr3[i103], cArr, i40);
                                                            i37 = i43;
                                                            i40++;
                                                        } else {
                                                            if (i42 < i39 - 2) {
                                                                throw zzff.zzc();
                                                            }
                                                            byte b17 = bArr3[i42];
                                                            int i104 = iZzh2 + 3;
                                                            byte b18 = bArr3[iZzh2 + 2];
                                                            iZzh2 += 4;
                                                            zzho.zza(b11, b17, b18, bArr3[i104], cArr, i40);
                                                            i40 += 2;
                                                        }
                                                        i37 = i43;
                                                    }
                                                    break;
                                                }
                                                i41 = i37;
                                                zzdjVar3.zzc = new String(cArr, 0, i40);
                                                iZzh2 = i39;
                                            }
                                            iZzh = iZzh2;
                                            i93 = i41;
                                        } else {
                                            iZzh = zzdk.zzh(bArr3, i33, zzdjVar3);
                                            i36 = zzdjVar3.zza;
                                            if (i36 >= 0) {
                                                throw zzff.zzd();
                                            }
                                            int i105 = i93 | i25;
                                            if (i36 == 0) {
                                                zzdjVar3.zzc = "";
                                            } else {
                                                zzdjVar3.zzc = new String(bArr3, iZzh, i36, zzfd.zzb);
                                                iZzh += i36;
                                            }
                                            i93 = i105;
                                        }
                                        unsafe2.putObject(obj2, j11, zzdjVar3.zzc);
                                        iZzl = iZzh;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i915 = i34;
                                        bArr8 = bArr3;
                                        i92 = i915;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 9:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 2) {
                                        i93 |= i25;
                                        Object objZzx = zzgfVar.zzx(obj2, i29);
                                        iZzm = zzdk.zzm(objZzx, zzgfVar.zzv(i29), bArr, i33, i12, zzdjVar);
                                        zzgfVar.zzF(obj2, i29, objZzx);
                                        i12 = i12;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        iZzl = iZzm;
                                        int i916 = i34;
                                        bArr8 = bArr3;
                                        i92 = i916;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 10:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 2) {
                                        i93 |= i25;
                                        iZzm = zzdk.zza(bArr3, i33, zzdjVar3);
                                        unsafe2.putObject(obj2, j11, zzdjVar3.zzc);
                                        i12 = i12;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        iZzl = iZzm;
                                        int i917 = i34;
                                        bArr8 = bArr3;
                                        i92 = i917;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 12:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 0) {
                                        int iZzh19 = zzdk.zzh(bArr3, i33, zzdjVar3);
                                        i44 = zzdjVar3.zza;
                                        i35 = iZzh19;
                                        zzfb zzfbVarZzu3 = zzgfVar.zzu(i29);
                                        if ((i23 & Integer.MIN_VALUE) != 0 || zzfbVarZzu3 == null || zzfbVarZzu3.zza(i44)) {
                                            i93 |= i25;
                                            unsafe2.putInt(obj2, j11, i44);
                                        } else {
                                            zzd(obj).zzj(i34, Long.valueOf(i44));
                                        }
                                        i12 = i12;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        iZzl = i35;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i918 = i34;
                                        bArr8 = bArr3;
                                        i92 = i918;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 15:
                                    zzdjVar3 = zzdjVar5;
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    unsafe2 = unsafe12;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    if (i22 == 0) {
                                        i93 |= i25;
                                        iZzm = zzdk.zzh(bArr3, i33, zzdjVar3);
                                        unsafe2.putInt(obj2, j11, zzea.zzb(zzdjVar3.zza));
                                        i12 = i12;
                                        unsafe12 = unsafe2;
                                        zzdjVar5 = zzdjVar3;
                                        i91 = i29;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        iZzl = iZzm;
                                        int i919 = i34;
                                        bArr8 = bArr3;
                                        i92 = i919;
                                    } else {
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                case 16:
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    i34 = i14;
                                    if (i22 == 0) {
                                        i93 |= i25;
                                        bArr3 = bArr;
                                        int iZzk3 = zzdk.zzk(bArr3, i33, zzdjVar5);
                                        unsafe12.putLong(obj, j11, zzea.zzc(zzdjVar5.zzb));
                                        i12 = i12;
                                        i13 = i13;
                                        unsafe12 = unsafe12;
                                        zzdjVar5 = zzdjVar5;
                                        i91 = i29;
                                        iZzl = iZzk3;
                                        i90 = i32;
                                        i89 = 0;
                                        i94 = i31;
                                        int i9110 = i34;
                                        bArr8 = bArr3;
                                        i92 = i9110;
                                    } else {
                                        bArr3 = bArr;
                                        zzdjVar3 = zzdjVar5;
                                        unsafe2 = unsafe12;
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                                default:
                                    if (i22 == 3) {
                                        int i106 = i93 | i25;
                                        Object objZzx2 = zzgfVar.zzx(obj2, i16);
                                        int i107 = i16;
                                        iZzl = zzdk.zzl(objZzx2, zzgfVar.zzv(i16), bArr, i24, i12, (i96 << 3) | 4, zzdjVar);
                                        zzgfVar.zzF(obj2, i107, objZzx2);
                                        i94 = i28;
                                        i13 = i13;
                                        i93 = i106;
                                        i91 = i107;
                                        i92 = i14;
                                        i90 = i96;
                                        i89 = 0;
                                        bArr8 = bArr;
                                        i12 = i12;
                                    } else {
                                        i29 = i16;
                                        i31 = i28;
                                        i32 = i96;
                                        i33 = i24;
                                        i34 = i14;
                                        bArr3 = bArr;
                                        zzdjVar3 = zzdjVar5;
                                        unsafe2 = unsafe12;
                                        i17 = i31;
                                        i13 = i13;
                                        i18 = i33;
                                        unsafe = unsafe2;
                                        i91 = i29;
                                        i21 = i34;
                                        i19 = i32;
                                        zzdjVar2 = zzdjVar3;
                                        bArr2 = bArr3;
                                    }
                                    break;
                            }
                        } else {
                            i17 = i94;
                            i45 = i96;
                            zzdjVar4 = zzdjVar5;
                            i46 = i14;
                            i47 = i16;
                            unsafe3 = unsafe12;
                            if (iZzr == 27) {
                                i49 = i47;
                                i50 = i24;
                                bArr4 = bArr;
                                i48 = i93;
                                zzdjVar4 = zzdjVar4;
                                if (iZzr <= 49) {
                                    j12 = i23;
                                    unsafe5 = zzb;
                                    zzfcVarZzd2 = (zzfc) unsafe5.getObject(obj2, j11);
                                    if (!zzfcVarZzd2.zzc()) {
                                        size3 = zzfcVarZzd2.size();
                                        if (size3 == 0) {
                                            i80 = 10;
                                        } else {
                                            i80 = size3 + size3;
                                        }
                                        zzfcVarZzd2 = zzfcVarZzd2.zzd(i80);
                                        unsafe5.putObject(obj2, j11, zzfcVarZzd2);
                                    }
                                    zzfcVar = zzfcVarZzd2;
                                    switch (iZzr) {
                                        case 18:
                                        case 35:
                                            bArr4 = bArr;
                                            i53 = i12;
                                            zzdjVar4 = zzdjVar4;
                                            i90 = i45;
                                            unsafe6 = unsafe3;
                                            if (i22 == 2) {
                                                zzegVar2 = (zzeg) zzfcVar;
                                                iZzh3 = zzdk.zzh(bArr4, i50, zzdjVar4);
                                                i54 = zzdjVar4.zza + iZzh3;
                                                while (iZzh3 < i54) {
                                                    zzegVar2.zze(Double.longBitsToDouble(zzdk.zzn(bArr4, iZzh3)));
                                                    iZzh3 += 8;
                                                }
                                                if (iZzh3 != i54) {
                                                    throw zzff.zzg();
                                                }
                                            } else if (i22 == 1) {
                                                iZzh3 = i50 + 8;
                                                zzegVar = (zzeg) zzfcVar;
                                                zzegVar.zze(Double.longBitsToDouble(zzdk.zzn(bArr4, i50)));
                                                while (iZzh3 < i53) {
                                                    iZzh4 = zzdk.zzh(bArr4, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        zzegVar.zze(Double.longBitsToDouble(zzdk.zzn(bArr4, iZzh4)));
                                                        iZzh3 = iZzh4 + 8;
                                                    }
                                                }
                                            } else {
                                                iZzh3 = i50;
                                            }
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            bArr4 = bArr;
                                            i53 = i12;
                                            zzdjVar4 = zzdjVar4;
                                            i90 = i45;
                                            unsafe6 = unsafe3;
                                            if (i22 == 2) {
                                                zzeqVar2 = (zzeq) zzfcVar;
                                                iZzh3 = zzdk.zzh(bArr4, i50, zzdjVar4);
                                                i55 = zzdjVar4.zza + iZzh3;
                                                while (iZzh3 < i55) {
                                                    zzeqVar2.zze(Float.intBitsToFloat(zzdk.zzb(bArr4, iZzh3)));
                                                    iZzh3 += 4;
                                                }
                                                if (iZzh3 != i55) {
                                                    throw zzff.zzg();
                                                }
                                            } else if (i22 == 5) {
                                                iZzh3 = i50 + 4;
                                                zzeqVar = (zzeq) zzfcVar;
                                                zzeqVar.zze(Float.intBitsToFloat(zzdk.zzb(bArr4, i50)));
                                                while (iZzh3 < i53) {
                                                    iZzh5 = zzdk.zzh(bArr4, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        zzeqVar.zze(Float.intBitsToFloat(zzdk.zzb(bArr4, iZzh5)));
                                                        iZzh3 = iZzh5 + 4;
                                                    }
                                                }
                                            } else {
                                                iZzh3 = i50;
                                            }
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            bArr4 = bArr;
                                            i53 = i12;
                                            zzdjVar4 = zzdjVar4;
                                            i90 = i45;
                                            unsafe6 = unsafe3;
                                            if (i22 == 2) {
                                                zzfrVar2 = (zzfr) zzfcVar;
                                                iZzh3 = zzdk.zzh(bArr4, i50, zzdjVar4);
                                                i56 = zzdjVar4.zza + iZzh3;
                                                while (iZzh3 < i56) {
                                                    iZzh3 = zzdk.zzk(bArr4, iZzh3, zzdjVar4);
                                                    zzfrVar2.zzf(zzdjVar4.zzb);
                                                }
                                                if (iZzh3 != i56) {
                                                    throw zzff.zzg();
                                                }
                                            } else if (i22 == 0) {
                                                zzfrVar = (zzfr) zzfcVar;
                                                iZzh3 = zzdk.zzk(bArr4, i50, zzdjVar4);
                                                zzfrVar.zzf(zzdjVar4.zzb);
                                                while (iZzh3 < i53) {
                                                    iZzh6 = zzdk.zzh(bArr4, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzh3 = zzdk.zzk(bArr4, iZzh6, zzdjVar4);
                                                        zzfrVar.zzf(zzdjVar4.zzb);
                                                    }
                                                }
                                            } else {
                                                iZzh3 = i50;
                                            }
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 22:
                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                        case 39:
                                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                            bArr4 = bArr;
                                            unsafe7 = unsafe3;
                                            i53 = i12;
                                            i57 = i49;
                                            i58 = i50;
                                            zzdjVar4 = zzdjVar4;
                                            i59 = i45;
                                            if (i22 == 2) {
                                                iZzf = zzdk.zzf(bArr4, i58, zzfcVar, zzdjVar4);
                                                unsafe6 = unsafe7;
                                                iZzh3 = iZzf;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                            } else if (i22 == 0) {
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                iZzh3 = zzdk.zzj(i46, bArr, i58, i12, zzfcVar, zzdjVar);
                                            } else {
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                iZzh3 = i50;
                                            }
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                            bArr4 = bArr;
                                            unsafe7 = unsafe3;
                                            i53 = i12;
                                            i57 = i49;
                                            i58 = i50;
                                            zzdjVar4 = zzdjVar4;
                                            i59 = i45;
                                            if (i22 == 2) {
                                                if (i22 == 1) {
                                                    iZze = i58 + 8;
                                                    zzfrVar3 = (zzfr) zzfcVar;
                                                    zzfrVar3.zzf(zzdk.zzn(bArr4, i58));
                                                    while (iZze < i53) {
                                                        iZzh7 = zzdk.zzh(bArr4, iZze, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            unsafe6 = unsafe7;
                                                            i50 = i58;
                                                            i90 = i59;
                                                            iZzh3 = iZze;
                                                            i49 = i57;
                                                            if (iZzh3 != i50) {
                                                                i13 = i13;
                                                                i12 = i53;
                                                                i91 = i49;
                                                                unsafe12 = unsafe6;
                                                                zzdjVar5 = zzdjVar4;
                                                                i92 = i46;
                                                                i94 = i17;
                                                                i93 = i48;
                                                                i89 = 0;
                                                                obj2 = obj;
                                                                iZzl = iZzh3;
                                                                bArr8 = bArr4;
                                                            } else {
                                                                obj2 = obj;
                                                                i18 = iZzh3;
                                                                i91 = i49;
                                                                i19 = i90;
                                                                unsafe = unsafe6;
                                                                i93 = i48;
                                                                zzdjVar2 = zzdjVar4;
                                                                bArr2 = bArr4;
                                                                i21 = i46;
                                                            }
                                                        } else {
                                                            zzfrVar3.zzf(zzdk.zzn(bArr4, iZzh7));
                                                            iZze = iZzh7 + 8;
                                                        }
                                                        break;
                                                    }
                                                    unsafe6 = unsafe7;
                                                    i50 = i58;
                                                    i90 = i59;
                                                    iZzh3 = iZze;
                                                    i49 = i57;
                                                    if (iZzh3 != i50) {
                                                        i13 = i13;
                                                        i12 = i53;
                                                        i91 = i49;
                                                        unsafe12 = unsafe6;
                                                        zzdjVar5 = zzdjVar4;
                                                        i92 = i46;
                                                        i94 = i17;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        obj2 = obj;
                                                        iZzl = iZzh3;
                                                        bArr8 = bArr4;
                                                    } else {
                                                        obj2 = obj;
                                                        i18 = iZzh3;
                                                        i91 = i49;
                                                        i19 = i90;
                                                        unsafe = unsafe6;
                                                        i93 = i48;
                                                        zzdjVar2 = zzdjVar4;
                                                        bArr2 = bArr4;
                                                        i21 = i46;
                                                    }
                                                }
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                                break;
                                            } else {
                                                zzfrVar4 = (zzfr) zzfcVar;
                                                iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                i60 = zzdjVar4.zza + iZzf;
                                                while (iZzf < i60) {
                                                    zzfrVar4.zzf(zzdk.zzn(bArr4, iZzf));
                                                    iZzf += 8;
                                                }
                                                if (iZzf != i60) {
                                                    throw zzff.zzg();
                                                }
                                                unsafe6 = unsafe7;
                                                iZzh3 = iZzf;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            break;
                                        case 24:
                                        case VungleException.WEB_CRASH /* 31 */:
                                        case 41:
                                        case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                            bArr4 = bArr;
                                            unsafe7 = unsafe3;
                                            i53 = i12;
                                            i57 = i49;
                                            i58 = i50;
                                            zzdjVar4 = zzdjVar4;
                                            i59 = i45;
                                            if (i22 == 2) {
                                                if (i22 == 5) {
                                                    iZze = i58 + 4;
                                                    zzeyVar = (zzey) zzfcVar;
                                                    zzeyVar.zzf(zzdk.zzb(bArr4, i58));
                                                    while (iZze < i53) {
                                                        iZzh8 = zzdk.zzh(bArr4, iZze, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            unsafe6 = unsafe7;
                                                            i50 = i58;
                                                            i90 = i59;
                                                            iZzh3 = iZze;
                                                            i49 = i57;
                                                            if (iZzh3 != i50) {
                                                                i13 = i13;
                                                                i12 = i53;
                                                                i91 = i49;
                                                                unsafe12 = unsafe6;
                                                                zzdjVar5 = zzdjVar4;
                                                                i92 = i46;
                                                                i94 = i17;
                                                                i93 = i48;
                                                                i89 = 0;
                                                                obj2 = obj;
                                                                iZzl = iZzh3;
                                                                bArr8 = bArr4;
                                                            } else {
                                                                obj2 = obj;
                                                                i18 = iZzh3;
                                                                i91 = i49;
                                                                i19 = i90;
                                                                unsafe = unsafe6;
                                                                i93 = i48;
                                                                zzdjVar2 = zzdjVar4;
                                                                bArr2 = bArr4;
                                                                i21 = i46;
                                                            }
                                                        } else {
                                                            zzeyVar.zzf(zzdk.zzb(bArr4, iZzh8));
                                                            iZze = iZzh8 + 4;
                                                        }
                                                        break;
                                                    }
                                                    unsafe6 = unsafe7;
                                                    i50 = i58;
                                                    i90 = i59;
                                                    iZzh3 = iZze;
                                                    i49 = i57;
                                                    if (iZzh3 != i50) {
                                                        i13 = i13;
                                                        i12 = i53;
                                                        i91 = i49;
                                                        unsafe12 = unsafe6;
                                                        zzdjVar5 = zzdjVar4;
                                                        i92 = i46;
                                                        i94 = i17;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        obj2 = obj;
                                                        iZzl = iZzh3;
                                                        bArr8 = bArr4;
                                                    } else {
                                                        obj2 = obj;
                                                        i18 = iZzh3;
                                                        i91 = i49;
                                                        i19 = i90;
                                                        unsafe = unsafe6;
                                                        i93 = i48;
                                                        zzdjVar2 = zzdjVar4;
                                                        bArr2 = bArr4;
                                                        i21 = i46;
                                                    }
                                                }
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                                break;
                                            } else {
                                                zzeyVar2 = (zzey) zzfcVar;
                                                iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                i61 = zzdjVar4.zza + iZzf;
                                                while (iZzf < i61) {
                                                    zzeyVar2.zzf(zzdk.zzb(bArr4, iZzf));
                                                    iZzf += 4;
                                                }
                                                if (iZzf != i61) {
                                                    throw zzff.zzg();
                                                }
                                                unsafe6 = unsafe7;
                                                iZzh3 = iZzf;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            break;
                                        case 25:
                                        case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                            bArr4 = bArr;
                                            unsafe7 = unsafe3;
                                            i53 = i12;
                                            i57 = i49;
                                            i58 = i50;
                                            zzdjVar4 = zzdjVar4;
                                            i59 = i45;
                                            if (i22 == 2) {
                                                if (i22 == 0) {
                                                    zzdlVar = (zzdl) zzfcVar;
                                                    iZzf = zzdk.zzk(bArr4, i58, zzdjVar4);
                                                    if (zzdjVar4.zzb != 0) {
                                                        z12 = true;
                                                    } else {
                                                        z12 = false;
                                                    }
                                                    zzdlVar.zze(z12);
                                                    while (iZzf < i53) {
                                                        iZzh9 = zzdk.zzh(bArr4, iZzf, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            iZzf = zzdk.zzk(bArr4, iZzh9, zzdjVar4);
                                                            if (zzdjVar4.zzb != 0) {
                                                                z13 = true;
                                                            } else {
                                                                z13 = false;
                                                            }
                                                            zzdlVar.zze(z13);
                                                        }
                                                    }
                                                }
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                zzdlVar2 = (zzdl) zzfcVar;
                                                iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                i62 = zzdjVar4.zza + iZzf;
                                                while (iZzf < i62) {
                                                    iZzf = zzdk.zzk(bArr4, iZzf, zzdjVar4);
                                                    if (zzdjVar4.zzb != 0) {
                                                        z14 = true;
                                                    } else {
                                                        z14 = false;
                                                    }
                                                    zzdlVar2.zze(z14);
                                                }
                                                if (iZzf != i62) {
                                                    throw zzff.zzg();
                                                }
                                            }
                                            unsafe6 = unsafe7;
                                            iZzh3 = iZzf;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 26:
                                            unsafe7 = unsafe3;
                                            i53 = i12;
                                            i57 = i49;
                                            i58 = i50;
                                            i59 = i45;
                                            bArr4 = bArr;
                                            zzdjVar4 = zzdjVar4;
                                            if (i22 == 2) {
                                                if ((j12 & 536870912) == 0) {
                                                    iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                    i67 = zzdjVar4.zza;
                                                    if (i67 >= 0) {
                                                        throw zzff.zzd();
                                                    }
                                                    if (i67 == 0) {
                                                        zzfcVar.add("");
                                                    } else {
                                                        zzfcVar.add(new String(bArr4, iZzf, i67, zzfd.zzb));
                                                        iZzf += i67;
                                                    }
                                                    while (iZzf < i53) {
                                                        iZzh11 = zzdk.zzh(bArr4, iZzf, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            iZzf = zzdk.zzh(bArr4, iZzh11, zzdjVar4);
                                                            i68 = zzdjVar4.zza;
                                                            if (i68 >= 0) {
                                                                throw zzff.zzd();
                                                            }
                                                            if (i68 == 0) {
                                                                zzfcVar.add("");
                                                            } else {
                                                                zzfcVar.add(new String(bArr4, iZzf, i68, zzfd.zzb));
                                                                iZzf += i68;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                    i63 = zzdjVar4.zza;
                                                    if (i63 >= 0) {
                                                        throw zzff.zzd();
                                                    }
                                                    if (i63 == 0) {
                                                        zzfcVar.add("");
                                                    } else {
                                                        i64 = iZzf + i63;
                                                        if (zzhs.zze(bArr4, iZzf, i64)) {
                                                            throw zzff.zzc();
                                                        }
                                                        zzfcVar.add(new String(bArr4, iZzf, i63, zzfd.zzb));
                                                        iZzf = i64;
                                                    }
                                                    while (iZzf < i53) {
                                                        iZzh10 = zzdk.zzh(bArr4, iZzf, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            iZzf = zzdk.zzh(bArr4, iZzh10, zzdjVar4);
                                                            i65 = zzdjVar4.zza;
                                                            if (i65 >= 0) {
                                                                throw zzff.zzd();
                                                            }
                                                            if (i65 == 0) {
                                                                zzfcVar.add("");
                                                            } else {
                                                                i66 = iZzf + i65;
                                                                if (zzhs.zze(bArr4, iZzf, i66)) {
                                                                    throw zzff.zzc();
                                                                }
                                                                zzfcVar.add(new String(bArr4, iZzf, i65, zzfd.zzb));
                                                                iZzf = i66;
                                                            }
                                                        }
                                                    }
                                                }
                                                unsafe6 = unsafe7;
                                                iZzh3 = iZzf;
                                                i50 = i58;
                                                i49 = i57;
                                                i90 = i59;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            unsafe6 = unsafe7;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 27:
                                            bArr5 = bArr;
                                            if (i22 == 2) {
                                                zzgfVar = this;
                                                i57 = i49;
                                                i53 = i12;
                                                iZze = zzdk.zze(zzgfVar.zzv(i49), i46, bArr, i50, i12, zzfcVar, zzdjVar);
                                                unsafe6 = unsafe3;
                                                bArr4 = bArr;
                                                i50 = i50;
                                                i90 = i45;
                                                zzdjVar4 = zzdjVar4;
                                                iZzh3 = iZze;
                                                i49 = i57;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                i53 = i12;
                                                zzgfVar = this;
                                                i90 = i45;
                                                bArr4 = bArr5;
                                                unsafe6 = unsafe3;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            break;
                                        case 28:
                                            bArr5 = bArr;
                                            if (i22 == 2) {
                                                iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                                i69 = zzdjVar4.zza;
                                                if (i69 >= 0) {
                                                    throw zzff.zzd();
                                                }
                                                if (i69 <= bArr5.length - iZzh3) {
                                                    throw zzff.zzg();
                                                }
                                                if (i69 == 0) {
                                                    zzfcVar.add(zzdw.zzb);
                                                } else {
                                                    zzfcVar.add(zzdw.zzl(bArr5, iZzh3, i69));
                                                    iZzh3 += i69;
                                                }
                                                while (iZzh3 < i12) {
                                                    iZzh12 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        i90 = i45;
                                                        i53 = i12;
                                                        zzgfVar = this;
                                                        bArr4 = bArr5;
                                                        zzdjVar4 = zzdjVar4;
                                                        unsafe6 = unsafe3;
                                                        if (iZzh3 != i50) {
                                                            i13 = i13;
                                                            i12 = i53;
                                                            i91 = i49;
                                                            unsafe12 = unsafe6;
                                                            zzdjVar5 = zzdjVar4;
                                                            i92 = i46;
                                                            i94 = i17;
                                                            i93 = i48;
                                                            i89 = 0;
                                                            obj2 = obj;
                                                            iZzl = iZzh3;
                                                            bArr8 = bArr4;
                                                        } else {
                                                            obj2 = obj;
                                                            i18 = iZzh3;
                                                            i91 = i49;
                                                            i19 = i90;
                                                            unsafe = unsafe6;
                                                            i93 = i48;
                                                            zzdjVar2 = zzdjVar4;
                                                            bArr2 = bArr4;
                                                            i21 = i46;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzh3 = zzdk.zzh(bArr5, iZzh12, zzdjVar4);
                                                        i70 = zzdjVar4.zza;
                                                        if (i70 >= 0) {
                                                            throw zzff.zzd();
                                                        }
                                                        if (i70 <= bArr5.length - iZzh3) {
                                                            throw zzff.zzg();
                                                        }
                                                        if (i70 == 0) {
                                                            zzfcVar.add(zzdw.zzb);
                                                        } else {
                                                            zzfcVar.add(zzdw.zzl(bArr5, iZzh3, i70));
                                                            iZzh3 += i70;
                                                        }
                                                    }
                                                }
                                                i90 = i45;
                                                i53 = i12;
                                                zzgfVar = this;
                                                bArr4 = bArr5;
                                                zzdjVar4 = zzdjVar4;
                                                unsafe6 = unsafe3;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                i90 = i45;
                                                i53 = i12;
                                                zzgfVar = this;
                                                bArr4 = bArr5;
                                                unsafe6 = unsafe3;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            break;
                                        case 30:
                                        case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                            bArr5 = bArr;
                                            i71 = i12;
                                            if (i22 == 2) {
                                                iZzj = zzdk.zzf(bArr5, i50, zzfcVar, zzdjVar4);
                                            } else if (i22 == 0) {
                                                zzgfVar = this;
                                                i53 = i71;
                                                i90 = i45;
                                                bArr4 = bArr5;
                                                unsafe6 = unsafe3;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                iZzj = zzdk.zzj(i46, bArr, i50, i12, zzfcVar, zzdjVar);
                                            }
                                            zzfbVarZzu = zzgfVar.zzu(i49);
                                            zzhdVar = zzgfVar.zzm;
                                            int i108 = zzgo.zza;
                                            if (zzfbVarZzu != null) {
                                                i72 = iZzj;
                                                i73 = i45;
                                            } else if (zzfcVar instanceof RandomAccess) {
                                                size2 = zzfcVar.size();
                                                objZzo2 = null;
                                                i74 = 0;
                                                i75 = 0;
                                                while (i74 < size2) {
                                                    int i109 = iZzj;
                                                    iIntValue2 = ((Integer) zzfcVar.get(i74)).intValue();
                                                    if (zzfbVarZzu.zza(iIntValue2)) {
                                                        if (i74 != i75) {
                                                            zzfcVar.set(i75, Integer.valueOf(iIntValue2));
                                                        }
                                                        i75++;
                                                        i76 = i45;
                                                    } else {
                                                        i76 = i45;
                                                        objZzo2 = zzgo.zzo(obj2, i76, iIntValue2, objZzo2, zzhdVar);
                                                    }
                                                    i74++;
                                                    i45 = i76;
                                                    iZzj = i109;
                                                }
                                                i72 = iZzj;
                                                i73 = i45;
                                                if (i75 != size2) {
                                                    zzfcVar.subList(i75, size2).clear();
                                                }
                                            } else {
                                                i72 = iZzj;
                                                i73 = i45;
                                                it = zzfcVar.iterator();
                                                objZzo = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!zzfbVarZzu.zza(iIntValue)) {
                                                        objZzo = zzgo.zzo(obj2, i73, iIntValue, objZzo, zzhdVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            i90 = i73;
                                            i53 = i71;
                                            iZzh3 = i72;
                                            zzgfVar = this;
                                            bArr4 = bArr5;
                                            zzdjVar4 = zzdjVar4;
                                            unsafe6 = unsafe3;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 33:
                                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                            bArr5 = bArr;
                                            i71 = i12;
                                            if (i22 == 2) {
                                                if (i22 == 0) {
                                                    zzeyVar3 = (zzey) zzfcVar;
                                                    iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                                    zzeyVar3.zzf(zzea.zzb(zzdjVar4.zza));
                                                    while (iZzh3 < i71) {
                                                        iZzh13 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            iZzh3 = zzdk.zzh(bArr5, iZzh13, zzdjVar4);
                                                            zzeyVar3.zzf(zzea.zzb(zzdjVar4.zza));
                                                        }
                                                    }
                                                }
                                                i53 = i71;
                                                i90 = i45;
                                                bArr4 = bArr5;
                                                unsafe6 = unsafe3;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                zzeyVar4 = (zzey) zzfcVar;
                                                iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                                i77 = zzdjVar4.zza + iZzh3;
                                                while (iZzh3 < i77) {
                                                    iZzh3 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                    zzeyVar4.zzf(zzea.zzb(zzdjVar4.zza));
                                                }
                                                if (iZzh3 != i77) {
                                                    throw zzff.zzg();
                                                }
                                            }
                                            i53 = i71;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            zzdjVar4 = zzdjVar4;
                                            unsafe6 = unsafe3;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr5 = bArr;
                                            i71 = i12;
                                            if (i22 == 2) {
                                                if (i22 == 0) {
                                                    zzfrVar5 = (zzfr) zzfcVar;
                                                    iZzh3 = zzdk.zzk(bArr5, i50, zzdjVar4);
                                                    zzfrVar5.zzf(zzea.zzc(zzdjVar4.zzb));
                                                    while (iZzh3 < i71) {
                                                        iZzh14 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            iZzh3 = zzdk.zzk(bArr5, iZzh14, zzdjVar4);
                                                            zzfrVar5.zzf(zzea.zzc(zzdjVar4.zzb));
                                                        }
                                                    }
                                                }
                                                i53 = i71;
                                                i90 = i45;
                                                bArr4 = bArr5;
                                                unsafe6 = unsafe3;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                zzfrVar6 = (zzfr) zzfcVar;
                                                iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                                i78 = zzdjVar4.zza + iZzh3;
                                                while (iZzh3 < i78) {
                                                    iZzh3 = zzdk.zzk(bArr5, iZzh3, zzdjVar4);
                                                    zzfrVar6.zzf(zzea.zzc(zzdjVar4.zzb));
                                                }
                                                if (iZzh3 != i78) {
                                                    throw zzff.zzg();
                                                }
                                            }
                                            i53 = i71;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            zzdjVar4 = zzdjVar4;
                                            unsafe6 = unsafe3;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        default:
                                            if (i22 == 3) {
                                                i79 = (i46 & (-8)) | 4;
                                                zzgmVarZzv = zzgfVar.zzv(i49);
                                                iZzh3 = zzdk.zzc(zzgmVarZzv, bArr, i50, i12, i79, zzdjVar);
                                                zzfcVar.add(zzdjVar4.zzc);
                                                i71 = i12;
                                                while (true) {
                                                    if (iZzh3 < i71) {
                                                        iZzh15 = zzdk.zzh(bArr, iZzh3, zzdjVar4);
                                                        if (i46 == zzdjVar4.zza) {
                                                            iZzh3 = zzdk.zzc(zzgmVarZzv, bArr, iZzh15, i12, i79, zzdjVar);
                                                            zzfcVar.add(zzdjVar4.zzc);
                                                            zzgmVarZzv = zzgmVarZzv;
                                                        } else {
                                                            bArr5 = bArr;
                                                        }
                                                    } else {
                                                        bArr5 = bArr;
                                                    }
                                                }
                                                i53 = i71;
                                                i90 = i45;
                                                bArr4 = bArr5;
                                                zzdjVar4 = zzdjVar4;
                                                unsafe6 = unsafe3;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            } else {
                                                bArr4 = bArr;
                                                i53 = i12;
                                                i90 = i45;
                                                unsafe6 = unsafe3;
                                                iZzh3 = i50;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    zzdjVar4 = zzdjVar4;
                                    i51 = i45;
                                    unsafe4 = unsafe3;
                                    if (iZzr == 50) {
                                        unsafe9 = zzb;
                                        j13 = iArr[i49 + 2] & 1048575;
                                        switch (iZzr) {
                                            case 51:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 1) {
                                                    iZzh16 = i81 + 8;
                                                    unsafe9.putObject(obj2, j11, Double.valueOf(Double.longBitsToDouble(zzdk.zzn(bArr2, i81))));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 52:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 5) {
                                                    iZzh16 = i81 + 4;
                                                    unsafe9.putObject(obj2, j11, Float.valueOf(Float.intBitsToFloat(zzdk.zzb(bArr2, i81))));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 0) {
                                                    iZzk = zzdk.zzk(bArr2, i81, zzdjVar2);
                                                    unsafe9.putObject(obj2, j11, Long.valueOf(zzdjVar2.zzb));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                    iZzh16 = iZzk;
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 0) {
                                                    iZzh16 = zzdk.zzh(bArr2, i81, zzdjVar2);
                                                    unsafe9.putObject(obj2, j11, Integer.valueOf(zzdjVar2.zza));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 56:
                                            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 1) {
                                                    iZzh16 = i81 + 8;
                                                    unsafe9.putObject(obj2, j11, Long.valueOf(zzdk.zzn(bArr2, i81)));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                            case 64:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 5) {
                                                    iZzh16 = i81 + 4;
                                                    unsafe9.putObject(obj2, j11, Integer.valueOf(zzdk.zzb(bArr2, i81)));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 58:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 0) {
                                                    iZzk = zzdk.zzk(bArr2, i81, zzdjVar2);
                                                    if (zzdjVar2.zzb != 0) {
                                                        z15 = true;
                                                    } else {
                                                        z15 = false;
                                                    }
                                                    unsafe9.putObject(obj2, j11, Boolean.valueOf(z15));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                    iZzh16 = iZzk;
                                                } else {
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 59:
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                if (i22 == 2) {
                                                    iZzh17 = zzdk.zzh(bArr2, i81, zzdjVar2);
                                                    i83 = zzdjVar2.zza;
                                                    if (i83 == 0) {
                                                        unsafe9.putObject(obj2, j11, "");
                                                    } else {
                                                        i84 = iZzh17 + i83;
                                                        if ((i23 & ASTNode.DISCARD) == 0 && !zzhs.zze(bArr2, iZzh17, i84)) {
                                                            throw zzff.zzc();
                                                        }
                                                        unsafe9.putObject(obj2, j11, new String(bArr2, iZzh17, i83, zzfd.zzb));
                                                        iZzh17 = i84;
                                                    }
                                                    unsafe9.putInt(obj2, j13, i19);
                                                    iZzh16 = iZzh17;
                                                } else {
                                                    i82 = i82;
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 60:
                                                obj2 = obj;
                                                i81 = i50;
                                                i85 = i49;
                                                i19 = i51;
                                                i21 = i46;
                                                zzdjVar2 = zzdjVar4;
                                                if (i22 == 2) {
                                                    Object objZzy = zzgfVar.zzy(obj2, i19, i85);
                                                    bArr2 = bArr4;
                                                    unsafe = unsafe4;
                                                    iZzh16 = zzdk.zzm(objZzy, zzgfVar.zzv(i85), bArr, i81, i12, zzdjVar);
                                                    zzgfVar.zzG(obj2, i19, i85, objZzy);
                                                    i82 = i85;
                                                } else {
                                                    bArr2 = bArr4;
                                                    unsafe = unsafe4;
                                                    i82 = i85;
                                                    iZzh16 = i81;
                                                }
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 61:
                                                i81 = i50;
                                                unsafe10 = unsafe4;
                                                bArr6 = bArr4;
                                                i21 = i46;
                                                zzdjVar2 = zzdjVar4;
                                                obj2 = obj;
                                                i86 = i49;
                                                i19 = i51;
                                                if (i22 == 2) {
                                                    iZza = zzdk.zza(bArr6, i81, zzdjVar2);
                                                    unsafe9.putObject(obj2, j11, zzdjVar2.zzc);
                                                    unsafe9.putInt(obj2, j13, i19);
                                                    bArr2 = bArr6;
                                                    iZzh16 = iZza;
                                                    i82 = i86;
                                                    unsafe = unsafe10;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                }
                                                bArr2 = bArr6;
                                                i82 = i86;
                                                unsafe = unsafe10;
                                                iZzh16 = i81;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 63:
                                                i81 = i50;
                                                unsafe10 = unsafe4;
                                                bArr6 = bArr4;
                                                zzdjVar2 = zzdjVar4;
                                                obj2 = obj;
                                                i86 = i49;
                                                i19 = i51;
                                                if (i22 == 0) {
                                                    iZza = zzdk.zzh(bArr6, i81, zzdjVar2);
                                                    i87 = zzdjVar2.zza;
                                                    zzfbVarZzu2 = zzgfVar.zzu(i86);
                                                    if (zzfbVarZzu2 != null || zzfbVarZzu2.zza(i87)) {
                                                        i21 = i46;
                                                        unsafe9.putObject(obj2, j11, Integer.valueOf(i87));
                                                        unsafe9.putInt(obj2, j13, i19);
                                                    } else {
                                                        i21 = i46;
                                                        zzd(obj).zzj(i21, Long.valueOf(i87));
                                                    }
                                                    bArr2 = bArr6;
                                                    iZzh16 = iZza;
                                                    i82 = i86;
                                                    unsafe = unsafe10;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                } else {
                                                    i21 = i46;
                                                    bArr2 = bArr6;
                                                    i82 = i86;
                                                    unsafe = unsafe10;
                                                    iZzh16 = i81;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                }
                                                break;
                                            case 66:
                                                i81 = i50;
                                                unsafe11 = unsafe4;
                                                bArr7 = bArr4;
                                                i88 = i46;
                                                zzdjVar2 = zzdjVar4;
                                                obj2 = obj;
                                                i85 = i49;
                                                i19 = i51;
                                                if (i22 == 0) {
                                                    iZzh18 = zzdk.zzh(bArr7, i81, zzdjVar2);
                                                    unsafe9.putObject(obj2, j11, Integer.valueOf(zzea.zzb(zzdjVar2.zza)));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                    bArr2 = bArr7;
                                                    iZzh16 = iZzh18;
                                                    unsafe = unsafe11;
                                                    i21 = i88;
                                                    i82 = i85;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                }
                                                bArr2 = bArr7;
                                                unsafe = unsafe11;
                                                i21 = i88;
                                                i82 = i85;
                                                iZzh16 = i81;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                                i81 = i50;
                                                unsafe11 = unsafe4;
                                                bArr7 = bArr4;
                                                i88 = i46;
                                                zzdjVar2 = zzdjVar4;
                                                obj2 = obj;
                                                i85 = i49;
                                                i19 = i51;
                                                if (i22 == 0) {
                                                    iZzh18 = zzdk.zzk(bArr7, i81, zzdjVar2);
                                                    unsafe9.putObject(obj2, j11, Long.valueOf(zzea.zzc(zzdjVar2.zzb)));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                    bArr2 = bArr7;
                                                    iZzh16 = iZzh18;
                                                    unsafe = unsafe11;
                                                    i21 = i88;
                                                    i82 = i85;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                }
                                                bArr2 = bArr7;
                                                unsafe = unsafe11;
                                                i21 = i88;
                                                i82 = i85;
                                                iZzh16 = i81;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                            case 68:
                                                if (i22 == 3) {
                                                    obj2 = obj;
                                                    Object objZzy2 = zzgfVar.zzy(obj2, i51, i49);
                                                    i85 = i49;
                                                    i81 = i50;
                                                    zzdjVar2 = zzdjVar4;
                                                    int iZzl2 = zzdk.zzl(objZzy2, zzgfVar.zzv(i49), bArr, i81, i12, (i46 & (-8)) | 4, zzdjVar);
                                                    zzgfVar.zzG(obj2, i51, i85, objZzy2);
                                                    bArr2 = bArr4;
                                                    unsafe = unsafe4;
                                                    iZzh16 = iZzl2;
                                                    i21 = i46;
                                                    i19 = i51;
                                                    i82 = i85;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                } else {
                                                    obj2 = obj;
                                                    zzdjVar2 = zzdjVar4;
                                                    i81 = i50;
                                                    unsafe = unsafe4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                    i82 = i49;
                                                    i19 = i51;
                                                    iZzh16 = i81;
                                                    if (iZzh16 != i81) {
                                                        i81 = i81;
                                                        unsafe12 = unsafe;
                                                        i12 = i12;
                                                        i13 = i13;
                                                        i90 = i19;
                                                        i92 = i21;
                                                        zzdjVar5 = zzdjVar2;
                                                        i91 = i82;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        iZzl = iZzh16;
                                                        bArr8 = bArr2;
                                                        i94 = i17;
                                                    } else {
                                                        i81 = i81;
                                                        i13 = i13;
                                                        i18 = iZzh16;
                                                        i91 = i82;
                                                        i93 = i48;
                                                    }
                                                }
                                                break;
                                            default:
                                                obj2 = obj;
                                                i81 = i50;
                                                i82 = i49;
                                                i19 = i51;
                                                unsafe = unsafe4;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                iZzh16 = i81;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i22 == 2) {
                                            unsafe8 = zzb;
                                            Object objZzw = zzgfVar.zzw(i49);
                                            object = unsafe8.getObject(obj, j11);
                                            if (!((zzfw) object).zze()) {
                                                zzfw zzfwVarZzb = zzfw.zza().zzb();
                                                zzfx.zza(zzfwVarZzb, object);
                                                unsafe8.putObject(obj, j11, zzfwVarZzb);
                                            }
                                            throw null;
                                        }
                                        obj2 = obj;
                                        i18 = i50;
                                        unsafe = unsafe4;
                                        i93 = i48;
                                        i91 = i49;
                                        i19 = i51;
                                        zzdjVar2 = zzdjVar4;
                                        bArr2 = bArr4;
                                        i21 = i46;
                                    }
                                }
                            } else if (i22 == 2) {
                                zzfcVarZzd = (zzfc) unsafe3.getObject(obj2, j11);
                                if (!zzfcVarZzd.zzc()) {
                                    size = zzfcVarZzd.size();
                                    if (size == 0) {
                                        i52 = 10;
                                    } else {
                                        i52 = size + size;
                                    }
                                    zzfcVarZzd = zzfcVarZzd.zzd(i52);
                                    unsafe3.putObject(obj2, j11, zzfcVarZzd);
                                }
                                unsafe12 = unsafe3;
                                iZzl = zzdk.zze(zzgfVar.zzv(i47), i46, bArr, i24, i12, zzfcVarZzd, zzdjVar);
                                i91 = i47;
                                zzdjVar5 = zzdjVar4;
                                i92 = i46;
                                i94 = i17;
                                i93 = i93;
                                i90 = i45;
                                i13 = i13;
                                bArr8 = bArr;
                                i12 = i12;
                                i89 = 0;
                            } else {
                                i48 = i93;
                                unsafe4 = unsafe3;
                                i49 = i47;
                                i50 = i24;
                                bArr4 = bArr;
                                i51 = i45;
                                i18 = i50;
                                unsafe = unsafe4;
                                i93 = i48;
                                i91 = i49;
                                i19 = i51;
                                zzdjVar2 = zzdjVar4;
                                bArr2 = bArr4;
                                i21 = i46;
                            }
                        }
                    } else {
                        unsafe = unsafe12;
                        i13 = i13;
                        i17 = i94;
                        bArr2 = bArr8;
                        i91 = 0;
                        zzdjVar2 = zzdjVar5;
                        i18 = iZzi;
                        i19 = i96;
                        i21 = i14;
                    }
                    if (i21 == i13 || i13 == 0) {
                        if (!zzgfVar.zzh && (zzejVar = zzdjVar2.zzd) != zzej.zza && zzejVar.zzb(zzgfVar.zzg, i19) != null) {
                            throw null;
                        }
                        iZzg = zzdk.zzg(i21, bArr, i18, i12, zzd(obj), zzdjVar);
                        unsafe12 = unsafe;
                        i12 = i12;
                        i13 = i13;
                        i92 = i21;
                        zzdjVar5 = zzdjVar2;
                        i89 = 0;
                        i90 = i19;
                        bArr8 = bArr2;
                        i94 = i17;
                        iZzl = iZzg;
                    } else {
                        iZzl = i18;
                        i92 = i21;
                        i94 = i17;
                    }
                }
                i16 = iZzq;
                i15 = -1;
                if (i16 == i15) {
                    i22 = i14 & 7;
                    iArr = zzgfVar.zzc;
                    i23 = iArr[i16 + 1];
                    iZzr = zzr(i23);
                    j11 = i23 & 1048575;
                    i24 = iZzi;
                    if (iZzr <= 17) {
                        int i920 = iArr[i16 + 2];
                        i25 = 1 << (i920 >>> 20);
                        i26 = 1048575;
                        i27 = i920 & 1048575;
                        if (i27 != i94) {
                            if (i94 != 1048575) {
                                unsafe12.putInt(obj2, i94, i93);
                                i26 = 1048575;
                            }
                            if (i27 == i26) {
                                i93 = 0;
                            } else {
                                i93 = unsafe12.getInt(obj2, i27);
                            }
                            i28 = i27;
                        } else {
                            i28 = i94;
                        }
                        switch (iZzr) {
                            case 0:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 1) {
                                    iZzh = i33 + 8;
                                    i93 |= i25;
                                    zzhn.zzo(obj2, j11, Double.longBitsToDouble(zzdk.zzn(bArr3, i33)));
                                    iZzl = iZzh;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9111 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9111;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 1:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 5) {
                                    iZzh = i33 + 4;
                                    i93 |= i25;
                                    zzhn.zzp(obj2, j11, Float.intBitsToFloat(zzdk.zzb(bArr3, i33)));
                                    iZzl = iZzh;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9112 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9112;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 2:
                            case 3:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 0) {
                                    i93 |= i25;
                                    int iZzk4 = zzdk.zzk(bArr3, i33, zzdjVar3);
                                    unsafe2.putLong(obj, j11, zzdjVar3.zzb);
                                    iZzl = iZzk4;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9113 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9113;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 4:
                            case 11:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 0) {
                                    i93 |= i25;
                                    iZzh = zzdk.zzh(bArr3, i33, zzdjVar3);
                                    unsafe2.putInt(obj2, j11, zzdjVar3.zza);
                                    iZzl = iZzh;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9114 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9114;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 5:
                            case 14:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 1) {
                                    i35 = i33 + 8;
                                    i93 |= i25;
                                    unsafe2.putLong(obj, j11, zzdk.zzn(bArr3, i33));
                                    i12 = i12;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    iZzl = i35;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9115 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9115;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 6:
                            case 13:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 5) {
                                    iZzh = i33 + 4;
                                    i93 |= i25;
                                    unsafe2.putInt(obj2, j11, zzdk.zzb(bArr3, i33));
                                    iZzl = iZzh;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9116 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9116;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 7:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 0) {
                                    i93 |= i25;
                                    iZzh = zzdk.zzk(bArr3, i33, zzdjVar3);
                                    if (zzdjVar3.zzb != 0) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    zzhn.zzm(obj2, j11, z11);
                                    iZzl = iZzh;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9117 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9117;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 8:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 2) {
                                    if ((i23 & ASTNode.DISCARD) != 0) {
                                        i37 = i93 | i25;
                                        iZzh2 = zzdk.zzh(bArr3, i33, zzdjVar3);
                                        i38 = zzdjVar3.zza;
                                        if (i38 >= 0) {
                                            throw zzff.zzd();
                                        }
                                        if (i38 == 0) {
                                            zzdjVar3.zzc = "";
                                            i41 = i37;
                                        } else {
                                            int i1010 = zzhs.zza;
                                            length = bArr3.length;
                                            if ((((length - iZzh2) - i38) | iZzh2 | i38) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh2), Integer.valueOf(i38)));
                                            }
                                            i39 = iZzh2 + i38;
                                            cArr = new char[i38];
                                            i40 = 0;
                                            while (iZzh2 < i39) {
                                                b13 = bArr3[iZzh2];
                                                if (zzho.zzd(b13)) {
                                                    iZzh2++;
                                                    cArr[i40] = (char) b13;
                                                    i40++;
                                                } else {
                                                    while (iZzh2 < i39) {
                                                        i42 = iZzh2 + 1;
                                                        b11 = bArr3[iZzh2];
                                                        if (zzho.zzd(b11)) {
                                                            cArr[i40] = (char) b11;
                                                            i40++;
                                                            iZzh2 = i42;
                                                            while (iZzh2 < i39) {
                                                                b12 = bArr3[iZzh2];
                                                                if (zzho.zzd(b12)) {
                                                                }
                                                                iZzh2++;
                                                                cArr[i40] = (char) b12;
                                                                i40++;
                                                            }
                                                        } else {
                                                            i43 = i37;
                                                            if (b11 < -32) {
                                                                if (i42 < i39) {
                                                                    throw zzff.zzc();
                                                                }
                                                                iZzh2 += 2;
                                                                zzho.zzc(b11, bArr3[i42], cArr, i40);
                                                                i40++;
                                                            } else if (b11 < -16) {
                                                                if (i42 < i39 - 1) {
                                                                    throw zzff.zzc();
                                                                }
                                                                int i1011 = iZzh2 + 2;
                                                                iZzh2 += 3;
                                                                zzho.zzb(b11, bArr3[i42], bArr3[i1011], cArr, i40);
                                                                i37 = i43;
                                                                i40++;
                                                            } else {
                                                                if (i42 < i39 - 2) {
                                                                    throw zzff.zzc();
                                                                }
                                                                byte b19 = bArr3[i42];
                                                                int i1012 = iZzh2 + 3;
                                                                byte b110 = bArr3[iZzh2 + 2];
                                                                iZzh2 += 4;
                                                                zzho.zza(b11, b19, b110, bArr3[i1012], cArr, i40);
                                                                i40 += 2;
                                                            }
                                                            i37 = i43;
                                                        }
                                                        break;
                                                    }
                                                    i41 = i37;
                                                    zzdjVar3.zzc = new String(cArr, 0, i40);
                                                    iZzh2 = i39;
                                                }
                                            }
                                            while (iZzh2 < i39) {
                                                i42 = iZzh2 + 1;
                                                b11 = bArr3[iZzh2];
                                                if (zzho.zzd(b11)) {
                                                    cArr[i40] = (char) b11;
                                                    i40++;
                                                    iZzh2 = i42;
                                                    while (iZzh2 < i39) {
                                                        b12 = bArr3[iZzh2];
                                                        if (zzho.zzd(b12)) {
                                                        }
                                                        iZzh2++;
                                                        cArr[i40] = (char) b12;
                                                        i40++;
                                                    }
                                                } else {
                                                    i43 = i37;
                                                    if (b11 < -32) {
                                                        if (i42 < i39) {
                                                            throw zzff.zzc();
                                                        }
                                                        iZzh2 += 2;
                                                        zzho.zzc(b11, bArr3[i42], cArr, i40);
                                                        i40++;
                                                    } else if (b11 < -16) {
                                                        if (i42 < i39 - 1) {
                                                            throw zzff.zzc();
                                                        }
                                                        int i1013 = iZzh2 + 2;
                                                        iZzh2 += 3;
                                                        zzho.zzb(b11, bArr3[i42], bArr3[i1013], cArr, i40);
                                                        i37 = i43;
                                                        i40++;
                                                    } else {
                                                        if (i42 < i39 - 2) {
                                                            throw zzff.zzc();
                                                        }
                                                        byte b111 = bArr3[i42];
                                                        int i1014 = iZzh2 + 3;
                                                        byte b112 = bArr3[iZzh2 + 2];
                                                        iZzh2 += 4;
                                                        zzho.zza(b11, b111, b112, bArr3[i1014], cArr, i40);
                                                        i40 += 2;
                                                    }
                                                    i37 = i43;
                                                }
                                                break;
                                            }
                                            i41 = i37;
                                            zzdjVar3.zzc = new String(cArr, 0, i40);
                                            iZzh2 = i39;
                                        }
                                        iZzh = iZzh2;
                                        i93 = i41;
                                    } else {
                                        iZzh = zzdk.zzh(bArr3, i33, zzdjVar3);
                                        i36 = zzdjVar3.zza;
                                        if (i36 >= 0) {
                                            throw zzff.zzd();
                                        }
                                        int i1015 = i93 | i25;
                                        if (i36 == 0) {
                                            zzdjVar3.zzc = "";
                                        } else {
                                            zzdjVar3.zzc = new String(bArr3, iZzh, i36, zzfd.zzb);
                                            iZzh += i36;
                                        }
                                        i93 = i1015;
                                    }
                                    unsafe2.putObject(obj2, j11, zzdjVar3.zzc);
                                    iZzl = iZzh;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i9118 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9118;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 9:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 2) {
                                    i93 |= i25;
                                    Object objZzx3 = zzgfVar.zzx(obj2, i29);
                                    iZzm = zzdk.zzm(objZzx3, zzgfVar.zzv(i29), bArr, i33, i12, zzdjVar);
                                    zzgfVar.zzF(obj2, i29, objZzx3);
                                    i12 = i12;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    iZzl = iZzm;
                                    int i9119 = i34;
                                    bArr8 = bArr3;
                                    i92 = i9119;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 10:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 2) {
                                    i93 |= i25;
                                    iZzm = zzdk.zza(bArr3, i33, zzdjVar3);
                                    unsafe2.putObject(obj2, j11, zzdjVar3.zzc);
                                    i12 = i12;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    iZzl = iZzm;
                                    int i91110 = i34;
                                    bArr8 = bArr3;
                                    i92 = i91110;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 12:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 0) {
                                    int iZzh110 = zzdk.zzh(bArr3, i33, zzdjVar3);
                                    i44 = zzdjVar3.zza;
                                    i35 = iZzh110;
                                    zzfb zzfbVarZzu4 = zzgfVar.zzu(i29);
                                    if ((i23 & Integer.MIN_VALUE) != 0) {
                                        i93 |= i25;
                                        unsafe2.putInt(obj2, j11, i44);
                                    } else {
                                        i93 |= i25;
                                        unsafe2.putInt(obj2, j11, i44);
                                    }
                                    i12 = i12;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    iZzl = i35;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i91111 = i34;
                                    bArr8 = bArr3;
                                    i92 = i91111;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 15:
                                zzdjVar3 = zzdjVar5;
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                unsafe2 = unsafe12;
                                i34 = i14;
                                bArr3 = bArr;
                                if (i22 == 0) {
                                    i93 |= i25;
                                    iZzm = zzdk.zzh(bArr3, i33, zzdjVar3);
                                    unsafe2.putInt(obj2, j11, zzea.zzb(zzdjVar3.zza));
                                    i12 = i12;
                                    unsafe12 = unsafe2;
                                    zzdjVar5 = zzdjVar3;
                                    i91 = i29;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    iZzl = iZzm;
                                    int i91112 = i34;
                                    bArr8 = bArr3;
                                    i92 = i91112;
                                } else {
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            case 16:
                                i29 = i16;
                                i31 = i28;
                                i32 = i96;
                                i33 = i24;
                                i34 = i14;
                                if (i22 == 0) {
                                    i93 |= i25;
                                    bArr3 = bArr;
                                    int iZzk5 = zzdk.zzk(bArr3, i33, zzdjVar5);
                                    unsafe12.putLong(obj, j11, zzea.zzc(zzdjVar5.zzb));
                                    i12 = i12;
                                    i13 = i13;
                                    unsafe12 = unsafe12;
                                    zzdjVar5 = zzdjVar5;
                                    i91 = i29;
                                    iZzl = iZzk5;
                                    i90 = i32;
                                    i89 = 0;
                                    i94 = i31;
                                    int i91113 = i34;
                                    bArr8 = bArr3;
                                    i92 = i91113;
                                } else {
                                    bArr3 = bArr;
                                    zzdjVar3 = zzdjVar5;
                                    unsafe2 = unsafe12;
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                            default:
                                if (i22 == 3) {
                                    int i1016 = i93 | i25;
                                    Object objZzx4 = zzgfVar.zzx(obj2, i16);
                                    int i1017 = i16;
                                    iZzl = zzdk.zzl(objZzx4, zzgfVar.zzv(i16), bArr, i24, i12, (i96 << 3) | 4, zzdjVar);
                                    zzgfVar.zzF(obj2, i1017, objZzx4);
                                    i94 = i28;
                                    i13 = i13;
                                    i93 = i1016;
                                    i91 = i1017;
                                    i92 = i14;
                                    i90 = i96;
                                    i89 = 0;
                                    bArr8 = bArr;
                                    i12 = i12;
                                } else {
                                    i29 = i16;
                                    i31 = i28;
                                    i32 = i96;
                                    i33 = i24;
                                    i34 = i14;
                                    bArr3 = bArr;
                                    zzdjVar3 = zzdjVar5;
                                    unsafe2 = unsafe12;
                                    i17 = i31;
                                    i13 = i13;
                                    i18 = i33;
                                    unsafe = unsafe2;
                                    i91 = i29;
                                    i21 = i34;
                                    i19 = i32;
                                    zzdjVar2 = zzdjVar3;
                                    bArr2 = bArr3;
                                }
                                break;
                        }
                    } else {
                        i17 = i94;
                        i45 = i96;
                        zzdjVar4 = zzdjVar5;
                        i46 = i14;
                        i47 = i16;
                        unsafe3 = unsafe12;
                        if (iZzr == 27) {
                            i49 = i47;
                            i50 = i24;
                            bArr4 = bArr;
                            i48 = i93;
                            zzdjVar4 = zzdjVar4;
                            if (iZzr <= 49) {
                                j12 = i23;
                                unsafe5 = zzb;
                                zzfcVarZzd2 = (zzfc) unsafe5.getObject(obj2, j11);
                                if (!zzfcVarZzd2.zzc()) {
                                    size3 = zzfcVarZzd2.size();
                                    if (size3 == 0) {
                                        i80 = 10;
                                    } else {
                                        i80 = size3 + size3;
                                    }
                                    zzfcVarZzd2 = zzfcVarZzd2.zzd(i80);
                                    unsafe5.putObject(obj2, j11, zzfcVarZzd2);
                                }
                                zzfcVar = zzfcVarZzd2;
                                switch (iZzr) {
                                    case 18:
                                    case 35:
                                        bArr4 = bArr;
                                        i53 = i12;
                                        zzdjVar4 = zzdjVar4;
                                        i90 = i45;
                                        unsafe6 = unsafe3;
                                        if (i22 == 2) {
                                            zzegVar2 = (zzeg) zzfcVar;
                                            iZzh3 = zzdk.zzh(bArr4, i50, zzdjVar4);
                                            i54 = zzdjVar4.zza + iZzh3;
                                            while (iZzh3 < i54) {
                                                zzegVar2.zze(Double.longBitsToDouble(zzdk.zzn(bArr4, iZzh3)));
                                                iZzh3 += 8;
                                            }
                                            if (iZzh3 != i54) {
                                                throw zzff.zzg();
                                            }
                                        } else if (i22 == 1) {
                                            iZzh3 = i50 + 8;
                                            zzegVar = (zzeg) zzfcVar;
                                            zzegVar.zze(Double.longBitsToDouble(zzdk.zzn(bArr4, i50)));
                                            while (iZzh3 < i53) {
                                                iZzh4 = zzdk.zzh(bArr4, iZzh3, zzdjVar4);
                                                if (i46 == zzdjVar4.zza) {
                                                    zzegVar.zze(Double.longBitsToDouble(zzdk.zzn(bArr4, iZzh4)));
                                                    iZzh3 = iZzh4 + 8;
                                                }
                                            }
                                        } else {
                                            iZzh3 = i50;
                                        }
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        bArr4 = bArr;
                                        i53 = i12;
                                        zzdjVar4 = zzdjVar4;
                                        i90 = i45;
                                        unsafe6 = unsafe3;
                                        if (i22 == 2) {
                                            zzeqVar2 = (zzeq) zzfcVar;
                                            iZzh3 = zzdk.zzh(bArr4, i50, zzdjVar4);
                                            i55 = zzdjVar4.zza + iZzh3;
                                            while (iZzh3 < i55) {
                                                zzeqVar2.zze(Float.intBitsToFloat(zzdk.zzb(bArr4, iZzh3)));
                                                iZzh3 += 4;
                                            }
                                            if (iZzh3 != i55) {
                                                throw zzff.zzg();
                                            }
                                        } else if (i22 == 5) {
                                            iZzh3 = i50 + 4;
                                            zzeqVar = (zzeq) zzfcVar;
                                            zzeqVar.zze(Float.intBitsToFloat(zzdk.zzb(bArr4, i50)));
                                            while (iZzh3 < i53) {
                                                iZzh5 = zzdk.zzh(bArr4, iZzh3, zzdjVar4);
                                                if (i46 == zzdjVar4.zza) {
                                                    zzeqVar.zze(Float.intBitsToFloat(zzdk.zzb(bArr4, iZzh5)));
                                                    iZzh3 = iZzh5 + 4;
                                                }
                                            }
                                        } else {
                                            iZzh3 = i50;
                                        }
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        bArr4 = bArr;
                                        i53 = i12;
                                        zzdjVar4 = zzdjVar4;
                                        i90 = i45;
                                        unsafe6 = unsafe3;
                                        if (i22 == 2) {
                                            zzfrVar2 = (zzfr) zzfcVar;
                                            iZzh3 = zzdk.zzh(bArr4, i50, zzdjVar4);
                                            i56 = zzdjVar4.zza + iZzh3;
                                            while (iZzh3 < i56) {
                                                iZzh3 = zzdk.zzk(bArr4, iZzh3, zzdjVar4);
                                                zzfrVar2.zzf(zzdjVar4.zzb);
                                            }
                                            if (iZzh3 != i56) {
                                                throw zzff.zzg();
                                            }
                                        } else if (i22 == 0) {
                                            zzfrVar = (zzfr) zzfcVar;
                                            iZzh3 = zzdk.zzk(bArr4, i50, zzdjVar4);
                                            zzfrVar.zzf(zzdjVar4.zzb);
                                            while (iZzh3 < i53) {
                                                iZzh6 = zzdk.zzh(bArr4, iZzh3, zzdjVar4);
                                                if (i46 == zzdjVar4.zza) {
                                                    iZzh3 = zzdk.zzk(bArr4, iZzh6, zzdjVar4);
                                                    zzfrVar.zzf(zzdjVar4.zzb);
                                                }
                                            }
                                        } else {
                                            iZzh3 = i50;
                                        }
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 22:
                                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                    case 39:
                                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                        bArr4 = bArr;
                                        unsafe7 = unsafe3;
                                        i53 = i12;
                                        i57 = i49;
                                        i58 = i50;
                                        zzdjVar4 = zzdjVar4;
                                        i59 = i45;
                                        if (i22 == 2) {
                                            iZzf = zzdk.zzf(bArr4, i58, zzfcVar, zzdjVar4);
                                            unsafe6 = unsafe7;
                                            iZzh3 = iZzf;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                        } else if (i22 == 0) {
                                            unsafe6 = unsafe7;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            iZzh3 = zzdk.zzj(i46, bArr, i58, i12, zzfcVar, zzdjVar);
                                        } else {
                                            unsafe6 = unsafe7;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            iZzh3 = i50;
                                        }
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                        bArr4 = bArr;
                                        unsafe7 = unsafe3;
                                        i53 = i12;
                                        i57 = i49;
                                        i58 = i50;
                                        zzdjVar4 = zzdjVar4;
                                        i59 = i45;
                                        if (i22 == 2) {
                                            if (i22 == 1) {
                                                iZze = i58 + 8;
                                                zzfrVar3 = (zzfr) zzfcVar;
                                                zzfrVar3.zzf(zzdk.zzn(bArr4, i58));
                                                while (iZze < i53) {
                                                    iZzh7 = zzdk.zzh(bArr4, iZze, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        unsafe6 = unsafe7;
                                                        i50 = i58;
                                                        i90 = i59;
                                                        iZzh3 = iZze;
                                                        i49 = i57;
                                                        if (iZzh3 != i50) {
                                                            i13 = i13;
                                                            i12 = i53;
                                                            i91 = i49;
                                                            unsafe12 = unsafe6;
                                                            zzdjVar5 = zzdjVar4;
                                                            i92 = i46;
                                                            i94 = i17;
                                                            i93 = i48;
                                                            i89 = 0;
                                                            obj2 = obj;
                                                            iZzl = iZzh3;
                                                            bArr8 = bArr4;
                                                        } else {
                                                            obj2 = obj;
                                                            i18 = iZzh3;
                                                            i91 = i49;
                                                            i19 = i90;
                                                            unsafe = unsafe6;
                                                            i93 = i48;
                                                            zzdjVar2 = zzdjVar4;
                                                            bArr2 = bArr4;
                                                            i21 = i46;
                                                        }
                                                    } else {
                                                        zzfrVar3.zzf(zzdk.zzn(bArr4, iZzh7));
                                                        iZze = iZzh7 + 8;
                                                    }
                                                    break;
                                                }
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i90 = i59;
                                                iZzh3 = iZze;
                                                i49 = i57;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            unsafe6 = unsafe7;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        } else {
                                            zzfrVar4 = (zzfr) zzfcVar;
                                            iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                            i60 = zzdjVar4.zza + iZzf;
                                            while (iZzf < i60) {
                                                zzfrVar4.zzf(zzdk.zzn(bArr4, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i60) {
                                                throw zzff.zzg();
                                            }
                                            unsafe6 = unsafe7;
                                            iZzh3 = iZzf;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case VungleException.WEB_CRASH /* 31 */:
                                    case 41:
                                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                        bArr4 = bArr;
                                        unsafe7 = unsafe3;
                                        i53 = i12;
                                        i57 = i49;
                                        i58 = i50;
                                        zzdjVar4 = zzdjVar4;
                                        i59 = i45;
                                        if (i22 == 2) {
                                            if (i22 == 5) {
                                                iZze = i58 + 4;
                                                zzeyVar = (zzey) zzfcVar;
                                                zzeyVar.zzf(zzdk.zzb(bArr4, i58));
                                                while (iZze < i53) {
                                                    iZzh8 = zzdk.zzh(bArr4, iZze, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        unsafe6 = unsafe7;
                                                        i50 = i58;
                                                        i90 = i59;
                                                        iZzh3 = iZze;
                                                        i49 = i57;
                                                        if (iZzh3 != i50) {
                                                            i13 = i13;
                                                            i12 = i53;
                                                            i91 = i49;
                                                            unsafe12 = unsafe6;
                                                            zzdjVar5 = zzdjVar4;
                                                            i92 = i46;
                                                            i94 = i17;
                                                            i93 = i48;
                                                            i89 = 0;
                                                            obj2 = obj;
                                                            iZzl = iZzh3;
                                                            bArr8 = bArr4;
                                                        } else {
                                                            obj2 = obj;
                                                            i18 = iZzh3;
                                                            i91 = i49;
                                                            i19 = i90;
                                                            unsafe = unsafe6;
                                                            i93 = i48;
                                                            zzdjVar2 = zzdjVar4;
                                                            bArr2 = bArr4;
                                                            i21 = i46;
                                                        }
                                                    } else {
                                                        zzeyVar.zzf(zzdk.zzb(bArr4, iZzh8));
                                                        iZze = iZzh8 + 4;
                                                    }
                                                    break;
                                                }
                                                unsafe6 = unsafe7;
                                                i50 = i58;
                                                i90 = i59;
                                                iZzh3 = iZze;
                                                i49 = i57;
                                                if (iZzh3 != i50) {
                                                    i13 = i13;
                                                    i12 = i53;
                                                    i91 = i49;
                                                    unsafe12 = unsafe6;
                                                    zzdjVar5 = zzdjVar4;
                                                    i92 = i46;
                                                    i94 = i17;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    obj2 = obj;
                                                    iZzl = iZzh3;
                                                    bArr8 = bArr4;
                                                } else {
                                                    obj2 = obj;
                                                    i18 = iZzh3;
                                                    i91 = i49;
                                                    i19 = i90;
                                                    unsafe = unsafe6;
                                                    i93 = i48;
                                                    zzdjVar2 = zzdjVar4;
                                                    bArr2 = bArr4;
                                                    i21 = i46;
                                                }
                                            }
                                            unsafe6 = unsafe7;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                            break;
                                        } else {
                                            zzeyVar2 = (zzey) zzfcVar;
                                            iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                            i61 = zzdjVar4.zza + iZzf;
                                            while (iZzf < i61) {
                                                zzeyVar2.zzf(zzdk.zzb(bArr4, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i61) {
                                                throw zzff.zzg();
                                            }
                                            unsafe6 = unsafe7;
                                            iZzh3 = iZzf;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        }
                                        break;
                                    case 25:
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        bArr4 = bArr;
                                        unsafe7 = unsafe3;
                                        i53 = i12;
                                        i57 = i49;
                                        i58 = i50;
                                        zzdjVar4 = zzdjVar4;
                                        i59 = i45;
                                        if (i22 == 2) {
                                            if (i22 == 0) {
                                                zzdlVar = (zzdl) zzfcVar;
                                                iZzf = zzdk.zzk(bArr4, i58, zzdjVar4);
                                                if (zzdjVar4.zzb != 0) {
                                                    z12 = true;
                                                } else {
                                                    z12 = false;
                                                }
                                                zzdlVar.zze(z12);
                                                while (iZzf < i53) {
                                                    iZzh9 = zzdk.zzh(bArr4, iZzf, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzf = zzdk.zzk(bArr4, iZzh9, zzdjVar4);
                                                        if (zzdjVar4.zzb != 0) {
                                                            z13 = true;
                                                        } else {
                                                            z13 = false;
                                                        }
                                                        zzdlVar.zze(z13);
                                                    }
                                                }
                                            }
                                            unsafe6 = unsafe7;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            zzdlVar2 = (zzdl) zzfcVar;
                                            iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                            i62 = zzdjVar4.zza + iZzf;
                                            while (iZzf < i62) {
                                                iZzf = zzdk.zzk(bArr4, iZzf, zzdjVar4);
                                                if (zzdjVar4.zzb != 0) {
                                                    z14 = true;
                                                } else {
                                                    z14 = false;
                                                }
                                                zzdlVar2.zze(z14);
                                            }
                                            if (iZzf != i62) {
                                                throw zzff.zzg();
                                            }
                                        }
                                        unsafe6 = unsafe7;
                                        iZzh3 = iZzf;
                                        i50 = i58;
                                        i49 = i57;
                                        i90 = i59;
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 26:
                                        unsafe7 = unsafe3;
                                        i53 = i12;
                                        i57 = i49;
                                        i58 = i50;
                                        i59 = i45;
                                        bArr4 = bArr;
                                        zzdjVar4 = zzdjVar4;
                                        if (i22 == 2) {
                                            if ((j12 & 536870912) == 0) {
                                                iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                i67 = zzdjVar4.zza;
                                                if (i67 >= 0) {
                                                    throw zzff.zzd();
                                                }
                                                if (i67 == 0) {
                                                    zzfcVar.add("");
                                                } else {
                                                    zzfcVar.add(new String(bArr4, iZzf, i67, zzfd.zzb));
                                                    iZzf += i67;
                                                }
                                                while (iZzf < i53) {
                                                    iZzh11 = zzdk.zzh(bArr4, iZzf, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzf = zzdk.zzh(bArr4, iZzh11, zzdjVar4);
                                                        i68 = zzdjVar4.zza;
                                                        if (i68 >= 0) {
                                                            throw zzff.zzd();
                                                        }
                                                        if (i68 == 0) {
                                                            zzfcVar.add("");
                                                        } else {
                                                            zzfcVar.add(new String(bArr4, iZzf, i68, zzfd.zzb));
                                                            iZzf += i68;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzf = zzdk.zzh(bArr4, i58, zzdjVar4);
                                                i63 = zzdjVar4.zza;
                                                if (i63 >= 0) {
                                                    throw zzff.zzd();
                                                }
                                                if (i63 == 0) {
                                                    zzfcVar.add("");
                                                } else {
                                                    i64 = iZzf + i63;
                                                    if (zzhs.zze(bArr4, iZzf, i64)) {
                                                        throw zzff.zzc();
                                                    }
                                                    zzfcVar.add(new String(bArr4, iZzf, i63, zzfd.zzb));
                                                    iZzf = i64;
                                                }
                                                while (iZzf < i53) {
                                                    iZzh10 = zzdk.zzh(bArr4, iZzf, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzf = zzdk.zzh(bArr4, iZzh10, zzdjVar4);
                                                        i65 = zzdjVar4.zza;
                                                        if (i65 >= 0) {
                                                            throw zzff.zzd();
                                                        }
                                                        if (i65 == 0) {
                                                            zzfcVar.add("");
                                                        } else {
                                                            i66 = iZzf + i65;
                                                            if (zzhs.zze(bArr4, iZzf, i66)) {
                                                                throw zzff.zzc();
                                                            }
                                                            zzfcVar.add(new String(bArr4, iZzf, i65, zzfd.zzb));
                                                            iZzf = i66;
                                                        }
                                                    }
                                                }
                                            }
                                            unsafe6 = unsafe7;
                                            iZzh3 = iZzf;
                                            i50 = i58;
                                            i49 = i57;
                                            i90 = i59;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        }
                                        unsafe6 = unsafe7;
                                        i50 = i58;
                                        i49 = i57;
                                        i90 = i59;
                                        iZzh3 = i50;
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 27:
                                        bArr5 = bArr;
                                        if (i22 == 2) {
                                            zzgfVar = this;
                                            i57 = i49;
                                            i53 = i12;
                                            iZze = zzdk.zze(zzgfVar.zzv(i49), i46, bArr, i50, i12, zzfcVar, zzdjVar);
                                            unsafe6 = unsafe3;
                                            bArr4 = bArr;
                                            i50 = i50;
                                            i90 = i45;
                                            zzdjVar4 = zzdjVar4;
                                            iZzh3 = iZze;
                                            i49 = i57;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            i53 = i12;
                                            zzgfVar = this;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            unsafe6 = unsafe3;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        }
                                        break;
                                    case 28:
                                        bArr5 = bArr;
                                        if (i22 == 2) {
                                            iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                            i69 = zzdjVar4.zza;
                                            if (i69 >= 0) {
                                                throw zzff.zzd();
                                            }
                                            if (i69 <= bArr5.length - iZzh3) {
                                                throw zzff.zzg();
                                            }
                                            if (i69 == 0) {
                                                zzfcVar.add(zzdw.zzb);
                                            } else {
                                                zzfcVar.add(zzdw.zzl(bArr5, iZzh3, i69));
                                                iZzh3 += i69;
                                            }
                                            while (iZzh3 < i12) {
                                                iZzh12 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                if (i46 == zzdjVar4.zza) {
                                                    i90 = i45;
                                                    i53 = i12;
                                                    zzgfVar = this;
                                                    bArr4 = bArr5;
                                                    zzdjVar4 = zzdjVar4;
                                                    unsafe6 = unsafe3;
                                                    if (iZzh3 != i50) {
                                                        i13 = i13;
                                                        i12 = i53;
                                                        i91 = i49;
                                                        unsafe12 = unsafe6;
                                                        zzdjVar5 = zzdjVar4;
                                                        i92 = i46;
                                                        i94 = i17;
                                                        i93 = i48;
                                                        i89 = 0;
                                                        obj2 = obj;
                                                        iZzl = iZzh3;
                                                        bArr8 = bArr4;
                                                    } else {
                                                        obj2 = obj;
                                                        i18 = iZzh3;
                                                        i91 = i49;
                                                        i19 = i90;
                                                        unsafe = unsafe6;
                                                        i93 = i48;
                                                        zzdjVar2 = zzdjVar4;
                                                        bArr2 = bArr4;
                                                        i21 = i46;
                                                    }
                                                    break;
                                                } else {
                                                    iZzh3 = zzdk.zzh(bArr5, iZzh12, zzdjVar4);
                                                    i70 = zzdjVar4.zza;
                                                    if (i70 >= 0) {
                                                        throw zzff.zzd();
                                                    }
                                                    if (i70 <= bArr5.length - iZzh3) {
                                                        throw zzff.zzg();
                                                    }
                                                    if (i70 == 0) {
                                                        zzfcVar.add(zzdw.zzb);
                                                    } else {
                                                        zzfcVar.add(zzdw.zzl(bArr5, iZzh3, i70));
                                                        iZzh3 += i70;
                                                    }
                                                }
                                            }
                                            i90 = i45;
                                            i53 = i12;
                                            zzgfVar = this;
                                            bArr4 = bArr5;
                                            zzdjVar4 = zzdjVar4;
                                            unsafe6 = unsafe3;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            i90 = i45;
                                            i53 = i12;
                                            zzgfVar = this;
                                            bArr4 = bArr5;
                                            unsafe6 = unsafe3;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        }
                                        break;
                                    case 30:
                                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                        bArr5 = bArr;
                                        i71 = i12;
                                        if (i22 == 2) {
                                            iZzj = zzdk.zzf(bArr5, i50, zzfcVar, zzdjVar4);
                                        } else if (i22 == 0) {
                                            zzgfVar = this;
                                            i53 = i71;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            unsafe6 = unsafe3;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            iZzj = zzdk.zzj(i46, bArr, i50, i12, zzfcVar, zzdjVar);
                                        }
                                        zzfbVarZzu = zzgfVar.zzu(i49);
                                        zzhdVar = zzgfVar.zzm;
                                        int i1018 = zzgo.zza;
                                        if (zzfbVarZzu != null) {
                                            i72 = iZzj;
                                            i73 = i45;
                                        } else if (zzfcVar instanceof RandomAccess) {
                                            size2 = zzfcVar.size();
                                            objZzo2 = null;
                                            i74 = 0;
                                            i75 = 0;
                                            while (i74 < size2) {
                                                int i1019 = iZzj;
                                                iIntValue2 = ((Integer) zzfcVar.get(i74)).intValue();
                                                if (zzfbVarZzu.zza(iIntValue2)) {
                                                    if (i74 != i75) {
                                                        zzfcVar.set(i75, Integer.valueOf(iIntValue2));
                                                    }
                                                    i75++;
                                                    i76 = i45;
                                                } else {
                                                    i76 = i45;
                                                    objZzo2 = zzgo.zzo(obj2, i76, iIntValue2, objZzo2, zzhdVar);
                                                }
                                                i74++;
                                                i45 = i76;
                                                iZzj = i1019;
                                            }
                                            i72 = iZzj;
                                            i73 = i45;
                                            if (i75 != size2) {
                                                zzfcVar.subList(i75, size2).clear();
                                            }
                                        } else {
                                            i72 = iZzj;
                                            i73 = i45;
                                            it = zzfcVar.iterator();
                                            objZzo = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!zzfbVarZzu.zza(iIntValue)) {
                                                    objZzo = zzgo.zzo(obj2, i73, iIntValue, objZzo, zzhdVar);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        i90 = i73;
                                        i53 = i71;
                                        iZzh3 = i72;
                                        zzgfVar = this;
                                        bArr4 = bArr5;
                                        zzdjVar4 = zzdjVar4;
                                        unsafe6 = unsafe3;
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 33:
                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                        bArr5 = bArr;
                                        i71 = i12;
                                        if (i22 == 2) {
                                            if (i22 == 0) {
                                                zzeyVar3 = (zzey) zzfcVar;
                                                iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                                zzeyVar3.zzf(zzea.zzb(zzdjVar4.zza));
                                                while (iZzh3 < i71) {
                                                    iZzh13 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzh3 = zzdk.zzh(bArr5, iZzh13, zzdjVar4);
                                                        zzeyVar3.zzf(zzea.zzb(zzdjVar4.zza));
                                                    }
                                                }
                                            }
                                            i53 = i71;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            unsafe6 = unsafe3;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            zzeyVar4 = (zzey) zzfcVar;
                                            iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                            i77 = zzdjVar4.zza + iZzh3;
                                            while (iZzh3 < i77) {
                                                iZzh3 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                zzeyVar4.zzf(zzea.zzb(zzdjVar4.zza));
                                            }
                                            if (iZzh3 != i77) {
                                                throw zzff.zzg();
                                            }
                                        }
                                        i53 = i71;
                                        i90 = i45;
                                        bArr4 = bArr5;
                                        zzdjVar4 = zzdjVar4;
                                        unsafe6 = unsafe3;
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        bArr5 = bArr;
                                        i71 = i12;
                                        if (i22 == 2) {
                                            if (i22 == 0) {
                                                zzfrVar5 = (zzfr) zzfcVar;
                                                iZzh3 = zzdk.zzk(bArr5, i50, zzdjVar4);
                                                zzfrVar5.zzf(zzea.zzc(zzdjVar4.zzb));
                                                while (iZzh3 < i71) {
                                                    iZzh14 = zzdk.zzh(bArr5, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzh3 = zzdk.zzk(bArr5, iZzh14, zzdjVar4);
                                                        zzfrVar5.zzf(zzea.zzc(zzdjVar4.zzb));
                                                    }
                                                }
                                            }
                                            i53 = i71;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            unsafe6 = unsafe3;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            zzfrVar6 = (zzfr) zzfcVar;
                                            iZzh3 = zzdk.zzh(bArr5, i50, zzdjVar4);
                                            i78 = zzdjVar4.zza + iZzh3;
                                            while (iZzh3 < i78) {
                                                iZzh3 = zzdk.zzk(bArr5, iZzh3, zzdjVar4);
                                                zzfrVar6.zzf(zzea.zzc(zzdjVar4.zzb));
                                            }
                                            if (iZzh3 != i78) {
                                                throw zzff.zzg();
                                            }
                                        }
                                        i53 = i71;
                                        i90 = i45;
                                        bArr4 = bArr5;
                                        zzdjVar4 = zzdjVar4;
                                        unsafe6 = unsafe3;
                                        if (iZzh3 != i50) {
                                            i13 = i13;
                                            i12 = i53;
                                            i91 = i49;
                                            unsafe12 = unsafe6;
                                            zzdjVar5 = zzdjVar4;
                                            i92 = i46;
                                            i94 = i17;
                                            i93 = i48;
                                            i89 = 0;
                                            obj2 = obj;
                                            iZzl = iZzh3;
                                            bArr8 = bArr4;
                                        } else {
                                            obj2 = obj;
                                            i18 = iZzh3;
                                            i91 = i49;
                                            i19 = i90;
                                            unsafe = unsafe6;
                                            i93 = i48;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                        }
                                        break;
                                    default:
                                        if (i22 == 3) {
                                            i79 = (i46 & (-8)) | 4;
                                            zzgmVarZzv = zzgfVar.zzv(i49);
                                            iZzh3 = zzdk.zzc(zzgmVarZzv, bArr, i50, i12, i79, zzdjVar);
                                            zzfcVar.add(zzdjVar4.zzc);
                                            i71 = i12;
                                            while (true) {
                                                if (iZzh3 < i71) {
                                                    iZzh15 = zzdk.zzh(bArr, iZzh3, zzdjVar4);
                                                    if (i46 == zzdjVar4.zza) {
                                                        iZzh3 = zzdk.zzc(zzgmVarZzv, bArr, iZzh15, i12, i79, zzdjVar);
                                                        zzfcVar.add(zzdjVar4.zzc);
                                                        zzgmVarZzv = zzgmVarZzv;
                                                    } else {
                                                        bArr5 = bArr;
                                                    }
                                                } else {
                                                    bArr5 = bArr;
                                                }
                                            }
                                            i53 = i71;
                                            i90 = i45;
                                            bArr4 = bArr5;
                                            zzdjVar4 = zzdjVar4;
                                            unsafe6 = unsafe3;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        } else {
                                            bArr4 = bArr;
                                            i53 = i12;
                                            i90 = i45;
                                            unsafe6 = unsafe3;
                                            iZzh3 = i50;
                                            if (iZzh3 != i50) {
                                                i13 = i13;
                                                i12 = i53;
                                                i91 = i49;
                                                unsafe12 = unsafe6;
                                                zzdjVar5 = zzdjVar4;
                                                i92 = i46;
                                                i94 = i17;
                                                i93 = i48;
                                                i89 = 0;
                                                obj2 = obj;
                                                iZzl = iZzh3;
                                                bArr8 = bArr4;
                                            } else {
                                                obj2 = obj;
                                                i18 = iZzh3;
                                                i91 = i49;
                                                i19 = i90;
                                                unsafe = unsafe6;
                                                i93 = i48;
                                                zzdjVar2 = zzdjVar4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                zzdjVar4 = zzdjVar4;
                                i51 = i45;
                                unsafe4 = unsafe3;
                                if (iZzr == 50) {
                                    unsafe9 = zzb;
                                    j13 = iArr[i49 + 2] & 1048575;
                                    switch (iZzr) {
                                        case 51:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 1) {
                                                iZzh16 = i81 + 8;
                                                unsafe9.putObject(obj2, j11, Double.valueOf(Double.longBitsToDouble(zzdk.zzn(bArr2, i81))));
                                                unsafe9.putInt(obj2, j13, i19);
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 52:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 5) {
                                                iZzh16 = i81 + 4;
                                                unsafe9.putObject(obj2, j11, Float.valueOf(Float.intBitsToFloat(zzdk.zzb(bArr2, i81))));
                                                unsafe9.putInt(obj2, j13, i19);
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 0) {
                                                iZzk = zzdk.zzk(bArr2, i81, zzdjVar2);
                                                unsafe9.putObject(obj2, j11, Long.valueOf(zzdjVar2.zzb));
                                                unsafe9.putInt(obj2, j13, i19);
                                                iZzh16 = iZzk;
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 0) {
                                                iZzh16 = zzdk.zzh(bArr2, i81, zzdjVar2);
                                                unsafe9.putObject(obj2, j11, Integer.valueOf(zzdjVar2.zza));
                                                unsafe9.putInt(obj2, j13, i19);
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 56:
                                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 1) {
                                                iZzh16 = i81 + 8;
                                                unsafe9.putObject(obj2, j11, Long.valueOf(zzdk.zzn(bArr2, i81)));
                                                unsafe9.putInt(obj2, j13, i19);
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                        case 64:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 5) {
                                                iZzh16 = i81 + 4;
                                                unsafe9.putObject(obj2, j11, Integer.valueOf(zzdk.zzb(bArr2, i81)));
                                                unsafe9.putInt(obj2, j13, i19);
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 58:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 0) {
                                                iZzk = zzdk.zzk(bArr2, i81, zzdjVar2);
                                                if (zzdjVar2.zzb != 0) {
                                                    z15 = true;
                                                } else {
                                                    z15 = false;
                                                }
                                                unsafe9.putObject(obj2, j11, Boolean.valueOf(z15));
                                                unsafe9.putInt(obj2, j13, i19);
                                                iZzh16 = iZzk;
                                            } else {
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 59:
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            obj2 = obj;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            if (i22 == 2) {
                                                iZzh17 = zzdk.zzh(bArr2, i81, zzdjVar2);
                                                i83 = zzdjVar2.zza;
                                                if (i83 == 0) {
                                                    unsafe9.putObject(obj2, j11, "");
                                                } else {
                                                    i84 = iZzh17 + i83;
                                                    if ((i23 & ASTNode.DISCARD) == 0) {
                                                    }
                                                    unsafe9.putObject(obj2, j11, new String(bArr2, iZzh17, i83, zzfd.zzb));
                                                    iZzh17 = i84;
                                                }
                                                unsafe9.putInt(obj2, j13, i19);
                                                iZzh16 = iZzh17;
                                            } else {
                                                i82 = i82;
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 60:
                                            obj2 = obj;
                                            i81 = i50;
                                            i85 = i49;
                                            i19 = i51;
                                            i21 = i46;
                                            zzdjVar2 = zzdjVar4;
                                            if (i22 == 2) {
                                                Object objZzy3 = zzgfVar.zzy(obj2, i19, i85);
                                                bArr2 = bArr4;
                                                unsafe = unsafe4;
                                                iZzh16 = zzdk.zzm(objZzy3, zzgfVar.zzv(i85), bArr, i81, i12, zzdjVar);
                                                zzgfVar.zzG(obj2, i19, i85, objZzy3);
                                                i82 = i85;
                                            } else {
                                                bArr2 = bArr4;
                                                unsafe = unsafe4;
                                                i82 = i85;
                                                iZzh16 = i81;
                                            }
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 61:
                                            i81 = i50;
                                            unsafe10 = unsafe4;
                                            bArr6 = bArr4;
                                            i21 = i46;
                                            zzdjVar2 = zzdjVar4;
                                            obj2 = obj;
                                            i86 = i49;
                                            i19 = i51;
                                            if (i22 == 2) {
                                                iZza = zzdk.zza(bArr6, i81, zzdjVar2);
                                                unsafe9.putObject(obj2, j11, zzdjVar2.zzc);
                                                unsafe9.putInt(obj2, j13, i19);
                                                bArr2 = bArr6;
                                                iZzh16 = iZza;
                                                i82 = i86;
                                                unsafe = unsafe10;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            }
                                            bArr2 = bArr6;
                                            i82 = i86;
                                            unsafe = unsafe10;
                                            iZzh16 = i81;
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 63:
                                            i81 = i50;
                                            unsafe10 = unsafe4;
                                            bArr6 = bArr4;
                                            zzdjVar2 = zzdjVar4;
                                            obj2 = obj;
                                            i86 = i49;
                                            i19 = i51;
                                            if (i22 == 0) {
                                                iZza = zzdk.zzh(bArr6, i81, zzdjVar2);
                                                i87 = zzdjVar2.zza;
                                                zzfbVarZzu2 = zzgfVar.zzu(i86);
                                                if (zzfbVarZzu2 != null) {
                                                    i21 = i46;
                                                    unsafe9.putObject(obj2, j11, Integer.valueOf(i87));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                } else {
                                                    i21 = i46;
                                                    unsafe9.putObject(obj2, j11, Integer.valueOf(i87));
                                                    unsafe9.putInt(obj2, j13, i19);
                                                }
                                                bArr2 = bArr6;
                                                iZzh16 = iZza;
                                                i82 = i86;
                                                unsafe = unsafe10;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            } else {
                                                i21 = i46;
                                                bArr2 = bArr6;
                                                i82 = i86;
                                                unsafe = unsafe10;
                                                iZzh16 = i81;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            }
                                            break;
                                        case 66:
                                            i81 = i50;
                                            unsafe11 = unsafe4;
                                            bArr7 = bArr4;
                                            i88 = i46;
                                            zzdjVar2 = zzdjVar4;
                                            obj2 = obj;
                                            i85 = i49;
                                            i19 = i51;
                                            if (i22 == 0) {
                                                iZzh18 = zzdk.zzh(bArr7, i81, zzdjVar2);
                                                unsafe9.putObject(obj2, j11, Integer.valueOf(zzea.zzb(zzdjVar2.zza)));
                                                unsafe9.putInt(obj2, j13, i19);
                                                bArr2 = bArr7;
                                                iZzh16 = iZzh18;
                                                unsafe = unsafe11;
                                                i21 = i88;
                                                i82 = i85;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            }
                                            bArr2 = bArr7;
                                            unsafe = unsafe11;
                                            i21 = i88;
                                            i82 = i85;
                                            iZzh16 = i81;
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                            i81 = i50;
                                            unsafe11 = unsafe4;
                                            bArr7 = bArr4;
                                            i88 = i46;
                                            zzdjVar2 = zzdjVar4;
                                            obj2 = obj;
                                            i85 = i49;
                                            i19 = i51;
                                            if (i22 == 0) {
                                                iZzh18 = zzdk.zzk(bArr7, i81, zzdjVar2);
                                                unsafe9.putObject(obj2, j11, Long.valueOf(zzea.zzc(zzdjVar2.zzb)));
                                                unsafe9.putInt(obj2, j13, i19);
                                                bArr2 = bArr7;
                                                iZzh16 = iZzh18;
                                                unsafe = unsafe11;
                                                i21 = i88;
                                                i82 = i85;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            }
                                            bArr2 = bArr7;
                                            unsafe = unsafe11;
                                            i21 = i88;
                                            i82 = i85;
                                            iZzh16 = i81;
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                        case 68:
                                            if (i22 == 3) {
                                                obj2 = obj;
                                                Object objZzy4 = zzgfVar.zzy(obj2, i51, i49);
                                                i85 = i49;
                                                i81 = i50;
                                                zzdjVar2 = zzdjVar4;
                                                int iZzl3 = zzdk.zzl(objZzy4, zzgfVar.zzv(i49), bArr, i81, i12, (i46 & (-8)) | 4, zzdjVar);
                                                zzgfVar.zzG(obj2, i51, i85, objZzy4);
                                                bArr2 = bArr4;
                                                unsafe = unsafe4;
                                                iZzh16 = iZzl3;
                                                i21 = i46;
                                                i19 = i51;
                                                i82 = i85;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            } else {
                                                obj2 = obj;
                                                zzdjVar2 = zzdjVar4;
                                                i81 = i50;
                                                unsafe = unsafe4;
                                                bArr2 = bArr4;
                                                i21 = i46;
                                                i82 = i49;
                                                i19 = i51;
                                                iZzh16 = i81;
                                                if (iZzh16 != i81) {
                                                    i81 = i81;
                                                    unsafe12 = unsafe;
                                                    i12 = i12;
                                                    i13 = i13;
                                                    i90 = i19;
                                                    i92 = i21;
                                                    zzdjVar5 = zzdjVar2;
                                                    i91 = i82;
                                                    i93 = i48;
                                                    i89 = 0;
                                                    iZzl = iZzh16;
                                                    bArr8 = bArr2;
                                                    i94 = i17;
                                                } else {
                                                    i81 = i81;
                                                    i13 = i13;
                                                    i18 = iZzh16;
                                                    i91 = i82;
                                                    i93 = i48;
                                                }
                                            }
                                            break;
                                        default:
                                            obj2 = obj;
                                            i81 = i50;
                                            i82 = i49;
                                            i19 = i51;
                                            unsafe = unsafe4;
                                            zzdjVar2 = zzdjVar4;
                                            bArr2 = bArr4;
                                            i21 = i46;
                                            iZzh16 = i81;
                                            if (iZzh16 != i81) {
                                                i81 = i81;
                                                unsafe12 = unsafe;
                                                i12 = i12;
                                                i13 = i13;
                                                i90 = i19;
                                                i92 = i21;
                                                zzdjVar5 = zzdjVar2;
                                                i91 = i82;
                                                i93 = i48;
                                                i89 = 0;
                                                iZzl = iZzh16;
                                                bArr8 = bArr2;
                                                i94 = i17;
                                            } else {
                                                i81 = i81;
                                                i13 = i13;
                                                i18 = iZzh16;
                                                i91 = i82;
                                                i93 = i48;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i22 == 2) {
                                        unsafe8 = zzb;
                                        Object objZzw2 = zzgfVar.zzw(i49);
                                        object = unsafe8.getObject(obj, j11);
                                        if (!((zzfw) object).zze()) {
                                            zzfw zzfwVarZzb2 = zzfw.zza().zzb();
                                            zzfx.zza(zzfwVarZzb2, object);
                                            unsafe8.putObject(obj, j11, zzfwVarZzb2);
                                        }
                                        throw null;
                                    }
                                    obj2 = obj;
                                    i18 = i50;
                                    unsafe = unsafe4;
                                    i93 = i48;
                                    i91 = i49;
                                    i19 = i51;
                                    zzdjVar2 = zzdjVar4;
                                    bArr2 = bArr4;
                                    i21 = i46;
                                }
                            }
                        } else if (i22 == 2) {
                            zzfcVarZzd = (zzfc) unsafe3.getObject(obj2, j11);
                            if (!zzfcVarZzd.zzc()) {
                                size = zzfcVarZzd.size();
                                if (size == 0) {
                                    i52 = 10;
                                } else {
                                    i52 = size + size;
                                }
                                zzfcVarZzd = zzfcVarZzd.zzd(i52);
                                unsafe3.putObject(obj2, j11, zzfcVarZzd);
                            }
                            unsafe12 = unsafe3;
                            iZzl = zzdk.zze(zzgfVar.zzv(i47), i46, bArr, i24, i12, zzfcVarZzd, zzdjVar);
                            i91 = i47;
                            zzdjVar5 = zzdjVar4;
                            i92 = i46;
                            i94 = i17;
                            i93 = i93;
                            i90 = i45;
                            i13 = i13;
                            bArr8 = bArr;
                            i12 = i12;
                            i89 = 0;
                        } else {
                            i48 = i93;
                            unsafe4 = unsafe3;
                            i49 = i47;
                            i50 = i24;
                            bArr4 = bArr;
                            i51 = i45;
                            i18 = i50;
                            unsafe = unsafe4;
                            i93 = i48;
                            i91 = i49;
                            i19 = i51;
                            zzdjVar2 = zzdjVar4;
                            bArr2 = bArr4;
                            i21 = i46;
                        }
                    }
                } else {
                    unsafe = unsafe12;
                    i13 = i13;
                    i17 = i94;
                    bArr2 = bArr8;
                    i91 = 0;
                    zzdjVar2 = zzdjVar5;
                    i18 = iZzi;
                    i19 = i96;
                    i21 = i14;
                }
                if (i21 == i13) {
                }
                iZzg = !zzgfVar.zzh ? zzdk.zzg(i21, bArr, i18, i12, zzd(obj), zzdjVar) : zzdk.zzg(i21, bArr, i18, i12, zzd(obj), zzdjVar);
                unsafe12 = unsafe;
                i12 = i12;
                i13 = i13;
                i92 = i21;
                zzdjVar5 = zzdjVar2;
                i89 = 0;
                i90 = i19;
                bArr8 = bArr2;
                i94 = i17;
                iZzl = iZzg;
            } else {
                unsafe = unsafe12;
                i13 = i13;
            }
        }
        if (i94 != 1048575) {
            unsafe.putInt(obj2, i94, i93);
        }
        for (int i110 = zzgfVar.zzj; i110 < zzgfVar.zzk; i110++) {
            int[] iArr2 = zzgfVar.zzi;
            int[] iArr3 = zzgfVar.zzc;
            int i111 = iArr2[i110];
            int i112 = iArr3[i111];
            Object objZzf = zzhn.zzf(obj2, zzgfVar.zzs(i111) & 1048575);
            if (objZzf != null && zzgfVar.zzu(i111) != null) {
                throw null;
            }
        }
        if (i13 == 0) {
            if (iZzl != i12) {
                throw zzff.zze();
            }
        } else if (iZzl > i12 || i92 != i13) {
            throw zzff.zze();
        }
        return iZzl;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final Object zze() {
        return ((zzex) this.zzg).zzi();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzex) {
                zzex zzexVar = (zzex) obj;
                zzexVar.zzq(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                zzexVar.zza = 0;
                zzexVar.zzo();
            }
            int[] iArr = this.zzc;
            for (int i11 = 0; i11 < iArr.length; i11 += 3) {
                int iZzs = zzs(i11);
                int i12 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j11 = i12;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i11)) {
                                    zzv(i11).zzf(zzb.getObject(obj, j11));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
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
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                            case 48:
                            case 49:
                                this.zzl.zza(obj, j11);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j11);
                                if (object != null) {
                                    ((zzfw) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i11], i11)) {
                        zzv(i11).zzf(zzb.getObject(obj, j11));
                    }
                } else if (zzI(obj, i11)) {
                    zzv(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzs = zzs(i11);
            int i12 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i13 = iArr[i11];
            long j11 = i12;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i11)) {
                        zzhn.zzo(obj, j11, zzhn.zza(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i11)) {
                        zzhn.zzp(obj, j11, zzhn.zzb(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i11)) {
                        zzhn.zzm(obj, j11, zzhn.zzw(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i11);
                    break;
                case 10:
                    if (zzI(obj2, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i11)) {
                        zzhn.zzq(obj, j11, zzhn.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i11)) {
                        zzhn.zzr(obj, j11, zzhn.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i11);
                    break;
                case 18:
                case 19:
                case 20:
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
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    this.zzl.zzb(obj, obj2, j11);
                    break;
                case 50:
                    int i14 = zzgo.zza;
                    zzhn.zzs(obj, j11, zzfx.zza(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                case 58:
                case 59:
                    if (zzM(obj2, i13, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzE(obj, i13, i11);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj2, i13, i11)) {
                        zzhn.zzs(obj, j11, zzhn.zzf(obj2, j11));
                        zzE(obj, i13, i11);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i11);
                    break;
            }
        }
        zzgo.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzh(Object obj, byte[] bArr, int i11, int i12, zzdj zzdjVar) throws IOException {
        zzc(obj, bArr, i11, i12, 0, zzdjVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final void zzi(Object obj, zzhv zzhvVar) throws IOException {
        int i11;
        int i12;
        int i13;
        if (this.zzh) {
            this.zzn.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        while (i17 < iArr.length) {
            int iZzs = zzs(i17);
            int[] iArr2 = this.zzc;
            int iZzr = zzr(iZzs);
            int i18 = iArr2[i17];
            if (iZzr <= 17) {
                int i19 = iArr2[i17 + 2];
                int i21 = i19 & i14;
                if (i21 != i15) {
                    i16 = i21 == i14 ? 0 : unsafe.getInt(obj, i21);
                    i15 = i21;
                }
                i11 = i15;
                i12 = i16;
                i13 = 1 << (i19 >>> 20);
            } else {
                i11 = i15;
                i12 = i16;
                i13 = 0;
            }
            long j11 = iZzs & i14;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzf(i18, zzhn.zza(obj, j11));
                    }
                    break;
                case 1:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzo(i18, zzhn.zzb(obj, j11));
                    }
                    break;
                case 2:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzt(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 3:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzJ(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 4:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzr(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 5:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzm(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 6:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzk(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 7:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzb(i18, zzhn.zzw(obj, j11));
                    }
                    break;
                case 8:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzO(i18, unsafe.getObject(obj, j11), zzhvVar);
                    }
                    break;
                case 9:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzv(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    break;
                case 10:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzd(i18, (zzdw) unsafe.getObject(obj, j11));
                    }
                    break;
                case 11:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzH(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 12:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzi(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 13:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzw(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 14:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzy(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 15:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzA(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 16:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzC(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 17:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        zzhvVar.zzq(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    break;
                case 18:
                    zzgo.zzs(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 19:
                    zzgo.zzw(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 20:
                    zzgo.zzy(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 21:
                    zzgo.zzE(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 22:
                    zzgo.zzx(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 23:
                    zzgo.zzv(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 24:
                    zzgo.zzu(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 25:
                    zzgo.zzr(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 26:
                    int i22 = this.zzc[i17];
                    List list = (List) unsafe.getObject(obj, j11);
                    int i23 = zzgo.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhvVar.zzG(i22, list);
                    }
                    break;
                case 27:
                    int i24 = this.zzc[i17];
                    List list2 = (List) unsafe.getObject(obj, j11);
                    zzgm zzgmVarZzv = zzv(i17);
                    int i25 = zzgo.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i26 = 0; i26 < list2.size(); i26++) {
                            ((zzef) zzhvVar).zzv(i24, list2.get(i26), zzgmVarZzv);
                        }
                    }
                    break;
                case 28:
                    int i27 = this.zzc[i17];
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i28 = zzgo.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhvVar.zze(i27, list3);
                    }
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    zzgo.zzD(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 30:
                    zzgo.zzt(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    zzgo.zzz(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 32:
                    zzgo.zzA(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 33:
                    zzgo.zzB(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 34:
                    zzgo.zzC(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, false);
                    break;
                case 35:
                    zzgo.zzs(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 36:
                    zzgo.zzw(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 37:
                    zzgo.zzy(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 38:
                    zzgo.zzE(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 39:
                    zzgo.zzx(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 40:
                    zzgo.zzv(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 41:
                    zzgo.zzu(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzgo.zzr(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzgo.zzD(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzgo.zzt(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzgo.zzz(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzgo.zzA(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzgo.zzB(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 48:
                    zzgo.zzC(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzhvVar, true);
                    break;
                case 49:
                    int i29 = this.zzc[i17];
                    List list4 = (List) unsafe.getObject(obj, j11);
                    zzgm zzgmVarZzv2 = zzv(i17);
                    int i31 = zzgo.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i32 = 0; i32 < list4.size(); i32++) {
                            ((zzef) zzhvVar).zzq(i29, list4.get(i32), zzgmVarZzv2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j11) != null) {
                        throw null;
                    }
                    break;
                    break;
                case 51:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzf(i18, zzm(obj, j11));
                    }
                    break;
                case 52:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzo(i18, zzn(obj, j11));
                    }
                    break;
                case 53:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzt(i18, zzt(obj, j11));
                    }
                    break;
                case 54:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzJ(i18, zzt(obj, j11));
                    }
                    break;
                case 55:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzr(i18, zzo(obj, j11));
                    }
                    break;
                case 56:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzm(i18, zzt(obj, j11));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzk(i18, zzo(obj, j11));
                    }
                    break;
                case 58:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzb(i18, zzN(obj, j11));
                    }
                    break;
                case 59:
                    if (zzM(obj, i18, i17)) {
                        zzO(i18, unsafe.getObject(obj, j11), zzhvVar);
                    }
                    break;
                case 60:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzv(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    break;
                case 61:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzd(i18, (zzdw) unsafe.getObject(obj, j11));
                    }
                    break;
                case 62:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzH(i18, zzo(obj, j11));
                    }
                    break;
                case 63:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzi(i18, zzo(obj, j11));
                    }
                    break;
                case 64:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzw(i18, zzo(obj, j11));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzy(i18, zzt(obj, j11));
                    }
                    break;
                case 66:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzA(i18, zzo(obj, j11));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzC(i18, zzt(obj, j11));
                    }
                    break;
                case 68:
                    if (zzM(obj, i18, i17)) {
                        zzhvVar.zzq(i18, unsafe.getObject(obj, j11), zzv(i17));
                    }
                    break;
            }
            i17 += 3;
            i15 = i11;
            i16 = i12;
            i14 = 1048575;
        }
        zzhd zzhdVar = this.zzm;
        zzhdVar.zzi(zzhdVar.zzd(obj), zzhvVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzF;
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzs = zzs(i11);
            long j11 = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i11) || Double.doubleToLongBits(zzhn.zza(obj, j11)) != Double.doubleToLongBits(zzhn.zza(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i11) || Float.floatToIntBits(zzhn.zzb(obj, j11)) != Float.floatToIntBits(zzhn.zzb(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i11) || zzhn.zzd(obj, j11) != zzhn.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i11) || zzhn.zzd(obj, j11) != zzhn.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i11) || zzhn.zzc(obj, j11) != zzhn.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i11) || zzhn.zzd(obj, j11) != zzhn.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i11) || zzhn.zzc(obj, j11) != zzhn.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i11) || zzhn.zzw(obj, j11) != zzhn.zzw(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i11) || !zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i11) || !zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i11) || !zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i11) || zzhn.zzc(obj, j11) != zzhn.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i11) || zzhn.zzc(obj, j11) != zzhn.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i11) || zzhn.zzc(obj, j11) != zzhn.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i11) || zzhn.zzd(obj, j11) != zzhn.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i11) || zzhn.zzc(obj, j11) != zzhn.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i11) || zzhn.zzd(obj, j11) != zzhn.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i11) || !zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
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
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    zZzF = zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11));
                    break;
                case 50:
                    zZzF = zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                case 68:
                    long jZzp = zzp(i11) & 1048575;
                    if (zzhn.zzc(obj, jZzp) != zzhn.zzc(obj2, jZzp) || !zzgo.zzF(zzhn.zzf(obj, j11), zzhn.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzF) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        this.zzn.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00af  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c5 A[LOOP:1: B:45:0x00b4->B:50:0x00c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzk(Object obj) {
        int i11;
        int i12;
        List list;
        zzgm zzgmVarZzv;
        int i13;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i17 = iArr[i16];
            int i18 = iArr2[i17];
            int iZzs = zzs(i17);
            int i19 = this.zzc[i17 + 2];
            int i21 = i19 & 1048575;
            int i22 = 1 << (i19 >>> 20);
            if (i21 != i14) {
                if (i21 != 1048575) {
                    i15 = zzb.getInt(obj, i21);
                }
                i12 = i15;
                i11 = i21;
            } else {
                i11 = i14;
                i12 = i15;
            }
            if ((268435456 & iZzs) != 0 && !zzJ(obj, i17, i11, i12, i22)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i17, i11, i12, i22) && !zzK(obj, iZzs, zzv(i17))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzhn.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgmVarZzv = zzv(i17);
                    for (i13 = 0; i13 < list.size(); i13++) {
                        if (!zzgmVarZzv.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i18, i17) && !zzK(obj, iZzs, zzv(i17))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzhn.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzgmVarZzv = zzv(i17);
                    while (i13 < list.size()) {
                        if (!zzgmVarZzv.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzfw) zzhn.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i16++;
            i14 = i11;
            i15 = i12;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        throw null;
    }
}
