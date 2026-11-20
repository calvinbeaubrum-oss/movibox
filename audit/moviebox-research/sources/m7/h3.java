package m7;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h3 extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f70891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l7.a f70892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f70893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f70894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Collection f70895h;

    public h3(Collection collection) {
        super(null, null);
        this.f70892e = null;
        this.f70890c = -1;
        this.f70891d = null;
        this.f70893f = null;
        this.f70894g = null;
        this.f70895h = collection;
    }

    public h3(Map map, Object obj) {
        super(null, null);
        this.f70892e = null;
        this.f70890c = -1;
        this.f70891d = null;
        this.f70893f = obj;
        this.f70894g = map;
        this.f70895h = null;
    }

    public h3(l7.a aVar, List list, int i11) {
        super(null, null);
        this.f70892e = aVar;
        this.f70890c = i11;
        this.f70891d = list;
        this.f70893f = null;
        this.f70894g = null;
        this.f70895h = null;
    }

    @Override // m7.l
    public void d(l7.a aVar, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // m7.l
    public void h(Object obj, Object obj2) {
        JSONArray jSONArray;
        Object relatedArray;
        Map map = this.f70894g;
        if (map != null) {
            map.put(this.f70893f, obj2);
            return;
        }
        Collection collection = this.f70895h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f70891d.set(this.f70890c, obj2);
        List list = this.f70891d;
        if (!(list instanceof JSONArray) || (relatedArray = (jSONArray = (JSONArray) list).getRelatedArray()) == null || Array.getLength(relatedArray) <= this.f70890c) {
            return;
        }
        if (jSONArray.getComponentType() != null) {
            obj2 = TypeUtils.h(obj2, jSONArray.getComponentType(), this.f70892e.h());
        }
        Array.set(relatedArray, this.f70890c, obj2);
    }
}
