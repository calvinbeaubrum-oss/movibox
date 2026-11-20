package zc;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.Node;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface i {
    boolean a();

    String b();

    boolean c();

    void d(f fVar);

    void destroy();

    int e();

    void f(h hVar);

    Boolean g();

    Activity getActivity();

    String getAppId();

    String getFrameworkVersion();

    ac.a getRenderBridge();

    View getView();

    void h(EngineRouter engineRouter);

    Node i();

    void init(String str);

    void j(String str);

    void k(l lVar);

    void l(c cVar);

    void m(boolean z11);

    void n(l lVar, @NonNull String str, String str2, String str3, String str4);

    void o(Activity activity);

    void onPause();

    void onResume();

    void p(Node node);

    void q(String str);

    void r(IEngine iEngine);

    void reload();

    void s(b bVar);

    void setBgColor(String str);

    void setFrameworkVersion(String str);

    void setMiniAppType(int i11);

    void setSupportFullScreen(boolean z11);

    IEngine t();

    void u();

    String v();

    void w(CreateParams createParams);

    void x(String str);

    void y(d dVar);
}
