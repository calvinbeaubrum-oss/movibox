package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c6.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f12373a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f12374b = {112, 114, 109, 0};

    public static void A(@NonNull InputStream inputStream) throws IOException {
        c6.d.h(inputStream);
        int iJ = c6.d.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            c6.d.j(inputStream);
            for (int iJ2 = c6.d.j(inputStream); iJ2 > 0; iJ2--) {
                c6.d.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(@NonNull OutputStream outputStream, @NonNull byte[] bArr, @NonNull c6.c[] cVarArr) throws IOException {
        if (Arrays.equals(bArr, k.f14653a)) {
            N(outputStream, cVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f14654b)) {
            M(outputStream, cVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f14656d)) {
            K(outputStream, cVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f14655c)) {
            L(outputStream, cVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, k.f14657e)) {
            return false;
        }
        J(outputStream, cVarArr);
        return true;
    }

    public static void C(@NonNull OutputStream outputStream, @NonNull c6.c cVar) throws IOException {
        int iIntValue = 0;
        for (int i11 : cVar.f14643h) {
            Integer numValueOf = Integer.valueOf(i11);
            c6.d.p(outputStream, numValueOf.intValue() - iIntValue);
            iIntValue = numValueOf.intValue();
        }
    }

    public static f D(@NonNull c6.c[] cVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c6.d.p(byteArrayOutputStream, cVarArr.length);
            int i11 = 2;
            for (c6.c cVar : cVarArr) {
                c6.d.q(byteArrayOutputStream, cVar.f14638c);
                c6.d.q(byteArrayOutputStream, cVar.f14639d);
                c6.d.q(byteArrayOutputStream, cVar.f14642g);
                String strJ = j(cVar.f14636a, cVar.f14637b, k.f14653a);
                int iK = c6.d.k(strJ);
                c6.d.p(byteArrayOutputStream, iK);
                i11 = i11 + 14 + iK;
                c6.d.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i11 == byteArray.length) {
                f fVar = new f(FileSectionType.DEX_FILES, i11, byteArray, false);
                byteArrayOutputStream.close();
                return fVar;
            }
            throw c6.d.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static void E(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f12373a);
        outputStream.write(bArr);
    }

    public static void F(@NonNull OutputStream outputStream, @NonNull c6.c cVar) throws IOException {
        I(outputStream, cVar);
        C(outputStream, cVar);
        H(outputStream, cVar);
    }

    public static void G(@NonNull OutputStream outputStream, @NonNull c6.c cVar, @NonNull String str) throws IOException {
        c6.d.p(outputStream, c6.d.k(str));
        c6.d.p(outputStream, cVar.f14640e);
        c6.d.q(outputStream, cVar.f14641f);
        c6.d.q(outputStream, cVar.f14638c);
        c6.d.q(outputStream, cVar.f14642g);
        c6.d.n(outputStream, str);
    }

    public static void H(@NonNull OutputStream outputStream, @NonNull c6.c cVar) throws IOException {
        byte[] bArr = new byte[k(cVar.f14642g)];
        for (Map.Entry<Integer, Integer> entry : cVar.f14644i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, cVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, cVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(@NonNull OutputStream outputStream, @NonNull c6.c cVar) throws IOException {
        int i11 = 0;
        for (Map.Entry<Integer, Integer> entry : cVar.f14644i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                c6.d.p(outputStream, iIntValue - i11);
                c6.d.p(outputStream, 0);
                i11 = iIntValue;
            }
        }
    }

    public static void J(@NonNull OutputStream outputStream, @NonNull c6.c[] cVarArr) throws IOException {
        c6.d.p(outputStream, cVarArr.length);
        for (c6.c cVar : cVarArr) {
            String strJ = j(cVar.f14636a, cVar.f14637b, k.f14657e);
            c6.d.p(outputStream, c6.d.k(strJ));
            c6.d.p(outputStream, cVar.f14644i.size());
            c6.d.p(outputStream, cVar.f14643h.length);
            c6.d.q(outputStream, cVar.f14638c);
            c6.d.n(outputStream, strJ);
            Iterator<Integer> it = cVar.f14644i.keySet().iterator();
            while (it.hasNext()) {
                c6.d.p(outputStream, it.next().intValue());
            }
            for (int i11 : cVar.f14643h) {
                c6.d.p(outputStream, i11);
            }
        }
    }

    public static void K(@NonNull OutputStream outputStream, @NonNull c6.c[] cVarArr) throws IOException {
        c6.d.r(outputStream, cVarArr.length);
        for (c6.c cVar : cVarArr) {
            int size = cVar.f14644i.size() * 4;
            String strJ = j(cVar.f14636a, cVar.f14637b, k.f14656d);
            c6.d.p(outputStream, c6.d.k(strJ));
            c6.d.p(outputStream, cVar.f14643h.length);
            c6.d.q(outputStream, size);
            c6.d.q(outputStream, cVar.f14638c);
            c6.d.n(outputStream, strJ);
            Iterator<Integer> it = cVar.f14644i.keySet().iterator();
            while (it.hasNext()) {
                c6.d.p(outputStream, it.next().intValue());
                c6.d.p(outputStream, 0);
            }
            for (int i11 : cVar.f14643h) {
                c6.d.p(outputStream, i11);
            }
        }
    }

    public static void L(@NonNull OutputStream outputStream, @NonNull c6.c[] cVarArr) throws IOException {
        byte[] bArrB = b(cVarArr, k.f14655c);
        c6.d.r(outputStream, cVarArr.length);
        c6.d.m(outputStream, bArrB);
    }

    public static void M(@NonNull OutputStream outputStream, @NonNull c6.c[] cVarArr) throws IOException {
        byte[] bArrB = b(cVarArr, k.f14654b);
        c6.d.r(outputStream, cVarArr.length);
        c6.d.m(outputStream, bArrB);
    }

    public static void N(@NonNull OutputStream outputStream, @NonNull c6.c[] cVarArr) throws IOException {
        O(outputStream, cVarArr);
    }

    public static void O(@NonNull OutputStream outputStream, @NonNull c6.c[] cVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(cVarArr));
        arrayList.add(c(cVarArr));
        arrayList.add(d(cVarArr));
        long length2 = ((long) k.f14653a.length) + ((long) f12373a.length) + 4 + ((long) (arrayList.size() * 16));
        c6.d.q(outputStream, arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            f fVar = (f) arrayList.get(i11);
            c6.d.q(outputStream, fVar.f12385a.getValue());
            c6.d.q(outputStream, length2);
            if (fVar.f12388d) {
                byte[] bArr = fVar.f12387c;
                long length3 = bArr.length;
                byte[] bArrB = c6.d.b(bArr);
                arrayList2.add(bArrB);
                c6.d.q(outputStream, bArrB.length);
                c6.d.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(fVar.f12387c);
                c6.d.q(outputStream, fVar.f12387c.length);
                c6.d.q(outputStream, 0L);
                length = fVar.f12387c.length;
            }
            length2 += (long) length;
        }
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            outputStream.write((byte[]) arrayList2.get(i12));
        }
    }

    public static int a(@NonNull c6.c cVar) {
        Iterator<Map.Entry<Integer, Integer>> it = cVar.f14644i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= it.next().getValue().intValue();
        }
        return iIntValue;
    }

    @NonNull
    public static byte[] b(@NonNull c6.c[] cVarArr, @NonNull byte[] bArr) throws IOException {
        int i11 = 0;
        int iK = 0;
        for (c6.c cVar : cVarArr) {
            iK += c6.d.k(j(cVar.f14636a, cVar.f14637b, bArr)) + 16 + (cVar.f14640e * 2) + cVar.f14641f + k(cVar.f14642g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, k.f14655c)) {
            int length = cVarArr.length;
            while (i11 < length) {
                c6.c cVar2 = cVarArr[i11];
                G(byteArrayOutputStream, cVar2, j(cVar2.f14636a, cVar2.f14637b, bArr));
                F(byteArrayOutputStream, cVar2);
                i11++;
            }
        } else {
            for (c6.c cVar3 : cVarArr) {
                G(byteArrayOutputStream, cVar3, j(cVar3.f14636a, cVar3.f14637b, bArr));
            }
            int length2 = cVarArr.length;
            while (i11 < length2) {
                F(byteArrayOutputStream, cVarArr[i11]);
                i11++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw c6.d.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static f c(@NonNull c6.c[] cVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        for (int i12 = 0; i12 < cVarArr.length; i12++) {
            try {
                c6.c cVar = cVarArr[i12];
                c6.d.p(byteArrayOutputStream, i12);
                c6.d.p(byteArrayOutputStream, cVar.f14640e);
                i11 = i11 + 4 + (cVar.f14640e * 2);
                C(byteArrayOutputStream, cVar);
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            f fVar = new f(FileSectionType.CLASSES, i11, byteArray, true);
            byteArrayOutputStream.close();
            return fVar;
        }
        throw c6.d.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
    }

    public static f d(@NonNull c6.c[] cVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        for (int i12 = 0; i12 < cVarArr.length; i12++) {
            try {
                c6.c cVar = cVarArr[i12];
                int iA = a(cVar);
                byte[] bArrE = e(cVar);
                byte[] bArrF = f(cVar);
                c6.d.p(byteArrayOutputStream, i12);
                int length = bArrE.length + 2 + bArrF.length;
                c6.d.q(byteArrayOutputStream, length);
                c6.d.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i11 = i11 + 6 + length;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            f fVar = new f(FileSectionType.METHODS, i11, byteArray, true);
            byteArrayOutputStream.close();
            return fVar;
        }
        throw c6.d.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(@NonNull c6.c cVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, cVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static byte[] f(@NonNull c6.c cVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, cVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @NonNull
    public static String g(@NonNull String str, @NonNull String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        return ":".equals(str2) ? str.replace("!", ":") : str;
    }

    @NonNull
    public static String h(@NonNull String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    @Nullable
    public static c6.c i(@NonNull c6.c[] cVarArr, @NonNull String str) {
        if (cVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i11 = 0; i11 < cVarArr.length; i11++) {
            if (cVarArr[i11].f14637b.equals(strH)) {
                return cVarArr[i11];
            }
        }
        return null;
    }

    @NonNull
    public static String j(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        String strA = k.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + k.a(bArr) + str2;
    }

    public static int k(int i11) {
        return y(i11 * 2) / 8;
    }

    public static int l(int i11, int i12, int i13) {
        if (i11 == 1) {
            throw c6.d.c("HOT methods are not stored in the bitmap");
        }
        if (i11 == 2) {
            return i12;
        }
        if (i11 == 4) {
            return i12 + i13;
        }
        throw c6.d.c("Unexpected flag: " + i11);
    }

    public static int[] m(@NonNull InputStream inputStream, int i11) throws IOException {
        int[] iArr = new int[i11];
        int iH = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            iH += c6.d.h(inputStream);
            iArr[i12] = iH;
        }
        return iArr;
    }

    public static int n(@NonNull BitSet bitSet, int i11, int i12) {
        int i13 = bitSet.get(l(2, i11, i12)) ? 2 : 0;
        return bitSet.get(l(4, i11, i12)) ? i13 | 4 : i13;
    }

    public static byte[] o(@NonNull InputStream inputStream, @NonNull byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, c6.d.d(inputStream, bArr.length))) {
            return c6.d.d(inputStream, k.f14654b.length);
        }
        throw c6.d.c("Invalid magic");
    }

    public static void p(@NonNull InputStream inputStream, @NonNull c6.c cVar) throws IOException {
        int iAvailable = inputStream.available() - cVar.f14641f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += c6.d.h(inputStream);
            cVar.f14644i.put(Integer.valueOf(iH), 1);
            for (int iH2 = c6.d.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw c6.d.c("Read too much data during profile line parse");
        }
    }

    @NonNull
    public static c6.c[] q(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull byte[] bArr2, c6.c[] cVarArr) throws IOException {
        if (Arrays.equals(bArr, k.f14658f)) {
            if (Arrays.equals(k.f14653a, bArr2)) {
                throw c6.d.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, cVarArr);
        }
        if (Arrays.equals(bArr, k.f14659g)) {
            return t(inputStream, bArr2, cVarArr);
        }
        throw c6.d.c("Unsupported meta version");
    }

    @NonNull
    public static c6.c[] r(@NonNull InputStream inputStream, @NonNull byte[] bArr, c6.c[] cVarArr) throws IOException {
        if (!Arrays.equals(bArr, k.f14658f)) {
            throw c6.d.c("Unsupported meta version");
        }
        int iJ = c6.d.j(inputStream);
        byte[] bArrE = c6.d.e(inputStream, (int) c6.d.i(inputStream), (int) c6.d.i(inputStream));
        if (inputStream.read() > 0) {
            throw c6.d.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            c6.c[] cVarArrS = s(byteArrayInputStream, iJ, cVarArr);
            byteArrayInputStream.close();
            return cVarArrS;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @NonNull
    public static c6.c[] s(@NonNull InputStream inputStream, int i11, c6.c[] cVarArr) throws IOException {
        if (inputStream.available() == 0) {
            return new c6.c[0];
        }
        if (i11 != cVarArr.length) {
            throw c6.d.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i11];
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int iH = c6.d.h(inputStream);
            iArr[i12] = c6.d.h(inputStream);
            strArr[i12] = c6.d.f(inputStream, iH);
        }
        for (int i13 = 0; i13 < i11; i13++) {
            c6.c cVar = cVarArr[i13];
            if (!cVar.f14637b.equals(strArr[i13])) {
                throw c6.d.c("Order of dexfiles in metadata did not match baseline");
            }
            int i14 = iArr[i13];
            cVar.f14640e = i14;
            cVar.f14643h = m(inputStream, i14);
        }
        return cVarArr;
    }

    @NonNull
    public static c6.c[] t(@NonNull InputStream inputStream, @NonNull byte[] bArr, c6.c[] cVarArr) throws IOException {
        int iH = c6.d.h(inputStream);
        byte[] bArrE = c6.d.e(inputStream, (int) c6.d.i(inputStream), (int) c6.d.i(inputStream));
        if (inputStream.read() > 0) {
            throw c6.d.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            c6.c[] cVarArrU = u(byteArrayInputStream, bArr, iH, cVarArr);
            byteArrayInputStream.close();
            return cVarArrU;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @NonNull
    public static c6.c[] u(@NonNull InputStream inputStream, @NonNull byte[] bArr, int i11, c6.c[] cVarArr) throws IOException {
        if (inputStream.available() == 0) {
            return new c6.c[0];
        }
        if (i11 != cVarArr.length) {
            throw c6.d.c("Mismatched number of dex files found in metadata");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            c6.d.h(inputStream);
            String strF = c6.d.f(inputStream, c6.d.h(inputStream));
            long jI = c6.d.i(inputStream);
            int iH = c6.d.h(inputStream);
            c6.c cVarI = i(cVarArr, strF);
            if (cVarI == null) {
                throw c6.d.c("Missing profile key: " + strF);
            }
            cVarI.f14639d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, k.f14657e)) {
                cVarI.f14640e = iH;
                cVarI.f14643h = iArrM;
            }
        }
        return cVarArr;
    }

    public static void v(@NonNull InputStream inputStream, @NonNull c6.c cVar) throws IOException {
        BitSet bitSetValueOf = BitSet.valueOf(c6.d.d(inputStream, c6.d.a(cVar.f14642g * 2)));
        int i11 = 0;
        while (true) {
            int i12 = cVar.f14642g;
            if (i11 >= i12) {
                return;
            }
            int iN = n(bitSetValueOf, i11, i12);
            if (iN != 0) {
                Integer num = cVar.f14644i.get(Integer.valueOf(i11));
                if (num == null) {
                    num = 0;
                }
                cVar.f14644i.put(Integer.valueOf(i11), Integer.valueOf(iN | num.intValue()));
            }
            i11++;
        }
    }

    @NonNull
    public static c6.c[] w(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull String str) throws IOException {
        if (!Arrays.equals(bArr, k.f14654b)) {
            throw c6.d.c("Unsupported version");
        }
        int iJ = c6.d.j(inputStream);
        byte[] bArrE = c6.d.e(inputStream, (int) c6.d.i(inputStream), (int) c6.d.i(inputStream));
        if (inputStream.read() > 0) {
            throw c6.d.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            c6.c[] cVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return cVarArrX;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @NonNull
    public static c6.c[] x(@NonNull InputStream inputStream, @NonNull String str, int i11) throws IOException {
        if (inputStream.available() == 0) {
            return new c6.c[0];
        }
        c6.c[] cVarArr = new c6.c[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int iH = c6.d.h(inputStream);
            int iH2 = c6.d.h(inputStream);
            long jI = c6.d.i(inputStream);
            cVarArr[i12] = new c6.c(str, c6.d.f(inputStream, iH), c6.d.i(inputStream), 0L, iH2, (int) jI, (int) c6.d.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i13 = 0; i13 < i11; i13++) {
            c6.c cVar = cVarArr[i13];
            p(inputStream, cVar);
            cVar.f14643h = m(inputStream, cVar.f14640e);
            v(inputStream, cVar);
        }
        return cVarArr;
    }

    public static int y(int i11) {
        return (i11 + 7) & (-8);
    }

    public static void z(@NonNull byte[] bArr, int i11, int i12, @NonNull c6.c cVar) {
        int iL = l(i11, i12, cVar.f14642g);
        int i13 = iL / 8;
        bArr[i13] = (byte) ((1 << (iL % 8)) | bArr[i13]);
    }
}
