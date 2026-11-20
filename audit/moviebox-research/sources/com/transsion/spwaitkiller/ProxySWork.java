package com.transsion.spwaitkiller;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ProxySWork<T> extends LinkedList<T> {
    private final AboveAndroid12Processor aboveAndroid12Processor;
    private final LinkedList<T> proxy;
    private Handler sHandler;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface AboveAndroid12Processor {
        void reProxySWork();
    }

    public ProxySWork(LinkedList<T> proxy, Looper looper, AboveAndroid12Processor aboveAndroid12Processor) {
        Intrinsics.g(proxy, "proxy");
        Intrinsics.g(looper, "looper");
        this.proxy = proxy;
        this.aboveAndroid12Processor = aboveAndroid12Processor;
        this.sHandler = new Handler(looper);
    }

    private final void delegateWork() {
        if (this.proxy.size() == 0) {
            return;
        }
        Object objClone = this.proxy.clone();
        Intrinsics.e(objClone, "null cannot be cast to non-null type java.util.LinkedList<java.lang.Runnable>");
        final LinkedList linkedList = (LinkedList) objClone;
        this.proxy.clear();
        Handler handler = this.sHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.transsion.spwaitkiller.a
                @Override // java.lang.Runnable
                public final void run() {
                    ProxySWork.delegateWork$lambda$0(linkedList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delegateWork$lambda$0(LinkedList works) {
        Intrinsics.g(works, "$works");
        Iterator it = works.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T t11) {
        return this.proxy.add(t11);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.proxy.clear();
    }

    @Override // java.util.LinkedList
    public Object clone() {
        if (Build.VERSION.SDK_INT < 31) {
            delegateWork();
            return new LinkedList();
        }
        Object objClone = this.proxy.clone();
        Intrinsics.f(objClone, "{\n            proxy.clone()\n        }");
        return objClone;
    }

    public int getSize() {
        if (Build.VERSION.SDK_INT < 31) {
            return this.proxy.size();
        }
        delegateWork();
        AboveAndroid12Processor aboveAndroid12Processor = this.aboveAndroid12Processor;
        if (aboveAndroid12Processor != null) {
            aboveAndroid12Processor.reProxySWork();
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i11) {
        return (T) removeAt(i11);
    }

    public /* bridge */ Object removeAt(int i11) {
        return super.remove(i11);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }
}
