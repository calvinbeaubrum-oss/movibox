package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.viewmodel.PlayListViewModel$getPlayList$1", f = "PlayListViewModel.kt", l = {22}, m = "invokeSuspend")
public final class PlayListViewModel$getPlayList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $category;
    final /* synthetic */ String $label;
    final /* synthetic */ String $recType;
    final /* synthetic */ int $tabId;
    final /* synthetic */ String $topIds;
    int label;
    final /* synthetic */ PlayListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayListViewModel$getPlayList$1(PlayListViewModel playListViewModel, String str, String str2, String str3, String str4, int i11, Continuation<? super PlayListViewModel$getPlayList$1> continuation) {
        super(2, continuation);
        this.this$0 = playListViewModel;
        this.$label = str;
        this.$category = str2;
        this.$recType = str3;
        this.$topIds = str4;
        this.$tabId = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayListViewModel$getPlayList$1(this.this$0, this.$label, this.$category, this.$recType, this.$topIds, this.$tabId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PlayListViewModel$getPlayList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                rt.a aVar = this.this$0.f52743a;
                int iD = this.this$0.d();
                int i12 = this.this$0.f52746d;
                String str = this.$label;
                String str2 = this.$category;
                String str3 = this.$recType;
                String str4 = this.$topIds;
                int i13 = this.$tabId;
                this.label = 1;
                objA = rt.a.C0833a.a(aVar, null, iD, i12, str, str2, str3, str4, i13, this, 1, null);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objA = obj;
            }
            BaseDto baseDto = (BaseDto) objA;
            if (baseDto.getData() != null) {
                this.this$0.f().n(baseDto.getData());
                PlayListViewModel playListViewModel = this.this$0;
                playListViewModel.g(playListViewModel.d() + 1);
            } else {
                this.this$0.f().n(null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            this.this$0.f().n(null);
        }
        return Unit.f68710a;
    }
}
