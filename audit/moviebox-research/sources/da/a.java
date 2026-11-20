package da;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.k;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f62965b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f62966a;

    public a() {
        try {
            EnumMap<MMKVRecoverStrategic, Integer> enumMap = MMKV.f49335a;
            if (Build.VERSION.SDK_INT < 35 || !(b.c().h().startsWith("v1.") || b.c().h().startsWith("v0."))) {
                this.f62966a = b.c();
            } else {
                c.Log().e("AdxPreferencesHelper", "mmkv is not ajust target 35");
            }
        } catch (Throwable unused) {
            c.Log().e("AdxPreferencesHelper", "init mmkv error, com.tencent.mmkv.MMKV not found!");
            this.f62966a = null;
        }
    }

    public static a d() {
        return f62965b;
    }

    public void a() {
        b bVar = this.f62966a;
        if (bVar != null) {
            bVar.a();
        } else {
            k.d("hisavana_sdk").b();
        }
    }

    public boolean b(String str) {
        return c(str, false);
    }

    public boolean c(String str, boolean z11) {
        b bVar = this.f62966a;
        return bVar != null ? bVar.b(str, z11) : k.d("hisavana_sdk").c(str, z11);
    }

    public int e(String str) {
        return f(str, 0);
    }

    public int f(String str, int i11) {
        b bVar = this.f62966a;
        return bVar != null ? bVar.d(str, i11) : k.d("hisavana_sdk").e(str, i11);
    }

    public long g(String str) {
        return h(str, 0L);
    }

    public long h(String str, long j11) {
        b bVar = this.f62966a;
        return bVar != null ? bVar.e(str, j11) : k.d("hisavana_sdk").f(str, j11);
    }

    public String i(String str) {
        return j(str, "");
    }

    public String j(String str, String str2) {
        b bVar = this.f62966a;
        return bVar != null ? bVar.f(str, str2) : k.d("hisavana_sdk").g(str, str2);
    }

    public Set<String> k(String str) {
        return l(str, new HashSet());
    }

    public Set<String> l(String str, Set<String> set) {
        b bVar = this.f62966a;
        return bVar != null ? bVar.g(str, set) : k.d("hisavana_sdk").h(str, set);
    }

    public void m(String str, boolean z11) {
        b bVar = this.f62966a;
        if (bVar != null) {
            bVar.i(str, z11);
        } else {
            k.d("hisavana_sdk").i(str, z11);
        }
    }

    public void n(String str, int i11) {
        b bVar = this.f62966a;
        if (bVar != null) {
            bVar.j(str, i11);
        } else {
            k.d("hisavana_sdk").j(str, i11);
        }
    }

    public void o(String str, long j11) {
        b bVar = this.f62966a;
        if (bVar != null) {
            bVar.k(str, j11);
        } else {
            k.d("hisavana_sdk").k(str, j11);
        }
    }

    public void p(String str, String str2) {
        b bVar = this.f62966a;
        if (bVar == null) {
            k.d("hisavana_sdk").l(str, str2);
        } else {
            bVar.l(str, str2);
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = this.f62966a;
        if (bVar != null) {
            bVar.m(str);
        } else {
            k.d("hisavana_sdk").m(str);
        }
    }
}
