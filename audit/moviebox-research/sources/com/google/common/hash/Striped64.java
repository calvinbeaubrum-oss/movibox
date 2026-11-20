package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class Striped64 extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f38740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f38741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f38742c;
    volatile transient long base;
    volatile transient int busy;
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: compiled from: source.java */
    public class a implements PrivilegedExceptionAction<Unsafe> {
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
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Unsafe f38743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f38744c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f38745a;

        static {
            try {
                Unsafe unsafeA = Striped64.a();
                f38743b = unsafeA;
                f38744c = unsafeA.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e11) {
                throw new Error(e11);
            }
        }

        public b(long j11) {
            this.f38745a = j11;
        }

        public final boolean a(long j11, long j12) {
            return f38743b.compareAndSwapLong(this, f38744c, j11, j12);
        }
    }

    static {
        try {
            Unsafe unsafeA = a();
            f38740a = unsafeA;
            f38741b = unsafeA.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            f38742c = unsafeA.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e11) {
            throw new Error(e11);
        }
    }

    public static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e11) {
                throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    public final boolean casBase(long j11, long j12) {
        return f38740a.compareAndSwapLong(this, f38741b, j11, j12);
    }

    public final boolean casBusy() {
        return f38740a.compareAndSwapInt(this, f38742c, 0, 1);
    }

    public abstract long fn(long j11, long j12);

    public final void internalReset(long j11) {
        b[] bVarArr = this.cells;
        this.base = j11;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f38745a = j11;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    public final void retryUpdate(long j11, int[] iArr, boolean z11) {
        int iNextInt;
        int[] iArr2;
        boolean z12;
        int length;
        boolean z13;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            iNextInt = rng.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr2[0] = iNextInt;
        } else {
            iNextInt = iArr[0];
            iArr2 = iArr;
        }
        int i11 = iNextInt;
        boolean z14 = false;
        boolean z15 = z11;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i11];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(j11);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 == null || (length2 = bVarArr2.length) <= 0) {
                                    z13 = false;
                                } else {
                                    int i12 = (length2 - 1) & i11;
                                    if (bVarArr2[i12] == null) {
                                        bVarArr2[i12] = bVar2;
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                }
                                this.busy = 0;
                                if (z13) {
                                    return;
                                }
                            } catch (Throwable th2) {
                                this.busy = 0;
                                throw th2;
                            }
                        }
                    }
                    z14 = false;
                    int i13 = i11 ^ (i11 << 13);
                    int i14 = i13 ^ (i13 >>> 17);
                    i11 = i14 ^ (i14 << 5);
                    iArr2[0] = i11;
                } else {
                    if (z15) {
                        long j12 = bVar.f38745a;
                        if (bVar.a(j12, fn(j12, j11))) {
                            return;
                        }
                        if (length >= NCPU || this.cells != bVarArr) {
                            z14 = false;
                        } else if (!z14) {
                            z14 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i15 = 0; i15 < length; i15++) {
                                        bVarArr3[i15] = bVarArr[i15];
                                    }
                                    this.cells = bVarArr3;
                                }
                                this.busy = 0;
                                z14 = false;
                            } catch (Throwable th3) {
                                this.busy = 0;
                                throw th3;
                            }
                        }
                    } else {
                        z15 = true;
                    }
                    int i16 = i11 ^ (i11 << 13);
                    int i17 = i16 ^ (i16 >>> 17);
                    i11 = i17 ^ (i17 << 5);
                    iArr2[0] = i11;
                }
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i11 & 1] = new b(j11);
                        this.cells = bVarArr4;
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    this.busy = 0;
                    if (z12) {
                        return;
                    }
                } catch (Throwable th4) {
                    this.busy = 0;
                    throw th4;
                }
            } else {
                long j13 = this.base;
                if (casBase(j13, fn(j13, j11))) {
                    return;
                }
            }
        }
    }
}
