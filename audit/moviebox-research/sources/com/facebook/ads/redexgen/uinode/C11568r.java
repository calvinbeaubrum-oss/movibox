package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.redexgen.uinode.AbstractC11578s;
import com.facebook.ads.redexgen.uinode.C11558q;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11568r<T extends AbstractC11578s, E extends C11558q> {
    public static String[] A02 = {"WBmgDKUAJnOjRPVdo459bnYJXDnRSoZA", "OZ5TpfWbSmXE", "sC9WLlq1dd0W0qrWeGI0su3O22TcCAEW", "0Ub2X", "5m4s5CvbohnvtMuC", "JEGJTDHJWZGaFE0Bjwe", "ELtjylBnyGpGsAAS3nfDjHYeujv6lcAm", "LzmA2INjpudrbI3uXcOOEdZHAsdjx9ZW"};
    public final Map<Class<E>, List<WeakReference<T>>> A00 = new HashMap();
    public final Queue<E> A01 = new ArrayDeque();

    private void A00(E e11) {
        List<WeakReference<T>> list;
        Map<Class<E>, List<WeakReference<T>>> map = this.A00;
        if (map == null || (list = map.get(e11.getClass())) == null) {
            return;
        }
        A01(list);
        if (list.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            AbstractC11578s abstractC11578s = (AbstractC11578s) ((WeakReference) it.next()).get();
            if (abstractC11578s != null && abstractC11578s.A00(e11)) {
                abstractC11578s.A03(e11);
            }
        }
    }

    private void A01(List<WeakReference<T>> list) {
        if (list != null) {
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                WeakReference<T> weakReference = list.get(i12);
                T t11 = weakReference.get();
                if (A02[1].length() != 12) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[6] = "MDutMibHR0xfS0kHpIX6qzWASaThPw85";
                strArr[0] = "nvT9JaP2TDwXv3h3yDNvutMp299h55Zc";
                if (t11 != null) {
                    list.set(i11, weakReference);
                    i11++;
                }
            }
            for (int size = list.size() - 1; size >= i11; size--) {
                list.remove(size);
            }
        }
    }

    public final synchronized void A02(E e11) {
        if (this.A01.isEmpty()) {
            this.A01.add(e11);
            while (!this.A01.isEmpty()) {
                A00(this.A01.peek());
                this.A01.remove();
            }
        } else {
            this.A01.add(e11);
        }
    }

    public final synchronized void A03(T... tArr) {
        if (tArr == null) {
            return;
        }
        for (T t11 : tArr) {
            A05(t11);
        }
    }

    public final synchronized void A04(T... tArr) {
        if (tArr == null) {
            return;
        }
        for (T t11 : tArr) {
            A06(t11);
        }
    }

    public final synchronized boolean A05(T t11) {
        if (t11 == null) {
            return false;
        }
        Class<E> clsA01 = t11.A01();
        if (this.A00.get(clsA01) == null) {
            this.A00.put(clsA01, new ArrayList());
        }
        List<WeakReference<T>> list = this.A00.get(clsA01);
        A01(list);
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).get() == t11) {
                return false;
            }
        }
        return list.add(new WeakReference<>(t11));
    }

    public final synchronized boolean A06(T t11) {
        if (t11 == null) {
            return false;
        }
        List<WeakReference<T>> list = this.A00.get(t11.A01());
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).get() == t11) {
                list.get(i11).clear();
                return true;
            }
        }
        return false;
    }
}
