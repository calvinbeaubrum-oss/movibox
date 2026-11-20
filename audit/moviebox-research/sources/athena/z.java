package athena;

import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.transsion.athena.data.AppIdData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13775b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public interface a {
        void a(y yVar);
    }

    public z() {
        com.transsion.core.utils.a.c();
        j0.m();
        this.f13774a = k.c(ws.a.a());
        this.f13775b = ws.a.a().getFilesDir().getPath();
    }

    public int a(int i11, l0<String> l0Var) {
        try {
            return this.f13774a.a(k.a.f13712a, i11, l0Var);
        } catch (com.transsion.ga.e e11) {
            int i12 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
            return -1;
        }
    }

    public int b(cr.a aVar) {
        int i11 = 1;
        if (aVar.h() != 1 && aVar.h() != 2) {
            i11 = 0;
        }
        try {
            return this.f13774a.b(k.a.f13712a, aVar, i11);
        } catch (com.transsion.ga.e e11) {
            int i12 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
            return 0;
        }
    }

    public int c(ArrayList<cr.a> arrayList, l0<LongSparseArray<Integer>> l0Var) {
        try {
            return this.f13774a.r(k.a.f13712a, arrayList, l0Var);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
            return 0;
        }
    }

    public synchronized cr.d d(long j11, long j12, String str, int i11, int i12) {
        try {
        } catch (com.transsion.ga.e e11) {
            int i13 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
            return null;
        }
        return this.f13774a.d(k.a.f13712a, j11, j12, str, i11, i12);
    }

    public synchronized void e() {
        this.f13774a.f();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f13775b);
            String str = File.separator;
            sb2.append(str);
            sb2.append(br.g.f14358k);
            v.h(sb2.toString());
            v.h(this.f13775b + str + br.g.f14359l);
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public synchronized void f(long j11, a aVar) {
        try {
            String str = this.f13775b + File.separator + br.g.f14358k;
            if (new File(str).exists()) {
                for (File file : v.e(str, j11)) {
                    if (!file.getName().contains("upload")) {
                        if (file.getName().startsWith("f_") || file.getName().startsWith("r_")) {
                            File file2 = new File(file.getPath() + "upload" + System.currentTimeMillis());
                            file = !file.renameTo(file2) ? null : file2;
                        }
                    }
                    if (file != null) {
                        aVar.a(new d0(j11, file, ar.b.a().m(j11)));
                    }
                }
            }
            String str2 = this.f13775b + File.separator + br.g.f14359l;
            if (new File(str2).exists()) {
                try {
                    v.h(str2);
                } catch (Exception e11) {
                    a0.c(Log.getStackTraceString(e11));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void g(l0<SparseArray<br.b>> l0Var) {
        try {
            this.f13774a.p(l0Var);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void h(br.b bVar, boolean z11) {
        try {
            this.f13774a.h(k.a.f13715d, bVar, z11);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public void i(AppIdData appIdData) {
        try {
            this.f13774a.i(k.a.f13715d, appIdData);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void j(String str, long j11) {
        try {
            this.f13774a.j(k.a.f13712a, str, j11);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void k(List<AppIdData> list) {
        try {
            this.f13774a.k(k.a.f13715d, list);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void l(List<AppIdData> list, int i11) {
        try {
            this.f13774a.l(k.a.f13715d, list, i11);
        } catch (com.transsion.ga.e e11) {
            int i12 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void m(List<AppIdData> list, long j11, String str, l0<SparseArray<cr.e>> l0Var) {
        try {
            this.f13774a.m(k.a.f13712a, list, j11, str, l0Var);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void n(List<AppIdData> list, String str) {
        try {
            this.f13774a.o(k.a.f13712a, list, str);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
        }
    }

    public synchronized void o(List<Long> list, boolean z11, l0<String> l0Var) {
        if (z11) {
            try {
                String str = this.f13775b + File.separator + br.g.f14358k;
                if (new File(str).exists()) {
                    for (File file : v.m(str)) {
                        String name = file.getName();
                        if (!name.startsWith("f_") && !name.startsWith("r_")) {
                            a0.a("cleanupEvents deleteFile " + name + " " + v.l(file));
                        } else if (list.contains(Long.valueOf(Long.parseLong(name.substring(2, name.indexOf(45)))))) {
                            a0.a("cleanupEvents deleteFile " + name + " " + v.l(file));
                        }
                    }
                }
                String str2 = this.f13775b + File.separator + br.g.f14359l;
                if (new File(str2).exists()) {
                    try {
                        v.h(str2);
                    } catch (Exception e11) {
                        a0.c(Log.getStackTraceString(e11));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.f13774a.n(k.a.f13712a, list, l0Var);
        } catch (com.transsion.ga.e e12) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e12);
        }
    }

    public synchronized boolean p(int i11) {
        try {
        } catch (com.transsion.ga.e e11) {
            int i12 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
            return false;
        }
        return this.f13774a.q(k.a.f13712a, i11);
    }

    public List<AppIdData> q() {
        try {
            return this.f13774a.e(k.a.f13715d);
        } catch (com.transsion.ga.e e11) {
            int i11 = com.transsion.ga.e.f51961a;
            com.transsion.ga.l.a().c(e11);
            return null;
        }
    }
}
