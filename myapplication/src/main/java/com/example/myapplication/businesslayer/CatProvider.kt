package com.example.myapplication.businesslayer

import com.example.myapplication.datalayer.IAccessor
import com.example.myapplication.objects.Cat
import java.time.ZoneOffset

class CatProvider (val accessor: IAccessor) {
    suspend fun getCats(offset: Int, limit: Int): List<Cat>{
        return accessor.getCats(offset, limit)
    }
}