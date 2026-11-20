package com.google.android.libraries.places.internal;

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
final class zzavi<T> implements zzavt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzawx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzavf zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaut zzm;
    private final zzawn zzn;
    private final zzatg zzo;
    private final zzavl zzp;
    private final zzava zzq;

    private zzavi(int[] iArr, Object[] objArr, int i11, int i12, zzavf zzavfVar, int i13, boolean z11, int[] iArr2, int i14, int i15, zzavl zzavlVar, zzaut zzautVar, zzawn zzawnVar, zzatg zzatgVar, zzava zzavaVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = zzavfVar instanceof zzatu;
        boolean z12 = false;
        if (zzatgVar != null && zzatgVar.zzi(zzavfVar)) {
            z12 = true;
        }
        this.zzh = z12;
        this.zzj = iArr2;
        this.zzk = i14;
        this.zzl = i15;
        this.zzp = zzavlVar;
        this.zzm = zzautVar;
        this.zzn = zzawnVar;
        this.zzo = zzatgVar;
        this.zzg = zzavfVar;
        this.zzq = zzavaVar;
    }

    private final void zzA(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzM(obj2, i12, i11)) {
            int iZzp = zzp(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = iZzp;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzavt zzavtVarZzs = zzs(i11);
            if (!zzM(obj, i12, i11)) {
                if (zzL(object)) {
                    Object objZzc = zzavtVarZzs.zzc();
                    zzavtVarZzs.zze(objZzc, object);
                    unsafe.putObject(obj, j11, objZzc);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzD(obj, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object objZzc2 = zzavtVarZzs.zzc();
                zzavtVarZzs.zze(objZzc2, object2);
                unsafe.putObject(obj, j11, objZzc2);
                object2 = objZzc2;
            }
            zzavtVarZzs.zze(object2, object);
        }
    }

    private final void zzB(Object obj, int i11, zzavs zzavsVar) throws IOException {
        long j11 = i11 & 1048575;
        if (zzH(i11)) {
            zzawx.zzs(obj, j11, zzavsVar.zzs());
        } else if (this.zzi) {
            zzawx.zzs(obj, j11, zzavsVar.zzr());
        } else {
            zzawx.zzs(obj, j11, zzavsVar.zzp());
        }
    }

    private final void zzC(Object obj, int i11) {
        int iZzn = zzn(i11);
        long j11 = 1048575 & iZzn;
        if (j11 == 1048575) {
            return;
        }
        zzawx.zzq(obj, j11, (1 << (iZzn >>> 20)) | zzawx.zzc(obj, j11));
    }

    private final void zzD(Object obj, int i11, int i12) {
        zzawx.zzq(obj, zzn(i12) & 1048575, i11);
    }

    private final void zzE(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, zzp(i11) & 1048575, obj2);
        zzC(obj, i11);
    }

    private final void zzF(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, zzp(i12) & 1048575, obj2);
        zzD(obj, i11, i12);
    }

    private final boolean zzG(Object obj, Object obj2, int i11) {
        return zzI(obj, i11) == zzI(obj2, i11);
    }

    private static boolean zzH(int i11) {
        return (i11 & ASTNode.DISCARD) != 0;
    }

    private final boolean zzI(Object obj, int i11) {
        int iZzn = zzn(i11);
        long j11 = iZzn & 1048575;
        if (j11 != 1048575) {
            return (zzawx.zzc(obj, j11) & (1 << (iZzn >>> 20))) != 0;
        }
        int iZzp = zzp(i11);
        long j12 = iZzp & 1048575;
        switch (zzo(iZzp)) {
            case 0:
                return Double.doubleToRawLongBits(zzawx.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzawx.zzb(obj, j12)) != 0;
            case 2:
                return zzawx.zzd(obj, j12) != 0;
            case 3:
                return zzawx.zzd(obj, j12) != 0;
            case 4:
                return zzawx.zzc(obj, j12) != 0;
            case 5:
                return zzawx.zzd(obj, j12) != 0;
            case 6:
                return zzawx.zzc(obj, j12) != 0;
            case 7:
                return zzawx.zzw(obj, j12);
            case 8:
                Object objZzf = zzawx.zzf(obj, j12);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzask) {
                    return !zzask.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzawx.zzf(obj, j12) != null;
            case 10:
                return !zzask.zzb.equals(zzawx.zzf(obj, j12));
            case 11:
                return zzawx.zzc(obj, j12) != 0;
            case 12:
                return zzawx.zzc(obj, j12) != 0;
            case 13:
                return zzawx.zzc(obj, j12) != 0;
            case 14:
                return zzawx.zzd(obj, j12) != 0;
            case 15:
                return zzawx.zzc(obj, j12) != 0;
            case 16:
                return zzawx.zzd(obj, j12) != 0;
            case 17:
                return zzawx.zzf(obj, j12) != null;
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

    private static boolean zzK(Object obj, int i11, zzavt zzavtVar) {
        return zzavtVar.zzh(zzawx.zzf(obj, i11 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzatu) {
            return ((zzatu) obj).zzaH();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i11, int i12) {
        return zzawx.zzc(obj, (long) (zzn(i12) & 1048575)) == i11;
    }

    private static boolean zzN(Object obj, long j11) {
        return ((Boolean) zzawx.zzf(obj, j11)).booleanValue();
    }

    private static final void zzO(int i11, Object obj, zzasy zzasyVar) throws IOException {
        if (obj instanceof String) {
            zzasyVar.zzG(i11, (String) obj);
        } else {
            zzasyVar.zzd(i11, (zzask) obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0280  */
    /* JADX WARN: Code duplicated, block: B:131:0x0283  */
    public static zzavi zzi(Class cls, zzavc zzavcVar, zzavl zzavlVar, zzaut zzautVar, zzawn zzawnVar, zzatg zzatgVar, zzava zzavaVar) {
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
        Field fieldZzx;
        char cCharAt9;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        Object obj;
        Field fieldZzx2;
        int i37;
        Object obj2;
        Field fieldZzx3;
        int i38;
        char cCharAt10;
        int i39;
        char cCharAt11;
        int i40;
        char cCharAt12;
        int i41;
        char cCharAt13;
        if (!(zzavcVar instanceof zzavr)) {
            throw null;
        }
        zzavr zzavrVar = (zzavr) zzavcVar;
        String strZzd = zzavrVar.zzd();
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
        Object[] objArrZze = zzavrVar.zze();
        Class<?> cls2 = zzavrVar.zza().getClass();
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
                iArr[i75] = i74;
                i75++;
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
                    int i93 = i74 / 3;
                    objArr[i93 + i93 + 1] = objArrZze[i12];
                } else {
                    if (i92 == 12) {
                        if (zzavrVar.zzc() == 1 || i85 != 0) {
                            i35 = i12 + 1;
                            int i94 = i74 / 3;
                            objArr[i94 + i94 + 1] = objArrZze[i12];
                        } else {
                            i85 = 0;
                        }
                    }
                    i36 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i36];
                    if (obj instanceof Field) {
                        fieldZzx2 = (Field) obj;
                    } else {
                        fieldZzx2 = zzx(cls2, (String) obj);
                        objArrZze[i36] = fieldZzx2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzx2);
                    i37 = i36 + 1;
                    obj2 = objArrZze[i37];
                    if (obj2 instanceof Field) {
                        fieldZzx3 = (Field) obj2;
                    } else {
                        fieldZzx3 = zzx(cls2, (String) obj2);
                        objArrZze[i37] = fieldZzx3;
                    }
                    zzavrVar = zzavrVar;
                    strZzd = strZzd;
                    i31 = i12;
                    i28 = i91;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx3);
                    i29 = 0;
                }
                i12 = i35;
                i36 = iCharAt12 + iCharAt12;
                obj = objArrZze[i36];
                if (obj instanceof Field) {
                    fieldZzx2 = (Field) obj;
                } else {
                    fieldZzx2 = zzx(cls2, (String) obj);
                    objArrZze[i36] = fieldZzx2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzx2);
                i37 = i36 + 1;
                obj2 = objArrZze[i37];
                if (obj2 instanceof Field) {
                    fieldZzx3 = (Field) obj2;
                } else {
                    fieldZzx3 = zzx(cls2, (String) obj2);
                    objArrZze[i37] = fieldZzx3;
                }
                zzavrVar = zzavrVar;
                strZzd = strZzd;
                i31 = i12;
                i28 = i91;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx3);
                i29 = 0;
            } else {
                int i95 = i12 + 1;
                Field fieldZzx4 = zzx(cls2, (String) objArrZze[i12]);
                if (i84 == 9 || i84 == 17) {
                    zzavrVar = zzavrVar;
                    int i96 = i74 / 3;
                    objArr[i96 + i96 + 1] = fieldZzx4.getType();
                } else {
                    if (i84 == 27) {
                        i32 = 1;
                        i33 = i12 + 2;
                    } else if (i84 == 49) {
                        i33 = i12 + 2;
                        i32 = 1;
                    } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                        zzavrVar = zzavrVar;
                        if (zzavrVar.zzc() == 1 || i85 != 0) {
                            i33 = i12 + 2;
                            int i97 = i74 / 3;
                            objArr[i97 + i97 + 1] = objArrZze[i95];
                            i95 = i33;
                        } else {
                            i85 = 0;
                        }
                    } else {
                        if (i84 == 50) {
                            int i98 = i12 + 2;
                            int i99 = i72 + 1;
                            iArr[i72] = i74;
                            int i100 = i74 / 3;
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
                        zzavrVar = zzavrVar;
                    }
                    int i102 = i74 / 3;
                    objArr[i102 + i102 + i32] = objArrZze[i95];
                    i95 = i33;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzx4);
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
                        fieldZzx = (Field) obj3;
                    } else {
                        fieldZzx = zzx(cls2, (String) obj3);
                        objArrZze[i106] = fieldZzx;
                    }
                    i29 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx);
                }
                if (i84 >= 18 && i84 <= 49) {
                    iArr[i73] = iObjectFieldOffset3;
                    i73++;
                }
                i31 = i95;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i107 = i74 + 1;
            iArr2[i74] = iCharAt10;
            int i108 = i74 + 2;
            iArr2[i107] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? ASTNode.DEOP : 0) | ((iCharAt11 & 512) != 0 ? ASTNode.DISCARD : 0) | (i85 != 0 ? Integer.MIN_VALUE : 0) | (i84 << 20);
            i74 += 3;
            iArr2[i108] = (i29 << 20) | iObjectFieldOffset;
            i12 = i31;
            i43 = i28;
            length = i86;
            zzavrVar = zzavrVar;
            strZzd = strZzd;
            i16 = i16;
            i13 = i13;
            c11 = 55296;
        }
        zzavr zzavrVar2 = zzavrVar;
        return new zzavi(iArr2, objArr, i13, i16, zzavrVar2.zza(), zzavrVar2.zzc(), false, iArr, i14, i70, zzavlVar, zzautVar, zzawnVar, zzatgVar, zzavaVar);
    }

    private static double zzk(Object obj, long j11) {
        return ((Double) zzawx.zzf(obj, j11)).doubleValue();
    }

    private static float zzl(Object obj, long j11) {
        return ((Float) zzawx.zzf(obj, j11)).floatValue();
    }

    private static int zzm(Object obj, long j11) {
        return ((Integer) zzawx.zzf(obj, j11)).intValue();
    }

    private final int zzn(int i11) {
        return this.zzc[i11 + 2];
    }

    private static int zzo(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzp(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzq(Object obj, long j11) {
        return ((Long) zzawx.zzf(obj, j11)).longValue();
    }

    private final zzaty zzr(int i11) {
        int i12 = i11 / 3;
        return (zzaty) this.zzd[i12 + i12 + 1];
    }

    private final zzavt zzs(int i11) {
        Object[] objArr = this.zzd;
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzavt zzavtVar = (zzavt) objArr[i13];
        if (zzavtVar != null) {
            return zzavtVar;
        }
        zzavt zzavtVarZzb = zzavp.zza().zzb((Class) objArr[i13 + 1]);
        this.zzd[i13] = zzavtVarZzb;
        return zzavtVarZzb;
    }

    private final Object zzt(Object obj, int i11, Object obj2, zzawn zzawnVar, Object obj3) {
        int i12 = this.zzc[i11];
        Object objZzf = zzawx.zzf(obj, zzp(i11) & 1048575);
        if (objZzf == null || zzr(i11) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzu(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzv(Object obj, int i11) {
        zzavt zzavtVarZzs = zzs(i11);
        int iZzp = zzp(i11) & 1048575;
        if (!zzI(obj, i11)) {
            return zzavtVarZzs.zzc();
        }
        Object object = zzb.getObject(obj, iZzp);
        if (zzL(object)) {
            return object;
        }
        Object objZzc = zzavtVarZzs.zzc();
        if (object != null) {
            zzavtVarZzs.zze(objZzc, object);
        }
        return objZzc;
    }

    private final Object zzw(Object obj, int i11, int i12) {
        zzavt zzavtVarZzs = zzs(i12);
        if (!zzM(obj, i11, i12)) {
            return zzavtVarZzs.zzc();
        }
        Object object = zzb.getObject(obj, zzp(i12) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZzc = zzavtVarZzs.zzc();
        if (object != null) {
            zzavtVarZzs.zze(objZzc, object);
        }
        return objZzc;
    }

    private static Field zzx(Class cls, String str) {
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

    private static void zzy(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzz(Object obj, Object obj2, int i11) {
        if (zzI(obj2, i11)) {
            int iZzp = zzp(i11) & 1048575;
            Unsafe unsafe = zzb;
            long j11 = iZzp;
            Object object = unsafe.getObject(obj2, j11);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzavt zzavtVarZzs = zzs(i11);
            if (!zzI(obj, i11)) {
                if (zzL(object)) {
                    Object objZzc = zzavtVarZzs.zzc();
                    zzavtVarZzs.zze(objZzc, object);
                    unsafe.putObject(obj, j11, objZzc);
                } else {
                    unsafe.putObject(obj, j11, object);
                }
                zzC(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j11);
            if (!zzL(object2)) {
                Object objZzc2 = zzavtVarZzs.zzc();
                zzavtVarZzs.zze(objZzc2, object2);
                unsafe.putObject(obj, j11, objZzc2);
                object2 = objZzc2;
            }
            zzavtVarZzs.zze(object2, object);
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0390  */
    /* JADX WARN: Code duplicated, block: B:180:0x0489  */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zza(Object obj) {
        int i11;
        int i12;
        int i13;
        int iZzB;
        int iZzB2;
        int iZzB3;
        int iZzC;
        int iZzB4;
        int iZzB5;
        int iZzd;
        int iZzB6;
        int iZzh;
        int iZzg;
        int size;
        int iZzB7;
        int iZzB8;
        int iZzB9;
        int iZze;
        int iZzB10;
        int iZzB11;
        int iZzy;
        Unsafe unsafe = zzb;
        boolean z11 = false;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.zzc.length) {
            int iZzp = zzp(i17);
            int iZzo = zzo(iZzp);
            int[] iArr = this.zzc;
            int i19 = iArr[i17];
            int i21 = iArr[i17 + 2];
            int i22 = i21 & i14;
            if (iZzo <= 17) {
                if (i22 != i15) {
                    i16 = i22 == i14 ? 0 : unsafe.getInt(obj, i22);
                    i15 = i22;
                }
                i11 = i15;
                i12 = i16;
                i13 = 1 << (i21 >>> 20);
            } else {
                i11 = i15;
                i12 = i16;
                i13 = 0;
            }
            int i23 = iZzp & i14;
            if (iZzo >= zzatl.zzJ.zza()) {
                zzatl.zzW.zza();
            }
            long j11 = i23;
            switch (iZzo) {
                case 0:
                    if (zzJ(obj, i17, i11, i12, i13)) {
                        iZzB = zzasx.zzB(i19 << 3);
                        iZzh = iZzB + 8;
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
                        iZzB2 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB2 + 4;
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
                        long j12 = unsafe.getLong(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(j12);
                        iZzh = iZzB3 + iZzC;
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
                        long j13 = unsafe.getLong(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(j13);
                        iZzh = iZzB3 + iZzC;
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
                        long j14 = unsafe.getInt(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(j14);
                        iZzh = iZzB3 + iZzC;
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
                        iZzB = zzasx.zzB(i19 << 3);
                        iZzh = iZzB + 8;
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
                        iZzB2 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB2 + 4;
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
                        iZzB4 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB4 + 1;
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
                        if (object instanceof zzask) {
                            iZzB5 = zzasx.zzB(i24);
                            iZzd = ((zzask) object).zzd();
                            iZzB6 = zzasx.zzB(iZzd);
                            iZzh = iZzB5 + iZzB6 + iZzd;
                            i18 += iZzh;
                        } else {
                            iZzB3 = zzasx.zzB(i24);
                            iZzC = zzasx.zzA((String) object);
                            iZzh = iZzB3 + iZzC;
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
                        iZzh = zzavv.zzh(i19, unsafe.getObject(obj, j11), zzs(i17));
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
                        zzask zzaskVar = (zzask) unsafe.getObject(obj, j11);
                        iZzB5 = zzasx.zzB(i19 << 3);
                        iZzd = zzaskVar.zzd();
                        iZzB6 = zzasx.zzB(iZzd);
                        iZzh = iZzB5 + iZzB6 + iZzd;
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
                        int i25 = unsafe.getInt(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzB(i25);
                        iZzh = iZzB3 + iZzC;
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
                        long j15 = unsafe.getInt(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(j15);
                        iZzh = iZzB3 + iZzC;
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
                        iZzB2 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB2 + 4;
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
                        iZzB = zzasx.zzB(i19 << 3);
                        iZzh = iZzB + 8;
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
                        int i26 = unsafe.getInt(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzB((i26 >> 31) ^ (i26 + i26));
                        iZzh = iZzB3 + iZzC;
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
                        long j16 = unsafe.getLong(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC((j16 >> 63) ^ (j16 + j16));
                        iZzh = iZzB3 + iZzC;
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
                        iZzh = zzasx.zzy(i19, (zzavf) unsafe.getObject(obj, j11), zzs(i17));
                        i18 += iZzh;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 18:
                    iZzh = zzavv.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 19:
                    iZzh = zzavv.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j11);
                    int i27 = zzavv.zza;
                    if (list.size() == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzavv.zzg(list) + (list.size() * zzasx.zzB(i19 << 3));
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
                    int i28 = zzavv.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzB3 = zzavv.zzl(list2);
                        iZzB7 = zzasx.zzB(i19 << 3);
                        iZzC = size * iZzB7;
                        iZzh = iZzB3 + iZzC;
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
                    int i29 = zzavv.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzB3 = zzavv.zzf(list3);
                        iZzB7 = zzasx.zzB(i19 << 3);
                        iZzC = size * iZzB7;
                        iZzh = iZzB3 + iZzC;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 23:
                    iZzh = zzavv.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 24:
                    iZzh = zzavv.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j11);
                    int i31 = zzavv.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = size2 * (zzasx.zzB(i19 << 3) + 1);
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
                    int i32 = zzavv.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzasx.zzB(i19 << 3) * size3;
                        if (list5 instanceof zzaun) {
                            zzaun zzaunVar = (zzaun) list5;
                            for (int i33 = 0; i33 < size3; i33++) {
                                Object objZzf = zzaunVar.zzf(i33);
                                if (objZzf instanceof zzask) {
                                    int iZzd2 = ((zzask) objZzf).zzd();
                                    iZzg += zzasx.zzB(iZzd2) + iZzd2;
                                } else {
                                    iZzg += zzasx.zzA((String) objZzf);
                                }
                            }
                        } else {
                            for (int i34 = 0; i34 < size3; i34++) {
                                Object obj2 = list5.get(i34);
                                if (obj2 instanceof zzask) {
                                    int iZzd3 = ((zzask) obj2).zzd();
                                    iZzg += zzasx.zzB(iZzd3) + iZzd3;
                                } else {
                                    iZzg += zzasx.zzA((String) obj2);
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
                    zzavt zzavtVarZzs = zzs(i17);
                    int i35 = zzavv.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzB8 = 0;
                    } else {
                        iZzB8 = zzasx.zzB(i19 << 3) * size4;
                        for (int i36 = 0; i36 < size4; i36++) {
                            Object obj3 = list6.get(i36);
                            if (obj3 instanceof zzaul) {
                                int iZza = ((zzaul) obj3).zza();
                                iZzB8 += zzasx.zzB(iZza) + iZza;
                            } else {
                                iZzB8 += zzasx.zzz((zzavf) obj3, zzavtVarZzs);
                            }
                        }
                    }
                    i18 += iZzB8;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j11);
                    int i37 = zzavv.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzB9 = 0;
                    } else {
                        iZzB9 = size5 * zzasx.zzB(i19 << 3);
                        for (int i38 = 0; i38 < list7.size(); i38++) {
                            int iZzd4 = ((zzask) list7.get(i38)).zzd();
                            iZzB9 += zzasx.zzB(iZzd4) + iZzd4;
                        }
                    }
                    i18 += iZzB9;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    List list8 = (List) unsafe.getObject(obj, j11);
                    int i39 = zzavv.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzB3 = zzavv.zzk(list8);
                        iZzB7 = zzasx.zzB(i19 << 3);
                        iZzC = size * iZzB7;
                        iZzh = iZzB3 + iZzC;
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
                    int i40 = zzavv.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzB3 = zzavv.zza(list9);
                        iZzB7 = zzasx.zzB(i19 << 3);
                        iZzC = size * iZzB7;
                        iZzh = iZzB3 + iZzC;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iZzh = zzavv.zzb(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 32:
                    iZzh = zzavv.zzd(i19, (List) unsafe.getObject(obj, j11), z11);
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j11);
                    int i41 = zzavv.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzB3 = zzavv.zzi(list10);
                        iZzB7 = zzasx.zzB(i19 << 3);
                        iZzC = size * iZzB7;
                        iZzh = iZzB3 + iZzC;
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
                    int i42 = zzavv.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzB3 = zzavv.zzj(list11);
                        iZzB7 = zzasx.zzB(i19 << 3);
                        iZzC = size * iZzB7;
                        iZzh = iZzB3 + iZzC;
                    }
                    i18 += iZzh;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 35:
                    iZze = zzavv.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 36:
                    iZze = zzavv.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 37:
                    iZze = zzavv.zzg((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 38:
                    iZze = zzavv.zzl((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 39:
                    iZze = zzavv.zzf((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 40:
                    iZze = zzavv.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 41:
                    iZze = zzavv.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list12 = (List) unsafe.getObject(obj, j11);
                    int i43 = zzavv.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZze = zzavv.zzk((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZze = zzavv.zza((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZze = zzavv.zzc((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZze = zzavv.zze((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZze = zzavv.zzi((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 48:
                    iZze = zzavv.zzj((List) unsafe.getObject(obj, j11));
                    if (iZze > 0) {
                        iZzB10 = zzasx.zzB(i19 << 3);
                        iZzB11 = zzasx.zzB(iZze);
                        iZzB9 = iZzB10 + iZzB11 + iZze;
                        i18 += iZzB9;
                    }
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j11);
                    zzavt zzavtVarZzs2 = zzs(i17);
                    int i44 = zzavv.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzy = 0;
                    } else {
                        iZzy = 0;
                        for (int i45 = 0; i45 < size6; i45++) {
                            iZzy += zzasx.zzy(i19, (zzavf) list13.get(i45), zzavtVarZzs2);
                        }
                    }
                    i18 += iZzy;
                    i17 += 3;
                    i15 = i11;
                    i16 = i12;
                    z11 = false;
                    i14 = 1048575;
                    break;
                case 50:
                    zzauz zzauzVar = (zzauz) unsafe.getObject(obj, j11);
                    if (zzauzVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzauzVar.entrySet().iterator();
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
                        iZzB = zzasx.zzB(i19 << 3);
                        iZzh = iZzB + 8;
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
                        iZzB2 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB2 + 4;
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
                        long jZzq = zzq(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(jZzq);
                        iZzh = iZzB3 + iZzC;
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
                        long jZzq2 = zzq(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(jZzq2);
                        iZzh = iZzB3 + iZzC;
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
                        long jZzm = zzm(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(jZzm);
                        iZzh = iZzB3 + iZzC;
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
                        iZzB = zzasx.zzB(i19 << 3);
                        iZzh = iZzB + 8;
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
                        iZzB2 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB2 + 4;
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
                        iZzB4 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB4 + 1;
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
                        int i46 = i19 << 3;
                        Object object2 = unsafe.getObject(obj, j11);
                        if (object2 instanceof zzask) {
                            iZzB5 = zzasx.zzB(i46);
                            iZzd = ((zzask) object2).zzd();
                            iZzB6 = zzasx.zzB(iZzd);
                            iZzh = iZzB5 + iZzB6 + iZzd;
                            i18 += iZzh;
                        } else {
                            iZzB3 = zzasx.zzB(i46);
                            iZzC = zzasx.zzA((String) object2);
                            iZzh = iZzB3 + iZzC;
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
                        iZzh = zzavv.zzh(i19, unsafe.getObject(obj, j11), zzs(i17));
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
                        zzask zzaskVar2 = (zzask) unsafe.getObject(obj, j11);
                        iZzB5 = zzasx.zzB(i19 << 3);
                        iZzd = zzaskVar2.zzd();
                        iZzB6 = zzasx.zzB(iZzd);
                        iZzh = iZzB5 + iZzB6 + iZzd;
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
                        int iZzm = zzm(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzB(iZzm);
                        iZzh = iZzB3 + iZzC;
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
                        long jZzm2 = zzm(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC(jZzm2);
                        iZzh = iZzB3 + iZzC;
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
                        iZzB2 = zzasx.zzB(i19 << 3);
                        iZzh = iZzB2 + 4;
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
                        iZzB = zzasx.zzB(i19 << 3);
                        iZzh = iZzB + 8;
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
                        int iZzm2 = zzm(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzB((iZzm2 >> 31) ^ (iZzm2 + iZzm2));
                        iZzh = iZzB3 + iZzC;
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
                        long jZzq3 = zzq(obj, j11);
                        iZzB3 = zzasx.zzB(i19 << 3);
                        iZzC = zzasx.zzC((jZzq3 >> 63) ^ (jZzq3 + jZzq3));
                        iZzh = iZzB3 + iZzC;
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
                        iZzh = zzasx.zzy(i19, (zzavf) unsafe.getObject(obj, j11), zzs(i17));
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
        zzawn zzawnVar = this.zzn;
        int iZza2 = i18 + zzawnVar.zza(zzawnVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        zzatk zzatkVarZzb = this.zzo.zzb(obj);
        int iZzb = 0;
        for (int i47 = 0; i47 < zzatkVarZzb.zza.zzb(); i47++) {
            Map.Entry entryZzg = zzatkVarZzb.zza.zzg(i47);
            iZzb += zzatk.zzb((zzatj) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzatkVarZzb.zza.zzc()) {
            iZzb += zzatk.zzb((zzatj) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZzb;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zzb(Object obj) {
        int i11;
        long jDoubleToLongBits;
        int i12;
        int iFloatToIntBits;
        int i13;
        int i14 = 0;
        for (int i15 = 0; i15 < this.zzc.length; i15 += 3) {
            int iZzp = zzp(i15);
            int[] iArr = this.zzc;
            int i16 = 1048575 & iZzp;
            int iZzo = zzo(iZzp);
            int i17 = iArr[i15];
            long j11 = i16;
            int iHashCode = 37;
            switch (iZzo) {
                case 0:
                    i11 = i14 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzawx.zza(obj, j11));
                    byte[] bArr = zzaud.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i12 = i14 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzawx.zzb(obj, j11));
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 2:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr2 = zzaud.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr3 = zzaud.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 5:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr4 = zzaud.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 7:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzaud.zza(zzawx.zzw(obj, j11));
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 8:
                    i12 = i14 * 53;
                    iFloatToIntBits = ((String) zzawx.zzf(obj, j11)).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 9:
                    i13 = i14 * 53;
                    Object objZzf = zzawx.zzf(obj, j11);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i14 = i13 + iHashCode;
                    break;
                case 10:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzf(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 11:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 12:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 13:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 14:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr5 = zzaud.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j11);
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 16:
                    i11 = i14 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j11);
                    byte[] bArr6 = zzaud.zzd;
                    i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i13 = i14 * 53;
                    Object objZzf2 = zzawx.zzf(obj, j11);
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
                    iFloatToIntBits = zzawx.zzf(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 50:
                    i12 = i14 * 53;
                    iFloatToIntBits = zzawx.zzf(obj, j11).hashCode();
                    i14 = i12 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzk(obj, j11));
                        byte[] bArr7 = zzaud.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzl(obj, j11));
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzq(obj, j11);
                        byte[] bArr8 = zzaud.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzq(obj, j11);
                        byte[] bArr9 = zzaud.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzm(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzq(obj, j11);
                        byte[] bArr10 = zzaud.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzm(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzaud.zza(zzN(obj, j11));
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = ((String) zzawx.zzf(obj, j11)).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzawx.zzf(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzawx.zzf(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzm(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzm(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzm(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzq(obj, j11);
                        byte[] bArr11 = zzaud.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzm(obj, j11);
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj, i17, i15)) {
                        i11 = i14 * 53;
                        jDoubleToLongBits = zzq(obj, j11);
                        byte[] bArr12 = zzaud.zzd;
                        i14 = i11 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (zzM(obj, i17, i15)) {
                        i12 = i14 * 53;
                        iFloatToIntBits = zzawx.zzf(obj, j11).hashCode();
                        i14 = i12 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i14 * 53) + this.zzn.zzd(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzo.zzb(obj).zza.hashCode() : iHashCode2;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final Object zzc() {
        return ((zzatu) this.zzg).zzat();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzd(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzatu) {
                zzatu zzatuVar = (zzatu) obj;
                zzatuVar.zzaF(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                zzatuVar.zza = 0;
                zzatuVar.zzaD();
            }
            int[] iArr = this.zzc;
            for (int i11 = 0; i11 < iArr.length; i11 += 3) {
                int iZzp = zzp(i11);
                int i12 = 1048575 & iZzp;
                int iZzo = zzo(iZzp);
                long j11 = i12;
                if (iZzo != 9) {
                    if (iZzo != 60 && iZzo != 68) {
                        switch (iZzo) {
                            case 17:
                                if (zzI(obj, i11)) {
                                    zzs(i11).zzd(zzb.getObject(obj, j11));
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
                                    ((zzauz) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i11], i11)) {
                        zzs(i11).zzd(zzb.getObject(obj, j11));
                    }
                } else if (zzI(obj, i11)) {
                    zzs(i11).zzd(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zzf(obj);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zze(Object obj, Object obj2) {
        zzy(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzp = zzp(i11);
            int i12 = 1048575 & iZzp;
            int[] iArr = this.zzc;
            int iZzo = zzo(iZzp);
            int i13 = iArr[i11];
            long j11 = i12;
            switch (iZzo) {
                case 0:
                    if (zzI(obj2, i11)) {
                        zzawx.zzo(obj, j11, zzawx.zza(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i11)) {
                        zzawx.zzp(obj, j11, zzawx.zzb(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i11)) {
                        zzawx.zzm(obj, j11, zzawx.zzw(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i11)) {
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 9:
                    zzz(obj, obj2, i11);
                    break;
                case 10:
                    if (zzI(obj2, i11)) {
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i11)) {
                        zzawx.zzq(obj, j11, zzawx.zzc(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i11)) {
                        zzawx.zzr(obj, j11, zzawx.zzd(obj2, j11));
                        zzC(obj, i11);
                    }
                    break;
                case 17:
                    zzz(obj, obj2, i11);
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
                    int i14 = zzavv.zza;
                    zzawx.zzs(obj, j11, zzava.zza(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11)));
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
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzD(obj, i13, i11);
                    }
                    break;
                case 60:
                    zzA(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj2, i13, i11)) {
                        zzawx.zzs(obj, j11, zzawx.zzf(obj2, j11));
                        zzD(obj, i13, i11);
                    }
                    break;
                case 68:
                    zzA(obj, obj2, i11);
                    break;
            }
        }
        zzavv.zzr(this.zzn, obj, obj2);
        if (this.zzh) {
            zzavv.zzq(this.zzo, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:181:0x0619 A[Catch: all -> 0x0643, TryCatch #1 {all -> 0x0643, blocks: (B:117:0x02fc, B:179:0x0614, B:181:0x0619, B:182:0x061e, B:122:0x0309, B:124:0x031a, B:125:0x0329, B:126:0x0338, B:127:0x0347, B:128:0x0356, B:129:0x0365, B:130:0x0374, B:131:0x0383, B:132:0x0392, B:133:0x03a2, B:134:0x03b2, B:135:0x03c2, B:136:0x03d2, B:137:0x03ee, B:138:0x03fe, B:139:0x040e, B:142:0x0425, B:144:0x042b, B:145:0x043b, B:146:0x044b, B:147:0x045b, B:148:0x046b, B:149:0x047b, B:150:0x048b, B:151:0x049b, B:152:0x04ab, B:153:0x04bb, B:154:0x04cb, B:155:0x04e0, B:156:0x04f1, B:157:0x0502, B:158:0x0513, B:159:0x0524, B:161:0x0531, B:164:0x0538, B:165:0x0542, B:166:0x054c, B:167:0x055d, B:168:0x056e, B:169:0x0583, B:170:0x058e, B:171:0x059f, B:172:0x05b0, B:173:0x05c0, B:174:0x05d0, B:175:0x05e0, B:176:0x05f0, B:177:0x0600), top: B:203:0x02fc }] */
    /* JADX WARN: Code duplicated, block: B:187:0x062b A[LOOP:3: B:185:0x0627->B:187:0x062b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x063f  */
    /* JADX WARN: Code duplicated, block: B:196:0x064c A[LOOP:2: B:194:0x0648->B:196:0x064c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:198:0x0660  */
    /* JADX WARN: Code duplicated, block: B:296:0x0624 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzf(Object obj, zzavs zzavsVar, zzatf zzatfVar) throws Throwable {
        Object obj2;
        int i11;
        int i12;
        zzawn zzawnVar;
        Object obj3;
        zzatf zzatfVar2;
        int i13;
        zzatf zzatfVar3;
        zzatf zzatfVar4;
        Object obj4 = obj;
        zzatf zzatfVar5 = zzatfVar;
        zzatfVar.getClass();
        zzy(obj);
        zzawn zzawnVar2 = this.zzn;
        zzatg zzatgVar = this.zzo;
        Object objZzt = null;
        zzatk zzatkVar = null;
        while (true) {
            try {
                int iZzc = zzavsVar.zzc();
                if (iZzc < this.zze || iZzc > this.zzf) {
                    i12 = -1;
                } else {
                    int length = (this.zzc.length / 3) - 1;
                    int i14 = 0;
                    while (true) {
                        if (i14 > length) {
                            i12 = -1;
                        } else {
                            int i15 = (length + i14) >>> 1;
                            int i16 = i15 * 3;
                            int i17 = this.zzc[i16];
                            if (iZzc == i17) {
                                i12 = i16;
                            } else if (iZzc < i17) {
                                length = i15 - 1;
                            } else {
                                i14 = i15 + 1;
                            }
                        }
                    }
                }
                if (i12 >= 0) {
                    zzawnVar2 = zzawnVar2;
                    obj2 = obj4;
                    try {
                        int iZzp = zzp(i12);
                        try {
                            switch (zzo(iZzp)) {
                                case 0:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzo(obj2, iZzp & 1048575, zzavsVar.zza());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 1:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzp(obj2, iZzp & 1048575, zzavsVar.zzb());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 2:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzr(obj2, iZzp & 1048575, zzavsVar.zzl());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 3:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzr(obj2, iZzp & 1048575, zzavsVar.zzo());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 4:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzq(obj2, iZzp & 1048575, zzavsVar.zzg());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 5:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzr(obj2, iZzp & 1048575, zzavsVar.zzk());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 6:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzq(obj2, iZzp & 1048575, zzavsVar.zzf());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 7:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzm(obj2, iZzp & 1048575, zzavsVar.zzN());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 8:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzB(obj2, iZzp, zzavsVar);
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 9:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavf zzavfVar = (zzavf) zzv(obj2, i12);
                                    zzavsVar.zzu(zzavfVar, zzs(i12), zzatfVar2);
                                    zzE(obj2, i12, zzavfVar);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 10:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzs(obj2, iZzp & 1048575, zzavsVar.zzp());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 11:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzq(obj2, iZzp & 1048575, zzavsVar.zzj());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 12:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    int iZze = zzavsVar.zze();
                                    zzaty zzatyVarZzr = zzr(i12);
                                    if (zzatyVarZzr == null || zzatyVarZzr.zza(iZze)) {
                                        zzawx.zzq(obj2, iZzp & 1048575, iZze);
                                        zzC(obj2, i12);
                                        zzatfVar5 = zzatfVar2;
                                        objZzt = objZzt;
                                        zzatgVar = zzatgVar;
                                    } else {
                                        zzatfVar5 = zzatfVar2;
                                        zzawnVar2 = zzawnVar2;
                                        zzatgVar = zzatgVar;
                                        objZzt = zzavv.zzp(obj2, iZzc, iZze, objZzt, zzawnVar2);
                                    }
                                    obj4 = obj2;
                                    break;
                                case 13:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzq(obj2, iZzp & 1048575, zzavsVar.zzh());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 14:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzr(obj2, iZzp & 1048575, zzavsVar.zzm());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 15:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzq(obj2, iZzp & 1048575, zzavsVar.zzi());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 16:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzawx.zzr(obj2, iZzp & 1048575, zzavsVar.zzn());
                                    zzC(obj2, i12);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 17:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavf zzavfVar2 = (zzavf) zzv(obj2, i12);
                                    zzavsVar.zzt(zzavfVar2, zzs(i12), zzatfVar2);
                                    zzE(obj2, i12, zzavfVar2);
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 18:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzx(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 19:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzB(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 20:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzE(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 21:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzM(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 22:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzD(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 23:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzA(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 24:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzz(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 25:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzavsVar.zzv(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 26:
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    try {
                                        if (zzH(iZzp)) {
                                            ((zzasr) zzavsVar).zzK(this.zzm.zza(obj2, iZzp & 1048575), true);
                                        } else {
                                            ((zzasr) zzavsVar).zzK(this.zzm.zza(obj2, iZzp & 1048575), false);
                                        }
                                    } catch (zzaue unused) {
                                        zzawnVar2.zzq(zzavsVar);
                                        if (objZzt == null) {
                                            objZzt = zzawnVar2.zzc(obj2);
                                        }
                                        if (!zzawnVar2.zzp(objZzt, zzavsVar)) {
                                            objZzt = objZzt;
                                            for (i13 = this.zzk; i13 < this.zzl; i13++) {
                                                objZzt = zzt(obj, this.zzj[i13], objZzt, zzawnVar2, obj);
                                            }
                                            if (objZzt != null) {
                                                zzawnVar2.zzn(obj2, objZzt);
                                            }
                                        }
                                    }
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 27:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzF(this.zzm.zza(obj2, iZzp & 1048575), zzs(i12), zzatfVar3);
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 28:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzw(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzL(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 30:
                                    zzatgVar = zzatgVar;
                                    zzatfVar4 = zzatfVar5;
                                    List listZza = this.zzm.zza(obj2, iZzp & 1048575);
                                    zzavsVar.zzy(listZza);
                                    objZzt = zzavv.zzo(obj, iZzc, listZza, zzr(i12), objZzt, zzawnVar2);
                                    zzatfVar5 = zzatfVar4;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case VungleException.WEB_CRASH /* 31 */:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzG(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 32:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzH(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 33:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzI(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 34:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzJ(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 35:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzx(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 36:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzB(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 37:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzE(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 38:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzM(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 39:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzD(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 40:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzA(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 41:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzz(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzv(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                    zzatfVar3 = zzatfVar5;
                                    zzavsVar.zzL(this.zzm.zza(obj2, iZzp & 1048575));
                                    zzatfVar2 = zzatfVar3;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                    List listZza2 = this.zzm.zza(obj2, iZzp & 1048575);
                                    zzavsVar.zzy(listZza2);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar4 = zzatfVar5;
                                    try {
                                        try {
                                            objZzt = zzavv.zzo(obj, iZzc, listZza2, zzr(i12), objZzt, zzawnVar2);
                                            zzatfVar5 = zzatfVar4;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (zzaue unused2) {
                                        zzatfVar2 = zzatfVar4;
                                        zzawnVar2.zzq(zzavsVar);
                                        if (objZzt == null) {
                                            objZzt = zzawnVar2.zzc(obj2);
                                        }
                                        if (!zzawnVar2.zzp(objZzt, zzavsVar)) {
                                            objZzt = objZzt;
                                            while (i13 < this.zzl) {
                                                objZzt = zzt(obj, this.zzj[i13], objZzt, zzawnVar2, obj);
                                            }
                                            if (objZzt != null) {
                                                zzawnVar2.zzn(obj2, objZzt);
                                            }
                                        }
                                        zzatfVar5 = zzatfVar2;
                                        objZzt = objZzt;
                                    }
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                    zzavsVar.zzG(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                    zzavsVar.zzH(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                    zzavsVar.zzI(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 48:
                                    zzavsVar.zzJ(this.zzm.zza(obj2, iZzp & 1048575));
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 49:
                                    zzavsVar.zzC(this.zzm.zza(obj2, iZzp & 1048575), zzs(i12), zzatfVar5);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 50:
                                    Object objZzu = zzu(i12);
                                    long jZzp = zzp(i12) & 1048575;
                                    Object objZzf = zzawx.zzf(obj2, jZzp);
                                    if (objZzf == null) {
                                        objZzf = zzauz.zza().zzb();
                                        zzawx.zzs(obj2, jZzp, objZzf);
                                    } else if (!((zzauz) objZzf).zze()) {
                                        Object objZzb = zzauz.zza().zzb();
                                        zzava.zza(objZzb, objZzf);
                                        zzawx.zzs(obj2, jZzp, objZzb);
                                        objZzf = objZzb;
                                    }
                                    throw null;
                                case 51:
                                    zzawx.zzs(obj2, iZzp & 1048575, Double.valueOf(zzavsVar.zza()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 52:
                                    zzawx.zzs(obj2, iZzp & 1048575, Float.valueOf(zzavsVar.zzb()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 53:
                                    zzawx.zzs(obj2, iZzp & 1048575, Long.valueOf(zzavsVar.zzl()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 54:
                                    zzawx.zzs(obj2, iZzp & 1048575, Long.valueOf(zzavsVar.zzo()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 55:
                                    zzawx.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzavsVar.zzg()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 56:
                                    zzawx.zzs(obj2, iZzp & 1048575, Long.valueOf(zzavsVar.zzk()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                    zzawx.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzavsVar.zzf()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 58:
                                    zzawx.zzs(obj2, iZzp & 1048575, Boolean.valueOf(zzavsVar.zzN()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 59:
                                    zzB(obj2, iZzp, zzavsVar);
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 60:
                                    zzavf zzavfVar3 = (zzavf) zzw(obj2, iZzc, i12);
                                    zzavsVar.zzu(zzavfVar3, zzs(i12), zzatfVar5);
                                    zzF(obj2, iZzc, i12, zzavfVar3);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 61:
                                    zzawx.zzs(obj2, iZzp & 1048575, zzavsVar.zzp());
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 62:
                                    zzawx.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzavsVar.zzj()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 63:
                                    int iZze2 = zzavsVar.zze();
                                    zzaty zzatyVarZzr2 = zzr(i12);
                                    if (zzatyVarZzr2 != null && !zzatyVarZzr2.zza(iZze2)) {
                                        objZzt = zzavv.zzp(obj2, iZzc, iZze2, objZzt, zzawnVar2);
                                        obj4 = obj2;
                                        zzawnVar2 = zzawnVar2;
                                    }
                                    zzawx.zzs(obj2, iZzp & 1048575, Integer.valueOf(iZze2));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 64:
                                    zzawx.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzavsVar.zzh()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                    zzawx.zzs(obj2, iZzp & 1048575, Long.valueOf(zzavsVar.zzm()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 66:
                                    zzawx.zzs(obj2, iZzp & 1048575, Integer.valueOf(zzavsVar.zzi()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                    zzawx.zzs(obj2, iZzp & 1048575, Long.valueOf(zzavsVar.zzn()));
                                    zzD(obj2, iZzc, i12);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                case 68:
                                    zzavf zzavfVar4 = (zzavf) zzw(obj2, iZzc, i12);
                                    zzavsVar.zzt(zzavfVar4, zzs(i12), zzatfVar5);
                                    zzF(obj2, iZzc, i12, zzavfVar4);
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    zzatfVar2 = zzatfVar5;
                                    zzatfVar5 = zzatfVar2;
                                    objZzt = objZzt;
                                    zzatgVar = zzatgVar;
                                    obj4 = obj2;
                                    break;
                                default:
                                    if (objZzt == null) {
                                        objZzt = zzawnVar2.zzc(obj2);
                                    }
                                    try {
                                        if (!zzawnVar2.zzp(objZzt, zzavsVar)) {
                                            for (int i18 = this.zzk; i18 < this.zzl; i18++) {
                                                objZzt = zzt(obj, this.zzj[i18], objZzt, zzawnVar2, obj);
                                            }
                                        }
                                        obj4 = obj2;
                                        zzawnVar2 = zzawnVar2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    break;
                            }
                        } catch (zzaue unused3) {
                            objZzt = objZzt;
                            zzatgVar = zzatgVar;
                            zzatfVar2 = zzatfVar5;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        objZzt = objZzt;
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i19 = this.zzk; i19 < this.zzl; i19++) {
                        objZzt = zzt(obj, this.zzj[i19], objZzt, zzawnVar2, obj);
                    }
                    zzawnVar2 = zzawnVar2;
                    obj2 = obj4;
                } else {
                    try {
                        Object objZzd = !this.zzh ? null : zzatgVar.zzd(zzatfVar5, this.zzg, iZzc);
                        if (objZzd != null) {
                            zzatk zzatkVarZzc = zzatkVar == null ? zzatgVar.zzc(obj4) : zzatkVar;
                            zzawnVar = zzawnVar2;
                            obj3 = obj4;
                            try {
                                objZzt = zzatgVar.zze(obj, zzavsVar, objZzd, zzatfVar, zzatkVarZzc, objZzt, zzawnVar);
                                zzatkVar = zzatkVarZzc;
                            } catch (Throwable th5) {
                                th = th5;
                                obj2 = obj3;
                                zzawnVar2 = zzawnVar;
                                objZzt = objZzt;
                                objZzt = objZzt;
                                for (i11 = this.zzk; i11 < this.zzl; i11++) {
                                    objZzt = zzt(obj, this.zzj[i11], objZzt, zzawnVar2, obj);
                                }
                                if (objZzt != null) {
                                    zzawnVar2.zzn(obj2, objZzt);
                                }
                                throw th;
                            }
                        } else {
                            zzawnVar = zzawnVar2;
                            obj3 = obj4;
                            zzawnVar.zzq(zzavsVar);
                            if (objZzt == null) {
                                objZzt = zzawnVar.zzc(obj3);
                            }
                            try {
                                if (!zzawnVar.zzp(objZzt, zzavsVar)) {
                                    int i21 = this.zzk;
                                    while (i21 < this.zzl) {
                                        zzawn zzawnVar3 = zzawnVar;
                                        objZzt = zzt(obj, this.zzj[i21], objZzt, zzawnVar3, obj);
                                        i21++;
                                        obj3 = obj3;
                                        zzawnVar = zzawnVar3;
                                    }
                                    obj2 = obj3;
                                    zzawnVar2 = zzawnVar;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                obj2 = obj3;
                                zzawnVar2 = zzawnVar;
                            }
                        }
                        obj4 = obj3;
                        zzawnVar2 = zzawnVar;
                    } catch (Throwable th7) {
                        th = th7;
                        zzawnVar2 = zzawnVar2;
                        obj2 = obj4;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                objZzt = objZzt;
                zzawnVar2 = zzawnVar2;
                obj2 = obj4;
            }
            objZzt = objZzt;
            while (i11 < this.zzl) {
                objZzt = zzt(obj, this.zzj[i11], objZzt, zzawnVar2, obj);
            }
            if (objZzt != null) {
                zzawnVar2.zzn(obj2, objZzt);
            }
            throw th;
        }
        if (objZzt != null) {
            zzawnVar2.zzn(obj2, objZzt);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final boolean zzg(Object obj, Object obj2) {
        boolean zZzt;
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzp = zzp(i11);
            long j11 = iZzp & 1048575;
            switch (zzo(iZzp)) {
                case 0:
                    if (!zzG(obj, obj2, i11) || Double.doubleToLongBits(zzawx.zza(obj, j11)) != Double.doubleToLongBits(zzawx.zza(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzG(obj, obj2, i11) || Float.floatToIntBits(zzawx.zzb(obj, j11)) != Float.floatToIntBits(zzawx.zzb(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzG(obj, obj2, i11) || zzawx.zzd(obj, j11) != zzawx.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzG(obj, obj2, i11) || zzawx.zzd(obj, j11) != zzawx.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzG(obj, obj2, i11) || zzawx.zzc(obj, j11) != zzawx.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzG(obj, obj2, i11) || zzawx.zzd(obj, j11) != zzawx.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzG(obj, obj2, i11) || zzawx.zzc(obj, j11) != zzawx.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzG(obj, obj2, i11) || zzawx.zzw(obj, j11) != zzawx.zzw(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzG(obj, obj2, i11) || !zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzG(obj, obj2, i11) || !zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzG(obj, obj2, i11) || !zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzG(obj, obj2, i11) || zzawx.zzc(obj, j11) != zzawx.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzG(obj, obj2, i11) || zzawx.zzc(obj, j11) != zzawx.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzG(obj, obj2, i11) || zzawx.zzc(obj, j11) != zzawx.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzG(obj, obj2, i11) || zzawx.zzd(obj, j11) != zzawx.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzG(obj, obj2, i11) || zzawx.zzc(obj, j11) != zzawx.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzG(obj, obj2, i11) || zzawx.zzd(obj, j11) != zzawx.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzG(obj, obj2, i11) || !zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11))) {
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
                    zZzt = zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11));
                    break;
                case 50:
                    zZzt = zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11));
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
                    long jZzn = zzn(i11) & 1048575;
                    if (zzawx.zzc(obj, jZzn) != zzawx.zzc(obj2, jZzn) || !zzavv.zzt(zzawx.zzf(obj, j11), zzawx.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzt) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c2 A[LOOP:1: B:45:0x00b1->B:50:0x00c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00df A[SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final boolean zzh(Object obj) {
        int i11;
        int i12;
        List list;
        zzavt zzavtVarZzs;
        int i13;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i17 = iArr[i16];
            int i18 = iArr2[i17];
            int iZzp = zzp(i17);
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
            if ((268435456 & iZzp) != 0 && !zzJ(obj, i17, i11, i12, i22)) {
                return false;
            }
            int iZzo = zzo(iZzp);
            if (iZzo == 9 || iZzo == 17) {
                if (zzJ(obj, i17, i11, i12, i22) && !zzK(obj, iZzp, zzs(i17))) {
                    return false;
                }
            } else if (iZzo == 27) {
                list = (List) zzawx.zzf(obj, iZzp & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzavtVarZzs = zzs(i17);
                    for (i13 = 0; i13 < list.size(); i13++) {
                        if (!zzavtVarZzs.zzh(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (iZzo == 60 || iZzo == 68) {
                if (zzM(obj, i18, i17) && !zzK(obj, iZzp, zzs(i17))) {
                    return false;
                }
            } else if (iZzo == 49) {
                list = (List) zzawx.zzf(obj, iZzp & 1048575);
                if (list.isEmpty()) {
                    zzavtVarZzs = zzs(i17);
                    while (i13 < list.size()) {
                        if (!zzavtVarZzs.zzh(list.get(i13))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzo == 50 && !((zzauz) zzawx.zzf(obj, iZzp & 1048575)).isEmpty()) {
                throw null;
            }
            i16++;
            i14 = i11;
            i15 = i12;
        }
        return !this.zzh || this.zzo.zzb(obj).zzj();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zzj(Object obj, zzasy zzasyVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int i11;
        Map.Entry entry2;
        int i12;
        if (this.zzh) {
            zzatk zzatkVarZzb = this.zzo.zzb(obj);
            if (zzatkVarZzb.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzatkVarZzb.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < iArr.length) {
            int iZzp = zzp(i15);
            int[] iArr2 = this.zzc;
            int iZzo = zzo(iZzp);
            int i16 = iArr2[i15];
            if (iZzo <= 17) {
                int i17 = iArr2[i15 + 2];
                int i18 = i17 & 1048575;
                if (i18 != i13) {
                    i14 = i18 == 1048575 ? 0 : unsafe.getInt(obj, i18);
                    i13 = i18;
                } else {
                    entry = entry;
                }
                i12 = 1 << (i17 >>> 20);
                i11 = i14;
                entry2 = entry;
            } else {
                i11 = i14;
                entry2 = entry;
                i12 = 0;
            }
            int i19 = i13;
            while (entry2 != null && this.zzo.zza(entry2) <= i16) {
                this.zzo.zzj(zzasyVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j11 = iZzp & 1048575;
            switch (iZzo) {
                case 0:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzf(i16, zzawx.zza(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 1:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzo(i16, zzawx.zzb(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 2:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzt(i16, unsafe.getLong(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 3:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzK(i16, unsafe.getLong(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 4:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzr(i16, unsafe.getInt(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 5:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzm(i16, unsafe.getLong(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 6:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzk(i16, unsafe.getInt(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 7:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzb(i16, zzawx.zzw(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 8:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzO(i16, unsafe.getObject(obj, j11), zzasyVar);
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 9:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzv(i16, unsafe.getObject(obj, j11), zzs(i15));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 10:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzd(i16, (zzask) unsafe.getObject(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 11:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzI(i16, unsafe.getInt(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 12:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzi(i16, unsafe.getInt(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 13:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzx(i16, unsafe.getInt(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 14:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzz(i16, unsafe.getLong(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 15:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzB(i16, unsafe.getInt(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 16:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzD(i16, unsafe.getLong(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 17:
                    it = it;
                    iArr = iArr;
                    if (zzJ(obj, i15, i19, i11, i12)) {
                        zzasyVar.zzq(i16, unsafe.getObject(obj, j11), zzs(i15));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 18:
                    zzavv.zzv(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 19:
                    zzavv.zzz(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 20:
                    zzavv.zzB(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 21:
                    zzavv.zzH(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 22:
                    zzavv.zzA(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 23:
                    zzavv.zzy(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 24:
                    zzavv.zzx(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 25:
                    zzavv.zzu(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 26:
                    int i21 = this.zzc[i15];
                    List list = (List) unsafe.getObject(obj, j11);
                    int i22 = zzavv.zza;
                    if (list != null && !list.isEmpty()) {
                        zzasyVar.zzH(i21, list);
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 27:
                    int i23 = this.zzc[i15];
                    List list2 = (List) unsafe.getObject(obj, j11);
                    zzavt zzavtVarZzs = zzs(i15);
                    int i24 = zzavv.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i25 = 0; i25 < list2.size(); i25++) {
                            zzasyVar.zzv(i23, list2.get(i25), zzavtVarZzs);
                        }
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 28:
                    int i26 = this.zzc[i15];
                    List list3 = (List) unsafe.getObject(obj, j11);
                    int i27 = zzavv.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzasyVar.zze(i26, list3);
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    zzavv.zzG(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 30:
                    zzavv.zzw(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    zzavv.zzC(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 32:
                    zzavv.zzD(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 33:
                    zzavv.zzE(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 34:
                    zzavv.zzF(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, false);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 35:
                    zzavv.zzv(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 36:
                    zzavv.zzz(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 37:
                    zzavv.zzB(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 38:
                    zzavv.zzH(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 39:
                    zzavv.zzA(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 40:
                    zzavv.zzy(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 41:
                    zzavv.zzx(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzavv.zzu(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzavv.zzG(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzavv.zzw(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzavv.zzC(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzavv.zzD(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzavv.zzE(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 48:
                    zzavv.zzF(this.zzc[i15], (List) unsafe.getObject(obj, j11), zzasyVar, true);
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 49:
                    int i28 = this.zzc[i15];
                    List list4 = (List) unsafe.getObject(obj, j11);
                    zzavt zzavtVarZzs2 = zzs(i15);
                    int i29 = zzavv.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i31 = 0; i31 < list4.size(); i31++) {
                            zzasyVar.zzq(i28, list4.get(i31), zzavtVarZzs2);
                        }
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j11) != null) {
                        throw null;
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 51:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzf(i16, zzk(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 52:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzo(i16, zzl(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 53:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzt(i16, zzq(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 54:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzK(i16, zzq(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 55:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzr(i16, zzm(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 56:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzm(i16, zzq(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzk(i16, zzm(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 58:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzb(i16, zzN(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 59:
                    if (zzM(obj, i16, i15)) {
                        zzO(i16, unsafe.getObject(obj, j11), zzasyVar);
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 60:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzv(i16, unsafe.getObject(obj, j11), zzs(i15));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 61:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzd(i16, (zzask) unsafe.getObject(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 62:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzI(i16, zzm(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 63:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzi(i16, zzm(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 64:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzx(i16, zzm(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzz(i16, zzq(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 66:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzB(i16, zzm(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzD(i16, zzq(obj, j11));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                case 68:
                    if (zzM(obj, i16, i15)) {
                        zzasyVar.zzq(i16, unsafe.getObject(obj, j11), zzs(i15));
                    }
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
                default:
                    i15 += 3;
                    i13 = i19;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i14 = i11;
                    break;
            }
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzo.zzj(zzasyVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        zzawn zzawnVar = this.zzn;
        zzawnVar.zzs(zzawnVar.zzd(obj), zzasyVar);
    }
}
