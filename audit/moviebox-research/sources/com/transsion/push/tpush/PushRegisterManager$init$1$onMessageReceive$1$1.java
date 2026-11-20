package com.transsion.push.tpush;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.transsion.upload.log.UploadLoggerManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
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
@DebugMetadata(c = "com.transsion.push.tpush.PushRegisterManager$init$1$onMessageReceive$1$1", f = "PushRegisterManager.kt", l = {}, m = "invokeSuspend")
public final class PushRegisterManager$init$1$onMessageReceive$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushRegisterManager$init$1$onMessageReceive$1$1(String str, Continuation<? super PushRegisterManager$init$1$onMessageReceive$1$1> continuation) {
        super(2, continuation);
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushRegisterManager$init$1$onMessageReceive$1$1(this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PushRegisterManager$init$1$onMessageReceive$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String lowerCase;
        String asString;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        JsonObject asJsonObject = JsonParser.parseString(this.$it).getAsJsonObject();
        JsonElement jsonElement = asJsonObject != null ? asJsonObject.get("clientLogsRetrieve") : null;
        b.a.f(b.f78622a, "PushRegisterManager", "clientLogsRetrieve=" + jsonElement, false, 4, null);
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = asString.toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
        }
        if (Intrinsics.b(lowerCase, "true")) {
            UploadLoggerManager.m(UploadLoggerManager.f59261a, null, 1, null);
        }
        return Unit.f68710a;
    }
}
