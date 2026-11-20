package com.transsion.web.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.f;
import androidx.lifecycle.u;
import c1.j;
import com.tn.lib.widget.toast.core.h;
import com.transsion.share.R$string;
import com.transsion.share.share.i;
import com.transsion.web.fragment.WebFragmentV2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class WebShareUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f60220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, String, Unit> f60221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b1.b<Intent> f60222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f60223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f60224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f60225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f60226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b1.a<ActivityResult> f60228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f60229j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements f {
        public a() {
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.lifecycle.e.b(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onPause(u uVar) {
            androidx.lifecycle.e.c(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onResume(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.d(this, owner);
            WebShareUtil.this.f60224e = 0L;
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onStop(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.f(this, owner);
            if (com.blankj.utilcode.util.c.j()) {
                return;
            }
            WebShareUtil.this.f60224e = SystemClock.elapsedRealtime();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebShareUtil(Fragment fragment, Function2<? super String, ? super String, Unit> shareCallback) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(shareCallback, "shareCallback");
        this.f60220a = fragment;
        this.f60221b = shareCallback;
        this.f60225f = "fail";
        this.f60226g = "cancel";
        this.f60227h = "success";
        b1.a<ActivityResult> aVar = new b1.a() { // from class: com.transsion.web.share.e
            @Override // b1.a
            public final void a(Object obj) {
                WebShareUtil.m(this.f60239a, (ActivityResult) obj);
            }
        };
        this.f60228i = aVar;
        this.f60222c = fragment.registerForActivityResult(new j(), aVar);
        fragment.getLifecycle().a(new a());
        this.f60229j = "";
    }

    public static final void m(WebShareUtil this$0, ActivityResult activityResult) {
        String str;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(activityResult, "activityResult");
        try {
            if (this$0.f60223d) {
                int resultCode = activityResult.getResultCode();
                if (resultCode == -1) {
                    str = this$0.f60227h;
                } else if (resultCode != 0) {
                    str = this$0.f60225f;
                } else {
                    h.f50034a.k(R$string.cancel);
                    str = this$0.f60226g;
                }
            } else if (this$0.f60224e == 0 || SystemClock.elapsedRealtime() - this$0.f60224e < 1500) {
                uo.b.a aVar = uo.b.f78622a;
                String strA = WebFragmentV2.f60174r.a();
                Intrinsics.f(strA, "WebFragmentV2.TAG");
                uo.b.a.f(aVar, strA, "操作太快了 leaveVskitTime:" + this$0.f60224e, false, 4, null);
                str = this$0.f60225f;
            } else {
                str = this$0.f60227h;
            }
            uo.b.a aVar2 = uo.b.f78622a;
            String strA2 = WebFragmentV2.f60174r.a();
            Intrinsics.f(strA2, "WebFragmentV2.TAG");
            uo.b.a.f(aVar2, strA2, "shareResultActivityResultCallback:" + str + "  ----  " + activityResult.getResultCode(), false, 4, null);
            this$0.l(str);
        } catch (Exception unused) {
        }
    }

    public final Intent h(Context context, String str, String str2, String str3) {
        String strI = i(context, str2, str3);
        if (strI == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(strI);
        return intent;
    }

    public final String i(Context context, String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f51450a.c(context, str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f51450a.c(context, str2)) {
            return null;
        }
        return str2;
    }

    public final void j(Activity activity, String data, String callbackId) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        JSONObject jSONObject = new JSONObject(data);
        String strOptString = jSONObject.optString("packageName");
        String shareTxt = jSONObject.optString("txt");
        this.f60229j = callbackId;
        Context context = this.f60220a.getContext();
        if (context == null) {
            return;
        }
        if (Intrinsics.b(strOptString, "copyLink")) {
            ClipData clipDataNewPlainText = ClipData.newPlainText("MovieBox", shareTxt);
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(clipDataNewPlainText);
            }
            h.f50034a.k(com.transsion.web.R$string.web_copied);
            l(this.f60227h);
            return;
        }
        if (strOptString == null || strOptString.length() == 0) {
            l("0");
            return;
        }
        if (TextUtils.equals(strOptString, "com.whatsapp")) {
            i iVar = i.f57758a;
            Intrinsics.f(shareTxt, "shareTxt");
            iVar.d(activity, shareTxt, new Function1<Boolean, Unit>() { // from class: com.transsion.web.share.WebShareUtil$h5ShareNative$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    if (z11) {
                        WebShareUtil webShareUtil = this.this$0;
                        webShareUtil.l(webShareUtil.f60227h);
                    } else {
                        WebShareUtil webShareUtil2 = this.this$0;
                        webShareUtil2.l(webShareUtil2.f60225f);
                        h.f50034a.k(com.transsion.web.R$string.web_app_not_exist);
                    }
                }
            });
        } else if (TextUtils.equals(strOptString, "org.telegram.messenger")) {
            i iVar2 = i.f57758a;
            Intrinsics.f(shareTxt, "shareTxt");
            iVar2.c(activity, shareTxt, new Function1<Boolean, Unit>() { // from class: com.transsion.web.share.WebShareUtil$h5ShareNative$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    if (z11) {
                        WebShareUtil webShareUtil = this.this$0;
                        webShareUtil.l(webShareUtil.f60227h);
                    } else {
                        WebShareUtil webShareUtil2 = this.this$0;
                        webShareUtil2.l(webShareUtil2.f60225f);
                        h.f50034a.k(com.transsion.web.R$string.web_app_not_exist);
                    }
                }
            });
        }
    }

    public final void k(String data, String callbackId, FragmentManager fragmentManager) {
        Intrinsics.g(data, "data");
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(fragmentManager, "fragmentManager");
        this.f60229j = callbackId;
        final Context context = this.f60220a.getContext();
        if (context == null) {
            return;
        }
        try {
            if (fragmentManager.findFragmentByTag("WebShareDialog") != null) {
                return;
            }
            WebShareDialog webShareDialogA = WebShareDialog.f60210h.a(data);
            webShareDialogA.q0(new Function3<String, String, String, Unit>() { // from class: com.transsion.web.share.WebShareUtil$nativeShare$1$1
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
                    if (packageName.length() == 0) {
                        ClipData clipDataNewPlainText = ClipData.newPlainText("MovieBox", txt);
                        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                        if (clipboardManager != null) {
                            clipboardManager.setPrimaryClip(clipDataNewPlainText);
                        }
                        h.f50034a.k(com.transsion.web.R$string.web_copied);
                        WebShareUtil webShareUtil = this;
                        webShareUtil.l(webShareUtil.f60227h);
                        return;
                    }
                    Intent intentH = this.h(context, txt, packageName, str);
                    if (intentH == null) {
                        h.f50034a.k(com.transsion.web.R$string.web_app_not_exist);
                        WebShareUtil webShareUtil2 = this;
                        webShareUtil2.l(webShareUtil2.f60225f);
                        return;
                    }
                    WebShareUtil webShareUtil3 = this;
                    try {
                        Result.Companion companion = Result.Companion;
                        b1.b bVar = webShareUtil3.f60222c;
                        if (bVar != null) {
                            bVar.a(intentH);
                            unit = Unit.f68710a;
                        } else {
                            unit = null;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                    }
                    WebShareUtil webShareUtil4 = this;
                    if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
                        return;
                    }
                    webShareUtil4.l(webShareUtil4.f60225f);
                }
            });
            webShareDialogA.show(fragmentManager, "WebShareDialog");
        } catch (Exception unused) {
            l(this.f60225f);
        }
    }

    public final void l(String str) {
        this.f60221b.invoke(this.f60229j, str);
    }
}
