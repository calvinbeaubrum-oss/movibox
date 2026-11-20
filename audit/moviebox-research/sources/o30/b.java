package o30;

import java.util.LinkedList;
import t30.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends ClassLoader implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f72278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f72279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<a> f72280c;

    public b(ClassLoader classLoader, int i11) {
        super(classLoader);
        this.f72280c = new LinkedList<>();
        this.f72279b = i11;
    }

    @Override // t30.k
    public Class a(String str, byte[] bArr, int i11, int i12) {
        this.f72278a++;
        return super.defineClass(str, bArr, i11, i12);
    }

    public void b() {
        synchronized (this.f72280c) {
            try {
                for (a aVar : this.f72280c) {
                    if (aVar != null) {
                        aVar.a();
                    }
                }
                this.f72280c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int c() {
        return this.f72278a;
    }

    public boolean d() {
        return this.f72279b < this.f72278a;
    }

    public a e(a aVar) {
        synchronized (this.f72280c) {
            try {
                this.f72280c.add(aVar);
                while (this.f72280c.size() > this.f72279b) {
                    a aVarRemoveFirst = this.f72280c.removeFirst();
                    if (aVarRemoveFirst != null) {
                        aVarRemoveFirst.a();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }
}
