package ph;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f73858a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements o {
        @Override // ph.o
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // ph.o
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // ph.o
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
