package com.dao;

import com.bean.Product;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface ProductMapper {
    @Select({"call insert_product_log(#{pname,mode=IN,jdbcType=VARCHAR},"
            +"#{pclass,mode=IN,jdbcType=VARCHAR},"
		+ "#{price,mode=IN,jdbcType=DECIMAL},"
		+"#{operatorID,mode=IN,jdbcType=INTEGER})"
    })
    @Options(statementType=StatementType.CALLABLE)
    public void insert(Map<String, Object> params);
    
    @Select({"call update_product_log(#{pno,mode=IN,jdbcType=INTEGER},"
    		+"#{newpname,mode=IN,jdbcType=VARCHAR},"
            +"#{newpclass,mode=IN,jdbcType=VARCHAR},"
		+ "#{newprice,mode=IN,jdbcType=DECIMAL},"
		+"#{operatorID,mode=IN,jdbcType=INTEGER})"
    })
    @Options(statementType=StatementType.CALLABLE)
    public void update(Map<String, Object> params);
    
    @Select({"call delete_product_log(#{pno,mode=IN,jdbcType=INTEGER},"
    		+"#{operatorID,mode=IN,jdbcType=INTEGER})"
        })
   @Options(statementType=StatementType.CALLABLE)
        public void delete(Map<String, Object> params);
    
    
    @Select("select ProductNo from product where ProductName=#{productname}")
    Integer selectpno(String productname);
    
    @Select("${sql}")
    List<Product> selectSql(@Param("sql")String sql);
    
    @Select("${sql}")
    int selectCount(@Param("sql")String sql);
    
    
    
    
    
}