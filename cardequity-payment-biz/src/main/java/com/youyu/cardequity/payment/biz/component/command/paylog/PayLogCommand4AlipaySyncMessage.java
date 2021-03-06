package com.youyu.cardequity.payment.biz.component.command.paylog;

import com.youyu.cardequity.common.base.annotation.StatusAndStrategyNum;
import com.youyu.cardequity.payment.biz.component.properties.AlipayProperties;
import com.youyu.cardequity.payment.biz.dal.dao.PayLogMapper;
import com.youyu.cardequity.payment.biz.dal.entity.PayLog;
import com.youyu.cardequity.payment.biz.dal.entity.PayLog4Alipay;
import com.youyu.cardequity.payment.dto.alipay.AlipaySyncMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月6日 下午10:00:00
 * @work Alipay Pay同步支付命令
 */
@StatusAndStrategyNum(superClass = PayLogCommand.class, number = "1", describe = "支付宝同步接收参数")
@Component
public class PayLogCommand4AlipaySyncMessage extends PayLogCommand {

    @Autowired
    private AlipayProperties alipayProperties;

    @Autowired
    private PayLogMapper payLogMapper;

    /**
     * @param payLog
     * @param t      支付宝同步参数:AlipaySyncMessageDto
     * @param <T>
     * @return
     */
    @Override
    public <T> void executeCmd(PayLog payLog, T t) {
        AlipaySyncMessageDto alipaySyncMessageDto = (AlipaySyncMessageDto) t;
        verifySignatur(alipaySyncMessageDto);
        PayLog4Alipay payLog4Alipay = (PayLog4Alipay) payLog;
        payLog4Alipay.analysisAlipaySycnMessage(alipaySyncMessageDto, alipayProperties.getSellerId(), alipayProperties.getAppId());
        payLogMapper.updateAlipaySyncMessage(payLog4Alipay);
    }

    /**
     * 验证签名,暂时不验证(支付宝提示忽略)
     *
     * @param alipaySyncMessageDto
     */
    private void verifySignatur(AlipaySyncMessageDto alipaySyncMessageDto) {
    }
}
