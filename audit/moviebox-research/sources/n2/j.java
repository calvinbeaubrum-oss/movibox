package n2;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class j extends ReplacementSpan {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f71472l = new a(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f71473m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f71474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f71476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f71477d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f71478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f71479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint.FontMetricsInt f71480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f71481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f71482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71483k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(float f11, int i11, float f12, int i12, float f13, int i13) {
        this.f71474a = f11;
        this.f71475b = i11;
        this.f71476c = f12;
        this.f71477d = i12;
        this.f71478f = f13;
        this.f71479g = i13;
    }

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.f71480h;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.y("fontMetrics");
        return null;
    }

    public final int b() {
        if (this.f71483k) {
            return this.f71482j;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }

    public final int c() {
        return this.f71479g;
    }

    public final int d() {
        if (this.f71483k) {
            return this.f71481i;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
    }

    @Override // android.text.style.ReplacementSpan
    @SuppressLint({"DocumentExceptions"})
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        float f11;
        int iA;
        this.f71483k = true;
        float textSize = paint.getTextSize();
        this.f71480h = paint.getFontMetricsInt();
        if (a().descent <= a().ascent) {
            throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.".toString());
        }
        int i13 = this.f71475b;
        if (i13 == 0) {
            f11 = this.f71474a * this.f71478f;
        } else {
            if (i13 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            f11 = this.f71474a * textSize;
        }
        this.f71481i = k.a(f11);
        int i14 = this.f71477d;
        if (i14 == 0) {
            iA = k.a(this.f71476c * this.f71478f);
        } else {
            if (i14 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            iA = k.a(this.f71476c * textSize);
        }
        this.f71482j = iA;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            switch (this.f71479g) {
                case 0:
                    if (fontMetricsInt.ascent > (-b())) {
                        fontMetricsInt.ascent = -b();
                    }
                    break;
                case 1:
                case 4:
                    if (fontMetricsInt.ascent + b() > fontMetricsInt.descent) {
                        fontMetricsInt.descent = fontMetricsInt.ascent + b();
                    }
                    break;
                case 2:
                case 5:
                    if (fontMetricsInt.ascent > fontMetricsInt.descent - b()) {
                        fontMetricsInt.ascent = fontMetricsInt.descent - b();
                    }
                    break;
                case 3:
                case 6:
                    if (fontMetricsInt.descent - fontMetricsInt.ascent < b()) {
                        int iB = fontMetricsInt.ascent - ((b() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2);
                        fontMetricsInt.ascent = iB;
                        fontMetricsInt.descent = iB + b();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown verticalAlign.");
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        return d();
    }
}
