package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OooO0OO extends RelativeLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public Page f31851OooO;
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f31852OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final IResourceProcessor f31853OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final Lazy f31854OooO0o0;
    public MiniAppConfigModel.TabBarBean OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public MiniAppConfigModel.TabBarBean.ListBean f31855OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public r0.a f31856OooOO0;
    public boolean OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public String f31857OooOO0o;

    /* JADX INFO: compiled from: source.java */
    @DebugMetadata(c = "com.cloud.tmc.miniapp.widget.TabBarItemView$requestDrawable$1", f = "TabBarView.kt", l = {}, m = "invokeSuspend")
    public static final class OooO extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ Function1<Drawable, Unit> f31858OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OooO(String str, String str2, Function1<? super Drawable, Unit> function1, Continuation<? super OooO> continuation) {
            super(2, continuation);
            this.OooO0O0 = str;
            this.OooO0OO = str2;
            this.f31858OooO0Oo = function1;
        }

        public static final void OooO00o(Function1 function1, File file) {
            if (function1 != null) {
                function1.invoke(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OooO0OO.this.new OooO(this.OooO0O0, this.OooO0OO, this.f31858OooO0Oo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return OooO0OO.this.new OooO(this.OooO0O0, this.OooO0OO, this.f31858OooO0Oo, continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final File file;
            kotlin.coroutines.intrinsics.a.e();
            ResultKt.b(obj);
            if (OooO0OO.this.f31857OooOO0o.length() > 0) {
                OooO0OO oooO0OO = OooO0OO.this;
                file = oooO0OO.f31853OooO0o.get(this.OooO0O0, this.OooO0OO, oooO0OO.f31857OooOO0o);
            } else {
                file = OooO0OO.this.f31853OooO0o.get(this.OooO0O0, this.OooO0OO);
            }
            AppCompatImageView ivTabIcon = OooO0OO.this.getIvTabIcon();
            final Function1<Drawable, Unit> function1 = this.f31858OooO0Oo;
            ivTabIcon.post(new Runnable() { // from class: com.cloud.tmc.miniapp.widget.r
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0OO.OooO.OooO00o(function1, file);
                }
            });
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<AppCompatImageView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooO0OO.this.findViewById(R$id.iv_badge);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooO0OO.this.findViewById(R$id.iv_red);
        }
    }

    /* JADX INFO: renamed from: com.cloud.tmc.miniapp.widget.OooO0OO$OooO0OO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0348OooO0OO extends Lambda implements Function0<AppCompatImageView> {
        public C0348OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooO0OO.this.findViewById(R$id.iv_red_icon);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<AppCompatImageView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooO0OO.this.findViewById(R$id.iv_tab_icon);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function1<Drawable, Unit> {
        public OooOO0() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Drawable drawable) {
            OooO0OO.this.getIvTabIcon().setImageDrawable(drawable);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<AppCompatTextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) OooO0OO.this.findViewById(R$id.tv_tab_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function1<Drawable, Unit> {
        public OooOOO0() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Drawable drawable) {
            OooO0OO.this.getIvTabIcon().setImageDrawable(drawable);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0OO(Context context, AttributeSet attributeSet) {
        super(context, null);
        Intrinsics.g(context, "context");
        this.OooO00o = LazyKt__LazyJVMKt.b(new OooO0o());
        this.OooO0O0 = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.OooO0OO = LazyKt__LazyJVMKt.b(new OooO0O0());
        this.f31852OooO0Oo = LazyKt__LazyJVMKt.b(new C0348OooO0OO());
        this.f31854OooO0o0 = LazyKt__LazyJVMKt.b(new OooO00o());
        Object objA = tc.a.a(IResourceProcessor.class);
        Intrinsics.f(objA, "get(\n        IResourceProcessor::class.java\n    )");
        this.f31853OooO0o = (IResourceProcessor) objA;
        LayoutInflater.from(context).inflate(R$layout.layout_mini_tab_item, this);
        setGravity(17);
        this.f31857OooOO0o = "";
    }

    private final AppCompatImageView getIvBadge() {
        Object value = this.f31854OooO0o0.getValue();
        Intrinsics.f(value, "<get-ivBadge>(...)");
        return (AppCompatImageView) value;
    }

    private final AppCompatImageView getIvRed() {
        Object value = this.OooO0OO.getValue();
        Intrinsics.f(value, "<get-ivRed>(...)");
        return (AppCompatImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvRedIcon() {
        Object value = this.f31852OooO0Oo.getValue();
        Intrinsics.f(value, "<get-ivRedIcon>(...)");
        return (AppCompatImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvTabIcon() {
        Object value = this.OooO00o.getValue();
        Intrinsics.f(value, "<get-ivTabIcon>(...)");
        return (AppCompatImageView) value;
    }

    private final AppCompatTextView getTvTabName() {
        Object value = this.OooO0O0.getValue();
        Intrinsics.f(value, "<get-tvTabName>(...)");
        return (AppCompatTextView) value;
    }

    public final void OooO00o() {
        r0.a aVar = this.f31856OooOO0;
        if (aVar != null) {
            ((OoooO00.OooOO0) aVar).OooO00o(0);
        }
        getIvBadge().setTag(Boolean.FALSE);
    }

    public final void OooO00o(MiniAppConfigModel.TabBarBean.ListBean tab, Page page) {
        String str;
        App app;
        Intrinsics.g(tab, "tab");
        MiniAppConfigModel.TabBarBean tabBarBean = this.OooO0oO;
        if (tabBarBean != null && tabBarBean.tabBarPositionIsTop()) {
            xb.i.c(getIvTabIcon());
            return;
        }
        String str2 = tab.selectedIconPath;
        if (str2 != null && str2.length() != 0 && (str = tab.iconPath) != null && str.length() != 0) {
            String appId = null;
            String str3 = Intrinsics.b(page != null ? page.getPagePath() : null, tab.pagePath) ? tab.selectedIconPath : tab.iconPath;
            if (page != null && (app = page.getApp()) != null) {
                appId = app.getAppId();
            }
            OooO00o(str3, appId, new OooOOO0());
        }
        String str4 = tab.text;
        if (str4 != null) {
            getTvTabName().setText(str4);
        }
    }

    public final void OooO00o(MiniAppConfigModel.TabBarBean tabBarConfig, MiniAppConfigModel.TabBarBean.ListBean tab, Page page) {
        App app;
        Intrinsics.g(tabBarConfig, "tabBarConfig");
        Intrinsics.g(tab, "tab");
        this.OooO0oO = tabBarConfig;
        this.f31855OooO0oo = tab;
        this.f31851OooO = page;
        String appId = null;
        this.OooOO0O = Intrinsics.b(page != null ? page.getPagePath() : null, tab.pagePath);
        if (tabBarConfig.tabBarPositionIsTop()) {
            xb.i.c(getIvTabIcon());
        } else {
            String str = this.OooOO0O ? tab.selectedIconPath : tab.iconPath;
            if (page != null && (app = page.getApp()) != null) {
                appId = app.getAppId();
            }
            OooO00o(str, appId, new OooOO0());
        }
        getTvTabName().setText(tab.text);
        OooO00o(this.OooOO0O ? tabBarConfig.getSelectedColor() : tabBarConfig.getColor());
    }

    public final void OooO00o(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return;
                }
                getTvTabName().setTextColor(Color.parseColor(str));
            } catch (Exception e11) {
                TmcLogger.h("[TabBarItemView]: set tab item text color error", e11);
            }
        }
    }

    public final void OooO00o(String str, String str2, Function1<? super Drawable, Unit> function1) {
        if (str == null || str.length() == 0) {
            function1.invoke(null);
        } else if (i0.b(str) && !StringsKt__StringsKt.Q(str, ".miniapp.transsion.com", false, 2, null)) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new OooO(str, str2, function1, null), 3, null);
        } else {
            File file = this.f31857OooOO0o.length() > 0 ? this.f31853OooO0o.get(str, str2, this.f31857OooOO0o) : this.f31853OooO0o.get(str, str2);
            function1.invoke(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
        }
    }

    public final Page getPage() {
        return this.f31851OooO;
    }

    public final MiniAppConfigModel.TabBarBean getTabBarConfig() {
        return this.OooO0oO;
    }

    public final MiniAppConfigModel.TabBarBean.ListBean getTabBarList() {
        return this.f31855OooO0oo;
    }

    public final boolean getTabSelected() {
        return this.OooOO0O;
    }

    public final void setCommonresId(String id2) {
        Intrinsics.g(id2, "id");
        this.f31857OooOO0o = id2;
    }

    public final void setPage(Page page) {
        this.f31851OooO = page;
    }

    public final void setTabBarBadge(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (this.f31856OooOO0 == null) {
            OoooO00.OooOO0 oooOO0 = (OoooO00.OooOO0) new OoooO00.OooOO0(getContext(), null).OooO00o(getIvBadge());
            oooOO0.f272OooO0oo = 8388627;
            oooOO0.invalidate();
            oooOO0.OooO0OO = r0.c.a(oooOO0.getContext(), 8.0f);
            oooOO0.OooO0OO();
            oooOO0.invalidate();
            oooOO0.f269OooO0Oo = r0.c.a(oooOO0.getContext(), 2.0f);
            oooOO0.invalidate();
            oooOO0.f268OooO = r0.c.a(oooOO0.getContext(), 0.0f);
            oooOO0.f273OooOO0 = r0.c.a(oooOO0.getContext(), 0.0f);
            oooOO0.invalidate();
            oooOO0.OooO0oO = false;
            oooOO0.invalidate();
            this.f31856OooOO0 = oooOO0;
        }
        if (xb.i.a(getIvRed())) {
            setUnreadVisible(false);
        }
        if (xb.i.a(getIvRedIcon())) {
            setUnreadIconVisible(false);
        }
        byte[] bytes = str.getBytes(Charsets.f69091b);
        Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
        int i11 = new Regex(".*[\\u4e00-\\u9fa5]+.*").matches(str) ? 6 : 4;
        r0.a aVar = this.f31856OooOO0;
        if (aVar != null) {
            if (bytes.length > i11) {
                str = "...";
            }
            OoooO00.OooOO0 oooOO1 = (OoooO00.OooOO0) aVar;
            oooOO1.f270OooO0o = str;
            oooOO1.f271OooO0o0 = 1;
            oooOO1.OooO0OO();
            oooOO1.invalidate();
        }
        getIvBadge().setTag(Boolean.TRUE);
    }

    public final void setTabBarConfig(MiniAppConfigModel.TabBarBean tabBarBean) {
        this.OooO0oO = tabBarBean;
    }

    public final void setTabBarList(MiniAppConfigModel.TabBarBean.ListBean listBean) {
        this.f31855OooO0oo = listBean;
    }

    public final void setTabSelected(boolean z11) {
        this.OooOO0O = z11;
    }

    public final void setUnreadIconVisible(boolean z11) {
        if (z11 && Intrinsics.b(getIvBadge().getTag(), Boolean.TRUE)) {
            OooO00o();
        }
        xb.i.g(getIvRedIcon(), z11);
    }

    public final void setUnreadVisible(boolean z11) {
        if (z11 && Intrinsics.b(getIvBadge().getTag(), Boolean.TRUE)) {
            OooO00o();
        }
        xb.i.g(getIvRed(), z11);
    }
}
