package com.transsion.baselib.db.place;

import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface PlaceDao {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static Object a(PlaceDao placeDao, List<PlaceDBBean> list, Continuation<? super Unit> continuation) throws Throwable {
            PlaceDao$insertList$1 placeDao$insertList$1;
            if (continuation instanceof PlaceDao$insertList$1) {
                placeDao$insertList$1 = (PlaceDao$insertList$1) continuation;
                int i11 = placeDao$insertList$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    placeDao$insertList$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    placeDao$insertList$1 = new PlaceDao$insertList$1(continuation);
                }
            } else {
                placeDao$insertList$1 = new PlaceDao$insertList$1(continuation);
            }
            Object obj = placeDao$insertList$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = placeDao$insertList$1.label;
            if (i12 != 0) {
                if (i12 == 1) {
                    list = (List) placeDao$insertList$1.L$1;
                    placeDao = (PlaceDao) placeDao$insertList$1.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            placeDao$insertList$1.L$0 = placeDao;
            placeDao$insertList$1.L$1 = list;
            placeDao$insertList$1.label = 1;
            if (placeDao.a(placeDao$insertList$1) == objE) {
                return objE;
            }
            placeDao$insertList$1.L$0 = null;
            placeDao$insertList$1.L$1 = null;
            placeDao$insertList$1.label = 2;
            if (placeDao.b(list, placeDao$insertList$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    Object a(Continuation<? super Unit> continuation);

    Object b(List<PlaceDBBean> list, Continuation<? super Unit> continuation);

    Object c(List<PlaceDBBean> list, Continuation<? super Unit> continuation);

    Object d(Continuation<? super List<PlaceDBBean>> continuation);
}
