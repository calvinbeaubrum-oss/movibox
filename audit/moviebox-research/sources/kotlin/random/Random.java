package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@SinceKotlin
@Metadata
@SourceDebugExtension
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = PlatformImplementationsKt.f68822a.b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Default extends Random implements Serializable {

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes8.dex */
        @Metadata
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i11) {
            return Random.defaultRandom.nextBits(i11);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i11) {
            return Random.defaultRandom.nextBytes(i11);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            Intrinsics.g(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int i11, int i12) {
            Intrinsics.g(array, "array");
            return Random.defaultRandom.nextBytes(array, i11, i12);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d11) {
            return Random.defaultRandom.nextDouble(d11);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d11, double d12) {
            return Random.defaultRandom.nextDouble(d11, d12);
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public int nextInt(int i11) {
            return Random.defaultRandom.nextInt(i11);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i11, int i12) {
            return Random.defaultRandom.nextInt(i11, i12);
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public long nextLong(long j11) {
            return Random.defaultRandom.nextLong(j11);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j11, long j12) {
            return Random.defaultRandom.nextLong(j11, j12);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = bArr.length;
        }
        return random.nextBytes(bArr, i11, i12);
    }

    public abstract int nextBits(int i11);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public byte[] nextBytes(int i11) {
        return nextBytes(new byte[i11]);
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.g(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(byte[] array, int i11, int i12) {
        Intrinsics.g(array, "array");
        if (!new IntRange(0, array.length).v(i11) || !new IntRange(0, array.length).v(i12)) {
            throw new IllegalArgumentException(("fromIndex (" + i11 + ") or toIndex (" + i12 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i11 > i12) {
            throw new IllegalArgumentException(("fromIndex (" + i11 + ") must be not greater than toIndex (" + i12 + ").").toString());
        }
        int i13 = (i12 - i11) / 4;
        for (int i14 = 0; i14 < i13; i14++) {
            int iNextInt = nextInt();
            array[i11] = (byte) iNextInt;
            array[i11 + 1] = (byte) (iNextInt >>> 8);
            array[i11 + 2] = (byte) (iNextInt >>> 16);
            array[i11 + 3] = (byte) (iNextInt >>> 24);
            i11 += 4;
        }
        int i15 = i12 - i11;
        int iNextBits = nextBits(i15 * 8);
        for (int i16 = 0; i16 < i15; i16++) {
            array[i11 + i16] = (byte) (iNextBits >>> (i16 * 8));
        }
        return array;
    }

    public double nextDouble() {
        return PlatformRandomKt.a(nextBits(26), nextBits(27));
    }

    public double nextDouble(double d11) {
        return nextDouble(0.0d, d11);
    }

    public double nextDouble(double d11, double d12) {
        double dNextDouble;
        RandomKt.b(d11, d12);
        double d13 = d12 - d11;
        if (!Double.isInfinite(d13) || Double.isInfinite(d11) || Double.isNaN(d11) || Double.isInfinite(d12) || Double.isNaN(d12)) {
            dNextDouble = d11 + (nextDouble() * d13);
        } else {
            double d14 = 2;
            double dNextDouble2 = nextDouble() * ((d12 / d14) - (d11 / d14));
            dNextDouble = d11 + dNextDouble2 + dNextDouble2;
        }
        return dNextDouble >= d12 ? Math.nextAfter(d12, Double.NEGATIVE_INFINITY) : dNextDouble;
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int i11) {
        return nextInt(0, i11);
    }

    public int nextInt(int i11, int i12) {
        int iNextInt;
        int i13;
        int iNextBits;
        RandomKt.c(i11, i12);
        int i14 = i12 - i11;
        if (i14 > 0 || i14 == Integer.MIN_VALUE) {
            if (((-i14) & i14) == i14) {
                iNextBits = nextBits(RandomKt.e(i14));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i13 = iNextInt % i14;
                } while ((iNextInt - i13) + (i14 - 1) < 0);
                iNextBits = i13;
            }
            return i11 + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i11 <= iNextInt2 && iNextInt2 < i12) {
                return iNextInt2;
            }
        }
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public long nextLong(long j11) {
        return nextLong(0L, j11);
    }

    public long nextLong(long j11, long j12) {
        long jNextLong;
        long j13;
        long jNextBits;
        int iNextInt;
        RandomKt.d(j11, j12);
        long j14 = j12 - j11;
        if (j14 > 0) {
            if (((-j14) & j14) == j14) {
                int i11 = (int) j14;
                int i12 = (int) (j14 >>> 32);
                if (i11 != 0) {
                    iNextInt = nextBits(RandomKt.e(i11));
                } else if (i12 == 1) {
                    iNextInt = nextInt();
                } else {
                    jNextBits = (((long) nextBits(RandomKt.e(i12))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                jNextBits = ((long) iNextInt) & 4294967295L;
            } else {
                do {
                    jNextLong = nextLong() >>> 1;
                    j13 = jNextLong % j14;
                } while ((jNextLong - j13) + (j14 - 1) < 0);
                jNextBits = j13;
            }
            return j11 + jNextBits;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (j11 <= jNextLong2 && jNextLong2 < j12) {
                return jNextLong2;
            }
        }
    }
}
