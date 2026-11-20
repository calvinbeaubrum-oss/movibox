package OooO0o0;

import OooO0o0.OooOo;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$dimen;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import id.h;
import j.l;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class OooOo extends OooO0o0.OooO0OO.OooO00o<OooOo> {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public l E;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f76t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f77u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f78v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f79w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f80x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f81y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f82z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<FrameLayout> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) OooOo.this.findViewById(R$id.fl_text_panel);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<View> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooOo.this.findViewById(R$id.view_halving_line);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOo.this.findViewById(R$id.btn_common_dialog_left);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOo.this.findViewById(R$id.btn_common_dialog_right);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<FrameLayout> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) OooOo.this.findViewById(R$id.fl_edit_panel);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOo.this.findViewById(R$id.txt_common_dialog_describe);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOo.this.findViewById(R$id.txt_common_dialog_edit);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<View> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooOo.this.findViewById(R$id.view_line_bottom);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOo.this.findViewById(R$id.txt_common_dialog_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<View> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooOo.this.findViewById(R$id.view_line_top);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOo(Context context, boolean z11) {
        super(context);
        Intrinsics.g(context, "context");
        this.f76t = z11;
        this.f77u = LazyKt__LazyJVMKt.b(new OooOOOO());
        this.f78v = LazyKt__LazyJVMKt.b(new OooOOO());
        this.f79w = LazyKt__LazyJVMKt.b(new OooO());
        this.f80x = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f81y = LazyKt__LazyJVMKt.b(new OooOOO0());
        this.f82z = LazyKt__LazyJVMKt.b(new OooOO0());
        this.A = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.B = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.C = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.D = LazyKt__LazyJVMKt.b(new OooO00o());
        j(z11 ? R$layout.layout_common_tip_confirm_dialog : R$layout.layout_common_tip_confirm_normal_dialog);
        a(0.2f);
        TextView textViewV = v();
        if (textViewV != null) {
            textViewV.setOnClickListener(new View.OnClickListener() { // from class: j.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OooOo.A(this.f67778a, view);
                }
            });
        }
        TextView textViewO = O();
        if (textViewO != null) {
            textViewO.setOnClickListener(new View.OnClickListener() { // from class: j.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OooOo.D(this.f67779a, view);
                }
            });
        }
        TextView textViewP = P();
        if (textViewP != null) {
            textViewP.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: j.j
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                    OooOo.B(this.f67780a, view, i11, i12, i13, i14);
                }
            });
        }
    }

    public static final void A(OooOo this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        l lVar = this$0.E;
        if (lVar != null) {
            Intrinsics.f(it, "it");
            lVar.a(it);
        }
        this$0.l();
    }

    public static final void B(OooOo this$0, View view, int i11, int i12, int i13, int i14) {
        View viewT;
        View viewT2;
        View viewR;
        View viewR2;
        View viewR3;
        View viewT3;
        Intrinsics.g(this$0, "this$0");
        if (i12 <= 0) {
            View viewT4 = this$0.T();
            if ((viewT4 == null || viewT4.getVisibility() != 4) && (viewT3 = this$0.T()) != null) {
                i.d(viewT3);
            }
        } else {
            View viewT5 = this$0.T();
            if (i12 <= (viewT5 != null ? viewT5.getHeight() : 1)) {
                View viewT6 = this$0.T();
                if ((viewT6 == null || viewT6.getVisibility() != 0) && (viewT2 = this$0.T()) != null) {
                    i.e(viewT2);
                }
                float f11 = i12;
                View viewT7 = this$0.T();
                float height = f11 / (viewT7 != null ? viewT7.getHeight() : 1);
                View viewT8 = this$0.T();
                if (viewT8 != null) {
                    viewT8.setAlpha(1 * height);
                }
            } else {
                View viewT9 = this$0.T();
                if (!Intrinsics.a(viewT9 != null ? Float.valueOf(viewT9.getAlpha()) : null, 1.0f) && (viewT = this$0.T()) != null) {
                    viewT.setAlpha(1.0f);
                }
            }
        }
        TextView textViewP = this$0.P();
        int lineHeight = textViewP != null ? textViewP.getLineHeight() : 1;
        TextView textViewP2 = this$0.P();
        int lineCount = (lineHeight * (textViewP2 != null ? textViewP2.getLineCount() : 1)) - view.getHeight();
        if (i12 >= lineCount) {
            View viewR4 = this$0.R();
            if ((viewR4 == null || viewR4.getVisibility() != 4) && (viewR3 = this$0.R()) != null) {
                i.d(viewR3);
                return;
            }
            return;
        }
        int i15 = lineCount - i12;
        View viewR5 = this$0.R();
        if (i15 > (viewR5 != null ? viewR5.getHeight() : 1)) {
            View viewR6 = this$0.R();
            if (Intrinsics.a(viewR6 != null ? Float.valueOf(viewR6.getAlpha()) : null, 1.0f) || (viewR = this$0.R()) == null) {
                return;
            }
            viewR.setAlpha(1.0f);
            return;
        }
        View viewR7 = this$0.R();
        if ((viewR7 == null || viewR7.getVisibility() != 0) && (viewR2 = this$0.R()) != null) {
            i.e(viewR2);
        }
        float f12 = i15;
        View viewR8 = this$0.R();
        float height2 = f12 / (viewR8 != null ? viewR8.getHeight() : 1);
        View viewR9 = this$0.R();
        if (viewR9 == null) {
            return;
        }
        viewR9.setAlpha(1 * height2);
    }

    public static final void D(OooOo this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        l lVar = this$0.E;
        if (lVar != null) {
            Intrinsics.f(it, "it");
            lVar.b(it);
        }
        this$0.l();
    }

    public static final void z(OooOo this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        TextView textViewP = this_apply.P();
        if ((textViewP != null ? textViewP.getHeight() : 0) >= ((int) h.a.c(this_apply).getDimension(R$dimen.mini_dp_216))) {
            View viewT = this_apply.T();
            if (viewT != null) {
                i.d(viewT);
            }
            View viewR = this_apply.R();
            if (viewR != null) {
                i.e(viewR);
                return;
            }
            return;
        }
        View viewT2 = this_apply.T();
        if (viewT2 != null) {
            i.c(viewT2);
        }
        View viewR2 = this_apply.R();
        if (viewR2 != null) {
            i.c(viewR2);
        }
    }

    public final OooOo C(String str) {
        TextView textViewV = v();
        if (textViewV != null) {
            textViewV.setText(y(str, 12));
        }
        return this;
    }

    public final OooOo E(String str) {
        TextView textViewO = O();
        if (textViewO != null) {
            TextView textViewV = v();
            textViewO.setText(y(str, (textViewV == null || !i.a(textViewV)) ? 24 : 12));
        }
        J();
        M();
        return this;
    }

    public final OooOo F(int i11) {
        if (i11 > 0) {
            TextView textViewP = P();
            if (textViewP != null) {
                textViewP.setMaxLines(i11);
            }
            TextView textViewP2 = P();
            if (textViewP2 != null) {
                textViewP2.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            H(true);
        }
        return this;
    }

    public final OooOo G(String str) {
        TextView textViewS = S();
        if (textViewS != null) {
            textViewS.setText(str);
        }
        TextView textViewS2 = S();
        if (textViewS2 != null) {
            i.e(textViewS2);
        }
        N();
        return this;
    }

    public final OooOo H(boolean z11) {
        if (z11) {
            TextView textViewP = P();
            if (textViewP != null) {
                textViewP.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        } else {
            TextView textViewP2 = P();
            if (textViewP2 != null) {
                textViewP2.setMovementMethod(null);
            }
        }
        return this;
    }

    public final OooOo I(int i11) {
        TextView textViewO = O();
        if (textViewO != null) {
            textViewO.setTextColor(i11);
        }
        return this;
    }

    public final void J() {
        TextView textViewO;
        TextView textViewV = v();
        if (textViewV == null || !i.a(textViewV) || (textViewO = O()) == null || !i.a(textViewO)) {
            TextView textViewO2 = O();
            if (textViewO2 != null) {
                textViewO2.setBackgroundResource(this.f76t ? R$drawable.shape_mini_common_tip_confirm_dialog_click : R$drawable.shape_mini_common_tip_confirm_normal_dialog_click);
                return;
            }
            return;
        }
        TextView textViewO3 = O();
        if (textViewO3 != null) {
            textViewO3.setBackgroundResource(this.f76t ? R$drawable.shape_mini_common_tip_confirm_dialog_right_click : R$drawable.shape_mini_common_tip_confirm_normal_dialog_right_click);
        }
    }

    public final OooOo K(int i11) {
        TextView textViewV = v();
        if (textViewV != null) {
            textViewV.setTextColor(i11);
        }
        return this;
    }

    public final OooOo L(boolean z11) {
        TextView textViewV = v();
        if (textViewV != null) {
            i.f(textViewV, z11);
        }
        J();
        M();
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public final void M() {
        boolean z11;
        TextView textViewV = v();
        if (textViewV != null) {
            z11 = i.a(textViewV);
        }
        View view = (View) this.D.getValue();
        if (view != null) {
            i.f(view, z11);
        }
    }

    public final void N() {
        TextView textViewP;
        TextView textViewP2;
        TextView textViewP3;
        TextView textViewS = S();
        if (textViewS != null && i.a(textViewS) && (textViewP3 = P()) != null && i.a(textViewP3)) {
            TextView textViewS2 = S();
            if (textViewS2 != null) {
                textViewS2.setTextColor(h.a.a(this, this.f76t ? R$color.mini_confirm_dialog_title_color : R$color.mini_confirm_normal_dialog_title_color));
            }
            TextView textViewP4 = P();
            if (textViewP4 != null) {
                textViewP4.setTextColor(h.a.a(this, this.f76t ? R$color.mini_confirm_dialog_describe_color : R$color.mini_confirm_normal_dialog_describe_color));
                return;
            }
            return;
        }
        TextView textViewS3 = S();
        if (textViewS3 == null || i.a(textViewS3) || (textViewP = P()) == null || !i.a(textViewP) || (textViewP2 = P()) == null) {
            return;
        }
        textViewP2.setTextColor(h.a.a(this, this.f76t ? R$color.mini_confirm_dialog_title_color : R$color.mini_confirm_normal_dialog_title_color));
    }

    public final TextView O() {
        return (TextView) this.C.getValue();
    }

    public final TextView P() {
        return (TextView) this.f82z.getValue();
    }

    public final TextView Q() {
        return (TextView) this.A.getValue();
    }

    public final View R() {
        return (View) this.f78v.getValue();
    }

    public final TextView S() {
        return (TextView) this.f81y.getValue();
    }

    public final View T() {
        return (View) this.f77u.getValue();
    }

    public final TextView v() {
        return (TextView) this.B.getValue();
    }

    public final OooOo w(l listener) {
        Intrinsics.g(listener, "listener");
        this.E = listener;
        return this;
    }

    public final OooOo x(String str) {
        TextView textViewQ;
        FrameLayout frameLayout = (FrameLayout) this.f79w.getValue();
        if (frameLayout == null || !i.a(frameLayout)) {
            FrameLayout frameLayout2 = (FrameLayout) this.f80x.getValue();
            if (frameLayout2 != null && i.a(frameLayout2) && (textViewQ = Q()) != null) {
                textViewQ.setText(str);
            }
        } else {
            TextView textViewP = P();
            if (textViewP != null) {
                textViewP.setText(str);
            }
            TextView textViewP2 = P();
            if (textViewP2 != null) {
                i.e(textViewP2);
            }
            N();
            TextView textViewP3 = P();
            if (textViewP3 != null) {
                textViewP3.postDelayed(new Runnable() { // from class: j.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        OooOo.z(this.f67781a);
                    }
                }, 10L);
            }
        }
        return this;
    }

    public final String y(String str, int i11) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() < i11) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String strSubstring = str.substring(0, i11);
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb2.append(strSubstring);
        sb2.append("...");
        return sb2.toString();
    }
}
