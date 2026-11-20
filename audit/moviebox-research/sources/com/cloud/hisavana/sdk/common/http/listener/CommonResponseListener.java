package com.cloud.hisavana.sdk.common.http.listener;

import android.os.Handler;
import android.util.Log;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class CommonResponseListener<E> extends ResponseBaseListener {
    public CommonResponseListener() {
    }

    public CommonResponseListener(boolean z11) {
        super(z11);
    }

    public abstract void g(int i11, E e11);

    public void h(int i11, String str) {
        i(i11, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(final int i11, String str) {
        final Object objB;
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                throw new RuntimeException("Missing type parameter.");
            }
            try {
                objB = GsonUtil.b(str, ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            } catch (Exception e11) {
                z.a().e("ssp", "GsonUtil parseResponse " + Log.getStackTraceString(e11));
                objB = null;
            }
            Handler handler = this.f29457a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java.lang.Runnable
                    public void run() {
                        CommonResponseListener.this.g(i11, objB);
                    }
                });
            } else {
                g(i11, objB);
            }
        } catch (Throwable th2) {
            z.a().e("ssp", "parseResponse " + Log.getStackTraceString(th2));
            c.netLog("CommonResponseListener --> 解析网络请求数据异常 --> parseResponse --> catch " + Log.getStackTraceString(th2));
            a(TaErrorCode.ERROR_RESPONSE_PARSING_FAILED);
        }
    }
}
