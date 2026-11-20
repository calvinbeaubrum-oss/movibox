package tm;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f77242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77243c;

    public o(int i11, int i12, int i13) throws FormatException {
        super(i11);
        if (i12 < 0 || i12 > 10 || i13 < 0 || i13 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f77242b = i12;
        this.f77243c = i13;
    }

    public int b() {
        return this.f77242b;
    }

    public int c() {
        return this.f77243c;
    }

    public boolean d() {
        return this.f77242b == 10;
    }

    public boolean e() {
        return this.f77243c == 10;
    }
}
