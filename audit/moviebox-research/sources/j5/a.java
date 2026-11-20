package j5;

import androidx.media3.common.ParserException;
import java.io.IOException;
import java.util.ArrayDeque;
import u4.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f67857a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f67858b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f67859c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j5.b f67860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f67861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f67862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f67863g;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f67864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f67865b;

        public b(int i11, long j11) {
            this.f67864a = i11;
            this.f67865b = j11;
        }
    }

    public static String f(t tVar, int i11) throws IOException {
        if (i11 == 0) {
            return "";
        }
        byte[] bArr = new byte[i11];
        tVar.readFully(bArr, 0, i11);
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        return new String(bArr, 0, i11);
    }

    @Override // j5.c
    public boolean a(t tVar) throws IOException {
        z3.a.i(this.f67860d);
        while (true) {
            b bVarPeek = this.f67858b.peek();
            if (bVarPeek != null && tVar.getPosition() >= bVarPeek.f67865b) {
                this.f67860d.endMasterElement(this.f67858b.pop().f67864a);
                return true;
            }
            if (this.f67861e == 0) {
                long jD = this.f67859c.d(tVar, true, false, 4);
                if (jD == -2) {
                    jD = c(tVar);
                }
                if (jD == -1) {
                    return false;
                }
                this.f67862f = (int) jD;
                this.f67861e = 1;
            }
            if (this.f67861e == 1) {
                this.f67863g = this.f67859c.d(tVar, false, true, 8);
                this.f67861e = 2;
            }
            int elementType = this.f67860d.getElementType(this.f67862f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = tVar.getPosition();
                    this.f67858b.push(new b(this.f67862f, this.f67863g + position));
                    this.f67860d.startMasterElement(this.f67862f, position, this.f67863g);
                    this.f67861e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j11 = this.f67863g;
                    if (j11 <= 8) {
                        this.f67860d.integerElement(this.f67862f, e(tVar, (int) j11));
                        this.f67861e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.f67863g, null);
                }
                if (elementType == 3) {
                    long j12 = this.f67863g;
                    if (j12 <= 2147483647L) {
                        this.f67860d.stringElement(this.f67862f, f(tVar, (int) j12));
                        this.f67861e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.f67863g, null);
                }
                if (elementType == 4) {
                    this.f67860d.a(this.f67862f, (int) this.f67863g, tVar);
                    this.f67861e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                }
                long j13 = this.f67863g;
                if (j13 == 4 || j13 == 8) {
                    this.f67860d.floatElement(this.f67862f, d(tVar, (int) j13));
                    this.f67861e = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.f67863g, null);
            }
            tVar.skipFully((int) this.f67863g);
            this.f67861e = 0;
        }
    }

    @Override // j5.c
    public void b(j5.b bVar) {
        this.f67860d = bVar;
    }

    public final long c(t tVar) throws IOException {
        tVar.resetPeekPosition();
        while (true) {
            tVar.peekFully(this.f67857a, 0, 4);
            int iC = g.c(this.f67857a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) g.a(this.f67857a, iC, false);
                if (this.f67860d.isLevel1Element(iA)) {
                    tVar.skipFully(iC);
                    return iA;
                }
            }
            tVar.skipFully(1);
        }
    }

    public final double d(t tVar, int i11) throws IOException {
        long jE = e(tVar, i11);
        return i11 == 4 ? Float.intBitsToFloat((int) jE) : Double.longBitsToDouble(jE);
    }

    public final long e(t tVar, int i11) throws IOException {
        tVar.readFully(this.f67857a, 0, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | ((long) (this.f67857a[i12] & 255));
        }
        return j11;
    }

    @Override // j5.c
    public void reset() {
        this.f67861e = 0;
        this.f67858b.clear();
        this.f67859c.e();
    }
}
