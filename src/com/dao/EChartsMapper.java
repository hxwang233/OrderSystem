package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.utils.EChartsData;

public interface EChartsMapper {
	@Select("select address as name,count(*) as value from customer group by address")
	List<EChartsData> selectAddress();
	
	@Select("select  DATE_FORMAT(orderdate,'%W (%c-%d)') as name,count(*) as value  from ordermaster  where (orderdate<now() and orderdate>DATE_ADD(orderdate,INTERVAL '-7' DAY ) ) group by DATE_FORMAT(orderdate,'%W') order by Orderdate")
	List<EChartsData> selectWeekOrder();
	
	@Select("select DATE_FORMAT(orderdate,'%W (%c-%d)') as name,sum(Ordersum) as value from ordermaster where (orderdate<now() and orderdate>DATE_ADD(orderdate,INTERVAL '-7' DAY ) ) group by DATE_FORMAT(orderdate,'%W') order by Orderdate")
	List<EChartsData> selectWeekSum();
}
