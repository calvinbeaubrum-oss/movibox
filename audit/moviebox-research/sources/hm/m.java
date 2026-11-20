package hm;

import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f66529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f66530b;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f66531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f66532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f66533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f66534d;

        public b(char c11, g gVar, int i11, b bVar, int i12) {
            char c12 = c11 == i12 ? (char) 1000 : c11;
            this.f66531a = c12;
            this.f66532b = i11;
            this.f66533c = bVar;
            int length = c12 == 1000 ? 1 : gVar.b(c11, i11).length;
            length = (bVar == null ? 0 : bVar.f66532b) != i11 ? length + 3 : length;
            this.f66534d = bVar != null ? length + bVar.f66534d : length;
        }

        public boolean e() {
            return this.f66531a == 1000;
        }
    }

    public m(String str, Charset charset, int i11) {
        this.f66530b = i11;
        g gVar = new g(str, charset, i11);
        if (gVar.g() != 1) {
            this.f66529a = e(str, gVar, i11);
            return;
        }
        this.f66529a = new int[str.length()];
        for (int i12 = 0; i12 < this.f66529a.length; i12++) {
            char cCharAt = str.charAt(i12);
            int[] iArr = this.f66529a;
            if (cCharAt == i11) {
                cCharAt = 1000;
            }
            iArr[i12] = cCharAt;
        }
    }

    public static void c(b[][] bVarArr, int i11, b bVar) {
        if (bVarArr[i11][bVar.f66532b] == null || bVarArr[i11][bVar.f66532b].f66534d > bVar.f66534d) {
            bVarArr[i11][bVar.f66532b] = bVar;
        }
    }

    public static void d(String str, g gVar, b[][] bVarArr, int i11, b bVar, int i12) {
        int i13;
        int iF;
        char cCharAt = str.charAt(i11);
        int iG = gVar.g();
        if (gVar.f() < 0 || !(cCharAt == i12 || gVar.a(cCharAt, gVar.f()))) {
            i13 = iG;
            iF = 0;
        } else {
            iF = gVar.f();
            i13 = iF + 1;
        }
        for (int i14 = iF; i14 < i13; i14++) {
            if (cCharAt == i12 || gVar.a(cCharAt, i14)) {
                c(bVarArr, i11 + 1, new b(cCharAt, gVar, i14, bVar, i12));
            }
        }
    }

    public static int[] e(String str, g gVar, int i11) {
        int i12;
        int length = str.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, gVar.g());
        d(str, gVar, bVarArr, 0, null, i11);
        int i13 = 1;
        while (true) {
            i12 = 0;
            if (i13 > length) {
                break;
            }
            for (int i14 = 0; i14 < gVar.g(); i14++) {
                b bVar = bVarArr[i13][i14];
                if (bVar != null && i13 < length) {
                    d(str, gVar, bVarArr, i13, bVar, i11);
                }
            }
            while (i12 < gVar.g()) {
                bVarArr[i13 - 1][i12] = null;
                i12++;
            }
            i13++;
        }
        int i15 = -1;
        int i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i17 = 0; i17 < gVar.g(); i17++) {
            b bVar2 = bVarArr[length][i17];
            if (bVar2 != null && bVar2.f66534d < i16) {
                i16 = bVar2.f66534d;
                i15 = i17;
            }
        }
        if (i15 < 0) {
            throw new IllegalStateException("Failed to encode \"" + str + "\"");
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 = bVarArr[length][i15]; bVar3 != null; bVar3 = bVar3.f66533c) {
            if (bVar3.e()) {
                arrayList.add(0, 1000);
            } else {
                byte[] bArrB = gVar.b(bVar3.f66531a, bVar3.f66532b);
                for (int length2 = bArrB.length - 1; length2 >= 0; length2--) {
                    arrayList.add(0, Integer.valueOf(bArrB[length2] & 255));
                }
            }
            if ((bVar3.f66533c == null ? 0 : bVar3.f66533c.f66532b) != bVar3.f66532b) {
                arrayList.add(0, Integer.valueOf(gVar.e(bVar3.f66532b) + 256));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        while (i12 < size) {
            iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
            i12++;
        }
        return iArr;
    }

    @Override // hm.h
    public boolean a(int i11) {
        if (i11 >= 0 && i11 < length()) {
            int i12 = this.f66529a[i11];
            return i12 > 255 && i12 <= 999;
        }
        throw new IndexOutOfBoundsException("" + i11);
    }

    @Override // hm.h
    public int b(int i11) {
        if (i11 < 0 || i11 >= length()) {
            throw new IndexOutOfBoundsException("" + i11);
        }
        if (a(i11)) {
            return this.f66529a[i11] + InputDeviceCompat.SOURCE_ANY;
        }
        throw new IllegalArgumentException("value at " + i11 + " is not an ECI but a character");
    }

    @Override // hm.h
    public char charAt(int i11) {
        if (i11 < 0 || i11 >= length()) {
            throw new IndexOutOfBoundsException("" + i11);
        }
        if (!a(i11)) {
            return (char) (h(i11) ? this.f66530b : this.f66529a[i11]);
        }
        throw new IllegalArgumentException("value at " + i11 + " is not a character but an ECI");
    }

    public int f() {
        return this.f66530b;
    }

    public boolean g(int i11, int i12) {
        if ((i11 + i12) - 1 >= this.f66529a.length) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (a(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i11) {
        if (i11 >= 0 && i11 < length()) {
            return this.f66529a[i11] == 1000;
        }
        throw new IndexOutOfBoundsException("" + i11);
    }

    @Override // hm.h
    public int length() {
        return this.f66529a.length;
    }

    @Override // hm.h
    public CharSequence subSequence(int i11, int i12) {
        if (i11 < 0 || i11 > i12 || i12 > length()) {
            throw new IndexOutOfBoundsException("" + i11);
        }
        StringBuilder sb2 = new StringBuilder();
        while (i11 < i12) {
            if (a(i11)) {
                throw new IllegalArgumentException("value at " + i11 + " is not a character but an ECI");
            }
            sb2.append(charAt(i11));
            i11++;
        }
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < length(); i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            if (a(i11)) {
                sb2.append("ECI(");
                sb2.append(b(i11));
                sb2.append(')');
            } else if (charAt(i11) < 128) {
                sb2.append('\'');
                sb2.append(charAt(i11));
                sb2.append('\'');
            } else {
                sb2.append((int) charAt(i11));
            }
        }
        return sb2.toString();
    }
}
