package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends ComponentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b1.b<IntentSenderRequest> f16296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public ResultReceiver f16297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ResultReceiver f16298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ResultReceiver f16299d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16301g;

    public final Intent H(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    public final Intent I() {
        getApplicationContext().getPackageName();
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    public void J(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        int iZzc = zzb.zzc(data, "ProxyBillingActivity");
        ResultReceiver resultReceiver = this.f16299d;
        if (resultReceiver != null) {
            resultReceiver.send(iZzc, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || iZzc != 0) {
            zzb.zzk("ProxyBillingActivity", "Alternative billing only dialog finished with resultCode " + activityResult.getResultCode() + " and billing's responseCode: " + iZzc);
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        Intent intentI;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100 || i11 == 110) {
            int iZzc = zzb.zzc(intent, "ProxyBillingActivity");
            if (i12 != -1) {
                zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + i12 + " and billing's responseCode: " + iZzc);
            } else if (iZzc != 0) {
                i12 = -1;
                zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + i12 + " and billing's responseCode: " + iZzc);
            } else {
                iZzc = 0;
            }
            ResultReceiver resultReceiver = this.f16297b;
            if (resultReceiver != null) {
                resultReceiver.send(iZzc, intent != null ? intent.getExtras() : null);
            } else {
                if (intent == null) {
                    intentI = I();
                } else if (intent.getExtras() != null) {
                    String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                    if (string != null) {
                        intentI = H(string);
                        intentI.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    } else {
                        intentI = I();
                        intentI.putExtras(intent.getExtras());
                        intentI.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    }
                } else {
                    intentI = I();
                    zzb.zzk("ProxyBillingActivity", "Got null bundle!");
                    intentI.putExtra("RESPONSE_CODE", 6);
                    intentI.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    n.a aVarC = n.c();
                    aVarC.c(6);
                    aVarC.b("An internal error occurred.");
                    intentI.putExtra("FAILURE_LOGGING_PAYLOAD", m0.a(22, 2, aVarC.a()).zzc());
                    intentI.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                if (i11 == 110) {
                    intentI.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentI);
            }
        } else if (i11 == 101) {
            int iZza = zzb.zza(intent, "ProxyBillingActivity");
            ResultReceiver resultReceiver2 = this.f16298c;
            if (resultReceiver2 != null) {
                resultReceiver2.send(iZza, intent != null ? intent.getExtras() : null);
            }
        } else {
            zzb.zzk("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i11 + "; skipping...");
        }
        this.f16300f = false;
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PendingIntent pendingIntent;
        int i11;
        super.onCreate(bundle);
        this.f16296a = registerForActivityResult(new c1.k(), new b1.a() { // from class: com.android.billingclient.api.d1
            @Override // b1.a
            public final void a(Object obj) {
                this.f16318a.J((ActivityResult) obj);
            }
        });
        if (bundle != null) {
            zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f16300f = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.f16297b = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f16298c = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            } else if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f16299d = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
            }
            this.f16301g = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f16299d = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f16296a.a(new IntentSenderRequest.a(pendingIntent2).a());
            return;
        }
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f16301g = true;
                i11 = Worker.WHAT_QUIT;
            } else {
                i11 = 100;
            }
        } else {
            if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.f16297b = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.f16298c = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
                i11 = 101;
            } else {
                pendingIntent = null;
            }
            i11 = 100;
        }
        try {
            this.f16300f = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i11, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e11) {
            zzb.zzl("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e11);
            ResultReceiver resultReceiver = this.f16297b;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.f16298c;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent intentI = I();
                    if (this.f16301g) {
                        intentI.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    intentI.putExtra("RESPONSE_CODE", 6);
                    intentI.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(intentI);
                }
            }
            this.f16300f = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f16300f) {
            Intent intentI = I();
            intentI.putExtra("RESPONSE_CODE", 1);
            intentI.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(intentI);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f16297b;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f16298c;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.f16299d;
        if (resultReceiver3 != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver3);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f16300f);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f16301g);
    }
}
