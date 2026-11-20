package bh;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tg.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.common.base.o f14220d = com.google.common.base.o.f(':');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.common.base.o f14221e = com.google.common.base.o.f('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f14222a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14223b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14224c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f14226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14227c;

        public a(int i11, long j11, int i12) {
            this.f14225a = i11;
            this.f14226b = j11;
            this.f14227c = i12;
        }
    }

    public static int b(String str) throws ParserException {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", null);
        }
    }

    public static SlowMotionData f(c0 c0Var, int i11) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> listI = f14221e.i(c0Var.A(i11));
        for (int i12 = 0; i12 < listI.size(); i12++) {
            List<String> listI2 = f14220d.i(listI.get(i12));
            if (listI2.size() != 3) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong(listI2.get(0)), Long.parseLong(listI2.get(1)), 1 << (Integer.parseInt(listI2.get(2)) - 1)));
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedContainer(null, e11);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public final void a(tg.m mVar, a0 a0Var) throws IOException {
        c0 c0Var = new c0(8);
        mVar.readFully(c0Var.d(), 0, 8);
        this.f14224c = c0Var.q() + 8;
        if (c0Var.n() != 1397048916) {
            a0Var.f76990a = 0L;
        } else {
            a0Var.f76990a = mVar.getPosition() - ((long) (this.f14224c - 12));
            this.f14223b = 2;
        }
    }

    public int c(tg.m mVar, a0 a0Var, List<Metadata.Entry> list) throws IOException {
        int i11 = this.f14223b;
        long j11 = 0;
        if (i11 == 0) {
            long length = mVar.getLength();
            if (length != -1 && length >= 8) {
                j11 = length - 8;
            }
            a0Var.f76990a = j11;
            this.f14223b = 1;
        } else if (i11 == 1) {
            a(mVar, a0Var);
        } else if (i11 == 2) {
            d(mVar, a0Var);
        } else {
            if (i11 != 3) {
                throw new IllegalStateException();
            }
            e(mVar, list);
            a0Var.f76990a = 0L;
        }
        return 1;
    }

    public final void d(tg.m mVar, a0 a0Var) throws IOException {
        long length = mVar.getLength();
        int i11 = this.f14224c - 20;
        c0 c0Var = new c0(i11);
        mVar.readFully(c0Var.d(), 0, i11);
        for (int i12 = 0; i12 < i11 / 12; i12++) {
            c0Var.Q(2);
            short s11 = c0Var.s();
            if (s11 == 2192 || s11 == 2816 || s11 == 2817 || s11 == 2819 || s11 == 2820) {
                this.f14222a.add(new a(s11, (length - ((long) this.f14224c)) - ((long) c0Var.q()), c0Var.q()));
            } else {
                c0Var.Q(8);
            }
        }
        if (this.f14222a.isEmpty()) {
            a0Var.f76990a = 0L;
        } else {
            this.f14223b = 3;
            a0Var.f76990a = this.f14222a.get(0).f14226b;
        }
    }

    public final void e(tg.m mVar, List<Metadata.Entry> list) throws IOException {
        long position = mVar.getPosition();
        int length = (int) ((mVar.getLength() - mVar.getPosition()) - ((long) this.f14224c));
        c0 c0Var = new c0(length);
        mVar.readFully(c0Var.d(), 0, length);
        for (int i11 = 0; i11 < this.f14222a.size(); i11++) {
            a aVar = this.f14222a.get(i11);
            c0Var.P((int) (aVar.f14226b - position));
            c0Var.Q(4);
            int iQ = c0Var.q();
            int iB = b(c0Var.A(iQ));
            int i12 = aVar.f14227c - (iQ + 8);
            if (iB == 2192) {
                list.add(f(c0Var, i12));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f14222a.clear();
        this.f14223b = 0;
    }
}
