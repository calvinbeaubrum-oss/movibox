package dd;

import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.security.AccessControlException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    void a(dd.a aVar);

    boolean b(c cVar, List<? extends e> list, @Nullable a aVar) throws AccessControlException;
}
