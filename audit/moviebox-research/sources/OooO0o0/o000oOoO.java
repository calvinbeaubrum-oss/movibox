package OooO0o0;

import OooO0o0.o000oOoO;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o000oOoO extends OooO0o0.OooO0OO.OooO00o<o000oOoO> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f126t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f127u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f128v;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<View> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return o000oOoO.this.findViewById(R$id.view_line);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<ProgressBar> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ProgressBar invoke() {
            return (ProgressBar) o000oOoO.this.findViewById(R$id.pb_download_progress);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000oOoO.this.findViewById(R$id.tv_cancel);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000oOoO.this.findViewById(R$id.tv_progress);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000oOoO.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o000oOoO(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        LazyKt__LazyJVMKt.b(new OooO0o());
        this.f126t = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f127u = LazyKt__LazyJVMKt.b(new OooO00o());
        LazyKt__LazyJVMKt.b(new OooO());
        this.f128v = LazyKt__LazyJVMKt.b(new OooO0O0());
        j(R$layout.layout_fw_update_progress);
        n(false);
        k(false);
        b(-1);
        u(x());
    }

    public static final void v(o000oOoO this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        TextView textView = (TextView) this$0.f126t.getValue();
        if (textView != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append('%');
            textView.setText(sb2.toString());
        }
        ProgressBar progressBar = (ProgressBar) this$0.f127u.getValue();
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(i11);
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        if (Intrinsics.b(view, (TextView) this.f128v.getValue())) {
            Context context = this.f27a;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                oooO0OO.b();
            }
        }
    }

    public final void w(final int i11) {
        e.f(new Runnable() { // from class: j.x
            @Override // java.lang.Runnable
            public final void run() {
                o000oOoO.v(this.f67793a, i11);
            }
        });
    }

    public final TextView x() {
        return (TextView) this.f128v.getValue();
    }
}
