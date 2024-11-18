package br.eti.fmotta.lbm.lotteryservice.application.usecase.dto

import br.eti.fmotta.lbm.lotteryservice.domain.lottery.Lottery
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryModality
import java.util.UUID

data class LotteryResponse(
    val id: UUID,
    val name: String,
    val description: String,
    val modality: LotteryModality,
    val modalitySpecial: Boolean = false,
    val modalitySupported: Boolean = false,
)

fun Lottery.toLotteryResponse() =
    LotteryResponse(
        id = this.id,
        name = this.name,
        description = this.description,
        modality = this.modality,
        modalitySpecial = this.special,
        modalitySupported = this.supported,
    )
