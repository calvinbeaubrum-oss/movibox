package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    /* JADX INFO: compiled from: source.java */
    public static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BigIntegerDomain f39296a = new BigIntegerDomain();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final BigInteger f39297b = BigInteger.valueOf(Long.MIN_VALUE);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final BigInteger f39298c = BigInteger.valueOf(Long.MAX_VALUE);
        private static final long serialVersionUID = 0;

        public BigIntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f39296a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(f39297b).min(f39298c).longValue();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public BigInteger offset(BigInteger bigInteger, long j11) {
            n1.c(j11, "distance");
            return bigInteger.add(BigInteger.valueOf(j11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntegerDomain f39299a = new IntegerDomain();
        private static final long serialVersionUID = 0;

        public IntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f39299a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public long distance(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Integer next(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue + 1);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Integer offset(Integer num, long j11) {
            n1.c(j11, "distance");
            return Integer.valueOf(Ints.c(num.longValue() + j11));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Integer previous(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class LongDomain extends DiscreteDomain<Long> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LongDomain f39300a = new LongDomain();
        private static final long serialVersionUID = 0;

        public LongDomain() {
            super(true);
        }

        private Object readResolve() {
            return f39300a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public long distance(Long l11, Long l12) {
            long jLongValue = l12.longValue() - l11.longValue();
            if (l12.longValue() > l11.longValue() && jLongValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l12.longValue() >= l11.longValue() || jLongValue <= 0) {
                return jLongValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Long next(Long l11) {
            long jLongValue = l11.longValue();
            if (jLongValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue + 1);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Long offset(Long l11, long j11) {
            n1.c(j11, "distance");
            long jLongValue = l11.longValue() + j11;
            if (jLongValue < 0) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(l11.longValue() < 0, "overflow");
            }
            return Long.valueOf(jLongValue);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.DiscreteDomain
        public Long previous(Long l11) {
            long jLongValue = l11.longValue();
            if (jLongValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public DiscreteDomain() {
        this(false);
    }

    public DiscreteDomain(boolean z11) {
        this.supportsFastOffset = z11;
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.f39296a;
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.f39299a;
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.f39300a;
    }

    public abstract long distance(C c11, C c12);

    public C maxValue() {
        throw new NoSuchElementException();
    }

    public C minValue() {
        throw new NoSuchElementException();
    }

    public abstract C next(C c11);

    public C offset(C c11, long j11) {
        n1.c(j11, "distance");
        for (long j12 = 0; j12 < j11; j12++) {
            c11 = (C) next(c11);
        }
        return c11;
    }

    public abstract C previous(C c11);
}
