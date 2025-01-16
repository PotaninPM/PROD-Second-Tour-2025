package com.prod.core.api.data.json

/**
 * Провайдер JSON строк, имитирует ответы сервера
 */
interface JsonProvider {

    /*
    * JSON строка для баннера
     */
    val bannerInfoJson: String

    /*
    * JSON строка для всех товаров
     */
    val allGoodsJson: String

    /*
    * JSON строка для всех бонусов
     */
    val allBonusesJson: String

    /*
    * JSON строка для информации о пользователе
     */
    val userInfo: String
}
