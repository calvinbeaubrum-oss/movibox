package nk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.common.j;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import jk.i;
import lk.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f72019d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f72020e = 15;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f72021f = new g();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Comparator<? super File> f72022g = new Comparator() { // from class: nk.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.u((File) obj, (File) obj2);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final FilenameFilter f72023h = new FilenameFilter() { // from class: nk.d
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return e.v(file, str);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f72024a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f72025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ok.g f72026c;

    public e(f fVar, ok.g gVar) {
        this.f72025b = fVar;
        this.f72026c = gVar;
    }

    @NonNull
    public static String A(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i11 = fileInputStream.read(bArr);
                if (i11 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f72019d);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i11);
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void F(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f72019d);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th2) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static void G(File file, String str, long j11) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f72019d);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j11));
            outputStreamWriter.close();
        } catch (Throwable th2) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static int f(List<File> list, int i11) {
        int size = list.size();
        for (File file : list) {
            if (size <= i11) {
                return size;
            }
            f.s(file);
            size--;
        }
        return size;
    }

    public static long h(long j11) {
        return j11 * 1000;
    }

    @NonNull
    public static String m(int i11, boolean z11) {
        return NotificationCompat.CATEGORY_EVENT + String.format(Locale.US, "%010d", Integer.valueOf(i11)) + (z11 ? "_" : "");
    }

    @NonNull
    public static String o(@NonNull String str) {
        return str.substring(0, f72020e);
    }

    public static boolean s(@NonNull String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && str.endsWith("_");
    }

    public static boolean t(@NonNull File file, @NonNull String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_");
    }

    public static /* synthetic */ int u(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    public static /* synthetic */ boolean v(File file, String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT);
    }

    public static int x(@NonNull File file, @NonNull File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    public final void B(@NonNull File file, @NonNull CrashlyticsReport.d dVar, @NonNull String str) {
        try {
            g gVar = f72021f;
            F(this.f72025b.g(str), gVar.E(gVar.D(A(file)).m(dVar)));
        } catch (IOException e11) {
            gk.f.f().l("Could not synthesize final native report file for " + file, e11);
        }
    }

    public final void C(String str, long j11) {
        boolean z11;
        List<File> listP = this.f72025b.p(str, f72023h);
        if (listP.isEmpty()) {
            gk.f.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(listP);
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = listP.iterator();
        loop0: while (true) {
            z11 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File next = it.next();
                try {
                    arrayList.add(f72021f.g(A(next)));
                    if (z11 || s(next.getName())) {
                        z11 = true;
                    }
                } catch (IOException e11) {
                    gk.f.f().l("Could not add event to report for " + next, e11);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            D(this.f72025b.o(str, "report"), arrayList, j11, z11, i.j(str, this.f72025b));
            return;
        }
        gk.f.f().k("Could not parse event files for session " + str);
    }

    public final void D(@NonNull File file, @NonNull List<CrashlyticsReport.e.d> list, long j11, boolean z11, @Nullable String str) {
        try {
            g gVar = f72021f;
            CrashlyticsReport crashlyticsReportL = gVar.D(A(file)).n(j11, z11, str).l(kk.e.a(list));
            CrashlyticsReport.e eVarJ = crashlyticsReportL.j();
            if (eVarJ == null) {
                return;
            }
            F(z11 ? this.f72025b.j(eVarJ.h()) : this.f72025b.l(eVarJ.h()), gVar.E(crashlyticsReportL));
        } catch (IOException e11) {
            gk.f.f().l("Could not synthesize final report file for " + file, e11);
        }
    }

    public final int E(String str, int i11) {
        List<File> listP = this.f72025b.p(str, new FilenameFilter() { // from class: nk.a
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return e.t(file, str2);
            }
        });
        Collections.sort(listP, new Comparator() { // from class: nk.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.x((File) obj, (File) obj2);
            }
        });
        return f(listP, i11);
    }

    public final SortedSet<String> e(@Nullable String str) {
        this.f72025b.b();
        SortedSet<String> sortedSetP = p();
        if (str != null) {
            sortedSetP.remove(str);
        }
        if (sortedSetP.size() <= 8) {
            return sortedSetP;
        }
        while (sortedSetP.size() > 8) {
            String strLast = sortedSetP.last();
            gk.f.f().b("Removing session over cap: " + strLast);
            this.f72025b.c(strLast);
            sortedSetP.remove(strLast);
        }
        return sortedSetP;
    }

    public final void g() {
        int i11 = this.f72026c.b().f72456a.f72467b;
        List<File> listN = n();
        int size = listN.size();
        if (size <= i11) {
            return;
        }
        Iterator<File> it = listN.subList(i11, size).iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    public void i() {
        j(this.f72025b.m());
        j(this.f72025b.k());
        j(this.f72025b.h());
    }

    public final void j(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    public void k(@Nullable String str, long j11) {
        for (String str2 : e(str)) {
            gk.f.f().i("Finalizing report for session " + str2);
            C(str2, j11);
            this.f72025b.c(str2);
        }
        g();
    }

    public void l(String str, CrashlyticsReport.d dVar) {
        File fileO = this.f72025b.o(str, "report");
        gk.f.f().b("Writing native session report for " + str + " to file: " + fileO);
        B(fileO, dVar, str);
    }

    public final List<File> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f72025b.k());
        arrayList.addAll(this.f72025b.h());
        Comparator<? super File> comparator = f72022g;
        Collections.sort(arrayList, comparator);
        List<File> listM = this.f72025b.m();
        Collections.sort(listM, comparator);
        arrayList.addAll(listM);
        return arrayList;
    }

    public SortedSet<String> p() {
        return new TreeSet(this.f72025b.d()).descendingSet();
    }

    public long q(String str) {
        return this.f72025b.o(str, "start-time").lastModified();
    }

    public boolean r() {
        return (this.f72025b.m().isEmpty() && this.f72025b.k().isEmpty() && this.f72025b.h().isEmpty()) ? false : true;
    }

    @NonNull
    public List<j> w() {
        List<File> listN = n();
        ArrayList arrayList = new ArrayList();
        for (File file : listN) {
            try {
                arrayList.add(j.a(f72021f.D(A(file)), file.getName(), file));
            } catch (IOException e11) {
                gk.f.f().l("Could not load report file " + file + "; deleting", e11);
                file.delete();
            }
        }
        return arrayList;
    }

    public void y(@NonNull CrashlyticsReport.e.d dVar, @NonNull String str, boolean z11) {
        int i11 = this.f72026c.b().f72456a.f72466a;
        try {
            F(this.f72025b.o(str, m(this.f72024a.getAndIncrement(), z11)), f72021f.h(dVar));
        } catch (IOException e11) {
            gk.f.f().l("Could not persist event for session " + str, e11);
        }
        E(str, i11);
    }

    public void z(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.e eVarJ = crashlyticsReport.j();
        if (eVarJ == null) {
            gk.f.f().b("Could not get session for report");
            return;
        }
        String strH = eVarJ.h();
        try {
            F(this.f72025b.o(strH, "report"), f72021f.E(crashlyticsReport));
            G(this.f72025b.o(strH, "start-time"), "", eVarJ.k());
        } catch (IOException e11) {
            gk.f.f().c("Could not persist report for session " + strH, e11);
        }
    }
}
