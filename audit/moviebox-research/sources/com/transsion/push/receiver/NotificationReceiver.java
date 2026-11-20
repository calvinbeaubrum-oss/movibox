package com.transsion.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.transsion.push.utils.FSNControl;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.pushapi.TriggerSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uo.b;

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
public final class NotificationReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f56974b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f56975a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void b(Context context) {
        NotificationUtil.f57032a.J(context, TriggerSource.UNLOCK);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0108, code lost:
    
        if (r2.equals("android.intent.action.USER_UNLOCKED") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0115, code lost:
    
        if (r2.equals("android.intent.action.USER_PRESENT") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0119, code lost:
    
        r18.f56975a.postDelayed(new mw.a(r19), 10000);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(final Context context, Intent intent) {
        b.a aVar = b.f78622a;
        b.a.f(aVar, "NotificationReceiver", "onReceiver， context:" + context + " action " + (intent != null ? intent.getAction() : null), false, 4, null);
        if (context != null) {
            FSNControl.f57027a.h(intent != null ? intent.getAction() : null);
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                switch (action.hashCode()) {
                    case -2128145023:
                        if (!action.equals("android.intent.action.SCREEN_OFF")) {
                        }
                        b.a.f(aVar, "NotificationReceiver", "onReceiver， " + intent.getAction(), false, 4, null);
                        break;
                    case -1886648615:
                        if (!action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        }
                        b.a.f(aVar, "NotificationReceiver", "onReceiver， " + intent.getAction(), false, 4, null);
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            NotificationUtil.f57032a.J(context, TriggerSource.SCREEN_ON);
                            break;
                        }
                        break;
                    case 823795052:
                        break;
                    case 833559602:
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            b.a.f(aVar, "NotificationReceiver", "onReceiver， " + intent.getAction(), false, 4, null);
                        }
                        break;
                    case 1083601606:
                        if (action.equals("com.community.oneroom.last_permanent_msg")) {
                            String stringExtra = intent.getStringExtra("MESSAGE_TYPE");
                            String stringExtra2 = intent.getStringExtra("extra_source");
                            String stringExtra3 = intent.getStringExtra("extra_message_id");
                            if (stringExtra3 != null) {
                                NotificationUtil.f57032a.P(context, stringExtra3);
                                com.transsion.push.helper.a.f56923a.a(stringExtra3, stringExtra2, stringExtra, intent.getData(), true, (64 & 32) != 0 ? "" : "notification_last", (64 & 64) != 0 ? "" : null);
                            }
                        }
                        break;
                    case 1884162848:
                        if (action.equals("com.community.oneroom.notification_delete")) {
                            String stringExtra4 = intent.getStringExtra("extra_notification_group_tag");
                            int intExtra = intent.getIntExtra("extra_notification_id", 0);
                            String stringExtra5 = intent.getStringExtra("MESSAGE_TYPE");
                            String stringExtra6 = intent.getStringExtra("extra_source");
                            String stringExtra7 = intent.getStringExtra("extra_message_id");
                            NotificationUtil.f57032a.n(context, stringExtra4, intExtra);
                            com.transsion.push.helper.a.f56923a.a(stringExtra7, stringExtra6, stringExtra5, intent.getData(), true, (64 & 32) != 0 ? "" : "notification_close", (64 & 64) != 0 ? "" : null);
                        }
                        break;
                    case 1950024803:
                        if (action.equals("com.community.oneroom.next_permanent_msg")) {
                            String stringExtra8 = intent.getStringExtra("MESSAGE_TYPE");
                            String stringExtra9 = intent.getStringExtra("extra_source");
                            String stringExtra10 = intent.getStringExtra("extra_message_id");
                            if (stringExtra10 != null) {
                                NotificationUtil.R(NotificationUtil.f57032a, context, stringExtra10, false, 4, null);
                                com.transsion.push.helper.a.f56923a.a(stringExtra10, stringExtra9, stringExtra8, intent.getData(), true, (64 & 32) != 0 ? "" : "notification_next", (64 & 64) != 0 ? "" : null);
                            }
                        }
                        break;
                }
            }
        }
    }
}
