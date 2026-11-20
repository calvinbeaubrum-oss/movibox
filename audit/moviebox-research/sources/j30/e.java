package j30;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, i> f67838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i f67839b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Byte.valueOf(Byte.parseByte((String) obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return e.f67839b.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return new Byte(((Byte) obj).byteValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Byte.valueOf(((Integer) obj).byteValue());
        }
    }

    /* JADX INFO: renamed from: j30.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0725e implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Byte.valueOf(((Long) obj).byteValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Byte.valueOf(((Double) obj).byteValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Byte.valueOf(((Float) obj).byteValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements i {
        @Override // j30.i
        public Object a(Object obj) {
            return Byte.valueOf(((Short) obj).byteValue());
        }
    }

    static {
        HashMap map = new HashMap();
        f67838a = map;
        a aVar = new a();
        f67839b = aVar;
        map.put(String.class, aVar);
        map.put(Object.class, new b());
        map.put(Byte.class, new c());
        map.put(Integer.class, new d());
        map.put(Long.class, new C0725e());
        map.put(Double.class, new f());
        map.put(Float.class, new g());
        map.put(Short.class, new h());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67838a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, i> map = f67838a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
