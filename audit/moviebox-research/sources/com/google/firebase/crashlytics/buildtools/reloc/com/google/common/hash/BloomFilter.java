package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.m;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.SignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class BloomFilter<T> implements n<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: compiled from: source.java */
    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.a.g(((BloomFilter) bloomFilter).bits.f39820a);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t11, Funnel<? super T> funnel, int i11, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t11, Funnel<? super T> funnel, int i11, BloomFilterStrategies.a aVar);
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i11, Funnel<? super T> funnel, Strategy strategy) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 > 0, "numHashFunctions (%s) must be > 0", i11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 <= 255, "numHashFunctions (%s) must be <= 255", i11);
        this.bits = (BloomFilterStrategies.a) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(aVar);
        this.numHashFunctions = i11;
        this.funnel = (Funnel) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(funnel);
        this.strategy = (Strategy) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i11) {
        return create(funnel, i11);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i11, double d11) {
        return create(funnel, i11, d11);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j11) {
        return create(funnel, j11, 0.03d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j11, double d11) {
        return create(funnel, j11, d11, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j11, double d11, Strategy strategy) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(funnel);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(j11 >= 0, "Expected insertions (%s) must be >= 0", j11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(d11 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d11));
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(d11 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d11));
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(strategy);
        if (j11 == 0) {
            j11 = 1;
        }
        long jOptimalNumOfBits = optimalNumOfBits(j11, d11);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(jOptimalNumOfBits), optimalNumOfHashFunctions(j11, jOptimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + jOptimalNumOfBits + " bits", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BloomFilter lambda$toBloomFilter$1(BloomFilter bloomFilter, BloomFilter bloomFilter2) {
        bloomFilter.putAll(bloomFilter2);
        return bloomFilter;
    }

    public static long optimalNumOfBits(long j11, double d11) {
        if (d11 == 0.0d) {
            d11 = Double.MIN_VALUE;
        }
        return (long) (((-j11) * Math.log(d11)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long j11, long j12) {
        return Math.max(1, (int) Math.round((j12 / j11) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i11;
        int iC;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(inputStream, "InputStream");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(funnel, "Funnel");
        byte b11 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte b12 = dataInputStream.readByte();
            try {
                iC = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.n.c(dataInputStream.readByte());
                try {
                    int i12 = dataInputStream.readInt();
                    try {
                        BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[b12];
                        long[] jArr = new long[i12];
                        for (int i13 = 0; i13 < i12; i13++) {
                            jArr[i13] = dataInputStream.readLong();
                        }
                        return new BloomFilter<>(new BloomFilterStrategies.a(jArr), iC, funnel, bloomFilterStrategies);
                    } catch (RuntimeException e11) {
                        e = e11;
                        b11 = b12;
                        i11 = i12;
                        throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b11) + " numHashFunctions: " + iC + " dataLength: " + i11, e);
                    }
                } catch (RuntimeException e12) {
                    e = e12;
                    b11 = b12;
                    i11 = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b11) + " numHashFunctions: " + iC + " dataLength: " + i11, e);
                }
            } catch (RuntimeException e13) {
                e = e13;
                iC = -1;
            }
        } catch (RuntimeException e14) {
            e = e14;
            i11 = -1;
            iC = -1;
        }
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> funnel, long j11) {
        return toBloomFilter(funnel, j11, 0.03d);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(final Funnel<? super T> funnel, final long j11, final double d11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(funnel);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(j11 >= 0, "Expected insertions (%s) must be >= 0", j11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(d11 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d11));
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(d11 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d11));
        return Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return BloomFilter.create(funnel, j11, d11);
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.f
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((BloomFilter) obj).put(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.g
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BloomFilter.lambda$toBloomFilter$1((BloomFilter) obj, (BloomFilter) obj2);
            }
        }, Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT);
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
    @Deprecated
    public boolean apply(T t11) {
        return mightContain(t11);
    }

    public long approximateElementCount() {
        double dB = this.bits.b();
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.a.c(((-Math.log1p(-(this.bits.a() / dB))) * dB) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    public long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t11) {
        return this.strategy.mightContain(t11, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t11) {
        return this.strategy.put(t11, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(bloomFilter);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i11 = this.numHashFunctions;
        int i12 = bloomFilter.numHashFunctions;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.g(i11 == i12, "BloomFilters must have the same number of hash functions (%s != %s)", i11, i12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.i(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
    public /* bridge */ /* synthetic */ boolean test(Object obj) {
        return m.a(this, obj);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.n.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f39820a.length());
        for (int i11 = 0; i11 < this.bits.f39820a.length(); i11++) {
            dataOutputStream.writeLong(this.bits.f39820a.get(i11));
        }
    }
}
