package com.transsion.baselib.db.video;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

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
public interface ShortTVPlayDao {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static Object a(ShortTVPlayDao shortTVPlayDao, ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation) throws Throwable {
            ShortTVPlayDao$insertOrUpdate$1 shortTVPlayDao$insertOrUpdate$1;
            if (continuation instanceof ShortTVPlayDao$insertOrUpdate$1) {
                shortTVPlayDao$insertOrUpdate$1 = (ShortTVPlayDao$insertOrUpdate$1) continuation;
                int i11 = shortTVPlayDao$insertOrUpdate$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    shortTVPlayDao$insertOrUpdate$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    shortTVPlayDao$insertOrUpdate$1 = new ShortTVPlayDao$insertOrUpdate$1(continuation);
                }
            } else {
                shortTVPlayDao$insertOrUpdate$1 = new ShortTVPlayDao$insertOrUpdate$1(continuation);
            }
            Object objB = shortTVPlayDao$insertOrUpdate$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = shortTVPlayDao$insertOrUpdate$1.label;
            if (i12 == 0) {
                ResultKt.b(objB);
                String subjectId = shortTVPlayBean.getSubjectId();
                shortTVPlayDao$insertOrUpdate$1.L$0 = shortTVPlayDao;
                shortTVPlayDao$insertOrUpdate$1.L$1 = shortTVPlayBean;
                shortTVPlayDao$insertOrUpdate$1.label = 1;
                objB = shortTVPlayDao.b(subjectId, shortTVPlayDao$insertOrUpdate$1);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    if (i12 == 2) {
                        ResultKt.b(objB);
                        return Unit.f68710a;
                    }
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objB);
                    return Unit.f68710a;
                }
                shortTVPlayBean = (ShortTVPlayBean) shortTVPlayDao$insertOrUpdate$1.L$1;
                shortTVPlayDao = (ShortTVPlayDao) shortTVPlayDao$insertOrUpdate$1.L$0;
                ResultKt.b(objB);
            }
            if (objB == null) {
                shortTVPlayDao$insertOrUpdate$1.L$0 = null;
                shortTVPlayDao$insertOrUpdate$1.L$1 = null;
                shortTVPlayDao$insertOrUpdate$1.label = 2;
                if (shortTVPlayDao.c(shortTVPlayBean, shortTVPlayDao$insertOrUpdate$1) == objE) {
                    return objE;
                }
                return Unit.f68710a;
            }
            shortTVPlayDao$insertOrUpdate$1.L$0 = null;
            shortTVPlayDao$insertOrUpdate$1.L$1 = null;
            shortTVPlayDao$insertOrUpdate$1.label = 3;
            if (shortTVPlayDao.f(shortTVPlayBean, shortTVPlayDao$insertOrUpdate$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    Object b(String str, Continuation<? super ShortTVPlayBean> continuation);

    Object c(ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation);

    Object d(ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation);

    Object e(String str, int i11, long j11, Continuation<? super Unit> continuation);

    Object f(ShortTVPlayBean shortTVPlayBean, Continuation<? super Unit> continuation);
}
