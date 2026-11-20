package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67834a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal((String) obj, MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: renamed from: j30.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0722b implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal((char[]) obj, MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(String.valueOf(obj), MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return (BigDecimal) obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(((BigInteger) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal((String) obj, MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(((Double) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(((Float) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(((Short) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(((Long) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(Object obj) {
            return new BigDecimal(((Integer) obj).doubleValue(), MathContext.DECIMAL128);
        }
    }

    static {
        HashMap map = new HashMap();
        f67834a = map;
        map.put(Object.class, new c());
        map.put(BigDecimal.class, new d());
        map.put(BigInteger.class, new e());
        map.put(String.class, new f());
        map.put(Double.class, new g());
        map.put(Float.class, new h());
        map.put(Short.class, new i());
        map.put(Long.class, new j());
        map.put(Integer.class, new k());
        map.put(String.class, new a());
        map.put(char[].class, new C0722b());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67834a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67834a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
