package hj;

import com.google.common.base.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: hj.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0698a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Charset f66461a;

        public C0698a(Charset charset) {
            this.f66461a = (Charset) m.p(charset);
        }

        @Override // hj.c
        public Reader a() throws IOException {
            return new InputStreamReader(a.this.b(), this.f66461a);
        }

        public String toString() {
            return a.this.toString() + ".asCharSource(" + this.f66461a + ")";
        }
    }

    public c a(Charset charset) {
        return new C0698a(charset);
    }

    public abstract InputStream b() throws IOException;
}
