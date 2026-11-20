package h0;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.s;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import com.cloud.tmc.miniutils.util.w;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import p010OooOooo.o0000;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final void a(final int i11, final int i12, final boolean z11, final ViewGroup viewGroup, final FragmentActivity fragmentActivity, final App app, final MiniAppBaseFragment miniAppBaseFragment) {
        AppModel appModel;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getRect->width:");
        sb2.append(i11);
        sb2.append(", height:");
        sb2.append(i12);
        sb2.append(", isVideo:");
        sb2.append(z11);
        sb2.append(", appType:");
        sb2.append((app == null || (appModel = app.getAppModel()) == null) ? null : Integer.valueOf(appModel.getAppinfoCategoryType()));
        TmcLogger.c("pom", sb2.toString());
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: h0.f
            @Override // java.lang.Runnable
            public final void run() {
                g.b(viewGroup, fragmentActivity, app, z11, i11, i12, miniAppBaseFragment);
            }
        });
    }

    public static final void b(ViewGroup viewGroup, FragmentActivity activity, App app, boolean z11, int i11, int i12, MiniAppBaseFragment miniAppBaseFragment) {
        AppModel appModel;
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(miniAppBaseFragment, "$miniAppBaseFragment");
        if (viewGroup != null) {
            ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
            int iB = w.b();
            if (s.e(activity)) {
                iB -= s.b(activity);
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
                if (Build.VERSION.SDK_INT >= 28 && attributes != null && attributes.layoutInDisplayCutoutMode == 3) {
                    iB += s.b(activity);
                }
            }
            if (app != null && (appModel = app.getAppModel()) != null && appModel.getAppinfoCategoryType() == MiniAppType.SHELL_GAME.getType()) {
                if (miniAppBaseFragment.E0()) {
                    iB -= s.a(activity);
                }
                ((ViewGroup.MarginLayoutParams) bVar).width = w.c();
                ((ViewGroup.MarginLayoutParams) bVar).height = iB;
                if (!miniAppBaseFragment.L0().get()) {
                    return;
                }
                if (activity.getRequestedOrientation() == 0) {
                    activity.setRequestedOrientation(1);
                }
            } else if (!z11 || (z11 && i11 > i12)) {
                if (miniAppBaseFragment.E0()) {
                    miniAppBaseFragment.K0();
                }
                int iC = w.c();
                if (iC >= iB) {
                    ((ViewGroup.MarginLayoutParams) bVar).height = iB;
                    ((ViewGroup.MarginLayoutParams) bVar).width = iC;
                } else {
                    ((ViewGroup.MarginLayoutParams) bVar).height = iC;
                    ((ViewGroup.MarginLayoutParams) bVar).width = iB;
                }
                if (!miniAppBaseFragment.L0().get()) {
                    return;
                }
                if (activity.getRequestedOrientation() == 1) {
                    activity.setRequestedOrientation(0);
                }
            } else {
                if (miniAppBaseFragment.E0()) {
                    iB -= s.a(activity);
                }
                ((ViewGroup.MarginLayoutParams) bVar).width = w.c();
                ((ViewGroup.MarginLayoutParams) bVar).height = iB;
                if (!miniAppBaseFragment.L0().get()) {
                    return;
                }
                if (activity.getRequestedOrientation() == 0) {
                    activity.setRequestedOrientation(1);
                }
            }
            viewGroup.setLayoutParams(bVar);
            viewGroup.requestLayout();
        }
    }

    public static final void c(ViewGroup viewGroup, FragmentActivity activity, MiniAppBaseFragment this_tryToProtrait) {
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(this_tryToProtrait, "$this_tryToProtrait");
        if (viewGroup != null) {
            ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
            int iB = w.b();
            if (s.e(activity)) {
                iB -= s.b(activity);
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
                if (Build.VERSION.SDK_INT >= 28 && attributes != null && attributes.layoutInDisplayCutoutMode == 3) {
                    iB += s.b(activity);
                }
            }
            if (this_tryToProtrait.E0()) {
                iB -= s.a(activity);
            }
            ((ViewGroup.MarginLayoutParams) bVar).width = w.c();
            ((ViewGroup.MarginLayoutParams) bVar).height = iB;
            if (activity.getRequestedOrientation() == 0) {
                activity.setRequestedOrientation(1);
            }
            viewGroup.setLayoutParams(bVar);
            viewGroup.requestLayout();
        }
    }

    public static final void d(MiniAppBaseFragment miniAppBaseFragment) {
        zc.i render;
        Intrinsics.g(miniAppBaseFragment, "<this>");
        Page pageH0 = miniAppBaseFragment.h0();
        View view = (pageH0 == null || (render = pageH0.getRender()) == null) ? null : render.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            webView.evaluateJavascript("\n        function getVideoRect() {\n              console.log('pom getVideoRect');\n              if (window.injectFullScreen != null) {\n                return;\n              }\n              window.injectFullScreen = true;\n              [\n                'fullscreenchange',\n                'webkitfullscreenchange',\n                'mozfullscreenchange',\n                'msfullscreenchange',\n              ].forEach((item) => {\n                document.addEventListener(item, function (res) {\n                  console.log('pom ' + item);\n                  var fullscreenElement = document.fullscreenElement;\n                  if (fullscreenElement) {\n                    if (fullscreenElement instanceof HTMLVideoElement) {\n                      // 全屏元素是 <video> 标签\n                      console.log('pom ' + item + ' video label enter fullScreen');\n                      window.dltFullScreen.enterFullScreen(\n                        res.target.videoWidth,\n                        res.target.videoHeight,\n                        true\n                      );\n                    } else {\n                      // 全屏元素不是 <video> 标签\n                      console.log('pom ' + item + ' other label enter fullScreen');\n                      window.dltFullScreen.enterFullScreen(\n                        res.target.videoWidth,\n                        res.target.videoHeight,\n                        false\n                      );\n                    }\n                  } else {\n                    // 页面退出全屏模式\n                    console.log('pom ' + item + ' exit fullScreen');\n                  }\n                });\n              });\n            }\n            getVideoRect();\n    ", new ValueCallback() { // from class: h0.b
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    g.i((String) obj);
                }
            });
        }
    }

    public static final void e(final MiniAppBaseFragment miniAppBaseFragment, final ViewGroup viewGroup, final FragmentActivity activity) {
        Intrinsics.g(miniAppBaseFragment, "<this>");
        Intrinsics.g(activity, "activity");
        com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: h0.c
            @Override // java.lang.Runnable
            public final void run() {
                g.c(viewGroup, activity, miniAppBaseFragment);
            }
        });
    }

    public static final void f(MiniAppBaseFragment miniAppBaseFragment, Page page) {
        uc.b eventCenterInstance;
        Intrinsics.g(miniAppBaseFragment, "<this>");
        if (page == null || (eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(page)) == null) {
            return;
        }
        StringBuilder sbA = hd.j.a("eventFullScreen_");
        sbA.append(page.getNodeId());
        eventCenterInstance.a(sbA.toString());
    }

    public static final void g(MiniAppBaseFragment miniAppBaseFragment, Page page, final o0000 miniFragment) {
        uc.b eventCenterInstance;
        Intrinsics.g(miniAppBaseFragment, "<this>");
        Intrinsics.g(miniFragment, "miniFragment");
        if (page == null || (eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(page)) == null) {
            return;
        }
        StringBuilder sbA = hd.j.a("eventAD_");
        sbA.append(page.getNodeId());
        eventCenterInstance.b(sbA.toString(), new uc.c() { // from class: h0.d
            @Override // uc.c
            public final boolean O(uc.a aVar) {
                return g.j(miniFragment, aVar);
            }
        });
    }

    public static final void h(MiniAppBaseFragment miniAppBaseFragment, Page page, final ViewGroup viewGroup, final FragmentActivity activity, final App app, final MiniAppBaseFragment miniAppBaseFragment2) {
        uc.b eventCenterInstance;
        Intrinsics.g(miniAppBaseFragment, "<this>");
        Intrinsics.g(activity, "activity");
        Intrinsics.g(miniAppBaseFragment2, "miniAppBaseFragment");
        if (page == null || (eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(page)) == null) {
            return;
        }
        StringBuilder sbA = hd.j.a("eventFullScreen_");
        sbA.append(page.getNodeId());
        eventCenterInstance.b(sbA.toString(), new uc.c() { // from class: h0.e
            @Override // uc.c
            public final boolean O(uc.a aVar) {
                return g.k(viewGroup, activity, app, miniAppBaseFragment2, aVar);
            }
        });
    }

    public static final void i(String str) {
    }

    public static final boolean j(o0000 miniFragment, uc.a aVar) {
        Intrinsics.g(miniFragment, "$miniFragment");
        if (aVar == null) {
            return true;
        }
        try {
            Map<String, Object> data = aVar.getData();
            if (data == null) {
                return true;
            }
            Object obj = data.get("eventADParmaKeyADTag");
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = data.get("eventADParmaKeyADM");
            Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            Object obj3 = data.get("eventADParmaKeyCallbackId");
            Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj3;
            TmcLogger.c("pom", "adTag:" + str + ", adm:" + zBooleanValue + ", callbackId:" + str2);
            miniFragment.getClass();
            Intrinsics.g(str, "<set-?>");
            miniFragment.H = str;
            miniFragment.I = zBooleanValue;
            Intrinsics.g(str2, "<set-?>");
            miniFragment.J = str2;
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static final boolean k(ViewGroup viewGroup, FragmentActivity activity, App app, MiniAppBaseFragment miniAppBaseFragment, uc.a aVar) {
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(miniAppBaseFragment, "$miniAppBaseFragment");
        if (aVar == null) {
            return true;
        }
        try {
            Map<String, Object> data = aVar.getData();
            if (data == null) {
                return true;
            }
            Object obj = data.get("eventFullScreenParamKeyWidth");
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = data.get("eventFullScreenParamKeyHeight");
            Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue2 = ((Integer) obj2).intValue();
            Object obj3 = data.get("eventFullScreenParamKeyIsVideo");
            Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            a(iIntValue, iIntValue2, ((Boolean) obj3).booleanValue(), viewGroup, activity, app, miniAppBaseFragment);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static final void l(MiniAppBaseFragment miniAppBaseFragment) {
        FragmentActivity activity;
        Intrinsics.g(miniAppBaseFragment, "<this>");
        FragmentActivity activity2 = miniAppBaseFragment.getActivity();
        if (activity2 == null || activity2.getRequestedOrientation() != 0 || (activity = miniAppBaseFragment.getActivity()) == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }
}
