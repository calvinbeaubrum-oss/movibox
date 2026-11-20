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
public interface IShortTvFavoriteStateDao {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static Object a(IShortTvFavoriteStateDao iShortTvFavoriteStateDao, ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation) throws Throwable {
            IShortTvFavoriteStateDao$insertOrUpdate$1 iShortTvFavoriteStateDao$insertOrUpdate$1;
            if (continuation instanceof IShortTvFavoriteStateDao$insertOrUpdate$1) {
                iShortTvFavoriteStateDao$insertOrUpdate$1 = (IShortTvFavoriteStateDao$insertOrUpdate$1) continuation;
                int i11 = iShortTvFavoriteStateDao$insertOrUpdate$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    iShortTvFavoriteStateDao$insertOrUpdate$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    iShortTvFavoriteStateDao$insertOrUpdate$1 = new IShortTvFavoriteStateDao$insertOrUpdate$1(continuation);
                }
            } else {
                iShortTvFavoriteStateDao$insertOrUpdate$1 = new IShortTvFavoriteStateDao$insertOrUpdate$1(continuation);
            }
            Object objB = iShortTvFavoriteStateDao$insertOrUpdate$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = iShortTvFavoriteStateDao$insertOrUpdate$1.label;
            if (i12 == 0) {
                ResultKt.b(objB);
                String subjectId = shortTvFavoriteState.getSubjectId();
                iShortTvFavoriteStateDao$insertOrUpdate$1.L$0 = iShortTvFavoriteStateDao;
                iShortTvFavoriteStateDao$insertOrUpdate$1.L$1 = shortTvFavoriteState;
                iShortTvFavoriteStateDao$insertOrUpdate$1.label = 1;
                objB = iShortTvFavoriteStateDao.b(subjectId, iShortTvFavoriteStateDao$insertOrUpdate$1);
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
                shortTvFavoriteState = (ShortTvFavoriteState) iShortTvFavoriteStateDao$insertOrUpdate$1.L$1;
                iShortTvFavoriteStateDao = (IShortTvFavoriteStateDao) iShortTvFavoriteStateDao$insertOrUpdate$1.L$0;
                ResultKt.b(objB);
            }
            if (objB == null) {
                iShortTvFavoriteStateDao$insertOrUpdate$1.L$0 = null;
                iShortTvFavoriteStateDao$insertOrUpdate$1.L$1 = null;
                iShortTvFavoriteStateDao$insertOrUpdate$1.label = 2;
                if (iShortTvFavoriteStateDao.c(shortTvFavoriteState, iShortTvFavoriteStateDao$insertOrUpdate$1) == objE) {
                    return objE;
                }
                return Unit.f68710a;
            }
            iShortTvFavoriteStateDao$insertOrUpdate$1.L$0 = null;
            iShortTvFavoriteStateDao$insertOrUpdate$1.L$1 = null;
            iShortTvFavoriteStateDao$insertOrUpdate$1.label = 3;
            if (iShortTvFavoriteStateDao.a(shortTvFavoriteState, iShortTvFavoriteStateDao$insertOrUpdate$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    Object a(ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation);

    Object b(String str, Continuation<? super ShortTvFavoriteState> continuation);

    Object c(ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation);

    Object d(ShortTvFavoriteState shortTvFavoriteState, Continuation<? super Unit> continuation);
}
