package br.eti.fmotta.lbm.lotteryservice.domain.lottery

import java.time.LocalDateTime
import java.util.UUID

data class Lottery(
    val id: UUID,
    val name: String,
    val description: String,
    val modality: LotteryModality,
    val special: Boolean = false,
    val supported: Boolean = false,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
