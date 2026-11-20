package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class k extends RippleDrawable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3183f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f3184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f3185h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w1 f3187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f3188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3189d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f3190a = new b();

        public final void a(RippleDrawable rippleDrawable, int i11) {
            rippleDrawable.setRadius(i11);
        }
    }

    public k(boolean z11) {
        super(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK), null, z11 ? new ColorDrawable(-1) : null);
        this.f3186a = z11;
    }

    public final long a(long j11, float f11) {
        if (Build.VERSION.SDK_INT < 28) {
            f11 *= 2;
        }
        return w1.k(j11, kotlin.ranges.a.f(f11, 1.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    public final void b(long j11, float f11) {
        long jA = a(j11, f11);
        w1 w1Var = this.f3187b;
        if (w1Var != null && w1.m(w1Var.u(), jA)) {
            return;
        }
        this.f3187b = w1.g(jA);
        setColor(ColorStateList.valueOf(y1.j(jA)));
    }

    public final void c(int i11) {
        Integer num = this.f3188c;
        if (num != null && num.intValue() == i11) {
            return;
        }
        this.f3188c = Integer.valueOf(i11);
        if (Build.VERSION.SDK_INT >= 23) {
            b.f3190a.a(this, i11);
            return;
        }
        try {
            if (!f3185h) {
                f3185h = true;
                f3184g = RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE);
            }
            Method method = f3184g;
            if (method != null) {
                method.invoke(this, Integer.valueOf(i11));
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        if (!this.f3186a) {
            this.f3189d = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        this.f3189d = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.f3189d;
    }
}
