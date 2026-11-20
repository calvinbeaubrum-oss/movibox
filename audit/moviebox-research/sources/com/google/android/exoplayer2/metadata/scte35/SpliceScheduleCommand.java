package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.c0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
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
        public final int f33583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33584b;

        public b(int i11, long j11) {
            this.f33583a = i11;
            this.f33584b = j11;
        }

        public /* synthetic */ b(int i11, long j11, a aVar) {
            this(i11, j11);
        }

        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        public final void d(Parcel parcel) {
            parcel.writeInt(this.f33583a);
            parcel.writeLong(this.f33584b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f33585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f33586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f33587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f33588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f33589e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f33590f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f33591g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f33592h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f33593i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f33594j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f33595k;

        public c(long j11, boolean z11, boolean z12, boolean z13, List<b> list, long j12, boolean z14, long j13, int i11, int i12, int i13) {
            this.f33585a = j11;
            this.f33586b = z11;
            this.f33587c = z12;
            this.f33588d = z13;
            this.f33590f = Collections.unmodifiableList(list);
            this.f33589e = j12;
            this.f33591g = z14;
            this.f33592h = j13;
            this.f33593i = i11;
            this.f33594j = i12;
            this.f33595k = i13;
        }

        public c(Parcel parcel) {
            this.f33585a = parcel.readLong();
            this.f33586b = parcel.readByte() == 1;
            this.f33587c = parcel.readByte() == 1;
            this.f33588d = parcel.readByte() == 1;
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(b.c(parcel));
            }
            this.f33590f = Collections.unmodifiableList(arrayList);
            this.f33589e = parcel.readLong();
            this.f33591g = parcel.readByte() == 1;
            this.f33592h = parcel.readLong();
            this.f33593i = parcel.readInt();
            this.f33594j = parcel.readInt();
            this.f33595k = parcel.readInt();
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
            int iD;
            boolean z13;
            boolean z14;
            long jF;
            long jF2 = c0Var.F();
            boolean z15 = (c0Var.D() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z15) {
                arrayList = arrayList2;
                z11 = false;
                j11 = C.TIME_UNSET;
                z12 = false;
                j12 = C.TIME_UNSET;
                i11 = 0;
                i12 = 0;
                iD = 0;
                z13 = false;
            } else {
                int iD2 = c0Var.D();
                boolean z16 = (iD2 & 128) != 0;
                boolean z17 = (iD2 & 64) != 0;
                boolean z18 = (iD2 & 32) != 0;
                long jF3 = z17 ? c0Var.F() : C.TIME_UNSET;
                if (!z17) {
                    int iD3 = c0Var.D();
                    ArrayList arrayList3 = new ArrayList(iD3);
                    for (int i13 = 0; i13 < iD3; i13++) {
                        arrayList3.add(new b(c0Var.D(), c0Var.F(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z18) {
                    long jD = c0Var.D();
                    boolean z19 = (128 & jD) != 0;
                    jF = ((((jD & 1) << 32) | c0Var.F()) * 1000) / 90;
                    z14 = z19;
                } else {
                    z14 = false;
                    jF = C.TIME_UNSET;
                }
                int iJ = c0Var.J();
                int iD4 = c0Var.D();
                z13 = z17;
                iD = c0Var.D();
                j12 = jF;
                arrayList = arrayList2;
                long j13 = jF3;
                i11 = iJ;
                i12 = iD4;
                j11 = j13;
                boolean z21 = z16;
                z12 = z14;
                z11 = z21;
            }
            return new c(jF2, z15, z11, z13, arrayList, j11, z12, j12, i11, i12, iD);
        }

        public final void f(Parcel parcel) {
            parcel.writeLong(this.f33585a);
            parcel.writeByte(this.f33586b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f33587c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f33588d ? (byte) 1 : (byte) 0);
            int size = this.f33590f.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                this.f33590f.get(i11).d(parcel);
            }
            parcel.writeLong(this.f33589e);
            parcel.writeByte(this.f33591g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f33592h);
            parcel.writeInt(this.f33593i);
            parcel.writeInt(this.f33594j);
            parcel.writeInt(this.f33595k);
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
        int iD = c0Var.D();
        ArrayList arrayList = new ArrayList(iD);
        for (int i11 = 0; i11 < iD; i11++) {
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
