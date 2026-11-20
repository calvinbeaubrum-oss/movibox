package com.transsnet.downloader.manager;

import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import tr.j;

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
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$deleteItem$1", f = "DownloadManagerImpl.kt", l = {1450, 1454, 1465, 1470, 1472}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadManagerImpl$deleteItem$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ DownloadBean $downloadInfo;
    Object L$0;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$deleteItem$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$deleteItem$1$2", f = "DownloadManagerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function1<Boolean, Unit> function1 = this.$callback;
            if (function1 == null) {
                return null;
            }
            function1.invoke(Boxing.a(true));
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadManagerImpl$deleteItem$1(DownloadBean downloadBean, DownloadManagerImpl downloadManagerImpl, Function1<? super Boolean, Unit> function1, Continuation<? super DownloadManagerImpl$deleteItem$1> continuation) {
        super(2, continuation);
        this.$downloadInfo = downloadBean;
        this.this$0 = downloadManagerImpl;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$deleteItem$1(this.$downloadInfo, this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$deleteItem$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0104  */
    /* JADX WARN: Code duplicated, block: B:46:0x0115  */
    /* JADX WARN: Code duplicated, block: B:48:0x011d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Unit unit;
        a2 a2VarC;
        AnonymousClass2 anonymousClass2;
        rr.a aVarI0;
        AudioBean audioBean;
        rr.a aVarI1;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else if (i11 == 2) {
                unit = (Unit) this.L$0;
                ResultKt.b(obj);
                uo.b.a.g(uo.b.f78622a, "get deleteItem success " + unit, false, 2, null);
                a2VarC = w0.c();
                anonymousClass2 = new AnonymousClass2(this.$callback, null);
                this.L$0 = null;
                this.label = 3;
                if (h.g(a2VarC, anonymousClass2, this) == objE) {
                    return objE;
                }
                if (this.$downloadInfo.getType() == 1) {
                    String url = this.$downloadInfo.getUrl();
                    this.label = 4;
                    obj = aVarI0.c(url, this);
                    if (obj == objE) {
                        return objE;
                    }
                    audioBean = (AudioBean) obj;
                    if (audioBean != null) {
                        DownloadManagerImpl downloadManagerImpl = this.this$0;
                        audioBean.setReadProcess(Boxing.e(0L));
                        aVarI1 = downloadManagerImpl.i0();
                        if (aVarI1 != null) {
                            this.label = 5;
                            if (aVarI1.b(audioBean, this) == objE) {
                                return objE;
                            }
                        }
                    }
                }
            } else if (i11 == 3) {
                ResultKt.b(obj);
                if (this.$downloadInfo.getType() == 1 && (aVarI0 = this.this$0.i0()) != null) {
                    String url2 = this.$downloadInfo.getUrl();
                    this.label = 4;
                    obj = aVarI0.c(url2, this);
                    if (obj == objE) {
                        return objE;
                    }
                    audioBean = (AudioBean) obj;
                    if (audioBean != null) {
                        DownloadManagerImpl downloadManagerImpl2 = this.this$0;
                        audioBean.setReadProcess(Boxing.e(0L));
                        aVarI1 = downloadManagerImpl2.i0();
                        if (aVarI1 != null) {
                            this.label = 5;
                            if (aVarI1.b(audioBean, this) == objE) {
                                return objE;
                            }
                        }
                    }
                }
            } else if (i11 == 4) {
                ResultKt.b(obj);
                audioBean = (AudioBean) obj;
                if (audioBean != null) {
                    DownloadManagerImpl downloadManagerImpl3 = this.this$0;
                    audioBean.setReadProcess(Boxing.e(0L));
                    aVarI1 = downloadManagerImpl3.i0();
                    if (aVarI1 != null) {
                        this.label = 5;
                        if (aVarI1.b(audioBean, this) == objE) {
                            return objE;
                        }
                    }
                }
            } else {
                if (i11 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            DownloadManagerApi.f60274j.a().q2(this.$downloadInfo.getSubjectId(), this.$downloadInfo.getResourceId(), this.$downloadInfo.isSeries(), (8 & 8) != 0, (8 & 16) != 0 ? false : this.$downloadInfo.isMultiresolution());
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        DownloadBean downloadBean = this.$downloadInfo;
        downloadBean.setPreStatus(downloadBean.getStatus());
        this.$downloadInfo.setStatus(7);
        Set set = this.this$0.f61037r;
        DownloadBean downloadBean2 = this.$downloadInfo;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((j) it.next()).a(downloadBean2.getSubtitleResId());
        }
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = this.$downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = this.$downloadInfo.getUrl();
        }
        String postId = this.$downloadInfo.getPostId();
        this.label = 1;
        if (downloadEsHelperA.h(resourceId, postId, this) == objE) {
            return objE;
        }
        unit = Unit.f68710a;
        tr.h hVarM0 = this.this$0.m0();
        String resourceId2 = this.$downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = this.$downloadInfo.getUrl();
        }
        this.L$0 = unit;
        this.label = 2;
        if (hVarM0.b(resourceId2, this) == objE) {
            return objE;
        }
        uo.b.a.g(uo.b.f78622a, "get deleteItem success " + unit, false, 2, null);
        a2VarC = w0.c();
        anonymousClass2 = new AnonymousClass2(this.$callback, null);
        this.L$0 = null;
        this.label = 3;
        if (h.g(a2VarC, anonymousClass2, this) == objE) {
            return objE;
        }
        if (this.$downloadInfo.getType() == 1) {
            String url3 = this.$downloadInfo.getUrl();
            this.label = 4;
            obj = aVarI0.c(url3, this);
            if (obj == objE) {
                return objE;
            }
            audioBean = (AudioBean) obj;
            if (audioBean != null) {
                DownloadManagerImpl downloadManagerImpl4 = this.this$0;
                audioBean.setReadProcess(Boxing.e(0L));
                aVarI1 = downloadManagerImpl4.i0();
                if (aVarI1 != null) {
                    this.label = 5;
                    if (aVarI1.b(audioBean, this) == objE) {
                        return objE;
                    }
                }
            }
        }
        DownloadManagerApi.f60274j.a().q2(this.$downloadInfo.getSubjectId(), this.$downloadInfo.getResourceId(), this.$downloadInfo.isSeries(), (8 & 8) != 0, (8 & 16) != 0 ? false : this.$downloadInfo.isMultiresolution());
        return Unit.f68710a;
    }
}
