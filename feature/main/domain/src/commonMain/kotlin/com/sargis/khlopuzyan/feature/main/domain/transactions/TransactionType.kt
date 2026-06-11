package com.sargis.khlopuzyan.feature.main.domain.transactions

enum class Transfer {
    TRANSFER_TO_ACCOUNT,
    TRANSFER_TO_CARD,
    TRANSFER_VIA_CONTACT,
    TRANSFER_ARCA_PAY,
    TRANSFER_TO_BUDGET,
    INTERNATIONAL_TRANSFER,
    TRANSFER_IN_RUB,
    CURRENCY_EXCHANGE,
    DEPOSIT_REPLENISHMENT,
}

enum class Payments {
    UTILITY,
    INTERNET_AND_TV,
    CAR,
    PUBLIC_SERVICES,
    OTHER_SERVICES,
    LOAN_REPAYMENT,
    TUITION_FEE
    //    SERVICE_GROUP_PAYMENT,
    //    POLICE_ADMINISTRATION_FINE,
}

enum class MobileAndInternet {
    VivaMobileAndInternet,
    TeamMobileFixedAndInternet,
    UcomMobile,
    UcomFixedAndInternet,
}