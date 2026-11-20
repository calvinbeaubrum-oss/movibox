package com.cloud.tmc.integration.defaultImpl;

import android.os.Bundle;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.ReportFactoryProxy;
import com.cloud.tmc.integration.utils.g0;
import com.cloud.tmc.integration.utils.l;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.n;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.render.ILocalChannelProxy;
import com.cloud.tmc.render.method.LocalChannelInterface;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tc.a;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class LocalChannelImp implements ILocalChannelProxy {
    @Override // com.cloud.tmc.render.ILocalChannelProxy
    public String gamePerformanceMonitorGetStr() {
        MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
        return miniAppConfigHelper.b("keyGamePerformanceMonitorStrUseLocal", true) ? "eyJodHRwczovL3d3dy5xeXhnYW1lLmNvbS9SZXNjdWVfVGhlX0xvdmVyL2luZGV4Lmh0bWw/dXRtX3NvdXJjZT1sYXVuY2hlcl9pbnN0YW50YXBwODg0NzciOnsidGFyZ2V0RWxlbWVudElkIjoiI2xvYWRpbmciLCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cueGlhb3l0Z2FtZS5jb20vVGVtcGxlUnVuXzIvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NyI6eyJ0YXJnZXRFbGVtZW50SWQiOiIucHJvZ3Jlc3MtdGV4dCIsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3Lm9vcHBnYW1lLmNvbS9Qb3VsdHJ5X0Zhcm0vaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODE4OCI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6NTAwMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuamx5eWdhbWUuY29tL0NoaWxkcmVuX0RvY3Rvcl9EZW50aXN0L2luZGV4Lmh0bWw/dXRtX3NvdXJjZT1sYXVuY2hlcl9pbnN0YW50YXBwODg0NzciOnsidGFyZ2V0VmVjdGV4UHJlRnJhbWUiOjMwMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuaHpzZGdhbWUuY29tL1BhdGhfQ29sb3JfTGluZS9pbmRleC5odG1sP3V0bV9zb3VyY2U9bGF1bmNoZXJfaW5zdGFudGFwcDg4NDc2NyI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MzAwLCJyZW5kZXJSZWFkeUlkbGVMb2FkVGltZVRIIjo5OTksIm92ZXJhbGxJZGxlTG9hZFRpbWVUSCI6LTF9LCJodHRwczovL3d3dy5vb3BwZ2FtZS5jb20vQnJpZGdlX0J1aWxkZXIvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NiI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MTAwMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuYWZhbnRhaWdhbWUuY29tL0tpbGxlcl9Bc3Nhc3Npbi9pbmRleC5odG1sP3V0bV9zb3VyY2U9bGF1bmNoZXJfaW5zdGFudGFwcDg4NDc2Ijp7InRhcmdldFZlY3RleFByZUZyYW1lIjo1MDAsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3LmJoamdhbWUuY29tL1N1YndheV9TdXJmZXJfU2VvdWwvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NyI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MTAwMDAsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3LmptYmlsZWdhbWUuY29tL0YxX3J1c2gvaW5kZXguaHRtbCI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MTAwMDAsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3LmptYmlsZWdhbWUuY29tL0ljZWNyZWFtL2luZGV4Lmh0bWwiOnsidGFyZ2V0VmVjdGV4UHJlRnJhbWUiOjEyMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuemh4aWFrZW1hb2dhbWUuY29tL0xhc3RfTmlnaHQvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NyI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6NDUwLCJyZW5kZXJSZWFkeUlkbGVMb2FkVGltZVRIIjo5OTksIm92ZXJhbGxJZGxlTG9hZFRpbWVUSCI6LTF9fQ==" : miniAppConfigHelper.e("keyGamePerformanceMonitorStr", "eyJodHRwczovL3d3dy5xeXhnYW1lLmNvbS9SZXNjdWVfVGhlX0xvdmVyL2luZGV4Lmh0bWw/dXRtX3NvdXJjZT1sYXVuY2hlcl9pbnN0YW50YXBwODg0NzciOnsidGFyZ2V0RWxlbWVudElkIjoiI2xvYWRpbmciLCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cueGlhb3l0Z2FtZS5jb20vVGVtcGxlUnVuXzIvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NyI6eyJ0YXJnZXRFbGVtZW50SWQiOiIucHJvZ3Jlc3MtdGV4dCIsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3Lm9vcHBnYW1lLmNvbS9Qb3VsdHJ5X0Zhcm0vaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODE4OCI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6NTAwMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuamx5eWdhbWUuY29tL0NoaWxkcmVuX0RvY3Rvcl9EZW50aXN0L2luZGV4Lmh0bWw/dXRtX3NvdXJjZT1sYXVuY2hlcl9pbnN0YW50YXBwODg0NzciOnsidGFyZ2V0VmVjdGV4UHJlRnJhbWUiOjMwMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuaHpzZGdhbWUuY29tL1BhdGhfQ29sb3JfTGluZS9pbmRleC5odG1sP3V0bV9zb3VyY2U9bGF1bmNoZXJfaW5zdGFudGFwcDg4NDc2NyI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MzAwLCJyZW5kZXJSZWFkeUlkbGVMb2FkVGltZVRIIjo5OTksIm92ZXJhbGxJZGxlTG9hZFRpbWVUSCI6LTF9LCJodHRwczovL3d3dy5vb3BwZ2FtZS5jb20vQnJpZGdlX0J1aWxkZXIvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NiI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MTAwMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuYWZhbnRhaWdhbWUuY29tL0tpbGxlcl9Bc3Nhc3Npbi9pbmRleC5odG1sP3V0bV9zb3VyY2U9bGF1bmNoZXJfaW5zdGFudGFwcDg4NDc2Ijp7InRhcmdldFZlY3RleFByZUZyYW1lIjo1MDAsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3LmJoamdhbWUuY29tL1N1YndheV9TdXJmZXJfU2VvdWwvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NyI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MTAwMDAsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3LmptYmlsZWdhbWUuY29tL0YxX3J1c2gvaW5kZXguaHRtbCI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6MTAwMDAsInJlbmRlclJlYWR5SWRsZUxvYWRUaW1lVEgiOjk5OSwib3ZlcmFsbElkbGVMb2FkVGltZVRIIjotMX0sImh0dHBzOi8vd3d3LmptYmlsZWdhbWUuY29tL0ljZWNyZWFtL2luZGV4Lmh0bWwiOnsidGFyZ2V0VmVjdGV4UHJlRnJhbWUiOjEyMCwicmVuZGVyUmVhZHlJZGxlTG9hZFRpbWVUSCI6OTk5LCJvdmVyYWxsSWRsZUxvYWRUaW1lVEgiOi0xfSwiaHR0cHM6Ly93d3cuemh4aWFrZW1hb2dhbWUuY29tL0xhc3RfTmlnaHQvaW5kZXguaHRtbD91dG1fc291cmNlPWxhdW5jaGVyX2luc3RhbnRhcHA4ODQ3NyI6eyJ0YXJnZXRWZWN0ZXhQcmVGcmFtZSI6NDUwLCJyZW5kZXJSZWFkeUlkbGVMb2FkVGltZVRIIjo5OTksIm92ZXJhbGxJZGxlTG9hZFRpbWVUSCI6LTF9fQ==");
    }

    @Override // com.cloud.tmc.render.ILocalChannelProxy
    public void report(String tag, String reportData, Integer num, Integer num2) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(reportData, "reportData");
        try {
            if (n.a(tag)) {
                p.e(LocalChannelImp.class.getSimpleName(), "tag is empty");
                return;
            }
            if (n.a(reportData)) {
                p.e(LocalChannelImp.class.getSimpleName(), "reportData is empty");
                return;
            }
            Map<String, ? extends Object> _dataMap = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.defaultImpl.LocalChannelImp$report$gson$1
            }.getType(), new g0()).serializeNulls().create().fromJson(reportData, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.defaultImpl.LocalChannelImp$report$_dataMap$1
            }.getType());
            Bundle bundle = new Bundle();
            l lVar = l.f31069a;
            Intrinsics.f(_dataMap, "_dataMap");
            lVar.a(_dataMap, bundle);
            ((ReportFactoryProxy) a.a(ReportFactoryProxy.class)).report("", tag, bundle, num, num2);
        } catch (Exception e11) {
            TmcLogger.e("report exception:" + e11);
        }
    }

    @Override // com.cloud.tmc.render.ILocalChannelProxy
    public void reportForH5(String tag, String reportData, Integer num, Integer num2) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(reportData, "reportData");
        try {
            if (n.a(tag)) {
                p.e(LocalChannelImp.class.getSimpleName(), "tag is empty");
                LocalChannelInterface.f32099c.a(2, "tag is empty");
            } else {
                if (n.a(reportData)) {
                    p.e(LocalChannelImp.class.getSimpleName(), "reportData is empty");
                    LocalChannelInterface.f32099c.a(3, "reportData is empty");
                    return;
                }
                Map<String, ? extends Object> _dataMap = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.defaultImpl.LocalChannelImp$reportForH5$gson$1
                }.getType(), new g0()).serializeNulls().create().fromJson(reportData, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.integration.defaultImpl.LocalChannelImp$reportForH5$_dataMap$1
                }.getType());
                Bundle bundle = new Bundle();
                l lVar = l.f31069a;
                Intrinsics.f(_dataMap, "_dataMap");
                lVar.a(_dataMap, bundle);
                ((ReportFactoryProxy) a.a(ReportFactoryProxy.class)).report("", tag, bundle, num, num2);
            }
        } catch (Exception e11) {
            LocalChannelInterface.f32099c.a(4, String.valueOf(e11));
        }
    }
}
