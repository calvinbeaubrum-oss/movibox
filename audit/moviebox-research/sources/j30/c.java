package j30;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, j30.i> f67835a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return (BigInteger) obj;
        }
    }

    /* JADX INFO: renamed from: j30.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0723c implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return ((BigDecimal) obj).toBigInteger();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger((String) obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger(String.valueOf(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger((String) obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements j30.i {
        @Override // j30.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigInteger a(Object obj) {
            return new BigInteger(new String((char[]) obj));
        }
    }

    static {
        HashMap map = new HashMap();
        f67835a = map;
        map.put(Object.class, new a());
        map.put(BigInteger.class, new b());
        map.put(BigDecimal.class, new C0723c());
        map.put(String.class, new d());
        map.put(Short.class, new e());
        map.put(Long.class, new f());
        map.put(Integer.class, new g());
        map.put(String.class, new h());
        map.put(char[].class, new i());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67835a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, j30.i> map = f67835a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Integer.class.getName());
    }
}
