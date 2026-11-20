package OooO0o0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import hd.j;
import id.d;
import kd.k;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o0ooOOo extends OooO0o0.OooO0OO.OooO00o<o0ooOOo> {
    public String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final String G;
    public final String H;
    public final String I;
    public final String J;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f155t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public bc.a f156u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f157v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f158w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f159x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f160y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f161z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0ooOOo.this.findViewById(R$id.tv_content);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0ooOOo.this.findViewById(R$id.tv_agree_content);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0ooOOo.this.findViewById(R$id.tv_btn_one);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0ooOOo.this.findViewById(R$id.tv_btn_two);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0ooOOo.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements OooO0o0.OooO0OO.h {
        public a() {
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0o0.OooO0OO oooO0OO) {
            k.a(j.a("MiniDevUserAgreementDialog.onDismiss->"), o0ooOOo.this.A, o0ooOOo.this.f155t);
            o0ooOOo o0ooooo = o0ooOOo.this;
            o0ooooo.f156u = null;
            if (o0ooooo.A.length() > 0) {
                PermissionScopeBridge.Companion.getClass();
                PermissionScopeBridge.OooO00o.remove(o0ooOOo.this.A);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0ooOOo(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f155t = "MiniDevUserAgreementDialog";
        this.f157v = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f158w = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.f159x = LazyKt__LazyJVMKt.b(new OooO());
        this.f160y = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f161z = LazyKt__LazyJVMKt.b(new OooO0o());
        this.A = "";
        j(R$layout.mini_dialog_layout_dua);
        b(-1);
        g(true);
        u(y(), z());
        d(new a());
        k(false);
        this.B = "mode";
        this.C = MimeTypes.BASE_TYPE_TEXT;
        this.D = NotificationCompat.CATEGORY_STATUS;
        this.E = "1";
        this.F = "2";
        this.G = "1";
        this.H = "2";
        this.I = "agreeClick";
        this.J = "cancelClick";
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        d.a.a(this, view);
        int id2 = view.getId();
        if (id2 == R$id.tv_btn_one) {
            w(this.I);
        } else if (id2 == R$id.tv_btn_two) {
            w(this.J);
        }
    }

    public final TextView v() {
        return (TextView) this.f159x.getValue();
    }

    public final void w(String str) {
        hd.k.a("sendClickResponse status = ", str, this.f155t);
        bc.a aVar = this.f156u;
        if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(this.D, str);
            aVar.d(jsonObject);
        }
        bc.a aVar2 = this.f156u;
        if (aVar2 != null) {
            aVar2.close();
        }
        l();
    }

    public final TextView x() {
        return (TextView) this.f158w.getValue();
    }

    public final TextView y() {
        return (TextView) this.f160y.getValue();
    }

    public final TextView z() {
        return (TextView) this.f161z.getValue();
    }
}
