package j30;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class s implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, i> f67856a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements i {
        @Override // j30.i
        public Object a(Object obj) {
            Object[] objArr = (Object[]) obj;
            String[] strArr = new String[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                strArr[i11] = String.valueOf(objArr[i11]);
            }
            return strArr;
        }
    }

    static {
        HashMap map = new HashMap();
        f67856a = map;
        map.put(Object[].class, new a());
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return f67856a.containsKey(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        if (!obj.getClass().isArray()) {
            return new String[]{String.valueOf(obj)};
        }
        Object[] objArr = (Object[]) obj;
        String[] strArr = new String[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            strArr[i11] = String.valueOf(objArr[i11]);
        }
        return strArr;
    }
}
