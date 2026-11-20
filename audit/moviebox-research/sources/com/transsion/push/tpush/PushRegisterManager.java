package com.transsion.push.tpush;

import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import androidx.core.app.NotificationManagerCompat;
import bu.e;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.util.networkinfo.g;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.push.PushManager;
import com.transsion.push.TPushListener;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushNotification;
import com.transsion.push.helper.PushMsgHelper;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import uo.b;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PushRegisterManager implements r00.a, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PushRegisterManager f57004a = new PushRegisterManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f57005b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.push.tpush.PushRegisterManager$pushApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f57006c = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.push.tpush.PushRegisterManager$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f57007d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f57008f = "";

    private final ILoginApi f() {
        return (ILoginApi) f57006c.getValue();
    }

    public static /* synthetic */ void l(PushRegisterManager pushRegisterManager, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = TmcEngineFactory.ENGINE_TYPE_DEFAULT;
        }
        pushRegisterManager.k(str, str2, str3);
    }

    public final boolean e() {
        try {
            return NotificationManagerCompat.from(Utils.a()).areNotificationsEnabled();
        } catch (Exception unused) {
            return true;
        }
    }

    public final a g() {
        return (a) f57005b.getValue();
    }

    public final RequestBody h(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    public final void i(final Application context, boolean z11) {
        Intrinsics.g(context, "context");
        ILoginApi iLoginApiF = f();
        if (iLoginApiF != null) {
            iLoginApiF.F(this);
        }
        f.f49475a.l(this);
        PushManager.getInstance().addCustomNotification(new PushNotification.Builder().setSmallIcon(R$drawable.push_small_logo).setType(1).setShowDefaultLargeIcon(false).build());
        PushManager.getInstance().init(context);
        PushManager.getInstance().registerPushListener(new TPushListener() { // from class: com.transsion.push.tpush.PushRegisterManager$init$1
            @Override // com.transsion.push.TPushListener
            public void onClickException(long j11, String str) {
                b.f78622a.c("PushRegisterManager", "onClickException msgId " + j11 + " reason " + str, true);
            }

            @Override // com.transsion.push.TPushListener
            public void onMessageReceive(long j11, String str, int i11) {
                b.a.f(b.f78622a, "PushRegisterManager", "onMessageReceive msgId " + j11 + " transData=" + str, false, 4, null);
                PushManager.getInstance().trackArrive(j11);
                if (str != null) {
                    Application application = context;
                    try {
                        if (StringsKt__StringsKt.Q(str, "clientLogsRetrieve", false, 2, null)) {
                            j.d(l0.a(w0.b()), null, null, new PushRegisterManager$init$1$onMessageReceive$1$1(str, null), 3, null);
                        } else if (StringsKt__StringsKt.Q(str, "configRefreshPush", false, 2, null)) {
                            ((IRefreshConfig) com.alibaba.android.arouter.launcher.a.d().h(IRefreshConfig.class)).a();
                        } else {
                            MsgBean msgBean = (MsgBean) n.d(str, MsgBean.class);
                            if (msgBean != null) {
                                Intrinsics.f(msgBean, "fromJson(it, MsgBean::class.java)");
                                PushRegisterManager.f57004a.k(String.valueOf(j11), String.valueOf(msgBean.getDeeplink()), "pass");
                                msgBean.setMessageId(String.valueOf(j11));
                                msgBean.setType(MsgType.ONLINE_JSON_PUSH.getType());
                                msgBean.setStyle("1");
                                PushMsgHelper.f56891a.b(application, msgBean);
                            }
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }

            @Override // com.transsion.push.TPushListener
            public void onNotificationShow(long j11, String str) {
                PushRegisterManager.l(PushRegisterManager.f57004a, String.valueOf(j11), str == null ? "" : str, null, 4, null);
                b.a.f(b.f78622a, "PushRegisterManager", "onNotificationShow msgId " + j11 + " landingPage " + str, false, 4, null);
            }

            @Override // com.transsion.push.TPushListener
            public void onPushReceive(long j11, PushMessage pushMessage, int i11) {
            }

            @Override // com.transsion.push.TPushListener
            public void onSdkInitSuccess(String str, String str2) throws JSONException {
                b.a.f(b.f78622a, "PushRegisterManager", "onSdkInitSuccess clientId " + str + "  token " + str2, false, 4, null);
                PushRegisterManager pushRegisterManager = PushRegisterManager.f57004a;
                if (str == null) {
                    str = "";
                }
                pushRegisterManager.m(str);
                if (str2 == null) {
                    str2 = "";
                }
                pushRegisterManager.n(str2);
                pushRegisterManager.j();
            }
        });
    }

    public final void j() throws JSONException {
        String userId;
        UserInfo userInfoP;
        ILoginApi iLoginApiF = f();
        if (iLoginApiF == null || (userInfoP = iLoginApiF.P()) == null || (userId = userInfoP.getUserId()) == null) {
            userId = "";
        }
        if (userId.length() == 0 || f57007d.length() == 0) {
            return;
        }
        boolean zE = e();
        String strA = e.a(userId + "|" + f57007d + "|" + f57008f + "|" + zE);
        if (strA.equals(RoomAppMMKV.f51271a.a().getString("push_ru", ""))) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("twibidaClientId", f57007d);
        jSONObject.put("firebaseToken", f57008f);
        jSONObject.put("notifySwitchOff", !zE);
        j.d(l0.a(w0.b()), null, null, new PushRegisterManager$pushRegister$1(jSONObject, strA, null), 3, null);
    }

    public final void k(String str, String str2, String str3) {
        boolean zE = e();
        HashMap map = new HashMap();
        map.put("msgId", str);
        String str4 = "0";
        map.put("are_notify_enabled", zE ? "1" : "0");
        if (zE && str2.length() > 0) {
            str4 = "1";
        }
        map.put("is_show", str4);
        map.put("channel_type", str3);
        if (str2.length() > 0) {
            map.put("url", str2);
            String queryParameter = Uri.parse(str2).getQueryParameter("msg_type");
            if (queryParameter == null) {
                queryParameter = "";
            }
            map.put("msg_type", queryParameter);
        }
        m.f51277a.n("message_receive", map);
    }

    public final void m(String str) {
        Intrinsics.g(str, "<set-?>");
        f57007d = str;
    }

    public final void n(String str) {
        Intrinsics.g(str, "<set-?>");
        f57008f = str;
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) throws JSONException {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        j();
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    @Override // r00.a
    public void onLogin(UserInfo user) throws JSONException {
        Intrinsics.g(user, "user");
        b.a.f(b.f78622a, "PushRegisterManager", "onLogin " + user.getUserId(), false, 4, null);
        j();
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }
}
