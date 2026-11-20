package com.transsion.quickjs;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.quickjs.JSArray;
import com.quickjs.QuickJS;
import com.quickjs.e0;
import com.quickjs.plugin.f;
import com.quickjs.y;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.quickjs.api.CodeItem;
import com.transsion.quickjs.api.JSConfigBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class QuickJSHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f57063c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<MMKV> f57064d = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.quickjs.QuickJSHelper$Companion$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_app_js_config");
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<ExecutorService> f57065e = LazyKt__LazyJVMKt.b(new Function0<ExecutorService>() { // from class: com.transsion.quickjs.QuickJSHelper$Companion$singleExecutor$2
        @Override // kotlin.jvm.functions.Function0
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QuickJS f57066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f57067b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class ExecuteBuilder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.transsion.quickjs.a f57070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f57071d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f57068a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f57069b = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<e0> f57072e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<Object> f57073f = new ArrayList();

        public final ExecuteBuilder h(e0 plugin) {
            Intrinsics.g(plugin, "plugin");
            this.f57072e.add(plugin);
            return this;
        }

        public final ExecuteBuilder i(String string) {
            Intrinsics.g(string, "string");
            this.f57073f.add(string);
            return this;
        }

        public final ExecuteBuilder j(com.transsion.quickjs.a callback) {
            Intrinsics.g(callback, "callback");
            this.f57070c = callback;
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        public final Object k(Continuation<? super JSConfigBean> continuation) throws Throwable {
            QuickJSHelper$ExecuteBuilder$fetchCode$1 quickJSHelper$ExecuteBuilder$fetchCode$1;
            ExecuteBuilder executeBuilder;
            List<CodeItem> items;
            CodeItem codeItem;
            String value;
            if (continuation instanceof QuickJSHelper$ExecuteBuilder$fetchCode$1) {
                quickJSHelper$ExecuteBuilder$fetchCode$1 = (QuickJSHelper$ExecuteBuilder$fetchCode$1) continuation;
                int i11 = quickJSHelper$ExecuteBuilder$fetchCode$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    quickJSHelper$ExecuteBuilder$fetchCode$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    quickJSHelper$ExecuteBuilder$fetchCode$1 = new QuickJSHelper$ExecuteBuilder$fetchCode$1(this, continuation);
                }
            } else {
                quickJSHelper$ExecuteBuilder$fetchCode$1 = new QuickJSHelper$ExecuteBuilder$fetchCode$1(this, continuation);
            }
            QuickJSHelper$ExecuteBuilder$fetchCode$1 quickJSHelper$ExecuteBuilder$fetchCode$2 = quickJSHelper$ExecuteBuilder$fetchCode$1;
            Object objA = quickJSHelper$ExecuteBuilder$fetchCode$2.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = quickJSHelper$ExecuteBuilder$fetchCode$2.label;
            if (i12 == 0) {
                ResultKt.b(objA);
                try {
                    ow.a aVar = (ow.a) NetServiceGenerator.f49399d.a().i(ow.a.class);
                    String string = QuickJSHelper.f57063c.c().getString(this.f57068a + "_version", "");
                    String str = this.f57068a;
                    quickJSHelper$ExecuteBuilder$fetchCode$2.L$0 = this;
                    quickJSHelper$ExecuteBuilder$fetchCode$2.label = 1;
                    objA = ow.a.C0794a.a(aVar, null, str, string, quickJSHelper$ExecuteBuilder$fetchCode$2, 1, null);
                    if (objA == objE) {
                        return objE;
                    }
                    executeBuilder = this;
                } catch (Exception e11) {
                    e = e11;
                    executeBuilder = this;
                    uo.b.f78622a.h("quickjs", "request " + executeBuilder.f57068a + " failed(" + executeBuilder.f57071d + ") with " + e.getMessage(), true);
                    e.printStackTrace();
                    return null;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                executeBuilder = (ExecuteBuilder) quickJSHelper$ExecuteBuilder$fetchCode$2.L$0;
                try {
                    ResultKt.b(objA);
                } catch (Exception e12) {
                    e = e12;
                    uo.b.f78622a.h("quickjs", "request " + executeBuilder.f57068a + " failed(" + executeBuilder.f57071d + ") with " + e.getMessage(), true);
                    e.printStackTrace();
                    return null;
                }
            }
            BaseDto baseDto = (BaseDto) objA;
            JSConfigBean jSConfigBean = (JSConfigBean) baseDto.getData();
            List<CodeItem> items2 = jSConfigBean != null ? jSConfigBean.getItems() : null;
            if (items2 != null && !items2.isEmpty() && jSConfigBean != null && (items = jSConfigBean.getItems()) != null && (codeItem = items.get(0)) != null && (value = codeItem.getValue()) != null) {
                a aVar2 = QuickJSHelper.f57063c;
                aVar2.c().putString(executeBuilder.f57068a, value);
                MMKV mmkvC = aVar2.c();
                String str2 = executeBuilder.f57068a + "_version";
                JSConfigBean jSConfigBean2 = (JSConfigBean) baseDto.getData();
                mmkvC.putString(str2, jSConfigBean2 != null ? jSConfigBean2.getVersion() : null);
            }
            return jSConfigBean;
        }

        public final ExecuteBuilder l(String fileName) {
            Intrinsics.g(fileName, "fileName");
            this.f57068a = fileName;
            return this;
        }

        public final ExecuteBuilder m(String functionName) {
            Intrinsics.g(functionName, "functionName");
            this.f57069b = functionName;
            return this;
        }

        public final void n() {
            if (this.f57069b.length() != 0 && this.f57068a.length() != 0) {
                ExecutorService singleExecutor = QuickJSHelper.f57063c.d();
                Intrinsics.f(singleExecutor, "singleExecutor");
                j.d(l0.a(i1.b(singleExecutor)), null, null, new QuickJSHelper$ExecuteBuilder$start$1(this, null), 3, null).start();
                return;
            }
            uo.b.f78622a.h("quickjs", "fileName:" + this.f57068a + " or functionName:" + this.f57069b + " is null", true);
            throw new RuntimeException("fileName and functionName is must set");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MMKV c() {
            Object value = QuickJSHelper.f57064d.getValue();
            Intrinsics.f(value, "<get-mmkv>(...)");
            return (MMKV) value;
        }

        public final ExecutorService d() {
            return (ExecutorService) QuickJSHelper.f57065e.getValue();
        }
    }

    public QuickJSHelper() {
    }

    public /* synthetic */ QuickJSHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void l(com.transsion.quickjs.a aVar, Object obj) {
        if (aVar != null) {
            aVar.onSuccess(obj);
        }
    }

    public static final void m(com.transsion.quickjs.a aVar, Exception e11) {
        Intrinsics.g(e11, "$e");
        if (aVar != null) {
            aVar.a(e11.getMessage(), 0);
        }
    }

    public final void h(y yVar) {
        if (yVar != null) {
            yVar.W(new pw.b());
        }
        if (yVar != null) {
            yVar.W(new com.quickjs.plugin.b());
        }
        if (yVar != null) {
            yVar.W(new f());
        }
    }

    public final y i() {
        if (this.f57066a == null) {
            this.f57066a = QuickJS.d();
        }
        if (this.f57067b == null) {
            QuickJS quickJS = this.f57066a;
            y yVarC = quickJS != null ? quickJS.c() : null;
            this.f57067b = yVarC;
            h(yVarC);
        }
        y yVar = this.f57067b;
        Intrinsics.d(yVar);
        return yVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(String str, String str2, JSArray jSArray, final com.transsion.quickjs.a aVar, boolean z11) {
        y yVar;
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, "quickjs", "run " + str2 + " start run", false, 4, null);
        if (this.f57067b == null) {
            i();
        }
        try {
            y yVar2 = this.f57067b;
            if (yVar2 != null) {
                yVar2.g0(str, str2 + ".js");
            }
            y yVar3 = this.f57067b;
            final Object objG = yVar3 != null ? yVar3.g(str2, jSArray) : null;
            if (z11) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.quickjs.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QuickJSHelper.l(aVar, objG);
                    }
                });
            } else if (aVar != null) {
                aVar.onSuccess(objG);
            }
            aVar2.c("quickjs", "run " + str2 + " success", true);
            QuickJS quickJS = this.f57066a;
            if (quickJS != null) {
                quickJS.close();
            }
            yVar = this.f57067b;
            if (yVar != null) {
                yVar.close();
            }
        } catch (Exception e11) {
            uo.b.f78622a.h("quickjs", "run " + str2 + " failed: " + e11.getMessage(), true);
            if (z11) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.quickjs.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QuickJSHelper.m(aVar, e11);
                    }
                });
            } else if (aVar != null) {
                aVar.a(e11.getMessage(), 0);
            }
            e11.printStackTrace();
            QuickJS quickJS2 = this.f57066a;
            if (quickJS2 != null) {
                quickJS2.close();
            }
            yVar = this.f57067b;
            if (yVar != null) {
            }
        } finally {
            QuickJS quickJS3 = this.f57066a;
            if (quickJS3 != null) {
                quickJS3.close();
            }
            y yVar4 = this.f57067b;
            if (yVar4 != null) {
                yVar4.close();
            }
            this.f57066a = null;
            this.f57067b = null;
        }
    }

    public final String n(String str) {
        String string = f57063c.c().getString(str, "");
        if (string != null && string.length() != 0) {
            return string;
        }
        uo.b.f78622a.h("quickjs", "fileName:" + str + " use buildIn file", true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".js");
        String string2 = sb2.toString();
        Application applicationA = com.tn.lib.util.a.f49452a.a();
        Intrinsics.d(applicationA);
        return d.a(string2, applicationA);
    }
}
