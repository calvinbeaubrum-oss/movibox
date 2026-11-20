package com.cloud.hisavana.sdk;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;
import com.cloud.hisavana.sdk.common.activity.MiniAppSchemeActivity;
import com.cloud.hisavana.sdk.common.bean.MiniAppInfo;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f30119a = new t0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static u0 f30120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function1<? super Integer, Unit> f30121c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Lambda implements Function1<Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f30122a = new a();

        public a() {
            super(1);
        }

        public final void a(int i11) {
            t0.f30119a.k();
            Function1 function1 = t0.f30121c;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i11));
            }
            t0.f30121c = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(String str, final ShortcutInfo.Builder builder, final ShortcutManager shortcutManager, final MiniAppInfo miniAppInfo, final Function1 onAddResult) {
        Bitmap bitmapDecodeFile;
        T tCreateWithResource;
        Icon iconCreateWithBitmap;
        Intrinsics.g(builder, "$builder");
        Intrinsics.g(onAddResult, "$onAddResult");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (str != null) {
            try {
                bitmapDecodeFile = BitmapFactory.decodeFile(str);
            } catch (Exception unused) {
            }
        } else {
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null || (iconCreateWithBitmap = Icon.createWithBitmap(bitmapDecodeFile)) == null) {
            tCreateWithResource = iconCreateWithBitmap;
            tCreateWithResource = Icon.createWithResource(f30119a.j(), R$drawable.miniapp_default_icon);
        }
        tCreateWithResource = iconCreateWithBitmap;
        objectRef.element = tCreateWithResource;
        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.h3
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                t0.i(objectRef, builder, shortcutManager, miniAppInfo, onAddResult);
            }
        });
    }

    public static final void i(Ref.ObjectRef icon, ShortcutInfo.Builder builder, ShortcutManager shortcutManager, MiniAppInfo miniAppInfo, Function1 onAddResult) {
        Intrinsics.g(icon, "$icon");
        Intrinsics.g(builder, "$builder");
        Intrinsics.g(onAddResult, "$onAddResult");
        try {
            Icon iconA = s2.a(icon.element);
            if (iconA != null) {
                builder.setIcon(iconA);
            }
            ShortcutInfo shortcutInfoBuild = builder.build();
            Intrinsics.f(shortcutInfoBuild, "builder.build()");
            Intent intentCreateShortcutResultIntent = shortcutManager.createShortcutResultIntent(shortcutInfoBuild);
            t0 t0Var = f30119a;
            PendingIntent broadcast = PendingIntent.getBroadcast(t0Var.j(), 99, intentCreateShortcutResultIntent, 67108864);
            String appId = miniAppInfo.getAppId();
            Intrinsics.f(appId, "appInfo.appId");
            t0Var.e(appId);
            shortcutManager.requestPinShortcut(shortcutInfoBuild, broadcast != null ? broadcast.getIntentSender() : null);
        } catch (Exception e11) {
            z.a().e("MiniApp", "Failed to add to homescreen: " + Log.getStackTraceString(e11));
            onAddResult.invoke(-1);
        }
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public final void e(String str) {
        k();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_add_item_result_receiver");
        f30120b = new u0(str, a.f30122a);
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                j().registerReceiver(f30120b, intentFilter, 2);
            } else {
                j().registerReceiver(f30120b, intentFilter);
            }
        } catch (Throwable th2) {
            z.a().e("MiniApp", "Failed to register broadcast receiver: " + Log.getStackTraceString(th2));
        }
    }

    public final void g(final String str, final MiniAppInfo miniAppInfo, final Function1<? super Integer, Unit> onAddResult) {
        Object next;
        Intrinsics.g(onAddResult, "onAddResult");
        if (j() == null || miniAppInfo == null) {
            onAddResult.invoke(-1);
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            onAddResult.invoke(-1);
            return;
        }
        try {
            final ShortcutManager shortcutManagerA = com.bytedance.sdk.openadsdk.api.init.b.a(j().getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()));
            if (shortcutManagerA != null && shortcutManagerA.isRequestPinShortcutSupported()) {
                List pinnedShortcuts = shortcutManagerA.getPinnedShortcuts();
                Intrinsics.f(pinnedShortcuts, "shortcutManager.pinnedShortcuts");
                Iterator it = pinnedShortcuts.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(a3.a(next).getId(), miniAppInfo.getAppId()));
                if (a3.a(next) != null) {
                    onAddResult.invoke(2);
                    return;
                }
                f30121c = onAddResult;
                x2.a();
                ShortcutInfo.Builder builderA = r2.a(j(), miniAppInfo.getAppId());
                Intent intent = new Intent(j(), (Class<?>) MiniAppSchemeActivity.class);
                intent.setAction(miniAppInfo.getAppId());
                intent.putExtra(WebConstants.FIELD_DEEPLINK, miniAppInfo.getDeepLinkUrl());
                ShortcutInfo.Builder shortLabel = builderA.setIntent(intent).setShortLabel(miniAppInfo.getName());
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString(PushConstants.PROVIDER_FIELD_APP_ID, miniAppInfo.getAppId());
                persistableBundle.putBoolean("extraAddHomeShowDialog", false);
                final ShortcutInfo.Builder extras = shortLabel.setExtras(persistableBundle);
                Intrinsics.f(extras, "Builder(context, appInfo…false)\n                })");
                com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.g3
                    @Override // java.lang.Runnable
                    public final void run() {
                        t0.f(str, extras, shortcutManagerA, miniAppInfo, onAddResult);
                    }
                });
                return;
            }
            onAddResult.invoke(-1);
        } catch (Throwable th2) {
            z.a().e("MiniApp", "Failed to create shortcut: " + Log.getStackTraceString(th2));
            onAddResult.invoke(-1);
        }
    }

    public final Context j() {
        return com.cloud.sdk.commonutil.util.f.a().getApplicationContext();
    }

    public final void k() {
        u0 u0Var = f30120b;
        if (u0Var != null) {
            try {
                f30119a.j().unregisterReceiver(u0Var);
            } catch (Throwable th2) {
                z.a().e("MiniApp", "Failed to unregister broadcast receiver: " + Log.getStackTraceString(th2));
            }
        }
        f30120b = null;
    }
}
