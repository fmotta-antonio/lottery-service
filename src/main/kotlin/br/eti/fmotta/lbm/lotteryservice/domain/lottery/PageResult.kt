package br.eti.fmotta.lbm.lotteryservice.domain.lottery

data class PageResult<T>(
    val data: List<T>,
    val page: Int,
    val size: Int,
    val total: Int,
    val pages: Int,
)
