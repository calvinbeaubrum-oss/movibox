package w20;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f79210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f79211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f79212c;

    public d(File file) {
        this.f79212c = 0;
        this.f79210a = file;
    }

    public d(File file, String[] strArr) {
        this(file);
        a(strArr);
    }

    public void a(String[] strArr) {
        String[] strArr2 = this.f79211b;
        int length = strArr2 == null ? 0 : strArr2.length;
        String[] strArr3 = new String[strArr.length + length];
        if (length > 0) {
            System.arraycopy(strArr2, 0, strArr3, 0, length);
        }
        this.f79211b = strArr3;
        System.arraycopy(strArr, 0, strArr3, length, strArr.length);
    }

    public c b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        File file = this.f79210a;
        String[] strArr = this.f79211b;
        int i11 = this.f79212c;
        this.f79212c = i11 + 1;
        return new c(file, strArr[i11]);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f79212c < this.f79211b.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        return b();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
