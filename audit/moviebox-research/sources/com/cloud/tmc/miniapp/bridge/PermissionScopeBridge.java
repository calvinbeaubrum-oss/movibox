package com.cloud.tmc.miniapp.bridge;

import OooO0o0.o0OO00O;
import OooO0o0.o0OOO0o;
import OooO0o0.o0Oo0oo;
import OooO0o0.o0ooOOo;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import cc.c;
import cc.f;
import cc.g;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.h;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.x;
import com.cloud.tmc.miniutils.util.y;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.gslb.Utils;
import com.transsion.push.PushConstants;
import hd.j;
import hd.k;
import j.h0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.HttpUrl;
import xb.d;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class PermissionScopeBridge implements BridgeExtension {
    public static final int ERROR_CODE_HAPPENED_EXCEPTION = 500;
    public static final int ERROR_CODE_SCOPE_NAME_IS_EMPTY = 601;
    public static final int ERROR_CODE_SCOPE_NAME_NOT_FOUND = 602;
    public static final String ERROR_MSG_SCOPE_NAME_IS_EMPTY = "scopeName is empty";
    public static final String ERROR_MSG_SCOPE_NAME_NOT_FOUND = "No specified scopeName found";
    public static final String TAG = "PermissionScopeBridge::";
    public static final a Companion = new a();
    public static final ConcurrentHashMap<String, o0ooOOo> OooO00o = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public final boolean a(String str) {
            if (str != null) {
                try {
                    return (str.length() == 0 || !PermissionScopeBridge.OooO00o.containsKey(str) || ((o0ooOOo) PermissionScopeBridge.OooO00o.get(str)) == null) ? false : true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f31494b;

        public b(bc.a aVar, Ref.BooleanRef booleanRef) {
            this.f31493a = aVar;
            this.f31494b = booleanRef;
        }

        @Override // j.h0
        public void b(boolean z11) {
            TmcLogger.c(PermissionScopeBridge.TAG, "clickNotShowAgagin status = " + z11);
            this.f31494b.element = z11;
        }

        @Override // j.h0
        public void c(int i11) {
            TmcLogger.c(PermissionScopeBridge.TAG, "onClick postion = " + i11);
            this.f31493a.d(h.a().c("click", Integer.valueOf(i11)).b("isClickNotShowAgain", Boolean.valueOf(this.f31494b.element)).e());
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009c A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:4:0x0010, B:6:0x0016, B:8:0x001c, B:10:0x0022, B:13:0x003c, B:16:0x0048, B:17:0x005b, B:19:0x0063, B:20:0x0089, B:21:0x009c), top: B:26:0x0010 }] */
    @zb.a
    @e(ExecutorType.NORMAL)
    public final void checkScopePermissionAuthStatus(@f(App.class) App app, @g({"scopeName"}) String scopeName, @c bc.a callback) {
        Context context;
        Intrinsics.g(scopeName, "scopeName");
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    callback.b();
                } else if (com.cloud.tmc.miniutils.util.f.a(scopeName)) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(TrackingKey.CODE, Integer.valueOf(ERROR_CODE_SCOPE_NAME_IS_EMPTY));
                    jsonObject.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_IS_EMPTY);
                    callback.e(jsonObject);
                } else {
                    ConcurrentHashMap<String, ScopeModel> concurrentHashMap = h.b.f65651d;
                    if (concurrentHashMap.containsKey(scopeName)) {
                        ScopeModel scopeModel = concurrentHashMap.get(scopeName);
                        if (scopeModel != null) {
                            ScopeUtils scopeUtils = ScopeUtils.f31808a;
                            long validityTime = scopeModel.getValidityTime();
                            String appId = app.getAppId();
                            Intrinsics.f(appId, "app.appId");
                            boolean zH = scopeUtils.h(context, scopeName, validityTime, appId);
                            JsonObject jsonObject2 = new JsonObject();
                            jsonObject2.addProperty("authStatus", Boolean.valueOf(zH));
                            callback.d(jsonObject2);
                        } else {
                            JsonObject jsonObject3 = new JsonObject();
                            jsonObject3.addProperty(TrackingKey.CODE, Integer.valueOf(ERROR_CODE_SCOPE_NAME_NOT_FOUND));
                            jsonObject3.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_NOT_FOUND);
                            callback.e(jsonObject3);
                        }
                    } else {
                        JsonObject jsonObject4 = new JsonObject();
                        jsonObject4.addProperty(TrackingKey.CODE, Integer.valueOf(ERROR_CODE_SCOPE_NAME_NOT_FOUND));
                        jsonObject4.addProperty("errMsg", ERROR_MSG_SCOPE_NAME_NOT_FOUND);
                        callback.e(jsonObject4);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty(TrackingKey.CODE, (Number) 500);
                jsonObject5.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject5);
            }
        } else {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @zb.a
    @e(ExecutorType.IO)
    public final void getTempUniqueId(@f(App.class) App app, @c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                } else {
                    context = null;
                }
            } catch (Throwable unused) {
                callback.b();
                return;
            }
        } else {
            context = null;
        }
        if (context == null) {
            return;
        }
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, app.getAppId(), "tempUniqueId");
        if (string == null || string.length() == 0) {
            string = com.cloud.tmc.miniutils.util.h.b(System.currentTimeMillis() + '_' + app.getAppId());
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, app.getAppId(), "tempUniqueId", string);
        }
        callback.d(h.a().d("tempUniqueId", string).e());
    }

    @zb.a
    @e(ExecutorType.NORMAL)
    public final void listScope(@c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            Set<Map.Entry<String, ScopeModel>> setEntrySet = h.b.f65651d.entrySet();
            Intrinsics.f(setEntrySet, "SHOW_SCOPE_MAP.entries");
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() != null) {
                    Object value = entry.getValue();
                    Intrinsics.f(value, "it.value");
                    jsonArray.add(o.a(value));
                }
            }
            Unit unit = Unit.f68710a;
            jsonObject.addProperty("data", o.a(jsonArray));
            callback.d(jsonObject);
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(TrackingKey.CODE, (Number) 500);
            jsonObject2.addProperty("errMsg", th2.getMessage());
            callback.e(jsonObject2);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c(TAG, "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c(TAG, "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    @zb.a
    @e(ExecutorType.IO)
    public final void queryAddScreenNotShowAgainStatus(@f(App.class) App app, @g({"miniappId"}) String miniappId, @c bc.a callback) {
        Context context;
        Intrinsics.g(miniappId, "miniappId");
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                } else {
                    context = null;
                }
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
                callback.d(h.a().c(CampaignEx.JSON_KEY_TIMESTAMP, 0L).e());
                return;
            }
        } else {
            context = null;
        }
        if (context == null) {
            callback.b();
        } else {
            callback.d(h.a().c(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, miniappId, "miniAddHomeNotShowAgainTime"))).e());
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void queryDynamicScopeConfig(@f(App.class) App app, @c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            callback.d(h.a().d("scopeConfig", MiniAppConfigHelper.f30370a.e("muscl", "{}")).e());
        } catch (Throwable unused) {
            callback.b();
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void queryEnableDevUserAgreement(@f(App.class) App app, @c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            callback.d(h.a().b("enable", Boolean.valueOf(MiniAppConfigHelper.f30370a.b("enableDevUserAgreement", false))).e());
        } catch (Throwable unused) {
            callback.b();
        }
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void queryEnableduaWhitlist(@f(App.class) App app, @c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            callback.d(h.a().d("duaWhitlist", MiniAppConfigHelper.f30370a.e("enableduaWhitlist", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)).e());
        } catch (Throwable unused) {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001d  */
    @zb.a
    @e(ExecutorType.IO)
    public final void queryMsgNotShowAgainStatus(@f(App.class) App app, @g({"miniappId"}) String miniappId, @c bc.a callback) {
        Context context;
        Intrinsics.g(miniappId, "miniappId");
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null) {
                    context = appContext.getContext();
                } else {
                    context = null;
                }
            } catch (Throwable th2) {
                TmcLogger.h(TAG, th2);
                callback.d(h.a().c(CampaignEx.JSON_KEY_TIMESTAMP, 0L).e());
                return;
            }
        } else {
            context = null;
        }
        if (context == null) {
            callback.b();
            return;
        }
        Pair<Boolean, Long> pairD = ScopeUtils.f31808a.d(context, miniappId);
        TmcLogger.c(TAG, "msgStatusPair,-> " + pairD.getFirst().booleanValue() + ',' + pairD.getSecond().longValue());
        callback.d(h.a().b("notShowAgain", pairD.getFirst()).c(CampaignEx.JSON_KEY_TIMESTAMP, pairD.getSecond()).e());
    }

    @zb.a
    @e(ExecutorType.IO)
    public final void queryScopeContentConfig(@f(App.class) App app, @c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            JsonObject jsonObject = new JsonObject();
            for (String str : ScopeUtils.f31809b) {
                jsonObject.addProperty(str, ScopeUtils.f31808a.l(str, ""));
            }
            callback.d(h.a().d("scope", o.a(jsonObject)).e());
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00d7 A[Catch: all -> 0x00d5, TryCatch #2 {all -> 0x00d5, blocks: (B:28:0x00c0, B:30:0x00c6, B:33:0x00d1, B:36:0x00d7, B:39:0x00e2), top: B:120:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e2 A[Catch: all -> 0x00d5, TRY_LEAVE, TryCatch #2 {all -> 0x00d5, blocks: (B:28:0x00c0, B:30:0x00c6, B:33:0x00d1, B:36:0x00d7, B:39:0x00e2), top: B:120:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x017c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0187  */
    @zb.a
    @e(ExecutorType.UI)
    public final void showScopePermissionDialog(@f(App.class) App app, @g({"logo"}) String logo, @g({CampaignEx.JSON_KEY_TITLE}) String title, @g({"titleTips"}) String titleTips, @g({"scopeName"}) String scopeType, @g({"customContent"}) String customContent, @g({"button1"}) JsonObject config, @g({"button2"}) JsonObject config2, @g({"button3"}) JsonObject config3, @g({"notShowAgain"}) JsonObject config4, @c bc.a callback) {
        AppModel appModel;
        String str;
        TextView textViewY;
        TextView textView;
        TextView textView2;
        tb.b appContext;
        Intrinsics.g(logo, "logo");
        Intrinsics.g(title, "title");
        Intrinsics.g(titleTips, "titleTips");
        Intrinsics.g(scopeType, "scopeName");
        Intrinsics.g(customContent, "customContent");
        Intrinsics.g(config, "button1");
        Intrinsics.g(config2, "button2");
        Intrinsics.g(config3, "button3");
        Intrinsics.g(config4, "notShowAgain");
        Intrinsics.g(callback, "callback");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null || (appModel = app.getAppModel()) == null) {
            return;
        }
        String logo2 = appModel.getLogo();
        String str2 = "";
        if (logo2 == null) {
            logo2 = "";
        }
        String iconUrl = xb.e.b(logo, logo2);
        String name = appModel.getName();
        if (name == null) {
            name = "";
        }
        String appName = xb.e.b(title, name);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        o0OO00O o0oo00o = new o0OO00O(context);
        Intrinsics.g(iconUrl, "iconUrl");
        try {
            AppCompatImageView appCompatImageView = (AppCompatImageView) o0oo00o.f144v.getValue();
            if (appCompatImageView != null) {
                ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                Context context2 = o0oo00o.f27a;
                int iA = x.a(4.0f);
                int i11 = R$drawable.drawable_app_icon_place_holder;
                imageLoaderProxy.loadImgRoundCorners(context2, iconUrl, appCompatImageView, iA, i11, i11);
            }
        } catch (Throwable th2) {
            TmcLogger.g(o0oo00o.f142t, "setAppLogo", th2);
        }
        Intrinsics.g(scopeType, "scopeType");
        if (customContent != null) {
            try {
                if (customContent.length() > 0) {
                    TextView textView3 = (TextView) o0oo00o.f147y.getValue();
                    if (textView3 != null) {
                        textView3.setText(customContent);
                    }
                } else {
                    textView2 = (TextView) o0oo00o.f147y.getValue();
                    if (textView2 == null) {
                        textView2.setText(ScopeUtils.f31808a.b(scopeType, ""));
                    }
                }
            } catch (Throwable th3) {
                TmcLogger.g(o0oo00o.f142t, "setAppName", th3);
            }
        } else {
            textView2 = (TextView) o0oo00o.f147y.getValue();
            if (textView2 == null) {
                textView2.setText(ScopeUtils.f31808a.b(scopeType, ""));
            }
        }
        Intrinsics.g(config, "config");
        try {
            o0oo00o.w((TextView) o0oo00o.f148z.getValue(), config);
        } catch (Throwable th4) {
            TmcLogger.g(o0oo00o.f142t, "setBtnOne:-> ", th4);
        }
        Intrinsics.g(config2, "config");
        try {
            o0oo00o.w((TextView) o0oo00o.A.getValue(), config2);
        } catch (Throwable th5) {
            TmcLogger.g(o0oo00o.f142t, "setBtnTwo:-> ", th5);
        }
        Intrinsics.g(config3, "config");
        try {
            o0oo00o.w(o0oo00o.y(), config3);
        } catch (Throwable th6) {
            TmcLogger.g(o0oo00o.f142t, "setBtnThree:-> ", th6);
        }
        int i12 = 0;
        if (titleTips != null) {
            try {
                if (titleTips.length() == 0) {
                    TextView textView4 = (TextView) o0oo00o.f146x.getValue();
                    if (textView4 != null) {
                        try {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                            String strD = id.h.a.d(o0oo00o, R$string.mini_permission_dialog_title);
                            if (strD == null) {
                                strD = "";
                            }
                            str = String.format(strD, Arrays.copyOf(new Object[]{" "}, 1));
                            Intrinsics.f(str, "format(format, *args)");
                        } catch (Throwable th7) {
                            TmcLogger.h(o0oo00o.f142t, th7);
                            str = "";
                        }
                        textView4.setText(str);
                    }
                } else {
                    textView = (TextView) o0oo00o.f146x.getValue();
                    if (textView != null) {
                        textView.setText(titleTips);
                    }
                }
            } catch (Throwable th8) {
                TmcLogger.g(o0oo00o.f142t, "setAppTitleTips", th8);
            }
        } else {
            textView = (TextView) o0oo00o.f146x.getValue();
            if (textView != null) {
                textView.setText(titleTips);
            }
        }
        Intrinsics.g(appName, "appName");
        try {
            TextView textView5 = (TextView) o0oo00o.f145w.getValue();
            if (textView5 != null) {
                textView5.setText(appName);
            }
        } catch (Throwable th9) {
            TmcLogger.g(o0oo00o.f142t, "setAppName", th9);
        }
        Intrinsics.g(config4, "config");
        try {
            JsonElement jsonElement = config4.get(o0oo00o.G);
            boolean asBoolean = jsonElement != null ? jsonElement.getAsBoolean() : false;
            Group group = (Group) o0oo00o.C.getValue();
            if (group != null) {
                if (!asBoolean) {
                    i12 = 8;
                }
                group.setVisibility(i12);
            }
            JsonElement jsonElement2 = config4.get(o0oo00o.I);
            String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (asString != null) {
                Intrinsics.f(asString, "config.get(KEY_TEXT)?.asString ?: \"\"");
                str2 = asString;
            }
            if (str2.length() > 0 && (textViewY = o0oo00o.y()) != null) {
                textViewY.setText(str2);
            }
        } catch (Throwable unused) {
        }
        b callback2 = new b(callback, booleanRef);
        Intrinsics.g(callback2, "callback");
        o0oo00o.f143u = callback2;
        o0oo00o.q();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:105:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:113:0x025c A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0268  */
    /* JADX WARN: Code duplicated, block: B:117:0x0269 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c3 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x02d0 A[Catch: all -> 0x019e, TRY_LEAVE, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a1 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01b9 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01c9 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:77:0x018b, B:79:0x0191, B:82:0x0199, B:85:0x01a1, B:87:0x01b2, B:92:0x01c2, B:97:0x01d2, B:102:0x01de, B:106:0x01e8, B:108:0x024a, B:114:0x0262, B:118:0x02bc, B:122:0x02ca, B:124:0x02d0, B:121:0x02c3, B:117:0x0269, B:112:0x0255, B:113:0x025c, B:95:0x01c9, B:90:0x01b9, B:110:0x0250), top: B:201:0x018b, inners: #1 }] */
    @zb.a
    @e(ExecutorType.UI)
    public final void userAgreementDialogShow(@f(App.class) App app, @g({"titleMode"}) JsonObject config, @g({AppLovinEventTypes.USER_VIEWED_CONTENT}) String content, @g({"agreementContent"}) String agreementContent, @g({"privacyPolicyTv"}) String str, @g({"userAgreementTv"}) String str2, @g({"privacyPolicyUrl"}) String str3, @g({"userAgreementUrl"}) String str4, @g({"btnBgColor"}) String btnBgColor, @g({"agreeBtn"}) String str5, @g({"cancelBtn"}) JsonObject cancelBtn, @c(isSticky = true) bc.a callback) {
        bc.a aVar;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String dauAgreeContent;
        int iD0;
        int iJ0;
        int iD1;
        int iJ1;
        int iA;
        TextView textViewX;
        TextView textViewX2;
        TextView textViewX3;
        String privacyPolicyTv = str;
        String userAgreementTv = str2;
        String privacyPolicyUrl = str3;
        String userAgreementUrl = str4;
        String agreeBtn = str5;
        Intrinsics.g(config, "titleMode");
        Intrinsics.g(content, "content");
        Intrinsics.g(agreementContent, "agreementContent");
        Intrinsics.g(privacyPolicyTv, "privacyPolicyTv");
        Intrinsics.g(userAgreementTv, "userAgreementTv");
        Intrinsics.g(privacyPolicyUrl, "privacyPolicyUrl");
        Intrinsics.g(userAgreementUrl, "userAgreementUrl");
        Intrinsics.g(btnBgColor, "btnBgColor");
        Intrinsics.g(agreeBtn, "agreeBtn");
        Intrinsics.g(cancelBtn, "cancelBtn");
        Intrinsics.g(callback, "callback");
        TmcLogger.c(TAG, "userAgreementDialogShow titleMode = " + config);
        String appId = app != null ? app.getAppId() : null;
        if (appId == null) {
            TmcLogger.c(TAG, "app is null");
            return;
        }
        tb.b appContext = app.getAppContext();
        Context context = appContext != null ? appContext.getContext() : null;
        if (context == null) {
            TmcLogger.c(TAG, "context is null");
            return;
        }
        ConcurrentHashMap<String, o0ooOOo> concurrentHashMap = OooO00o;
        if (concurrentHashMap.containsKey(appId)) {
            TmcLogger.c(TAG, "dialog is exist remove it");
            o0ooOOo o0ooooo = concurrentHashMap.get(appId);
            if (o0ooooo != null) {
                o0ooooo.l();
            }
            concurrentHashMap.remove(appId);
        }
        o0ooOOo o0ooooo2 = new o0ooOOo(context);
        Intrinsics.g(appId, "appId");
        o0ooooo2.A = appId;
        AppModel appModel = app.getAppModel();
        String name = appModel != null ? appModel.getName() : null;
        Intrinsics.g(config, "config");
        JsonElement jsonElement3 = config.get(o0ooooo2.B);
        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString == null) {
            asString = "1";
        } else {
            Intrinsics.f(asString, "config.get(KEY_MODE)?.asString ?: \"1\"");
        }
        JsonElement jsonElement4 = config.get(o0ooooo2.C);
        String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        if (asString2 == null) {
            asString2 = "";
        } else {
            Intrinsics.f(asString2, "config.get(KEY_TEXT)?.asString ?: \"\"");
        }
        String str6 = appId;
        if (asString2.length() > 0) {
            TextView textView = (TextView) o0ooooo2.f157v.getValue();
            if (textView != null) {
                textView.setText(asString2);
            }
        } else {
            TextView textView2 = (TextView) o0ooooo2.f157v.getValue();
            if (textView2 != null) {
                String strB = (!Intrinsics.b(asString, o0ooooo2.E) && Intrinsics.b(asString, o0ooooo2.F)) ? y.b(id.h.a.d(o0ooooo2, R$string.mini_dau_title_welcome), name) : id.h.a.d(o0ooooo2, R$string.mini_dau_title_notice);
                textView2.setText(strB);
            }
        }
        if (content == null || content.length() <= 0) {
            TextView textViewV = o0ooooo2.v();
            if (textViewV != null) {
                textViewV.setText(id.h.a.d(o0ooooo2, R$string.mini_dau_content));
            }
            TextView textViewV2 = o0ooooo2.v();
            if (textViewV2 != null) {
                textViewV2.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        } else {
            TextView textViewV3 = o0ooooo2.v();
            if (textViewV3 != null) {
                textViewV3.setText(content);
            }
        }
        Intrinsics.g(callback, "callback");
        o0ooooo2.f156u = callback;
        String name2 = app.getAppModel().getName();
        if (name2 == null) {
            name2 = "";
        }
        if (agreementContent != null) {
            try {
                if (agreementContent.length() > 0) {
                    TextView textViewX4 = o0ooooo2.x();
                    if (textViewX4 != null) {
                        textViewX4.setText(agreementContent);
                    }
                } else {
                    dauAgreeContent = y.b(id.h.a.d(o0ooooo2, R$string.mini_dau_agree_content), name2);
                    if (privacyPolicyTv != null || str.length() <= 0) {
                        privacyPolicyTv = id.h.a.d(o0ooooo2, R$string.mini_privacy_privacy_policy);
                    }
                    if (userAgreementTv != null || str2.length() <= 0) {
                        userAgreementTv = id.h.a.d(o0ooooo2, R$string.mini_user_agreement);
                    }
                    if (privacyPolicyUrl != null || str3.length() <= 0) {
                        privacyPolicyUrl = "https://h5.dlight-app.com/outside/privacy-policy?lang=";
                    }
                    if (userAgreementUrl != null || str4.length() <= 0) {
                        userAgreementUrl = "https://h5.dlight-app.com/outside/user-agreement?lang=";
                    }
                    Intrinsics.f(dauAgreeContent, "dauAgreeContent");
                    iD0 = StringsKt__StringsKt.d0(dauAgreeContent, Utils.SEPARATOR, 0, false, 6, null);
                    iJ0 = StringsKt__StringsKt.j0(dauAgreeContent, Utils.SEPARATOR, 0, false, 6, null);
                    iD1 = StringsKt__StringsKt.d0(dauAgreeContent, "*", 0, false, 6, null);
                    iJ1 = StringsKt__StringsKt.j0(dauAgreeContent, "*", 0, false, 6, null);
                    if (btnBgColor != null || btnBgColor.length() <= 0) {
                        iA = id.h.a.a(o0ooooo2, R$color.mini_color_primary);
                    } else {
                        try {
                            iA = Color.parseColor(btnBgColor);
                        } catch (Throwable unused) {
                            iA = id.h.a.a(o0ooooo2, R$color.mini_color_primary);
                        }
                    }
                    textViewX = o0ooooo2.x();
                    if (textViewX == null) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(dauAgreeContent.subSequence(0, iD0));
                        d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(privacyPolicyTv), Integer.valueOf(iA), true, new o0OOO0o(privacyPolicyUrl, o0ooooo2));
                        spannableStringBuilder.append(dauAgreeContent.subSequence(iJ0 + 1, iD1));
                        d.b(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(userAgreementTv), Integer.valueOf(iA), true, new o0Oo0oo(userAgreementUrl, o0ooooo2));
                        spannableStringBuilder.append(dauAgreeContent.subSequence(iJ1 + 1, dauAgreeContent.length()));
                        textViewX.setText(new SpannedString(spannableStringBuilder));
                    }
                    textViewX2 = o0ooooo2.x();
                    if (textViewX2 == null) {
                        textViewX2.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    textViewX3 = o0ooooo2.x();
                    if (textViewX3 != null) {
                        xb.h.b(textViewX3);
                    }
                }
            } catch (Throwable th2) {
                String str7 = o0ooooo2.f155t;
                StringBuilder sbA = j.a("setAgreeText:");
                sbA.append(th2.getMessage());
                TmcLogger.c(str7, sbA.toString());
            }
        } else {
            dauAgreeContent = y.b(id.h.a.d(o0ooooo2, R$string.mini_dau_agree_content), name2);
            if (privacyPolicyTv != null) {
                privacyPolicyTv = id.h.a.d(o0ooooo2, R$string.mini_privacy_privacy_policy);
            } else {
                privacyPolicyTv = id.h.a.d(o0ooooo2, R$string.mini_privacy_privacy_policy);
            }
            if (userAgreementTv != null) {
                userAgreementTv = id.h.a.d(o0ooooo2, R$string.mini_user_agreement);
            } else {
                userAgreementTv = id.h.a.d(o0ooooo2, R$string.mini_user_agreement);
            }
            if (privacyPolicyUrl != null) {
                privacyPolicyUrl = "https://h5.dlight-app.com/outside/privacy-policy?lang=";
            } else {
                privacyPolicyUrl = "https://h5.dlight-app.com/outside/privacy-policy?lang=";
            }
            if (userAgreementUrl != null) {
                userAgreementUrl = "https://h5.dlight-app.com/outside/user-agreement?lang=";
            } else {
                userAgreementUrl = "https://h5.dlight-app.com/outside/user-agreement?lang=";
            }
            Intrinsics.f(dauAgreeContent, "dauAgreeContent");
            iD0 = StringsKt__StringsKt.d0(dauAgreeContent, Utils.SEPARATOR, 0, false, 6, null);
            iJ0 = StringsKt__StringsKt.j0(dauAgreeContent, Utils.SEPARATOR, 0, false, 6, null);
            iD1 = StringsKt__StringsKt.d0(dauAgreeContent, "*", 0, false, 6, null);
            iJ1 = StringsKt__StringsKt.j0(dauAgreeContent, "*", 0, false, 6, null);
            if (btnBgColor != null) {
                iA = id.h.a.a(o0ooooo2, R$color.mini_color_primary);
            } else {
                iA = id.h.a.a(o0ooooo2, R$color.mini_color_primary);
            }
            textViewX = o0ooooo2.x();
            if (textViewX == null) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append(dauAgreeContent.subSequence(0, iD0));
                d.b(spannableStringBuilder2, BidiFormatter.getInstance().unicodeWrap(privacyPolicyTv), Integer.valueOf(iA), true, new o0OOO0o(privacyPolicyUrl, o0ooooo2));
                spannableStringBuilder2.append(dauAgreeContent.subSequence(iJ0 + 1, iD1));
                d.b(spannableStringBuilder2, BidiFormatter.getInstance().unicodeWrap(userAgreementTv), Integer.valueOf(iA), true, new o0Oo0oo(userAgreementUrl, o0ooooo2));
                spannableStringBuilder2.append(dauAgreeContent.subSequence(iJ1 + 1, dauAgreeContent.length()));
                textViewX.setText(new SpannedString(spannableStringBuilder2));
            }
            textViewX2 = o0ooooo2.x();
            if (textViewX2 == null) {
                textViewX2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            textViewX3 = o0ooooo2.x();
            if (textViewX3 != null) {
                xb.h.b(textViewX3);
            }
        }
        if (btnBgColor != null && btnBgColor.length() > 0) {
            k.a("btnBgColor = ", btnBgColor, o0ooooo2.f155t);
            try {
                TextView textViewY = o0ooooo2.y();
                Drawable background = textViewY != null ? textViewY.getBackground() : null;
                GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(Color.parseColor(btnBgColor));
                }
            } catch (Throwable th3) {
                String str8 = o0ooooo2.f155t;
                StringBuilder sbA2 = j.a("setAgreeBtn:");
                sbA2.append(th3.getMessage());
                TmcLogger.c(str8, sbA2.toString());
            }
        }
        TextView textViewY2 = o0ooooo2.y();
        if (textViewY2 != null) {
            if (agreeBtn == null || str5.length() <= 0) {
                agreeBtn = id.h.a.d(o0ooooo2, R$string.mini_text_agree);
            }
            textViewY2.setText(agreeBtn);
        }
        String asString3 = (cancelBtn == null || (jsonElement2 = cancelBtn.get(o0ooooo2.C)) == null) ? null : jsonElement2.getAsString();
        if (asString3 == null) {
            asString3 = "";
        } else {
            Intrinsics.f(asString3, "config?.get(KEY_TEXT)?.asString ?: \"\"");
        }
        String asString4 = (cancelBtn == null || (jsonElement = cancelBtn.get(o0ooooo2.B)) == null) ? null : jsonElement.getAsString();
        if (asString4 == null) {
            asString4 = "";
        } else {
            Intrinsics.f(asString4, "config?.get(KEY_MODE)?.asString ?: \"\"");
        }
        TextView textView3 = (TextView) o0ooooo2.f161z.getValue();
        if (textView3 != null) {
            if (asString3.length() <= 0) {
                asString3 = (!Intrinsics.b(asString4, o0ooooo2.G) && Intrinsics.b(asString4, o0ooooo2.H)) ? id.h.a.d(o0ooooo2, R$string.mini_dau_guest_mode) : id.h.a.d(o0ooooo2, R$string.mini_can_open_exit);
            }
            textView3.setText(asString3);
        }
        o0ooooo2.q();
        try {
            OooO00o.put(str6, o0ooooo2);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, PushConstants.PUSH_SERVICE_TYPE_SHOW);
            aVar = callback;
            try {
                aVar.d(jsonObject);
            } catch (Throwable unused2) {
                callbackFail(aVar, "", Boolean.TRUE);
            }
        } catch (Throwable unused3) {
            aVar = callback;
        }
    }
}
