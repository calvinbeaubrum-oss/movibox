package t3;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.u;
import androidx.lifecycle.y0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: t3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0847a<D> {
        @NonNull
        androidx.loader.content.a<D> onCreateLoader(int i11, @Nullable Bundle bundle);

        void onLoadFinished(@NonNull androidx.loader.content.a<D> aVar, D d11);

        void onLoaderReset(@NonNull androidx.loader.content.a<D> aVar);
    }

    @NonNull
    public static <T extends u & y0> a b(@NonNull T t11) {
        return new b(t11, t11.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract <D> androidx.loader.content.a<D> c(int i11, @Nullable Bundle bundle, @NonNull InterfaceC0847a<D> interfaceC0847a);

    public abstract void d();
}
