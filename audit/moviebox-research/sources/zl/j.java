package zl;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.BiConsumer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f82088e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f82089f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f82090g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<BiConsumer<String, com.google.firebase.remoteconfig.internal.a>> f82091a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f82092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f82093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f82094d;

    public j(Executor executor, d dVar, d dVar2) {
        this.f82092b = executor;
        this.f82093c = dVar;
        this.f82094d = dVar2;
    }

    @Nullable
    public static com.google.firebase.remoteconfig.internal.a e(d dVar) {
        return dVar.f();
    }

    public static Set<String> f(d dVar) {
        HashSet hashSet = new HashSet();
        com.google.firebase.remoteconfig.internal.a aVarE = e(dVar);
        if (aVarE == null) {
            return hashSet;
        }
        Iterator<String> itKeys = aVarE.d().keys();
        while (itKeys.hasNext()) {
            hashSet.add(itKeys.next());
        }
        return hashSet;
    }

    public static TreeSet<String> h(String str, com.google.firebase.remoteconfig.internal.a aVar) {
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator<String> itKeys = aVar.d().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    @Nullable
    public static Long j(d dVar, String str) {
        com.google.firebase.remoteconfig.internal.a aVarE = e(dVar);
        if (aVarE == null) {
            return null;
        }
        try {
            return Long.valueOf(aVarE.d().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    public static String l(d dVar, String str) {
        com.google.firebase.remoteconfig.internal.a aVarE = e(dVar);
        if (aVarE == null) {
            return null;
        }
        try {
            return aVarE.d().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void o(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void b(BiConsumer<String, com.google.firebase.remoteconfig.internal.a> biConsumer) {
        synchronized (this.f82091a) {
            this.f82091a.add(biConsumer);
        }
    }

    public final void c(final String str, final com.google.firebase.remoteconfig.internal.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f82091a) {
            try {
                for (final BiConsumer<String, com.google.firebase.remoteconfig.internal.a> biConsumer : this.f82091a) {
                    this.f82092b.execute(new Runnable() { // from class: zl.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            biConsumer.accept(str, aVar);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Map<String, yl.i> d() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(f(this.f82093c));
        hashSet.addAll(f(this.f82094d));
        HashMap map = new HashMap();
        for (String str : hashSet) {
            map.put(str, m(str));
        }
        return map;
    }

    public Set<String> g(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        com.google.firebase.remoteconfig.internal.a aVarE = e(this.f82093c);
        if (aVarE != null) {
            treeSet.addAll(h(str, aVarE));
        }
        com.google.firebase.remoteconfig.internal.a aVarE2 = e(this.f82094d);
        if (aVarE2 != null) {
            treeSet.addAll(h(str, aVarE2));
        }
        return treeSet;
    }

    public long i(String str) {
        Long lJ = j(this.f82093c, str);
        if (lJ != null) {
            c(str, e(this.f82093c));
            return lJ.longValue();
        }
        Long lJ2 = j(this.f82094d, str);
        if (lJ2 != null) {
            return lJ2.longValue();
        }
        o(str, "Long");
        return 0L;
    }

    public String k(String str) {
        String strL = l(this.f82093c, str);
        if (strL != null) {
            c(str, e(this.f82093c));
            return strL;
        }
        String strL2 = l(this.f82094d, str);
        if (strL2 != null) {
            return strL2;
        }
        o(str, "String");
        return "";
    }

    public yl.i m(String str) {
        String strL = l(this.f82093c, str);
        if (strL != null) {
            c(str, e(this.f82093c));
            return new l(strL, 2);
        }
        String strL2 = l(this.f82094d, str);
        if (strL2 != null) {
            return new l(strL2, 1);
        }
        o(str, "FirebaseRemoteConfigValue");
        return new l("", 0);
    }
}
