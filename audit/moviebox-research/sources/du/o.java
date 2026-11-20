package du;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class o implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        if (obj instanceof Collection) {
            return oVar.o((Collection) obj, new HashSet(), type);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(oVar.i(obj));
        return hashSet;
    }
}
