package com.transsion.postdetail.viewmodel;

import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomBuiltInHelper$copyVideoFiles$1", f = "RoomBuiltInHelper.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
public final class RoomBuiltInHelper$copyVideoFiles$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PostSubjectItem> $list;
    int label;
    final /* synthetic */ RoomBuiltInHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomBuiltInHelper$copyVideoFiles$1(List<PostSubjectItem> list, RoomBuiltInHelper roomBuiltInHelper, Continuation<? super RoomBuiltInHelper$copyVideoFiles$1> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = roomBuiltInHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomBuiltInHelper$copyVideoFiles$1(this.$list, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomBuiltInHelper$copyVideoFiles$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Media media;
        List<Video> video;
        a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String filepath = DownloadEsHelper.f60994m.a().c().getAbsolutePath();
        List<PostSubjectItem> list = this.$list;
        RoomBuiltInHelper roomBuiltInHelper = this.this$0;
        for (PostSubjectItem postSubjectItem : list) {
            if (postSubjectItem.getBuiltIn() && (media = postSubjectItem.getMedia()) != null && (video = media.getVideo()) != null && (!video.isEmpty())) {
                Media media2 = postSubjectItem.getMedia();
                List<Video> video2 = media2 != null ? media2.getVideo() : null;
                Intrinsics.d(video2);
                Video video3 = video2.get(0);
                String url = video3.getUrl();
                if (url != null) {
                    String title = postSubjectItem.getTitle();
                    if (title == null) {
                        Subject subject = postSubjectItem.getSubject();
                        String title2 = subject != null ? subject.getTitle() : null;
                        title = title2 == null ? "" : title2;
                    }
                    String str = title + ".mp4";
                    Intrinsics.f(filepath, "filepath");
                    if (roomBuiltInHelper.b(filepath, str, url)) {
                        video3.setUrl(filepath + "/" + str);
                        b.a.f(b.f78622a, "copyFile", "copyFile success,new url = " + video3.getUrl() + " ", false, 4, null);
                    }
                }
            }
        }
        return Unit.f68710a;
    }
}
