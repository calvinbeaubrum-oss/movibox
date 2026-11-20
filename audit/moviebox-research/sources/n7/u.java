package n7;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class u implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f71751a = new u();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f71752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f71753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f71754c;

        public ByteBuffer a() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f71752a);
            byteBufferWrap.limit(this.f71753b);
            byteBufferWrap.position(this.f71754c);
            return byteBufferWrap;
        }
    }

    @Override // m7.b2
    public int b() {
        return 14;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byte[] bArrArray = byteBuffer.array();
        j1 j1Var = o0Var.f71701k;
        j1Var.write(123);
        j1Var.q("array");
        j1Var.n(bArrArray);
        j1Var.u(',', "limit", byteBuffer.limit());
        j1Var.u(',', RequestParameters.POSITION, byteBuffer.position());
        j1Var.write(125);
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) ((a) aVar.j0(a.class)).a();
    }
}
