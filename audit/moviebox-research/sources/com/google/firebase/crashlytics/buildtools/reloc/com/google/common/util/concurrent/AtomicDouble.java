package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private static final AtomicLongFieldUpdater<AtomicDouble> updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, AppMeasurementSdk.ConditionalUserProperty.VALUE);
    private volatile transient long value;

    public AtomicDouble() {
    }

    public AtomicDouble(double d11) {
        this.value = Double.doubleToRawLongBits(d11);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    public final double addAndGet(double d11) {
        long j11;
        double dLongBitsToDouble;
        do {
            j11 = this.value;
            dLongBitsToDouble = Double.longBitsToDouble(j11) + d11;
        } while (!updater.compareAndSet(this, j11, Double.doubleToRawLongBits(dLongBitsToDouble)));
        return dLongBitsToDouble;
    }

    public final boolean compareAndSet(double d11, double d12) {
        return updater.compareAndSet(this, Double.doubleToRawLongBits(d11), Double.doubleToRawLongBits(d12));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value);
    }

    public final double getAndAdd(double d11) {
        long j11;
        double dLongBitsToDouble;
        do {
            j11 = this.value;
            dLongBitsToDouble = Double.longBitsToDouble(j11);
        } while (!updater.compareAndSet(this, j11, Double.doubleToRawLongBits(dLongBitsToDouble + d11)));
        return dLongBitsToDouble;
    }

    public final double getAndSet(double d11) {
        return Double.longBitsToDouble(updater.getAndSet(this, Double.doubleToRawLongBits(d11)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d11) {
        updater.lazySet(this, Double.doubleToRawLongBits(d11));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d11) {
        this.value = Double.doubleToRawLongBits(d11);
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d11, double d12) {
        return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(d11), Double.doubleToRawLongBits(d12));
    }
}
