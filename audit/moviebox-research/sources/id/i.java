package id;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.proxy.AnimtionProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.MiniNoNetworkView;
import com.cloud.tmc.miniapp.widget.MiniappLaunchLoadingView;
import com.cloud.tmc.miniapp.widget.OfflineAppView;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface i {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static boolean a(i iVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                return statusLayout.OooO0OO();
            }
            return true;
        }

        public static void b(i iVar, LoadingTextView.LoadingAnimationModel progressConfig) {
            Intrinsics.g(progressConfig, "progressConfig");
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.setLoadingProgressConfig(progressConfig);
            }
        }

        public static boolean c(i iVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout == null) {
                return true;
            }
            if (!statusLayout.OooO0OO()) {
                return false;
            }
            statusLayout.OooO00o();
            statusLayout.OooO0O0();
            return true;
        }

        public static void d(i iVar, String str, String str2, String str3, StatusLayout.b bVar, String str4, StatusLayout.a aVar) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Bundle bundle = new Bundle();
            bundle.putInt("type", 2);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(str4, "uncon_page_ex", bundle);
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.OooO00o();
                statusLayout.OooO0O0(iVar.getViewThemeMode());
                statusLayout.OooOOOo = true;
                ConstraintLayout constraintLayout = statusLayout.OooO0oO;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
                LinearLayout linearLayout = statusLayout.f31865OooO0o;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                try {
                    LoadingTextView loadingTextView = statusLayout.f31867OooO0oo;
                    if (loadingTextView != null) {
                        loadingTextView.OooO00o();
                    }
                    MiniNoNetworkView miniNoNetworkView = statusLayout.OooOOO0;
                    if (miniNoNetworkView != null) {
                        miniNoNetworkView.OooO00o(str, str2, str3);
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("launcher step error", th2);
                }
                statusLayout.setOnCustomNoNetWorkRetryListener(bVar);
            }
        }

        public static void e(i iVar, StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
            Integer viewThemeMode = iVar.getViewThemeMode();
            iVar.showErrorLayout((viewThemeMode != null && viewThemeMode.intValue() == 2) ? R$drawable.mini_ic_error_normal_mode : R$drawable.mini_ic_error, i11, bVar, str, aVar);
        }

        public static /* synthetic */ void f(i iVar, StatusLayout.b bVar, int i11, String str, String str2, StatusLayout.a aVar, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
            }
            if ((i12 & 2) != 0) {
                i11 = R$string.loading_error_tv;
            }
            int i13 = i11;
            if ((i12 & 4) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i12 & 16) != 0) {
                aVar = null;
            }
            iVar.showError(bVar, i13, str3, str2, aVar);
        }

        public static void g(i iVar, int i11, @StringRes int i12, @StringRes int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                n(iVar, z2.a.getDrawable(statusLayout.getContext(), i11), statusLayout.getContext().getString(i12), statusLayout.getContext().getString(i13), bVar, null, z11, z12, aVar, 16, null);
            }
        }

        public static void h(i iVar, int i11, @StringRes int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                iVar.showErrorLayout(z2.a.getDrawable(statusLayout.getContext(), i11), statusLayout.getContext().getString(i12), bVar, str, aVar);
            }
        }

        public static void i(i iVar, Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
            if (iVar.getStatusLayout() != null) {
                n(iVar, drawable, charSequence, null, bVar, str, false, false, aVar, 96, null);
            }
        }

        public static void j(i iVar, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.OooO00o();
                statusLayout.OooO0O0(iVar.getViewThemeMode());
                statusLayout.OooOOOo = true;
                statusLayout.OooOOo0 = z12;
                ConstraintLayout constraintLayout = statusLayout.OooO0oO;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
                LinearLayout linearLayout = statusLayout.f31865OooO0o;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                MiniNoNetworkView miniNoNetworkView = statusLayout.OooOOO0;
                if (miniNoNetworkView != null) {
                    miniNoNetworkView.setVisibility(8);
                }
                TextView textView = statusLayout.f31866OooO0o0;
                if (textView != null) {
                    xb.i.g(textView, statusLayout.OooOOOO != null);
                }
                try {
                    if (z11) {
                        TextView textView2 = statusLayout.OooOOO;
                        if (textView2 != null) {
                            xb.i.e(textView2);
                        }
                    } else {
                        TextView textView3 = statusLayout.OooOOO;
                        if (textView3 != null) {
                            xb.i.c(textView3);
                        }
                    }
                    LoadingTextView loadingTextView = statusLayout.f31867OooO0oo;
                    if (loadingTextView != null) {
                        loadingTextView.OooO00o();
                    }
                    if (AppDynamicBuildConfig.k()) {
                        if (str == null || str.length() == 0) {
                            TextView textView4 = statusLayout.f31869OooOO0o;
                            if (textView4 != null) {
                                xb.i.d(textView4);
                            }
                        } else {
                            TextView textView5 = statusLayout.f31869OooOO0o;
                            if (textView5 != null) {
                                xb.i.e(textView5);
                                textView5.setText(str);
                            }
                        }
                    }
                    if (str != null) {
                        TmcLogger.e("launch step error:" + str);
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("launcher step error", th2);
                }
                statusLayout.setIcon(drawable);
                statusLayout.setHint(charSequence);
                statusLayout.setTitle(charSequence2);
                statusLayout.setOnRetryListener(bVar);
            }
        }

        public static /* synthetic */ void k(i iVar, int i11, int i12, int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar, int i14, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            iVar.showErrorLayout(i11, i12, i13, bVar, (i14 & 16) != 0 ? true : z11, (i14 & 32) != 0 ? false : z12, (i14 & 64) != 0 ? null : aVar);
        }

        public static /* synthetic */ void l(i iVar, int i11, int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            if ((i13 & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i13 & 16) != 0) {
                aVar = null;
            }
            iVar.showErrorLayout(i11, i12, bVar, str2, aVar);
        }

        public static /* synthetic */ void m(i iVar, Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            if ((i11 & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i11 & 16) != 0) {
                aVar = null;
            }
            iVar.showErrorLayout(drawable, charSequence, bVar, str2, aVar);
        }

        public static /* synthetic */ void n(i iVar, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorLayout");
            }
            iVar.showErrorLayout(drawable, charSequence, charSequence2, bVar, (i11 & 16) != 0 ? "" : str, (i11 & 32) != 0 ? false : z11, (i11 & 64) != 0 ? false : z12, (i11 & 128) != 0 ? null : aVar);
        }

        public static void o(i iVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.OooO0O0(iVar.getViewThemeMode());
                statusLayout.OooO0Oo();
                statusLayout.setOnRetryListener(null);
            }
        }

        public static void p(i iVar, String appName, String logo) {
            String string;
            TextView textView;
            Intrinsics.g(appName, "appName");
            Intrinsics.g(logo, "logo");
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                Intrinsics.g(logo, "logo");
                Intrinsics.g(appName, "appName");
                try {
                    string = statusLayout.getContext().getString(R$string.dialog_loading_tv);
                } catch (Throwable unused) {
                    string = "Loading...";
                }
                Intrinsics.f(string, "try {\n            contex…   \"Loading...\"\n        }");
                if (!Intrinsics.b(appName, string) && (textView = statusLayout.f31863OooO) != null) {
                    textView.setText(appName);
                }
                MiniappLaunchLoadingView miniappLaunchLoadingView = statusLayout.f31868OooOO0;
                if (miniappLaunchLoadingView != null) {
                    Intrinsics.g(logo, "logo");
                    try {
                        AppCompatImageView appCompatImageView = miniappLaunchLoadingView.OooO00o;
                        if (appCompatImageView == null) {
                            Intrinsics.y("mLoadingImg");
                            appCompatImageView = null;
                        }
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        if (((AnimtionProxy) tc.a.a(AnimtionProxy.class)).enableLoadingAnimation() && !miniappLaunchLoadingView.f31840OooO0o) {
                            miniappLaunchLoadingView.OooO0oO = true;
                            miniappLaunchLoadingView.OooO00o();
                        }
                        if (logo.length() == 0) {
                            return;
                        }
                        ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                        Context context = miniappLaunchLoadingView.getContext();
                        int iB = xb.a.b(14);
                        Integer num = miniappLaunchLoadingView.OooO0OO;
                        int i11 = (num != null && num.intValue() == 2) ? R$drawable.drawable_app_icon_place_holder_normal_mode : R$drawable.drawable_app_icon_place_holder;
                        Integer num2 = miniappLaunchLoadingView.OooO0OO;
                        imageLoaderProxy.loadImgRoundCorners(context, logo, appCompatImageView2, iB, i11, (num2 != null && num2.intValue() == 2) ? R$drawable.drawable_app_icon_place_holder_normal_mode : R$drawable.drawable_app_icon_place_holder);
                    } catch (Throwable th2) {
                        TmcLogger.h(miniappLaunchLoadingView.f31839OooO0Oo, th2);
                    }
                }
            }
        }

        public static void q(i iVar, float f11) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                statusLayout.setMainLayoutAlpha(f11);
            }
        }

        public static void r(i iVar, StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
            if (iVar.getStatusLayout() != null) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.recordForCommon(str2, "uncon_page_ex", bundle);
                Integer viewThemeMode = iVar.getViewThemeMode();
                k(iVar, (viewThemeMode != null && viewThemeMode.intValue() == 2) ? R$drawable.mini_ic_no_network_normal_mode : R$drawable.mini_ic_no_network, R$string.mini_no_network_info, R$string.mini_no_network_connection, bVar, false, false, aVar, 48, null);
            }
        }

        public static /* synthetic */ void s(i iVar, StatusLayout.b bVar, int i11, String str, String str2, StatusLayout.a aVar, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNoNetwork");
            }
            if ((i12 & 2) != 0) {
                i11 = R$string.loading_error_tv;
            }
            int i13 = i11;
            if ((i12 & 4) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i12 & 16) != 0) {
                aVar = null;
            }
            iVar.showNoNetwork(bVar, i13, str3, str2, aVar);
        }

        public static void t(i iVar, int i11, @StringRes int i12, StatusLayout.b bVar) {
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                m(iVar, z2.a.getDrawable(statusLayout.getContext(), i11), statusLayout.getContext().getString(i12), bVar, null, null, 24, null);
                statusLayout.setHintColor(R$color.mini_color_686c73);
            }
        }

        public static void u(i iVar, StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
            if (iVar.getStatusLayout() != null) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
                Bundle bundle = new Bundle();
                bundle.putInt("type", 3);
                Unit unit = Unit.f68710a;
                performanceAnalyseProxy.recordForCommon(str2, "uncon_page_ex", bundle);
                Integer viewThemeMode = iVar.getViewThemeMode();
                iVar.showErrorLayout((viewThemeMode != null && viewThemeMode.intValue() == 2) ? R$drawable.mini_ic_unstable_network_normal_mode : R$drawable.mini_ic_unstable_network, R$string.mini_unstable_network_info, R$string.mini_unstable_network, bVar, true, true, aVar);
            }
        }

        public static /* synthetic */ void v(i iVar, StatusLayout.b bVar, int i11, String str, String str2, StatusLayout.a aVar, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showUnstableNetwork");
            }
            if ((i12 & 2) != 0) {
                i11 = R$string.loading_error_tv;
            }
            int i13 = i11;
            if ((i12 & 4) != 0) {
                str = "";
            }
            String str3 = str;
            if ((i12 & 16) != 0) {
                aVar = null;
            }
            iVar.showUnstableNetwork(bVar, i13, str3, str2, aVar);
        }

        public static void w(i iVar, String appId, Function3<? super String, ? super String, ? super String, Unit> function3) {
            Intrinsics.g(appId, "appId");
            if (iVar.getStatusLayout() != null) {
                Intrinsics.g(appId, "appId");
            }
        }

        public static void x(i iVar) {
            MiniNoNetworkView miniNoNetworkView;
            View view;
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout == null || (miniNoNetworkView = statusLayout.OooOOO0) == null || miniNoNetworkView.getVisibility() != 0) {
                return;
            }
            LinearLayout llOfflineApps = miniNoNetworkView.getLlOfflineApps();
            Intrinsics.g(miniNoNetworkView, "<this>");
            for (int i11 = 0; i11 < 4; i11++) {
                if (llOfflineApps != null) {
                    try {
                        view = ViewGroupKt.get(llOfflineApps, i11);
                    } catch (Throwable th2) {
                        TmcLogger.g("OfflineAppExtension", "offlineAppOnResume fail:", th2);
                        return;
                    }
                } else {
                    view = null;
                }
                OfflineAppView offlineAppView = view instanceof OfflineAppView ? (OfflineAppView) view : null;
                if (offlineAppView != null) {
                    offlineAppView.OooO00o(null, null);
                }
            }
        }

        public static void y(i iVar, LoadStepAction loadStep) {
            Intrinsics.g(loadStep, "step");
            StatusLayout statusLayout = iVar.getStatusLayout();
            if (statusLayout != null) {
                Intrinsics.g(loadStep, "step");
                LoadingTextView loadingTextView = statusLayout.f31867OooO0oo;
                if (loadingTextView != null) {
                    Intrinsics.g(loadStep, "loadStep");
                    TmcLogger.c(loadingTextView.OooO00o, loadStep.name() + " startTime: " + System.currentTimeMillis() + ",currentProgress:" + loadingTextView.f31827OooO0Oo);
                    switch (LoadingTextView.b.f31830a[loadStep.ordinal()]) {
                        case 1:
                            loadingTextView.OooO00o(0);
                            break;
                        case 2:
                            break;
                        case 3:
                            loadingTextView.OooO00o(loadingTextView.f31827OooO0Oo, loadingTextView.OooO0O0.getDownload(), loadingTextView.OooO0O0.getFirstDuration());
                            break;
                        case 4:
                            loadingTextView.OooO00o(loadingTextView.f31827OooO0Oo, loadingTextView.OooO0O0.getDecompress(), loadingTextView.OooO0O0.getSecondDuration());
                            break;
                        case 5:
                            loadingTextView.OooO00o(loadingTextView.f31827OooO0Oo, loadingTextView.OooO0O0.getCreatRender(), loadingTextView.OooO0O0.getSecondDuration());
                            break;
                        case 6:
                            loadingTextView.OooO00o(loadingTextView.f31827OooO0Oo, loadingTextView.OooO0O0.getLoadRender(), loadingTextView.OooO0O0.getSecondDuration());
                            break;
                        case 7:
                            loadingTextView.OooO00o(loadingTextView.f31827OooO0Oo, 100, loadingTextView.OooO0O0.getFinishAnimationDuration());
                            break;
                        default:
                            loadingTextView.OooO00o(loadingTextView.f31827OooO0Oo, 100, loadingTextView.OooO0O0.getFinishAnimationDuration());
                            break;
                    }
                }
            }
        }
    }

    StatusLayout getStatusLayout();

    Integer getViewThemeMode();

    void showError(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar);

    void showErrorLayout(int i11, @StringRes int i12, @StringRes int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar);

    void showErrorLayout(int i11, @StringRes int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar);

    void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar);

    void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar);

    void showNoNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar);

    void showUnstableNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar);
}
