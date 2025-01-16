package com.prod.core.impl.data.json

import com.prod.core.api.data.json.JsonProvider

internal class DefaultJsonProvider : JsonProvider {

    override val bannerInfoJson: String = """
        {
            "large": {
                "priority": 0,
                "image_id": "banner-1-img",
                "title": "Кэшбэк на манго",
                "description": "Купите до 2 кг Манго и получите %s",
                "bonus": {
                    "value": 123,
                    "postfix": " баллов"
                }
            },
            "small": {
                "priority": 1,
                "right_label": "Акции",
                "left_label": "2 в 1",
                "image_id": "bonus-badge"
            }
        }
    """.trimIndent()

    override val allGoodsJson: String = """
        {
            "goods": [
                {
                    "id": "good_13647283-dao",
                    "image_id": "goods-1-img",
                    "name": "Хлеб с отрубями Хрустяшка",
                    "producer": {
                        "id": "prodai-31323",
                        "name": "АО Московский хрящекомбинат"
                    },
                    "is_new": false,
                    "item_countity": {
                        "type": "gramm",
                        "value": 200
                    },
                    "cost": 130,
                    "popularity": 100,
                    "bonus_ids": ["bonus_3233"],
                    "category": "HLEB"
                },
                {
                    "id": "good_13643463-hae",
                    "image_id": "goods-2-img",
                    "name": "Ты мягкий пирожочек",
                    "producer": {
                        "id": "prodai-31323",
                        "name": "Участник PROD'а"
                    },
                    "is_new": true,
                    "item_countity": {
                        "type": "kilo",
                        "value": 2
                    },
                    "cost": 2000,
                    "popularity": 100,
                    "rating": 4.9,
                    "category": "HLEB"
                },
                {
                    "id": "good_87647283-dop",
                    "image_id": "goods-3-img",
                    "name": "Молоко Молочное",
                    "producer": {
                        "id": "prodai-31323",
                        "name": "ООО Милые Коровки"
                    },
                    "is_new": true,
                    "item_countity": {
                        "type": "kilo",
                        "value": 1
                    },
                    "cost": 244,
                    "popularity": 25,
                    "rating": 3.5,
                    "bonus_ids": ["bonus_4243", "bonus_3233", "bonus_323"],
                    "category": "MILK"
                },
                {
                    "id": "good_13649783-wpo",
                    "image_id": "goods-4-img",
                    "name": "Манго сочное. Египет",
                    "producer": {
                        "id": "prodai-31323",
                        "name": "Египетские сельхоз проля Дары Клеопатры"
                    },
                    "item_countity": {
                        "type": "gramm",
                        "value": 200
                    },
                    "cost": 230.2506,
                    "popularity": 35,
                    "rating": 4.5,
                    "bonus_ids": ["bonus_13132", "bonus_4243"],
                    "category": "FRUITS"
                }
            ]
        }
    """.trimIndent()

    override val allBonusesJson: String = """
        [
            {
                "id": "bonus_323",
                "type": "cashback",
                "value": 0.05
            },
            {
                "id": "bonus_3233",
                "type": "points",
                "value": 1000
            },
            {
                "id": "bonus_13132",
                "type": "cashback",
                "value": 0.1,
                "available_due_to": "2025-04-23T18:25:43.511Z"
            },
            {
                "id": "bonus_4243",
                "type": "points",
                "value": 200,
                "available_due_to": "2025-04-23T18:25:43.511Z",
                "promotion_extra": {
                    "base_color": "5222FF",
                    "tint_color": "FFFFFF",
                    "label": "PREMIUM"
                }
            }
        ]
    """.trimIndent()

    override val userInfo: String = """
        {
            "last_goods_cat": ["FRUITS", "MILK"],
            "available_bonuses": ["bonus_323", "bonus_4243", "bonus_13132"],
            "favourites": ["good_13643463-hae"],
            "activity_level": 50
        }
    """.trimIndent()
}
