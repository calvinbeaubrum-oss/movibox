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
import com.cloud.tmc.miniutils.util.y;
import id.d;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import ua.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o000OOo extends OooO0o0.OooO0OO.OooO00o<o000OOo> {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public boolean D;
    public final String E;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l f117t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f118u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f119v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f120w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f121x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f122y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f123z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<AppCompatImageView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) o000OOo.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<Group> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Group invoke() {
            return (Group) o000OOo.this.findViewById(R$id.group_check_show_again);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<ImageView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) o000OOo.this.findViewById(R$id.iv_check_show_again);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000OOo.this.findViewById(R$id.tv_allow);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000OOo.this.findViewById(R$id.tv_content);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<TextView> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000OOo.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000OOo.this.findViewById(R$id.tv_deny);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<TextView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o000OOo.this.findViewById(R$id.tv_title_tips);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<View> {
        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return o000OOo.this.findViewById(R$id.view_click_show_again_check);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements OooO0o0.OooO0OO.f {
        public a() {
        }

        @Override // OooO0o0.OooO0OO.f
        public void a(OooO0o0.OooO0OO oooO0OO) {
            l lVar = o000OOo.this.f117t;
            if (lVar != null) {
                lVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0o0.OooO0OO.h {
        public b() {
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0o0.OooO0OO oooO0OO) {
            o000OOo.this.f117t = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o000OOo(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f118u = LazyKt__LazyJVMKt.b(new OooO());
        this.f119v = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f120w = LazyKt__LazyJVMKt.b(new OooOOO());
        this.f121x = LazyKt__LazyJVMKt.b(new OooOOOO());
        this.f122y = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.f123z = LazyKt__LazyJVMKt.b(new OooOOO0());
        this.A = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.B = LazyKt__LazyJVMKt.b(new OooOo00());
        this.C = LazyKt__LazyJVMKt.b(new OooO0o());
        this.E = "PermissionDialog";
        j(R$layout.layout_mini_login_permission);
        b(id.b.f67188f8.a());
        g(true);
        u(x(), y(), v());
        k(false);
        c(new a());
        d(new b());
        try {
            TextView textViewZ = z();
            if (textViewZ == null) {
                return;
            }
            textViewZ.setText(w(y.c(R$string.mini_permission_dialog_title), " "));
        } catch (Throwable th2) {
            TmcLogger.h(this.E, th2);
        }
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        d.a.a(this, view);
        if (Intrinsics.b(view, (TextView) this.f119v.getValue())) {
            l lVar = this.f117t;
            if (lVar != null) {
                lVar.c(null);
            }
            l();
            return;
        }
        if (Intrinsics.b(view, (TextView) this.f123z.getValue())) {
            l lVar2 = this.f117t;
            if (lVar2 != null) {
                lVar2.a();
            }
            l();
            return;
        }
        if (Intrinsics.b(view, (View) this.B.getValue())) {
            this.D = !this.D;
            ImageView imageView = (ImageView) this.C.getValue();
            if (imageView != null) {
                imageView.setSelected(this.D);
            }
            l lVar3 = this.f117t;
            if (lVar3 != null) {
                lVar3.b(this.D);
            }
        }
    }

    public final View v() {
        return (View) this.B.getValue();
    }

    public final String w(String str, String str2) {
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            if (str == null) {
                str = "";
            }
            String str3 = String.format(str, Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.f(str3, "format(format, *args)");
            return str3;
        } catch (Throwable th2) {
            TmcLogger.h(this.E, th2);
            return str2;
        }
    }

    public final TextView x() {
        return (TextView) this.f119v.getValue();
    }

    public final TextView y() {
        return (TextView) this.f123z.getValue();
    }

    public final TextView z() {
        return (TextView) this.f121x.getValue();
    }
}
