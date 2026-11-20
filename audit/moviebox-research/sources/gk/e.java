package gk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public b f65564b = null;

    /* JADX INFO: compiled from: source.java */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f65565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f65566b;

        public b() {
            int iQ = CommonUtils.q(e.this.f65563a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iQ == 0) {
                if (!e.this.c("flutter_assets/NOTICES.Z")) {
                    this.f65565a = null;
                    this.f65566b = null;
                    return;
                } else {
                    this.f65565a = "Flutter";
                    this.f65566b = null;
                    f.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f65565a = "Unity";
            String string = e.this.f65563a.getResources().getString(iQ);
            this.f65566b = string;
            f.f().i("Unity Editor version is: " + string);
        }
    }

    public e(Context context) {
        this.f65563a = context;
    }

    public static boolean g(Context context) {
        return CommonUtils.q(context, "com.google.firebase.crashlytics.unity_version", "string") != 0;
    }

    public final boolean c(String str) {
        if (this.f65563a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f65563a.getAssets().open(str);
            if (inputStreamOpen == null) {
                return true;
            }
            inputStreamOpen.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Nullable
    public String d() {
        return f().f65565a;
    }

    @Nullable
    public String e() {
        return f().f65566b;
    }

    public final b f() {
        if (this.f65564b == null) {
            this.f65564b = new b();
        }
        return this.f65564b;
    }
}
