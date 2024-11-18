package br.eti.fmotta.lbm.lotteryservice.domain.lottery

data class LotteryFilter(
    val name: String? = null,
    val modality: LotteryModality? = null,
    val modalitySpecial: Boolean? = null,
    val modalitySupported: Boolean? = null,
    val sortBy: String? = null,
    val sortOrder: String? = null,
)
