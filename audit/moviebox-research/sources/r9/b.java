package r9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.n2;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n2 f75166a;

    public b(String str) {
        this.f75166a = new n2(str);
    }

    public void a() {
        this.f75166a.W();
    }

    public AdChoicesView b(Context context, TaNativeInfo taNativeInfo) {
        return this.f75166a.H0(context, taNativeInfo);
    }

    public AdCloseView c(Context context) {
        return this.f75166a.I0(context);
    }

    public t9.a d() {
        return this.f75166a.q0();
    }

    public void e() {
        this.f75166a.w0();
    }

    public void f(@NonNull ViewGroup viewGroup, List<View> list, TaNativeInfo taNativeInfo) {
        this.f75166a.Q0(viewGroup, list, taNativeInfo);
    }

    public void g(int i11) {
        this.f75166a.a1(i11);
    }

    public void h(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        this.f75166a.x(str, str2, map);
    }

    public void i(boolean z11) {
        this.f75166a.P(z11);
    }

    public void j(boolean z11) {
        this.f75166a.V(z11);
    }

    public void k(@NonNull s9.a aVar) {
        this.f75166a.C(aVar);
    }

    public void l(boolean z11) {
        this.f75166a.c1(z11);
    }

    public void m(String str) {
        this.f75166a.w(str);
    }

    public void n(t9.a aVar) {
        this.f75166a.D(aVar);
    }
}
