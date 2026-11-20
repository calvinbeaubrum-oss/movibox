package y00;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.JsonObject;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.o;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f81053c = "y00.k";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Repository f81054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VungleApiClient f81055b;

    public k(Repository repository, VungleApiClient vungleApiClient) {
        this.f81054a = repository;
        this.f81055b = vungleApiClient;
    }

    public static g b(boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("sendAll", z11);
        return new g(f81053c).l(bundle).m(5).o(30000L, 1);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        List<o> list = bundle.getBoolean("sendAll", false) ? this.f81054a.a0().get() : this.f81054a.c0().get();
        if (list == null) {
            return 1;
        }
        for (o oVar : list) {
            try {
                v00.e<JsonObject> eVarExecute = this.f81055b.w(oVar.n()).execute();
                if (eVarExecute.b() != 200) {
                    oVar.k(3);
                    this.f81054a.h0(oVar);
                    long jP = this.f81055b.p(eVarExecute);
                    if (jP > 0) {
                        hVar.a(b(false).k(jP));
                    }
                    return 1;
                }
                this.f81054a.s(oVar);
            } catch (DatabaseHelper.DBException unused) {
            } catch (IOException e11) {
                for (o oVar2 : list) {
                    oVar2.k(3);
                    try {
                        this.f81054a.h0(oVar2);
                    } catch (DatabaseHelper.DBException unused2) {
                        return 1;
                    }
                }
                Log.e(f81053c, Log.getStackTraceString(e11));
                return 2;
            }
        }
        return 0;
    }
}
