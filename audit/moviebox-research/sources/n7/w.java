package n7;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class w implements b2 {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T c(l7.a aVar) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 4) {
            String strG0 = bVar.g0();
            bVar.W(16);
            return (T) strG0.toCharArray();
        }
        if (bVar.k0() == 2) {
            Number numberI0 = bVar.i0();
            bVar.W(16);
            return (T) numberI0.toString().toCharArray();
        }
        Object objX = aVar.x();
        if (objX instanceof String) {
            return (T) ((String) objX).toCharArray();
        }
        if (!(objX instanceof Collection)) {
            if (objX == null) {
                return null;
            }
            return (T) com.alibaba.fastjson.a.toJSONString(objX).toCharArray();
        }
        Collection collection = (Collection) objX;
        for (Object obj : collection) {
            if ((obj instanceof String) && ((String) obj).length() != 1) {
                throw new JSONException("can not cast to char[]");
            }
        }
        char[] cArr = new char[collection.size()];
        Iterator it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            cArr[i11] = ((String) it.next()).charAt(0);
            i11++;
        }
        return cArr;
    }

    @Override // m7.b2
    public int b() {
        return 4;
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) c(aVar);
    }
}
