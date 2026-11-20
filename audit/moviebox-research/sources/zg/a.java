package zg;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayDeque;
import tg.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f81972a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f81973b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f81974c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zg.b f81975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f81976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f81977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f81978g;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f81979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f81980b;

        public b(int i11, long j11) {
            this.f81979a = i11;
            this.f81980b = j11;
        }
    }

    public static String f(m mVar, int i11) throws IOException {
        if (i11 == 0) {
            return "";
        }
        byte[] bArr = new byte[i11];
        mVar.readFully(bArr, 0, i11);
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        return new String(bArr, 0, i11);
    }

    @Override // zg.c
    public boolean a(m mVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f81975d);
        while (true) {
            b bVarPeek = this.f81973b.peek();
            if (bVarPeek != null && mVar.getPosition() >= bVarPeek.f81980b) {
                this.f81975d.endMasterElement(this.f81973b.pop().f81979a);
                return true;
            }
            if (this.f81976e == 0) {
                long jD = this.f81974c.d(mVar, true, false, 4);
                if (jD == -2) {
                    jD = c(mVar);
                }
                if (jD == -1) {
                    return false;
                }
                this.f81977f = (int) jD;
                this.f81976e = 1;
            }
            if (this.f81976e == 1) {
                this.f81978g = this.f81974c.d(mVar, false, true, 8);
                this.f81976e = 2;
            }
            int elementType = this.f81975d.getElementType(this.f81977f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = mVar.getPosition();
                    this.f81973b.push(new b(this.f81977f, this.f81978g + position));
                    this.f81975d.startMasterElement(this.f81977f, position, this.f81978g);
                    this.f81976e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j11 = this.f81978g;
                    if (j11 <= 8) {
                        this.f81975d.integerElement(this.f81977f, e(mVar, (int) j11));
                        this.f81976e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.f81978g, null);
                }
                if (elementType == 3) {
                    long j12 = this.f81978g;
                    if (j12 <= 2147483647L) {
                        this.f81975d.stringElement(this.f81977f, f(mVar, (int) j12));
                        this.f81976e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.f81978g, null);
                }
                if (elementType == 4) {
                    this.f81975d.a(this.f81977f, (int) this.f81978g, mVar);
                    this.f81976e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                }
                long j13 = this.f81978g;
                if (j13 == 4 || j13 == 8) {
                    this.f81975d.floatElement(this.f81977f, d(mVar, (int) j13));
                    this.f81976e = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.f81978g, null);
            }
            mVar.skipFully((int) this.f81978g);
            this.f81976e = 0;
        }
    }

    @Override // zg.c
    public void b(zg.b bVar) {
        this.f81975d = bVar;
    }

    public final long c(m mVar) throws IOException {
        mVar.resetPeekPosition();
        while (true) {
            mVar.peekFully(this.f81972a, 0, 4);
            int iC = g.c(this.f81972a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) g.a(this.f81972a, iC, false);
                if (this.f81975d.isLevel1Element(iA)) {
                    mVar.skipFully(iC);
                    return iA;
                }
            }
            mVar.skipFully(1);
        }
    }

    public final double d(m mVar, int i11) throws IOException {
        long jE = e(mVar, i11);
        return i11 == 4 ? Float.intBitsToFloat((int) jE) : Double.longBitsToDouble(jE);
    }

    public final long e(m mVar, int i11) throws IOException {
        mVar.readFully(this.f81972a, 0, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | ((long) (this.f81972a[i12] & 255));
        }
        return j11;
    }

    @Override // zg.c
    public void reset() {
        this.f81976e = 0;
        this.f81973b.clear();
        this.f81974c.e();
    }
}
