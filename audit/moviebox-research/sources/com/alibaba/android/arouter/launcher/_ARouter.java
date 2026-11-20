package com.alibaba.android.arouter.launcher;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.utils.d;
import java.util.concurrent.ThreadPoolExecutor;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class _ARouter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILogger f15359a = new com.alibaba.android.arouter.utils.a(ILogger.defaultTag);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f15360b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f15361c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f15362d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile _ARouter f15363e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f15364f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15365g = i7.b.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Handler f15366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Context f15367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static InterceptorService f15368j;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements InterceptorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f15370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Postcard f15371c;

        public a(int i11, NavigationCallback navigationCallback, Postcard postcard) {
            this.f15369a = i11;
            this.f15370b = navigationCallback;
            this.f15371c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            _ARouter.this.a(postcard, this.f15369a, this.f15370b);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th2) {
            NavigationCallback navigationCallback = this.f15370b;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.f15371c);
            }
            _ARouter.f15359a.info(ILogger.defaultTag, "Navigation failed, termination by interceptor : " + th2.getMessage());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15373a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f15373a = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15373a[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15373a[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15373a[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15373a[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15373a[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15373a[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static void e() {
        f15368j = (InterceptorService) com.alibaba.android.arouter.launcher.a.d().b("/arouter/service/interceptor").navigation();
    }

    public static boolean i() {
        return f15361c;
    }

    public static _ARouter k() {
        if (!f15364f) {
            throw new InitException("ARouterCore::Init::Invoke init(context) first!");
        }
        if (f15363e == null) {
            synchronized (_ARouter.class) {
                try {
                    if (f15363e == null) {
                        f15363e = new _ARouter();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f15363e;
    }

    public static synchronized boolean l(Application application) {
        f15367i = application;
        com.alibaba.android.arouter.core.a.d(application, f15365g);
        f15359a.info(ILogger.defaultTag, "ARouter init success!");
        f15364f = true;
        f15366h = new Handler(Looper.getMainLooper());
        return true;
    }

    public static void m(Object obj) {
        AutowiredService autowiredService = (AutowiredService) com.alibaba.android.arouter.launcher.a.d().b("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public final Object a(final Postcard postcard, final int i11, final NavigationCallback navigationCallback) {
        final Context context = postcard.getContext();
        int i12 = b.f15373a[postcard.getType().ordinal()];
        if (i12 == 1) {
            final Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            String action = postcard.getAction();
            if (!d.b(action)) {
                intent.setAction(action);
            }
            p(new Runnable() { // from class: com.alibaba.android.arouter.launcher._ARouter.3
                @Override // java.lang.Runnable
                public void run() {
                    _ARouter.this.q(i11, context, intent, postcard, navigationCallback);
                }
            });
            return null;
        }
        if (i12 == 2) {
            return postcard.getProvider();
        }
        if (i12 == 3 || i12 == 4 || i12 == 5) {
            try {
                Object objNewInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance instanceof Fragment) {
                    ((Fragment) objNewInstance).setArguments(postcard.getExtras());
                } else if (objNewInstance instanceof androidx.fragment.app.Fragment) {
                    ((androidx.fragment.app.Fragment) objNewInstance).setArguments(postcard.getExtras());
                }
                return objNewInstance;
            } catch (Exception e11) {
                f15359a.error(ILogger.defaultTag, "Fetch fragment instance error, " + d.a(e11.getStackTrace()));
            }
        }
        return null;
    }

    public Postcard f(Uri uri) {
        if (uri == null || d.b(uri.toString())) {
            throw new HandlerException("ARouter::Parameter invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) com.alibaba.android.arouter.launcher.a.d().h(PathReplaceService.class);
        if (pathReplaceService != null) {
            uri = pathReplaceService.forUri(uri);
        }
        return new Postcard(uri.getPath(), j(uri.getPath()), uri, null);
    }

    public Postcard g(String str) {
        if (d.b(str)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) com.alibaba.android.arouter.launcher.a.d().h(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return h(str, j(str), Boolean.TRUE);
    }

    public Postcard h(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (d.b(str) || d.b(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) com.alibaba.android.arouter.launcher.a.d().h(PathReplaceService.class)) != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    public final String j(String str) {
        if (d.b(str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String strSubstring = str.substring(1, str.indexOf("/", 1));
            if (d.b(strSubstring)) {
                throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return strSubstring;
        } catch (Exception e11) {
            f15359a.warning(ILogger.defaultTag, "Failed to extract default group! " + e11.getMessage());
            return null;
        }
    }

    public Object n(Context context, final Postcard postcard, int i11, NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) com.alibaba.android.arouter.launcher.a.d().h(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        postcard.setContext(context == null ? f15367i : context);
        try {
            com.alibaba.android.arouter.core.a.c(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return a(postcard, i11, navigationCallback);
            }
            f15368j.doInterceptions(postcard, new a(i11, navigationCallback, postcard));
            return null;
        } catch (NoRouteFoundException e11) {
            f15359a.warning(ILogger.defaultTag, e11.getMessage());
            if (i()) {
                p(new Runnable() { // from class: com.alibaba.android.arouter.launcher._ARouter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(_ARouter.f15367i, "There's no route matched!\n Path = [" + postcard.getPath() + "]\n Group = [" + postcard.getGroup() + "]", 1).show();
                    }
                });
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) com.alibaba.android.arouter.launcher.a.d().h(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public <T> T o(Class<? extends T> cls) {
        try {
            Postcard postcardB = com.alibaba.android.arouter.core.a.b(cls.getName());
            if (postcardB == null) {
                postcardB = com.alibaba.android.arouter.core.a.b(cls.getSimpleName());
            }
            if (postcardB == null) {
                return null;
            }
            postcardB.setContext(f15367i);
            com.alibaba.android.arouter.core.a.c(postcardB);
            return (T) postcardB.getProvider();
        } catch (NoRouteFoundException e11) {
            f15359a.warning(ILogger.defaultTag, e11.getMessage());
            return null;
        }
    }

    public final void p(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f15366h.post(runnable);
        } else {
            runnable.run();
        }
    }

    public final void q(int i11, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i11 < 0) {
            z2.a.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.k((Activity) context, intent, i11, postcard.getOptionsBundle());
        } else {
            f15359a.warning(ILogger.defaultTag, "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }
}
