package br.eti.fmotta.lbm.lotteryservice.application.usecase.dto

data class PageResponse<T>(
    val content: List<T>,
    val page: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int,
)
