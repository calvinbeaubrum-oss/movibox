package al;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@KeepForSdk
public interface a {

    /* JADX INFO: renamed from: al.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @KeepForSdk
    public interface InterfaceC0026a {
        @KeepForSdk
        void a(String str);
    }

    @Nullable
    @KeepForSdk
    String a();

    @KeepForSdk
    void b(InterfaceC0026a interfaceC0026a);

    @NonNull
    @KeepForSdk
    Task<String> c();
}
