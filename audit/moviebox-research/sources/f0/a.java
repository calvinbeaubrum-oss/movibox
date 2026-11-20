package f0;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements o0.c<View> {
    @Override // o0.c
    public o0.a OooO00o() {
        return o0.a.c.f72241b;
    }

    @Override // o0.c
    public int a() {
        return 0;
    }

    @Override // o0.c
    public float b() {
        return 0.0f;
    }

    @Override // o0.c
    public float c() {
        return 0.0f;
    }

    @Override // o0.c
    public int d() {
        return 0;
    }

    @Override // o0.c
    public int e() {
        return 80;
    }

    @Override // o0.c
    public View f(Context context) {
        Intrinsics.g(context, "context");
        View inflate = View.inflate(context, R$layout.mini_toast_add_home_success_layout, null);
        ((TextView) inflate.findViewById(R$id.tv_text_add_home_msg)).setId(R.id.message);
        Intrinsics.f(inflate, "inflate");
        return inflate;
    }
}
