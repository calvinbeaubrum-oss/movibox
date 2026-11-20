package z3;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f81768a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f81769b = {"", "A", "B", "C"};

    public static String a(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static List<byte[]> b(boolean z11) {
        return Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i11, boolean z11, int i12, int i13, int[] iArr, int i14) {
        Object[] objArr = new Object[5];
        objArr[0] = f81769b[i11];
        objArr[1] = Integer.valueOf(i12);
        objArr[2] = Integer.valueOf(i13);
        objArr[3] = Character.valueOf(z11 ? 'H' : 'L');
        objArr[4] = Integer.valueOf(i14);
        StringBuilder sb2 = new StringBuilder(u0.G("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i15 = 0; i15 < length; i15++) {
            sb2.append(String.format(".%02X", Integer.valueOf(iArr[i15])));
        }
        return sb2.toString();
    }

    public static byte[] d(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = f81768a;
        byte[] bArr3 = new byte[bArr2.length + i12];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i11, bArr3, bArr2.length, i12);
        return bArr3;
    }

    public static Pair<Integer, Integer> e(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        c0Var.U(9);
        int iH = c0Var.H();
        c0Var.U(20);
        return Pair.create(Integer.valueOf(c0Var.L()), Integer.valueOf(iH));
    }

    public static boolean f(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }
}
