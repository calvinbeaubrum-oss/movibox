package gy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f65640d;

    public g(String str, String str2) {
        super(str, str2.getBytes().length, null);
        this.f65640d = str2;
    }

    @Override // gy.e
    public InputStream e() throws IOException {
        return new ByteArrayInputStream(this.f65640d.getBytes());
    }

    public String toString() {
        return this.f65640d;
    }
}
