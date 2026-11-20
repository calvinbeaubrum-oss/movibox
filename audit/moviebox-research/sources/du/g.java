package du;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        try {
            return Double.valueOf(Double.parseDouble(obj.toString()));
        } catch (Exception unused) {
            throw oVar.q(obj, Double.class);
        }
    }
}
