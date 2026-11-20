package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public PairedStats(Stats stats, Stats stats2, double d11) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d11;
    }

    private static double ensureInUnitRange(double d11) {
        if (d11 >= 1.0d) {
            return 1.0d;
        }
        if (d11 <= -1.0d) {
            return -1.0d;
        }
        return d11;
    }

    private static double ensurePositive(double d11) {
        if (d11 > 0.0d) {
            return d11;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        l.n(bArr);
        l.g(bArr.length == BYTES, "Expected PairedStats.BYTES = %s, got %s", BYTES, bArr.length);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(byteBufferOrder), Stats.readFrom(byteBufferOrder), byteBufferOrder.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
    }

    public int hashCode() {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public d leastSquaresFit() {
        l.t(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return d.a();
        }
        double dSumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (dSumOfSquaresOfDeltas > 0.0d) {
            return this.yStats.sumOfSquaresOfDeltas() > 0.0d ? d.c(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / dSumOfSquaresOfDeltas) : d.b(this.yStats.mean());
        }
        l.t(this.yStats.sumOfSquaresOfDeltas() > 0.0d);
        return d.d(this.xStats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        l.t(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double dSumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double dSumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        l.t(dSumOfSquaresOfDeltas > 0.0d);
        l.t(dSumOfSquaresOfDeltas2 > 0.0d);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(dSumOfSquaresOfDeltas * dSumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        l.t(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        l.t(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(BYTES).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(byteBufferOrder);
        this.yStats.writeTo(byteBufferOrder);
        byteBufferOrder.putDouble(this.sumOfProductsOfDeltas);
        return byteBufferOrder.array();
    }

    public String toString() {
        return count() > 0 ? com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.b(this).d("xStats", this.xStats).d("yStats", this.yStats).a("populationCovariance", populationCovariance()).toString() : com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.b(this).d("xStats", this.xStats).d("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
