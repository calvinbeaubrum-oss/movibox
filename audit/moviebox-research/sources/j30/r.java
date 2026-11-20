package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class r implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Short f67852a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Short f67853b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static j30.i f67854c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Class, j30.i> f67855d;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            return ((Boolean) obj).booleanValue() ? r.f67852a : r.f67853b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            return Short.valueOf(Short.parseShort((String) obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        public Object a(Object obj) {
            return r.f67854c.a(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            return Short.valueOf(((BigDecimal) obj).shortValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            return Short.valueOf(((BigInteger) obj).shortValue());
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
        public Short a(Object obj) {
            Integer num = (Integer) obj;
            if (num.intValue() <= 32767) {
                return Short.valueOf(num.shortValue());
            }
            throw new ConversionException("cannot coerce Integer to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            Float f11 = (Float) obj;
            if (f11.floatValue() <= 32767.0f) {
                return Short.valueOf(f11.shortValue());
            }
            throw new ConversionException("cannot coerce Float to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            Double d11 = (Double) obj;
            if (d11.doubleValue() <= 32767.0d) {
                return Short.valueOf(d11.shortValue());
            }
            throw new ConversionException("cannot coerce Double to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(Object obj) {
            Long l11 = (Long) obj;
            if (l11.longValue() <= 32767) {
                return Short.valueOf(l11.shortValue());
            }
            throw new ConversionException("cannot coerce Integer to Short since the value (" + String.valueOf(obj) + ") exceeds that maximum precision of Integer.");
        }
    }

    static {
        HashMap map = new HashMap();
        f67855d = map;
        map.put(String.class, f67854c);
        map.put(Object.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(BigInteger.class, new e());
        map.put(Short.class, new f());
        map.put(Integer.class, new g());
        map.put(Float.class, new h());
        map.put(Double.class, new i());
        map.put(Long.class, new j());
        map.put(Boolean.class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67855d.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67855d;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Short.class.getName());
    }
}
