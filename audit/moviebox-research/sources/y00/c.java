package y00;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.vungle.warren.AdLoader;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.model.m;
import com.vungle.warren.model.p;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f81033d = "y00.c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.vungle.warren.persistence.d f81034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Repository f81035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AdLoader f81036c;

    public c(@NonNull com.vungle.warren.persistence.d dVar, @NonNull Repository repository, @NonNull AdLoader adLoader) {
        this.f81034a = dVar;
        this.f81035b = repository;
        this.f81036c = adLoader;
    }

    public static g b() {
        return new g(f81033d).m(0).p(true);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        if (this.f81034a == null || this.f81035b == null) {
            return 1;
        }
        com.vungle.warren.utility.i.e(this.f81034a.getCacheDirectory());
        File[] fileArrListFiles = this.f81034a.getCacheDirectory().listFiles();
        List<m> list = (List) this.f81035b.V(m.class).get();
        if (list == null || list.size() == 0) {
            return 0;
        }
        Collection<m> collection = this.f81035b.e0().get();
        HashSet hashSet = new HashSet();
        try {
            for (m mVar : list) {
                if (collection == null || collection.isEmpty() || collection.contains(mVar)) {
                    List<String> list2 = this.f81035b.A(mVar.d()).get();
                    if (list2 != null) {
                        for (String str : list2) {
                            com.vungle.warren.model.c cVar = (com.vungle.warren.model.c) this.f81035b.T(str, com.vungle.warren.model.c.class).get();
                            if (cVar != null) {
                                if (cVar.u() > System.currentTimeMillis() || cVar.D() == 2) {
                                    hashSet.add(cVar.v());
                                    Log.w(f81033d, "setting valid adv " + str + " for placement " + mVar.d());
                                } else {
                                    this.f81035b.u(str);
                                    SessionTracker.l().w(new p.b().d(SessionEvent.AD_EXPIRED).a(SessionAttribute.EVENT_ID, str).c());
                                    this.f81036c.V(mVar, mVar.b(), 1000L, false);
                                }
                            }
                        }
                    }
                } else {
                    String.format(Locale.ENGLISH, "Placement %s is no longer valid, deleting it and its advertisement", mVar.d());
                    this.f81035b.s(mVar);
                }
            }
            List<com.vungle.warren.model.c> list3 = (List) this.f81035b.V(com.vungle.warren.model.c.class).get();
            if (list3 != null) {
                for (com.vungle.warren.model.c cVar2 : list3) {
                    if (cVar2.D() == 2) {
                        hashSet.add(cVar2.v());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("found adv in viewing state ");
                        sb2.append(cVar2.v());
                    } else if (!hashSet.contains(cVar2.v())) {
                        Log.e(f81033d, "    delete ad " + cVar2.v());
                        this.f81035b.u(cVar2.v());
                    }
                }
            }
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (!hashSet.contains(file.getName())) {
                        Log.v(f81033d, String.format(Locale.ENGLISH, "Deleting assets under directory %s", file.getName()));
                        com.vungle.warren.utility.i.b(file);
                    }
                }
            }
            return 0;
        } catch (DatabaseHelper.DBException unused) {
            return 1;
        } catch (IOException e11) {
            Log.e(f81033d, "Failed to delete asset directory!", e11);
            return 1;
        }
    }
}
