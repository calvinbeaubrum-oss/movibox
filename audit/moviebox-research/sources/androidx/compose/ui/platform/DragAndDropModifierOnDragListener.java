package androidx.compose.ui.platform;

import android.view.DragEvent;
import android.view.View;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
public final class DragAndDropModifierOnDragListener implements View.OnDragListener, androidx.compose.ui.draganddrop.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<androidx.compose.ui.draganddrop.g, y1.m, Function1<? super z1.g, Unit>, Boolean> f5326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DragAndDropNode f5327b = new DragAndDropNode(new Function1<androidx.compose.ui.draganddrop.b, androidx.compose.ui.draganddrop.f>() { // from class: androidx.compose.ui.platform.DragAndDropModifierOnDragListener$rootDragAndDropNode$1
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.draganddrop.f invoke(androidx.compose.ui.draganddrop.b bVar) {
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.b<androidx.compose.ui.draganddrop.d> f5328c = new androidx.collection.b<>(0, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.f f5329d = new androidx.compose.ui.node.l0<DragAndDropNode>() { // from class: androidx.compose.ui.platform.DragAndDropModifierOnDragListener$modifier$1
        public boolean equals(Object obj) {
            return obj == this;
        }

        public int hashCode() {
            return this.f5330b.f5327b.hashCode();
        }

        @Override // androidx.compose.ui.node.l0
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public DragAndDropNode a() {
            return this.f5330b.f5327b;
        }

        @Override // androidx.compose.ui.node.l0
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void o(DragAndDropNode dragAndDropNode) {
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropModifierOnDragListener(Function3<? super androidx.compose.ui.draganddrop.g, ? super y1.m, ? super Function1<? super z1.g, Unit>, Boolean> function3) {
        this.f5326a = function3;
    }

    @Override // androidx.compose.ui.draganddrop.c
    public boolean a(androidx.compose.ui.draganddrop.d dVar) {
        return this.f5328c.contains(dVar);
    }

    @Override // androidx.compose.ui.draganddrop.c
    public void b(androidx.compose.ui.draganddrop.d dVar) {
        this.f5328c.add(dVar);
    }

    public androidx.compose.ui.f d() {
        return this.f5329d;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        androidx.compose.ui.draganddrop.b bVar = new androidx.compose.ui.draganddrop.b(dragEvent);
        switch (dragEvent.getAction()) {
            case 1:
                boolean zH1 = this.f5327b.H1(bVar);
                Iterator<androidx.compose.ui.draganddrop.d> it = this.f5328c.iterator();
                while (it.hasNext()) {
                    it.next().G(bVar);
                }
                return zH1;
            case 2:
                this.f5327b.H(bVar);
                return false;
            case 3:
                return this.f5327b.s0(bVar);
            case 4:
                this.f5327b.b1(bVar);
                return false;
            case 5:
                this.f5327b.h0(bVar);
                return false;
            case 6:
                this.f5327b.S(bVar);
                return false;
            default:
                return false;
        }
    }
}
