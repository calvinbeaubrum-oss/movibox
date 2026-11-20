package j30;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, i> f67841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f67842b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements i {
        @Override // j30.i
        public Object a(Object obj) {
            String str = (String) obj;
            if (str.length() <= 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new ConversionException("cannot convert a string with a length greater than 1 to java.lang.Character");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return g.f67842b.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return new Character(((Character) obj).charValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Character.valueOf((char) ((BigDecimal) obj).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Character.valueOf((char) ((Integer) obj).intValue());
        }
    }

    static {
        HashMap map = new HashMap();
        f67841a = map;
        a aVar = new a();
        f67842b = aVar;
        map.put(String.class, aVar);
        map.put(Object.class, new b());
        map.put(Character.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(Integer.class, new e());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67841a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, i> map = f67841a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
