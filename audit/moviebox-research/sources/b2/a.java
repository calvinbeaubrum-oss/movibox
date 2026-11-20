package b2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.g;
import b3.d;
import b3.k;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParser f13905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final g f13907c;

    public a(XmlPullParser xmlPullParser, int i11) {
        this.f13905a = xmlPullParser;
        this.f13906b = i11;
        this.f13907c = new g();
    }

    public /* synthetic */ a(XmlPullParser xmlPullParser, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i12 & 2) != 0 ? 0 : i11);
    }

    public final float a(TypedArray typedArray, int i11, float f11) {
        float dimension = typedArray.getDimension(i11, f11);
        l(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float b(TypedArray typedArray, int i11, float f11) {
        float f12 = typedArray.getFloat(i11, f11);
        l(typedArray.getChangingConfigurations());
        return f12;
    }

    public final int c(TypedArray typedArray, int i11, int i12) {
        int i13 = typedArray.getInt(i11, i12);
        l(typedArray.getChangingConfigurations());
        return i13;
    }

    public final boolean d(TypedArray typedArray, String str, int i11, boolean z11) {
        boolean zA = k.a(typedArray, this.f13905a, str, i11, z11);
        l(typedArray.getChangingConfigurations());
        return zA;
    }

    public final ColorStateList e(TypedArray typedArray, Resources.Theme theme, String str, int i11) {
        ColorStateList colorStateListC = k.c(typedArray, this.f13905a, theme, str, i11);
        l(typedArray.getChangingConfigurations());
        return colorStateListC;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f13905a, aVar.f13905a) && this.f13906b == aVar.f13906b;
    }

    public final d f(TypedArray typedArray, Resources.Theme theme, String str, int i11, int i12) {
        d dVarE = k.e(typedArray, this.f13905a, theme, str, i11, i12);
        l(typedArray.getChangingConfigurations());
        return dVarE;
    }

    public final float g(TypedArray typedArray, String str, int i11, float f11) {
        float f12 = k.f(typedArray, this.f13905a, str, i11, f11);
        l(typedArray.getChangingConfigurations());
        return f12;
    }

    public final int h(TypedArray typedArray, String str, int i11, int i12) {
        int iG = k.g(typedArray, this.f13905a, str, i11, i12);
        l(typedArray.getChangingConfigurations());
        return iG;
    }

    public int hashCode() {
        return (this.f13905a.hashCode() * 31) + this.f13906b;
    }

    public final String i(TypedArray typedArray, int i11) {
        String string = typedArray.getString(i11);
        l(typedArray.getChangingConfigurations());
        return string;
    }

    public final XmlPullParser j() {
        return this.f13905a;
    }

    public final TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, iArr);
        l(typedArrayK.getChangingConfigurations());
        return typedArrayK;
    }

    public final void l(int i11) {
        this.f13906b = i11 | this.f13906b;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.f13905a + ", config=" + this.f13906b + ')';
    }
}
