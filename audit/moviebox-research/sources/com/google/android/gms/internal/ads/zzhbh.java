package com.google.android.gms.internal.ads;

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
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbh<T> implements zzhby<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhcz.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhbe zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhas zzm;
    private final zzhcp zzn;
    private final zzgzg zzo;
    private final zzhbj zzp;
    private final zzhaz zzq;

    private zzhbh(int[] iArr, Object[] objArr, int i11, int i12, zzhbe zzhbeVar, int i13, boolean z11, int[] iArr2, int i14, int i15, zzhbj zzhbjVar, zzhas zzhasVar, zzhcp zzhcpVar, zzgzg zzgzgVar, zzhaz zzhazVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = zzhbeVar instanceof zzgzu;
        boolean z12 = false;
        if (zzgzgVar != null && zzgzgVar.zzh(zzhbeVar)) {
            z12 = true;
        }
        this.zzh = z12;
        this.zzj = iArr2;
        this.zzk = i14;
        this.zzl = i15;
        this.zzp = zzhbjVar;
        this.zzm = zzhasVar;
        this.zzn = zzhcpVar;
        this.zzo = zzgzgVar;
        this.zzg = zzhbeVar;
        this.zzq = zzhazVar;
    }

    private final Object zzA(Object obj, int i11) {
        zzhby zzhbyVarZzx = zzx(i11);
        int iZzu = zzu(i11) & 1048575;
        if (!zzN(obj, i11)) {
            return zzhbyVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhbyVarZzx.zze();
        if (object != null) {
            zzhbyVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i11, int i12) {
        zzhby zzhbyVarZzx = zzx(i12);
        if (!zzR(obj, i11, i12)) {
            return zzhbyVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i12) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhbyVarZzx.zze();
        if (object != null) {
            zzhbyVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i11) {
        if (zzN(obj2, i11)) {
            int iZzu = zzu(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = iZzu;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzhby zzhbyVarZzx = zzx(i11);
            if (!zzN(obj, i11)) {
                if (zzQ(object)) {
                    Object objZze = zzhbyVarZzx.zze();
                    zzhbyVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j11, objZze);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzH(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzQ(object2)) {
                Object objZze2 = zzhbyVarZzx.zze();
                zzhbyVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j11, objZze2);
                object2 = objZze2;
            }
            zzhbyVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzR(obj2, i12, i11)) {
            int iZzu = zzu(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = iZzu;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzhby zzhbyVarZzx = zzx(i11);
            if (!zzR(obj, i12, i11)) {
                if (zzQ(object)) {
                    Object objZze = zzhbyVarZzx.zze();
                    zzhbyVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j11, objZze);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzI(obj, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzQ(object2)) {
                Object objZze2 = zzhbyVarZzx.zze();
                zzhbyVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j11, objZze2);
                object2 = objZze2;
            }
            zzhbyVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i11, zzhbq zzhbqVar) throws IOException {
        long j11 = i11 & 1048575;
        if (zzM(i11)) {
            zzhcz.zzv(obj, j11, zzhbqVar.zzs());
        } else if (this.zzi) {
            zzhcz.zzv(obj, j11, zzhbqVar.zzr());
        } else {
            zzhcz.zzv(obj, j11, zzhbqVar.zzp());
        }
    }

    private final void zzH(Object obj, int i11) {
        int iZzr = zzr(i11);
        long j11 = 1048575 & iZzr;
        if (j11 == 1048575) {
            return;
        }
        zzhcz.zzt(obj, j11, (1 << (iZzr >>> 20)) | zzhcz.zzd(obj, j11));
    }

    private final void zzI(Object obj, int i11, int i12) {
        zzhcz.zzt(obj, zzr(i12) & 1048575, i11);
    }

    private final void zzJ(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, zzu(i11) & 1048575, obj2);
        zzH(obj, i11);
    }

    private final void zzK(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, zzu(i12) & 1048575, obj2);
        zzI(obj, i11, i12);
    }

    private final boolean zzL(Object obj, Object obj2, int i11) {
        return zzN(obj, i11) == zzN(obj2, i11);
    }

    private static boolean zzM(int i11) {
        return (i11 & ASTNode.DISCARD) != 0;
    }

    private final boolean zzN(Object obj, int i11) {
        int iZzr = zzr(i11);
        long j11 = iZzr & 1048575;
        if (j11 != 1048575) {
            return (zzhcz.zzd(obj, j11) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i11);
        long j12 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhcz.zzb(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhcz.zzc(obj, j12)) != 0;
            case 2:
                return zzhcz.zzf(obj, j12) != 0;
            case 3:
                return zzhcz.zzf(obj, j12) != 0;
            case 4:
                return zzhcz.zzd(obj, j12) != 0;
            case 5:
                return zzhcz.zzf(obj, j12) != 0;
            case 6:
                return zzhcz.zzd(obj, j12) != 0;
            case 7:
                return zzhcz.zzz(obj, j12);
            case 8:
                Object objZzh = zzhcz.zzh(obj, j12);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgyl) {
                    return !zzgyl.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhcz.zzh(obj, j12) != null;
            case 10:
                return !zzgyl.zzb.equals(zzhcz.zzh(obj, j12));
            case 11:
                return zzhcz.zzd(obj, j12) != 0;
            case 12:
                return zzhcz.zzd(obj, j12) != 0;
            case 13:
                return zzhcz.zzd(obj, j12) != 0;
            case 14:
                return zzhcz.zzf(obj, j12) != 0;
            case 15:
                return zzhcz.zzd(obj, j12) != 0;
            case 16:
                return zzhcz.zzf(obj, j12) != 0;
            case 17:
                return zzhcz.zzh(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return zzN(obj, i11);
        }
        return (i13 & i14) != 0;
    }

    private static boolean zzP(Object obj, int i11, zzhby zzhbyVar) {
        return zzhbyVar.zzk(zzhcz.zzh(obj, i11 & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgzu) {
            return ((zzgzu) obj).zzaY();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i11, int i12) {
        return zzhcz.zzd(obj, (long) (zzr(i12) & 1048575)) == i11;
    }

    private static boolean zzS(Object obj, long j11) {
        return ((Boolean) zzhcz.zzh(obj, j11)).booleanValue();
    }

    private static final void zzT(int i11, Object obj, zzgzb zzgzbVar) throws IOException {
        if (obj instanceof String) {
            zzgzbVar.zzF(i11, (String) obj);
        } else {
            zzgzbVar.zzd(i11, (zzgyl) obj);
        }
    }

    public static zzhcq zzd(Object obj) {
        zzgzu zzgzuVar = (zzgzu) obj;
        zzhcq zzhcqVar = zzgzuVar.zzc;
        if (zzhcqVar != zzhcq.zzc()) {
            return zzhcqVar;
        }
        zzhcq zzhcqVarZzf = zzhcq.zzf();
        zzgzuVar.zzc = zzhcqVarZzf;
        return zzhcqVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0280  */
    /* JADX WARN: Code duplicated, block: B:131:0x0283  */
    public static zzhbh zzl(Class cls, zzhbb zzhbbVar, zzhbj zzhbjVar, zzhas zzhasVar, zzhcp zzhcpVar, zzgzg zzgzgVar, zzhaz zzhazVar) {
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
        Field fieldZzC;
        char cCharAt9;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        Object obj;
        Field fieldZzC2;
        int i37;
        Object obj2;
        Field fieldZzC3;
        int i38;
        char cCharAt10;
        int i39;
        char cCharAt11;
        int i40;
        char cCharAt12;
        int i41;
        char cCharAt13;
        if (!(zzhbbVar instanceof zzhbp)) {
            throw null;
        }
        zzhbp zzhbpVar = (zzhbp) zzhbbVar;
        String strZzd = zzhbpVar.zzd();
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
        Object[] objArrZze = zzhbpVar.zze();
        Class<?> cls2 = zzhbpVar.zza().getClass();
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
                        if (zzhbpVar.zzc() == 1 || i85 != 0) {
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
                        fieldZzC2 = (Field) obj;
                    } else {
                        fieldZzC2 = zzC(cls2, (String) obj);
                        objArrZze[i36] = fieldZzC2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC2);
                    i37 = i36 + 1;
                    obj2 = objArrZze[i37];
                    if (obj2 instanceof Field) {
                        fieldZzC3 = (Field) obj2;
                    } else {
                        fieldZzC3 = zzC(cls2, (String) obj2);
                        objArrZze[i37] = fieldZzC3;
                    }
                    zzhbpVar = zzhbpVar;
                    strZzd = strZzd;
                    i31 = i12;
                    i28 = i91;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC3);
                    i29 = 0;
                }
                i12 = i35;
                i36 = iCharAt12 + iCharAt12;
                obj = objArrZze[i36];
                if (obj instanceof Field) {
                    fieldZzC2 = (Field) obj;
                } else {
                    fieldZzC2 = zzC(cls2, (String) obj);
                    objArrZze[i36] = fieldZzC2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC2);
                i37 = i36 + 1;
                obj2 = objArrZze[i37];
                if (obj2 instanceof Field) {
                    fieldZzC3 = (Field) obj2;
                } else {
                    fieldZzC3 = zzC(cls2, (String) obj2);
                    objArrZze[i37] = fieldZzC3;
                }
                zzhbpVar = zzhbpVar;
                strZzd = strZzd;
                i31 = i12;
                i28 = i91;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC3);
                i29 = 0;
            } else {
                int i95 = i12 + 1;
                Field fieldZzC4 = zzC(cls2, (String) objArrZze[i12]);
                if (i84 == 9 || i84 == 17) {
                    zzhbpVar = zzhbpVar;
                    int i96 = i75 / 3;
                    objArr[i96 + i96 + 1] = fieldZzC4.getType();
                } else {
                    if (i84 == 27) {
                        i32 = 1;
                        i33 = i12 + 2;
                    } else if (i84 == 49) {
                        i33 = i12 + 2;
                        i32 = 1;
                    } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                        zzhbpVar = zzhbpVar;
                        if (zzhbpVar.zzc() == 1 || i85 != 0) {
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
                        zzhbpVar = zzhbpVar;
                    }
                    int i102 = i75 / 3;
                    objArr[i102 + i102 + i32] = objArrZze[i95];
                    i95 = i33;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzC4);
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
                        fieldZzC = (Field) obj3;
                    } else {
                        fieldZzC = zzC(cls2, (String) obj3);
                        objArrZze[i106] = fieldZzC;
                    }
                    i29 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC);
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
            zzhbpVar = zzhbpVar;
            strZzd = strZzd;
            i16 = i16;
            i13 = i13;
            c11 = 55296;
        }
        zzhbp zzhbpVar2 = zzhbpVar;
        return new zzhbh(iArr2, objArr, i13, i16, zzhbpVar2.zza(), zzhbpVar2.zzc(), false, iArr, i14, i70, zzhbjVar, zzhasVar, zzhcpVar, zzgzgVar, zzhazVar);
    }

    private static double zzn(Object obj, long j11) {
        return ((Double) zzhcz.zzh(obj, j11)).doubleValue();
    }

    private static float zzo(Object obj, long j11) {
        return ((Float) zzhcz.zzh(obj, j11)).floatValue();
    }

    private static int zzp(Object obj, long j11) {
        return ((Integer) zzhcz.zzh(obj, j11)).intValue();
    }

    private final int zzq(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzs(i11, 0);
    }

    private final int zzr(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzs(int i11, int i12) {
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

    private static int zzt(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzu(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzv(Object obj, long j11) {
        return ((Long) zzhcz.zzh(obj, j11)).longValue();
    }

    private final zzgzy zzw(int i11) {
        int i12 = i11 / 3;
        return (zzgzy) this.zzd[i12 + i12 + 1];
    }

    private final zzhby zzx(int i11) {
        Object[] objArr = this.zzd;
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzhby zzhbyVar = (zzhby) objArr[i13];
        if (zzhbyVar != null) {
            return zzhbyVar;
        }
        zzhby zzhbyVarZzb = zzhbn.zza().zzb((Class) objArr[i13 + 1]);
        this.zzd[i13] = zzhbyVarZzb;
        return zzhbyVarZzb;
    }

    private final Object zzy(Object obj, int i11, Object obj2, zzhcp zzhcpVar, Object obj3) {
        int i12 = this.zzc[i11];
        Object objZzh = zzhcz.zzh(obj, zzu(i11) & 1048575);
        if (objZzh == null || zzw(i11) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    /* JADX WARN: Code duplicated, block: B:143:0x038f  */
    /* JADX WARN: Code duplicated, block: B:180:0x0488  */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zza(Object obj) {
        int i11;
        int i12;
        int i13;
        int iZzz;
        int iZzz2;
        int iZzz3;
        int iZzA;
        int iZzz4;
        int iZzz5;
        int iZzd;
        int iZzz6;
        int iZzh;
        int iZzg;
        int size;
        int iZzz7;
        int iZzz8;
        int iZzz9;
        int iZze;
        int iZzz10;
        int iZzz11;
        int iZzw;
        Unsafe unsafe = zzb;
        boolean z11 = false;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.zzc.length) {
            int iZzu = zzu(i17);
            int iZzt = zzt(iZzu);
            int[] iArr = this.zzc;
            int i19 = iArr[i17];
            int i21 = iArr[i17 + 2];
            int i22 = i21 & i14;
            if (iZzt <= 17) {
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
            int i23 = iZzu & i14;
            if (iZzt >= zzgzl.zzJ.zza()) {
                zzgzl.zzW.zza();
            }
            long j11 = i23;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz = zzgza.zzz(i19 << 3);
                        iZzh = iZzz + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 1:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz2 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 2:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        long j12 = unsafe.getLong(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(j12);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 3:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        long j13 = unsafe.getLong(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(j13);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 4:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        long j14 = unsafe.getInt(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(j14);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 5:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz = zzgza.zzz(i19 << 3);
                        iZzh = iZzz + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 6:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz2 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 7:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz4 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz4 + 1;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 8:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        int i24 = i19 << 3;
                        Object object = unsafe.getObject(obj, j11);
                        if (object instanceof zzgyl) {
                            iZzz5 = zzgza.zzz(i24);
                            iZzd = ((zzgyl) object).zzd();
                            iZzz6 = zzgza.zzz(iZzd);
                            iZzh = iZzz5 + iZzz6 + iZzd;
                            i18 += iZzh;
                        } else {
                            iZzz3 = zzgza.zzz(i24);
                            iZzA = zzgza.zzy((String) object);
                            iZzh = iZzz3 + iZzA;
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
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzh = zzhca.zzh(i19, unsafe.getObject(obj, j11), zzx(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 10:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgyl zzgylVar = (zzgyl) unsafe.getObject(obj, j11);
                        iZzz5 = zzgza.zzz(i19 << 3);
                        iZzd = zzgylVar.zzd();
                        iZzz6 = zzgza.zzz(iZzd);
                        iZzh = iZzz5 + iZzz6 + iZzd;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 11:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        int i25 = unsafe.getInt(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzz(i25);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 12:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        long j15 = unsafe.getInt(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(j15);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 13:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz2 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 14:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzz = zzgza.zzz(i19 << 3);
                        iZzh = iZzz + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 15:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        int i26 = unsafe.getInt(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzz((i26 >> 31) ^ (i26 + i26));
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 16:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        long j16 = unsafe.getLong(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA((j16 >> 63) ^ (j16 + j16));
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 17:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        iZzh = zzgza.zzw(i19, (zzhbe) unsafe.getObject(obj, j11), zzx(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 18:
                    iZzh = zzhca.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 19:
                    iZzh = zzhca.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j11);
                    int i27 = zzhca.zza;
                    if (list.size() == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzhca.zzg(list) + (list.size() * zzgza.zzz(i19 << 3));
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
                    int i28 = zzhca.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzz3 = zzhca.zzl(list2);
                        iZzz7 = zzgza.zzz(i19 << 3);
                        iZzA = size * iZzz7;
                        iZzh = iZzz3 + iZzA;
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
                    int i29 = zzhca.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzz3 = zzhca.zzf(list3);
                        iZzz7 = zzgza.zzz(i19 << 3);
                        iZzA = size * iZzz7;
                        iZzh = iZzz3 + iZzA;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 23:
                    iZzh = zzhca.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 24:
                    iZzh = zzhca.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j11);
                    int i31 = zzhca.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = size2 * (zzgza.zzz(i19 << 3) + 1);
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
                    int i32 = zzhca.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzgza.zzz(i19 << 3) * size3;
                        if (list5 instanceof zzham) {
                            zzham zzhamVar = (zzham) list5;
                            for (int i33 = 0; i33 < size3; i33++) {
                                Object objZzf = zzhamVar.zzf(i33);
                                if (objZzf instanceof zzgyl) {
                                    int iZzd2 = ((zzgyl) objZzf).zzd();
                                    iZzg += zzgza.zzz(iZzd2) + iZzd2;
                                } else {
                                    iZzg += zzgza.zzy((String) objZzf);
                                }
                            }
                        } else {
                            for (int i34 = 0; i34 < size3; i34++) {
                                Object obj2 = list5.get(i34);
                                if (obj2 instanceof zzgyl) {
                                    int iZzd3 = ((zzgyl) obj2).zzd();
                                    iZzg += zzgza.zzz(iZzd3) + iZzd3;
                                } else {
                                    iZzg += zzgza.zzy((String) obj2);
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
                    zzhby zzhbyVarZzx = zzx(i17);
                    int i35 = zzhca.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzz8 = 0;
                    } else {
                        iZzz8 = zzgza.zzz(i19 << 3) * size4;
                        for (int i36 = 0; i36 < size4; i36++) {
                            Object obj3 = list6.get(i36);
                            if (obj3 instanceof zzhak) {
                                int iZza = ((zzhak) obj3).zza();
                                iZzz8 += zzgza.zzz(iZza) + iZza;
                            } else {
                                iZzz8 += zzgza.zzx((zzhbe) obj3, zzhbyVarZzx);
                            }
                        }
                    }
                    i18 += iZzz8;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j11);
                    int i37 = zzhca.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzz9 = 0;
                    } else {
                        iZzz9 = size5 * zzgza.zzz(i19 << 3);
                        for (int i38 = 0; i38 < list7.size(); i38++) {
                            int iZzd4 = ((zzgyl) list7.get(i38)).zzd();
                            iZzz9 += zzgza.zzz(iZzd4) + iZzd4;
                        }
                    }
                    i18 += iZzz9;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    List list8 = (List) unsafe.getObject(obj, j11);
                    int i39 = zzhca.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzz3 = zzhca.zzk(list8);
                        iZzz7 = zzgza.zzz(i19 << 3);
                        iZzA = size * iZzz7;
                        iZzh = iZzz3 + iZzA;
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
                    int i40 = zzhca.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzz3 = zzhca.zza(list9);
                        iZzz7 = zzgza.zzz(i19 << 3);
                        iZzA = size * iZzz7;
                        iZzh = iZzz3 + iZzA;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iZzh = zzhca.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 32:
                    iZzh = zzhca.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j11);
                    int i41 = zzhca.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzz3 = zzhca.zzi(list10);
                        iZzz7 = zzgza.zzz(i19 << 3);
                        iZzA = size * iZzz7;
                        iZzh = iZzz3 + iZzA;
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
                    int i42 = zzhca.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzz3 = zzhca.zzj(list11);
                        iZzz7 = zzgza.zzz(i19 << 3);
                        iZzA = size * iZzz7;
                        iZzh = iZzz3 + iZzA;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 35:
                    iZze = zzhca.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 36:
                    iZze = zzhca.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 37:
                    iZze = zzhca.zzg((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 38:
                    iZze = zzhca.zzl((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 39:
                    iZze = zzhca.zzf((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 40:
                    iZze = zzhca.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 41:
                    iZze = zzhca.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list12 = (List) unsafe.getObject(obj, j11);
                    int i43 = zzhca.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZze = zzhca.zzk((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZze = zzhca.zza((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZze = zzhca.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZze = zzhca.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZze = zzhca.zzi((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 48:
                    iZze = zzhca.zzj((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzz10 = zzgza.zzz(i19 << 3);
                        iZzz11 = zzgza.zzz(iZze);
                        iZzz9 = iZzz10 + iZzz11 + iZze;
                        i18 += iZzz9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j11);
                    zzhby zzhbyVarZzx2 = zzx(i17);
                    int i44 = zzhca.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzw = 0;
                    } else {
                        iZzw = 0;
                        for (int i45 = 0; i45 < size6; i45++) {
                            iZzw += zzgza.zzw(i19, (zzhbe) list13.get(i45), zzhbyVarZzx2);
                        }
                    }
                    i18 += iZzw;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 50:
                    zzhay zzhayVar = (zzhay) unsafe.getObject(obj, j11);
                    if (zzhayVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzhayVar.entrySet().iterator();
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
                    if (zzR(obj, i19, i17)) {
                        iZzz = zzgza.zzz(i19 << 3);
                        iZzh = iZzz + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 52:
                    if (zzR(obj, i19, i17)) {
                        iZzz2 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 53:
                    if (zzR(obj, i19, i17)) {
                        long jZzv = zzv(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(jZzv);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 54:
                    if (zzR(obj, i19, i17)) {
                        long jZzv2 = zzv(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(jZzv2);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 55:
                    if (zzR(obj, i19, i17)) {
                        long jZzp = zzp(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(jZzp);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 56:
                    if (zzR(obj, i19, i17)) {
                        iZzz = zzgza.zzz(i19 << 3);
                        iZzh = iZzz + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzR(obj, i19, i17)) {
                        iZzz2 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 58:
                    if (zzR(obj, i19, i17)) {
                        iZzz4 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz4 + 1;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 59:
                    if (zzR(obj, i19, i17)) {
                        int i46 = i19 << 3;
                        Object object2 = unsafe.getObject(obj, j11);
                        if (object2 instanceof zzgyl) {
                            iZzz5 = zzgza.zzz(i46);
                            iZzd = ((zzgyl) object2).zzd();
                            iZzz6 = zzgza.zzz(iZzd);
                            iZzh = iZzz5 + iZzz6 + iZzd;
                            i18 += iZzh;
                        } else {
                            iZzz3 = zzgza.zzz(i46);
                            iZzA = zzgza.zzy((String) object2);
                            iZzh = iZzz3 + iZzA;
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
                    if (zzR(obj, i19, i17)) {
                        iZzh = zzhca.zzh(i19, unsafe.getObject(obj, j11), zzx(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 61:
                    if (zzR(obj, i19, i17)) {
                        zzgyl zzgylVar2 = (zzgyl) unsafe.getObject(obj, j11);
                        iZzz5 = zzgza.zzz(i19 << 3);
                        iZzd = zzgylVar2.zzd();
                        iZzz6 = zzgza.zzz(iZzd);
                        iZzh = iZzz5 + iZzz6 + iZzd;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 62:
                    if (zzR(obj, i19, i17)) {
                        int iZzp = zzp(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzz(iZzp);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 63:
                    if (zzR(obj, i19, i17)) {
                        long jZzp2 = zzp(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA(jZzp2);
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 64:
                    if (zzR(obj, i19, i17)) {
                        iZzz2 = zzgza.zzz(i19 << 3);
                        iZzh = iZzz2 + 4;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i19, i17)) {
                        iZzz = zzgza.zzz(i19 << 3);
                        iZzh = iZzz + 8;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 66:
                    if (zzR(obj, i19, i17)) {
                        int iZzp2 = zzp(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzz((iZzp2 >> 31) ^ (iZzp2 + iZzp2));
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzR(obj, i19, i17)) {
                        long jZzv3 = zzv(obj, j11);
                        iZzz3 = zzgza.zzz(i19 << 3);
                        iZzA = zzgza.zzA((jZzv3 >> 63) ^ (jZzv3 + jZzv3));
                        iZzh = iZzz3 + iZzA;
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 68:
                    if (zzR(obj, i19, i17)) {
                        iZzh = zzgza.zzw(i19, (zzhbe) unsafe.getObject(obj, j11), zzx(i17));
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
        zzhcp zzhcpVar = this.zzn;
        int iZza2 = i18 + zzhcpVar.zza(zzhcpVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zzb(Object obj) {
        int i11;
        long jDoubleToLongBits;
        int i12;
        int iFloatToIntBits;
        int i13;
        int i14 = 0;
        for (int i15 = 0; i15 < this.zzc.length; i15 += 3) {
            int iZzu = zzu(i15);
            int[] iArr = this.zzc;
            int i16 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i17 = iArr[i15];
            long j11 = i16;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i11 = i14 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhcz.zzb(obj, j11));
                    byte[] bArr = zzhae.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i12 = i14 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhcz.zzc(obj, j11));
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 2:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j11);
                    byte[] bArr2 = zzhae.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j11);
                    byte[] bArr3 = zzhae.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 5:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j11);
                    byte[] bArr4 = zzhae.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 7:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhae.zza(zzhcz.zzz(obj, j11));
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 8:
                    i12 = i14 * 53;
                    iFloatToIntBits = ((String) zzhcz.zzh(obj, j11)).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 9:
                    i13 = i14 * 53;
                    Object objZzh = zzhcz.zzh(obj, j11);
                    if (objZzh != null) {
                        iHashCode = objZzh.hashCode();
                    }
                    i14 = i13 + iHashCode;
                    break;
                case 10:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzh(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 11:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 12:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 13:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 14:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j11);
                    byte[] bArr5 = zzhae.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 16:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j11);
                    byte[] bArr6 = zzhae.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i13 = i14 * 53;
                    Object objZzh2 = zzhcz.zzh(obj, j11);
                    if (objZzh2 != null) {
                        iHashCode = objZzh2.hashCode();
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
                    iFloatToIntBits = zzhcz.zzh(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 50:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzhcz.zzh(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j11));
                        byte[] bArr7 = zzhae.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j11));
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzv(obj, j11);
                        byte[] bArr8 = zzhae.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (zzR(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzv(obj, j11);
                        byte[] bArr9 = zzhae.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzp(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzv(obj, j11);
                        byte[] bArr10 = zzhae.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzp(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhae.zza(zzS(obj, j11));
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = ((String) zzhcz.zzh(obj, j11)).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhcz.zzh(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhcz.zzh(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzp(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzp(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzp(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzv(obj, j11);
                        byte[] bArr11 = zzhae.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzp(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzR(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzv(obj, j11);
                        byte[] bArr12 = zzhae.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (zzR(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzhcz.zzh(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i14 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:280:0x0706 A[PHI: r0 r1 r2 r3 r4 r7 r15 r29
  0x0706: PHI (r0v120 int) = (r0v110 int), (r0v112 int), (r0v116 int), (r0v118 int), (r0v121 int) binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r1v102 com.google.android.gms.internal.ads.zzgxx) = 
  (r1v96 com.google.android.gms.internal.ads.zzgxx)
  (r1v98 com.google.android.gms.internal.ads.zzgxx)
  (r1v100 com.google.android.gms.internal.ads.zzgxx)
  (r1v101 com.google.android.gms.internal.ads.zzgxx)
  (r1v103 com.google.android.gms.internal.ads.zzgxx)
 binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r2v91 int) = (r2v86 int), (r2v87 int), (r2v89 int), (r2v90 int), (r2v92 int) binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r3v75 int) = (r3v69 int), (r3v71 int), (r3v73 int), (r3v74 int), (r3v76 int) binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r4v79 int) = (r4v73 int), (r4v75 int), (r4v77 int), (r4v78 int), (r4v80 int) binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r7v19 byte[]) = (r7v14 byte[]), (r7v15 byte[]), (r7v17 byte[]), (r7v18 byte[]), (r7v20 byte[]) binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r15v24 int) = (r15v19 int), (r15v20 int), (r15v22 int), (r15v23 int), (r15v25 int) binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]
  0x0706: PHI (r29v15 sun.misc.Unsafe) = 
  (r29v10 sun.misc.Unsafe)
  (r29v11 sun.misc.Unsafe)
  (r29v13 sun.misc.Unsafe)
  (r29v14 sun.misc.Unsafe)
  (r29v16 sun.misc.Unsafe)
 binds: [B:344:0x0835, B:335:0x07fd, B:318:0x07a3, B:294:0x0743, B:232:0x064e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:393:0x0956 A[PHI: r7 r8 r10 r11 r12 r14 r15 r29
  0x0956: PHI (r7v28 byte[]) = (r7v10 byte[]), (r7v11 byte[]), (r7v13 byte[]), (r7v19 byte[]), (r7v26 byte[]), (r7v33 byte[]) binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r8v150 int) = (r8v95 int), (r8v96 int), (r8v98 int), (r8v121 int), (r8v148 int), (r8v156 int) binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r10v93 com.google.android.gms.internal.ads.zzgxx) = 
  (r10v72 com.google.android.gms.internal.ads.zzgxx)
  (r10v73 com.google.android.gms.internal.ads.zzgxx)
  (r10v75 com.google.android.gms.internal.ads.zzgxx)
  (r10v80 com.google.android.gms.internal.ads.zzgxx)
  (r10v92 com.google.android.gms.internal.ads.zzgxx)
  (r10v98 com.google.android.gms.internal.ads.zzgxx)
 binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r11v66 int) = (r11v36 int), (r11v37 int), (r11v39 int), (r11v50 int), (r11v64 int), (r11v70 int) binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r12v48 int) = (r12v19 int), (r12v20 int), (r12v22 int), (r12v37 int), (r12v45 int), (r12v51 int) binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r14v71 int) = (r14v55 int), (r14v56 int), (r14v58 int), (r14v61 int), (r14v69 int), (r14v76 int) binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r15v33 int) = (r15v15 int), (r15v16 int), (r15v18 int), (r15v24 int), (r15v31 int), (r15v37 int) binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]
  0x0956: PHI (r29v24 sun.misc.Unsafe) = 
  (r29v6 sun.misc.Unsafe)
  (r29v7 sun.misc.Unsafe)
  (r29v9 sun.misc.Unsafe)
  (r29v15 sun.misc.Unsafe)
  (r29v22 sun.misc.Unsafe)
  (r29v27 sun.misc.Unsafe)
 binds: [B:387:0x092c, B:371:0x08ce, B:355:0x0879, B:280:0x0706, B:176:0x051e, B:160:0x04b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:479:0x0c2c A[PHI: r0 r1 r2 r5 r6 r10 r21
  0x0c2c: PHI (r0v83 int) = 
  (r0v67 int)
  (r0v68 int)
  (r0v69 int)
  (r0v70 int)
  (r0v71 int)
  (r0v72 int)
  (r0v73 int)
  (r0v75 int)
  (r0v80 int)
  (r0v84 int)
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]
  0x0c2c: PHI (r1v76 int) = 
  (r1v53 int)
  (r1v54 int)
  (r1v55 int)
  (r1v56 int)
  (r1v57 int)
  (r1v58 int)
  (r1v59 int)
  (r1v61 int)
  (r1v68 int)
  (r1v77 int)
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]
  0x0c2c: PHI (r2v69 com.google.android.gms.internal.ads.zzgxx) = 
  (r2v55 com.google.android.gms.internal.ads.zzgxx)
  (r2v56 com.google.android.gms.internal.ads.zzgxx)
  (r2v57 com.google.android.gms.internal.ads.zzgxx)
  (r2v58 com.google.android.gms.internal.ads.zzgxx)
  (r2v59 com.google.android.gms.internal.ads.zzgxx)
  (r2v60 com.google.android.gms.internal.ads.zzgxx)
  (r2v61 com.google.android.gms.internal.ads.zzgxx)
  (r2v63 com.google.android.gms.internal.ads.zzgxx)
  (r2v66 com.google.android.gms.internal.ads.zzgxx)
  (r2v70 com.google.android.gms.internal.ads.zzgxx)
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]
  0x0c2c: PHI (r5v73 byte[]) = 
  (r5v51 byte[])
  (r5v52 byte[])
  (r5v53 byte[])
  (r5v54 byte[])
  (r5v55 byte[])
  (r5v56 byte[])
  (r5v57 byte[])
  (r5v59 byte[])
  (r5v67 byte[])
  (r5v74 byte[])
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]
  0x0c2c: PHI (r6v24 com.google.android.gms.internal.ads.zzhbh<T>) = 
  (r6v6 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v7 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v8 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v9 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v10 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v11 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v12 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v14 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v19 com.google.android.gms.internal.ads.zzhbh<T>)
  (r6v25 com.google.android.gms.internal.ads.zzhbh<T>)
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]
  0x0c2c: PHI (r10v70 int) = 
  (r10v53 int)
  (r10v54 int)
  (r10v55 int)
  (r10v56 int)
  (r10v57 int)
  (r10v58 int)
  (r10v59 int)
  (r10v61 int)
  (r10v65 int)
  (r10v71 int)
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]
  0x0c2c: PHI (r21v20 int) = 
  (r21v4 int)
  (r21v5 int)
  (r21v6 int)
  (r21v7 int)
  (r21v8 int)
  (r21v9 int)
  (r21v10 int)
  (r21v12 int)
  (r21v17 int)
  (r21v21 int)
 binds: [B:477:0x0c14, B:474:0x0beb, B:471:0x0bc6, B:468:0x0ba2, B:465:0x0b7f, B:462:0x0b5b, B:455:0x0b2e, B:453:0x0b1a, B:418:0x0a2c, B:410:0x09d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:553:0x0959 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:0x0c2f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:0x0c3e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x096d A[SYNTHETIC] */
    public final int zzc(Object obj, byte[] bArr, int i11, int i12, int i13, zzgxx zzgxxVar) throws IOException {
        Unsafe unsafe;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iZzg;
        zzgzf zzgzfVar;
        zzgxx zzgxxVar2;
        int i21;
        int i22;
        Unsafe unsafe2;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int iZzh;
        int i28;
        int i29;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        zzgxx zzgxxVar3;
        int i37;
        int i38;
        byte[] bArr2;
        byte[] bArr3;
        int i39;
        int iZzk;
        zzgxx zzgxxVar4;
        byte[] bArr4;
        zzhad zzhadVar;
        byte[] bArr5;
        int i40;
        int i41;
        int i42;
        int i43;
        zzgxx zzgxxVar5;
        int iZzj;
        int iZzh2;
        int i44;
        zzgxx zzgxxVar6;
        int i45;
        int i46;
        int i47;
        int iZzf;
        int i48;
        int iZzh3;
        zzgxx zzgxxVar7;
        int iZzj2;
        zzhbh<T> zzhbhVar = this;
        Object obj2 = obj;
        byte[] bArr6 = bArr;
        i12 = i12;
        i13 = i13;
        zzgxx zzgxxVar8 = zzgxxVar;
        zzD(obj);
        Unsafe unsafe3 = zzb;
        int i49 = -1;
        int iZzl = i11;
        int i50 = -1;
        int i51 = 0;
        int i52 = 0;
        int i53 = 0;
        int i54 = 1048575;
        while (true) {
            if (iZzl < i12) {
                int i55 = iZzl + 1;
                byte b11 = bArr6[iZzl];
                if (b11 < 0) {
                    int iZzi = zzgxy.zzi(b11, bArr6, i55, zzgxxVar8);
                    i16 = zzgxxVar8.zza;
                    i55 = iZzi;
                } else {
                    i16 = b11;
                }
                int i56 = i16 >>> 3;
                int iZzs = i56 > i50 ? (i56 < zzhbhVar.zze || i56 > zzhbhVar.zzf) ? -1 : zzhbhVar.zzs(i56, i51 / 3) : zzhbhVar.zzq(i56);
                if (iZzs == i49) {
                    unsafe = unsafe3;
                    i15 = i13;
                    i17 = i56;
                    iZzl = i55;
                    i18 = i16;
                    i19 = 0;
                } else {
                    int i57 = i16 & 7;
                    int[] iArr = zzhbhVar.zzc;
                    int i58 = iArr[iZzs + 1];
                    int iZzt = zzt(i58);
                    int i59 = i55;
                    int i60 = i16;
                    long j11 = i58 & 1048575;
                    if (iZzt <= 17) {
                        int i61 = iArr[iZzs + 2];
                        int i62 = 1 << (i61 >>> 20);
                        int i63 = 1048575;
                        int i64 = i61 & 1048575;
                        if (i64 != i54) {
                            if (i54 != 1048575) {
                                unsafe3.putInt(obj2, i54, i53);
                                i63 = 1048575;
                            }
                            if (i64 == i63) {
                                i64 = i64;
                                i53 = 0;
                            } else {
                                i64 = i64;
                                i53 = unsafe3.getInt(obj2, i64);
                            }
                            i54 = i64;
                        } else {
                            i54 = i54;
                        }
                        switch (iZzt) {
                            case 0:
                                zzgxxVar2 = zzgxxVar8;
                                i21 = iZzs;
                                i22 = i60;
                                unsafe2 = unsafe3;
                                i23 = i56;
                                iZzl = i59;
                                if (i57 == 1) {
                                    i24 = iZzl + 8;
                                    i53 |= i62;
                                    zzhcz.zzr(obj2, j11, Double.longBitsToDouble(zzgxy.zzn(bArr6, iZzl)));
                                    i13 = i13;
                                    iZzl = i24;
                                    i52 = i22;
                                    i12 = i12;
                                    unsafe3 = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i50 = i23;
                                    i49 = -1;
                                    i51 = i21;
                                } else {
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 1:
                                zzgxxVar2 = zzgxxVar8;
                                i21 = iZzs;
                                i22 = i60;
                                unsafe2 = unsafe3;
                                i23 = i56;
                                iZzl = i59;
                                if (i57 == 5) {
                                    i24 = iZzl + 4;
                                    i53 |= i62;
                                    zzhcz.zzs(obj2, j11, Float.intBitsToFloat(zzgxy.zzb(bArr6, iZzl)));
                                    i13 = i13;
                                    iZzl = i24;
                                    i52 = i22;
                                    i12 = i12;
                                    unsafe3 = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i50 = i23;
                                    i49 = -1;
                                    i51 = i21;
                                } else {
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 2:
                            case 3:
                                zzgxxVar2 = zzgxxVar8;
                                i25 = i60;
                                i26 = i12;
                                i23 = i56;
                                iZzl = i59;
                                unsafe2 = unsafe3;
                                i27 = iZzs;
                                if (i57 == 0) {
                                    i53 |= i62;
                                    iZzl = zzgxy.zzk(bArr6, iZzl, zzgxxVar2);
                                    i52 = i25;
                                    unsafe2.putLong(obj, j11, zzgxxVar2.zzb);
                                    i12 = i26;
                                    unsafe3 = unsafe2;
                                    i51 = i27;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i50 = i23;
                                    i49 = -1;
                                } else {
                                    i21 = i27;
                                    i22 = i25;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 4:
                            case 11:
                                zzgxxVar2 = zzgxxVar8;
                                i25 = i60;
                                i26 = i12;
                                i23 = i56;
                                iZzl = i59;
                                unsafe2 = unsafe3;
                                i27 = iZzs;
                                if (i57 == 0) {
                                    i53 |= i62;
                                    iZzl = zzgxy.zzh(bArr6, iZzl, zzgxxVar2);
                                    unsafe2.putInt(obj2, j11, zzgxxVar2.zza);
                                    i13 = i13;
                                    i52 = i25;
                                    i50 = i23;
                                    i49 = -1;
                                    i12 = i26;
                                    zzgxxVar8 = zzgxxVar2;
                                    Unsafe unsafe4 = unsafe2;
                                    i51 = i27;
                                    unsafe3 = unsafe4;
                                } else {
                                    i21 = i27;
                                    i22 = i25;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 5:
                            case 14:
                                zzgxxVar2 = zzgxxVar8;
                                i22 = i60;
                                i23 = i56;
                                iZzl = i59;
                                unsafe2 = unsafe3;
                                if (i57 == 1) {
                                    i53 |= i62;
                                    unsafe2.putLong(obj, j11, zzgxy.zzn(bArr6, iZzl));
                                    i13 = i13;
                                    unsafe3 = unsafe2;
                                    i12 = i12;
                                    i51 = iZzs;
                                    zzgxxVar8 = zzgxxVar2;
                                    i49 = -1;
                                    i52 = i22;
                                    iZzl += 8;
                                    i50 = i23;
                                } else {
                                    i21 = iZzs;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 6:
                            case 13:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i22 = i60;
                                i23 = i56;
                                iZzl = i59;
                                unsafe2 = unsafe3;
                                i27 = iZzs;
                                if (i57 == 5) {
                                    i53 |= i62;
                                    unsafe2.putInt(obj2, j11, zzgxy.zzb(bArr6, iZzl));
                                    iZzl += 4;
                                    i52 = i22;
                                    zzgxxVar8 = zzgxxVar2;
                                    i50 = i23;
                                    i49 = -1;
                                    Unsafe unsafe5 = unsafe2;
                                    i51 = i27;
                                    unsafe3 = unsafe5;
                                } else {
                                    i21 = i27;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 7:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i22 = i60;
                                i23 = i56;
                                iZzl = i59;
                                unsafe2 = unsafe3;
                                i27 = iZzs;
                                if (i57 == 0) {
                                    i53 |= i62;
                                    iZzl = zzgxy.zzk(bArr6, iZzl, zzgxxVar2);
                                    zzhcz.zzp(obj2, j11, zzgxxVar2.zzb != 0);
                                    i52 = i22;
                                    zzgxxVar8 = zzgxxVar2;
                                    i50 = i23;
                                    i49 = -1;
                                    Unsafe unsafe6 = unsafe2;
                                    i51 = i27;
                                    unsafe3 = unsafe6;
                                } else {
                                    i21 = i27;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 8:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i22 = i60;
                                i23 = i56;
                                iZzl = i59;
                                unsafe2 = unsafe3;
                                i27 = iZzs;
                                if (i57 == 2) {
                                    if (zzM(i58)) {
                                        iZzh = zzgxy.zzh(bArr6, iZzl, zzgxxVar2);
                                        i28 = zzgxxVar2.zza;
                                        if (i28 < 0) {
                                            throw zzhag.zzf();
                                        }
                                        i29 = i62 | i53;
                                        if (i28 == 0) {
                                            zzgxxVar2.zzc = "";
                                        } else {
                                            zzgxxVar2.zzc = zzhde.zzh(bArr6, iZzh, i28);
                                            iZzh += i28;
                                        }
                                    } else {
                                        iZzh = zzgxy.zzh(bArr6, iZzl, zzgxxVar2);
                                        i28 = zzgxxVar2.zza;
                                        if (i28 < 0) {
                                            throw zzhag.zzf();
                                        }
                                        i29 = i62 | i53;
                                        if (i28 == 0) {
                                            zzgxxVar2.zzc = "";
                                        } else {
                                            zzgxxVar2.zzc = new String(bArr6, iZzh, i28, zzhae.zzb);
                                            iZzh += i28;
                                        }
                                    }
                                    iZzl = iZzh;
                                    i53 = i29;
                                    unsafe2.putObject(obj2, j11, zzgxxVar2.zzc);
                                    i52 = i22;
                                    zzgxxVar8 = zzgxxVar2;
                                    i50 = i23;
                                    i49 = -1;
                                    Unsafe unsafe7 = unsafe2;
                                    i51 = i27;
                                    unsafe3 = unsafe7;
                                } else {
                                    i21 = i27;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 9:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i31 = iZzs;
                                i32 = i60;
                                unsafe2 = unsafe3;
                                i23 = i56;
                                iZzl = i59;
                                if (i57 == 2) {
                                    i53 |= i62;
                                    Object objZzA = zzhbhVar.zzA(obj2, i31);
                                    i52 = i32;
                                    int iZzm = zzgxy.zzm(objZzA, zzhbhVar.zzx(i31), bArr, iZzl, i12, zzgxxVar);
                                    zzhbhVar.zzJ(obj2, i31, objZzA);
                                    i13 = i13;
                                    i12 = i12;
                                    unsafe3 = unsafe2;
                                    i51 = i31;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i50 = i23;
                                    i49 = -1;
                                    iZzl = iZzm;
                                } else {
                                    i21 = i31;
                                    i22 = i32;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 10:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i31 = iZzs;
                                i32 = i60;
                                unsafe2 = unsafe3;
                                i23 = i56;
                                iZzl = i59;
                                if (i57 == 2) {
                                    i53 |= i62;
                                    iZzl = zzgxy.zza(bArr6, iZzl, zzgxxVar2);
                                    unsafe2.putObject(obj2, j11, zzgxxVar2.zzc);
                                    i52 = i32;
                                    i13 = i13;
                                    unsafe3 = unsafe2;
                                    i50 = i23;
                                    i49 = -1;
                                    i51 = i31;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                } else {
                                    i21 = i31;
                                    i22 = i32;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 12:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i31 = iZzs;
                                i33 = i60;
                                unsafe2 = unsafe3;
                                i23 = i56;
                                iZzl = i59;
                                if (i57 == 0) {
                                    iZzl = zzgxy.zzh(bArr6, iZzl, zzgxxVar2);
                                    int i65 = zzgxxVar2.zza;
                                    zzgzy zzgzyVarZzw = zzhbhVar.zzw(i31);
                                    if ((i58 & Integer.MIN_VALUE) == 0 || zzgzyVarZzw == null || zzgzyVarZzw.zza(i65)) {
                                        i34 = i33;
                                        i53 |= i62;
                                        unsafe2.putInt(obj2, j11, i65);
                                    } else {
                                        i34 = i33;
                                        zzd(obj).zzj(i34, Long.valueOf(i65));
                                    }
                                    i13 = i13;
                                    i52 = i34;
                                    unsafe3 = unsafe2;
                                    i50 = i23;
                                    i49 = -1;
                                    i51 = i31;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                } else {
                                    i21 = i31;
                                    i22 = i33;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 15:
                                i12 = i12;
                                zzgxxVar2 = zzgxxVar8;
                                i31 = iZzs;
                                i33 = i60;
                                unsafe2 = unsafe3;
                                i23 = i56;
                                iZzl = i59;
                                if (i57 == 0) {
                                    i53 |= i62;
                                    iZzl = zzgxy.zzh(bArr6, iZzl, zzgxxVar2);
                                    unsafe2.putInt(obj2, j11, zzgyt.zzF(zzgxxVar2.zza));
                                    i13 = i13;
                                    unsafe3 = unsafe2;
                                    i50 = i23;
                                    i52 = i33;
                                    i49 = -1;
                                    i51 = i31;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                } else {
                                    i21 = i31;
                                    i22 = i33;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            case 16:
                                i33 = i60;
                                if (i57 == 0) {
                                    i53 |= i62;
                                    iZzl = zzgxy.zzk(bArr6, i59, zzgxxVar8);
                                    i23 = i56;
                                    unsafe3.putLong(obj, j11, zzgyt.zzG(zzgxxVar8.zzb));
                                    unsafe3 = unsafe3;
                                    i12 = i12;
                                    i13 = i13;
                                    zzgxxVar8 = zzgxxVar8;
                                    i52 = i33;
                                    i49 = -1;
                                    i51 = iZzs;
                                    i50 = i23;
                                } else {
                                    zzgxxVar2 = zzgxxVar8;
                                    i23 = i56;
                                    iZzl = i59;
                                    unsafe2 = unsafe3;
                                    i21 = iZzs;
                                    i22 = i33;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                            default:
                                if (i57 == 3) {
                                    Object objZzA2 = zzhbhVar.zzA(obj2, iZzs);
                                    iZzl = zzgxy.zzl(objZzA2, zzhbhVar.zzx(iZzs), bArr, i59, i12, (i56 << 3) | 4, zzgxxVar);
                                    zzhbhVar.zzJ(obj2, iZzs, objZzA2);
                                    i53 |= i62;
                                    i51 = iZzs;
                                    i50 = i56;
                                    i54 = i54;
                                    i52 = i60;
                                    i49 = -1;
                                    i13 = i13;
                                } else {
                                    zzgxxVar2 = zzgxxVar8;
                                    i21 = iZzs;
                                    i22 = i60;
                                    unsafe2 = unsafe3;
                                    i23 = i56;
                                    iZzl = i59;
                                    i15 = i13;
                                    i18 = i22;
                                    unsafe = unsafe2;
                                    zzgxxVar8 = zzgxxVar2;
                                    i54 = i54;
                                    i17 = i23;
                                    i19 = i21;
                                }
                                break;
                        }
                    } else {
                        int i66 = i54;
                        zzgxx zzgxxVar9 = zzgxxVar8;
                        Unsafe unsafe8 = unsafe3;
                        if (iZzt != 27) {
                            Unsafe unsafe9 = unsafe8;
                            i35 = i53;
                            if (iZzt <= 49) {
                                long j12 = i58;
                                Unsafe unsafe10 = zzb;
                                zzhad zzhadVar2 = (zzhad) unsafe10.getObject(obj2, j11);
                                if (zzhadVar2.zzc()) {
                                    unsafe9 = unsafe9;
                                    zzhadVar = zzhadVar2;
                                } else {
                                    int size = zzhadVar2.size();
                                    zzhad zzhadVarZzd = zzhadVar2.zzd(size == 0 ? 10 : size + size);
                                    unsafe10.putObject(obj2, j11, zzhadVarZzd);
                                    zzhadVar = zzhadVarZzd;
                                }
                                switch (iZzt) {
                                    case 18:
                                    case 35:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        i19 = iZzs;
                                        i41 = i60;
                                        i42 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar3 = zzhadVar;
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar;
                                        if (i57 == 2) {
                                            zzgzc zzgzcVar = (zzgzc) zzhadVar3;
                                            iZzh2 = zzgxy.zzh(bArr5, i42, zzgxxVar5);
                                            int i67 = zzgxxVar5.zza + iZzh2;
                                            while (iZzh2 < i67) {
                                                zzgzcVar.zze(Double.longBitsToDouble(zzgxy.zzn(bArr5, iZzh2)));
                                                iZzh2 += 8;
                                            }
                                            if (iZzh2 != i67) {
                                                throw zzhag.zzj();
                                            }
                                            iZzj = iZzh2;
                                        } else if (i57 == 1) {
                                            iZzj = i42 + 8;
                                            zzgzc zzgzcVar2 = (zzgzc) zzhadVar3;
                                            zzgzcVar2.zze(Double.longBitsToDouble(zzgxy.zzn(bArr5, i42)));
                                            while (iZzj < i40) {
                                                int iZzh4 = zzgxy.zzh(bArr5, iZzj, zzgxxVar5);
                                                if (i41 == zzgxxVar5.zza) {
                                                    zzgzcVar2.zze(Double.longBitsToDouble(zzgxy.zzn(bArr5, iZzh4)));
                                                    iZzj = iZzh4 + 8;
                                                }
                                            }
                                        } else {
                                            iZzj = i42;
                                        }
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        i19 = iZzs;
                                        i41 = i60;
                                        i42 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar4 = zzhadVar;
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar;
                                        if (i57 == 2) {
                                            zzgzm zzgzmVar = (zzgzm) zzhadVar4;
                                            iZzh2 = zzgxy.zzh(bArr5, i42, zzgxxVar5);
                                            int i68 = zzgxxVar5.zza + iZzh2;
                                            while (iZzh2 < i68) {
                                                zzgzmVar.zze(Float.intBitsToFloat(zzgxy.zzb(bArr5, iZzh2)));
                                                iZzh2 += 4;
                                            }
                                            if (iZzh2 != i68) {
                                                throw zzhag.zzj();
                                            }
                                            iZzj = iZzh2;
                                        } else if (i57 == 5) {
                                            iZzj = i42 + 4;
                                            zzgzm zzgzmVar2 = (zzgzm) zzhadVar4;
                                            zzgzmVar2.zze(Float.intBitsToFloat(zzgxy.zzb(bArr5, i42)));
                                            while (iZzj < i40) {
                                                int iZzh5 = zzgxy.zzh(bArr5, iZzj, zzgxxVar5);
                                                if (i41 == zzgxxVar5.zza) {
                                                    zzgzmVar2.zze(Float.intBitsToFloat(zzgxy.zzb(bArr5, iZzh5)));
                                                    iZzj = iZzh5 + 4;
                                                }
                                            }
                                        } else {
                                            iZzj = i42;
                                        }
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        i19 = iZzs;
                                        i41 = i60;
                                        i42 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar5 = zzhadVar;
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar;
                                        if (i57 != 2) {
                                            if (i57 == 0) {
                                                zzhat zzhatVar = (zzhat) zzhadVar5;
                                                iZzh2 = zzgxy.zzk(bArr5, i42, zzgxxVar5);
                                                zzhatVar.zzg(zzgxxVar5.zzb);
                                                while (iZzh2 < i40) {
                                                    int iZzh6 = zzgxy.zzh(bArr5, iZzh2, zzgxxVar5);
                                                    if (i41 == zzgxxVar5.zza) {
                                                        iZzh2 = zzgxy.zzk(bArr5, iZzh6, zzgxxVar5);
                                                        zzhatVar.zzg(zzgxxVar5.zzb);
                                                    }
                                                }
                                            } else {
                                                iZzj = i42;
                                            }
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        } else {
                                            zzhat zzhatVar2 = (zzhat) zzhadVar5;
                                            iZzh2 = zzgxy.zzh(bArr5, i42, zzgxxVar5);
                                            int i69 = zzgxxVar5.zza + iZzh2;
                                            while (iZzh2 < i69) {
                                                iZzh2 = zzgxy.zzk(bArr5, iZzh2, zzgxxVar5);
                                                zzhatVar2.zzg(zzgxxVar5.zzb);
                                            }
                                            if (iZzh2 != i69) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        iZzj = iZzh2;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 22:
                                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                    case 39:
                                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                        bArr5 = bArr;
                                        i44 = i12;
                                        zzgxxVar6 = zzgxxVar;
                                        i19 = iZzs;
                                        i45 = i60;
                                        i46 = i56;
                                        i47 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar6 = zzhadVar;
                                        if (i57 == 2) {
                                            iZzf = zzgxy.zzf(bArr5, i47, zzhadVar6, zzgxxVar6);
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = iZzf;
                                        } else if (i57 == 0) {
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = zzgxy.zzj(i45, bArr, i47, i12, zzhadVar6, zzgxxVar);
                                        } else {
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = i42;
                                        }
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                        bArr5 = bArr;
                                        i44 = i12;
                                        zzgxxVar6 = zzgxxVar;
                                        i19 = iZzs;
                                        i45 = i60;
                                        i46 = i56;
                                        i47 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar7 = zzhadVar;
                                        if (i57 != 2) {
                                            if (i57 == 1) {
                                                i48 = i47 + 8;
                                                zzhat zzhatVar3 = (zzhat) zzhadVar7;
                                                zzhatVar3.zzg(zzgxy.zzn(bArr5, i47));
                                                while (i48 < i44) {
                                                    int iZzh7 = zzgxy.zzh(bArr5, i48, zzgxxVar6);
                                                    if (i45 != zzgxxVar6.zza) {
                                                        i41 = i45;
                                                        zzgxxVar5 = zzgxxVar6;
                                                        i42 = i47;
                                                        i43 = i46;
                                                        iZzj = i48;
                                                        i40 = i44;
                                                        if (iZzj != i42) {
                                                            i13 = i13;
                                                            iZzl = iZzj;
                                                            zzgxxVar8 = zzgxxVar5;
                                                            i12 = i40;
                                                            i50 = i43;
                                                            i52 = i41;
                                                            i51 = i19;
                                                            i54 = i66;
                                                            i53 = i35;
                                                            unsafe3 = unsafe;
                                                            i49 = -1;
                                                            bArr6 = bArr5;
                                                            obj2 = obj;
                                                        } else {
                                                            i15 = i13;
                                                            iZzl = iZzj;
                                                            zzgxxVar8 = zzgxxVar5;
                                                            i17 = i43;
                                                            i18 = i41;
                                                            i54 = i66;
                                                            i53 = i35;
                                                            obj2 = obj;
                                                        }
                                                    } else {
                                                        zzhatVar3.zzg(zzgxy.zzn(bArr5, iZzh7));
                                                        i48 = iZzh7 + 8;
                                                    }
                                                    break;
                                                }
                                                i41 = i45;
                                                zzgxxVar5 = zzgxxVar6;
                                                i42 = i47;
                                                i43 = i46;
                                                iZzj = i48;
                                                i40 = i44;
                                                if (iZzj != i42) {
                                                    i13 = i13;
                                                    iZzl = iZzj;
                                                    zzgxxVar8 = zzgxxVar5;
                                                    i12 = i40;
                                                    i50 = i43;
                                                    i52 = i41;
                                                    i51 = i19;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    bArr6 = bArr5;
                                                    obj2 = obj;
                                                } else {
                                                    i15 = i13;
                                                    iZzl = iZzj;
                                                    zzgxxVar8 = zzgxxVar5;
                                                    i17 = i43;
                                                    i18 = i41;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    obj2 = obj;
                                                }
                                            }
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                            break;
                                        } else {
                                            zzhat zzhatVar4 = (zzhat) zzhadVar7;
                                            iZzf = zzgxy.zzh(bArr5, i47, zzgxxVar6);
                                            int i70 = zzgxxVar6.zza + iZzf;
                                            while (iZzf < i70) {
                                                zzhatVar4.zzg(zzgxy.zzn(bArr5, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i70) {
                                                throw zzhag.zzj();
                                            }
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = iZzf;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case VungleException.WEB_CRASH /* 31 */:
                                    case 41:
                                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                        bArr5 = bArr;
                                        i44 = i12;
                                        zzgxxVar6 = zzgxxVar;
                                        i19 = iZzs;
                                        i45 = i60;
                                        i46 = i56;
                                        i47 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar8 = zzhadVar;
                                        if (i57 != 2) {
                                            if (i57 == 5) {
                                                i48 = i47 + 4;
                                                zzgzv zzgzvVar = (zzgzv) zzhadVar8;
                                                zzgzvVar.zzh(zzgxy.zzb(bArr5, i47));
                                                while (i48 < i44) {
                                                    int iZzh8 = zzgxy.zzh(bArr5, i48, zzgxxVar6);
                                                    if (i45 != zzgxxVar6.zza) {
                                                        i41 = i45;
                                                        zzgxxVar5 = zzgxxVar6;
                                                        i42 = i47;
                                                        i43 = i46;
                                                        iZzj = i48;
                                                        i40 = i44;
                                                        if (iZzj != i42) {
                                                            i13 = i13;
                                                            iZzl = iZzj;
                                                            zzgxxVar8 = zzgxxVar5;
                                                            i12 = i40;
                                                            i50 = i43;
                                                            i52 = i41;
                                                            i51 = i19;
                                                            i54 = i66;
                                                            i53 = i35;
                                                            unsafe3 = unsafe;
                                                            i49 = -1;
                                                            bArr6 = bArr5;
                                                            obj2 = obj;
                                                        } else {
                                                            i15 = i13;
                                                            iZzl = iZzj;
                                                            zzgxxVar8 = zzgxxVar5;
                                                            i17 = i43;
                                                            i18 = i41;
                                                            i54 = i66;
                                                            i53 = i35;
                                                            obj2 = obj;
                                                        }
                                                    } else {
                                                        zzgzvVar.zzh(zzgxy.zzb(bArr5, iZzh8));
                                                        i48 = iZzh8 + 4;
                                                    }
                                                    break;
                                                }
                                                i41 = i45;
                                                zzgxxVar5 = zzgxxVar6;
                                                i42 = i47;
                                                i43 = i46;
                                                iZzj = i48;
                                                i40 = i44;
                                                if (iZzj != i42) {
                                                    i13 = i13;
                                                    iZzl = iZzj;
                                                    zzgxxVar8 = zzgxxVar5;
                                                    i12 = i40;
                                                    i50 = i43;
                                                    i52 = i41;
                                                    i51 = i19;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    bArr6 = bArr5;
                                                    obj2 = obj;
                                                } else {
                                                    i15 = i13;
                                                    iZzl = iZzj;
                                                    zzgxxVar8 = zzgxxVar5;
                                                    i17 = i43;
                                                    i18 = i41;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    obj2 = obj;
                                                }
                                            }
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                            break;
                                        } else {
                                            zzgzv zzgzvVar2 = (zzgzv) zzhadVar8;
                                            iZzf = zzgxy.zzh(bArr5, i47, zzgxxVar6);
                                            int i71 = zzgxxVar6.zza + iZzf;
                                            while (iZzf < i71) {
                                                zzgzvVar2.zzh(zzgxy.zzb(bArr5, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i71) {
                                                throw zzhag.zzj();
                                            }
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = iZzf;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                    case 25:
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        bArr5 = bArr;
                                        i44 = i12;
                                        zzgxxVar6 = zzgxxVar;
                                        i19 = iZzs;
                                        i45 = i60;
                                        i46 = i56;
                                        i47 = i59;
                                        unsafe = unsafe9;
                                        zzhad zzhadVar9 = zzhadVar;
                                        if (i57 != 2) {
                                            if (i57 == 0) {
                                                zzgxz zzgxzVar = (zzgxz) zzhadVar9;
                                                iZzf = zzgxy.zzk(bArr5, i47, zzgxxVar6);
                                                zzgxzVar.zze(zzgxxVar6.zzb != 0);
                                                while (iZzf < i44) {
                                                    int iZzh9 = zzgxy.zzh(bArr5, iZzf, zzgxxVar6);
                                                    if (i45 == zzgxxVar6.zza) {
                                                        iZzf = zzgxy.zzk(bArr5, iZzh9, zzgxxVar6);
                                                        zzgxzVar.zze(zzgxxVar6.zzb != 0);
                                                    }
                                                }
                                            }
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        } else {
                                            zzgxz zzgxzVar2 = (zzgxz) zzhadVar9;
                                            iZzf = zzgxy.zzh(bArr5, i47, zzgxxVar6);
                                            int i72 = zzgxxVar6.zza + iZzf;
                                            while (iZzf < i72) {
                                                iZzf = zzgxy.zzk(bArr5, iZzf, zzgxxVar6);
                                                zzgxzVar2.zze(zzgxxVar6.zzb != 0);
                                            }
                                            if (iZzf != i72) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i41 = i45;
                                        zzgxxVar5 = zzgxxVar6;
                                        i42 = i47;
                                        i40 = i44;
                                        i43 = i46;
                                        iZzj = iZzf;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 26:
                                        bArr5 = bArr;
                                        i44 = i12;
                                        zzgxxVar6 = zzgxxVar;
                                        i46 = i56;
                                        unsafe = unsafe9;
                                        i19 = iZzs;
                                        i45 = i60;
                                        i47 = i59;
                                        zzhad zzhadVar10 = zzhadVar;
                                        if (i57 == 2) {
                                            if ((536870912 & j12) == 0) {
                                                iZzh3 = zzgxy.zzh(bArr5, i47, zzgxxVar6);
                                                int i73 = zzgxxVar6.zza;
                                                if (i73 < 0) {
                                                    throw zzhag.zzf();
                                                }
                                                if (i73 == 0) {
                                                    zzhadVar10.add("");
                                                } else {
                                                    zzhadVar10.add(new String(bArr5, iZzh3, i73, zzhae.zzb));
                                                    iZzh3 += i73;
                                                }
                                                while (iZzh3 < i44) {
                                                    int iZzh10 = zzgxy.zzh(bArr5, iZzh3, zzgxxVar6);
                                                    if (i45 == zzgxxVar6.zza) {
                                                        iZzh3 = zzgxy.zzh(bArr5, iZzh10, zzgxxVar6);
                                                        int i74 = zzgxxVar6.zza;
                                                        if (i74 < 0) {
                                                            throw zzhag.zzf();
                                                        }
                                                        if (i74 == 0) {
                                                            zzhadVar10.add("");
                                                        } else {
                                                            zzhadVar10.add(new String(bArr5, iZzh3, i74, zzhae.zzb));
                                                            iZzh3 += i74;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzh3 = zzgxy.zzh(bArr5, i47, zzgxxVar6);
                                                int i75 = zzgxxVar6.zza;
                                                if (i75 < 0) {
                                                    throw zzhag.zzf();
                                                }
                                                if (i75 == 0) {
                                                    zzhadVar10.add("");
                                                } else {
                                                    int i76 = iZzh3 + i75;
                                                    if (!zzhde.zzj(bArr5, iZzh3, i76)) {
                                                        throw zzhag.zzd();
                                                    }
                                                    zzhadVar10.add(new String(bArr5, iZzh3, i75, zzhae.zzb));
                                                    iZzh3 = i76;
                                                }
                                                while (iZzh3 < i44) {
                                                    int iZzh11 = zzgxy.zzh(bArr5, iZzh3, zzgxxVar6);
                                                    if (i45 == zzgxxVar6.zza) {
                                                        iZzh3 = zzgxy.zzh(bArr5, iZzh11, zzgxxVar6);
                                                        int i77 = zzgxxVar6.zza;
                                                        if (i77 < 0) {
                                                            throw zzhag.zzf();
                                                        }
                                                        if (i77 == 0) {
                                                            zzhadVar10.add("");
                                                        } else {
                                                            int i78 = iZzh3 + i77;
                                                            if (!zzhde.zzj(bArr5, iZzh3, i78)) {
                                                                throw zzhag.zzd();
                                                            }
                                                            zzhadVar10.add(new String(bArr5, iZzh3, i77, zzhae.zzb));
                                                            iZzh3 = i78;
                                                        }
                                                    }
                                                }
                                            }
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = iZzh3;
                                            i42 = i47;
                                        } else {
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = i42;
                                        }
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 27:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        zzgxxVar7 = zzgxxVar;
                                        i19 = iZzs;
                                        i41 = i60;
                                        unsafe = unsafe9;
                                        if (i57 == 2) {
                                            i46 = i56;
                                            i44 = i40;
                                            i47 = i59;
                                            zzgxxVar6 = zzgxxVar;
                                            i45 = i41;
                                            iZzf = zzgxy.zze(zzhbhVar.zzx(i19), i41, bArr, i47, i12, zzhadVar, zzgxxVar);
                                            i41 = i45;
                                            zzgxxVar5 = zzgxxVar6;
                                            i42 = i47;
                                            i40 = i44;
                                            i43 = i46;
                                            iZzj = iZzf;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        }
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar7;
                                        i42 = i59;
                                        iZzj = i42;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 28:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        zzgxxVar7 = zzgxxVar;
                                        i19 = iZzs;
                                        i41 = i60;
                                        unsafe = unsafe9;
                                        if (i57 == 2) {
                                            iZzj = zzgxy.zzh(bArr5, i59, zzgxxVar7);
                                            int i79 = zzgxxVar7.zza;
                                            if (i79 < 0) {
                                                throw zzhag.zzf();
                                            }
                                            if (i79 > bArr5.length - iZzj) {
                                                throw zzhag.zzj();
                                            }
                                            if (i79 == 0) {
                                                zzhadVar.add(zzgyl.zzb);
                                            } else {
                                                zzhadVar.add(zzgyl.zzv(bArr5, iZzj, i79));
                                                iZzj += i79;
                                            }
                                            while (iZzj < i40) {
                                                int iZzh12 = zzgxy.zzh(bArr5, iZzj, zzgxxVar7);
                                                if (i41 != zzgxxVar7.zza) {
                                                    i43 = i56;
                                                    zzgxxVar5 = zzgxxVar7;
                                                    i42 = i59;
                                                    if (iZzj != i42) {
                                                        i13 = i13;
                                                        iZzl = iZzj;
                                                        zzgxxVar8 = zzgxxVar5;
                                                        i12 = i40;
                                                        i50 = i43;
                                                        i52 = i41;
                                                        i51 = i19;
                                                        i54 = i66;
                                                        i53 = i35;
                                                        unsafe3 = unsafe;
                                                        i49 = -1;
                                                        bArr6 = bArr5;
                                                        obj2 = obj;
                                                    } else {
                                                        i15 = i13;
                                                        iZzl = iZzj;
                                                        zzgxxVar8 = zzgxxVar5;
                                                        i17 = i43;
                                                        i18 = i41;
                                                        i54 = i66;
                                                        i53 = i35;
                                                        obj2 = obj;
                                                    }
                                                    break;
                                                } else {
                                                    iZzj = zzgxy.zzh(bArr5, iZzh12, zzgxxVar7);
                                                    int i80 = zzgxxVar7.zza;
                                                    if (i80 < 0) {
                                                        throw zzhag.zzf();
                                                    }
                                                    if (i80 > bArr5.length - iZzj) {
                                                        throw zzhag.zzj();
                                                    }
                                                    if (i80 == 0) {
                                                        zzhadVar.add(zzgyl.zzb);
                                                    } else {
                                                        zzhadVar.add(zzgyl.zzv(bArr5, iZzj, i80));
                                                        iZzj += i80;
                                                    }
                                                }
                                            }
                                            i43 = i56;
                                            zzgxxVar5 = zzgxxVar7;
                                            i42 = i59;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        }
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar7;
                                        i42 = i59;
                                        iZzj = i42;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 30:
                                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        zzgxxVar7 = zzgxxVar;
                                        i19 = iZzs;
                                        i41 = i60;
                                        unsafe = unsafe9;
                                        if (i57 != 2) {
                                            if (i57 == 0) {
                                                iZzj2 = zzgxy.zzj(i41, bArr, i59, i12, zzhadVar, zzgxxVar);
                                            }
                                            i43 = i56;
                                            zzgxxVar5 = zzgxxVar7;
                                            i42 = i59;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        } else {
                                            iZzj2 = zzgxy.zzf(bArr5, i59, zzhadVar, zzgxxVar7);
                                        }
                                        int i81 = iZzj2;
                                        zzhca.zzo(obj, i56, zzhadVar, zzhbhVar.zzw(i19), null, zzhbhVar.zzn);
                                        iZzj = i81;
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar7;
                                        i42 = i59;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 33:
                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        zzgxxVar7 = zzgxxVar;
                                        i19 = iZzs;
                                        i41 = i60;
                                        unsafe = unsafe9;
                                        if (i57 != 2) {
                                            if (i57 == 0) {
                                                zzgzv zzgzvVar3 = (zzgzv) zzhadVar;
                                                iZzj = zzgxy.zzh(bArr5, i59, zzgxxVar7);
                                                zzgzvVar3.zzh(zzgyt.zzF(zzgxxVar7.zza));
                                                while (iZzj < i40) {
                                                    int iZzh13 = zzgxy.zzh(bArr5, iZzj, zzgxxVar7);
                                                    if (i41 == zzgxxVar7.zza) {
                                                        iZzj = zzgxy.zzh(bArr5, iZzh13, zzgxxVar7);
                                                        zzgzvVar3.zzh(zzgyt.zzF(zzgxxVar7.zza));
                                                    }
                                                }
                                            }
                                            i43 = i56;
                                            zzgxxVar5 = zzgxxVar7;
                                            i42 = i59;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        } else {
                                            zzgzv zzgzvVar4 = (zzgzv) zzhadVar;
                                            iZzj = zzgxy.zzh(bArr5, i59, zzgxxVar7);
                                            int i82 = zzgxxVar7.zza + iZzj;
                                            while (iZzj < i82) {
                                                iZzj = zzgxy.zzh(bArr5, iZzj, zzgxxVar7);
                                                zzgzvVar4.zzh(zzgyt.zzF(zzgxxVar7.zza));
                                            }
                                            if (iZzj != i82) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar7;
                                        i42 = i59;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        bArr5 = bArr;
                                        i40 = i12;
                                        zzgxxVar7 = zzgxxVar;
                                        i19 = iZzs;
                                        i41 = i60;
                                        unsafe = unsafe9;
                                        if (i57 != 2) {
                                            if (i57 == 0) {
                                                zzhat zzhatVar5 = (zzhat) zzhadVar;
                                                iZzj = zzgxy.zzk(bArr5, i59, zzgxxVar7);
                                                zzhatVar5.zzg(zzgyt.zzG(zzgxxVar7.zzb));
                                                while (iZzj < i40) {
                                                    int iZzh14 = zzgxy.zzh(bArr5, iZzj, zzgxxVar7);
                                                    if (i41 == zzgxxVar7.zza) {
                                                        iZzj = zzgxy.zzk(bArr5, iZzh14, zzgxxVar7);
                                                        zzhatVar5.zzg(zzgyt.zzG(zzgxxVar7.zzb));
                                                    }
                                                }
                                            }
                                            i43 = i56;
                                            zzgxxVar5 = zzgxxVar7;
                                            i42 = i59;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        } else {
                                            zzhat zzhatVar6 = (zzhat) zzhadVar;
                                            iZzj = zzgxy.zzh(bArr5, i59, zzgxxVar7);
                                            int i83 = zzgxxVar7.zza + iZzj;
                                            while (iZzj < i83) {
                                                iZzj = zzgxy.zzk(bArr5, iZzj, zzgxxVar7);
                                                zzhatVar6.zzg(zzgyt.zzG(zzgxxVar7.zzb));
                                            }
                                            if (iZzj != i83) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i43 = i56;
                                        zzgxxVar5 = zzgxxVar7;
                                        i42 = i59;
                                        if (iZzj != i42) {
                                            i13 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i12 = i40;
                                            i50 = i43;
                                            i52 = i41;
                                            i51 = i19;
                                            i54 = i66;
                                            i53 = i35;
                                            unsafe3 = unsafe;
                                            i49 = -1;
                                            bArr6 = bArr5;
                                            obj2 = obj;
                                        } else {
                                            i15 = i13;
                                            iZzl = iZzj;
                                            zzgxxVar8 = zzgxxVar5;
                                            i17 = i43;
                                            i18 = i41;
                                            i54 = i66;
                                            i53 = i35;
                                            obj2 = obj;
                                        }
                                        break;
                                    default:
                                        if (i57 == 3) {
                                            int i84 = (i60 & (-8)) | 4;
                                            zzhby zzhbyVarZzx = zzhbhVar.zzx(iZzs);
                                            i19 = iZzs;
                                            i41 = i60;
                                            i40 = i12;
                                            unsafe = unsafe9;
                                            zzgxx zzgxxVar10 = zzgxxVar;
                                            iZzj = zzgxy.zzc(zzhbyVarZzx, bArr, i59, i12, i84, zzgxxVar10);
                                            zzhadVar.add(zzgxxVar10.zzc);
                                            while (true) {
                                                if (iZzj < i40) {
                                                    int iZzh15 = zzgxy.zzh(bArr, iZzj, zzgxxVar10);
                                                    if (i41 == zzgxxVar10.zza) {
                                                        int i85 = i84;
                                                        int i86 = i84;
                                                        zzgxx zzgxxVar11 = zzgxxVar10;
                                                        iZzj = zzgxy.zzc(zzhbyVarZzx, bArr, iZzh15, i12, i85, zzgxxVar);
                                                        zzhadVar.add(zzgxxVar11.zzc);
                                                        zzgxxVar10 = zzgxxVar11;
                                                        i84 = i86;
                                                    } else {
                                                        bArr5 = bArr;
                                                    }
                                                } else {
                                                    bArr5 = bArr;
                                                }
                                            }
                                            zzgxxVar7 = zzgxxVar10;
                                            i43 = i56;
                                            zzgxxVar5 = zzgxxVar7;
                                            i42 = i59;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        } else {
                                            bArr5 = bArr;
                                            i19 = iZzs;
                                            unsafe = unsafe9;
                                            i40 = i12;
                                            i41 = i60;
                                            i43 = i56;
                                            i42 = i59;
                                            zzgxxVar5 = zzgxxVar;
                                            iZzj = i42;
                                            if (iZzj != i42) {
                                                i13 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i12 = i40;
                                                i50 = i43;
                                                i52 = i41;
                                                i51 = i19;
                                                i54 = i66;
                                                i53 = i35;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                bArr6 = bArr5;
                                                obj2 = obj;
                                            } else {
                                                i15 = i13;
                                                iZzl = iZzj;
                                                zzgxxVar8 = zzgxxVar5;
                                                i17 = i43;
                                                i18 = i41;
                                                i54 = i66;
                                                i53 = i35;
                                                obj2 = obj;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                unsafe = unsafe9;
                                byte[] bArr7 = bArr6;
                                i19 = iZzs;
                                i36 = i56;
                                zzgxxVar3 = zzgxxVar9;
                                i37 = i60;
                                i38 = i59;
                                if (iZzt != 50) {
                                    obj2 = obj;
                                    Unsafe unsafe11 = zzb;
                                    long j13 = iArr[i19 + 2] & 1048575;
                                    switch (iZzt) {
                                        case 51:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 1) {
                                                iZzk = i39 + 8;
                                                unsafe11.putObject(obj2, j11, Double.valueOf(Double.longBitsToDouble(zzgxy.zzn(bArr3, i39))));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 52:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 5) {
                                                iZzk = i39 + 4;
                                                unsafe11.putObject(obj2, j11, Float.valueOf(Float.intBitsToFloat(zzgxy.zzb(bArr3, i39))));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 0) {
                                                iZzk = zzgxy.zzk(bArr3, i39, zzgxxVar8);
                                                unsafe11.putObject(obj2, j11, Long.valueOf(zzgxxVar8.zzb));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 0) {
                                                iZzk = zzgxy.zzh(bArr3, i39, zzgxxVar8);
                                                unsafe11.putObject(obj2, j11, Integer.valueOf(zzgxxVar8.zza));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 56:
                                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 1) {
                                                iZzk = i39 + 8;
                                                unsafe11.putObject(obj2, j11, Long.valueOf(zzgxy.zzn(bArr3, i39)));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                        case 64:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 5) {
                                                iZzk = i39 + 4;
                                                unsafe11.putObject(obj2, j11, Integer.valueOf(zzgxy.zzb(bArr3, i39)));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 58:
                                            i18 = i37;
                                            i19 = i19;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 0) {
                                                iZzk = zzgxy.zzk(bArr3, i39, zzgxxVar8);
                                                unsafe11.putObject(obj2, j11, Boolean.valueOf(zzgxxVar8.zzb != 0));
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 59:
                                            i18 = i37;
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            if (i57 == 2) {
                                                iZzk = zzgxy.zzh(bArr3, i39, zzgxxVar8);
                                                int i87 = zzgxxVar8.zza;
                                                if (i87 == 0) {
                                                    unsafe11.putObject(obj2, j11, "");
                                                } else {
                                                    int i88 = iZzk + i87;
                                                    if ((i58 & ASTNode.DISCARD) != 0 && !zzhde.zzj(bArr3, iZzk, i88)) {
                                                        throw zzhag.zzd();
                                                    }
                                                    unsafe11.putObject(obj2, j11, new String(bArr3, iZzk, i87, zzhae.zzb));
                                                    iZzk = i88;
                                                }
                                                unsafe11.putInt(obj2, j13, i17);
                                                iZzl = iZzk;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                            } else {
                                                i19 = i19;
                                                iZzl = i39;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                            }
                                            break;
                                        case 60:
                                            zzhbhVar = this;
                                            zzgxxVar4 = zzgxxVar3;
                                            bArr4 = bArr7;
                                            i18 = i37;
                                            if (i57 == 2) {
                                                Object objZzB = zzhbhVar.zzB(obj2, i36, i19);
                                                i17 = i36;
                                                int iZzm2 = zzgxy.zzm(objZzB, zzhbhVar.zzx(i19), bArr, i38, i12, zzgxxVar);
                                                zzhbhVar.zzK(obj2, i17, i19, objZzB);
                                                iZzl = iZzm2;
                                                i39 = i38;
                                                bArr3 = bArr4;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                            } else {
                                                i17 = i36;
                                                i39 = i38;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                                bArr3 = bArr4;
                                                iZzl = i39;
                                            }
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 61:
                                            bArr4 = bArr7;
                                            i18 = i37;
                                            zzgxxVar4 = zzgxxVar3;
                                            zzhbhVar = this;
                                            if (i57 == 2) {
                                                iZzl = zzgxy.zza(bArr4, i38, zzgxxVar4);
                                                unsafe11.putObject(obj2, j11, zzgxxVar4.zzc);
                                                unsafe11.putInt(obj2, j13, i36);
                                                i17 = i36;
                                                i39 = i38;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                                bArr3 = bArr4;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                            }
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar4;
                                            i19 = i19;
                                            bArr3 = bArr4;
                                            iZzl = i39;
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 63:
                                            bArr4 = bArr7;
                                            i18 = i37;
                                            zzgxxVar4 = zzgxxVar3;
                                            zzhbhVar = this;
                                            if (i57 == 0) {
                                                iZzl = zzgxy.zzh(bArr4, i38, zzgxxVar4);
                                                int i89 = zzgxxVar4.zza;
                                                zzgzy zzgzyVarZzw2 = zzhbhVar.zzw(i19);
                                                if (zzgzyVarZzw2 == null || zzgzyVarZzw2.zza(i89)) {
                                                    unsafe11.putObject(obj2, j11, Integer.valueOf(i89));
                                                    unsafe11.putInt(obj2, j13, i36);
                                                } else {
                                                    zzd(obj).zzj(i18, Long.valueOf(i89));
                                                }
                                                i17 = i36;
                                                i39 = i38;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                                bArr3 = bArr4;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                            }
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar4;
                                            i19 = i19;
                                            bArr3 = bArr4;
                                            iZzl = i39;
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 66:
                                            bArr4 = bArr7;
                                            i18 = i37;
                                            zzgxxVar4 = zzgxxVar3;
                                            zzhbhVar = this;
                                            if (i57 == 0) {
                                                iZzl = zzgxy.zzh(bArr4, i38, zzgxxVar4);
                                                unsafe11.putObject(obj2, j11, Integer.valueOf(zzgyt.zzF(zzgxxVar4.zza)));
                                                unsafe11.putInt(obj2, j13, i36);
                                                i17 = i36;
                                                i39 = i38;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                                bArr3 = bArr4;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                            }
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar4;
                                            i19 = i19;
                                            bArr3 = bArr4;
                                            iZzl = i39;
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                            bArr4 = bArr7;
                                            i18 = i37;
                                            zzgxxVar4 = zzgxxVar3;
                                            zzhbhVar = this;
                                            if (i57 == 0) {
                                                iZzl = zzgxy.zzk(bArr4, i38, zzgxxVar4);
                                                unsafe11.putObject(obj2, j11, Long.valueOf(zzgyt.zzG(zzgxxVar4.zzb)));
                                                unsafe11.putInt(obj2, j13, i36);
                                                i17 = i36;
                                                i39 = i38;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                                bArr3 = bArr4;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                            }
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar4;
                                            i19 = i19;
                                            bArr3 = bArr4;
                                            iZzl = i39;
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                        case 68:
                                            if (i57 == 3) {
                                                zzhbhVar = this;
                                                Object objZzB2 = zzhbhVar.zzB(obj2, i36, i19);
                                                zzgxxVar4 = zzgxxVar3;
                                                bArr4 = bArr7;
                                                i18 = i37;
                                                iZzl = zzgxy.zzl(objZzB2, zzhbhVar.zzx(i19), bArr, i38, i12, (i37 & (-8)) | 4, zzgxxVar);
                                                zzhbhVar.zzK(obj2, i36, i19, objZzB2);
                                                i17 = i36;
                                                i39 = i38;
                                                zzgxxVar8 = zzgxxVar4;
                                                i19 = i19;
                                                bArr3 = bArr4;
                                                if (iZzl != i39) {
                                                    i18 = i18;
                                                    i52 = i18;
                                                    bArr6 = bArr3;
                                                    i50 = i17;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i51 = i19;
                                                    unsafe3 = unsafe;
                                                    i49 = -1;
                                                    i13 = i13;
                                                } else {
                                                    i18 = i18;
                                                    i15 = i13;
                                                    i54 = i66;
                                                    i53 = i35;
                                                    i19 = i19;
                                                }
                                                break;
                                            }
                                        default:
                                            zzhbhVar = this;
                                            bArr3 = bArr7;
                                            i18 = i37;
                                            i19 = i19;
                                            i17 = i36;
                                            i39 = i38;
                                            zzgxxVar8 = zzgxxVar3;
                                            iZzl = i39;
                                            if (iZzl != i39) {
                                                i18 = i18;
                                                i52 = i18;
                                                bArr6 = bArr3;
                                                i50 = i17;
                                                i54 = i66;
                                                i53 = i35;
                                                i51 = i19;
                                                unsafe3 = unsafe;
                                                i49 = -1;
                                                i13 = i13;
                                            } else {
                                                i18 = i18;
                                                i15 = i13;
                                                i54 = i66;
                                                i53 = i35;
                                                i19 = i19;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i57 == 2) {
                                        Unsafe unsafe12 = zzb;
                                        Object objZzz = zzhbhVar.zzz(i19);
                                        Object object = unsafe12.getObject(obj, j11);
                                        if (zzhaz.zza(object)) {
                                            zzhay zzhayVarZzb = zzhay.zza().zzb();
                                            zzhaz.zzb(zzhayVarZzb, object);
                                            unsafe12.putObject(obj, j11, zzhayVarZzb);
                                        }
                                        throw null;
                                    }
                                    bArr2 = bArr7;
                                    obj2 = obj;
                                }
                            }
                        } else if (i57 == 2) {
                            zzhad zzhadVarZzd2 = (zzhad) unsafe8.getObject(obj2, j11);
                            if (!zzhadVarZzd2.zzc()) {
                                int size2 = zzhadVarZzd2.size();
                                zzhadVarZzd2 = zzhadVarZzd2.zzd(size2 == 0 ? 10 : size2 + size2);
                                unsafe8.putObject(obj2, j11, zzhadVarZzd2);
                            }
                            unsafe3 = unsafe8;
                            iZzl = zzgxy.zze(zzhbhVar.zzx(iZzs), i60, bArr, i59, i12, zzhadVarZzd2, zzgxxVar);
                            i12 = i12;
                            i51 = iZzs;
                            i52 = i60;
                            i50 = i56;
                            i54 = i66;
                            i53 = i53;
                            zzgxxVar8 = zzgxxVar9;
                            i49 = -1;
                        } else {
                            i35 = i53;
                            unsafe = unsafe8;
                            zzgxxVar3 = zzgxxVar9;
                            bArr2 = bArr6;
                            i19 = iZzs;
                            i37 = i60;
                            i36 = i56;
                            i38 = i59;
                        }
                        i15 = i13;
                        iZzl = i38;
                        zzgxxVar8 = zzgxxVar3;
                        i18 = i37;
                        i54 = i66;
                        i53 = i35;
                        i17 = i36;
                    }
                }
                if (i18 != i15 || i15 == 0) {
                    if (!zzhbhVar.zzh || (zzgzfVar = zzgxxVar8.zzd) == zzgzf.zza) {
                        i52 = i18;
                        iZzg = zzgxy.zzg(i52, bArr, iZzl, i12, zzd(obj), zzgxxVar);
                    } else {
                        if (zzgzfVar.zzc(zzhbhVar.zzg, i17) != null) {
                            throw null;
                        }
                        i52 = i18;
                        iZzg = zzgxy.zzg(i18, bArr, iZzl, i12, zzd(obj), zzgxxVar);
                    }
                    iZzl = iZzg;
                    zzgxxVar8 = zzgxxVar;
                    i13 = i15;
                    i50 = i17;
                    i12 = i12;
                    i51 = i19;
                    unsafe3 = unsafe;
                    i49 = -1;
                    bArr6 = bArr;
                } else {
                    i14 = i12;
                    i52 = i18;
                }
            } else {
                unsafe = unsafe3;
                i14 = i12;
                i15 = i13;
            }
        }
        if (i54 != 1048575) {
            unsafe.putInt(obj2, i54, i53);
        }
        for (int i90 = zzhbhVar.zzk; i90 < zzhbhVar.zzl; i90++) {
            zzy(obj, zzhbhVar.zzj[i90], null, zzhbhVar.zzn, obj);
        }
        if (i15 == 0) {
            if (iZzl != i14) {
                throw zzhag.zzg();
            }
        } else if (iZzl > i14 || i52 != i15) {
            throw zzhag.zzg();
        }
        return iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final Object zze() {
        return ((zzgzu) this.zzg).zzaD();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgzu) {
                zzgzu zzgzuVar = (zzgzu) obj;
                zzgzuVar.zzaV(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                zzgzuVar.zza = 0;
                zzgzuVar.zzaT();
            }
            int[] iArr = this.zzc;
            for (int i11 = 0; i11 < iArr.length; i11 += 3) {
                int iZzu = zzu(i11);
                int i12 = 1048575 & iZzu;
                int iZzt = zzt(iZzu);
                long j11 = i12;
                if (iZzt != 9) {
                    if (iZzt != 60 && iZzt != 68) {
                        switch (iZzt) {
                            case 17:
                                if (zzN(obj, i11)) {
                                    zzx(i11).zzf(zzb.getObject(obj, j11));
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
                                this.zzm.zzb(obj, j11);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j11);
                                if (object != null) {
                                    ((zzhay) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                }
                                break;
                        }
                    } else if (zzR(obj, this.zzc[i11], i11)) {
                        zzx(i11).zzf(zzb.getObject(obj, j11));
                    }
                } else if (zzN(obj, i11)) {
                    zzx(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzu = zzu(i11);
            int i12 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i13 = iArr[i11];
            long j11 = i12;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzr(obj, j11, zzhcz.zzb(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzs(obj, j11, zzhcz.zzc(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzu(obj, j11, zzhcz.zzf(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzu(obj, j11, zzhcz.zzf(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzt(obj, j11, zzhcz.zzd(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzu(obj, j11, zzhcz.zzf(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzt(obj, j11, zzhcz.zzd(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzp(obj, j11, zzhcz.zzz(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzv(obj, j11, zzhcz.zzh(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i11);
                    break;
                case 10:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzv(obj, j11, zzhcz.zzh(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzt(obj, j11, zzhcz.zzd(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzt(obj, j11, zzhcz.zzd(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzt(obj, j11, zzhcz.zzd(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzu(obj, j11, zzhcz.zzf(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzt(obj, j11, zzhcz.zzd(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i11)) {
                        zzhcz.zzu(obj, j11, zzhcz.zzf(obj2, j11));
                        zzH(obj, i11);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i11);
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
                    this.zzm.zzc(obj, obj2, j11);
                    break;
                case 50:
                    int i14 = zzhca.zza;
                    zzhcz.zzv(obj, j11, zzhaz.zzb(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11)));
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
                    if (zzR(obj2, i13, i11)) {
                        zzhcz.zzv(obj, j11, zzhcz.zzh(obj2, j11));
                        zzI(obj, i13, i11);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzR(obj2, i13, i11)) {
                        zzhcz.zzv(obj, j11, zzhcz.zzh(obj2, j11));
                        zzI(obj, i13, i11);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i11);
                    break;
            }
        }
        zzhca.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:168:0x0625 A[Catch: all -> 0x00f7, TryCatch #4 {all -> 0x00f7, blocks: (B:55:0x00d5, B:166:0x0620, B:168:0x0625, B:169:0x062a), top: B:189:0x00d5 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0636 A[LOOP:2: B:172:0x0632->B:174:0x0636, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:176:0x064a  */
    /* JADX WARN: Code duplicated, block: B:182:0x0656 A[LOOP:3: B:180:0x0652->B:182:0x0656, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x066a  */
    /* JADX WARN: Code duplicated, block: B:209:0x0630 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzh(Object obj, zzhbq zzhbqVar, zzgzf zzgzfVar) throws Throwable {
        Object obj2;
        zzhcp zzhcpVar;
        int i11;
        zzhcp zzhcpVar2;
        Object obj3;
        zzgzg zzgzgVar;
        zzgzf zzgzfVar2;
        int i12;
        Object obj4;
        Object obj5 = obj;
        zzgzf zzgzfVar3 = zzgzfVar;
        zzgzfVar.getClass();
        zzD(obj);
        zzhcp zzhcpVar3 = this.zzn;
        zzgzg zzgzgVar2 = this.zzo;
        Object objZzy = null;
        zzgzk zzgzkVar = null;
        while (true) {
            try {
                int iZzc = zzhbqVar.zzc();
                int iZzq = zzq(iZzc);
                if (iZzq >= 0) {
                    zzhcpVar = zzhcpVar3;
                    obj5 = obj5;
                    try {
                        int iZzu = zzu(iZzq);
                        try {
                            switch (zzt(iZzu)) {
                                case 0:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzr(obj5, iZzu & 1048575, zzhbqVar.zza());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 1:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzs(obj5, iZzu & 1048575, zzhbqVar.zzb());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 2:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzl());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 3:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzo());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 4:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzg());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 5:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzk());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 6:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzf());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 7:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzp(obj5, iZzu & 1048575, zzhbqVar.zzN());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 8:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzG(obj5, iZzu, zzhbqVar);
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 9:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbe zzhbeVar = (zzhbe) zzA(obj5, iZzq);
                                    zzhbqVar.zzu(zzhbeVar, zzx(iZzq), zzgzfVar2);
                                    zzJ(obj5, iZzq, zzhbeVar);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 10:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzv(obj5, iZzu & 1048575, zzhbqVar.zzp());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 11:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzj());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 12:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    int iZze = zzhbqVar.zze();
                                    zzgzy zzgzyVarZzw = zzw(iZzq);
                                    if (zzgzyVarZzw != null && !zzgzyVarZzw.zza(iZze)) {
                                        objZzy = zzhca.zzp(obj5, iZzc, iZze, obj4, zzhcpVar);
                                        zzgzgVar2 = zzgzgVar;
                                        zzgzfVar3 = zzgzfVar2;
                                        zzhcpVar3 = zzhcpVar;
                                    }
                                    zzhcz.zzt(obj5, iZzu & 1048575, iZze);
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 13:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzh());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 14:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzm());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 15:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzi());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 16:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzn());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 17:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbe zzhbeVar2 = (zzhbe) zzA(obj5, iZzq);
                                    zzhbqVar.zzt(zzhbeVar2, zzx(iZzq), zzgzfVar2);
                                    zzJ(obj5, iZzq, zzhbeVar2);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 18:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzx(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 19:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzB(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 20:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzE(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 21:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzM(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 22:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzD(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 23:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzA(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 24:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzz(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 25:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzv(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 26:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    if (zzM(iZzu)) {
                                        ((zzgyu) zzhbqVar).zzK(this.zzm.zza(obj5, iZzu & 1048575), true);
                                    } else {
                                        ((zzgyu) zzhbqVar).zzK(this.zzm.zza(obj5, iZzu & 1048575), false);
                                    }
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 27:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzF(this.zzm.zza(obj5, iZzu & 1048575), zzx(iZzq), zzgzfVar2);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 28:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzw(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzL(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 30:
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    List listZza = this.zzm.zza(obj5, iZzu & 1048575);
                                    zzhbqVar.zzy(listZza);
                                    objZzy = zzhca.zzo(obj, iZzc, listZza, zzw(iZzq), objZzy, zzhcpVar);
                                    zzgzgVar2 = zzgzgVar;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case VungleException.WEB_CRASH /* 31 */:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzG(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 32:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzH(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 33:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzI(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 34:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzJ(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 35:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzx(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 36:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzB(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 37:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzE(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 38:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzM(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 39:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzD(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 40:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzA(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 41:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzz(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzv(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzL(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                    List listZza2 = this.zzm.zza(obj5, iZzu & 1048575);
                                    zzhbqVar.zzy(listZza2);
                                    obj2 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    try {
                                        objZzy = zzhca.zzo(obj, iZzc, listZza2, zzw(iZzq), obj2, zzhcpVar);
                                    } catch (zzhaf unused) {
                                        objZzy = obj2;
                                        zzhcpVar.zzq(zzhbqVar);
                                        if (objZzy == null) {
                                            objZzy = zzhcpVar.zzc(obj5);
                                        }
                                        if (!zzhcpVar.zzp(objZzy, zzhbqVar)) {
                                            for (i12 = this.zzk; i12 < this.zzl; i12++) {
                                                objZzy = zzy(obj, this.zzj[i12], objZzy, zzhcpVar, obj);
                                            }
                                            if (objZzy != null) {
                                                zzhcpVar.zzn(obj5, objZzy);
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    zzgzgVar2 = zzgzgVar;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                    zzhbqVar.zzG(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                    zzhbqVar.zzH(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                    zzhbqVar.zzI(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 48:
                                    zzhbqVar.zzJ(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 49:
                                    zzhbqVar.zzC(this.zzm.zza(obj5, iZzu & 1048575), zzx(iZzq), zzgzfVar3);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 50:
                                    Object objZzz = zzz(iZzq);
                                    long jZzu = zzu(iZzq) & 1048575;
                                    Object objZzh = zzhcz.zzh(obj5, jZzu);
                                    if (objZzh == null) {
                                        objZzh = zzhay.zza().zzb();
                                        zzhcz.zzv(obj5, jZzu, objZzh);
                                    } else if (zzhaz.zza(objZzh)) {
                                        Object objZzb = zzhay.zza().zzb();
                                        zzhaz.zzb(objZzb, objZzh);
                                        zzhcz.zzv(obj5, jZzu, objZzb);
                                        objZzh = objZzb;
                                    }
                                    throw null;
                                case 51:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Double.valueOf(zzhbqVar.zza()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 52:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Float.valueOf(zzhbqVar.zzb()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 53:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzl()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 54:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzo()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 55:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzg()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 56:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzk()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzf()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 58:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Boolean.valueOf(zzhbqVar.zzN()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 59:
                                    zzG(obj5, iZzu, zzhbqVar);
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 60:
                                    zzhbe zzhbeVar3 = (zzhbe) zzB(obj5, iZzc, iZzq);
                                    zzhbqVar.zzu(zzhbeVar3, zzx(iZzq), zzgzfVar3);
                                    zzK(obj5, iZzc, iZzq, zzhbeVar3);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 61:
                                    zzhcz.zzv(obj5, iZzu & 1048575, zzhbqVar.zzp());
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 62:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzj()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 63:
                                    int iZze2 = zzhbqVar.zze();
                                    zzgzy zzgzyVarZzw2 = zzw(iZzq);
                                    if (zzgzyVarZzw2 != null && !zzgzyVarZzw2.zza(iZze2)) {
                                        objZzy = zzhca.zzp(obj5, iZzc, iZze2, objZzy, zzhcpVar);
                                        obj5 = obj5;
                                        zzhcpVar3 = zzhcpVar;
                                    }
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(iZze2));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 64:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzh()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzm()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 66:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzi()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzn()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 68:
                                    zzhbe zzhbeVar4 = (zzhbe) zzB(obj5, iZzc, iZzq);
                                    zzhbqVar.zzt(zzhbeVar4, zzx(iZzq), zzgzfVar3);
                                    zzK(obj5, iZzc, iZzq, zzhbeVar4);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                default:
                                    if (objZzy == null) {
                                        objZzy = zzhcpVar.zzc(obj5);
                                    }
                                    try {
                                        try {
                                            if (!zzhcpVar.zzp(objZzy, zzhbqVar)) {
                                                for (int i13 = this.zzk; i13 < this.zzl; i13++) {
                                                    objZzy = zzy(obj, this.zzj[i13], objZzy, zzhcpVar, obj);
                                                }
                                            }
                                            obj5 = obj5;
                                        } catch (zzhaf unused2) {
                                            zzgzgVar = zzgzgVar2;
                                            zzgzfVar2 = zzgzfVar3;
                                            zzhcpVar.zzq(zzhbqVar);
                                            if (objZzy == null) {
                                                objZzy = zzhcpVar.zzc(obj5);
                                            }
                                            if (!zzhcpVar.zzp(objZzy, zzhbqVar)) {
                                                while (i12 < this.zzl) {
                                                    objZzy = zzy(obj, this.zzj[i12], objZzy, zzhcpVar, obj);
                                                }
                                            }
                                            zzgzgVar2 = zzgzgVar;
                                            zzgzfVar3 = zzgzfVar2;
                                            zzhcpVar3 = zzhcpVar;
                                        }
                                        zzhcpVar3 = zzhcpVar;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    break;
                            }
                        } catch (zzhaf unused3) {
                            obj2 = objZzy;
                            zzgzgVar = zzgzgVar2;
                            zzgzfVar2 = zzgzfVar3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj2 = objZzy;
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i14 = this.zzk; i14 < this.zzl; i14++) {
                        objZzy = zzy(obj, this.zzj[i14], objZzy, zzhcpVar3, obj);
                    }
                    zzhcpVar = zzhcpVar3;
                    obj5 = obj5;
                } else {
                    try {
                        Object objZzc = !this.zzh ? null : zzgzgVar2.zzc(zzgzfVar3, this.zzg, iZzc);
                        if (objZzc != null) {
                            zzgzk zzgzkVarZzb = zzgzkVar == null ? zzgzgVar2.zzb(obj5) : zzgzkVar;
                            zzhcpVar2 = zzhcpVar3;
                            obj3 = obj5;
                            try {
                                objZzy = zzgzgVar2.zzd(obj, zzhbqVar, objZzc, zzgzfVar, zzgzkVarZzb, objZzy, zzhcpVar2);
                                zzgzkVar = zzgzkVarZzb;
                            } catch (Throwable th5) {
                                th = th5;
                                obj5 = obj3;
                                zzhcpVar = zzhcpVar2;
                                obj2 = objZzy;
                                objZzy = obj2;
                                for (i11 = this.zzk; i11 < this.zzl; i11++) {
                                    objZzy = zzy(obj, this.zzj[i11], objZzy, zzhcpVar, obj);
                                }
                                if (objZzy != null) {
                                    zzhcpVar.zzn(obj5, objZzy);
                                }
                                throw th;
                            }
                        } else {
                            zzhcpVar2 = zzhcpVar3;
                            obj3 = obj5;
                            zzhcpVar2.zzq(zzhbqVar);
                            if (objZzy == null) {
                                objZzy = zzhcpVar2.zzc(obj3);
                            }
                            try {
                                if (!zzhcpVar2.zzp(objZzy, zzhbqVar)) {
                                    int i15 = this.zzk;
                                    while (i15 < this.zzl) {
                                        zzhcp zzhcpVar4 = zzhcpVar2;
                                        objZzy = zzy(obj, this.zzj[i15], objZzy, zzhcpVar4, obj);
                                        i15++;
                                        obj3 = obj3;
                                        zzhcpVar2 = zzhcpVar4;
                                    }
                                    obj5 = obj3;
                                    zzhcpVar = zzhcpVar2;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                obj5 = obj3;
                                zzhcpVar = zzhcpVar2;
                            }
                        }
                        obj5 = obj3;
                        zzhcpVar3 = zzhcpVar2;
                    } catch (Throwable th7) {
                        th = th7;
                        zzhcpVar = zzhcpVar3;
                        obj5 = obj5;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                obj2 = objZzy;
                zzhcpVar = zzhcpVar3;
                obj5 = obj5;
            }
            objZzy = obj2;
            while (i11 < this.zzl) {
                objZzy = zzy(obj, this.zzj[i11], objZzy, zzhcpVar, obj);
            }
            if (objZzy != null) {
                zzhcpVar.zzn(obj5, objZzy);
            }
            throw th;
        }
        if (objZzy != null) {
            zzhcpVar.zzn(obj5, objZzy);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzi(Object obj, byte[] bArr, int i11, int i12, zzgxx zzgxxVar) throws IOException {
        zzc(obj, bArr, i11, i12, 0, zzgxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzs;
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzu = zzu(i11);
            long j11 = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i11) || Double.doubleToLongBits(zzhcz.zzb(obj, j11)) != Double.doubleToLongBits(zzhcz.zzb(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i11) || Float.floatToIntBits(zzhcz.zzc(obj, j11)) != Float.floatToIntBits(zzhcz.zzc(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzf(obj, j11) != zzhcz.zzf(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzf(obj, j11) != zzhcz.zzf(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzd(obj, j11) != zzhcz.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzf(obj, j11) != zzhcz.zzf(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzd(obj, j11) != zzhcz.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzz(obj, j11) != zzhcz.zzz(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i11) || !zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i11) || !zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i11) || !zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzd(obj, j11) != zzhcz.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzd(obj, j11) != zzhcz.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzd(obj, j11) != zzhcz.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzf(obj, j11) != zzhcz.zzf(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzd(obj, j11) != zzhcz.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i11) || zzhcz.zzf(obj, j11) != zzhcz.zzf(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i11) || !zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11))) {
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
                    zZzs = zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11));
                    break;
                case 50:
                    zZzs = zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11));
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
                    long jZzr = zzr(i11) & 1048575;
                    if (zzhcz.zzd(obj, jZzr) != zzhcz.zzd(obj2, jZzr) || !zzhca.zzs(zzhcz.zzh(obj, j11), zzhcz.zzh(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzs) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00af  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c5 A[LOOP:1: B:45:0x00b4->B:50:0x00c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzk(Object obj) {
        int i11;
        int i12;
        List list;
        zzhby zzhbyVarZzx;
        int i13;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i17 = iArr[i16];
            int i18 = iArr2[i17];
            int iZzu = zzu(i17);
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
            if ((268435456 & iZzu) != 0 && !zzO(obj, i17, i11, i12, i22)) {
                return false;
            }
            int iZzt = zzt(iZzu);
            if (iZzt == 9 || iZzt == 17) {
                if (zzO(obj, i17, i11, i12, i22) && !zzP(obj, iZzu, zzx(i17))) {
                    return false;
                }
            } else if (iZzt == 27) {
                list = (List) zzhcz.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhbyVarZzx = zzx(i17);
                    for (i13 = 0; i13 < list.size(); i13++) {
                        if (!zzhbyVarZzx.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (iZzt == 60 || iZzt == 68) {
                if (zzR(obj, i18, i17) && !zzP(obj, iZzu, zzx(i17))) {
                    return false;
                }
            } else if (iZzt == 49) {
                list = (List) zzhcz.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    zzhbyVarZzx = zzx(i17);
                    while (i13 < list.size()) {
                        if (!zzhbyVarZzx.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzt == 50 && !((zzhay) zzhcz.zzh(obj, iZzu & 1048575)).isEmpty()) {
                throw null;
            }
            i16++;
            i14 = i11;
            i15 = i12;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzm(Object obj, zzgzb zzgzbVar) throws IOException {
        int i11;
        int i12;
        int i13;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        while (i17 < iArr.length) {
            int iZzu = zzu(i17);
            int[] iArr2 = this.zzc;
            int iZzt = zzt(iZzu);
            int i18 = iArr2[i17];
            if (iZzt <= 17) {
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
            long j11 = iZzu & i14;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzf(i18, zzhcz.zzb(obj, j11));
                    }
                    break;
                case 1:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzo(i18, zzhcz.zzc(obj, j11));
                    }
                    break;
                case 2:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzt(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 3:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzJ(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 4:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzr(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 5:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzm(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 6:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzk(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 7:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzb(i18, zzhcz.zzz(obj, j11));
                    }
                    break;
                case 8:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzT(i18, unsafe.getObject(obj, j11), zzgzbVar);
                    }
                    break;
                case 9:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzv(i18, unsafe.getObject(obj, j11), zzx(i17));
                    }
                    break;
                case 10:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzd(i18, (zzgyl) unsafe.getObject(obj, j11));
                    }
                    break;
                case 11:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzH(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 12:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzi(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 13:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzw(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 14:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzy(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 15:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzA(i18, unsafe.getInt(obj, j11));
                    }
                    break;
                case 16:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzC(i18, unsafe.getLong(obj, j11));
                    }
                    break;
                case 17:
                    if (zzO(obj, i17, i11, i12, i13)) {
                        zzgzbVar.zzq(i18, unsafe.getObject(obj, j11), zzx(i17));
                    }
                    break;
                case 18:
                    zzhca.zzu(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 19:
                    zzhca.zzy(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 20:
                    zzhca.zzA(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 21:
                    zzhca.zzG(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 22:
                    zzhca.zzz(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 23:
                    zzhca.zzx(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 24:
                    zzhca.zzw(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 25:
                    zzhca.zzt(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 26:
                    int i22 = this.zzc[i17];
                    List list = (List) unsafe.getObject(obj, j11);
                    int i23 = zzhca.zza;
                    if (list != null && !list.isEmpty()) {
                        zzgzbVar.zzG(i22, list);
                    }
                    break;
                case 27:
                    int i24 = this.zzc[i17];
                    List list2 = (List) unsafe.getObject(obj, j11);
                    zzhby zzhbyVarZzx = zzx(i17);
                    int i25 = zzhca.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i26 = 0; i26 < list2.size(); i26++) {
                            zzgzbVar.zzv(i24, list2.get(i26), zzhbyVarZzx);
                        }
                    }
                    break;
                case 28:
                    int i27 = this.zzc[i17];
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i28 = zzhca.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzgzbVar.zze(i27, list3);
                    }
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    zzhca.zzF(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 30:
                    zzhca.zzv(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    zzhca.zzB(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 32:
                    zzhca.zzC(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 33:
                    zzhca.zzD(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 34:
                    zzhca.zzE(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, false);
                    break;
                case 35:
                    zzhca.zzu(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 36:
                    zzhca.zzy(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 37:
                    zzhca.zzA(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 38:
                    zzhca.zzG(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 39:
                    zzhca.zzz(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 40:
                    zzhca.zzx(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 41:
                    zzhca.zzw(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzhca.zzt(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzhca.zzF(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzhca.zzv(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzhca.zzB(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzhca.zzC(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzhca.zzD(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 48:
                    zzhca.zzE(this.zzc[i17], (List) unsafe.getObject(obj, j11), zzgzbVar, true);
                    break;
                case 49:
                    int i29 = this.zzc[i17];
                    List list4 = (List) unsafe.getObject(obj, j11);
                    zzhby zzhbyVarZzx2 = zzx(i17);
                    int i31 = zzhca.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i32 = 0; i32 < list4.size(); i32++) {
                            zzgzbVar.zzq(i29, list4.get(i32), zzhbyVarZzx2);
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
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzf(i18, zzn(obj, j11));
                    }
                    break;
                case 52:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzo(i18, zzo(obj, j11));
                    }
                    break;
                case 53:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzt(i18, zzv(obj, j11));
                    }
                    break;
                case 54:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzJ(i18, zzv(obj, j11));
                    }
                    break;
                case 55:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzr(i18, zzp(obj, j11));
                    }
                    break;
                case 56:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzm(i18, zzv(obj, j11));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzk(i18, zzp(obj, j11));
                    }
                    break;
                case 58:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzb(i18, zzS(obj, j11));
                    }
                    break;
                case 59:
                    if (zzR(obj, i18, i17)) {
                        zzT(i18, unsafe.getObject(obj, j11), zzgzbVar);
                    }
                    break;
                case 60:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzv(i18, unsafe.getObject(obj, j11), zzx(i17));
                    }
                    break;
                case 61:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzd(i18, (zzgyl) unsafe.getObject(obj, j11));
                    }
                    break;
                case 62:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzH(i18, zzp(obj, j11));
                    }
                    break;
                case 63:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzi(i18, zzp(obj, j11));
                    }
                    break;
                case 64:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzw(i18, zzp(obj, j11));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzy(i18, zzv(obj, j11));
                    }
                    break;
                case 66:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzA(i18, zzp(obj, j11));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzC(i18, zzv(obj, j11));
                    }
                    break;
                case 68:
                    if (zzR(obj, i18, i17)) {
                        zzgzbVar.zzq(i18, unsafe.getObject(obj, j11), zzx(i17));
                    }
                    break;
            }
            i17 += 3;
            i15 = i11;
            i16 = i12;
            i14 = 1048575;
        }
        zzhcp zzhcpVar = this.zzn;
        zzhcpVar.zzr(zzhcpVar.zzd(obj), zzgzbVar);
    }
}
