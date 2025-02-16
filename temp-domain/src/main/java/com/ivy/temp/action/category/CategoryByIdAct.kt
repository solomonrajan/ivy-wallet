package com.ivy.wallet.domain.action.category

import com.ivy.data.CategoryOld
import com.ivy.frp.action.FPAction
import com.ivy.wallet.io.persistence.dao.CategoryDao
import java.util.*
import javax.inject.Inject

class CategoryByIdAct @Inject constructor(
    private val categoryDao: CategoryDao
) : FPAction<UUID, CategoryOld?>() {
    override suspend fun UUID.compose(): suspend () -> CategoryOld? = suspend {
        categoryDao.findById(this)?.toDomain()
    }
}