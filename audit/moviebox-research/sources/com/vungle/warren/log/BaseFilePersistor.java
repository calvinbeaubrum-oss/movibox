package com.vungle.warren.log;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.utility.i;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class BaseFilePersistor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f62050e = "BaseFilePersistor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public File f62051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f62052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62054d;

    /* JADX INFO: compiled from: source.java */
    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f62055a;

        public a(String str) {
            this.f62055a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f62055a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(File file, int i11);

        void onFailure();
    }

    public BaseFilePersistor(@Nullable File file, String str, String str2, String str3) {
        this.f62052b = str2;
        this.f62053c = str3;
        this.f62054d = str;
        if (file != null) {
            this.f62051a = g(file, str);
        }
    }

    public static String c(long j11) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j11));
    }

    public boolean a(File file, String str, @Nullable b bVar) throws Throwable {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    int iE = e(file);
                    if (iE > 0) {
                        fileWriter2.append((CharSequence) "\n");
                    }
                    fileWriter2.append((CharSequence) str);
                    fileWriter2.flush();
                    i.a(fileWriter2);
                    if (bVar != null) {
                        bVar.a(file, iE + 1);
                    }
                    return true;
                } catch (IOException unused) {
                    fileWriter = fileWriter2;
                    if (bVar != null) {
                        bVar.onFailure();
                    }
                    i.a(fileWriter);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    i.a(fileWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    @Nullable
    public File b(@NonNull File file, @NonNull String str, boolean z11) {
        boolean zCreateNewFile;
        File file2 = new File(file, str);
        if (file2.exists()) {
            return file2;
        }
        if (z11) {
            zCreateNewFile = file2.mkdir();
        } else {
            try {
                zCreateNewFile = file2.createNewFile();
            } catch (IOException e11) {
                Log.e(f62050e, "Can't create new file " + file2.getName(), e11);
            }
        }
        if (zCreateNewFile) {
            return file2;
        }
        return null;
    }

    @Nullable
    public File[] d(String str) {
        if (h()) {
            return null;
        }
        return this.f62051a.listFiles(new a(str));
    }

    public int e(File file) throws Throwable {
        if (file == null) {
            return 0;
        }
        LineNumberReader lineNumberReader = null;
        try {
            LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(file.getAbsolutePath()));
            do {
                try {
                } catch (Exception unused) {
                    lineNumberReader = lineNumberReader2;
                    i.a(lineNumberReader);
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    lineNumberReader = lineNumberReader2;
                    i.a(lineNumberReader);
                    throw th;
                }
            } while (lineNumberReader2.readLine() != null);
            int lineNumber = lineNumberReader2.getLineNumber();
            i.a(lineNumberReader2);
            return lineNumber;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Nullable
    public File f(String str) {
        return b(this.f62051a, str, false);
    }

    @Nullable
    public File g(@NonNull File file, String str) {
        File fileB = b(file, str, true);
        if (fileB == null || !fileB.exists()) {
            return null;
        }
        return fileB;
    }

    public boolean h() {
        File file = this.f62051a;
        return file == null || !file.exists();
    }

    public boolean i(@NonNull File file, @NonNull String str) {
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(this.f62051a, str);
        if (file2.exists()) {
            return false;
        }
        return file.renameTo(file2);
    }

    public void j(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator<File>() { // from class: com.vungle.warren.log.BaseFilePersistor.2
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
    }
}
