package q20;

import java.io.FilterReader;
import java.io.IOException;
import java.io.StringReader;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a extends FilterReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f74269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Project f74270b;

    public a() {
        super(new StringReader(""));
        this.f74269a = false;
        this.f74270b = null;
        d.d(this);
    }

    public final void a(Project project) {
        this.f74270b = project;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final int read(char[] cArr, int i11, int i12) throws IOException {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = read();
            if (i14 == -1) {
                if (i13 == 0) {
                    return -1;
                }
                return i13;
            }
            cArr[i11 + i13] = (char) i14;
        }
        return i12;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final long skip(long j11) throws IOException, IllegalArgumentException {
        if (j11 < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        for (long j12 = 0; j12 < j11; j12++) {
            if (read() == -1) {
                return j12;
            }
        }
        return j11;
    }
}
