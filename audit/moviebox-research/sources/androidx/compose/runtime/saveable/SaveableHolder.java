package androidx.compose.runtime.saveable;

import androidx.compose.runtime.b2;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SaveableHolder<T> implements e, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d<T, Object> f3567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f3568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f3570d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object[] f3571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.a f3572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Object> f3573h = new Function0<Object>(this) { // from class: androidx.compose.runtime.saveable.SaveableHolder$valueProvider$1
        final /* synthetic */ SaveableHolder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d dVar = this.this$0.f3567a;
            SaveableHolder<T> saveableHolder = this.this$0;
            Object obj = saveableHolder.f3570d;
            if (obj != null) {
                return dVar.a(saveableHolder, obj);
            }
            throw new IllegalArgumentException("Value should be initialized".toString());
        }
    };

    public SaveableHolder(d<T, Object> dVar, b bVar, String str, T t11, Object[] objArr) {
        this.f3567a = dVar;
        this.f3568b = bVar;
        this.f3569c = str;
        this.f3570d = t11;
        this.f3571f = objArr;
    }

    private final void e() {
        b bVar = this.f3568b;
        if (this.f3572g == null) {
            if (bVar != null) {
                RememberSaveableKt.d(bVar, this.f3573h.invoke());
                this.f3572g = bVar.b(this.f3569c, this.f3573h);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("entry(" + this.f3572g + ") is not null").toString());
    }

    @Override // androidx.compose.runtime.saveable.e
    public boolean a(Object obj) {
        b bVar = this.f3568b;
        return bVar == null || bVar.a(obj);
    }

    public final T d(Object[] objArr) {
        if (Arrays.equals(objArr, this.f3571f)) {
            return this.f3570d;
        }
        return null;
    }

    public final void f(d<T, Object> dVar, b bVar, String str, T t11, Object[] objArr) {
        boolean z11;
        boolean z12 = true;
        if (this.f3568b != bVar) {
            this.f3568b = bVar;
            z11 = true;
        } else {
            z11 = false;
        }
        if (Intrinsics.b(this.f3569c, str)) {
            z12 = z11;
        } else {
            this.f3569c = str;
        }
        this.f3567a = dVar;
        this.f3570d = t11;
        this.f3571f = objArr;
        b.a aVar = this.f3572g;
        if (aVar == null || !z12) {
            return;
        }
        if (aVar != null) {
            aVar.unregister();
        }
        this.f3572g = null;
        e();
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        b.a aVar = this.f3572g;
        if (aVar != null) {
            aVar.unregister();
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        b.a aVar = this.f3572g;
        if (aVar != null) {
            aVar.unregister();
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        e();
    }
}
