package i7;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends CountDownLatch {
    public a(int i11) {
        super(i11);
    }

    public void a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
