package i1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f66865f = new HashMap<>();

    @Override // i1.b
    @Nullable
    public b.c<K, V> b(K k11) {
        return this.f66865f.get(k11);
    }

    public boolean contains(K k11) {
        return this.f66865f.containsKey(k11);
    }

    @Override // i1.b
    public V i(@NonNull K k11, @NonNull V v11) {
        b.c<K, V> cVarB = b(k11);
        if (cVarB != null) {
            return cVarB.f66871b;
        }
        this.f66865f.put(k11, g(k11, v11));
        return null;
    }

    @Override // i1.b
    public V j(@NonNull K k11) {
        V v11 = (V) super.j(k11);
        this.f66865f.remove(k11);
        return v11;
    }

    @Nullable
    public Map.Entry<K, V> o(K k11) {
        if (contains(k11)) {
            return this.f66865f.get(k11).f66873d;
        }
        return null;
    }
}
