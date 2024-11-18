package br.eti.fmotta.lbm.lotteryservice.application.usecase

import br.eti.fmotta.lbm.lotteryservice.application.usecase.dto.LotteryResponse
import br.eti.fmotta.lbm.lotteryservice.application.usecase.dto.PageResponse
import br.eti.fmotta.lbm.lotteryservice.application.usecase.dto.toLotteryResponse
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.Lottery
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryFilter
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryService
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.PageResult

class LotteryUseCase(
    private val lotteryService: LotteryService,
) {
    fun getLotteryModalities(
        page: Int,
        size: Int,
        lotteryFilter: LotteryFilter,
    ): PageResponse<LotteryResponse> {
        val lotteryModalities = lotteryService.getLotteryModalities(page, size, lotteryFilter)
        val pageResponse = pageResponse(lotteryModalities)
        return pageResponse
    }

    private fun pageResponse(lotteryModalities: PageResult<Lottery>) =
        PageResponse(
            content = lotteryModalities.data.map { it.toLotteryResponse() },
            page = lotteryModalities.page,
            size = lotteryModalities.size,
            totalElements = lotteryModalities.total,
            totalPages = lotteryModalities.pages,
        )
}
