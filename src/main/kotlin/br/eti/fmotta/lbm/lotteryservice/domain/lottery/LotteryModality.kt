package br.eti.fmotta.lbm.lotteryservice.domain.lottery

enum class LotteryModality {
    MEGA_SENA,
    LOTOFACIL,
    QUINA,
    LOTOMANIA,
    TIMEMANIA,
    DUPLA_SENA,
    LOTERIA_FEDERAL,
    LOTECA,
    DIA_DE_SORTE,
    SUPER_SETE,
    MAIS_MILIONARIA,
    ;

    companion object {
        fun fromString(value: String?): LotteryModality {
            return value?.let { valueOf(it.uppercase()) }
                ?: throw IllegalArgumentException("Invalid LotteryModality value: null")
        }
    }
}
