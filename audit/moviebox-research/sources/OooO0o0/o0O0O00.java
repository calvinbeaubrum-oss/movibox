package OooO0o0;

import OooO0o0.o0O0O00;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.tmc.integration.model.CSMKBean;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniutils.util.k;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o0O0O00 extends OooO0o0.OooO0OO.OooO00o<o0O0O00> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f135t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f136u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f137v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f138w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f139x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f140y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f141z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<ImageView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) o0O0O00.this.findViewById(R$id.iv_close);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<ImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) o0O0O00.this.findViewById(R$id.iv_confrim);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<ImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) o0O0O00.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) o0O0O00.this.findViewById(R$id.tv_open);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0O0O00(Context mContext, String appId) {
        super(mContext);
        Intrinsics.g(mContext, "mContext");
        Intrinsics.g(appId, "appId");
        this.f135t = mContext;
        this.f136u = appId;
        this.f137v = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f138w = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.f139x = LazyKt__LazyJVMKt.b(new OooO00o());
        this.f140y = LazyKt__LazyJVMKt.b(new OooO0o());
        j(R$layout.dialog_mini_open_app);
        g(true);
        k(true);
        m(80);
        b(-1);
        ImageView imageViewZ = z();
        if (imageViewZ != null) {
            imageViewZ.setOnClickListener(new View.OnClickListener() { // from class: j.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0O0O00.v(this.f67767a, view);
                }
            });
        }
        TextView textViewA = A();
        if (textViewA != null) {
            textViewA.setOnClickListener(new View.OnClickListener() { // from class: j.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0O0O00.w(this.f67768a, view);
                }
            });
        }
        ImageView imageViewY = y();
        if (imageViewY != null) {
            imageViewY.setOnClickListener(new View.OnClickListener() { // from class: j.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0O0O00.x(this.f67771a, view);
                }
            });
        }
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_GET_ADD_EX;
        Bundle bundle = new Bundle();
        bundle.putString("miniappid", appId);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
    }

    public static final void v(o0O0O00 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        view.setSelected(!this$0.f141z);
        this$0.f141z = !this$0.f141z;
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(this$0.f135t, "1000886706715795456_web", "csmk", k.j(new CSMKBean(!this$0.f141z)));
    }

    public static final void w(o0O0O00 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ByteAppManager.launchMiniAppForId$default(this$0.f135t, this$0.f136u, "120011", null, 8, null);
        this$0.l();
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_GET_ADD_CLICK;
        Bundle bundle = new Bundle();
        bundle.putString("miniappid", this$0.f136u);
        bundle.putString("type", "1");
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
        if (this$0.f141z) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_GET_ADD_NOSHOW;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", this$0.f136u);
            performanceAnalyseProxy2.record("", pointAnalyseType2, "", bundle2);
        }
    }

    public static final void x(o0O0O00 this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.l();
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_GET_ADD_CLICK;
        Bundle bundle = new Bundle();
        bundle.putString("miniappid", this$0.f136u);
        bundle.putString("type", "2");
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record("", pointAnalyseType, "", bundle);
        if (this$0.f141z) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType2 = PointAnalyseType.POINT_GET_ADD_NOSHOW;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", this$0.f136u);
            performanceAnalyseProxy2.record("", pointAnalyseType2, "", bundle2);
        }
    }

    public final TextView A() {
        return (TextView) this.f140y.getValue();
    }

    public final ImageView y() {
        return (ImageView) this.f139x.getValue();
    }

    public final ImageView z() {
        return (ImageView) this.f138w.getValue();
    }
}
