package com.transsion.moviedetail.staff;

import android.os.SystemClock;
import android.util.SparseArray;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.moviedetailapi.bean.Staff;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends Staff> f53793c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53791a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53792b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray<Long> f53794d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashSet<String> f53795e = new HashSet<>();

    public final int a() {
        return this.f53791a;
    }

    public final int b() {
        return this.f53792b;
    }

    public final void c(int i11, long j11) {
        String staffId;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("reportBrowseEvent  staff----  position:");
            sb2.append(i11);
            sb2.append("  duration:");
            sb2.append(j11);
            List<? extends Staff> list = this.f53793c;
            Staff staff = list != null ? list.get(i11) : null;
            if (!this.f53795e.add(staff != null ? staff.getStaffId() : null)) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("item_type", "staff");
            if (staff == null || (staffId = staff.getStaffId()) == null) {
                staffId = "";
            }
            linkedHashMap.put("staff_id", staffId);
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            linkedHashMap.put("browse_duration", String.valueOf(j11));
            com.transsion.baselib.helper.a.f51183a.d("staff_info", linkedHashMap);
        } catch (Exception unused) {
        }
    }

    public final void d(int i11, int i12) {
        int i13 = this.f53791a;
        if (i13 == i11 && this.f53792b == i12) {
            return;
        }
        if (i13 >= 0 && this.f53792b >= 0) {
            ArrayList arrayList = new ArrayList();
            IntIterator intIteratorA = androidx.core.util.k.a(this.f53794d);
            while (intIteratorA.hasNext()) {
                int iIntValue = intIteratorA.next().intValue();
                if (i11 > iIntValue || iIntValue > i12) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Long l11 = this.f53794d.get(iIntValue);
                    Intrinsics.f(l11, "subjectBrowserHashMap.get(it)");
                    c(iIntValue, jElapsedRealtime - l11.longValue());
                    arrayList.add(Integer.valueOf(iIntValue));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f53794d.remove(((Number) it.next()).intValue());
            }
            if (i11 <= i12) {
                int i14 = i11;
                while (true) {
                    if (this.f53794d.get(i14) == null) {
                        this.f53794d.put(i14, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    if (i14 == i12) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
        } else if (i11 <= i12) {
            int i15 = i11;
            while (true) {
                this.f53794d.put(i15, Long.valueOf(SystemClock.elapsedRealtime()));
                if (i15 == i12) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.f53791a = i11;
        this.f53792b = i12;
    }

    public final void e(List<? extends Staff> list) {
        this.f53793c = list;
    }
}
