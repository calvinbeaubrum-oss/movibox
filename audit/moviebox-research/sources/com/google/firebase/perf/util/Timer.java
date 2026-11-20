package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new a();
    private long elapsedRealtimeMicros;
    private long uptimeMicros;
    private long wallClockMicros;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a implements Parcelable.Creator<Timer> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Timer[] newArray(int i11) {
            return new Timer[i11];
        }
    }

    public Timer() {
        this(wallClockMicros(), elapsedRealtimeMicros(), uptimeMicros());
    }

    @VisibleForTesting
    public Timer(long j11) {
        this(j11, j11, j11);
    }

    @VisibleForTesting
    public Timer(long j11, long j12, long j13) {
        this.wallClockMicros = j11;
        this.elapsedRealtimeMicros = j12;
        this.uptimeMicros = j13;
    }

    private Timer(Parcel parcel) {
        this(parcel.readLong(), parcel.readLong(), parcel.readLong());
    }

    public /* synthetic */ Timer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static long elapsedRealtimeMicros() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    public static Timer ofElapsedRealtime(long j11, long j12) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long micros = timeUnit.toMicros(j12);
        long micros2 = timeUnit.toMicros(j11);
        return new Timer(wallClockMicros() + (micros2 - elapsedRealtimeMicros()), micros2, micros);
    }

    private static long uptimeMicros() {
        return TimeUnit.MILLISECONDS.toMicros(SystemClock.uptimeMillis());
    }

    private static long wallClockMicros() {
        return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCurrentTimestampMicros() {
        return this.wallClockMicros + getDurationMicros();
    }

    public long getDurationMicros() {
        return getDurationMicros(new Timer());
    }

    public long getDurationMicros(@NonNull Timer timer) {
        return timer.elapsedRealtimeMicros - this.elapsedRealtimeMicros;
    }

    public long getDurationUptimeMicros(@NonNull Timer timer) {
        return timer.uptimeMicros - this.uptimeMicros;
    }

    public long getMicros() {
        return this.wallClockMicros;
    }

    public void reset() {
        this.wallClockMicros = wallClockMicros();
        this.elapsedRealtimeMicros = elapsedRealtimeMicros();
        this.uptimeMicros = uptimeMicros();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.wallClockMicros);
        parcel.writeLong(this.elapsedRealtimeMicros);
        parcel.writeLong(this.uptimeMicros);
    }
}
