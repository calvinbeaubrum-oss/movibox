package athena;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f13743c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Character, Integer> f13744d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13745a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f13746b = 0;

    static {
        for (int i11 = 0; i11 < 32; i11++) {
            f13744d.put(Character.valueOf(f13743c[i11]), Integer.valueOf(i11));
        }
    }

    public s0(double d11, double d12, int i11) {
        int iMin = Math.min(i11, 64);
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        boolean z11 = true;
        while (this.f13746b < iMin) {
            if (z11) {
                c(d12, dArr2);
            } else {
                c(d11, dArr);
            }
            z11 = !z11;
        }
        this.f13745a <<= 64 - iMin;
    }

    public static s0 a(double d11, double d12, int i11) {
        if (i11 > 12) {
            throw new IllegalArgumentException("A geohash can only be 12 character long.");
        }
        int i12 = i11 * 5;
        return new s0(d11, d12, i12 <= 60 ? i12 : 60);
    }

    public String b() {
        if (this.f13746b % 5 != 0) {
            throw new IllegalStateException("Cannot convert a geohash to base32 if the precision is not a multiple of 5.");
        }
        StringBuilder sb2 = new StringBuilder();
        long j11 = this.f13745a;
        int iCeil = (int) Math.ceil(((double) this.f13746b) / 5.0d);
        for (int i11 = 0; i11 < iCeil; i11++) {
            sb2.append(f13743c[(int) (((-576460752303423488L) & j11) >>> 59)]);
            j11 <<= 5;
        }
        return sb2.toString();
    }

    public final void c(double d11, double[] dArr) {
        double d12 = (dArr[0] + dArr[1]) / 2.0d;
        if (d11 >= d12) {
            this.f13746b = (byte) (this.f13746b + 1);
            this.f13745a = (this.f13745a << 1) | 1;
            dArr[0] = d12;
        } else {
            this.f13746b = (byte) (this.f13746b + 1);
            this.f13745a <<= 1;
            dArr[1] = d12;
        }
    }
}
