package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties$CC;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class b implements androidx.compose.ui.focus.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5071a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f5072b;

    public final boolean a() {
        return f5072b != null;
    }

    public final void b() {
        f5072b = null;
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester getNext() {
        return FocusProperties$CC.f(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester i() {
        return FocusProperties$CC.e(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester j() {
        return FocusProperties$CC.i(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester m() {
        return FocusProperties$CC.h(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester n() {
        return FocusProperties$CC.j(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ Function1 o() {
        return FocusProperties$CC.d(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester p() {
        return FocusProperties$CC.b(this);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester q() {
        return FocusProperties$CC.a(this);
    }

    @Override // androidx.compose.ui.focus.m
    public void r(boolean z11) {
        f5072b = Boolean.valueOf(z11);
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ Function1 s() {
        return FocusProperties$CC.c(this);
    }

    @Override // androidx.compose.ui.focus.m
    public boolean t() {
        Boolean bool = f5072b;
        if (bool != null) {
            return bool.booleanValue();
        }
        h2.a.c("canFocus is read before it is written");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.focus.m
    public /* synthetic */ FocusRequester u() {
        return FocusProperties$CC.g(this);
    }
}
