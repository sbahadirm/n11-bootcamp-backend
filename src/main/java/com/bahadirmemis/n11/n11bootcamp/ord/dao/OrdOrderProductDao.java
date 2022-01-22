package com.bahadirmemis.n11.n11bootcamp.ord.dao;

import com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderProductDetailDto;
import com.bahadirmemis.n11.n11bootcamp.ord.entity.OrdOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdOrderProductDao extends JpaRepository<OrdOrderProduct, Long> {


    @Query(
            "select  " +
                    "  new com.bahadirmemis.n11.n11bootcamp.ord.dto.OrdOrderProductDetailDto(" +
                    " ordOrderProduct.id, " +
                    " ordOrderProduct.ordOrderId, " +
                    " ordOrderProduct.basBasketProductId, " +
                    " ordOrder.orderDate, " +
                    " ordOrder.paidAmount, " +
                    " ordOrder.deliveryCompany, " +
                    " ordOrder.parcelTrackingCode, " +
                    " ordOrder.addressId, " +
                    " ordOrder.deliveryStatus ," +
                    " ordOrder.deliveryDate, " +
                    " ordOrder.orderNo, " +
                    " prdProduct.name, " +
                    " prdProduct.shortName, " +
                    " prdProduct.categoryId, " +
                    " prdProduct.vendorUserId, " +
                    " prdProduct.imageUrl, " +
                    " prdProduct.price, " +
                    " prdProduct.additionalDiscount" +
                    " )" +
                    "from " +
                    " OrdOrderProduct ordOrderProduct " +
                    " left join OrdOrder ordOrder on ordOrderProduct.ordOrderId = ordOrder.id " +
                    " left join BasBasketProduct basBasketProduct on ordOrderProduct.basBasketProductId = basBasketProduct.id " +
                    " left join PrdProduct prdProduct on basBasketProduct.prdProductId = prdProduct.id " +
                    " left join BasBasket basBasket on basBasketProduct.basBasketId = basBasket.id " +
                    " left join UsrUser usrUser on basBasket.usrUserId = usrUser.id " +
                    " where usrUser.username = :username " +
                    " order by ordOrder.id, ordOrderProduct.id"
    )
    List<OrdOrderProductDetailDto> findAllOrdOrderProductDetailDtoListByUsername(@Param("username") String username);
}
