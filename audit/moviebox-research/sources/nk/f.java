package nk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f72027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f72028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f72029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f72030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f72031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f72032f;

    public f(Context context) {
        String str;
        File filesDir = context.getFilesDir();
        this.f72027a = filesDir;
        if (v()) {
            str = ".com.google.firebase.crashlytics.files.v2" + File.pathSeparator + u(Application.getProcessName());
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileQ = q(new File(filesDir, str));
        this.f72028b = fileQ;
        this.f72029c = q(new File(fileQ, "open-sessions"));
        this.f72030d = q(new File(fileQ, "reports"));
        this.f72031e = q(new File(fileQ, "priority-reports"));
        this.f72032f = q(new File(fileQ, "native-reports"));
    }

    public static synchronized File q(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                gk.f.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                gk.f.f().d("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static File r(File file) {
        file.mkdirs();
        return file;
    }

    public static boolean s(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                s(file2);
            }
        }
        return file.delete();
    }

    public static <T> List<T> t(@Nullable T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public static String u(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    @SuppressLint({"AnnotateVersionCheck"})
    public static boolean v() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public final void a(File file) {
        if (file.exists() && s(file)) {
            gk.f.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public void b() {
        a(new File(this.f72027a, ".com.google.firebase.crashlytics"));
        a(new File(this.f72027a, ".com.google.firebase.crashlytics-ndk"));
        if (v()) {
            a(new File(this.f72027a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    public boolean c(String str) {
        return s(new File(this.f72029c, str));
    }

    public List<String> d() {
        return t(this.f72029c.list());
    }

    public File e(String str) {
        return new File(this.f72028b, str);
    }

    public List<File> f(FilenameFilter filenameFilter) {
        return t(this.f72028b.listFiles(filenameFilter));
    }

    public File g(String str) {
        return new File(this.f72032f, str);
    }

    public List<File> h() {
        return t(this.f72032f.listFiles());
    }

    public File i(String str) {
        return r(new File(n(str), "native"));
    }

    public File j(String str) {
        return new File(this.f72031e, str);
    }

    public List<File> k() {
        return t(this.f72031e.listFiles());
    }

    public File l(String str) {
        return new File(this.f72030d, str);
    }

    public List<File> m() {
        return t(this.f72030d.listFiles());
    }

    public final File n(String str) {
        return r(new File(this.f72029c, str));
    }

    public File o(String str, String str2) {
        return new File(n(str), str2);
    }

    public List<File> p(String str, FilenameFilter filenameFilter) {
        return t(n(str).listFiles(filenameFilter));
    }
}
