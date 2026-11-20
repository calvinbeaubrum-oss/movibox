package com.google.protobuf;

import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f41356a = H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f41357b = com.google.protobuf.d.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f41358c = q(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f41359d = q(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f41360e = F();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f41361f = Y();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f41362g = X();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f41363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f41364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f41365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f41366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f41367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f41368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f41369n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f41370o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f41371p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f41372q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f41373r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f41374s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f41375t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f41376u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f41377v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f41378w;

    /* JADX INFO: compiled from: source.java */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.l1.e
        public void c(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.l1.e
        public boolean d(Object obj, long j11) {
            return l1.f41378w ? l1.u(obj, j11) : l1.v(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public byte e(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.l1.e
        public byte f(Object obj, long j11) {
            return l1.f41378w ? l1.y(obj, j11) : l1.z(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public double g(Object obj, long j11) {
            return Double.longBitsToDouble(k(obj, j11));
        }

        @Override // com.google.protobuf.l1.e
        public float h(Object obj, long j11) {
            return Float.intBitsToFloat(i(obj, j11));
        }

        @Override // com.google.protobuf.l1.e
        public long j(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.l1.e
        public void n(Object obj, long j11, boolean z11) {
            if (l1.f41378w) {
                l1.N(obj, j11, z11);
            } else {
                l1.O(obj, j11, z11);
            }
        }

        @Override // com.google.protobuf.l1.e
        public void o(Object obj, long j11, byte b11) {
            if (l1.f41378w) {
                l1.Q(obj, j11, b11);
            } else {
                l1.R(obj, j11, b11);
            }
        }

        @Override // com.google.protobuf.l1.e
        public void p(Object obj, long j11, double d11) {
            s(obj, j11, Double.doubleToLongBits(d11));
        }

        @Override // com.google.protobuf.l1.e
        public void q(Object obj, long j11, float f11) {
            r(obj, j11, Float.floatToIntBits(f11));
        }

        @Override // com.google.protobuf.l1.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.l1.e
        public void c(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.l1.e
        public boolean d(Object obj, long j11) {
            return l1.f41378w ? l1.u(obj, j11) : l1.v(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public byte e(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.l1.e
        public byte f(Object obj, long j11) {
            return l1.f41378w ? l1.y(obj, j11) : l1.z(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public double g(Object obj, long j11) {
            return Double.longBitsToDouble(k(obj, j11));
        }

        @Override // com.google.protobuf.l1.e
        public float h(Object obj, long j11) {
            return Float.intBitsToFloat(i(obj, j11));
        }

        @Override // com.google.protobuf.l1.e
        public long j(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.l1.e
        public void n(Object obj, long j11, boolean z11) {
            if (l1.f41378w) {
                l1.N(obj, j11, z11);
            } else {
                l1.O(obj, j11, z11);
            }
        }

        @Override // com.google.protobuf.l1.e
        public void o(Object obj, long j11, byte b11) {
            if (l1.f41378w) {
                l1.Q(obj, j11, b11);
            } else {
                l1.R(obj, j11, b11);
            }
        }

        @Override // com.google.protobuf.l1.e
        public void p(Object obj, long j11, double d11) {
            s(obj, j11, Double.doubleToLongBits(d11));
        }

        @Override // com.google.protobuf.l1.e
        public void q(Object obj, long j11, float f11) {
            r(obj, j11, Float.floatToIntBits(f11));
        }

        @Override // com.google.protobuf.l1.e
        public boolean v() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.l1.e
        public void c(long j11, byte[] bArr, long j12, long j13) {
            this.f41379a.copyMemory((Object) null, j11, bArr, l1.f41363h + j12, j13);
        }

        @Override // com.google.protobuf.l1.e
        public boolean d(Object obj, long j11) {
            return this.f41379a.getBoolean(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public byte e(long j11) {
            return this.f41379a.getByte(j11);
        }

        @Override // com.google.protobuf.l1.e
        public byte f(Object obj, long j11) {
            return this.f41379a.getByte(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public double g(Object obj, long j11) {
            return this.f41379a.getDouble(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public float h(Object obj, long j11) {
            return this.f41379a.getFloat(obj, j11);
        }

        @Override // com.google.protobuf.l1.e
        public long j(long j11) {
            return this.f41379a.getLong(j11);
        }

        @Override // com.google.protobuf.l1.e
        public void n(Object obj, long j11, boolean z11) {
            this.f41379a.putBoolean(obj, j11, z11);
        }

        @Override // com.google.protobuf.l1.e
        public void o(Object obj, long j11, byte b11) {
            this.f41379a.putByte(obj, j11, b11);
        }

        @Override // com.google.protobuf.l1.e
        public void p(Object obj, long j11, double d11) {
            this.f41379a.putDouble(obj, j11, d11);
        }

        @Override // com.google.protobuf.l1.e
        public void q(Object obj, long j11, float f11) {
            this.f41379a.putFloat(obj, j11, f11);
        }

        @Override // com.google.protobuf.l1.e
        public boolean u() {
            if (!super.u()) {
                return false;
            }
            try {
                Class<?> cls = this.f41379a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th2) {
                l1.K(th2);
                return false;
            }
        }

        @Override // com.google.protobuf.l1.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f41379a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th2) {
                l1.K(th2);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Unsafe f41379a;

        public e(Unsafe unsafe) {
            this.f41379a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f41379a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f41379a.arrayIndexScale(cls);
        }

        public abstract void c(long j11, byte[] bArr, long j12, long j13);

        public abstract boolean d(Object obj, long j11);

        public abstract byte e(long j11);

        public abstract byte f(Object obj, long j11);

        public abstract double g(Object obj, long j11);

        public abstract float h(Object obj, long j11);

        public final int i(Object obj, long j11) {
            return this.f41379a.getInt(obj, j11);
        }

        public abstract long j(long j11);

        public final long k(Object obj, long j11) {
            return this.f41379a.getLong(obj, j11);
        }

        public final Object l(Object obj, long j11) {
            return this.f41379a.getObject(obj, j11);
        }

        public final long m(Field field) {
            return this.f41379a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j11, boolean z11);

        public abstract void o(Object obj, long j11, byte b11);

        public abstract void p(Object obj, long j11, double d11);

        public abstract void q(Object obj, long j11, float f11);

        public final void r(Object obj, long j11, int i11) {
            this.f41379a.putInt(obj, j11, i11);
        }

        public final void s(Object obj, long j11, long j12) {
            this.f41379a.putLong(obj, j11, j12);
        }

        public final void t(Object obj, long j11, Object obj2) {
            this.f41379a.putObject(obj, j11, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.f41379a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th2) {
                l1.K(th2);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.f41379a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return l1.o() != null;
            } catch (Throwable th2) {
                l1.K(th2);
                return false;
            }
        }
    }

    static {
        long jM = m(byte[].class);
        f41363h = jM;
        f41364i = m(boolean[].class);
        f41365j = n(boolean[].class);
        f41366k = m(int[].class);
        f41367l = n(int[].class);
        f41368m = m(long[].class);
        f41369n = n(long[].class);
        f41370o = m(float[].class);
        f41371p = n(float[].class);
        f41372q = m(double[].class);
        f41373r = n(double[].class);
        f41374s = m(Object[].class);
        f41375t = n(Object[].class);
        f41376u = s(o());
        f41377v = (int) (jM & 7);
        f41378w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static double A(Object obj, long j11) {
        return f41360e.g(obj, j11);
    }

    public static float B(Object obj, long j11) {
        return f41360e.h(obj, j11);
    }

    public static int C(Object obj, long j11) {
        return f41360e.i(obj, j11);
    }

    public static long D(long j11) {
        return f41360e.j(j11);
    }

    public static long E(Object obj, long j11) {
        return f41360e.k(obj, j11);
    }

    public static e F() {
        Unsafe unsafe = f41356a;
        if (unsafe == null) {
            return null;
        }
        if (!com.google.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (f41358c) {
            return new c(unsafe);
        }
        if (f41359d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object G(Object obj, long j11) {
        return f41360e.l(obj, j11);
    }

    public static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean I() {
        return f41362g;
    }

    public static boolean J() {
        return f41361f;
    }

    public static void K(Throwable th2) {
        Logger.getLogger(l1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
    }

    public static long L(Field field) {
        return f41360e.m(field);
    }

    public static void M(Object obj, long j11, boolean z11) {
        f41360e.n(obj, j11, z11);
    }

    public static void N(Object obj, long j11, boolean z11) {
        Q(obj, j11, z11 ? (byte) 1 : (byte) 0);
    }

    public static void O(Object obj, long j11, boolean z11) {
        R(obj, j11, z11 ? (byte) 1 : (byte) 0);
    }

    public static void P(byte[] bArr, long j11, byte b11) {
        f41360e.o(bArr, f41363h + j11, b11);
    }

    public static void Q(Object obj, long j11, byte b11) {
        long j12 = (-4) & j11;
        int iC = C(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        U(obj, j12, ((255 & b11) << i11) | (iC & (~(255 << i11))));
    }

    public static void R(Object obj, long j11, byte b11) {
        long j12 = (-4) & j11;
        int i11 = (((int) j11) & 3) << 3;
        U(obj, j12, ((255 & b11) << i11) | (C(obj, j12) & (~(255 << i11))));
    }

    public static void S(Object obj, long j11, double d11) {
        f41360e.p(obj, j11, d11);
    }

    public static void T(Object obj, long j11, float f11) {
        f41360e.q(obj, j11, f11);
    }

    public static void U(Object obj, long j11, int i11) {
        f41360e.r(obj, j11, i11);
    }

    public static void V(Object obj, long j11, long j12) {
        f41360e.s(obj, j11, j12);
    }

    public static void W(Object obj, long j11, Object obj2) {
        f41360e.t(obj, j11, obj2);
    }

    public static boolean X() {
        e eVar = f41360e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    public static boolean Y() {
        e eVar = f41360e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    public static long k(ByteBuffer byteBuffer) {
        return f41360e.k(byteBuffer, f41376u);
    }

    public static <T> T l(Class<T> cls) {
        try {
            return (T) f41356a.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static int m(Class<?> cls) {
        if (f41362g) {
            return f41360e.a(cls);
        }
        return -1;
    }

    public static int n(Class<?> cls) {
        if (f41362g) {
            return f41360e.b(cls);
        }
        return -1;
    }

    public static Field o() {
        Field fieldR;
        if (com.google.protobuf.d.c() && (fieldR = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldR;
        }
        Field fieldR2 = r(Buffer.class, PlaceTypes.ADDRESS);
        if (fieldR2 == null || fieldR2.getType() != Long.TYPE) {
            return null;
        }
        return fieldR2;
    }

    public static void p(long j11, byte[] bArr, long j12, long j13) {
        f41360e.c(j11, bArr, j12, j13);
    }

    public static boolean q(Class<?> cls) {
        if (!com.google.protobuf.d.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f41357b;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
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

    public static Field r(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long s(Field field) {
        e eVar;
        if (field == null || (eVar = f41360e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    public static boolean t(Object obj, long j11) {
        return f41360e.d(obj, j11);
    }

    public static boolean u(Object obj, long j11) {
        return y(obj, j11) != 0;
    }

    public static boolean v(Object obj, long j11) {
        return z(obj, j11) != 0;
    }

    public static byte w(long j11) {
        return f41360e.e(j11);
    }

    public static byte x(byte[] bArr, long j11) {
        return f41360e.f(bArr, f41363h + j11);
    }

    public static byte y(Object obj, long j11) {
        return (byte) ((C(obj, (-4) & j11) >>> ((int) (((~j11) & 3) << 3))) & 255);
    }

    public static byte z(Object obj, long j11) {
        return (byte) ((C(obj, (-4) & j11) >>> ((int) ((j11 & 3) << 3))) & 255);
    }
}
