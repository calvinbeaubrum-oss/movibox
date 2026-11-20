package OooO0o0;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import hd.j;
import id.b;
import id.d;
import id.h;
import j.h0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0OO00O extends OooO0o0.OooO0OO.OooO00o<o0OO00O> {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public boolean F;
    public final String G;
    public final String H;
    public final String I;
    public final String J;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final String Q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public h0 f143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f144v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f145w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f146x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f147y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f148z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_btn_three);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<Group> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Group invoke() {
            return (Group) o0OO00O.this.findViewById(R$id.group_check_show_again);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<ImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) o0OO00O.this.findViewById(R$id.iv_check_show_again);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<AppCompatImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) o0OO00O.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_btn_one);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_btn_two);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_content);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<TextView> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_show_again);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<TextView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0OO00O.this.findViewById(R$id.tv_title_tips);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<View> {
        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return o0OO00O.this.findViewById(R$id.view_click_show_again_check);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0OO00O(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f142t = "MiniScopePermissionDialog";
        this.f144v = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f145w = LazyKt__LazyJVMKt.b(new OooOOO());
        this.f146x = LazyKt__LazyJVMKt.b(new OooOOOO());
        this.f147y = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.f148z = LazyKt__LazyJVMKt.b(new OooO0o());
        this.A = LazyKt__LazyJVMKt.b(new OooOO0());
        this.B = LazyKt__LazyJVMKt.b(new OooO());
        this.C = LazyKt__LazyJVMKt.b(new OooO00o());
        this.D = LazyKt__LazyJVMKt.b(new OooO0O0());
        LazyKt__LazyJVMKt.b(new OooOOO0());
        this.E = LazyKt__LazyJVMKt.b(new OooOo00());
        j(R$layout.mini_dialog_layout_permission_scope);
        b(b.f67188f8.a());
        g(true);
        u(x(), z(), y(), v());
        k(false);
        this.G = "isShow";
        this.H = "bgcolor";
        this.I = MimeTypes.BASE_TYPE_TEXT;
        this.J = "customText";
        this.K = "1";
        this.L = "2";
        this.M = "3";
        this.N = "4";
        this.O = "5";
        this.P = "0";
        this.Q = "1";
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        d.a.a(this, view);
        int id2 = view.getId();
        if (id2 == R$id.tv_btn_one) {
            TmcLogger.c(this.f142t, "click1");
            h0 h0Var = this.f143u;
            if (h0Var != null) {
                h0Var.c(1);
            }
            l();
            return;
        }
        if (id2 == R$id.tv_btn_two) {
            TmcLogger.c(this.f142t, "click2");
            h0 h0Var2 = this.f143u;
            if (h0Var2 != null) {
                h0Var2.c(2);
            }
            l();
            return;
        }
        if (id2 == R$id.tv_btn_three) {
            TmcLogger.c(this.f142t, "click3");
            h0 h0Var3 = this.f143u;
            if (h0Var3 != null) {
                h0Var3.c(3);
            }
            l();
            return;
        }
        if (id2 == R$id.view_click_show_again_check) {
            this.F = !this.F;
            ImageView imageView = (ImageView) this.D.getValue();
            if (imageView != null) {
                imageView.setSelected(this.F);
            }
            String str = this.f142t;
            StringBuilder sbA = j.a("isNotShowAgain = ");
            sbA.append(this.F);
            TmcLogger.c(str, sbA.toString());
            h0 h0Var4 = this.f143u;
            if (h0Var4 != null) {
                h0Var4.b(this.F);
            }
        }
    }

    public final View v() {
        return (View) this.E.getValue();
    }

    public final void w(TextView textView, JsonObject jsonObject) {
        JsonElement jsonElement = jsonObject.get(this.G);
        if (jsonElement == null || !jsonElement.getAsBoolean()) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            String str = this.f142t;
            StringBuilder sbA = j.a("initBtnConfig:-> btn is not show->");
            sbA.append(textView != null ? Integer.valueOf(textView.getId()) : null);
            TmcLogger.f(str, sbA.toString());
            return;
        }
        JsonElement jsonElement2 = jsonObject.get(this.H);
        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString == null) {
            asString = this.P;
        }
        if (asString.length() > 0) {
            if (Intrinsics.b(asString, this.P)) {
                if (textView != null) {
                    textView.setSelected(false);
                }
            } else if (Intrinsics.b(asString, this.Q) && textView != null) {
                textView.setSelected(true);
            }
        }
        JsonElement jsonElement3 = jsonObject.get(this.J);
        String asString2 = jsonElement3 != null ? jsonElement3.getAsString() : null;
        String strD = "";
        if (asString2 == null) {
            asString2 = "";
        }
        if (asString2.length() > 0) {
            if (textView == null) {
                return;
            }
            textView.setText(asString2);
            return;
        }
        JsonElement jsonElement4 = jsonObject.get(this.I);
        Object asString3 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        if (asString3 == null) {
            asString3 = "";
        }
        if (Intrinsics.b(asString3, this.K)) {
            strD = h.a.d(this, R$string.mini_permission_allow);
        } else if (Intrinsics.b(asString3, this.L)) {
            strD = h.a.d(this, R$string.mini_permission_dont_allow);
        } else if (Intrinsics.b(asString3, this.M)) {
            strD = h.a.d(this, R$string.mini_permission_only_this_time);
        } else if (Intrinsics.b(asString3, this.N)) {
            strD = h.a.d(this, R$string.mini_permission_only_use_time);
        } else if (Intrinsics.b(asString3, this.O)) {
            strD = h.a.d(this, R$string.mini_permission_dont_allow_not_show);
        }
        if (textView == null) {
            return;
        }
        textView.setText(strD);
    }

    public final TextView x() {
        return (TextView) this.f148z.getValue();
    }

    public final TextView y() {
        return (TextView) this.B.getValue();
    }

    public final TextView z() {
        return (TextView) this.A.getValue();
    }
}
