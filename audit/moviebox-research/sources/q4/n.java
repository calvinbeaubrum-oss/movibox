package q4;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f74374a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements n {
        @Override // q4.n
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // q4.n
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // q4.n
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
