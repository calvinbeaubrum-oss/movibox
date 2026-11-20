package pv;

import android.view.View;
import com.transsion.player.ui.render.RenderScaleMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f74058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f74059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RenderScaleMode f74060c = RenderScaleMode.SCREEN_SCALE_DEFAULT;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f74061d;

    /* JADX INFO: renamed from: pv.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0810a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74062a;

        static {
            int[] iArr = new int[RenderScaleMode.values().length];
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_ORIGINAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_16_9.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_4_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_MATCH_PARENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f74062a = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0040 A[PHI: r7
  0x0040: PHI (r7v10 int) = (r7v6 int), (r7v8 int), (r7v9 int), (r7v13 int) binds: [B:35:0x0073, B:26:0x0052, B:22:0x0046, B:19:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    public final int[] a(int i11, int i12) {
        int i13 = this.f74061d;
        if (i13 == 90 || i13 == 270) {
            i12 = i11;
            i11 = i12;
        }
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (this.f74059b == 0 || this.f74058a == 0) {
            return new int[]{size, size2};
        }
        switch (C0810a.f74062a[this.f74060c.ordinal()]) {
            case 1:
                int i14 = this.f74058a;
                int i15 = i14 * size2;
                int i16 = this.f74059b;
                if (i15 < size * i16) {
                    i11 = (i14 * size2) / i16;
                } else {
                    if (i14 * size2 > size * i16) {
                        i12 = (i16 * size) / i14;
                        i11 = size;
                    }
                    i11 = size;
                }
                i12 = size2;
                break;
            case 2:
                i11 = this.f74058a;
                i12 = this.f74059b;
                break;
            case 3:
                i12 = (size / 16) * 9;
                if (size2 <= i12) {
                    i11 = (size2 / 9) * 16;
                    i12 = size2;
                } else {
                    i11 = size;
                }
                break;
            case 4:
                i12 = (size / 4) * 3;
                if (size2 <= i12) {
                    i11 = (size2 / 3) * 4;
                    i12 = size2;
                } else {
                    i11 = size;
                }
                break;
            case 5:
                break;
            case 6:
                int i17 = this.f74058a;
                int i18 = i17 * size2;
                int i19 = this.f74059b;
                if (i18 <= size * i19) {
                    i12 = (i19 * size) / i17;
                    i11 = size;
                } else {
                    i11 = (i17 * size2) / i19;
                    i12 = size2;
                }
                break;
            default:
                i11 = size;
                i12 = size2;
                break;
        }
        return new int[]{i11, i12};
    }

    public final void b(RenderScaleMode screenScale) {
        Intrinsics.g(screenScale, "screenScale");
        if (screenScale == this.f74060c) {
            return;
        }
        this.f74060c = screenScale;
    }

    public final void c(int i11) {
        this.f74061d = i11;
    }

    public final void d(int i11, int i12) {
        this.f74058a = i11;
        this.f74059b = i12;
    }
}
