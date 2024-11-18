package br.eti.fmotta.lbm.lotteryservice.infrastructure.controller

import br.eti.fmotta.lbm.lotteryservice.application.usecase.LotteryUseCase
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryFilter
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryModality
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/lotteries")
class LotteryController(
    private val lotteryUseCase: LotteryUseCase,
) {
    @GetMapping
    fun getLotteries(
        @RequestParam page: Int = 1,
        @RequestParam size: Int = 10,
        @RequestParam params: Map<String, String>,
    ): ResponseEntity<*> {
        val lotteryModalities = lotteryUseCase.getLotteryModalities(page, size, params.toFilter())
        return ResponseEntity.ok(lotteryModalities)
    }
}

fun Map<String, String>.toFilter(): LotteryFilter {
    return LotteryFilter(
        name = this["name"],
        modalitySupported = this["modalitySupported"]?.toBoolean(),
        modalitySpecial = this["modalitySpecial"]?.toBoolean(),
        modality = this["modality"]?.let { LotteryModality.fromString(it) },
        sortOrder = this["sortOrder"],
        sortBy = this["sortBy"],
    )
}
