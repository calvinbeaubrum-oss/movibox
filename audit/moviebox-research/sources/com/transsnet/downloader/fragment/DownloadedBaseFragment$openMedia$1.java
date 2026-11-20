package com.transsnet.downloader.fragment;

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
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadedBaseFragment$openMedia$1", f = "DownloadedBaseFragment.kt", l = {154, 154}, m = "invokeSuspend")
public final class DownloadedBaseFragment$openMedia$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $item;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadedBaseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadedBaseFragment$openMedia$1(DownloadedBaseFragment downloadedBaseFragment, DownloadBean downloadBean, Continuation<? super DownloadedBaseFragment$openMedia$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadedBaseFragment;
        this.$item = downloadBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadedBaseFragment$openMedia$1(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadedBaseFragment$openMedia$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0070  */
    /* JADX WARN: Code duplicated, block: B:27:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    /* JADX WARN: Code duplicated, block: B:36:0x012d A[Catch: all -> 0x0146, TryCatch #0 {all -> 0x0146, blocks: (B:34:0x0123, B:36:0x012d, B:40:0x0153, B:39:0x0148), top: B:68:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0148 A[Catch: all -> 0x0146, TryCatch #0 {all -> 0x0146, blocks: (B:34:0x0123, B:36:0x012d, B:40:0x0153, B:39:0x0148), top: B:68:0x0123 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0176  */
    /* JADX WARN: Code duplicated, block: B:48:0x018c  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x01df  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [T, com.transsion.baselib.db.audio.AudioBean] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object objD;
        rr.a aVarM1;
        T t11;
        Object objC;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        IAudioApi iAudioApiN1;
        IAudioApi iAudioApiN2;
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
            iAudioApiN1 = this.this$0.n1();
            if (iAudioApiN1 == null && iAudioApiN1.p1()) {
                IAudioApi iAudioApiN3 = this.this$0.n1();
                if (iAudioApiN3 == null || !iAudioApiN3.D((AudioBean) objectRef2.element)) {
                    IAudioApi iAudioApiN4 = this.this$0.n1();
                    if (iAudioApiN4 != null) {
                        IAudioApi.a.a(iAudioApiN4, (AudioBean) objectRef2.element, false, 2, null);
                    }
                } else {
                    IAudioApi iAudioApiN5 = this.this$0.n1();
                    if (iAudioApiN5 != null) {
                        iAudioApiN5.pause();
                    }
                }
            } else {
                iAudioApiN2 = this.this$0.n1();
                if (iAudioApiN2 != null) {
                    IAudioApi.a.a(iAudioApiN2, (AudioBean) objectRef2.element, false, 2, null);
                }
            }
            IFloatingApi iFloatingApiP1 = this.this$0.p1();
            View view = this.this$0.getView();
            iFloatingApiP1.y(new WeakReference<>((Activity) (view != null ? view.getContext() : null)), (AudioBean) objectRef2.element);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        objectRef = new Ref.ObjectRef();
        rr.a aVarM2 = this.this$0.m1();
        if (aVarM2 != null) {
            String resourceId = this.$item.getResourceId();
            if (resourceId == null) {
                resourceId = this.$item.getUrl();
            }
            this.L$0 = objectRef;
            this.L$1 = objectRef;
            this.label = 1;
            objD = aVarM2.d(resourceId, this);
            if (objD == objE) {
                return objE;
            }
            objectRef2 = objectRef;
        } else {
            objectRef2 = objectRef;
        }
        aVarM1 = this.this$0.m1();
        if (aVarM1 != null) {
            String url = this.$item.getUrl();
            this.L$0 = objectRef2;
            this.L$1 = objectRef;
            this.label = 2;
            objC = aVarM1.c(url, this);
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
        iAudioApiN1 = this.this$0.n1();
        if (iAudioApiN1 == null) {
            iAudioApiN2 = this.this$0.n1();
            if (iAudioApiN2 != null) {
                IAudioApi.a.a(iAudioApiN2, (AudioBean) objectRef2.element, false, 2, null);
            }
        } else {
            iAudioApiN2 = this.this$0.n1();
            if (iAudioApiN2 != null) {
                IAudioApi.a.a(iAudioApiN2, (AudioBean) objectRef2.element, false, 2, null);
            }
        }
        IFloatingApi iFloatingApiP2 = this.this$0.p1();
        View view2 = this.this$0.getView();
        iFloatingApiP2.y(new WeakReference<>((Activity) (view2 != null ? view2.getContext() : null)), (AudioBean) objectRef2.element);
        return Unit.f68710a;
        AudioBean audioBean3 = (AudioBean) objD;
        t11 = audioBean3;
        if (audioBean3 == null) {
            aVarM1 = this.this$0.m1();
            if (aVarM1 != null) {
                String url2 = this.$item.getUrl();
                this.L$0 = objectRef2;
                this.L$1 = objectRef;
                this.label = 2;
                objC = aVarM1.c(url2, this);
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
        iAudioApiN1 = this.this$0.n1();
        if (iAudioApiN1 == null) {
            iAudioApiN2 = this.this$0.n1();
            if (iAudioApiN2 != null) {
                IAudioApi.a.a(iAudioApiN2, (AudioBean) objectRef2.element, false, 2, null);
            }
        } else {
            iAudioApiN2 = this.this$0.n1();
            if (iAudioApiN2 != null) {
                IAudioApi.a.a(iAudioApiN2, (AudioBean) objectRef2.element, false, 2, null);
            }
        }
        IFloatingApi iFloatingApiP3 = this.this$0.p1();
        View view3 = this.this$0.getView();
        iFloatingApiP3.y(new WeakReference<>((Activity) (view3 != null ? view3.getContext() : null)), (AudioBean) objectRef2.element);
        return Unit.f68710a;
    }
}
