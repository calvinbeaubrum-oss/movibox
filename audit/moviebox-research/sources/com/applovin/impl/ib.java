package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ib extends cb implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient eb f19681b;

    public static int a(int i11) {
        int iMax = Math.max(i11, 2);
        if (iMax >= 751619276) {
            Preconditions.checkArgument(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    private static ib a(int i11, Object... objArr) {
        if (i11 == 0) {
            return h();
        }
        if (i11 == 1) {
            return a(objArr[0]);
        }
        int iA = a(i11);
        Object[] objArr2 = new Object[iA];
        int i12 = iA - 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            Object objA = gg.a(objArr[i15], i15);
            int iHashCode = objA.hashCode();
            int iA2 = ka.a(iHashCode);
            while (true) {
                int i16 = iA2 & i12;
                Object obj = objArr2[i16];
                if (obj == null) {
                    objArr[i14] = objA;
                    objArr2[i16] = objA;
                    i13 += iHashCode;
                    i14++;
                    break;
                }
                if (obj.equals(objA)) {
                    break;
                }
                iA2++;
            }
        }
        Arrays.fill(objArr, i14, i11, (Object) null);
        if (i14 == 1) {
            return new hk(objArr[0], i13);
        }
        if (a(i14) < iA / 2) {
            return a(i14, objArr);
        }
        if (a(i14, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i14);
        }
        return new oi(objArr, i13, objArr2, i12, i14);
    }

    public static ib a(Object obj) {
        return new hk(obj);
    }

    public static ib a(Object obj, Object obj2) {
        return a(2, obj, obj2);
    }

    public static ib a(Object obj, Object obj2, Object obj3) {
        return a(3, obj, obj2, obj3);
    }

    public static ib a(Collection collection) {
        if ((collection instanceof ib) && !(collection instanceof SortedSet)) {
            ib ibVar = (ib) collection;
            if (!ibVar.e()) {
                return ibVar;
            }
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    public static ib a(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? a(objArr.length, (Object[]) objArr.clone()) : a(objArr[0]);
        }
        return h();
    }

    private static boolean a(int i11, int i12) {
        return i11 < (i12 >> 1) + (i12 >> 2);
    }

    public static ib h() {
        return oi.f21553i;
    }

    @Override // com.applovin.impl.cb
    public eb a() {
        eb ebVar = this.f19681b;
        if (ebVar != null) {
            return ebVar;
        }
        eb ebVarF = f();
        this.f19681b = ebVarF;
        return ebVarF;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ib) && g() && ((ib) obj).g() && hashCode() != obj.hashCode()) {
            return false;
        }
        return rj.a(this, obj);
    }

    public eb f() {
        return eb.a(toArray());
    }

    public boolean g() {
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return rj.a(this);
    }

    @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract pp iterator();
}
