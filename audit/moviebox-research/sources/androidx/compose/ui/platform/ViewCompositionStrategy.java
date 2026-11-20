package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
public interface ViewCompositionStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5374a = a.f5377a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DisposeOnDetachedFromWindowOrReleasedFromPool implements ViewCompositionStrategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DisposeOnDetachedFromWindowOrReleasedFromPool f5375b = new DisposeOnDetachedFromWindowOrReleasedFromPool();

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AbstractComposeView f5376a;

            public a(AbstractComposeView abstractComposeView) {
                this.f5376a = abstractComposeView;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (k3.a.f(this.f5376a)) {
                    return;
                }
                this.f5376a.disposeComposition();
            }
        }

        public static final void c(AbstractComposeView abstractComposeView) {
            abstractComposeView.disposeComposition();
        }

        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public Function0<Unit> a(final AbstractComposeView abstractComposeView) {
            final a aVar = new a(abstractComposeView);
            abstractComposeView.addOnAttachStateChangeListener(aVar);
            final k3.b bVar = new k3.b() { // from class: androidx.compose.ui.platform.p2
                @Override // k3.b
                public final void onRelease() {
                    ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.c(abstractComposeView);
                }
            };
            k3.a.a(abstractComposeView, bVar);
            return new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    abstractComposeView.removeOnAttachStateChangeListener(aVar);
                    k3.a.g(abstractComposeView, bVar);
                }
            };
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5377a = new a();

        public final ViewCompositionStrategy a() {
            return DisposeOnDetachedFromWindowOrReleasedFromPool.f5375b;
        }
    }

    Function0<Unit> a(AbstractComposeView abstractComposeView);
}
