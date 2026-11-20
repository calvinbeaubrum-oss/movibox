package OooO0o0;

import OooO0o0.o0OoOo0;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import j.y;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0OoOo0 extends OooO0o0.OooO0OO.OooO00o<o0OoOo0> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f149t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f150u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f151v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y f154y;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OoOo0.this.findViewById(R$id.txt_common_dialog_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<TextView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OoOo0.this.findViewById(R$id.btn_common_dialog_left);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OoOo0.this.findViewById(R$id.btn_common_dialog_right);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OoOo0.this.findViewById(R$id.tv_download_size);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OoOo0.this.findViewById(R$id.txt_common_dialog_describe);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0OoOo0(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f149t = LazyKt__LazyJVMKt.b(new OooO());
        this.f150u = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f151v = LazyKt__LazyJVMKt.b(new OooO00o());
        this.f152w = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.f153x = LazyKt__LazyJVMKt.b(new OooO0OO());
        j(R$layout.layout_fw_update_tips);
        n(false);
        k(false);
        b(-1);
        TextView textViewZ = z();
        if (textViewZ != null) {
            textViewZ.setOnClickListener(new View.OnClickListener() { // from class: j.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0OoOo0.x(this.f67774a, view);
                }
            });
        }
        TextView textViewA = A();
        if (textViewA != null) {
            textViewA.setOnClickListener(new View.OnClickListener() { // from class: j.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0OoOo0.y(this.f67775a, view);
                }
            });
        }
    }

    public static final void x(o0OoOo0 this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        y yVar = this$0.f154y;
        if (yVar != null) {
            Intrinsics.f(it, "it");
            yVar.a(it);
        }
    }

    public static final void y(o0OoOo0 this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        y yVar = this$0.f154y;
        if (yVar != null) {
            Intrinsics.f(it, "it");
            yVar.b(it);
        }
    }

    public final TextView A() {
        return (TextView) this.f152w.getValue();
    }

    public final TextView B() {
        return (TextView) this.f150u.getValue();
    }

    public final TextView v() {
        return (TextView) this.f149t.getValue();
    }

    public final String w(long j11) {
        float f11 = j11 / 1000.0f;
        if (f11 < 1000.0f) {
            return ((int) f11) + " KB";
        }
        StringBuilder sb2 = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String str = decimalFormat.format(f11 / 1000.0f);
        Intrinsics.f(str, "format.format(number)");
        sb2.append(str);
        sb2.append(" MB");
        return sb2.toString();
    }

    public final TextView z() {
        return (TextView) this.f151v.getValue();
    }
}
