package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z3.c0;
import z3.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<b> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i11) {
            return new SpliceInsertCommand[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f11803c;

        public b(int i11, long j11, long j12) {
            this.f11801a = i11;
            this.f11802b = j11;
            this.f11803c = j12;
        }

        public /* synthetic */ b(int i11, long j11, long j12, a aVar) {
            this(i11, j11, j12);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f11801a);
            parcel.writeLong(this.f11802b);
            parcel.writeLong(this.f11803c);
        }
    }

    private SpliceInsertCommand(long j11, boolean z11, boolean z12, boolean z13, boolean z14, long j12, long j13, List<b> list, boolean z15, long j14, int i11, int i12, int i13) {
        this.spliceEventId = j11;
        this.spliceEventCancelIndicator = z11;
        this.outOfNetworkIndicator = z12;
        this.programSpliceFlag = z13;
        this.spliceImmediateFlag = z14;
        this.programSplicePts = j12;
        this.programSplicePlaybackPositionUs = j13;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z15;
        this.breakDurationUs = j14;
        this.uniqueProgramId = i11;
        this.availNum = i12;
        this.availsExpected = i13;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(b.a(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceInsertCommand parseFromSection(c0 c0Var, long j11, i0 i0Var) {
        List list;
        boolean z11;
        boolean z12;
        long j12;
        boolean z13;
        long j13;
        int iN;
        int iH;
        int iH2;
        boolean z14;
        boolean z15;
        long J;
        long J2 = c0Var.J();
        boolean z16 = (c0Var.H() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z16) {
            list = listEmptyList;
            z11 = false;
            z12 = false;
            j12 = C.TIME_UNSET;
            z13 = false;
            j13 = C.TIME_UNSET;
            iN = 0;
            iH = 0;
            iH2 = 0;
            z14 = false;
        } else {
            int iH3 = c0Var.H();
            boolean z17 = (iH3 & 128) != 0;
            boolean z18 = (iH3 & 64) != 0;
            boolean z19 = (iH3 & 32) != 0;
            boolean z21 = (iH3 & 16) != 0;
            long spliceTime = (!z18 || z21) ? C.TIME_UNSET : TimeSignalCommand.parseSpliceTime(c0Var, j11);
            if (!z18) {
                int iH4 = c0Var.H();
                ArrayList arrayList = new ArrayList(iH4);
                for (int i11 = 0; i11 < iH4; i11++) {
                    int iH5 = c0Var.H();
                    long spliceTime2 = !z21 ? TimeSignalCommand.parseSpliceTime(c0Var, j11) : C.TIME_UNSET;
                    arrayList.add(new b(iH5, spliceTime2, i0Var.b(spliceTime2), null));
                }
                listEmptyList = arrayList;
            }
            if (z19) {
                long jH = c0Var.H();
                boolean z22 = (128 & jH) != 0;
                J = ((((jH & 1) << 32) | c0Var.J()) * 1000) / 90;
                z15 = z22;
            } else {
                z15 = false;
                J = C.TIME_UNSET;
            }
            iN = c0Var.N();
            z14 = z18;
            iH = c0Var.H();
            iH2 = c0Var.H();
            list = listEmptyList;
            long j14 = spliceTime;
            z13 = z15;
            j13 = J;
            z12 = z21;
            z11 = z17;
            j12 = j14;
        }
        return new SpliceInsertCommand(J2, z16, z11, z14, z12, j12, i0Var.b(j12), list, z13, j13, iN, iH, iH2);
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.programSplicePts + ", programSplicePlaybackPositionUs= " + this.programSplicePlaybackPositionUs + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.componentSpliceList.get(i12).b(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }
}
