package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j30.i f67845b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            return ((Boolean) obj).booleanValue() ? Double.valueOf(1.0d) : Double.valueOf(0.0d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            String str = (String) obj;
            return str.length() == 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.parseDouble(str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return j.f67845b.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            return Double.valueOf(((BigDecimal) obj).doubleValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            return Double.valueOf(((BigInteger) obj).doubleValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            Float f11 = (Float) obj;
            if (f11.floatValue() <= Double.MAX_VALUE) {
                return Double.valueOf(f11.doubleValue());
            }
            throw new ConversionException("cannot coerce Float to Double since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Double.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            return Double.valueOf(((Short) obj).doubleValue());
        }
    }

    /* JADX INFO: renamed from: j30.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0726j implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(Object obj) {
            return Double.valueOf(((Long) obj).doubleValue());
        }
    }

    static {
        HashMap map = new HashMap();
        f67844a = map;
        b bVar = new b();
        f67845b = bVar;
        map.put(String.class, bVar);
        map.put(Object.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(BigInteger.class, new e());
        map.put(Double.class, new f());
        map.put(Float.class, new g());
        map.put(Integer.class, new h());
        map.put(Short.class, new i());
        map.put(Long.class, new C0726j());
        map.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67844a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67844a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
