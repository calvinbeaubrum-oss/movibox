package athena;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<a> f13601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13602d;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f13605c;

        public a(int i11, int i12, long j11) {
            this.f13603a = i11;
            this.f13604b = i12;
            this.f13605c = j11;
        }

        public String a() {
            return this.f13604b + "-" + this.f13605c;
        }

        public String toString() {
            return "{appId=" + this.f13603a + ", type=" + this.f13604b + ", version=" + this.f13605c + '}';
        }
    }

    public b() {
    }

    public b(String str) {
        this.f13602d = str;
    }
}
