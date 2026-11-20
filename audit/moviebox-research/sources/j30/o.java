package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class o implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j30.i f67851b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Object obj) {
            return ((Boolean) obj).booleanValue() ? 1L : 0L;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            String str = (String) obj;
            if (str.length() == 0) {
                return 0L;
            }
            return Long.valueOf(Long.parseLong(str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return o.f67851b.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Object obj) {
            return Long.valueOf(((BigDecimal) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Object obj) {
            return Long.valueOf(((BigInteger) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return Long.valueOf(((Short) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return new Long(((Long) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return Long.valueOf(((Integer) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return Long.valueOf(((Double) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return Long.valueOf(((Float) obj).longValue());
        }
    }

    static {
        HashMap map = new HashMap();
        f67850a = map;
        b bVar = new b();
        f67851b = bVar;
        map.put(String.class, bVar);
        map.put(Object.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(BigInteger.class, new e());
        map.put(Short.class, new f());
        map.put(Long.class, new g());
        map.put(Integer.class, new h());
        map.put(Double.class, new i());
        map.put(Float.class, new j());
        map.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67850a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67850a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Long.class.getName());
    }
}
