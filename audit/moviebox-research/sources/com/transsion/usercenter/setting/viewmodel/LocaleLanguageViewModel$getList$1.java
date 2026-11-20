package com.transsion.usercenter.setting.viewmodel;

import com.transsion.baselib.locale.LocaleManager;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.usercenter.setting.viewmodel.LocaleLanguageViewModel$getList$1", f = "LocaleLanguageViewModel.kt", l = {}, m = "invokeSuspend")
public final class LocaleLanguageViewModel$getList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocaleLanguageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocaleLanguageViewModel$getList$1(LocaleLanguageViewModel localeLanguageViewModel, Continuation<? super LocaleLanguageViewModel$getList$1> continuation) {
        super(2, continuation);
        this.this$0 = localeLanguageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocaleLanguageViewModel$getList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocaleLanguageViewModel$getList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean zB;
        a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        LocaleManager.b bVar = LocaleManager.f51198f;
        Locale localeI = bVar.e().i();
        if (localeI != null) {
            LocaleLanguageViewModel localeLanguageViewModel = this.this$0;
            boolean zO = bVar.e().o(localeI);
            String language = localeI.getLanguage();
            String[] strArrG = bVar.g();
            String[] strArrF = bVar.f();
            ArrayList arrayList = new ArrayList();
            int length = strArrG.length;
            int i11 = 0;
            while (i11 < length) {
                kz.a aVar = new kz.a();
                aVar.c(strArrG[i11]);
                aVar.e(strArrF[i11]);
                if (zO) {
                    zB = i11 == 0;
                } else {
                    zB = Intrinsics.b(language, strArrF[i11]);
                }
                aVar.d(zB);
                arrayList.add(aVar);
                i11++;
            }
            localeLanguageViewModel.d().n(arrayList);
        }
        return Unit.f68710a;
    }
}
