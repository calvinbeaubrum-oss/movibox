package gd;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.node.Node;
import com.google.gson.JsonObject;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();
    }

    Boolean a();

    Boolean c();

    void destroy();

    int e();

    void f();

    void g(String str, String str2);

    String getFrameworkVersion();

    @Nullable
    Node getNode();

    String getWorkerId();

    void h();

    boolean i();

    boolean isDestroyed();

    Boolean isRenderProcessGone();

    void j(HashMap<String, Object> map, c cVar);

    void k(JsonObject jsonObject, c cVar);

    void l(a aVar);

    Handler m();

    Boolean n();

    void o();

    void p(String str);

    void q();

    void r(String str);

    void s(@Nullable String str);

    void setAppId(String str);

    void setFrameworkVersion(String str);

    void setNode(Node node);

    int workerType();
}
