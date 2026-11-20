package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.SerializationException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements Iterable<org.jsoup.nodes.a>, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f73096d = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f73097a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f73098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f73099c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator<org.jsoup.nodes.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f73100a = 0;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.jsoup.nodes.a next() {
            b bVar = b.this;
            String[] strArr = bVar.f73098b;
            int i11 = this.f73100a;
            org.jsoup.nodes.a aVar = new org.jsoup.nodes.a(strArr[i11], bVar.f73099c[i11], bVar);
            this.f73100a++;
            return aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f73100a < b.this.f73097a;
        }

        @Override // java.util.Iterator
        public void remove() {
            b bVar = b.this;
            int i11 = this.f73100a - 1;
            this.f73100a = i11;
            bVar.J(i11);
        }
    }

    public b() {
        String[] strArr = f73096d;
        this.f73098b = strArr;
        this.f73099c = strArr;
    }

    public static String r(String str) {
        return str == null ? "" : str;
    }

    public static String[] v(String[] strArr, int i11) {
        String[] strArr2 = new String[i11];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i11));
        return strArr2;
    }

    public boolean A(String str) {
        return E(str) != -1;
    }

    public String B() {
        StringBuilder sb2 = new StringBuilder();
        try {
            C(sb2, new Document("").j1());
            return sb2.toString();
        } catch (IOException e11) {
            throw new SerializationException(e11);
        }
    }

    public final void C(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i11 = this.f73097a;
        for (int i12 = 0; i12 < i11; i12++) {
            String str = this.f73098b[i12];
            String str2 = this.f73099c[i12];
            appendable.append(' ').append(str);
            if (!org.jsoup.nodes.a.k(str, str2, outputSettings)) {
                appendable.append("=\"");
                if (str2 == null) {
                    str2 = "";
                }
                Entities.e(appendable, str2, outputSettings, true, false, false);
                appendable.append('\"');
            }
        }
    }

    public int D(String str) {
        d30.d.j(str);
        for (int i11 = 0; i11 < this.f73097a; i11++) {
            if (str.equals(this.f73098b[i11])) {
                return i11;
            }
        }
        return -1;
    }

    public final int E(String str) {
        d30.d.j(str);
        for (int i11 = 0; i11 < this.f73097a; i11++) {
            if (str.equalsIgnoreCase(this.f73098b[i11])) {
                return i11;
            }
        }
        return -1;
    }

    public void F() {
        for (int i11 = 0; i11 < this.f73097a; i11++) {
            String[] strArr = this.f73098b;
            strArr[i11] = e30.b.a(strArr[i11]);
        }
    }

    public b G(String str, String str2) {
        int iD = D(str);
        if (iD != -1) {
            this.f73099c[iD] = str2;
        } else {
            f(str, str2);
        }
        return this;
    }

    public b H(org.jsoup.nodes.a aVar) {
        d30.d.j(aVar);
        G(aVar.getKey(), aVar.getValue());
        aVar.f73095c = this;
        return this;
    }

    public void I(String str, String str2) {
        int iE = E(str);
        if (iE == -1) {
            f(str, str2);
            return;
        }
        this.f73099c[iE] = str2;
        if (this.f73098b[iE].equals(str)) {
            return;
        }
        this.f73098b[iE] = str;
    }

    public final void J(int i11) {
        d30.d.b(i11 >= this.f73097a);
        int i12 = (this.f73097a - i11) - 1;
        if (i12 > 0) {
            String[] strArr = this.f73098b;
            int i13 = i11 + 1;
            System.arraycopy(strArr, i13, strArr, i11, i12);
            String[] strArr2 = this.f73099c;
            System.arraycopy(strArr2, i13, strArr2, i11, i12);
        }
        int i14 = this.f73097a - 1;
        this.f73097a = i14;
        this.f73098b[i14] = null;
        this.f73099c[i14] = null;
    }

    public void K(String str) {
        int iD = D(str);
        if (iD != -1) {
            J(iD);
        }
    }

    public void L(String str) {
        int iE = E(str);
        if (iE != -1) {
            J(iE);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f73097a == bVar.f73097a && Arrays.equals(this.f73098b, bVar.f73098b)) {
            return Arrays.equals(this.f73099c, bVar.f73099c);
        }
        return false;
    }

    public final void f(String str, String str2) {
        o(this.f73097a + 1);
        String[] strArr = this.f73098b;
        int i11 = this.f73097a;
        strArr[i11] = str;
        this.f73099c[i11] = str2;
        this.f73097a = i11 + 1;
    }

    public void g(b bVar) {
        if (bVar.size() == 0) {
            return;
        }
        o(this.f73097a + bVar.f73097a);
        Iterator<org.jsoup.nodes.a> it = bVar.iterator();
        while (it.hasNext()) {
            H(it.next());
        }
    }

    public int hashCode() {
        return (((this.f73097a * 31) + Arrays.hashCode(this.f73098b)) * 31) + Arrays.hashCode(this.f73099c);
    }

    @Override // java.lang.Iterable
    public Iterator<org.jsoup.nodes.a> iterator() {
        return new a();
    }

    public List<org.jsoup.nodes.a> j() {
        ArrayList arrayList = new ArrayList(this.f73097a);
        for (int i11 = 0; i11 < this.f73097a; i11++) {
            arrayList.add(this.f73099c[i11] == null ? new f30.a(this.f73098b[i11]) : new org.jsoup.nodes.a(this.f73098b[i11], this.f73099c[i11], this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final void o(int i11) {
        d30.d.d(i11 >= this.f73097a);
        String[] strArr = this.f73098b;
        int length = strArr.length;
        if (length >= i11) {
            return;
        }
        int i12 = length >= 4 ? this.f73097a * 2 : 4;
        if (i11 <= i12) {
            i11 = i12;
        }
        this.f73098b = v(strArr, i11);
        this.f73099c = v(this.f73099c, i11);
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f73097a = this.f73097a;
            this.f73098b = v(this.f73098b, this.f73097a);
            this.f73099c = v(this.f73099c, this.f73097a);
            return bVar;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public int size() {
        return this.f73097a;
    }

    public String toString() {
        return B();
    }

    public String x(String str) {
        int iD = D(str);
        return iD == -1 ? "" : r(this.f73099c[iD]);
    }

    public String y(String str) {
        int iE = E(str);
        return iE == -1 ? "" : r(this.f73099c[iE]);
    }

    public boolean z(String str) {
        return D(str) != -1;
    }
}
