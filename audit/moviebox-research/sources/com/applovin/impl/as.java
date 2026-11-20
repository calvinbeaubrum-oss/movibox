package com.applovin.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class as implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f17781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f17782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f17783c;

    public as(List list) {
        this.f17781a = Collections.unmodifiableList(new ArrayList(list));
        this.f17782b = new long[list.size() * 2];
        for (int i11 = 0; i11 < list.size(); i11++) {
            wr wrVar = (wr) list.get(i11);
            int i12 = i11 * 2;
            long[] jArr = this.f17782b;
            jArr[i12] = wrVar.f24161b;
            jArr[i12 + 1] = wrVar.f24162c;
        }
        long[] jArr2 = this.f17782b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f17783c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(wr wrVar, wr wrVar2) {
        return Long.compare(wrVar.f24161b, wrVar2.f24161b);
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f17783c.length;
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        int iA = xp.a(this.f17783c, j11, false, false);
        if (iA < this.f17783c.length) {
            return iA;
        }
        return -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        b1.a(i11 >= 0);
        b1.a(i11 < this.f17783c.length);
        return this.f17783c[i11];
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < this.f17781a.size(); i11++) {
            long[] jArr = this.f17782b;
            int i12 = i11 * 2;
            if (jArr[i12] <= j11 && j11 < jArr[i12 + 1]) {
                wr wrVar = (wr) this.f17781a.get(i11);
                b5 b5Var = wrVar.f24160a;
                if (b5Var.f17836f == -3.4028235E38f) {
                    arrayList2.add(wrVar);
                } else {
                    arrayList.add(b5Var);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.applovin.impl.xs
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return as.a((wr) obj, (wr) obj2);
            }
        });
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            arrayList.add(((wr) arrayList2.get(i13)).f24160a.a().a((-1) - i13, 1).a());
        }
        return arrayList;
    }
}
