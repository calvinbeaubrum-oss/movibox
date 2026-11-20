package com.transsion.quickjs;

import com.quickjs.JSArray;
import com.quickjs.JSFunction;
import com.quickjs.b0;
import com.quickjs.c0;
import com.quickjs.e0;
import com.quickjs.y;
import com.transsion.quickjs.api.CodeItem;
import com.transsion.quickjs.api.JSConfigBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.quickjs.QuickJSHelper$ExecuteBuilder$start$1", f = "QuickJSHelper.kt", l = {247, 263}, m = "invokeSuspend")
public final class QuickJSHelper$ExecuteBuilder$start$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ QuickJSHelper.ExecuteBuilder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJSHelper$ExecuteBuilder$start$1(QuickJSHelper.ExecuteBuilder executeBuilder, Continuation<? super QuickJSHelper$ExecuteBuilder$start$1> continuation) {
        super(2, continuation);
        this.this$0 = executeBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuickJSHelper$ExecuteBuilder$start$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((QuickJSHelper$ExecuteBuilder$start$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0134  */
    /* JADX WARN: Code duplicated, block: B:53:0x0136  */
    /* JADX WARN: Code duplicated, block: B:56:0x013d  */
    /* JADX WARN: Code duplicated, block: B:59:0x014a  */
    /* JADX WARN: Code duplicated, block: B:61:0x014d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        QuickJSHelper quickJSHelper;
        JSArray jSArray;
        String str;
        JSConfigBean jSConfigBean;
        String str2;
        List<CodeItem> items;
        String value;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            quickJSHelper = new QuickJSHelper(null);
            quickJSHelper.i();
            for (e0 e0Var : this.this$0.f57072e) {
                y yVar = quickJSHelper.f57067b;
                if (yVar != null) {
                    yVar.W(e0Var);
                }
            }
            jSArray = new JSArray(quickJSHelper.f57067b);
            for (Object obj2 : this.this$0.f57073f) {
                if (obj2 instanceof c0) {
                    jSArray.d0(new JSFunction(quickJSHelper.f57067b, (c0) obj2));
                } else if (obj2 instanceof b0) {
                    jSArray.d0(new JSFunction(quickJSHelper.f57067b, (b0) obj2));
                } else if (obj2 instanceof String) {
                    jSArray.e0((String) obj2);
                } else if (obj2 instanceof Boolean) {
                    jSArray.g0(((Boolean) obj2).booleanValue());
                } else if (obj2 instanceof Double) {
                    jSArray.Z(((Number) obj2).doubleValue());
                } else if (obj2 instanceof Integer) {
                    jSArray.b0(((Number) obj2).intValue());
                }
            }
            uo.b.f78622a.h("quickjs", "fileName:" + this.this$0.f57068a + " jsContext and params is ready", true);
            if (this.this$0.f57071d) {
                QuickJSHelper.ExecuteBuilder executeBuilder = this.this$0;
                this.L$0 = quickJSHelper;
                this.L$1 = jSArray;
                this.L$2 = "";
                this.label = 1;
                obj = executeBuilder.k(this);
                if (obj == objE) {
                    return objE;
                }
                str = "";
                jSConfigBean = (JSConfigBean) obj;
                if (jSConfigBean != null) {
                    value = jSConfigBean.getItems().get(0).getValue();
                    if (value == null) {
                        str = "";
                    } else {
                        str = value;
                    }
                }
                if (str.length() == 0) {
                    String strN = quickJSHelper.n(this.this$0.f57068a);
                    str2 = strN != null ? strN : "";
                } else {
                    str2 = str;
                }
                quickJSHelper.j(str2, this.this$0.f57069b, jSArray, this.this$0.f57070c, (16 & 16) != 0 ? false : false);
            } else {
                String strN2 = quickJSHelper.n(this.this$0.f57068a);
                quickJSHelper.j(strN2 == null ? "" : strN2, this.this$0.f57069b, jSArray, this.this$0.f57070c, (16 & 16) != 0 ? false : false);
                QuickJSHelper.ExecuteBuilder executeBuilder2 = this.this$0;
                this.label = 2;
                if (executeBuilder2.k(this) == objE) {
                    return objE;
                }
            }
        } else if (i11 == 1) {
            str = (String) this.L$2;
            JSArray jSArray2 = (JSArray) this.L$1;
            QuickJSHelper quickJSHelper2 = (QuickJSHelper) this.L$0;
            ResultKt.b(obj);
            jSArray = jSArray2;
            quickJSHelper = quickJSHelper2;
            jSConfigBean = (JSConfigBean) obj;
            if (jSConfigBean != null && (items = jSConfigBean.getItems()) != null && !items.isEmpty()) {
                value = jSConfigBean.getItems().get(0).getValue();
                if (value == null) {
                    str = "";
                } else {
                    str = value;
                }
            }
            if (str.length() == 0) {
                String strN3 = quickJSHelper.n(this.this$0.f57068a);
                str2 = strN3 != null ? strN3 : "";
            } else {
                str2 = str;
            }
            quickJSHelper.j(str2, this.this$0.f57069b, jSArray, this.this$0.f57070c, (16 & 16) != 0 ? false : false);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
