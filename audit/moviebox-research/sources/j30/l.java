package j30;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, i> f67848a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements i {
        @Override // j30.i
        public Object a(Object obj) {
            String[] strArr = (String[]) obj;
            Integer[] numArr = new Integer[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                numArr[i11] = Integer.valueOf(Integer.parseInt(strArr[i11]));
            }
            return numArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements i {
        @Override // j30.i
        public Object a(Object obj) {
            Object[] objArr = (Object[]) obj;
            Integer[] numArr = new Integer[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                numArr[i11] = Integer.valueOf(Integer.parseInt(String.valueOf(objArr[i11])));
            }
            return numArr;
        }
    }

    static {
        HashMap map = new HashMap();
        f67848a = map;
        map.put(String[].class, new a());
        map.put(Object[].class, new b());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67848a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        Map<Class, i> map = f67848a;
        if (map.containsKey(obj.getClass())) {
            return map.get(obj.getClass()).a(obj);
        }
        throw new ConversionException("cannot convert type: " + obj.getClass().getName() + " to: " + Boolean.class.getName());
    }
}
