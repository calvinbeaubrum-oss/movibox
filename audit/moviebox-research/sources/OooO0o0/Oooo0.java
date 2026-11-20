package OooO0o0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Oooo0 extends OooO0o0.OooO0OO.OooO00o<Oooo0> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f83t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f84u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f85v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f86w;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<TextView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) Oooo0.this.findViewById(R$id.btn_common_dialog_left);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) Oooo0.this.findViewById(R$id.btn_common_dialog_right);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) Oooo0.this.findViewById(R$id.txt_common_dialog_describe);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) Oooo0.this.findViewById(R$id.txt_common_dialog_title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oooo0(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f83t = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f84u = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f85v = LazyKt__LazyJVMKt.b(new OooO00o());
        this.f86w = LazyKt__LazyJVMKt.b(new OooO0O0());
        j(R$layout.layout_fw_update_tips);
        n(false);
        b(-1);
        TextView textViewV = v();
        if (textViewV != null) {
            textViewV.setText(t(R$string.mini_dialog_download_error_title));
        }
        TextView textViewY = y();
        if (textViewY != null) {
            textViewY.setText(t(R$string.mini_dialog_download_error_content));
        }
        TextView textViewW = w();
        if (textViewW != null) {
            textViewW.setText(t(R$string.mini_text_cancel));
        }
        TextView textViewX = x();
        if (textViewX != null) {
            textViewX.setText(t(R$string.mini_dialog_download_error_retry_btn));
        }
        u(w(), x());
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        if (Intrinsics.b(view, w())) {
            Context context = this.f27a;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                oooO0OO.b();
                return;
            }
            return;
        }
        if (Intrinsics.b(view, x())) {
            Context context2 = this.f27a;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO2 = context2 instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context2 : null;
            if (oooO0OO2 != null) {
                com.cloud.tmc.miniapp.ui.OooO0OO.h0(oooO0OO2, false, null, 3, null);
            }
            l();
        }
    }

    public final TextView v() {
        return (TextView) this.f83t.getValue();
    }

    public final TextView w() {
        return (TextView) this.f85v.getValue();
    }

    public final TextView x() {
        return (TextView) this.f86w.getValue();
    }

    public final TextView y() {
        return (TextView) this.f84u.getValue();
    }
}
