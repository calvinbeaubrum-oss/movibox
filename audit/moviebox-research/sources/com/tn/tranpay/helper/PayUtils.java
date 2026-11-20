package com.tn.tranpay.helper;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.tranpay.R$string;
import java.net.URISyntaxException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PayUtils f50173a = new PayUtils();

    public static /* synthetic */ boolean d(PayUtils payUtils, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "tran_pay";
        }
        return payUtils.c(str, str2);
    }

    public static final void j(Function0 onConfirm, DialogInterface dialogInterface, int i11) {
        Intrinsics.g(onConfirm, "$onConfirm");
        dialogInterface.dismiss();
        onConfirm.invoke();
    }

    public static final void k(Function0 onCancel, DialogInterface dialogInterface, int i11) {
        Intrinsics.g(onCancel, "$onCancel");
        dialogInterface.dismiss();
        onCancel.invoke();
    }

    public final boolean c(String str, String tag) {
        Object objM163constructorimpl;
        Intrinsics.g(tag, "tag");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            PackageManager packageManager = Utils.a().getPackageManager();
            if (str == null) {
                str = "";
            }
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf(packageManager.getPackageInfo(str, 0) != null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            fq.a.f65215a.d(tag, "PayUtils --> checkAppInstalled() --> 获取包信息失败");
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean e(String link) {
        Intrinsics.g(link, "link");
        Uri uri = Uri.parse(link);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != -1183762788) {
                if (iHashCode != 3213448) {
                    Intrinsics.f(uri, "uri");
                    return f(uri);
                }
                Intrinsics.f(uri, "uri");
                return f(uri);
            }
            if (scheme.equals("intent")) {
                return g(link);
            }
        }
        fq.a.e(fq.a.f65215a, "handleAppLink: can't handle this type of link.", null, 2, null);
        return false;
    }

    public final boolean f(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(ASTNode.DEOP);
        try {
            Utils.a().startActivity(intent);
            return true;
        } catch (Exception e11) {
            fq.a.e(fq.a.f65215a, "handleAppLink: " + e11, null, 2, null);
            return false;
        }
    }

    public final boolean g(String link) {
        Intrinsics.g(link, "link");
        try {
            Intent uri = Intent.parseUri(link, 1);
            uri.addFlags(ASTNode.DEOP);
            if (!d(this, uri.getPackage(), null, 2, null)) {
                fq.a.e(fq.a.f65215a, "handleAppLink: can't find app to handle this link.", null, 2, null);
                return false;
            }
            try {
                Utils.a().startActivity(uri);
                return true;
            } catch (Exception e11) {
                fq.a.e(fq.a.f65215a, "handleAppLink: " + e11, null, 2, null);
                return false;
            }
        } catch (ActivityNotFoundException e12) {
            fq.a.e(fq.a.f65215a, "handleAppLink: " + e12 + ", activity not found", null, 2, null);
            return false;
        } catch (URISyntaxException e13) {
            fq.a.e(fq.a.f65215a, "handleAppLink: " + e13 + ", invalid URI", null, 2, null);
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:12|13|35|40|22|(1:24)(1:25)) */
    /* JADX WARN: Code duplicated, block: B:24:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0089  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
    
        r17 = r3;
        r4 = r1;
        r1 = r10;
        r3 = r11;
        r10 = r8;
        r8 = r12;
        r12 = r17;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00ae, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e3 -> B:13:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object h(long j11, long j12, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        PayUtils$retryWithFixedIntervalAndTimeLimit$1 payUtils$retryWithFixedIntervalAndTimeLimit$1;
        PayUtils$retryWithFixedIntervalAndTimeLimit$1 payUtils$retryWithFixedIntervalAndTimeLimit$2;
        Object obj;
        long jCurrentTimeMillis;
        long j13;
        long j14;
        Function1<? super Continuation<? super T>, ? extends Object> function2;
        long j15;
        long j16;
        long j17;
        Function1<? super Continuation<? super T>, ? extends Object> function3;
        if (continuation instanceof PayUtils$retryWithFixedIntervalAndTimeLimit$1) {
            payUtils$retryWithFixedIntervalAndTimeLimit$1 = (PayUtils$retryWithFixedIntervalAndTimeLimit$1) continuation;
            int i11 = payUtils$retryWithFixedIntervalAndTimeLimit$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                payUtils$retryWithFixedIntervalAndTimeLimit$1.label = i11 - Integer.MIN_VALUE;
            } else {
                payUtils$retryWithFixedIntervalAndTimeLimit$1 = new PayUtils$retryWithFixedIntervalAndTimeLimit$1(this, continuation);
            }
        } else {
            payUtils$retryWithFixedIntervalAndTimeLimit$1 = new PayUtils$retryWithFixedIntervalAndTimeLimit$1(this, continuation);
        }
        Object objG = payUtils$retryWithFixedIntervalAndTimeLimit$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = payUtils$retryWithFixedIntervalAndTimeLimit$1.label;
        int i13 = 1;
        if (i12 == 0) {
            ResultKt.b(objG);
            payUtils$retryWithFixedIntervalAndTimeLimit$2 = payUtils$retryWithFixedIntervalAndTimeLimit$1;
            obj = objE;
            jCurrentTimeMillis = System.currentTimeMillis();
            j13 = j11;
            j14 = j12;
            function2 = function1;
            CoroutineDispatcher coroutineDispatcherA = w0.a();
            PayUtils$retryWithFixedIntervalAndTimeLimit$2 payUtils$retryWithFixedIntervalAndTimeLimit$3 = new PayUtils$retryWithFixedIntervalAndTimeLimit$2(function2, null);
            payUtils$retryWithFixedIntervalAndTimeLimit$2.L$0 = function2;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.J$0 = j13;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.J$1 = j14;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.J$2 = jCurrentTimeMillis;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.label = i13;
            objG = h.g(coroutineDispatcherA, payUtils$retryWithFixedIntervalAndTimeLimit$3, payUtils$retryWithFixedIntervalAndTimeLimit$2);
            if (objG == obj) {
                return obj;
            }
            long j18 = j13;
            function3 = function2;
            payUtils$retryWithFixedIntervalAndTimeLimit$1 = payUtils$retryWithFixedIntervalAndTimeLimit$2;
            objE = obj;
            j16 = j14;
            j17 = jCurrentTimeMillis;
            j15 = j18;
        } else if (i12 == 1) {
            j17 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$2;
            j16 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$1;
            j15 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$0;
            function3 = (Function1) payUtils$retryWithFixedIntervalAndTimeLimit$1.L$0;
            try {
                ResultKt.b(objG);
            } catch (Exception e11) {
                Exception e12 = e11;
                if ((System.currentTimeMillis() - j17) + j15 > j16) {
                    fq.a.g(fq.a.f65215a, "Exceeded maximum retry time", null, 2, null);
                    throw new TimeoutException("Exceeded maximum retry time");
                }
                fq.a.e(fq.a.f65215a, "Action failed: " + e12.getMessage() + ". Retrying in " + j15 + "ms", null, 2, null);
                payUtils$retryWithFixedIntervalAndTimeLimit$1.L$0 = function3;
                payUtils$retryWithFixedIntervalAndTimeLimit$1.J$0 = j15;
                payUtils$retryWithFixedIntervalAndTimeLimit$1.J$1 = j16;
                payUtils$retryWithFixedIntervalAndTimeLimit$1.J$2 = j17;
                payUtils$retryWithFixedIntervalAndTimeLimit$1.label = 2;
                if (r0.a(j15, payUtils$retryWithFixedIntervalAndTimeLimit$1) == objE) {
                    return objE;
                }
                long j19 = j16;
                payUtils$retryWithFixedIntervalAndTimeLimit$2 = payUtils$retryWithFixedIntervalAndTimeLimit$1;
                obj = objE;
                function2 = function3;
                j13 = j15;
                jCurrentTimeMillis = j17;
                j14 = j19;
                i13 = 1;
                CoroutineDispatcher coroutineDispatcherA2 = w0.a();
                PayUtils$retryWithFixedIntervalAndTimeLimit$2 payUtils$retryWithFixedIntervalAndTimeLimit$4 = new PayUtils$retryWithFixedIntervalAndTimeLimit$2(function2, null);
                payUtils$retryWithFixedIntervalAndTimeLimit$2.L$0 = function2;
                payUtils$retryWithFixedIntervalAndTimeLimit$2.J$0 = j13;
                payUtils$retryWithFixedIntervalAndTimeLimit$2.J$1 = j14;
                payUtils$retryWithFixedIntervalAndTimeLimit$2.J$2 = jCurrentTimeMillis;
                payUtils$retryWithFixedIntervalAndTimeLimit$2.label = i13;
                objG = h.g(coroutineDispatcherA2, payUtils$retryWithFixedIntervalAndTimeLimit$4, payUtils$retryWithFixedIntervalAndTimeLimit$2);
                if (objG == obj) {
                    return obj;
                }
                long j110 = j13;
                function3 = function2;
                payUtils$retryWithFixedIntervalAndTimeLimit$1 = payUtils$retryWithFixedIntervalAndTimeLimit$2;
                objE = obj;
                j16 = j14;
                j17 = jCurrentTimeMillis;
                j15 = j110;
            }
        } else {
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j17 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$2;
            j16 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$1;
            j15 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$0;
            function3 = (Function1) payUtils$retryWithFixedIntervalAndTimeLimit$1.L$0;
            ResultKt.b(objG);
            long j111 = j16;
            payUtils$retryWithFixedIntervalAndTimeLimit$2 = payUtils$retryWithFixedIntervalAndTimeLimit$1;
            obj = objE;
            function2 = function3;
            j13 = j15;
            jCurrentTimeMillis = j17;
            j14 = j111;
            i13 = 1;
            CoroutineDispatcher coroutineDispatcherA3 = w0.a();
            PayUtils$retryWithFixedIntervalAndTimeLimit$2 payUtils$retryWithFixedIntervalAndTimeLimit$5 = new PayUtils$retryWithFixedIntervalAndTimeLimit$2(function2, null);
            payUtils$retryWithFixedIntervalAndTimeLimit$2.L$0 = function2;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.J$0 = j13;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.J$1 = j14;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.J$2 = jCurrentTimeMillis;
            payUtils$retryWithFixedIntervalAndTimeLimit$2.label = i13;
            objG = h.g(coroutineDispatcherA3, payUtils$retryWithFixedIntervalAndTimeLimit$5, payUtils$retryWithFixedIntervalAndTimeLimit$2);
            if (objG == obj) {
                return obj;
            }
            long j112 = j13;
            function3 = function2;
            payUtils$retryWithFixedIntervalAndTimeLimit$1 = payUtils$retryWithFixedIntervalAndTimeLimit$2;
            objE = obj;
            j16 = j14;
            j17 = jCurrentTimeMillis;
            j15 = j112;
        }
        fq.a.c(fq.a.f65215a, "Action succeeded", null, 2, null);
        return objG;
    }

    public final void i(Context context, final Function0<Unit> onConfirm, final Function0<Unit> onCancel) {
        Intrinsics.g(context, "context");
        Intrinsics.g(onConfirm, "onConfirm");
        Intrinsics.g(onCancel, "onCancel");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R$string.pay_abandon_transaction));
        builder.setPositiveButton(context.getString(R$string.pay_confirm), new DialogInterface.OnClickListener() { // from class: com.tn.tranpay.helper.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                PayUtils.j(onConfirm, dialogInterface, i11);
            }
        });
        builder.setNegativeButton(context.getString(R$string.pay_cancel), new DialogInterface.OnClickListener() { // from class: com.tn.tranpay.helper.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                PayUtils.k(onCancel, dialogInterface, i11);
            }
        });
        builder.create().show();
    }
}
