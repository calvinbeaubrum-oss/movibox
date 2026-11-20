package com.transsnet.downloader.adapter;

import android.app.Activity;
import android.view.View;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "com.transsnet.downloader.adapter.DownloadedHolder$openMedia$1", f = "DownloadedHolder.kt", l = {425, 425}, m = "invokeSuspend")
public final class DownloadedHolder$openMedia$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $item;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadedHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadedHolder$openMedia$1(DownloadedHolder downloadedHolder, DownloadBean downloadBean, Continuation<? super DownloadedHolder$openMedia$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadedHolder;
        this.$item = downloadBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadedHolder$openMedia$1(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadedHolder$openMedia$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0070  */
    /* JADX WARN: Code duplicated, block: B:27:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    /* JADX WARN: Code duplicated, block: B:36:0x012d A[Catch: all -> 0x0146, TryCatch #0 {all -> 0x0146, blocks: (B:34:0x0123, B:36:0x012d, B:40:0x0153, B:39:0x0148), top: B:71:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0148 A[Catch: all -> 0x0146, TryCatch #0 {all -> 0x0146, blocks: (B:34:0x0123, B:36:0x012d, B:40:0x0153, B:39:0x0148), top: B:71:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0176  */
    /* JADX WARN: Code duplicated, block: B:48:0x018c  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [T, com.transsion.baselib.db.audio.AudioBean] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object objD;
        rr.a aVarQ;
        T t11;
        Object objC;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        IAudioApi iAudioApiR;
        IAudioApi iAudioApiR2;
        IFloatingApi iFloatingApiS;
        DownloadBean downloadBean;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                objectRef = (Ref.ObjectRef) this.L$1;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                objectRef2 = objectRef5;
                objD = obj;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef3 = (Ref.ObjectRef) this.L$1;
                objectRef4 = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                objC = obj;
            }
            objectRef2 = objectRef4;
            objectRef = objectRef3;
            t11 = (AudioBean) objC;
            objectRef.element = t11;
            if (objectRef2.element == 0) {
                ?? audioBean = new AudioBean(this.$item.getUrl(), this.$item.getCover(), Boxing.e(0L), this.$item.getSize(), this.$item.getPath(), this.$item.getName(), null, null, null, null, null, null, null, this.$item.getPostId(), this.$item.getSubjectId(), null, 0, this.$item.getSubjectName(), this.$item.getSe(), this.$item.getEp(), 106432, null);
                objectRef2.element = audioBean;
                audioBean.setPostId(this.$item.getPostId());
                ((AudioBean) objectRef2.element).setResourceId(this.$item.getResourceId());
                ((AudioBean) objectRef2.element).setSubjectId(this.$item.getSubjectId());
                ((AudioBean) objectRef2.element).setGroupId(this.$item.getGroupId());
                downloadBean = this.$item;
                try {
                    Result.Companion companion = Result.Companion;
                    if (downloadBean.getEpse() > 100) {
                        int epse = downloadBean.getEpse() / 100;
                        int epse2 = downloadBean.getEpse() % 100;
                        ((AudioBean) objectRef2.element).setSe(epse);
                        ((AudioBean) objectRef2.element).setEp(epse2);
                    } else {
                        ((AudioBean) objectRef2.element).setEp(downloadBean.getEpse());
                    }
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
            if (!Intrinsics.b(((AudioBean) objectRef2.element).getUrl(), this.$item.getPath())) {
                ((AudioBean) objectRef2.element).setUrl(this.$item.getPath());
            }
            iAudioApiR = this.this$0.r();
            if (iAudioApiR == null && iAudioApiR.p1()) {
                IAudioApi iAudioApiR3 = this.this$0.r();
                if (iAudioApiR3 == null || !iAudioApiR3.D((AudioBean) objectRef2.element)) {
                    IAudioApi iAudioApiR4 = this.this$0.r();
                    if (iAudioApiR4 != null) {
                        IAudioApi.a.a(iAudioApiR4, (AudioBean) objectRef2.element, false, 2, null);
                    }
                } else {
                    IAudioApi iAudioApiR5 = this.this$0.r();
                    if (iAudioApiR5 != null) {
                        iAudioApiR5.pause();
                    }
                }
            } else {
                iAudioApiR2 = this.this$0.r();
                if (iAudioApiR2 != null) {
                    IAudioApi.a.a(iAudioApiR2, (AudioBean) objectRef2.element, false, 2, null);
                }
            }
            iFloatingApiS = this.this$0.s();
            if (iFloatingApiS != null) {
                View viewT = this.this$0.t();
                iFloatingApiS.y(new WeakReference<>((Activity) (viewT != null ? viewT.getContext() : null)), (AudioBean) objectRef2.element);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        objectRef = new Ref.ObjectRef();
        rr.a aVarQ2 = this.this$0.q();
        if (aVarQ2 != null) {
            String resourceId = this.$item.getResourceId();
            if (resourceId == null) {
                resourceId = this.$item.getUrl();
            }
            this.L$0 = objectRef;
            this.L$1 = objectRef;
            this.label = 1;
            objD = aVarQ2.d(resourceId, this);
            if (objD == objE) {
                return objE;
            }
            objectRef2 = objectRef;
        } else {
            objectRef2 = objectRef;
        }
        aVarQ = this.this$0.q();
        if (aVarQ != null) {
            String url = this.$item.getUrl();
            this.L$0 = objectRef2;
            this.L$1 = objectRef;
            this.label = 2;
            objC = aVarQ.c(url, this);
            if (objC == objE) {
                return objE;
            }
            objectRef3 = objectRef;
            objectRef4 = objectRef2;
            objectRef2 = objectRef4;
            objectRef = objectRef3;
            t11 = (AudioBean) objC;
        } else {
            t11 = 0;
        }
        objectRef.element = t11;
        if (objectRef2.element == 0) {
            ?? audioBean2 = new AudioBean(this.$item.getUrl(), this.$item.getCover(), Boxing.e(0L), this.$item.getSize(), this.$item.getPath(), this.$item.getName(), null, null, null, null, null, null, null, this.$item.getPostId(), this.$item.getSubjectId(), null, 0, this.$item.getSubjectName(), this.$item.getSe(), this.$item.getEp(), 106432, null);
            objectRef2.element = audioBean2;
            audioBean2.setPostId(this.$item.getPostId());
            ((AudioBean) objectRef2.element).setResourceId(this.$item.getResourceId());
            ((AudioBean) objectRef2.element).setSubjectId(this.$item.getSubjectId());
            ((AudioBean) objectRef2.element).setGroupId(this.$item.getGroupId());
            downloadBean = this.$item;
            Result.Companion companion3 = Result.Companion;
            if (downloadBean.getEpse() > 100) {
                int epse3 = downloadBean.getEpse() / 100;
                int epse4 = downloadBean.getEpse() % 100;
                ((AudioBean) objectRef2.element).setSe(epse3);
                ((AudioBean) objectRef2.element).setEp(epse4);
            } else {
                ((AudioBean) objectRef2.element).setEp(downloadBean.getEpse());
            }
            Result.m163constructorimpl(Unit.f68710a);
        }
        if (!Intrinsics.b(((AudioBean) objectRef2.element).getUrl(), this.$item.getPath())) {
            ((AudioBean) objectRef2.element).setUrl(this.$item.getPath());
        }
        iAudioApiR = this.this$0.r();
        if (iAudioApiR == null) {
            iAudioApiR2 = this.this$0.r();
            if (iAudioApiR2 != null) {
                IAudioApi.a.a(iAudioApiR2, (AudioBean) objectRef2.element, false, 2, null);
            }
        } else {
            iAudioApiR2 = this.this$0.r();
            if (iAudioApiR2 != null) {
                IAudioApi.a.a(iAudioApiR2, (AudioBean) objectRef2.element, false, 2, null);
            }
        }
        iFloatingApiS = this.this$0.s();
        if (iFloatingApiS != null) {
            View viewT2 = this.this$0.t();
            iFloatingApiS.y(new WeakReference<>((Activity) (viewT2 != null ? viewT2.getContext() : null)), (AudioBean) objectRef2.element);
        }
        return Unit.f68710a;
        AudioBean audioBean3 = (AudioBean) objD;
        t11 = audioBean3;
        if (audioBean3 == null) {
            aVarQ = this.this$0.q();
            if (aVarQ != null) {
                String url2 = this.$item.getUrl();
                this.L$0 = objectRef2;
                this.L$1 = objectRef;
                this.label = 2;
                objC = aVarQ.c(url2, this);
                if (objC == objE) {
                    return objE;
                }
                objectRef3 = objectRef;
                objectRef4 = objectRef2;
                objectRef2 = objectRef4;
                objectRef = objectRef3;
                t11 = (AudioBean) objC;
            } else {
                t11 = 0;
            }
        }
        objectRef.element = t11;
        if (objectRef2.element == 0) {
            ?? audioBean4 = new AudioBean(this.$item.getUrl(), this.$item.getCover(), Boxing.e(0L), this.$item.getSize(), this.$item.getPath(), this.$item.getName(), null, null, null, null, null, null, null, this.$item.getPostId(), this.$item.getSubjectId(), null, 0, this.$item.getSubjectName(), this.$item.getSe(), this.$item.getEp(), 106432, null);
            objectRef2.element = audioBean4;
            audioBean4.setPostId(this.$item.getPostId());
            ((AudioBean) objectRef2.element).setResourceId(this.$item.getResourceId());
            ((AudioBean) objectRef2.element).setSubjectId(this.$item.getSubjectId());
            ((AudioBean) objectRef2.element).setGroupId(this.$item.getGroupId());
            downloadBean = this.$item;
            Result.Companion companion4 = Result.Companion;
            if (downloadBean.getEpse() > 100) {
                int epse5 = downloadBean.getEpse() / 100;
                int epse6 = downloadBean.getEpse() % 100;
                ((AudioBean) objectRef2.element).setSe(epse5);
                ((AudioBean) objectRef2.element).setEp(epse6);
            } else {
                ((AudioBean) objectRef2.element).setEp(downloadBean.getEpse());
            }
            Result.m163constructorimpl(Unit.f68710a);
        }
        if (!Intrinsics.b(((AudioBean) objectRef2.element).getUrl(), this.$item.getPath())) {
            ((AudioBean) objectRef2.element).setUrl(this.$item.getPath());
        }
        iAudioApiR = this.this$0.r();
        if (iAudioApiR == null) {
            iAudioApiR2 = this.this$0.r();
            if (iAudioApiR2 != null) {
                IAudioApi.a.a(iAudioApiR2, (AudioBean) objectRef2.element, false, 2, null);
            }
        } else {
            iAudioApiR2 = this.this$0.r();
            if (iAudioApiR2 != null) {
                IAudioApi.a.a(iAudioApiR2, (AudioBean) objectRef2.element, false, 2, null);
            }
        }
        iFloatingApiS = this.this$0.s();
        if (iFloatingApiS != null) {
            View viewT3 = this.this$0.t();
            iFloatingApiS.y(new WeakReference<>((Activity) (viewT3 != null ? viewT3.getContext() : null)), (AudioBean) objectRef2.element);
        }
        return Unit.f68710a;
    }
}
