package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Sfl {
    private static boolean ExN = false;
    private static boolean TRI = false;
    private static String We;
    private static String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f27030sc;
    private static Resources zY;

    public static int ExN(Context context, String str) {
        return sc(context, str, "id");
    }

    public static int Ol(Context context, String str) {
        return sc(context, str, "anim");
    }

    public static int Qj(Context context, String str) {
        return sc(context, str, TtmlNode.ATTR_TTS_COLOR);
    }

    public static int TRI(Context context, String str) {
        return sc(context, str, TtmlNode.TAG_STYLE);
    }

    public static int We(Context context, String str) {
        try {
            return sc(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String We(Context context) {
        if (We == null) {
            We = context.getPackageName();
        }
        return We;
    }

    public static int pFF(Context context, String str) {
        return sc(context, str, "string");
    }

    private static AssetManager pFF(AssetManager assetManager, String str) {
        try {
            AssetManager assetManager2 = assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager") ? (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]) : (AssetManager) AssetManager.class.newInstance();
            sc(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            sc(assetManager, str);
        }
        try {
            WP.sc(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static Resources pFF(Context context) {
        Resources resources = zY;
        if (resources == null) {
            resources = null;
        }
        Context context2 = f27030sc;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static int qr(Context context, String str) {
        return pFF(context).getColor(Qj(context, str));
    }

    private static int sc(Context context, String str, String str2) {
        int identifier = pFF(context).getIdentifier(str, str2, We(context));
        if (identifier != 0) {
            return identifier;
        }
        if (ExN) {
            return context.getResources().getIdentifier(str, str2, We(context));
        }
        zY(context);
        return pFF(context).getIdentifier(str, str2, We(context));
    }

    public static String sc(Context context, String str) {
        return pFF(context).getString(pFF(context, str));
    }

    public static void sc(Context context) {
        f27030sc = context;
    }

    public static void sc(String str) {
        We = str;
    }

    public static boolean sc(AssetManager assetManager, String str) {
        Method methodSc = WP.sc((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodSc == null) {
            methodSc = WP.sc((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodSc != null) {
            int i11 = 3;
            while (true) {
                int i12 = i11 - 1;
                if (i11 < 0) {
                    break;
                }
                try {
                    if (((Integer) methodSc.invoke(assetManager, str)).intValue() != 0) {
                        return true;
                    }
                    i11 = i12;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static Drawable zY(Context context, String str) {
        try {
            return pFF(context).getDrawable(We(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized void zY(Context context) {
        try {
            if (TextUtils.isEmpty(pFF)) {
                return;
            }
            Resources resources = context.getResources();
            zY = new Resources(pFF(resources.getAssets(), pFF + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            We = context.getPackageName();
            ExN = true;
        } catch (Throwable th2) {
            Log.e("ResourceHelp", "makePluginResources failed", th2);
        }
    }
}
