package com.cloud.tmc.integration.ui.p000native;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.cloud.tmc.integration.R$id;
import com.cloud.tmc.integration.R$layout;
import com.cloud.tmc.integration.ui.data.NativeTabBean;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class NativeTabView extends FrameLayout {
    public static final b Companion = new b(null);
    public static final String ERROR = "error";
    public static final String ERROR_MSG_T10001 = "Parameter error: T10001";
    public static final String ERROR_MSG_T10002 = "parse Json error, please check the config: T10002";
    public static final String EVENT_SELECTED = "nativeTabSelected";
    public static final String TAG = "NativeTabView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f30964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.cloud.tmc.integration.ui.p000native.a f30965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GradientDrawable f30966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30967d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f30968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f30969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f30970h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[NativeTabView]: onTabReselected:");
            sb2.append(tab != null ? Integer.valueOf(tab.getPosition()) : null);
            sb2.append(", from:");
            sb2.append(tab);
            TmcLogger.c(NativeTabView.TAG, sb2.toString());
            View customView = tab != null ? tab.getCustomView() : null;
            TextView textView = customView instanceof TextView ? (TextView) customView : null;
            if (textView != null) {
                textView.setTextColor(NativeTabView.this.f30968f);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[NativeTabView]: onTabSelected:");
            sb2.append(tab != null ? Integer.valueOf(tab.getPosition()) : null);
            sb2.append(", from::");
            sb2.append(tab);
            TmcLogger.c(NativeTabView.TAG, sb2.toString());
            View customView = tab != null ? tab.getCustomView() : null;
            TextView textView = customView instanceof TextView ? (TextView) customView : null;
            if (textView != null) {
                textView.setTextColor(NativeTabView.this.f30968f);
            }
            JsonObject jsonObject = new JsonObject();
            boolean z11 = false;
            jsonObject.addProperty("index", Integer.valueOf(tab != null ? tab.getPosition() : 0));
            if (NativeTabView.this.f30970h) {
                NativeTabView.this.f30970h = false;
                z11 = true;
            }
            jsonObject.addProperty("isApiControl", Boolean.valueOf(z11));
            com.cloud.tmc.integration.ui.p000native.a aVar = NativeTabView.this.f30965b;
            if (aVar != null) {
                aVar.a(NativeTabView.EVENT_SELECTED, jsonObject);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[NativeTabView]: onTabUnselected:");
            sb2.append(tab != null ? Integer.valueOf(tab.getPosition()) : null);
            sb2.append(", from::");
            sb2.append(tab);
            TmcLogger.c(NativeTabView.TAG, sb2.toString());
            View customView = tab != null ? tab.getCustomView() : null;
            TextView textView = customView instanceof TextView ? (TextView) customView : null;
            if (textView != null) {
                textView.setTextColor(NativeTabView.this.f30967d);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f30964a = LazyKt__LazyJVMKt.b(new Function0<TabLayout>() { // from class: com.cloud.tmc.integration.ui.native.NativeTabView$tabLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TabLayout invoke() {
                return (TabLayout) this.this$0.findViewById(R$id.mini_native_tab);
            }
        });
        this.f30967d = -1;
        this.f30968f = ViewCompat.MEASURED_STATE_MASK;
        LayoutInflater.from(context).inflate(R$layout.mini_native_tab_layout, this);
        Drawable background = getTabLayout().getBackground();
        this.f30966c = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        getTabLayout().addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
    }

    public /* synthetic */ NativeTabView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final TabLayout getTabLayout() {
        Object value = this.f30964a.getValue();
        Intrinsics.f(value, "<get-tabLayout>(...)");
        return (TabLayout) value;
    }

    public final void addNativeTabListener(com.cloud.tmc.integration.ui.p000native.a aVar) {
        this.f30965b = aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public final void removeNativeTabListener(com.cloud.tmc.integration.ui.p000native.a aVar) {
        this.f30965b = null;
    }

    public final void setTabStyle(NativeTabBean data) {
        GradientDrawable gradientDrawable;
        Intrinsics.g(data, "data");
        TmcLogger.f(TAG, "setTabStyle =" + data);
        String color = data.getColor();
        if (color != null && color.length() != 0) {
            this.f30967d = Color.parseColor(data.getColor());
        }
        String selectedColor = data.getSelectedColor();
        if (selectedColor != null && selectedColor.length() != 0) {
            this.f30968f = Color.parseColor(data.getSelectedColor());
        }
        String backgroundColor = data.getBackgroundColor();
        if (backgroundColor != null && backgroundColor.length() != 0 && (gradientDrawable = this.f30966c) != null) {
            gradientDrawable.setColor(Color.parseColor(data.getBackgroundColor()));
        }
        String selectBackgroundColor = data.getSelectBackgroundColor();
        if (selectBackgroundColor != null && selectBackgroundColor.length() != 0) {
            getTabLayout().setSelectedTabIndicatorColor(Color.parseColor(data.getSelectBackgroundColor()));
        }
        String selectBackgroundColor2 = data.getSelectBackgroundColor();
        if (selectBackgroundColor2 != null && selectBackgroundColor2.length() != 0) {
            getTabLayout().setSelectedTabIndicatorColor(Color.parseColor(data.getSelectBackgroundColor()));
        }
        List<String> tabList = data.getTabList();
        if (tabList == null || tabList.size() < 2 || tabList.size() > 5) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("tab list is invalid. count = ");
            sb2.append(tabList != null ? tabList.size() : 0);
            TmcLogger.f(TAG, sb2.toString());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", ERROR_MSG_T10001);
            com.cloud.tmc.integration.ui.p000native.a aVar = this.f30965b;
            if (aVar != null) {
                aVar.a("error", jsonObject);
                return;
            }
            return;
        }
        String string = tabList.toString();
        List<String> list = this.f30969g;
        if (Intrinsics.b(string, list != null ? list.toString() : null)) {
            TmcLogger.f(TAG, "tab list not changed list = " + tabList);
            return;
        }
        int selectedIndex = (data.getSelectedIndex() == -1 || data.getSelectedIndex() >= tabList.size()) ? 0 : data.getSelectedIndex();
        this.f30969g = tabList;
        getTabLayout().removeAllTabs();
        int size = tabList.size();
        int i11 = 0;
        while (i11 < size) {
            TextView textView = new TextView(getContext());
            textView.setText(tabList.get(i11));
            textView.setGravity(17);
            textView.setTextSize(14.0f);
            if (i11 == selectedIndex) {
                textView.setTextColor(this.f30968f);
            } else {
                textView.setTextColor(this.f30967d);
            }
            getTabLayout().addTab(getTabLayout().newTab().setCustomView(textView), i11 == selectedIndex);
            i11++;
        }
    }

    public final void switchTab(int i11) {
        TabLayout.Tab tabAt;
        List<String> list = this.f30969g;
        int size = list != null ? list.size() : 0;
        if (i11 < 0 || i11 >= size || (tabAt = getTabLayout().getTabAt(i11)) == null) {
            return;
        }
        this.f30970h = true;
        tabAt.select();
    }
}
