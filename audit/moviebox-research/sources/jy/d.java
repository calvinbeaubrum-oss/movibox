package jy;

import com.transsion.transfer.androidasync.future.y;
import com.transsion.transfer.androidasync.r;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements a<JSONObject> {
    @Override // jy.a
    public com.transsion.transfer.androidasync.future.f<JSONObject> a(r rVar) {
        return new f().a(rVar).r(new y() { // from class: jy.c
            @Override // com.transsion.transfer.androidasync.future.y
            public final Object then(Object obj) {
                return new JSONObject((String) obj);
            }
        });
    }
}
