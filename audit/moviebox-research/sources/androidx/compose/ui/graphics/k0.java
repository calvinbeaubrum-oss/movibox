package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class k0 implements c4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4156e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f4157f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f4158a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DrawChildContainer f4160c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4159b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ComponentCallbacks2 f4161d = null;

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
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4162a = new b();

        @JvmStatic
        public static final long a(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public k0(ViewGroup viewGroup) {
        this.f4158a = viewGroup;
    }

    @Override // androidx.compose.ui.graphics.c4
    public GraphicsLayer a() {
        GraphicsLayerImpl d0Var;
        GraphicsLayer graphicsLayer;
        synchronized (this.f4159b) {
            try {
                long jC = c(this.f4158a);
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 29) {
                    d0Var = new androidx.compose.ui.graphics.layer.c0(jC, null, null, 6, null);
                } else if (!f4157f || i11 < 23) {
                    d0Var = new androidx.compose.ui.graphics.layer.d0(d(this.f4158a), jC, null, null, 12, null);
                } else {
                    try {
                        d0Var = new androidx.compose.ui.graphics.layer.e(this.f4158a, jC, null, null, 12, null);
                    } catch (Throwable unused) {
                        f4157f = false;
                        d0Var = new androidx.compose.ui.graphics.layer.d0(d(this.f4158a), jC, null, null, 12, null);
                    }
                }
                graphicsLayer = new GraphicsLayer(d0Var, null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void b(GraphicsLayer graphicsLayer) {
        synchronized (this.f4159b) {
            graphicsLayer.H();
            Unit unit = Unit.f68710a;
        }
    }

    public final long c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.a(view);
        }
        return -1L;
    }

    public final DrawChildContainer d(ViewGroup viewGroup) {
        DrawChildContainer drawChildContainer = this.f4160c;
        if (drawChildContainer != null) {
            return drawChildContainer;
        }
        ViewLayerContainer viewLayerContainer = new ViewLayerContainer(viewGroup.getContext());
        viewGroup.addView(viewLayerContainer);
        this.f4160c = viewLayerContainer;
        return viewLayerContainer;
    }
}
