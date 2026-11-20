package com.applovin.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19807a;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends j1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f19808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f19809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f19810d;

        public a(int i11, long j11) {
            super(i11);
            this.f19808b = j11;
            this.f19809c = new ArrayList();
            this.f19810d = new ArrayList();
        }

        public void a(a aVar) {
            this.f19810d.add(aVar);
        }

        public void a(b bVar) {
            this.f19809c.add(bVar);
        }

        public a d(int i11) {
            int size = this.f19810d.size();
            for (int i12 = 0; i12 < size; i12++) {
                a aVar = (a) this.f19810d.get(i12);
                if (aVar.f19807a == i11) {
                    return aVar;
                }
            }
            return null;
        }

        public b e(int i11) {
            int size = this.f19809c.size();
            for (int i12 = 0; i12 < size; i12++) {
                b bVar = (b) this.f19809c.get(i12);
                if (bVar.f19807a == i11) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // com.applovin.impl.j1
        public String toString() {
            return j1.a(this.f19807a) + " leaves: " + Arrays.toString(this.f19809c.toArray()) + " containers: " + Arrays.toString(this.f19810d.toArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends j1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bh f19811b;

        public b(int i11, bh bhVar) {
            super(i11);
            this.f19811b = bhVar;
        }
    }

    public j1(int i11) {
        this.f19807a = i11;
    }

    public static String a(int i11) {
        return "" + ((char) ((i11 >> 24) & 255)) + ((char) ((i11 >> 16) & 255)) + ((char) ((i11 >> 8) & 255)) + ((char) (i11 & 255));
    }

    public static int b(int i11) {
        return i11 & 16777215;
    }

    public static int c(int i11) {
        return (i11 >> 24) & 255;
    }

    public String toString() {
        return a(this.f19807a);
    }
}
