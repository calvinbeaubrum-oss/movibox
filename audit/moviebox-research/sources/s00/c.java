package s00;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.x;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import v00.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements s00.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f75920c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VungleApiClient f75921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Repository f75922b;

    /* JADX INFO: compiled from: source.java */
    public class a implements v00.c<JsonObject> {
        public a() {
        }

        @Override // v00.c
        public void a(@NonNull v00.b<JsonObject> bVar, e<JsonObject> eVar) {
            String unused = c.f75920c;
        }

        @Override // v00.c
        public void b(v00.b<JsonObject> bVar, Throwable th2) {
            String unused = c.f75920c;
        }
    }

    public c(VungleApiClient vungleApiClient, Repository repository) {
        this.f75921a = vungleApiClient;
        this.f75922b = repository;
    }

    @Override // s00.a
    public String[] a() {
        List list = (List) this.f75922b.V(com.vungle.warren.model.e.class).get();
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((com.vungle.warren.model.e) list.get(i11)).f62164a;
        }
        return b(strArr);
    }

    @Override // s00.a
    public String[] b(@NonNull String[] strArr) {
        if (strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    try {
                        if (this.f75921a.v(str)) {
                            this.f75922b.s(new com.vungle.warren.model.e(str));
                        } else {
                            arrayList.add(str);
                        }
                    } catch (DatabaseHelper.DBException unused) {
                        Log.e(f75920c, "DBException deleting : " + str);
                        Log.e(f75920c, "Invalid Url : " + str);
                    }
                } catch (VungleApiClient.ClearTextTrafficException unused2) {
                    Log.e(f75920c, "Cleartext Network Traffic is Blocked : " + str);
                } catch (DatabaseHelper.DBException unused3) {
                    Log.e(f75920c, "Can't delete sent ping URL : " + str);
                } catch (MalformedURLException unused4) {
                    this.f75922b.s(new com.vungle.warren.model.e(str));
                    Log.e(f75920c, "Invalid Url : " + str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // s00.a
    public void c(JsonObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        this.f75921a.z(jsonObject).a(new a());
    }

    @Override // s00.a
    public void d(String[] strArr) {
        for (String str : strArr) {
            if (x.a(str)) {
                try {
                    this.f75922b.h0(new com.vungle.warren.model.e(str));
                } catch (DatabaseHelper.DBException unused) {
                    Log.e(f75920c, "Can't save failed to ping URL : " + str);
                }
            }
        }
    }
}
