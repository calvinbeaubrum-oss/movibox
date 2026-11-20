package t30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i extends ClassLoader implements k {
    public i(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override // t30.k
    public Class<?> a(String str, byte[] bArr, int i11, int i12) {
        return super.defineClass(str, bArr, i11, i12);
    }
}
