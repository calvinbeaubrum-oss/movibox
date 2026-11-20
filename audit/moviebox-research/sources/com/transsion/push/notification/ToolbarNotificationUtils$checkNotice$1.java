package com.transsion.push.notification;

import com.blankj.utilcode.util.n;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.push.bean.ToolbarNoticeConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
@DebugMetadata(c = "com.transsion.push.notification.ToolbarNotificationUtils$checkNotice$1", f = "ToolbarNotificationUtils.kt", l = {111}, m = "invokeSuspend")
public final class ToolbarNotificationUtils$checkNotice$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public ToolbarNotificationUtils$checkNotice$1(Continuation<? super ToolbarNotificationUtils$checkNotice$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ToolbarNotificationUtils$checkNotice$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ToolbarNotificationUtils$checkNotice$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ToolbarNoticeConfig toolbarNoticeConfig;
        String value;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                Result.Companion companion = Result.Companion;
                uo.b.a.s(uo.b.f78622a, "ToolbarNo", "checkNotice-----", false, 4, null);
                try {
                    ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_toolbar_notice", false, 2, null);
                    toolbarNoticeConfig = (configBeanC == null || (value = configBeanC.getValue()) == null) ? null : (ToolbarNoticeConfig) n.d(value, ToolbarNoticeConfig.class);
                } catch (Exception unused) {
                }
                int days = toolbarNoticeConfig != null ? toolbarNoticeConfig.getDays() : 3;
                ToolbarNotificationUtils.f56931e = toolbarNoticeConfig;
                ToolbarNotificationUtils toolbarNotificationUtils = ToolbarNotificationUtils.f56927a;
                toolbarNotificationUtils.y(toolbarNoticeConfig);
                if (toolbarNotificationUtils.u(days)) {
                    a2 a2VarC = w0.c();
                    ToolbarNotificationUtils$checkNotice$1$1$1 toolbarNotificationUtils$checkNotice$1$1$1 = new ToolbarNotificationUtils$checkNotice$1$1$1(null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, toolbarNotificationUtils$checkNotice$1$1$1, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        return Unit.f68710a;
    }
}
