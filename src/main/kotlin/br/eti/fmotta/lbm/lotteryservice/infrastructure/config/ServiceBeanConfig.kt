package br.eti.fmotta.lbm.lotteryservice.infrastructure.config

import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryRepository
import br.eti.fmotta.lbm.lotteryservice.domain.lottery.LotteryService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceBeanConfig {
    @Bean
    fun lotteryService(lotteryRepository: LotteryRepository) = LotteryService(lotteryRepository)
}
