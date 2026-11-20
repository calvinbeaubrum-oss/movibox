package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f25980f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f25981g = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f25982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25984c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f25986e;

    /* JADX INFO: compiled from: source.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f25988b;

        public a(String str) {
            this.f25987a = str;
        }

        public void a() {
            b.f25981g.add(this.f25987a);
        }

        public void b() {
            b.f25980f.add(this.f25987a);
        }

        public String toString() {
            return this.f25987a;
        }
    }

    public b(String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.f25982a = arrayList;
        arrayList.add(new a(str));
        this.f25983b = 1;
        this.f25986e = 1;
    }

    public b(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.f25983b = size;
        this.f25982a = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            a aVar = new a(str);
            if (f25980f.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(aVar);
            } else if (f25981g.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(aVar);
            } else {
                this.f25982a.add(aVar);
            }
        }
        if (arrayList != null) {
            this.f25982a.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.f25982a.addAll(arrayList2);
        }
        Integer num = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25979j;
        this.f25986e = (num == null || num.intValue() <= 0) ? this.f25983b >= 2 ? 1 : 2 : num.intValue();
    }

    public a b() {
        if (!c()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f25984c + 1;
        if (i11 >= this.f25983b - 1) {
            this.f25984c = -1;
            this.f25985d++;
        } else {
            this.f25984c = i11;
        }
        a aVar = this.f25982a.get(i11);
        aVar.f25988b = (this.f25985d * this.f25983b) + this.f25984c;
        return aVar;
    }

    public boolean c() {
        return this.f25985d < this.f25986e;
    }
}
