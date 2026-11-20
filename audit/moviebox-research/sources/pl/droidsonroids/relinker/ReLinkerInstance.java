package pl.droidsonroids.relinker;

import android.content.Context;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import v30.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ReLinkerInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f73932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.InterfaceC0806b f73933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b.a f73934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f73935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f73936e;

    /* JADX INFO: compiled from: source.java */
    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f73937a;

        public a(String str) {
            this.f73937a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f73937a);
        }
    }

    public ReLinkerInstance() {
        this(new c(), new pl.droidsonroids.relinker.a());
    }

    public ReLinkerInstance(b.InterfaceC0806b interfaceC0806b, b.a aVar) {
        this.f73932a = new HashSet();
        if (interfaceC0806b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f73933b = interfaceC0806b;
        this.f73934c = aVar;
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new a(this.f73933b.b(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f73935d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strB = this.f73933b.b(str);
        if (d.a(str2)) {
            return new File(c(context), strB);
        }
        return new File(c(context), strB + InstructionFileId.DOT + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, b.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (d.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        i("Beginning load of %s...", str);
        if (cVar == null) {
            g(context, str, str2);
        } else {
            new Thread(new Runnable(context, str, str2, cVar) { // from class: pl.droidsonroids.relinker.ReLinkerInstance.1
                final /* synthetic */ Context val$context;
                final /* synthetic */ String val$library;
                final /* synthetic */ b.c val$listener;
                final /* synthetic */ String val$version;

                /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
                
                    throw null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
                
                    throw null;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() throws Throwable {
                    try {
                        ReLinkerInstance.this.g(this.val$context, this.val$library, this.val$version);
                        throw null;
                    } catch (UnsatisfiedLinkError unused) {
                        throw null;
                    } catch (MissingLibraryException unused2) {
                        throw null;
                    }
                }
            }).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        if (this.f73932a.contains(str) && !this.f73935d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.f73933b.a(str);
            this.f73932a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e11) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e11));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f73935d) {
                if (this.f73935d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f73934c.a(context, this.f73933b.d(), this.f73933b.b(str), fileD, this);
            }
            try {
                if (this.f73936e) {
                    i iVar = null;
                    try {
                        i iVar2 = new i(fileD);
                        try {
                            List<String> listC = iVar2.c();
                            iVar2.close();
                            Iterator<String> it = listC.iterator();
                            while (it.hasNext()) {
                                e(context, this.f73933b.c(it.next()));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            iVar = iVar2;
                            iVar.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (IOException unused) {
            }
            this.f73933b.e(fileD.getAbsolutePath());
            this.f73932a.add(str);
            i("%s (%s) was re-linked!", str, str2);
        }
    }

    public void h(String str) {
    }

    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }
}
