package dc;

import com.cloud.tmc.kernel.bridge.extension.bind.BindException;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h<T> implements b<cc.h, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JsonObject f63027a;

    public h(JsonObject jsonObject) {
        this.f63027a = jsonObject;
    }

    @Override // dc.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(Class<T> cls, cc.h hVar) throws BindException {
        if (this.f63027a != null) {
            return null;
        }
        throw new BindException("input JSON is null");
    }
}
