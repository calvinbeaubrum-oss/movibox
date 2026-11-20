package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.R$id;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public final class RippleContainer extends ViewGroup {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<RippleHostView> f3135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<RippleHostView> f3136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f3137d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3138f;

    public RippleContainer(Context context) {
        super(context);
        this.f3134a = 5;
        ArrayList arrayList = new ArrayList();
        this.f3135b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f3136c = arrayList2;
        this.f3137d = new f();
        setClipChildren(false);
        RippleHostView rippleHostView = new RippleHostView(context);
        addView(rippleHostView);
        arrayList.add(rippleHostView);
        arrayList2.add(rippleHostView);
        this.f3138f = 1;
        setTag(R$id.hide_in_inspector_tag, Boolean.TRUE);
    }

    public final void disposeRippleIfNeeded(e eVar) {
        eVar.E0();
        RippleHostView rippleHostViewB = this.f3137d.b(eVar);
        if (rippleHostViewB != null) {
            rippleHostViewB.disposeRipple();
            this.f3137d.c(eVar);
            this.f3136c.add(rippleHostViewB);
        }
    }

    public final RippleHostView getRippleHostView(e eVar) {
        RippleHostView rippleHostViewB = this.f3137d.b(eVar);
        if (rippleHostViewB != null) {
            return rippleHostViewB;
        }
        RippleHostView rippleHostView = (RippleHostView) kotlin.collections.k.I(this.f3136c);
        if (rippleHostView == null) {
            if (this.f3138f > kotlin.collections.g.n(this.f3135b)) {
                rippleHostView = new RippleHostView(getContext());
                addView(rippleHostView);
                this.f3135b.add(rippleHostView);
            } else {
                rippleHostView = this.f3135b.get(this.f3138f);
                e eVarA = this.f3137d.a(rippleHostView);
                if (eVarA != null) {
                    eVarA.E0();
                    this.f3137d.c(eVarA);
                    rippleHostView.disposeRipple();
                }
            }
            int i11 = this.f3138f;
            if (i11 < this.f3134a - 1) {
                this.f3138f = i11 + 1;
            } else {
                this.f3138f = 0;
            }
        }
        this.f3137d.d(eVar, rippleHostView);
        return rippleHostView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }
}
