package com.youyu.cardequity.payment.biz.component.strategy.paycheckfiledeatail;

import com.youyu.cardequity.payment.biz.dal.entity.PayCheckFileDeatail;
import com.youyu.cardequity.payment.biz.dal.entity.TradeOrder;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月6日 下午10:00:00
 * @work 对账策略
 */
public abstract class PayCheckFileDeatailStrategy {

    /**
     * 对账单对交易
     *
     * @param payCheckFileDeatail
     * @param tradeOrder
     */
    public abstract void doBill2Trade(PayCheckFileDeatail payCheckFileDeatail, TradeOrder tradeOrder);

    /**
     * 对账单对交易退款
     *
     * @param payCheckFileDeatail
     * @param tradeOrder
     */
    public abstract void doBill2TradeRefund(PayCheckFileDeatail payCheckFileDeatail, TradeOrder tradeOrder);

    /**
     * 交易去对对账单,此时没有对账文件
     *
     * @param tradeOrder
     */
    public abstract void doTrade2BillNotFile(TradeOrder tradeOrder);

    /**
     * 交易退款去对对账单,此时没有对账文件
     *
     * @param tradeOrder
     */
    public abstract void doTrade2BillRefundNotFile(TradeOrder tradeOrder);
}
