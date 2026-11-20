package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
    public final List<c> events;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i11) {
            return new SpliceScheduleCommand[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11805b;

        public b(int i11, long j11) {
            this.f11804a = i11;
            this.f11805b = j11;
        }

        public /* synthetic */ b(int i11, long j11, a aVar) {
            this(i11, j11);
        }

        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        public final void d(Parcel parcel) {
            parcel.writeInt(this.f11804a);
            parcel.writeLong(this.f11805b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f11807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f11808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f11809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f11810e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f11811f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f11812g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f11813h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f11814i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f11815j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f11816k;

        public c(long j11, boolean z11, boolean z12, boolean z13, List<b> list, long j12, boolean z14, long j13, int i11, int i12, int i13) {
            this.f11806a = j11;
            this.f11807b = z11;
            this.f11808c = z12;
            this.f11809d = z13;
            this.f11811f = Collections.unmodifiableList(list);
            this.f11810e = j12;
            this.f11812g = z14;
            this.f11813h = j13;
            this.f11814i = i11;
            this.f11815j = i12;
            this.f11816k = i13;
        }

        public c(Parcel parcel) {
            this.f11806a = parcel.readLong();
            this.f11807b = parcel.readByte() == 1;
            this.f11808c = parcel.readByte() == 1;
            this.f11809d = parcel.readByte() == 1;
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(b.c(parcel));
            }
            this.f11811f = Collections.unmodifiableList(arrayList);
            this.f11810e = parcel.readLong();
            this.f11812g = parcel.readByte() == 1;
            this.f11813h = parcel.readLong();
            this.f11814i = parcel.readInt();
            this.f11815j = parcel.readInt();
            this.f11816k = parcel.readInt();
        }

        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        public static c e(c0 c0Var) {
            ArrayList arrayList;
            boolean z11;
            long j11;
            boolean z12;
            long j12;
            int i11;
            int i12;
            int iH;
            boolean z13;
            boolean z14;
            long J;
            long J2 = c0Var.J();
            boolean z15 = (c0Var.H() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z15) {
                arrayList = arrayList2;
                z11 = false;
                j11 = C.TIME_UNSET;
                z12 = false;
                j12 = C.TIME_UNSET;
                i11 = 0;
                i12 = 0;
                iH = 0;
                z13 = false;
            } else {
                int iH2 = c0Var.H();
                boolean z16 = (iH2 & 128) != 0;
                boolean z17 = (iH2 & 64) != 0;
                boolean z18 = (iH2 & 32) != 0;
                long J3 = z17 ? c0Var.J() : C.TIME_UNSET;
                if (!z17) {
                    int iH3 = c0Var.H();
                    ArrayList arrayList3 = new ArrayList(iH3);
                    for (int i13 = 0; i13 < iH3; i13++) {
                        arrayList3.add(new b(c0Var.H(), c0Var.J(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z18) {
                    long jH = c0Var.H();
                    boolean z19 = (128 & jH) != 0;
                    J = ((((jH & 1) << 32) | c0Var.J()) * 1000) / 90;
                    z14 = z19;
                } else {
                    z14 = false;
                    J = C.TIME_UNSET;
                }
                int iN = c0Var.N();
                int iH4 = c0Var.H();
                z13 = z17;
                iH = c0Var.H();
                j12 = J;
                arrayList = arrayList2;
                long j13 = J3;
                i11 = iN;
                i12 = iH4;
                j11 = j13;
                boolean z21 = z16;
                z12 = z14;
                z11 = z21;
            }
            return new c(J2, z15, z11, z13, arrayList, j11, z12, j12, i11, i12, iH);
        }

        public final void f(Parcel parcel) {
            parcel.writeLong(this.f11806a);
            parcel.writeByte(this.f11807b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f11808c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f11809d ? (byte) 1 : (byte) 0);
            int size = this.f11811f.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f11811f.get(i11).d(parcel);
            }
            parcel.writeLong(this.f11810e);
            parcel.writeByte(this.f11812g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f11813h);
            parcel.writeInt(this.f11814i);
            parcel.writeInt(this.f11815j);
            parcel.writeInt(this.f11816k);
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int i11 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(c.d(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<c> list) {
        this.events = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand parseFromSection(c0 c0Var) {
        int iH = c0Var.H();
        ArrayList arrayList = new ArrayList(iH);
        for (int i11 = 0; i11 < iH; i11++) {
            arrayList.add(c.e(c0Var));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.events.get(i12).f(parcel);
        }
    }
}
