package com.transsion.push.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.utils.NotificationUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.push.helper.PushShowPermanentHelper$showPermanentPush$1", f = "PushShowPermanentHelper.kt", l = {}, m = "invokeSuspend")
public final class PushShowPermanentHelper$showPermanentPush$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<PermanentItemBean> $msgList;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<Bitmap> f56913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<PermanentItemBean> f56915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<PermanentItemBean> f56916d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f56917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f56918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f56919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Context f56920i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f56921j;

        public a(List<Bitmap> list, String str, List<PermanentItemBean> list2, List<PermanentItemBean> list3, int i11, Ref.IntRef intRef, int i12, Context context, int i13) {
            this.f56913a = list;
            this.f56914b = str;
            this.f56915c = list2;
            this.f56916d = list3;
            this.f56917f = i11;
            this.f56918g = intRef;
            this.f56919h = i12;
            this.f56920i = context;
            this.f56921j = i13;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            Ref.IntRef intRef = this.f56918g;
            int i11 = intRef.element + 1;
            intRef.element = i11;
            b.a.f(b.f78622a, "PUSH_SHOW", "onLoadFailed-size:" + i11 + " :" + this.f56914b, false, 4, null);
        }

        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Object objM163constructorimpl;
            Intrinsics.g(resource, "resource");
            b.a aVar = b.f78622a;
            b.a.f(aVar, "PUSH_SHOW", "onSuccess-size:" + this.f56913a.size() + " :" + this.f56914b, false, 4, null);
            this.f56913a.add(resource);
            this.f56915c.add(this.f56916d.get(this.f56917f));
            Ref.IntRef intRef = this.f56918g;
            int i11 = intRef.element + 1;
            intRef.element = i11;
            if (i11 == this.f56919h) {
                b.a.f(aVar, "PUSH_SHOW", "load complete-size:" + i11, false, 4, null);
                Context context = this.f56920i;
                List<PermanentItemBean> list = this.f56915c;
                List<Bitmap> list2 = this.f56913a;
                int i12 = this.f56921j;
                try {
                    Result.Companion companion = Result.Companion;
                    PushShowPermanentHelper.f56904a.j(context, list, list2, i12);
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                }
                Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    thM166exceptionOrNullimpl.printStackTrace();
                }
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushShowPermanentHelper$showPermanentPush$1(List<PermanentItemBean> list, Context context, Continuation<? super PushShowPermanentHelper$showPermanentPush$1> continuation) {
        super(2, continuation);
        this.$msgList = list;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushShowPermanentHelper$showPermanentPush$1(this.$msgList, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PushShowPermanentHelper$showPermanentPush$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0062  */
    /* JADX WARN: Code duplicated, block: B:16:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:0x0072 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int iG;
        int i11;
        Ref.IntRef intRef;
        ArrayList arrayList;
        int i12;
        String image;
        PushShowPermanentHelper$showPermanentPush$1 pushShowPermanentHelper$showPermanentPush$1 = this;
        kotlin.coroutines.intrinsics.a.e();
        if (pushShowPermanentHelper$showPermanentPush$1.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        int curAbType = PushConfigHelper.INSTANCE.getCurAbType();
        ArrayList arrayList2 = new ArrayList();
        if (curAbType != 1) {
            if (curAbType != 2) {
                i11 = 1;
            } else {
                iG = kotlin.ranges.a.g(pushShowPermanentHelper$showPermanentPush$1.$msgList.size(), 4);
            }
            b.a.f(b.f78622a, "PUSH_SHOW", "postPushPermanent, curAbType:" + curAbType, false, 4, null);
            intRef = new Ref.IntRef();
            arrayList = new ArrayList();
            i12 = 0;
            while (i12 < i11) {
                image = pushShowPermanentHelper$showPermanentPush$1.$msgList.get(i12).getImage();
                if (image == null) {
                    image = "";
                }
                String str = image;
                Glide.with(pushShowPermanentHelper$showPermanentPush$1.$context).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load2(NotificationUtil.f57032a.E(str)).into(new a(arrayList2, str, arrayList, pushShowPermanentHelper$showPermanentPush$1.$msgList, i12, intRef, i11, pushShowPermanentHelper$showPermanentPush$1.$context, curAbType));
                i12++;
                pushShowPermanentHelper$showPermanentPush$1 = this;
                arrayList2 = arrayList2;
            }
            return Unit.f68710a;
        }
        iG = kotlin.ranges.a.g(pushShowPermanentHelper$showPermanentPush$1.$msgList.size(), 10);
        i11 = iG;
        b.a.f(b.f78622a, "PUSH_SHOW", "postPushPermanent, curAbType:" + curAbType, false, 4, null);
        intRef = new Ref.IntRef();
        arrayList = new ArrayList();
        i12 = 0;
        while (i12 < i11) {
            image = pushShowPermanentHelper$showPermanentPush$1.$msgList.get(i12).getImage();
            if (image == null) {
                image = "";
            }
            String str2 = image;
            Glide.with(pushShowPermanentHelper$showPermanentPush$1.$context).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load2(NotificationUtil.f57032a.E(str2)).into(new a(arrayList2, str2, arrayList, pushShowPermanentHelper$showPermanentPush$1.$msgList, i12, intRef, i11, pushShowPermanentHelper$showPermanentPush$1.$context, curAbType));
            i12++;
            pushShowPermanentHelper$showPermanentPush$1 = this;
            arrayList2 = arrayList2;
        }
        return Unit.f68710a;
    }
}
