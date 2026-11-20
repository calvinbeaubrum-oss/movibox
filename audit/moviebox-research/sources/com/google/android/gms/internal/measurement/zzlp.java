package com.google.android.gms.internal.measurement;

import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.common.api.Api;
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
final class zzlp<T> implements zzlx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmy.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzla zzm;
    private final zzmo zzn;
    private final zzjs zzo;
    private final zzlr zzp;
    private final zzlh zzq;

    private zzlp(int[] iArr, Object[] objArr, int i11, int i12, zzlm zzlmVar, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzlr zzlrVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = z11;
        boolean z13 = false;
        if (zzjsVar != null && zzjsVar.zzc(zzlmVar)) {
            z13 = true;
        }
        this.zzh = z13;
        this.zzj = iArr2;
        this.zzk = i13;
        this.zzl = i14;
        this.zzp = zzlrVar;
        this.zzm = zzlaVar;
        this.zzn = zzmoVar;
        this.zzo = zzjsVar;
        this.zzg = zzlmVar;
        this.zzq = zzlhVar;
    }

    private static int zzA(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzB(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzC(Object obj, long j11) {
        return ((Long) zzmy.zzf(obj, j11)).longValue();
    }

    private final zzkj zzD(int i11) {
        int i12 = i11 / 3;
        return (zzkj) this.zzd[i12 + i12 + 1];
    }

    private final zzlx zzE(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzlx zzlxVar = (zzlx) this.zzd[i13];
        if (zzlxVar != null) {
            return zzlxVar;
        }
        zzlx zzlxVarZzb = zzlu.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzlxVarZzb;
        return zzlxVarZzb;
    }

    private final Object zzF(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzG(Object obj, int i11) {
        zzlx zzlxVarZzE = zzE(i11);
        long jZzB = zzB(i11) & 1048575;
        if (!zzT(obj, i11)) {
            return zzlxVarZzE.zze();
        }
        Object object = zzb.getObject(obj, jZzB);
        if (zzW(object)) {
            return object;
        }
        Object objZze = zzlxVarZzE.zze();
        if (object != null) {
            zzlxVarZzE.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzH(Object obj, int i11, int i12) {
        zzlx zzlxVarZzE = zzE(i12);
        if (!zzX(obj, i11, i12)) {
            return zzlxVarZzE.zze();
        }
        Object object = zzb.getObject(obj, zzB(i12) & 1048575);
        if (zzW(object)) {
            return object;
        }
        Object objZze = zzlxVarZzE.zze();
        if (object != null) {
            zzlxVarZzE.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzI(Class cls, String str) {
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

    private static void zzJ(Object obj) {
        if (!zzW(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzK(Object obj, Object obj2, int i11) {
        if (zzT(obj2, i11)) {
            long jZzB = zzB(i11) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, jZzB);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzlx zzlxVarZzE = zzE(i11);
            if (!zzT(obj, i11)) {
                if (zzW(object)) {
                    Object objZze = zzlxVarZzE.zze();
                    zzlxVarZzE.zzg(objZze, object);
                    unsafe.putObject(obj, jZzB, objZze);
                } else {
                    unsafe.putObject(obj, jZzB, object);
                }
                zzM(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, jZzB);
            if (!zzW(object2)) {
                Object objZze2 = zzlxVarZzE.zze();
                zzlxVarZzE.zzg(objZze2, object2);
                unsafe.putObject(obj, jZzB, objZze2);
                object2 = objZze2;
            }
            zzlxVarZzE.zzg(object2, object);
        }
    }

    private final void zzL(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzX(obj2, i12, i11)) {
            long jZzB = zzB(i11) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, jZzB);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i11] + " is present but null: " + obj2.toString());
            }
            zzlx zzlxVarZzE = zzE(i11);
            if (!zzX(obj, i12, i11)) {
                if (zzW(object)) {
                    Object objZze = zzlxVarZzE.zze();
                    zzlxVarZzE.zzg(objZze, object);
                    unsafe.putObject(obj, jZzB, objZze);
                } else {
                    unsafe.putObject(obj, jZzB, object);
                }
                zzN(obj, i12, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, jZzB);
            if (!zzW(object2)) {
                Object objZze2 = zzlxVarZzE.zze();
                zzlxVarZzE.zzg(objZze2, object2);
                unsafe.putObject(obj, jZzB, objZze2);
                object2 = objZze2;
            }
            zzlxVarZzE.zzg(object2, object);
        }
    }

    private final void zzM(Object obj, int i11) {
        int iZzy = zzy(i11);
        long j11 = 1048575 & iZzy;
        if (j11 == 1048575) {
            return;
        }
        zzmy.zzq(obj, j11, (1 << (iZzy >>> 20)) | zzmy.zzc(obj, j11));
    }

    private final void zzN(Object obj, int i11, int i12) {
        zzmy.zzq(obj, zzy(i12) & 1048575, i11);
    }

    private final void zzO(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, zzB(i11) & 1048575, obj2);
        zzM(obj, i11);
    }

    private final void zzP(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, zzB(i12) & 1048575, obj2);
        zzN(obj, i11, i12);
    }

    private final void zzQ(Object obj, zzng zzngVar) throws IOException {
        int i11;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i13 < length) {
            int iZzB = zzB(i13);
            int[] iArr = this.zzc;
            int i16 = iArr[i13];
            int iZzA = zzA(iZzB);
            if (iZzA <= 17) {
                int i17 = iArr[i13 + 2];
                int i18 = i17 & i12;
                if (i18 != i15) {
                    i14 = unsafe.getInt(obj, i18);
                    i15 = i18;
                }
                i11 = 1 << (i17 >>> 20);
            } else {
                i11 = 0;
            }
            long j11 = iZzB & i12;
            switch (iZzA) {
                case 0:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzf(i16, zzmy.zza(obj, j11));
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 1:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzo(i16, zzmy.zzb(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 2:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzt(i16, unsafe.getLong(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 3:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzJ(i16, unsafe.getLong(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 4:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzr(i16, unsafe.getInt(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 5:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzm(i16, unsafe.getLong(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 6:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzk(i16, unsafe.getInt(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 7:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzb(i16, zzmy.zzw(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 8:
                    if ((i14 & i11) != 0) {
                        zzZ(i16, unsafe.getObject(obj, j11), zzngVar);
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 9:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzv(i16, unsafe.getObject(obj, j11), zzE(i13));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 10:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzd(i16, (zzje) unsafe.getObject(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 11:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzH(i16, unsafe.getInt(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 12:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzi(i16, unsafe.getInt(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 13:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzw(i16, unsafe.getInt(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 14:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzy(i16, unsafe.getLong(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 15:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzA(i16, unsafe.getInt(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 16:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzC(i16, unsafe.getLong(obj, j11));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 17:
                    if ((i14 & i11) != 0) {
                        zzngVar.zzq(i16, unsafe.getObject(obj, j11), zzE(i13));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 18:
                    zzlz.zzJ(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 19:
                    zzlz.zzN(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 20:
                    zzlz.zzQ(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 21:
                    zzlz.zzY(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 22:
                    zzlz.zzP(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 23:
                    zzlz.zzM(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 24:
                    zzlz.zzL(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 25:
                    zzlz.zzH(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 26:
                    zzlz.zzW(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar);
                    break;
                case 27:
                    zzlz.zzR(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, zzE(i13));
                    break;
                case 28:
                    zzlz.zzI(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    zzlz.zzX(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    break;
                case 30:
                    zzlz.zzK(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    zzlz.zzS(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    break;
                case 32:
                    zzlz.zzT(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    break;
                case 33:
                    zzlz.zzU(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    break;
                case 34:
                    zzlz.zzV(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, false);
                    break;
                case 35:
                    zzlz.zzJ(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 36:
                    zzlz.zzN(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 37:
                    zzlz.zzQ(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 38:
                    zzlz.zzY(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 39:
                    zzlz.zzP(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 40:
                    zzlz.zzM(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 41:
                    zzlz.zzL(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzlz.zzH(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzlz.zzX(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzlz.zzK(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzlz.zzS(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzlz.zzT(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzlz.zzU(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 48:
                    zzlz.zzV(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, true);
                    break;
                case 49:
                    zzlz.zzO(this.zzc[i13], (List) unsafe.getObject(obj, j11), zzngVar, zzE(i13));
                    break;
                case 50:
                    zzR(zzngVar, i16, unsafe.getObject(obj, j11), i13);
                    break;
                case 51:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzf(i16, zzn(obj, j11));
                    }
                    break;
                case 52:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzo(i16, zzo(obj, j11));
                    }
                    break;
                case 53:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzt(i16, zzC(obj, j11));
                    }
                    break;
                case 54:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzJ(i16, zzC(obj, j11));
                    }
                    break;
                case 55:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzr(i16, zzr(obj, j11));
                    }
                    break;
                case 56:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzm(i16, zzC(obj, j11));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzk(i16, zzr(obj, j11));
                    }
                    break;
                case 58:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzb(i16, zzY(obj, j11));
                    }
                    break;
                case 59:
                    if (zzX(obj, i16, i13)) {
                        zzZ(i16, unsafe.getObject(obj, j11), zzngVar);
                    }
                    break;
                case 60:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzv(i16, unsafe.getObject(obj, j11), zzE(i13));
                    }
                    break;
                case 61:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzd(i16, (zzje) unsafe.getObject(obj, j11));
                    }
                    break;
                case 62:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzH(i16, zzr(obj, j11));
                    }
                    break;
                case 63:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzi(i16, zzr(obj, j11));
                    }
                    break;
                case 64:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzw(i16, zzr(obj, j11));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzy(i16, zzC(obj, j11));
                    }
                    break;
                case 66:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzA(i16, zzr(obj, j11));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzC(i16, zzC(obj, j11));
                    }
                    break;
                case 68:
                    if (zzX(obj, i16, i13)) {
                        zzngVar.zzq(i16, unsafe.getObject(obj, j11), zzE(i13));
                    }
                    break;
            }
            i13 += 3;
            i12 = 1048575;
        }
        zzmo zzmoVar = this.zzn;
        zzmoVar.zzi(zzmoVar.zzd(obj), zzngVar);
    }

    private final void zzR(zzng zzngVar, int i11, Object obj, int i12) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzS(Object obj, Object obj2, int i11) {
        return zzT(obj, i11) == zzT(obj2, i11);
    }

    private final boolean zzT(Object obj, int i11) {
        int iZzy = zzy(i11);
        long j11 = iZzy & 1048575;
        if (j11 != 1048575) {
            return (zzmy.zzc(obj, j11) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzB = zzB(i11);
        long j12 = iZzB & 1048575;
        switch (zzA(iZzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmy.zza(obj, j12)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmy.zzb(obj, j12)) != 0;
            case 2:
                return zzmy.zzd(obj, j12) != 0;
            case 3:
                return zzmy.zzd(obj, j12) != 0;
            case 4:
                return zzmy.zzc(obj, j12) != 0;
            case 5:
                return zzmy.zzd(obj, j12) != 0;
            case 6:
                return zzmy.zzc(obj, j12) != 0;
            case 7:
                return zzmy.zzw(obj, j12);
            case 8:
                Object objZzf = zzmy.zzf(obj, j12);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzje) {
                    return !zzje.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmy.zzf(obj, j12) != null;
            case 10:
                return !zzje.zzb.equals(zzmy.zzf(obj, j12));
            case 11:
                return zzmy.zzc(obj, j12) != 0;
            case 12:
                return zzmy.zzc(obj, j12) != 0;
            case 13:
                return zzmy.zzc(obj, j12) != 0;
            case 14:
                return zzmy.zzd(obj, j12) != 0;
            case 15:
                return zzmy.zzc(obj, j12) != 0;
            case 16:
                return zzmy.zzd(obj, j12) != 0;
            case 17:
                return zzmy.zzf(obj, j12) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzU(Object obj, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return zzT(obj, i11);
        }
        return (i13 & i14) != 0;
    }

    private static boolean zzV(Object obj, int i11, zzlx zzlxVar) {
        return zzlxVar.zzk(zzmy.zzf(obj, i11 & 1048575));
    }

    private static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkf) {
            return ((zzkf) obj).zzbO();
        }
        return true;
    }

    private final boolean zzX(Object obj, int i11, int i12) {
        return zzmy.zzc(obj, (long) (zzy(i12) & 1048575)) == i11;
    }

    private static boolean zzY(Object obj, long j11) {
        return ((Boolean) zzmy.zzf(obj, j11)).booleanValue();
    }

    private static final void zzZ(int i11, Object obj, zzng zzngVar) throws IOException {
        if (obj instanceof String) {
            zzngVar.zzF(i11, (String) obj);
        } else {
            zzngVar.zzd(i11, (zzje) obj);
        }
    }

    public static zzmp zzd(Object obj) {
        zzkf zzkfVar = (zzkf) obj;
        zzmp zzmpVar = zzkfVar.zzc;
        if (zzmpVar != zzmp.zzc()) {
            return zzmpVar;
        }
        zzmp zzmpVarZzf = zzmp.zzf();
        zzkfVar.zzc = zzmpVarZzf;
        return zzmpVarZzf;
    }

    public static zzlp zzl(Class cls, zzlj zzljVar, zzlr zzlrVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar) {
        if (zzljVar instanceof zzlw) {
            return zzm((zzlw) zzljVar, zzlrVar, zzlaVar, zzmoVar, zzjsVar, zzlhVar);
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
    public static zzlp zzm(zzlw zzlwVar, zzlr zzlrVar, zzla zzlaVar, zzmo zzmoVar, zzjs zzjsVar, zzlh zzlhVar) {
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
        Field fieldZzI;
        char cCharAt9;
        int i34;
        int i35;
        int i36;
        int i37;
        Object obj;
        Field fieldZzI2;
        int i38;
        Object obj2;
        Field fieldZzI3;
        int i39;
        char cCharAt10;
        int i40;
        char cCharAt11;
        int i41;
        char cCharAt12;
        int i42;
        char cCharAt13;
        boolean z11 = zzlwVar.zzc() == 2;
        String strZzd = zzlwVar.zzd();
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
        Object[] objArrZze = zzlwVar.zze();
        Class<?> cls = zzlwVar.zza().getClass();
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
                        fieldZzI2 = (Field) obj;
                    } else {
                        fieldZzI2 = zzI(cls, (String) obj);
                        objArrZze[i37] = fieldZzI2;
                    }
                    iArr2 = iArr3;
                    i28 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzI2);
                    i38 = i37 + 1;
                    obj2 = objArrZze[i38];
                    if (obj2 instanceof Field) {
                        fieldZzI3 = (Field) obj2;
                    } else {
                        fieldZzI3 = zzI(cls, (String) obj2);
                        objArrZze[i38] = fieldZzI3;
                    }
                    strZzd = strZzd;
                    i13 = i13;
                    objArr = objArr2;
                    i31 = i12;
                    i32 = i92;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzI3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i33 = 0;
                }
                i12 = i36;
                i37 = iCharAt12 + iCharAt12;
                obj = objArrZze[i37];
                if (obj instanceof Field) {
                    fieldZzI2 = (Field) obj;
                } else {
                    fieldZzI2 = zzI(cls, (String) obj);
                    objArrZze[i37] = fieldZzI2;
                }
                iArr2 = iArr3;
                i28 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzI2);
                i38 = i37 + 1;
                obj2 = objArrZze[i38];
                if (obj2 instanceof Field) {
                    fieldZzI3 = (Field) obj2;
                } else {
                    fieldZzI3 = zzI(cls, (String) obj2);
                    objArrZze[i38] = fieldZzI3;
                }
                strZzd = strZzd;
                i13 = i13;
                objArr = objArr2;
                i31 = i12;
                i32 = i92;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzI3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i33 = 0;
            } else {
                iArr2 = iArr3;
                i28 = iCharAt;
                i29 = i14;
                int i95 = i12 + 1;
                Field fieldZzI4 = zzI(cls, (String) objArrZze[i12]);
                if (i85 == 9 || i85 == 17) {
                    int i96 = i75 / 3;
                    objArr2[i96 + i96 + 1] = fieldZzI4.getType();
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
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzI4);
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
                                fieldZzI = (Field) obj3;
                            } else {
                                fieldZzI = zzI(cls, (String) obj3);
                                objArrZze[i106] = fieldZzI;
                            }
                            i33 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzI);
                        }
                        if (i85 >= 18 && i85 <= 49) {
                            iArr[i74] = iObjectFieldOffset;
                            i74++;
                        }
                    }
                    i31 = i34;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzI4);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzI4);
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
        return new zzlp(iArr3, objArr2, iCharAt, i14, zzlwVar.zza(), z11, false, iArr, iCharAt3, i72, zzlrVar, zzlaVar, zzmoVar, zzjsVar, zzlhVar, null);
    }

    private static double zzn(Object obj, long j11) {
        return ((Double) zzmy.zzf(obj, j11)).doubleValue();
    }

    private static float zzo(Object obj, long j11) {
        return ((Float) zzmy.zzf(obj, j11)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i11;
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzv;
        int iZzA5;
        int iZzA6;
        int iZzd;
        int iZzA7;
        int i12;
        int iZzu;
        int iZzi;
        int iZzz;
        int iZzA8;
        int iZzA9;
        int iZzA10;
        int iZzA11;
        int iZzA12;
        int iZzB2;
        int iZzA13;
        int iZzd2;
        int iZzA14;
        int i13;
        Unsafe unsafe = zzb;
        int i14 = 1048575;
        int i15 = 0;
        int iZzA15 = 0;
        int i16 = 0;
        int i17 = 1048575;
        while (i15 < this.zzc.length) {
            int iZzB3 = zzB(i15);
            int[] iArr = this.zzc;
            int i18 = iArr[i15];
            int iZzA16 = zzA(iZzB3);
            if (iZzA16 <= 17) {
                int i19 = iArr[i15 + 2];
                int i21 = i19 & i14;
                i11 = 1 << (i19 >>> 20);
                if (i21 != i17) {
                    i16 = unsafe.getInt(obj, i21);
                    i17 = i21;
                }
            } else {
                i11 = 0;
            }
            long j11 = iZzB3 & i14;
            switch (iZzA16) {
                case 0:
                    if ((i16 & i11) != 0) {
                        iZzA = zzjm.zzA(i18 << 3);
                        iZzA5 = iZzA + 8;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 1:
                    if ((i16 & i11) != 0) {
                        iZzA2 = zzjm.zzA(i18 << 3);
                        iZzA5 = iZzA2 + 4;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 2:
                    if ((i16 & i11) != 0) {
                        long j12 = unsafe.getLong(obj, j11);
                        iZzA3 = zzjm.zzA(i18 << 3);
                        iZzB = zzjm.zzB(j12);
                        iZzA15 += iZzA3 + iZzB;
                    }
                    break;
                case 3:
                    if ((i16 & i11) != 0) {
                        long j13 = unsafe.getLong(obj, j11);
                        iZzA3 = zzjm.zzA(i18 << 3);
                        iZzB = zzjm.zzB(j13);
                        iZzA15 += iZzA3 + iZzB;
                    }
                    break;
                case 4:
                    if ((i16 & i11) != 0) {
                        int i22 = unsafe.getInt(obj, j11);
                        iZzA4 = zzjm.zzA(i18 << 3);
                        iZzv = zzjm.zzv(i22);
                        i12 = iZzA4 + iZzv;
                        iZzA15 += i12;
                    }
                    break;
                case 5:
                    if ((i16 & i11) != 0) {
                        iZzA = zzjm.zzA(i18 << 3);
                        iZzA5 = iZzA + 8;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 6:
                    if ((i16 & i11) != 0) {
                        iZzA2 = zzjm.zzA(i18 << 3);
                        iZzA5 = iZzA2 + 4;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 7:
                    if ((i16 & i11) != 0) {
                        iZzA5 = zzjm.zzA(i18 << 3) + 1;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 8:
                    if ((i16 & i11) != 0) {
                        Object object = unsafe.getObject(obj, j11);
                        if (!(object instanceof zzje)) {
                            iZzA4 = zzjm.zzA(i18 << 3);
                            iZzv = zzjm.zzy((String) object);
                            i12 = iZzA4 + iZzv;
                            iZzA15 += i12;
                        } else {
                            iZzA6 = zzjm.zzA(i18 << 3);
                            iZzd = ((zzje) object).zzd();
                            iZzA7 = zzjm.zzA(iZzd);
                            i12 = iZzA6 + iZzA7 + iZzd;
                            iZzA15 += i12;
                        }
                    }
                    break;
                case 9:
                    if ((i16 & i11) != 0) {
                        iZzA5 = zzlz.zzo(i18, unsafe.getObject(obj, j11), zzE(i15));
                        iZzA15 += iZzA5;
                    }
                    break;
                case 10:
                    if ((i16 & i11) != 0) {
                        zzje zzjeVar = (zzje) unsafe.getObject(obj, j11);
                        iZzA6 = zzjm.zzA(i18 << 3);
                        iZzd = zzjeVar.zzd();
                        iZzA7 = zzjm.zzA(iZzd);
                        i12 = iZzA6 + iZzA7 + iZzd;
                        iZzA15 += i12;
                    }
                    break;
                case 11:
                    if ((i16 & i11) != 0) {
                        int i23 = unsafe.getInt(obj, j11);
                        iZzA4 = zzjm.zzA(i18 << 3);
                        iZzv = zzjm.zzA(i23);
                        i12 = iZzA4 + iZzv;
                        iZzA15 += i12;
                    }
                    break;
                case 12:
                    if ((i16 & i11) != 0) {
                        int i24 = unsafe.getInt(obj, j11);
                        iZzA4 = zzjm.zzA(i18 << 3);
                        iZzv = zzjm.zzv(i24);
                        i12 = iZzA4 + iZzv;
                        iZzA15 += i12;
                    }
                    break;
                case 13:
                    if ((i16 & i11) != 0) {
                        iZzA2 = zzjm.zzA(i18 << 3);
                        iZzA5 = iZzA2 + 4;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 14:
                    if ((i16 & i11) != 0) {
                        iZzA = zzjm.zzA(i18 << 3);
                        iZzA5 = iZzA + 8;
                        iZzA15 += iZzA5;
                    }
                    break;
                case 15:
                    if ((i16 & i11) != 0) {
                        int i25 = unsafe.getInt(obj, j11);
                        iZzA4 = zzjm.zzA(i18 << 3);
                        iZzv = zzjm.zzA((i25 >> 31) ^ (i25 + i25));
                        i12 = iZzA4 + iZzv;
                        iZzA15 += i12;
                    }
                    break;
                case 16:
                    if ((i11 & i16) != 0) {
                        long j14 = unsafe.getLong(obj, j11);
                        iZzA15 += zzjm.zzA(i18 << 3) + zzjm.zzB((j14 >> 63) ^ (j14 + j14));
                    }
                    break;
                case 17:
                    if ((i16 & i11) != 0) {
                        iZzA5 = zzjm.zzu(i18, (zzlm) unsafe.getObject(obj, j11), zzE(i15));
                        iZzA15 += iZzA5;
                    }
                    break;
                case 18:
                    iZzA5 = zzlz.zzh(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 19:
                    iZzA5 = zzlz.zzf(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 20:
                    iZzA5 = zzlz.zzm(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 21:
                    iZzA5 = zzlz.zzx(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 22:
                    iZzA5 = zzlz.zzk(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 23:
                    iZzA5 = zzlz.zzh(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 24:
                    iZzA5 = zzlz.zzf(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 25:
                    iZzA5 = zzlz.zza(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzA5;
                    break;
                case 26:
                    iZzu = zzlz.zzu(i18, (List) unsafe.getObject(obj, j11));
                    iZzA15 += iZzu;
                    break;
                case 27:
                    iZzu = zzlz.zzp(i18, (List) unsafe.getObject(obj, j11), zzE(i15));
                    iZzA15 += iZzu;
                    break;
                case 28:
                    iZzu = zzlz.zzc(i18, (List) unsafe.getObject(obj, j11));
                    iZzA15 += iZzu;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    iZzu = zzlz.zzv(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzu;
                    break;
                case 30:
                    iZzu = zzlz.zzd(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzu;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iZzu = zzlz.zzf(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzu;
                    break;
                case 32:
                    iZzu = zzlz.zzh(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzu;
                    break;
                case 33:
                    iZzu = zzlz.zzq(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzu;
                    break;
                case 34:
                    iZzu = zzlz.zzs(i18, (List) unsafe.getObject(obj, j11), false);
                    iZzA15 += iZzu;
                    break;
                case 35:
                    iZzi = zzlz.zzi((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 36:
                    iZzi = zzlz.zzg((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 37:
                    iZzi = zzlz.zzn((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 38:
                    iZzi = zzlz.zzy((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 39:
                    iZzi = zzlz.zzl((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 40:
                    iZzi = zzlz.zzi((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 41:
                    iZzi = zzlz.zzg((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    iZzi = zzlz.zzb((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZzi = zzlz.zzw((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZzi = zzlz.zze((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZzi = zzlz.zzg((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZzi = zzlz.zzi((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZzi = zzlz.zzr((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 48:
                    iZzi = zzlz.zzt((List) unsafe.getObject(obj, j11));
                    if (iZzi > 0) {
                        iZzz = zzjm.zzz(i18);
                        iZzA8 = zzjm.zzA(iZzi);
                        iZzA9 = iZzz + iZzA8;
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 49:
                    iZzu = zzlz.zzj(i18, (List) unsafe.getObject(obj, j11), zzE(i15));
                    iZzA15 += iZzu;
                    break;
                case 50:
                    zzlh.zza(i18, unsafe.getObject(obj, j11), zzF(i15));
                    break;
                case 51:
                    if (zzX(obj, i18, i15)) {
                        iZzA10 = zzjm.zzA(i18 << 3);
                        iZzu = iZzA10 + 8;
                        iZzA15 += iZzu;
                    }
                    break;
                case 52:
                    if (zzX(obj, i18, i15)) {
                        iZzA11 = zzjm.zzA(i18 << 3);
                        iZzu = iZzA11 + 4;
                        iZzA15 += iZzu;
                    }
                    break;
                case 53:
                    if (zzX(obj, i18, i15)) {
                        long jZzC = zzC(obj, j11);
                        iZzA12 = zzjm.zzA(i18 << 3);
                        iZzB2 = zzjm.zzB(jZzC);
                        iZzA15 += iZzA12 + iZzB2;
                    }
                    break;
                case 54:
                    if (zzX(obj, i18, i15)) {
                        long jZzC2 = zzC(obj, j11);
                        iZzA12 = zzjm.zzA(i18 << 3);
                        iZzB2 = zzjm.zzB(jZzC2);
                        iZzA15 += iZzA12 + iZzB2;
                    }
                    break;
                case 55:
                    if (zzX(obj, i18, i15)) {
                        int iZzr = zzr(obj, j11);
                        iZzA9 = zzjm.zzA(i18 << 3);
                        iZzi = zzjm.zzv(iZzr);
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 56:
                    if (zzX(obj, i18, i15)) {
                        iZzA10 = zzjm.zzA(i18 << 3);
                        iZzu = iZzA10 + 8;
                        iZzA15 += iZzu;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzX(obj, i18, i15)) {
                        iZzA11 = zzjm.zzA(i18 << 3);
                        iZzu = iZzA11 + 4;
                        iZzA15 += iZzu;
                    }
                    break;
                case 58:
                    if (zzX(obj, i18, i15)) {
                        iZzu = zzjm.zzA(i18 << 3) + 1;
                        iZzA15 += iZzu;
                    }
                    break;
                case 59:
                    if (zzX(obj, i18, i15)) {
                        Object object2 = unsafe.getObject(obj, j11);
                        if (object2 instanceof zzje) {
                            iZzA13 = zzjm.zzA(i18 << 3);
                            iZzd2 = ((zzje) object2).zzd();
                            iZzA14 = zzjm.zzA(iZzd2);
                            i13 = iZzA13 + iZzA14 + iZzd2;
                            iZzA15 += i13;
                        } else {
                            iZzA9 = zzjm.zzA(i18 << 3);
                            iZzi = zzjm.zzy((String) object2);
                            i13 = iZzA9 + iZzi;
                            iZzA15 += i13;
                        }
                    }
                    break;
                case 60:
                    if (zzX(obj, i18, i15)) {
                        iZzu = zzlz.zzo(i18, unsafe.getObject(obj, j11), zzE(i15));
                        iZzA15 += iZzu;
                    }
                    break;
                case 61:
                    if (zzX(obj, i18, i15)) {
                        zzje zzjeVar2 = (zzje) unsafe.getObject(obj, j11);
                        iZzA13 = zzjm.zzA(i18 << 3);
                        iZzd2 = zzjeVar2.zzd();
                        iZzA14 = zzjm.zzA(iZzd2);
                        i13 = iZzA13 + iZzA14 + iZzd2;
                        iZzA15 += i13;
                    }
                    break;
                case 62:
                    if (zzX(obj, i18, i15)) {
                        int iZzr2 = zzr(obj, j11);
                        iZzA9 = zzjm.zzA(i18 << 3);
                        iZzi = zzjm.zzA(iZzr2);
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 63:
                    if (zzX(obj, i18, i15)) {
                        int iZzr3 = zzr(obj, j11);
                        iZzA9 = zzjm.zzA(i18 << 3);
                        iZzi = zzjm.zzv(iZzr3);
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case 64:
                    if (zzX(obj, i18, i15)) {
                        iZzA11 = zzjm.zzA(i18 << 3);
                        iZzu = iZzA11 + 4;
                        iZzA15 += iZzu;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzX(obj, i18, i15)) {
                        iZzA10 = zzjm.zzA(i18 << 3);
                        iZzu = iZzA10 + 8;
                        iZzA15 += iZzu;
                    }
                    break;
                case 66:
                    if (zzX(obj, i18, i15)) {
                        int iZzr4 = zzr(obj, j11);
                        iZzA9 = zzjm.zzA(i18 << 3);
                        iZzi = zzjm.zzA((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i13 = iZzA9 + iZzi;
                        iZzA15 += i13;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzX(obj, i18, i15)) {
                        long jZzC3 = zzC(obj, j11);
                        iZzA15 += zzjm.zzA(i18 << 3) + zzjm.zzB((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                    }
                    break;
                case 68:
                    if (zzX(obj, i18, i15)) {
                        iZzu = zzjm.zzu(i18, (zzlm) unsafe.getObject(obj, j11), zzE(i15));
                        iZzA15 += iZzu;
                    }
                    break;
                default:
                    break;
            }
            i15 += 3;
            i14 = 1048575;
        }
        zzmo zzmoVar = this.zzn;
        int iZza = iZzA15 + zzmoVar.zza(zzmoVar.zzd(obj));
        if (!this.zzh) {
            return iZza;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final int zzq(Object obj) {
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzv;
        int iZzA5;
        int iZzA6;
        int iZzd;
        int iZzA7;
        int iZzo;
        int iZzz;
        int iZzA8;
        int i11;
        Unsafe unsafe = zzb;
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzc.length; i13 += 3) {
            int iZzB2 = zzB(i13);
            int iZzA9 = zzA(iZzB2);
            int i14 = this.zzc[i13];
            long j11 = iZzB2 & 1048575;
            if (iZzA9 >= zzjx.zzJ.zza() && iZzA9 <= zzjx.zzW.zza()) {
                int i15 = this.zzc[i13 + 2];
            }
            switch (iZzA9) {
                case 0:
                    if (zzT(obj, i13)) {
                        iZzA = zzjm.zzA(i14 << 3);
                        iZzo = iZzA + 8;
                        i12 += iZzo;
                    }
                    break;
                case 1:
                    if (zzT(obj, i13)) {
                        iZzA2 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA2 + 4;
                        i12 += iZzo;
                    }
                    break;
                case 2:
                    if (zzT(obj, i13)) {
                        long jZzd = zzmy.zzd(obj, j11);
                        iZzA3 = zzjm.zzA(i14 << 3);
                        iZzB = zzjm.zzB(jZzd);
                        i12 += iZzA3 + iZzB;
                    }
                    break;
                case 3:
                    if (zzT(obj, i13)) {
                        long jZzd2 = zzmy.zzd(obj, j11);
                        iZzA3 = zzjm.zzA(i14 << 3);
                        iZzB = zzjm.zzB(jZzd2);
                        i12 += iZzA3 + iZzB;
                    }
                    break;
                case 4:
                    if (zzT(obj, i13)) {
                        int iZzc = zzmy.zzc(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzv(iZzc);
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 5:
                    if (zzT(obj, i13)) {
                        iZzA = zzjm.zzA(i14 << 3);
                        iZzo = iZzA + 8;
                        i12 += iZzo;
                    }
                    break;
                case 6:
                    if (zzT(obj, i13)) {
                        iZzA2 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA2 + 4;
                        i12 += iZzo;
                    }
                    break;
                case 7:
                    if (zzT(obj, i13)) {
                        iZzA5 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA5 + 1;
                        i12 += iZzo;
                    }
                    break;
                case 8:
                    if (zzT(obj, i13)) {
                        Object objZzf = zzmy.zzf(obj, j11);
                        if (objZzf instanceof zzje) {
                            iZzA6 = zzjm.zzA(i14 << 3);
                            iZzd = ((zzje) objZzf).zzd();
                            iZzA7 = zzjm.zzA(iZzd);
                            i11 = iZzA6 + iZzA7 + iZzd;
                            i12 += i11;
                        } else {
                            iZzA4 = zzjm.zzA(i14 << 3);
                            iZzv = zzjm.zzy((String) objZzf);
                            i11 = iZzA4 + iZzv;
                            i12 += i11;
                        }
                    }
                    break;
                case 9:
                    if (zzT(obj, i13)) {
                        iZzo = zzlz.zzo(i14, zzmy.zzf(obj, j11), zzE(i13));
                        i12 += iZzo;
                    }
                    break;
                case 10:
                    if (zzT(obj, i13)) {
                        zzje zzjeVar = (zzje) zzmy.zzf(obj, j11);
                        iZzA6 = zzjm.zzA(i14 << 3);
                        iZzd = zzjeVar.zzd();
                        iZzA7 = zzjm.zzA(iZzd);
                        i11 = iZzA6 + iZzA7 + iZzd;
                        i12 += i11;
                    }
                    break;
                case 11:
                    if (zzT(obj, i13)) {
                        int iZzc2 = zzmy.zzc(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzA(iZzc2);
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 12:
                    if (zzT(obj, i13)) {
                        int iZzc3 = zzmy.zzc(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzv(iZzc3);
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 13:
                    if (zzT(obj, i13)) {
                        iZzA2 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA2 + 4;
                        i12 += iZzo;
                    }
                    break;
                case 14:
                    if (zzT(obj, i13)) {
                        iZzA = zzjm.zzA(i14 << 3);
                        iZzo = iZzA + 8;
                        i12 += iZzo;
                    }
                    break;
                case 15:
                    if (zzT(obj, i13)) {
                        int iZzc4 = zzmy.zzc(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzA((iZzc4 >> 31) ^ (iZzc4 + iZzc4));
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 16:
                    if (zzT(obj, i13)) {
                        long jZzd3 = zzmy.zzd(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzB((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 17:
                    if (zzT(obj, i13)) {
                        iZzo = zzjm.zzu(i14, (zzlm) zzmy.zzf(obj, j11), zzE(i13));
                        i12 += iZzo;
                    }
                    break;
                case 18:
                    iZzo = zzlz.zzh(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 19:
                    iZzo = zzlz.zzf(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 20:
                    iZzo = zzlz.zzm(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 21:
                    iZzo = zzlz.zzx(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 22:
                    iZzo = zzlz.zzk(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 23:
                    iZzo = zzlz.zzh(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 24:
                    iZzo = zzlz.zzf(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 25:
                    iZzo = zzlz.zza(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 26:
                    iZzo = zzlz.zzu(i14, (List) zzmy.zzf(obj, j11));
                    i12 += iZzo;
                    break;
                case 27:
                    iZzo = zzlz.zzp(i14, (List) zzmy.zzf(obj, j11), zzE(i13));
                    i12 += iZzo;
                    break;
                case 28:
                    iZzo = zzlz.zzc(i14, (List) zzmy.zzf(obj, j11));
                    i12 += iZzo;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    iZzo = zzlz.zzv(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 30:
                    iZzo = zzlz.zzd(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iZzo = zzlz.zzf(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 32:
                    iZzo = zzlz.zzh(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 33:
                    iZzo = zzlz.zzq(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 34:
                    iZzo = zzlz.zzs(i14, (List) zzmy.zzf(obj, j11), false);
                    i12 += iZzo;
                    break;
                case 35:
                    iZzv = zzlz.zzi((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 36:
                    iZzv = zzlz.zzg((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 37:
                    iZzv = zzlz.zzn((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 38:
                    iZzv = zzlz.zzy((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 39:
                    iZzv = zzlz.zzl((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 40:
                    iZzv = zzlz.zzi((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 41:
                    iZzv = zzlz.zzg((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    iZzv = zzlz.zzb((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZzv = zzlz.zzw((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZzv = zzlz.zze((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZzv = zzlz.zzg((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZzv = zzlz.zzi((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZzv = zzlz.zzr((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 48:
                    iZzv = zzlz.zzt((List) unsafe.getObject(obj, j11));
                    if (iZzv > 0) {
                        iZzz = zzjm.zzz(i14);
                        iZzA8 = zzjm.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 49:
                    iZzo = zzlz.zzj(i14, (List) zzmy.zzf(obj, j11), zzE(i13));
                    i12 += iZzo;
                    break;
                case 50:
                    zzlh.zza(i14, zzmy.zzf(obj, j11), zzF(i13));
                    break;
                case 51:
                    if (zzX(obj, i14, i13)) {
                        iZzA = zzjm.zzA(i14 << 3);
                        iZzo = iZzA + 8;
                        i12 += iZzo;
                    }
                    break;
                case 52:
                    if (zzX(obj, i14, i13)) {
                        iZzA2 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA2 + 4;
                        i12 += iZzo;
                    }
                    break;
                case 53:
                    if (zzX(obj, i14, i13)) {
                        long jZzC = zzC(obj, j11);
                        iZzA3 = zzjm.zzA(i14 << 3);
                        iZzB = zzjm.zzB(jZzC);
                        i12 += iZzA3 + iZzB;
                    }
                    break;
                case 54:
                    if (zzX(obj, i14, i13)) {
                        long jZzC2 = zzC(obj, j11);
                        iZzA3 = zzjm.zzA(i14 << 3);
                        iZzB = zzjm.zzB(jZzC2);
                        i12 += iZzA3 + iZzB;
                    }
                    break;
                case 55:
                    if (zzX(obj, i14, i13)) {
                        int iZzr = zzr(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzv(iZzr);
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 56:
                    if (zzX(obj, i14, i13)) {
                        iZzA = zzjm.zzA(i14 << 3);
                        iZzo = iZzA + 8;
                        i12 += iZzo;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzX(obj, i14, i13)) {
                        iZzA2 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA2 + 4;
                        i12 += iZzo;
                    }
                    break;
                case 58:
                    if (zzX(obj, i14, i13)) {
                        iZzA5 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA5 + 1;
                        i12 += iZzo;
                    }
                    break;
                case 59:
                    if (zzX(obj, i14, i13)) {
                        Object objZzf2 = zzmy.zzf(obj, j11);
                        if (objZzf2 instanceof zzje) {
                            iZzA6 = zzjm.zzA(i14 << 3);
                            iZzd = ((zzje) objZzf2).zzd();
                            iZzA7 = zzjm.zzA(iZzd);
                            i11 = iZzA6 + iZzA7 + iZzd;
                            i12 += i11;
                        } else {
                            iZzA4 = zzjm.zzA(i14 << 3);
                            iZzv = zzjm.zzy((String) objZzf2);
                            i11 = iZzA4 + iZzv;
                            i12 += i11;
                        }
                    }
                    break;
                case 60:
                    if (zzX(obj, i14, i13)) {
                        iZzo = zzlz.zzo(i14, zzmy.zzf(obj, j11), zzE(i13));
                        i12 += iZzo;
                    }
                    break;
                case 61:
                    if (zzX(obj, i14, i13)) {
                        zzje zzjeVar2 = (zzje) zzmy.zzf(obj, j11);
                        iZzA6 = zzjm.zzA(i14 << 3);
                        iZzd = zzjeVar2.zzd();
                        iZzA7 = zzjm.zzA(iZzd);
                        i11 = iZzA6 + iZzA7 + iZzd;
                        i12 += i11;
                    }
                    break;
                case 62:
                    if (zzX(obj, i14, i13)) {
                        int iZzr2 = zzr(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzA(iZzr2);
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 63:
                    if (zzX(obj, i14, i13)) {
                        int iZzr3 = zzr(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzv(iZzr3);
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 64:
                    if (zzX(obj, i14, i13)) {
                        iZzA2 = zzjm.zzA(i14 << 3);
                        iZzo = iZzA2 + 4;
                        i12 += iZzo;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzX(obj, i14, i13)) {
                        iZzA = zzjm.zzA(i14 << 3);
                        iZzo = iZzA + 8;
                        i12 += iZzo;
                    }
                    break;
                case 66:
                    if (zzX(obj, i14, i13)) {
                        int iZzr4 = zzr(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzA((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzX(obj, i14, i13)) {
                        long jZzC3 = zzC(obj, j11);
                        iZzA4 = zzjm.zzA(i14 << 3);
                        iZzv = zzjm.zzB((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i11 = iZzA4 + iZzv;
                        i12 += i11;
                    }
                    break;
                case 68:
                    if (zzX(obj, i14, i13)) {
                        iZzo = zzjm.zzu(i14, (zzlm) zzmy.zzf(obj, j11), zzE(i13));
                        i12 += iZzo;
                    }
                    break;
            }
        }
        zzmo zzmoVar = this.zzn;
        return i12 + zzmoVar.zza(zzmoVar.zzd(obj));
    }

    private static int zzr(Object obj, long j11) {
        return ((Integer) zzmy.zzf(obj, j11)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, zzir zzirVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzF = zzF(i13);
        Object object = unsafe.getObject(obj, j11);
        if (!((zzlg) object).zze()) {
            zzlg zzlgVarZzb = zzlg.zza().zzb();
            zzlh.zzb(zzlgVarZzb, object);
            unsafe.putObject(obj, j11, zzlgVarZzb);
        }
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzir zzirVar) throws IOException {
        Unsafe unsafe = zzb;
        long j12 = this.zzc[i18 + 2] & 1048575;
        switch (i17) {
            case 51:
                if (i15 != 1) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Double.valueOf(Double.longBitsToDouble(zzis.zzp(bArr, i11))));
                unsafe.putInt(obj, j12, i14);
                return i11 + 8;
            case 52:
                if (i15 != 5) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Float.valueOf(Float.intBitsToFloat(zzis.zzb(bArr, i11))));
                unsafe.putInt(obj, j12, i14);
                return i11 + 4;
            case 53:
            case 54:
                if (i15 != 0) {
                    return i11;
                }
                int iZzm = zzis.zzm(bArr, i11, zzirVar);
                unsafe.putObject(obj, j11, Long.valueOf(zzirVar.zzb));
                unsafe.putInt(obj, j12, i14);
                return iZzm;
            case 55:
            case 62:
                if (i15 != 0) {
                    return i11;
                }
                int iZzj = zzis.zzj(bArr, i11, zzirVar);
                unsafe.putObject(obj, j11, Integer.valueOf(zzirVar.zza));
                unsafe.putInt(obj, j12, i14);
                return iZzj;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i15 != 1) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Long.valueOf(zzis.zzp(bArr, i11)));
                unsafe.putInt(obj, j12, i14);
                return i11 + 8;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
            case 64:
                if (i15 != 5) {
                    return i11;
                }
                unsafe.putObject(obj, j11, Integer.valueOf(zzis.zzb(bArr, i11)));
                unsafe.putInt(obj, j12, i14);
                return i11 + 4;
            case 58:
                if (i15 != 0) {
                    return i11;
                }
                int iZzm2 = zzis.zzm(bArr, i11, zzirVar);
                unsafe.putObject(obj, j11, Boolean.valueOf(zzirVar.zzb != 0));
                unsafe.putInt(obj, j12, i14);
                return iZzm2;
            case 59:
                if (i15 != 2) {
                    return i11;
                }
                int iZzj2 = zzis.zzj(bArr, i11, zzirVar);
                int i19 = zzirVar.zza;
                if (i19 == 0) {
                    unsafe.putObject(obj, j11, "");
                } else {
                    if ((i16 & ASTNode.DISCARD) != 0 && !zznd.zzf(bArr, iZzj2, iZzj2 + i19)) {
                        throw zzkp.zzc();
                    }
                    unsafe.putObject(obj, j11, new String(bArr, iZzj2, i19, zzkn.zzb));
                    iZzj2 += i19;
                }
                unsafe.putInt(obj, j12, i14);
                return iZzj2;
            case 60:
                if (i15 != 2) {
                    return i11;
                }
                Object objZzH = zzH(obj, i14, i18);
                int iZzo = zzis.zzo(objZzH, zzE(i18), bArr, i11, i12, zzirVar);
                zzP(obj, i14, i18, objZzH);
                return iZzo;
            case 61:
                if (i15 != 2) {
                    return i11;
                }
                int iZza = zzis.zza(bArr, i11, zzirVar);
                unsafe.putObject(obj, j11, zzirVar.zzc);
                unsafe.putInt(obj, j12, i14);
                return iZza;
            case 63:
                if (i15 != 0) {
                    return i11;
                }
                int iZzj3 = zzis.zzj(bArr, i11, zzirVar);
                int i21 = zzirVar.zza;
                zzkj zzkjVarZzD = zzD(i18);
                if (zzkjVarZzD == null || zzkjVarZzD.zza(i21)) {
                    unsafe.putObject(obj, j11, Integer.valueOf(i21));
                    unsafe.putInt(obj, j12, i14);
                } else {
                    zzd(obj).zzj(i13, Long.valueOf(i21));
                }
                return iZzj3;
            case 66:
                if (i15 != 0) {
                    return i11;
                }
                int iZzj4 = zzis.zzj(bArr, i11, zzirVar);
                unsafe.putObject(obj, j11, Integer.valueOf(zzji.zzb(zzirVar.zza)));
                unsafe.putInt(obj, j12, i14);
                return iZzj4;
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                if (i15 != 0) {
                    return i11;
                }
                int iZzm3 = zzis.zzm(bArr, i11, zzirVar);
                unsafe.putObject(obj, j11, Long.valueOf(zzji.zzc(zzirVar.zzb)));
                unsafe.putInt(obj, j12, i14);
                return iZzm3;
            case 68:
                if (i15 != 3) {
                    return i11;
                }
                Object objZzH2 = zzH(obj, i14, i18);
                int iZzn = zzis.zzn(objZzH2, zzE(i18), bArr, i11, i12, (i13 & (-8)) | 4, zzirVar);
                zzP(obj, i14, i18, objZzH2);
                return iZzn;
            default:
                return i11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x029d A[PHI: r0 r19 r26 r27 r28
  0x029d: PHI (r0v21 int) = (r0v16 int), (r0v19 int), (r0v23 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r19v4 int) = (r19v2 int), (r19v2 int), (r19v5 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r27v3 int) = (r27v1 int), (r27v1 int), (r27v4 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r28v6 sun.misc.Unsafe) = (r28v4 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x02b3 A[PHI: r0 r19 r26 r27 r28
  0x02b3: PHI (r0v20 int) = (r0v16 int), (r0v19 int), (r0v23 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r19v3 int) = (r19v2 int), (r19v2 int), (r19v5 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r27v2 int) = (r27v1 int), (r27v1 int), (r27v4 int) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b3: PHI (r28v5 sun.misc.Unsafe) = (r28v4 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe) binds: [B:114:0x0304, B:110:0x02e4, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0088. Please report as an issue. */
    private final int zzu(Object obj, byte[] bArr, int i11, int i12, zzir zzirVar) throws IOException {
        int i13;
        int iZzk;
        int i14;
        int i15;
        Unsafe unsafe;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int iZza;
        int iZzm;
        this = this;
        obj = obj;
        bArr = bArr;
        i12 = i12;
        zzirVar = zzirVar;
        zzJ(obj);
        Unsafe unsafe2 = zzb;
        int i24 = 1048575;
        int i25 = -1;
        int iZzi = i11;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 1048575;
        while (iZzi < i12) {
            int i31 = iZzi + 1;
            byte b11 = bArr[iZzi];
            if (b11 < 0) {
                iZzk = zzis.zzk(b11, bArr, i31, zzirVar);
                i13 = zzirVar.zza;
            } else {
                i13 = b11;
                iZzk = i31;
            }
            int i32 = i13 >>> 3;
            int i33 = i13 & 7;
            int iZzx = i32 > i26 ? this.zzx(i32, i27 / 3) : this.zzw(i32);
            if (iZzx == i25) {
                i14 = iZzk;
                i15 = i32;
                unsafe = unsafe2;
                i16 = 0;
            } else {
                int[] iArr = this.zzc;
                int i34 = iArr[iZzx + 1];
                int iZzA = zzA(i34);
                long j11 = i34 & i24;
                if (iZzA <= 17) {
                    int i35 = iArr[iZzx + 2];
                    int i36 = 1 << (i35 >>> 20);
                    int i37 = 1048575;
                    int i38 = i35 & 1048575;
                    if (i38 != i29) {
                        if (i29 != 1048575) {
                            unsafe2.putInt(obj, i29, i28);
                            i37 = 1048575;
                        }
                        if (i38 != i37) {
                            i28 = unsafe2.getInt(obj, i38);
                        }
                        i29 = i38;
                    }
                    switch (iZzA) {
                        case 0:
                            i15 = i32;
                            i17 = iZzx;
                            i22 = iZzk;
                            i23 = i28;
                            if (i33 == 1) {
                                zzmy.zzo(obj, j11, Double.longBitsToDouble(zzis.zzp(bArr, i22)));
                                iZzi = i22 + 8;
                                i28 = i23 | i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 1:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            i22 = iZzk;
                            i23 = i28;
                            if (i33 == 5) {
                                zzmy.zzp(obj, j11, Float.intBitsToFloat(zzis.zzb(bArr, i22)));
                                iZzi = i22 + 4;
                                i28 = i23 | i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 2:
                        case 3:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            i22 = iZzk;
                            i23 = i28;
                            if (i33 != 0) {
                                i28 = i23;
                                unsafe = unsafe2;
                                i16 = i17;
                                i14 = i22;
                            } else {
                                iZzm = zzis.zzm(bArr, i22, zzirVar);
                                unsafe2.putLong(obj, j11, zzirVar.zzb);
                                i28 = i23 | i36;
                                i27 = i17;
                                iZzi = iZzm;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                                i12 = i12;
                            }
                            break;
                        case 4:
                        case 11:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            i22 = iZzk;
                            i23 = i28;
                            if (i33 == 0) {
                                iZzi = zzis.zzj(bArr, i22, zzirVar);
                                unsafe2.putInt(obj, j11, zzirVar.zza);
                                i28 = i23 | i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 5:
                        case 14:
                            i15 = i32;
                            i17 = iZzx;
                            i23 = i28;
                            if (i33 == 1) {
                                i22 = iZzk;
                                unsafe2.putLong(obj, j11, zzis.zzp(bArr, iZzk));
                                iZzi = i22 + 8;
                                i28 = i23 | i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 6:
                        case 13:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            i23 = i28;
                            if (i33 == 5) {
                                unsafe2.putInt(obj, j11, zzis.zzb(bArr, iZzk));
                                iZzi = iZzk + 4;
                                i28 = i23 | i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 7:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            i23 = i28;
                            if (i33 == 0) {
                                int iZzm2 = zzis.zzm(bArr, iZzk, zzirVar);
                                zzmy.zzm(obj, j11, zzirVar.zzb != 0);
                                i28 = i23 | i36;
                                iZzi = iZzm2;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 8:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            i23 = i28;
                            if (i33 == 2) {
                                iZzi = (536870912 & i34) == 0 ? zzis.zzg(bArr, iZzk, zzirVar) : zzis.zzh(bArr, iZzk, zzirVar);
                                unsafe2.putObject(obj, j11, zzirVar.zzc);
                                i28 = i23 | i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 9:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            if (i33 == 2) {
                                Object objZzG = this.zzG(obj, i17);
                                iZzi = zzis.zzo(objZzG, this.zzE(i17), bArr, iZzk, i12, zzirVar);
                                this.zzO(obj, i17, objZzG);
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i23 = i28;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 10:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            if (i33 == 2) {
                                iZza = zzis.zza(bArr, iZzk, zzirVar);
                                unsafe2.putObject(obj, j11, zzirVar.zzc);
                                i28 |= i36;
                                iZzi = iZza;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i23 = i28;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 12:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            if (i33 == 0) {
                                iZza = zzis.zzj(bArr, iZzk, zzirVar);
                                unsafe2.putInt(obj, j11, zzirVar.zza);
                                i28 |= i36;
                                iZzi = iZza;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i23 = i28;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 15:
                            i15 = i32;
                            zzirVar = zzirVar;
                            i17 = iZzx;
                            if (i33 == 0) {
                                iZzi = zzis.zzj(bArr, iZzk, zzirVar);
                                unsafe2.putInt(obj, j11, zzji.zzb(zzirVar.zza));
                                i28 |= i36;
                                i27 = i17;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                            }
                            i22 = iZzk;
                            i23 = i28;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                        case 16:
                            if (i33 != 0) {
                                i15 = i32;
                                i17 = iZzx;
                                i22 = iZzk;
                                i23 = i28;
                                i28 = i23;
                                unsafe = unsafe2;
                                i16 = i17;
                                i14 = i22;
                            } else {
                                zzirVar = zzirVar;
                                iZzm = zzis.zzm(bArr, iZzk, zzirVar);
                                i17 = iZzx;
                                i15 = i32;
                                unsafe2.putLong(obj, j11, zzji.zzc(zzirVar.zzb));
                                i28 |= i36;
                                i27 = i17;
                                iZzi = iZzm;
                                i26 = i15;
                                i25 = -1;
                                i24 = 1048575;
                                i12 = i12;
                            }
                            break;
                        default:
                            i15 = i32;
                            i17 = iZzx;
                            i22 = iZzk;
                            i23 = i28;
                            i28 = i23;
                            unsafe = unsafe2;
                            i16 = i17;
                            i14 = i22;
                            break;
                    }
                } else {
                    i15 = i32;
                    int i39 = i28;
                    zzirVar = zzirVar;
                    i17 = iZzx;
                    if (iZzA != 27) {
                        if (iZzA <= 49) {
                            int i40 = iZzk;
                            i19 = i29;
                            i21 = i39;
                            unsafe = unsafe2;
                            i16 = i17;
                            iZzi = zzv(obj, bArr, iZzk, i12, i13, i15, i33, i17, i34, iZzA, j11, zzirVar);
                            if (iZzi != i40) {
                                i27 = i16;
                                i26 = i15;
                                i29 = i19;
                                i28 = i21;
                            } else {
                                i14 = iZzi;
                                i29 = i19;
                                i28 = i21;
                            }
                            unsafe2 = unsafe;
                        } else {
                            i18 = iZzk;
                            i19 = i29;
                            i21 = i39;
                            unsafe = unsafe2;
                            i16 = i17;
                            if (iZzA == 50) {
                                if (i33 == 2) {
                                    iZzi = zzs(obj, bArr, i18, i12, i16, j11, zzirVar);
                                    if (iZzi != i18) {
                                        i27 = i16;
                                        i26 = i15;
                                        i29 = i19;
                                        i28 = i21;
                                    } else {
                                        i14 = iZzi;
                                    }
                                    unsafe2 = unsafe;
                                }
                                i29 = i19;
                                i28 = i21;
                            } else {
                                iZzi = zzt(obj, bArr, i18, i12, i13, i15, i33, i34, iZzA, j11, i16, zzirVar);
                                if (iZzi != i18) {
                                    i27 = i16;
                                    i26 = i15;
                                    i29 = i19;
                                    i28 = i21;
                                } else {
                                    i14 = iZzi;
                                    i29 = i19;
                                    i28 = i21;
                                }
                                unsafe2 = unsafe;
                            }
                        }
                        i25 = -1;
                        i24 = 1048575;
                    } else if (i33 == 2) {
                        zzkm zzkmVarZzd = (zzkm) unsafe2.getObject(obj, j11);
                        if (!zzkmVarZzd.zzc()) {
                            int size = zzkmVarZzd.size();
                            zzkmVarZzd = zzkmVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj, j11, zzkmVarZzd);
                        }
                        iZzi = zzis.zze(this.zzE(i17), i13, bArr, iZzk, i12, zzkmVarZzd, zzirVar);
                        i28 = i39;
                        i27 = i17;
                        i26 = i15;
                        i25 = -1;
                        i24 = 1048575;
                    } else {
                        i18 = iZzk;
                        i19 = i29;
                        i21 = i39;
                        unsafe = unsafe2;
                        i16 = i17;
                    }
                    i14 = i18;
                    i29 = i19;
                    i28 = i21;
                }
            }
            iZzi = zzis.zzi(i13, bArr, i14, i12, zzd(obj), zzirVar);
            i27 = i16;
            i26 = i15;
            unsafe2 = unsafe;
            i25 = -1;
            i24 = 1048575;
        }
        int i41 = i28;
        Unsafe unsafe3 = unsafe2;
        if (i29 != 1048575) {
            unsafe3.putInt(obj, i29, i41);
        }
        if (iZzi == i12) {
            return iZzi;
        }
        throw zzkp.zze();
    }

    private final int zzv(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, zzir zzirVar) throws IOException {
        int i18;
        int i19;
        int i21;
        int iZzj;
        int iZzj2 = i11;
        Unsafe unsafe = zzb;
        zzkm zzkmVarZzd = (zzkm) unsafe.getObject(obj, j12);
        if (!zzkmVarZzd.zzc()) {
            int size = zzkmVarZzd.size();
            zzkmVarZzd = zzkmVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j12, zzkmVarZzd);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i15 == 2) {
                    zzjo zzjoVar = (zzjo) zzkmVarZzd;
                    int iZzj3 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i22 = zzirVar.zza + iZzj3;
                    while (iZzj3 < i22) {
                        zzjoVar.zze(Double.longBitsToDouble(zzis.zzp(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i22) {
                        return iZzj3;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 1) {
                    zzjo zzjoVar2 = (zzjo) zzkmVarZzd;
                    zzjoVar2.zze(Double.longBitsToDouble(zzis.zzp(bArr, i11)));
                    while (true) {
                        int i23 = iZzj2 + 8;
                        if (i23 >= i12) {
                            return i23;
                        }
                        iZzj2 = zzis.zzj(bArr, i23, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return i23;
                        }
                        zzjoVar2.zze(Double.longBitsToDouble(zzis.zzp(bArr, iZzj2)));
                    }
                }
                return iZzj2;
            case 19:
            case 36:
                if (i15 == 2) {
                    zzjy zzjyVar = (zzjy) zzkmVarZzd;
                    int iZzj4 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i24 = zzirVar.zza + iZzj4;
                    while (iZzj4 < i24) {
                        zzjyVar.zze(Float.intBitsToFloat(zzis.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i24) {
                        return iZzj4;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 5) {
                    zzjy zzjyVar2 = (zzjy) zzkmVarZzd;
                    zzjyVar2.zze(Float.intBitsToFloat(zzis.zzb(bArr, i11)));
                    while (true) {
                        i18 = iZzj2 + 4;
                        if (i18 < i12) {
                            iZzj2 = zzis.zzj(bArr, i18, zzirVar);
                            if (i13 == zzirVar.zza) {
                                zzjyVar2.zze(Float.intBitsToFloat(zzis.zzb(bArr, iZzj2)));
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
                    zzlb zzlbVar = (zzlb) zzkmVarZzd;
                    int iZzj5 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i25 = zzirVar.zza + iZzj5;
                    while (iZzj5 < i25) {
                        iZzj5 = zzis.zzm(bArr, iZzj5, zzirVar);
                        zzlbVar.zzg(zzirVar.zzb);
                    }
                    if (iZzj5 == i25) {
                        return iZzj5;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 0) {
                    zzlb zzlbVar2 = (zzlb) zzkmVarZzd;
                    int iZzm = zzis.zzm(bArr, iZzj2, zzirVar);
                    zzlbVar2.zzg(zzirVar.zzb);
                    while (iZzm < i12) {
                        int iZzj6 = zzis.zzj(bArr, iZzm, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzis.zzm(bArr, iZzj6, zzirVar);
                        zzlbVar2.zzg(zzirVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 39:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                if (i15 == 2) {
                    return zzis.zzf(bArr, iZzj2, zzkmVarZzd, zzirVar);
                }
                if (i15 == 0) {
                    return zzis.zzl(i13, bArr, i11, i12, zzkmVarZzd, zzirVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                if (i15 == 2) {
                    zzlb zzlbVar3 = (zzlb) zzkmVarZzd;
                    int iZzj7 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i26 = zzirVar.zza + iZzj7;
                    while (iZzj7 < i26) {
                        zzlbVar3.zzg(zzis.zzp(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i26) {
                        return iZzj7;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 1) {
                    zzlb zzlbVar4 = (zzlb) zzkmVarZzd;
                    zzlbVar4.zzg(zzis.zzp(bArr, i11));
                    while (true) {
                        i19 = iZzj2 + 8;
                        if (i19 < i12) {
                            iZzj2 = zzis.zzj(bArr, i19, zzirVar);
                            if (i13 == zzirVar.zza) {
                                zzlbVar4.zzg(zzis.zzp(bArr, iZzj2));
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
                    zzkg zzkgVar = (zzkg) zzkmVarZzd;
                    int iZzj8 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i27 = zzirVar.zza + iZzj8;
                    while (iZzj8 < i27) {
                        zzkgVar.zzh(zzis.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i27) {
                        return iZzj8;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 5) {
                    zzkg zzkgVar2 = (zzkg) zzkmVarZzd;
                    zzkgVar2.zzh(zzis.zzb(bArr, i11));
                    while (true) {
                        i21 = iZzj2 + 4;
                        if (i21 < i12) {
                            iZzj2 = zzis.zzj(bArr, i21, zzirVar);
                            if (i13 == zzirVar.zza) {
                                zzkgVar2.zzh(zzis.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i21;
                }
                return iZzj2;
            case 25:
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                if (i15 == 2) {
                    zzit zzitVar = (zzit) zzkmVarZzd;
                    iZzj = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i28 = zzirVar.zza + iZzj;
                    while (iZzj < i28) {
                        iZzj = zzis.zzm(bArr, iZzj, zzirVar);
                        zzitVar.zze(zzirVar.zzb != 0);
                    }
                    if (iZzj != i28) {
                        throw zzkp.zzf();
                    }
                    return iZzj;
                }
                if (i15 == 0) {
                    zzit zzitVar2 = (zzit) zzkmVarZzd;
                    int iZzm2 = zzis.zzm(bArr, iZzj2, zzirVar);
                    zzitVar2.zze(zzirVar.zzb != 0);
                    while (iZzm2 < i12) {
                        int iZzj9 = zzis.zzj(bArr, iZzm2, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzis.zzm(bArr, iZzj9, zzirVar);
                        zzitVar2.zze(zzirVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i15 == 2) {
                    if ((j11 & 536870912) == 0) {
                        iZzj2 = zzis.zzj(bArr, iZzj2, zzirVar);
                        int i29 = zzirVar.zza;
                        if (i29 < 0) {
                            throw zzkp.zzd();
                        }
                        if (i29 == 0) {
                            zzkmVarZzd.add("");
                        } else {
                            zzkmVarZzd.add(new String(bArr, iZzj2, i29, zzkn.zzb));
                            iZzj2 += i29;
                        }
                        while (iZzj2 < i12) {
                            int iZzj10 = zzis.zzj(bArr, iZzj2, zzirVar);
                            if (i13 == zzirVar.zza) {
                                iZzj2 = zzis.zzj(bArr, iZzj10, zzirVar);
                                int i31 = zzirVar.zza;
                                if (i31 < 0) {
                                    throw zzkp.zzd();
                                }
                                if (i31 == 0) {
                                    zzkmVarZzd.add("");
                                } else {
                                    zzkmVarZzd.add(new String(bArr, iZzj2, i31, zzkn.zzb));
                                    iZzj2 += i31;
                                }
                            }
                        }
                    } else {
                        iZzj2 = zzis.zzj(bArr, iZzj2, zzirVar);
                        int i32 = zzirVar.zza;
                        if (i32 < 0) {
                            throw zzkp.zzd();
                        }
                        if (i32 == 0) {
                            zzkmVarZzd.add("");
                        } else {
                            int i33 = iZzj2 + i32;
                            if (!zznd.zzf(bArr, iZzj2, i33)) {
                                throw zzkp.zzc();
                            }
                            zzkmVarZzd.add(new String(bArr, iZzj2, i32, zzkn.zzb));
                            iZzj2 = i33;
                        }
                        while (iZzj2 < i12) {
                            int iZzj11 = zzis.zzj(bArr, iZzj2, zzirVar);
                            if (i13 == zzirVar.zza) {
                                iZzj2 = zzis.zzj(bArr, iZzj11, zzirVar);
                                int i34 = zzirVar.zza;
                                if (i34 < 0) {
                                    throw zzkp.zzd();
                                }
                                if (i34 == 0) {
                                    zzkmVarZzd.add("");
                                } else {
                                    int i35 = iZzj2 + i34;
                                    if (!zznd.zzf(bArr, iZzj2, i35)) {
                                        throw zzkp.zzc();
                                    }
                                    zzkmVarZzd.add(new String(bArr, iZzj2, i34, zzkn.zzb));
                                    iZzj2 = i35;
                                }
                            }
                        }
                    }
                }
                return iZzj2;
            case 27:
                if (i15 == 2) {
                    return zzis.zze(zzE(i16), i13, bArr, i11, i12, zzkmVarZzd, zzirVar);
                }
                return iZzj2;
            case 28:
                if (i15 == 2) {
                    int iZzj12 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i36 = zzirVar.zza;
                    if (i36 < 0) {
                        throw zzkp.zzd();
                    }
                    if (i36 > bArr.length - iZzj12) {
                        throw zzkp.zzf();
                    }
                    if (i36 == 0) {
                        zzkmVarZzd.add(zzje.zzb);
                    } else {
                        zzkmVarZzd.add(zzje.zzl(bArr, iZzj12, i36));
                        iZzj12 += i36;
                    }
                    while (iZzj12 < i12) {
                        int iZzj13 = zzis.zzj(bArr, iZzj12, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzis.zzj(bArr, iZzj13, zzirVar);
                        int i37 = zzirVar.zza;
                        if (i37 < 0) {
                            throw zzkp.zzd();
                        }
                        if (i37 > bArr.length - iZzj12) {
                            throw zzkp.zzf();
                        }
                        if (i37 == 0) {
                            zzkmVarZzd.add(zzje.zzb);
                        } else {
                            zzkmVarZzd.add(zzje.zzl(bArr, iZzj12, i37));
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
                        iZzj = zzis.zzl(i13, bArr, i11, i12, zzkmVarZzd, zzirVar);
                    }
                    return iZzj2;
                }
                iZzj = zzis.zzf(bArr, iZzj2, zzkmVarZzd, zzirVar);
                zzlz.zzC(obj, i14, zzkmVarZzd, zzD(i16), null, this.zzn);
                return iZzj;
            case 33:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                if (i15 == 2) {
                    zzkg zzkgVar3 = (zzkg) zzkmVarZzd;
                    int iZzj14 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i38 = zzirVar.zza + iZzj14;
                    while (iZzj14 < i38) {
                        iZzj14 = zzis.zzj(bArr, iZzj14, zzirVar);
                        zzkgVar3.zzh(zzji.zzb(zzirVar.zza));
                    }
                    if (iZzj14 == i38) {
                        return iZzj14;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 0) {
                    zzkg zzkgVar4 = (zzkg) zzkmVarZzd;
                    int iZzj15 = zzis.zzj(bArr, iZzj2, zzirVar);
                    zzkgVar4.zzh(zzji.zzb(zzirVar.zza));
                    while (iZzj15 < i12) {
                        int iZzj16 = zzis.zzj(bArr, iZzj15, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return iZzj15;
                        }
                        iZzj15 = zzis.zzj(bArr, iZzj16, zzirVar);
                        zzkgVar4.zzh(zzji.zzb(zzirVar.zza));
                    }
                    return iZzj15;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i15 == 2) {
                    zzlb zzlbVar5 = (zzlb) zzkmVarZzd;
                    int iZzj17 = zzis.zzj(bArr, iZzj2, zzirVar);
                    int i39 = zzirVar.zza + iZzj17;
                    while (iZzj17 < i39) {
                        iZzj17 = zzis.zzm(bArr, iZzj17, zzirVar);
                        zzlbVar5.zzg(zzji.zzc(zzirVar.zzb));
                    }
                    if (iZzj17 == i39) {
                        return iZzj17;
                    }
                    throw zzkp.zzf();
                }
                if (i15 == 0) {
                    zzlb zzlbVar6 = (zzlb) zzkmVarZzd;
                    int iZzm3 = zzis.zzm(bArr, iZzj2, zzirVar);
                    zzlbVar6.zzg(zzji.zzc(zzirVar.zzb));
                    while (iZzm3 < i12) {
                        int iZzj18 = zzis.zzj(bArr, iZzm3, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzis.zzm(bArr, iZzj18, zzirVar);
                        zzlbVar6.zzg(zzji.zzc(zzirVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i15 == 3) {
                    zzlx zzlxVarZzE = zzE(i16);
                    int i40 = (i13 & (-8)) | 4;
                    int iZzc = zzis.zzc(zzlxVarZzE, bArr, i11, i12, i40, zzirVar);
                    zzkmVarZzd.add(zzirVar.zzc);
                    while (iZzc < i12) {
                        int iZzj19 = zzis.zzj(bArr, iZzc, zzirVar);
                        if (i13 != zzirVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzis.zzc(zzlxVarZzE, bArr, iZzj19, i12, i40, zzirVar);
                        zzkmVarZzd.add(zzirVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzw(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzz(i11, 0);
    }

    private final int zzx(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzz(i11, i12);
    }

    private final int zzy(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzz(int i11, int i12) {
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

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zzb(Object obj) {
        int i11;
        int iZzc;
        int length = this.zzc.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iZzB = zzB(i13);
            int i14 = this.zzc[i13];
            long j11 = 1048575 & iZzB;
            int iHashCode = 37;
            switch (zzA(iZzB)) {
                case 0:
                    i11 = i12 * 53;
                    iZzc = zzkn.zzc(Double.doubleToLongBits(zzmy.zza(obj, j11)));
                    i12 = i11 + iZzc;
                    break;
                case 1:
                    i11 = i12 * 53;
                    iZzc = Float.floatToIntBits(zzmy.zzb(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 2:
                    i11 = i12 * 53;
                    iZzc = zzkn.zzc(zzmy.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 3:
                    i11 = i12 * 53;
                    iZzc = zzkn.zzc(zzmy.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 4:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 5:
                    i11 = i12 * 53;
                    iZzc = zzkn.zzc(zzmy.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 6:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 7:
                    i11 = i12 * 53;
                    iZzc = zzkn.zza(zzmy.zzw(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 8:
                    i11 = i12 * 53;
                    iZzc = ((String) zzmy.zzf(obj, j11)).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 9:
                    Object objZzf = zzmy.zzf(obj, j11);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 10:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzf(obj, j11).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 11:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 12:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 13:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 14:
                    i11 = i12 * 53;
                    iZzc = zzkn.zzc(zzmy.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 15:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzc(obj, j11);
                    i12 = i11 + iZzc;
                    break;
                case 16:
                    i11 = i12 * 53;
                    iZzc = zzkn.zzc(zzmy.zzd(obj, j11));
                    i12 = i11 + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzmy.zzf(obj, j11);
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
                    iZzc = zzmy.zzf(obj, j11).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 50:
                    i11 = i12 * 53;
                    iZzc = zzmy.zzf(obj, j11).hashCode();
                    i12 = i11 + iZzc;
                    break;
                case 51:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zzc(Double.doubleToLongBits(zzn(obj, j11)));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 52:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = Float.floatToIntBits(zzo(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 53:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zzc(zzC(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 54:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zzc(zzC(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 55:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzr(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 56:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zzc(zzC(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzr(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 58:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zza(zzY(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 59:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = ((String) zzmy.zzf(obj, j11)).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
                case 60:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzmy.zzf(obj, j11).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
                case 61:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzmy.zzf(obj, j11).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
                case 62:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzr(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 63:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzr(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case 64:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzr(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zzc(zzC(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 66:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzr(obj, j11);
                        i12 = i11 + iZzc;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzkn.zzc(zzC(obj, j11));
                        i12 = i11 + iZzc;
                    }
                    break;
                case 68:
                    if (zzX(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iZzc = zzmy.zzf(obj, j11).hashCode();
                        i12 = i11 + iZzc;
                    }
                    break;
            }
        }
        int iHashCode2 = (i12 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    public final int zzc(Object obj, byte[] bArr, int i11, int i12, int i13, zzir zzirVar) throws IOException {
        Unsafe unsafe;
        Object obj2;
        zzlp<T> zzlpVar;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        zzir zzirVar2;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        zzlp<T> zzlpVar2 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        i12 = i12;
        int i27 = i13;
        zzir zzirVar3 = zzirVar;
        zzJ(obj);
        Unsafe unsafe2 = zzb;
        int iZzi = i11;
        int i28 = 0;
        int i29 = -1;
        int i31 = 0;
        int i32 = 0;
        int i33 = 1048575;
        while (true) {
            if (iZzi < i12) {
                int i34 = iZzi + 1;
                byte b11 = bArr2[iZzi];
                if (b11 < 0) {
                    int iZzk = zzis.zzk(b11, bArr2, i34, zzirVar3);
                    i14 = zzirVar3.zza;
                    i34 = iZzk;
                } else {
                    i14 = b11;
                }
                int i35 = i14 >>> 3;
                int i36 = i14 & 7;
                int iZzx = i35 > i29 ? zzlpVar2.zzx(i35, i31 / 3) : zzlpVar2.zzw(i35);
                if (iZzx == -1) {
                    i15 = i35;
                    i16 = i34;
                    i17 = i14;
                    i18 = i32;
                    unsafe = unsafe2;
                    i13 = i27;
                    i19 = 0;
                } else {
                    int[] iArr = zzlpVar2.zzc;
                    int i37 = iArr[iZzx + 1];
                    int iZzA = zzA(i37);
                    int i38 = i34;
                    long j11 = i37 & 1048575;
                    int i39 = i14;
                    if (iZzA <= 17) {
                        int i40 = iArr[iZzx + 2];
                        int i41 = 1 << (i40 >>> 20);
                        int i42 = i40 & 1048575;
                        if (i42 != i33) {
                            if (i33 != 1048575) {
                                unsafe2.putInt(obj3, i33, i32);
                            }
                            i33 = i42;
                            i18 = unsafe2.getInt(obj3, i42);
                        } else {
                            i18 = i32;
                            i33 = i33;
                        }
                        switch (iZzA) {
                            case 0:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                bArr2 = bArr;
                                if (i36 == 1) {
                                    zzmy.zzo(obj3, j11, Double.longBitsToDouble(zzis.zzp(bArr2, i23)));
                                    iZzi = i23 + 8;
                                    i32 = i18 | i41;
                                    i29 = i21;
                                    i31 = i22;
                                    i28 = i39;
                                    i27 = i13;
                                } else {
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 1:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                bArr2 = bArr;
                                if (i36 == 5) {
                                    zzmy.zzp(obj3, j11, Float.intBitsToFloat(zzis.zzb(bArr2, i23)));
                                    iZzi = i23 + 4;
                                    i32 = i18 | i41;
                                    i29 = i21;
                                    i31 = i22;
                                    i28 = i39;
                                    i27 = i13;
                                } else {
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 2:
                            case 3:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                bArr2 = bArr;
                                if (i36 == 0) {
                                    int iZzm = zzis.zzm(bArr2, i23, zzirVar3);
                                    unsafe2.putLong(obj, j11, zzirVar3.zzb);
                                    i32 = i18 | i41;
                                    iZzi = iZzm;
                                    i29 = i21;
                                    i31 = i22;
                                    i28 = i39;
                                    i27 = i13;
                                } else {
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 4:
                            case 11:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                bArr2 = bArr;
                                if (i36 == 0) {
                                    iZzi = zzis.zzj(bArr2, i23, zzirVar3);
                                    unsafe2.putInt(obj3, j11, zzirVar3.zza);
                                    i32 = i18 | i41;
                                    i29 = i21;
                                    i31 = i22;
                                    i28 = i39;
                                    i27 = i13;
                                } else {
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 5:
                            case 14:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i24 = i39;
                                bArr2 = bArr;
                                if (i36 == 1) {
                                    i39 = i24;
                                    unsafe2.putLong(obj, j11, zzis.zzp(bArr2, i23));
                                    iZzi = i23 + 8;
                                    i32 = i18 | i41;
                                    i29 = i21;
                                    i31 = i22;
                                    i28 = i39;
                                    i27 = i13;
                                } else {
                                    i39 = i24;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 6:
                            case 13:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i24 = i39;
                                bArr2 = bArr;
                                if (i36 == 5) {
                                    unsafe2.putInt(obj3, j11, zzis.zzb(bArr2, i23));
                                    iZzi = i23 + 4;
                                    i29 = i21;
                                    i31 = i22;
                                    i33 = i33;
                                    i12 = i12;
                                    i27 = i13;
                                    int i43 = i24;
                                    i32 = i18 | i41;
                                    i28 = i43;
                                } else {
                                    i39 = i24;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 7:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i24 = i39;
                                bArr2 = bArr;
                                if (i36 == 0) {
                                    iZzi = zzis.zzm(bArr2, i23, zzirVar3);
                                    zzmy.zzm(obj3, j11, zzirVar3.zzb != 0);
                                    i29 = i21;
                                    i31 = i22;
                                    i33 = i33;
                                    i12 = i12;
                                    i27 = i13;
                                    int i44 = i24;
                                    i32 = i18 | i41;
                                    i28 = i44;
                                } else {
                                    i39 = i24;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 8:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i24 = i39;
                                bArr2 = bArr;
                                if (i36 == 2) {
                                    iZzi = (536870912 & i37) == 0 ? zzis.zzg(bArr2, i23, zzirVar3) : zzis.zzh(bArr2, i23, zzirVar3);
                                    unsafe2.putObject(obj3, j11, zzirVar3.zzc);
                                    i29 = i21;
                                    i31 = i22;
                                    i33 = i33;
                                    i12 = i12;
                                    i27 = i13;
                                    int i45 = i24;
                                    i32 = i18 | i41;
                                    i28 = i45;
                                } else {
                                    i39 = i24;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i25 = i39;
                                if (i36 == 2) {
                                    Object objZzG = zzlpVar2.zzG(obj3, i22);
                                    iZzi = zzis.zzo(objZzG, zzlpVar2.zzE(i22), bArr, i23, i12, zzirVar);
                                    zzlpVar2.zzO(obj3, i22, objZzG);
                                    i32 = i18 | i41;
                                    i28 = i25;
                                    i29 = i21;
                                    i31 = i22;
                                    i27 = i13;
                                } else {
                                    i39 = i25;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 10:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i25 = i39;
                                bArr2 = bArr;
                                if (i36 == 2) {
                                    iZzi = zzis.zza(bArr2, i23, zzirVar3);
                                    unsafe2.putObject(obj3, j11, zzirVar3.zzc);
                                    i32 = i18 | i41;
                                    i28 = i25;
                                    i29 = i21;
                                    i31 = i22;
                                    i27 = i13;
                                } else {
                                    i39 = i25;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 12:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i25 = i39;
                                bArr2 = bArr;
                                if (i36 == 0) {
                                    iZzi = zzis.zzj(bArr2, i23, zzirVar3);
                                    int i46 = zzirVar3.zza;
                                    zzkj zzkjVarZzD = zzlpVar2.zzD(i22);
                                    if (zzkjVarZzD == null || zzkjVarZzD.zza(i46)) {
                                        unsafe2.putInt(obj3, j11, i46);
                                        i32 = i18 | i41;
                                        i28 = i25;
                                        i29 = i21;
                                        i31 = i22;
                                    } else {
                                        zzd(obj).zzj(i25, Long.valueOf(i46));
                                        i28 = i25;
                                        i29 = i21;
                                        i31 = i22;
                                        i32 = i18;
                                    }
                                    i27 = i13;
                                } else {
                                    i39 = i25;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 15:
                                i21 = i35;
                                i22 = iZzx;
                                i23 = i38;
                                i25 = i39;
                                bArr2 = bArr;
                                if (i36 == 0) {
                                    iZzi = zzis.zzj(bArr2, i23, zzirVar3);
                                    unsafe2.putInt(obj3, j11, zzji.zzb(zzirVar3.zza));
                                    i32 = i18 | i41;
                                    i28 = i25;
                                    i29 = i21;
                                    i31 = i22;
                                    i27 = i13;
                                } else {
                                    i39 = i25;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            case 16:
                                i21 = i35;
                                i23 = i38;
                                i25 = i39;
                                if (i36 == 0) {
                                    bArr2 = bArr;
                                    int iZzm2 = zzis.zzm(bArr2, i23, zzirVar3);
                                    i22 = iZzx;
                                    unsafe2.putLong(obj, j11, zzji.zzc(zzirVar3.zzb));
                                    i32 = i18 | i41;
                                    iZzi = iZzm2;
                                    i28 = i25;
                                    i29 = i21;
                                    i31 = i22;
                                    i27 = i13;
                                } else {
                                    i22 = iZzx;
                                    i39 = i25;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                            default:
                                if (i36 == 3) {
                                    Object objZzG2 = zzlpVar2.zzG(obj3, iZzx);
                                    iZzi = zzis.zzn(objZzG2, zzlpVar2.zzE(iZzx), bArr, i38, i12, (i35 << 3) | 4, zzirVar);
                                    zzlpVar2.zzO(obj3, iZzx, objZzG2);
                                    i32 = i18 | i41;
                                    i31 = iZzx;
                                    i29 = i35;
                                    i28 = i39;
                                    bArr2 = bArr;
                                    i27 = i13;
                                } else {
                                    i21 = i35;
                                    i23 = i38;
                                    i22 = iZzx;
                                    i16 = i23;
                                    unsafe = unsafe2;
                                    i15 = i21;
                                    i19 = i22;
                                    i17 = i39;
                                    i33 = i33;
                                }
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (iZzA != 27) {
                            i18 = i32;
                            i33 = i33;
                            if (iZzA <= 49) {
                                i15 = i35;
                                unsafe = unsafe2;
                                i19 = iZzx;
                                iZzi = zzv(obj, bArr, i38, i12, i39, i15, i36, iZzx, i37, iZzA, j11, zzirVar);
                                if (iZzi != i38) {
                                    zzlpVar2 = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    i29 = i15;
                                    i12 = i12;
                                    i27 = i13;
                                    zzirVar3 = zzirVar;
                                    i31 = i19;
                                    i28 = i39;
                                    i32 = i18;
                                    i33 = i33;
                                    unsafe2 = unsafe;
                                } else {
                                    i16 = iZzi;
                                    i17 = i39;
                                    i33 = i33;
                                }
                            } else {
                                i26 = i38;
                                i15 = i35;
                                unsafe = unsafe2;
                                i19 = iZzx;
                                if (iZzA != 50) {
                                    iZzi = zzt(obj, bArr, i26, i12, i39, i15, i36, i37, iZzA, j11, i19, zzirVar);
                                    if (iZzi != i26) {
                                        zzlpVar2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i29 = i15;
                                        i12 = i12;
                                        i27 = i13;
                                        zzirVar3 = zzirVar;
                                        i31 = i19;
                                        i28 = i39;
                                        i32 = i18;
                                        i33 = i33;
                                        unsafe2 = unsafe;
                                    } else {
                                        i16 = iZzi;
                                        i17 = i39;
                                        i33 = i33;
                                    }
                                } else if (i36 == 2) {
                                    iZzi = zzs(obj, bArr, i26, i12, i19, j11, zzirVar);
                                    if (iZzi != i26) {
                                        zzlpVar2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i29 = i15;
                                        i12 = i12;
                                        i27 = i13;
                                        zzirVar3 = zzirVar;
                                        i31 = i19;
                                        i28 = i39;
                                        i32 = i18;
                                        i33 = i33;
                                        unsafe2 = unsafe;
                                    } else {
                                        i16 = iZzi;
                                        i17 = i39;
                                        i33 = i33;
                                    }
                                } else {
                                    i16 = i26;
                                    i17 = i39;
                                    i33 = i33;
                                }
                            }
                        } else if (i36 == 2) {
                            zzkm zzkmVarZzd = (zzkm) unsafe2.getObject(obj3, j11);
                            if (!zzkmVarZzd.zzc()) {
                                int size = zzkmVarZzd.size();
                                zzkmVarZzd = zzkmVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j11, zzkmVarZzd);
                            }
                            i28 = i39;
                            iZzi = zzis.zze(zzlpVar2.zzE(iZzx), i28, bArr, i38, i12, zzkmVarZzd, zzirVar);
                            i27 = i13;
                            i29 = i35;
                            i31 = iZzx;
                            i32 = i32;
                            i33 = i33;
                            i12 = i12;
                        } else {
                            i18 = i32;
                            i33 = i33;
                            i15 = i35;
                            i26 = i38;
                            unsafe = unsafe2;
                            i19 = iZzx;
                            i16 = i26;
                            i17 = i39;
                            i33 = i33;
                        }
                    }
                }
                if (i17 != i13 || i13 == 0) {
                    if (this.zzh) {
                        zzirVar2 = zzirVar;
                        zzjr zzjrVar = zzirVar2.zzd;
                        if (zzjrVar != zzjr.zza) {
                            i15 = i15;
                            if (zzjrVar.zzb(this.zzg, i15) != null) {
                                throw null;
                            }
                            iZzi = zzis.zzi(i17, bArr, i16, i12, zzd(obj), zzirVar);
                            obj = obj;
                        }
                        i12 = i12;
                        i28 = i17;
                        zzlpVar2 = this;
                        zzirVar3 = zzirVar2;
                        i29 = i15;
                        obj3 = obj;
                        i31 = i19;
                        i32 = i18;
                        unsafe2 = unsafe;
                        bArr2 = bArr;
                        i27 = i13;
                    } else {
                        zzirVar2 = zzirVar;
                    }
                    iZzi = zzis.zzi(i17, bArr, i16, i12, zzd(obj), zzirVar);
                    i12 = i12;
                    i28 = i17;
                    zzlpVar2 = this;
                    zzirVar3 = zzirVar2;
                    i29 = i15;
                    obj3 = obj;
                    i31 = i19;
                    i32 = i18;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i27 = i13;
                } else {
                    zzlpVar = this;
                    obj2 = obj;
                    iZzi = i16;
                    i28 = i17;
                    i32 = i18;
                }
            } else {
                unsafe = unsafe2;
                i13 = i27;
                obj2 = obj3;
                zzlpVar = zzlpVar2;
            }
        }
        if (i33 != 1048575) {
            unsafe.putInt(obj2, i33, i32);
        }
        for (int i47 = zzlpVar.zzk; i47 < zzlpVar.zzl; i47++) {
            int i48 = zzlpVar.zzj[i47];
            int i49 = zzlpVar.zzc[i48];
            Object objZzf = zzmy.zzf(obj2, zzlpVar.zzB(i48) & 1048575);
            if (objZzf != null && zzlpVar.zzD(i48) != null) {
                throw null;
            }
        }
        if (i13 == 0) {
            if (iZzi != i12) {
                throw zzkp.zze();
            }
        } else if (iZzi > i12 || i28 != i13) {
            throw zzkp.zze();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final Object zze() {
        return ((zzkf) this.zzg).zzbA();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzf(Object obj) {
        if (zzW(obj)) {
            if (obj instanceof zzkf) {
                zzkf zzkfVar = (zzkf) obj;
                zzkfVar.zzbM(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                zzkfVar.zzb = 0;
                zzkfVar.zzbK();
            }
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int iZzB = zzB(i11);
                long j11 = 1048575 & iZzB;
                int iZzA = zzA(iZzB);
                if (iZzA != 9) {
                    switch (iZzA) {
                        case 17:
                            if (zzT(obj, i11)) {
                                zzE(i11).zzf(zzb.getObject(obj, j11));
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
                            this.zzm.zza(obj, j11);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j11);
                            if (object != null) {
                                ((zzlg) object).zzc();
                                unsafe.putObject(obj, j11, object);
                            }
                            break;
                    }
                } else if (zzT(obj, i11)) {
                    zzE(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzg(obj);
            if (this.zzh) {
                this.zzo.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzg(Object obj, Object obj2) {
        zzJ(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzB = zzB(i11);
            long j11 = 1048575 & iZzB;
            int i12 = this.zzc[i11];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzT(obj2, i11)) {
                        zzmy.zzo(obj, j11, zzmy.zza(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 1:
                    if (zzT(obj2, i11)) {
                        zzmy.zzp(obj, j11, zzmy.zzb(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 2:
                    if (zzT(obj2, i11)) {
                        zzmy.zzr(obj, j11, zzmy.zzd(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 3:
                    if (zzT(obj2, i11)) {
                        zzmy.zzr(obj, j11, zzmy.zzd(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 4:
                    if (zzT(obj2, i11)) {
                        zzmy.zzq(obj, j11, zzmy.zzc(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 5:
                    if (zzT(obj2, i11)) {
                        zzmy.zzr(obj, j11, zzmy.zzd(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 6:
                    if (zzT(obj2, i11)) {
                        zzmy.zzq(obj, j11, zzmy.zzc(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 7:
                    if (zzT(obj2, i11)) {
                        zzmy.zzm(obj, j11, zzmy.zzw(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 8:
                    if (zzT(obj2, i11)) {
                        zzmy.zzs(obj, j11, zzmy.zzf(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 9:
                    zzK(obj, obj2, i11);
                    break;
                case 10:
                    if (zzT(obj2, i11)) {
                        zzmy.zzs(obj, j11, zzmy.zzf(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 11:
                    if (zzT(obj2, i11)) {
                        zzmy.zzq(obj, j11, zzmy.zzc(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 12:
                    if (zzT(obj2, i11)) {
                        zzmy.zzq(obj, j11, zzmy.zzc(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 13:
                    if (zzT(obj2, i11)) {
                        zzmy.zzq(obj, j11, zzmy.zzc(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 14:
                    if (zzT(obj2, i11)) {
                        zzmy.zzr(obj, j11, zzmy.zzd(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 15:
                    if (zzT(obj2, i11)) {
                        zzmy.zzq(obj, j11, zzmy.zzc(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 16:
                    if (zzT(obj2, i11)) {
                        zzmy.zzr(obj, j11, zzmy.zzd(obj2, j11));
                        zzM(obj, i11);
                    }
                    break;
                case 17:
                    zzK(obj, obj2, i11);
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
                    this.zzm.zzb(obj, obj2, j11);
                    break;
                case 50:
                    zzlz.zzaa(this.zzq, obj, obj2, j11);
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
                    if (zzX(obj2, i12, i11)) {
                        zzmy.zzs(obj, j11, zzmy.zzf(obj2, j11));
                        zzN(obj, i12, i11);
                    }
                    break;
                case 60:
                    zzL(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzX(obj2, i12, i11)) {
                        zzmy.zzs(obj, j11, zzmy.zzf(obj2, j11));
                        zzN(obj, i12, i11);
                    }
                    break;
                case 68:
                    zzL(obj, obj2, i11);
                    break;
            }
        }
        zzlz.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzlz.zzE(this.zzo, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzh(Object obj, byte[] bArr, int i11, int i12, zzir zzirVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i11, i12, zzirVar);
        } else {
            zzc(obj, bArr, i11, i12, 0, zzirVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzi(Object obj, zzng zzngVar) throws IOException {
        if (!this.zzi) {
            zzQ(obj, zzngVar);
            return;
        }
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int iZzB = zzB(i11);
            int i12 = this.zzc[i11];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzT(obj, i11)) {
                        zzngVar.zzf(i12, zzmy.zza(obj, iZzB & 1048575));
                    }
                    break;
                case 1:
                    if (zzT(obj, i11)) {
                        zzngVar.zzo(i12, zzmy.zzb(obj, iZzB & 1048575));
                    }
                    break;
                case 2:
                    if (zzT(obj, i11)) {
                        zzngVar.zzt(i12, zzmy.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 3:
                    if (zzT(obj, i11)) {
                        zzngVar.zzJ(i12, zzmy.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 4:
                    if (zzT(obj, i11)) {
                        zzngVar.zzr(i12, zzmy.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 5:
                    if (zzT(obj, i11)) {
                        zzngVar.zzm(i12, zzmy.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 6:
                    if (zzT(obj, i11)) {
                        zzngVar.zzk(i12, zzmy.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 7:
                    if (zzT(obj, i11)) {
                        zzngVar.zzb(i12, zzmy.zzw(obj, iZzB & 1048575));
                    }
                    break;
                case 8:
                    if (zzT(obj, i11)) {
                        zzZ(i12, zzmy.zzf(obj, iZzB & 1048575), zzngVar);
                    }
                    break;
                case 9:
                    if (zzT(obj, i11)) {
                        zzngVar.zzv(i12, zzmy.zzf(obj, iZzB & 1048575), zzE(i11));
                    }
                    break;
                case 10:
                    if (zzT(obj, i11)) {
                        zzngVar.zzd(i12, (zzje) zzmy.zzf(obj, iZzB & 1048575));
                    }
                    break;
                case 11:
                    if (zzT(obj, i11)) {
                        zzngVar.zzH(i12, zzmy.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 12:
                    if (zzT(obj, i11)) {
                        zzngVar.zzi(i12, zzmy.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 13:
                    if (zzT(obj, i11)) {
                        zzngVar.zzw(i12, zzmy.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 14:
                    if (zzT(obj, i11)) {
                        zzngVar.zzy(i12, zzmy.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 15:
                    if (zzT(obj, i11)) {
                        zzngVar.zzA(i12, zzmy.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 16:
                    if (zzT(obj, i11)) {
                        zzngVar.zzC(i12, zzmy.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 17:
                    if (zzT(obj, i11)) {
                        zzngVar.zzq(i12, zzmy.zzf(obj, iZzB & 1048575), zzE(i11));
                    }
                    break;
                case 18:
                    zzlz.zzJ(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 19:
                    zzlz.zzN(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 20:
                    zzlz.zzQ(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 21:
                    zzlz.zzY(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 22:
                    zzlz.zzP(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 23:
                    zzlz.zzM(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 24:
                    zzlz.zzL(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 25:
                    zzlz.zzH(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 26:
                    zzlz.zzW(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar);
                    break;
                case 27:
                    zzlz.zzR(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, zzE(i11));
                    break;
                case 28:
                    zzlz.zzI(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    zzlz.zzX(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 30:
                    zzlz.zzK(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    zzlz.zzS(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 32:
                    zzlz.zzT(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 33:
                    zzlz.zzU(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 34:
                    zzlz.zzV(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, false);
                    break;
                case 35:
                    zzlz.zzJ(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 36:
                    zzlz.zzN(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 37:
                    zzlz.zzQ(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 38:
                    zzlz.zzY(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 39:
                    zzlz.zzP(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 40:
                    zzlz.zzM(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 41:
                    zzlz.zzL(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzlz.zzH(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzlz.zzX(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzlz.zzK(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzlz.zzS(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzlz.zzT(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzlz.zzU(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 48:
                    zzlz.zzV(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, true);
                    break;
                case 49:
                    zzlz.zzO(i12, (List) zzmy.zzf(obj, iZzB & 1048575), zzngVar, zzE(i11));
                    break;
                case 50:
                    zzR(zzngVar, i12, zzmy.zzf(obj, iZzB & 1048575), i11);
                    break;
                case 51:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzf(i12, zzn(obj, iZzB & 1048575));
                    }
                    break;
                case 52:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzo(i12, zzo(obj, iZzB & 1048575));
                    }
                    break;
                case 53:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzt(i12, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 54:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzJ(i12, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 55:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzr(i12, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 56:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzm(i12, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzk(i12, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 58:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzb(i12, zzY(obj, iZzB & 1048575));
                    }
                    break;
                case 59:
                    if (zzX(obj, i12, i11)) {
                        zzZ(i12, zzmy.zzf(obj, iZzB & 1048575), zzngVar);
                    }
                    break;
                case 60:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzv(i12, zzmy.zzf(obj, iZzB & 1048575), zzE(i11));
                    }
                    break;
                case 61:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzd(i12, (zzje) zzmy.zzf(obj, iZzB & 1048575));
                    }
                    break;
                case 62:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzH(i12, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 63:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzi(i12, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 64:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzw(i12, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzy(i12, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 66:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzA(i12, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzC(i12, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 68:
                    if (zzX(obj, i12, i11)) {
                        zzngVar.zzq(i12, zzmy.zzf(obj, iZzB & 1048575), zzE(i11));
                    }
                    break;
            }
        }
        zzmo zzmoVar = this.zzn;
        zzmoVar.zzi(zzmoVar.zzd(obj), zzngVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzZ;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int iZzB = zzB(i11);
            long j11 = iZzB & 1048575;
            switch (zzA(iZzB)) {
                case 0:
                    if (!zzS(obj, obj2, i11) || Double.doubleToLongBits(zzmy.zza(obj, j11)) != Double.doubleToLongBits(zzmy.zza(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzS(obj, obj2, i11) || Float.floatToIntBits(zzmy.zzb(obj, j11)) != Float.floatToIntBits(zzmy.zzb(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzS(obj, obj2, i11) || zzmy.zzd(obj, j11) != zzmy.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzS(obj, obj2, i11) || zzmy.zzd(obj, j11) != zzmy.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzS(obj, obj2, i11) || zzmy.zzc(obj, j11) != zzmy.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzS(obj, obj2, i11) || zzmy.zzd(obj, j11) != zzmy.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzS(obj, obj2, i11) || zzmy.zzc(obj, j11) != zzmy.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzS(obj, obj2, i11) || zzmy.zzw(obj, j11) != zzmy.zzw(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzS(obj, obj2, i11) || !zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzS(obj, obj2, i11) || !zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzS(obj, obj2, i11) || !zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzS(obj, obj2, i11) || zzmy.zzc(obj, j11) != zzmy.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzS(obj, obj2, i11) || zzmy.zzc(obj, j11) != zzmy.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzS(obj, obj2, i11) || zzmy.zzc(obj, j11) != zzmy.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzS(obj, obj2, i11) || zzmy.zzd(obj, j11) != zzmy.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzS(obj, obj2, i11) || zzmy.zzc(obj, j11) != zzmy.zzc(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzS(obj, obj2, i11) || zzmy.zzd(obj, j11) != zzmy.zzd(obj2, j11)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzS(obj, obj2, i11) || !zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11))) {
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
                    zZzZ = zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11));
                    break;
                case 50:
                    zZzZ = zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11));
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
                    long jZzy = zzy(i11) & 1048575;
                    if (zzmy.zzc(obj, jZzy) != zzmy.zzc(obj2, jZzy) || !zzlz.zzZ(zzmy.zzf(obj, j11), zzmy.zzf(obj2, j11))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzZ) {
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
    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzk(Object obj) {
        int i11;
        int i12;
        List list;
        zzlx zzlxVarZzE;
        int i13;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < this.zzk) {
            int i17 = this.zzj[i16];
            int i18 = this.zzc[i17];
            int iZzB = zzB(i17);
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
            if ((268435456 & iZzB) != 0 && !zzU(obj, i17, i11, i12, i22)) {
                return false;
            }
            int iZzA = zzA(iZzB);
            if (iZzA == 9 || iZzA == 17) {
                if (zzU(obj, i17, i11, i12, i22) && !zzV(obj, iZzB, zzE(i17))) {
                    return false;
                }
            } else if (iZzA == 27) {
                list = (List) zzmy.zzf(obj, iZzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzlxVarZzE = zzE(i17);
                    for (i13 = 0; i13 < list.size(); i13++) {
                        if (!zzlxVarZzE.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (iZzA == 60 || iZzA == 68) {
                if (zzX(obj, i18, i17) && !zzV(obj, iZzB, zzE(i17))) {
                    return false;
                }
            } else if (iZzA == 49) {
                list = (List) zzmy.zzf(obj, iZzB & 1048575);
                if (list.isEmpty()) {
                    zzlxVarZzE = zzE(i17);
                    while (i13 < list.size()) {
                        if (!zzlxVarZzE.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzA == 50 && !((zzlg) zzmy.zzf(obj, iZzB & 1048575)).isEmpty()) {
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
}
