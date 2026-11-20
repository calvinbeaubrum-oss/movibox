package com.google.android.gms.internal.ads;

import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhcz {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzhcy zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* JADX WARN: Code duplicated, block: B:11:0x003e  */
    static {
        boolean z11;
        boolean z12;
        zzhcy zzhcyVar;
        Unsafe unsafeZzi = zzi();
        zzc = unsafeZzi;
        int i11 = zzgxw.zza;
        zzd = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zZzy = zzy(cls);
        zze = zZzy;
        boolean zZzy2 = zzy(Integer.TYPE);
        zzhcy zzhcwVar = null;
        if (unsafeZzi != null) {
            if (zZzy) {
                zzhcwVar = new zzhcx(unsafeZzi);
            } else if (zZzy2) {
                zzhcwVar = new zzhcw(unsafeZzi);
            }
        }
        zzf = zzhcwVar;
        if (zzhcwVar == null) {
            z11 = false;
        } else {
            try {
                Class<?> cls2 = zzhcwVar.zza.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (zzE() == null) {
                    z11 = false;
                } else {
                    z11 = true;
                }
            } catch (Throwable th2) {
                zzj(th2);
            }
        }
        zzg = z11;
        zzhcy zzhcyVar2 = zzf;
        if (zzhcyVar2 == null) {
            z12 = false;
        } else {
            try {
                Class<?> cls3 = zzhcyVar2.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z12 = true;
            } catch (Throwable th3) {
                zzj(th3);
                z12 = false;
            }
        }
        zzh = z12;
        zza = zzC(byte[].class);
        zzC(boolean[].class);
        zzD(boolean[].class);
        zzC(int[].class);
        zzD(int[].class);
        zzC(long[].class);
        zzD(long[].class);
        zzC(float[].class);
        zzD(float[].class);
        zzC(double[].class);
        zzD(double[].class);
        zzC(Object[].class);
        zzD(Object[].class);
        Field fieldZzE = zzE();
        long jObjectFieldOffset = -1;
        if (fieldZzE != null && (zzhcyVar = zzf) != null) {
            jObjectFieldOffset = zzhcyVar.zza.objectFieldOffset(fieldZzE);
        }
        zzi = jObjectFieldOffset;
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzhcz() {
    }

    public static boolean zzA() {
        return zzh;
    }

    public static boolean zzB() {
        return zzg;
    }

    private static int zzC(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzD(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzE() {
        int i11 = zzgxw.zza;
        Field fieldZzF = zzF(Buffer.class, "effectiveDirectAddress");
        if (fieldZzF != null) {
            return fieldZzF;
        }
        Field fieldZzF2 = zzF(Buffer.class, PlaceTypes.ADDRESS);
        if (fieldZzF2 == null || fieldZzF2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzF2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzG(Object obj, long j11, byte b11) {
        zzhcy zzhcyVar = zzf;
        long j12 = (-4) & j11;
        int i11 = zzhcyVar.zza.getInt(obj, j12);
        int i12 = ((~((int) j11)) & 3) << 3;
        zzhcyVar.zza.putInt(obj, j12, ((255 & b11) << i12) | (i11 & (~(255 << i12))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzH(Object obj, long j11, byte b11) {
        zzhcy zzhcyVar = zzf;
        long j12 = (-4) & j11;
        int i11 = (((int) j11) & 3) << 3;
        zzhcyVar.zza.putInt(obj, j12, ((255 & b11) << i11) | (zzhcyVar.zza.getInt(obj, j12) & (~(255 << i11))));
    }

    public static byte zza(long j11) {
        return zzf.zza(j11);
    }

    public static double zzb(Object obj, long j11) {
        return zzf.zzb(obj, j11);
    }

    public static float zzc(Object obj, long j11) {
        return zzf.zzc(obj, j11);
    }

    public static int zzd(Object obj, long j11) {
        return zzf.zza.getInt(obj, j11);
    }

    public static long zze(ByteBuffer byteBuffer) {
        zzhcy zzhcyVar = zzf;
        return zzhcyVar.zza.getLong(byteBuffer, zzi);
    }

    public static long zzf(Object obj, long j11) {
        return zzf.zza.getLong(obj, j11);
    }

    public static Object zzg(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static Object zzh(Object obj, long j11) {
        return zzf.zza.getObject(obj, j11);
    }

    public static Unsafe zzi() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhcv());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzj(Throwable th2) {
        Logger.getLogger(zzhcz.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th2.toString()));
    }

    public static void zzo(long j11, byte[] bArr, long j12, long j13) {
        zzf.zzd(j11, bArr, j12, j13);
    }

    public static void zzp(Object obj, long j11, boolean z11) {
        zzf.zze(obj, j11, z11);
    }

    public static void zzq(byte[] bArr, long j11, byte b11) {
        zzf.zzf(bArr, zza + j11, b11);
    }

    public static void zzr(Object obj, long j11, double d11) {
        zzf.zzg(obj, j11, d11);
    }

    public static void zzs(Object obj, long j11, float f11) {
        zzf.zzh(obj, j11, f11);
    }

    public static void zzt(Object obj, long j11, int i11) {
        zzf.zza.putInt(obj, j11, i11);
    }

    public static void zzu(Object obj, long j11, long j12) {
        zzf.zza.putLong(obj, j11, j12);
    }

    public static void zzv(Object obj, long j11, Object obj2) {
        zzf.zza.putObject(obj, j11, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzw(Object obj, long j11) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j11) >>> ((int) (((~j11) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzx(Object obj, long j11) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j11) >>> ((int) ((j11 & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzy(Class cls) {
        int i11 = zzgxw.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzz(Object obj, long j11) {
        return zzf.zzi(obj, j11);
    }
}
