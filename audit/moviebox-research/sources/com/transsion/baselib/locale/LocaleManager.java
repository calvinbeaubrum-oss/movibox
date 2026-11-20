package com.transsion.baselib.locale;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import as.c;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.locale.LocaleManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class LocaleManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f51198f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f51199g = {null, "English", "Bahasa Indonesia", "Français", "Português", "العربية", "বাংলা", "Русский", "ਪੰਜਾਬੀ", "اردو", "Filipino"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f51200h = {null, Locale.ENGLISH.getLanguage(), "in", "fr", "pt", "ar", "bn", "ru", "pa", "ur", "fil"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<LocaleManager> f51201i = LazyKt__LazyJVMKt.b(new Function0<LocaleManager>() { // from class: com.transsion.baselib.locale.LocaleManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LocaleManager invoke() {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return new LocaleManager(applicationA, null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Locale f51202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Locale f51203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f51204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f51205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.transsion.baselib.locale.a f51206e;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f51208b;

        public a(Context context) {
            this.f51208b = context;
        }

        public static final void b(LocaleManager this$0, Locale oldSystemLocal, Locale locale, Context baseContext) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(oldSystemLocal, "$oldSystemLocal");
            if (this$0.i() == oldSystemLocal) {
                String country = locale.getCountry();
                Intrinsics.f(country, "localeL.country");
                this$0.m(null, country, true);
            } else {
                Intrinsics.f(baseContext, "baseContext");
                this$0.p(baseContext, this$0.i());
            }
            uo.b.a.f(uo.b.f78622a, "LocaleManager", "onConfigurationChanged()-> locale = " + locale, false, 4, null);
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.g(newConfig, "newConfig");
            final Locale localeL = Build.VERSION.SDK_INT >= 24 ? newConfig.getLocales().get(0) : newConfig.locale;
            final Locale locale = LocaleManager.this.f51203b;
            if (Intrinsics.b(localeL, locale)) {
                return;
            }
            LocaleManager localeManager = LocaleManager.this;
            Intrinsics.f(localeL, "localeL");
            localeManager.f51203b = localeL;
            final LocaleManager localeManager2 = LocaleManager.this;
            final Context context = this.f51208b;
            ThreadUtils.j(new Runnable() { // from class: as.b
                @Override // java.lang.Runnable
                public final void run() {
                    LocaleManager.a.b(localeManager2, locale, localeL, context);
                }
            });
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Locale d(Context context) {
            Intrinsics.g(context, "context");
            uo.b.a.f(uo.b.f78622a, "LocaleManager", "getContextLocale()-> context = " + context, false, 4, null);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                Locale locale = configuration.getLocales().get(0);
                Intrinsics.f(locale, "{\n                config….locales[0]\n            }");
                return locale;
            }
            Locale locale2 = configuration.locale;
            Intrinsics.f(locale2, "{\n                config…tion.locale\n            }");
            return locale2;
        }

        public final LocaleManager e() {
            return (LocaleManager) LocaleManager.f51201i.getValue();
        }

        public final String[] f() {
            return LocaleManager.f51200h;
        }

        public final String[] g() {
            return LocaleManager.f51199g;
        }

        public final Locale h(String str, String str2) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return new Locale(str, str2);
        }

        public final String i() {
            return RoomAppMMKV.f51271a.a().getString("k_language_short_name", null);
        }

        public final void j(String str) {
            if (str != null) {
                int length = str.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    boolean z12 = Intrinsics.i(str.charAt(!z11 ? i11 : length), 32) <= 0;
                    if (z11) {
                        if (!z12) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z12) {
                        i11++;
                    } else {
                        z11 = true;
                    }
                }
                if (str.subSequence(i11, length + 1).toString().length() != 0) {
                    RoomAppMMKV.f51271a.a().putString("k_language_short_name", str);
                    return;
                }
            }
            RoomAppMMKV.f51271a.a().remove("k_language_short_name");
        }

        public final Context k(Context context, Locale locale) {
            Intrinsics.g(context, "context");
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                c.a();
                LocaleList localeListA = androidx.compose.ui.text.platform.extensions.b.a(new Locale[]{locale});
                configuration.setLocales(localeListA);
                LocaleList.setDefault(localeListA);
            } else {
                configuration.setLocale(locale);
            }
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics.f(contextCreateConfigurationContext, "newContext.createConfigurationContext(newConfig)");
            return contextCreateConfigurationContext;
        }
    }

    public LocaleManager(Context context) {
        com.transsion.baselib.locale.a aVar = new com.transsion.baselib.locale.a();
        this.f51206e = aVar;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        Context baseContext = application.getBaseContext();
        Intrinsics.f(baseContext, "baseContext");
        this.f51205d = baseContext;
        b bVar = f51198f;
        Locale localeD = bVar.d(baseContext);
        this.f51203b = localeD;
        String countryCode = localeD.getCountry();
        uo.b.a.f(uo.b.f78622a, "LocaleManager", "LocaleManager()->  system locale =" + this.f51203b + ", countryCode = " + countryCode, false, 4, null);
        application.registerActivityLifecycleCallbacks(aVar);
        application.registerComponentCallbacks(new a(baseContext));
        String strI = bVar.i();
        Intrinsics.f(countryCode, "countryCode");
        m(strI, countryCode, true);
    }

    public /* synthetic */ LocaleManager(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final void n(LocaleManager this$0, Locale locale) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "LocaleManager", "notify changed()-> ", false, 4, null);
        this$0.f51206e.e(locale);
    }

    public final synchronized Locale i() {
        return this.f51202a;
    }

    public final Locale j() {
        return this.f51202a;
    }

    public final Locale k() {
        return this.f51203b;
    }

    public final void l(String str) {
        if (Build.VERSION.SDK_INT == 23 && Intrinsics.b("ur", str)) {
            m(str, "PK", false);
            return;
        }
        String country = this.f51203b.getCountry();
        Intrinsics.f(country, "systemLocale.country");
        m(str, country, false);
    }

    public final void m(String str, String str2, boolean z11) {
        fp.b.f65208a.k(str);
        Context context = this.f51205d;
        if (str != null) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z12 = false;
            while (i11 <= length) {
                boolean z13 = Intrinsics.i(str.charAt(!z12 ? i11 : length), 32) <= 0;
                if (z12) {
                    if (!z13) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z13) {
                    i11++;
                } else {
                    z12 = true;
                }
            }
            if (str.subSequence(i11, length + 1).toString().length() == 0) {
                str = null;
            }
        }
        if (z11 || !TextUtils.equals(str, this.f51204c)) {
            b bVar = f51198f;
            final Locale localeH = bVar.h(str, str2);
            if (localeH == null) {
                localeH = this.f51203b;
            }
            uo.b.a.f(uo.b.f78622a, "LocaleManager", "setLocale()-> locale = " + localeH + " , language = " + ((Object) str), false, 4, null);
            synchronized (this) {
                this.f51204c = str;
                this.f51202a = localeH;
                Locale.setDefault(localeH);
                Unit unit = Unit.f68710a;
            }
            p(context, localeH);
            bVar.j(str);
            ThreadUtils.j(new Runnable() { // from class: as.a
                @Override // java.lang.Runnable
                public final void run() {
                    LocaleManager.n(this.f13590a, localeH);
                }
            });
        }
    }

    public final boolean o(Locale locale) {
        Intrinsics.g(locale, "locale");
        return this.f51203b == locale;
    }

    public final void p(Context context, Locale locale) {
        Locale locale2;
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            locale2 = configuration.getLocales().get(0);
            Intrinsics.f(locale2, "{\n            configuration.locales[0]\n        }");
        } else {
            locale2 = configuration.locale;
            Intrinsics.f(locale2, "{\n            configuration.locale\n        }");
        }
        uo.b.a.f(uo.b.f78622a, "LocaleManager", "updateConfig()-> old app locale = " + locale2 + " , new app locale = " + locale, false, 4, null);
        Configuration configuration2 = new Configuration(configuration);
        configuration2.setLocale(locale);
        resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
    }
}
