package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.m;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.y0;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.u2;
import androidx.compose.ui.platform.v2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements v2 {
    public static final int $stable = 8;
    public final NestedScrollDispatcher A;
    public final androidx.compose.runtime.saveable.b B;
    public final int C;
    public final String D;
    public androidx.compose.runtime.saveable.b.a E;
    public Function1<? super T, Unit> F;
    public Function1<? super T, Unit> G;
    public Function1<? super T, Unit> H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final T f6216z;

    public ViewFactoryHolder(Context context, m mVar, T t11, NestedScrollDispatcher nestedScrollDispatcher, androidx.compose.runtime.saveable.b bVar, int i11, y0 y0Var) {
        super(context, mVar, i11, nestedScrollDispatcher, t11, y0Var);
        this.f6216z = t11;
        this.A = nestedScrollDispatcher;
        this.B = bVar;
        this.C = i11;
        setClipChildren(false);
        String strValueOf = String.valueOf(i11);
        this.D = strValueOf;
        Object objF = bVar != null ? bVar.f(strValueOf) : null;
        SparseArray<Parcelable> sparseArray = objF instanceof SparseArray ? (SparseArray) objF : null;
        if (sparseArray != null) {
            t11.restoreHierarchyState(sparseArray);
        }
        d();
        this.F = AndroidView_androidKt.a();
        this.G = AndroidView_androidKt.a();
        this.H = AndroidView_androidKt.a();
    }

    public /* synthetic */ ViewFactoryHolder(Context context, m mVar, View view, NestedScrollDispatcher nestedScrollDispatcher, androidx.compose.runtime.saveable.b bVar, int i11, y0 y0Var, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : mVar, view, (i12 & 8) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher, bVar, i11, y0Var);
    }

    public ViewFactoryHolder(Context context, Function1<? super Context, ? extends T> function1, m mVar, androidx.compose.runtime.saveable.b bVar, int i11, y0 y0Var) {
        this(context, mVar, function1.invoke(context), null, bVar, i11, y0Var, 8, null);
    }

    public /* synthetic */ ViewFactoryHolder(Context context, Function1 function1, m mVar, androidx.compose.runtime.saveable.b bVar, int i11, y0 y0Var, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, function1, (i12 & 4) != 0 ? null : mVar, bVar, i11, y0Var);
    }

    private final void setSavableRegistryEntry(androidx.compose.runtime.saveable.b.a aVar) {
        androidx.compose.runtime.saveable.b.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.unregister();
        }
        this.E = aVar;
    }

    public final void d() {
        androidx.compose.runtime.saveable.b bVar = this.B;
        if (bVar != null) {
            setSavableRegistryEntry(bVar.b(this.D, new Function0<Object>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$registerSaveStateProvider$1
                final /* synthetic */ ViewFactoryHolder<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                    this.this$0.f6216z.saveHierarchyState(sparseArray);
                    return sparseArray;
                }
            }));
        }
    }

    public final void e() {
        setSavableRegistryEntry(null);
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.A;
    }

    public final Function1<T, Unit> getReleaseBlock() {
        return this.H;
    }

    public final Function1<T, Unit> getResetBlock() {
        return this.G;
    }

    public /* bridge */ /* synthetic */ AbstractComposeView getSubCompositionView() {
        return u2.a(this);
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.F;
    }

    public View getViewRoot() {
        return this;
    }

    public final void setReleaseBlock(Function1<? super T, Unit> function1) {
        this.H = function1;
        setRelease(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$releaseBlock$1
            final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getReleaseBlock().invoke(this.this$0.f6216z);
                this.this$0.e();
            }
        });
    }

    public final void setResetBlock(Function1<? super T, Unit> function1) {
        this.G = function1;
        setReset(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$resetBlock$1
            final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getResetBlock().invoke(this.this$0.f6216z);
            }
        });
    }

    public final void setUpdateBlock(Function1<? super T, Unit> function1) {
        this.F = function1;
        setUpdate(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$updateBlock$1
            final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getUpdateBlock().invoke(this.this$0.f6216z);
            }
        });
    }
}
