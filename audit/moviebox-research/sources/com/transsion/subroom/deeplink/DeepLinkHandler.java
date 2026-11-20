package com.transsion.subroom.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.transsion.baselib.report.c;
import com.transsion.baseui.activity.d;
import com.transsion.push.PushManager;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.helper.PushPermanentManager;
import com.transsion.push.notification.ToolbarNotificationUtils;
import com.transsion.push.utils.NotificationUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.k;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import r3.a;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DeepLinkHandler extends AppCompatActivity implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58045a = "deeplink_Handler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58046b;

    public DeepLinkHandler() {
        final Function0 function0 = null;
        this.f58046b = new ViewModelLazy(Reflection.b(LaunchViewModel.class), new Function0<x0>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<a>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                a aVar;
                Function0 function1 = function0;
                return (function1 == null || (aVar = (a) function1.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    public final void L() {
        String stringExtra = getIntent().getStringExtra("extra_notification_group_tag");
        int intExtra = getIntent().getIntExtra("extra_notification_id", 0);
        String strO = O();
        String stringExtra2 = getIntent().getStringExtra("MESSAGE_TYPE");
        String stringExtra3 = getIntent().getStringExtra("extra_message_style");
        String stringExtra4 = getIntent().getStringExtra("extra_source");
        boolean z11 = intExtra == 111;
        Uri data = getIntent().getData();
        if (strO == null) {
            strO = null;
            stringExtra2 = data != null ? data.getQueryParameter("msg_type") : null;
            if (data != null) {
                strO = data.getQueryParameter("msgId");
            }
        }
        String str = stringExtra2;
        b.a.f(b.f78622a, this.f58045a, "clearNotification， notificationId:" + intExtra + " messageId " + ((Object) strO) + " messageType " + ((Object) str) + " source" + stringExtra4, false, 4, null);
        if (strO != null) {
            if (Intrinsics.b(str, MsgType.ONLINE_JSON_PUSH.getType())) {
                PushManager pushManager = PushManager.getInstance();
                Long lN = k.n(strO);
                pushManager.trackClick(lN != null ? lN.longValue() : 0L);
            }
            com.transsion.push.helper.a.f56923a.a(strO, stringExtra4, str, data, z11, (64 & 32) != 0 ? "" : stringExtra3, (64 & 64) != 0 ? "" : null);
        }
        R(strO, z11);
        if (!z11) {
            NotificationUtil.f57032a.n(getApplicationContext(), stringExtra, intExtra);
            return;
        }
        if (PushConfigHelper.INSTANCE.isAbType()) {
            PushPermanentManager.f56895a.p(String.valueOf(data));
            return;
        }
        NotificationUtil notificationUtil = NotificationUtil.f57032a;
        Context applicationContext = getApplicationContext();
        Intrinsics.f(applicationContext, "applicationContext");
        notificationUtil.Q(applicationContext, strO, true);
    }

    public final LaunchViewModel M() {
        return (LaunchViewModel) this.f58046b.getValue();
    }

    public final String O() {
        return getIntent().getStringExtra("extra_message_id");
    }

    public final void Q(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        b.a.f(b.f78622a, this.f58045a, "appLinkData " + data + " type=" + intent.getType(), false, 4, null);
        try {
            L();
            ToolbarNotificationUtils.f56927a.x(intent);
            M().h(this, data, new Function0<Unit>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$handleIntent$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.overridePendingTransition(0, 0);
                    this.this$0.finish();
                }
            });
            if (data.getBooleanQueryParameter("withoutAd", false)) {
                return;
            }
            overridePendingTransition(0, 0);
            finish();
        } catch (Exception e11) {
            b.a.f(b.f78622a, this.f58045a, "处理 appLinkData " + data + " 异常:" + e11.getMessage(), false, 4, null);
            finish();
        }
    }

    public final void R(String str, boolean z11) {
        j.d(l0.a(w0.b()), null, null, new DeepLinkHandler$updateMsgStatus$1(str, this, z11, null), 3, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.f(intent, "intent");
        Q(intent);
        d.d(null, this, 1, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.f(null, this, 1, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.g(intent, "intent");
        super.onNewIntent(intent);
        Q(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.k(null, this, 1, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.o(null, this, 1, null);
    }
}
