package com.applovin.mediation;

import com.applovin.impl.sdk.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxSegment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f24938b;

    public MaxSegment(int i11, List<Integer> list) {
        this.f24937a = i11;
        this.f24938b = list;
        a(i11);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            a(it.next().intValue());
        }
    }

    private void a(int i11) {
        if (i11 >= 0) {
            return;
        }
        n.h("MaxSegment", "Please ensure that the segment value entered is a non-negative number in the range of [0, 2147483647]: " + i11);
    }

    public int getKey() {
        return this.f24937a;
    }

    public List<Integer> getValues() {
        return this.f24938b;
    }

    public String toString() {
        return "MaxSegment{key=" + this.f24937a + ", values=" + this.f24938b + '}';
    }
}
