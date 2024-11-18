package br.eti.fmotta.lbm.lotteryservice.infrastructure.config

import br.eti.fmotta.lbm.lotteryservice.application.usecase.LotteryUseCase
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseBeanConfig {
    @Bean
    fun lotteryUseCase(lotteryService: LotteryService) = LotteryUseCase(lotteryService)
}
