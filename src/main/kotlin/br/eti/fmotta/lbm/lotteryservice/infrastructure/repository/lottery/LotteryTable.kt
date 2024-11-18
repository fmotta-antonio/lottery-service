package br.eti.fmotta.lbm.lotteryservice.infrastructure.repository.lottery

import br.eti.fmotta.lbm.lotteryservice.domain.lottery.Lottery
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryModality
import br.eti.fmotta.lbm.lotteryservice.infrastructure.config.database.PGEnum
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime

object LotteryTable : UUIDTable("Lottery") {
    val name = varchar("name", 60)
    val description = varchar("description", 255)
    val modality =
        customEnumeration(
            "modality",
            "modality_lottery_type",
            { value -> LotteryModality.fromString(value as String) },
            { PGEnum("modality_lottery_type", it) },
        )
    val modalitySpecial = bool("modality_special").default(false)
    val modalitySupported = bool("modality_supported").default(false)
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
    val updatedAt = datetime("updated_at").defaultExpression(CurrentDateTime)

    fun toDomain(row: ResultRow) =
        Lottery(
            id = row[LotteryTable.id].value,
            name = row[name],
            description = row[description],
            modality = row[modality],
            supported = row[modalitySupported],
            special = row[modalitySpecial],
            createdAt = row[createdAt],
            updatedAt = row[updatedAt],
        )
}
