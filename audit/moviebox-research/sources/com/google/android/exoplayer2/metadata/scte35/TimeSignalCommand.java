package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.k0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();
    public final long playbackPositionUs;
    public final long ptsTime;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand[] newArray(int i11) {
            return new TimeSignalCommand[i11];
        }
    }

    private TimeSignalCommand(long j11, long j12) {
        this.ptsTime = j11;
        this.playbackPositionUs = j12;
    }

    public /* synthetic */ TimeSignalCommand(long j11, long j12, a aVar) {
        this(j11, j12);
    }

    public static TimeSignalCommand parseFromSection(c0 c0Var, long j11, k0 k0Var) {
        long spliceTime = parseSpliceTime(c0Var, j11);
        return new TimeSignalCommand(spliceTime, k0Var.b(spliceTime));
    }

    public static long parseSpliceTime(c0 c0Var, long j11) {
        long jD = c0Var.D();
        return (128 & jD) != 0 ? 8589934591L & ((((jD & 1) << 32) | c0Var.F()) + j11) : C.TIME_UNSET;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.ptsTime);
        parcel.writeLong(this.playbackPositionUs);
    }
}
