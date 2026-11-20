package com.cloud.tmc.miniapp.defaultimpl;

import OooO0o0.OooO0O0;
import OooO0o0.OooO0OO;
import OooO0o0.OooOo;
import OooO0o0.o000OOo;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.defaultimpl.DefaultDialogProxy;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.cloud.tmc.miniutils.util.x;
import com.cloud.tmc.miniutils.util.y;
import j.l;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import ua.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultDialogProxy implements DialogProxy {
    public static final a Companion = new a();
    public OooO0O0 OooO00o;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0OO.h {
        public b() {
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            OooO0O0 addHomeDialog = DefaultDialogProxy.this.getAddHomeDialog();
            if (addHomeDialog != null) {
                addHomeDialog.f13t = null;
            }
            DefaultDialogProxy.this.setAddHomeDialog(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31512b;

        public c(Function0<Unit> function0, Function0<Unit> function1) {
            this.f31511a = function0;
            this.f31512b = function1;
        }

        @Override // j.l
        public void a(View view) {
            Intrinsics.g(view, "view");
            Function0<Unit> function0 = this.f31511a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // j.l
        public void b(View view) {
            Unit unit;
            Intrinsics.g(view, "view");
            Function0<Unit> function0 = this.f31512b;
            if (function0 != null) {
                function0.invoke();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                PermissionUtils.v();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements OooO0OO.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31513a;

        public d(String str) {
            this.f31513a = str;
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            sd.g gVar = sd.g.f76294a;
            String str = this.f31513a;
            if (str == null) {
                str = "";
            }
            gVar.a(str, oooO0OO);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements l {
        @Override // j.l
        public void a(View view) {
            Intrinsics.g(view, "view");
        }

        @Override // j.l
        public void b(View view) {
            Intrinsics.g(view, "view");
            PermissionUtils.v();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f31514a;

        public f(Ref.BooleanRef booleanRef) {
            this.f31514a = booleanRef;
        }

        @Override // j.l
        public void a(View view) {
            Intrinsics.g(view, "view");
        }

        @Override // j.l
        public void b(View view) {
            Intrinsics.g(view, "view");
            this.f31514a.element = true;
            PermissionUtils.v();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements OooO0OO.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f31515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f31516b;

        public g(Ref.BooleanRef booleanRef, Function0<Unit> function0) {
            this.f31515a = booleanRef;
            this.f31516b = function0;
        }

        @Override // OooO0o0.OooO0OO.h
        public void a(OooO0OO oooO0OO) {
            Function0<Unit> function0;
            if (this.f31515a.element || (function0 = this.f31516b) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public static final void OooO00o(DefaultDialogProxy this$0, Context context, String str, String str2, String str3, String str4, k callback) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        Intrinsics.g(callback, "$callback");
        try {
            OooO0O0 oooO0O0 = this$0.OooO00o;
            if (oooO0O0 != null) {
                oooO0O0.l();
                OooO0O0 oooO0O1 = this$0.OooO00o;
                if (oooO0O1 != null) {
                    oooO0O1.f13t = null;
                }
                this$0.OooO00o = null;
            }
            Activity activityC = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (activityC == null) {
                activityC = com.cloud.tmc.miniutils.util.a.c();
            }
            Intrinsics.f(activityC, "context as? MiniAppActiv…ityUtils.getTopActivity()");
            OooO0O0 oooO0O0V = new OooO0O0(activityC).w(str).v(str2);
            if (str3 == null) {
                str3 = "";
            }
            try {
                oooO0O0V.D = str3;
            } catch (Throwable th2) {
                TmcLogger.h("locationType", th2);
            }
            if (str4 == null) {
                str4 = "";
            }
            try {
                oooO0O0V.E = str4;
            } catch (Throwable th3) {
                TmcLogger.h("locationType", th3);
            }
            oooO0O0V.f13t = callback;
            OooO0O0 oooO0O0D = oooO0O0V.d(this$0.new b());
            this$0.OooO00o = oooO0O0D;
            oooO0O0D.q();
        } catch (Throwable th4) {
            TmcLogger.h("DefaultDialogProxy", th4);
        }
    }

    public final OooO0O0 getAddHomeDialog() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void hideLoadingDialog(Context context) {
        Intrinsics.g(context, "context");
        try {
            ((com.cloud.tmc.miniapp.ui.OooO0OO) context).hideLoadingDialog();
        } catch (Throwable th2) {
            TmcLogger.h("DefaultDialogProxy", th2);
        }
    }

    public final void setAddHomeDialog(OooO0O0 oooO0O0) {
        this.OooO00o = oooO0O0;
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showAddHomeConfirmDialog(final Context context, final String str, final String str2, final String str3, final String str4, final k callback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: md.b
            @Override // java.lang.Runnable
            public final void run() {
                DefaultDialogProxy.OooO00o(this.f70977a, context, str, str2, str4, str3, callback);
            }
        });
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showCameraPermissionDialog(Context context, String str, Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics.g(context, "context");
        OooOo oooOo = new OooOo(context, true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String strC = y.c(R$string.mini_dialog_permission_title);
        Intrinsics.f(strC, "getString(R.string.mini_dialog_permission_title)");
        String str2 = String.format(strC, Arrays.copyOf(new Object[]{y.c(R$string.mini_dialog_permission_camera)}, 1));
        Intrinsics.f(str2, "format(format, *args)");
        OooOo oooOoG = oooOo.G(str2);
        String strC2 = y.c(R$string.mini_dialog_permission_content);
        Intrinsics.f(strC2, "getString(R.string.mini_dialog_permission_content)");
        String str3 = String.format(strC2, Arrays.copyOf(new Object[]{y.c(R$string.mini_dialog_permission_camera)}, 1));
        Intrinsics.f(str3, "format(format, *args)");
        oooOoG.x(str3).C(y.c(R$string.mini_dialog_permission_left)).L(true).E(y.c(R$string.mini_dialog_permission_Right)).w(new c(function1, function0)).e(new d(str)).b(-1).H(true).k(false).q();
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showLoadingDialog(Context context) {
        Intrinsics.g(context, "context");
        try {
            BaseActivity.showLoadingDialog$default((com.cloud.tmc.miniapp.ui.OooO0OO) context, null, 1, null);
        } catch (Throwable th2) {
            TmcLogger.h("DefaultDialogProxy", th2);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showLocationPermissionDialog(Context context) {
        Intrinsics.g(context, "context");
        OooOo oooOo = new OooOo(context, true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String strC = y.c(R$string.mini_dialog_permission_title);
        Intrinsics.f(strC, "getString(R.string.mini_dialog_permission_title)");
        String str = String.format(strC, Arrays.copyOf(new Object[]{y.c(R$string.mini_dialog_permission_location)}, 1));
        Intrinsics.f(str, "format(format, *args)");
        OooOo oooOoG = oooOo.G(str);
        String strC2 = y.c(R$string.mini_dialog_permission_content);
        Intrinsics.f(strC2, "getString(R.string.mini_dialog_permission_content)");
        String str2 = String.format(strC2, Arrays.copyOf(new Object[]{y.c(R$string.mini_dialog_permission_location)}, 1));
        Intrinsics.f(str2, "format(format, *args)");
        oooOoG.x(str2).C(y.c(R$string.mini_dialog_permission_left)).L(true).E(y.c(R$string.mini_dialog_permission_Right)).w(new e()).b(-1).H(true).n(true).q();
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showPermissionDialog(Context context, String scopeName, String dialogContent, String appTitle, String appIconUrl, ua.l callback) {
        Group group;
        Intrinsics.g(context, "context");
        Intrinsics.g(scopeName, "scope");
        Intrinsics.g(dialogContent, "dialogContent");
        Intrinsics.g(appTitle, "appTitle");
        Intrinsics.g(appIconUrl, "appIconUrl");
        Intrinsics.g(callback, "callback");
        Activity activityC = com.cloud.tmc.miniutils.util.a.c();
        Intrinsics.f(activityC, "getTopActivity()");
        o000OOo o000ooo = new o000OOo(activityC);
        TextView textView = (TextView) o000ooo.f120w.getValue();
        if (textView != null) {
            textView.setText(appTitle);
        }
        TextView textView2 = (TextView) o000ooo.f122y.getValue();
        if (textView2 != null) {
            textView2.setText(dialogContent);
        }
        if (appIconUrl != null) {
            try {
                AppCompatImageView appCompatImageView = (AppCompatImageView) o000ooo.f118u.getValue();
                if (appCompatImageView != null) {
                    ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                    Context context2 = o000ooo.f27a;
                    int iA = x.a(4.0f);
                    int i11 = R$drawable.drawable_app_icon_place_holder;
                    imageLoaderProxy.loadImgRoundCorners(context2, appIconUrl, appCompatImageView, iA, i11, i11);
                }
            } catch (Throwable th2) {
                TmcLogger.h("PermissionDialog", th2);
            }
        }
        Intrinsics.g(scopeName, "scopeName");
        try {
            if (Intrinsics.b(scopeName, "notifyMessage") && (group = (Group) o000ooo.A.getValue()) != null) {
                group.setVisibility(0);
            }
        } catch (Throwable th3) {
            TmcLogger.h(o000ooo.E, th3);
        }
        o000ooo.f117t = callback;
        o000ooo.q();
    }

    @Override // com.cloud.tmc.integration.proxy.DialogProxy
    public void showStoragePermissionDialog(Context context, Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics.g(context, "context");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        OooOo oooOo = new OooOo(context, true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String strC = y.c(R$string.mini_dialog_permission_title);
        Intrinsics.f(strC, "getString(R.string.mini_dialog_permission_title)");
        String str = String.format(strC, Arrays.copyOf(new Object[]{y.c(R$string.mini_dialog_permission_storage)}, 1));
        Intrinsics.f(str, "format(format, *args)");
        OooOo oooOoG = oooOo.G(str);
        String strC2 = y.c(R$string.mini_dialog_permission_content);
        Intrinsics.f(strC2, "getString(R.string.mini_dialog_permission_content)");
        String str2 = String.format(strC2, Arrays.copyOf(new Object[]{y.c(R$string.mini_dialog_permission_storage)}, 1));
        Intrinsics.f(str2, "format(format, *args)");
        oooOoG.x(str2).C(y.c(R$string.mini_dialog_permission_left)).L(true).E(y.c(R$string.mini_dialog_permission_Right)).w(new f(booleanRef)).d(new g(booleanRef, function1)).b(-1).H(true).n(true).q();
    }
}
