package OooO0o0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniutils.util.x;
import com.cloud.tmc.miniutils.util.y;
import id.d;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import ua.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooO0O0 extends OooO0OO.OooO00o<OooO0O0> {
    public boolean A;
    public final Lazy B;
    public final Lazy C;
    public String D;
    public String E;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k f13t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f14u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f15v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f16w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f17x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f18y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f19z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<AppCompatImageView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooO0O0.this.findViewById(R$id.iv_dialog_mini_app_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<ImageView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) OooO0O0.this.findViewById(R$id.iv_check_show_again);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooO0O0.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooO0O0.this.findViewById(R$id.tv_allow);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<TextView> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooO0O0.this.findViewById(R$id.tv_dialog_mini_app_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooO0O0.this.findViewById(R$id.tv_deny);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<TextView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooO0O0.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<View> {
        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooO0O0.this.findViewById(R$id.view_click_show_again_check);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements OooO0OO.j {
        public a() {
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            String str = OooO0O0.this.E;
            Bundle bundle = new Bundle();
            bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, OooO0O0.this.D);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(str, "second_add_ex", bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0OO.f {
        public b() {
        }

        @Override // OooO0o0.OooO0OO.f
        public void a(OooO0OO oooO0OO) {
            k kVar = OooO0O0.this.f13t;
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements OooO0OO.h {
        public c() {
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            OooO0O0.this.f13t = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0O0(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f14u = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f15v = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.f16w = LazyKt__LazyJVMKt.b(new OooOOOO());
        this.f17x = LazyKt__LazyJVMKt.b(new OooOOO0());
        this.f18y = LazyKt__LazyJVMKt.b(new OooOOO());
        this.f19z = LazyKt__LazyJVMKt.b(new OooO0o());
        this.B = LazyKt__LazyJVMKt.b(new OooOo00());
        this.C = LazyKt__LazyJVMKt.b(new OooO());
        this.D = "";
        this.E = "";
        j(R$layout.mini_addhome_confirm_layout);
        b(id.b.f67188f8.a());
        g(true);
        u(x(), y(), z());
        k(false);
        n(false);
        e(new a());
        c(new b());
        d(new c());
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        d.a.a(this, view);
        if (Intrinsics.b(view, (TextView) this.f15v.getValue())) {
            k kVar = this.f13t;
            if (kVar != null) {
                kVar.c(null);
            }
            l();
            return;
        }
        if (Intrinsics.b(view, (TextView) this.f17x.getValue())) {
            k kVar2 = this.f13t;
            if (kVar2 != null) {
                kVar2.a();
            }
            l();
            return;
        }
        if (Intrinsics.b(view, (View) this.B.getValue())) {
            this.A = !this.A;
            ImageView imageView = (ImageView) this.f19z.getValue();
            if (imageView != null) {
                imageView.setSelected(this.A);
            }
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(this.f27a, this.E, "miniAddHomeNotShowAgainTime", this.A ? System.currentTimeMillis() : 0L);
        }
    }

    public final OooO0O0 v(String str) {
        if (str != null) {
            try {
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f14u.getValue();
                if (appCompatImageView != null) {
                    ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                    Context context = this.f27a;
                    int iA = x.a(4.0f);
                    int i11 = R$drawable.drawable_app_icon_place_holder;
                    imageLoaderProxy.loadImgRoundCorners(context, str, appCompatImageView, iA, i11, i11);
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.C.getValue();
                if (appCompatImageView2 != null) {
                    ImageLoaderProxy imageLoaderProxy2 = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                    Context context2 = this.f27a;
                    int iA2 = x.a(16.0f);
                    int i12 = R$drawable.drawable_app_icon_place_holder;
                    imageLoaderProxy2.loadImgRoundCorners(context2, str, appCompatImageView2, iA2, i12, i12);
                }
            } catch (Throwable th2) {
                TmcLogger.h("PermissionDialog", th2);
            }
        }
        return this;
    }

    public final OooO0O0 w(String str) {
        try {
            TextView textView = (TextView) this.f16w.getValue();
            if (textView != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String strC = y.c(R$string.mini_permission_dialog_title);
                Intrinsics.f(strC, "getString(R.string.mini_permission_dialog_title)");
                String str2 = String.format(strC, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.f(str2, "format(format, *args)");
                textView.setText(str2);
            }
            TextView textView2 = (TextView) this.f18y.getValue();
            if (textView2 != null) {
                textView2.setText(str);
            }
        } catch (Throwable th2) {
            TmcLogger.h("setAppTitle", th2);
        }
        return this;
    }

    public final TextView x() {
        return (TextView) this.f15v.getValue();
    }

    public final TextView y() {
        return (TextView) this.f17x.getValue();
    }

    public final View z() {
        return (View) this.B.getValue();
    }
}
