package cr;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f62792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f62793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<a> f62794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f62795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f62796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f62797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f62798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f62799h;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f62800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f62801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f62802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f62803d;

        public a(String str, long j11, int i11, String str2) {
            this.f62800a = str;
            this.f62801b = j11;
            this.f62803d = i11;
            this.f62802c = str2;
        }

        public String toString() {
            return "TidEvent{event='" + this.f62800a + "', ts=" + this.f62801b + '}';
        }
    }

    public d(long j11, String str, List<a> list, long j12, long j13, int i11, int i12, boolean z11) {
        this.f62792a = j11;
        this.f62794c = list;
        this.f62793b = str;
        this.f62795d = j12;
        this.f62796e = j13;
        this.f62797f = i11;
        this.f62798g = i12;
        this.f62799h = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f62792a == ((d) obj).f62792a;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f62792a), this.f62794c, Long.valueOf(this.f62795d), Long.valueOf(this.f62796e), Integer.valueOf(this.f62797f), Integer.valueOf(this.f62798g), Boolean.valueOf(this.f62799h));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<a> it = this.f62794c.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
        }
        return "TidEventSet{tid=" + this.f62792a + ", event='" + this.f62793b + "', eventList=" + ((Object) sb2) + ", eventCount=" + this.f62797f + '}';
    }
}
