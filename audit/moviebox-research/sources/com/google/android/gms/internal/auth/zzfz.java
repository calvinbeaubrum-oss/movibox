package com.google.android.gms.internal.auth;

import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i11, int i12, zzfw zzfwVar, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzh = z11;
        this.zzi = iArr2;
        this.zzj = i13;
        this.zzk = i14;
        this.zzo = zzgbVar;
        this.zzl = zzfkVar;
        this.zzm = zzgyVar;
        this.zzn = zzelVar;
        this.zzg = zzfwVar;
        this.zzp = zzfrVar;
    }

    private static Field zzA(Class cls, String str) {
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

    private final void zzB(Object obj, Object obj2, int i11) {
        long jZzv = zzv(i11) & 1048575;
        if (zzG(obj2, i11)) {
            Object objZzf = zzhi.zzf(obj, jZzv);
            Object objZzf2 = zzhi.zzf(obj2, jZzv);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, jZzv, zzez.zzg(objZzf, objZzf2));
                zzD(obj, i11);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, jZzv, objZzf2);
                zzD(obj, i11);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i11) {
        int iZzv = zzv(i11);
        int i12 = this.zzc[i11];
        long j11 = iZzv & 1048575;
        if (zzJ(obj2, i12, i11)) {
            Object objZzf = zzJ(obj, i12, i11) ? zzhi.zzf(obj, j11) : null;
            Object objZzf2 = zzhi.zzf(obj2, j11);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, j11, zzez.zzg(objZzf, objZzf2));
                zzE(obj, i12, i11);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, j11, objZzf2);
                zzE(obj, i12, i11);
            }
        }
    }

    private final void zzD(Object obj, int i11) {
        int iZzs = zzs(i11);
        long j11 = 1048575 & iZzs;
        if (j11 == 1048575) {
            return;
        }
        zzhi.zzn(obj, j11, (1 << (iZzs >>> 20)) | zzhi.zzc(obj, j11));
    }

    private final void zzE(Object obj, int i11, int i12) {
        zzhi.zzn(obj, zzs(i12) & 1048575, i11);
    }

    private final boolean zzF(Object obj, Object obj2, int i11) {
        return zzG(obj, i11) == zzG(obj2, i11);
    }

    private final boolean zzG(Object obj, int i11) {
        int iZzs = zzs(i11);
        long j11 = iZzs & 1048575;
        if (j11 != 1048575) {
            return (zzhi.zzc(obj, j11) & (1 << (iZzs >>> 20))) != 0;
        }
        int iZzv = zzv(i11);
        long j12 = iZzv & 1048575;
        switch (zzu(iZzv)) {
            case 0:
                return Double.doubleToRawLongBits(zzhi.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhi.zzb(obj, j12)) != 0;
            case 2:
                return zzhi.zzd(obj, j12) != 0;
            case 3:
                return zzhi.zzd(obj, j12) != 0;
            case 4:
                return zzhi.zzc(obj, j12) != 0;
            case 5:
                return zzhi.zzd(obj, j12) != 0;
            case 6:
                return zzhi.zzc(obj, j12) != 0;
            case 7:
                return zzhi.zzt(obj, j12);
            case 8:
                Object objZzf = zzhi.zzf(obj, j12);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzee) {
                    return !zzee.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhi.zzf(obj, j12) != null;
            case 10:
                return !zzee.zzb.equals(zzhi.zzf(obj, j12));
            case 11:
                return zzhi.zzc(obj, j12) != 0;
            case 12:
                return zzhi.zzc(obj, j12) != 0;
            case 13:
                return zzhi.zzc(obj, j12) != 0;
            case 14:
                return zzhi.zzd(obj, j12) != 0;
            case 15:
                return zzhi.zzc(obj, j12) != 0;
            case 16:
                return zzhi.zzd(obj, j12) != 0;
            case 17:
                return zzhi.zzf(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(Object obj, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return zzG(obj, i11);
        }
        return (i13 & i14) != 0;
    }

    private static boolean zzI(Object obj, int i11, zzgh zzghVar) {
        return zzghVar.zzi(zzhi.zzf(obj, i11 & 1048575));
    }

    private final boolean zzJ(Object obj, int i11, int i12) {
        return zzhi.zzc(obj, (long) (zzs(i12) & 1048575)) == i11;
    }

    public static zzgz zzc(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar != zzgz.zza()) {
            return zzgzVar;
        }
        zzgz zzgzVarZzc = zzgz.zzc();
        zzeuVar.zzc = zzgzVarZzc;
        return zzgzVarZzc;
    }

    public static zzfz zzj(Class cls, zzft zzftVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        if (zzftVar instanceof zzgg) {
            return zzk((zzgg) zzftVar, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar);
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0264  */
    /* JADX WARN: Code duplicated, block: B:128:0x027a  */
    /* JADX WARN: Code duplicated, block: B:130:0x027e  */
    /* JADX WARN: Code duplicated, block: B:164:0x0334  */
    /* JADX WARN: Code duplicated, block: B:180:0x0384  */
    /* JADX WARN: Code duplicated, block: B:183:0x038e  */
    public static zzfz zzk(zzgg zzggVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        int i11;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        char cCharAt;
        int i17;
        char cCharAt2;
        int i18;
        char cCharAt3;
        int i19;
        char cCharAt4;
        int i21;
        char cCharAt5;
        int i22;
        char cCharAt6;
        int i23;
        char cCharAt7;
        int i24;
        char cCharAt8;
        int i25;
        int i26;
        int i27;
        int[] iArr2;
        int i28;
        int i29;
        int i31;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Object[] objArr;
        int i32;
        int i33;
        Field fieldZzA;
        char cCharAt9;
        int i34;
        int i35;
        int i36;
        int i37;
        Object obj;
        Field fieldZzA2;
        int i38;
        Object obj2;
        Field fieldZzA3;
        int i39;
        char cCharAt10;
        int i40;
        char cCharAt11;
        int i41;
        char cCharAt12;
        int i42;
        char cCharAt13;
        boolean z11 = zzggVar.zzc() == 2;
        String strZzd = zzggVar.zzd();
        int length = strZzd.length();
        char c11 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i43 = 1;
            while (true) {
                i11 = i43 + 1;
                if (strZzd.charAt(i43) < 55296) {
                    break;
                }
                i43 = i11;
            }
        } else {
            i11 = 1;
        }
        int i44 = i11 + 1;
        int iCharAt4 = strZzd.charAt(i11);
        if (iCharAt4 >= 55296) {
            int i45 = iCharAt4 & 8191;
            int i46 = 13;
            while (true) {
                i42 = i44 + 1;
                cCharAt13 = strZzd.charAt(i44);
                if (cCharAt13 < 55296) {
                    break;
                }
                i45 |= (cCharAt13 & 8191) << i46;
                i46 += 13;
                i44 = i42;
            }
            iCharAt4 = i45 | (cCharAt13 << i46);
            i44 = i42;
        }
        if (iCharAt4 == 0) {
            iArr = zza;
            i13 = 0;
            iCharAt = 0;
            i15 = 0;
            iCharAt2 = 0;
            i14 = 0;
            iCharAt3 = 0;
            i12 = 0;
        } else {
            int i47 = i44 + 1;
            int iCharAt5 = strZzd.charAt(i44);
            if (iCharAt5 >= 55296) {
                int i48 = iCharAt5 & 8191;
                int i49 = 13;
                while (true) {
                    i24 = i47 + 1;
                    cCharAt8 = strZzd.charAt(i47);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt8 & 8191) << i49;
                    i49 += 13;
                    i47 = i24;
                }
                iCharAt5 = i48 | (cCharAt8 << i49);
                i47 = i24;
            }
            int i50 = i47 + 1;
            int iCharAt6 = strZzd.charAt(i47);
            if (iCharAt6 >= 55296) {
                int i51 = iCharAt6 & 8191;
                int i52 = 13;
                while (true) {
                    i23 = i50 + 1;
                    cCharAt7 = strZzd.charAt(i50);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt7 & 8191) << i52;
                    i52 += 13;
                    i50 = i23;
                }
                iCharAt6 = i51 | (cCharAt7 << i52);
                i50 = i23;
            }
            int i53 = i50 + 1;
            iCharAt = strZzd.charAt(i50);
            if (iCharAt >= 55296) {
                int i54 = iCharAt & 8191;
                int i55 = 13;
                while (true) {
                    i22 = i53 + 1;
                    cCharAt6 = strZzd.charAt(i53);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt6 & 8191) << i55;
                    i55 += 13;
                    i53 = i22;
                }
                iCharAt = i54 | (cCharAt6 << i55);
                i53 = i22;
            }
            int i56 = i53 + 1;
            int iCharAt7 = strZzd.charAt(i53);
            if (iCharAt7 >= 55296) {
                int i57 = iCharAt7 & 8191;
                int i58 = 13;
                while (true) {
                    i21 = i56 + 1;
                    cCharAt5 = strZzd.charAt(i56);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt5 & 8191) << i58;
                    i58 += 13;
                    i56 = i21;
                }
                iCharAt7 = i57 | (cCharAt5 << i58);
                i56 = i21;
            }
            int i59 = i56 + 1;
            iCharAt2 = strZzd.charAt(i56);
            if (iCharAt2 >= 55296) {
                int i60 = iCharAt2 & 8191;
                int i61 = 13;
                while (true) {
                    i19 = i59 + 1;
                    cCharAt4 = strZzd.charAt(i59);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt4 & 8191) << i61;
                    i61 += 13;
                    i59 = i19;
                }
                iCharAt2 = i60 | (cCharAt4 << i61);
                i59 = i19;
            }
            int i62 = i59 + 1;
            int iCharAt8 = strZzd.charAt(i59);
            if (iCharAt8 >= 55296) {
                int i63 = iCharAt8 & 8191;
                int i64 = 13;
                while (true) {
                    i18 = i62 + 1;
                    cCharAt3 = strZzd.charAt(i62);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt3 & 8191) << i64;
                    i64 += 13;
                    i62 = i18;
                }
                iCharAt8 = i63 | (cCharAt3 << i64);
                i62 = i18;
            }
            int i65 = i62 + 1;
            int iCharAt9 = strZzd.charAt(i62);
            if (iCharAt9 >= 55296) {
                int i66 = iCharAt9 & 8191;
                int i67 = 13;
                while (true) {
                    i17 = i65 + 1;
                    cCharAt2 = strZzd.charAt(i65);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i66 |= (cCharAt2 & 8191) << i67;
                    i67 += 13;
                    i65 = i17;
                }
                iCharAt9 = i66 | (cCharAt2 << i67);
                i65 = i17;
            }
            int i68 = i65 + 1;
            iCharAt3 = strZzd.charAt(i65);
            if (iCharAt3 >= 55296) {
                int i69 = iCharAt3 & 8191;
                int i70 = 13;
                while (true) {
                    i16 = i68 + 1;
                    cCharAt = strZzd.charAt(i68);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i69 |= (cCharAt & 8191) << i70;
                    i70 += 13;
                    i68 = i16;
                }
                iCharAt3 = i69 | (cCharAt << i70);
                i68 = i16;
            }
            iArr = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i12 = iCharAt5 + iCharAt5 + iCharAt6;
            i13 = iCharAt5;
            i44 = i68;
            int i71 = iCharAt8;
            i14 = iCharAt7;
            i15 = i71;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzggVar.zze();
        Class<?> cls = zzggVar.zza().getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 + iCharAt2];
        int i72 = iCharAt3 + i15;
        int i73 = iCharAt3;
        int i74 = i72;
        int i75 = 0;
        int i76 = 0;
        while (i44 < length) {
            int i77 = i44 + 1;
            int iCharAt10 = strZzd.charAt(i44);
            if (iCharAt10 >= c11) {
                int i78 = iCharAt10 & 8191;
                int i79 = i77;
                int i80 = 13;
                while (true) {
                    i41 = i79 + 1;
                    cCharAt12 = strZzd.charAt(i79);
                    if (cCharAt12 < c11) {
                        break;
                    }
                    i78 |= (cCharAt12 & 8191) << i80;
                    i80 += 13;
                    i79 = i41;
                }
                iCharAt10 = i78 | (cCharAt12 << i80);
                i25 = i41;
            } else {
                i25 = i77;
            }
            int i81 = i25 + 1;
            int iCharAt11 = strZzd.charAt(i25);
            if (iCharAt11 >= c11) {
                int i82 = iCharAt11 & 8191;
                int i83 = i81;
                int i84 = 13;
                while (true) {
                    i40 = i83 + 1;
                    cCharAt11 = strZzd.charAt(i83);
                    i26 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i82 |= (cCharAt11 & 8191) << i84;
                    i84 += 13;
                    i83 = i40;
                    length = i26;
                }
                iCharAt11 = i82 | (cCharAt11 << i84);
                i27 = i40;
            } else {
                i26 = length;
                i27 = i81;
            }
            int i85 = iCharAt11 & 255;
            int i86 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i76] = i75;
                i76++;
            }
            if (i85 >= 51) {
                int i87 = i27 + 1;
                int iCharAt12 = strZzd.charAt(i27);
                if (iCharAt12 >= 55296) {
                    int i88 = iCharAt12 & 8191;
                    int i89 = i87;
                    int i90 = 13;
                    while (true) {
                        i39 = i89 + 1;
                        cCharAt10 = strZzd.charAt(i89);
                        i29 = i14;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i88 |= (cCharAt10 & 8191) << i90;
                        i90 += 13;
                        i89 = i39;
                        i14 = i29;
                    }
                    iCharAt12 = i88 | (cCharAt10 << i90);
                    i35 = i39;
                } else {
                    i29 = i14;
                    i35 = i87;
                }
                int i91 = i85 - 51;
                int i92 = i35;
                if (i91 == 9 || i91 == 17) {
                    int i93 = i75 / 3;
                    i36 = i12 + 1;
                    objArr2[i93 + i93 + 1] = objArrZze[i12];
                } else {
                    if (i91 == 12 && !z11) {
                        int i94 = i75 / 3;
                        i36 = i12 + 1;
                        objArr2[i94 + i94 + 1] = objArrZze[i12];
                    }
                    i37 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i37];
                    if (obj instanceof Field) {
                        fieldZzA2 = (Field) obj;
                    } else {
                        fieldZzA2 = zzA(cls, (String) obj);
                        objArrZze[i37] = fieldZzA2;
                    }
                    iArr2 = iArr3;
                    i28 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzA2);
                    i38 = i37 + 1;
                    obj2 = objArrZze[i38];
                    if (obj2 instanceof Field) {
                        fieldZzA3 = (Field) obj2;
                    } else {
                        fieldZzA3 = zzA(cls, (String) obj2);
                        objArrZze[i38] = fieldZzA3;
                    }
                    strZzd = strZzd;
                    i13 = i13;
                    objArr = objArr2;
                    i31 = i12;
                    i32 = i92;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i33 = 0;
                }
                i12 = i36;
                i37 = iCharAt12 + iCharAt12;
                obj = objArrZze[i37];
                if (obj instanceof Field) {
                    fieldZzA2 = (Field) obj;
                } else {
                    fieldZzA2 = zzA(cls, (String) obj);
                    objArrZze[i37] = fieldZzA2;
                }
                iArr2 = iArr3;
                i28 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzA2);
                i38 = i37 + 1;
                obj2 = objArrZze[i38];
                if (obj2 instanceof Field) {
                    fieldZzA3 = (Field) obj2;
                } else {
                    fieldZzA3 = zzA(cls, (String) obj2);
                    objArrZze[i38] = fieldZzA3;
                }
                strZzd = strZzd;
                i13 = i13;
                objArr = objArr2;
                i31 = i12;
                i32 = i92;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i33 = 0;
            } else {
                iArr2 = iArr3;
                i28 = iCharAt;
                i29 = i14;
                int i95 = i12 + 1;
                Field fieldZzA4 = zzA(cls, (String) objArrZze[i12]);
                if (i85 == 9 || i85 == 17) {
                    int i96 = i75 / 3;
                    objArr2[i96 + i96 + 1] = fieldZzA4.getType();
                } else {
                    if (i85 == 27 || i85 == 49) {
                        int i97 = i75 / 3;
                        i34 = i12 + 2;
                        objArr2[i97 + i97 + 1] = objArrZze[i95];
                    } else if (i85 == 12 || i85 == 30 || i85 == 44) {
                        if (!z11) {
                            int i98 = i75 / 3;
                            i34 = i12 + 2;
                            objArr2[i98 + i98 + 1] = objArrZze[i95];
                        }
                    } else if (i85 == 50) {
                        int i99 = i73 + 1;
                        iArr[i73] = i75;
                        int i100 = i75 / 3;
                        int i101 = i100 + i100;
                        int i102 = i12 + 2;
                        objArr2[i101] = objArrZze[i95];
                        if ((iCharAt11 & 2048) != 0) {
                            i95 = i12 + 3;
                            objArr2[i101 + 1] = objArrZze[i102];
                            i73 = i99;
                        } else {
                            i73 = i99;
                            i31 = i102;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                        iObjectFieldOffset2 = 1048575;
                        objArr = objArr2;
                        if ((iCharAt11 & 4096) == 4096 || i85 > 17) {
                            i32 = i27;
                            i33 = 0;
                        } else {
                            int i103 = i27 + 1;
                            int iCharAt13 = strZzd.charAt(i27);
                            if (iCharAt13 >= 55296) {
                                int i104 = iCharAt13 & 8191;
                                int i105 = 13;
                                while (true) {
                                    i32 = i103 + 1;
                                    cCharAt9 = strZzd.charAt(i103);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i104 |= (cCharAt9 & 8191) << i105;
                                    i105 += 13;
                                    i103 = i32;
                                }
                                iCharAt13 = i104 | (cCharAt9 << i105);
                            } else {
                                i32 = i103;
                            }
                            int i106 = i13 + i13 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i106];
                            if (obj3 instanceof Field) {
                                fieldZzA = (Field) obj3;
                            } else {
                                fieldZzA = zzA(cls, (String) obj3);
                                objArrZze[i106] = fieldZzA;
                            }
                            i33 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA);
                        }
                        if (i85 >= 18 && i85 <= 49) {
                            iArr[i74] = iObjectFieldOffset;
                            i74++;
                        }
                    }
                    i31 = i34;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                    iObjectFieldOffset2 = 1048575;
                    objArr = objArr2;
                    if ((iCharAt11 & 4096) == 4096) {
                        i32 = i27;
                        i33 = 0;
                    } else {
                        i32 = i27;
                        i33 = 0;
                    }
                    if (i85 >= 18) {
                        iArr[i74] = iObjectFieldOffset;
                        i74++;
                    }
                }
                i31 = i95;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
                iObjectFieldOffset2 = 1048575;
                objArr = objArr2;
                if ((iCharAt11 & 4096) == 4096) {
                    i32 = i27;
                    i33 = 0;
                } else {
                    i32 = i27;
                    i33 = 0;
                }
                if (i85 >= 18) {
                    iArr[i74] = iObjectFieldOffset;
                    i74++;
                }
            }
            int i107 = i75 + 1;
            iArr2[i75] = iCharAt10;
            int i108 = i75 + 2;
            iArr2[i107] = ((iCharAt11 & 256) != 0 ? ASTNode.DEOP : 0) | ((iCharAt11 & 512) != 0 ? ASTNode.DISCARD : 0) | (i85 << 20) | iObjectFieldOffset;
            i75 += 3;
            iArr2[i108] = (i33 << 20) | iObjectFieldOffset2;
            i13 = i13;
            i12 = i31;
            iCharAt = i28;
            iCharAt3 = i86;
            i44 = i32;
            length = i26;
            objArr2 = objArr;
            strZzd = strZzd;
            iArr3 = iArr2;
            i14 = i29;
            c11 = 55296;
        }
        return new zzfz(iArr3, objArr2, iCharAt, i14, zzggVar.zza(), z11, false, iArr, iCharAt3, i72, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar, null);
    }

    private static int zzl(Object obj, long j11) {
        return ((Integer) zzhi.zzf(obj, j11)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzz = zzz(i13);
        Object object = unsafe.getObject(obj, j11);
        if (!((zzfq) object).zze()) {
            zzfq zzfqVarZzb = zzfq.zza().zzb();
            zzfr.zza(zzfqVarZzb, object);
            unsafe.putObject(obj, j11, zzfqVarZzb);
        }
        throw null;
    }

    private final int zzn(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        long j12 = this.zzc[i18 + 2] & 1048575;
        switch (i17) {
            case 51:
                if (i15 != 1) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i11))));
                unsafe.putInt(obj, j12, i14);
                return i11 + 8;
            case 52:
                if (i15 != 5) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i11))));
                unsafe.putInt(obj, j12, i14);
                return i11 + 4;
            case 53:
            case 54:
                if (i15 != 0) {
                    return i11;
                }
                int iZzm = zzdt.zzm(bArr, i11, zzdsVar);
                unsafe.putObject(obj, j11, Long.valueOf(zzdsVar.zzb));
                unsafe.putInt(obj, j12, i14);
                return iZzm;
            case 55:
            case 62:
                if (i15 != 0) {
                    return i11;
                }
                int iZzj = zzdt.zzj(bArr, i11, zzdsVar);
                unsafe.putObject(obj, j11, Integer.valueOf(zzdsVar.zza));
                unsafe.putInt(obj, j12, i14);
                return iZzj;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i15 != 1) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Long.valueOf(zzdt.zzn(bArr, i11)));
                unsafe.putInt(obj, j12, i14);
                return i11 + 8;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
            case 64:
                if (i15 != 5) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Integer.valueOf(zzdt.zzb(bArr, i11)));
                unsafe.putInt(obj, j12, i14);
                return i11 + 4;
            case 58:
                if (i15 != 0) {
                    return i11;
                }
                int iZzm2 = zzdt.zzm(bArr, i11, zzdsVar);
                unsafe.putObject(obj, j11, Boolean.valueOf(zzdsVar.zzb != 0));
                unsafe.putInt(obj, j12, i14);
                return iZzm2;
            case 59:
                if (i15 != 2) {
                    return i11;
                }
                int iZzj2 = zzdt.zzj(bArr, i11, zzdsVar);
                int i19 = zzdsVar.zza;
                if (i19 == 0) {
                    unsafe.putObject(obj, j11, "");
                } else {
                    if ((i16 & ASTNode.DISCARD) != 0 && !zzhm.zzd(bArr, iZzj2, iZzj2 + i19)) {
                        throw zzfa.zzb();
                    }
                    unsafe.putObject(obj, j11, new String(bArr, iZzj2, i19, zzez.zzb));
                    iZzj2 += i19;
                }
                unsafe.putInt(obj, j12, i14);
                return iZzj2;
            case 60:
                if (i15 != 2) {
                    return i11;
                }
                int iZzd = zzdt.zzd(zzy(i18), bArr, i11, i12, zzdsVar);
                Object object = unsafe.getInt(obj, j12) == i14 ? unsafe.getObject(obj, j11) : null;
                if (object == null) {
                    unsafe.putObject(obj, j11, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j11, zzez.zzg(object, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j12, i14);
                return iZzd;
            case 61:
                if (i15 != 2) {
                    return i11;
                }
                int iZza = zzdt.zza(bArr, i11, zzdsVar);
                unsafe.putObject(obj, j11, zzdsVar.zzc);
                unsafe.putInt(obj, j12, i14);
                return iZza;
            case 63:
                if (i15 != 0) {
                    return i11;
                }
                int iZzj3 = zzdt.zzj(bArr, i11, zzdsVar);
                int i21 = zzdsVar.zza;
                zzex zzexVarZzx = zzx(i18);
                if (zzexVarZzx == null || zzexVarZzx.zza()) {
                    unsafe.putObject(obj, j11, Integer.valueOf(i21));
                    unsafe.putInt(obj, j12, i14);
                } else {
                    zzc(obj).zzf(i13, Long.valueOf(i21));
                }
                return iZzj3;
            case 66:
                if (i15 != 0) {
                    return i11;
                }
                int iZzj4 = zzdt.zzj(bArr, i11, zzdsVar);
                unsafe.putObject(obj, j11, Integer.valueOf(zzei.zzb(zzdsVar.zza)));
                unsafe.putInt(obj, j12, i14);
                return iZzj4;
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                if (i15 != 0) {
                    return i11;
                }
                int iZzm3 = zzdt.zzm(bArr, i11, zzdsVar);
                unsafe.putObject(obj, j11, Long.valueOf(zzei.zzc(zzdsVar.zzb)));
                unsafe.putInt(obj, j12, i14);
                return iZzm3;
            case 68:
                if (i15 != 3) {
                    return i11;
                }
                int iZzc = zzdt.zzc(zzy(i18), bArr, i11, i12, (i13 & (-8)) | 4, zzdsVar);
                Object object2 = unsafe.getInt(obj, j12) == i14 ? unsafe.getObject(obj, j11) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j11, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j11, zzez.zzg(object2, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j12, i14);
                return iZzc;
            default:
                return i11;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0082. Please report as an issue. */
    private final int zzo(Object obj, byte[] bArr, int i11, int i12, zzds zzdsVar) throws IOException {
        int i13;
        int iZzk;
        int i14;
        int i15;
        Unsafe unsafe;
        int i16;
        int i17;
        int i18;
        int iZzm;
        int iZzd;
        int i19;
        int i21;
        int i22;
        zzfz<T> zzfzVar = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i23 = i12;
        zzdsVar = zzdsVar;
        Unsafe unsafe2 = zzb;
        int i24 = 1048575;
        int i25 = -1;
        int iZzi = i11;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 1048575;
        while (iZzi < i23) {
            int i31 = iZzi + 1;
            byte b11 = bArr2[iZzi];
            if (b11 < 0) {
                iZzk = zzdt.zzk(b11, bArr2, i31, zzdsVar);
                i13 = zzdsVar.zza;
            } else {
                i13 = b11;
                iZzk = i31;
            }
            int i32 = i13 >>> 3;
            int i33 = i13 & 7;
            int iZzr = i32 > i26 ? zzfzVar.zzr(i32, i27 / 3) : zzfzVar.zzq(i32);
            if (iZzr == i25) {
                i14 = iZzk;
                i15 = i32;
                unsafe = unsafe2;
                i16 = 0;
            } else {
                int[] iArr = zzfzVar.zzc;
                int i34 = iArr[iZzr + 1];
                int iZzu = zzu(i34);
                long j11 = i34 & i24;
                if (iZzu <= 17) {
                    int i35 = iArr[iZzr + 2];
                    int i36 = 1 << (i35 >>> 20);
                    int i37 = i35 & 1048575;
                    if (i37 != i29) {
                        if (i29 != 1048575) {
                            unsafe2.putInt(obj2, i29, i28);
                        }
                        if (i37 != 1048575) {
                            i28 = unsafe2.getInt(obj2, i37);
                        }
                        i29 = i37;
                    }
                    switch (iZzu) {
                        case 0:
                            i17 = iZzr;
                            i18 = iZzk;
                            i15 = i32;
                            if (i33 == 1) {
                                zzhi.zzl(obj2, j11, Double.longBitsToDouble(zzdt.zzn(bArr2, i18)));
                                iZzi = i18 + 8;
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 1:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i18 = iZzk;
                            i15 = i32;
                            if (i33 == 5) {
                                zzhi.zzm(obj2, j11, Float.intBitsToFloat(zzdt.zzb(bArr2, i18)));
                                iZzi = i18 + 4;
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 2:
                        case 3:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i18 = iZzk;
                            i15 = i32;
                            if (i33 == 0) {
                                iZzm = zzdt.zzm(bArr2, i18, zzdsVar);
                                unsafe2.putLong(obj, j11, zzdsVar.zzb);
                                i28 |= i36;
                                iZzi = iZzm;
                                i27 = i17;
                                i26 = i15;
                            }
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 4:
                        case 11:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i18 = iZzk;
                            i15 = i32;
                            if (i33 == 0) {
                                iZzi = zzdt.zzj(bArr2, i18, zzdsVar);
                                unsafe2.putInt(obj2, j11, zzdsVar.zza);
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 5:
                        case 14:
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 1) {
                                i18 = iZzk;
                                unsafe2.putLong(obj, j11, zzdt.zzn(bArr2, iZzk));
                                iZzi = i18 + 8;
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 6:
                        case 13:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 5) {
                                unsafe2.putInt(obj2, j11, zzdt.zzb(bArr2, iZzk));
                                iZzi = iZzk + 4;
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 7:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 0) {
                                iZzi = zzdt.zzm(bArr2, iZzk, zzdsVar);
                                zzhi.zzk(obj2, j11, zzdsVar.zzb != 0);
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 8:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 2) {
                                iZzi = (536870912 & i34) == 0 ? zzdt.zzg(bArr2, iZzk, zzdsVar) : zzdt.zzh(bArr2, iZzk, zzdsVar);
                                unsafe2.putObject(obj2, j11, zzdsVar.zzc);
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 9:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 2) {
                                iZzd = zzdt.zzd(zzfzVar.zzy(i17), bArr2, iZzk, i23, zzdsVar);
                                Object object = unsafe2.getObject(obj2, j11);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j11, zzdsVar.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j11, zzez.zzg(object, zzdsVar.zzc));
                                }
                                i28 |= i36;
                                iZzi = iZzd;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 10:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 2) {
                                iZzd = zzdt.zza(bArr2, iZzk, zzdsVar);
                                unsafe2.putObject(obj2, j11, zzdsVar.zzc);
                                i28 |= i36;
                                iZzi = iZzd;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 12:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 0) {
                                iZzd = zzdt.zzj(bArr2, iZzk, zzdsVar);
                                unsafe2.putInt(obj2, j11, zzdsVar.zza);
                                i28 |= i36;
                                iZzi = iZzd;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 15:
                            zzdsVar = zzdsVar;
                            i17 = iZzr;
                            i15 = i32;
                            if (i33 == 0) {
                                iZzd = zzdt.zzj(bArr2, iZzk, zzdsVar);
                                unsafe2.putInt(obj2, j11, zzei.zzb(zzdsVar.zza));
                                i28 |= i36;
                                iZzi = iZzd;
                                i27 = i17;
                                i26 = i15;
                            }
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                        case 16:
                            if (i33 != 0) {
                                i15 = i32;
                                i17 = iZzr;
                                i18 = iZzk;
                                i14 = i18;
                                unsafe = unsafe2;
                                i16 = i17;
                            } else {
                                zzdsVar = zzdsVar;
                                iZzm = zzdt.zzm(bArr2, iZzk, zzdsVar);
                                i17 = iZzr;
                                i15 = i32;
                                unsafe2.putLong(obj, j11, zzei.zzc(zzdsVar.zzb));
                                i28 |= i36;
                                iZzi = iZzm;
                                i27 = i17;
                                i26 = i15;
                            }
                            break;
                        default:
                            i15 = i32;
                            i17 = iZzr;
                            i18 = iZzk;
                            i14 = i18;
                            unsafe = unsafe2;
                            i16 = i17;
                            break;
                    }
                    i25 = -1;
                    i24 = 1048575;
                } else {
                    zzdsVar = zzdsVar;
                    i17 = iZzr;
                    int i38 = iZzk;
                    i15 = i32;
                    if (iZzu == 27) {
                        if (i33 == 2) {
                            zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj2, j11);
                            if (!zzeyVarZzd.zzc()) {
                                int size = zzeyVarZzd.size();
                                zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj2, j11, zzeyVarZzd);
                            }
                            iZzi = zzdt.zze(zzfzVar.zzy(i17), i13, bArr, i38, i12, zzeyVarZzd, zzdsVar);
                            i28 = i28;
                            i27 = i17;
                            i26 = i15;
                            i25 = -1;
                            i24 = 1048575;
                        } else {
                            i19 = i38;
                            i21 = i28;
                            i22 = i29;
                            unsafe = unsafe2;
                            i16 = i17;
                        }
                    } else if (iZzu <= 49) {
                        i21 = i28;
                        i22 = i29;
                        unsafe = unsafe2;
                        i16 = i17;
                        iZzi = zzp(obj, bArr, i38, i12, i13, i15, i33, i17, i34, iZzu, j11, zzdsVar);
                        if (iZzi != i38) {
                            obj2 = obj;
                            bArr2 = bArr;
                            i23 = i12;
                            zzdsVar = zzdsVar;
                            i29 = i22;
                            i26 = i15;
                            i28 = i21;
                            i27 = i16;
                            unsafe2 = unsafe;
                            i25 = -1;
                            i24 = 1048575;
                            zzfzVar = this;
                        } else {
                            i14 = iZzi;
                            i29 = i22;
                            i28 = i21;
                        }
                    } else {
                        i19 = i38;
                        i21 = i28;
                        i22 = i29;
                        unsafe = unsafe2;
                        i16 = i17;
                        if (iZzu != 50) {
                            iZzi = zzn(obj, bArr, i19, i12, i13, i15, i33, i34, iZzu, j11, i16, zzdsVar);
                            if (iZzi != i19) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i23 = i12;
                                zzdsVar = zzdsVar;
                                i29 = i22;
                                i26 = i15;
                                i28 = i21;
                                i27 = i16;
                                unsafe2 = unsafe;
                                i25 = -1;
                                i24 = 1048575;
                                zzfzVar = this;
                            } else {
                                i14 = iZzi;
                                i29 = i22;
                                i28 = i21;
                            }
                        } else if (i33 == 2) {
                            iZzi = zzm(obj, bArr, i19, i12, i16, j11, zzdsVar);
                            if (iZzi != i19) {
                                obj2 = obj;
                                bArr2 = bArr;
                                i23 = i12;
                                zzdsVar = zzdsVar;
                                i29 = i22;
                                i26 = i15;
                                i28 = i21;
                                i27 = i16;
                                unsafe2 = unsafe;
                                i25 = -1;
                                i24 = 1048575;
                                zzfzVar = this;
                            } else {
                                i14 = iZzi;
                                i29 = i22;
                                i28 = i21;
                            }
                        }
                    }
                    i14 = i19;
                    i29 = i22;
                    i28 = i21;
                }
            }
            iZzi = zzdt.zzi(i13, bArr, i14, i12, zzc(obj), zzdsVar);
            zzfzVar = this;
            obj2 = obj;
            bArr2 = bArr;
            i23 = i12;
            zzdsVar = zzdsVar;
            i26 = i15;
            i27 = i16;
            unsafe2 = unsafe;
            i25 = -1;
            i24 = 1048575;
        }
        int i39 = i28;
        int i40 = i29;
        Unsafe unsafe3 = unsafe2;
        if (i40 != 1048575) {
            unsafe3.putInt(obj, i40, i39);
        }
        if (iZzi == i12) {
            return iZzi;
        }
        throw zzfa.zzd();
    }

    private final int zzp(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, zzds zzdsVar) throws IOException {
        int i18;
        int i19;
        int i21;
        int iZzj;
        int iZzj2 = i11;
        Unsafe unsafe = zzb;
        zzey zzeyVarZzd = (zzey) unsafe.getObject(obj, j12);
        if (!zzeyVarZzd.zzc()) {
            int size = zzeyVarZzd.size();
            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j12, zzeyVarZzd);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i15 == 2) {
                    zzej zzejVar = (zzej) zzeyVarZzd;
                    int iZzj3 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i22 = zzdsVar.zza + iZzj3;
                    while (iZzj3 < i22) {
                        zzejVar.zze(Double.longBitsToDouble(zzdt.zzn(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i22) {
                        return iZzj3;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 1) {
                    zzej zzejVar2 = (zzej) zzeyVarZzd;
                    zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i11)));
                    while (true) {
                        int i23 = iZzj2 + 8;
                        if (i23 >= i12) {
                            return i23;
                        }
                        iZzj2 = zzdt.zzj(bArr, i23, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return i23;
                        }
                        zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, iZzj2)));
                    }
                }
                return iZzj2;
            case 19:
            case 36:
                if (i15 == 2) {
                    zzeq zzeqVar = (zzeq) zzeyVarZzd;
                    int iZzj4 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i24 = zzdsVar.zza + iZzj4;
                    while (iZzj4 < i24) {
                        zzeqVar.zze(Float.intBitsToFloat(zzdt.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i24) {
                        return iZzj4;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 5) {
                    zzeq zzeqVar2 = (zzeq) zzeyVarZzd;
                    zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i11)));
                    while (true) {
                        i18 = iZzj2 + 4;
                        if (i18 < i12) {
                            iZzj2 = zzdt.zzj(bArr, i18, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i18;
                }
                return iZzj2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    zzfl zzflVar = (zzfl) zzeyVarZzd;
                    int iZzj5 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i25 = zzdsVar.zza + iZzj5;
                    while (iZzj5 < i25) {
                        iZzj5 = zzdt.zzm(bArr, iZzj5, zzdsVar);
                        zzflVar.zze(zzdsVar.zzb);
                    }
                    if (iZzj5 == i25) {
                        return iZzj5;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 0) {
                    zzfl zzflVar2 = (zzfl) zzeyVarZzd;
                    int iZzm = zzdt.zzm(bArr, iZzj2, zzdsVar);
                    zzflVar2.zze(zzdsVar.zzb);
                    while (iZzm < i12) {
                        int iZzj6 = zzdt.zzj(bArr, iZzm, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzdt.zzm(bArr, iZzj6, zzdsVar);
                        zzflVar2.zze(zzdsVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 39:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                if (i15 == 2) {
                    return zzdt.zzf(bArr, iZzj2, zzeyVarZzd, zzdsVar);
                }
                if (i15 == 0) {
                    return zzdt.zzl(i13, bArr, i11, i12, zzeyVarZzd, zzdsVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                if (i15 == 2) {
                    zzfl zzflVar3 = (zzfl) zzeyVarZzd;
                    int iZzj7 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i26 = zzdsVar.zza + iZzj7;
                    while (iZzj7 < i26) {
                        zzflVar3.zze(zzdt.zzn(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i26) {
                        return iZzj7;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 1) {
                    zzfl zzflVar4 = (zzfl) zzeyVarZzd;
                    zzflVar4.zze(zzdt.zzn(bArr, i11));
                    while (true) {
                        i19 = iZzj2 + 8;
                        if (i19 < i12) {
                            iZzj2 = zzdt.zzj(bArr, i19, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzflVar4.zze(zzdt.zzn(bArr, iZzj2));
                            }
                        }
                    }
                    return i19;
                }
                return iZzj2;
            case 24:
            case VungleException.WEB_CRASH /* 31 */:
            case 41:
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                if (i15 == 2) {
                    zzev zzevVar = (zzev) zzeyVarZzd;
                    int iZzj8 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i27 = zzdsVar.zza + iZzj8;
                    while (iZzj8 < i27) {
                        zzevVar.zze(zzdt.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i27) {
                        return iZzj8;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 5) {
                    zzev zzevVar2 = (zzev) zzeyVarZzd;
                    zzevVar2.zze(zzdt.zzb(bArr, i11));
                    while (true) {
                        i21 = iZzj2 + 4;
                        if (i21 < i12) {
                            iZzj2 = zzdt.zzj(bArr, i21, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                zzevVar2.zze(zzdt.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i21;
                }
                return iZzj2;
            case 25:
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                if (i15 == 2) {
                    zzdu zzduVar = (zzdu) zzeyVarZzd;
                    iZzj = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i28 = zzdsVar.zza + iZzj;
                    while (iZzj < i28) {
                        iZzj = zzdt.zzm(bArr, iZzj, zzdsVar);
                        zzduVar.zze(zzdsVar.zzb != 0);
                    }
                    if (iZzj != i28) {
                        throw zzfa.zzf();
                    }
                    return iZzj;
                }
                if (i15 == 0) {
                    zzdu zzduVar2 = (zzdu) zzeyVarZzd;
                    int iZzm2 = zzdt.zzm(bArr, iZzj2, zzdsVar);
                    zzduVar2.zze(zzdsVar.zzb != 0);
                    while (iZzm2 < i12) {
                        int iZzj9 = zzdt.zzj(bArr, iZzm2, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzdt.zzm(bArr, iZzj9, zzdsVar);
                        zzduVar2.zze(zzdsVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i15 == 2) {
                    if ((j11 & 536870912) == 0) {
                        iZzj2 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                        int i29 = zzdsVar.zza;
                        if (i29 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i29 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            zzeyVarZzd.add(new String(bArr, iZzj2, i29, zzez.zzb));
                            iZzj2 += i29;
                        }
                        while (iZzj2 < i12) {
                            int iZzj10 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                iZzj2 = zzdt.zzj(bArr, iZzj10, zzdsVar);
                                int i31 = zzdsVar.zza;
                                if (i31 < 0) {
                                    throw zzfa.zzc();
                                }
                                if (i31 == 0) {
                                    zzeyVarZzd.add("");
                                } else {
                                    zzeyVarZzd.add(new String(bArr, iZzj2, i31, zzez.zzb));
                                    iZzj2 += i31;
                                }
                            }
                        }
                    } else {
                        iZzj2 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                        int i32 = zzdsVar.zza;
                        if (i32 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i32 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            int i33 = iZzj2 + i32;
                            if (!zzhm.zzd(bArr, iZzj2, i33)) {
                                throw zzfa.zzb();
                            }
                            zzeyVarZzd.add(new String(bArr, iZzj2, i32, zzez.zzb));
                            iZzj2 = i33;
                        }
                        while (iZzj2 < i12) {
                            int iZzj11 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                            if (i13 == zzdsVar.zza) {
                                iZzj2 = zzdt.zzj(bArr, iZzj11, zzdsVar);
                                int i34 = zzdsVar.zza;
                                if (i34 < 0) {
                                    throw zzfa.zzc();
                                }
                                if (i34 == 0) {
                                    zzeyVarZzd.add("");
                                } else {
                                    int i35 = iZzj2 + i34;
                                    if (!zzhm.zzd(bArr, iZzj2, i35)) {
                                        throw zzfa.zzb();
                                    }
                                    zzeyVarZzd.add(new String(bArr, iZzj2, i34, zzez.zzb));
                                    iZzj2 = i35;
                                }
                            }
                        }
                    }
                }
                return iZzj2;
            case 27:
                if (i15 == 2) {
                    return zzdt.zze(zzy(i16), i13, bArr, i11, i12, zzeyVarZzd, zzdsVar);
                }
                return iZzj2;
            case 28:
                if (i15 == 2) {
                    int iZzj12 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i36 = zzdsVar.zza;
                    if (i36 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i36 > bArr.length - iZzj12) {
                        throw zzfa.zzf();
                    }
                    if (i36 == 0) {
                        zzeyVarZzd.add(zzee.zzb);
                    } else {
                        zzeyVarZzd.add(zzee.zzk(bArr, iZzj12, i36));
                        iZzj12 += i36;
                    }
                    while (iZzj12 < i12) {
                        int iZzj13 = zzdt.zzj(bArr, iZzj12, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzdt.zzj(bArr, iZzj13, zzdsVar);
                        int i37 = zzdsVar.zza;
                        if (i37 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i37 > bArr.length - iZzj12) {
                            throw zzfa.zzf();
                        }
                        if (i37 == 0) {
                            zzeyVarZzd.add(zzee.zzb);
                        } else {
                            zzeyVarZzd.add(zzee.zzk(bArr, iZzj12, i37));
                            iZzj12 += i37;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case 30:
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                if (i15 != 2) {
                    if (i15 == 0) {
                        iZzj = zzdt.zzl(i13, bArr, i11, i12, zzeyVarZzd, zzdsVar);
                    }
                    return iZzj2;
                }
                iZzj = zzdt.zzf(bArr, iZzj2, zzeyVarZzd, zzdsVar);
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                if (zzgzVar == zzgz.zza()) {
                    zzgzVar = null;
                }
                Object objZzd = zzgj.zzd(i14, zzeyVarZzd, zzx(i16), zzgzVar, this.zzm);
                if (objZzd != null) {
                    zzeuVar.zzc = (zzgz) objZzd;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                if (i15 == 2) {
                    zzev zzevVar3 = (zzev) zzeyVarZzd;
                    int iZzj14 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i38 = zzdsVar.zza + iZzj14;
                    while (iZzj14 < i38) {
                        iZzj14 = zzdt.zzj(bArr, iZzj14, zzdsVar);
                        zzevVar3.zze(zzei.zzb(zzdsVar.zza));
                    }
                    if (iZzj14 == i38) {
                        return iZzj14;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 0) {
                    zzev zzevVar4 = (zzev) zzeyVarZzd;
                    int iZzj15 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    while (iZzj15 < i12) {
                        int iZzj16 = zzdt.zzj(bArr, iZzj15, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return iZzj15;
                        }
                        iZzj15 = zzdt.zzj(bArr, iZzj16, zzdsVar);
                        zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    }
                    return iZzj15;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i15 == 2) {
                    zzfl zzflVar5 = (zzfl) zzeyVarZzd;
                    int iZzj17 = zzdt.zzj(bArr, iZzj2, zzdsVar);
                    int i39 = zzdsVar.zza + iZzj17;
                    while (iZzj17 < i39) {
                        iZzj17 = zzdt.zzm(bArr, iZzj17, zzdsVar);
                        zzflVar5.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    if (iZzj17 == i39) {
                        return iZzj17;
                    }
                    throw zzfa.zzf();
                }
                if (i15 == 0) {
                    zzfl zzflVar6 = (zzfl) zzeyVarZzd;
                    int iZzm3 = zzdt.zzm(bArr, iZzj2, zzdsVar);
                    zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    while (iZzm3 < i12) {
                        int iZzj18 = zzdt.zzj(bArr, iZzm3, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzdt.zzm(bArr, iZzj18, zzdsVar);
                        zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i15 == 3) {
                    zzgh zzghVarZzy = zzy(i16);
                    int i40 = (i13 & (-8)) | 4;
                    int iZzc = zzdt.zzc(zzghVarZzy, bArr, i11, i12, i40, zzdsVar);
                    zzeyVarZzd.add(zzdsVar.zzc);
                    while (iZzc < i12) {
                        int iZzj19 = zzdt.zzj(bArr, iZzc, zzdsVar);
                        if (i13 != zzdsVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzdt.zzc(zzghVarZzy, bArr, iZzj19, i12, i40, zzdsVar);
                        zzeyVarZzd.add(zzdsVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzq(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzt(i11, 0);
    }

    private final int zzr(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzt(i11, i12);
    }

    private final int zzs(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzt(int i11, int i12) {
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

    private static int zzu(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzv(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzw(Object obj, long j11) {
        return ((Long) zzhi.zzf(obj, j11)).longValue();
    }

    private final zzex zzx(int i11) {
        int i12 = i11 / 3;
        return (zzex) this.zzd[i12 + i12 + 1];
    }

    private final zzgh zzy(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzgh zzghVar = (zzgh) this.zzd[i13];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzghVarZzb = zzge.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzghVarZzb;
        return zzghVarZzb;
    }

    private final Object zzz(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        int i11;
        int iZzc;
        int length = this.zzc.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iZzv = zzv(i13);
            int i14 = this.zzc[i13];
            long j11 = 1048575 & iZzv;
            int iHashCode = 37;
            switch (zzu(iZzv)) {
                case 0:
                    i11 = i12 * 53;
                    iZzc = zzez.zzc(Double.doubleToLongBits(zzhi.zza(obj, j11)));
                    i12 = i11 + iZzc;
                    break;
                case 1:
                    i11 = i12 * 53;
                    iZzc = Float.floatToIntBits(zzhi.zzb(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 2:
                    i11 = i12 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 3:
                    i11 = i12 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 4:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 5:
                    i11 = i12 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 6:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 7:
                    i11 = i12 * 53;
                    iZzc = zzez.zza(zzhi.zzt(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 8:
                    i11 = i12 * 53;
                    iZzc = ((String) zzhi.zzf(obj, j11)).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 9:
                    Object objZzf = zzhi.zzf(obj, j11);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 10:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzf(obj, j11).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 11:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 12:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 13:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 14:
                    i11 = i12 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 15:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 16:
                    i11 = i12 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzhi.zzf(obj, j11);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
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
                    i11 = i12 * 53;
                    iZzc = zzhi.zzf(obj, j11).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 50:
                    i11 = i12 * 53;
                    iZzc = zzhi.zzf(obj, j11).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 51:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zzc(Double.doubleToLongBits(((Double) zzhi.zzf(obj, j11)).doubleValue()));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 52:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = Float.floatToIntBits(((Float) zzhi.zzf(obj, j11)).floatValue());
                        i12 = i11 + iZzc;
                    }
                    break;
                case 53:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 54:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 55:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzl(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 56:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzl(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 58:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zza(((Boolean) zzhi.zzf(obj, j11)).booleanValue());
                        i12 = i11 + iZzc;
                    }
                    break;
                case 59:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = ((String) zzhi.zzf(obj, j11)).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
                case 60:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzhi.zzf(obj, j11).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
                case 61:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzhi.zzf(obj, j11).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
                case 62:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzl(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 63:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzl(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 64:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzl(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 66:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzl(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzez.zzc(zzw(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 68:
                    if (zzJ(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzhi.zzf(obj, j11).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
            }
        }
        return (i12 * 53) + this.zzm.zza(obj).hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:123:0x03b8 A[PHI: r0 r18 r28
  0x03b8: PHI (r0v24 int) = (r0v19 int), (r0v22 int), (r0v26 int) binds: [B:135:0x041b, B:131:0x03f8, B:122:0x03b6] A[DONT_GENERATE, DONT_INLINE]
  0x03b8: PHI (r18v5 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:135:0x041b, B:131:0x03f8, B:122:0x03b6] A[DONT_GENERATE, DONT_INLINE]
  0x03b8: PHI (r28v7 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:135:0x041b, B:131:0x03f8, B:122:0x03b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:125:0x03d2 A[PHI: r0 r18 r28
  0x03d2: PHI (r0v23 int) = (r0v19 int), (r0v22 int), (r0v26 int) binds: [B:135:0x041b, B:131:0x03f8, B:122:0x03b6] A[DONT_GENERATE, DONT_INLINE]
  0x03d2: PHI (r18v4 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:135:0x041b, B:131:0x03f8, B:122:0x03b6] A[DONT_GENERATE, DONT_INLINE]
  0x03d2: PHI (r28v6 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:135:0x041b, B:131:0x03f8, B:122:0x03b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x008e. Please report as an issue. */
    public final int zzb(Object obj, byte[] bArr, int i11, int i12, int i13, zzds zzdsVar) throws IOException {
        Unsafe unsafe;
        Object obj2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int iZzm;
        int i29;
        this = this;
        obj = obj;
        bArr = bArr;
        i12 = i12;
        i13 = i13;
        zzdsVar = zzdsVar;
        Unsafe unsafe2 = zzb;
        int iZzi = i11;
        int i31 = 0;
        int i32 = -1;
        int i33 = 0;
        int i34 = 0;
        int i35 = 1048575;
        while (true) {
            if (iZzi < i12) {
                int i36 = iZzi + 1;
                byte b11 = bArr[iZzi];
                if (b11 < 0) {
                    int iZzk = zzdt.zzk(b11, bArr, i36, zzdsVar);
                    i14 = zzdsVar.zza;
                    i36 = iZzk;
                } else {
                    i14 = b11;
                }
                int i37 = i14 >>> 3;
                int i38 = i14 & 7;
                int iZzr = i37 > i32 ? this.zzr(i37, i33 / 3) : this.zzq(i37);
                if (iZzr == -1) {
                    i15 = i37;
                    i16 = i36;
                    i17 = i14;
                    i18 = i34;
                    unsafe = unsafe2;
                    i13 = i13;
                    i19 = 0;
                } else {
                    int[] iArr = this.zzc;
                    int i39 = iArr[iZzr + 1];
                    int iZzu = zzu(i39);
                    int i40 = i36;
                    long j11 = i39 & 1048575;
                    int i41 = i14;
                    if (iZzu <= 17) {
                        int i42 = iArr[iZzr + 2];
                        int i43 = 1 << (i42 >>> 20);
                        int i44 = i42 & 1048575;
                        if (i44 != i35) {
                            if (i35 != 1048575) {
                                unsafe2.putInt(obj, i35, i34);
                            }
                            i21 = i44;
                            i23 = unsafe2.getInt(obj, i44);
                        } else {
                            i21 = i35;
                            i23 = i34;
                        }
                        switch (iZzu) {
                            case 0:
                                i26 = iZzr;
                                i25 = i40;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 1) {
                                    zzhi.zzl(obj, j11, Double.longBitsToDouble(zzdt.zzn(bArr, i25)));
                                    iZzi = i25 + 8;
                                    i34 = i23 | i43;
                                    i33 = i26;
                                    i32 = i15;
                                    i31 = i41;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 1:
                                i26 = iZzr;
                                i25 = i40;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 5) {
                                    zzhi.zzm(obj, j11, Float.intBitsToFloat(zzdt.zzb(bArr, i25)));
                                    iZzi = i25 + 4;
                                    i34 = i23 | i43;
                                    i33 = i26;
                                    i32 = i15;
                                    i31 = i41;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 2:
                            case 3:
                                i26 = iZzr;
                                i25 = i40;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 0) {
                                    int iZzm2 = zzdt.zzm(bArr, i25, zzdsVar);
                                    unsafe2.putLong(obj, j11, zzdsVar.zzb);
                                    i34 = i23 | i43;
                                    iZzi = iZzm2;
                                    i33 = i26;
                                    i32 = i15;
                                    i31 = i41;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 4:
                            case 11:
                                i26 = iZzr;
                                i25 = i40;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 0) {
                                    iZzi = zzdt.zzj(bArr, i25, zzdsVar);
                                    unsafe2.putInt(obj, j11, zzdsVar.zza);
                                    i34 = i23 | i43;
                                    i33 = i26;
                                    i32 = i15;
                                    i31 = i41;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 5:
                            case 14:
                                i25 = i40;
                                i27 = i41;
                                bArr = bArr;
                                i15 = i37;
                                i28 = iZzr;
                                if (i38 == 1) {
                                    i41 = i27;
                                    i26 = i28;
                                    unsafe2.putLong(obj, j11, zzdt.zzn(bArr, i25));
                                    iZzi = i25 + 8;
                                    i34 = i23 | i43;
                                    i33 = i26;
                                    i32 = i15;
                                    i31 = i41;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i41 = i27;
                                    i26 = i28;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 6:
                            case 13:
                                i25 = i40;
                                i27 = i41;
                                bArr = bArr;
                                i15 = i37;
                                i28 = iZzr;
                                if (i38 == 5) {
                                    unsafe2.putInt(obj, j11, zzdt.zzb(bArr, i25));
                                    iZzm = i25 + 4;
                                    int i45 = i23 | i43;
                                    i13 = i13;
                                    i33 = i28;
                                    iZzi = iZzm;
                                    i31 = i27;
                                    i35 = i21;
                                    i12 = i12;
                                    i34 = i45;
                                    i32 = i15;
                                } else {
                                    i41 = i27;
                                    i26 = i28;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 7:
                                i25 = i40;
                                i27 = i41;
                                bArr = bArr;
                                i15 = i37;
                                i28 = iZzr;
                                if (i38 == 0) {
                                    iZzm = zzdt.zzm(bArr, i25, zzdsVar);
                                    zzhi.zzk(obj, j11, zzdsVar.zzb != 0);
                                    int i46 = i23 | i43;
                                    i13 = i13;
                                    i33 = i28;
                                    iZzi = iZzm;
                                    i31 = i27;
                                    i35 = i21;
                                    i12 = i12;
                                    i34 = i46;
                                    i32 = i15;
                                } else {
                                    i41 = i27;
                                    i26 = i28;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 8:
                                i25 = i40;
                                i27 = i41;
                                bArr = bArr;
                                i15 = i37;
                                i28 = iZzr;
                                if (i38 == 2) {
                                    iZzm = (536870912 & i39) == 0 ? zzdt.zzg(bArr, i25, zzdsVar) : zzdt.zzh(bArr, i25, zzdsVar);
                                    unsafe2.putObject(obj, j11, zzdsVar.zzc);
                                    int i47 = i23 | i43;
                                    i13 = i13;
                                    i33 = i28;
                                    iZzi = iZzm;
                                    i31 = i27;
                                    i35 = i21;
                                    i12 = i12;
                                    i34 = i47;
                                    i32 = i15;
                                } else {
                                    i41 = i27;
                                    i26 = i28;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 9:
                                i24 = iZzr;
                                i25 = i40;
                                i29 = i41;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 2) {
                                    iZzi = zzdt.zzd(this.zzy(i24), bArr, i25, i12, zzdsVar);
                                    if ((i23 & i43) == 0) {
                                        unsafe2.putObject(obj, j11, zzdsVar.zzc);
                                    } else {
                                        unsafe2.putObject(obj, j11, zzez.zzg(unsafe2.getObject(obj, j11), zzdsVar.zzc));
                                    }
                                    int i48 = i23 | i43;
                                    i13 = i13;
                                    i33 = i24;
                                    i32 = i15;
                                    i35 = i21;
                                    i34 = i48;
                                    i31 = i29;
                                    i12 = i12;
                                } else {
                                    i41 = i29;
                                    i26 = i24;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 10:
                                i24 = iZzr;
                                i25 = i40;
                                i29 = i41;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 2) {
                                    iZzi = zzdt.zza(bArr, i25, zzdsVar);
                                    unsafe2.putObject(obj, j11, zzdsVar.zzc);
                                    i34 = i23 | i43;
                                    i33 = i24;
                                    i31 = i29;
                                    i32 = i15;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i41 = i29;
                                    i26 = i24;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 12:
                                i24 = iZzr;
                                i25 = i40;
                                i29 = i41;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 0) {
                                    iZzi = zzdt.zzj(bArr, i25, zzdsVar);
                                    int i49 = zzdsVar.zza;
                                    zzex zzexVarZzx = this.zzx(i24);
                                    if (zzexVarZzx == null || zzexVarZzx.zza()) {
                                        unsafe2.putInt(obj, j11, i49);
                                        i34 = i23 | i43;
                                    } else {
                                        zzc(obj).zzf(i29, Long.valueOf(i49));
                                        i34 = i23;
                                    }
                                    i33 = i24;
                                    i31 = i29;
                                    i32 = i15;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i41 = i29;
                                    i26 = i24;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 15:
                                i24 = iZzr;
                                i25 = i40;
                                i29 = i41;
                                bArr = bArr;
                                i15 = i37;
                                if (i38 == 0) {
                                    iZzi = zzdt.zzj(bArr, i25, zzdsVar);
                                    unsafe2.putInt(obj, j11, zzei.zzb(zzdsVar.zza));
                                    i34 = i23 | i43;
                                    i33 = i24;
                                    i31 = i29;
                                    i32 = i15;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i41 = i29;
                                    i26 = i24;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            case 16:
                                i24 = iZzr;
                                i25 = i40;
                                i15 = i37;
                                if (i38 == 0) {
                                    bArr = bArr;
                                    int iZzm3 = zzdt.zzm(bArr, i25, zzdsVar);
                                    i29 = i41;
                                    unsafe2.putLong(obj, j11, zzei.zzc(zzdsVar.zzb));
                                    i34 = i23 | i43;
                                    i13 = i13;
                                    i33 = i24;
                                    iZzi = iZzm3;
                                    i31 = i29;
                                    i32 = i15;
                                    i35 = i21;
                                    i12 = i12;
                                } else {
                                    i41 = i41;
                                    i26 = i24;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                            default:
                                if (i38 == 3) {
                                    iZzi = zzdt.zzc(this.zzy(iZzr), bArr, i40, i12, (i37 << 3) | 4, zzdsVar);
                                    if ((i23 & i43) == 0) {
                                        unsafe2.putObject(obj, j11, zzdsVar.zzc);
                                    } else {
                                        unsafe2.putObject(obj, j11, zzez.zzg(unsafe2.getObject(obj, j11), zzdsVar.zzc));
                                    }
                                    i34 = i23 | i43;
                                    bArr = bArr;
                                    i12 = i12;
                                    i13 = i13;
                                    i33 = iZzr;
                                    i31 = i41;
                                    i32 = i37;
                                    i35 = i21;
                                } else {
                                    i24 = iZzr;
                                    i25 = i40;
                                    i15 = i37;
                                    i26 = i24;
                                    i18 = i23;
                                    unsafe = unsafe2;
                                    i16 = i25;
                                    i19 = i26;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                break;
                        }
                    } else {
                        i15 = i37;
                        bArr = bArr;
                        if (iZzu != 27) {
                            i18 = i34;
                            i21 = i35;
                            if (iZzu <= 49) {
                                unsafe = unsafe2;
                                i19 = iZzr;
                                iZzi = zzp(obj, bArr, i40, i12, i41, i15, i38, iZzr, i39, iZzu, j11, zzdsVar);
                                if (iZzi != i40) {
                                    i13 = i13;
                                    i32 = i15;
                                    i33 = i19;
                                    i31 = i41;
                                    i34 = i18;
                                    i35 = i21;
                                } else {
                                    i16 = iZzi;
                                    i17 = i41;
                                    i35 = i21;
                                }
                                unsafe2 = unsafe;
                            } else {
                                i22 = i40;
                                unsafe = unsafe2;
                                i19 = iZzr;
                                if (iZzu == 50) {
                                    if (i38 == 2) {
                                        iZzi = zzm(obj, bArr, i22, i12, i19, j11, zzdsVar);
                                        if (iZzi != i22) {
                                            i13 = i13;
                                            i32 = i15;
                                            i33 = i19;
                                            i31 = i41;
                                            i34 = i18;
                                            i35 = i21;
                                        } else {
                                            i16 = iZzi;
                                        }
                                        unsafe2 = unsafe;
                                    }
                                    i17 = i41;
                                    i35 = i21;
                                } else {
                                    iZzi = zzn(obj, bArr, i22, i12, i41, i15, i38, i39, iZzu, j11, i19, zzdsVar);
                                    if (iZzi != i22) {
                                        i13 = i13;
                                        i32 = i15;
                                        i33 = i19;
                                        i31 = i41;
                                        i34 = i18;
                                        i35 = i21;
                                    } else {
                                        i16 = iZzi;
                                        i17 = i41;
                                        i35 = i21;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                        } else if (i38 == 2) {
                            zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj, j11);
                            if (!zzeyVarZzd.zzc()) {
                                int size = zzeyVarZzd.size();
                                zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj, j11, zzeyVarZzd);
                            }
                            i31 = i41;
                            i21 = i35;
                            iZzi = zzdt.zze(this.zzy(iZzr), i31, bArr, i40, i12, zzeyVarZzd, zzdsVar);
                            i13 = i13;
                            i33 = iZzr;
                            i32 = i15;
                            i34 = i34;
                            i35 = i21;
                            i12 = i12;
                        } else {
                            i18 = i34;
                            i21 = i35;
                            i22 = i40;
                            unsafe = unsafe2;
                            i19 = iZzr;
                        }
                        i16 = i22;
                        i17 = i41;
                        i35 = i21;
                    }
                }
                if (i17 != i13 || i13 == 0) {
                    iZzi = zzdt.zzi(i17, bArr, i16, i12, zzc(obj), zzdsVar);
                    i13 = i13;
                    i31 = i17;
                    i32 = i15;
                    i33 = i19;
                    i34 = i18;
                    unsafe2 = unsafe;
                } else {
                    iZzi = i16;
                    i31 = i17;
                    i34 = i18;
                }
            } else {
                unsafe = unsafe2;
                i13 = i13;
            }
        }
        if (i35 != 1048575) {
            long j12 = i35;
            obj2 = obj;
            unsafe.putInt(obj2, j12, i34);
        } else {
            obj2 = obj;
        }
        for (int i50 = this.zzj; i50 < this.zzk; i50++) {
            int i51 = this.zzi[i50];
            int i52 = this.zzc[i51];
            Object objZzf = zzhi.zzf(obj2, zzv(i51) & 1048575);
            if (objZzf != null && zzx(i51) != null) {
                throw null;
            }
        }
        if (i13 == 0) {
            if (iZzi != i12) {
                throw zzfa.zzd();
            }
        } else if (iZzi > i12 || i31 != i13) {
            throw zzfa.zzd();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        int i11;
        int i12 = this.zzj;
        while (true) {
            i11 = this.zzk;
            if (i12 >= i11) {
                break;
            }
            long jZzv = zzv(this.zzi[i12]) & 1048575;
            Object objZzf = zzhi.zzf(obj, jZzv);
            if (objZzf != null) {
                ((zzfq) objZzf).zzc();
                zzhi.zzp(obj, jZzv, objZzf);
            }
            i12++;
        }
        int length = this.zzi.length;
        while (i11 < length) {
            this.zzl.zza(obj, this.zzi[i11]);
            i11++;
        }
        this.zzm.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzv = zzv(i11);
            long j11 = 1048575 & iZzv;
            int i12 = this.zzc[i11];
            switch (zzu(iZzv)) {
                case 0:
                    if (zzG(obj2, i11)) {
                        zzhi.zzl(obj, j11, zzhi.zza(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 1:
                    if (zzG(obj2, i11)) {
                        zzhi.zzm(obj, j11, zzhi.zzb(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 2:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 3:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 4:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 5:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 6:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 7:
                    if (zzG(obj2, i11)) {
                        zzhi.zzk(obj, j11, zzhi.zzt(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 8:
                    if (zzG(obj2, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i11);
                    break;
                case 10:
                    if (zzG(obj2, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 11:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 12:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 13:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 14:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 15:
                    if (zzG(obj2, i11)) {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                    }
                    break;
                case 16:
                    if (zzG(obj2, i11)) {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
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
                    zzgj.zzi(this.zzp, obj, obj2, j11);
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
                    if (zzJ(obj2, i12, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzE(obj, i12, i11);
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
                    if (zzJ(obj2, i12, i11)) {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzE(obj, i12, i11);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i11);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i11, int i12, zzds zzdsVar) throws IOException {
        if (this.zzh) {
            zzo(obj, bArr, i11, i12, zzdsVar);
        } else {
            zzb(obj, bArr, i11, i12, 0, zzdsVar);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzh;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int iZzv = zzv(i11);
            long j11 = iZzv & 1048575;
            switch (zzu(iZzv)) {
                case 0:
                    if (!zzF(obj, obj2, i11) || Double.doubleToLongBits(zzhi.zza(obj, j11)) != Double.doubleToLongBits(zzhi.zza(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzF(obj, obj2, i11) || Float.floatToIntBits(zzhi.zzb(obj, j11)) != Float.floatToIntBits(zzhi.zzb(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzF(obj, obj2, i11) || zzhi.zzd(obj, j11) != zzhi.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzF(obj, obj2, i11) || zzhi.zzd(obj, j11) != zzhi.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzF(obj, obj2, i11) || zzhi.zzc(obj, j11) != zzhi.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzF(obj, obj2, i11) || zzhi.zzd(obj, j11) != zzhi.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzF(obj, obj2, i11) || zzhi.zzc(obj, j11) != zzhi.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzF(obj, obj2, i11) || zzhi.zzt(obj, j11) != zzhi.zzt(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzF(obj, obj2, i11) || !zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzF(obj, obj2, i11) || !zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzF(obj, obj2, i11) || !zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzF(obj, obj2, i11) || zzhi.zzc(obj, j11) != zzhi.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzF(obj, obj2, i11) || zzhi.zzc(obj, j11) != zzhi.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzF(obj, obj2, i11) || zzhi.zzc(obj, j11) != zzhi.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzF(obj, obj2, i11) || zzhi.zzd(obj, j11) != zzhi.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzF(obj, obj2, i11) || zzhi.zzc(obj, j11) != zzhi.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzF(obj, obj2, i11) || zzhi.zzd(obj, j11) != zzhi.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzF(obj, obj2, i11) || !zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
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
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11));
                    break;
                case 50:
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11));
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
                    long jZzs = zzs(i11) & 1048575;
                    if (zzhi.zzc(obj, jZzs) != zzhi.zzc(obj2, jZzs) || !zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzh) {
                return false;
            }
        }
        return this.zzm.zza(obj).equals(this.zzm.zza(obj2));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c2 A[LOOP:1: B:45:0x00b1->B:50:0x00c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00df A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        int i11;
        int i12;
        List list;
        zzgh zzghVarZzy;
        int i13;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < this.zzj) {
            int i17 = this.zzi[i16];
            int i18 = this.zzc[i17];
            int iZzv = zzv(i17);
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
            if ((268435456 & iZzv) != 0 && !zzH(obj, i17, i11, i12, i22)) {
                return false;
            }
            int iZzu = zzu(iZzv);
            if (iZzu == 9 || iZzu == 17) {
                if (zzH(obj, i17, i11, i12, i22) && !zzI(obj, iZzv, zzy(i17))) {
                    return false;
                }
            } else if (iZzu == 27) {
                list = (List) zzhi.zzf(obj, iZzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzghVarZzy = zzy(i17);
                    for (i13 = 0; i13 < list.size(); i13++) {
                        if (!zzghVarZzy.zzi(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (iZzu == 60 || iZzu == 68) {
                if (zzJ(obj, i18, i17) && !zzI(obj, iZzv, zzy(i17))) {
                    return false;
                }
            } else if (iZzu == 49) {
                list = (List) zzhi.zzf(obj, iZzv & 1048575);
                if (list.isEmpty()) {
                    zzghVarZzy = zzy(i17);
                    while (i13 < list.size()) {
                        if (!zzghVarZzy.zzi(list.get(i13))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzu == 50 && !((zzfq) zzhi.zzf(obj, iZzv & 1048575)).isEmpty()) {
                throw null;
            }
            i16++;
            i14 = i11;
            i15 = i12;
        }
        return true;
    }
}
