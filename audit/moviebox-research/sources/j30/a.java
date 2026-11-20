package j30;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements org.mvel2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f67833a;

    public a(Class cls) {
        this.f67833a = cls;
    }

    public static Object c(Class cls, Object obj, Class cls2) {
        Class<?> componentType = cls2.getComponentType();
        int i11 = 0;
        if (Collection.class.isAssignableFrom(cls)) {
            Collection collection = (Collection) obj;
            Object objNewInstance = Array.newInstance(componentType, collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Array.set(objNewInstance, i11, org.mvel2.b.b(it.next(), componentType));
                i11++;
            }
            return objNewInstance;
        }
        if (!obj.getClass().isArray()) {
            Object objNewInstance2 = Array.newInstance(componentType, 1);
            Array.set(objNewInstance2, 0, obj);
            return objNewInstance2;
        }
        int length = Array.getLength(obj);
        Object objNewInstance3 = Array.newInstance(componentType, length);
        while (i11 < length) {
            Array.set(objNewInstance3, i11, org.mvel2.b.b(Array.get(obj, i11), componentType));
            i11++;
        }
        return objNewInstance3;
    }

    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls);
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        return c(obj.getClass(), obj, this.f67833a);
    }
}
