package m7;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements b2 {
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) f(aVar, type, obj, null, 0);
    }

    public abstract <T> T f(l7.a aVar, Type type, Object obj, String str, int i11);
}
