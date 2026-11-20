package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.miniutils.util.f;
import com.cloud.tmc.miniutils.util.z;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import rc.b;

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
@SourceDebugExtension
public final class MiniAppConfigModel extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private String handleTabBarLoad;

    @JvmField
    public String iconFile;
    private String includeFiles;

    @JvmField
    public HashMap<String, PagesBean> launchParams;
    private String mfah;

    @JvmField
    public List<String> pages;

    @JvmField
    public HashMap<String, PreloadRuleSubpackage> preloadRule;

    @JvmField
    public List<Subpackage> subPackages;

    @JvmField
    public TabBarBean tabBar;
    private WindowBean window;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class PagesBean extends b implements Serializable, Parcelable {
        public static final a CREATOR = new a(null);
        private WindowBean window;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements Parcelable.Creator<PagesBean> {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PagesBean createFromParcel(Parcel parcel) {
                Intrinsics.g(parcel, "parcel");
                return new PagesBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public PagesBean[] newArray(int i11) {
                return new PagesBean[i11];
            }
        }

        public PagesBean() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PagesBean(Parcel parcel) {
            this();
            Intrinsics.g(parcel, "parcel");
            this.window = (WindowBean) parcel.readParcelable(WindowBean.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final WindowBean getWindow() {
            return this.window;
        }

        public final void setWindow(WindowBean windowBean) {
            this.window = windowBean;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            Intrinsics.g(parcel, "parcel");
            parcel.writeParcelable(this.window, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class TabBarBean extends b implements Serializable, Parcelable {
        public static final a CREATOR = new a(null);
        private String backgroundColor;
        private String borderStyle;
        private String color;
        private Boolean custom;

        @JvmField
        public List<ListBean> list;
        private String position;
        private String selectedColor;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class ListBean extends b implements Serializable, Parcelable {
            public static final a CREATOR = new a(null);

            @JvmField
            public String iconPath;

            @JvmField
            public String pagePath;

            @JvmField
            public String selectedIconPath;

            @JvmField
            public String text;

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class a implements Parcelable.Creator<ListBean> {
                public a() {
                }

                public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public ListBean createFromParcel(Parcel parcel) {
                    Intrinsics.g(parcel, "parcel");
                    return new ListBean(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public ListBean[] newArray(int i11) {
                    return new ListBean[i11];
                }
            }

            public ListBean() {
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public ListBean(Parcel parcel) {
                this();
                Intrinsics.g(parcel, "parcel");
                this.pagePath = parcel.readString();
                this.text = parcel.readString();
                this.iconPath = parcel.readString();
                this.selectedIconPath = parcel.readString();
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || !Intrinsics.b(ListBean.class, obj.getClass())) {
                    return false;
                }
                ListBean listBean = (ListBean) obj;
                return Intrinsics.b(this.pagePath, listBean.pagePath) && Intrinsics.b(this.text, listBean.text) && Intrinsics.b(this.iconPath, listBean.iconPath) && Intrinsics.b(this.selectedIconPath, listBean.selectedIconPath);
            }

            public int hashCode() {
                return Objects.hash(this.pagePath, this.text, this.iconPath, this.selectedIconPath);
            }

            public String toString() {
                return "ListBean(pagePath=" + this.pagePath + ", text=" + this.text + ", iconPath=" + this.iconPath + ", selectedIconPath=" + this.selectedIconPath + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i11) {
                Intrinsics.g(parcel, "parcel");
                parcel.writeString(this.pagePath);
                parcel.writeString(this.text);
                parcel.writeString(this.iconPath);
                parcel.writeString(this.selectedIconPath);
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements Parcelable.Creator<TabBarBean> {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TabBarBean createFromParcel(Parcel parcel) {
                Intrinsics.g(parcel, "parcel");
                return new TabBarBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public TabBarBean[] newArray(int i11) {
                return new TabBarBean[i11];
            }
        }

        public TabBarBean() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TabBarBean(Parcel parcel) {
            this();
            Intrinsics.g(parcel, "parcel");
            this.color = parcel.readString();
            this.selectedColor = parcel.readString();
            this.backgroundColor = parcel.readString();
            this.borderStyle = parcel.readString();
            this.list = parcel.createTypedArrayList(ListBean.CREATOR);
            this.position = parcel.readString();
            Object value = parcel.readValue(Boolean.TYPE.getClassLoader());
            this.custom = value instanceof Boolean ? (Boolean) value : null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.b(TabBarBean.class, obj.getClass())) {
                return false;
            }
            TabBarBean tabBarBean = (TabBarBean) obj;
            return Intrinsics.b(this.color, tabBarBean.color) && Intrinsics.b(this.selectedColor, tabBarBean.selectedColor) && Intrinsics.b(this.backgroundColor, tabBarBean.backgroundColor) && Intrinsics.b(this.borderStyle, tabBarBean.borderStyle) && Intrinsics.b(this.position, tabBarBean.position) && Intrinsics.b(this.custom, tabBarBean.custom) && Intrinsics.b(this.list, tabBarBean.list);
        }

        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        public final String getBorderStyle() {
            return this.borderStyle;
        }

        public final String getColor() {
            return this.color;
        }

        public final Boolean getCustom() {
            return this.custom;
        }

        public final String getPosition() {
            return this.position;
        }

        public final String getSelectedColor() {
            return this.selectedColor;
        }

        public int hashCode() {
            Object[] objArr = new Object[7];
            objArr[0] = this.color;
            objArr[1] = this.selectedColor;
            objArr[2] = this.backgroundColor;
            objArr[3] = this.borderStyle;
            objArr[4] = this.position;
            objArr[5] = this.custom;
            List<ListBean> list = this.list;
            objArr[6] = list != null ? list.toString() : null;
            return Objects.hash(objArr);
        }

        public final void setBackgroundColor(String str) {
            this.backgroundColor = str;
        }

        public final void setBorderStyle(String str) {
            this.borderStyle = str;
        }

        public final void setColor(String str) {
            this.color = str;
        }

        public final void setCustom(Boolean bool) {
            this.custom = bool;
        }

        public final void setPosition(String str) {
            this.position = str;
        }

        public final void setSelectedColor(String str) {
            this.selectedColor = str;
        }

        public final boolean tabBarBorderStyleIsWhite() {
            return Intrinsics.b("white", this.borderStyle);
        }

        public final boolean tabBarCustom() {
            return Intrinsics.b(Boolean.TRUE, this.custom);
        }

        public final boolean tabBarPositionIsTop() {
            return Intrinsics.b("top", this.position);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            Intrinsics.g(parcel, "parcel");
            parcel.writeString(this.color);
            parcel.writeString(this.selectedColor);
            parcel.writeString(this.backgroundColor);
            parcel.writeString(this.borderStyle);
            parcel.writeTypedList(this.list);
            parcel.writeString(this.position);
            parcel.writeValue(this.custom);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class WindowBean extends b implements Serializable, Parcelable {
        public static final a CREATOR = new a(null);
        private String contentBackgroundColor;
        private String darkModeContentBackgroundColor;
        private String darkModeNavigationBarBackgroundColor;
        private String darkModeNavigationBarIconStyle;
        private String darkModeNavigationBarTextStyle;
        private Boolean enableNavigationBarLoading;
        private Boolean enablePageLoading;
        private Boolean enablePullDownRefresh;
        private Boolean enablePullUpRefresh;
        private Boolean enableTabBarAdjustPan;
        private Boolean enableTransparentStatusBar;
        private String handleWebviewPreload;
        private Boolean limitTextZoom;
        private String navigationBarBackgroundColor;
        private String navigationBarHomeAction;
        private String navigationBarIconStyle;
        private String navigationBarTextStyle;
        private String navigationBarTitleText;
        private String navigationStyle;
        private String refreshFooterAccentColor;
        private String refreshFooterBackgroundColor;
        private Integer refreshFooterDelayed;
        private String refreshHeaderAccentColor;
        private String refreshHeaderBackgroundColor;
        private String refreshHeaderCustomLoading;
        private String refreshHeaderCustomLoadingGif;
        private String refreshHeaderCustomSuccess;
        private String refreshHeaderCustomSuccessGif;
        private Boolean refreshHeaderCustomTextEnable;
        private Integer refreshHeaderDelayed;
        private String refreshHeaderStyle;
        private Boolean refreshHeaderTranslationContent;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements Parcelable.Creator<WindowBean> {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WindowBean createFromParcel(Parcel parcel) {
                Intrinsics.g(parcel, "parcel");
                return new WindowBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public WindowBean[] newArray(int i11) {
                return new WindowBean[i11];
            }
        }

        public WindowBean() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public WindowBean(Parcel parcel) {
            this();
            Intrinsics.g(parcel, "parcel");
            Class cls = Boolean.TYPE;
            Object value = parcel.readValue(cls.getClassLoader());
            this.enablePullDownRefresh = value instanceof Boolean ? (Boolean) value : null;
            Object value2 = parcel.readValue(cls.getClassLoader());
            this.enablePullUpRefresh = value2 instanceof Boolean ? (Boolean) value2 : null;
            Object value3 = parcel.readValue(cls.getClassLoader());
            this.enableTransparentStatusBar = value3 instanceof Boolean ? (Boolean) value3 : null;
            Object value4 = parcel.readValue(cls.getClassLoader());
            this.enableNavigationBarLoading = value4 instanceof Boolean ? (Boolean) value4 : null;
            this.navigationBarTitleText = parcel.readString();
            this.navigationStyle = parcel.readString();
            this.navigationBarBackgroundColor = parcel.readString();
            this.navigationBarTextStyle = parcel.readString();
            this.navigationBarIconStyle = parcel.readString();
            this.navigationBarHomeAction = parcel.readString();
            this.refreshHeaderStyle = parcel.readString();
            Object value5 = parcel.readValue(cls.getClassLoader());
            this.refreshHeaderCustomTextEnable = value5 instanceof Boolean ? (Boolean) value5 : null;
            this.refreshHeaderCustomLoading = parcel.readString();
            this.refreshHeaderCustomLoadingGif = parcel.readString();
            this.refreshHeaderCustomSuccess = parcel.readString();
            this.refreshHeaderCustomSuccessGif = parcel.readString();
            Object value6 = parcel.readValue(cls.getClassLoader());
            this.refreshHeaderTranslationContent = value6 instanceof Boolean ? (Boolean) value6 : null;
            this.refreshHeaderAccentColor = parcel.readString();
            this.refreshHeaderBackgroundColor = parcel.readString();
            Class cls2 = Integer.TYPE;
            Object value7 = parcel.readValue(cls2.getClassLoader());
            this.refreshHeaderDelayed = value7 instanceof Integer ? (Integer) value7 : null;
            this.refreshFooterAccentColor = parcel.readString();
            this.refreshFooterBackgroundColor = parcel.readString();
            Object value8 = parcel.readValue(cls2.getClassLoader());
            this.refreshFooterDelayed = value8 instanceof Integer ? (Integer) value8 : null;
            this.contentBackgroundColor = parcel.readString();
            this.handleWebviewPreload = parcel.readString();
            Object value9 = parcel.readValue(cls.getClassLoader());
            this.enablePageLoading = value9 instanceof Boolean ? (Boolean) value9 : null;
            Object value10 = parcel.readValue(cls.getClassLoader());
            this.enableTabBarAdjustPan = value10 instanceof Boolean ? (Boolean) value10 : null;
            this.darkModeNavigationBarBackgroundColor = parcel.readString();
            this.darkModeNavigationBarTextStyle = parcel.readString();
            this.darkModeNavigationBarIconStyle = parcel.readString();
            this.darkModeContentBackgroundColor = parcel.readString();
            Object value11 = parcel.readValue(cls.getClassLoader());
            this.limitTextZoom = value11 instanceof Boolean ? (Boolean) value11 : null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getContentBackgroundColor() {
            return this.contentBackgroundColor;
        }

        public final String getContentBgColor() {
            try {
                return (!z.a(((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext()) || f.a(this.darkModeContentBackgroundColor)) ? this.contentBackgroundColor : this.darkModeContentBackgroundColor;
            } catch (Throwable th2) {
                TmcLogger.h("", th2);
                return this.contentBackgroundColor;
            }
        }

        public final String getDarkModeContentBackgroundColor() {
            return this.darkModeContentBackgroundColor;
        }

        public final String getDarkModeNavigationBarBackgroundColor() {
            return this.darkModeNavigationBarBackgroundColor;
        }

        public final String getDarkModeNavigationBarIconStyle() {
            return this.darkModeNavigationBarIconStyle;
        }

        public final String getDarkModeNavigationBarTextStyle() {
            return this.darkModeNavigationBarTextStyle;
        }

        public final Boolean getEnableNavigationBarLoading() {
            return this.enableNavigationBarLoading;
        }

        public final Boolean getEnablePageLoading() {
            return this.enablePageLoading;
        }

        public final Boolean getEnablePullDownRefresh() {
            return this.enablePullDownRefresh;
        }

        public final Boolean getEnablePullUpRefresh() {
            return this.enablePullUpRefresh;
        }

        public final Boolean getEnableTabBarAdjustPan() {
            return this.enableTabBarAdjustPan;
        }

        public final Boolean getEnableTransparentStatusBar() {
            return this.enableTransparentStatusBar;
        }

        public final String getHandleWebviewPreload() {
            return this.handleWebviewPreload;
        }

        public final Boolean getLimitTextZoom() {
            return this.limitTextZoom;
        }

        public final String getNavigationBarBackgroundColor() {
            return this.navigationBarBackgroundColor;
        }

        public final String getNavigationBarHomeAction() {
            return this.navigationBarHomeAction;
        }

        public final String getNavigationBarIconStyle() {
            return this.navigationBarIconStyle;
        }

        public final String getNavigationBarTextStyle() {
            return this.navigationBarTextStyle;
        }

        public final String getNavigationBarTitleText() {
            return this.navigationBarTitleText;
        }

        public final String getNavigationBgColor() {
            try {
                return (!z.a(((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext()) || f.a(this.darkModeNavigationBarBackgroundColor)) ? this.navigationBarBackgroundColor : this.darkModeNavigationBarBackgroundColor;
            } catch (Throwable th2) {
                TmcLogger.h("", th2);
                return this.navigationBarBackgroundColor;
            }
        }

        public final String getNavigationStyle() {
            return this.navigationStyle;
        }

        public final String getRefreshFooterAccentColor() {
            return this.refreshFooterAccentColor;
        }

        public final String getRefreshFooterBackgroundColor() {
            return this.refreshFooterBackgroundColor;
        }

        public final Integer getRefreshFooterDelayed() {
            return this.refreshFooterDelayed;
        }

        public final String getRefreshHeaderAccentColor() {
            return this.refreshHeaderAccentColor;
        }

        public final String getRefreshHeaderBackgroundColor() {
            return this.refreshHeaderBackgroundColor;
        }

        public final String getRefreshHeaderCustomLoading() {
            return this.refreshHeaderCustomLoading;
        }

        public final String getRefreshHeaderCustomLoadingGif() {
            return this.refreshHeaderCustomLoadingGif;
        }

        public final String getRefreshHeaderCustomSuccess() {
            return this.refreshHeaderCustomSuccess;
        }

        public final String getRefreshHeaderCustomSuccessGif() {
            return this.refreshHeaderCustomSuccessGif;
        }

        public final Boolean getRefreshHeaderCustomTextEnable() {
            return this.refreshHeaderCustomTextEnable;
        }

        public final Integer getRefreshHeaderDelayed() {
            return this.refreshHeaderDelayed;
        }

        public final String getRefreshHeaderStyle() {
            return this.refreshHeaderStyle;
        }

        public final Boolean getRefreshHeaderTranslationContent() {
            return this.refreshHeaderTranslationContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final boolean navigationBarIconStyleIsWhite() {
            Object objB = "white";
            try {
                objB = (!z.a(((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext()) || f.a(this.darkModeNavigationBarIconStyle)) ? Intrinsics.b("white", this.navigationBarIconStyle) : Intrinsics.b("white", this.darkModeNavigationBarIconStyle);
                return objB;
            } catch (Throwable th2) {
                TmcLogger.h("", th2);
                return Intrinsics.b(objB, this.navigationBarIconStyle);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final boolean navigationBarTextStyleIsWhite() {
            Object objB = "white";
            try {
                objB = (!z.a(((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext()) || f.a(this.darkModeNavigationBarTextStyle)) ? Intrinsics.b("white", this.navigationBarTextStyle) : Intrinsics.b("white", this.darkModeNavigationBarTextStyle);
                return objB;
            } catch (Throwable th2) {
                TmcLogger.h("", th2);
                return Intrinsics.b(objB, this.navigationBarTextStyle);
            }
        }

        public final boolean navigationStyleIsCustom() {
            return Intrinsics.b("custom", this.navigationStyle);
        }

        public final boolean navigationStyleIsHide() {
            return Intrinsics.b("hide", this.navigationStyle);
        }

        public final void setContentBackgroundColor(String str) {
            this.contentBackgroundColor = str;
        }

        public final void setDarkModeContentBackgroundColor(String str) {
            this.darkModeContentBackgroundColor = str;
        }

        public final void setDarkModeNavigationBarBackgroundColor(String str) {
            this.darkModeNavigationBarBackgroundColor = str;
        }

        public final void setDarkModeNavigationBarIconStyle(String str) {
            this.darkModeNavigationBarIconStyle = str;
        }

        public final void setDarkModeNavigationBarTextStyle(String str) {
            this.darkModeNavigationBarTextStyle = str;
        }

        public final void setEnableNavigationBarLoading(Boolean bool) {
            this.enableNavigationBarLoading = bool;
        }

        public final void setEnablePageLoading(Boolean bool) {
            this.enablePageLoading = bool;
        }

        public final void setEnablePullDownRefresh(Boolean bool) {
            this.enablePullDownRefresh = bool;
        }

        public final void setEnablePullUpRefresh(Boolean bool) {
            this.enablePullUpRefresh = bool;
        }

        public final void setEnableTabBarAdjustPan(Boolean bool) {
            this.enableTabBarAdjustPan = bool;
        }

        public final void setEnableTransparentStatusBar(Boolean bool) {
            this.enableTransparentStatusBar = bool;
        }

        public final void setHandleWebviewPreload(String str) {
            this.handleWebviewPreload = str;
        }

        public final void setLimitTextZoom(Boolean bool) {
            this.limitTextZoom = bool;
        }

        public final void setNavigationBarBackgroundColor(String str) {
            this.navigationBarBackgroundColor = str;
        }

        public final void setNavigationBarHomeAction(String str) {
            this.navigationBarHomeAction = str;
        }

        public final void setNavigationBarIconStyle(String str) {
            this.navigationBarIconStyle = str;
        }

        public final void setNavigationBarTextStyle(String str) {
            this.navigationBarTextStyle = str;
        }

        public final void setNavigationBarTitleText(String str) {
            this.navigationBarTitleText = str;
        }

        public final void setNavigationStyle(String str) {
            this.navigationStyle = str;
        }

        public final void setRefreshFooterAccentColor(String str) {
            this.refreshFooterAccentColor = str;
        }

        public final void setRefreshFooterBackgroundColor(String str) {
            this.refreshFooterBackgroundColor = str;
        }

        public final void setRefreshFooterDelayed(Integer num) {
            this.refreshFooterDelayed = num;
        }

        public final void setRefreshHeaderAccentColor(String str) {
            this.refreshHeaderAccentColor = str;
        }

        public final void setRefreshHeaderBackgroundColor(String str) {
            this.refreshHeaderBackgroundColor = str;
        }

        public final void setRefreshHeaderCustomLoading(String str) {
            this.refreshHeaderCustomLoading = str;
        }

        public final void setRefreshHeaderCustomLoadingGif(String str) {
            this.refreshHeaderCustomLoadingGif = str;
        }

        public final void setRefreshHeaderCustomSuccess(String str) {
            this.refreshHeaderCustomSuccess = str;
        }

        public final void setRefreshHeaderCustomSuccessGif(String str) {
            this.refreshHeaderCustomSuccessGif = str;
        }

        public final void setRefreshHeaderCustomTextEnable(Boolean bool) {
            this.refreshHeaderCustomTextEnable = bool;
        }

        public final void setRefreshHeaderDelayed(Integer num) {
            this.refreshHeaderDelayed = num;
        }

        public final void setRefreshHeaderStyle(String str) {
            this.refreshHeaderStyle = str;
        }

        public final void setRefreshHeaderTranslationContent(Boolean bool) {
            this.refreshHeaderTranslationContent = bool;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            Intrinsics.g(parcel, "parcel");
            parcel.writeValue(this.enablePullDownRefresh);
            parcel.writeValue(this.enablePullUpRefresh);
            parcel.writeValue(this.enableTransparentStatusBar);
            parcel.writeValue(this.enableNavigationBarLoading);
            parcel.writeString(this.navigationBarTitleText);
            parcel.writeString(this.navigationStyle);
            parcel.writeString(this.navigationBarBackgroundColor);
            parcel.writeString(this.navigationBarTextStyle);
            parcel.writeString(this.navigationBarIconStyle);
            parcel.writeString(this.navigationBarHomeAction);
            parcel.writeString(this.refreshHeaderStyle);
            parcel.writeValue(this.refreshHeaderCustomTextEnable);
            parcel.writeString(this.refreshHeaderCustomLoading);
            parcel.writeString(this.refreshHeaderCustomLoadingGif);
            parcel.writeString(this.refreshHeaderCustomSuccess);
            parcel.writeString(this.refreshHeaderCustomSuccessGif);
            parcel.writeValue(this.refreshHeaderTranslationContent);
            parcel.writeString(this.refreshHeaderAccentColor);
            parcel.writeString(this.refreshHeaderBackgroundColor);
            parcel.writeValue(this.refreshHeaderDelayed);
            parcel.writeString(this.refreshFooterAccentColor);
            parcel.writeString(this.refreshFooterBackgroundColor);
            parcel.writeValue(this.refreshFooterDelayed);
            parcel.writeString(this.contentBackgroundColor);
            parcel.writeString(this.handleWebviewPreload);
            parcel.writeValue(this.enablePageLoading);
            parcel.writeValue(this.enableTabBarAdjustPan);
            parcel.writeString(this.darkModeNavigationBarBackgroundColor);
            parcel.writeString(this.darkModeNavigationBarTextStyle);
            parcel.writeString(this.darkModeNavigationBarIconStyle);
            parcel.writeString(this.darkModeContentBackgroundColor);
            parcel.writeValue(this.limitTextZoom);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MiniAppConfigModel> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MiniAppConfigModel createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MiniAppConfigModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MiniAppConfigModel[] newArray(int i11) {
            return new MiniAppConfigModel[i11];
        }
    }

    public MiniAppConfigModel() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniAppConfigModel(Parcel parcel) {
        HashMap<String, PreloadRuleSubpackage> map;
        this();
        Intrinsics.g(parcel, "parcel");
        this.window = (WindowBean) parcel.readParcelable(WindowBean.class.getClassLoader());
        this.tabBar = (TabBarBean) parcel.readParcelable(TabBarBean.class.getClassLoader());
        this.includeFiles = parcel.readString();
        this.pages = parcel.createStringArrayList();
        this.subPackages = parcel.createTypedArrayList(Subpackage.CREATOR);
        HashMap hashMap = parcel.readHashMap(PreloadRuleSubpackage.class.getClassLoader());
        HashMap<String, PagesBean> map2 = null;
        if (hashMap != null) {
            map = new HashMap<>();
            for (Object obj : hashMap.keySet()) {
                if (hashMap.get(obj) instanceof PreloadRuleSubpackage) {
                    String string = obj.toString();
                    Object obj2 = hashMap.get(obj);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.cloud.tmc.integration.model.PreloadRuleSubpackage");
                    }
                    map.put(string, (PreloadRuleSubpackage) obj2);
                }
            }
        } else {
            map = null;
        }
        this.preloadRule = map;
        HashMap hashMap2 = parcel.readHashMap(PagesBean.class.getClassLoader());
        if (hashMap2 != null) {
            map2 = new HashMap<>();
            for (Object obj3 : hashMap2.keySet()) {
                if (hashMap2.get(obj3) instanceof PagesBean) {
                    String string2 = obj3.toString();
                    Object obj4 = hashMap2.get(obj3);
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.cloud.tmc.integration.model.MiniAppConfigModel.PagesBean");
                    }
                    map2.put(string2, (PagesBean) obj4);
                }
            }
        }
        this.launchParams = map2;
        this.mfah = parcel.readString();
        this.iconFile = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getHandleTabBarLoad() {
        return this.handleTabBarLoad;
    }

    public final String getIncludeFiles() {
        return this.includeFiles;
    }

    public final String getMfah() {
        return this.mfah;
    }

    public final WindowBean getWindow() {
        return this.window;
    }

    public final void setHandleTabBarLoad(String str) {
        this.handleTabBarLoad = str;
    }

    public final void setIncludeFiles(String str) {
        this.includeFiles = str;
    }

    public final void setMfah(String str) {
        this.mfah = str;
    }

    public final void setWindow(WindowBean windowBean) {
        this.window = windowBean;
    }

    public final boolean tabBarManual() {
        return Intrinsics.b("manual", this.handleTabBarLoad);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeParcelable(this.window, i11);
        parcel.writeParcelable(this.tabBar, i11);
        parcel.writeString(this.includeFiles);
        parcel.writeStringList(this.pages);
        parcel.writeTypedList(this.subPackages);
        parcel.writeMap(this.preloadRule);
        parcel.writeMap(this.launchParams);
        parcel.writeString(this.mfah);
        parcel.writeString(this.iconFile);
    }
}
