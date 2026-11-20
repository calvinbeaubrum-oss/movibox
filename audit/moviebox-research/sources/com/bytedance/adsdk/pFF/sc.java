package com.bytedance.adsdk.pFF;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class sc<E> implements Collection<E>, Set<E> {
    private static Object[] ExN;
    private static int Qj;
    private static int TRI;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static Object[] f26182qr;
    private int[] Ol;
    private BT<E, E> WH;
    int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Object[] f26183sc;
    private static final int[] zY = new int[0];
    private static final Object[] We = new Object[0];

    public sc() {
        this(0);
    }

    public sc(int i11) {
        if (i11 == 0) {
            this.Ol = zY;
            this.f26183sc = We;
        } else {
            We(i11);
        }
        this.pFF = 0;
    }

    private void We(int i11) {
        if (i11 == 8) {
            synchronized (sc.class) {
                Object[] objArr = f26182qr;
                if (objArr != null) {
                    this.f26183sc = objArr;
                    f26182qr = (Object[]) objArr[0];
                    this.Ol = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Qj--;
                    return;
                }
            }
        } else if (i11 == 4) {
            synchronized (sc.class) {
                Object[] objArr2 = ExN;
                if (objArr2 != null) {
                    this.f26183sc = objArr2;
                    ExN = (Object[]) objArr2[0];
                    this.Ol = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    TRI--;
                    return;
                }
            }
        }
        this.Ol = new int[i11];
        this.f26183sc = new Object[i11];
    }

    private BT<E, E> pFF() {
        if (this.WH == null) {
            this.WH = new BT<E, E>() { // from class: com.bytedance.adsdk.pFF.sc.1
                @Override // com.bytedance.adsdk.pFF.BT
                public Map<E, E> pFF() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.pFF.BT
                public int sc() {
                    return sc.this.pFF;
                }

                @Override // com.bytedance.adsdk.pFF.BT
                public int sc(Object obj) {
                    return sc.this.sc(obj);
                }

                @Override // com.bytedance.adsdk.pFF.BT
                public Object sc(int i11, int i12) {
                    return sc.this.f26183sc[i11];
                }

                @Override // com.bytedance.adsdk.pFF.BT
                public void sc(int i11) {
                    sc.this.zY(i11);
                }

                @Override // com.bytedance.adsdk.pFF.BT
                public void zY() {
                    sc.this.clear();
                }
            };
        }
        return this.WH;
    }

    private int sc() {
        int i11 = this.pFF;
        if (i11 == 0) {
            return -1;
        }
        int iSc = pFF.sc(this.Ol, i11, 0);
        if (iSc < 0 || this.f26183sc[iSc] == null) {
            return iSc;
        }
        int i12 = iSc + 1;
        while (i12 < i11 && this.Ol[i12] == 0) {
            if (this.f26183sc[i12] == null) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iSc - 1; i13 >= 0 && this.Ol[i13] == 0; i13--) {
            if (this.f26183sc[i13] == null) {
                return i13;
            }
        }
        return ~i12;
    }

    private int sc(Object obj, int i11) {
        int i12 = this.pFF;
        if (i12 == 0) {
            return -1;
        }
        int iSc = pFF.sc(this.Ol, i12, i11);
        if (iSc < 0 || obj.equals(this.f26183sc[iSc])) {
            return iSc;
        }
        int i13 = iSc + 1;
        while (i13 < i12 && this.Ol[i13] == i11) {
            if (obj.equals(this.f26183sc[i13])) {
                return i13;
            }
            i13++;
        }
        for (int i14 = iSc - 1; i14 >= 0 && this.Ol[i14] == i11; i14--) {
            if (obj.equals(this.f26183sc[i14])) {
                return i14;
            }
        }
        return ~i13;
    }

    private static void sc(int[] iArr, Object[] objArr, int i11) {
        if (iArr.length == 8) {
            synchronized (sc.class) {
                try {
                    if (Qj < 10) {
                        objArr[0] = f26182qr;
                        objArr[1] = iArr;
                        for (int i12 = i11 - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        f26182qr = objArr;
                        Qj++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (sc.class) {
                try {
                    if (TRI < 10) {
                        objArr[0] = ExN;
                        objArr[1] = iArr;
                        for (int i13 = i11 - 1; i13 >= 2; i13--) {
                            objArr[i13] = null;
                        }
                        ExN = objArr;
                        TRI++;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e11) {
        int i11;
        int iSc;
        if (e11 == null) {
            iSc = sc();
            i11 = 0;
        } else {
            int iHashCode = e11.hashCode();
            i11 = iHashCode;
            iSc = sc(e11, iHashCode);
        }
        if (iSc >= 0) {
            return false;
        }
        int i12 = ~iSc;
        int i13 = this.pFF;
        int[] iArr = this.Ol;
        if (i13 >= iArr.length) {
            int i14 = 8;
            if (i13 >= 8) {
                i14 = (i13 >> 1) + i13;
            } else if (i13 < 4) {
                i14 = 4;
            }
            Object[] objArr = this.f26183sc;
            We(i14);
            int[] iArr2 = this.Ol;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f26183sc, 0, objArr.length);
            }
            sc(iArr, objArr, this.pFF);
        }
        int i15 = this.pFF;
        if (i12 < i15) {
            int[] iArr3 = this.Ol;
            int i16 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i16, i15 - i12);
            Object[] objArr2 = this.f26183sc;
            System.arraycopy(objArr2, i12, objArr2, i16, this.pFF - i12);
        }
        this.Ol[i12] = i11;
        this.f26183sc[i12] = e11;
        this.pFF++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        sc(this.pFF + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i11 = this.pFF;
        if (i11 != 0) {
            sc(this.Ol, this.f26183sc, i11);
            this.Ol = zY;
            this.f26183sc = We;
            this.pFF = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return sc(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.pFF; i11++) {
                try {
                    if (!set.contains(pFF(i11))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.Ol;
        int i11 = this.pFF;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += iArr[i13];
        }
        return i12;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.pFF <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return pFF().We().iterator();
    }

    public E pFF(int i11) {
        return (E) this.f26183sc[i11];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iSc = sc(obj);
        if (iSc < 0) {
            return false;
        }
        zY(iSc);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z11 = false;
        for (int i11 = this.pFF - 1; i11 >= 0; i11--) {
            if (!collection.contains(this.f26183sc[i11])) {
                zY(i11);
                z11 = true;
            }
        }
        return z11;
    }

    public int sc(Object obj) {
        return obj == null ? sc() : sc(obj, obj.hashCode());
    }

    public void sc(int i11) {
        int[] iArr = this.Ol;
        if (iArr.length < i11) {
            Object[] objArr = this.f26183sc;
            We(i11);
            int i12 = this.pFF;
            if (i12 > 0) {
                System.arraycopy(iArr, 0, this.Ol, 0, i12);
                System.arraycopy(objArr, 0, this.f26183sc, 0, this.pFF);
            }
            sc(iArr, objArr, this.pFF);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.pFF;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i11 = this.pFF;
        Object[] objArr = new Object[i11];
        System.arraycopy(this.f26183sc, 0, objArr, 0, i11);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.pFF) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.pFF));
        }
        System.arraycopy(this.f26183sc, 0, tArr, 0, this.pFF);
        int length = tArr.length;
        int i11 = this.pFF;
        if (length > i11) {
            tArr[i11] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.pFF * 14);
        sb2.append('{');
        for (int i11 = 0; i11 < this.pFF; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            E ePFF = pFF(i11);
            if (ePFF != this) {
                sb2.append(ePFF);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public E zY(int i11) {
        Object[] objArr = this.f26183sc;
        E e11 = (E) objArr[i11];
        int i12 = this.pFF;
        if (i12 <= 1) {
            sc(this.Ol, objArr, i12);
            this.Ol = zY;
            this.f26183sc = We;
            this.pFF = 0;
        } else {
            int[] iArr = this.Ol;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                int i13 = i12 - 1;
                this.pFF = i13;
                if (i11 < i13) {
                    int i14 = i11 + 1;
                    System.arraycopy(iArr, i14, iArr, i11, i13 - i11);
                    Object[] objArr2 = this.f26183sc;
                    System.arraycopy(objArr2, i14, objArr2, i11, this.pFF - i11);
                }
                this.f26183sc[this.pFF] = null;
            } else {
                We(i12 > 8 ? i12 + (i12 >> 1) : 8);
                this.pFF--;
                if (i11 > 0) {
                    System.arraycopy(iArr, 0, this.Ol, 0, i11);
                    System.arraycopy(objArr, 0, this.f26183sc, 0, i11);
                }
                int i15 = this.pFF;
                if (i11 < i15) {
                    int i16 = i11 + 1;
                    System.arraycopy(iArr, i16, this.Ol, i11, i15 - i11);
                    System.arraycopy(objArr, i16, this.f26183sc, i11, this.pFF - i11);
                }
            }
        }
        return e11;
    }
}
