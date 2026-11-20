package du;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        if (obj instanceof String) {
            return Enum.valueOf((Class) type, obj.toString());
        }
        throw new com.transsion.json.k(String.format("%s:  Don't know how to convert %s to enumerated constant of %s", oVar.d(), obj, type));
    }
}
