package com.transsion.subtitle;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
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
@DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleControl$downloadListener$1$onComplete$1", f = "VideoSubtitleControl.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
public final class VideoSubtitleControl$downloadListener$1$onComplete$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleDownloadTable $stDownloadTable;
    int label;
    final /* synthetic */ VideoSubtitleControl this$0;
    final /* synthetic */ VideoSubtitleControl$downloadListener$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoSubtitleControl$downloadListener$1$onComplete$1(SubtitleDownloadTable subtitleDownloadTable, VideoSubtitleControl videoSubtitleControl, VideoSubtitleControl$downloadListener$1 videoSubtitleControl$downloadListener$1, Continuation<? super VideoSubtitleControl$downloadListener$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$stDownloadTable = subtitleDownloadTable;
        this.this$0 = videoSubtitleControl;
        this.this$1 = videoSubtitleControl$downloadListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoSubtitleControl$downloadListener$1$onComplete$1(this.$stDownloadTable, this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((VideoSubtitleControl$downloadListener$1$onComplete$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String resourceId = this.$stDownloadTable.getResourceId();
        DownloadBean downloadBean = this.this$0.f58094p;
        if (!TextUtils.equals(resourceId, downloadBean != null ? downloadBean.getSubtitleResId() : null)) {
            a.f58119a.a(this.this$0.getClass().getSimpleName() + " --> onComplete() --> 字幕下载成功，不是当前视频，不做处理");
            return Unit.f68710a;
        }
        Function1 function1 = this.this$0.f58088j;
        if (function1 != null) {
            function1.invoke(Utils.a().getString(R$string.subtitle_downloaded_successfully));
        }
        vx.a aVar = new vx.a(this.$stDownloadTable);
        Function3 function3 = this.this$0.f58085g;
        String lanName = this.$stDownloadTable.getLanName();
        if (lanName == null) {
            lanName = "";
        }
        String lan = this.$stDownloadTable.getLan();
        if (lan == null) {
            lan = "";
        }
        function3.invoke(lanName, lan, Boxing.d(this.$stDownloadTable.getType()));
        if (this.this$0.G) {
            this.this$1.e(aVar);
        } else {
            this.this$1.h(aVar);
        }
        this.this$1.g();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        for (vx.a aVar2 : this.this$0.f58090l) {
            if (Intrinsics.b(aVar2.b().getId(), aVar.b().getId())) {
                booleanRef.element = false;
                aVar2.h(aVar.b());
            }
        }
        if (booleanRef.element) {
            aVar.l(true);
            aVar.b().setStatus(5);
            this.this$0.f58090l.add(aVar);
            this.this$0.f58087i.invoke(this.this$0.f58090l);
            a.f58119a.a(this.this$0.getClass().getSimpleName() + " --> handleSetImmediately() --> 搜索字幕下载处理");
        }
        String string = RoomAppMMKV.f51271a.a().getString("k_subtitle_language", "");
        if (aVar.b().isSetImmediately() || string == null || string.length() == 0) {
            this.this$0.X(aVar);
        }
        return Unit.f68710a;
    }
}
