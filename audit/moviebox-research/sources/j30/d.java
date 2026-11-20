package j30;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j30.i f67837b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((BigDecimal) obj).doubleValue() > 0.0d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            String str = (String) obj;
            return Boolean.valueOf((str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("off") || "0".equals(obj) || "".equals(obj)) ? false : true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return d.f67837b.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: j30.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0724d implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((Integer) obj).intValue() > 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((Float) obj).floatValue() > 0.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((Double) obj).doubleValue() > 0.0d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((Short) obj).shortValue() > 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((Long) obj).longValue() > 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf(((Boolean) obj).booleanValue());
        }
    }

    static {
        HashMap map = new HashMap();
        f67836a = map;
        b bVar = new b();
        f67837b = bVar;
        map.put(String.class, bVar);
        map.put(Object.class, new c());
        map.put(Boolean.class, new C0724d());
        map.put(Integer.class, new e());
        map.put(Float.class, new f());
        map.put(Double.class, new g());
        map.put(Short.class, new h());
        map.put(Long.class, new i());
        map.put(Boolean.TYPE, new j());
        map.put(BigDecimal.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67836a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67836a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
