package com.transsion.transfer.wifi.share;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.u;
import b1.b;
import c1.j;
import com.blankj.utilcode.util.c;
import com.tn.lib.widget.toast.core.h;
import com.transsion.transfer.wifi.qrcode.QrCodeUtil;
import com.transsion.transfer.wifi.util.g;
import com.transsion.web.R$string;
import com.transsion.web.share.WebShareDialog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShareManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f59193a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b<Intent> f59197e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59194b = "fail";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59195c = "cancel";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59196d = "success";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1.a<ActivityResult> f59198f = new b1.a() { // from class: com.transsion.transfer.wifi.share.a
        @Override // b1.a
        public final void a(Object obj) {
            ShareManager.i(this.f59200a, (ActivityResult) obj);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements f {
        public a() {
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onDestroy(u uVar) {
            e.b(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onPause(u uVar) {
            e.c(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onResume(u owner) {
            Intrinsics.g(owner, "owner");
            e.d(this, owner);
            ShareManager.this.f59193a = 0L;
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onStop(u owner) {
            Intrinsics.g(owner, "owner");
            e.f(this, owner);
            if (c.j()) {
                return;
            }
            ShareManager.this.f59193a = SystemClock.elapsedRealtime();
        }
    }

    public static final void i(ShareManager this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(activityResult, "activityResult");
        try {
            String str = (this$0.f59193a == 0 || SystemClock.elapsedRealtime() - this$0.f59193a < 1500) ? this$0.f59194b : this$0.f59196d;
            g.d(g.f59252a, "ShareManager --> shareResultActivityResultCallback --> result = " + str, false, 2, null);
            h.f50034a.l(str);
        } catch (Exception unused) {
        }
    }

    public final Intent e(Context context, String str, String str2, String str3) {
        String strF = f(context, str2, str3);
        if (strF == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(strF);
        return intent;
    }

    public final String f(Context context, String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f51450a.c(context, str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f51450a.c(context, str2)) {
            return null;
        }
        return str2;
    }

    public final String g() {
        return "Enjoy Free Dramas & HD Movies on MovieBox—now with file transfer support! " + QrCodeUtil.f59192a.d();
    }

    public final void h(AppCompatActivity activity) {
        Intrinsics.g(activity, "activity");
        this.f59197e = activity.registerForActivityResult(new j(), this.f59198f);
        activity.getLifecycle().a(new a());
    }

    public final void j(final AppCompatActivity activity) {
        Intrinsics.g(activity, "activity");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("WhatsApp", g());
        jSONObject.put("Telegram", g());
        jSONObject.put("CopyLink", g());
        WebShareDialog.a aVar = WebShareDialog.f60210h;
        String string = jSONObject.toString();
        Intrinsics.f(string, "jsonObject.toString()");
        WebShareDialog webShareDialogA = aVar.a(string);
        webShareDialogA.r0("wifi_share_panel");
        webShareDialogA.s0(false);
        webShareDialogA.q0(new Function3<String, String, String, Unit>() { // from class: com.transsion.transfer.wifi.share.ShareManager$showShareDialog$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3) {
                invoke2(str, str2, str3);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String packageName, String str, String txt) {
                Object objM163constructorimpl;
                Unit unit;
                Intrinsics.g(packageName, "packageName");
                Intrinsics.g(txt, "txt");
                g.h(g.f59252a, "ShareManager --> showShareDialog() --> packageName = " + packageName + " --> backUpPackageName = " + str + " --> txt = " + txt, false, 2, null);
                if (packageName.length() == 0) {
                    ClipData clipDataNewPlainText = ClipData.newPlainText("MovieBox", txt);
                    ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
                    if (clipboardManager != null) {
                        clipboardManager.setPrimaryClip(clipDataNewPlainText);
                    }
                    h.f50034a.k(R$string.web_copied);
                    return;
                }
                Intent intentE = this.e(activity, txt, packageName, str);
                if (intentE == null) {
                    h.f50034a.k(R$string.web_app_not_exist);
                    return;
                }
                ShareManager shareManager = this;
                try {
                    Result.Companion companion = Result.Companion;
                    b bVar = shareManager.f59197e;
                    if (bVar != null) {
                        bVar.a(intentE);
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(unit);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                }
                Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl == null) {
                    return;
                }
                g.d(g.f59252a, "ShareManager --> showShareDialog() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            }
        });
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "activity.supportFragmentManager");
        webShareDialogA.show(supportFragmentManager, "WebShareDialog");
    }
}
