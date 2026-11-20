package com.facebook.biddingkit.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: compiled from: source.java */
    public static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<String> f32472a;

        public b() {
            this.f32472a = new ArrayList();
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void a(String str) {
            this.f32472a.add(str);
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void flush() {
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = this.f32472a.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append('\n');
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f32473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f32474b;

        public c(d dVar, int i11) {
            this.f32473a = dVar;
            this.f32474b = i11;
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void a(String str) {
            if (this.f32474b > 0) {
                this.f32473a.a(str);
                this.f32474b--;
            }
        }

        @Override // com.facebook.biddingkit.logging.g.d
        public void flush() {
            this.f32473a.flush();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(String str);

        void flush();
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f32475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public char[] f32476b = new char[1024];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32477c;

        public e(d dVar) {
            this.f32475a = dVar;
        }

        public final void a() {
            this.f32475a.a(new String(this.f32476b, 0, this.f32477c));
            this.f32477c = 0;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            if (this.f32477c > 0) {
                a();
            }
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        @Override // java.io.Writer
        public void write(char[] cArr, int i11, int i12) throws IOException {
            for (int i13 = i11; i13 < i11 + i12; i13++) {
                char c11 = cArr[i13];
                if (c11 != '\n') {
                    int i14 = this.f32477c;
                    char[] cArr2 = this.f32476b;
                    if (i14 == cArr2.length) {
                        a();
                    } else {
                        cArr2[i14] = c11;
                        this.f32477c = i14 + 1;
                    }
                } else {
                    a();
                }
            }
        }
    }

    public static String a(Throwable th2) {
        return b(th2, 100);
    }

    public static String b(Throwable th2, int i11) {
        if (th2 == null) {
            return "";
        }
        try {
            b bVar = new b();
            d cVar = i11 >= 0 ? new c(bVar, i11) : bVar;
            th2.printStackTrace(new PrintWriter(new e(cVar)));
            cVar.flush();
            return bVar.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
