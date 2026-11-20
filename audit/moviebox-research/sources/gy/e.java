package gy;

import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.w;
import com.transsion.transfer.androidasync.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e extends d {
    public e(String str, long j11, List<w> list) {
        super(str, j11, list);
    }

    @Override // gy.d
    public void d(u uVar, fy.a aVar) {
        try {
            c0.f(e(), uVar, aVar);
        } catch (Exception e11) {
            aVar.i(e11);
        }
    }

    public abstract InputStream e() throws IOException;
}
