package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class FocusPropertiesImpl implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3897a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FocusRequester f3898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FocusRequester f3899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FocusRequester f3900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FocusRequester f3901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FocusRequester f3902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FocusRequester f3903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FocusRequester f3904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FocusRequester f3905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super b, FocusRequester> f3906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super b, FocusRequester> f3907k;

    public FocusPropertiesImpl() {
        FocusRequester.a aVar = FocusRequester.f3908b;
        this.f3898b = aVar.b();
        this.f3899c = aVar.b();
        this.f3900d = aVar.b();
        this.f3901e = aVar.b();
        this.f3902f = aVar.b();
        this.f3903g = aVar.b();
        this.f3904h = aVar.b();
        this.f3905i = aVar.b();
        this.f3906j = new Function1<b, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(b bVar) {
                return m51invoke3ESFkO8(bVar.o());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m51invoke3ESFkO8(int i11) {
                return FocusRequester.f3908b.b();
            }
        };
        this.f3907k = new Function1<b, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(b bVar) {
                return m52invoke3ESFkO8(bVar.o());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m52invoke3ESFkO8(int i11) {
                return FocusRequester.f3908b.b();
            }
        };
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester getNext() {
        return this.f3898b;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester i() {
        return this.f3902f;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester j() {
        return this.f3904h;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester m() {
        return this.f3903g;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester n() {
        return this.f3900d;
    }

    @Override // androidx.compose.ui.focus.m
    public Function1<b, FocusRequester> o() {
        return this.f3907k;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester p() {
        return this.f3905i;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester q() {
        return this.f3901e;
    }

    @Override // androidx.compose.ui.focus.m
    public void r(boolean z11) {
        this.f3897a = z11;
    }

    @Override // androidx.compose.ui.focus.m
    public Function1<b, FocusRequester> s() {
        return this.f3906j;
    }

    @Override // androidx.compose.ui.focus.m
    public boolean t() {
        return this.f3897a;
    }

    @Override // androidx.compose.ui.focus.m
    public FocusRequester u() {
        return this.f3899c;
    }
}
