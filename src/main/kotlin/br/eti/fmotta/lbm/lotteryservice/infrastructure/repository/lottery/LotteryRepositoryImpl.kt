package br.eti.fmotta.lbm.lotteryservice.infrastructure.repository.lottery

import br.eti.fmotta.lbm.lotteryservice.domain.lottery.Lottery
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryFilter
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryRepository
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.PageResult
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.lowerCase
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class LotteryRepositoryImpl : LotteryRepository {
    override fun getLotteries(
        page: Int,
        size: Int,
        lotteryFilter: LotteryFilter,
    ): PageResult<Lottery> =
        transaction {
            val query = LotteryTable.selectAll()

            applyFilter(query, lotteryFilter)
            applyOrder(query, lotteryFilter)

            val start = (page - 1) * size.toLong()
            val totalElements = query.count().toInt()
            val results = query.limit(size).offset(start).map { LotteryTable.toDomain(it) }
            val totalPages = if (size > 0) (totalElements + size - 1) / size else 0
            PageResult(results, page, size, totalElements, totalPages)
        }

    private fun applyFilter(
        query: Query,
        lotteryFilter: LotteryFilter,
    ) {
        lotteryFilter.name?.let { query.andWhere { LotteryTable.name.lowerCase() like "%${it.lowercase()}%" } }
        lotteryFilter.modality?.let { query.andWhere { LotteryTable.modality eq it } }
        lotteryFilter.modalitySpecial?.let { query.andWhere { LotteryTable.modalitySpecial eq it } }
        lotteryFilter.modalitySupported?.let { query.andWhere { LotteryTable.modalitySupported eq it } }
    }

    private fun applyOrder(
        query: Query,
        lotteryFilter: LotteryFilter,
    ) {
        val columnOrderBy =
            LotteryTable.columns.firstOrNull { it.name == lotteryFilter.sortBy }
                ?: LotteryTable.createdAt

        val columnSortOrder =
            lotteryFilter.sortOrder?.let {
                runCatching { SortOrder.valueOf(it) }.getOrNull()
            } ?: SortOrder.ASC

        query.orderBy(columnOrderBy to columnSortOrder)
    }
}
