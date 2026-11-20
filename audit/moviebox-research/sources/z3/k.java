package z3;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f81796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f81798c;

    public k(String... strArr) {
        this.f81796a = strArr;
    }

    public synchronized boolean a() {
        if (this.f81797b) {
            return this.f81798c;
        }
        this.f81797b = true;
        try {
            for (String str : this.f81796a) {
                b(str);
            }
            this.f81798c = true;
        } catch (UnsatisfiedLinkError unused) {
            o.h("LibraryLoader", "Failed to load " + Arrays.toString(this.f81796a));
        }
        return this.f81798c;
    }

    public abstract void b(String str);
}
