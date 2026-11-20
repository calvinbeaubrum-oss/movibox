package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class m implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67849a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Object obj) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Object obj) {
            return Integer.valueOf(((Character) obj).charValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            if (((String) obj).length() == 0) {
                return 0;
            }
            return Integer.valueOf(Integer.parseInt(String.valueOf(obj)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Object obj) {
            return Integer.valueOf(((BigDecimal) obj).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Object obj) {
            return Integer.valueOf(((BigInteger) obj).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return Integer.valueOf(((Short) obj).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            Long l11 = (Long) obj;
            if (l11.longValue() <= 2147483647L) {
                return Integer.valueOf(l11.intValue());
            }
            throw new ConversionException("cannot coerce Long to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            Float f11 = (Float) obj;
            if (f11.floatValue() <= 2.1474836E9f) {
                return Integer.valueOf(f11.intValue());
            }
            throw new ConversionException("cannot coerce Float to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            Double d11 = (Double) obj;
            if (d11.doubleValue() <= 2.147483647E9d) {
                return Integer.valueOf(d11.intValue());
            }
            throw new ConversionException("cannot coerce Long to Integer since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return obj;
        }
    }

    static {
        HashMap map = new HashMap(10);
        f67849a = map;
        map.put(Object.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(BigInteger.class, new e());
        map.put(String.class, new f());
        map.put(Short.class, new g());
        map.put(Long.class, new h());
        map.put(Float.class, new i());
        map.put(Double.class, new j());
        map.put(Integer.class, new k());
        map.put(Boolean.class, new a());
        map.put(Character.class, new b());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67849a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67849a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
