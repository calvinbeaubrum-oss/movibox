package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j30.i f67847b;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            return ((Boolean) obj).booleanValue() ? Float.valueOf(1.0f) : Float.valueOf(0.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            String str = (String) obj;
            return str.length() == 0 ? Float.valueOf(0.0f) : Float.valueOf(Float.parseFloat(str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return k.f67847b.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            return Float.valueOf(((BigDecimal) obj).floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            return Float.valueOf(((BigInteger) obj).floatValue());
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
        public Float a(Object obj) {
            return Float.valueOf(((Integer) obj).floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            return Float.valueOf(((Double) obj).floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            return Float.valueOf(((Long) obj).floatValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(Object obj) {
            return Float.valueOf(((Short) obj).floatValue());
        }
    }

    static {
        HashMap map = new HashMap();
        f67846a = map;
        b bVar = new b();
        f67847b = bVar;
        map.put(String.class, bVar);
        map.put(Object.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(BigInteger.class, new e());
        map.put(Float.class, new f());
        map.put(Integer.class, new g());
        map.put(Double.class, new h());
        map.put(Long.class, new i());
        map.put(Short.class, new j());
        map.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67846a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67846a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
