package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f73231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73232b;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends b {
        public a(Collection<c> collection) {
            super(collection);
        }

        public a(c... cVarArr) {
            this(Arrays.asList(cVarArr));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (int i11 = 0; i11 < this.f73232b; i11++) {
                if (!this.f73231a.get(i11).a(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return d30.c.i(this.f73231a, " ");
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0790b extends b {
        public C0790b() {
        }

        public C0790b(Collection<c> collection) {
            if (this.f73232b > 1) {
                this.f73231a.add(new a(collection));
            } else {
                this.f73231a.addAll(collection);
            }
            d();
        }

        public C0790b(c... cVarArr) {
            this(Arrays.asList(cVarArr));
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (int i11 = 0; i11 < this.f73232b; i11++) {
                if (this.f73231a.get(i11).a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public void e(c cVar) {
            this.f73231a.add(cVar);
            d();
        }

        public String toString() {
            return d30.c.i(this.f73231a, ", ");
        }
    }

    public b() {
        this.f73232b = 0;
        this.f73231a = new ArrayList<>();
    }

    public b(Collection<c> collection) {
        this();
        this.f73231a.addAll(collection);
        d();
    }

    public void b(c cVar) {
        this.f73231a.set(this.f73232b - 1, cVar);
    }

    public c c() {
        int i11 = this.f73232b;
        if (i11 > 0) {
            return this.f73231a.get(i11 - 1);
        }
        return null;
    }

    public void d() {
        this.f73232b = this.f73231a.size();
    }
}
