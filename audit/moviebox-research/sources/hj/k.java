package hj;

import com.google.common.base.m;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Readable f66476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f66477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharBuffer f66478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f66479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue<String> f66480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f66481f;

    /* JADX INFO: compiled from: source.java */
    public class a extends i {
        public a() {
        }

        @Override // hj.i
        public void d(String str, String str2) {
            k.this.f66480e.add(str);
        }
    }

    public k(Readable readable) {
        CharBuffer charBufferA = d.a();
        this.f66478c = charBufferA;
        this.f66479d = charBufferA.array();
        this.f66480e = new ArrayDeque();
        this.f66481f = new a();
        this.f66476a = (Readable) m.p(readable);
        this.f66477b = readable instanceof Reader ? (Reader) readable : null;
    }

    public String b() throws IOException {
        int i11;
        while (this.f66480e.peek() == null) {
            h.a(this.f66478c);
            Reader reader = this.f66477b;
            if (reader != null) {
                char[] cArr = this.f66479d;
                i11 = reader.read(cArr, 0, cArr.length);
            } else {
                i11 = this.f66476a.read(this.f66478c);
            }
            if (i11 == -1) {
                this.f66481f.b();
                break;
            }
            this.f66481f.a(this.f66479d, 0, i11);
        }
        return this.f66480e.poll();
    }
}
