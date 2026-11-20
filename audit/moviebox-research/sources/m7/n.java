package m7;

import com.alibaba.fastjson.JSONException;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f70903a = new n();

    @Override // m7.b2
    public int b() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.alibaba.fastjson.c] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        int iK0;
        l7.c cVar = (l7.c) aVar.p();
        String strY = cVar.y(aVar.t());
        cVar.w();
        int iK1 = cVar.k0();
        if (iK1 == 25) {
            String strY2 = cVar.y(aVar.t());
            strY = (strY + InstructionFileId.DOT) + strY2;
            cVar.w();
            iK1 = cVar.k0();
        }
        ?? r11 = (T) new com.alibaba.fastjson.c(strY);
        if (iK1 != 10) {
            throw new JSONException("illegal jsonp : " + cVar.c());
        }
        cVar.w();
        while (true) {
            r11.b(aVar.x());
            iK0 = cVar.k0();
            if (iK0 != 16) {
                break;
            }
            cVar.w();
        }
        if (iK0 == 11) {
            cVar.w();
            if (cVar.k0() == 24) {
                cVar.w();
            }
            return r11;
        }
        throw new JSONException("illegal jsonp : " + cVar.c());
    }
}
