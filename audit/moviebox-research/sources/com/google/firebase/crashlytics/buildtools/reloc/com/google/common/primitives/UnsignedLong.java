package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    private UnsignedLong(long j11) {
        this.value = j11;
    }

    public static UnsignedLong fromLongBits(long j11) {
        return new UnsignedLong(j11);
    }

    public static UnsignedLong valueOf(long j11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(j11 >= 0, "value (%s) is outside the range for an unsigned long value", j11);
        return fromLongBits(j11);
    }

    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedLong valueOf(String str, int i11) {
        return fromLongBits(UnsignedLongs.d(str, i11));
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(bigInteger);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.j(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    public BigInteger bigIntegerValue() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? bigIntegerValueOf.setBit(63) : bigIntegerValueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(unsignedLong);
        return UnsignedLongs.a(this.value, unsignedLong.value);
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.b(this.value, ((UnsignedLong) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(unsignedLong)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j11 = this.value;
        double d11 = Long.MAX_VALUE & j11;
        return j11 < 0 ? d11 + 9.223372036854776E18d : d11;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j11 = this.value;
        float f11 = Long.MAX_VALUE & j11;
        return j11 < 0 ? f11 + 9.223372E18f : f11;
    }

    public int hashCode() {
        return Longs.e(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(unsignedLong)).value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.e(this.value, ((UnsignedLong) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(unsignedLong)).value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(unsignedLong)).value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(unsignedLong)).value);
    }

    public String toString() {
        return UnsignedLongs.f(this.value);
    }

    public String toString(int i11) {
        return UnsignedLongs.g(this.value, i11);
    }
}
