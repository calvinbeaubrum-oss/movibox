package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.ImageSelectProxy;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.ui.ImagePreviewActivity;
import com.cloud.tmc.miniapp.ui.ImageSelectActivity;
import com.cloud.tmc.miniapp.ui.b;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ua.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TmcImageSelectImpl implements ImageSelectProxy {

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f31520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f31521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f31522c;

        /* JADX INFO: compiled from: source.java */
        public static final class OooO00o extends Lambda implements Function0<Unit> {
            public final /* synthetic */ n OooO00o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OooO00o(n nVar) {
                super(0);
                this.OooO00o = nVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                try {
                    this.OooO00o.a();
                } catch (Throwable unused) {
                }
                return Unit.f68710a;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class a implements n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f31523a;

            public a(n nVar) {
                this.f31523a = nVar;
            }

            @Override // ua.n
            public void a() {
                n.a.b(this);
            }

            @Override // ua.n
            public void b(boolean z11) {
            }

            @Override // ua.n
            public void c(ArrayList<String> data) {
                Intrinsics.g(data, "data");
                this.f31523a.c(data);
            }

            @Override // ua.n
            public void d(ArrayList<String> arrayList, ArrayList<Integer> arrayList2, boolean z11) {
                n.a.c(this, arrayList, arrayList2, z11);
            }

            @Override // ua.n
            public void onCancel() {
                this.f31523a.onCancel();
            }
        }

        public OooO0O0(n nVar, Context context, int i11) {
            this.f31520a = nVar;
            this.f31521b = context;
            this.f31522c = i11;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            this.f31520a.b(false);
            ((DialogProxy) tc.a.a(DialogProxy.class)).showStoragePermissionDialog(this.f31521b, null, new OooO00o(this.f31520a));
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            this.f31520a.b(true);
            Context context = this.f31521b;
            if (context instanceof BaseActivity) {
                ImageSelectActivity.a aVar = ImageSelectActivity.OooOOOo;
                BaseActivity activity = (BaseActivity) context;
                int i11 = this.f31522c;
                a aVar2 = new a(this.f31520a);
                Intrinsics.g(activity, "activity");
                if (i11 < 1) {
                    TmcLogger.b("最少要选择一个图片");
                    return;
                }
                Intent intent = new Intent(activity, (Class<?>) ImageSelectActivity.class);
                intent.putExtra("maxSelect", i11);
                ImageSelectActivity.OooOOo0 = i11 != 1 ? 2 : 1;
                h.f31061a.a(intent, activity);
                activity.startActivityForResult(intent, new b(aVar2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f31524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<String> f31525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f31526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f31527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ bc.a f31528e;

        public a(Context context, ArrayList<String> arrayList, boolean z11, int i11, bc.a aVar) {
            this.f31524a = context;
            this.f31525b = arrayList;
            this.f31526c = z11;
            this.f31527d = i11;
            this.f31528e = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f31528e;
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed preview image, no permission : PI002").e());
            }
            Object objA = tc.a.a(DialogProxy.class);
            Intrinsics.f(objA, "get(DialogProxy::class.java)");
            DialogProxy.a.a((DialogProxy) objA, this.f31524a, null, null, 6, null);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            Context context = this.f31524a;
            if (context instanceof BaseActivity) {
                ImagePreviewActivity.a aVar = ImagePreviewActivity.f31681r;
                BaseActivity activity = (BaseActivity) context;
                ArrayList<String> urls = this.f31525b;
                boolean z11 = this.f31526c;
                int i11 = this.f31527d;
                Intrinsics.g(activity, "activity");
                Intrinsics.g(urls, "urls");
                Intent intent = new Intent(activity, (Class<?>) ImagePreviewActivity.class);
                intent.putExtra("imageList", urls);
                intent.putExtra("imageMaxSelect", 0);
                intent.putExtra("showMenu", z11);
                intent.putExtra("current", i11);
                intent.putExtra("imageIndex", i11);
                h.f31061a.a(intent, activity);
                activity.startActivity(intent);
                activity.overridePendingTransition(R$anim.activity_fast_fade_in, R$anim.activity_fast_fade_out);
            }
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ImageSelectProxy
    public void imagePreview(Context context, ArrayList<String> urls, boolean z11, int i11, bc.a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(urls, "urls");
        PermissionUtils.y("STORAGE_READ").m(new a(context, urls, z11, i11, aVar)).z();
    }

    @Override // com.cloud.tmc.integration.proxy.ImageSelectProxy
    public void imageSelect(Context context, int i11, n listener) {
        Intrinsics.g(context, "context");
        Intrinsics.g(listener, "listener");
        PermissionUtils.y("MEDIA_IMAGES").m(new OooO0O0(listener, context, i11)).z();
    }

    public final boolean isDestroy(Context context) {
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return activity.isFinishing() || activity.isDestroyed();
        }
        if (!(context instanceof FragmentActivity)) {
            return false;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        return fragmentActivity.isFinishing() || fragmentActivity.isDestroyed();
    }
}
