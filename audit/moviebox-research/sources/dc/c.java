package dc;

import com.cloud.tmc.kernel.bridge.extension.bind.BindException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements b<cc.c, bc.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mc.a f63023a;

    public c(mc.a aVar) {
        this.f63023a = aVar;
    }

    @Override // dc.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bc.a a(Class<bc.a> cls, cc.c cVar) throws BindException {
        return new com.cloud.tmc.kernel.extension.b(this.f63023a, cVar.isSticky());
    }
}
