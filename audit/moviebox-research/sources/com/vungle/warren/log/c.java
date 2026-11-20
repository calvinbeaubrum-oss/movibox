package com.vungle.warren.log;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends BaseFilePersistor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f62087i = "c";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LogManager.b f62088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public File f62089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f62090h;

    /* JADX INFO: compiled from: source.java */
    public class a implements BaseFilePersistor.b {
        public a() {
        }

        @Override // com.vungle.warren.log.BaseFilePersistor.b
        public void a(File file, int i11) {
            if (i11 >= c.this.f62090h) {
                c cVar = c.this;
                if (cVar.i(cVar.f62089g, file.getName() + "_pending")) {
                    c cVar2 = c.this;
                    cVar2.f62089g = cVar2.q();
                    if (c.this.f62088f != null) {
                        c.this.f62088f.a();
                    }
                }
            }
        }

        @Override // com.vungle.warren.log.BaseFilePersistor.b
        public void onFailure() {
            Log.e(c.f62087i, "Failed to write sdk logs.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements FilenameFilter {
        public b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.endsWith(c.this.f62053c);
        }
    }

    /* JADX INFO: renamed from: com.vungle.warren.log.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0630c implements BaseFilePersistor.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f62093a;

        public C0630c(File file) {
            this.f62093a = file;
        }

        @Override // com.vungle.warren.log.BaseFilePersistor.b
        public void a(File file, int i11) {
            c.this.i(this.f62093a, this.f62093a.getName() + "_crash");
        }

        @Override // com.vungle.warren.log.BaseFilePersistor.b
        public void onFailure() {
            Log.e(c.f62087i, "Failed to write crash log.");
        }
    }

    public c(@Nullable File file) {
        super(file, "sdk_logs", "log_", "_pending");
        this.f62090h = 100;
        if (this.f62051a != null) {
            this.f62089g = q();
        }
    }

    @Nullable
    public File[] p(int i11) {
        File[] fileArrD = d("_crash");
        if (fileArrD == null || fileArrD.length == 0) {
            return null;
        }
        j(fileArrD);
        return (File[]) Arrays.copyOfRange(fileArrD, 0, Math.min(fileArrD.length, i11));
    }

    @Nullable
    public File q() throws Throwable {
        File file = this.f62051a;
        File fileQ = null;
        if (file == null || !file.exists()) {
            Log.w(f62087i, "No log cache dir found.");
            return null;
        }
        File[] fileArrListFiles = this.f62051a.listFiles(new b());
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return f(this.f62052b + System.currentTimeMillis() + UUID.randomUUID().toString());
        }
        j(fileArrListFiles);
        File file2 = fileArrListFiles[0];
        int iE = e(file2);
        if (iE <= 0 || iE < this.f62090h) {
            return file2;
        }
        try {
            if (i(file2, file2.getName() + this.f62053c)) {
                fileQ = q();
            }
        } catch (Exception unused) {
        }
        return fileQ == null ? file2 : fileQ;
    }

    @Nullable
    public File[] r() {
        return d("_pending");
    }

    public void s(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) throws Throwable {
        if (this.f62051a == null) {
            Log.w(f62087i, "No log cache dir found.");
            return;
        }
        com.vungle.warren.log.b bVar = new com.vungle.warren.log.b(str, str2, str3, str4, str5, str6, TimeZone.getDefault().getID(), BaseFilePersistor.c(System.currentTimeMillis()), str7, str8, str9);
        File fileB = b(this.f62051a, "crash_" + System.currentTimeMillis(), false);
        if (fileB != null) {
            a(fileB, bVar.b(), new C0630c(fileB));
        }
    }

    public boolean t(File file, String str, @Nullable BaseFilePersistor.b bVar) throws Throwable {
        if (file == null || !file.exists()) {
            String str2 = f62087i;
            File fileQ = q();
            this.f62089g = fileQ;
            if (fileQ == null || !fileQ.exists()) {
                Log.w(str2, "Can't create log file, maybe no space left.");
                return false;
            }
            file = fileQ;
        }
        return a(file, str, bVar);
    }

    public void u(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        t(this.f62089g, new com.vungle.warren.log.b(str, str2, str3, str4, str5, str6, TimeZone.getDefault().getID(), BaseFilePersistor.c(System.currentTimeMillis()), str7, str8, str9).b(), new a());
    }

    public void v(int i11) {
        this.f62090h = i11;
    }

    public void w(@NonNull LogManager.b bVar) {
        this.f62088f = bVar;
    }
}
