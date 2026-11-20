package sj;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e implements nj.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hk.b f76369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hk.b f76370b;

    public static void b(@Nullable hk.b bVar, @NonNull String str, @NonNull Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.onEvent(str, bundle);
    }

    @Override // nj.a.b
    public void a(int i11, @Nullable Bundle bundle) {
        String string;
        gk.f.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i11), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public final void c(@NonNull String str, @NonNull Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.f76369a : this.f76370b, str, bundle);
    }

    public void d(@Nullable hk.b bVar) {
        this.f76370b = bVar;
    }

    public void e(@Nullable hk.b bVar) {
        this.f76369a = bVar;
    }
}
