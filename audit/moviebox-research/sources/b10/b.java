package b10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b10.a;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface b<T extends b10.a> extends a10.d.a {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(@NonNull String str, @Nullable String str2, @Nullable String str3);

        void b(@NonNull VungleException vungleException, @Nullable String str);
    }

    void j(@NonNull T t11, @Nullable c10.a aVar);

    boolean k();

    void l();

    void m(int i11);

    void n(@Nullable c10.a aVar);

    void o(@Nullable a aVar);

    void p(@Nullable c10.a aVar);

    void s(int i11);

    void start();
}
