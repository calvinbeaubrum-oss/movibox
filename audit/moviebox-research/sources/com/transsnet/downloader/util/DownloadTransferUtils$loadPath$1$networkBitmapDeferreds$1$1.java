package com.transsnet.downloader.util;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1", f = "DownloadTransferUtils.kt", l = {143}, m = "invokeSuspend")
public final class DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Pair<? extends String, ? extends File>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: renamed from: com.transsnet.downloader.util.DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.util.DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1$1", f = "DownloadTransferUtils.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Pair<? extends String, ? extends File>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(k0 k0Var, Continuation<? super Pair<? extends String, ? extends File>> continuation) {
            return invoke2(k0Var, (Continuation<? super Pair<String, ? extends File>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(k0 k0Var, Continuation<? super Pair<String, ? extends File>> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            File file = Glide.with(this.$context).asFile().load2(this.$url).submit().get();
            uo.b.a.o(uo.b.f78622a, TransferBottomToolsView.TAG, new String[]{"封面加载--完成, url:" + this.$url}, false, 4, null);
            return TuplesKt.a(this.$url, file);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1(String str, Context context, Continuation<? super DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1(this.$url, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k0 k0Var, Continuation<? super Pair<? extends String, ? extends File>> continuation) {
        return invoke2(k0Var, (Continuation<? super Pair<String, ? extends File>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k0 k0Var, Continuation<? super Pair<String, ? extends File>> continuation) {
        return ((DownloadTransferUtils$loadPath$1$networkBitmapDeferreds$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, "封面加载, url:" + this.$url, false, 4, null);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$url, null);
                this.label = 1;
                obj = TimeoutKt.c(300L, anonymousClass1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return (Pair) obj;
        } catch (TimeoutCancellationException e11) {
            e11.printStackTrace();
            uo.b.a.j(uo.b.f78622a, TransferBottomToolsView.TAG, "封面加载超时 " + e11 + "， " + this.$url, false, 4, null);
            return TuplesKt.a(this.$url, null);
        } catch (Exception e12) {
            e12.printStackTrace();
            uo.b.a.j(uo.b.f78622a, TransferBottomToolsView.TAG, "封面加载失败 " + e12 + "， " + this.$url, false, 4, null);
            return TuplesKt.a(this.$url, null);
        }
    }
}
