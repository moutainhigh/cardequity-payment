package com.youyu.cardequity.payment.biz.dal.dao;

import com.youyu.cardequity.payment.biz.dal.entity.PayLog;
import com.youyu.common.mapper.YyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月10日 下午10:00:00
 * @work 支付日志Mapper
 */
public interface PayLogMapper extends YyMapper<PayLog> {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    PayLog getById(String id);

    /**
     * 更新支付宝预支付信息:主要更新状态和返回信息
     *
     * @param payLog
     */
    void updateAlipayPrepayment(PayLog payLog);

    /**
     * 更新支付宝同步通知信息:主要更新状态和同步消息
     *
     * @param payLog
     */
    void updateAlipaySyncMessage(PayLog payLog);

    /**
     * 更新支付宝异步通知信息:主要更新状态和同步消息
     *
     * @param payLog
     */
    void updateAlipayAsyncMessage(PayLog payLog);

    /**
     * 支付宝交易关闭相关信息:主要更新交易关闭消息
     *
     * @param payLog
     */
    void updateAlipayTradeClose(PayLog payLog);

    /**
     * 支付宝查询交易更新相关信息:主要更新交易查询消息
     *
     * @param payLog
     */
    void updateAlipayTradeQuery(PayLog payLog);

    /**
     * 插入
     *
     * @param payLog
     * @return
     */
    @Override
    int insertSelective(PayLog payLog);

    /**
     * 根据订单单号查询
     *
     * @param appSheetSerialNo
     * @return
     */
    PayLog getByAppSheetSerialNo(@Param("appSheetSerialNo") String appSheetSerialNo);

    /**
     * 在阈值范围内还未收到支付宝异步回调通知时,主动查询未通知的订单进行主动查询
     *
     * @param alipayAsyncNotifyThresholdStart 时间阈值开始:[当前时间-alipayAsyncNotifyThresholdStart分钟]
     * @param alipayAsyncNotifyThresholdEnd   时间阈值结束:[当前时间-alipayAsyncNotifyThresholdEnd分钟]
     * @param alipayPayType                   支付类型
     * @param alipayAsyncResponseSucc         异步通知响应不等于:!=success
     * @return
     */
    List<PayLog> getByTimeAlipayTradeQuery(@Param("alipayAsyncNotifyThresholdStart") Integer alipayAsyncNotifyThresholdStart, @Param("alipayAsyncNotifyThresholdEnd") Integer alipayAsyncNotifyThresholdEnd, @Param("alipayPayType") String alipayPayType, @Param("alipayAsyncResponseSucc") String alipayAsyncResponseSucc);
}