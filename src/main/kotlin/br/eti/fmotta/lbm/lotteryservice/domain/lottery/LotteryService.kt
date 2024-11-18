package br.eti.fmotta.lbm.lotteryservice.domain.lottery

class LotteryService(
    private val lotteryRepository: LotteryRepository,
) {
    fun getLotteryModalities(
        page: Int,
        size: Int,
        lotteryFilter: LotteryFilter,
    ): PageResult<Lottery> {
        return lotteryRepository.getLotteries(page, size, lotteryFilter)
    }
}
