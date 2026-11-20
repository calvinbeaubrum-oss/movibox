package com.transsion.videodetail.music.ui;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.videodetail.music.ui.MusicDetailFragment$playDownloadMusic$1", f = "MusicDetailFragment.kt", l = {881}, m = "invokeSuspend")
public final class MusicDetailFragment$playDownloadMusic$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicDetailFragment$playDownloadMusic$1(MusicDetailFragment musicDetailFragment, String str, Continuation<? super MusicDetailFragment$playDownloadMusic$1> continuation) {
        super(2, continuation);
        this.this$0 = musicDetailFragment;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MusicDetailFragment$playDownloadMusic$1 musicDetailFragment$playDownloadMusic$1 = new MusicDetailFragment$playDownloadMusic$1(this.this$0, this.$subjectId, continuation);
        musicDetailFragment$playDownloadMusic$1.L$0 = obj;
        return musicDetailFragment$playDownloadMusic$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MusicDetailFragment$playDownloadMusic$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Unit unit;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            k0 k0Var = (k0) this.L$0;
            tr.c cVarM1 = this.this$0.M1();
            String str = this.$subjectId;
            if (str == null) {
                str = "";
            }
            this.L$0 = k0Var;
            this.label = 1;
            obj = cVarM1.z(str, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        DownloadBean downloadBean = (DownloadBean) obj;
        if (downloadBean != null) {
            this.this$0.u2(downloadBean);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            MusicDetailFragment musicDetailFragment = this.this$0;
            sz.a.f76638a.b(musicDetailFragment.j0() + " --> loadData() --> 无网络 无下载");
        }
        return Unit.f68710a;
    }
}
