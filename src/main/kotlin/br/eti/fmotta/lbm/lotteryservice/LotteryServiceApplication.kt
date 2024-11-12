package br.eti.fmotta.lbm.lotteryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LotteryServiceApplication

fun main(args: Array<String>) {
    runApplication<LotteryServiceApplication>(*args)
}
