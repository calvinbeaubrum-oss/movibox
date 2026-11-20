package t30;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f76814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<c> f76815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<Integer> f76816c;

    /* JADX INFO: compiled from: source.java */
    public class a implements b {
        public a() {
        }

        @Override // t30.j.b
        public int a(int i11) {
            for (c cVar : j.this.f76815b) {
                if (cVar.c(i11)) {
                    return cVar.b();
                }
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        int a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f76818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f76819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f76820c;

        public c(int i11, int i12, int i13) {
            this.f76818a = i11;
            this.f76819b = i12;
            this.f76820c = i13;
        }

        public /* synthetic */ c(int i11, int i12, int i13, a aVar) {
            this(i11, i12, i13);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            if (cVar.f76818a >= this.f76819b) {
                return 1;
            }
            return cVar.f76819b < this.f76818a ? -1 : 0;
        }

        public int b() {
            return this.f76820c;
        }

        public boolean c(int i11) {
            return i11 >= this.f76818a && i11 <= this.f76819b;
        }
    }

    public j(char[] cArr) {
        this.f76814a = cArr;
    }

    public b b() {
        a aVar;
        this.f76815b = new ArrayList<>();
        this.f76816c = new TreeSet();
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (true) {
            char[] cArr = this.f76814a;
            aVar = null;
            if (i11 >= cArr.length) {
                break;
            }
            if (cArr[i11] == '\n') {
                this.f76816c.add(Integer.valueOf(i13));
                this.f76815b.add(new c(i12, i11, i13, aVar));
                i12 = i11 + 1;
                i13++;
            }
            i11++;
        }
        if (i11 > i12) {
            this.f76816c.add(Integer.valueOf(i13));
            this.f76815b.add(new c(i12, i11, i13, aVar));
        }
        return new a();
    }
}
