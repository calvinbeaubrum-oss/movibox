package com.mbridge.msdk.foundation.same.b;

import android.util.Log;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ag;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f44430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f44431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<a> f44432c = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f44433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f44434b;

        public a(c cVar, File file) {
            this.f44434b = cVar;
            this.f44433a = file;
        }
    }

    private e(b bVar) {
        this.f44431b = bVar;
    }

    public static synchronized e a() {
        try {
            if (f44430a == null && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                ag.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
            if (f44430a == null) {
                Log.e("MBridgeDirManager", "mDirectoryManager == null");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f44430a;
    }

    public static String a(c cVar) {
        File fileB = b(cVar);
        if (fileB != null) {
            return fileB.getAbsolutePath();
        }
        return null;
    }

    public static synchronized void a(b bVar) {
        if (f44430a == null) {
            f44430a = new e(bVar);
        }
    }

    private boolean a(com.mbridge.msdk.foundation.same.b.a aVar) {
        String strB;
        com.mbridge.msdk.foundation.same.b.a aVarC = aVar.c();
        if (aVarC == null) {
            strB = aVar.b();
        } else {
            File fileB = b(aVarC.d());
            if (fileB == null) {
                return false;
            }
            strB = fileB.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(strB);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        this.f44432c.add(new a(aVar.d(), file));
        List<com.mbridge.msdk.foundation.same.b.a> listA = aVar.a();
        if (listA == null) {
            return true;
        }
        Iterator<com.mbridge.msdk.foundation.same.b.a> it = listA.iterator();
        while (it.hasNext()) {
            if (!a(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static File b(c cVar) {
        try {
            if (a() == null || a().f44432c == null || a().f44432c.size() <= 0) {
                return null;
            }
            for (a aVar : a().f44432c) {
                if (aVar.f44434b.equals(cVar)) {
                    return aVar.f44433a;
                }
            }
            return null;
        } catch (Throwable th2) {
            ad.a("MBridgeDirManager", th2.getMessage(), th2);
            return null;
        }
    }

    public final boolean b() {
        return a(this.f44431b.b());
    }
}
