package com.transsion.push.worker;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import com.transsion.push.notification.ToolbarNotificationUtils;
import com.transsion.push.utils.NotificationUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.r0;
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
public final class PullWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f57058f = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f57059d;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.g(context, "context");
        Intrinsics.g(params, "params");
        this.f57059d = context;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    public Object d(Continuation<? super i.a> continuation) throws Throwable {
        PullWorker$doWork$1 pullWorker$doWork$1;
        PullWorker pullWorker;
        if (continuation instanceof PullWorker$doWork$1) {
            pullWorker$doWork$1 = (PullWorker$doWork$1) continuation;
            int i11 = pullWorker$doWork$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                pullWorker$doWork$1.label = i11 - Integer.MIN_VALUE;
            } else {
                pullWorker$doWork$1 = new PullWorker$doWork$1(this, continuation);
            }
        } else {
            pullWorker$doWork$1 = new PullWorker$doWork$1(this, continuation);
        }
        Object obj = pullWorker$doWork$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = pullWorker$doWork$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            int iNextInt = Random.Default.nextInt(0, 120);
            b.a.f(b.f78622a, "PullWorker", "doWork random * " + iNextInt, false, 4, null);
            pullWorker$doWork$1.L$0 = this;
            pullWorker$doWork$1.label = 1;
            if (r0.a(((long) iNextInt) * 1000, pullWorker$doWork$1) == objE) {
                return objE;
            }
            pullWorker = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pullWorker = (PullWorker) pullWorker$doWork$1.L$0;
            ResultKt.b(obj);
        }
        try {
            NotificationUtil notificationUtil = NotificationUtil.f57032a;
            NotificationUtil.K(notificationUtil, pullWorker.f57059d, null, 2, null);
            notificationUtil.r();
            ToolbarNotificationUtils.f56927a.k();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        i.a aVarC = i.a.c();
        Intrinsics.f(aVarC, "success()");
        return aVarC;
    }
}
