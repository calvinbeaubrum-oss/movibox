package j30;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, i> f67840a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return ((String) obj).toCharArray();
        }
    }

    static {
        HashMap map = new HashMap();
        f67840a = map;
        map.put(String.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67840a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, i> map = f67840a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
