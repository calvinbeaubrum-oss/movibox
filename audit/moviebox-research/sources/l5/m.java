package l5;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import u4.l0;
import u4.t;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.common.base.o f69919d = com.google.common.base.o.f(':');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.common.base.o f69920e = com.google.common.base.o.f('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f69921a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f69922b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f69923c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f69925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f69926c;

        public a(int i11, long j11, int i12) {
            this.f69924a = i11;
            this.f69925b = j11;
            this.f69926c = i12;
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
        List<String> listI = f69920e.i(c0Var.E(i11));
        for (int i12 = 0; i12 < listI.size(); i12++) {
            List<String> listI2 = f69919d.i(listI.get(i12));
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

    public final void a(t tVar, l0 l0Var) throws IOException {
        c0 c0Var = new c0(8);
        tVar.readFully(c0Var.e(), 0, 8);
        this.f69923c = c0Var.u() + 8;
        if (c0Var.q() != 1397048916) {
            l0Var.f78322a = 0L;
        } else {
            l0Var.f78322a = tVar.getPosition() - ((long) (this.f69923c - 12));
            this.f69922b = 2;
        }
    }

    public int c(t tVar, l0 l0Var, List<Metadata.Entry> list) throws IOException {
        int i11 = this.f69922b;
        long j11 = 0;
        if (i11 == 0) {
            long length = tVar.getLength();
            if (length != -1 && length >= 8) {
                j11 = length - 8;
            }
            l0Var.f78322a = j11;
            this.f69922b = 1;
        } else if (i11 == 1) {
            a(tVar, l0Var);
        } else if (i11 == 2) {
            d(tVar, l0Var);
        } else {
            if (i11 != 3) {
                throw new IllegalStateException();
            }
            e(tVar, list);
            l0Var.f78322a = 0L;
        }
        return 1;
    }

    public final void d(t tVar, l0 l0Var) throws IOException {
        long length = tVar.getLength();
        int i11 = this.f69923c - 20;
        c0 c0Var = new c0(i11);
        tVar.readFully(c0Var.e(), 0, i11);
        for (int i12 = 0; i12 < i11 / 12; i12++) {
            c0Var.V(2);
            short sW = c0Var.w();
            if (sW == 2192 || sW == 2816 || sW == 2817 || sW == 2819 || sW == 2820) {
                this.f69921a.add(new a(sW, (length - ((long) this.f69923c)) - ((long) c0Var.u()), c0Var.u()));
            } else {
                c0Var.V(8);
            }
        }
        if (this.f69921a.isEmpty()) {
            l0Var.f78322a = 0L;
        } else {
            this.f69922b = 3;
            l0Var.f78322a = this.f69921a.get(0).f69925b;
        }
    }

    public final void e(t tVar, List<Metadata.Entry> list) throws IOException {
        long position = tVar.getPosition();
        int length = (int) ((tVar.getLength() - tVar.getPosition()) - ((long) this.f69923c));
        c0 c0Var = new c0(length);
        tVar.readFully(c0Var.e(), 0, length);
        for (int i11 = 0; i11 < this.f69921a.size(); i11++) {
            a aVar = this.f69921a.get(i11);
            c0Var.U((int) (aVar.f69925b - position));
            c0Var.V(4);
            int iU = c0Var.u();
            int iB = b(c0Var.E(iU));
            int i12 = aVar.f69926c - (iU + 8);
            if (iB == 2192) {
                list.add(f(c0Var, i12));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f69921a.clear();
        this.f69922b = 0;
    }
}
