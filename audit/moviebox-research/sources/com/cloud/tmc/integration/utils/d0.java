package com.cloud.tmc.integration.utils;

import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.AppLoadResult;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f31040a = new d0();

    @JvmStatic
    public static final MiniAppConfigModel.TabBarBean c(MiniAppConfigModel.TabBarBean tabBarBean) {
        d0 d0Var = f31040a;
        MiniAppConfigModel.TabBarBean tabBarBeanA = d0Var.a();
        if (tabBarBean != null) {
            d0Var.h(tabBarBeanA, tabBarBean);
        }
        return tabBarBeanA;
    }

    @JvmStatic
    public static final MiniAppConfigModel.TabBarBean d(AppLoadResult appLoadResult) {
        MiniAppConfigModel miniAppConfigModel;
        return c((appLoadResult == null || (miniAppConfigModel = appLoadResult.appConfigModel) == null) ? null : miniAppConfigModel.tabBar);
    }

    @JvmStatic
    public static final MiniAppConfigModel.WindowBean e(MiniAppConfigModel.WindowBean windowBean, MiniAppConfigModel.WindowBean windowBean2) {
        d0 d0Var = f31040a;
        MiniAppConfigModel.WindowBean windowBeanB = d0Var.b();
        if (windowBean != null) {
            d0Var.i(windowBeanB, windowBean);
        }
        if (windowBean2 != null) {
            d0Var.i(windowBeanB, windowBean2);
        }
        return windowBeanB;
    }

    @JvmStatic
    public static final MiniAppConfigModel.WindowBean f(AppLoadResult appLoadResult, String str) {
        MiniAppConfigModel miniAppConfigModel;
        HashMap<String, MiniAppConfigModel.PagesBean> map;
        if (appLoadResult != null) {
            try {
                miniAppConfigModel = appLoadResult.appConfigModel;
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        } else {
            miniAppConfigModel = null;
        }
        MiniAppConfigModel.WindowBean window = miniAppConfigModel != null ? miniAppConfigModel.getWindow() : null;
        MiniAppConfigModel.PagesBean pagesBean = (miniAppConfigModel == null || (map = miniAppConfigModel.launchParams) == null) ? null : map.get(com.cloud.tmc.kernel.utils.r.i(str));
        return e(window, pagesBean != null ? pagesBean.getWindow() : null);
    }

    @JvmStatic
    public static final int g(String action) {
        Intrinsics.g(action, "action");
        if (Intrinsics.b(action, "back")) {
            return 1;
        }
        return Intrinsics.b(action, "all") ? 2 : 0;
    }

    public final MiniAppConfigModel.TabBarBean a() {
        MiniAppConfigModel.TabBarBean tabBarBean = new MiniAppConfigModel.TabBarBean();
        tabBarBean.setBorderStyle("black");
        tabBarBean.setPosition("bottom");
        tabBarBean.setCustom(Boolean.FALSE);
        return tabBarBean;
    }

    public final MiniAppConfigModel.WindowBean b() {
        MiniAppConfigModel.WindowBean windowBean = new MiniAppConfigModel.WindowBean();
        Boolean bool = Boolean.FALSE;
        windowBean.setEnablePullDownRefresh(bool);
        windowBean.setEnablePullUpRefresh(bool);
        windowBean.setRefreshHeaderStyle(TmcEngineFactory.ENGINE_TYPE_DEFAULT);
        Boolean bool2 = Boolean.TRUE;
        windowBean.setRefreshHeaderCustomTextEnable(bool2);
        windowBean.setRefreshHeaderTranslationContent(bool2);
        windowBean.setEnableTransparentStatusBar(bool);
        windowBean.setEnableNavigationBarLoading(bool2);
        windowBean.setNavigationStyle(TmcEngineFactory.ENGINE_TYPE_DEFAULT);
        windowBean.setNavigationBarBackgroundColor("#ffffff");
        windowBean.setNavigationBarTextStyle("black");
        windowBean.setNavigationBarIconStyle("black");
        windowBean.setNavigationBarHomeAction("home");
        windowBean.setHandleWebviewPreload("manual");
        windowBean.setEnablePageLoading(bool);
        windowBean.setEnableTabBarAdjustPan(bool);
        windowBean.setLimitTextZoom(bool);
        return windowBean;
    }

    public final void h(MiniAppConfigModel.TabBarBean tabBarBean, MiniAppConfigModel.TabBarBean tabBarBean2) {
        String strC = xb.e.c(tabBarBean2.getColor());
        if (strC != null) {
            tabBarBean.setColor(strC);
        }
        String strC2 = xb.e.c(tabBarBean2.getSelectedColor());
        if (strC2 != null) {
            tabBarBean.setSelectedColor(strC2);
        }
        String strC3 = xb.e.c(tabBarBean2.getBackgroundColor());
        if (strC3 != null) {
            tabBarBean.setBackgroundColor(strC3);
        }
        String strC4 = xb.e.c(tabBarBean2.getBorderStyle());
        if (strC4 != null) {
            tabBarBean.setBorderStyle(strC4);
        }
        List<MiniAppConfigModel.TabBarBean.ListBean> list = tabBarBean2.list;
        if (list != null) {
            tabBarBean.list = list;
        }
        String strC5 = xb.e.c(tabBarBean2.getPosition());
        if (strC5 != null) {
            tabBarBean.setPosition(strC5);
        }
        Boolean custom = tabBarBean2.getCustom();
        if (custom != null) {
            custom.booleanValue();
            tabBarBean.setCustom(tabBarBean2.getCustom());
        }
    }

    public final MiniAppConfigModel.WindowBean i(MiniAppConfigModel.WindowBean windowBean, MiniAppConfigModel.WindowBean windowBean2) {
        Boolean enablePullDownRefresh = windowBean2.getEnablePullDownRefresh();
        if (enablePullDownRefresh != null) {
            windowBean.setEnablePullDownRefresh(Boolean.valueOf(enablePullDownRefresh.booleanValue()));
        }
        Boolean enablePullUpRefresh = windowBean2.getEnablePullUpRefresh();
        if (enablePullUpRefresh != null) {
            windowBean.setEnablePullUpRefresh(Boolean.valueOf(enablePullUpRefresh.booleanValue()));
        }
        Boolean enableTransparentStatusBar = windowBean2.getEnableTransparentStatusBar();
        if (enableTransparentStatusBar != null) {
            windowBean.setEnableTransparentStatusBar(Boolean.valueOf(enableTransparentStatusBar.booleanValue()));
        }
        Boolean enableNavigationBarLoading = windowBean2.getEnableNavigationBarLoading();
        if (enableNavigationBarLoading != null) {
            windowBean.setEnableNavigationBarLoading(Boolean.valueOf(enableNavigationBarLoading.booleanValue()));
        }
        String navigationBarTitleText = windowBean2.getNavigationBarTitleText();
        if (navigationBarTitleText != null) {
            windowBean.setNavigationBarTitleText(navigationBarTitleText);
        }
        String navigationStyle = windowBean2.getNavigationStyle();
        if (navigationStyle != null) {
            windowBean.setNavigationStyle(navigationStyle);
        }
        String navigationBarBackgroundColor = windowBean2.getNavigationBarBackgroundColor();
        if (navigationBarBackgroundColor != null) {
            windowBean.setNavigationBarBackgroundColor(navigationBarBackgroundColor);
        }
        String navigationBarTextStyle = windowBean2.getNavigationBarTextStyle();
        if (navigationBarTextStyle != null) {
            windowBean.setNavigationBarTextStyle(navigationBarTextStyle);
        }
        String navigationBarIconStyle = windowBean2.getNavigationBarIconStyle();
        if (navigationBarIconStyle != null) {
            windowBean.setNavigationBarIconStyle(navigationBarIconStyle);
        }
        String navigationBarHomeAction = windowBean2.getNavigationBarHomeAction();
        if (navigationBarHomeAction != null) {
            windowBean.setNavigationBarHomeAction(navigationBarHomeAction);
        }
        String refreshHeaderStyle = windowBean2.getRefreshHeaderStyle();
        if (refreshHeaderStyle != null) {
            windowBean.setRefreshHeaderStyle(refreshHeaderStyle);
        }
        Boolean refreshHeaderCustomTextEnable = windowBean2.getRefreshHeaderCustomTextEnable();
        if (refreshHeaderCustomTextEnable != null) {
            windowBean.setRefreshHeaderCustomTextEnable(Boolean.valueOf(refreshHeaderCustomTextEnable.booleanValue()));
        }
        String refreshHeaderCustomLoading = windowBean2.getRefreshHeaderCustomLoading();
        if (refreshHeaderCustomLoading != null) {
            windowBean.setRefreshHeaderCustomLoading(refreshHeaderCustomLoading);
        }
        String refreshHeaderCustomLoadingGif = windowBean2.getRefreshHeaderCustomLoadingGif();
        if (refreshHeaderCustomLoadingGif != null) {
            windowBean.setRefreshHeaderCustomLoadingGif(refreshHeaderCustomLoadingGif);
        }
        String refreshHeaderCustomSuccess = windowBean2.getRefreshHeaderCustomSuccess();
        if (refreshHeaderCustomSuccess != null) {
            windowBean.setRefreshHeaderCustomSuccess(refreshHeaderCustomSuccess);
        }
        String refreshHeaderCustomSuccessGif = windowBean2.getRefreshHeaderCustomSuccessGif();
        if (refreshHeaderCustomSuccessGif != null) {
            windowBean.setRefreshHeaderCustomSuccessGif(refreshHeaderCustomSuccessGif);
        }
        Boolean refreshHeaderTranslationContent = windowBean2.getRefreshHeaderTranslationContent();
        if (refreshHeaderTranslationContent != null) {
            windowBean.setRefreshHeaderTranslationContent(Boolean.valueOf(refreshHeaderTranslationContent.booleanValue()));
        }
        String refreshHeaderAccentColor = windowBean2.getRefreshHeaderAccentColor();
        if (refreshHeaderAccentColor != null) {
            windowBean.setRefreshHeaderAccentColor(refreshHeaderAccentColor);
        }
        String refreshHeaderBackgroundColor = windowBean2.getRefreshHeaderBackgroundColor();
        if (refreshHeaderBackgroundColor != null) {
            windowBean.setRefreshHeaderBackgroundColor(refreshHeaderBackgroundColor);
        }
        Integer refreshHeaderDelayed = windowBean2.getRefreshHeaderDelayed();
        if (refreshHeaderDelayed != null) {
            windowBean.setRefreshHeaderDelayed(Integer.valueOf(refreshHeaderDelayed.intValue()));
        }
        String refreshFooterAccentColor = windowBean2.getRefreshFooterAccentColor();
        if (refreshFooterAccentColor != null) {
            windowBean.setRefreshFooterAccentColor(refreshFooterAccentColor);
        }
        String refreshFooterBackgroundColor = windowBean2.getRefreshFooterBackgroundColor();
        if (refreshFooterBackgroundColor != null) {
            windowBean.setRefreshFooterBackgroundColor(refreshFooterBackgroundColor);
        }
        Integer refreshFooterDelayed = windowBean2.getRefreshFooterDelayed();
        if (refreshFooterDelayed != null) {
            windowBean.setRefreshFooterDelayed(Integer.valueOf(refreshFooterDelayed.intValue()));
        }
        String contentBackgroundColor = windowBean2.getContentBackgroundColor();
        if (contentBackgroundColor != null) {
            windowBean.setContentBackgroundColor(contentBackgroundColor);
        }
        String handleWebviewPreload = windowBean2.getHandleWebviewPreload();
        if (handleWebviewPreload != null) {
            windowBean.setHandleWebviewPreload(handleWebviewPreload);
        }
        Boolean enablePageLoading = windowBean2.getEnablePageLoading();
        if (enablePageLoading != null) {
            windowBean.setEnablePageLoading(Boolean.valueOf(enablePageLoading.booleanValue()));
        }
        Boolean enableTabBarAdjustPan = windowBean2.getEnableTabBarAdjustPan();
        if (enableTabBarAdjustPan != null) {
            windowBean.setEnableTabBarAdjustPan(Boolean.valueOf(enableTabBarAdjustPan.booleanValue()));
        }
        String darkModeNavigationBarBackgroundColor = windowBean2.getDarkModeNavigationBarBackgroundColor();
        if (darkModeNavigationBarBackgroundColor != null) {
            windowBean.setDarkModeNavigationBarBackgroundColor(darkModeNavigationBarBackgroundColor);
        }
        String darkModeNavigationBarTextStyle = windowBean2.getDarkModeNavigationBarTextStyle();
        if (darkModeNavigationBarTextStyle != null) {
            windowBean.setDarkModeNavigationBarTextStyle(darkModeNavigationBarTextStyle);
        }
        String darkModeNavigationBarIconStyle = windowBean2.getDarkModeNavigationBarIconStyle();
        if (darkModeNavigationBarIconStyle != null) {
            windowBean.setDarkModeNavigationBarIconStyle(darkModeNavigationBarIconStyle);
        }
        String darkModeContentBackgroundColor = windowBean2.getDarkModeContentBackgroundColor();
        if (darkModeContentBackgroundColor != null) {
            windowBean.setDarkModeContentBackgroundColor(darkModeContentBackgroundColor);
        }
        Boolean limitTextZoom = windowBean2.getLimitTextZoom();
        if (limitTextZoom != null) {
            windowBean.setLimitTextZoom(Boolean.valueOf(limitTextZoom.booleanValue()));
        }
        return windowBean;
    }
}
