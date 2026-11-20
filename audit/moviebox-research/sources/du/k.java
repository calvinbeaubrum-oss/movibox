package du;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class k implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        com.transsion.json.n nVar = (com.transsion.json.n) obj;
        return nVar.a() ? Long.valueOf(nVar.longValue()) : Double.valueOf(nVar.doubleValue());
    }
}
