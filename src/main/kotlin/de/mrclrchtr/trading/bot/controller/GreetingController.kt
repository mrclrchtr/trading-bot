package de.mrclrchtr.trading.bot.controller

import de.mrclrchtr.trading.bot.generated.swagger.client.api.TradeApi
import de.mrclrchtr.trading.bot.generated.swagger.client.model.TradeBin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class GreetingController(
        private val tradeApi: TradeApi
) {

    @GetMapping("/greeting")
    fun greeting(): List<TradeBin> {
        return tradeApi.tradeGetBucketed("1m", false, "XBTUSD", null, null, BigDecimal.valueOf(250), null, true, null, null)
    }

}