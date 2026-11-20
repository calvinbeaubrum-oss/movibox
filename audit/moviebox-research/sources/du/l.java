package du;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l implements com.transsion.json.p {
    @Override // com.transsion.json.p
    public Object a(com.transsion.json.o oVar, Object obj, Type type, Class cls) {
        if (obj instanceof Collection) {
            return oVar.o((Collection) obj, new ArrayList(), type);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar.i(obj));
        return arrayList;
    }
}
