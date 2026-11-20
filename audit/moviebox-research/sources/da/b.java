package da;

import android.util.Log;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.f;
import com.tencent.mmkv.MMKV;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f62967b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MMKV f62968a;

    public b() {
        try {
            MMKV.t(f.a());
            this.f62968a = MMKV.z("HisavanaMMKV");
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "Hisavana MMKV init error " + e11.getMessage());
        }
    }

    public static b c() {
        return f62967b;
    }

    public void a() {
        try {
            this.f62968a.clear();
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "clear " + Log.getStackTraceString(e11));
        }
    }

    public boolean b(String str, boolean z11) {
        try {
            return this.f62968a.getBoolean(str, z11);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "getBoolean " + Log.getStackTraceString(e11));
            return z11;
        }
    }

    public int d(String str, int i11) {
        try {
            return this.f62968a.getInt(str, i11);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "getInt " + Log.getStackTraceString(e11));
            return i11;
        }
    }

    public long e(String str, long j11) {
        try {
            return this.f62968a.getLong(str, j11);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "getLong " + Log.getStackTraceString(e11));
            return j11;
        }
    }

    public String f(String str, String str2) {
        try {
            return this.f62968a.getString(str, str2);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "getString " + Log.getStackTraceString(e11));
            return str2;
        }
    }

    public Set<String> g(String str, Set<String> set) {
        try {
            return this.f62968a.getStringSet(str, set);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "getStringSet " + Log.getStackTraceString(e11));
            return set;
        }
    }

    public String h() {
        try {
            return MMKV.version();
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "MMKV.version() " + Log.getStackTraceString(e11));
            return "";
        }
    }

    public void i(String str, boolean z11) {
        try {
            this.f62968a.putBoolean(str, z11);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "putBoolean " + Log.getStackTraceString(e11));
        }
    }

    public void j(String str, int i11) {
        try {
            this.f62968a.putInt(str, i11);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "putInt " + Log.getStackTraceString(e11));
        }
    }

    public void k(String str, long j11) {
        try {
            this.f62968a.putLong(str, j11);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "putLong " + Log.getStackTraceString(e11));
        }
    }

    public void l(String str, String str2) {
        try {
            this.f62968a.putString(str, str2);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "putString " + Log.getStackTraceString(e11));
        }
    }

    public void m(String str) {
        try {
            this.f62968a.D(str);
        } catch (Exception e11) {
            c.Log().e("HisavanaMMKV", "getStringSet " + Log.getStackTraceString(e11));
        }
    }
}
