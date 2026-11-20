package du;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        try {
            return oVar.k((Map) obj, b(cls), type);
        } catch (IllegalAccessException e11) {
            throw new com.transsion.json.k(oVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e11);
        } catch (InstantiationException e12) {
            throw new com.transsion.json.k(oVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e12);
        } catch (NoSuchMethodException e13) {
            throw new com.transsion.json.k(oVar.d() + ": " + cls.getName() + " lacks a no argument constructor.  com.zero.json will instantiate any protected, private, or public no-arg constructor.", e13);
        } catch (InvocationTargetException e14) {
            throw new com.transsion.json.k(oVar.d() + ":There was an exception trying to instantiate an instance of " + cls.getName(), e14);
        }
    }

    public Object b(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }
}
