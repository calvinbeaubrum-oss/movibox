package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
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
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<z> f4732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f4733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4736e;

    public q(List<z> list) {
        this(list, null);
    }

    public q(List<z> list, i iVar) {
        this.f4732a = list;
        this.f4733b = iVar;
        MotionEvent motionEventE = e();
        this.f4734c = p.a(motionEventE != null ? motionEventE.getButtonState() : 0);
        MotionEvent motionEventE2 = e();
        this.f4735d = j0.b(motionEventE2 != null ? motionEventE2.getMetaState() : 0);
        this.f4736e = a();
    }

    public final int a() {
        MotionEvent motionEventE = e();
        if (motionEventE == null) {
            List<z> list = this.f4732a;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                z zVar = list.get(i11);
                if (r.d(zVar)) {
                    return s.f4737a.e();
                }
                if (r.b(zVar)) {
                    return s.f4737a.d();
                }
            }
            return s.f4737a.c();
        }
        int actionMasked = motionEventE.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    switch (actionMasked) {
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            return s.f4737a.f();
                        case 9:
                            return s.f4737a.a();
                        case 10:
                            return s.f4737a.b();
                        default:
                            return s.f4737a.g();
                    }
                }
                return s.f4737a.c();
            }
            return s.f4737a.e();
        }
        return s.f4737a.d();
    }

    public final int b() {
        return this.f4734c;
    }

    public final List<z> c() {
        return this.f4732a;
    }

    public final i d() {
        return this.f4733b;
    }

    public final MotionEvent e() {
        i iVar = this.f4733b;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    public final int f() {
        return this.f4736e;
    }

    public final void g(int i11) {
        this.f4736e = i11;
    }
}
