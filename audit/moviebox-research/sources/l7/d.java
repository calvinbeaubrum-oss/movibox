package l7;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.MathContext;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ThreadLocal<char[]> f70111x = new ThreadLocal<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Reader f70112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public char[] f70113v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f70114w;

    @Override // l7.c
    public final void A0(int i11, int i12, char[] cArr) {
        System.arraycopy(this.f70113v, i11, cArr, 0, i12);
    }

    @Override // l7.c
    public final int D0(char c11, int i11) {
        int i12 = i11 - this.f70099f;
        while (true) {
            char cZ0 = z0(this.f70099f + i12);
            if (c11 == cZ0) {
                return i12 + this.f70099f;
            }
            if (cZ0 == 26) {
                return -1;
            }
            i12++;
        }
    }

    @Override // l7.c
    public boolean E0() {
        if (this.f70114w == -1) {
            return true;
        }
        int i11 = this.f70099f;
        char[] cArr = this.f70113v;
        if (i11 != cArr.length) {
            return this.f70098d == 26 && i11 + 1 >= cArr.length;
        }
        return true;
    }

    @Override // l7.c, l7.b
    public final BigDecimal Z() {
        int i11 = this.f70103j;
        if (i11 == -1) {
            i11 = 0;
        }
        char cZ0 = z0((this.f70102i + i11) - 1);
        int i12 = this.f70102i;
        if (cZ0 == 'L' || cZ0 == 'S' || cZ0 == 'B' || cZ0 == 'F' || cZ0 == 'D') {
            i12--;
        }
        if (i12 <= 65535) {
            return new BigDecimal(this.f70113v, i11, i12, MathContext.UNLIMITED);
        }
        throw new JSONException("decimal overflow");
    }

    @Override // l7.c, l7.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.f70113v;
        if (cArr.length <= 65536) {
            f70111x.set(cArr);
        }
        this.f70113v = null;
        com.alibaba.fastjson.util.f.a(this.f70112u);
    }

    @Override // l7.b
    public byte[] d0() {
        if (this.f70095a != 26) {
            return com.alibaba.fastjson.util.f.e(this.f70113v, this.f70103j + 1, this.f70102i);
        }
        throw new JSONException("TODO");
    }

    @Override // l7.c, l7.b
    public final String g0() {
        if (this.f70104k) {
            return new String(this.f70101h, 0, this.f70102i);
        }
        int i11 = this.f70103j + 1;
        if (i11 < 0) {
            throw new IllegalStateException();
        }
        char[] cArr = this.f70113v;
        int length = cArr.length;
        int i12 = this.f70102i;
        if (i11 <= length - i12) {
            return new String(cArr, i11, i12);
        }
        throw new IllegalStateException();
    }

    @Override // l7.c
    public final String k1(int i11, int i12) {
        if (i12 >= 0) {
            return new String(this.f70113v, i11, i12);
        }
        throw new StringIndexOutOfBoundsException(i12);
    }

    @Override // l7.c
    public final char[] l1(int i11, int i12) {
        if (i12 < 0) {
            throw new StringIndexOutOfBoundsException(i12);
        }
        if (i11 == 0) {
            return this.f70113v;
        }
        char[] cArr = new char[i12];
        System.arraycopy(this.f70113v, i11, cArr, 0, i12);
        return cArr;
    }

    @Override // l7.c, l7.b
    public final char next() {
        int i11 = this.f70099f + 1;
        this.f70099f = i11;
        int i12 = this.f70114w;
        if (i11 >= i12) {
            if (i12 == -1) {
                return (char) 26;
            }
            int i13 = this.f70102i;
            if (i13 > 0) {
                int i14 = i12 - i13;
                if (this.f70098d == '\"' && i14 > 0) {
                    i14--;
                }
                char[] cArr = this.f70113v;
                System.arraycopy(cArr, i14, cArr, 0, i13);
            }
            this.f70103j = -1;
            int i15 = this.f70102i;
            this.f70099f = i15;
            try {
                char[] cArr2 = this.f70113v;
                int length = cArr2.length - i15;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.f70113v = cArr3;
                    length = cArr3.length - i15;
                }
                int i16 = this.f70112u.read(this.f70113v, this.f70099f, length);
                this.f70114w = i16;
                if (i16 == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (i16 == -1) {
                    this.f70098d = (char) 26;
                    return (char) 26;
                }
                this.f70114w = i16 + this.f70099f;
                i11 = i15;
            } catch (IOException e11) {
                throw new JSONException(e11.getMessage(), e11);
            }
        }
        char c11 = this.f70113v[i11];
        this.f70098d = c11;
        return c11;
    }

    @Override // l7.c, l7.b
    public final boolean t() {
        int i11 = 0;
        while (true) {
            char c11 = this.f70113v[i11];
            if (c11 == 26) {
                this.f70095a = 20;
                return true;
            }
            if (!c.F0(c11)) {
                return false;
            }
            i11++;
        }
    }

    @Override // l7.c, l7.b
    public final String v0() {
        int i11 = this.f70103j;
        if (i11 == -1) {
            i11 = 0;
        }
        char cZ0 = z0((this.f70102i + i11) - 1);
        int i12 = this.f70102i;
        if (cZ0 == 'L' || cZ0 == 'S' || cZ0 == 'B' || cZ0 == 'F' || cZ0 == 'D') {
            i12--;
        }
        return new String(this.f70113v, i11, i12);
    }

    @Override // l7.c
    public final String w0(int i11, int i12, int i13, i iVar) {
        return iVar.c(this.f70113v, i11, i12, i13);
    }

    @Override // l7.c
    public final void x0(int i11, char[] cArr, int i12, int i13) {
        System.arraycopy(this.f70113v, i11, cArr, i12, i13);
    }

    @Override // l7.c
    public final boolean y0(char[] cArr) {
        for (int i11 = 0; i11 < cArr.length; i11++) {
            if (z0(this.f70099f + i11) != cArr[i11]) {
                return false;
            }
        }
        return true;
    }

    @Override // l7.c
    public final char z0(int i11) {
        int i12 = this.f70114w;
        if (i11 >= i12) {
            if (i12 == -1) {
                if (i11 < this.f70102i) {
                    return this.f70113v[i11];
                }
                return (char) 26;
            }
            int i13 = this.f70099f;
            if (i13 == 0) {
                char[] cArr = this.f70113v;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i13, cArr2, 0, i12);
                int i14 = this.f70114w;
                try {
                    this.f70114w += this.f70112u.read(cArr2, i14, length - i14);
                    this.f70113v = cArr2;
                } catch (IOException e11) {
                    throw new JSONException(e11.getMessage(), e11);
                }
            } else {
                int i15 = i12 - i13;
                if (i15 > 0) {
                    char[] cArr3 = this.f70113v;
                    System.arraycopy(cArr3, i13, cArr3, 0, i15);
                }
                try {
                    Reader reader = this.f70112u;
                    char[] cArr4 = this.f70113v;
                    int i16 = reader.read(cArr4, i15, cArr4.length - i15);
                    this.f70114w = i16;
                    if (i16 == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (i16 == -1) {
                        return (char) 26;
                    }
                    this.f70114w = i16 + i15;
                    int i17 = this.f70099f;
                    i11 -= i17;
                    this.f70103j -= i17;
                    this.f70099f = 0;
                } catch (IOException e12) {
                    throw new JSONException(e12.getMessage(), e12);
                }
            }
        }
        return this.f70113v[i11];
    }
}
