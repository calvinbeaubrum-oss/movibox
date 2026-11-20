package athena;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile i f13685e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f13686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13689d;

    public static i d() {
        if (f13685e == null) {
            synchronized (i.class) {
                try {
                    if (f13685e == null) {
                        f13685e = new i();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f13685e;
    }

    public void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ws.a.a().getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        this.f13688c = sb2.toString();
        if (!c()) {
            this.f13688c = ws.a.a().getFilesDir().getPath();
        }
        this.f13689d = this.f13688c + str2 + "remote_config.cfg";
    }

    public void b(byte[] bArr) {
        this.f13686a = bArr;
    }

    public final boolean c() {
        if (!this.f13687b) {
            File file = new File(this.f13688c);
            try {
                if (file.exists()) {
                    this.f13687b = true;
                } else {
                    this.f13687b = file.mkdirs();
                }
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        return this.f13687b;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(this.f13688c) && c()) {
            File file = new File(this.f13689d);
            try {
                p0.d(file, str, this.f13686a);
            } catch (Exception e11) {
                com.transsion.ga.l.a().c(new com.transsion.ga.e("bufferSave", e11));
                try {
                    if (file.isDirectory()) {
                        v.h(this.f13689d);
                    }
                } catch (Exception unused) {
                    e11.printStackTrace();
                }
            }
        }
    }

    @Nullable
    public String f() throws Throwable {
        if (!TextUtils.isEmpty(this.f13688c) && c()) {
            File file = new File(this.f13689d);
            try {
                return p0.a(file, this.f13686a);
            } catch (Exception e11) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("e", e11.getClass().getSimpleName());
                    bundle.putString("pwd", br.d.e(this.f13686a));
                    bundle.putLong("len", file.length());
                    com.transsion.ga.l.a().c(new com.transsion.ga.e("bufferRead", bundle));
                    v.l(file);
                } catch (Exception unused) {
                    e11.printStackTrace();
                }
            }
        }
        return null;
    }
}
