package com.cloud.hisavana.sdk;

import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class m1<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public static Object[] f29856d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f29857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public static Object[] f29858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f29859h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f29860a = s3.f30040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f29861b = s3.f30042c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29862c = 0;

    public static int e(int[] iArr, int i11, int i12) {
        try {
            return s3.a(iArr, i11, i12);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void h(int[] iArr, Object[] objArr, int i11) {
        if (iArr.length == 8) {
            synchronized (k1.class) {
                try {
                    if (f29859h < 10) {
                        objArr[0] = f29858g;
                        objArr[1] = iArr;
                        for (int i12 = (i11 << 1) - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f29858g = objArr;
                        f29859h++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (k1.class) {
                try {
                    if (f29857f < 10) {
                        objArr[0] = f29856d;
                        objArr[1] = iArr;
                        for (int i13 = (i11 << 1) - 1; i13 >= 2; i13--) {
                            objArr[i13] = null;
                        }
                        f29856d = objArr;
                        f29857f++;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public int a() {
        int i11 = this.f29862c;
        if (i11 == 0) {
            return -1;
        }
        int iE = e(this.f29860a, i11, 0);
        if (iE < 0 || this.f29861b[iE << 1] == null) {
            return iE;
        }
        int i12 = iE + 1;
        while (i12 < i11 && this.f29860a[i12] == 0) {
            if (this.f29861b[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iE - 1; i13 >= 0 && this.f29860a[i13] == 0; i13--) {
            if (this.f29861b[i13 << 1] == null) {
                return i13;
            }
        }
        return ~i12;
    }

    public int c(@Nullable Object obj) {
        return obj == null ? a() : d(obj, obj.hashCode());
    }

    public void clear() {
        int i11 = this.f29862c;
        if (i11 > 0) {
            int[] iArr = this.f29860a;
            Object[] objArr = this.f29861b;
            this.f29860a = s3.f30040a;
            this.f29861b = s3.f30042c;
            this.f29862c = 0;
            h(iArr, objArr, i11);
        }
        if (this.f29862c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        return c(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public int d(Object obj, int i11) {
        int i12 = this.f29862c;
        if (i12 == 0) {
            return -1;
        }
        int iE = e(this.f29860a, i12, i11);
        if (iE < 0 || obj.equals(this.f29861b[iE << 1])) {
            return iE;
        }
        int i13 = iE + 1;
        while (i13 < i12 && this.f29860a[i13] == i11) {
            if (obj.equals(this.f29861b[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        for (int i14 = iE - 1; i14 >= 0 && this.f29860a[i14] == i11; i14--) {
            if (obj.equals(this.f29861b[i14 << 1])) {
                return i14;
            }
        }
        return ~i13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m1) {
            m1 m1Var = (m1) obj;
            if (size() != m1Var.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f29862c; i11++) {
                try {
                    K k11 = k(i11);
                    V vM = m(i11);
                    Object obj2 = m1Var.get(k11);
                    if (vM == null) {
                        if (obj2 != null || !m1Var.containsKey(k11)) {
                            return false;
                        }
                    } else if (!vM.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i12 = 0; i12 < this.f29862c; i12++) {
                try {
                    K k12 = k(i12);
                    V vM2 = m(i12);
                    Object obj3 = map.get(k12);
                    if (vM2 == null) {
                        if (obj3 != null || !map.containsKey(k12)) {
                            return false;
                        }
                    } else if (!vM2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V f(int i11, V v11) {
        int i12 = (i11 << 1) + 1;
        Object[] objArr = this.f29861b;
        V v12 = (V) objArr[i12];
        objArr[i12] = v11;
        return v12;
    }

    public final void g(int i11) {
        if (i11 == 8) {
            synchronized (k1.class) {
                try {
                    Object[] objArr = f29858g;
                    if (objArr != null) {
                        this.f29861b = objArr;
                        f29858g = (Object[]) objArr[0];
                        this.f29860a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f29859h--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else if (i11 == 4) {
            synchronized (k1.class) {
                try {
                    Object[] objArr2 = f29856d;
                    if (objArr2 != null) {
                        this.f29861b = objArr2;
                        f29856d = (Object[]) objArr2[0];
                        this.f29860a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f29857f--;
                        return;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        this.f29860a = new int[i11];
        this.f29861b = new Object[i11 << 1];
    }

    @Nullable
    public V get(Object obj) {
        int iC = c(obj);
        if (iC >= 0) {
            return (V) this.f29861b[(iC << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f29860a;
        Object[] objArr = this.f29861b;
        int i11 = this.f29862c;
        int i12 = 1;
        int i13 = 0;
        int iHashCode = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i13];
            i13++;
            i12 += 2;
        }
        return iHashCode;
    }

    public int i(Object obj) {
        int i11 = this.f29862c * 2;
        Object[] objArr = this.f29861b;
        if (obj == null) {
            for (int i12 = 1; i12 < i11; i12 += 2) {
                if (objArr[i12] == null) {
                    return i12 >> 1;
                }
            }
            return -1;
        }
        for (int i13 = 1; i13 < i11; i13 += 2) {
            if (obj.equals(objArr[i13])) {
                return i13 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.f29862c <= 0;
    }

    public void j(int i11) {
        int i12 = this.f29862c;
        int[] iArr = this.f29860a;
        if (iArr.length < i11) {
            Object[] objArr = this.f29861b;
            g(i11);
            if (this.f29862c > 0) {
                System.arraycopy(iArr, 0, this.f29860a, 0, i12);
                System.arraycopy(objArr, 0, this.f29861b, 0, i12 << 1);
            }
            h(iArr, objArr, i12);
        }
        if (this.f29862c != i12) {
            throw new ConcurrentModificationException();
        }
    }

    public K k(int i11) {
        return (K) this.f29861b[i11 << 1];
    }

    public V l(int i11) {
        Object[] objArr = this.f29861b;
        int i12 = i11 << 1;
        V v11 = (V) objArr[i12 + 1];
        int i13 = this.f29862c;
        int i14 = 0;
        if (i13 <= 1) {
            h(this.f29860a, objArr, i13);
            this.f29860a = s3.f30040a;
            this.f29861b = s3.f30042c;
        } else {
            int i15 = i13 - 1;
            int[] iArr = this.f29860a;
            if (iArr.length <= 8 || i13 >= iArr.length / 3) {
                if (i11 < i15) {
                    int i16 = i11 + 1;
                    int i17 = i15 - i11;
                    System.arraycopy(iArr, i16, iArr, i11, i17);
                    Object[] objArr2 = this.f29861b;
                    System.arraycopy(objArr2, i16 << 1, objArr2, i12, i17 << 1);
                }
                Object[] objArr3 = this.f29861b;
                int i18 = i15 << 1;
                objArr3[i18] = null;
                objArr3[i18 + 1] = null;
            } else {
                g(i13 > 8 ? i13 + (i13 >> 1) : 8);
                if (i13 != this.f29862c) {
                    throw new ConcurrentModificationException();
                }
                if (i11 > 0) {
                    System.arraycopy(iArr, 0, this.f29860a, 0, i11);
                    System.arraycopy(objArr, 0, this.f29861b, 0, i12);
                }
                if (i11 < i15) {
                    int i19 = i11 + 1;
                    int i21 = i15 - i11;
                    System.arraycopy(iArr, i19, this.f29860a, i11, i21);
                    System.arraycopy(objArr, i19 << 1, this.f29861b, i12, i21 << 1);
                }
            }
            i14 = i15;
        }
        if (i13 != this.f29862c) {
            throw new ConcurrentModificationException();
        }
        this.f29862c = i14;
        return v11;
    }

    public V m(int i11) {
        return (V) this.f29861b[(i11 << 1) + 1];
    }

    @Nullable
    public V put(K k11, V v11) {
        int i11;
        int iD;
        int i12 = this.f29862c;
        if (k11 == null) {
            iD = a();
            i11 = 0;
        } else {
            int iHashCode = k11.hashCode();
            i11 = iHashCode;
            iD = d(k11, iHashCode);
        }
        if (iD >= 0) {
            int i13 = (iD << 1) + 1;
            Object[] objArr = this.f29861b;
            V v12 = (V) objArr[i13];
            objArr[i13] = v11;
            return v12;
        }
        int i14 = ~iD;
        int[] iArr = this.f29860a;
        if (i12 >= iArr.length) {
            int i15 = 8;
            if (i12 >= 8) {
                i15 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i15 = 4;
            }
            Object[] objArr2 = this.f29861b;
            g(i15);
            if (i12 != this.f29862c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f29860a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f29861b, 0, objArr2.length);
            }
            h(iArr, objArr2, i12);
        }
        if (i14 < i12) {
            int[] iArr3 = this.f29860a;
            int i16 = i14 + 1;
            System.arraycopy(iArr3, i14, iArr3, i16, i12 - i14);
            Object[] objArr3 = this.f29861b;
            System.arraycopy(objArr3, i14 << 1, objArr3, i16 << 1, (this.f29862c - i14) << 1);
        }
        int i17 = this.f29862c;
        if (i12 == i17) {
            int[] iArr4 = this.f29860a;
            if (i14 < iArr4.length) {
                iArr4[i14] = i11;
                Object[] objArr4 = this.f29861b;
                int i18 = i14 << 1;
                objArr4[i18] = k11;
                objArr4[i18 + 1] = v11;
                this.f29862c = i17 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V remove(Object obj) {
        int iC = c(obj);
        if (iC >= 0) {
            return l(iC);
        }
        return null;
    }

    public int size() {
        return this.f29862c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f29862c * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f29862c; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            K k11 = k(i11);
            if (k11 != this) {
                sb2.append(k11);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vM = m(i11);
            if (vM != this) {
                sb2.append(vM);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
