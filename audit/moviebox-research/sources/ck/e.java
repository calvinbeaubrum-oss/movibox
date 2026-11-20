package ck;

import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e implements com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d> f14943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14944b = b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14945c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14946d;

    public e(List<com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d> list, String str) {
        this.f14943a = (List) fk.a.g(list, "Header list");
        this.f14946d = str;
    }

    public boolean a(int i11) {
        if (this.f14946d == null) {
            return true;
        }
        return this.f14946d.equalsIgnoreCase(this.f14943a.get(i11).getName());
    }

    public int b(int i11) {
        if (i11 < -1) {
            return -1;
        }
        int size = this.f14943a.size() - 1;
        boolean zA = false;
        while (!zA && i11 < size) {
            i11++;
            zA = a(i11);
        }
        if (zA) {
            return i11;
        }
        return -1;
    }

    public com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d c() throws NoSuchElementException {
        int i11 = this.f14944b;
        if (i11 < 0) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.f14945c = i11;
        this.f14944b = b(i11);
        return this.f14943a.get(i11);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f14944b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return c();
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        fk.b.a(this.f14945c >= 0, "No header to remove");
        this.f14943a.remove(this.f14945c);
        this.f14945c = -1;
        this.f14944b--;
    }
}
