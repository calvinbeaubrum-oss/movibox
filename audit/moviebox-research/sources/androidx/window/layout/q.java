package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f13198a = new q();

    public final r a(Activity activity, FoldingFeature oemFeature) {
        HardwareFoldingFeature.Type typeA;
        r.c cVar;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            typeA = HardwareFoldingFeature.Type.Companion.a();
        } else {
            if (type != 2) {
                return null;
            }
            typeA = HardwareFoldingFeature.Type.Companion.b();
        }
        int state = oemFeature.getState();
        if (state == 1) {
            cVar = r.c.f13208c;
        } else {
            if (state != 2) {
                return null;
            }
            cVar = r.c.f13209d;
        }
        Rect bounds = oemFeature.getBounds();
        Intrinsics.f(bounds, "oemFeature.bounds");
        if (!c(activity, new androidx.window.core.b(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        Intrinsics.f(bounds2, "oemFeature.bounds");
        return new HardwareFoldingFeature(new androidx.window.core.b(bounds2), typeA, cVar);
    }

    public final a0 b(Activity activity, WindowLayoutInfo info) {
        r rVarA;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        Intrinsics.f(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                q qVar = f13198a;
                Intrinsics.f(feature, "feature");
                rVarA = qVar.a(activity, feature);
            } else {
                rVarA = null;
            }
            if (rVarA != null) {
                arrayList.add(rVarA);
            }
        }
        return new a0(arrayList);
    }

    public final boolean c(Activity activity, androidx.window.core.b bVar) {
        Rect rectA = f0.f13186a.a(activity).a();
        if (bVar.e()) {
            return false;
        }
        if (bVar.d() != rectA.width() && bVar.a() != rectA.height()) {
            return false;
        }
        if (bVar.d() >= rectA.width() || bVar.a() >= rectA.height()) {
            return (bVar.d() == rectA.width() && bVar.a() == rectA.height()) ? false : true;
        }
        return false;
    }
}
