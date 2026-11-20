package rk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f75588d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f75589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f75590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nk.f f75591c;

    public b(Context context, e eVar, nk.f fVar) {
        this.f75589a = context;
        this.f75590b = eVar;
        this.f75591c = fVar;
    }

    @Nullable
    public static File b(File file, String str) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    public static void h(nk.f fVar, String str, String str2, String str3) throws Throwable {
        j(new File(fVar.i(str), str3), str2);
    }

    public static void j(File file, String str) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), f75588d));
            try {
                bufferedWriter2.write(str);
                CommonUtils.e(bufferedWriter2, "Failed to close " + file);
            } catch (IOException unused) {
                bufferedWriter = bufferedWriter2;
                CommonUtils.e(bufferedWriter, "Failed to close " + file);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CommonUtils.e(bufferedWriter, "Failed to close " + file);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @NonNull
    public f a(String str) {
        File fileI = this.f75591c.i(str);
        File file = new File(fileI, "pending");
        gk.f.f().i("Minidump directory: " + file.getAbsolutePath());
        File fileB = b(file, ".dmp");
        gk.f fVarF = gk.f.f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Minidump file ");
        sb2.append((fileB == null || !fileB.exists()) ? "does not exist" : "exists");
        fVarF.i(sb2.toString());
        f.b bVar = new f.b();
        if (fileI != null && fileI.exists() && file.exists()) {
            bVar.l(b(file, ".dmp")).k(b(fileI, ".device_info")).n(new File(fileI, "session.json")).h(new File(fileI, "app.json")).j(new File(fileI, "device.json")).m(new File(fileI, "os.json"));
        }
        return bVar.i();
    }

    public boolean c(String str) {
        File file = a(str).f75597a;
        return file != null && file.exists();
    }

    public boolean d(String str, String str2, long j11, kk.f fVar) throws Throwable {
        File fileI = this.f75591c.i(str);
        if (fileI == null) {
            return false;
        }
        try {
            if (!this.f75590b.a(fileI.getCanonicalPath(), this.f75589a.getAssets())) {
                return false;
            }
            e(str, str2, j11);
            f(str, fVar.a());
            i(str, fVar.d());
            g(str, fVar.c());
            return true;
        } catch (IOException e11) {
            gk.f.f().e("Error initializing Crashlytics NDK", e11);
            return false;
        }
    }

    public void e(String str, String str2, long j11) throws Throwable {
        h(this.f75591c, str, h.b(str, str2, j11), "session.json");
    }

    public void f(String str, kk.f.a aVar) throws Throwable {
        h(this.f75591c, str, h.c(aVar.a(), aVar.f(), aVar.g(), aVar.e(), aVar.c(), aVar.d().d(), aVar.d().e()), "app.json");
    }

    public void g(String str, kk.f.b bVar) throws Throwable {
        h(this.f75591c, str, h.d(bVar.a(), bVar.g(), bVar.b(), bVar.j(), bVar.d(), bVar.e(), bVar.i(), bVar.f(), bVar.h()), "device.json");
    }

    public void i(String str, kk.f.c cVar) throws Throwable {
        h(this.f75591c, str, h.e(cVar.d(), cVar.c(), cVar.b()), "os.json");
    }
}
