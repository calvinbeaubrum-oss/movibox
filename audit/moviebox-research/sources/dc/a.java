package dc;

import com.cloud.tmc.kernel.bridge.extension.bind.BindException;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements b<cc.b, rc.a> {
    public a(rc.a aVar) {
    }

    @Override // dc.b
    public /* bridge */ /* synthetic */ rc.a a(Class<rc.a> cls, Annotation annotation) throws BindException {
        b(cls, (cc.b) annotation);
        return null;
    }

    public rc.a b(Class<rc.a> cls, cc.b bVar) throws BindException {
        if (bVar.required()) {
            throw new BindException("Required ApiContext but not inject!!!");
        }
        return null;
    }
}
