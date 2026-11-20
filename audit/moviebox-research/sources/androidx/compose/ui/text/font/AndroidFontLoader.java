package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class AndroidFontLoader implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5785b;

    public AndroidFontLoader(Context context) {
        this.f5784a = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.a0
    public Object b() {
        return this.f5785b;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.a0
    public Object c(h hVar, Continuation<? super Typeface> continuation) throws Throwable {
        AndroidFontLoader$awaitLoad$1 androidFontLoader$awaitLoad$1;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof AndroidFontLoader$awaitLoad$1) {
            androidFontLoader$awaitLoad$1 = (AndroidFontLoader$awaitLoad$1) continuation;
            int i11 = androidFontLoader$awaitLoad$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                androidFontLoader$awaitLoad$1.label = i11 - Integer.MIN_VALUE;
            } else {
                androidFontLoader$awaitLoad$1 = new AndroidFontLoader$awaitLoad$1(this, continuation);
            }
        } else {
            androidFontLoader$awaitLoad$1 = new AndroidFontLoader$awaitLoad$1(this, continuation);
        }
        Object objD = androidFontLoader$awaitLoad$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = androidFontLoader$awaitLoad$1.label;
        if (i12 == 0) {
            ResultKt.b(objD);
            if (hVar instanceof a) {
                ((a) hVar).a();
                androidFontLoader$awaitLoad$1.label = 1;
                throw null;
            }
            if (!(hVar instanceof i0)) {
                throw new IllegalArgumentException("Unknown font type: " + hVar);
            }
            Context context = this.f5784a;
            androidFontLoader$awaitLoad$1.L$0 = this;
            androidFontLoader$awaitLoad$1.L$1 = hVar;
            androidFontLoader$awaitLoad$1.label = 2;
            objD = b.d((i0) hVar, context, androidFontLoader$awaitLoad$1);
            if (objD == objE) {
                return objE;
            }
            androidFontLoader = this;
        } else {
            if (i12 == 1) {
                ResultKt.b(objD);
                return objD;
            }
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (h) androidFontLoader$awaitLoad$1.L$1;
            androidFontLoader = (AndroidFontLoader) androidFontLoader$awaitLoad$1.L$0;
            ResultKt.b(objD);
        }
        ((i0) hVar).e();
        return h0.c((Typeface) objD, null, androidFontLoader.f5784a);
    }

    @Override // androidx.compose.ui.text.font.a0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Typeface a(h hVar) {
        Object objM163constructorimpl;
        Typeface typefaceC;
        if (hVar instanceof a) {
            ((a) hVar).a();
            throw null;
        }
        if (!(hVar instanceof i0)) {
            return null;
        }
        int iC = hVar.c();
        o.a aVar = o.f5843a;
        if (o.e(iC, aVar.b())) {
            typefaceC = b.c((i0) hVar, this.f5784a);
        } else {
            if (!o.e(iC, aVar.c())) {
                if (o.e(iC, aVar.a())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) o.g(hVar.c())));
            }
            try {
                Result.Companion companion = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(b.c((i0) hVar, this.f5784a));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            if (Result.m169isFailureimpl(objM163constructorimpl)) {
                objM163constructorimpl = null;
            }
            typefaceC = (Typeface) objM163constructorimpl;
        }
        ((i0) hVar).e();
        return h0.c(typefaceC, null, this.f5784a);
    }
}
