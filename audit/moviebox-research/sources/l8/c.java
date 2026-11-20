package l8;

import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.UFX;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UFX f70158a;

    public c() {
        this.f70158a = null;
        this.f70158a = q8.c.c();
    }

    @Override // l8.d
    public e a(a aVar) throws IOException {
        Ql.sc scVar = new Ql.sc();
        try {
            Map<String, String> map = aVar.f70156e;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        scVar.pFF(key, value);
                    }
                }
            }
            BT btPFF = this.f70158a.sc(scVar.pFF(aVar.f70153b).sc().sc("videoPreloadLowVersion").sc(6).pFF()).pFF();
            btPFF.zY();
            return new b(btPFF, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }
}
