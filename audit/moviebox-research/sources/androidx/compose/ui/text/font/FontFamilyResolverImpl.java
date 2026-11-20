package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class FontFamilyResolverImpl implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f5800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f5801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypefaceRequestCache f5802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FontListFontFamilyTypefaceAdapter f5803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f5804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<n0, Object> f5805f;

    public FontFamilyResolverImpl(a0 a0Var, c0 c0Var, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, z zVar) {
        this.f5800a = a0Var;
        this.f5801b = c0Var;
        this.f5802c = typefaceRequestCache;
        this.f5803d = fontListFontFamilyTypefaceAdapter;
        this.f5804e = zVar;
        this.f5805f = new Function1<n0, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(n0 n0Var) {
                return this.this$0.g(n0.b(n0Var, null, null, 0, 0, null, 30, null)).getValue();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FontFamilyResolverImpl(a0 a0Var, c0 c0Var, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, z zVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(a0Var, (i11 & 2) != 0 ? c0.f5818a.a() : c0Var, (i11 & 4) != 0 ? k.b() : typefaceRequestCache, (i11 & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(k.a(), null, 2, 0 == true ? 1 : 0) : fontListFontFamilyTypefaceAdapter, (i11 & 16) != 0 ? new z() : zVar);
    }

    @Override // androidx.compose.ui.text.font.i.b
    public a3<Object> a(i iVar, u uVar, int i11, int i12) {
        return g(new n0(this.f5801b.d(iVar), this.f5801b.a(uVar), this.f5801b.b(i11), this.f5801b.c(i12), this.f5800a.b(), null));
    }

    public final a0 f() {
        return this.f5800a;
    }

    public final a3<Object> g(final n0 n0Var) {
        return this.f5802c.c(n0Var, new Function1<Function1<? super o0, ? extends Unit>, o0>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final o0 invoke2(Function1<? super o0, Unit> function1) {
                o0 o0VarA = this.this$0.f5803d.a(n0Var, this.this$0.f(), function1, this.this$0.f5805f);
                if (o0VarA == null && (o0VarA = this.this$0.f5804e.a(n0Var, this.this$0.f(), function1, this.this$0.f5805f)) == null) {
                    throw new IllegalStateException("Could not load font");
                }
                return o0VarA;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ o0 invoke(Function1<? super o0, ? extends Unit> function1) {
                return invoke2((Function1<? super o0, Unit>) function1);
            }
        });
    }
}
