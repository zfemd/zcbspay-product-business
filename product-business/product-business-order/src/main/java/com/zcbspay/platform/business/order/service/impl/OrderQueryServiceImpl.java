package com.zcbspay.platform.business.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.business.commons.utils.BeanCopyUtil;
import com.zcbspay.platform.business.exception.QueryOrderException;
import com.zcbspay.platform.business.order.bean.BatchResultBean;
import com.zcbspay.platform.business.order.bean.OrderResultBean;
import com.zcbspay.platform.business.order.bean.ResultBean;
import com.zcbspay.platform.business.order.service.OrderQueryService;

@Service("orderQueryService")
public class OrderQueryServiceImpl implements OrderQueryService {

	@Autowired
	private com.zcbspay.platform.support.order.query.query.service.QueryOrderService queryOrderService;

	@Override
	public ResultBean queryOrder(String merchNo, String orderId) throws QueryOrderException {
		OrderResultBean orderResultBean;
		try {
			orderResultBean = BeanCopyUtil.copyBean(OrderResultBean.class,
					queryOrderService.queryOrder(merchNo, orderId));
		} catch (com.zcbspay.platform.support.order.query.exception.QueryOrderException e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(orderResultBean);
	}

	@Override
	public ResultBean queryOrderByTN(String tn) throws QueryOrderException {
		OrderResultBean orderResultBean;
		
		try {
			orderResultBean = BeanCopyUtil.copyBean(OrderResultBean.class,
					queryOrderService.queryOrderByTN(tn));
		} catch (com.zcbspay.platform.support.order.query.exception.QueryOrderException e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(orderResultBean);
	}

	@Override
	public ResultBean queryInsteadPayOrder(String merchNo, String orderId) throws QueryOrderException {
		OrderResultBean orderResultBean;
		try {
			orderResultBean = BeanCopyUtil.copyBean(OrderResultBean.class,
					queryOrderService.queryInsteadPayOrder(merchNo, orderId));
		} catch (com.zcbspay.platform.support.order.query.exception.QueryOrderException e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(orderResultBean);
	}

	@Override
	public ResultBean queryConcentrateCollectionOrder(String tn) throws QueryOrderException {
		OrderResultBean orderResultBean;
		try {
			orderResultBean = BeanCopyUtil.copyBean(OrderResultBean.class,
					queryOrderService.queryConcentrateCollectionOrder(tn));
		} catch (com.zcbspay.platform.support.order.query.exception.QueryOrderException e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(orderResultBean);
	}

	@Override
	public ResultBean queryConcentratePaymentOrder(String tn) throws QueryOrderException {
		OrderResultBean orderResultBean;
		try {
			orderResultBean = BeanCopyUtil.copyBean(OrderResultBean.class,
					queryOrderService.queryConcentratePaymentOrder(tn));
		} catch (com.zcbspay.platform.support.order.query.exception.QueryOrderException e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(orderResultBean);
	}

	@Override
	public ResultBean queryConcentrateCollectionBatch(String merchNo, String batchNo, String txnDate) {
		BatchResultBean batchResultBean;
		try {
			batchResultBean = BeanCopyUtil.copyBean(BatchResultBean.class,
					queryOrderService.queryConcentrateCollectionBatch(merchNo, batchNo, txnDate));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(batchResultBean);
	}

	@Override
	public ResultBean queryConcentratePaymentBatch(String merchNo, String batchNo, String txnDate) {
		BatchResultBean batchResultBean;
		try {
			batchResultBean = BeanCopyUtil.copyBean(BatchResultBean.class,
					queryOrderService.queryConcentratePaymentBatch(merchNo, batchNo, txnDate));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultBean("BO00012", e.getMessage());
		}
		return new ResultBean(batchResultBean);
	}

}