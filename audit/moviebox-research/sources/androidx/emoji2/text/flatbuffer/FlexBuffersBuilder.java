package androidx.emoji2.text.flatbuffer;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class FlexBuffersBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8320a;

    /* JADX INFO: renamed from: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements Comparator<a> {
        final /* synthetic */ FlexBuffersBuilder this$0;

        public AnonymousClass1(FlexBuffersBuilder flexBuffersBuilder) {
        }

        @Override // java.util.Comparator
        public int compare(a aVar, a aVar2) {
            byte b11;
            byte b12;
            int i11 = aVar.f8321a;
            int i12 = aVar2.f8321a;
            do {
                b11 = this.this$0.f8320a.get(i11);
                b12 = this.this$0.f8320a.get(i12);
                if (b11 == 0) {
                    return b11 - b12;
                }
                i11++;
                i12++;
            } while (b11 == b12);
            return b11 - b12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8321a;
    }
}
