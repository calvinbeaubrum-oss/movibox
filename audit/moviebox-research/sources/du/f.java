package du;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        try {
            oVar.d();
            throw null;
        } catch (ClassNotFoundException e11) {
            throw new com.transsion.json.k(String.format("%s: Could not find class %s", oVar.d(), e11.getMessage()), e11);
        } catch (IllegalAccessException unused) {
            oVar.d();
            throw null;
        } catch (InstantiationException unused2) {
            oVar.d();
            throw null;
        } catch (NoSuchMethodException unused3) {
            oVar.d();
            throw null;
        } catch (InvocationTargetException unused4) {
            oVar.d();
            throw null;
        }
    }

    public com.transsion.json.g b() {
        return null;
    }
}
