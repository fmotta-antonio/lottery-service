package br.eti.fmotta.lbm.lotteryservice.domain.lottery

interface LotteryRepository {
    fun getLotteries(
        page: Int,
        size: Int,
        lotteryFilter: LotteryFilter,
    ): PageResult<Lottery>
}
