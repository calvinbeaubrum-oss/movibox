package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f3560a;

    public r1(List<Integer> list) {
        this.f3560a = list;
    }

    public /* synthetic */ r1(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    public final void a(int i11) {
        if (!this.f3560a.isEmpty()) {
            if (this.f3560a.get(0).intValue() == i11) {
                return;
            }
            List<Integer> list = this.f3560a;
            if (list.get(list.size() - 1).intValue() == i11) {
                return;
            }
        }
        int size = this.f3560a.size();
        this.f3560a.add(Integer.valueOf(i11));
        while (size > 0) {
            int i12 = ((size + 1) >>> 1) - 1;
            int iIntValue = this.f3560a.get(i12).intValue();
            if (i11 <= iIntValue) {
                break;
            }
            this.f3560a.set(size, Integer.valueOf(iIntValue));
            size = i12;
        }
        this.f3560a.set(size, Integer.valueOf(i11));
    }

    public final boolean b() {
        return !this.f3560a.isEmpty();
    }

    public final int c() {
        return ((Number) CollectionsKt___CollectionsKt.e0(this.f3560a)).intValue();
    }

    public final int d() {
        int iIntValue;
        if (!(this.f3560a.size() > 0)) {
            k.s("Set is empty");
        }
        int iIntValue2 = this.f3560a.get(0).intValue();
        while ((!this.f3560a.isEmpty()) && this.f3560a.get(0).intValue() == iIntValue2) {
            List<Integer> list = this.f3560a;
            list.set(0, (Integer) CollectionsKt___CollectionsKt.q0(list));
            List<Integer> list2 = this.f3560a;
            list2.remove(list2.size() - 1);
            int size = this.f3560a.size();
            int size2 = this.f3560a.size() >>> 1;
            int i11 = 0;
            while (i11 < size2) {
                int iIntValue3 = this.f3560a.get(i11).intValue();
                int i12 = (i11 + 1) * 2;
                int i13 = i12 - 1;
                int iIntValue4 = this.f3560a.get(i13).intValue();
                if (i12 < size && (iIntValue = this.f3560a.get(i12).intValue()) > iIntValue4) {
                    if (iIntValue <= iIntValue3) {
                        break;
                    }
                    this.f3560a.set(i11, Integer.valueOf(iIntValue));
                    this.f3560a.set(i12, Integer.valueOf(iIntValue3));
                    i11 = i12;
                } else {
                    if (iIntValue4 <= iIntValue3) {
                        break;
                    }
                    this.f3560a.set(i11, Integer.valueOf(iIntValue4));
                    this.f3560a.set(i13, Integer.valueOf(iIntValue3));
                    i11 = i13;
                }
            }
        }
        return iIntValue2;
    }
}
