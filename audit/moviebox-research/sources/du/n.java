package du;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        if (type == null || !(type instanceof ParameterizedType)) {
            return oVar.l((Map) obj, b(), null, null);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = parameterizedType.getActualTypeArguments()[1];
        Map map = (Map) obj;
        HashMap<Object, Object> mapB = b();
        if (type2 == Object.class) {
            type2 = null;
        }
        return oVar.l(map, mapB, type2, type3 != Object.class ? type3 : null);
    }

    public HashMap<Object, Object> b() {
        return new HashMap<>();
    }
}
